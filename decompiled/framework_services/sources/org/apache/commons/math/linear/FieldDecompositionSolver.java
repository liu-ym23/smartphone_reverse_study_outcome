package org.apache.commons.math.linear;

import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public interface FieldDecompositionSolver<T extends FieldElement<T>> {
    FieldMatrix<T> getInverse() throws InvalidMatrixException;

    boolean isNonSingular();

    FieldMatrix<T> solve(FieldMatrix<T> r1) throws IllegalArgumentException, InvalidMatrixException;

    FieldVector<T> solve(FieldVector<T> r1) throws IllegalArgumentException, InvalidMatrixException;

    T[] solve(T[] r1) throws IllegalArgumentException, InvalidMatrixException;
}
