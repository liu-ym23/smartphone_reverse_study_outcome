package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public class ColorUtils {
    static final double[][] SRGB_TO_XYZ = null;
    static final double[] WHITE_POINT_D65 = null;
    static final double[][] XYZ_TO_SRGB = null;

    public static int alphaFromArgb(int r0) {
        return (r0 >> 24) & 255;
    }

    public static int argbFromRgb(int r1, int r2, int r3) {
        return ((((r1 & 255) << 16) | (-16777216)) | ((r2 & 255) << 8)) | (r3 & 255);
    }

    public static int blueFromArgb(int r0) {
        return r0 & 255;
    }

    public static int greenFromArgb(int r0) {
        return (r0 >> 8) & 255;
    }

    static double labInvf(double r4) {
        double r0 = (r4 * r4) * r4;
        if (r0 <= 0.008856451679035631d) goto L6;
        return r0;
    L6:
        return ((r4 * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static int redFromArgb(int r0) {
        return (r0 >> 16) & 255;
    }

    private ColorUtils() {
    }

    static {
        SRGB_TO_XYZ = new double[][]{new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
        XYZ_TO_SRGB = new double[][]{new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};
        WHITE_POINT_D65 = new double[]{95.047d, 100.0d, 108.883d};
    }

    public static int argbFromLinrgb(double[] r4) {
        return argbFromRgb(delinearized(r4[0]), delinearized(r4[1]), delinearized(r4[2]));
    }

    public static boolean isOpaque(int r1) {
        if (alphaFromArgb(r1) < 255) goto L5;
        return true;
    L5:
        return false;
    }

    public static int argbFromXyz(double r11, double r13, double r15) {
        double[][] r0 = XYZ_TO_SRGB;
        double[] r2 = r0[0];
        double r3 = ((r2[0] * r11) + (r2[1] * r13)) + (r2[2] * r15);
        double[] r4 = r0[1];
        double r7 = ((r4[0] * r11) + (r4[1] * r13)) + (r4[2] * r15);
        double[] r1 = r0[2];
        double r5 = ((r1[0] * r11) + (r1[1] * r13)) + (r1[2] * r15);
        return argbFromRgb(delinearized(r3), delinearized(r7), delinearized(r5));
    }

    public static double[] xyzFromArgb(int r7) {
        return MathUtils.matrixMultiply(new double[]{linearized(redFromArgb(r7)), linearized(greenFromArgb(r7)), linearized(blueFromArgb(r7))}, SRGB_TO_XYZ);
    }

    public static int argbFromLab(double r9, double r11, double r13) {
        double[] r0 = WHITE_POINT_D65;
        double r10 = (r9 + 16.0d) / 116.0d;
        double r14 = r10 - (r13 / 200.0d);
        double r12 = labInvf((r11 / 500.0d) + r10);
        double r15 = labInvf(r10);
        double r16 = labInvf(r14);
        return argbFromXyz(r12 * r0[0], r15 * r0[1], r16 * r0[2]);
    }

    public static double[] labFromArgb(int r17) {
        double r0 = linearized(redFromArgb(r17));
        double r2 = linearized(greenFromArgb(r17));
        double r4 = linearized(blueFromArgb(r17));
        double[][] r6 = SRGB_TO_XYZ;
        double[] r8 = r6[0];
        double r9 = ((r8[0] * r0) + (r8[1] * r2)) + (r8[2] * r4);
        double[] r10 = r6[1];
        double r13 = ((r10[0] * r0) + (r10[1] * r2)) + (r10[2] * r4);
        double[] r7 = r6[2];
        double r15 = ((r7[0] * r0) + (r7[1] * r2)) + (r7[2] * r4);
        double[] r1 = WHITE_POINT_D65;
        double r11 = r9 / r1[0];
        double r14 = r13 / r1[1];
        double r16 = r15 / r1[2];
        double r3 = labF(r11);
        double r5 = labF(r14);
        return new double[]{(116.0d * r5) - 16.0d, (r3 - r5) * 500.0d, (r5 - labF(r16)) * 200.0d};
    }

    public static int argbFromLstar(double r0) {
        int r1 = delinearized(yFromLstar(r0));
        return argbFromRgb(r1, r1, r1);
    }

    public static double lstarFromArgb(int r4) {
        return (labF(xyzFromArgb(r4)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double yFromLstar(double r2) {
        return labInvf((r2 + 16.0d) / 116.0d) * 100.0d;
    }

    public static double lstarFromY(double r2) {
        return (labF(r2 / 100.0d) * 116.0d) - 16.0d;
    }

    public static double linearized(int r6) {
        double r0 = ((double) r6) / 255.0d;
        if (r0 > 0.040449936d) goto L7;
        double r1 = r0 / 12.92d;
    L6:
        return r1 * 100.0d;
    L7:
        r1 = Math.pow((r0 + 0.055d) / 1.055d, 2.4d);
        goto L6
    }

    public static int delinearized(double r2) {
        double r3 = r2 / 100.0d;
        if (r3 > 0.0031308d) goto L5;
        double r4 = r3 * 12.92d;
    L7:
        return MathUtils.clampInt(0, 255, (int) Math.round(r4 * 255.0d));
    L5:
        r4 = (Math.pow(r3, 0.4166666666666667d) * 1.055d) - 0.055d;
        goto L7
    }

    public static double[] whitePointD65() {
        return WHITE_POINT_D65;
    }

    static double labF(double r2) {
        if (r2 <= 0.008856451679035631d) goto L7;
        return Math.pow(r2, 0.3333333333333333d);
    L7:
        return ((r2 * 903.2962962962963d) + 16.0d) / 116.0d;
    }
}
