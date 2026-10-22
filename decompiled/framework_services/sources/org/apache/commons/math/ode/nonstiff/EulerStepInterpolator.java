package org.apache.commons.math.ode.nonstiff;

import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes3.dex */
class EulerStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = -7179861704951334960L;

    public EulerStepInterpolator() {
    }

    public EulerStepInterpolator(EulerStepInterpolator interpolator) {
        super(interpolator);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new EulerStepInterpolator(this);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH) throws DerivativeException {
        int i = 0;
    L4:
        if (i >= this.interpolatedState.length) goto L6;
        this.interpolatedState[i] = this.currentState[i] - (this.yDotK[0][i] * oneMinusThetaH);
        i = i + 1;
        goto L4
    L6:
        System.arraycopy(this.yDotK[0], 0, this.interpolatedDerivatives, 0, this.interpolatedDerivatives.length);
    }
}
