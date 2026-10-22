package org.apache.commons.math.ode.nonstiff;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class HighamHall54Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final String METHOD_NAME = "Higham-Hall 5(4)";
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;
    private static final double[] STATIC_E = null;

    static {
        STATIC_C = new double[]{0.2222222222222222d, 0.3333333333333333d, 0.5d, 0.6d, 1.0d, 1.0d};
        STATIC_A = new double[][]{new double[]{0.2222222222222222d}, new double[]{0.08333333333333333d, 0.25d}, new double[]{0.125d, 0.0d, 0.375d}, new double[]{0.182d, -0.27d, 0.624d, 0.064d}, new double[]{-0.55d, 1.35d, 2.4d, -7.2d, 5.0d}, new double[]{0.08333333333333333d, 0.0d, 0.84375d, -1.3333333333333333d, 1.3020833333333333d, 0.10416666666666667d}};
        STATIC_B = new double[]{0.08333333333333333d, 0.0d, 0.84375d, -1.3333333333333333d, 1.3020833333333333d, 0.10416666666666667d, 0.0d};
        STATIC_E = new double[]{-0.05d, 0.0d, 0.50625d, -1.2d, 0.78125d, 0.0625d, -0.1d};
    }

    public HighamHall54Integrator(double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance) {
        super(METHOD_NAME, false, STATIC_C, STATIC_A, STATIC_B, new HighamHall54StepInterpolator(), minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
    }

    public HighamHall54Integrator(double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance) {
        super(METHOD_NAME, false, STATIC_C, STATIC_A, STATIC_B, new HighamHall54StepInterpolator(), minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
    }

    @Override // org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    public int getOrder() {
        return 5;
    }

    @Override // org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    protected double estimateError(double[][] yDotK, double[] y0, double[] y1, double h) {
        double error = 0.0d;
        int j = 0;
    L4:
        if (j >= this.mainSetDimension) goto L14;
        double errSum = STATIC_E[0] * yDotK[0][j];
        int l = 1;
    L7:
        if (l >= STATIC_E.length) goto L9;
        errSum = errSum + (STATIC_E[l] * yDotK[l][j]);
        l = l + 1;
        goto L7
    L9:
        double yScale = FastMath.max(FastMath.abs(y0[j]), FastMath.abs(y1[j]));
        if (this.vecAbsoluteTolerance != null) goto L12;
        double r7 = this.scalAbsoluteTolerance;
        double r9 = this.scalRelativeTolerance;
    L13:
        double tol = r7 + (r9 * yScale);
        double ratio = (h * errSum) / tol;
        error = error + (ratio * ratio);
        j = j + 1;
        goto L4
    L12:
        r7 = this.vecAbsoluteTolerance[j];
        r9 = this.vecRelativeTolerance[j];
        goto L13
    L14:
        int j2 = this.mainSetDimension;
        return FastMath.sqrt(error / ((double) j2));
    }
}
