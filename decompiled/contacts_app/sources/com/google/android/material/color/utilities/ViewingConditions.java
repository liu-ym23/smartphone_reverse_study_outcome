package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = null;
    private final double aw;
    private final double c;
    private final double fl;
    private final double flRoot;
    private final double n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;
    private final double z;

    static {
        DEFAULT = defaultWithBackgroundLstar(50.0d);
    }

    public double getAw() {
        return this.aw;
    }

    public double getN() {
        return this.n;
    }

    public double getNbb() {
        return this.nbb;
    }

    double getNcb() {
        return this.ncb;
    }

    double getC() {
        return this.c;
    }

    double getNc() {
        return this.nc;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    double getZ() {
        return this.z;
    }

    public static ViewingConditions make(double[] r43, double r44, double r46, double r48, boolean r50) {
        double r4 = Math.max(0.1d, r46);
        double[][] r6 = Cam16.XYZ_TO_CAM16RGB;
        double r8 = r43[0];
        double[] r10 = r6[0];
        double r11 = r10[0] * r8;
        double r14 = r43[1];
        double r12 = r11 + (r10[1] * r14);
        double r17 = r43[2];
        double r13 = r12 + (r10[2] * r17);
        double[] r15 = r6[1];
        double r19 = ((r15[0] * r8) + (r15[1] * r14)) + (r15[2] * r17);
        double[] r7 = r6[2];
        double r9 = ((r8 * r7[0]) + (r14 * r7[1])) + (r17 * r7[2]);
        double r34 = (r48 / 10.0d) + 0.8d;
        if (r34 < 0.9d) goto L5;
        double r16 = MathUtils.lerp(0.59d, 0.69d, (r34 - 0.9d) * 10.0d);
    L6:
        double r32 = r16;
        if (r50 == false) goto L9;
        double r25 = 1.0d;
    L10:
        double r2 = MathUtils.clampDouble(0.0d, 1.0d, r25);
        double[] r18 = {(((100.0d / r13) * r2) + 1.0d) - r2, (((100.0d / r19) * r2) + 1.0d) - r2, (((100.0d / r9) * r2) + 1.0d) - r2};
        double r3 = 5.0d * r44;
        double r23 = 1.0d / (r3 + 1.0d);
        double r26 = ((r23 * r23) * r23) * r23;
        double r110 = 1.0d - r26;
        double r0 = (r26 * r44) + (((0.1d * r110) * r110) * Math.cbrt(r3));
        double r5 = ColorUtils.yFromLstar(r4) / r43[1];
        double r41 = Math.sqrt(r5) + 1.48d;
        double r20 = 0.725d / Math.pow(r5, 0.2d);
        double r21 = Math.pow(((r18[2] * r0) * r9) / 100.0d, 0.42d);
        double[] r22 = {Math.pow(((r18[0] * r0) * r13) / 100.0d, 0.42d), Math.pow(((r18[1] * r0) * r19) / 100.0d, 0.42d), r21};
        double r24 = r22[0];
        double r27 = r22[1];
        return new ViewingConditions(r5, (((((r24 * 400.0d) / (r24 + 27.13d)) * 2.0d) + ((r27 * 400.0d) / (r27 + 27.13d))) + (((400.0d * r21) / (r21 + 27.13d)) * 0.05d)) * r20, r20, r20, r32, r34, r18, r0, Math.pow(r0, 0.25d), r41);
    L9:
        r25 = (1.0d - (Math.exp(((-r44) - 42.0d) / 92.0d) * 0.2777777777777778d)) * r34;
        goto L10
    L5:
        r16 = MathUtils.lerp(0.525d, 0.59d, (r34 - 0.8d) * 10.0d);
        goto L6
    }

    public static ViewingConditions defaultWithBackgroundLstar(double r8) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, r8, 2.0d, false);
    }

    private ViewingConditions(double r4, double r6, double r8, double r10, double r12, double r14, double[] r16, double r17, double r19, double r21) {
        this.n = r4;
        this.aw = r6;
        this.nbb = r8;
        this.ncb = r10;
        this.c = r12;
        this.nc = r14;
        this.rgbD = r16;
        this.fl = r17;
        this.flRoot = r19;
        this.z = r21;
    }
}
