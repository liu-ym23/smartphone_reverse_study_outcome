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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getUnbounded", "()Z", "setUnbounded", "(Z)V", "getAlignmentCallback", "()Lkotlin/jvm/functions/Function2;", "setAlignmentCallback", "(Lkotlin/jvm/functions/Function2;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public static /* synthetic */ Unit a(WrapContentNode r100, int r101, Placeable r102, int r103, MeasureScope r104, Placeable.PlacementScope r105) {
        return measure_3p2s80s$lambda$0(r100, r101, r102, r103, r104, r105);
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

    public final Function2<IntSize, LayoutDirection, IntOffset> getAlignmentCallback() {
        return this.alignmentCallback;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final boolean getUnbounded() {
        return this.unbounded;
    }

    public final void setAlignmentCallback(Function2<? super IntSize, ? super LayoutDirection, IntOffset> r100) {
        this.alignmentCallback = r100;
    }

    public final void setDirection(Direction r100) {
        this.direction = r100;
    }

    public final void setUnbounded(boolean r100) {
        this.unbounded = r100;
    }

    public WrapContentNode(Direction r100, boolean r101, Function2<? super IntSize, ? super LayoutDirection, IntOffset> r102) {
        this.direction = r100;
        this.unbounded = r101;
        this.alignmentCallback = r102;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(final MeasureScope r110, Measurable r111, long r112) {
        Direction r100 = this.direction;
        Direction r101 = Direction.Vertical;
        int r102 = 0;
        if (r100 == r101) goto L5;
        int r103 = 0;
    L6:
        Direction r104 = this.direction;
        Direction r105 = Direction.Horizontal;
        if (r104 != r105) goto L10;
        r102 = Constraints.m7488getMinHeightimpl(r112);
    L10:
        int r106 = Integer.MAX_VALUE;
        if (this.direction != r101) goto L13;
    L15:
        int r107 = Constraints.m7487getMaxWidthimpl(r112);
    L17:
        if (this.direction != r105) goto L19;
    L21:
        r106 = Constraints.m7486getMaxHeightimpl(r112);
    L22:
        final Placeable r108 = r111.mo6256measureBRTryo0(ConstraintsKt.Constraints(r103, r107, r102, r106));
        final int r109 = RangesKt.coerceIn(r108.getWidth(), Constraints.m7489getMinWidthimpl(r112), Constraints.m7487getMaxWidthimpl(r112));
        final int r113 = RangesKt.coerceIn(r108.getHeight(), Constraints.m7488getMinHeightimpl(r112), Constraints.m7486getMaxHeightimpl(r112));
        return MeasureScope.CC.layout$default(r110, r109, r113, null, new v2(this, r109, r108, r113, r110), 4, null);
    L19:
        if (this.unbounded == false) goto L21;
    L13:
        if (this.unbounded == false) goto L15;
        r107 = Integer.MAX_VALUE;
        goto L17
    L5:
        r103 = Constraints.m7489getMinWidthimpl(r112);
        goto L6
    }

    private static final Unit measure_3p2s80s$lambda$0(WrapContentNode r100, int r101, Placeable r102, int r110, MeasureScope r111, Placeable.PlacementScope r112) {
        Function2<? super IntSize, ? super LayoutDirection, IntOffset> r103 = r100.alignmentCallback;
        int r104 = r101 - r102.getWidth();
        int r113 = r110 - r102.getHeight();
        Placeable.PlacementScope.m6327place70tqf50$default(r112, r102, r103.invoke(IntSize.m7711boximpl(IntSize.m7714constructorimpl((((long) r104) << 32) | (((long) r113) & BodyPartID.bodyIdMax))), r111.getLayoutDirection()).m7685unboximpl(), 0.0f, 2, null);
        return Unit.INSTANCE;
    }
}
