package org.apache.commons.math.ode.jacobians;

import org.apache.commons.math.ode.DerivativeException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface StepHandlerWithJacobians {
    void handleStep(StepInterpolatorWithJacobians r1, boolean r2) throws DerivativeException;

    boolean requiresDenseOutput();

    void reset();
}
