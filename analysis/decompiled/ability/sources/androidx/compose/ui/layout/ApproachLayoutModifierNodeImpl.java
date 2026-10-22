package androidx.compose.ui.layout;

import S7.k;
import S7.n;
import S7.o;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0010\u001a\u00020\u000b*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0017J#\u0010\u001c\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR:\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\"\u001a\u0004\b\f\u0010#\"\u0004\b$\u0010%R4\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010&\u001a\u0004\b\u0010\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "measureBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "isMeasurementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isPlacementApproachInProgress", AppAgent.CONSTRUCT, "(LS7/o;LS7/k;LS7/n;)V", "lookaheadSize", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "lookaheadCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/ui/layout/LayoutCoordinates;)Z", "measurable", "constraints", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachMeasure", "LS7/o;", "getMeasureBlock", "()LS7/o;", "setMeasureBlock", "(LS7/o;)V", "LS7/k;", "()LS7/k;", "setMeasurementApproachInProgress", "(LS7/k;)V", "LS7/n;", "()LS7/n;", "setPlacementApproachInProgress", "(LS7/n;)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class ApproachLayoutModifierNodeImpl extends Modifier.Node implements ApproachLayoutModifierNode {
    private k isMeasurementApproachInProgress;
    private n isPlacementApproachInProgress;
    private o measureBlock;

    public ApproachLayoutModifierNodeImpl(o oVar, k kVar, n nVar) {
        this.measureBlock = oVar;
        this.isMeasurementApproachInProgress = kVar;
        this.isPlacementApproachInProgress = nVar;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: approachMeasure-3p2s80s */
    public MeasureResult mo101approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j5) {
        return (MeasureResult) this.measureBlock.invoke(approachMeasureScope, measurable, Constraints.m6784boximpl(j5));
    }

    public final o getMeasureBlock() {
        return this.measureBlock;
    }

    /* renamed from: isMeasurementApproachInProgress, reason: from getter */
    public final k getIsMeasurementApproachInProgress() {
        return this.isMeasurementApproachInProgress;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: isMeasurementApproachInProgress-ozmzZPI */
    public boolean mo102isMeasurementApproachInProgressozmzZPI(long lookaheadSize) {
        return ((Boolean) this.isMeasurementApproachInProgress.invoke(IntSize.m7007boximpl(lookaheadSize))).booleanValue();
    }

    /* renamed from: isPlacementApproachInProgress, reason: from getter */
    public final n getIsPlacementApproachInProgress() {
        return this.isPlacementApproachInProgress;
    }

    public final void setMeasureBlock(o oVar) {
        this.measureBlock = oVar;
    }

    public final void setMeasurementApproachInProgress(k kVar) {
        this.isMeasurementApproachInProgress = kVar;
    }

    public final void setPlacementApproachInProgress(n nVar) {
        this.isPlacementApproachInProgress = nVar;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean isPlacementApproachInProgress(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        return ((Boolean) this.isPlacementApproachInProgress.invoke(placementScope, layoutCoordinates)).booleanValue();
    }
}
