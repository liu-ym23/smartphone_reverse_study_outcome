package androidx.compose.ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", HintConstants.AUTOFILL_HINT_NAME, "", "id", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Oklab extends ColorSpace {
    private static final float[] InverseM1;
    private static final float[] InverseM2;

    /* renamed from: M1, reason: collision with root package name */
    private static final float[] f1825M1;

    /* renamed from: M2, reason: collision with root package name */
    private static final float[] f1826M2;

    static {
        float[] transform = Adaptation.INSTANCE.getBradford().getTransform();
        Illuminant illuminant = Illuminant.INSTANCE;
        float[] fArrMul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(transform, illuminant.getD50().toXyz$ui_graphics_release(), illuminant.getD65().toXyz$ui_graphics_release()));
        f1825M1 = fArrMul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f1826M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(fArrMul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }

    public Oklab(String str, int i) {
        super(str, ColorModel.INSTANCE.m4569getLabxdoWZVw(), i, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v10) {
        ColorSpaceKt.mul3x3Float3(f1825M1, v10);
        v10[0] = MathHelpersKt.fastCbrt(v10[0]);
        v10[1] = MathHelpersKt.fastCbrt(v10[1]);
        v10[2] = MathHelpersKt.fastCbrt(v10[2]);
        ColorSpaceKt.mul3x3Float3(f1826M2, v10);
        return v10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 1.0f) {
            v02 = 1.0f;
        }
        if (v12 < -0.5f) {
            v12 = -0.5f;
        }
        if (v12 > 0.5f) {
            v12 = 0.5f;
        }
        if (v22 < -0.5f) {
            v22 = -0.5f;
        }
        float f = v22 <= 0.5f ? v22 : 0.5f;
        float[] fArr = InverseM2;
        float f7 = (fArr[6] * f) + (fArr[3] * v12) + (fArr[0] * v02);
        float f9 = (fArr[7] * f) + (fArr[4] * v12) + (fArr[1] * v02);
        float f10 = (fArr[8] * f) + (fArr[5] * v12) + (fArr[2] * v02);
        float f11 = f7 * f7 * f7;
        float f12 = f9 * f9 * f9;
        float f13 = f10 * f10 * f10;
        float[] fArr2 = InverseM1;
        return (Float.floatToRawIntBits((fArr2[6] * f13) + ((fArr2[3] * f12) + (fArr2[0] * f11))) << 32) | (4294967295L & Float.floatToRawIntBits((fArr2[7] * f13) + (fArr2[4] * f12) + (fArr2[1] * f11)));
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v10) {
        float f = v10[0];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        v10[0] = f;
        float f7 = v10[1];
        if (f7 < -0.5f) {
            f7 = -0.5f;
        }
        if (f7 > 0.5f) {
            f7 = 0.5f;
        }
        v10[1] = f7;
        float f9 = v10[2];
        float f10 = f9 >= -0.5f ? f9 : -0.5f;
        v10[2] = f10 <= 0.5f ? f10 : 0.5f;
        ColorSpaceKt.mul3x3Float3(InverseM2, v10);
        float f11 = v10[0];
        v10[0] = f11 * f11 * f11;
        float f12 = v10[1];
        v10[1] = f12 * f12 * f12;
        float f13 = v10[2];
        v10[2] = f13 * f13 * f13;
        ColorSpaceKt.mul3x3Float3(InverseM1, v10);
        return v10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 1.0f) {
            v02 = 1.0f;
        }
        if (v12 < -0.5f) {
            v12 = -0.5f;
        }
        if (v12 > 0.5f) {
            v12 = 0.5f;
        }
        if (v22 < -0.5f) {
            v22 = -0.5f;
        }
        float f = v22 <= 0.5f ? v22 : 0.5f;
        float[] fArr = InverseM2;
        float f7 = (fArr[6] * f) + (fArr[3] * v12) + (fArr[0] * v02);
        float f9 = (fArr[7] * f) + (fArr[4] * v12) + (fArr[1] * v02);
        float f10 = (fArr[8] * f) + (fArr[5] * v12) + (fArr[2] * v02);
        float f11 = f7 * f7 * f7;
        float f12 = f9 * f9 * f9;
        float f13 = f10 * f10 * f10;
        float[] fArr2 = InverseM1;
        return (fArr2[8] * f13) + (fArr2[5] * f12) + (fArr2[2] * f11);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo4573xyzaToColorJlNiLsg$ui_graphics_release(float x10, float y, float z10, float a3, ColorSpace colorSpace) {
        float[] fArr = f1825M1;
        float f = (fArr[6] * z10) + (fArr[3] * y) + (fArr[0] * x10);
        float f7 = (fArr[7] * z10) + (fArr[4] * y) + (fArr[1] * x10);
        float f9 = (fArr[8] * z10) + (fArr[5] * y) + (fArr[2] * x10);
        float fFastCbrt = MathHelpersKt.fastCbrt(f);
        float fFastCbrt2 = MathHelpersKt.fastCbrt(f7);
        float fFastCbrt3 = MathHelpersKt.fastCbrt(f9);
        float[] fArr2 = f1826M2;
        return ColorKt.Color((fArr2[6] * fFastCbrt3) + (fArr2[3] * fFastCbrt2) + (fArr2[0] * fFastCbrt), (fArr2[7] * fFastCbrt3) + (fArr2[4] * fFastCbrt2) + (fArr2[1] * fFastCbrt), (fArr2[8] * fFastCbrt3) + (fArr2[5] * fFastCbrt2) + (fArr2[2] * fFastCbrt), a3, colorSpace);
    }
}
