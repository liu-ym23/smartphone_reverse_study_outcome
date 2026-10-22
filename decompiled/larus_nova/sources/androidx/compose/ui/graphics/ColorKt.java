package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a9\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a5\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00112\b\b\u0001\u0010\t\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u00112\b\b\u0003\u0010\u000b\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001a)\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a1\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0082\b\u001a\u0013\u0010&\u001a\u00020'*\u00020\u0006H\u0003¢\u0006\u0004\b(\u0010)\u001a\u0013\u0010*\u001a\u00020\b*\u00020\u0006H\u0007¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020\u0011*\u00020\u0006H\u0007¢\u0006\u0004\b.\u0010/\u001a\"\u00109\u001a\u00020\u0006*\u00020\u00062\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060;H\u0086\b¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001f\u00100\u001a\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u001f\u00106\u001a\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b7\u00103\u001a\u0004\b8\u00105¨\u0006>"}, d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "Color", "Landroidx/compose/ui/graphics/Color;", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "UncheckedColor", "color", "", "(I)J", "", "(J)J", "(IIII)J", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "toArgb", "toArgb-8_81llA", "(J)I", "isSpecified", "", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    private static final float compositeComponent(float r100, float r101, float r102, float r103, float r104) {
        if (r104 != 0.0f) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L9;
        return 0.0f;
    L9:
        return ((r100 * r102) + ((r101 * r103) * (1.0f - r102))) / r104;
    L5:
        r105 = false;
        goto L6
    }

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m4874isSpecified8_81llA(long r100) {
        if (r100 == 16) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4875isSpecified8_81llA$annotations(long r100) {
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m4876isUnspecified8_81llA(long r100) {
        if (r100 != 16) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4877isUnspecified8_81llA$annotations(long r100) {
    }

    public static final long Color(int r100) {
        return Color.m4823constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100) << 32));
    }

    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m4873getComponents8_81llA(long r100) {
        return new float[]{Color.m4833getRedimpl(r100), Color.m4832getGreenimpl(r100), Color.m4830getBlueimpl(r100), Color.m4829getAlphaimpl(r100)};
    }

    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m4879luminance8_81llA(long r100) {
        ColorSpace r101 = Color.m4831getColorSpaceimpl(r100);
        if (ColorModel.m5261equalsimpl0(r101.m5270getModelxdoWZVw(), ColorModel.Companion.m5268getRgbxdoWZVw()) == true) goto L5;
        InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ColorModel.m5264toStringimpl(r101.m5270getModelxdoWZVw()));
    L5:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction r102 = ((Rgb) r101).getEotfFunc$ui_graphics_release();
        float r103 = (float) (((r102.invoke(Color.m4833getRedimpl(r100)) * 0.2126d) + (r102.invoke(Color.m4832getGreenimpl(r100)) * 0.7152d)) + (r102.invoke(Color.m4830getBlueimpl(r100)) * 0.0722d));
        if (r103 >= 0.0f) goto L9;
        r103 = 0.0f;
    L9:
        if (r103 <= 1.0f) goto L12;
        return 1.0f;
    L12:
        return r103;
    }

    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m4881toArgb8_81llA(long r100) {
        return (int) ULong.m9623constructorimpl(Color.m4824convertvNxB06k(r100, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    public static final long Color(long r100) {
        return Color.m4823constructorimpl(ULong.m9623constructorimpl(r100 << 32));
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m4872compositeOverOWjLjI(long r110, long r111) {
        long r112 = Color.m4824convertvNxB06k(r110, Color.m4831getColorSpaceimpl(r111));
        float r100 = Color.m4829getAlphaimpl(r111);
        float r101 = Color.m4829getAlphaimpl(r112);
        float r102 = 1.0f - r101;
        float r103 = (r100 * r102) + r101;
        float r104 = Color.m4833getRedimpl(r112);
        float r105 = Color.m4833getRedimpl(r111);
        boolean r106 = true;
        float r107 = 0.0f;
        if (r103 != 0.0f) goto L5;
        boolean r113 = true;
    L6:
        if (r113 == false) goto L8;
        float r108 = 0.0f;
    L9:
        float r109 = Color.m4832getGreenimpl(r112);
        float r114 = Color.m4832getGreenimpl(r111);
        if (r103 != 0.0f) goto L12;
        boolean r115 = true;
    L13:
        if (r115 == false) goto L15;
        float r116 = 0.0f;
    L16:
        float r117 = Color.m4830getBlueimpl(r112);
        float r118 = Color.m4830getBlueimpl(r111);
        if (r103 == 0.0f) goto L20;
        r106 = false;
    L20:
        if (r106 == true) goto L24;
        r107 = ((r117 * r101) + ((r118 * r100) * r102)) / r103;
    L24:
        return UncheckedColor(r108, r116, r107, r103, Color.m4831getColorSpaceimpl(r111));
    L15:
        r116 = ((r109 * r101) + ((r114 * r100) * r102)) / r103;
        goto L16
    L12:
        r115 = false;
        goto L13
    L8:
        r108 = ((r104 * r101) + ((r105 * r100) * r102)) / r103;
        goto L9
    L5:
        r113 = false;
        goto L6
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m4880takeOrElseDxMtmZc(long r100, Function0<Color> r101) {
        if (r100 == 16) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r100;
    L9:
        return r101.invoke().m4837unboximpl();
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m4878lerpjxsXWHM(long r100, long r110, float r111) {
        ColorSpace r101 = ColorSpaces.INSTANCE.getOklab();
        long r102 = Color.m4824convertvNxB06k(r100, r101);
        long r103 = Color.m4824convertvNxB06k(r110, r101);
        float r104 = Color.m4829getAlphaimpl(r102);
        float r105 = Color.m4833getRedimpl(r102);
        float r106 = Color.m4832getGreenimpl(r102);
        float r107 = Color.m4830getBlueimpl(r102);
        float r112 = Color.m4829getAlphaimpl(r103);
        float r108 = Color.m4833getRedimpl(r103);
        float r109 = Color.m4832getGreenimpl(r103);
        float r113 = Color.m4830getBlueimpl(r103);
        if (r111 >= 0.0f) goto L6;
        r111 = 0.0f;
    L6:
        if (r111 <= 1.0f) goto L9;
        r111 = 1.0f;
    L9:
        return Color.m4824convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(r105, r108, r111), MathHelpersKt.lerp(r106, r109, r111), MathHelpersKt.lerp(r107, r113, r111), MathHelpersKt.lerp(r104, r112, r111), r101), Color.m4831getColorSpaceimpl(r110));
    }

    public static final long Color(int r100, int r101, int r102, int r103) {
        int r104 = (r100 & 255) << 16;
        return Color(((r104 | ((r103 & 255) << 24)) | ((r101 & 255) << 8)) | (r102 & 255));
    }

    public static final long Color(float r110, float r210, float r211, float r212, ColorSpace r213) {
        float r100 = 1.0f;
        float r101 = 0.0f;
        if (r213.isSrgb() == false) goto L36;
        if (r212 >= 0.0f) goto L7;
        float r102 = 0.0f;
    L9:
        if (r102 <= 1.0f) goto L11;
        r102 = 1.0f;
    L11:
        int r103 = ((int) ((r102 * 255.0f) + 0.5f)) << 24;
        if (r110 >= 0.0f) goto L14;
        float r104 = 0.0f;
    L16:
        if (r104 <= 1.0f) goto L18;
        r104 = 1.0f;
    L18:
        int r105 = r103 | (((int) ((r104 * 255.0f) + 0.5f)) << 16);
        if (r210 >= 0.0f) goto L21;
        float r106 = 0.0f;
    L23:
        if (r106 <= 1.0f) goto L25;
        r106 = 1.0f;
    L25:
        int r107 = r105 | (((int) ((r106 * 255.0f) + 0.5f)) << 8);
        if (r211 < 0.0f) goto L30;
        r101 = r211;
    L30:
        if (r101 > 1.0f) goto L34;
        r100 = r101;
    L34:
        return Color.m4823constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(r107 | ((int) ((r100 * 255.0f) + 0.5f))) << 32));
    L21:
        r106 = r210;
        goto L23
    L14:
        r104 = r110;
        goto L16
    L7:
        r102 = r212;
        goto L9
    L36:
        if (r213.getComponentCount() != 3) goto L38;
        boolean r108 = true;
    L39:
        if (r108 == true) goto L41;
        InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
    L41:
        int r109 = r213.getId$ui_graphics_release();
        if (r109 == (-1)) goto L44;
        boolean r111 = true;
    L45:
        if (r111 == true) goto L47;
        InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
    L47:
        float r112 = r213.getMinValue(0);
        float r113 = r213.getMaxValue(0);
        if (r110 < r112) goto L52;
        r112 = r110;
    L52:
        if (r112 > r113) goto L55;
        r113 = r112;
    L55:
        int r114 = Float.floatToRawIntBits(r113);
        int r115 = r114 >>> 31;
        int r116 = (r114 >>> 23) & 255;
        int r117 = r114 & 8388607;
        int r118 = 31;
        if (r116 != 255) goto L61;
        if (r117 == 0) goto L59;
        int r119 = 512;
    L60:
        int r120 = 31;
    L76:
        int r121 = r119 | ((r115 << 15) | (r120 << 10));
    L77:
        short r122 = (short) r121;
        float r123 = r213.getMinValue(1);
        float r124 = r213.getMaxValue(1);
        if (r210 < r123) goto L82;
        r123 = r210;
    L82:
        if (r123 > r124) goto L85;
        r124 = r123;
    L85:
        int r125 = Float.floatToRawIntBits(r124);
        int r126 = r125 >>> 31;
        int r127 = (r125 >>> 23) & 255;
        int r128 = r125 & 8388607;
        if (r127 != 255) goto L91;
        if (r128 == 0) goto L89;
        int r129 = 512;
    L90:
        int r130 = 31;
    L106:
        int r131 = r129 | ((r126 << 15) | (r130 << 10));
    L107:
        short r132 = (short) r131;
        float r133 = r213.getMinValue(2);
        float r134 = r213.getMaxValue(2);
        if (r211 < r133) goto L112;
        r133 = r211;
    L112:
        if (r133 > r134) goto L115;
        r134 = r133;
    L115:
        int r135 = Float.floatToRawIntBits(r134);
        int r136 = r135 >>> 31;
        int r137 = (r135 >>> 23) & 255;
        int r138 = r135 & 8388607;
        if (r137 != 255) goto L119;
        if (r138 == 0) goto L122;
        int r139 = 512;
    L134:
        int r140 = ((r136 << 15) | (r118 << 10)) | r139;
    L135:
        short r141 = (short) r140;
        if (r212 < 0.0f) goto L140;
        r101 = r212;
    L140:
        if (r101 > 1.0f) goto L144;
        r100 = r101;
    L144:
        return Color.m4823constructorimpl(ULong.m9623constructorimpl((((long) r109) & 63) | (((((long) ((int) ((r100 * 1023.0f) + 0.5f))) & 1023) << 6) | ((((((long) r122) & 65535) << 48) | ((((long) r132) & 65535) << 32)) | ((65535 & ((long) r141)) << 16)))));
    L122:
        r139 = 0;
        goto L134
    L119:
        int r142 = (r137 - 127) + 15;
        if (r142 < 31) goto L123;
        r118 = 49;
        goto L122
    L123:
        if (r142 > 0) goto L130;
        if (r142 < (-10)) goto L129;
        int r143 = (r138 | 8388608) >> (1 - r142);
        if ((r143 & 4096) == 0) goto L128;
        r143 = r143 + 8192;
    L128:
        r139 = r143 >> 13;
        r118 = 0;
        goto L134
    L129:
        r118 = 0;
        goto L122
    L130:
        int r144 = r138 >> 13;
        if ((r138 & 4096) == 0) goto L133;
        r140 = (((r142 << 10) | r144) + 1) | (r136 << 15);
        goto L135
    L133:
        r139 = r144;
        r118 = r142;
        goto L134
    L89:
        r129 = 0;
        goto L90
    L91:
        r130 = (r127 - 127) + 15;
        if (r130 < 31) goto L94;
        r129 = 0;
        r130 = 49;
        goto L106
    L94:
        if (r130 > 0) goto L102;
        if (r130 < (-10)) goto L100;
        int r145 = (r128 | 8388608) >> (1 - r130);
        if ((r145 & 4096) == 0) goto L99;
        r145 = r145 + 8192;
    L99:
        r129 = r145 >> 13;
    L101:
        r130 = 0;
        goto L106
    L100:
        r129 = 0;
        goto L101
    L102:
        int r146 = r128 >> 13;
        if ((r128 & 4096) == 0) goto L105;
        r131 = (((r130 << 10) | r146) + 1) | (r126 << 15);
        goto L107
    L105:
        r129 = r146;
        goto L106
    L59:
        r119 = 0;
        goto L60
    L61:
        r120 = (r116 - 127) + 15;
        if (r120 < 31) goto L64;
        r119 = 0;
        r120 = 49;
        goto L76
    L64:
        if (r120 > 0) goto L72;
        if (r120 < (-10)) goto L70;
        int r147 = (r117 | 8388608) >> (1 - r120);
        if ((r147 & 4096) == 0) goto L69;
        r147 = r147 + 8192;
    L69:
        r119 = r147 >> 13;
    L71:
        r120 = 0;
        goto L76
    L70:
        r119 = 0;
        goto L71
    L72:
        int r148 = r117 >> 13;
        if ((r117 & 4096) == 0) goto L75;
        r121 = (((r120 << 10) | r148) + 1) | (r115 << 15);
        goto L77
    L75:
        r119 = r148;
        goto L76
    L44:
        r111 = false;
        goto L45
    L38:
        r108 = false;
        goto L39
    }

    public static final long UncheckedColor(float r110, float r111, float r112, float r210, ColorSpace r211) {
        if (r211.isSrgb() == true) goto L5;
        int r100 = Float.floatToRawIntBits(r110);
        int r101 = r100 >>> 31;
        int r102 = (r100 >>> 23) & 255;
        int r103 = r100 & 8388607;
        int r113 = 49;
        int r114 = 0;
        if (r102 != 255) goto L12;
        if (r103 == 0) goto L10;
        int r104 = 512;
    L11:
        int r105 = 31;
    L27:
        int r106 = r104 | ((r101 << 15) | (r105 << 10));
    L28:
        short r107 = (short) r106;
        int r108 = Float.floatToRawIntBits(r111);
        int r109 = r108 >>> 31;
        int r115 = (r108 >>> 23) & 255;
        int r116 = r108 & 8388607;
        if (r115 != 255) goto L34;
        if (r116 == 0) goto L32;
        int r117 = 512;
    L33:
        int r118 = 31;
    L49:
        int r119 = r117 | ((r109 << 15) | (r118 << 10));
    L50:
        short r120 = (short) r119;
        int r121 = Float.floatToRawIntBits(r112);
        int r122 = r121 >>> 31;
        int r123 = (r121 >>> 23) & 255;
        int r124 = r121 & 8388607;
        if (r123 != 255) goto L56;
        if (r124 == 0) goto L54;
        int r125 = 512;
    L55:
        r114 = r125;
        r113 = 31;
    L70:
        int r126 = ((r122 << 15) | (r113 << 10)) | r114;
    L72:
        return Color.m4823constructorimpl(ULong.m9623constructorimpl((((((((long) r120) & 65535) << 32) | ((((long) r107) & 65535) << 48)) | ((((long) ((short) r126)) & 65535) << 16)) | ((((long) ((int) ((Math.max(0.0f, Math.min(r210, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6)) | (((long) r211.getId$ui_graphics_release()) & 63)));
    L54:
        r125 = 0;
        goto L55
    L56:
        int r127 = (r123 - 127) + 15;
        if (r127 >= 31) goto L70;
        if (r127 > 0) goto L66;
        if (r127 < (-10)) goto L65;
        int r128 = (r124 | 8388608) >> (1 - r127);
        if ((r128 & 4096) == 0) goto L64;
        r128 = r128 + 8192;
    L64:
        r114 = r128 >> 13;
    L65:
        r113 = 0;
        goto L70
    L66:
        r114 = r124 >> 13;
        if ((r124 & 4096) == 0) goto L69;
        r126 = (((r127 << 10) | r114) + 1) | (r122 << 15);
        goto L72
    L69:
        r113 = r127;
        goto L70
    L32:
        r117 = 0;
        goto L33
    L34:
        r118 = (r115 - 127) + 15;
        if (r118 < 31) goto L37;
        r117 = 0;
        r118 = 49;
        goto L49
    L37:
        if (r118 > 0) goto L45;
        if (r118 < (-10)) goto L43;
        int r129 = (r116 | 8388608) >> (1 - r118);
        if ((r129 & 4096) == 0) goto L42;
        r129 = r129 + 8192;
    L42:
        r117 = r129 >> 13;
    L44:
        r118 = 0;
        goto L49
    L43:
        r117 = 0;
        goto L44
    L45:
        int r130 = r116 >> 13;
        if ((r116 & 4096) == 0) goto L48;
        r119 = (((r118 << 10) | r130) + 1) | (r109 << 15);
        goto L50
    L48:
        r117 = r130;
        goto L49
    L10:
        r104 = 0;
        goto L11
    L12:
        r105 = (r102 - 127) + 15;
        if (r105 < 31) goto L15;
        r104 = 0;
        r105 = 49;
        goto L27
    L15:
        if (r105 > 0) goto L23;
        if (r105 < (-10)) goto L21;
        int r131 = (r103 | 8388608) >> (1 - r105);
        if ((r131 & 4096) == 0) goto L20;
        r131 = r131 + 8192;
    L20:
        r104 = r131 >> 13;
    L22:
        r105 = 0;
        goto L27
    L21:
        r104 = 0;
        goto L22
    L23:
        int r132 = r103 >> 13;
        if ((r103 & 4096) == 0) goto L26;
        r106 = (((r105 << 10) | r132) + 1) | (r101 << 15);
        goto L28
    L26:
        r104 = r132;
        goto L27
    L5:
        return Color.m4823constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl((((((int) ((r210 * 255.0f) + 0.5f)) << 24) | (((int) ((r110 * 255.0f) + 0.5f)) << 16)) | (((int) ((r111 * 255.0f) + 0.5f)) << 8)) | ((int) ((255.0f * r112) + 0.5f))) << 32));
    }

    public static /* synthetic */ long Color$default(int r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L6;
        r103 = 255;
    L6:
        return Color(r100, r101, r102, r103);
    }

    public static /* synthetic */ long Color$default(float r100, float r101, float r102, float r103, ColorSpace r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r103 = 1.0f;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r104 = ColorSpaces.INSTANCE.getSrgb();
    L9:
        return Color(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ long UncheckedColor$default(float r100, float r101, float r102, float r103, ColorSpace r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r103 = 1.0f;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r104 = ColorSpaces.INSTANCE.getSrgb();
    L9:
        return UncheckedColor(r100, r101, r102, r103, r104);
    }
}
