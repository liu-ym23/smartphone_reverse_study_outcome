package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;F)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getFraction", "()F", "setFraction", "(F)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public static /* synthetic */ Unit a(Placeable r100, Placeable.PlacementScope r101) {
        return measure_3p2s80s$lambda$0(r100, r101);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return LayoutModifierNode.CC.$default$maxIntrinsicHeight(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return LayoutModifierNode.CC.$default$maxIntrinsicWidth(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return LayoutModifierNode.CC.$default$minIntrinsicHeight(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return LayoutModifierNode.CC.$default$minIntrinsicWidth(this, r100, r101, r102);
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final void setDirection(Direction r100) {
        this.direction = r100;
    }

    public final void setFraction(float r100) {
        this.fraction = r100;
    }

    public FillNode(Direction r100, float r101) {
        this.direction = r100;
        this.fraction = r101;
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable r100, Placeable.PlacementScope r101) {
        Placeable.PlacementScope.placeRelative$default(r101, r100, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r100, Measurable r101, long r110) {
        if (Constraints.m7483getHasBoundedWidthimpl(r110) == true) goto L5;
    L13:
        int r102 = Constraints.m7489getMinWidthimpl(r110);
        int r103 = Constraints.m7487getMaxWidthimpl(r110);
    L15:
        if (Constraints.m7482getHasBoundedHeightimpl(r110) == true) goto L17;
    L25:
        int r104 = Constraints.m7488getMinHeightimpl(r110);
        int r111 = Constraints.m7486getMaxHeightimpl(r110);
        int r112 = r104;
    L26:
        final Placeable r105 = r101.mo6256measureBRTryo0(ConstraintsKt.Constraints(r102, r103, r112, r111));
        return MeasureScope.CC.layout$default(r100, r105.getWidth(), r105.getHeight(), null, new e0(r105), 4, null);
    L17:
        if (this.direction == Direction.Horizontal) goto L25;
        int r106 = Math.round(Constraints.m7486getMaxHeightimpl(r110) * this.fraction);
        int r107 = Constraints.m7488getMinHeightimpl(r110);
        r112 = Constraints.m7486getMaxHeightimpl(r110);
        if (r106 >= r107) goto L21;
        r106 = r107;
    L21:
        if (r106 > r112) goto L24;
        r112 = r106;
    L24:
        r111 = r112;
        goto L26
    L5:
        if (this.direction == Direction.Vertical) goto L13;
        int r108 = Math.round(Constraints.m7487getMaxWidthimpl(r110) * this.fraction);
        int r109 = Constraints.m7489getMinWidthimpl(r110);
        r102 = Constraints.m7487getMaxWidthimpl(r110);
        if (r108 >= r109) goto L9;
        r108 = r109;
    L9:
        if (r108 > r102) goto L12;
        r102 = r108;
    L12:
        r103 = r102;
        goto L15
    }
}
