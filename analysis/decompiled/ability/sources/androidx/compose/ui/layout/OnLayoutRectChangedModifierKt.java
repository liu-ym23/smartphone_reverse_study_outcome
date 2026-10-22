package androidx.compose.ui.layout;

import S7.k;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\f\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "throttleMillis", "debounceMillis", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "LC7/r;", "callback", "onLayoutRectChanged", "(Landroidx/compose/ui/Modifier;JJLS7/k;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "registerOnLayoutRectChanged", "(Landroidx/compose/ui/node/DelegatableNode;JJLS7/k;)Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnLayoutRectChangedModifierKt {
    @Stable
    public static final Modifier onLayoutRectChanged(Modifier modifier, long j5, long j6, k kVar) {
        return modifier.then(new OnLayoutRectChangedElement(j5, j6, kVar));
    }

    public static /* synthetic */ Modifier onLayoutRectChanged$default(Modifier modifier, long j5, long j6, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = 0;
        }
        long j10 = j5;
        if ((i & 2) != 0) {
            j6 = 64;
        }
        return onLayoutRectChanged(modifier, j10, j6, kVar);
    }

    public static final DelegatableNode.RegistrationHandle registerOnLayoutRectChanged(DelegatableNode delegatableNode, long j5, long j6, k kVar) {
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        return LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode).getRectManager().registerOnRectChangedCallback(layoutNodeRequireLayoutNode.getSemanticsId(), j5, j6, delegatableNode, kVar);
    }
}
