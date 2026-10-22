package org.apache.commons.math;

/* JADX INFO: loaded from: classes3.dex */
public interface FieldElement<T> {
    T add(T r1);

    T divide(T r1) throws ArithmeticException;

    Field<T> getField();

    T multiply(T r1);

    T subtract(T r1);
}
