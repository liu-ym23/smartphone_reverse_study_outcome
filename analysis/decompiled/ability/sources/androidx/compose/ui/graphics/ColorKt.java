package androidx.compose.ui.graphics;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Size;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u001a;\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a;\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\n\u0010\t\u001a\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\b\u0010\r\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\b\u0010\u000f\u001a7\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0001\u001a\u00020\u000b2\b\b\u0001\u0010\u0002\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u000b2\b\b\u0003\u0010\u0004\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\b\u0010\u0010\u001a)\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0001\u0010\u0013\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u001a\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a8\u0010 \u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0082\b¢\u0006\u0004\b \u0010!\u001a\u0013\u0010%\u001a\u00020\"*\u00020\u0007H\u0003¢\u0006\u0004\b#\u0010$\u001a\u0013\u0010(\u001a\u00020\u0000*\u00020\u0007H\u0007¢\u0006\u0004\b&\u0010'\u001a\u0013\u0010+\u001a\u00020\u000b*\u00020\u0007H\u0007¢\u0006\u0004\b)\u0010*\u001a\"\u00100\u001a\u00020\u0007*\u00020\u00072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070,H\u0086\b¢\u0006\u0004\b.\u0010/\"\u001a\u00102\u001a\u0002018\u0000X\u0081T¢\u0006\f\n\u0004\b2\u00103\u0012\u0004\b4\u00105\"\u001f\u0010;\u001a\u000206*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010:\u001a\u0004\b7\u00108\"\u001f\u0010>\u001a\u000206*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010:\u001a\u0004\b<\u00108¨\u0006?"}, d2 = {"", "red", "green", "blue", "alpha", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "Color", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "UncheckedColor", "", TypedValues.Custom.S_COLOR, "(I)J", "", "(J)J", "(IIII)J", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "lerp", "background", "compositeOver--OWjLjI", "(JJ)J", "compositeOver", "fgC", "bgC", "fgA", "bgA", "a", "compositeComponent", "(FFFFF)F", "", "getComponents-8_81llA", "(J)[F", "getComponents", "luminance-8_81llA", "(J)F", "luminance", "toArgb-8_81llA", "(J)I", "toArgb", "Lkotlin/Function0;", "block", "takeOrElse-DxMtmZc", "(JLS7/a;)J", "takeOrElse", "LC7/m;", "UnspecifiedColor", "J", "getUnspecifiedColor$annotations", "()V", "", "isSpecified-8_81llA", "(J)Z", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified", "isUnspecified-8_81llA", "isUnspecified-8_81llA$annotations", "isUnspecified", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    /* JADX WARN: Removed duplicated region for block: B:110:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0121  */
    @androidx.compose.runtime.Stable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long Color(float r20, float r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.ColorSpace r24) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long Color$default(float f, float f7, float f9, float f10, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f10 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f7, f9, f10, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e8  */
    @androidx.compose.runtime.Stable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long UncheckedColor(float r17, float r18, float r19, float r20, androidx.compose.ui.graphics.colorspace.ColorSpace r21) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.UncheckedColor(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long UncheckedColor$default(float f, float f7, float f9, float f10, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f10 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f, f7, f9, f10, colorSpace);
    }

    private static final float compositeComponent(float f, float f7, float f9, float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        return (((1.0f - f9) * (f7 * f10)) + (f * f9)) / f11;
    }

    @Stable
    /* renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m4184compositeOverOWjLjI(long j5, long j6) {
        float f;
        float f7;
        long jM4136convertvNxB06k = Color.m4136convertvNxB06k(j5, Color.m4143getColorSpaceimpl(j6));
        float fM4141getAlphaimpl = Color.m4141getAlphaimpl(j6);
        float fM4141getAlphaimpl2 = Color.m4141getAlphaimpl(jM4136convertvNxB06k);
        float f9 = 1.0f - fM4141getAlphaimpl2;
        float f10 = (fM4141getAlphaimpl * f9) + fM4141getAlphaimpl2;
        float fM4145getRedimpl = Color.m4145getRedimpl(jM4136convertvNxB06k);
        float fM4145getRedimpl2 = Color.m4145getRedimpl(j6);
        float f11 = 0.0f;
        if (f10 == 0.0f) {
            f = 0.0f;
        } else {
            f = (((fM4145getRedimpl2 * fM4141getAlphaimpl) * f9) + (fM4145getRedimpl * fM4141getAlphaimpl2)) / f10;
        }
        float fM4144getGreenimpl = Color.m4144getGreenimpl(jM4136convertvNxB06k);
        float fM4144getGreenimpl2 = Color.m4144getGreenimpl(j6);
        if (f10 == 0.0f) {
            f7 = 0.0f;
        } else {
            f7 = (((fM4144getGreenimpl2 * fM4141getAlphaimpl) * f9) + (fM4144getGreenimpl * fM4141getAlphaimpl2)) / f10;
        }
        float fM4142getBlueimpl = Color.m4142getBlueimpl(jM4136convertvNxB06k);
        float fM4142getBlueimpl2 = Color.m4142getBlueimpl(j6);
        if (f10 != 0.0f) {
            f11 = (((fM4142getBlueimpl2 * fM4141getAlphaimpl) * f9) + (fM4142getBlueimpl * fM4141getAlphaimpl2)) / f10;
        }
        return UncheckedColor(f, f7, f11, f10, Color.m4143getColorSpaceimpl(j6));
    }

    @Size(4)
    /* renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m4185getComponents8_81llA(long j5) {
        return new float[]{Color.m4145getRedimpl(j5), Color.m4144getGreenimpl(j5), Color.m4142getBlueimpl(j5), Color.m4141getAlphaimpl(j5)};
    }

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m4186isSpecified8_81llA(long j5) {
        return j5 != 16;
    }

    @Stable
    /* renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4187isSpecified8_81llA$annotations(long j5) {
    }

    /* renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m4188isUnspecified8_81llA(long j5) {
        return j5 == 16;
    }

    @Stable
    /* renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4189isUnspecified8_81llA$annotations(long j5) {
    }

    @Stable
    /* renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m4190lerpjxsXWHM(long j5, long j6, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM4136convertvNxB06k = Color.m4136convertvNxB06k(j5, oklab);
        long jM4136convertvNxB06k2 = Color.m4136convertvNxB06k(j6, oklab);
        float fM4141getAlphaimpl = Color.m4141getAlphaimpl(jM4136convertvNxB06k);
        float fM4145getRedimpl = Color.m4145getRedimpl(jM4136convertvNxB06k);
        float fM4144getGreenimpl = Color.m4144getGreenimpl(jM4136convertvNxB06k);
        float fM4142getBlueimpl = Color.m4142getBlueimpl(jM4136convertvNxB06k);
        float fM4141getAlphaimpl2 = Color.m4141getAlphaimpl(jM4136convertvNxB06k2);
        float fM4145getRedimpl2 = Color.m4145getRedimpl(jM4136convertvNxB06k2);
        float fM4144getGreenimpl2 = Color.m4144getGreenimpl(jM4136convertvNxB06k2);
        float fM4142getBlueimpl2 = Color.m4142getBlueimpl(jM4136convertvNxB06k2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m4136convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(fM4145getRedimpl, fM4145getRedimpl2, f), MathHelpersKt.lerp(fM4144getGreenimpl, fM4144getGreenimpl2, f), MathHelpersKt.lerp(fM4142getBlueimpl, fM4142getBlueimpl2, f), MathHelpersKt.lerp(fM4141getAlphaimpl, fM4141getAlphaimpl2, f), oklab), Color.m4143getColorSpaceimpl(j6));
    }

    @Stable
    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m4191luminance8_81llA(long j5) {
        ColorSpace colorSpaceM4143getColorSpaceimpl = Color.m4143getColorSpaceimpl(j5);
        if (!ColorModel.m4563equalsimpl0(colorSpaceM4143getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m4570getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m4566toStringimpl(colorSpaceM4143getColorSpaceimpl.getModel())));
        }
        DoubleFunction eotfFunc = ((Rgb) colorSpaceM4143getColorSpaceimpl).getEotfFunc();
        double dInvoke = eotfFunc.invoke(Color.m4145getRedimpl(j5));
        float fInvoke = (float) ((eotfFunc.invoke(Color.m4142getBlueimpl(j5)) * 0.0722d) + (eotfFunc.invoke(Color.m4144getGreenimpl(j5)) * 0.7152d) + (dInvoke * 0.2126d));
        if (fInvoke < 0.0f) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    /* renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m4192takeOrElseDxMtmZc(long j5, S7.a aVar) {
        return j5 != 16 ? j5 : ((Color) aVar.invoke()).m4149unboximpl();
    }

    @Stable
    @ColorInt
    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m4193toArgb8_81llA(long j5) {
        return (int) (Color.m4136convertvNxB06k(j5, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    public static /* synthetic */ long Color$default(int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i11 = 255;
        }
        return Color(i, i6, i10, i11);
    }

    @Stable
    public static final long Color(@ColorInt int i) {
        return Color.m4135constructorimpl(i << 32);
    }

    @Stable
    public static final long Color(long j5) {
        return Color.m4135constructorimpl(j5 << 32);
    }

    @Stable
    public static final long Color(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i6, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i10, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = ScatterMapKt.Sentinel) int i11) {
        return Color(((i & 255) << 16) | ((i11 & 255) << 24) | ((i6 & 255) << 8) | (i10 & 255));
    }
}
