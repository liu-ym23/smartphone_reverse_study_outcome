package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topLeft", "Landroidx/compose/foundation/shape/CornerSize;", "topRight", "bottomRight", "bottomLeft", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "topStart", "", "topEnd", "bottomEnd", "bottomStart", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AbsoluteCutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public String toString() {
        return "AbsoluteCutCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbsoluteCutCornerShape) == true) goto L8;
        return false;
    L8:
        AbsoluteCutCornerShape r101 = (AbsoluteCutCornerShape) r100;
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

    public AbsoluteCutCornerShape(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        super(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public AbsoluteCutCornerShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        return new AbsoluteCutCornerShape(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public /* bridge */ /* synthetic */ CornerBasedShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        return copy(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0, reason: not valid java name */
    public Outline mo1009createOutlineLjSzlW0(long r100, float r101, float r102, float r103, float r104, LayoutDirection r110) {
        if ((((r101 + r102) + r104) + r103) != 0.0f) goto L5;
        boolean r111 = true;
    L6:
        if (r111 == true) goto L10;
        Path r112 = AndroidPath_androidKt.Path();
        r112.moveTo(0.0f, r101);
        r112.lineTo(r101, 0.0f);
        int r105 = (int) (r100 >> 32);
        r112.lineTo(Float.intBitsToFloat(r105) - r102, 0.0f);
        r112.lineTo(Float.intBitsToFloat(r105), r102);
        float r106 = Float.intBitsToFloat(r105);
        int r107 = (int) (r100 & BodyPartID.bodyIdMax);
        r112.lineTo(r106, Float.intBitsToFloat(r107) - r103);
        r112.lineTo(Float.intBitsToFloat(r105) - r103, Float.intBitsToFloat(r107));
        r112.lineTo(r104, Float.intBitsToFloat(r107));
        r112.lineTo(0.0f, Float.intBitsToFloat(r107) - r104);
        r112.close();
        return new Outline.Generic(r112);
    L10:
        return new Outline.Rectangle(SizeKt.m4672toRectuvyYCjk(r100));
    L5:
        r111 = false;
        goto L6
    }
}
