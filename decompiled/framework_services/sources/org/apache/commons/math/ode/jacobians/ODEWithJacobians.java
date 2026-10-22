package org.apache.commons.math.ode.jacobians;

import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface ODEWithJacobians extends FirstOrderDifferentialEquations {
    void computeJacobians(double r1, double[] r3, double[] r4, double[][] r5, double[][] r6) throws DerivativeException;

    int getParametersDimension();
}
