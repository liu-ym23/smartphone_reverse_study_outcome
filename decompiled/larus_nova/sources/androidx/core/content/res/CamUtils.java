package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes17.dex */
final class CamUtils {
    static final float[][] CAM16RGB_TO_XYZ = null;
    static final float[][] SRGB_TO_XYZ = null;
    static final float[] WHITE_POINT_D65 = null;
    static final float[][] XYZ_TO_CAM16RGB = null;

    static {
        XYZ_TO_CAM16RGB = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        CAM16RGB_TO_XYZ = new float[][]{new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
        WHITE_POINT_D65 = new float[]{95.047f, 100.0f, 108.883f};
        SRGB_TO_XYZ = new float[][]{new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    }

    public static float lerp(float r100, float r101, float r102) {
        return r100 + ((r101 - r100) * r102);
    }

    private CamUtils() {
    }

    public static int intFromLStar(float r110) {
        if (r110 >= 1.0f) goto L7;
        return -16777216;
    L7:
        if (r110 <= 99.0f) goto L10;
        return -1;
    L10:
        float r100 = (r110 + 16.0f) / 116.0f;
        if (r110 <= 8.0f) goto L13;
        boolean r101 = true;
    L15:
        if (r101 == false) goto L17;
        float r111 = (r100 * r100) * r100;
    L18:
        float r102 = (r100 * r100) * r100;
        if (r102 <= 0.008856452f) goto L21;
        boolean r103 = true;
    L22:
        if (r103 == false) goto L24;
        float r104 = r102;
    L25:
        if (r103 == true) goto L28;
        r102 = ((r100 * 116.0f) - 16.0f) / 903.2963f;
    L28:
        float[] r105 = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(r104 * r105[0], r111 * r105[1], r102 * r105[2]);
    L24:
        r104 = ((r100 * 116.0f) - 16.0f) / 903.2963f;
        goto L25
    L21:
        r103 = false;
        goto L22
    L17:
        r111 = r110 / 903.2963f;
        goto L18
    L13:
        r101 = false;
        goto L15
    }

    public static float lStarFromInt(int r100) {
        return lStarFromY(yFromInt(r100));
    }

    public static float lStarFromY(float r100) {
        float r101 = r100 / 100.0f;
        if (r101 > 0.008856452f) goto L7;
        return r101 * 903.2963f;
    L7:
        return (((float) Math.cbrt(r101)) * 116.0f) - 16.0f;
    }

    public static float linearized(int r100) {
        float r101 = r100 / 255.0f;
        if (r101 > 0.04045f) goto L7;
        float r102 = r101 / 12.92f;
    L6:
        return r102 * 100.0f;
    L7:
        r102 = (float) Math.pow((r101 + 0.055f) / 1.055f, 2.4000000953674316d);
        goto L6
    }

    public static float yFromInt(int r100) {
        float r101 = linearized(Color.red(r100));
        float r102 = linearized(Color.green(r100));
        float r103 = linearized(Color.blue(r100));
        float[] r104 = SRGB_TO_XYZ[1];
        return ((r101 * r104[0]) + (r102 * r104[1])) + (r103 * r104[2]);
    }

    public static float yFromLStar(float r100) {
        if (r100 <= 8.0f) goto L7;
        float r101 = (float) Math.pow((((double) r100) + 16.0d) / 116.0d, 3.0d);
    L6:
        return r101 * 100.0f;
    L7:
        r101 = r100 / 903.2963f;
        goto L6
    }

    public static void xyzFromInt(int r100, float[] r110) {
        float r101 = linearized(Color.red(r100));
        float r102 = linearized(Color.green(r100));
        float r103 = linearized(Color.blue(r100));
        float[][] r104 = SRGB_TO_XYZ;
        float[] r105 = r104[0];
        r110[0] = ((r105[0] * r101) + (r105[1] * r102)) + (r105[2] * r103);
        float[] r106 = r104[1];
        r110[1] = ((r106[0] * r101) + (r106[1] * r102)) + (r106[2] * r103);
        float[] r107 = r104[2];
        r110[2] = ((r101 * r107[0]) + (r102 * r107[1])) + (r103 * r107[2]);
    }
}
