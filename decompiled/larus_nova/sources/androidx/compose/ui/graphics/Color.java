package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 62\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010 \u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b!\u0010\u0016J\u0010\u0010\"\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b#\u0010\u0016J\u0010\u0010$\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u0016J\u0010\u0010&\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b'\u0010\u0016J\u0010\u0010(\u001a\u00020\nH\u0087\n¢\u0006\u0004\b)\u0010\u000eJ7\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0013H\u0007¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u0016\u0088\u0001\u0002¨\u00067"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "getValue-s-VKNKU", "()J", "J", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "()V", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "red", "", "getRed$annotations", "getRed-impl", "(J)F", "green", "getGreen$annotations", "getGreen-impl", "blue", "getBlue$annotations", "getBlue-impl", "alpha", "getAlpha$annotations", "getAlpha-impl", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "copy", "copy-wmQWz5c", "(JFFFF)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Color {
    private static final long Black = 0;
    private static final long Blue = 0;
    public static final Companion Companion = null;
    private static final long Cyan = 0;
    private static final long DarkGray = 0;
    private static final long Gray = 0;
    private static final long Green = 0;
    private static final long LightGray = 0;
    private static final long Magenta = 0;
    private static final long Red = 0;
    private static final long Transparent = 0;
    private static final long Unspecified = 0;
    private static final long White = 0;
    private static final long Yellow = 0;
    private final long value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u000205¢\u0006\u0004\b6\u00107J(\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010=\u001a\u000200H\u0002J9\u0010>\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010?\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u000205¢\u0006\u0004\b@\u00107J(\u0010A\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010B\u001a\u000200H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\bR\u001e\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b)\u0010\u0003\u001a\u0004\b*\u0010\bR\u001e\u0010+\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\b¨\u0006C"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "<init>", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "hsv", "hue", "", "saturation", "value", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsv-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hsvToRgbComponent", OfficeSDKRequestTag.KEY_NEW_USER, "", "h", "s", BaseSwitches.V, "hsl", "lightness", "hsl-JlNiLsg", "hslToRgbComponent", "l", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getBlack-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4838getBlack0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getBlue-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4839getBlue0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getCyan-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4840getCyan0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getDarkGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4841getDarkGray0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4842getGray0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getGreen-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4843getGreen0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getLightGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4844getLightGray0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getMagenta-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4845getMagenta0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getRed-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4846getRed0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getTransparent-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4847getTransparent0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4848getUnspecified0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getWhite-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4849getWhite0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getYellow-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m4850getYellow0d7_KjU$annotations() {
        }

        /* JADX INFO: renamed from: getBlack-0d7_KjU, reason: not valid java name */
        public final long m4853getBlack0d7_KjU() {
            return Color.access$getBlack$cp();
        }

        /* JADX INFO: renamed from: getBlue-0d7_KjU, reason: not valid java name */
        public final long m4854getBlue0d7_KjU() {
            return Color.access$getBlue$cp();
        }

        /* JADX INFO: renamed from: getCyan-0d7_KjU, reason: not valid java name */
        public final long m4855getCyan0d7_KjU() {
            return Color.access$getCyan$cp();
        }

        /* JADX INFO: renamed from: getDarkGray-0d7_KjU, reason: not valid java name */
        public final long m4856getDarkGray0d7_KjU() {
            return Color.access$getDarkGray$cp();
        }

        /* JADX INFO: renamed from: getGray-0d7_KjU, reason: not valid java name */
        public final long m4857getGray0d7_KjU() {
            return Color.access$getGray$cp();
        }

        /* JADX INFO: renamed from: getGreen-0d7_KjU, reason: not valid java name */
        public final long m4858getGreen0d7_KjU() {
            return Color.access$getGreen$cp();
        }

        /* JADX INFO: renamed from: getLightGray-0d7_KjU, reason: not valid java name */
        public final long m4859getLightGray0d7_KjU() {
            return Color.access$getLightGray$cp();
        }

        /* JADX INFO: renamed from: getMagenta-0d7_KjU, reason: not valid java name */
        public final long m4860getMagenta0d7_KjU() {
            return Color.access$getMagenta$cp();
        }

        /* JADX INFO: renamed from: getRed-0d7_KjU, reason: not valid java name */
        public final long m4861getRed0d7_KjU() {
            return Color.access$getRed$cp();
        }

        /* JADX INFO: renamed from: getTransparent-0d7_KjU, reason: not valid java name */
        public final long m4862getTransparent0d7_KjU() {
            return Color.access$getTransparent$cp();
        }

        /* JADX INFO: renamed from: getUnspecified-0d7_KjU, reason: not valid java name */
        public final long m4863getUnspecified0d7_KjU() {
            return Color.access$getUnspecified$cp();
        }

        /* JADX INFO: renamed from: getWhite-0d7_KjU, reason: not valid java name */
        public final long m4864getWhite0d7_KjU() {
            return Color.access$getWhite$cp();
        }

        /* JADX INFO: renamed from: getYellow-0d7_KjU, reason: not valid java name */
        public final long m4865getYellow0d7_KjU() {
            return Color.access$getYellow$cp();
        }

        private final float hslToRgbComponent(int r100, float r101, float r102, float r103) {
            float r104 = (r100 + (r101 / 30.0f)) % 12.0f;
            return r103 - ((r102 * Math.min(r103, 1.0f - r103)) * Math.max(-1.0f, Math.min(r104 - 3, Math.min(9 - r104, 1.0f))));
        }

        private final float hsvToRgbComponent(int r100, float r101, float r102, float r103) {
            float r104 = (r100 + (r101 / 60.0f)) % 6.0f;
            return r103 - ((r102 * r103) * Math.max(0.0f, Math.min(r104, Math.min(4 - r104, 1.0f))));
        }

        /* JADX INFO: renamed from: hsl-JlNiLsg, reason: not valid java name */
        public final long m4866hslJlNiLsg(float r100, float r101, float r102, float r103, Rgb r110) {
            boolean r104 = true;
            if (0.0f <= r100) goto L5;
        L7:
            boolean r105 = false;
        L8:
            if (r105 == true) goto L10;
        L24:
            r104 = false;
        L25:
            if (r104 == true) goto L28;
            InlineClassHelperKt.throwIllegalArgumentException("HSL (" + r100 + ", " + r101 + ", " + r102 + ") must be in range (0..360, 0..1, 0..1)");
        L28:
            return ColorKt.Color(hslToRgbComponent(0, r100, r101, r102), hslToRgbComponent(8, r100, r101, r102), hslToRgbComponent(4, r100, r101, r102), r103, r110);
        L10:
            if (0.0f <= r101) goto L12;
        L14:
            boolean r106 = false;
        L15:
            if (r106 == false) goto L24;
            if (0.0f <= r102) goto L19;
        L21:
            boolean r107 = false;
        L22:
            if (r107 == false) goto L24;
        L19:
            if (r102 > 1.0f) goto L21;
            r107 = true;
            goto L22
        L12:
            if (r101 > 1.0f) goto L14;
            r106 = true;
            goto L15
        L5:
            if (r100 > 360.0f) goto L7;
            r105 = true;
            goto L8
        }

        /* JADX INFO: renamed from: hsv-JlNiLsg, reason: not valid java name */
        public final long m4867hsvJlNiLsg(float r100, float r101, float r102, float r103, Rgb r110) {
            boolean r104 = false;
            if (0.0f <= r100) goto L5;
        L7:
            boolean r105 = false;
        L8:
            if (r105 == true) goto L10;
        L24:
            if (r104 == true) goto L27;
            InlineClassHelperKt.throwIllegalArgumentException("HSV (" + r100 + ", " + r101 + ", " + r102 + ") must be in range (0..360, 0..1, 0..1)");
        L27:
            return ColorKt.Color(hsvToRgbComponent(5, r100, r101, r102), hsvToRgbComponent(3, r100, r101, r102), hsvToRgbComponent(1, r100, r101, r102), r103, r110);
        L10:
            if (0.0f <= r101) goto L12;
        L14:
            boolean r106 = false;
        L15:
            if (r106 == false) goto L24;
            if (0.0f <= r102) goto L19;
        L21:
            boolean r107 = false;
        L22:
            if (r107 == false) goto L24;
            r104 = true;
            goto L24
        L19:
            if (r102 > 1.0f) goto L21;
            r107 = true;
            goto L22
        L12:
            if (r101 > 1.0f) goto L14;
            r106 = true;
            goto L15
        L5:
            if (r100 > 360.0f) goto L7;
            r105 = true;
            goto L8
        }

        /* JADX INFO: renamed from: hsl-JlNiLsg$default, reason: not valid java name */
        public static /* synthetic */ long m4851hslJlNiLsg$default(Companion r100, float r101, float r102, float r103, float r110, Rgb r111, int r112, Object r113) {
            if ((r112 & 8) == 0) goto L5;
            float r104 = 1.0f;
        L7:
            if ((r112 & 16) == 0) goto L10;
            r111 = ColorSpaces.INSTANCE.getSrgb();
        L10:
            return r100.m4866hslJlNiLsg(r101, r102, r103, r104, r111);
        L5:
            r104 = r110;
            goto L7
        }

        /* JADX INFO: renamed from: hsv-JlNiLsg$default, reason: not valid java name */
        public static /* synthetic */ long m4852hsvJlNiLsg$default(Companion r100, float r101, float r102, float r103, float r110, Rgb r111, int r112, Object r113) {
            if ((r112 & 8) == 0) goto L5;
            float r104 = 1.0f;
        L7:
            if ((r112 & 16) == 0) goto L10;
            r111 = ColorSpaces.INSTANCE.getSrgb();
        L10:
            return r100.m4867hsvJlNiLsg(r101, r102, r103, r104, r111);
        L5:
            r104 = r110;
            goto L7
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m4817boximpl(long r100) {
        return new Color(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m4823constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4827equalsimpl(long r100, Object r101) {
        if ((r101 instanceof Color) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Color) r101).m4837unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4828equalsimpl0(long r100, long r101) {
        return ULong.m9630equalsimpl0(r100, r101);
    }

    public static /* synthetic */ void getAlpha$annotations() {
    }

    public static /* synthetic */ void getBlue$annotations() {
    }

    public static /* synthetic */ void getColorSpace$annotations() {
    }

    public static /* synthetic */ void getGreen$annotations() {
    }

    public static /* synthetic */ void getRed$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4834hashCodeimpl(long r100) {
        return ULong.m9635hashCodeimpl(r100);
    }

    public boolean equals(Object r100) {
        return m4827equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m4834hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4837unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Black = ColorKt.Color(4278190080L);
        DarkGray = ColorKt.Color(4282664004L);
        Gray = ColorKt.Color(4287137928L);
        LightGray = ColorKt.Color(4291611852L);
        White = ColorKt.Color(BodyPartID.bodyIdMax);
        Red = ColorKt.Color(4294901760L);
        Green = ColorKt.Color(4278255360L);
        Blue = ColorKt.Color(4278190335L);
        Yellow = ColorKt.Color(4294967040L);
        Cyan = ColorKt.Color(4278255615L);
        Magenta = ColorKt.Color(4294902015L);
        Transparent = ColorKt.Color(0);
        Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());
    }

    public String toString() {
        return m4835toStringimpl(this.value);
    }

    public static final /* synthetic */ long access$getBlack$cp() {
        return Black;
    }

    public static final /* synthetic */ long access$getBlue$cp() {
        return Blue;
    }

    public static final /* synthetic */ long access$getCyan$cp() {
        return Cyan;
    }

    public static final /* synthetic */ long access$getDarkGray$cp() {
        return DarkGray;
    }

    public static final /* synthetic */ long access$getGray$cp() {
        return Gray;
    }

    public static final /* synthetic */ long access$getGreen$cp() {
        return Green;
    }

    public static final /* synthetic */ long access$getLightGray$cp() {
        return LightGray;
    }

    public static final /* synthetic */ long access$getMagenta$cp() {
        return Magenta;
    }

    public static final /* synthetic */ long access$getRed$cp() {
        return Red;
    }

    public static final /* synthetic */ long access$getTransparent$cp() {
        return Transparent;
    }

    public static final /* synthetic */ long access$getUnspecified$cp() {
        return Unspecified;
    }

    public static final /* synthetic */ long access$getWhite$cp() {
        return White;
    }

    public static final /* synthetic */ long access$getYellow$cp() {
        return Yellow;
    }

    /* JADX INFO: renamed from: getValue-s-VKNKU, reason: not valid java name */
    public final long m4836getValuesVKNKU() {
        return this.value;
    }

    private /* synthetic */ Color(long r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m4818component1impl(long r100) {
        return m4833getRedimpl(r100);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m4819component2impl(long r100) {
        return m4832getGreenimpl(r100);
    }

    /* JADX INFO: renamed from: component3-impl, reason: not valid java name */
    public static final float m4820component3impl(long r100) {
        return m4830getBlueimpl(r100);
    }

    /* JADX INFO: renamed from: component4-impl, reason: not valid java name */
    public static final float m4821component4impl(long r100) {
        return m4829getAlphaimpl(r100);
    }

    /* JADX INFO: renamed from: component5-impl, reason: not valid java name */
    public static final ColorSpace m4822component5impl(long r100) {
        return m4831getColorSpaceimpl(r100);
    }

    /* JADX INFO: renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m4829getAlphaimpl(long r100) {
        if (ULong.m9623constructorimpl(63 & r100) != 0) goto L5;
        float r101 = (float) UnsignedKt.ulongToDouble(ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 >>> 56) & 255));
        float r102 = 255.0f;
    L7:
        return r101 / r102;
    L5:
        r101 = (float) UnsignedKt.ulongToDouble(ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 >>> 6) & 1023));
        r102 = 1023.0f;
        goto L7
    }

    /* JADX INFO: renamed from: getBlue-impl, reason: not valid java name */
    public static final float m4830getBlueimpl(long r100) {
        if (ULong.m9623constructorimpl(63 & r100) == 0) goto L22;
        int r101 = ((short) ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 >>> 16) & 65535)) & 65535;
        int r102 = 32768 & r101;
        int r103 = (r101 >>> 10) & 31;
        int r104 = r101 & 1023;
        if (r103 != 0) goto L13;
        if (r104 == 0) goto L12;
        float r105 = Float.intBitsToFloat(r104 + 1056964608) - Float16Kt.access$getFp32DenormalFloat$p();
        if (r102 != 0) goto L23;
        return r105;
    L23:
        return -r105;
    L12:
        int r106 = 0;
        int r107 = 0;
    L21:
        return Float.intBitsToFloat(((r106 << 23) | (r102 << 16)) | r107);
    L13:
        int r108 = r104 << 13;
        if (r103 == 31) goto L16;
        int r109 = (r103 - 15) + 127;
        r107 = r108;
        r106 = r109;
        goto L21
    L16:
        if (r108 == 0) goto L18;
        r108 = r108 | 4194304;
    L18:
        r107 = r108;
        r106 = 255;
        goto L21
    L22:
        return ((float) UnsignedKt.ulongToDouble(ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 >>> 32) & 255))) / 255.0f;
    }

    /* JADX INFO: renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m4831getColorSpaceimpl(long r100) {
        ColorSpaces r101 = ColorSpaces.INSTANCE;
        int r102 = (int) ULong.m9623constructorimpl(r100 & 63);
        return r101.getColorSpacesArray$ui_graphics_release()[r102];
    }

    /* JADX INFO: renamed from: getGreen-impl, reason: not valid java name */
    public static final float m4832getGreenimpl(long r100) {
        if (ULong.m9623constructorimpl(63 & r100) == 0) goto L22;
        int r101 = ((short) ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 >>> 32) & 65535)) & 65535;
        int r102 = 32768 & r101;
        int r103 = (r101 >>> 10) & 31;
        int r104 = r101 & 1023;
        if (r103 != 0) goto L13;
        if (r104 == 0) goto L12;
        float r105 = Float.intBitsToFloat(r104 + 1056964608) - Float16Kt.access$getFp32DenormalFloat$p();
        if (r102 != 0) goto L23;
        return r105;
    L23:
        return -r105;
    L12:
        int r106 = 0;
        int r107 = 0;
    L21:
        return Float.intBitsToFloat(((r106 << 23) | (r102 << 16)) | r107);
    L13:
        int r108 = r104 << 13;
        if (r103 == 31) goto L16;
        int r109 = (r103 - 15) + 127;
        r107 = r108;
        r106 = r109;
        goto L21
    L16:
        if (r108 == 0) goto L18;
        r108 = r108 | 4194304;
    L18:
        r107 = r108;
        r106 = 255;
        goto L21
    L22:
        return ((float) UnsignedKt.ulongToDouble(ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 >>> 40) & 255))) / 255.0f;
    }

    /* JADX INFO: renamed from: getRed-impl, reason: not valid java name */
    public static final float m4833getRedimpl(long r100) {
        if (ULong.m9623constructorimpl(63 & r100) == 0) goto L22;
        int r101 = ((short) ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 >>> 48) & 65535)) & 65535;
        int r102 = 32768 & r101;
        int r103 = (r101 >>> 10) & 31;
        int r104 = r101 & 1023;
        if (r103 != 0) goto L13;
        if (r104 == 0) goto L12;
        float r105 = Float.intBitsToFloat(r104 + 1056964608) - Float16Kt.access$getFp32DenormalFloat$p();
        if (r102 != 0) goto L23;
        return r105;
    L23:
        return -r105;
    L12:
        int r106 = 0;
        int r107 = 0;
    L21:
        return Float.intBitsToFloat(((r106 << 23) | (r102 << 16)) | r107);
    L13:
        int r108 = r104 << 13;
        if (r103 == 31) goto L16;
        int r109 = (r103 - 15) + 127;
        r107 = r108;
        r106 = r109;
        goto L21
    L16:
        if (r108 == 0) goto L18;
        r108 = r108 | 4194304;
    L18:
        r107 = r108;
        r106 = 255;
        goto L21
    L22:
        return ((float) UnsignedKt.ulongToDouble(ULong.m9623constructorimpl(ULong.m9623constructorimpl(r100 >>> 48) & 255))) / 255.0f;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4835toStringimpl(long r100) {
        return "Color(" + m4833getRedimpl(r100) + ", " + m4832getGreenimpl(r100) + ", " + m4830getBlueimpl(r100) + ", " + m4829getAlphaimpl(r100) + ", " + m4831getColorSpaceimpl(r100).getName() + ')';
    }

    /* JADX INFO: renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m4824convertvNxB06k(long r100, ColorSpace r101) {
        return ColorSpaceKt.m5273connectYBCOT_4$default(m4831getColorSpaceimpl(r100), r101, 0, 2, null).mo5276transformToColorl2rxGTc$ui_graphics_release(r100);
    }

    /* JADX INFO: renamed from: copy-wmQWz5c, reason: not valid java name */
    public static final long m4825copywmQWz5c(long r100, float r101, float r102, float r103, float r104) {
        return ColorKt.Color(r102, r103, r104, r101, m4831getColorSpaceimpl(r100));
    }

    /* JADX INFO: renamed from: copy-wmQWz5c$default, reason: not valid java name */
    public static /* synthetic */ long m4826copywmQWz5c$default(long r100, float r101, float r102, float r110, float r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = m4829getAlphaimpl(r100);
    L5:
        float r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = m4833getRedimpl(r100);
    L8:
        float r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = m4832getGreenimpl(r100);
    L11:
        float r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = m4830getBlueimpl(r100);
    L15:
        return m4825copywmQWz5c(r100, r103, r104, r105, r111);
    }
}
