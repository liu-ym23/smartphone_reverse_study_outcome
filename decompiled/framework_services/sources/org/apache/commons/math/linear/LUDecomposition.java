package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public interface LUDecomposition {
    double getDeterminant();

    RealMatrix getL();

    RealMatrix getP();

    int[] getPivot();

    DecompositionSolver getSolver();

    RealMatrix getU();
}
