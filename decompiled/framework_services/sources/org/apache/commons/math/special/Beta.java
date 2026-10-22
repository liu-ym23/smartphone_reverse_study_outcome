package org.apache.commons.math.special;

import org.apache.commons.math.MathException;
import org.apache.commons.math.util.ContinuedFraction;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class Beta {
    private static final double DEFAULT_EPSILON = 1.0E-14d;

    private Beta() {
    }

    public static double regularizedBeta(double x, double a, double b) throws MathException {
        return regularizedBeta(x, a, b, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public static double regularizedBeta(double x, double a, double b, double epsilon) throws MathException {
        return regularizedBeta(x, a, b, epsilon, Integer.MAX_VALUE);
    }

    public static double regularizedBeta(double x, double a, double b, int maxIterations) throws MathException {
        return regularizedBeta(x, a, b, DEFAULT_EPSILON, maxIterations);
    }

    public static double regularizedBeta(double x, final double a, final double b, double epsilon, int maxIterations) throws MathException {
        if (Double.isNaN(x) == true) goto L22;
        if (Double.isNaN(a) == true) goto L22;
        if (Double.isNaN(b) == true) goto L22;
        if (x < 0.0d) goto L22;
        if (x > 1.0d) goto L22;
        if (a <= 0.0d) goto L22;
        if (b <= 0.0d) goto L22;
        if (x <= ((a + 1.0d) / ((a + b) + 2.0d))) goto L20;
        double ret = 1.0d - regularizedBeta(1.0d - x, b, a, epsilon, maxIterations);
        return ret;
    L20:
        ContinuedFraction fraction = new AnonymousClass1(b, a);
        double ret2 = (FastMath.exp((((FastMath.log(x) * a) + (FastMath.log(1.0d - x) * b)) - FastMath.log(a)) - logBeta(a, b, epsilon, maxIterations)) * 1.0d) / fraction.evaluate(x, epsilon, maxIterations);
        return ret2;
    L22:
        return Double.NaN;
    }

    public static double logBeta(double a, double b) {
        return logBeta(a, b, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public static double logBeta(double a, double b, double epsilon, int maxIterations) {
        if (Double.isNaN(a) == false) goto L5;
    L12:
        return Double.NaN;
    L5:
        if (Double.isNaN(b) == true) goto L12;
        if (a <= 0.0d) goto L12;
        if (b <= 0.0d) goto L12;
        double ret = (Gamma.logGamma(a) + Gamma.logGamma(b)) - Gamma.logGamma(a + b);
        return ret;
    }
}
