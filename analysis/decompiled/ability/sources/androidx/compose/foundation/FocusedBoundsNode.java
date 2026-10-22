package androidx.compose.foundation;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Landroidx/compose/foundation/FocusedBoundsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "notifyObserverWhenAttached", "", "focused", "setFocus", "(Z)V", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "onGloballyPositioned", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "isFocused", "Z", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/foundation/FocusedBoundsObserverNode;", "getObserver", "()Landroidx/compose/foundation/FocusedBoundsObserverNode;", "observer", "", "getTraverseKey", "()Ljava/lang/Object;", "traverseKey", "TraverseKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusedBoundsNode extends Modifier.Node implements TraversableNode, GlobalPositionAwareModifierNode {
    private boolean isFocused;
    private LayoutCoordinates layoutCoordinates;
    private final boolean shouldAutoInvalidate;

    /* renamed from: TraverseKey, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsNode$TraverseKey;", "", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.FocusedBoundsNode$TraverseKey, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    private final FocusedBoundsObserverNode getObserver() {
        if (getIsAttached()) {
            TraversableNode traversableNodeFindNearestAncestor = TraversableNodeKt.findNearestAncestor(this, FocusedBoundsObserverNode.INSTANCE);
            if (traversableNodeFindNearestAncestor instanceof FocusedBoundsObserverNode) {
                return (FocusedBoundsObserverNode) traversableNodeFindNearestAncestor;
            }
        }
        return null;
    }

    private final void notifyObserverWhenAttached() {
        FocusedBoundsObserverNode observer;
        LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
        if (layoutCoordinates != null) {
            k.c(layoutCoordinates);
            if (!layoutCoordinates.isAttached() || (observer = getObserver()) == null) {
                return;
            }
            observer.onFocusBoundsChanged(this.layoutCoordinates);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return INSTANCE;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.layoutCoordinates = coordinates;
        if (this.isFocused) {
            if (coordinates.isAttached()) {
                notifyObserverWhenAttached();
                return;
            }
            FocusedBoundsObserverNode observer = getObserver();
            if (observer != null) {
                observer.onFocusBoundsChanged(null);
            }
        }
    }

    public final void setFocus(boolean focused) {
        if (focused == this.isFocused) {
            return;
        }
        if (focused) {
            notifyObserverWhenAttached();
        } else {
            FocusedBoundsObserverNode observer = getObserver();
            if (observer != null) {
                observer.onFocusBoundsChanged(null);
            }
        }
        this.isFocused = focused;
    }
}
