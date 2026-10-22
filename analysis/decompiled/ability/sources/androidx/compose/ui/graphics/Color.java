package androidx.compose.ui.graphics;

import Z6.k;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087@\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0019\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0018\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u001a\u0010\u0014J\u0010\u0010\u001e\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u0012H\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010)\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\u000e\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010/\u001a\u0004\b-\u0010\u001dR\u001a\u0010 \u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010/\u001a\u0004\b0\u0010\u0014R\u001a\u0010!\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010/\u001a\u0004\b2\u0010\u0014R\u001a\u0010\"\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010/\u001a\u0004\b4\u0010\u0014R\u001a\u0010\u001f\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010/\u001a\u0004\b6\u0010\u0014\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u00069"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "LC7/m;", "value", "constructor-impl", "(J)J", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "colorSpace", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "convert", "", "component1-impl", "(J)F", "component1", "component2-impl", "component2", "component3-impl", "component3", "component4-impl", "component4", "component5-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "component5", "alpha", "red", "green", "blue", "copy-wmQWz5c", "(JFFFF)J", "copy", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "J", "getValue-s-VKNKU", "()J", "getColorSpace-impl", "getColorSpace$annotations", "()V", "getRed-impl", "getRed$annotations", "getGreen-impl", "getGreen$annotations", "getBlue-impl", "getBlue$annotations", "getAlpha-impl", "getAlpha$annotations", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Color {
    private final long value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Black = ColorKt.Color(4278190080L);
    private static final long DarkGray = ColorKt.Color(4282664004L);
    private static final long Gray = ColorKt.Color(4287137928L);
    private static final long LightGray = ColorKt.Color(4291611852L);
    private static final long White = ColorKt.Color(4294967295L);
    private static final long Red = ColorKt.Color(4294901760L);
    private static final long Green = ColorKt.Color(4278255360L);
    private static final long Blue = ColorKt.Color(4278190335L);
    private static final long Yellow = ColorKt.Color(4294967040L);
    private static final long Cyan = ColorKt.Color(4278255615L);
    private static final long Magenta = ColorKt.Color(4294902015L);
    private static final long Transparent = ColorKt.Color(0);
    private static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u000205¢\u0006\u0004\b6\u00107J(\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010=\u001a\u000200H\u0002J9\u0010>\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010?\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u000205¢\u0006\u0004\b@\u00107J(\u0010A\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010B\u001a\u000200H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\bR\u001e\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b)\u0010\u0003\u001a\u0004\b*\u0010\bR\u001e\u0010+\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\b¨\u0006C"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", AppAgent.CONSTRUCT, "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "hsv", "hue", "", "saturation", "value", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsv-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hsvToRgbComponent", "n", "", "h", "s", "v", "hsl", "lightness", "hsl-JlNiLsg", "hslToRgbComponent", "l", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        /* renamed from: getBlack-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4150getBlack0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getBlue-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4151getBlue0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getCyan-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4152getCyan0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getDarkGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4153getDarkGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4154getGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getGreen-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4155getGreen0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getLightGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4156getLightGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getMagenta-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4157getMagenta0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getRed-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4158getRed0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getTransparent-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4159getTransparent0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getUnspecified-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4160getUnspecified0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getWhite-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4161getWhite0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getYellow-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4162getYellow0d7_KjU$annotations() {
        }

        /* renamed from: hsl-JlNiLsg$default, reason: not valid java name */
        public static /* synthetic */ long m4163hslJlNiLsg$default(Companion companion, float f, float f7, float f9, float f10, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f10 = 1.0f;
            }
            float f11 = f10;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m4178hslJlNiLsg(f, f7, f9, f11, rgb);
        }

        private final float hslToRgbComponent(int n, float h, float s5, float l) {
            float f = ((h / 30.0f) + n) % 12.0f;
            return l - (Math.max(-1.0f, Math.min(f - 3, Math.min(9 - f, 1.0f))) * (Math.min(l, 1.0f - l) * s5));
        }

        /* renamed from: hsv-JlNiLsg$default, reason: not valid java name */
        public static /* synthetic */ long m4164hsvJlNiLsg$default(Companion companion, float f, float f7, float f9, float f10, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f10 = 1.0f;
            }
            float f11 = f10;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m4179hsvJlNiLsg(f, f7, f9, f11, rgb);
        }

        private final float hsvToRgbComponent(int n, float h, float s5, float v10) {
            float f = ((h / 60.0f) + n) % 6.0f;
            return v10 - (Math.max(0.0f, Math.min(f, Math.min(4 - f, 1.0f))) * (s5 * v10));
        }

        /* renamed from: getBlack-0d7_KjU, reason: not valid java name */
        public final long m4165getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getBlue-0d7_KjU, reason: not valid java name */
        public final long m4166getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getCyan-0d7_KjU, reason: not valid java name */
        public final long m4167getCyan0d7_KjU() {
            return Color.Cyan;
        }

        /* renamed from: getDarkGray-0d7_KjU, reason: not valid java name */
        public final long m4168getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* renamed from: getGray-0d7_KjU, reason: not valid java name */
        public final long m4169getGray0d7_KjU() {
            return Color.Gray;
        }

        /* renamed from: getGreen-0d7_KjU, reason: not valid java name */
        public final long m4170getGreen0d7_KjU() {
            return Color.Green;
        }

        /* renamed from: getLightGray-0d7_KjU, reason: not valid java name */
        public final long m4171getLightGray0d7_KjU() {
            return Color.LightGray;
        }

        /* renamed from: getMagenta-0d7_KjU, reason: not valid java name */
        public final long m4172getMagenta0d7_KjU() {
            return Color.Magenta;
        }

        /* renamed from: getRed-0d7_KjU, reason: not valid java name */
        public final long m4173getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getTransparent-0d7_KjU, reason: not valid java name */
        public final long m4174getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU, reason: not valid java name */
        public final long m4175getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* renamed from: getWhite-0d7_KjU, reason: not valid java name */
        public final long m4176getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getYellow-0d7_KjU, reason: not valid java name */
        public final long m4177getYellow0d7_KjU() {
            return Color.Yellow;
        }

        /* renamed from: hsl-JlNiLsg, reason: not valid java name */
        public final long m4178hslJlNiLsg(float hue, float saturation, float lightness, float alpha, Rgb colorSpace) {
            if (!(0.0f <= hue && hue <= 360.0f && 0.0f <= saturation && saturation <= 1.0f && 0.0f <= lightness && lightness <= 1.0f)) {
                InlineClassHelperKt.throwIllegalArgumentException("HSL (" + hue + ", " + saturation + ", " + lightness + ") must be in range (0..360, 0..1, 0..1)");
            }
            return ColorKt.Color(hslToRgbComponent(0, hue, saturation, lightness), hslToRgbComponent(8, hue, saturation, lightness), hslToRgbComponent(4, hue, saturation, lightness), alpha, colorSpace);
        }

        /* renamed from: hsv-JlNiLsg, reason: not valid java name */
        public final long m4179hsvJlNiLsg(float hue, float saturation, float value, float alpha, Rgb colorSpace) {
            if (!(0.0f <= hue && hue <= 360.0f && 0.0f <= saturation && saturation <= 1.0f && 0.0f <= value && value <= 1.0f)) {
                InlineClassHelperKt.throwIllegalArgumentException("HSV (" + hue + ", " + saturation + ", " + value + ") must be in range (0..360, 0..1, 0..1)");
            }
            return ColorKt.Color(hsvToRgbComponent(5, hue, saturation, value), hsvToRgbComponent(3, hue, saturation, value), hsvToRgbComponent(1, hue, saturation, value), alpha, colorSpace);
        }

        private Companion() {
        }
    }

    private /* synthetic */ Color(long j5) {
        this.value = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m4129boximpl(long j5) {
        return new Color(j5);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m4130component1impl(long j5) {
        return m4145getRedimpl(j5);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m4131component2impl(long j5) {
        return m4144getGreenimpl(j5);
    }

    @Stable
    /* renamed from: component3-impl, reason: not valid java name */
    public static final float m4132component3impl(long j5) {
        return m4142getBlueimpl(j5);
    }

    @Stable
    /* renamed from: component4-impl, reason: not valid java name */
    public static final float m4133component4impl(long j5) {
        return m4141getAlphaimpl(j5);
    }

    @Stable
    /* renamed from: component5-impl, reason: not valid java name */
    public static final ColorSpace m4134component5impl(long j5) {
        return m4143getColorSpaceimpl(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4135constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m4136convertvNxB06k(long j5, ColorSpace colorSpace) {
        return ColorSpaceKt.m4575connectYBCOT_4$default(m4143getColorSpaceimpl(j5), colorSpace, 0, 2, null).mo4578transformToColorl2rxGTc$ui_graphics_release(j5);
    }

    @Stable
    /* renamed from: copy-wmQWz5c, reason: not valid java name */
    public static final long m4137copywmQWz5c(long j5, float f, float f7, float f9, float f10) {
        return ColorKt.Color(f7, f9, f10, f, m4143getColorSpaceimpl(j5));
    }

    /* renamed from: copy-wmQWz5c$default, reason: not valid java name */
    public static /* synthetic */ long m4138copywmQWz5c$default(long j5, float f, float f7, float f9, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m4141getAlphaimpl(j5);
        }
        float f11 = f;
        if ((i & 2) != 0) {
            f7 = m4145getRedimpl(j5);
        }
        float f12 = f7;
        if ((i & 4) != 0) {
            f9 = m4144getGreenimpl(j5);
        }
        float f13 = f9;
        if ((i & 8) != 0) {
            f10 = m4142getBlueimpl(j5);
        }
        return m4137copywmQWz5c(j5, f11, f12, f13, f10);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4139equalsimpl(long j5, Object obj) {
        return (obj instanceof Color) && j5 == ((Color) obj).m4149unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4140equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    @Stable
    public static /* synthetic */ void getAlpha$annotations() {
    }

    /* renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m4141getAlphaimpl(long j5) {
        float fO;
        float f;
        if ((63 & j5) == 0) {
            fO = (float) k.O((j5 >>> 56) & 255);
            f = 255.0f;
        } else {
            fO = (float) k.O((j5 >>> 6) & 1023);
            f = 1023.0f;
        }
        return fO / f;
    }

    @Stable
    public static /* synthetic */ void getBlue$annotations() {
    }

    /* renamed from: getBlue-impl, reason: not valid java name */
    public static final float m4142getBlueimpl(long j5) {
        int i;
        int i6;
        int i10;
        if ((63 & j5) == 0) {
            return ((float) k.O((j5 >>> 32) & 255)) / 255.0f;
        }
        short s5 = (short) ((j5 >>> 16) & 65535);
        int i11 = Short.MIN_VALUE & s5;
        int i12 = ((65535 & s5) >>> 10) & 31;
        int i13 = s5 & 1023;
        if (i12 != 0) {
            int i14 = i13 << 13;
            if (i12 == 31) {
                i = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i = i12 + 112;
            }
            int i15 = i;
            i6 = i14;
            i10 = i15;
        } else {
            if (i13 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i13 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i11 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i10 = 0;
            i6 = 0;
        }
        return Float.intBitsToFloat((i10 << 23) | (i11 << 16) | i6);
    }

    @Stable
    public static /* synthetic */ void getColorSpace$annotations() {
    }

    /* renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m4143getColorSpaceimpl(long j5) {
        return ColorSpaces.INSTANCE.getColorSpacesArray$ui_graphics_release()[(int) (j5 & 63)];
    }

    @Stable
    public static /* synthetic */ void getGreen$annotations() {
    }

    /* renamed from: getGreen-impl, reason: not valid java name */
    public static final float m4144getGreenimpl(long j5) {
        int i;
        int i6;
        int i10;
        if ((63 & j5) == 0) {
            return ((float) k.O((j5 >>> 40) & 255)) / 255.0f;
        }
        short s5 = (short) ((j5 >>> 32) & 65535);
        int i11 = Short.MIN_VALUE & s5;
        int i12 = ((65535 & s5) >>> 10) & 31;
        int i13 = s5 & 1023;
        if (i12 != 0) {
            int i14 = i13 << 13;
            if (i12 == 31) {
                i = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i = i12 + 112;
            }
            int i15 = i;
            i6 = i14;
            i10 = i15;
        } else {
            if (i13 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i13 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i11 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i10 = 0;
            i6 = 0;
        }
        return Float.intBitsToFloat((i10 << 23) | (i11 << 16) | i6);
    }

    @Stable
    public static /* synthetic */ void getRed$annotations() {
    }

    /* renamed from: getRed-impl, reason: not valid java name */
    public static final float m4145getRedimpl(long j5) {
        int i;
        int i6;
        int i10;
        if ((63 & j5) == 0) {
            return ((float) k.O((j5 >>> 48) & 255)) / 255.0f;
        }
        short s5 = (short) ((j5 >>> 48) & 65535);
        int i11 = Short.MIN_VALUE & s5;
        int i12 = ((65535 & s5) >>> 10) & 31;
        int i13 = s5 & 1023;
        if (i12 != 0) {
            int i14 = i13 << 13;
            if (i12 == 31) {
                i = 255;
                if (i14 != 0) {
                    i14 |= 4194304;
                }
            } else {
                i = i12 + 112;
            }
            int i15 = i;
            i6 = i14;
            i10 = i15;
        } else {
            if (i13 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i13 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i11 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i10 = 0;
            i6 = 0;
        }
        return Float.intBitsToFloat((i10 << 23) | (i11 << 16) | i6);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4146hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4147toStringimpl(long j5) {
        return "Color(" + m4145getRedimpl(j5) + ", " + m4144getGreenimpl(j5) + ", " + m4142getBlueimpl(j5) + ", " + m4141getAlphaimpl(j5) + ", " + m4143getColorSpaceimpl(j5).getName() + ')';
    }

    public boolean equals(Object other) {
        return m4139equalsimpl(this.value, other);
    }

    /* renamed from: getValue-s-VKNKU, reason: not valid java name and from getter */
    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        return m4146hashCodeimpl(this.value);
    }

    public String toString() {
        return m4147toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4149unboximpl() {
        return this.value;
    }
}
