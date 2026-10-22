package org.apache.commons.math.ode;

/* JADX INFO: loaded from: classes3.dex */
public interface FirstOrderDifferentialEquations {
    void computeDerivatives(double r1, double[] r3, double[] r4) throws DerivativeException;

    int getDimension();
}
