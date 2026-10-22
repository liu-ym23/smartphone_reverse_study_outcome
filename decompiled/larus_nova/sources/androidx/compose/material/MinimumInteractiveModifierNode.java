package androidx.compose.material;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/MinimumInteractiveModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MinimumInteractiveModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public static final int $stable = 0;

    static {
        $stable = Modifier.Node.$stable;
    }

    public static /* synthetic */ Unit a(int r100, Placeable r101, int r102, Placeable.PlacementScope r103) {
        return measure_3p2s80s$lambda$0(r100, r101, r102, r103);
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

    public MinimumInteractiveModifierNode() {
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r110, Measurable r111, long r112) {
        if (isAttached() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        long r101 = InteractiveComponentSizeKt.access$getMinimumInteractiveComponentSize$p();
        final Placeable r113 = r111.mo6256measureBRTryo0(r112);
        if (r100 == false) goto L11;
        int r114 = Math.max(r113.getWidth(), r110.mo365roundToPx0680j_4(DpSize.m7642getWidthD9Ej5fM(r101)));
    L12:
        final int r102 = r114;
        if (r100 == false) goto L15;
        int r115 = Math.max(r113.getHeight(), r110.mo365roundToPx0680j_4(DpSize.m7640getHeightD9Ej5fM(r101)));
    L16:
        final int r103 = r115;
        return MeasureScope.CC.layout$default(r110, r102, r103, null, new d6(r102, r113, r103), 4, null);
    L15:
        r115 = r113.getHeight();
        goto L16
    L11:
        r114 = r113.getWidth();
        goto L12
    L5:
        if (((Boolean) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement())).booleanValue() == false) goto L7;
        r100 = true;
        goto L8
    }

    private static final Unit measure_3p2s80s$lambda$0(int r100, Placeable r101, int r110, Placeable.PlacementScope r111) {
        Placeable.PlacementScope.place$default(r111, r101, MathKt.roundToInt((r100 - r101.getWidth()) / 2.0f), MathKt.roundToInt((r110 - r101.getHeight()) / 2.0f), 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
