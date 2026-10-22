package androidx.compose.material3.internal.colorUtil;

import androidx.camera.video.AudioStats;
import androidx.core.graphics.ColorUtils;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u001e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0016H\u0002J \u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014H\u0002J \u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0002J\u000e\u0010+\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020,J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0014J\u0010\u0010/\u001a\u00020,2\u0006\u0010\u001b\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u000e\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0014J\u000e\u00102\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016J\u0010\u00103\u001a\u00020,2\u0006\u0010\"\u001a\u00020\u0014H\u0002R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u00064"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/CamUtils;", "", "<init>", "()V", "XYZ_TO_CAM16RGB", "", "", "getXYZ_TO_CAM16RGB", "()[[F", "[[F", "CAM16RGB_TO_XYZ", "getCAM16RGB_TO_XYZ", "WHITE_POINT_D65", "getWHITE_POINT_D65", "()[F", "SRGB_TO_XYZ", "", "[[D", "XYZ_TO_SRGB", "signum", "", "num", "", "argbFromLstar", "lstar", "argbFromXyz", "x", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "argbFromLinrgbComponents", "r", ce.f26391f, "b", "delinearized", "rgbComponent", "clampInt", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "input", "argbFromRgb", "red", "green", "blue", "intFromLstar", "", "lstarFromInt", "argb", "lstarFromY", "yFromInt", "xyzFromInt", "yFromLstar", "linearized", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CamUtils {
    public static final int $stable = 0;
    private static final float[][] CAM16RGB_TO_XYZ = null;
    public static final CamUtils INSTANCE = null;
    private static final double[][] SRGB_TO_XYZ = null;
    private static final float[] WHITE_POINT_D65 = null;
    private static final float[][] XYZ_TO_CAM16RGB = null;
    private static final double[][] XYZ_TO_SRGB = null;

    private CamUtils() {
    }

    private final int argbFromRgb(int r100, int r101, int r102) {
        return ((((r100 & 255) << 16) | (-16777216)) | ((r101 & 255) << 8)) | (r102 & 255);
    }

    private final int clampInt(int r100, int r101, int r102) {
        if (r102 >= r100) goto L4;
        return r100;
    L4:
        if (r102 <= r101) goto L6;
        return r101;
    L6:
        return r102;
    }

    public final int signum(double r100) {
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return -1;
    L6:
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return 0;
    L13:
        return 1;
    L8:
        r101 = false;
        goto L9
    }

    static {
        INSTANCE = new CamUtils();
        XYZ_TO_CAM16RGB = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        CAM16RGB_TO_XYZ = new float[][]{new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
        WHITE_POINT_D65 = new float[]{95.047f, 100.0f, 108.883f};
        SRGB_TO_XYZ = new double[][]{new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
        XYZ_TO_SRGB = new double[][]{new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};
        $stable = 8;
    }

    public final float[][] getCAM16RGB_TO_XYZ() {
        return CAM16RGB_TO_XYZ;
    }

    public final float[] getWHITE_POINT_D65() {
        return WHITE_POINT_D65;
    }

    public final float[][] getXYZ_TO_CAM16RGB() {
        return XYZ_TO_CAM16RGB;
    }

    private final int delinearized(double r100) {
        double r101 = r100 / 100.0d;
        if (r101 > 0.0031308d) goto L5;
        double r102 = r101 * 12.92d;
    L7:
        return clampInt(0, 255, (int) Math.round(r102 * 255.0d));
    L5:
        r102 = (Math.pow(r101, 0.4166666666666667d) * 1.055d) - 0.055d;
        goto L7
    }

    private final float linearized(int r100) {
        float r101 = r100 / 255.0f;
        if (r101 > 0.04045f) goto L5;
        float r102 = r101 / 12.92f;
    L7:
        return r102 * 100.0f;
    L5:
        r102 = (float) Math.pow((r101 + 0.055f) / 1.055f, 2.4f);
        goto L7
    }

    private final float lstarFromY(float r100) {
        float r101 = r100 / 100.0f;
        if (r101 > 0.008856452f) goto L7;
        return r101 * 903.2963f;
    L7:
        return (((float) Math.cbrt(r101)) * 116.0f) - 16.0f;
    }

    private final float yFromInt(int r100) {
        float r101 = linearized((r100 >> 16) & 255);
        float r102 = linearized((r100 >> 8) & 255);
        float r103 = linearized(r100 & 255);
        double[] r104 = SRGB_TO_XYZ[1];
        return (float) (((((double) r101) * r104[0]) + (((double) r102) * r104[1])) + (((double) r103) * r104[2]));
    }

    public final int argbFromLstar(double r210) {
        double r100 = (r210 + 16.0d) / 116.0d;
        if (r210 <= 8.0d) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        double r102 = (r100 * r100) * r100;
    L10:
        double r103 = (r100 * r100) * r100;
        if (r103 <= 0.008856451679035631d) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        double r110 = r103;
    L17:
        if (r104 == true) goto L20;
        r103 = r210 / 903.2962962962963d;
    L20:
        float[] r105 = WHITE_POINT_D65;
        return argbFromXyz(r110 * ((double) r105[0]), r102 * ((double) r105[1]), r103 * ((double) r105[2]));
    L16:
        r110 = r210 / 903.2962962962963d;
        goto L17
    L13:
        r104 = false;
        goto L14
    L9:
        r102 = r210 / 903.2962962962963d;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public final int intFromLstar(float r110) {
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
        float r102 = (r100 * r100) * r100;
    L18:
        float r103 = (r100 * r100) * r100;
        if (r103 <= 0.008856452f) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L24;
        float r105 = r103;
    L25:
        if (r104 == true) goto L28;
        r103 = ((r100 * 116.0f) - 16.0f) / 903.2963f;
    L28:
        float[] r106 = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(r105 * r106[0], r102 * r106[1], r103 * r106[2]);
    L24:
        r105 = ((r100 * 116.0f) - 16.0f) / 903.2963f;
        goto L25
    L21:
        r104 = false;
        goto L22
    L17:
        r102 = r110 / 903.2963f;
        goto L18
    L13:
        r101 = false;
        goto L15
    }

    public final float lstarFromInt(int r100) {
        return lstarFromY(yFromInt(r100));
    }

    public final float[] xyzFromInt(int r110) {
        float r100 = linearized((r110 >> 16) & 255);
        float r101 = linearized((r110 >> 8) & 255);
        float r102 = linearized(r110 & 255);
        double[][] r103 = SRGB_TO_XYZ;
        double r104 = r100;
        double[] r105 = r103[0];
        double r111 = r101;
        double r112 = r102;
        double r106 = ((r105[0] * r104) + (r105[1] * r111)) + (r105[2] * r112);
        double[] r107 = r103[1];
        double r113 = ((r107[0] * r104) + (r107[1] * r111)) + (r107[2] * r112);
        double[] r108 = r103[2];
        return new float[]{(float) r106, (float) r113, (float) (((r104 * r108[0]) + (r111 * r108[1])) + (r112 * r108[2]))};
    }

    public final double yFromLstar(double r100) {
        if (r100 <= 8.0d) goto L5;
        double r101 = Math.pow((r100 + 16.0d) / 116.0d, 3.0d);
    L7:
        return r101 * 100.0d;
    L5:
        r101 = r100 / 903.2962962962963d;
        goto L7
    }

    private final int argbFromXyz(double r110, double r111, double r112) {
        double[][] r100 = XYZ_TO_SRGB;
        double[] r101 = r100[0];
        double r102 = ((r101[0] * r110) + (r101[1] * r111)) + (r101[2] * r112);
        double[] r103 = r100[1];
        double r104 = ((r103[0] * r110) + (r103[1] * r111)) + (r103[2] * r112);
        double[] r105 = r100[2];
        double r106 = ((r105[0] * r110) + (r105[1] * r111)) + (r105[2] * r112);
        return argbFromRgb(delinearized(r102), delinearized(r104), delinearized(r106));
    }

    public final int argbFromLinrgbComponents(double r100, double r101, double r102) {
        return argbFromRgb(delinearized(r100), delinearized(r101), delinearized(r102));
    }
}
