package org.apache.commons.math.ode;

/* JADX INFO: loaded from: classes3.dex */
public interface FirstOrderIntegrator extends ODEIntegrator {
    double integrate(FirstOrderDifferentialEquations r1, double r2, double[] r4, double r5, double[] r7) throws DerivativeException, IntegratorException;
}
