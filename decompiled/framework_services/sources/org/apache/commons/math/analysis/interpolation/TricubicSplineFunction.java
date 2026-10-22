package org.apache.commons.math.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math.analysis.TrivariateRealFunction;
import org.apache.commons.math.exception.OutOfRangeException;

/* JADX INFO: compiled from: TricubicSplineInterpolatingFunction.java */
/* JADX INFO: loaded from: classes3.dex */
class TricubicSplineFunction implements TrivariateRealFunction {
    private static final short N = 4;
    private final double[][][] a;

    public TricubicSplineFunction(double[] aV) {
        this.a = (double[][][]) Array.newInstance(Double.TYPE, new int[]{4, 4, 4});
        int i = 0;
    L3:
        if (i >= 4) goto L12;
        int j = 0;
    L5:
        if (j >= 4) goto L10;
        int k = 0;
    L7:
        if (k >= 4) goto L9;
        this.a[i][j][k] = aV[(((k * 4) + j) * 4) + i];
        k = k + 1;
        goto L7
    L9:
        j = j + 1;
        goto L5
    L10:
        i = i + 1;
        goto L3
    }

    @Override // org.apache.commons.math.analysis.TrivariateRealFunction
    public double value(double x, double y, double z) {
        int r2 = 4;
        boolean r10 = true;
        if (x < 0.0d) goto L30;
        if (x > 1.0d) goto L30;
        if (y < 0.0d) goto L28;
        if (y > 1.0d) goto L28;
        if (z < 0.0d) goto L26;
        if (z > 1.0d) goto L26;
        double x2 = x * x;
        double x3 = x2 * x;
        double[] pX = {1.0d, x, x2, x3};
        double y2 = y * y;
        double y3 = y2 * y;
        double[] pY = {1.0d, y, y2, y3};
        double z2 = z * z;
        double z3 = z2 * z;
        double[] pZ = {1.0d, z, z2, z3};
        double result = 0.0d;
        int i = 0;
    L15:
        if (i >= r2) goto L24;
        int j = 0;
    L17:
        if (j >= r2) goto L22;
        boolean r21 = r10;
        int k = 0;
    L19:
        if (k >= r2) goto L21;
        double[] pZ2 = pZ;
        result = result + (((this.a[i][j][k] * pX[i]) * pY[j]) * pZ2[k]);
        k = k + 1;
        pZ = pZ2;
        r2 = 4;
        goto L19
    L21:
        j = j + 1;
        r10 = r21;
        r2 = 4;
        goto L17
    L22:
        i = i + 1;
        r2 = 4;
        goto L15
    L24:
        return result;
    L26:
        throw new OutOfRangeException(Double.valueOf(z), 0, 1);
    L28:
        throw new OutOfRangeException(Double.valueOf(y), 0, 1);
    L30:
        throw new OutOfRangeException(Double.valueOf(x), 0, 1);
    }
}
