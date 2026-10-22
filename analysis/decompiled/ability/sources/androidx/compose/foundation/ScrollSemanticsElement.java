package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u0010*\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0019J\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019JD\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b+\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b/\u0010\u001bR\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b\t\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b\n\u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/foundation/ScrollSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "Landroidx/compose/foundation/ScrollState;", "state", "", "reverseScrolling", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "isScrollable", "isVertical", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)V", "create", "()Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "node", "LC7/r;", "update", "(Landroidx/compose/foundation/ScrollSemanticsModifierNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "component1", "()Landroidx/compose/foundation/ScrollState;", "component2", "()Z", "component3", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "component4", "component5", "copy", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)Landroidx/compose/foundation/ScrollSemanticsElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/ScrollState;", "getState", "Z", "getReverseScrolling", "Landroidx/compose/foundation/gestures/FlingBehavior;", "getFlingBehavior", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class ScrollSemanticsElement extends ModifierNodeElement<ScrollSemanticsModifierNode> {
    private final FlingBehavior flingBehavior;
    private final boolean isScrollable;
    private final boolean isVertical;
    private final boolean reverseScrolling;
    private final ScrollState state;

    public ScrollSemanticsElement(ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, boolean z12) {
        this.state = scrollState;
        this.reverseScrolling = z10;
        this.flingBehavior = flingBehavior;
        this.isScrollable = z11;
        this.isVertical = z12;
    }

    public static /* synthetic */ ScrollSemanticsElement copy$default(ScrollSemanticsElement scrollSemanticsElement, ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, boolean z12, int i, Object obj) {
        if ((i & 1) != 0) {
            scrollState = scrollSemanticsElement.state;
        }
        if ((i & 2) != 0) {
            z10 = scrollSemanticsElement.reverseScrolling;
        }
        if ((i & 4) != 0) {
            flingBehavior = scrollSemanticsElement.flingBehavior;
        }
        if ((i & 8) != 0) {
            z11 = scrollSemanticsElement.isScrollable;
        }
        if ((i & 16) != 0) {
            z12 = scrollSemanticsElement.isVertical;
        }
        boolean z13 = z12;
        FlingBehavior flingBehavior2 = flingBehavior;
        return scrollSemanticsElement.copy(scrollState, z10, flingBehavior2, z11, z13);
    }

    /* renamed from: component1, reason: from getter */
    public final ScrollState getState() {
        return this.state;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    /* renamed from: component3, reason: from getter */
    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsScrollable() {
        return this.isScrollable;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    public final ScrollSemanticsElement copy(ScrollState state, boolean reverseScrolling, FlingBehavior flingBehavior, boolean isScrollable, boolean isVertical) {
        return new ScrollSemanticsElement(state, reverseScrolling, flingBehavior, isScrollable, isVertical);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollSemanticsElement)) {
            return false;
        }
        ScrollSemanticsElement scrollSemanticsElement = (ScrollSemanticsElement) other;
        return k.b(this.state, scrollSemanticsElement.state) && this.reverseScrolling == scrollSemanticsElement.reverseScrolling && k.b(this.flingBehavior, scrollSemanticsElement.flingBehavior) && this.isScrollable == scrollSemanticsElement.isScrollable && this.isVertical == scrollSemanticsElement.isVertical;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final ScrollState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(this.state.hashCode() * 31, 31, this.reverseScrolling);
        FlingBehavior flingBehavior = this.flingBehavior;
        return Boolean.hashCode(this.isVertical) + androidx.appfunctions.metadata.a.d((iD + (flingBehavior == null ? 0 : flingBehavior.hashCode())) * 31, 31, this.isScrollable);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public final boolean isScrollable() {
        return this.isScrollable;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ScrollSemanticsElement(state=");
        sb.append(this.state);
        sb.append(", reverseScrolling=");
        sb.append(this.reverseScrolling);
        sb.append(", flingBehavior=");
        sb.append(this.flingBehavior);
        sb.append(", isScrollable=");
        sb.append(this.isScrollable);
        sb.append(", isVertical=");
        return androidx.appfunctions.metadata.a.r(sb, this.isVertical, ')');
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public ScrollSemanticsModifierNode getNode() {
        return new ScrollSemanticsModifierNode(this.state, this.reverseScrolling, this.flingBehavior, this.isScrollable, this.isVertical);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ScrollSemanticsModifierNode node) {
        node.setState(this.state);
        node.setReverseScrolling(this.reverseScrolling);
        node.setFlingBehavior(this.flingBehavior);
        node.setScrollable(this.isScrollable);
        node.setVertical(this.isVertical);
    }
}
