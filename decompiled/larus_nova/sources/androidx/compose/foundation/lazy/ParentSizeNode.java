package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
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
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/lazy/ParentSizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fraction", "", "widthState", "Landroidx/compose/runtime/State;", "", "heightState", "<init>", "(FLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getFraction", "()F", "setFraction", "(F)V", "getWidthState", "()Landroidx/compose/runtime/State;", "setWidthState", "(Landroidx/compose/runtime/State;)V", "getHeightState", "setHeightState", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ParentSizeNode extends Modifier.Node implements LayoutModifierNode {
    private float fraction;
    private State<Integer> heightState;
    private State<Integer> widthState;

    public static /* synthetic */ Unit a(Placeable r100, Placeable.PlacementScope r101) {
        return measure_3p2s80s$lambda$2(r100, r101);
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

    public final float getFraction() {
        return this.fraction;
    }

    public final State<Integer> getHeightState() {
        return this.heightState;
    }

    public final State<Integer> getWidthState() {
        return this.widthState;
    }

    public final void setFraction(float r100) {
        this.fraction = r100;
    }

    public final void setHeightState(State<Integer> r100) {
        this.heightState = r100;
    }

    public final void setWidthState(State<Integer> r100) {
        this.widthState = r100;
    }

    private static final Unit measure_3p2s80s$lambda$2(Placeable r100, Placeable.PlacementScope r101) {
        Placeable.PlacementScope.place$default(r101, r100, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    public ParentSizeNode(float r100, State<Integer> r101, State<Integer> r102) {
        this.fraction = r100;
        this.widthState = r101;
        this.heightState = r102;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r100, Measurable r101, long r110) {
        State<Integer> r102 = this.widthState;
        if (r102 != null) goto L5;
    L7:
        int r103 = Integer.MAX_VALUE;
    L8:
        State<Integer> r104 = this.heightState;
        if (r104 != null) goto L11;
    L13:
        int r105 = Integer.MAX_VALUE;
    L14:
        if (r103 == Integer.MAX_VALUE) goto L16;
        int r106 = r103;
    L17:
        if (r105 == Integer.MAX_VALUE) goto L19;
        int r107 = r105;
    L20:
        if (r103 != Integer.MAX_VALUE) goto L23;
        r103 = Constraints.m7487getMaxWidthimpl(r110);
    L23:
        if (r105 != Integer.MAX_VALUE) goto L26;
        r105 = Constraints.m7486getMaxHeightimpl(r110);
    L26:
        final Placeable r108 = r101.mo6256measureBRTryo0(ConstraintsKt.Constraints(r106, r103, r107, r105));
        return MeasureScope.CC.layout$default(r100, r108.getWidth(), r108.getHeight(), null, new f0(r108), 4, null);
    L19:
        r107 = Constraints.m7488getMinHeightimpl(r110);
        goto L20
    L16:
        r106 = Constraints.m7489getMinWidthimpl(r110);
        goto L17
    L11:
        if (r104.getValue().intValue() == Integer.MAX_VALUE) goto L13;
        r105 = Math.round(r104.getValue().floatValue() * this.fraction);
        goto L14
    L5:
        if (r102.getValue().intValue() == Integer.MAX_VALUE) goto L7;
        r103 = Math.round(r102.getValue().floatValue() * this.fraction);
        goto L8
    }

    public /* synthetic */ ParentSizeNode(float r100, State r101, State r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
