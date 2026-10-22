package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public interface QRDecomposition {
    RealMatrix getH();

    RealMatrix getQ();

    RealMatrix getQT();

    RealMatrix getR();

    DecompositionSolver getSolver();
}
