package org.apache.commons.math.ode.nonstiff;

import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes3.dex */
class ThreeEighthesStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = -3345024435978721931L;

    public ThreeEighthesStepInterpolator() {
    }

    public ThreeEighthesStepInterpolator(ThreeEighthesStepInterpolator interpolator) {
        super(interpolator);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new ThreeEighthesStepInterpolator(this);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH) throws DerivativeException {
        double fourTheta2 = (theta * 4.0d) * theta;
        double s = oneMinusThetaH / 8.0d;
        double coeff1 = ((1.0d - (7.0d * theta)) + (fourTheta2 * 2.0d)) * s;
        double coeff2 = (s * 3.0d) * ((theta + 1.0d) - fourTheta2);
        double coeff3 = (3.0d * s) * (theta + 1.0d);
        double coeff4 = ((theta + 1.0d) + fourTheta2) * s;
        double coeffDot3 = 0.75d * theta;
        double coeffDot1 = (((4.0d * theta) - 5.0d) * coeffDot3) + 1.0d;
        double coeffDot2 = (5.0d - (6.0d * theta)) * coeffDot3;
        double coeffDot4 = ((2.0d * theta) - 1.0d) * coeffDot3;
        int i = 0;
    L4:
        if (i >= this.interpolatedState.length) goto L7;
        double yDot1 = this.yDotK[0][i];
        double yDot2 = this.yDotK[1][i];
        double yDot3 = this.yDotK[2][i];
        double yDot4 = this.yDotK[3][i];
        double coeffDot5 = coeffDot1;
        this.interpolatedState[i] = (((this.currentState[i] - (coeff1 * yDot1)) - (coeff2 * yDot2)) - (coeff3 * yDot3)) - (coeff4 * yDot4);
        this.interpolatedDerivatives[i] = (((coeffDot5 * yDot1) + (coeffDot2 * yDot2)) + (coeffDot3 * yDot3)) + (coeffDot4 * yDot4);
        i = i + 1;
        coeffDot1 = coeffDot5;
        goto L4
    }
}
