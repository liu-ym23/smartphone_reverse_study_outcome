package org.apache.commons.math.linear;

import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public interface FieldVector<T extends FieldElement<T>> {
    FieldVector<T> add(FieldVector<T> r1) throws IllegalArgumentException;

    FieldVector<T> add(T[] r1) throws IllegalArgumentException;

    FieldVector<T> append(T r1);

    FieldVector<T> append(FieldVector<T> r1);

    FieldVector<T> append(T[] r1);

    FieldVector<T> copy();

    T dotProduct(FieldVector<T> r1) throws IllegalArgumentException;

    T dotProduct(T[] r1) throws IllegalArgumentException;

    FieldVector<T> ebeDivide(FieldVector<T> r1) throws IllegalArgumentException;

    FieldVector<T> ebeDivide(T[] r1) throws IllegalArgumentException;

    FieldVector<T> ebeMultiply(FieldVector<T> r1) throws IllegalArgumentException;

    FieldVector<T> ebeMultiply(T[] r1) throws IllegalArgumentException;

    T[] getData();

    int getDimension();

    T getEntry(int r1) throws MatrixIndexException;

    Field<T> getField();

    FieldVector<T> getSubVector(int r1, int r2) throws MatrixIndexException;

    FieldVector<T> mapAdd(T r1);

    FieldVector<T> mapAddToSelf(T r1);

    FieldVector<T> mapDivide(T r1);

    FieldVector<T> mapDivideToSelf(T r1);

    FieldVector<T> mapInv();

    FieldVector<T> mapInvToSelf();

    FieldVector<T> mapMultiply(T r1);

    FieldVector<T> mapMultiplyToSelf(T r1);

    FieldVector<T> mapSubtract(T r1);

    FieldVector<T> mapSubtractToSelf(T r1);

    FieldMatrix<T> outerProduct(FieldVector<T> r1) throws IllegalArgumentException;

    FieldMatrix<T> outerProduct(T[] r1) throws IllegalArgumentException;

    FieldVector<T> projection(FieldVector<T> r1) throws IllegalArgumentException;

    FieldVector<T> projection(T[] r1) throws IllegalArgumentException;

    void set(T r1);

    void setEntry(int r1, T r2) throws MatrixIndexException;

    void setSubVector(int r1, FieldVector<T> r2) throws MatrixIndexException;

    void setSubVector(int r1, T[] r2) throws MatrixIndexException;

    FieldVector<T> subtract(FieldVector<T> r1) throws IllegalArgumentException;

    FieldVector<T> subtract(T[] r1) throws IllegalArgumentException;

    T[] toArray();
}
