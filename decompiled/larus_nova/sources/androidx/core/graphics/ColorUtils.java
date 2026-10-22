package androidx.core.graphics;

import android.graphics.Color;
import androidx.camera.video.AudioStats;
import androidx.core.content.res.CamColor;
import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import java.util.Objects;
import t27.a;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = null;
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Color compositeColors(Color r100, Color r101) {
            if (Objects.equals(r100.getModel(), r101.getModel()) == false) goto L17;
            if (Objects.equals(r101.getColorSpace(), r100.getColorSpace()) == true) goto L8;
            r100 = r100.convert(r101.getColorSpace());
        L8:
            float[] r102 = r100.getComponents();
            float[] r103 = r101.getComponents();
            float r104 = r100.alpha();
            float r105 = r101.alpha() * (1.0f - r104);
            int r106 = r101.getComponentCount() - 1;
            float r107 = r104 + r105;
            r103[r106] = r107;
            if (r107 <= 0.0f) goto L11;
            r104 = r104 / r107;
            r105 = r105 / r107;
        L11:
            int r108 = 0;
        L12:
            if (r108 >= r106) goto L15;
            r103[r108] = (r102[r108] * r104) + (r103[r108] * r105);
            r108 = r108 + 1;
            goto L12
        L15:
            return Color.valueOf(r103, r101.getColorSpace());
        L17:
            throw new IllegalArgumentException("Color models must match (" + r100.getModel() + " vs. " + r101.getModel() + ")");
        }
    }

    private ColorUtils() {
    }

    public static void RGBToXYZ(int r100, int r101, int r102, double[] r103) {
        androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_RGBToXYZ(r100, r101, r102, r103);
    }

    public static void XYZToLAB(double r100, double r101, double r102, double[] r103) {
        androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_XYZToLAB(r100, r101, r102, r103);
    }

    public static void blendHSL(float[] r100, float[] r101, float r102, float[] r103) {
        androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_blendHSL(r100, r101, r102, r103);
    }

    public static void blendLAB(double[] r100, double[] r101, double r102, double[] r103) {
        androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_blendLAB(r100, r101, r102, r103);
    }

    public static double calculateContrast(int r100, int r101) {
        return androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_calculateContrast(r100, r101);
    }

    public static int calculateMinimumAlpha(int r100, int r101, float r102) {
        return androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_calculateMinimumAlpha(r100, r101, r102);
    }

    public static Color compositeColors(Color r100, Color r101) {
        return androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_compositeColors(r100, r101);
    }

    static {
        TEMP_ARRAY = new ThreadLocal();
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> r100 = TEMP_ARRAY;
        double[] r101 = r100.get();
        if (r101 != null) goto L6;
        double[] r102 = new double[3];
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }

    public static int HSLToColor(float[] r100) {
        float r101 = r100[0];
        float r102 = r100[1];
        float r103 = r100[2];
        float r104 = (1.0f - Math.abs((r103 * 2.0f) - 1.0f)) * r102;
        float r105 = r103 - (0.5f * r104);
        float r106 = (1.0f - Math.abs(((r101 / 60.0f) % 2.0f) - 1.0f)) * r104;
        switch((((int) r101) / 60)) {
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
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
    L12:
        return Color.rgb(constrain(r108, 0, 255), constrain(r109, 0, 255), constrain(r107, 0, 255));
    L5:
        r108 = Math.round((r104 + r105) * 255.0f);
        r109 = Math.round(r105 * 255.0f);
        r107 = Math.round((r106 + r105) * 255.0f);
        goto L12
    L6:
        r108 = Math.round((r106 + r105) * 255.0f);
        r109 = Math.round(r105 * 255.0f);
        r107 = Math.round((r104 + r105) * 255.0f);
        goto L12
    L7:
        r108 = Math.round(r105 * 255.0f);
        r109 = Math.round((r106 + r105) * 255.0f);
        r107 = Math.round((r104 + r105) * 255.0f);
        goto L12
    L8:
        r108 = Math.round(r105 * 255.0f);
        r109 = Math.round((r104 + r105) * 255.0f);
        r107 = Math.round((r106 + r105) * 255.0f);
        goto L12
    L9:
        r108 = Math.round((r106 + r105) * 255.0f);
        r109 = Math.round((r104 + r105) * 255.0f);
        r107 = Math.round(r105 * 255.0f);
        goto L12
    L10:
        r108 = Math.round((r104 + r105) * 255.0f);
        r109 = Math.round((r106 + r105) * 255.0f);
        r107 = Math.round(r105 * 255.0f);
        goto L12
    }

    public static double calculateLuminance(int r100) {
        double[] r101 = getTempDouble3Array();
        colorToXYZ(r100, r101);
        return r101[1] / 100.0d;
    }

    private static double pivotXyzComponent(double r100) {
        if (r100 <= XYZ_EPSILON) goto L6;
        return Math.pow(r100, 0.3333333333333333d);
    L6:
        return ((r100 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    public static double androidx_core_graphics_ColorUtils__calculateContrast$___twin___(int r100, int r101) {
        if (Color.alpha(r101) != 255) goto L10;
        if (Color.alpha(r100) >= 255) goto L7;
        r100 = compositeColors(r100, r101);
    L7:
        double r102 = calculateLuminance(r100) + 0.05d;
        double r103 = calculateLuminance(r101) + 0.05d;
        return Math.max(r102, r103) / Math.min(r102, r103);
    L10:
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(r101));
    }

    public static Color androidx_core_graphics_ColorUtils__compositeColors$___twin___(Color r100, Color r101) {
        return Api26Impl.compositeColors(r100, r101);
    }

    public static double androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_calculateContrast(int r100, int r101) {
        if (c.b() == false) goto L13;
        return androidx_core_graphics_ColorUtils__calculateContrast$___twin___(r100, r101);
    L6:
        th = move-exception;
        Double r102 = (Double) a.tryProtect(th, Double.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return r102.doubleValue();
    L13:
        return androidx_core_graphics_ColorUtils__calculateContrast$___twin___(r100, r101);
    }

    public static Color androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_compositeColors(Color r100, Color r101) {
        if (c.b() == false) goto L13;
        return androidx_core_graphics_ColorUtils__compositeColors$___twin___(r100, r101);
    L6:
        th = move-exception;
        Integer r102 = (Integer) a.tryProtect(th, Integer.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return Color.valueOf(r102.intValue());
    L13:
        return androidx_core_graphics_ColorUtils__compositeColors$___twin___(r100, r101);
    }

    public static void colorToHSL(int r100, float[] r101) {
        RGBToHSL(Color.red(r100), Color.green(r100), Color.blue(r100), r101);
    }

    public static void colorToLAB(int r100, double[] r101) {
        RGBToLAB(Color.red(r100), Color.green(r100), Color.blue(r100), r101);
    }

    public static void colorToM3HCT(int r100, float[] r101) {
        CamColor.getM3HCTfromColor(r100, r101);
    }

    public static void colorToXYZ(int r100, double[] r101) {
        RGBToXYZ(Color.red(r100), Color.green(r100), Color.blue(r100), r101);
    }

    private static int compositeAlpha(int r100, int r101) {
        return 255 - (((255 - r101) * (255 - r100)) / 255);
    }

    public static int compositeColors(int r100, int r101) {
        int r102 = Color.alpha(r101);
        int r103 = Color.alpha(r100);
        int r104 = compositeAlpha(r103, r102);
        return Color.argb(r104, compositeComponent(Color.red(r100), r103, Color.red(r101), r102, r104), compositeComponent(Color.green(r100), r103, Color.green(r101), r102, r104), compositeComponent(Color.blue(r100), r103, Color.blue(r101), r102, r104));
    }

    public static double distanceEuclidean(double[] r100, double[] r110) {
        return Math.sqrt((Math.pow(r100[0] - r110[0], 2.0d) + Math.pow(r100[1] - r110[1], 2.0d)) + Math.pow(r100[2] - r110[2], 2.0d));
    }

    public static int setAlphaComponent(int r100, int r101) {
        if (r101 < 0) goto L8;
        if (r101 > 255) goto L8;
        return (r100 & 16777215) | (r101 << 24);
    L8:
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static int LABToColor(double r100, double r110, double r111) {
        double[] r101 = getTempDouble3Array();
        LABToXYZ(r100, r110, r111, r101);
        return XYZToColor(r101[0], r101[1], r101[2]);
    }

    public static int M3HCTToColor(float r100, float r101, float r102) {
        return CamColor.toColor(r100, r101, r102);
    }

    public static int XYZToColor(double r110, double r111, double r210) {
        double r100 = (((3.2406d * r110) + ((-1.5372d) * r111)) + ((-0.4986d) * r210)) / 100.0d;
        double r101 = ((((-0.9689d) * r110) + (1.8758d * r111)) + (0.0415d * r210)) / 100.0d;
        double r102 = (((0.0557d * r110) + ((-0.204d) * r111)) + (1.057d * r210)) / 100.0d;
        if (r100 <= 0.0031308d) goto L5;
        double r103 = (Math.pow(r100, 0.4166666666666667d) * 1.055d) - 0.055d;
    L7:
        if (r101 <= 0.0031308d) goto L9;
        double r104 = (Math.pow(r101, 0.4166666666666667d) * 1.055d) - 0.055d;
    L11:
        if (r102 <= 0.0031308d) goto L13;
        double r105 = (Math.pow(r102, 0.4166666666666667d) * 1.055d) - 0.055d;
    L15:
        return Color.rgb(constrain((int) Math.round(r103 * 255.0d), 0, 255), constrain((int) Math.round(r104 * 255.0d), 0, 255), constrain((int) Math.round(r105 * 255.0d), 0, 255));
    L13:
        r105 = r102 * 12.92d;
        goto L15
    L9:
        r104 = r101 * 12.92d;
        goto L11
    L5:
        r103 = r100 * 12.92d;
        goto L7
    }

    public static int androidx_core_graphics_ColorUtils__calculateMinimumAlpha$___twin___(int r100, int r101, float r110) {
        int r102 = 255;
        if (Color.alpha(r101) != 255) goto L20;
        double r103 = r110;
        if (calculateContrast(setAlphaComponent(r100, 255), r101) >= r103) goto L8;
        return -1;
    L8:
        int r111 = 0;
        int r104 = 0;
    L10:
        if (r111 > 10) goto L18;
        if ((r102 - r104) <= 1) goto L18;
        int r105 = (r104 + r102) / 2;
        if (calculateContrast(setAlphaComponent(r100, r105), r101) >= r103) goto L16;
        r104 = r105;
    L17:
        r111 = r111 + 1;
        goto L10
    L16:
        r102 = r105;
    L18:
        return r102;
    L20:
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(r101));
    }

    public static int androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_calculateMinimumAlpha(int r100, int r101, float r102) {
        if (c.b() == false) goto L13;
        return androidx_core_graphics_ColorUtils__calculateMinimumAlpha$___twin___(r100, r101, r102);
    L6:
        th = move-exception;
        Integer r103 = (Integer) a.tryProtect(th, Integer.class);
        if (r103 != null) goto L10;
        throw th;
    L10:
        return r103.intValue();
    L13:
        return androidx_core_graphics_ColorUtils__calculateMinimumAlpha$___twin___(r100, r101, r102);
    }

    public static int blendARGB(int r100, int r101, float r102) {
        float r103 = 1.0f - r102;
        return Color.argb((int) ((Color.alpha(r100) * r103) + (Color.alpha(r101) * r102)), (int) ((Color.red(r100) * r103) + (Color.red(r101) * r102)), (int) ((Color.green(r100) * r103) + (Color.green(r101) * r102)), (int) ((Color.blue(r100) * r103) + (Color.blue(r101) * r102)));
    }

    public static float circularInterpolate(float r100, float r101, float r102) {
        if (Math.abs(r101 - r100) <= 180.0f) goto L9;
        if (r101 <= r100) goto L7;
        r100 = r100 + 360.0f;
        goto L9
    L7:
        r101 = r101 + 360.0f;
    L9:
        return (r100 + ((r101 - r100) * r102)) % 360.0f;
    }

    private static float constrain(float r100, float r101, float r102) {
        if (r100 >= r101) goto L6;
        return r101;
    L6:
        return Math.min(r100, r102);
    }

    private static int constrain(int r100, int r101, int r102) {
        if (r100 >= r101) goto L5;
        return r101;
    L5:
        return Math.min(r100, r102);
    }

    public static void LABToXYZ(double r110, double r210, double r211, double[] r212) {
        double r100 = (r110 + 16.0d) / 116.0d;
        double r101 = (r210 / 500.0d) + r100;
        double r102 = r100 - (r211 / 200.0d);
        double r111 = Math.pow(r101, 3.0d);
        if (r111 > XYZ_EPSILON) goto L7;
        r111 = ((r101 * 116.0d) - 16.0d) / XYZ_KAPPA;
    L7:
        if (r110 <= 7.9996247999999985d) goto L9;
        double r103 = Math.pow(r100, 3.0d);
    L10:
        double r104 = Math.pow(r102, 3.0d);
        if (r104 > XYZ_EPSILON) goto L14;
        r104 = ((r102 * 116.0d) - 16.0d) / XYZ_KAPPA;
    L14:
        r212[0] = r111 * XYZ_WHITE_REFERENCE_X;
        r212[1] = r103 * 100.0d;
        r212[2] = r104 * XYZ_WHITE_REFERENCE_Z;
        return;
    L9:
        r103 = r110 / XYZ_KAPPA;
        goto L10
    }

    public static void RGBToHSL(int r100, int r101, int r102, float[] r110) {
        float r103 = r100 / 255.0f;
        float r104 = r101 / 255.0f;
        float r105 = r102 / 255.0f;
        float r106 = Math.max(r103, Math.max(r104, r105));
        float r107 = Math.min(r103, Math.min(r104, r105));
        float r108 = r106 - r107;
        float r109 = (r106 + r107) / 2.0f;
        if (r106 != r107) goto L6;
        float r111 = 0.0f;
        float r112 = 0.0f;
    L13:
        float r113 = (r111 * 60.0f) % 360.0f;
        if (r113 >= 0.0f) goto L16;
        r113 = r113 + 360.0f;
    L16:
        r110[0] = constrain(r113, 0.0f, 360.0f);
        r110[1] = constrain(r112, 0.0f, 1.0f);
        r110[2] = constrain(r109, 0.0f, 1.0f);
        return;
    L6:
        if (r106 != r103) goto L9;
        r111 = ((r104 - r105) / r108) % 6.0f;
    L12:
        r112 = r108 / (1.0f - Math.abs((2.0f * r109) - 1.0f));
        goto L13
    L9:
        if (r106 != r104) goto L11;
        r111 = ((r105 - r103) / r108) + 2.0f;
        goto L12
    L11:
        r111 = 4.0f + ((r103 - r104) / r108);
        goto L12
    }

    public static void RGBToLAB(int r100, int r101, int r102, double[] r110) {
        RGBToXYZ(r100, r101, r102, r110);
        XYZToLAB(r110[0], r110[1], r110[2], r110);
    }

    public static void androidx_core_graphics_ColorUtils__RGBToXYZ$___twin___(int r110, int r111, int r112, double[] r113) {
        if (r113.length != 3) goto L19;
        double r100 = ((double) r110) / 255.0d;
        if (r100 >= 0.04045d) goto L7;
        double r101 = r100 / 12.92d;
    L8:
        double r102 = ((double) r111) / 255.0d;
        if (r102 >= 0.04045d) goto L11;
        double r103 = r102 / 12.92d;
    L12:
        double r104 = ((double) r112) / 255.0d;
        if (r104 >= 0.04045d) goto L15;
        double r105 = r104 / 12.92d;
    L16:
        r113[0] = (((0.4124d * r101) + (0.3576d * r103)) + (0.1805d * r105)) * 100.0d;
        r113[1] = (((0.2126d * r101) + (0.7152d * r103)) + (0.0722d * r105)) * 100.0d;
        r113[2] = (((r101 * 0.0193d) + (r103 * 0.1192d)) + (r105 * 0.9505d)) * 100.0d;
        return;
    L15:
        r105 = Math.pow((r104 + 0.055d) / 1.055d, 2.4d);
        goto L16
    L11:
        r103 = Math.pow((r102 + 0.055d) / 1.055d, 2.4d);
        goto L12
    L7:
        r101 = Math.pow((r100 + 0.055d) / 1.055d, 2.4d);
        goto L8
    L19:
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static void androidx_core_graphics_ColorUtils__XYZToLAB$___twin___(double r100, double r101, double r102, double[] r110) {
        if (r110.length != 3) goto L7;
        double r103 = pivotXyzComponent(r100 / XYZ_WHITE_REFERENCE_X);
        double r104 = pivotXyzComponent(r101 / 100.0d);
        double r105 = pivotXyzComponent(r102 / XYZ_WHITE_REFERENCE_Z);
        r110[0] = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, (116.0d * r104) - 16.0d);
        r110[1] = (r103 - r104) * 500.0d;
        r110[2] = (r104 - r105) * 200.0d;
        return;
    L7:
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    public static void androidx_core_graphics_ColorUtils__blendHSL$___twin___(float[] r100, float[] r101, float r102, float[] r103) {
        if (r103.length != 3) goto L7;
        float r104 = 1.0f - r102;
        r103[0] = circularInterpolate(r100[0], r101[0], r102);
        r103[1] = (r100[1] * r104) + (r101[1] * r102);
        r103[2] = (r100[2] * r104) + (r101[2] * r102);
        return;
    L7:
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void androidx_core_graphics_ColorUtils__blendLAB$___twin___(double[] r100, double[] r101, double r102, double[] r110) {
        if (r110.length != 3) goto L7;
        double r103 = 1.0d - r102;
        r110[0] = (r100[0] * r103) + (r101[0] * r102);
        r110[1] = (r100[1] * r103) + (r101[1] * r102);
        r110[2] = (r100[2] * r103) + (r101[2] * r102);
        return;
    L7:
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static void androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_RGBToXYZ(int r100, int r101, int r102, double[] r103) {
        if (c.b() == true) goto L13;
    L11:
        androidx_core_graphics_ColorUtils__RGBToXYZ$___twin___(r100, r101, r102, r103);
        return;
    L13:
        androidx_core_graphics_ColorUtils__RGBToXYZ$___twin___(r100, r101, r102, r103);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        if (c.a(ProtectorType.CAST_COLOR, th) == null) goto L10;
        return;
    L10:
        throw th;
    }

    public static void androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_XYZToLAB(double r100, double r101, double r102, double[] r103) {
        if (c.b() == true) goto L13;
    L11:
        androidx_core_graphics_ColorUtils__XYZToLAB$___twin___(r100, r101, r102, r103);
        return;
    L13:
        androidx_core_graphics_ColorUtils__XYZToLAB$___twin___(r100, r101, r102, r103);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        if (c.a(ProtectorType.CAST_COLOR, th) == null) goto L10;
        return;
    L10:
        throw th;
    }

    public static void androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_blendHSL(float[] r100, float[] r101, float r102, float[] r103) {
        if (c.b() == true) goto L13;
    L11:
        androidx_core_graphics_ColorUtils__blendHSL$___twin___(r100, r101, r102, r103);
        return;
    L13:
        androidx_core_graphics_ColorUtils__blendHSL$___twin___(r100, r101, r102, r103);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        if (c.a(ProtectorType.CAST_COLOR, th) == null) goto L10;
        return;
    L10:
        throw th;
    }

    public static void androidx_core_graphics_ColorUtils_com_bytedance_mt_protector_impl_color_ColorUtilsLancet_blendLAB(double[] r100, double[] r101, double r102, double[] r103) {
        if (c.b() == true) goto L13;
    L11:
        androidx_core_graphics_ColorUtils__blendLAB$___twin___(r100, r101, r102, r103);
        return;
    L13:
        androidx_core_graphics_ColorUtils__blendLAB$___twin___(r100, r101, r102, r103);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        if (c.a(ProtectorType.CAST_COLOR, th) == null) goto L10;
        return;
    L10:
        throw th;
    }

    private static int compositeComponent(int r100, int r101, int r102, int r103, int r104) {
        if (r104 != 0) goto L6;
        return 0;
    L6:
        return (((r100 * 255) * r101) + ((r102 * r103) * (255 - r101))) / (r104 * 255);
    }
}
