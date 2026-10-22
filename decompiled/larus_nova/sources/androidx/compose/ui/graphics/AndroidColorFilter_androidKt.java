package androidx.compose.ui.graphics;

import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001\u001a#\u0010\u0005\u001a\u00060\u0001j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00060\u0001j\u0002`\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u00060\u0001j\u0002`\u00062\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\n\u0010\u0018\u001a\u00060\u0001j\u0002`\u0006H\u0000¢\u0006\u0002\u0010\u0019\u001a\b\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\b\u0010\u001c\u001a\u00020\u001bH\u0000*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u001d"}, d2 = {"NativeColorFilter", "Landroid/graphics/ColorFilter;", "asAndroidColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "asComposeColorFilter", "actualTintColorFilter", "Landroidx/compose/ui/graphics/NativeColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "actualTintColorFilter-xETnrds", "(JI)Landroid/graphics/ColorFilter;", "actualColorMatrixColorFilter", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "actualColorMatrixColorFilter-jHG-Opc", "([F)Landroid/graphics/ColorFilter;", "actualLightingColorFilter", "multiply", "add", "actualLightingColorFilter--OWjLjI", "(JJ)Landroid/graphics/ColorFilter;", "actualColorMatrixFromFilter", "filter", "(Landroid/graphics/ColorFilter;)[F", "supportsColorMatrixQuery", "", "supportsLightingColorFilterQuery", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidColorFilter_androidKt {
    public static final boolean supportsColorMatrixQuery() {
        if (26 > Build.VERSION.SDK_INT) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean supportsLightingColorFilterQuery() {
        if (26 > Build.VERSION.SDK_INT) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: actualColorMatrixColorFilter-jHG-Opc, reason: not valid java name */
    public static final android.graphics.ColorFilter m4688actualColorMatrixColorFilterjHGOpc(float[] r100) {
        return new android.graphics.ColorMatrixColorFilter(r100);
    }

    public static final float[] actualColorMatrixFromFilter(android.graphics.ColorFilter r100) {
        if ((r100 instanceof android.graphics.ColorMatrixColorFilter) == false) goto L9;
        if (supportsColorMatrixQuery() == false) goto L9;
        return ColorMatrixFilterHelper.INSTANCE.m4906getColorMatrix8unuwjk((android.graphics.ColorMatrixColorFilter) r100);
    L9:
        throw new IllegalArgumentException("Unable to obtain ColorMatrix from Android ColorMatrixColorFilter. This method was invoked on an unsupported Android version");
    }

    public static final android.graphics.ColorFilter asAndroidColorFilter(ColorFilter r100) {
        return r100.getNativeColorFilter$ui_graphics_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ColorFilter asComposeColorFilter(android.graphics.ColorFilter r100) {
        if (29 > Build.VERSION.SDK_INT) goto L8;
        if ((r100 instanceof android.graphics.BlendModeColorFilter) == false) goto L8;
        return BlendModeColorFilterHelper.INSTANCE.createBlendModeColorFilter((android.graphics.BlendModeColorFilter) r100);
    L8:
        if ((r100 instanceof android.graphics.LightingColorFilter) == false) goto L13;
        if (supportsLightingColorFilterQuery() == false) goto L13;
        android.graphics.LightingColorFilter r101 = (android.graphics.LightingColorFilter) r100;
        ColorFilter r102 = new LightingColorFilter(ColorKt.Color(r101.getColorMultiply()), ColorKt.Color(r101.getColorAdd()), r100, null);
    L19:
        return r102;
    L13:
        if ((r100 instanceof android.graphics.ColorMatrixColorFilter) == true) goto L15;
    L17:
        r102 = new ColorFilter(r100);
        goto L19
    L15:
        if (supportsColorMatrixQuery() == false) goto L17;
        r102 = new ColorMatrixColorFilter(null, r100, 0 == true ? 1 : 0);
        goto L19
    }

    /* JADX INFO: renamed from: actualLightingColorFilter--OWjLjI, reason: not valid java name */
    public static final android.graphics.ColorFilter m4689actualLightingColorFilterOWjLjI(long r100, long r101) {
        return new android.graphics.LightingColorFilter(ColorKt.m4881toArgb8_81llA(r100), ColorKt.m4881toArgb8_81llA(r101));
    }

    /* JADX INFO: renamed from: actualTintColorFilter-xETnrds, reason: not valid java name */
    public static final android.graphics.ColorFilter m4690actualTintColorFilterxETnrds(long r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        return BlendModeColorFilterHelper.INSTANCE.m4772BlendModeColorFilterxETnrds(r100, r101);
    L6:
        return new PorterDuffColorFilter(ColorKt.m4881toArgb8_81llA(r100), AndroidBlendMode_androidKt.m4675toPorterDuffModes9anfk8(r101));
    }
}
