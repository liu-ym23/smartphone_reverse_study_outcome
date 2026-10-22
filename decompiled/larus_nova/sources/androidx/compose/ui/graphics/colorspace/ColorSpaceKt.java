package androidx.compose.ui.graphics.colorspace;

import androidx.camera.video.AudioStats;
import androidx.collection.MutableIntObjectMap;
import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\t\u001a\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\b\u001a\u001e\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000\u001a8\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000\u001aH\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000\u001aH\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000\u001a8\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000\u001a8\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000\u001a\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001fH\u0000\u001a\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0000\u001a\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020 H\u0000\u001a\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0000\u001a\u0018\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 H\u0000\u001a\u0018\u0010&\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 H\u0000\u001a)\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020 2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(H\u0080\b\u001a)\u0010,\u001a\u00020(2\u0006\u0010$\u001a\u00020 2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(H\u0080\b\u001a)\u0010-\u001a\u00020(2\u0006\u0010$\u001a\u00020 2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(H\u0080\b\u001a\u0018\u0010.\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 H\u0000\u001a \u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020 H\u0000¨\u00063"}, d2 = {"createConnector", "Landroidx/compose/ui/graphics/colorspace/Connector;", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "createConnector-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)Landroidx/compose/ui/graphics/colorspace/Connector;", "connect", "connect-YBCOT_4", "adapt", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "adaptation", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "rcpResponse", "", "x", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", ce.f26391f, "response", "e", "f", "absRcpResponse", "absResponse", "compare", "", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "inverse3x3", "m", "mul3x3", "lhs", "rhs", "mul3x3Float3", "mul3x3Float3_0", "", "r0", "r1", "r2", "mul3x3Float3_1", "mul3x3Float3_2", "mul3x3Diag", "chromaticAdaptation", "matrix", "srcWhitePoint", "dstWhitePoint", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorSpaceKt {
    public static final ColorSpace adapt(ColorSpace r100, WhitePoint r101) {
        return adapt$default(r100, r101, null, 2, null);
    }

    public static final float[] inverse3x3(float[] r210) {
        float r100 = r210[0];
        float r101 = r210[3];
        float r102 = r210[6];
        float r103 = r210[1];
        float r110 = r210[4];
        float r111 = r210[7];
        float r112 = r210[2];
        float r113 = r210[5];
        float r114 = r210[8];
        float r115 = (r110 * r114) - (r111 * r113);
        float r211 = (r111 * r112) - (r103 * r114);
        float r212 = (r103 * r113) - (r110 * r112);
        float r213 = ((r100 * r115) + (r101 * r211)) + (r102 * r212);
        float[] r104 = new float[r210.length];
        r104[0] = r115 / r213;
        r104[1] = r211 / r213;
        r104[2] = r212 / r213;
        r104[3] = ((r102 * r113) - (r101 * r114)) / r213;
        r104[4] = ((r114 * r100) - (r102 * r112)) / r213;
        r104[5] = ((r112 * r101) - (r113 * r100)) / r213;
        r104[6] = ((r101 * r111) - (r102 * r110)) / r213;
        r104[7] = ((r102 * r103) - (r111 * r100)) / r213;
        r104[8] = ((r100 * r110) - (r101 * r103)) / r213;
        return r104;
    }

    public static final boolean compare(TransferParameters r100, TransferParameters r101) {
        if (r101 != null) goto L4;
    L18:
        return false;
    L4:
        if (Math.abs(r100.getA() - r101.getA()) >= 0.001d) goto L18;
        if (Math.abs(r100.getB() - r101.getB()) >= 0.001d) goto L18;
        if (Math.abs(r100.getC() - r101.getC()) >= 0.001d) goto L18;
        if (Math.abs(r100.getD() - r101.getD()) >= 0.002d) goto L18;
        if (Math.abs(r100.getE() - r101.getE()) >= 0.001d) goto L18;
        if (Math.abs(r100.getF() - r101.getF()) >= 0.001d) goto L18;
        if (Math.abs(r100.getGamma() - r101.getGamma()) >= 0.001d) goto L18;
        return true;
    }

    public static final float[] mul3x3(float[] r210, float[] r211) {
        float[] r100 = new float[9];
        if (r210.length >= 9) goto L6;
        return r100;
    L6:
        if (r211.length >= 9) goto L8;
        return r100;
    L8:
        float r101 = r210[0] * r211[0];
        float r102 = r210[3];
        float r103 = r211[1];
        float r110 = r210[6];
        float r111 = r211[2];
        r100[0] = (r101 + (r102 * r103)) + (r110 * r111);
        float r104 = r210[1];
        float r112 = r211[0];
        float r113 = r210[4];
        float r114 = r210[7];
        r100[1] = ((r104 * r112) + (r103 * r113)) + (r114 * r111);
        float r105 = r210[2] * r112;
        float r115 = r210[5];
        float r106 = r105 + (r211[1] * r115);
        float r116 = r210[8];
        r100[2] = r106 + (r111 * r116);
        float r107 = r210[0];
        float r108 = r211[3] * r107;
        float r117 = r211[4];
        float r109 = r108 + (r102 * r117);
        float r118 = r211[5];
        r100[3] = r109 + (r110 * r118);
        float r119 = r210[1];
        float r120 = r211[3];
        r100[4] = ((r119 * r120) + (r113 * r117)) + (r114 * r118);
        float r121 = r210[2];
        r100[5] = ((r120 * r121) + (r115 * r211[4])) + (r118 * r116);
        float r122 = r107 * r211[6];
        float r123 = r210[3];
        float r124 = r211[7];
        float r125 = r122 + (r123 * r124);
        float r126 = r211[8];
        r100[6] = r125 + (r110 * r126);
        float r127 = r211[6];
        r100[7] = ((r119 * r127) + (r210[4] * r124)) + (r114 * r126);
        r100[8] = ((r121 * r127) + (r210[5] * r211[7])) + (r116 * r126);
        return r100;
    }

    public static final float[] mul3x3Diag(float[] r100, float[] r101) {
        float r102 = r100[0];
        float r103 = r100[1];
        float r104 = r100[2];
        return new float[]{r100[0] * r101[0], r100[1] * r101[1], r100[2] * r101[2], r101[3] * r102, r101[4] * r103, r101[5] * r104, r102 * r101[6], r103 * r101[7], r104 * r101[8]};
    }

    public static final float[] mul3x3Float3(float[] r100, float[] r101) {
        if (r100.length >= 9) goto L6;
        return r101;
    L6:
        if (r101.length >= 3) goto L8;
        return r101;
    L8:
        float r102 = r101[0];
        float r103 = r101[1];
        float r104 = r101[2];
        r101[0] = ((r100[0] * r102) + (r100[3] * r103)) + (r100[6] * r104);
        r101[1] = ((r100[1] * r102) + (r100[4] * r103)) + (r100[7] * r104);
        r101[2] = ((r100[2] * r102) + (r100[5] * r103)) + (r100[8] * r104);
        return r101;
    }

    public static final boolean compare(WhitePoint r100, WhitePoint r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (Math.abs(r100.getX() - r101.getX()) < 0.001f) goto L8;
    L10:
        return false;
    L8:
        if (Math.abs(r100.getY() - r101.getY()) >= 0.001f) goto L10;
        return true;
    }

    public static final boolean compare(float[] r100, float[] r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L13;
        if (Float.compare(r100[r103], r101[r103]) == 0) goto L12;
        if (Math.abs(r100[r103] - r101[r103]) <= 0.001f) goto L12;
        return false;
    L12:
        r103 = r103 + 1;
        goto L6
    L13:
        return true;
    }

    public static final ColorSpace adapt(ColorSpace r100, WhitePoint r101, Adaptation r102) {
        if (ColorModel.m5261equalsimpl0(r100.m5270getModelxdoWZVw(), ColorModel.Companion.m5268getRgbxdoWZVw()) == false) goto L9;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Rgb r103 = (Rgb) r100;
        if (compare(r103.getWhitePoint(), r101) == false) goto L7;
        return r100;
    L7:
        float[] r104 = r101.toXyz$ui_graphics_release();
        return new Rgb(r103, mul3x3(chromaticAdaptation(r102.getTransform$ui_graphics_release(), r103.getWhitePoint().toXyz$ui_graphics_release(), r104), r103.getTransform$ui_graphics_release()), r101);
    L9:
        return r100;
    }

    public static final float[] chromaticAdaptation(float[] r100, float[] r101, float[] r102) {
        float[] r103 = mul3x3Float3(r100, r101);
        float[] r104 = mul3x3Float3(r100, r102);
        return mul3x3(inverse3x3(r100), mul3x3Diag(new float[]{r104[0] / r103[0], r104[1] / r103[1], r104[2] / r103[2]}, r100));
    }

    /* JADX INFO: renamed from: connect-YBCOT_4, reason: not valid java name */
    public static final Connector m5272connectYBCOT_4(ColorSpace r100, ColorSpace r101, int r102) {
        int r103 = r100.getId$ui_graphics_release();
        int r104 = r101.getId$ui_graphics_release();
        if ((r103 | r104) < 0) goto L10;
        MutableIntObjectMap<Connector> r105 = ConnectorKt.getConnectors();
        int r106 = (r103 | (r104 << 6)) | (r102 << 12);
        Connector r107 = r105.get(r106);
        if (r107 != null) goto L9;
        r107 = m5274createConnectorYBCOT_4(r100, r101, r102);
        r105.set(r106, r107);
    L9:
        return r107;
    L10:
        return m5274createConnectorYBCOT_4(r100, r101, r102);
    }

    /* JADX INFO: renamed from: createConnector-YBCOT_4, reason: not valid java name */
    private static final Connector m5274createConnectorYBCOT_4(ColorSpace r100, ColorSpace r101, int r102) {
        if (r100 == r101) goto L12;
        long r103 = r100.m5270getModelxdoWZVw();
        ColorModel.Companion r104 = ColorModel.Companion;
        DefaultConstructorMarker r105 = null;
        if (ColorModel.m5261equalsimpl0(r103, r104.m5268getRgbxdoWZVw()) == true) goto L7;
    L9:
        Connector r106 = new Connector(r100, r101, r102, r105);
    L11:
        return r106;
    L7:
        if (ColorModel.m5261equalsimpl0(r101.m5270getModelxdoWZVw(), r104.m5268getRgbxdoWZVw()) == false) goto L9;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        r106 = new Connector.RgbConnector((Rgb) r100, (Rgb) r101, r102, r105);
        goto L11
    L12:
        return Connector.Companion.identity$ui_graphics_release(r100);
    }

    public static final float mul3x3Float3_0(float[] r100, float r101, float r102, float r103) {
        return ((r100[0] * r101) + (r100[3] * r102)) + (r100[6] * r103);
    }

    public static final float mul3x3Float3_1(float[] r100, float r101, float r102, float r103) {
        return ((r100[1] * r101) + (r100[4] * r102)) + (r100[7] * r103);
    }

    public static final float mul3x3Float3_2(float[] r100, float r101, float r102, float r103) {
        return ((r100[2] * r101) + (r100[5] * r102)) + (r100[8] * r103);
    }

    public static /* synthetic */ ColorSpace adapt$default(ColorSpace r100, WhitePoint r101, Adaptation r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = Adaptation.Companion.getBradford();
    L6:
        return adapt(r100, r101, r102);
    }

    /* JADX INFO: renamed from: connect-YBCOT_4$default, reason: not valid java name */
    public static /* synthetic */ Connector m5273connectYBCOT_4$default(ColorSpace r100, ColorSpace r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = ColorSpaces.INSTANCE.getSrgb();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = RenderIntent.Companion.m5289getPerceptualuksYyKA();
    L9:
        return m5272connectYBCOT_4(r100, r101, r102);
    }

    public static final double absRcpResponse(double r110, double r111, double r210, double r211, double r212, double r213) {
        if (r110 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r100 = -r110;
    L7:
        return Math.copySign(rcpResponse(r100, r111, r210, r211, r212, r213), r110);
    L5:
        r100 = r110;
        goto L7
    }

    public static final double absResponse(double r110, double r111, double r210, double r211, double r212, double r213) {
        if (r110 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r100 = -r110;
    L7:
        return Math.copySign(response(r100, r111, r210, r211, r212, r213), r110);
    L5:
        r100 = r110;
        goto L7
    }

    public static final double rcpResponse(double r100, double r101, double r102, double r103, double r104, double r110) {
        if (r100 < (r104 * r103)) goto L6;
        return (Math.pow(r100, 1.0d / r110) - r102) / r101;
    L6:
        return r100 / r103;
    }

    public static final double response(double r100, double r101, double r102, double r103, double r104, double r110) {
        if (r100 < r104) goto L6;
        return Math.pow((r101 * r100) + r102, r110);
    L6:
        return r100 * r103;
    }

    public static final double rcpResponse(double r100, double r101, double r102, double r110, double r111, double r112, double r113, double r114) {
        if (r100 < (r111 * r110)) goto L6;
        return (Math.pow(r100 - r112, 1.0d / r114) - r102) / r101;
    L6:
        return (r100 - r113) / r110;
    }

    public static final double response(double r100, double r101, double r102, double r110, double r111, double r112, double r113, double r114) {
        if (r100 < r111) goto L6;
        return Math.pow((r101 * r100) + r102, r114) + r112;
    L6:
        return (r110 * r100) + r113;
    }
}
