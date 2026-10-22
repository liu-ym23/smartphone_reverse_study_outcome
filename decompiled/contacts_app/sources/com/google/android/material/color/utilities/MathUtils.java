package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public class MathUtils {
    public static double clampDouble(double r1, double r3, double r5) {
        if (r5 >= r1) goto L6;
        return r1;
    L6:
        if (r5 <= r3) goto L8;
        return r3;
    L8:
        return r5;
    }

    public static int clampInt(int r0, int r1, int r2) {
        if (r2 >= r0) goto L4;
        return r0;
    L4:
        if (r2 <= r1) goto L6;
        return r1;
    L6:
        return r2;
    }

    public static double lerp(double r2, double r4, double r6) {
        return ((1.0d - r6) * r2) + (r6 * r4);
    }

    public static double sanitizeDegreesDouble(double r4) {
        double r5 = r4 % 360.0d;
        if (r5 < 0.0d) goto L5;
        return r5;
    L5:
        return r5 + 360.0d;
    }

    public static int signum(double r3) {
        if (r3 >= 0.0d) goto L7;
        return -1;
    L7:
        if (r3 != 0.0d) goto L10;
        return 0;
    L10:
        return 1;
    }

    private MathUtils() {
    }

    public static int sanitizeDegreesInt(int r0) {
        int r1 = r0 % 360;
        if (r1 < 0) goto L5;
        return r1;
    L5:
        return r1 + 360;
    }

    public static double rotationDirection(double r0, double r2) {
        if (sanitizeDegreesDouble(r2 - r0) > 180.0d) goto L5;
        return 1.0d;
    L5:
        return -1.0d;
    }

    public static double differenceDegrees(double r0, double r2) {
        return 180.0d - Math.abs(Math.abs(r0 - r2) - 180.0d);
    }

    public static double[] matrixMultiply(double[] r16, double[][] r17) {
        double r1 = r16[0];
        double[] r3 = r17[0];
        double r4 = r3[0] * r1;
        double r7 = r16[1];
        double r5 = r4 + (r3[1] * r7);
        double r10 = r16[2];
        double r6 = r5 + (r3[2] * r10);
        double[] r8 = r17[1];
        double r12 = ((r8[0] * r1) + (r8[1] * r7)) + (r8[2] * r10);
        double[] r9 = r17[2];
        return new double[]{r6, r12, ((r1 * r9[0]) + (r7 * r9[1])) + (r10 * r9[2])};
    }
}
