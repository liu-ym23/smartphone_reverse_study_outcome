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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/shape/CutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public String toString() {
        return "CutCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CutCornerShape) == true) goto L8;
        return false;
    L8:
        CutCornerShape r101 = (CutCornerShape) r100;
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

    public CutCornerShape(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        super(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public CutCornerShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        return new CutCornerShape(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public /* bridge */ /* synthetic */ CornerBasedShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        return copy(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo1009createOutlineLjSzlW0(long r100, float r101, float r110, float r111, float r112, LayoutDirection r113) {
        if ((((r101 + r110) + r112) + r111) != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L24;
        Path r103 = AndroidPath_androidKt.Path();
        LayoutDirection r104 = LayoutDirection.Ltr;
        if (r113 != r104) goto L11;
        float r105 = r101;
    L12:
        r103.moveTo(0.0f, r105);
        r103.lineTo(r105, 0.0f);
        if (r113 != r104) goto L15;
        r101 = r110;
    L15:
        int r114 = (int) (r100 >> 32);
        r103.lineTo(Float.intBitsToFloat(r114) - r101, 0.0f);
        r103.lineTo(Float.intBitsToFloat(r114), r101);
        if (r113 != r104) goto L18;
        float r106 = r111;
    L19:
        float r107 = Float.intBitsToFloat(r114);
        int r108 = (int) (r100 & BodyPartID.bodyIdMax);
        r103.lineTo(r107, Float.intBitsToFloat(r108) - r106);
        r103.lineTo(Float.intBitsToFloat(r114) - r106, Float.intBitsToFloat(r108));
        if (r113 != r104) goto L22;
        r111 = r112;
    L22:
        r103.lineTo(r111, Float.intBitsToFloat(r108));
        r103.lineTo(0.0f, Float.intBitsToFloat(r108) - r111);
        r103.close();
        return new Outline.Generic(r103);
    L18:
        r106 = r112;
        goto L19
    L11:
        r105 = r110;
        goto L12
    L24:
        return new Outline.Rectangle(SizeKt.m4672toRectuvyYCjk(r100));
    L5:
        r102 = false;
        goto L6
    }
}
