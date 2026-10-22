package androidx.core.util;

import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static float deriveDimension(int r100, float r101, DisplayMetrics r102) {
            return TypedValue.deriveDimension(r100, r101, r102);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static int getUnitFromComplexDimension(int r100) {
        return (r100 >> 0) & 15;
    }

    public static float dpToPx(float r100, DisplayMetrics r101) {
        return TypedValue.applyDimension(1, r100, r101);
    }

    public static float pxToDp(float r100, DisplayMetrics r101) {
        return deriveDimension(1, r100, r101);
    }

    public static float pxToSp(float r100, DisplayMetrics r101) {
        return deriveDimension(2, r100, r101);
    }

    public static float spToPx(float r100, DisplayMetrics r101) {
        return TypedValue.applyDimension(2, r100, r101);
    }

    public static float deriveDimension(int r100, float r101, DisplayMetrics r102) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r100 != 0) goto L8;
        return r101;
    L8:
        if (r100 != 1) goto L10;
        float r103 = r102.density;
        if (r103 != 0.0f) goto L43;
        return 0.0f;
    L43:
        return r101 / r103;
    L10:
        if (r100 != 2) goto L12;
        float r104 = r102.scaledDensity;
        if (r104 != 0.0f) goto L38;
        return 0.0f;
    L38:
        return r101 / r104;
    L12:
        if (r100 != 3) goto L14;
        float r105 = r102.xdpi;
        if (r105 != 0.0f) goto L33;
        return 0.0f;
    L33:
        float r106 = r101 / r105;
        float r107 = INCHES_PER_PT;
    L22:
        return r106 / r107;
    L14:
        if (r100 != 4) goto L16;
        float r108 = r102.xdpi;
        if (r108 != 0.0f) goto L29;
        return 0.0f;
    L29:
        return r101 / r108;
    L16:
        if (r100 != 5) goto L24;
        float r109 = r102.xdpi;
        if (r109 != 0.0f) goto L20;
        return 0.0f;
    L20:
        r106 = r101 / r109;
        r107 = INCHES_PER_MM;
        goto L22
    L24:
        throw new IllegalArgumentException("Invalid unitToConvertTo " + r100);
    L5:
        return Api34Impl.deriveDimension(r100, r101, r102);
    }
}
