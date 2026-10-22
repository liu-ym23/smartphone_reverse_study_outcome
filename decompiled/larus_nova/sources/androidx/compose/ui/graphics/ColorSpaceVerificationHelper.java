package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import android.os.Build;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import java.util.function.DoubleUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0007J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelper;", "", "<init>", "()V", "androidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "composeColorSpace", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE = null;

    static {
        INSTANCE = new ColorSpaceVerificationHelper();
    }

    private ColorSpaceVerificationHelper() {
    }

    public static /* synthetic */ double a(Function1 r100, double r101) {
        return androidColorSpace$lambda$1(r100, r101);
    }

    public static /* synthetic */ double b(ColorSpace r100, double r101) {
        return composeColorSpace$lambda$2(r100, r101);
    }

    public static /* synthetic */ double c(Function1 r100, double r101) {
        return androidColorSpace$lambda$0(r100, r101);
    }

    public static /* synthetic */ double d(ColorSpace r100, double r101) {
        return composeColorSpace$lambda$3(r100, r101);
    }

    @JvmStatic
    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace r210) {
        ColorSpaces r100 = ColorSpaces.INSTANCE;
        if (Intrinsics.areEqual(r210, r100.getSrgb()) == false) goto L6;
        return ColorSpace.get(ColorSpace.Named.SRGB);
    L6:
        if (Intrinsics.areEqual(r210, r100.getAces()) == false) goto L9;
        return ColorSpace.get(ColorSpace.Named.ACES);
    L9:
        if (Intrinsics.areEqual(r210, r100.getAcescg()) == false) goto L12;
        return ColorSpace.get(ColorSpace.Named.ACESCG);
    L12:
        if (Intrinsics.areEqual(r210, r100.getAdobeRgb()) == false) goto L15;
        return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
    L15:
        if (Intrinsics.areEqual(r210, r100.getBt2020()) == false) goto L18;
        return ColorSpace.get(ColorSpace.Named.BT2020);
    L18:
        if (Intrinsics.areEqual(r210, r100.getBt709()) == false) goto L21;
        return ColorSpace.get(ColorSpace.Named.BT709);
    L21:
        if (Intrinsics.areEqual(r210, r100.getCieLab()) == false) goto L24;
        return ColorSpace.get(ColorSpace.Named.CIE_LAB);
    L24:
        if (Intrinsics.areEqual(r210, r100.getCieXyz()) == false) goto L27;
        return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
    L27:
        if (Intrinsics.areEqual(r210, r100.getDciP3()) == false) goto L30;
        return ColorSpace.get(ColorSpace.Named.DCI_P3);
    L30:
        if (Intrinsics.areEqual(r210, r100.getDisplayP3()) == false) goto L33;
        return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
    L33:
        if (Intrinsics.areEqual(r210, r100.getExtendedSrgb()) == false) goto L36;
        return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
    L36:
        if (Intrinsics.areEqual(r210, r100.getLinearExtendedSrgb()) == false) goto L39;
        return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
    L39:
        if (Intrinsics.areEqual(r210, r100.getLinearSrgb()) == false) goto L42;
        return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
    L42:
        if (Intrinsics.areEqual(r210, r100.getNtsc1953()) == false) goto L45;
        return ColorSpace.get(ColorSpace.Named.NTSC_1953);
    L45:
        if (Intrinsics.areEqual(r210, r100.getProPhotoRgb()) == false) goto L48;
        return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
    L48:
        if (Intrinsics.areEqual(r210, r100.getSmpteC()) == false) goto L51;
        return ColorSpace.get(ColorSpace.Named.SMPTE_C);
    L51:
        if (Build.VERSION.SDK_INT < 34) goto L56;
        ColorSpace r101 = ColorSpaceVerificationHelperV34.obtainAndroidColorSpace(r210);
        if (r101 == null) goto L56;
        return r101;
    L56:
        if ((r210 instanceof Rgb) == false) goto L66;
        Rgb r102 = (Rgb) r210;
        float[] r103 = r102.getWhitePoint().toXyz$ui_graphics_release();
        TransferParameters r104 = r102.getTransferParameters();
        if (r104 == null) goto L60;
        ColorSpace.Rgb.TransferParameters r105 = new ColorSpace.Rgb.TransferParameters(r104.getA(), r104.getB(), r104.getC(), r104.getD(), r104.getE(), r104.getF(), r104.getGamma());
    L61:
        if (r105 == null) goto L63;
        ColorSpace.Rgb r106 = new ColorSpace.Rgb(r210.getName(), ((Rgb) r210).getPrimaries$ui_graphics_release(), r103, r105);
    L83:
        return r106;
    L63:
        String r107 = r210.getName();
        Rgb r108 = (Rgb) r210;
        float[] r109 = r108.getPrimaries$ui_graphics_release();
        final Function1<Double, Double> r110 = r108.getOetf();
        DoubleUnaryOperator r111 = new a(r110);
        final Function1<Double, Double> r112 = r108.getEotf();
        r106 = new ColorSpace.Rgb(r107, r109, r103, r111, new b(r112), r108.getMinValue(0), r108.getMaxValue(0));
        goto L83
    L60:
        r105 = null;
        goto L61
    L66:
        return ColorSpace.get(ColorSpace.Named.SRGB);
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(final ColorSpace r210) {
        int r100 = r210.getId();
        if (r100 != ColorSpace.Named.SRGB.ordinal()) goto L6;
        return ColorSpaces.INSTANCE.getSrgb();
    L6:
        if (r100 != ColorSpace.Named.ACES.ordinal()) goto L9;
        return ColorSpaces.INSTANCE.getAces();
    L9:
        if (r100 != ColorSpace.Named.ACESCG.ordinal()) goto L12;
        return ColorSpaces.INSTANCE.getAcescg();
    L12:
        if (r100 != ColorSpace.Named.ADOBE_RGB.ordinal()) goto L15;
        return ColorSpaces.INSTANCE.getAdobeRgb();
    L15:
        if (r100 != ColorSpace.Named.BT2020.ordinal()) goto L18;
        return ColorSpaces.INSTANCE.getBt2020();
    L18:
        if (r100 != ColorSpace.Named.BT709.ordinal()) goto L21;
        return ColorSpaces.INSTANCE.getBt709();
    L21:
        if (r100 != ColorSpace.Named.CIE_LAB.ordinal()) goto L24;
        return ColorSpaces.INSTANCE.getCieLab();
    L24:
        if (r100 != ColorSpace.Named.CIE_XYZ.ordinal()) goto L27;
        return ColorSpaces.INSTANCE.getCieXyz();
    L27:
        if (r100 != ColorSpace.Named.DCI_P3.ordinal()) goto L30;
        return ColorSpaces.INSTANCE.getDciP3();
    L30:
        if (r100 != ColorSpace.Named.DISPLAY_P3.ordinal()) goto L33;
        return ColorSpaces.INSTANCE.getDisplayP3();
    L33:
        if (r100 != ColorSpace.Named.EXTENDED_SRGB.ordinal()) goto L36;
        return ColorSpaces.INSTANCE.getExtendedSrgb();
    L36:
        if (r100 != ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) goto L39;
        return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
    L39:
        if (r100 != ColorSpace.Named.LINEAR_SRGB.ordinal()) goto L42;
        return ColorSpaces.INSTANCE.getLinearSrgb();
    L42:
        if (r100 != ColorSpace.Named.NTSC_1953.ordinal()) goto L45;
        return ColorSpaces.INSTANCE.getNtsc1953();
    L45:
        if (r100 != ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) goto L48;
        return ColorSpaces.INSTANCE.getProPhotoRgb();
    L48:
        if (r100 != ColorSpace.Named.SMPTE_C.ordinal()) goto L51;
        return ColorSpaces.INSTANCE.getSmpteC();
    L51:
        if (Build.VERSION.SDK_INT < 34) goto L56;
        androidx.compose.ui.graphics.colorspace.ColorSpace r101 = ColorSpaceVerificationHelperV34.obtainComposeColorSpaceFromId(r210.getId());
        if (Intrinsics.areEqual(r101, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release()) == true) goto L56;
        return r101;
    L56:
        if ((r210 instanceof ColorSpace.Rgb) == false) goto L67;
        ColorSpace.Rgb r102 = (ColorSpace.Rgb) r210;
        ColorSpace.Rgb.TransferParameters r103 = r102.getTransferParameters();
        if (r102.getWhitePoint().length != 3) goto L60;
        WhitePoint r104 = new WhitePoint(r102.getWhitePoint()[0], r102.getWhitePoint()[1], r102.getWhitePoint()[2]);
    L61:
        WhitePoint r110 = r104;
        if (r103 == null) goto L64;
        TransferParameters r111 = new TransferParameters(r103.g, r103.a, r103.b, r103.c, r103.d, r103.e, r103.f);
    L84:
        return new Rgb(r102.getName(), r102.getPrimaries(), r110, r102.getTransform(), new c(r210), new d(r210), r102.getMinValue(0), r102.getMaxValue(0), r111, r102.getId());
    L64:
        r111 = null;
        goto L84
    L60:
        r104 = new WhitePoint(r102.getWhitePoint()[0], r102.getWhitePoint()[1]);
        goto L61
    L67:
        return ColorSpaces.INSTANCE.getSrgb();
    }

    private static final double androidColorSpace$lambda$0(Function1 r100, double r101) {
        return ((Number) r100.invoke(Double.valueOf(r101))).doubleValue();
    }

    private static final double androidColorSpace$lambda$1(Function1 r100, double r101) {
        return ((Number) r100.invoke(Double.valueOf(r101))).doubleValue();
    }

    private static final double composeColorSpace$lambda$2(ColorSpace r100, double r101) {
        return ((ColorSpace.Rgb) r100).getOetf().applyAsDouble(r101);
    }

    private static final double composeColorSpace$lambda$3(ColorSpace r100, double r101) {
        return ((ColorSpace.Rgb) r100).getEotf().applyAsDouble(r101);
    }
}
