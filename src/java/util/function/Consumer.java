/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package java.util.function;

import java.util.Objects;

/**
 * Represents an operation that accepts a single input argument and returns no
 * result. Unlike most other functional interfaces, {@code Consumer} is expected
 * to operate via side-effects.
 *
 * <p>
 * This is a <a href="package-summary.html">functional interface</a> whose
 * functional method is {@link #accept(Object)}.
 *
 * @param <T>
 *            the type of the input to the operation
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Consumer<T> {

	/**
	 * Performs this operation on the given argument.
	 *
	 * @param t
	 *            the input argument
	 */
	void accept(T t);

	/**
	 * Returns a composed {@code Consumer} that performs, in sequence, this
	 * operation followed by the {@code after} operation. If performing either
	 * operation throws an exception, it is relayed to the caller of the
	 * composed operation. If performing this operation throws an exception, the
	 * {@code after} operation will not be performed.
	 *
	 * @param after
	 *            the operation to perform after this operation
	 * @return a composed {@code Consumer} that performs in sequence this
	 *         operation followed by the {@code after} operation
	 * @throws NullPointerException
	 *             if {@code after} is null
	 */
	// 缺省方法是在接口中定义方法实现的一种方式，并且保证所有已经存在的子类的兼容性，所以实现了接口的类默认都拥有在接口中定义的缺省方法，这有点像一个抽象类。
	// 当一个子类中没有覆盖缺省方法时，则对子类的该方法的调用将调用接口中的实现。
	default Consumer<T> andThen(Consumer<? super T> after) {
		Objects.requireNonNull(after);
		// 这个地方是 lambda 表达式
		return (T t) -> {
			accept(t);
			after.accept(t);
		};
	}
}
