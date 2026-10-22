package org.apache.commons.math.ode.nonstiff;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class DormandPrince54Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final double E1 = 0.0012326388888888888d;
    private static final double E3 = -0.0042527702905061394d;
    private static final double E4 = 0.03697916666666667d;
    private static final double E5 = -0.05086379716981132d;
    private static final double E6 = 0.0419047619047619d;
    private static final double E7 = -0.025d;
    private static final String METHOD_NAME = "Dormand-Prince 5(4)";
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    static {
        STATIC_C = new double[]{0.2d, 0.3d, 0.8d, 0.8888888888888888d, 1.0d, 1.0d};
        STATIC_A = new double[][]{new double[]{0.2d}, new double[]{0.075d, 0.225d}, new double[]{0.9777777777777777d, -3.7333333333333334d, 3.5555555555555554d}, new double[]{2.9525986892242035d, -11.595793324188385d, 9.822892851699436d, -0.2908093278463649d}, new double[]{2.8462752525252526d, -10.757575757575758d, 8.906422717743473d, 0.2784090909090909d, -0.2735313036020583d}, new double[]{0.09114583333333333d, 0.0d, 0.44923629829290207d, 0.6510416666666666d, -0.322376179245283d, 0.13095238095238096d}};
        STATIC_B = new double[]{0.09114583333333333d, 0.0d, 0.44923629829290207d, 0.6510416666666666d, -0.322376179245283d, 0.13095238095238096d, 0.0d};
    }

    public DormandPrince54Integrator(double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance) {
        super(METHOD_NAME, true, STATIC_C, STATIC_A, STATIC_B, new DormandPrince54StepInterpolator(), minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
    }

    public DormandPrince54Integrator(double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance) {
        super(METHOD_NAME, true, STATIC_C, STATIC_A, STATIC_B, new DormandPrince54StepInterpolator(), minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
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
        if (j >= this.mainSetDimension) goto L10;
        double errSum = (((((yDotK[0][j] * E1) + (yDotK[2][j] * E3)) + (yDotK[3][j] * E4)) + (yDotK[4][j] * E5)) + (yDotK[5][j] * E6)) + (yDotK[6][j] * E7);
        double yScale = FastMath.max(FastMath.abs(y0[j]), FastMath.abs(y1[j]));
        if (this.vecAbsoluteTolerance != null) goto L8;
        double r7 = this.scalAbsoluteTolerance;
        double r9 = this.scalRelativeTolerance;
    L9:
        double tol = r7 + (r9 * yScale);
        double ratio = (h * errSum) / tol;
        error = error + (ratio * ratio);
        j = j + 1;
        goto L4
    L8:
        r7 = this.vecAbsoluteTolerance[j];
        r9 = this.vecRelativeTolerance[j];
        goto L9
    L10:
        int j2 = this.mainSetDimension;
        return FastMath.sqrt(error / ((double) j2));
    }
}
