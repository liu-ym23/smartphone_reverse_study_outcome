package org.apache.commons.math.ode.jacobians;

import org.apache.commons.math.ode.FirstOrderDifferentialEquations;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface ParameterizedODE extends FirstOrderDifferentialEquations {
    int getParametersDimension();

    void setParameter(int r1, double r2);
}
