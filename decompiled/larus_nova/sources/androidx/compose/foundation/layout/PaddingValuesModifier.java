package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public static /* synthetic */ Unit a(Placeable r100, int r101, int r102, Placeable.PlacementScope r103) {
        return measure_3p2s80s$lambda$1(r100, r101, r102, r103);
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

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public PaddingValuesModifier(PaddingValues r100) {
        this.paddingValues = r100;
    }

    public final void setPaddingValues(PaddingValues r100) {
        this.paddingValues = r100;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r110, Measurable r111, long r112) {
        float r100 = this.paddingValues.mo681calculateLeftPaddingu2uoSUM(r110.getLayoutDirection());
        float r101 = this.paddingValues.mo683calculateTopPaddingD9Ej5fM();
        float r102 = this.paddingValues.mo682calculateRightPaddingu2uoSUM(r110.getLayoutDirection());
        float r103 = this.paddingValues.mo680calculateBottomPaddingD9Ej5fM();
        boolean r104 = false;
        float r105 = 0;
        if (Dp.m7543compareTo0680j_4(r100, Dp.m7544constructorimpl(r105)) < 0) goto L5;
        boolean r113 = true;
    L7:
        if (Dp.m7543compareTo0680j_4(r101, Dp.m7544constructorimpl(r105)) < 0) goto L9;
        boolean r114 = true;
    L10:
        boolean r115 = r113 & r114;
        if (Dp.m7543compareTo0680j_4(r102, Dp.m7544constructorimpl(r105)) < 0) goto L13;
        boolean r116 = true;
    L14:
        boolean r117 = r115 & r116;
        if (Dp.m7543compareTo0680j_4(r103, Dp.m7544constructorimpl(r105)) < 0) goto L18;
        r104 = true;
    L18:
        if ((r104 & r117) == true) goto L20;
        InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
    L20:
        final int r106 = r110.mo365roundToPx0680j_4(r100);
        int r107 = r110.mo365roundToPx0680j_4(r102) + r106;
        final int r108 = r110.mo365roundToPx0680j_4(r101);
        int r109 = r110.mo365roundToPx0680j_4(r103) + r108;
        final Placeable r118 = r111.mo6256measureBRTryo0(ConstraintsKt.m7506offsetNN6EwU(r112, -r107, -r109));
        return MeasureScope.CC.layout$default(r110, ConstraintsKt.m7504constrainWidthK40F9xA(r112, r118.getWidth() + r107), ConstraintsKt.m7503constrainHeightK40F9xA(r112, r118.getHeight() + r109), null, new t1(r118, r106, r108), 4, null);
    L13:
        r116 = false;
        goto L14
    L9:
        r114 = false;
        goto L10
    L5:
        r113 = false;
        goto L7
    }

    private static final Unit measure_3p2s80s$lambda$1(Placeable r100, int r101, int r102, Placeable.PlacementScope r110) {
        Placeable.PlacementScope.place$default(r110, r100, r101, r102, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
