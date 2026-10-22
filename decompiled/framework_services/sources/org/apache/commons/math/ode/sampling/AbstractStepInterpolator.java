package org.apache.commons.math.ode.sampling;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math.ode.DerivativeException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractStepInterpolator implements StepInterpolator {
    protected double[] currentState;
    private boolean dirtyState;
    private boolean finalized;
    private boolean forward;
    private double globalCurrentTime;
    private double globalPreviousTime;
    protected double h;
    protected double[] interpolatedDerivatives;
    protected double[] interpolatedState;
    protected double interpolatedTime;
    private double softCurrentTime;
    private double softPreviousTime;

    protected abstract void computeInterpolatedStateAndDerivatives(double r1, double r3) throws DerivativeException;

    protected abstract StepInterpolator doCopy();

    @Override // java.io.Externalizable
    public abstract void readExternal(ObjectInput r1) throws IOException, ClassNotFoundException;

    @Override // java.io.Externalizable
    public abstract void writeExternal(ObjectOutput r1) throws IOException;

    protected AbstractStepInterpolator() {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = null;
        this.interpolatedState = null;
        this.interpolatedDerivatives = null;
        this.finalized = false;
        this.forward = true;
        this.dirtyState = true;
    }

    protected AbstractStepInterpolator(double[] y, boolean forward) {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = y;
        this.interpolatedState = new double[y.length];
        this.interpolatedDerivatives = new double[y.length];
        this.finalized = false;
        this.forward = forward;
        this.dirtyState = true;
    }

    protected AbstractStepInterpolator(AbstractStepInterpolator interpolator) {
        this.globalPreviousTime = interpolator.globalPreviousTime;
        this.globalCurrentTime = interpolator.globalCurrentTime;
        this.softPreviousTime = interpolator.softPreviousTime;
        this.softCurrentTime = interpolator.softCurrentTime;
        this.h = interpolator.h;
        this.interpolatedTime = interpolator.interpolatedTime;
        if (interpolator.currentState == null) goto L5;
        this.currentState = (double[]) interpolator.currentState.clone();
        this.interpolatedState = (double[]) interpolator.interpolatedState.clone();
        this.interpolatedDerivatives = (double[]) interpolator.interpolatedDerivatives.clone();
    L6:
        this.finalized = interpolator.finalized;
        this.forward = interpolator.forward;
        this.dirtyState = interpolator.dirtyState;
        return;
    L5:
        this.currentState = null;
        this.interpolatedState = null;
        this.interpolatedDerivatives = null;
        goto L6
    }

    protected void reinitialize(double[] y, boolean isForward) {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = y;
        this.interpolatedState = new double[y.length];
        this.interpolatedDerivatives = new double[y.length];
        this.finalized = false;
        this.forward = isForward;
        this.dirtyState = true;
    }

    @Override // org.apache.commons.math.ode.sampling.StepInterpolator
    public StepInterpolator copy() throws DerivativeException {
        finalizeStep();
        return doCopy();
    }

    public void shift() {
        this.globalPreviousTime = this.globalCurrentTime;
        this.softPreviousTime = this.globalPreviousTime;
        this.softCurrentTime = this.globalCurrentTime;
    }

    public void storeTime(double t) {
        this.globalCurrentTime = t;
        this.softCurrentTime = this.globalCurrentTime;
        this.h = this.globalCurrentTime - this.globalPreviousTime;
        setInterpolatedTime(t);
        this.finalized = false;
    }

    public void setSoftPreviousTime(double softPreviousTime) {
        this.softPreviousTime = softPreviousTime;
    }

    public void setSoftCurrentTime(double softCurrentTime) {
        this.softCurrentTime = softCurrentTime;
    }

    public double getGlobalPreviousTime() {
        return this.globalPreviousTime;
    }

    public double getGlobalCurrentTime() {
        return this.globalCurrentTime;
    }

    @Override // org.apache.commons.math.ode.sampling.StepInterpolator
    public double getPreviousTime() {
        return this.softPreviousTime;
    }

    @Override // org.apache.commons.math.ode.sampling.StepInterpolator
    public double getCurrentTime() {
        return this.softCurrentTime;
    }

    @Override // org.apache.commons.math.ode.sampling.StepInterpolator
    public double getInterpolatedTime() {
        return this.interpolatedTime;
    }

    @Override // org.apache.commons.math.ode.sampling.StepInterpolator
    public void setInterpolatedTime(double time) {
        this.interpolatedTime = time;
        this.dirtyState = true;
    }

    @Override // org.apache.commons.math.ode.sampling.StepInterpolator
    public boolean isForward() {
        return this.forward;
    }

    @Override // org.apache.commons.math.ode.sampling.StepInterpolator
    public double[] getInterpolatedState() throws DerivativeException {
        if (this.dirtyState == false) goto L10;
        double oneMinusThetaH = this.globalCurrentTime - this.interpolatedTime;
        double theta = 0.0d;
        if (this.h == 0.0d) goto L8;
        theta = (this.h - oneMinusThetaH) / this.h;
    L8:
        computeInterpolatedStateAndDerivatives(theta, oneMinusThetaH);
        this.dirtyState = false;
    L10:
        return this.interpolatedState;
    }

    @Override // org.apache.commons.math.ode.sampling.StepInterpolator
    public double[] getInterpolatedDerivatives() throws DerivativeException {
        if (this.dirtyState == false) goto L10;
        double oneMinusThetaH = this.globalCurrentTime - this.interpolatedTime;
        double theta = 0.0d;
        if (this.h == 0.0d) goto L8;
        theta = (this.h - oneMinusThetaH) / this.h;
    L8:
        computeInterpolatedStateAndDerivatives(theta, oneMinusThetaH);
        this.dirtyState = false;
    L10:
        return this.interpolatedDerivatives;
    }

    public final void finalizeStep() throws DerivativeException {
        if (this.finalized == true) goto L6;
        doFinalize();
        this.finalized = true;
        return;
    }

    protected void doFinalize() throws DerivativeException {
    }

    protected void writeBaseExternal(ObjectOutput out) throws IOException {
        if (this.currentState != null) goto L5;
        out.writeInt(-1);
    L6:
        out.writeDouble(this.globalPreviousTime);
        out.writeDouble(this.globalCurrentTime);
        out.writeDouble(this.softPreviousTime);
        out.writeDouble(this.softCurrentTime);
        out.writeDouble(this.h);
        out.writeBoolean(this.forward);
        if (this.currentState == null) goto L12;
        int i = 0;
    L10:
        if (i >= this.currentState.length) goto L12;
        out.writeDouble(this.currentState[i]);
        i = i + 1;
    L12:
        out.writeDouble(this.interpolatedTime);
        finalizeStep();     // Catch: DerivativeException -> L15
        return;
    L15:
        e = move-exception;
        IOException ioe = new IOException(e.getLocalizedMessage());
        ioe.initCause(e);
        throw ioe;
    L5:
        out.writeInt(this.currentState.length);
        goto L6
    }

    protected double readBaseExternal(ObjectInput in) throws IOException {
        int dimension = in.readInt();
        this.globalPreviousTime = in.readDouble();
        this.globalCurrentTime = in.readDouble();
        this.softPreviousTime = in.readDouble();
        this.softCurrentTime = in.readDouble();
        this.h = in.readDouble();
        this.forward = in.readBoolean();
        this.dirtyState = true;
        double[] r2 = null;
        if (dimension >= 0) goto L5;
        this.currentState = null;
    L9:
        this.interpolatedTime = Double.NaN;
        if (dimension >= 0) goto L12;
        double[] r3 = null;
    L13:
        this.interpolatedState = r3;
        if (dimension < 0) goto L17;
        r2 = new double[dimension];
    L17:
        this.interpolatedDerivatives = r2;
        this.finalized = true;
        return in.readDouble();
    L12:
        r3 = new double[dimension];
        goto L13
    L5:
        this.currentState = new double[dimension];
        int i = 0;
    L7:
        if (i >= this.currentState.length) goto L9;
        this.currentState[i] = in.readDouble();
        i = i + 1;
        goto L7
    }
}
