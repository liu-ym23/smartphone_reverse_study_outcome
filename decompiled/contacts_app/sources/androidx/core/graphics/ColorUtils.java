package androidx.core.graphics;

import android.graphics.Color;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = null;
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    static class Api26Impl {
        private Api26Impl() {
        }

        static Color compositeColors(Color r7, Color r8) {
            if (Objects.equals(r7.getModel(), r8.getModel()) == false) goto L17;
            if (Objects.equals(r8.getColorSpace(), r7.getColorSpace()) == true) goto L8;
            r7 = r7.convert(r8.getColorSpace());
        L8:
            float[] r0 = r7.getComponents();
            float[] r1 = r8.getComponents();
            float r9 = r7.alpha();
            float r2 = r8.alpha() * (1.0f - r9);
            int r3 = r8.getComponentCount() - 1;
            float r4 = r9 + r2;
            r1[r3] = r4;
            if (r4 <= 0.0f) goto L11;
            r9 = r9 / r4;
            r2 = r2 / r4;
        L11:
            int r5 = 0;
        L12:
            if (r5 >= r3) goto L15;
            r1[r5] = (r0[r5] * r9) + (r1[r5] * r2);
            r5 = r5 + 1;
            goto L12
        L15:
            return Color.valueOf(r1, r8.getColorSpace());
        L17:
            throw new IllegalArgumentException("Color models must match (" + r7.getModel() + " vs. " + r8.getModel() + ")");
        }
    }

    static {
        TEMP_ARRAY = new ThreadLocal();
    }

    private ColorUtils() {
    }

    public static int compositeColors(int r6, int r7) {
        int r0 = Color.alpha(r7);
        int r1 = Color.alpha(r6);
        int r2 = compositeAlpha(r1, r0);
        return Color.argb(r2, compositeComponent(Color.red(r6), r1, Color.red(r7), r0, r2), compositeComponent(Color.green(r6), r1, Color.green(r7), r0, r2), compositeComponent(Color.blue(r6), r1, Color.blue(r7), r0, r2));
    }

    public static Color compositeColors(Color r0, Color r1) {
        return Api26Impl.compositeColors(r0, r1);
    }

    private static int compositeAlpha(int r0, int r1) {
        return 255 - (((255 - r1) * (255 - r0)) / 255);
    }

    private static int compositeComponent(int r0, int r1, int r2, int r3, int r4) {
        if (r4 != 0) goto L6;
        return 0;
    L6:
        return (((r0 * 255) * r1) + ((r2 * r3) * (255 - r1))) / (r4 * 255);
    }

    public static double calculateLuminance(int r4) {
        double[] r0 = getTempDouble3Array();
        colorToXYZ(r4, r0);
        return r0[1] / 100.0d;
    }

    public static double calculateContrast(int r4, int r5) {
        if (Color.alpha(r5) != 255) goto L10;
        if (Color.alpha(r4) >= 255) goto L7;
        r4 = compositeColors(r4, r5);
    L7:
        double r0 = calculateLuminance(r4) + 0.05d;
        double r6 = calculateLuminance(r5) + 0.05d;
        return Math.max(r0, r6) / Math.min(r0, r6);
    L10:
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(r5));
    }

    public static int calculateMinimumAlpha(int r8, int r9, float r10) {
        int r1 = 255;
        if (Color.alpha(r9) != 255) goto L20;
        double r4 = r10;
        if (calculateContrast(setAlphaComponent(r8, 255), r9) >= r4) goto L8;
        return -1;
    L8:
        int r11 = 0;
        int r0 = 0;
    L10:
        if (r11 > 10) goto L18;
        if ((r1 - r0) <= 1) goto L18;
        int r2 = (r0 + r1) / 2;
        if (calculateContrast(setAlphaComponent(r8, r2), r9) >= r4) goto L16;
        r0 = r2;
    L17:
        r11 = r11 + 1;
        goto L10
    L16:
        r1 = r2;
    L18:
        return r1;
    L20:
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(r9));
    }

    public static void RGBToHSL(int r7, int r8, int r9, float[] r10) {
        float r11 = r7 / 255.0f;
        float r12 = r8 / 255.0f;
        float r13 = r9 / 255.0f;
        float r0 = Math.max(r11, Math.max(r12, r13));
        float r1 = Math.min(r11, Math.min(r12, r13));
        float r2 = r0 - r1;
        float r3 = (r0 + r1) / 2.0f;
        if (r0 != r1) goto L6;
        float r14 = 0.0f;
        float r4 = 0.0f;
    L13:
        float r15 = (r14 * 60.0f) % 360.0f;
        if (r15 >= 0.0f) goto L16;
        r15 = r15 + 360.0f;
    L16:
        r10[0] = constrain(r15, 0.0f, 360.0f);
        r10[1] = constrain(r4, 0.0f, 1.0f);
        r10[2] = constrain(r3, 0.0f, 1.0f);
        return;
    L6:
        if (r0 != r11) goto L9;
        r14 = ((r12 - r13) / r2) % 6.0f;
    L12:
        r4 = r2 / (1.0f - Math.abs((2.0f * r3) - 1.0f));
        goto L13
    L9:
        if (r0 != r12) goto L11;
        r14 = ((r13 - r11) / r2) + 2.0f;
        goto L12
    L11:
        r14 = 4.0f + ((r11 - r12) / r2);
        goto L12
    }

    public static void colorToHSL(int r2, float[] r3) {
        RGBToHSL(Color.red(r2), Color.green(r2), Color.blue(r2), r3);
    }

    public static int HSLToColor(float[] r6) {
        float r1 = r6[0];
        float r2 = r6[1];
        float r7 = r6[2];
        float r4 = (1.0f - Math.abs((r7 * 2.0f) - 1.0f)) * r2;
        float r8 = r7 - (0.5f * r4);
        float r5 = (1.0f - Math.abs(((r1 / 60.0f) % 2.0f) - 1.0f)) * r4;
        switch((((int) r1) / 60)) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        int r9 = 0;
        int r3 = 0;
        int r10 = 0;
    L12:
        return Color.rgb(constrain(r3, 0, 255), constrain(r10, 0, 255), constrain(r9, 0, 255));
    L5:
        r3 = Math.round((r4 + r8) * 255.0f);
        r10 = Math.round(r8 * 255.0f);
        r9 = Math.round((r5 + r8) * 255.0f);
        goto L12
    L6:
        r3 = Math.round((r5 + r8) * 255.0f);
        r10 = Math.round(r8 * 255.0f);
        r9 = Math.round((r4 + r8) * 255.0f);
        goto L12
    L7:
        r3 = Math.round(r8 * 255.0f);
        r10 = Math.round((r5 + r8) * 255.0f);
        r9 = Math.round((r4 + r8) * 255.0f);
        goto L12
    L8:
        r3 = Math.round(r8 * 255.0f);
        r10 = Math.round((r4 + r8) * 255.0f);
        r9 = Math.round((r5 + r8) * 255.0f);
        goto L12
    L9:
        r3 = Math.round((r5 + r8) * 255.0f);
        r10 = Math.round((r4 + r8) * 255.0f);
        r9 = Math.round(r8 * 255.0f);
        goto L12
    L10:
        r3 = Math.round((r4 + r8) * 255.0f);
        r10 = Math.round((r5 + r8) * 255.0f);
        r9 = Math.round(r8 * 255.0f);
        goto L12
    }

    public static int setAlphaComponent(int r1, int r2) {
        if (r2 < 0) goto L8;
        if (r2 > 255) goto L8;
        return (r1 & 16777215) | (r2 << 24);
    L8:
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static void colorToLAB(int r2, double[] r3) {
        RGBToLAB(Color.red(r2), Color.green(r2), Color.blue(r2), r3);
    }

    public static void RGBToLAB(int r7, int r8, int r9, double[] r10) {
        RGBToXYZ(r7, r8, r9, r10);
        XYZToLAB(r10[0], r10[1], r10[2], r10);
    }

    public static void colorToXYZ(int r2, double[] r3) {
        RGBToXYZ(Color.red(r2), Color.green(r2), Color.blue(r2), r3);
    }

    public static void RGBToXYZ(int r16, int r17, int r18, double[] r19) {
        if (r19.length != 3) goto L19;
        double r1 = ((double) r16) / 255.0d;
        if (r1 >= 0.04045d) goto L7;
        double r2 = r1 / 12.92d;
    L8:
        double r10 = ((double) r17) / 255.0d;
        if (r10 >= 0.04045d) goto L11;
        double r11 = r10 / 12.92d;
    L12:
        double r12 = ((double) r18) / 255.0d;
        if (r12 >= 0.04045d) goto L15;
        double r13 = r12 / 12.92d;
    L16:
        r19[0] = (((0.4124d * r2) + (0.3576d * r11)) + (0.1805d * r13)) * 100.0d;
        r19[1] = (((0.2126d * r2) + (0.7152d * r11)) + (0.0722d * r13)) * 100.0d;
        r19[2] = (((r2 * 0.0193d) + (r11 * 0.1192d)) + (r13 * 0.9505d)) * 100.0d;
        return;
    L15:
        r13 = Math.pow((r12 + 0.055d) / 1.055d, 2.4d);
        goto L16
    L11:
        r11 = Math.pow((r10 + 0.055d) / 1.055d, 2.4d);
        goto L12
    L7:
        r2 = Math.pow((r1 + 0.055d) / 1.055d, 2.4d);
        goto L8
    L19:
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static void XYZToLAB(double r4, double r6, double r8, double[] r10) {
        if (r10.length != 3) goto L7;
        double r5 = pivotXyzComponent(r4 / XYZ_WHITE_REFERENCE_X);
        double r7 = pivotXyzComponent(r6 / 100.0d);
        double r9 = pivotXyzComponent(r8 / XYZ_WHITE_REFERENCE_Z);
        r10[0] = Math.max(0.0d, (116.0d * r7) - 16.0d);
        r10[1] = (r5 - r7) * 500.0d;
        r10[2] = (r7 - r9) * 200.0d;
        return;
    L7:
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    public static void LABToXYZ(double r19, double r21, double r23, double[] r25) {
        double r2 = (r19 + 16.0d) / 116.0d;
        double r6 = (r21 / 500.0d) + r2;
        double r8 = r2 - (r23 / 200.0d);
        double r12 = Math.pow(r6, 3.0d);
        if (r12 > XYZ_EPSILON) goto L7;
        r12 = ((r6 * 116.0d) - 16.0d) / XYZ_KAPPA;
    L7:
        if (r19 <= 7.9996247999999985d) goto L9;
        double r3 = Math.pow(r2, 3.0d);
    L10:
        double r7 = Math.pow(r8, 3.0d);
        if (r7 > XYZ_EPSILON) goto L14;
        r7 = ((r8 * 116.0d) - 16.0d) / XYZ_KAPPA;
    L14:
        r25[0] = r12 * XYZ_WHITE_REFERENCE_X;
        r25[1] = r3 * 100.0d;
        r25[2] = r7 * XYZ_WHITE_REFERENCE_Z;
        return;
    L9:
        r3 = r19 / XYZ_KAPPA;
        goto L10
    }

    public static int XYZToColor(double r17, double r19, double r21) {
        double r0 = (((3.2406d * r17) + ((-1.5372d) * r19)) + ((-0.4986d) * r21)) / 100.0d;
        double r4 = ((((-0.9689d) * r17) + (1.8758d * r19)) + (0.0415d * r21)) / 100.0d;
        double r6 = (((0.0557d * r17) + ((-0.204d) * r19)) + (1.057d * r21)) / 100.0d;
        if (r0 <= 0.0031308d) goto L5;
        double r1 = (Math.pow(r0, 0.4166666666666667d) * 1.055d) - 0.055d;
    L7:
        if (r4 <= 0.0031308d) goto L9;
        double r5 = (Math.pow(r4, 0.4166666666666667d) * 1.055d) - 0.055d;
    L11:
        if (r6 <= 0.0031308d) goto L13;
        double r2 = (Math.pow(r6, 0.4166666666666667d) * 1.055d) - 0.055d;
    L15:
        return Color.rgb(constrain((int) Math.round(r1 * 255.0d), 0, 255), constrain((int) Math.round(r5 * 255.0d), 0, 255), constrain((int) Math.round(r2 * 255.0d), 0, 255));
    L13:
        r2 = r6 * 12.92d;
        goto L15
    L9:
        r5 = r4 * 12.92d;
        goto L11
    L5:
        r1 = r0 * 12.92d;
        goto L7
    }

    public static int LABToColor(double r8, double r10, double r12) {
        double[] r7 = getTempDouble3Array();
        LABToXYZ(r8, r10, r12, r7);
        return XYZToColor(r7[0], r7[1], r7[2]);
    }

    public static double distanceEuclidean(double[] r9, double[] r10) {
        return Math.sqrt((Math.pow(r9[0] - r10[0], 2.0d) + Math.pow(r9[1] - r10[1], 2.0d)) + Math.pow(r9[2] - r10[2], 2.0d));
    }

    private static float constrain(float r1, float r2, float r3) {
        if (r1 >= r2) goto L6;
        return r2;
    L6:
        return Math.min(r1, r3);
    }

    private static int constrain(int r0, int r1, int r2) {
        if (r0 >= r1) goto L5;
        return r1;
    L5:
        return Math.min(r0, r2);
    }

    private static double pivotXyzComponent(double r2) {
        if (r2 <= XYZ_EPSILON) goto L6;
        return Math.pow(r2, 0.3333333333333333d);
    L6:
        return ((r2 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    public static int blendARGB(int r5, int r6, float r7) {
        float r0 = 1.0f - r7;
        return Color.argb((int) ((Color.alpha(r5) * r0) + (Color.alpha(r6) * r7)), (int) ((Color.red(r5) * r0) + (Color.red(r6) * r7)), (int) ((Color.green(r5) * r0) + (Color.green(r6) * r7)), (int) ((Color.blue(r5) * r0) + (Color.blue(r6) * r7)));
    }

    public static void blendHSL(float[] r4, float[] r5, float r6, float[] r7) {
        if (r7.length != 3) goto L7;
        float r0 = 1.0f - r6;
        r7[0] = circularInterpolate(r4[0], r5[0], r6);
        r7[1] = (r4[1] * r0) + (r5[1] * r6);
        r7[2] = (r4[2] * r0) + (r5[2] * r6);
        return;
    L7:
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(double[] r7, double[] r8, double r9, double[] r11) {
        if (r11.length != 3) goto L7;
        double r0 = 1.0d - r9;
        r11[0] = (r7[0] * r0) + (r8[0] * r9);
        r11[1] = (r7[1] * r0) + (r8[1] * r9);
        r11[2] = (r7[2] * r0) + (r8[2] * r9);
        return;
    L7:
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    static float circularInterpolate(float r2, float r3, float r4) {
        if (Math.abs(r3 - r2) <= 180.0f) goto L9;
        if (r3 <= r2) goto L7;
        r2 = r2 + 360.0f;
        goto L9
    L7:
        r3 = r3 + 360.0f;
    L9:
        return (r2 + ((r3 - r2) * r4)) % 360.0f;
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> r0 = TEMP_ARRAY;
        double[] r1 = r0.get();
        if (r1 != null) goto L6;
        double[] r2 = new double[3];
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }
}
