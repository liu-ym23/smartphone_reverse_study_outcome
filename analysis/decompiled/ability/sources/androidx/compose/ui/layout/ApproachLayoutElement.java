package androidx.compose.ui.layout;

import S7.k;
import S7.n;
import S7.o;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\u0016*\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R/\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b\f\u0010'R)\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\r8\u0006¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b\u0010\u0010)¨\u0006*"}, d2 = {"Landroidx/compose/ui/layout/ApproachLayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "approachMeasure", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "isMeasurementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isPlacementApproachInProgress", AppAgent.CONSTRUCT, "(LS7/o;LS7/k;LS7/n;)V", "create", "()Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;", "node", "LC7/r;", "update", "(Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "LS7/o;", "getApproachMeasure", "()LS7/o;", "LS7/k;", "()LS7/k;", "LS7/n;", "()LS7/n;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class ApproachLayoutElement extends ModifierNodeElement<ApproachLayoutModifierNodeImpl> {
    private final o approachMeasure;
    private final k isMeasurementApproachInProgress;
    private final n isPlacementApproachInProgress;

    public /* synthetic */ ApproachLayoutElement(o oVar, k kVar, n nVar, int i, e eVar) {
        this(oVar, kVar, (i & 4) != 0 ? LookaheadScopeKt.defaultPlacementApproachInProgress : nVar);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApproachLayoutElement)) {
            return false;
        }
        ApproachLayoutElement approachLayoutElement = (ApproachLayoutElement) other;
        return this.approachMeasure == approachLayoutElement.approachMeasure && this.isMeasurementApproachInProgress == approachLayoutElement.isMeasurementApproachInProgress && this.isPlacementApproachInProgress == approachLayoutElement.isPlacementApproachInProgress;
    }

    public final o getApproachMeasure() {
        return this.approachMeasure;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.isPlacementApproachInProgress.hashCode() + ((this.isMeasurementApproachInProgress.hashCode() + (this.approachMeasure.hashCode() * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("approachLayout");
        inspectorInfo.getProperties().set("approachMeasure", this.approachMeasure);
        inspectorInfo.getProperties().set("isMeasurementApproachInProgress", this.isMeasurementApproachInProgress);
        inspectorInfo.getProperties().set("isPlacementApproachInProgress", this.isPlacementApproachInProgress);
    }

    /* renamed from: isMeasurementApproachInProgress, reason: from getter */
    public final k getIsMeasurementApproachInProgress() {
        return this.isMeasurementApproachInProgress;
    }

    /* renamed from: isPlacementApproachInProgress, reason: from getter */
    public final n getIsPlacementApproachInProgress() {
        return this.isPlacementApproachInProgress;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public ApproachLayoutModifierNodeImpl getNode() {
        return new ApproachLayoutModifierNodeImpl(this.approachMeasure, this.isMeasurementApproachInProgress, this.isPlacementApproachInProgress);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ApproachLayoutModifierNodeImpl node) {
        node.setMeasureBlock(this.approachMeasure);
        node.setMeasurementApproachInProgress(this.isMeasurementApproachInProgress);
        node.setPlacementApproachInProgress(this.isPlacementApproachInProgress);
    }

    public ApproachLayoutElement(o oVar, k kVar, n nVar) {
        this.approachMeasure = oVar;
        this.isMeasurementApproachInProgress = kVar;
        this.isPlacementApproachInProgress = nVar;
    }
}
