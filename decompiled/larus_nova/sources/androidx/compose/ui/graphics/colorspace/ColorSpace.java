package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 82\u00020\u0001:\u00018B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\u0012\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0007H&J\u0012\u0010\u001b\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0007H&J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0007J\u0012\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010!\u001a\u00020\u001dH'J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0019H\u0010¢\u0006\u0002\b'J%\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0019H\u0010¢\u0006\u0002\b)J7\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0000H\u0010¢\u0006\u0004\b1\u00102J \u00103\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u0019H\u0007J\u0012\u00103\u001a\u00020\u001d2\b\b\u0001\u0010!\u001a\u00020\u001dH'J\b\u00104\u001a\u00020\u0003H\u0016J\u0013\u00105\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00107\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016¨\u00069"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", "name", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "id", "", "<init>", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getModel-xdoWZVw", "()J", "J", "getId$ui_graphics_release", "()I", "componentCount", "getComponentCount", "isWideGamut", "", "()Z", "isSrgb", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "r", ce.f26391f, "b", BaseSwitches.V, "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "toString", "equals", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ColorSpace {
    public static final Companion Companion = null;
    public static final int MaxId = 63;
    public static final int MinId = -1;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f15183id;
    private final long model;
    private final String name;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace$Companion;", "", "<init>", "()V", "MinId", "", "MaxId", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public /* synthetic */ ColorSpace(String r100, long r101, int r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ ColorSpace(String r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public abstract float[] fromXyz(float[] r100);

    public abstract float getMaxValue(int r100);

    public abstract float getMinValue(int r100);

    public boolean isSrgb() {
        return false;
    }

    public abstract boolean isWideGamut();

    public abstract float[] toXyz(float[] r100);

    public final int getComponentCount() {
        return ColorModel.m5262getComponentCountimpl(this.model);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + ColorModel.m5263hashCodeimpl(this.model)) * 31) + this.f15183id;
    }

    public String toString() {
        return this.name + " (id=" + this.f15183id + ", model=" + ColorModel.m5264toStringimpl(this.model) + ')';
    }

    public final int getId$ui_graphics_release() {
        return this.f15183id;
    }

    /* JADX INFO: renamed from: getModel-xdoWZVw, reason: not valid java name */
    public final long m5270getModelxdoWZVw() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        ColorSpace r101 = (ColorSpace) r100;
        if (this.f15183id == r101.f15183id) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L17;
        return false;
    L17:
        return ColorModel.m5261equalsimpl0(this.model, r101.model);
    L19:
        return false;
    }

    private ColorSpace(String r100, long r101) {
        this(r100, r101, -1, null);
    }

    private ColorSpace(String r100, long r101, int r102) {
        this.name = r100;
        this.model = r101;
        this.f15183id = r102;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L15;
        if (r102 < (-1)) goto L13;
        if (r102 > 63) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("The id must be between -1 and 63");
    L15:
        throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
    L5:
        r103 = false;
        goto L6
    }

    public final float[] fromXyz(float r100, float r101, float r102) {
        float[] r103 = new float[ColorModel.m5262getComponentCountimpl(this.model)];
        r103[0] = r100;
        r103[1] = r101;
        r103[2] = r102;
        return fromXyz(r103);
    }

    public long toXy$ui_graphics_release(float r100, float r101, float r102) {
        float[] r103 = toXyz(r100, r101, r102);
        float r104 = r103[0];
        float r105 = r103[1];
        return (Float.floatToRawIntBits(r104) << 32) | (Float.floatToRawIntBits(r105) & BodyPartID.bodyIdMax);
    }

    public final float[] toXyz(float r100, float r101, float r102) {
        return toXyz(new float[]{r100, r101, r102});
    }

    public float toZ$ui_graphics_release(float r100, float r101, float r102) {
        return toXyz(r100, r101, r102)[2];
    }

    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release, reason: not valid java name */
    public long mo5271xyzaToColorJlNiLsg$ui_graphics_release(float r100, float r101, float r102, float r103, ColorSpace r104) {
        float[] r105 = fromXyz(r100, r101, r102);
        return ColorKt.Color(r105[0], r105[1], r105[2], r103, r104);
    }
}
