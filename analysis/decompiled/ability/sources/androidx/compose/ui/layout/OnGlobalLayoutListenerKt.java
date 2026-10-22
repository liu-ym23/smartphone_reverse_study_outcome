package androidx.compose.ui.layout;

import S7.k;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/node/DelegatableNode;", "", "throttleMillis", "debounceMillis", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "LC7/r;", "callback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "registerOnGlobalLayoutListener", "(Landroidx/compose/ui/node/DelegatableNode;JJLS7/k;)Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnGlobalLayoutListenerKt {
    public static final DelegatableNode.RegistrationHandle registerOnGlobalLayoutListener(DelegatableNode delegatableNode, long j5, long j6, k kVar) {
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        return LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode).getRectManager().registerOnGlobalLayoutCallback(layoutNodeRequireLayoutNode.getSemanticsId(), j5, j6, delegatableNode.getNode(), kVar);
    }
}
