package org.apache.commons.math.ode.sampling;

import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class StepNormalizer implements StepHandler {
    private boolean forward;
    private double h;
    private final FixedStepHandler handler;
    private double[] lastDerivatives;
    private double[] lastState;
    private double lastTime;

    public StepNormalizer(double h, FixedStepHandler handler) {
        this.h = FastMath.abs(h);
        this.handler = handler;
        reset();
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public boolean requiresDenseOutput() {
        return true;
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public void reset() {
        this.lastTime = Double.NaN;
        this.lastState = null;
        this.lastDerivatives = null;
        this.forward = true;
    }

    @Override // org.apache.commons.math.ode.sampling.StepHandler
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws DerivativeException {
        if (this.lastState != null) goto L11;
        this.lastTime = interpolator.getPreviousTime();
        interpolator.setInterpolatedTime(this.lastTime);
        this.lastState = (double[]) interpolator.getInterpolatedState().clone();
        this.lastDerivatives = (double[]) interpolator.getInterpolatedDerivatives().clone();
        if (interpolator.getCurrentTime() < this.lastTime) goto L7;
        boolean r0 = true;
    L8:
        this.forward = r0;
        if (this.forward == true) goto L11;
        this.h = -this.h;
        goto L11
    L7:
        r0 = false;
    L11:
        double nextTime = this.lastTime + this.h;
        boolean r1 = this.forward;
        if (nextTime <= interpolator.getCurrentTime()) goto L14;
        boolean r5 = true;
    L15:
        boolean nextInStep = r1 ^ r5;
    L16:
        if (nextInStep == false) goto L22;
        this.handler.handleStep(this.lastTime, this.lastState, this.lastDerivatives, false);
        this.lastTime = nextTime;
        interpolator.setInterpolatedTime(this.lastTime);
        System.arraycopy(interpolator.getInterpolatedState(), 0, this.lastState, 0, this.lastState.length);
        System.arraycopy(interpolator.getInterpolatedDerivatives(), 0, this.lastDerivatives, 0, this.lastDerivatives.length);
        nextTime = nextTime + this.h;
        boolean r6 = this.forward;
        if (nextTime <= interpolator.getCurrentTime()) goto L20;
        boolean r7 = true;
    L21:
        nextInStep = r6 ^ r7;
        goto L16
    L20:
        r7 = false;
        goto L21
    L22:
        if (isLast == false) goto L28;
        this.handler.handleStep(this.lastTime, this.lastState, this.lastDerivatives, true);
        return;
    L28:
        return;
    L14:
        r5 = false;
        goto L15
    }
}
