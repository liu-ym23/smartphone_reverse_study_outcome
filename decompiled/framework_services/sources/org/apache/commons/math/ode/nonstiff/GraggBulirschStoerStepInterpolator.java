package org.apache.commons.math.ode.nonstiff;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math.ode.sampling.StepInterpolator;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
class GraggBulirschStoerStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = 7320613236731409847L;
    private int currentDegree;
    private double[] errfac;
    private double[][] polynoms;
    private double[] y0Dot;
    private double[] y1;
    private double[] y1Dot;
    private double[][] yMidDots;

    public GraggBulirschStoerStepInterpolator() {
        this.y0Dot = null;
        this.y1 = null;
        this.y1Dot = null;
        this.yMidDots = null;
        resetTables(-1);
    }

    public GraggBulirschStoerStepInterpolator(double[] y, double[] y0Dot, double[] y1, double[] y1Dot, double[][] yMidDots, boolean forward) {
        super(y, forward);
        this.y0Dot = y0Dot;
        this.y1 = y1;
        this.y1Dot = y1Dot;
        this.yMidDots = yMidDots;
        resetTables(yMidDots.length + 4);
    }

    public GraggBulirschStoerStepInterpolator(GraggBulirschStoerStepInterpolator interpolator) {
        super(interpolator);
        int dimension = this.currentState.length;
        this.y0Dot = null;
        this.y1 = null;
        this.y1Dot = null;
        this.yMidDots = null;
        if (interpolator.polynoms != null) goto L5;
        this.polynoms = null;
        this.currentDegree = -1;
        return;
    L5:
        resetTables(interpolator.currentDegree);
        int i = 0;
    L7:
        if (i >= this.polynoms.length) goto L9;
        this.polynoms[i] = new double[dimension];
        System.arraycopy(interpolator.polynoms[i], 0, this.polynoms[i], 0, dimension);
        i = i + 1;
        goto L7
    L9:
        int i2 = interpolator.currentDegree;
        this.currentDegree = i2;
    }

    private void resetTables(int maxDegree) {
        if (maxDegree >= 0) goto L5;
        this.polynoms = null;
        this.errfac = null;
        this.currentDegree = -1;
        return;
    L5:
        double[][] newPols = new double[maxDegree + 1][];
        if (this.polynoms == null) goto L12;
        System.arraycopy(this.polynoms, 0, newPols, 0, this.polynoms.length);
        int i = this.polynoms.length;
    L9:
        if (i >= newPols.length) goto L16;
        newPols[i] = new double[this.currentState.length];
        i = i + 1;
    L16:
        this.polynoms = newPols;
        if (maxDegree > 4) goto L19;
        this.errfac = null;
    L26:
        this.currentDegree = 0;
        return;
    L19:
        this.errfac = new double[maxDegree - 4];
        int i2 = 0;
    L21:
        if (i2 >= this.errfac.length) goto L26;
        int ip5 = i2 + 5;
        this.errfac[i2] = 1.0d / ((double) (ip5 * ip5));
        double e = FastMath.sqrt(((double) (i2 + 1)) / ((double) ip5)) * 0.5d;
        int j = 0;
    L23:
        if (j > i2) goto L25;
        double[] r7 = this.errfac;
        r7[i2] = r7[i2] * (e / ((double) (j + 1)));
        j = j + 1;
        goto L23
    L25:
        i2 = i2 + 1;
        goto L21
    L12:
        int i3 = 0;
    L14:
        if (i3 >= newPols.length) goto L16;
        newPols[i3] = new double[this.currentState.length];
        i3 = i3 + 1;
        goto L14
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new GraggBulirschStoerStepInterpolator(this);
    }

    public void computeCoefficients(int mu, double h) {
        int r1 = mu;
        if (this.polynoms != null) goto L5;
    L6:
        resetTables(r1 + 4);
    L7:
        this.currentDegree = r1 + 4;
        int i = 0;
    L9:
        if (i >= this.currentState.length) goto L28;
        double yp0 = this.y0Dot[i] * h;
        double yp1 = this.y1Dot[i] * h;
        double ydiff = this.y1[i] - this.currentState[i];
        double aspl = ydiff - yp1;
        double bspl = yp0 - ydiff;
        this.polynoms[0][i] = this.currentState[i];
        this.polynoms[1][i] = ydiff;
        this.polynoms[2][i] = aspl;
        this.polynoms[3][i] = bspl;
        if (r1 < 0) goto L12;
        double ph0 = ((this.currentState[i] + this.y1[i]) * 0.5d) + ((aspl + bspl) * 0.125d);
        this.polynoms[4][i] = (this.yMidDots[0][i] - ph0) * 16.0d;
        if (r1 <= 0) goto L25;
        double ph1 = ydiff + ((aspl - bspl) * 0.25d);
        this.polynoms[5][i] = (this.yMidDots[1][i] - ph1) * 16.0d;
        if (r1 <= 1) goto L24;
        double ph2 = yp1 - yp0;
        int i2 = i;
        this.polynoms[6][i2] = ((this.yMidDots[2][i2] - ph2) + this.polynoms[4][i2]) * 16.0d;
        if (r1 <= 2) goto L26;
        double ph3 = (bspl - aspl) * 6.0d;
        this.polynoms[7][i2] = ((this.yMidDots[3][i2] - ph3) + (this.polynoms[5][i2] * 3.0d)) * 16.0d;
        int j = 4;
    L20:
        if (j > r1) goto L26;
        double yp2 = yp0;
        int j2 = j;
        double fac1 = (((double) j) * 0.5d) * ((double) (j - 1));
        double fac2 = ((double) (j2 - 3)) * ((j2 - 2) * (2.0d * fac1));
        this.polynoms[j2 + 4][i2] = ((this.yMidDots[j2][i2] + (this.polynoms[j2 + 2][i2] * fac1)) - (this.polynoms[j2][i2] * fac2)) * 16.0d;
        j = j2 + 1;
        r1 = mu;
        yp0 = yp2;
    L26:
        i = i2 + 1;
        r1 = mu;
        goto L9
    L24:
        i2 = i;
        goto L26
    L25:
        i2 = i;
        goto L26
    L12:
        return;
    L28:
        return;
    L5:
        if (this.polynoms.length > (r1 + 4)) goto L7;
        goto L6
    }

    public double estimateError(double[] scale) {
        double error = 0.0d;
        if (this.currentDegree < 5) goto L11;
        int i = 0;
    L6:
        if (i >= scale.length) goto L8;
        double e = this.polynoms[this.currentDegree][i] / scale[i];
        error = error + (e * e);
        i = i + 1;
        goto L6
    L8:
        int i2 = scale.length;
        return FastMath.sqrt(error / ((double) i2)) * this.errfac[this.currentDegree - 5];
    L11:
        return 0.0d;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH) {
        int dimension = this.currentState.length;
        double oneMinusTheta = 1.0d - theta;
        double theta05 = theta - 0.5d;
        double tOmT = theta * oneMinusTheta;
        double t4 = tOmT * tOmT;
        double t4Dot = (tOmT * 2.0d) * (1.0d - (theta * 2.0d));
        double dot1 = 1.0d / this.h;
        double dot2 = this.h;
        double dot3 = ((2.0d - (theta * 3.0d)) * theta) / dot2;
        double dot4 = ((((3.0d * theta) - 4.0d) * theta) + 1.0d) / this.h;
        int i = 0;
    L4:
        if (i >= dimension) goto L14;
        double p0 = this.polynoms[0][i];
        double p1 = this.polynoms[1][i];
        double p2 = this.polynoms[2][i];
        int i2 = i;
        double p3 = this.polynoms[3][i2];
        this.interpolatedState[i2] = p0 + ((p1 + (((p2 * theta) + (p3 * oneMinusTheta)) * oneMinusTheta)) * theta);
        this.interpolatedDerivatives[i2] = ((dot1 * p1) + (dot3 * p2)) + (dot4 * p3);
        if (this.currentDegree <= 3) goto L12;
        double cDot = 0.0d;
        double c = this.polynoms[this.currentDegree][i2];
        double c2 = c;
        int j = this.currentDegree - 1;
    L9:
        if (j <= 3) goto L11;
        int j2 = j;
        double d = 1.0d / ((double) (j - 3));
        cDot = d * ((theta05 * cDot) + c2);
        c2 = this.polynoms[j2][i2] + ((c2 * d) * theta05);
        j = j2 - 1;
        goto L9
    L11:
        double[] r2 = this.interpolatedState;
        r2[i2] = r2[i2] + (t4 * c2);
        double[] r3 = this.interpolatedDerivatives;
        r3[i2] = r3[i2] + (((t4 * cDot) + (t4Dot * c2)) / this.h);
    L12:
        i = i2 + 1;
        goto L4
    L14:
        if (this.h != 0.0d) goto L21;
        System.arraycopy(this.yMidDots[1], 0, this.interpolatedDerivatives, 0, dimension);
        return;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        if (this.currentState != null) goto L5;
        int dimension = -1;
    L6:
        writeBaseExternal(out);
        out.writeInt(this.currentDegree);
        int k = 0;
    L8:
        if (k > this.currentDegree) goto L14;
        int l = 0;
    L10:
        if (l >= dimension) goto L12;
        out.writeDouble(this.polynoms[k][l]);
        l = l + 1;
        goto L10
    L12:
        k = k + 1;
        goto L8
    L14:
        return;
    L5:
        dimension = this.currentState.length;
        goto L6
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput in) throws IOException {
        double t = readBaseExternal(in);
        if (this.currentState != null) goto L5;
        int dimension = -1;
    L6:
        int degree = in.readInt();
        resetTables(degree);
        this.currentDegree = degree;
        int k = 0;
    L8:
        if (k > this.currentDegree) goto L13;
        int l = 0;
    L10:
        if (l >= dimension) goto L12;
        this.polynoms[k][l] = in.readDouble();
        l = l + 1;
        goto L10
    L12:
        k = k + 1;
        goto L8
    L13:
        setInterpolatedTime(t);
        return;
    L5:
        dimension = this.currentState.length;
        goto L6
    }
}
