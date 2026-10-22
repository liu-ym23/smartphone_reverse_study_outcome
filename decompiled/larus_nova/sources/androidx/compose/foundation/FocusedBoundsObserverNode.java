package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u001d\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005R(\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsObserverNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "onPositioned", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnPositioned", "()Lkotlin/jvm/functions/Function1;", "setOnPositioned", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "onFocusBoundsChanged", "focusedBounds", "TraverseKey", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusedBoundsObserverNode extends Modifier.Node implements TraversableNode {
    public static final int $stable = 0;
    public static final TraverseKey TraverseKey = null;
    private Function1<? super LayoutCoordinates, Unit> onPositioned;
    private final Object traverseKey;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsObserverNode$TraverseKey;", "", "<init>", "()V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TraverseKey {
        private TraverseKey() {
        }

        public /* synthetic */ TraverseKey(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        TraverseKey = new TraverseKey(null);
        $stable = 8;
    }

    public final Function1<LayoutCoordinates, Unit> getOnPositioned() {
        return this.onPositioned;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public FocusedBoundsObserverNode(Function1<? super LayoutCoordinates, Unit> r100) {
        this.onPositioned = r100;
        this.traverseKey = TraverseKey;
    }

    public final void onFocusBoundsChanged(LayoutCoordinates r100) {
        this.onPositioned.invoke(r100);
        FocusedBoundsObserverNode r101 = (FocusedBoundsObserverNode) TraversableNodeKt.findNearestAncestor(this);
        if (r101 == null) goto L6;
        r101.onFocusBoundsChanged(r100);
        return;
    }

    public final void setOnPositioned(Function1<? super LayoutCoordinates, Unit> r100) {
        this.onPositioned = r100;
    }
}
