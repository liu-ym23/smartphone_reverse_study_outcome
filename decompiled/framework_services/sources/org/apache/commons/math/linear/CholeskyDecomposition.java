package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public interface CholeskyDecomposition {
    double getDeterminant();

    RealMatrix getL();

    RealMatrix getLT();

    DecompositionSolver getSolver();
}
