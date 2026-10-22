package androidx.compose.ui.graphics;

import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001f\u0010\u0006\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001a\u0018\u0010\u0012\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0011H\u0000\u001a\u0010\u0010\u0013\u001a\u00020\u0014*\u00060\u0001j\u0002`\bH\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0014H\u0000\u001a\u0015\u0010\u0016\u001a\u00020\u0017*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010\u0018\u001a\u001f\u0010\u0019\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001e\u0010\f\u001a\u0015\u0010\u001f\u001a\u00020\u001d*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001a\u0018\u0010\"\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0011H\u0000\u001a\u0015\u0010#\u001a\u00020$*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001a\u001f\u0010%\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020$H\u0000¢\u0006\u0004\b&\u0010\f\u001a\u0015\u0010'\u001a\u00020(*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001a\u001f\u0010)\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020(H\u0000¢\u0006\u0004\b*\u0010\f\u001a\u0010\u0010+\u001a\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001a\u0018\u0010,\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0011H\u0000\u001a\u0015\u0010-\u001a\u00020.*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001a\u001f\u0010/\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020.H\u0000¢\u0006\u0004\b0\u0010\f\u001a \u00101\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u000e\u0010\u000e\u001a\n\u0018\u000102j\u0004\u0018\u0001`3H\u0000\u001a\u001a\u00104\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\b\u0010\u000e\u001a\u0004\u0018\u000105H\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u00066"}, d2 = {"NativePaint", "Landroid/graphics/Paint;", "Paint", "Landroidx/compose/ui/graphics/Paint;", "asComposePaint", "makeNativePaint", "setNativeBlendMode", "", "Landroidx/compose/ui/graphics/NativePaint;", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColorFilter", "value", "Landroidx/compose/ui/graphics/ColorFilter;", "getNativeAlpha", "", "setNativeAlpha", "getNativeAntiAlias", "", "setNativeAntiAlias", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeStyle--5YerkU", "getNativeStyle", "(Landroid/graphics/Paint;)I", "getNativeStrokeWidth", "setNativeStrokeWidth", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "getNativeStrokeMiterLimit", "setNativeStrokeMiterLimit", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidPaint_androidKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r100 = new int[android.graphics.Paint.Style.values().length];
            r100[android.graphics.Paint.Style.STROKE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L4:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[android.graphics.Paint.Cap.values().length];
            r101[android.graphics.Paint.Cap.BUTT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[android.graphics.Paint.Cap.ROUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L35:
            r101[android.graphics.Paint.Cap.SQUARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L10:
            $EnumSwitchMapping$1 = r101;
            int[] r102 = new int[android.graphics.Paint.Join.values().length];
            r102[android.graphics.Paint.Join.MITER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L23:
            r102[android.graphics.Paint.Join.BEVEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L27:
            r102[android.graphics.Paint.Join.ROUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L14:
            $EnumSwitchMapping$2 = r102;
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    public static final Paint asComposePaint(android.graphics.Paint r100) {
        return new AndroidPaint(r100);
    }

    public static final float getNativeAlpha(android.graphics.Paint r100) {
        return r100.getAlpha() / 255.0f;
    }

    public static final boolean getNativeAntiAlias(android.graphics.Paint r100) {
        return r100.isAntiAlias();
    }

    public static final long getNativeColor(android.graphics.Paint r100) {
        return ColorKt.Color(r100.getColor());
    }

    public static final int getNativeFilterQuality(android.graphics.Paint r100) {
        if (r100.isFilterBitmap() == true) goto L6;
        return FilterQuality.Companion.m4929getNonefv9h1I();
    L6:
        return FilterQuality.Companion.m4927getLowfv9h1I();
    }

    public static final int getNativeStrokeCap(android.graphics.Paint r100) {
        android.graphics.Paint.Cap r101 = r100.getStrokeCap();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 == 1) goto L16;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L18;
        return StrokeCap.Companion.m5206getButtKaPHkGw();
    L18:
        return StrokeCap.Companion.m5208getSquareKaPHkGw();
    L19:
        return StrokeCap.Companion.m5207getRoundKaPHkGw();
    L16:
        return StrokeCap.Companion.m5206getButtKaPHkGw();
    L5:
        r102 = WhenMappings.$EnumSwitchMapping$1[r101.ordinal()];
        goto L7
    }

    public static final int getNativeStrokeJoin(android.graphics.Paint r100) {
        android.graphics.Paint.Join r101 = r100.getStrokeJoin();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 == 1) goto L16;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L18;
        return StrokeJoin.Companion.m5217getMiterLxFBmk8();
    L18:
        return StrokeJoin.Companion.m5218getRoundLxFBmk8();
    L19:
        return StrokeJoin.Companion.m5216getBevelLxFBmk8();
    L16:
        return StrokeJoin.Companion.m5217getMiterLxFBmk8();
    L5:
        r102 = WhenMappings.$EnumSwitchMapping$2[r101.ordinal()];
        goto L7
    }

    public static final float getNativeStrokeMiterLimit(android.graphics.Paint r100) {
        return r100.getStrokeMiter();
    }

    public static final float getNativeStrokeWidth(android.graphics.Paint r100) {
        return r100.getStrokeWidth();
    }

    public static final int getNativeStyle(android.graphics.Paint r100) {
        android.graphics.Paint.Style r101 = r100.getStyle();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L10;
        return PaintingStyle.Companion.m5115getStrokeTiuSbCo();
    L10:
        return PaintingStyle.Companion.m5114getFillTiuSbCo();
    L5:
        r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        goto L7
    }

    public static final void setNativeAlpha(android.graphics.Paint r100, float r101) {
        r100.setAlpha((int) Math.rint(r101 * 255.0f));
    }

    public static final void setNativeAntiAlias(android.graphics.Paint r100, boolean r101) {
        r100.setAntiAlias(r101);
    }

    /* JADX INFO: renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m4709setNativeBlendModeGB0RdKg(android.graphics.Paint r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        WrapperVerificationHelperMethods.INSTANCE.m5257setBlendModeGB0RdKg(r100, r101);
        return;
    L5:
        r100.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m4675toPorterDuffModes9anfk8(r101)));
    }

    /* JADX INFO: renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m4710setNativeColor4WTKRHQ(android.graphics.Paint r100, long r101) {
        r100.setColor(ColorKt.m4881toArgb8_81llA(r101));
    }

    public static final void setNativeColorFilter(android.graphics.Paint r100, ColorFilter r101) {
        if (r101 == null) goto L4;
        android.graphics.ColorFilter r102 = AndroidColorFilter_androidKt.asAndroidColorFilter(r101);
    L5:
        r100.setColorFilter(r102);
        return;
    L4:
        r102 = null;
        goto L5
    }

    /* JADX INFO: renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m4711setNativeFilterQuality50PEsBU(android.graphics.Paint r100, int r101) {
        r100.setFilterBitmap(!FilterQuality.m4922equalsimpl0(r101, FilterQuality.Companion.m4929getNonefv9h1I()));
    }

    public static final void setNativePathEffect(android.graphics.Paint r100, PathEffect r101) {
        AndroidPathEffect r102 = (AndroidPathEffect) r101;
        if (r102 == null) goto L5;
        android.graphics.PathEffect r103 = r102.getNativePathEffect();
    L6:
        r100.setPathEffect(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void setNativeShader(android.graphics.Paint r100, Shader r101) {
        r100.setShader(r101);
    }

    /* JADX INFO: renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m4712setNativeStrokeCapCSYIeUk(android.graphics.Paint r100, int r101) {
        StrokeCap.Companion r102 = StrokeCap.Companion;
        if (StrokeCap.m5202equalsimpl0(r101, r102.m5208getSquareKaPHkGw()) == false) goto L6;
        android.graphics.Paint.Cap r103 = android.graphics.Paint.Cap.SQUARE;
    L12:
        r100.setStrokeCap(r103);
        return;
    L6:
        if (StrokeCap.m5202equalsimpl0(r101, r102.m5207getRoundKaPHkGw()) == false) goto L9;
        r103 = android.graphics.Paint.Cap.ROUND;
        goto L12
    L9:
        if (StrokeCap.m5202equalsimpl0(r101, r102.m5206getButtKaPHkGw()) == false) goto L11;
        r103 = android.graphics.Paint.Cap.BUTT;
        goto L12
    L11:
        r103 = android.graphics.Paint.Cap.BUTT;
        goto L12
    }

    /* JADX INFO: renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m4713setNativeStrokeJoinkLtJ_vA(android.graphics.Paint r100, int r101) {
        StrokeJoin.Companion r102 = StrokeJoin.Companion;
        if (StrokeJoin.m5212equalsimpl0(r101, r102.m5217getMiterLxFBmk8()) == false) goto L6;
        android.graphics.Paint.Join r103 = android.graphics.Paint.Join.MITER;
    L12:
        r100.setStrokeJoin(r103);
        return;
    L6:
        if (StrokeJoin.m5212equalsimpl0(r101, r102.m5216getBevelLxFBmk8()) == false) goto L9;
        r103 = android.graphics.Paint.Join.BEVEL;
        goto L12
    L9:
        if (StrokeJoin.m5212equalsimpl0(r101, r102.m5218getRoundLxFBmk8()) == false) goto L11;
        r103 = android.graphics.Paint.Join.ROUND;
        goto L12
    L11:
        r103 = android.graphics.Paint.Join.MITER;
        goto L12
    }

    public static final void setNativeStrokeMiterLimit(android.graphics.Paint r100, float r101) {
        r100.setStrokeMiter(r101);
    }

    public static final void setNativeStrokeWidth(android.graphics.Paint r100, float r101) {
        r100.setStrokeWidth(r101);
    }

    /* JADX INFO: renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m4714setNativeStyle5YerkU(android.graphics.Paint r100, int r101) {
        if (PaintingStyle.m5110equalsimpl0(r101, PaintingStyle.Companion.m5115getStrokeTiuSbCo()) == false) goto L5;
        android.graphics.Paint.Style r102 = android.graphics.Paint.Style.STROKE;
    L6:
        r100.setStyle(r102);
        return;
    L5:
        r102 = android.graphics.Paint.Style.FILL;
        goto L6
    }
}
