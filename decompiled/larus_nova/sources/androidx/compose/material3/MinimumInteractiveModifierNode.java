package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/MinimumInteractiveModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "()V", "alignmentLinesCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "updateAlignmentLines", "", "sizePx", "placeable", "Landroidx/compose/ui/layout/Placeable;", "getAlignmentLinesCache", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MinimumInteractiveModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Map<AlignmentLine, Integer> alignmentLinesCache;

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

    private final Map<AlignmentLine, Integer> getAlignmentLinesCache() {
        Map<AlignmentLine, Integer> r100 = this.alignmentLinesCache;
        if (r100 != null) goto L6;
        LinkedHashMap r101 = new LinkedHashMap(2);
        this.alignmentLinesCache = r101;
        return r101;
    L6:
        return r100;
    }

    public MinimumInteractiveModifierNode() {
    }

    private final void updateAlignmentLines(int r100, Placeable r101) {
        Map<AlignmentLine, Integer> r102 = getAlignmentLinesCache();
        r102.put(InteractiveComponentSizeKt.getMinimumInteractiveLeftAlignmentLine(), Integer.valueOf(RangesKt.coerceAtLeast(Math.round((r100 - r101.getWidth()) / 2.0f), 0)));
        r102.put(InteractiveComponentSizeKt.getMinimumInteractiveTopAlignmentLine(), Integer.valueOf(RangesKt.coerceAtLeast(Math.round((r100 - r101.getHeight()) / 2.0f), 0)));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r100, Measurable r101, long r102) {
        int r103 = 0;
        float r104 = 0;
        float r105 = Dp.m7544constructorimpl(RangesKt.coerceAtLeast(((Dp) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).m7558unboximpl(), Dp.m7544constructorimpl(r104)));
        final Placeable r106 = r101.mo6256measureBRTryo0(r102);
        if (isAttached() == true) goto L5;
    L9:
        boolean r107 = false;
    L11:
        if ((true ^ Float.isNaN(r105)) == false) goto L13;
        r103 = r100.mo365roundToPx0680j_4(r105);
    L13:
        if (r107 == false) goto L15;
        final int r108 = Math.max(r106.getWidth(), r103);
    L16:
        if (r107 == false) goto L18;
        final int r109 = Math.max(r106.getHeight(), r103);
    L19:
        if (r107 == false) goto L21;
        updateAlignmentLines(r103, r106);
    L21:
        Map<AlignmentLine, Integer> r110 = this.alignmentLinesCache;
        if (r110 != null) goto L25;
        r110 = MapsKt.emptyMap();
    L25:
        return r100.layout(r108, r109, r110, new wd(r108, r106, r109));
    L18:
        r109 = r106.getHeight();
        goto L19
    L15:
        r108 = r106.getWidth();
        goto L16
    L5:
        if ((!Float.isNaN(r105)) == false) goto L9;
        if (Dp.m7543compareTo0680j_4(r105, Dp.m7544constructorimpl(r104)) <= 0) goto L9;
        r107 = true;
        goto L11
    }

    private static final Unit measure_3p2s80s$lambda$0(int r100, Placeable r101, int r110, Placeable.PlacementScope r111) {
        Placeable.PlacementScope.place$default(r111, r101, MathKt.roundToInt((r100 - r101.getWidth()) / 2.0f), MathKt.roundToInt((r110 - r101.getHeight()) / 2.0f), 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
