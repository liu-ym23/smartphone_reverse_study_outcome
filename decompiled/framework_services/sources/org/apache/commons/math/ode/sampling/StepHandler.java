package org.apache.commons.math.ode.sampling;

import org.apache.commons.math.ode.DerivativeException;

/* JADX INFO: loaded from: classes3.dex */
public interface StepHandler {
    void handleStep(StepInterpolator r1, boolean r2) throws DerivativeException;

    boolean requiresDenseOutput();

    void reset();
}
