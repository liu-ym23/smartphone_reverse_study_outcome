package org.apache.commons.math.linear;

import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public interface FieldLUDecomposition<T extends FieldElement<T>> {
    T getDeterminant();

    FieldMatrix<T> getL();

    FieldMatrix<T> getP();

    int[] getPivot();

    FieldDecompositionSolver<T> getSolver();

    FieldMatrix<T> getU();
}
