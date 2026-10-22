package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/graphics/SweepGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "center", "Landroidx/compose/ui/geometry/Offset;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "<init>", "(JLjava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SweepGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final List<Float> stops;

    public /* synthetic */ SweepGradient(long r100, List r101, List r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public int hashCode() {
        int r100 = ((Offset.m4584hashCodeimpl(this.center) * 31) + this.colors.hashCode()) * 31;
        List<Float> r101 = this.stops;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        if ((this.center & 9223372034707292159L) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        String r101 = "center=" + Offset.m4590toStringimpl(this.center) + ", ";
    L10:
        return "SweepGradient(" + r101 + "colors=" + this.colors + ", stops=" + this.stops + ')';
    L8:
        r101 = "";
        goto L10
    L5:
        r100 = false;
        goto L6
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo4796createShaderuvyYCjk(long r110) {
        long r100 = this.center;
        boolean r101 = true;
        if ((9223372034707292159L & r100) != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        long r111 = SizeKt.m4661getCenteruvyYCjk(r110);
    L24:
        return ShaderKt.m5170SweepGradientShader9KIMszo(r111, this.colors, this.stops);
    L9:
        if (Float.intBitsToFloat((int) (r100 >> 32)) != Float.POSITIVE_INFINITY) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        long r104 = r110 >> 32;
    L15:
        float r105 = Float.intBitsToFloat((int) r104);
        if (Float.intBitsToFloat((int) (this.center & BodyPartID.bodyIdMax)) == Float.POSITIVE_INFINITY) goto L19;
        r101 = false;
    L19:
        if (r101 == true) goto L22;
        r110 = this.center;
    L22:
        float r112 = Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax));
        long r106 = Float.floatToRawIntBits(r105);
        r111 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r112)) & BodyPartID.bodyIdMax) | (r106 << 32));
        goto L24
    L14:
        r104 = this.center >> 32;
        goto L15
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SweepGradient) == true) goto L8;
        return false;
    L8:
        SweepGradient r101 = (SweepGradient) r100;
        if (Offset.m4579equalsimpl0(this.center, r101.center) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.colors, r101.colors) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.stops, r101.stops) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private SweepGradient(long r100, List<Color> r101, List<Float> r102) {
        this.center = r100;
        this.colors = r101;
        this.stops = r102;
    }

    public /* synthetic */ SweepGradient(long r100, List r101, List r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 4) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r110, null);
    }
}
