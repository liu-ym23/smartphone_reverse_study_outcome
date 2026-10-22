package org.apache.commons.math.ode.nonstiff;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class GillIntegrator extends RungeKuttaIntegrator {
    private static final double[][] STATIC_A = null;
    private static final double[] STATIC_B = null;
    private static final double[] STATIC_C = null;

    static {
        STATIC_C = new double[]{0.5d, 0.5d, 1.0d};
        STATIC_A = new double[][]{new double[]{0.5d}, new double[]{(FastMath.sqrt(2.0d) - 1.0d) / 2.0d, (2.0d - FastMath.sqrt(2.0d)) / 2.0d}, new double[]{0.0d, (-FastMath.sqrt(2.0d)) / 2.0d, (FastMath.sqrt(2.0d) + 2.0d) / 2.0d}};
        STATIC_B = new double[]{0.16666666666666666d, (2.0d - FastMath.sqrt(2.0d)) / 6.0d, (FastMath.sqrt(2.0d) + 2.0d) / 6.0d, 0.16666666666666666d};
    }

    public GillIntegrator(double step) {
        super("Gill", STATIC_C, STATIC_A, STATIC_B, new GillStepInterpolator(), step);
    }
}
