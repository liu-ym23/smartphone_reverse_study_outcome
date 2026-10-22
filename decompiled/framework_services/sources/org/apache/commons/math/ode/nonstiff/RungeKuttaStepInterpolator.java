package org.apache.commons.math.ode.nonstiff;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math.ode.AbstractIntegrator;
import org.apache.commons.math.ode.sampling.AbstractStepInterpolator;

/* JADX INFO: loaded from: classes3.dex */
abstract class RungeKuttaStepInterpolator extends AbstractStepInterpolator {
    protected AbstractIntegrator integrator;
    protected double[][] yDotK;

    protected RungeKuttaStepInterpolator() {
        this.yDotK = null;
        this.integrator = null;
    }

    public RungeKuttaStepInterpolator(RungeKuttaStepInterpolator interpolator) {
        super(interpolator);
        if (interpolator.currentState == null) goto L9;
        int dimension = this.currentState.length;
        this.yDotK = new double[interpolator.yDotK.length][];
        int k = 0;
    L6:
        if (k >= interpolator.yDotK.length) goto L10;
        this.yDotK[k] = new double[dimension];
        System.arraycopy(interpolator.yDotK[k], 0, this.yDotK[k], 0, dimension);
        k = k + 1;
    L10:
        this.integrator = null;
        return;
    L9:
        this.yDotK = null;
        goto L10
    }

    public void reinitialize(AbstractIntegrator rkIntegrator, double[] y, double[][] yDotArray, boolean forward) {
        reinitialize(y, forward);
        this.yDotK = yDotArray;
        this.integrator = rkIntegrator;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        writeBaseExternal(out);
        int kMax = -1;
        if (this.currentState != null) goto L5;
        int n = -1;
    L7:
        if (this.yDotK == null) goto L10;
        kMax = this.yDotK.length;
    L10:
        out.writeInt(kMax);
        int k = 0;
    L11:
        if (k >= kMax) goto L17;
        int i = 0;
    L13:
        if (i >= n) goto L15;
        out.writeDouble(this.yDotK[k][i]);
        i = i + 1;
        goto L13
    L15:
        k = k + 1;
        goto L11
    L17:
        return;
    L5:
        n = this.currentState.length;
        goto L7
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput in) throws IOException {
        double t = readBaseExternal(in);
        if (this.currentState != null) goto L5;
        int n = -1;
    L6:
        int kMax = in.readInt();
        if (kMax >= 0) goto L9;
        double[][] r5 = null;
    L10:
        this.yDotK = r5;
        int k = 0;
    L11:
        if (k >= kMax) goto L20;
        double[][] r6 = this.yDotK;
        if (n >= 0) goto L15;
        double[] r7 = null;
    L16:
        r6[k] = r7;
        int i = 0;
    L17:
        if (i >= n) goto L19;
        this.yDotK[k][i] = in.readDouble();
        i = i + 1;
        goto L17
    L19:
        k = k + 1;
        goto L11
    L15:
        r7 = new double[n];
        goto L16
    L20:
        this.integrator = null;
        if (this.currentState == null) goto L23;
        setInterpolatedTime(t);
        return;
    L23:
        this.interpolatedTime = t;
        return;
    L9:
        r5 = new double[kMax][];
        goto L10
    L5:
        n = this.currentState.length;
        goto L6
    }
}
