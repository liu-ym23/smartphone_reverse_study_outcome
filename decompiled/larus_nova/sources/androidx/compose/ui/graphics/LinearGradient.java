package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "<init>", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List r100, List r101, long r102, long r103, int r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo4774getIntrinsicSizeNHjbRc() {
        float r100 = Float.intBitsToFloat((int) (this.start >> 32));
        boolean r101 = true;
        if (Float.isInfinite(r100) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        float r103 = Float.NaN;
        if (r102 == false) goto L18;
        float r104 = Float.intBitsToFloat((int) (this.end >> 32));
        if (Float.isInfinite(r104) == false) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L18;
        float r106 = Math.abs(Float.intBitsToFloat((int) (this.start >> 32)) - Float.intBitsToFloat((int) (this.end >> 32)));
    L19:
        float r107 = Float.intBitsToFloat((int) (this.start & BodyPartID.bodyIdMax));
        if (Float.isInfinite(r107) == false) goto L22;
    L24:
        boolean r108 = false;
    L25:
        if (r108 == false) goto L34;
        float r109 = Float.intBitsToFloat((int) (this.end & BodyPartID.bodyIdMax));
        if (Float.isInfinite(r109) == false) goto L29;
    L31:
        r101 = false;
    L32:
        if (r101 == false) goto L34;
        r103 = Math.abs(Float.intBitsToFloat((int) (this.start & BodyPartID.bodyIdMax)) - Float.intBitsToFloat((int) (this.end & BodyPartID.bodyIdMax)));
        goto L34
    L29:
        if (Float.isNaN(r109) == true) goto L31;
    L34:
        long r110 = Float.floatToRawIntBits(r106);
        return Size.m4642constructorimpl((((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax) | (r110 << 32));
    L22:
        if (Float.isNaN(r107) == true) goto L24;
        r108 = true;
        goto L25
    L13:
        if (Float.isNaN(r104) == true) goto L15;
        r105 = true;
    L18:
        r106 = Float.NaN;
        goto L19
    L5:
        if (Float.isNaN(r100) == true) goto L7;
        r102 = true;
        goto L8
    }

    public int hashCode() {
        int r100 = this.colors.hashCode() * 31;
        List<Float> r101 = this.stops;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((((((r100 + r102) * 31) + Offset.m4584hashCodeimpl(this.start)) * 31) + Offset.m4584hashCodeimpl(this.end)) * 31) + TileMode.m5223hashCodeimpl(this.tileMode);
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        boolean r100 = true;
        if (((((this.start & androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase) ^ androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase) - androidx.compose.ui.geometry.InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) != 0) goto L5;
        boolean r101 = true;
    L6:
        String r102 = "";
        if (r101 == false) goto L9;
        String r103 = "start=" + Offset.m4590toStringimpl(this.start) + ", ";
    L11:
        if ((((androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase ^ (this.end & androidx.compose.ui.geometry.InlineClassHelperKt.DualFloatInfinityBase)) - androidx.compose.ui.geometry.InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) goto L14;
        r100 = false;
    L14:
        if (r100 == false) goto L17;
        r102 = "end=" + Offset.m4590toStringimpl(this.end) + ", ";
    L17:
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + r103 + r102 + "tileMode=" + TileMode.m5224toStringimpl(this.tileMode) + ')';
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
        boolean r100 = true;
        if (Float.intBitsToFloat((int) (this.start >> 32)) != Float.POSITIVE_INFINITY) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        long r102 = r110 >> 32;
    L9:
        float r103 = Float.intBitsToFloat((int) r102);
        if (Float.intBitsToFloat((int) (this.start & BodyPartID.bodyIdMax)) != Float.POSITIVE_INFINITY) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        long r105 = r110 & BodyPartID.bodyIdMax;
    L16:
        float r106 = Float.intBitsToFloat((int) r105);
        if (Float.intBitsToFloat((int) (this.end >> 32)) != Float.POSITIVE_INFINITY) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        long r111 = r110 >> 32;
    L23:
        float r108 = Float.intBitsToFloat((int) r111);
        if (Float.intBitsToFloat((int) (this.end & BodyPartID.bodyIdMax)) == Float.POSITIVE_INFINITY) goto L27;
        r100 = false;
    L27:
        if (r100 == false) goto L29;
        long r109 = r110 & BodyPartID.bodyIdMax;
    L30:
        float r112 = Float.intBitsToFloat((int) r109);
        List<Color> r113 = this.colors;
        List<Float> r114 = this.stops;
        long r115 = Offset.m4574constructorimpl((Float.floatToRawIntBits(r103) << 32) | (((long) Float.floatToRawIntBits(r106)) & BodyPartID.bodyIdMax));
        long r116 = Float.floatToRawIntBits(r108);
        return ShaderKt.m5166LinearGradientShaderVjE6UOU(r115, Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r112)) & BodyPartID.bodyIdMax) | (r116 << 32)), r113, r114, this.tileMode);
    L29:
        r109 = this.end & BodyPartID.bodyIdMax;
        goto L30
    L22:
        r111 = this.end >> 32;
        goto L23
    L19:
        r107 = false;
        goto L20
    L15:
        r105 = this.start & BodyPartID.bodyIdMax;
        goto L16
    L12:
        r104 = false;
        goto L13
    L8:
        r102 = this.start >> 32;
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LinearGradient) == true) goto L8;
        return false;
    L8:
        LinearGradient r101 = (LinearGradient) r100;
        if (Intrinsics.areEqual(this.colors, r101.colors) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stops, r101.stops) == true) goto L15;
        return false;
    L15:
        if (Offset.m4579equalsimpl0(this.start, r101.start) == true) goto L18;
        return false;
    L18:
        if (Offset.m4579equalsimpl0(this.end, r101.end) == true) goto L21;
        return false;
    L21:
        if (TileMode.m5222equalsimpl0(this.tileMode, r101.tileMode) == true) goto L23;
        return false;
    L23:
        return true;
    }

    private LinearGradient(List<Color> r100, List<Float> r101, long r102, long r103, int r104) {
        this.colors = r100;
        this.stops = r101;
        this.start = r102;
        this.end = r103;
        this.tileMode = r104;
    }

    public /* synthetic */ LinearGradient(List r110, List r111, long r112, long r113, int r114, int r115, DefaultConstructorMarker r116) {
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
