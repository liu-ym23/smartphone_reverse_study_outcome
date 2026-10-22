package org.apache.commons.math.ode.sampling;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class NordsieckStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = -7179861704951334960L;
    private Array2DRowRealMatrix nordsieck;
    private double referenceTime;
    private double[] scaled;
    private double scalingH;
    protected double[] stateVariation;

    public NordsieckStepInterpolator() {
    }

    public NordsieckStepInterpolator(NordsieckStepInterpolator interpolator) {
        super(interpolator);
        this.scalingH = interpolator.scalingH;
        this.referenceTime = interpolator.referenceTime;
        if (interpolator.scaled == null) goto L6;
        this.scaled = (double[]) interpolator.scaled.clone();
    L6:
        if (interpolator.nordsieck == null) goto L9;
        this.nordsieck = new Array2DRowRealMatrix(interpolator.nordsieck.getDataRef(), true);
    L9:
        if (interpolator.stateVariation == null) goto L12;
        this.stateVariation = (double[]) interpolator.stateVariation.clone();
        return;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new NordsieckStepInterpolator(this);
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    public void reinitialize(double[] y, boolean forward) {
        super.reinitialize(y, forward);
        this.stateVariation = new double[y.length];
    }

    public void reinitialize(double time, double stepSize, double[] scaledDerivative, Array2DRowRealMatrix nordsieckVector) {
        this.referenceTime = time;
        this.scalingH = stepSize;
        this.scaled = scaledDerivative;
        this.nordsieck = nordsieckVector;
        setInterpolatedTime(getInterpolatedTime());
    }

    public void rescale(double stepSize) {
        double ratio = stepSize / this.scalingH;
        int i = 0;
    L4:
        if (i >= this.scaled.length) goto L6;
        double[] r3 = this.scaled;
        r3[i] = r3[i] * ratio;
        i = i + 1;
        goto L4
    L6:
        double[][] nData = this.nordsieck.getDataRef();
        double power = ratio;
        int i2 = 0;
    L8:
        if (i2 >= nData.length) goto L14;
        power = power * ratio;
        double[] nDataI = nData[i2];
        int j = 0;
    L11:
        if (j >= nDataI.length) goto L13;
        nDataI[j] = nDataI[j] * power;
        j = j + 1;
        goto L11
    L13:
        i2 = i2 + 1;
        goto L8
    L14:
        this.scalingH = stepSize;
    }

    public double[] getInterpolatedStateVariation() throws DerivativeException {
        getInterpolatedState();
        return this.stateVariation;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH) {
        double x = this.interpolatedTime - this.referenceTime;
        double normalizedAbscissa = x / this.scalingH;
        Arrays.fill(this.stateVariation, 0.0d);
        Arrays.fill(this.interpolatedDerivatives, 0.0d);
        double[][] nData = this.nordsieck.getDataRef();
        int i = nData.length - 1;
    L3:
        if (i < 0) goto L9;
        int order = i + 2;
        double[] nDataI = nData[i];
        double power = FastMath.pow(normalizedAbscissa, order);
        int j = 0;
    L6:
        if (j >= nDataI.length) goto L8;
        double d = nDataI[j] * power;
        double[] r14 = this.stateVariation;
        r14[j] = r14[j] + d;
        double[] r15 = this.interpolatedDerivatives;
        r15[j] = r15[j] + (((double) order) * d);
        j = j + 1;
        x = x;
        goto L6
    L8:
        i = i - 1;
        goto L3
    L9:
        double x2 = x;
        int j2 = 0;
    L11:
        if (j2 >= this.currentState.length) goto L14;
        double[] r2 = this.stateVariation;
        r2[j2] = r2[j2] + (this.scaled[j2] * normalizedAbscissa);
        this.interpolatedState[j2] = this.currentState[j2] + this.stateVariation[j2];
        this.interpolatedDerivatives[j2] = (this.interpolatedDerivatives[j2] + (this.scaled[j2] * normalizedAbscissa)) / x2;
        j2 = j2 + 1;
        goto L11
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        writeBaseExternal(out);
        out.writeDouble(this.scalingH);
        out.writeDouble(this.referenceTime);
        if (this.currentState != null) goto L5;
        int n = -1;
    L7:
        if (this.scaled != null) goto L9;
        out.writeBoolean(false);
    L13:
        if (this.nordsieck != null) goto L15;
        out.writeBoolean(false);
        return;
    L15:
        out.writeBoolean(true);
        out.writeObject(this.nordsieck);
        return;
    L9:
        out.writeBoolean(true);
        int j = 0;
    L10:
        if (j >= n) goto L13;
        out.writeDouble(this.scaled[j]);
        j = j + 1;
        goto L10
    L5:
        n = this.currentState.length;
        goto L7
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        double t = readBaseExternal(in);
        this.scalingH = in.readDouble();
        this.referenceTime = in.readDouble();
        if (this.currentState != null) goto L5;
        int n = -1;
    L6:
        boolean hasScaled = in.readBoolean();
        if (hasScaled == false) goto L12;
        this.scaled = new double[n];
        int j = 0;
    L9:
        if (j >= n) goto L13;
        this.scaled[j] = in.readDouble();
        j = j + 1;
    L13:
        boolean hasNordsieck = in.readBoolean();
        if (hasNordsieck == false) goto L16;
        this.nordsieck = (Array2DRowRealMatrix) in.readObject();
    L17:
        if (hasScaled == false) goto L20;
        if (hasNordsieck == false) goto L20;
        this.stateVariation = new double[n];
        setInterpolatedTime(t);
        return;
    L20:
        this.stateVariation = null;
        return;
    L16:
        this.nordsieck = null;
        goto L17
    L12:
        this.scaled = null;
        goto L13
    L5:
        n = this.currentState.length;
        goto L6
    }
}
