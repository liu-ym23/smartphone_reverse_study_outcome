package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", BaseSwitches.V, "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Oklab extends ColorSpace {
    public static final Companion Companion = null;
    private static final float[] InverseM1 = null;
    private static final float[] InverseM2 = null;
    private static final float[] M1 = null;
    private static final float[] M2 = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab$Companion;", "", "<init>", "()V", "M1", "", "M2", "InverseM1", "InverseM2", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int r100) {
        if (r100 != 0) goto L4;
        return 1.0f;
    L4:
        return 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int r100) {
        if (r100 != 0) goto L4;
        return 0.0f;
    L4:
        return -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    static {
        Companion = new Companion(null);
        float[] r100 = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
        Illuminant r101 = Illuminant.INSTANCE;
        float[] r102 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(r100, r101.getD50().toXyz$ui_graphics_release(), r101.getD65().toXyz$ui_graphics_release()));
        M1 = r102;
        float[] r103 = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        M2 = r103;
        InverseM1 = ColorSpaceKt.inverse3x3(r102);
        InverseM2 = ColorSpaceKt.inverse3x3(r103);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] r100) {
        ColorSpaceKt.mul3x3Float3(M1, r100);
        r100[0] = MathHelpersKt.fastCbrt(r100[0]);
        r100[1] = MathHelpersKt.fastCbrt(r100[1]);
        r100[2] = MathHelpersKt.fastCbrt(r100[2]);
        ColorSpaceKt.mul3x3Float3(M2, r100);
        return r100;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] r100) {
        float r101 = r100[0];
        if (r101 >= 0.0f) goto L6;
        r101 = 0.0f;
    L6:
        if (r101 <= 1.0f) goto L8;
        r101 = 1.0f;
    L8:
        r100[0] = r101;
        float r102 = r100[1];
        float r103 = -0.5f;
        if (r102 >= (-0.5f)) goto L11;
        r102 = -0.5f;
    L11:
        float r104 = 0.5f;
        if (r102 <= 0.5f) goto L14;
        r102 = 0.5f;
    L14:
        r100[1] = r102;
        float r105 = r100[2];
        if (r105 < (-0.5f)) goto L19;
        r103 = r105;
    L19:
        if (r103 > 0.5f) goto L22;
        r104 = r103;
    L22:
        r100[2] = r104;
        ColorSpaceKt.mul3x3Float3(InverseM2, r100);
        float r106 = r100[0];
        r100[0] = (r106 * r106) * r106;
        float r107 = r100[1];
        r100[1] = (r107 * r107) * r107;
        float r108 = r100[2];
        r100[2] = (r108 * r108) * r108;
        ColorSpaceKt.mul3x3Float3(InverseM1, r100);
        return r100;
    }

    public Oklab(String r100, int r101) {
        super(r100, ColorModel.Companion.m5267getLabxdoWZVw(), r101, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float r110, float r111, float r112) {
        if (r110 >= 0.0f) goto L6;
        r110 = 0.0f;
    L6:
        if (r110 <= 1.0f) goto L9;
        r110 = 1.0f;
    L9:
        if (r111 >= (-0.5f)) goto L11;
        r111 = -0.5f;
    L11:
        float r100 = 0.5f;
        if (r111 <= 0.5f) goto L15;
        r111 = 0.5f;
    L15:
        if (r112 >= (-0.5f)) goto L18;
        r112 = -0.5f;
    L18:
        if (r112 > 0.5f) goto L21;
        r100 = r112;
    L21:
        float[] r113 = InverseM2;
        float r101 = ((r113[0] * r110) + (r113[3] * r111)) + (r113[6] * r100);
        float r102 = ((r113[1] * r110) + (r113[4] * r111)) + (r113[7] * r100);
        float r103 = ((r113[2] * r110) + (r113[5] * r111)) + (r113[8] * r100);
        float r114 = (r101 * r101) * r101;
        float r115 = (r102 * r102) * r102;
        float r116 = (r103 * r103) * r103;
        float[] r104 = InverseM1;
        float r105 = ((r104[0] * r114) + (r104[3] * r115)) + (r104[6] * r116);
        float r106 = ((r104[1] * r114) + (r104[4] * r115)) + (r104[7] * r116);
        return (Float.floatToRawIntBits(r105) << 32) | (((long) Float.floatToRawIntBits(r106)) & BodyPartID.bodyIdMax);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float r100, float r101, float r102) {
        if (r100 >= 0.0f) goto L6;
        r100 = 0.0f;
    L6:
        if (r100 <= 1.0f) goto L9;
        r100 = 1.0f;
    L9:
        if (r101 >= (-0.5f)) goto L11;
        r101 = -0.5f;
    L11:
        float r103 = 0.5f;
        if (r101 <= 0.5f) goto L15;
        r101 = 0.5f;
    L15:
        if (r102 >= (-0.5f)) goto L18;
        r102 = -0.5f;
    L18:
        if (r102 > 0.5f) goto L21;
        r103 = r102;
    L21:
        float[] r104 = InverseM2;
        float r105 = ((r104[0] * r100) + (r104[3] * r101)) + (r104[6] * r103);
        float r106 = ((r104[1] * r100) + (r104[4] * r101)) + (r104[7] * r103);
        float r107 = ((r104[2] * r100) + (r104[5] * r101)) + (r104[8] * r103);
        float r108 = (r105 * r105) * r105;
        float r109 = (r106 * r106) * r106;
        float[] r110 = InverseM1;
        float r111 = (r110[2] * r108) + (r110[5] * r109);
        float r112 = r110[8];
        return r111 + (r112 * ((r107 * r107) * r107));
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo5271xyzaToColorJlNiLsg$ui_graphics_release(float r110, float r111, float r112, float r113, ColorSpace r114) {
        float[] r100 = M1;
        float r101 = ((r100[0] * r110) + (r100[3] * r111)) + (r100[6] * r112);
        float r102 = ((r100[1] * r110) + (r100[4] * r111)) + (r100[7] * r112);
        float r115 = ((r100[2] * r110) + (r100[5] * r111)) + (r100[8] * r112);
        float r103 = MathHelpersKt.fastCbrt(r101);
        float r104 = MathHelpersKt.fastCbrt(r102);
        float r105 = MathHelpersKt.fastCbrt(r115);
        float[] r116 = M2;
        return ColorKt.Color(((r116[0] * r103) + (r116[3] * r104)) + (r116[6] * r105), ((r116[1] * r103) + (r116[4] * r104)) + (r116[7] * r105), ((r116[2] * r103) + (r116[5] * r104)) + (r116[8] * r105), r113, r114);
    }
}
