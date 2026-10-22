package org.apache.commons.math.ode.sampling;

import org.apache.commons.math.ode.DerivativeException;

/* JADX INFO: loaded from: classes3.dex */
public interface FixedStepHandler {
    void handleStep(double r1, double[] r3, double[] r4, boolean r5) throws DerivativeException;
}
