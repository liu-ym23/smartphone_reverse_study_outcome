package org.apache.commons.math.special;

import org.apache.commons.math.MathException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.util.ContinuedFraction;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class Gamma {
    private static final double C_LIMIT = 49.0d;
    private static final double DEFAULT_EPSILON = 1.0E-14d;
    public static final double GAMMA = 0.5772156649015329d;
    private static final double HALF_LOG_2_PI = 0.0d;
    private static final double[] LANCZOS = null;
    private static final double S_LIMIT = 1.0E-5d;

    static {
        LANCZOS = new double[]{0.9999999999999971d, 57.15623566586292d, -59.59796035547549d, 14.136097974741746d, -0.4919138160976202d, 3.399464998481189E-5d, 4.652362892704858E-5d, -9.837447530487956E-5d, 1.580887032249125E-4d, -2.1026444172410488E-4d, 2.1743961811521265E-4d, -1.643181065367639E-4d, 8.441822398385275E-5d, -2.6190838401581408E-5d, 3.6899182659531625E-6d};
        HALF_LOG_2_PI = FastMath.log(6.283185307179586d) * 0.5d;
    }

    private Gamma() {
    }

    public static double logGamma(double x) {
        if (Double.isNaN(x) == false) goto L5;
    L11:
        return Double.NaN;
    L5:
        if (x <= 0.0d) goto L11;
        double sum = 0.0d;
        int i = LANCZOS.length - 1;
    L8:
        if (i <= 0) goto L10;
        sum = sum + (LANCZOS[i] / (((double) i) + x));
        i = i - 1;
        goto L8
    L10:
        double tmp = (x + 4.7421875d) + 0.5d;
        double ret = ((((0.5d + x) * FastMath.log(tmp)) - tmp) + HALF_LOG_2_PI) + FastMath.log((sum + LANCZOS[0]) / x);
        return ret;
    }

    public static double regularizedGammaP(double a, double x) throws MathException {
        return regularizedGammaP(a, x, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public static double regularizedGammaP(double a, double x, double epsilon, int maxIterations) throws MathException {
        if (Double.isNaN(a) == false) goto L5;
    L33:
        return Double.NaN;
    L5:
        if (Double.isNaN(x) == true) goto L33;
        if (a <= 0.0d) goto L33;
        if (x < 0.0d) goto L33;
        if (x != 0.0d) goto L15;
        return 0.0d;
    L15:
        if (x < (a + 1.0d)) goto L17;
        double ret = 1.0d - regularizedGammaQ(a, x, epsilon, maxIterations);
        return ret;
    L17:
        double n = 0.0d;
        double an = 1.0d / a;
        double sum = an;
    L19:
        if (FastMath.abs(an / sum) <= epsilon) goto L26;
        if (n >= maxIterations) goto L26;
        if (sum >= Double.POSITIVE_INFINITY) goto L26;
        n = n + 1.0d;
        an = an * (x / (a + n));
        sum = sum + an;
    L26:
        if (n >= maxIterations) goto L32;
        if (Double.isInfinite(sum) == false) goto L30;
        return 1.0d;
    L30:
        double ret2 = -x;
        return FastMath.exp((ret2 + (FastMath.log(x) * a)) - logGamma(a)) * sum;
    L32:
        throw new MaxIterationsExceededException(maxIterations);
    }

    public static double regularizedGammaQ(double a, double x) throws MathException {
        return regularizedGammaQ(a, x, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public static double regularizedGammaQ(final double a, double x, double epsilon, int maxIterations) throws MathException {
        if (Double.isNaN(a) == false) goto L5;
    L18:
        return Double.NaN;
    L5:
        if (Double.isNaN(x) == true) goto L18;
        if (a <= 0.0d) goto L18;
        if (x < 0.0d) goto L18;
        if (x != 0.0d) goto L15;
        return 1.0d;
    L15:
        if (x >= (a + 1.0d)) goto L17;
        double ret = 1.0d - regularizedGammaP(a, x, epsilon, maxIterations);
        return ret;
    L17:
        ContinuedFraction cf = new AnonymousClass1(a);
        double ret2 = 1.0d / cf.evaluate(x, epsilon, maxIterations);
        return FastMath.exp(((-x) + (FastMath.log(x) * a)) - logGamma(a)) * ret2;
    }

    public static double digamma(double x) {
        if (x <= 0.0d) goto L9;
        if (x > S_LIMIT) goto L9;
        return (-0.5772156649015329d) - (1.0d / x);
    L9:
        if (x < C_LIMIT) goto L13;
        double inv = 1.0d / (x * x);
        return (FastMath.log(x) - (0.5d / x)) - ((((0.008333333333333333d - (inv / 252.0d)) * inv) + 0.08333333333333333d) * inv);
    L13:
        return digamma(x + 1.0d) - (1.0d / x);
    }

    public static double trigamma(double x) {
        if (x <= 0.0d) goto L9;
        if (x > S_LIMIT) goto L9;
        return 1.0d / (x * x);
    L9:
        if (x < C_LIMIT) goto L13;
        double inv = 1.0d / (x * x);
        return ((1.0d / x) + (inv / 2.0d)) + ((inv / x) * (0.16666666666666666d - (((inv / 42.0d) + 0.03333333333333333d) * inv)));
    L13:
        return trigamma(x + 1.0d) + (1.0d / (x * x));
    }
}
