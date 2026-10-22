package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", BaseSwitches.V, "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Lab extends ColorSpace {
    private static final float A = 0.008856452f;
    private static final float B = 7.787037f;
    private static final float C = 0.13793103f;
    public static final Companion Companion = null;
    private static final float D = 0.20689656f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab$Companion;", "", "<init>", "()V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "B", "C", "D", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int r100) {
        if (r100 != 0) goto L4;
        return 100.0f;
    L4:
        return 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int r100) {
        if (r100 != 0) goto L4;
        return 0.0f;
    L4:
        return -128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] r110) {
        float r100 = r110[0];
        Illuminant r101 = Illuminant.INSTANCE;
        float r102 = r100 / r101.getD50Xyz$ui_graphics_release()[0];
        float r103 = r110[1] / r101.getD50Xyz$ui_graphics_release()[1];
        float r104 = r110[2] / r101.getD50Xyz$ui_graphics_release()[2];
        if (r102 <= A) goto L5;
        float r105 = (float) Math.cbrt(r102);
    L7:
        if (r103 <= A) goto L9;
        float r106 = (float) Math.cbrt(r103);
    L11:
        if (r104 <= A) goto L13;
        float r107 = (float) Math.cbrt(r104);
    L14:
        float r108 = (116.0f * r106) - 16.0f;
        float r109 = (r105 - r106) * 500.0f;
        float r111 = (r106 - r107) * 200.0f;
        if (r108 >= 0.0f) goto L18;
        r108 = 0.0f;
    L18:
        if (r108 <= 100.0f) goto L20;
        r108 = 100.0f;
    L20:
        r110[0] = r108;
        if (r109 >= (-128.0f)) goto L23;
        r109 = -128.0f;
    L23:
        float r112 = 128.0f;
        if (r109 <= 128.0f) goto L26;
        r109 = 128.0f;
    L26:
        r110[1] = r109;
        if (r111 >= (-128.0f)) goto L30;
        r111 = -128.0f;
    L30:
        if (r111 > 128.0f) goto L33;
        r112 = r111;
    L33:
        r110[2] = r112;
        return r110;
    L13:
        r107 = C + (r104 * B);
        goto L14
    L9:
        r106 = (r103 * B) + C;
        goto L11
    L5:
        r105 = (r102 * B) + C;
        goto L7
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] r110) {
        float r100 = r110[0];
        if (r100 >= 0.0f) goto L6;
        r100 = 0.0f;
    L6:
        if (r100 <= 100.0f) goto L8;
        r100 = 100.0f;
    L8:
        r110[0] = r100;
        float r101 = r110[1];
        float r102 = -128.0f;
        if (r101 >= (-128.0f)) goto L11;
        r101 = -128.0f;
    L11:
        float r103 = 128.0f;
        if (r101 <= 128.0f) goto L14;
        r101 = 128.0f;
    L14:
        r110[1] = r101;
        float r104 = r110[2];
        if (r104 < (-128.0f)) goto L19;
        r102 = r104;
    L19:
        if (r102 > 128.0f) goto L22;
        r103 = r102;
    L22:
        r110[2] = r103;
        float r105 = (r100 + 16.0f) / 116.0f;
        float r106 = (r101 * 0.002f) + r105;
        float r107 = r105 - (r103 * 0.005f);
        if (r106 <= D) goto L25;
        float r108 = (r106 * r106) * r106;
    L27:
        if (r105 <= D) goto L29;
        float r109 = (r105 * r105) * r105;
    L31:
        if (r107 <= D) goto L33;
        float r111 = (r107 * r107) * r107;
    L34:
        Illuminant r112 = Illuminant.INSTANCE;
        r110[0] = r108 * r112.getD50Xyz$ui_graphics_release()[0];
        r110[1] = r109 * r112.getD50Xyz$ui_graphics_release()[1];
        r110[2] = r111 * r112.getD50Xyz$ui_graphics_release()[2];
        return r110;
    L33:
        r111 = (r107 - C) * 0.12841855f;
        goto L34
    L29:
        r109 = (r105 - C) * 0.12841855f;
        goto L31
    L25:
        r108 = (r106 - C) * 0.12841855f;
        goto L27
    }

    public Lab(String r100, int r101) {
        super(r100, ColorModel.Companion.m5267getLabxdoWZVw(), r101, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float r100, float r101, float r102) {
        if (r100 >= 0.0f) goto L6;
        r100 = 0.0f;
    L6:
        if (r100 <= 100.0f) goto L9;
        r100 = 100.0f;
    L9:
        if (r101 >= (-128.0f)) goto L12;
        r101 = -128.0f;
    L12:
        if (r101 <= 128.0f) goto L14;
        r101 = 128.0f;
    L14:
        float r103 = (r100 + 16.0f) / 116.0f;
        float r104 = (r101 * 0.002f) + r103;
        if (r104 <= D) goto L17;
        float r105 = (r104 * r104) * r104;
    L19:
        if (r103 <= D) goto L21;
        float r106 = (r103 * r103) * r103;
    L22:
        Illuminant r107 = Illuminant.INSTANCE;
        float r108 = r105 * r107.getD50Xyz$ui_graphics_release()[0];
        float r109 = r106 * r107.getD50Xyz$ui_graphics_release()[1];
        long r110 = Float.floatToRawIntBits(r108);
        return (((long) Float.floatToRawIntBits(r109)) & BodyPartID.bodyIdMax) | (r110 << 32);
    L21:
        r106 = (r103 - C) * 0.12841855f;
        goto L22
    L17:
        r105 = (r104 - C) * 0.12841855f;
        goto L19
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float r100, float r101, float r102) {
        if (r100 >= 0.0f) goto L6;
        r100 = 0.0f;
    L6:
        if (r100 <= 100.0f) goto L9;
        r100 = 100.0f;
    L9:
        if (r102 >= (-128.0f)) goto L12;
        r102 = -128.0f;
    L12:
        if (r102 <= 128.0f) goto L14;
        r102 = 128.0f;
    L14:
        float r103 = ((r100 + 16.0f) / 116.0f) - (r102 * 0.005f);
        if (r103 <= D) goto L17;
        float r104 = (r103 * r103) * r103;
    L19:
        return r104 * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    L17:
        r104 = 0.12841855f * (r103 - C);
        goto L19
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo5271xyzaToColorJlNiLsg$ui_graphics_release(float r100, float r101, float r102, float r103, ColorSpace r110) {
        Illuminant r104 = Illuminant.INSTANCE;
        float r105 = r100 / r104.getD50Xyz$ui_graphics_release()[0];
        float r106 = r101 / r104.getD50Xyz$ui_graphics_release()[1];
        float r107 = r102 / r104.getD50Xyz$ui_graphics_release()[2];
        if (r105 <= A) goto L5;
        float r108 = (float) Math.cbrt(r105);
    L7:
        if (r106 <= A) goto L9;
        float r109 = (float) Math.cbrt(r106);
    L11:
        if (r107 <= A) goto L13;
        float r111 = (float) Math.cbrt(r107);
    L14:
        float r112 = (116.0f * r109) - 16.0f;
        float r113 = (r108 - r109) * 500.0f;
        float r114 = (r109 - r111) * 200.0f;
        if (r112 >= 0.0f) goto L18;
        r112 = 0.0f;
    L18:
        if (r112 <= 100.0f) goto L21;
        r112 = 100.0f;
    L21:
        if (r113 >= (-128.0f)) goto L23;
        r113 = -128.0f;
    L23:
        float r115 = 128.0f;
        if (r113 <= 128.0f) goto L27;
        r113 = 128.0f;
    L27:
        if (r114 >= (-128.0f)) goto L30;
        r114 = -128.0f;
    L30:
        if (r114 > 128.0f) goto L34;
        r115 = r114;
    L34:
        return ColorKt.Color(r112, r113, r115, r103, r110);
    L13:
        r111 = (r107 * B) + C;
        goto L14
    L9:
        r109 = (r106 * B) + C;
        goto L11
    L5:
        r108 = (r105 * B) + C;
        goto L7
    }
}
