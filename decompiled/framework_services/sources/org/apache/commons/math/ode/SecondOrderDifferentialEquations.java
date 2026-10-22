package org.apache.commons.math.ode;

/* JADX INFO: loaded from: classes3.dex */
public interface SecondOrderDifferentialEquations {
    void computeSecondDerivatives(double r1, double[] r3, double[] r4, double[] r5) throws DerivativeException;

    int getDimension();
}
