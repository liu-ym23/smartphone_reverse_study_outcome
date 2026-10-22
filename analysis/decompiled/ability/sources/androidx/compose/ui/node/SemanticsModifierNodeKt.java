package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\"\u0018\u0010\u0006\u001a\u00020\u0005*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/SemanticsModifierNode;", "LC7/r;", "invalidateSemantics", "(Landroidx/compose/ui/node/SemanticsModifierNode;)V", "Landroidx/compose/ui/Modifier$Node;", "", "useMinimumTouchTarget", "Landroidx/compose/ui/geometry/Rect;", "touchBoundsInRoot", "(Landroidx/compose/ui/Modifier$Node;Z)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUseMinimumTouchTarget", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Z", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsModifierNodeKt {
    public static final boolean getUseMinimumTouchTarget(SemanticsConfiguration semanticsConfiguration) {
        return SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        DelegatableNodeKt.requireLayoutNode(semanticsModifierNode).invalidateSemantics$ui_release();
    }

    public static final Rect touchBoundsInRoot(Modifier.Node node, boolean z10) {
        return !node.getNode().getIsAttached() ? Rect.INSTANCE.getZero() : !z10 ? LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m5702requireCoordinator64DMado(node, NodeKind.m5862constructorimpl(8))) : DelegatableNodeKt.m5702requireCoordinator64DMado(node, NodeKind.m5862constructorimpl(8)).touchBoundsInRoot();
    }
}
