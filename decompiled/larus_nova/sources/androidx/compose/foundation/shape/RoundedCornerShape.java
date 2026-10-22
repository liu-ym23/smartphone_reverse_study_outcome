package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/shape/RoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public String toString() {
        return "RoundedCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RoundedCornerShape) == true) goto L8;
        return false;
    L8:
        RoundedCornerShape r101 = (RoundedCornerShape) r100;
        if (Intrinsics.areEqual(getTopStart(), r101.getTopStart()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getTopEnd(), r101.getTopEnd()) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getBottomEnd(), r101.getBottomEnd()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getBottomStart(), r101.getBottomStart()) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public RoundedCornerShape(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        super(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public RoundedCornerShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        return new RoundedCornerShape(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public /* bridge */ /* synthetic */ CornerBasedShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        return copy(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo1009createOutlineLjSzlW0(long r110, float r111, float r210, float r211, float r212, LayoutDirection r213) {
        if ((((r111 + r210) + r211) + r212) != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L26;
        Rect r101 = SizeKt.m4672toRectuvyYCjk(r110);
        LayoutDirection r102 = LayoutDirection.Ltr;
        if (r213 != r102) goto L11;
        float r103 = r111;
    L12:
        long r104 = CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r103) << 32) | (((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax));
        if (r213 != r102) goto L15;
        float r105 = r210;
    L16:
        long r112 = Float.floatToRawIntBits(r105);
        long r106 = CornerRadius.m4536constructorimpl((((long) Float.floatToRawIntBits(r105)) & BodyPartID.bodyIdMax) | (r112 << 32));
        if (r213 != r102) goto L19;
        float r113 = r211;
    L20:
        long r114 = CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r113) << 32) | (Float.floatToRawIntBits(r113) & BodyPartID.bodyIdMax));
        if (r213 != r102) goto L23;
        float r107 = r212;
    L24:
        long r115 = Float.floatToRawIntBits(r107);
        return new Outline.Rounded(RoundRectKt.m4634RoundRectZAM2FJo(r101, r104, r106, r114, CornerRadius.m4536constructorimpl((((long) Float.floatToRawIntBits(r107)) & BodyPartID.bodyIdMax) | (r115 << 32))));
    L23:
        r107 = r211;
        goto L24
    L19:
        r113 = r212;
        goto L20
    L15:
        r105 = r111;
        goto L16
    L11:
        r103 = r210;
        goto L12
    L26:
        return new Outline.Rectangle(SizeKt.m4672toRectuvyYCjk(r110));
    L5:
        r100 = false;
        goto L6
    }
}
