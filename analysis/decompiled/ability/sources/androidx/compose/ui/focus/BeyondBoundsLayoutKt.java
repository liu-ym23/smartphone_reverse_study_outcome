package androidx.compose.ui.focus;

import S7.k;
import androidx.compose.foundation.b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a9\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusDirection;", "direction", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "block", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILS7/k;)Ljava/lang/Object;", "searchBeyondBounds", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m3766searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i, k kVar) {
        Modifier.Node nodePop;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int iM5538getBeforehoxUOeE;
        NodeChain nodes;
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                nodePop = null;
                break;
            }
            if ((b.g(layoutNodeRequireLayoutNode) & iM5862constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM5862constructorimpl) != 0) {
                        nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodePop.getKindSet() & iM5862constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                        i6++;
                                        if (i6 == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                                if (i6 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
        if ((focusTargetNode2 != null && kotlin.jvm.internal.k.b(focusTargetNode2.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) || (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3782getUpdhqQ8s())) {
            iM5538getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5536getAbovehoxUOeE();
        } else if (FocusDirection.m3771equalsimpl0(i, companion.m3775getDowndhqQ8s())) {
            iM5538getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5539getBelowhoxUOeE();
        } else if (FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s())) {
            iM5538getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5540getLefthoxUOeE();
        } else if (FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s())) {
            iM5538getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5541getRighthoxUOeE();
        } else if (FocusDirection.m3771equalsimpl0(i, companion.m3779getNextdhqQ8s())) {
            iM5538getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5537getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m3771equalsimpl0(i, companion.m3780getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout");
            }
            iM5538getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5538getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo853layouto7g1Pn8(iM5538getBeforehoxUOeE, kVar);
    }
}
