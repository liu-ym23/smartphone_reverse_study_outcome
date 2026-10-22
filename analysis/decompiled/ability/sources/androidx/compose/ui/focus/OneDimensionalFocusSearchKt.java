package androidx.compose.ui.focus;

import S7.k;
import Y7.f;
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
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a/\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\t\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\n\u001a7\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a7\u0010\u0011\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a'\u0010\u0012\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\n\u001a'\u0010\u0013\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\n\u001a\u0013\u0010\u0014\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001aG\u0010\u001b\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0018\u001a\u00028\u00002\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u0003H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001aG\u0010\u001d\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0018\u001a\u00028\u00002\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u0003H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u001d\u0010\u001c\"\u001a\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\f\n\u0004\b\u001f\u0010 \u0012\u0004\b!\u0010\"\"\u001a\u0010#\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\f\n\u0004\b#\u0010 \u0012\u0004\b$\u0010\"¨\u0006%"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusDirection;", "direction", "Lkotlin/Function1;", "", "onFound", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILS7/k;)Z", "oneDimensionalFocusSearch", "forwardFocusSearch", "(Landroidx/compose/ui/focus/FocusTargetNode;LS7/k;)Z", "backwardFocusSearch", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILS7/k;)Z", "generateAndSearchChildren", "searchChildren-4C6V_qg", "searchChildren", "pickChildForForwardSearch", "pickChildForBackwardSearch", "isRoot", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/collection/MutableVector;", "item", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "forEachItemAfter", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;LS7/k;)V", "forEachItemBefore", "", "InvalidFocusDirection", "Ljava/lang/String;", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final boolean backwardFocusSearch(FocusTargetNode focusTargetNode, k kVar) {
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i = iArr[focusState.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                return pickChildForBackwardSearch(focusTargetNode, kVar);
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!pickChildForBackwardSearch(focusTargetNode, kVar)) {
                if (!(focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? ((Boolean) kVar.invoke(focusTargetNode)).booleanValue() : false)) {
                    return false;
                }
            }
            return true;
        }
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild == null) {
            throw new IllegalStateException(NoActiveChild);
        }
        int i6 = iArr[activeChild.getFocusState().ordinal()];
        if (i6 == 1) {
            return backwardFocusSearch(activeChild, kVar) || m3833generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.INSTANCE.m3780getPreviousdhqQ8s(), kVar) || (activeChild.fetchFocusProperties$ui_release().getCanFocus() && ((Boolean) kVar.invoke(activeChild)).booleanValue());
        }
        if (i6 == 2 || i6 == 3) {
            return m3833generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.INSTANCE.m3780getPreviousdhqQ8s(), kVar);
        }
        if (i6 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException(NoActiveChild);
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t9, k kVar) {
        boolean z10 = false;
        f fVarX = AbstractC1451a.X(0, mutableVector.getSize());
        int i = fVarX.f1569a;
        int i6 = fVarX.b;
        if (i > i6) {
            return;
        }
        while (true) {
            if (z10) {
                kVar.invoke(mutableVector.content[i]);
            }
            if (kotlin.jvm.internal.k.b(mutableVector.content[i], t9)) {
                z10 = true;
            }
            if (i == i6) {
                return;
            } else {
                i++;
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t9, k kVar) {
        boolean z10 = false;
        f fVarX = AbstractC1451a.X(0, mutableVector.getSize());
        int i = fVarX.f1569a;
        int i6 = fVarX.b;
        if (i > i6) {
            return;
        }
        while (true) {
            if (z10) {
                kVar.invoke(mutableVector.content[i6]);
            }
            if (kotlin.jvm.internal.k.b(mutableVector.content[i6], t9)) {
                z10 = true;
            }
            if (i6 == i) {
                return;
            } else {
                i6--;
            }
        }
    }

    private static final boolean forwardFocusSearch(FocusTargetNode focusTargetNode, k kVar) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild != null) {
                return forwardFocusSearch(activeChild, kVar) || m3833generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.INSTANCE.m3779getNextdhqQ8s(), kVar);
            }
            throw new IllegalStateException(NoActiveChild);
        }
        if (i == 2 || i == 3) {
            return pickChildForForwardSearch(focusTargetNode, kVar);
        }
        if (i == 4) {
            return focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? ((Boolean) kVar.invoke(focusTargetNode)).booleanValue() : pickChildForForwardSearch(focusTargetNode, kVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m3833generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int i, final k kVar) {
        if (m3835searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, i, kVar)) {
            return true;
        }
        final FocusTargetNode activeFocusTargetNode = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().getActiveFocusTargetNode();
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m3766searchBeyondBoundsOMvw8(focusTargetNode, i, new k() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                if (activeFocusTargetNode != DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().getActiveFocusTargetNode()) {
                    return Boolean.TRUE;
                }
                boolean zM3835searchChildren4C6V_qg = OneDimensionalFocusSearchKt.m3835searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, i, kVar);
                Boolean boolValueOf = Boolean.valueOf(zM3835searchChildren4C6V_qg);
                if (zM3835searchChildren4C6V_qg || !beyondBoundsScope.getHasMoreContent()) {
                    return boolValueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static /* synthetic */ void getInvalidFocusDirection$annotations() {
    }

    private static /* synthetic */ void getNoActiveChild$annotations() {
    }

    private static final boolean isRoot(FocusTargetNode focusTargetNode) {
        Modifier.Node node;
        NodeChain nodes;
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            node = null;
            if (layoutNodeRequireLayoutNode == null) {
                break;
            }
            if ((b.g(layoutNodeRequireLayoutNode) & iM5862constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM5862constructorimpl) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                node = nodePop;
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
        return node == null;
    }

    /* renamed from: oneDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m3834oneDimensionalFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i, k kVar) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3779getNextdhqQ8s())) {
            return forwardFocusSearch(focusTargetNode, kVar);
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3780getPreviousdhqQ8s())) {
            return backwardFocusSearch(focusTargetNode, kVar);
        }
        throw new IllegalStateException(InvalidFocusDirection);
    }

    private static final boolean pickChildForBackwardSearch(FocusTargetNode focusTargetNode, k kVar) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node nodePop = (Modifier.Node) b.l(mutableVector2, 1);
            if ((nodePop.getAggregateChildKindSet() & iM5862constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, nodePop, false);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & iM5862constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) nodePop);
                            } else if ((nodePop.getKindSet() & iM5862constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector3.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector3.add(delegate);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        int size = mutableVector.getSize() - 1;
        Object[] objArr = mutableVector.content;
        if (size < objArr.length) {
            while (size >= 0) {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[size];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) && backwardFocusSearch(focusTargetNode2, kVar)) {
                    return true;
                }
                size--;
            }
        }
        return false;
    }

    private static final boolean pickChildForForwardSearch(FocusTargetNode focusTargetNode, k kVar) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node nodePop = (Modifier.Node) b.l(mutableVector2, 1);
            if ((nodePop.getAggregateChildKindSet() & iM5862constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, nodePop, false);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & iM5862constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) nodePop);
                            } else if ((nodePop.getKindSet() & iM5862constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector3.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector3.add(delegate);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        Object[] objArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i6 = 0; i6 < size; i6++) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) objArr[i6];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) && forwardFocusSearch(focusTargetNode2, kVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m3835searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, k kVar) {
        if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.");
        }
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node nodePop = (Modifier.Node) b.l(mutableVector2, 1);
            if ((nodePop.getAggregateChildKindSet() & iM5862constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, nodePop, false);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & iM5862constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) nodePop);
                            } else if ((nodePop.getKindSet() & iM5862constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                        i6++;
                                        if (i6 == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector3.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector3.add(delegate);
                                        }
                                    }
                                }
                                if (i6 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3779getNextdhqQ8s())) {
            f fVarX = AbstractC1451a.X(0, mutableVector.getSize());
            int i10 = fVarX.f1569a;
            int i11 = fVarX.b;
            if (i10 <= i11) {
                boolean z10 = false;
                while (true) {
                    if (z10) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) mutableVector.content[i10];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode3) && forwardFocusSearch(focusTargetNode3, kVar)) {
                            return true;
                        }
                    }
                    if (kotlin.jvm.internal.k.b(mutableVector.content[i10], focusTargetNode2)) {
                        z10 = true;
                    }
                    if (i10 == i11) {
                        break;
                    }
                    i10++;
                }
            }
        } else {
            if (!FocusDirection.m3771equalsimpl0(i, companion.m3780getPreviousdhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            f fVarX2 = AbstractC1451a.X(0, mutableVector.getSize());
            int i12 = fVarX2.f1569a;
            int i13 = fVarX2.b;
            if (i12 <= i13) {
                boolean z11 = false;
                while (true) {
                    if (z11) {
                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) mutableVector.content[i13];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode4) && backwardFocusSearch(focusTargetNode4, kVar)) {
                            return true;
                        }
                    }
                    if (kotlin.jvm.internal.k.b(mutableVector.content[i13], focusTargetNode2)) {
                        z11 = true;
                    }
                    if (i13 == i12) {
                        break;
                    }
                    i13--;
                }
            }
        }
        if (FocusDirection.m3771equalsimpl0(i, FocusDirection.INSTANCE.m3779getNextdhqQ8s()) || !focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() || isRoot(focusTargetNode)) {
            return false;
        }
        return ((Boolean) kVar.invoke(focusTargetNode)).booleanValue();
    }
}
