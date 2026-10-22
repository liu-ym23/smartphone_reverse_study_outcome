package org.apache.commons.math.special;

import org.apache.commons.math.MathException;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class Erf {
    private Erf() {
    }

    public static double erf(double x) throws MathException {
        if (FastMath.abs(x) > 40.0d) goto L5;
        double ret = Gamma.regularizedGammaP(0.5d, x * x, 1.0E-15d, 10000);
        if (x < 0.0d) goto L12;
        return ret;
    L12:
        return -ret;
    L5:
        if (x <= 0.0d) goto L7;
        return 1.0d;
    L7:
        return -1.0d;
    }

    public static double erfc(double x) throws MathException {
        if (FastMath.abs(x) > 40.0d) goto L5;
        double ret = Gamma.regularizedGammaQ(0.5d, x * x, 1.0E-15d, 10000);
        if (x >= 0.0d) goto L12;
        return 2.0d - ret;
    L12:
        return ret;
    L5:
        if (x > 0.0d) goto L7;
        return 2.0d;
    L7:
        return 0.0d;
    }
}
