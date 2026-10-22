package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public interface DecompositionSolver {
    RealMatrix getInverse() throws InvalidMatrixException;

    boolean isNonSingular();

    RealMatrix solve(RealMatrix r1) throws IllegalArgumentException, InvalidMatrixException;

    RealVector solve(RealVector r1) throws IllegalArgumentException, InvalidMatrixException;

    double[] solve(double[] r1) throws IllegalArgumentException, InvalidMatrixException;
}
