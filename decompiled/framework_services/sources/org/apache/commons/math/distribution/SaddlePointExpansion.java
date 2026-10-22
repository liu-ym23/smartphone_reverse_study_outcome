package org.apache.commons.math.distribution;

import org.apache.commons.math.special.Gamma;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
final class SaddlePointExpansion {
    private static final double[] EXACT_STIRLING_ERRORS = null;
    private static final double HALF_LOG_2_PI = 0.0d;

    static {
        HALF_LOG_2_PI = FastMath.log(6.283185307179586d) * 0.5d;
        EXACT_STIRLING_ERRORS = new double[]{0.0d, 0.15342640972002736d, 0.08106146679532726d, 0.05481412105191765d, 0.0413406959554093d, 0.03316287351993629d, 0.02767792568499834d, 0.023746163656297496d, 0.020790672103765093d, 0.018488450532673187d, 0.016644691189821193d, 0.015134973221917378d, 0.013876128823070748d, 0.012810465242920227d, 0.01189670994589177d, 0.011104559758206917d, 0.010411265261972096d, 0.009799416126158804d, 0.009255462182712733d, 0.008768700134139386d, 0.00833056343336287d, 0.00793411456431402d, 0.007573675487951841d, 0.007244554301320383d, 0.00694284010720953d, 0.006665247032707682d, 0.006408994188004207d, 0.006171712263039458d, 0.0059513701127588475d, 0.0057462165130101155d, 0.005554733551962801d};
    }

    private SaddlePointExpansion() {
    }

    static double getStirlingError(double z) {
        if (z >= 15.0d) goto L9;
        double z2 = 2.0d * z;
        if (FastMath.floor(z2) != z2) goto L7;
        double ret = EXACT_STIRLING_ERRORS[(int) z2];
        return ret;
    L7:
        double ret2 = ((Gamma.logGamma(1.0d + z) - ((0.5d + z) * FastMath.log(z))) + z) - HALF_LOG_2_PI;
        return ret2;
    L9:
        double z3 = z * z;
        double ret3 = (0.08333333333333333d - ((0.002777777777777778d - ((7.936507936507937E-4d - ((5.952380952380953E-4d - (8.417508417508417E-4d / z3)) / z3)) / z3)) / z3)) / z;
        return ret3;
    }

    static double getDeviancePart(double x, double mu) {
        if (FastMath.abs(x - mu) >= ((x + mu) * 0.1d)) goto L9;
        double d = x - mu;
        double v = d / (x + mu);
        double s1 = v * d;
        double s = Double.NaN;
        double ej = (2.0d * x) * v;
        double v2 = v * v;
        int j = 1;
    L6:
        if (s1 == s) goto L12;
        s = s1;
        ej = ej * v2;
        s1 = s + (ej / ((double) ((j * 2) + 1)));
        j = j + 1;
        goto L6
    L12:
        return s1;
    L9:
        double ret = ((FastMath.log(x / mu) * x) + mu) - x;
        return ret;
    }

    static double logBinomialProbability(int x, int n, double p, double q) {
        if (x == 0) goto L5;
        if (x == n) goto L10;
        double ret = n;
        double f = ((((double) x) * 6.283185307179586d) * ((double) (n - x))) / ((double) n);
        return ((((getStirlingError(ret) - getStirlingError(x)) - getStirlingError(n - x)) - getDeviancePart(x, ((double) n) * p)) - getDeviancePart(n - x, ((double) n) * q)) + (FastMath.log(f) * (-0.5d));
    L10:
        if (q >= 0.1d) goto L12;
        double ret2 = (-getDeviancePart(n, ((double) n) * p)) - (((double) n) * q);
        return ret2;
    L12:
        double ret3 = n;
        return ret3 * FastMath.log(p);
    L5:
        if (p >= 0.1d) goto L7;
        double ret4 = (-getDeviancePart(n, ((double) n) * q)) - (((double) n) * p);
        return ret4;
    L7:
        double ret5 = n;
        return ret5 * FastMath.log(q);
    }
}
