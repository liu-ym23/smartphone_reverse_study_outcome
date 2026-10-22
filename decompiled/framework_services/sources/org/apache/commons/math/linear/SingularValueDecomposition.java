package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public interface SingularValueDecomposition {
    double getConditionNumber();

    RealMatrix getCovariance(double r1) throws IllegalArgumentException;

    double getNorm();

    int getRank();

    RealMatrix getS();

    double[] getSingularValues();

    DecompositionSolver getSolver();

    RealMatrix getU();

    RealMatrix getUT();

    RealMatrix getV();

    RealMatrix getVT();
}
