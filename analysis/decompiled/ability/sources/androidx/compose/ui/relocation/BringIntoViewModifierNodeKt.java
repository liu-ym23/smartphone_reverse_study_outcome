package androidx.compose.ui.relocation;

import C7.r;
import H7.c;
import S7.a;
import androidx.compose.foundation.b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/DelegatableNode;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "bounds", "LC7/r;", "bringIntoView", "(Landroidx/compose/ui/node/DelegatableNode;LS7/a;LH7/c;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BringIntoViewModifierNodeKt {
    public static final Object bringIntoView(DelegatableNode delegatableNode, final a aVar, c<? super r> cVar) {
        Object obj;
        final LayoutCoordinates layoutCoordinatesRequireLayoutCoordinates;
        Object objBringIntoView;
        NodeChain nodes;
        boolean isAttached = delegatableNode.getNode().getIsAttached();
        r rVar = r.f317a;
        if (!isAttached) {
            return rVar;
        }
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(524288);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        loop0: while (true) {
            obj = null;
            if (layoutNodeRequireLayoutNode == null) {
                break;
            }
            if ((b.g(layoutNodeRequireLayoutNode) & iM5862constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM5862constructorimpl) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof BringIntoViewModifierNode) {
                                obj = nodePop;
                                break loop0;
                            }
                            if ((nodePop.getKindSet() & iM5862constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
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
                                if (i == 1) {
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
        BringIntoViewModifierNode bringIntoViewModifierNode = (BringIntoViewModifierNode) obj;
        return (bringIntoViewModifierNode != null && (objBringIntoView = bringIntoViewModifierNode.bringIntoView((layoutCoordinatesRequireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(delegatableNode)), new a() { // from class: androidx.compose.ui.relocation.BringIntoViewModifierNodeKt.bringIntoView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Rect invoke() {
                Rect rect;
                a aVar2 = aVar;
                if (aVar2 != null && (rect = (Rect) aVar2.invoke()) != null) {
                    return rect;
                }
                LayoutCoordinates layoutCoordinates = layoutCoordinatesRequireLayoutCoordinates;
                if (!layoutCoordinates.isAttached()) {
                    layoutCoordinates = null;
                }
                if (layoutCoordinates != null) {
                    return SizeKt.m3985toRectuvyYCjk(IntSizeKt.m7027toSizeozmzZPI(layoutCoordinates.mo5557getSizeYbymL2g()));
                }
                return null;
            }
        }, cVar)) == CoroutineSingletons.f4909a) ? objBringIntoView : rVar;
    }

    public static /* synthetic */ Object bringIntoView$default(DelegatableNode delegatableNode, a aVar, c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = null;
        }
        return bringIntoView(delegatableNode, aVar, cVar);
    }
}
