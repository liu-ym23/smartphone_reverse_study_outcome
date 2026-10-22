package org.apache.commons.math.ode;

/* JADX INFO: loaded from: classes3.dex */
public interface SecondOrderIntegrator extends ODEIntegrator {
    void integrate(SecondOrderDifferentialEquations r1, double r2, double[] r4, double[] r5, double r6, double[] r8, double[] r9) throws DerivativeException, IntegratorException;
}
