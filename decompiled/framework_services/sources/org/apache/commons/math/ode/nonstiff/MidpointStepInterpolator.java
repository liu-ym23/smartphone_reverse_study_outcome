package org.apache.commons.math.ode.nonstiff;

import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes3.dex */
class MidpointStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = -865524111506042509L;

    public MidpointStepInterpolator() {
    }

    public MidpointStepInterpolator(MidpointStepInterpolator interpolator) {
        super(interpolator);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new MidpointStepInterpolator(this);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH) throws DerivativeException {
        double coeff1 = oneMinusThetaH * theta;
        double coeff2 = (theta + 1.0d) * oneMinusThetaH;
        double coeffDot2 = 2.0d * theta;
        double coeffDot1 = 1.0d - coeffDot2;
        int i = 0;
    L4:
        if (i >= this.interpolatedState.length) goto L7;
        double yDot1 = this.yDotK[0][i];
        double yDot2 = this.yDotK[1][i];
        this.interpolatedState[i] = (this.currentState[i] + (coeff1 * yDot1)) - (coeff2 * yDot2);
        this.interpolatedDerivatives[i] = (coeffDot1 * yDot1) + (coeffDot2 * yDot2);
        i = i + 1;
        goto L4
    }
}
