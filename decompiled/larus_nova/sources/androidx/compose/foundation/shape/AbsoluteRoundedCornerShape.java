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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0013\u0010\u001f\u001a\u00020 *\u00020\u000eH\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topLeft", "Landroidx/compose/foundation/shape/CornerSize;", "topRight", "bottomRight", "bottomLeft", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "topStart", "", "topEnd", "bottomEnd", "bottomStart", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "toRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "toRadius-Bz7bX_o", "(F)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AbsoluteRoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public String toString() {
        return "AbsoluteRoundedCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    /* JADX INFO: renamed from: toRadius-Bz7bX_o, reason: not valid java name */
    private final long m1013toRadiusBz7bX_o(float r100) {
        return CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r100) << 32) | (((long) Float.floatToRawIntBits(r100)) & BodyPartID.bodyIdMax));
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbsoluteRoundedCornerShape) == true) goto L8;
        return false;
    L8:
        AbsoluteRoundedCornerShape r101 = (AbsoluteRoundedCornerShape) r100;
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

    public AbsoluteRoundedCornerShape(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        super(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public AbsoluteRoundedCornerShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        return new AbsoluteRoundedCornerShape(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public /* bridge */ /* synthetic */ CornerBasedShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        return copy(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo1009createOutlineLjSzlW0(long r110, float r111, float r112, float r210, float r211, LayoutDirection r212) {
        if ((((r111 + r112) + r210) + r211) != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L10;
        Rect r101 = SizeKt.m4672toRectuvyYCjk(r110);
        long r102 = CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r111) << 32) | (((long) Float.floatToRawIntBits(r111)) & BodyPartID.bodyIdMax));
        long r103 = CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r112) << 32) | (((long) Float.floatToRawIntBits(r112)) & BodyPartID.bodyIdMax));
        long r104 = CornerRadius.m4536constructorimpl((Float.floatToRawIntBits(r210) << 32) | (((long) Float.floatToRawIntBits(r210)) & BodyPartID.bodyIdMax));
        long r113 = Float.floatToRawIntBits(r211);
        return new Outline.Rounded(RoundRectKt.m4634RoundRectZAM2FJo(r101, r102, r103, r104, CornerRadius.m4536constructorimpl((((long) Float.floatToRawIntBits(r211)) & BodyPartID.bodyIdMax) | (r113 << 32))));
    L10:
        return new Outline.Rectangle(SizeKt.m4672toRectuvyYCjk(r110));
    L5:
        r100 = false;
        goto L6
    }
}
