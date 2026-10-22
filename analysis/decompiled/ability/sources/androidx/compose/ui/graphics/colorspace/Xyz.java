package androidx.compose.ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.ColorKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0011\u0010$\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0082\bR\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", HintConstants.AUTOFILL_HINT_NAME, "", "id", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "clamp", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Xyz extends ColorSpace {
    public Xyz(String str, int i) {
        super(str, ColorModel.INSTANCE.m4571getXyzxdoWZVw(), i, null);
    }

    private final float clamp(float x10) {
        if (x10 < -2.0f) {
            x10 = -2.0f;
        }
        if (x10 > 2.0f) {
            return 2.0f;
        }
        return x10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v10) {
        float f = v10[0];
        if (f < -2.0f) {
            f = -2.0f;
        }
        if (f > 2.0f) {
            f = 2.0f;
        }
        v10[0] = f;
        float f7 = v10[1];
        if (f7 < -2.0f) {
            f7 = -2.0f;
        }
        if (f7 > 2.0f) {
            f7 = 2.0f;
        }
        v10[1] = f7;
        float f9 = v10[2];
        float f10 = f9 >= -2.0f ? f9 : -2.0f;
        v10[2] = f10 <= 2.0f ? f10 : 2.0f;
        return v10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return 2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return -2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < -2.0f) {
            v02 = -2.0f;
        }
        if (v02 > 2.0f) {
            v02 = 2.0f;
        }
        if (v12 < -2.0f) {
            v12 = -2.0f;
        }
        return (Float.floatToRawIntBits(v02) << 32) | (Float.floatToRawIntBits(v12 <= 2.0f ? v12 : 2.0f) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v10) {
        float f = v10[0];
        if (f < -2.0f) {
            f = -2.0f;
        }
        if (f > 2.0f) {
            f = 2.0f;
        }
        v10[0] = f;
        float f7 = v10[1];
        if (f7 < -2.0f) {
            f7 = -2.0f;
        }
        if (f7 > 2.0f) {
            f7 = 2.0f;
        }
        v10[1] = f7;
        float f9 = v10[2];
        float f10 = f9 >= -2.0f ? f9 : -2.0f;
        v10[2] = f10 <= 2.0f ? f10 : 2.0f;
        return v10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v22 < -2.0f) {
            v22 = -2.0f;
        }
        if (v22 > 2.0f) {
            return 2.0f;
        }
        return v22;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo4573xyzaToColorJlNiLsg$ui_graphics_release(float x10, float y, float z10, float a3, ColorSpace colorSpace) {
        if (x10 < -2.0f) {
            x10 = -2.0f;
        }
        if (x10 > 2.0f) {
            x10 = 2.0f;
        }
        if (y < -2.0f) {
            y = -2.0f;
        }
        if (y > 2.0f) {
            y = 2.0f;
        }
        if (z10 < -2.0f) {
            z10 = -2.0f;
        }
        return ColorKt.Color(x10, y, z10 <= 2.0f ? z10 : 2.0f, a3, colorSpace);
    }
}
