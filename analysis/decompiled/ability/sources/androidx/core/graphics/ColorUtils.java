package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ScatterMapKt;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Color compositeColors(Color color, Color color2) {
            if (!Objects.equals(color.getModel(), color2.getModel())) {
                throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
            }
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float fAlpha = color.alpha();
            float fAlpha2 = (1.0f - fAlpha) * color2.alpha();
            int componentCount = color2.getComponentCount() - 1;
            float f = fAlpha + fAlpha2;
            components2[componentCount] = f;
            if (f > 0.0f) {
                fAlpha /= f;
                fAlpha2 /= f;
            }
            for (int i = 0; i < componentCount; i++) {
                components2[i] = (components2[i] * fAlpha2) + (components[i] * fAlpha);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f = fArr[0];
        float f7 = fArr[1];
        float f9 = fArr[2];
        float fAbs = (1.0f - Math.abs((f9 * 2.0f) - 1.0f)) * f7;
        float f10 = f9 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f) / 60) {
            case 0:
                iRound = Math.round((fAbs + f10) * 255.0f);
                iRound2 = Math.round((fAbs2 + f10) * 255.0f);
                iRound3 = Math.round(f10 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f10) * 255.0f);
                iRound2 = Math.round((fAbs + f10) * 255.0f);
                iRound3 = Math.round(f10 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f10 * 255.0f);
                iRound2 = Math.round((fAbs + f10) * 255.0f);
                iRound3 = Math.round((fAbs2 + f10) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f10 * 255.0f);
                iRound2 = Math.round((fAbs2 + f10) * 255.0f);
                iRound3 = Math.round((fAbs + f10) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f10) * 255.0f);
                iRound2 = Math.round(f10 * 255.0f);
                iRound3 = Math.round((fAbs + f10) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f10) * 255.0f);
                iRound2 = Math.round(f10 * 255.0f);
                iRound3 = Math.round((fAbs2 + f10) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(constrain(iRound, 0, 255), constrain(iRound2, 0, 255), constrain(iRound3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d, @FloatRange(from = -128.0d, to = 127.0d) double d6, @FloatRange(from = -128.0d, to = 127.0d) double d10) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d6, d10, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d, @FloatRange(from = -128.0d, to = 127.0d) double d6, @FloatRange(from = -128.0d, to = 127.0d) double d10, double[] dArr) {
        double d11 = (d + 16.0d) / 116.0d;
        double d12 = (d6 / 500.0d) + d11;
        double d13 = d11 - (d10 / 200.0d);
        double dPow = Math.pow(d12, 3.0d);
        if (dPow <= XYZ_EPSILON) {
            dPow = ((d12 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double dPow2 = d > 7.9996247999999985d ? Math.pow(d11, 3.0d) : d / XYZ_KAPPA;
        double dPow3 = Math.pow(d13, 3.0d);
        if (dPow3 <= XYZ_EPSILON) {
            dPow3 = ((d13 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = dPow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = dPow2 * 100.0d;
        dArr[2] = dPow3 * XYZ_WHITE_REFERENCE_Z;
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f7, @FloatRange(from = 0.0d, to = 100.0d) float f9) {
        return CamColor.toColor(f, f7, f9);
    }

    public static void RGBToHSL(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i6, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i10, float[] fArr) {
        float f;
        float fAbs;
        float f7 = i / 255.0f;
        float f9 = i6 / 255.0f;
        float f10 = i10 / 255.0f;
        float fMax = Math.max(f7, Math.max(f9, f10));
        float fMin = Math.min(f7, Math.min(f9, f10));
        float f11 = fMax - fMin;
        float f12 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f = 0.0f;
            fAbs = 0.0f;
        } else {
            f = fMax == f7 ? ((f9 - f10) / f11) % 6.0f : fMax == f9 ? ((f10 - f7) / f11) + 2.0f : 4.0f + ((f7 - f9) / f11);
            fAbs = f11 / (1.0f - Math.abs((2.0f * f12) - 1.0f));
        }
        float f13 = (f * 60.0f) % 360.0f;
        if (f13 < 0.0f) {
            f13 += 360.0f;
        }
        fArr[0] = constrain(f13, 0.0f, 360.0f);
        fArr[1] = constrain(fAbs, 0.0f, 1.0f);
        fArr[2] = constrain(f12, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i6, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i10, double[] dArr) {
        RGBToXYZ(i, i6, i10, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i6, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i10, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = i / 255.0d;
        double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d6 = i6 / 255.0d;
        double dPow2 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        double d10 = i10 / 255.0d;
        double dPow3 = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
        dArr[1] = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d, @FloatRange(from = 0.0d, to = 100.0d) double d6, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d10) {
        double d11 = (((-0.4986d) * d10) + (((-1.5372d) * d6) + (3.2406d * d))) / 100.0d;
        double d12 = ((0.0415d * d10) + ((1.8758d * d6) + ((-0.9689d) * d))) / 100.0d;
        double d13 = ((1.057d * d10) + (((-0.204d) * d6) + (0.0557d * d))) / 100.0d;
        return Color.rgb(constrain((int) Math.round((d11 > 0.0031308d ? (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d : d11 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d12 > 0.0031308d ? (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d : d12 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d13 > 0.0031308d ? (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d : d13 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d, @FloatRange(from = 0.0d, to = 100.0d) double d6, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d10, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double dPivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
        double dPivotXyzComponent2 = pivotXyzComponent(d6 / 100.0d);
        double dPivotXyzComponent3 = pivotXyzComponent(d10 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = Math.max(0.0d, (116.0d * dPivotXyzComponent2) - 16.0d);
        dArr[1] = (dPivotXyzComponent - dPivotXyzComponent2) * 500.0d;
        dArr[2] = (dPivotXyzComponent2 - dPivotXyzComponent3) * 200.0d;
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i, @ColorInt int i6, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        float f7 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i6) * f) + (Color.alpha(i) * f7)), (int) ((Color.red(i6) * f) + (Color.red(i) * f7)), (int) ((Color.green(i6) * f) + (Color.green(i) * f7)), (int) ((Color.blue(i6) * f) + (Color.blue(i) * f7)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f, float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f7 = 1.0f - f;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
        fArr3[1] = (fArr2[1] * f) + (fArr[1] * f7);
        fArr3[2] = (fArr2[2] * f) + (fArr[2] * f7);
    }

    public static void blendLAB(double[] dArr, double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d, double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d6 = 1.0d - d;
        dArr3[0] = (dArr2[0] * d) + (dArr[0] * d6);
        dArr3[1] = (dArr2[1] * d) + (dArr[1] * d6);
        dArr3[2] = (dArr2[2] * d) + (dArr[2] * d6);
    }

    public static double calculateContrast(@ColorInt int i, @ColorInt int i6) {
        if (Color.alpha(i6) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i6));
        }
        if (Color.alpha(i) < 255) {
            i = compositeColors(i, i6);
        }
        double dCalculateLuminance = calculateLuminance(i) + 0.05d;
        double dCalculateLuminance2 = calculateLuminance(i6) + 0.05d;
        return Math.max(dCalculateLuminance, dCalculateLuminance2) / Math.min(dCalculateLuminance, dCalculateLuminance2);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / 100.0d;
    }

    public static int calculateMinimumAlpha(@ColorInt int i, @ColorInt int i6, float f) {
        int i10 = 255;
        if (Color.alpha(i6) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i6));
        }
        double d = f;
        if (calculateContrast(setAlphaComponent(i, 255), i6) < d) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = 0; i12 <= 10 && i10 - i11 > 1; i12++) {
            int i13 = (i11 + i10) / 2;
            if (calculateContrast(setAlphaComponent(i, i13), i6) < d) {
                i11 = i13;
            } else {
                i10 = i13;
            }
        }
        return i10;
    }

    @VisibleForTesting
    public static float circularInterpolate(float f, float f7, float f9) {
        if (Math.abs(f7 - f) > 180.0f) {
            if (f7 > f) {
                f += 360.0f;
            } else {
                f7 += 360.0f;
            }
        }
        return (((f7 - f) * f9) + f) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i, float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void colorToLAB(@ColorInt int i, double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void colorToM3HCT(@ColorInt int i, @Size(3) float[] fArr) {
        CamColor.getM3HCTfromColor(i, fArr);
    }

    public static void colorToXYZ(@ColorInt int i, double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i6) {
        return 255 - (((255 - i) * (255 - i6)) / 255);
    }

    public static int compositeColors(@ColorInt int i, @ColorInt int i6) {
        int iAlpha = Color.alpha(i6);
        int iAlpha2 = Color.alpha(i);
        int iCompositeAlpha = compositeAlpha(iAlpha2, iAlpha);
        return Color.argb(iCompositeAlpha, compositeComponent(Color.red(i), iAlpha2, Color.red(i6), iAlpha, iCompositeAlpha), compositeComponent(Color.green(i), iAlpha2, Color.green(i6), iAlpha, iCompositeAlpha), compositeComponent(Color.blue(i), iAlpha2, Color.blue(i6), iAlpha, iCompositeAlpha));
    }

    private static int compositeComponent(int i, int i6, int i10, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        return (((255 - i6) * (i10 * i11)) + ((i * 255) * i6)) / (i12 * 255);
    }

    private static float constrain(float f, float f7, float f9) {
        return f < f7 ? f7 : Math.min(f, f9);
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[2] - dArr2[2], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[0] - dArr2[0], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? Math.pow(d, 0.3333333333333333d) : ((d * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i6) {
        if (i6 < 0 || i6 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (i6 << 24);
    }

    private static int constrain(int i, int i6, int i10) {
        return i < i6 ? i6 : Math.min(i, i10);
    }

    @RequiresApi(26)
    public static Color compositeColors(Color color, Color color2) {
        return Api26Impl.compositeColors(color, color2);
    }
}
