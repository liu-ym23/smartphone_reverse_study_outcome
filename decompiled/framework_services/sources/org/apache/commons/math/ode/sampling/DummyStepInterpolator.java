package org.apache.commons.math.ode.sampling;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* JADX INFO: loaded from: classes3.dex */
public class DummyStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = 1708010296707839488L;
    private double[] currentDerivative;

    public DummyStepInterpolator() {
        this.currentDerivative = null;
    }

    public DummyStepInterpolator(double[] y, double[] yDot, boolean forward) {
        super(y, forward);
        this.currentDerivative = yDot;
    }

    public DummyStepInterpolator(DummyStepInterpolator interpolator) {
        super(interpolator);
        this.currentDerivative = (double[]) interpolator.currentDerivative.clone();
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new DummyStepInterpolator(this);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH) {
        System.arraycopy(this.currentState, 0, this.interpolatedState, 0, this.currentState.length);
        System.arraycopy(this.currentDerivative, 0, this.interpolatedDerivatives, 0, this.currentDerivative.length);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        writeBaseExternal(out);
        if (this.currentDerivative == null) goto L8;
        int i = 0;
    L6:
        if (i >= this.currentDerivative.length) goto L10;
        out.writeDouble(this.currentDerivative[i]);
        i = i + 1;
        goto L6
    L10:
        return;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput in) throws IOException {
        double t = readBaseExternal(in);
        if (this.currentState != null) goto L5;
        this.currentDerivative = null;
    L9:
        setInterpolatedTime(t);
        return;
    L5:
        this.currentDerivative = new double[this.currentState.length];
        int i = 0;
    L7:
        if (i >= this.currentDerivative.length) goto L9;
        this.currentDerivative[i] = in.readDouble();
        i = i + 1;
        goto L7
    }
}
