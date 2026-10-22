package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/RadialGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "<init>", "(Ljava/util/List;Ljava/util/List;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RadialGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final float radius;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RadialGradient(List r100, List r101, long r102, float r103, int r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo4774getIntrinsicSizeNHjbRc() {
        if ((Float.floatToRawIntBits(this.radius) & Integer.MAX_VALUE) >= 2139095040) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        float r101 = this.radius;
        float r102 = 2;
        float r103 = r101 * r102;
        float r104 = r101 * r102;
        return Size.m4642constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    L9:
        return Size.Companion.m4659getUnspecifiedNHjbRc();
    L5:
        r100 = false;
        goto L6
    }

    public int hashCode() {
        int r100 = this.colors.hashCode() * 31;
        List<Float> r101 = this.stops;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((((((r100 + r102) * 31) + Offset.m4584hashCodeimpl(this.center)) * 31) + Float.floatToIntBits(this.radius)) * 31) + TileMode.m5223hashCodeimpl(this.tileMode);
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        boolean r100 = true;
        if ((this.center & 9223372034707292159L) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r101 = true;
    L6:
        String r102 = "";
        if (r101 == false) goto L9;
        String r103 = "center=" + Offset.m4590toStringimpl(this.center) + ", ";
    L11:
        if ((Float.floatToRawIntBits(this.radius) & Integer.MAX_VALUE) < 2139095040) goto L14;
        r100 = false;
    L14:
        if (r100 == false) goto L17;
        r102 = "radius=" + this.radius + ", ";
    L17:
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + r103 + r102 + "tileMode=" + TileMode.m5224toStringimpl(this.tileMode) + ')';
    L9:
        r103 = "";
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo4796createShaderuvyYCjk(long r110) {
        long r100 = this.center;
        boolean r101 = true;
        if ((9223372034707292159L & r100) != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        long r103 = SizeKt.m4661getCenteruvyYCjk(r110);
        float r104 = Float.intBitsToFloat((int) (r103 >> 32));
        float r105 = Float.intBitsToFloat((int) (r103 & BodyPartID.bodyIdMax));
    L24:
        List<Color> r111 = this.colors;
        List<Float> r112 = this.stops;
        long r113 = Offset.m4574constructorimpl((Float.floatToRawIntBits(r104) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(r105)));
        float r106 = this.radius;
        if (r106 == Float.POSITIVE_INFINITY) goto L28;
        r101 = false;
    L28:
        if (r101 == false) goto L31;
        r106 = Size.m4650getMinDimensionimpl(r110) / 2;
    L31:
        return ShaderKt.m5168RadialGradientShader8uybcMk(r113, r106, r111, r112, this.tileMode);
    L10:
        if (Float.intBitsToFloat((int) (r100 >> 32)) != Float.POSITIVE_INFINITY) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        long r108 = r110 >> 32;
    L16:
        r104 = Float.intBitsToFloat((int) r108);
        if (Float.intBitsToFloat((int) (this.center & BodyPartID.bodyIdMax)) != Float.POSITIVE_INFINITY) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L22;
        long r114 = r110 & BodyPartID.bodyIdMax;
    L23:
        r105 = Float.intBitsToFloat((int) r114);
        goto L24
    L22:
        r114 = this.center & BodyPartID.bodyIdMax;
        goto L23
    L19:
        r109 = false;
        goto L20
    L15:
        r108 = this.center >> 32;
        goto L16
    L12:
        r107 = false;
        goto L13
    L5:
        r102 = false;
        goto L7
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RadialGradient) == true) goto L8;
        return false;
    L8:
        RadialGradient r101 = (RadialGradient) r100;
        if (Intrinsics.areEqual(this.colors, r101.colors) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stops, r101.stops) == true) goto L15;
        return false;
    L15:
        if (Offset.m4579equalsimpl0(this.center, r101.center) == true) goto L18;
        return false;
    L18:
        if (this.radius != r101.radius) goto L20;
        boolean r102 = true;
    L21:
        if (r102 == true) goto L24;
        return false;
    L24:
        if (TileMode.m5222equalsimpl0(this.tileMode, r101.tileMode) == true) goto L26;
        return false;
    L26:
        return true;
    L20:
        r102 = false;
        goto L21
    }

    private RadialGradient(List<Color> r100, List<Float> r101, long r102, float r103, int r104) {
        this.colors = r100;
        this.stops = r101;
        this.center = r102;
        this.radius = r103;
        this.tileMode = r104;
    }

    public /* synthetic */ RadialGradient(List r110, List r111, long r112, float r113, int r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 2) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r115 & 16) == 0) goto L9;
        int r101 = TileMode.Companion.m5226getClamp3opZhB0();
    L10:
        this(r110, r100, r112, r113, r101, null);
        return;
    L9:
        r101 = r114;
        goto L10
    L5:
        r100 = r111;
        goto L7
    }
}
