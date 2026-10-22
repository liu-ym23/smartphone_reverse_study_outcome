package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0011\u0010$\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0082\bR\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", BaseSwitches.V, "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "clamp", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Xyz extends ColorSpace {
    private final float clamp(float r100) {
        if (r100 >= (-2.0f)) goto L6;
        r100 = -2.0f;
    L6:
        if (r100 <= 2.0f) goto L9;
        return 2.0f;
    L9:
        return r100;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int r100) {
        return 2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int r100) {
        return -2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float r100, float r101, float r102) {
        if (r102 >= (-2.0f)) goto L6;
        r102 = -2.0f;
    L6:
        if (r102 <= 2.0f) goto L9;
        return 2.0f;
    L9:
        return r102;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] r100) {
        float r101 = r100[0];
        float r102 = -2.0f;
        if (r101 >= (-2.0f)) goto L5;
        r101 = -2.0f;
    L5:
        float r103 = 2.0f;
        if (r101 <= 2.0f) goto L8;
        r101 = 2.0f;
    L8:
        r100[0] = r101;
        float r104 = r100[1];
        if (r104 >= (-2.0f)) goto L12;
        r104 = -2.0f;
    L12:
        if (r104 <= 2.0f) goto L14;
        r104 = 2.0f;
    L14:
        r100[1] = r104;
        float r105 = r100[2];
        if (r105 < (-2.0f)) goto L19;
        r102 = r105;
    L19:
        if (r102 > 2.0f) goto L22;
        r103 = r102;
    L22:
        r100[2] = r103;
        return r100;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] r100) {
        float r101 = r100[0];
        float r102 = -2.0f;
        if (r101 >= (-2.0f)) goto L5;
        r101 = -2.0f;
    L5:
        float r103 = 2.0f;
        if (r101 <= 2.0f) goto L8;
        r101 = 2.0f;
    L8:
        r100[0] = r101;
        float r104 = r100[1];
        if (r104 >= (-2.0f)) goto L12;
        r104 = -2.0f;
    L12:
        if (r104 <= 2.0f) goto L14;
        r104 = 2.0f;
    L14:
        r100[1] = r104;
        float r105 = r100[2];
        if (r105 < (-2.0f)) goto L19;
        r102 = r105;
    L19:
        if (r102 > 2.0f) goto L22;
        r103 = r102;
    L22:
        r100[2] = r103;
        return r100;
    }

    public Xyz(String r100, int r101) {
        super(r100, ColorModel.Companion.m5269getXyzxdoWZVw(), r101, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float r100, float r101, float r102) {
        if (r100 >= (-2.0f)) goto L5;
        r100 = -2.0f;
    L5:
        float r103 = 2.0f;
        if (r100 <= 2.0f) goto L9;
        r100 = 2.0f;
    L9:
        if (r101 >= (-2.0f)) goto L12;
        r101 = -2.0f;
    L12:
        if (r101 > 2.0f) goto L16;
        r103 = r101;
    L16:
        return (Float.floatToRawIntBits(r100) << 32) | (((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo5271xyzaToColorJlNiLsg$ui_graphics_release(float r100, float r101, float r102, float r103, ColorSpace r104) {
        if (r100 >= (-2.0f)) goto L5;
        r100 = -2.0f;
    L5:
        float r105 = 2.0f;
        if (r100 <= 2.0f) goto L9;
        r100 = 2.0f;
    L9:
        if (r101 >= (-2.0f)) goto L12;
        r101 = -2.0f;
    L12:
        if (r101 <= 2.0f) goto L15;
        r101 = 2.0f;
    L15:
        if (r102 >= (-2.0f)) goto L18;
        r102 = -2.0f;
    L18:
        if (r102 > 2.0f) goto L22;
        r105 = r102;
    L22:
        return ColorKt.Color(r100, r101, r105, r103, r104);
    }
}
