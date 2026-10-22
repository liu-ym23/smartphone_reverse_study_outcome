package androidx.compose.ui.focus;

import S7.k;
import androidx.compose.foundation.b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a;\u0010\n\u001a\u0004\u0018\u00010\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\r\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u0011\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0013\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0010\u001a!\u0010\u0018\u001a\u00020\u0017*\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a+\u0010\u001d\u001a\u0004\u0018\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00000\u00152\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a/\u0010#\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b!\u0010\"\u001a/\u0010(\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b'\u0010\"\u001a\u0013\u0010)\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010+\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010*\u001a\u0013\u0010,\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b,\u0010-\"\u0014\u0010/\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100\"\u0014\u00101\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00100¨\u00062"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusDirection;", "direction", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "Lkotlin/Function1;", "", "onFound", "twoDimensionalFocusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/geometry/Rect;LS7/k;)Ljava/lang/Boolean;", "twoDimensionalFocusSearch", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILS7/k;)Z", "findChildCorrespondingToFocusEnter", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/geometry/Rect;ILS7/k;)Z", "generateAndSearchChildren", "searchChildren-4C6V_qg", "searchChildren", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/runtime/collection/MutableVector;", "accessibleChildren", "LC7/r;", "collectAccessibleChildren", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/runtime/collection/MutableVector;)V", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetNode;", "findBestCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", AgentBusWakeContract.EXTRA_SOURCE, "rect1", "rect2", "beamBeats-I7lrPNg", "beamBeats", "topLeft", "(Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "bottomRight", "activeNode", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "", "InvalidFocusDirection", "Ljava/lang/String;", "NoActiveChild", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
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

    private static final FocusTargetNode activeNode(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("Searching for active node in inactive hierarchy");
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            return focusTargetNodeFindActiveFocusNode;
        }
        throw new IllegalStateException(NoActiveChild);
    }

    /* renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    private static final boolean m3839beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i, rect)) {
            return false;
        }
        if (!beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i, rect)) {
            return true;
        }
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        return FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s()) || FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s()) || beamBeats_I7lrPNg$majorAxisDistance$6(rect2, i, rect) < beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i, rect);
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s()) || FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s())) {
            return rect.getBottom() > rect2.getTop() && rect.getTop() < rect2.getBottom();
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3782getUpdhqQ8s()) || FocusDirection.m3771equalsimpl0(i, companion.m3775getDowndhqQ8s())) {
            return rect.getRight() > rect2.getLeft() && rect.getLeft() < rect2.getRight();
        }
        throw new IllegalStateException(InvalidFocusDirection);
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s())) {
            return rect2.getLeft() >= rect.getRight();
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s())) {
            return rect2.getRight() <= rect.getLeft();
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3782getUpdhqQ8s())) {
            return rect2.getTop() >= rect.getBottom();
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3775getDowndhqQ8s())) {
            return rect2.getBottom() <= rect.getTop();
        }
        throw new IllegalStateException(InvalidFocusDirection);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float beamBeats_I7lrPNg$majorAxisDistance$6(androidx.compose.ui.geometry.Rect r2, int r3, androidx.compose.ui.geometry.Rect r4) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r1 = r0.m3778getLeftdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.getLeft()
            float r2 = r2.getRight()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.m3781getRightdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.getLeft()
            float r3 = r4.getRight()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.m3782getUpdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.getTop()
            float r2 = r2.getBottom()
            goto L14
        L3e:
            int r0 = r0.m3775getDowndhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r0)
            if (r3 == 0) goto L58
            float r2 = r2.getTop()
            float r3 = r4.getBottom()
            goto L28
        L51:
            r2 = 0
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L57
            return r2
        L57:
            return r3
        L58:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$majorAxisDistance$6(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(androidx.compose.ui.geometry.Rect r2, int r3, androidx.compose.ui.geometry.Rect r4) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r1 = r0.m3778getLeftdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.getLeft()
            float r2 = r2.getLeft()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.m3781getRightdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.getRight()
            float r3 = r4.getRight()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.m3782getUpdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.getTop()
            float r2 = r2.getTop()
            goto L14
        L3e:
            int r0 = r0.m3775getDowndhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r0)
            if (r3 == 0) goto L59
            float r2 = r2.getBottom()
            float r3 = r4.getBottom()
            goto L28
        L51:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L58
            return r2
        L58:
            return r3
        L59:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    private static final void collectAccessibleChildren(DelegatableNode delegatableNode, MutableVector<FocusTargetNode> mutableVector) {
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(1024);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode(), false);
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
                                FocusTargetNode focusTargetNode = (FocusTargetNode) nodePop;
                                if (focusTargetNode.getIsAttached() && !DelegatableNodeKt.requireLayoutNode(focusTargetNode).getIsDeactivated()) {
                                    if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                                        mutableVector.add(focusTargetNode);
                                    } else {
                                        collectAccessibleChildren(focusTargetNode, mutableVector);
                                    }
                                }
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
    }

    /* renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    private static final FocusTargetNode m3840findBestCandidate4WY_MpI(MutableVector<FocusTargetNode> mutableVector, Rect rect, int i) {
        Rect rectTranslate;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s())) {
            rectTranslate = rect.translate((rect.getRight() - rect.getLeft()) + 1, 0.0f);
        } else if (FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s())) {
            rectTranslate = rect.translate(-((rect.getRight() - rect.getLeft()) + 1), 0.0f);
        } else if (FocusDirection.m3771equalsimpl0(i, companion.m3782getUpdhqQ8s())) {
            rectTranslate = rect.translate(0.0f, (rect.getBottom() - rect.getTop()) + 1);
        } else {
            if (!FocusDirection.m3771equalsimpl0(i, companion.m3775getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            rectTranslate = rect.translate(0.0f, -((rect.getBottom() - rect.getTop()) + 1));
        }
        FocusTargetNode[] focusTargetNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        FocusTargetNode focusTargetNode = null;
        for (int i6 = 0; i6 < size; i6++) {
            FocusTargetNode focusTargetNode2 = focusTargetNodeArr[i6];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                Rect rectFocusRect = FocusTraversalKt.focusRect(focusTargetNode2);
                if (m3843isBetterCandidateI7lrPNg(rectFocusRect, rectTranslate, rect, i)) {
                    focusTargetNode = focusTargetNode2;
                    rectTranslate = rectFocusRect;
                }
            }
        }
        return focusTargetNode;
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8, reason: not valid java name */
    public static final boolean m3841findChildCorrespondingToFocusEnterOMvw8(FocusTargetNode focusTargetNode, int i, k kVar) {
        Rect rectBottomRight;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        collectAccessibleChildren(focusTargetNode, mutableVector);
        if (mutableVector.getSize() <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (mutableVector.getSize() == 0 ? null : mutableVector.content[0]);
            if (focusTargetNode2 != null) {
                return ((Boolean) kVar.invoke(focusTargetNode2)).booleanValue();
            }
            return false;
        }
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3776getEnterdhqQ8s())) {
            i = companion.m3781getRightdhqQ8s();
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s()) || FocusDirection.m3771equalsimpl0(i, companion.m3775getDowndhqQ8s())) {
            rectBottomRight = topLeft(FocusTraversalKt.focusRect(focusTargetNode));
        } else {
            if (!FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s()) && !FocusDirection.m3771equalsimpl0(i, companion.m3782getUpdhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            rectBottomRight = bottomRight(FocusTraversalKt.focusRect(focusTargetNode));
        }
        FocusTargetNode focusTargetNodeM3840findBestCandidate4WY_MpI = m3840findBestCandidate4WY_MpI(mutableVector, rectBottomRight, i);
        if (focusTargetNodeM3840findBestCandidate4WY_MpI != null) {
            return ((Boolean) kVar.invoke(focusTargetNodeM3840findBestCandidate4WY_MpI)).booleanValue();
        }
        return false;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m3842generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final Rect rect, final int i, final k kVar) {
        if (m3844searchChildren4C6V_qg(focusTargetNode, rect, i, kVar)) {
            return true;
        }
        final FocusTargetNode activeFocusTargetNode = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().getActiveFocusTargetNode();
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m3766searchBeyondBoundsOMvw8(focusTargetNode, i, new k() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                if (activeFocusTargetNode != DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().getActiveFocusTargetNode()) {
                    return Boolean.TRUE;
                }
                boolean zM3844searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m3844searchChildren4C6V_qg(focusTargetNode, rect, i, kVar);
                Boolean boolValueOf = Boolean.valueOf(zM3844searchChildren4C6V_qg);
                if (zM3844searchChildren4C6V_qg || !beyondBoundsScope.getHasMoreContent()) {
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

    /* renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    public static final boolean m3843isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(rect, i, rect3)) {
            return false;
        }
        if (isBetterCandidate_I7lrPNg$isCandidate(rect2, i, rect3) && !m3839beamBeatsI7lrPNg(rect3, rect, rect2, i)) {
            return !m3839beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2);
        }
        return true;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s())) {
            return (rect2.getRight() > rect.getRight() || rect2.getLeft() >= rect.getRight()) && rect2.getLeft() > rect.getLeft();
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s())) {
            return (rect2.getLeft() < rect.getLeft() || rect2.getRight() <= rect.getLeft()) && rect2.getRight() < rect.getRight();
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3782getUpdhqQ8s())) {
            return (rect2.getBottom() > rect.getBottom() || rect2.getTop() >= rect.getBottom()) && rect2.getTop() > rect.getTop();
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3775getDowndhqQ8s())) {
            return (rect2.getTop() < rect.getTop() || rect2.getBottom() <= rect.getTop()) && rect2.getBottom() < rect.getBottom();
        }
        throw new IllegalStateException(InvalidFocusDirection);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(androidx.compose.ui.geometry.Rect r2, int r3, androidx.compose.ui.geometry.Rect r4) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r1 = r0.m3778getLeftdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L16
            float r3 = r4.getLeft()
            float r2 = r2.getRight()
        L14:
            float r3 = r3 - r2
            goto L51
        L16:
            int r1 = r0.m3781getRightdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L2b
            float r2 = r2.getLeft()
            float r3 = r4.getRight()
        L28:
            float r3 = r2 - r3
            goto L51
        L2b:
            int r1 = r0.m3782getUpdhqQ8s()
            boolean r1 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r1)
            if (r1 == 0) goto L3e
            float r3 = r4.getTop()
            float r2 = r2.getBottom()
            goto L14
        L3e:
            int r0 = r0.m3775getDowndhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m3771equalsimpl0(r3, r0)
            if (r3 == 0) goto L58
            float r2 = r2.getTop()
            float r3 = r4.getBottom()
            goto L28
        L51:
            r2 = 0
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 >= 0) goto L57
            return r2
        L57:
            return r3
        L58:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$majorAxisDistance(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i, Rect rect2) {
        float f;
        float f7;
        float top;
        float bottom;
        float top2;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s()) || FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s())) {
            float top3 = rect2.getTop();
            float bottom2 = rect2.getBottom() - rect2.getTop();
            f = 2;
            f7 = (bottom2 / f) + top3;
            top = rect.getTop();
            bottom = rect.getBottom();
            top2 = rect.getTop();
        } else {
            if (!FocusDirection.m3771equalsimpl0(i, companion.m3782getUpdhqQ8s()) && !FocusDirection.m3771equalsimpl0(i, companion.m3775getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            float left = rect2.getLeft();
            float right = rect2.getRight() - rect2.getLeft();
            f = 2;
            f7 = (right / f) + left;
            top = rect.getLeft();
            bottom = rect.getRight();
            top2 = rect.getLeft();
        }
        return f7 - (((bottom - top2) / f) + top);
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        long jIsBetterCandidate_I7lrPNg$majorAxisDistance = (long) isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i, rect);
        long jIsBetterCandidate_I7lrPNg$minorAxisDistance = (long) isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i, rect);
        return (jIsBetterCandidate_I7lrPNg$minorAxisDistance * jIsBetterCandidate_I7lrPNg$minorAxisDistance) + (13 * jIsBetterCandidate_I7lrPNg$majorAxisDistance * jIsBetterCandidate_I7lrPNg$majorAxisDistance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m3844searchChildren4C6V_qg(FocusTargetNode focusTargetNode, Rect rect, int i, k kVar) {
        FocusTargetNode focusTargetNodeM3840findBestCandidate4WY_MpI;
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.getIsAttached()) {
                                    mutableVector.add(focusTargetNode2);
                                }
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
        while (mutableVector.getSize() != 0 && (focusTargetNodeM3840findBestCandidate4WY_MpI = m3840findBestCandidate4WY_MpI(mutableVector, rect, i)) != null) {
            if (focusTargetNodeM3840findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().getCanFocus()) {
                return ((Boolean) kVar.invoke(focusTargetNodeM3840findBestCandidate4WY_MpI)).booleanValue();
            }
            if (m3842generateAndSearchChildren4C6V_qg(focusTargetNodeM3840findBestCandidate4WY_MpI, rect, i, kVar)) {
                return true;
            }
            mutableVector.remove(focusTargetNodeM3840findBestCandidate4WY_MpI);
        }
        return false;
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    /* renamed from: twoDimensionalFocusSearch-sMXa3k8, reason: not valid java name */
    public static final Boolean m3845twoDimensionalFocusSearchsMXa3k8(FocusTargetNode focusTargetNode, int i, Rect rect, k kVar) {
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i6 = iArr[focusState.ordinal()];
        if (i6 != 1) {
            if (i6 == 2 || i6 == 3) {
                return Boolean.valueOf(m3841findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i, kVar));
            }
            if (i6 == 4) {
                return focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? (Boolean) kVar.invoke(focusTargetNode) : rect == null ? Boolean.valueOf(m3841findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i, kVar)) : Boolean.valueOf(m3844searchChildren4C6V_qg(focusTargetNode, rect, i, kVar));
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild == null) {
            throw new IllegalStateException(NoActiveChild);
        }
        int i10 = iArr[activeChild.getFocusState().ordinal()];
        if (i10 == 1) {
            Boolean boolM3845twoDimensionalFocusSearchsMXa3k8 = m3845twoDimensionalFocusSearchsMXa3k8(activeChild, i, rect, kVar);
            if (!kotlin.jvm.internal.k.b(boolM3845twoDimensionalFocusSearchsMXa3k8, Boolean.FALSE)) {
                return boolM3845twoDimensionalFocusSearchsMXa3k8;
            }
            if (rect == null) {
                rect = FocusTraversalKt.focusRect(activeNode(activeChild));
            }
            return Boolean.valueOf(m3842generateAndSearchChildren4C6V_qg(focusTargetNode, rect, i, kVar));
        }
        if (i10 == 2 || i10 == 3) {
            if (rect == null) {
                rect = FocusTraversalKt.focusRect(activeChild);
            }
            return Boolean.valueOf(m3842generateAndSearchChildren4C6V_qg(focusTargetNode, rect, i, kVar));
        }
        if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException(NoActiveChild);
    }
}
