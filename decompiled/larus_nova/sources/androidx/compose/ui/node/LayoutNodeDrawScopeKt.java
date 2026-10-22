package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"nextDrawNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutNodeDrawScopeKt {
    public static final /* synthetic */ Modifier.Node access$nextDrawNode(DelegatableNode r100) {
        return nextDrawNode(r100);
    }

    private static final Modifier.Node nextDrawNode(DelegatableNode r100) {
        int r101 = NodeKind.m6556constructorimpl(4);
        int r102 = NodeKind.m6556constructorimpl(2);
        Modifier.Node r103 = r100.getNode().getChild$ui_release();
        if (r103 != null) goto L6;
        return null;
    L6:
        if ((r103.getAggregateChildKindSet$ui_release() & r101) != 0) goto L8;
        return null;
    L8:
        if (r103 == null) goto L16;
        if ((r103.getKindSet$ui_release() & r102) != 0) goto L11;
        if ((r103.getKindSet$ui_release() & r101) != 0) goto L14;
        r103 = r103.getChild$ui_release();
        goto L8
    L14:
        return r103;
    L11:
        return null;
    L16:
        return null;
    }
}
