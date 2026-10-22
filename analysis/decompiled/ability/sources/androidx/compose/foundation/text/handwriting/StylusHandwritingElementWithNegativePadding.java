package androidx.compose.foundation.text.handwriting;

import S7.a;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000b*\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u0012¨\u0006!"}, d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingElementWithNegativePadding;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "Lkotlin/Function0;", "", "onHandwritingSlopExceeded", AppAgent.CONSTRUCT, "(LS7/a;)V", "create", "()Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "node", "LC7/r;", "update", "(Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "component1", "()LS7/a;", "copy", "(LS7/a;)Landroidx/compose/foundation/text/handwriting/StylusHandwritingElementWithNegativePadding;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "LS7/a;", "getOnHandwritingSlopExceeded", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class StylusHandwritingElementWithNegativePadding extends ModifierNodeElement<StylusHandwritingNodeWithNegativePadding> {
    private final a onHandwritingSlopExceeded;

    public StylusHandwritingElementWithNegativePadding(a aVar) {
        this.onHandwritingSlopExceeded = aVar;
    }

    public static /* synthetic */ StylusHandwritingElementWithNegativePadding copy$default(StylusHandwritingElementWithNegativePadding stylusHandwritingElementWithNegativePadding, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = stylusHandwritingElementWithNegativePadding.onHandwritingSlopExceeded;
        }
        return stylusHandwritingElementWithNegativePadding.copy(aVar);
    }

    /* renamed from: component1, reason: from getter */
    public final a getOnHandwritingSlopExceeded() {
        return this.onHandwritingSlopExceeded;
    }

    public final StylusHandwritingElementWithNegativePadding copy(a onHandwritingSlopExceeded) {
        return new StylusHandwritingElementWithNegativePadding(onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StylusHandwritingElementWithNegativePadding) && k.b(this.onHandwritingSlopExceeded, ((StylusHandwritingElementWithNegativePadding) other).onHandwritingSlopExceeded);
    }

    public final a getOnHandwritingSlopExceeded() {
        return this.onHandwritingSlopExceeded;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onHandwritingSlopExceeded.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("stylusHandwriting");
        inspectorInfo.getProperties().set("onHandwritingSlopExceeded", this.onHandwritingSlopExceeded);
    }

    public String toString() {
        return "StylusHandwritingElementWithNegativePadding(onHandwritingSlopExceeded=" + this.onHandwritingSlopExceeded + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public StylusHandwritingNodeWithNegativePadding getNode() {
        return new StylusHandwritingNodeWithNegativePadding(this.onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(StylusHandwritingNodeWithNegativePadding node) {
        node.setOnHandwritingSlopExceeded(this.onHandwritingSlopExceeded);
    }
}
