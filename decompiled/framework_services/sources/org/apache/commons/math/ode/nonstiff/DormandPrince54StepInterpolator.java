package org.apache.commons.math.ode.nonstiff;

import org.apache.commons.math.ode.AbstractIntegrator;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes3.dex */
class DormandPrince54StepInterpolator extends RungeKuttaStepInterpolator {
    private static final double A70 = 0.09114583333333333d;
    private static final double A72 = 0.44923629829290207d;
    private static final double A73 = 0.6510416666666666d;
    private static final double A74 = -0.322376179245283d;
    private static final double A75 = 0.13095238095238096d;
    private static final double D0 = -1.1270175653862835d;
    private static final double D2 = 2.675424484351598d;
    private static final double D3 = -5.685526961588504d;
    private static final double D4 = 3.5219323679207912d;
    private static final double D5 = -1.7672812570757455d;
    private static final double D6 = 2.382468931778144d;
    private static final long serialVersionUID = 4104157279605906956L;
    private double[] v1;
    private double[] v2;
    private double[] v3;
    private double[] v4;
    private boolean vectorsInitialized;

    public DormandPrince54StepInterpolator() {
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.vectorsInitialized = false;
    }

    public DormandPrince54StepInterpolator(DormandPrince54StepInterpolator interpolator) {
        super(interpolator);
        if (interpolator.v1 != null) goto L5;
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.vectorsInitialized = false;
        return;
    L5:
        this.v1 = (double[]) interpolator.v1.clone();
        this.v2 = (double[]) interpolator.v2.clone();
        this.v3 = (double[]) interpolator.v3.clone();
        this.v4 = (double[]) interpolator.v4.clone();
        this.vectorsInitialized = interpolator.vectorsInitialized;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new DormandPrince54StepInterpolator(this);
    }

    @Override // org.apache.commons.math.ode.nonstiff.RungeKuttaStepInterpolator
    public void reinitialize(AbstractIntegrator integrator, double[] y, double[][] yDotK, boolean forward) {
        super.reinitialize(integrator, y, yDotK, forward);
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    public void storeTime(double t) {
        super.storeTime(t);
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double theta, double oneMinusThetaH) throws DerivativeException {
        if (this.vectorsInitialized == false) goto L5;
    L12:
        double eta = 1.0d - theta;
        double twoTheta = theta * 2.0d;
        double dot2 = 1.0d - twoTheta;
        double dot3 = (2.0d - (theta * 3.0d)) * theta;
        double dot4 = (((twoTheta - 3.0d) * theta) + 1.0d) * twoTheta;
        int i = 0;
    L14:
        if (i >= this.interpolatedState.length) goto L17;
        int i2 = i;
        this.interpolatedState[i2] = this.currentState[i] - ((this.v1[i] - ((this.v2[i2] + ((this.v3[i2] + (this.v4[i2] * eta)) * theta)) * theta)) * oneMinusThetaH);
        this.interpolatedDerivatives[i2] = ((this.v1[i2] + (this.v2[i2] * dot2)) + (this.v3[i2] * dot3)) + (this.v4[i2] * dot4);
        i = i2 + 1;
        goto L14
    L17:
        return;
    L5:
        if (this.v1 != null) goto L7;
        this.v1 = new double[this.interpolatedState.length];
        this.v2 = new double[this.interpolatedState.length];
        this.v3 = new double[this.interpolatedState.length];
        this.v4 = new double[this.interpolatedState.length];
    L7:
        int i3 = 0;
    L9:
        if (i3 >= this.interpolatedState.length) goto L11;
        double yDot0 = this.yDotK[0][i3];
        double yDot2 = this.yDotK[2][i3];
        double yDot3 = this.yDotK[3][i3];
        double yDot4 = this.yDotK[4][i3];
        double yDot5 = this.yDotK[5][i3];
        double yDot6 = this.yDotK[6][i3];
        this.v1[i3] = ((((A70 * yDot0) + (A72 * yDot2)) + (A73 * yDot3)) + (A74 * yDot4)) + (A75 * yDot5);
        this.v2[i3] = yDot0 - this.v1[i3];
        int i4 = i3;
        this.v3[i4] = (this.v1[i3] - this.v2[i4]) - yDot6;
        this.v4[i4] = (((((D0 * yDot0) + (D2 * yDot2)) + (D3 * yDot3)) + (D4 * yDot4)) + (D5 * yDot5)) + (D6 * yDot6);
        i3 = i4 + 1;
        goto L9
    L11:
        this.vectorsInitialized = true;
        goto L12
    }
}
