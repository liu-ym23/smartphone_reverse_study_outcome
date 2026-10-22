package androidx.compose.foundation.shape;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J?\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getTopStart", "()Landroidx/compose/foundation/shape/CornerSize;", "getTopEnd", "getBottomEnd", "getBottomStart", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "all", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CornerBasedShape implements Shape {
    public static final int $stable = 0;
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    public abstract CornerBasedShape copy(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103);

    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo1009createOutlineLjSzlW0(long r100, float r101, float r102, float r103, float r104, LayoutDirection r105);

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }

    public final CornerBasedShape copy(CornerSize r100) {
        return copy(r100, r100, r100, r100);
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final Outline mo288createOutlinePq9zytI(long r110, LayoutDirection r111, Density r112) {
        float r100 = this.topStart.mo1017toPxTmRCtEA(r110, r112);
        float r101 = this.topEnd.mo1017toPxTmRCtEA(r110, r112);
        float r102 = this.bottomEnd.mo1017toPxTmRCtEA(r110, r112);
        float r103 = this.bottomStart.mo1017toPxTmRCtEA(r110, r112);
        float r104 = Size.m4650getMinDimensionimpl(r110);
        float r105 = r100 + r103;
        if (r105 <= r104) goto L5;
        float r106 = r104 / r105;
        r100 = r100 * r106;
        r103 = r103 * r106;
    L5:
        float r107 = r103;
        float r108 = r101 + r102;
        if (r108 <= r104) goto L9;
        float r109 = r104 / r108;
        r101 = r101 * r109;
        r102 = r102 * r109;
    L9:
        if (r100 >= 0.0f) goto L11;
    L17:
        boolean r113 = false;
    L18:
        if (r113 == true) goto L21;
        InlineClassHelperKt.throwIllegalArgumentException("Corner size in Px can't be negative(topStart = " + r100 + ", topEnd = " + r101 + ", bottomEnd = " + r102 + ", bottomStart = " + r107 + ")!");
    L21:
        return mo1009createOutlineLjSzlW0(r110, r100, r101, r102, r107, r111);
    L11:
        if (r101 < 0.0f) goto L17;
        if (r102 < 0.0f) goto L17;
        if (r107 < 0.0f) goto L17;
        r113 = true;
        goto L18
    }

    public CornerBasedShape(CornerSize r100, CornerSize r101, CornerSize r102, CornerSize r103) {
        this.topStart = r100;
        this.topEnd = r101;
        this.bottomEnd = r102;
        this.bottomStart = r103;
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape r100, CornerSize r101, CornerSize r102, CornerSize r103, CornerSize r104, int r105, Object r106) {
        if (r106 != null) goto L18;
        if ((r105 & 1) == 0) goto L7;
        r101 = r100.topStart;
    L7:
        if ((r105 & 2) == 0) goto L10;
        r102 = r100.topEnd;
    L10:
        if ((r105 & 4) == 0) goto L13;
        r103 = r100.bottomEnd;
    L13:
        if ((r105 & 8) == 0) goto L16;
        r104 = r100.bottomStart;
    L16:
        return r100.copy(r101, r102, r103, r104);
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }
}
