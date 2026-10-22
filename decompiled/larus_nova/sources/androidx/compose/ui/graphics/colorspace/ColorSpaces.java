package androidx.compose.ui.graphics.colorspace;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010A\u001a\u0004\u0018\u0001042\b\b\u0001\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\rJ\u0016\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0080\b¢\u0006\u0002\bGJ\u001d\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020NH\u0000¢\u0006\u0002\bQJ\u001d\u0010R\u001a\u00020N2\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020NH\u0000¢\u0006\u0002\bSJ\u001d\u0010T\u001a\u00020N2\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020NH\u0000¢\u0006\u0002\bUJ\u001d\u0010V\u001a\u00020N2\u0006\u0010W\u001a\u00020\r2\u0006\u0010P\u001a\u00020NH\u0000¢\u0006\u0002\bXR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010!\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010#\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010%\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010'\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0011\u0010)\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0011\u0010+\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018R\u0011\u0010-\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0018R\u0011\u0010/\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0018R\u0011\u00101\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0018R\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0018R\u0011\u0010;\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0018R\u0011\u0010=\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0018R\u0011\u0010?\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b@\u00106R\u001c\u0010H\u001a\b\u0012\u0004\u0012\u0002040IX\u0080\u0004¢\u0006\n\n\u0002\u0010L\u001a\u0004\bJ\u0010K¨\u0006Y"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpaces;", "", "<init>", "()V", "SrgbPrimaries", "", "getSrgbPrimaries$ui_graphics_release", "()[F", "Ntsc1953Primaries", "getNtsc1953Primaries$ui_graphics_release", "Bt2020Primaries", "getBt2020Primaries$ui_graphics_release", "SrgbTransferParameters", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getSrgbTransferParameters$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "NoneTransferParameters", "Bt2020HlgTransferParameters", "getBt2020HlgTransferParameters$ui_graphics_release", "Bt2020PqTransferParameters", "getBt2020PqTransferParameters$ui_graphics_release", "Srgb", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "getSrgb", "()Landroidx/compose/ui/graphics/colorspace/Rgb;", "LinearSrgb", "getLinearSrgb", "ExtendedSrgb", "getExtendedSrgb", "LinearExtendedSrgb", "getLinearExtendedSrgb", "Bt709", "getBt709", "Bt2020", "getBt2020", "DciP3", "getDciP3", "DisplayP3", "getDisplayP3", "Ntsc1953", "getNtsc1953", "SmpteC", "getSmpteC", "AdobeRgb", "getAdobeRgb", "ProPhotoRgb", "getProPhotoRgb", "Aces", "getAces", "Acescg", "getAcescg", "CieXyz", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getCieXyz", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "CieLab", "getCieLab", "Unspecified", "getUnspecified$ui_graphics_release", "Bt2020Hlg", "getBt2020Hlg", "Bt2020Pq", "getBt2020Pq", "Oklab", "getOklab", "match", "toXYZD50", "function", "getColorSpace", "id", "", "getColorSpace$ui_graphics_release", "ColorSpacesArray", "", "getColorSpacesArray$ui_graphics_release", "()[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "transferHlgOetf", "", "params", "x", "transferHlgOetf$ui_graphics_release", "transferHlgEotf", "transferHlgEotf$ui_graphics_release", "transferSt2048Oetf", "transferSt2048Oetf$ui_graphics_release", "transferSt2048Eotf", "pq", "transferSt2048Eotf$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorSpaces {
    private static final Rgb Aces = null;
    private static final Rgb Acescg = null;
    private static final Rgb AdobeRgb = null;
    private static final Rgb Bt2020 = null;
    private static final Rgb Bt2020Hlg = null;
    private static final TransferParameters Bt2020HlgTransferParameters = null;
    private static final Rgb Bt2020Pq = null;
    private static final TransferParameters Bt2020PqTransferParameters = null;
    private static final float[] Bt2020Primaries = null;
    private static final Rgb Bt709 = null;
    private static final ColorSpace CieLab = null;
    private static final ColorSpace CieXyz = null;
    private static final ColorSpace[] ColorSpacesArray = null;
    private static final Rgb DciP3 = null;
    private static final Rgb DisplayP3 = null;
    private static final Rgb ExtendedSrgb = null;
    public static final ColorSpaces INSTANCE = null;
    private static final Rgb LinearExtendedSrgb = null;
    private static final Rgb LinearSrgb = null;
    private static final TransferParameters NoneTransferParameters = null;
    private static final Rgb Ntsc1953 = null;
    private static final float[] Ntsc1953Primaries = null;
    private static final ColorSpace Oklab = null;
    private static final Rgb ProPhotoRgb = null;
    private static final Rgb SmpteC = null;
    private static final Rgb Srgb = null;
    private static final float[] SrgbPrimaries = null;
    private static final TransferParameters SrgbTransferParameters = null;
    private static final Rgb Unspecified = null;

    private ColorSpaces() {
    }

    public static /* synthetic */ double a(double r100) {
        return Bt2020Pq$lambda$5(r100);
    }

    public static /* synthetic */ double b(double r100) {
        return ExtendedSrgb$lambda$0(r100);
    }

    public static /* synthetic */ double c(double r100) {
        return Bt2020Hlg$lambda$2(r100);
    }

    public static /* synthetic */ double d(double r100) {
        return ExtendedSrgb$lambda$1(r100);
    }

    public static /* synthetic */ double e(double r100) {
        return Bt2020Pq$lambda$4(r100);
    }

    public static /* synthetic */ double f(double r100) {
        return Bt2020Hlg$lambda$3(r100);
    }

    static {
        INSTANCE = new ColorSpaces();
        float[] r110 = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        SrgbPrimaries = r110;
        float[] r111 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        Ntsc1953Primaries = r111;
        float[] r112 = {0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f};
        Bt2020Primaries = r112;
        TransferParameters r310 = new TransferParameters(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 96, null);
        SrgbTransferParameters = r310;
        TransferParameters r113 = new TransferParameters(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 96, null);
        NoneTransferParameters = r113;
        TransferParameters r311 = new TransferParameters(-3.0d, 2.0d, 2.0d, 5.591816309728916d, 0.28466892d, 0.55991073d, -0.685490157d);
        Bt2020HlgTransferParameters = r311;
        TransferParameters r114 = new TransferParameters(-2.0d, -1.555223d, 1.860454d, 0.012683313515655966d, 18.8515625d, -18.6875d, 6.277394636015326d);
        Bt2020PqTransferParameters = r114;
        Illuminant r115 = Illuminant.INSTANCE;
        Rgb r116 = new Rgb("sRGB IEC61966-2.1", r110, r115.getD65(), r310, 0);
        Srgb = r116;
        Rgb r117 = new Rgb("sRGB IEC61966-2.1 (Linear)", r110, r115.getD65(), 1.0d, 0.0f, 1.0f, 1);
        LinearSrgb = r117;
        Rgb r210 = new Rgb("scRGB-nl IEC 61966-2-2:2003", r110, r115.getD65(), null, new a(), new b(), -0.799f, 2.399f, r310, 2);
        ExtendedSrgb = r210;
        Rgb r211 = new Rgb("scRGB IEC 61966-2-2:2003", r110, r115.getD65(), 1.0d, -0.5f, 7.499f, 3);
        LinearExtendedSrgb = r211;
        Rgb r212 = new Rgb("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, r115.getD65(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 96, null), 4);
        Bt709 = r212;
        Rgb r213 = new Rgb("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, r115.getD65(), new TransferParameters(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 96, null), 5);
        Bt2020 = r213;
        Rgb r214 = new Rgb("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new WhitePoint(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        DciP3 = r214;
        Rgb r215 = new Rgb("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, r115.getD65(), r310, 7);
        DisplayP3 = r215;
        Rgb r216 = new Rgb("NTSC (1953)", r111, r115.getC(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 96, null), 8);
        Ntsc1953 = r216;
        Rgb r118 = new Rgb("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, r115.getD65(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 96, null), 9);
        SmpteC = r118;
        Rgb r217 = new Rgb("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, r115.getD65(), 2.2d, 0.0f, 1.0f, 10);
        AdobeRgb = r217;
        Rgb r218 = new Rgb("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, r115.getD50(), new TransferParameters(1.8d, 1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 0.0625d, 0.031248d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 96, null), 11);
        ProPhotoRgb = r218;
        Rgb r219 = new Rgb("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, r115.getD60(), 1.0d, -65504.0f, 65504.0f, 12);
        Aces = r219;
        Rgb r312 = new Rgb("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, r115.getD60(), 1.0d, -65504.0f, 65504.0f, 13);
        Acescg = r312;
        Xyz r119 = new Xyz("Generic XYZ", 14);
        CieXyz = r119;
        Lab r100 = new Lab("Generic L*a*b*", 15);
        CieLab = r100;
        Rgb r313 = new Rgb("None", r110, r115.getD65(), r113, 16);
        Unspecified = r313;
        Rgb r120 = new Rgb("Hybrid Log Gamma encoding", r112, r115.getD65(), null, new c(), new d(), 0.0f, 1.0f, r311, 17);
        Bt2020Hlg = r120;
        Rgb r314 = new Rgb("Perceptual Quantizer encoding", r112, r115.getD65(), null, new e(), new f(), 0.0f, 1.0f, r114, 18);
        Bt2020Pq = r314;
        Oklab r101 = new Oklab("Oklab", 19);
        Oklab = r101;
        ColorSpacesArray = new ColorSpace[]{r116, r117, r210, r211, r212, r213, r214, r215, r216, r118, r217, r218, r219, r312, r119, r100, r313, r120, r314, r101};
    }

    public final Rgb getAces() {
        return Aces;
    }

    public final Rgb getAcescg() {
        return Acescg;
    }

    public final Rgb getAdobeRgb() {
        return AdobeRgb;
    }

    public final Rgb getBt2020() {
        return Bt2020;
    }

    public final Rgb getBt2020Hlg() {
        return Bt2020Hlg;
    }

    public final TransferParameters getBt2020HlgTransferParameters$ui_graphics_release() {
        return Bt2020HlgTransferParameters;
    }

    public final Rgb getBt2020Pq() {
        return Bt2020Pq;
    }

    public final TransferParameters getBt2020PqTransferParameters$ui_graphics_release() {
        return Bt2020PqTransferParameters;
    }

    public final float[] getBt2020Primaries$ui_graphics_release() {
        return Bt2020Primaries;
    }

    public final Rgb getBt709() {
        return Bt709;
    }

    public final ColorSpace getCieLab() {
        return CieLab;
    }

    public final ColorSpace getCieXyz() {
        return CieXyz;
    }

    public final ColorSpace[] getColorSpacesArray$ui_graphics_release() {
        return ColorSpacesArray;
    }

    public final Rgb getDciP3() {
        return DciP3;
    }

    public final Rgb getDisplayP3() {
        return DisplayP3;
    }

    public final Rgb getExtendedSrgb() {
        return ExtendedSrgb;
    }

    public final Rgb getLinearExtendedSrgb() {
        return LinearExtendedSrgb;
    }

    public final Rgb getLinearSrgb() {
        return LinearSrgb;
    }

    public final Rgb getNtsc1953() {
        return Ntsc1953;
    }

    public final float[] getNtsc1953Primaries$ui_graphics_release() {
        return Ntsc1953Primaries;
    }

    public final ColorSpace getOklab() {
        return Oklab;
    }

    public final Rgb getProPhotoRgb() {
        return ProPhotoRgb;
    }

    public final Rgb getSmpteC() {
        return SmpteC;
    }

    public final Rgb getSrgb() {
        return Srgb;
    }

    public final float[] getSrgbPrimaries$ui_graphics_release() {
        return SrgbPrimaries;
    }

    public final TransferParameters getSrgbTransferParameters$ui_graphics_release() {
        return SrgbTransferParameters;
    }

    public final Rgb getUnspecified$ui_graphics_release() {
        return Unspecified;
    }

    private static final double Bt2020Hlg$lambda$2(double r100) {
        return INSTANCE.transferHlgOetf$ui_graphics_release(Bt2020HlgTransferParameters, r100);
    }

    private static final double Bt2020Hlg$lambda$3(double r100) {
        return INSTANCE.transferHlgEotf$ui_graphics_release(Bt2020HlgTransferParameters, r100);
    }

    private static final double Bt2020Pq$lambda$4(double r100) {
        return INSTANCE.transferSt2048Oetf$ui_graphics_release(Bt2020PqTransferParameters, r100);
    }

    private static final double Bt2020Pq$lambda$5(double r100) {
        return INSTANCE.transferSt2048Eotf$ui_graphics_release(Bt2020PqTransferParameters, r100);
    }

    private static final double ExtendedSrgb$lambda$0(double r110) {
        return ColorSpaceKt.absRcpResponse(r110, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    private static final double ExtendedSrgb$lambda$1(double r110) {
        return ColorSpaceKt.absResponse(r110, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    public final ColorSpace getColorSpace$ui_graphics_release(int r100) {
        return getColorSpacesArray$ui_graphics_release()[r100];
    }

    public final ColorSpace match(float[] r110, TransferParameters r111) {
        ColorSpace[] r100 = ColorSpacesArray;
        int r101 = r100.length;
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L13;
        ColorSpace r103 = r100[r102];
        if (ColorModel.m5261equalsimpl0(r103.m5270getModelxdoWZVw(), ColorModel.Companion.m5268getRgbxdoWZVw()) == false) goto L12;
        ColorSpace r104 = ColorSpaceKt.adapt$default(r103, Illuminant.INSTANCE.getD50(), null, 2, null);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Rgb r105 = (Rgb) r104;
        if (ColorSpaceKt.compare(r110, r105.getTransform$ui_graphics_release()) == false) goto L12;
        if (ColorSpaceKt.compare(r111, r105.getTransferParameters()) == false) goto L12;
        return r103;
    L12:
        r102 = r102 + 1;
        goto L4
    L13:
        return null;
    }

    public final double transferHlgEotf$ui_graphics_release(TransferParameters r210, double r211) {
        if (r211 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r100 = -1.0d;
    L6:
        double r101 = r211 * r100;
        double r102 = r210.getA();
        double r103 = r210.getB();
        double r110 = r210.getC();
        double r111 = r210.getD();
        double r112 = r210.getE();
        double r113 = r210.getF() + 1.0d;
        double r104 = r102 * r101;
        if (r104 > 1.0d) goto L9;
        double r105 = Math.pow(r104, r103);
    L11:
        return (r113 * r100) * r105;
    L9:
        r105 = Math.exp((r101 - r112) * r110) + r111;
        goto L11
    L5:
        r100 = 1.0d;
        goto L6
    }

    public final double transferHlgOetf$ui_graphics_release(TransferParameters r110, double r210) {
        if (r210 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r100 = -1.0d;
    L6:
        double r101 = 1.0d / r110.getA();
        double r102 = 1.0d / r110.getB();
        double r111 = 1.0d / r110.getC();
        double r112 = r110.getD();
        double r113 = r110.getE();
        double r103 = (r210 * r100) / (r110.getF() + 1.0d);
        if (r103 > 1.0d) goto L9;
        double r104 = r101 * Math.pow(r103, r102);
    L11:
        return r100 * r104;
    L9:
        r104 = (r111 * Math.log(r103 - r112)) + r113;
        goto L11
    L5:
        r100 = 1.0d;
        goto L6
    }

    public final double transferSt2048Eotf$ui_graphics_release(TransferParameters r110, double r111) {
        if (r111 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r100 = -1.0d;
    L6:
        double r112 = r111 * r100;
        return r100 * Math.pow(RangesKt.coerceAtLeast(r110.getA() + (r110.getB() * Math.pow(r112, r110.getC())), AudioStats.AUDIO_AMPLITUDE_NONE) / (r110.getD() + (r110.getE() * Math.pow(r112, r110.getC()))), r110.getF());
    L5:
        r100 = 1.0d;
        goto L6
    }

    public final double transferSt2048Oetf$ui_graphics_release(TransferParameters r110, double r210) {
        if (r210 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r100 = -1.0d;
    L6:
        double r101 = r210 * r100;
        double r102 = -r110.getA();
        double r111 = r110.getD();
        double r112 = 1.0d / r110.getF();
        double r113 = r110.getB();
        double r103 = -r110.getE();
        return r100 * Math.pow(Math.max(r102 + (r111 * Math.pow(r101, r112)), AudioStats.AUDIO_AMPLITUDE_NONE) / (r113 + (r103 * Math.pow(r101, r112))), 1.0d / r110.getC());
    L5:
        r100 = 1.0d;
        goto L6
    }
}
