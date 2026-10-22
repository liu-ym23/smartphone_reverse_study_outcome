package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\b\u0010\n\u001a\u00020\u0007H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/OverscrollModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "overscrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;)V", "onAttach", "", "onDetach", "update", "attachIfNeeded", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OverscrollModifierNode extends DelegatingNode {
    private DelegatableNode overscrollNode;

    private final void attachIfNeeded() {
        DelegatableNode r100 = this.overscrollNode;
        boolean r101 = false;
        if (r100 == null) goto L9;
        Modifier.Node r102 = r100.getNode();
        if (r102 == null) goto L9;
        if (r102.isAttached() == true) goto L9;
        r101 = true;
    L9:
        if (r101 == false) goto L11;
        DelegatableNode r103 = this.overscrollNode;
        Intrinsics.checkNotNull(r103);
        DelegatableNode r104 = delegate(r103);
    L12:
        this.overscrollNode = r104;
        return;
    L11:
        r104 = null;
        goto L12
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNode r100 = this.overscrollNode;
        if (r100 == null) goto L6;
        undelegate(r100);
        return;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        attachIfNeeded();
    }

    public OverscrollModifierNode(DelegatableNode r100) {
        this.overscrollNode = r100;
    }

    public final void update(DelegatableNode r100) {
        DelegatableNode r101 = this.overscrollNode;
        if (r101 == null) goto L5;
        undelegate(r101);
    L5:
        this.overscrollNode = r100;
        attachIfNeeded();
    }
}
