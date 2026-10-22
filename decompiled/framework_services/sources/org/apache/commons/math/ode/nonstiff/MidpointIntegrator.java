package org.apache.commons.math.ode.nonstiff;

/* JADX INFO: loaded from: classes3.dex */
public class MidpointIntegrator extends RungeKuttaIntegrator {
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    static {
        STATIC_C = new double[]{0.5d};
        STATIC_A = new double[][]{new double[]{0.5d}};
        STATIC_B = new double[]{0.0d, 1.0d};
    }

    public MidpointIntegrator(double step) {
        super("midpoint", STATIC_C, STATIC_A, STATIC_B, new MidpointStepInterpolator(), step);
    }
}
