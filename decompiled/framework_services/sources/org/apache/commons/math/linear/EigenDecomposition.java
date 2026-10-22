package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public interface EigenDecomposition {
    RealMatrix getD();

    double getDeterminant();

    RealVector getEigenvector(int r1);

    double getImagEigenvalue(int r1);

    double[] getImagEigenvalues();

    double getRealEigenvalue(int r1);

    double[] getRealEigenvalues();

    DecompositionSolver getSolver();

    RealMatrix getV();

    RealMatrix getVT();
}
