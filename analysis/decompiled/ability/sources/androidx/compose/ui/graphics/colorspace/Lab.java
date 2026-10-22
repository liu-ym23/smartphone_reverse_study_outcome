package androidx.compose.ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.ColorKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", HintConstants.AUTOFILL_HINT_NAME, "", "id", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Lab extends ColorSpace {

    /* renamed from: A, reason: collision with root package name */
    private static final float f1821A = 0.008856452f;

    /* renamed from: B, reason: collision with root package name */
    private static final float f1822B = 7.787037f;

    /* renamed from: C, reason: collision with root package name */
    private static final float f1823C = 0.13793103f;

    /* renamed from: D, reason: collision with root package name */
    private static final float f1824D = 0.20689656f;

    public Lab(String str, int i) {
        super(str, ColorModel.INSTANCE.m4569getLabxdoWZVw(), i, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v10) {
        float f = v10[0];
        Illuminant illuminant = Illuminant.INSTANCE;
        float f7 = f / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f9 = v10[1] / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f10 = v10[2] / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fCbrt = f7 > f1821A ? (float) Math.cbrt(f7) : (f7 * f1822B) + f1823C;
        float fCbrt2 = f9 > f1821A ? (float) Math.cbrt(f9) : (f9 * f1822B) + f1823C;
        float fCbrt3 = f10 > f1821A ? (float) Math.cbrt(f10) : (f10 * f1822B) + f1823C;
        float f11 = (116.0f * fCbrt2) - 16.0f;
        float f12 = (fCbrt - fCbrt2) * 500.0f;
        float f13 = (fCbrt2 - fCbrt3) * 200.0f;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 100.0f) {
            f11 = 100.0f;
        }
        v10[0] = f11;
        if (f12 < -128.0f) {
            f12 = -128.0f;
        }
        if (f12 > 128.0f) {
            f12 = 128.0f;
        }
        v10[1] = f12;
        if (f13 < -128.0f) {
            f13 = -128.0f;
        }
        v10[2] = f13 <= 128.0f ? f13 : 128.0f;
        return v10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
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
        if (v02 > 100.0f) {
            v02 = 100.0f;
        }
        if (v12 < -128.0f) {
            v12 = -128.0f;
        }
        if (v12 > 128.0f) {
            v12 = 128.0f;
        }
        float f = (v02 + 16.0f) / 116.0f;
        float f7 = (v12 * 0.002f) + f;
        float f9 = f7 > f1824D ? f7 * f7 * f7 : (f7 - f1823C) * 0.12841855f;
        float f10 = f > f1824D ? f * f * f : (f - f1823C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        return (Float.floatToRawIntBits(f9 * illuminant.getD50Xyz$ui_graphics_release()[0]) << 32) | (4294967295L & Float.floatToRawIntBits(f10 * illuminant.getD50Xyz$ui_graphics_release()[1]));
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v10) {
        float f = v10[0];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        v10[0] = f;
        float f7 = v10[1];
        if (f7 < -128.0f) {
            f7 = -128.0f;
        }
        if (f7 > 128.0f) {
            f7 = 128.0f;
        }
        v10[1] = f7;
        float f9 = v10[2];
        float f10 = f9 >= -128.0f ? f9 : -128.0f;
        float f11 = f10 <= 128.0f ? f10 : 128.0f;
        v10[2] = f11;
        float f12 = (f + 16.0f) / 116.0f;
        float f13 = (f7 * 0.002f) + f12;
        float f14 = f12 - (f11 * 0.005f);
        float f15 = f13 > f1824D ? f13 * f13 * f13 : (f13 - f1823C) * 0.12841855f;
        float f16 = f12 > f1824D ? f12 * f12 * f12 : (f12 - f1823C) * 0.12841855f;
        float f17 = f14 > f1824D ? f14 * f14 * f14 : (f14 - f1823C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        v10[0] = f15 * illuminant.getD50Xyz$ui_graphics_release()[0];
        v10[1] = f16 * illuminant.getD50Xyz$ui_graphics_release()[1];
        v10[2] = f17 * illuminant.getD50Xyz$ui_graphics_release()[2];
        return v10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 100.0f) {
            v02 = 100.0f;
        }
        if (v22 < -128.0f) {
            v22 = -128.0f;
        }
        if (v22 > 128.0f) {
            v22 = 128.0f;
        }
        float f = ((v02 + 16.0f) / 116.0f) - (v22 * 0.005f);
        return (f > f1824D ? f * f * f : 0.12841855f * (f - f1823C)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo4573xyzaToColorJlNiLsg$ui_graphics_release(float x10, float y, float z10, float a3, ColorSpace colorSpace) {
        Illuminant illuminant = Illuminant.INSTANCE;
        float f = x10 / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f7 = y / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f9 = z10 / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fCbrt = f > f1821A ? (float) Math.cbrt(f) : (f * f1822B) + f1823C;
        float fCbrt2 = f7 > f1821A ? (float) Math.cbrt(f7) : (f7 * f1822B) + f1823C;
        float fCbrt3 = f9 > f1821A ? (float) Math.cbrt(f9) : (f9 * f1822B) + f1823C;
        float f10 = (116.0f * fCbrt2) - 16.0f;
        float f11 = (fCbrt - fCbrt2) * 500.0f;
        float f12 = (fCbrt2 - fCbrt3) * 200.0f;
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 100.0f) {
            f10 = 100.0f;
        }
        if (f11 < -128.0f) {
            f11 = -128.0f;
        }
        if (f11 > 128.0f) {
            f11 = 128.0f;
        }
        if (f12 < -128.0f) {
            f12 = -128.0f;
        }
        return ColorKt.Color(f10, f11, f12 <= 128.0f ? f12 : 128.0f, a3, colorSpace);
    }
}
