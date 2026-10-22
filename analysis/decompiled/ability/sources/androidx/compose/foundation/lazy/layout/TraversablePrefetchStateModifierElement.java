package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\f*\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateNode;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchState", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "component1", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "create", "()Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateNode;", "node", "LC7/r;", "update", "(Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "copy", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateModifierElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class TraversablePrefetchStateModifierElement extends ModifierNodeElement<TraversablePrefetchStateNode> {
    private final LazyLayoutPrefetchState prefetchState;

    public TraversablePrefetchStateModifierElement(LazyLayoutPrefetchState lazyLayoutPrefetchState) {
        this.prefetchState = lazyLayoutPrefetchState;
    }

    /* renamed from: component1, reason: from getter */
    private final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    public static /* synthetic */ TraversablePrefetchStateModifierElement copy$default(TraversablePrefetchStateModifierElement traversablePrefetchStateModifierElement, LazyLayoutPrefetchState lazyLayoutPrefetchState, int i, Object obj) {
        if ((i & 1) != 0) {
            lazyLayoutPrefetchState = traversablePrefetchStateModifierElement.prefetchState;
        }
        return traversablePrefetchStateModifierElement.copy(lazyLayoutPrefetchState);
    }

    public final TraversablePrefetchStateModifierElement copy(LazyLayoutPrefetchState prefetchState) {
        return new TraversablePrefetchStateModifierElement(prefetchState);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TraversablePrefetchStateModifierElement) && k.b(this.prefetchState, ((TraversablePrefetchStateModifierElement) other).prefetchState);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.prefetchState.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("traversablePrefetchState");
        inspectorInfo.setValue(this.prefetchState);
    }

    public String toString() {
        return "TraversablePrefetchStateModifierElement(prefetchState=" + this.prefetchState + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public TraversablePrefetchStateNode create() {
        return new TraversablePrefetchStateNode(this.prefetchState);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(TraversablePrefetchStateNode node) {
        node.setPrefetchState(this.prefetchState);
    }
}
