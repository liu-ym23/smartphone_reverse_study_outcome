package androidx.compose.ui.viewinterop;

import C7.r;
import S7.k;
import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusEnterExitScope;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0005R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R#\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b0\"8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R#\u0010(\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b0\"8\u0006¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'¨\u0006*"}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/focus/FocusTargetNode;", "getFocusTargetOfEmbeddedViewWrapper", "()Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusProperties;", "focusProperties", "LC7/r;", "applyFocusProperties", "(Landroidx/compose/ui/focus/FocusProperties;)V", "Landroid/view/View;", "oldFocus", "newFocus", "onGlobalFocusChanged", "(Landroid/view/View;Landroid/view/View;)V", "onAttach", "onDetach", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "Landroid/view/ViewTreeObserver;", "attachedViewTreeObserver", "Landroid/view/ViewTreeObserver;", "getAttachedViewTreeObserver", "()Landroid/view/ViewTreeObserver;", "setAttachedViewTreeObserver", "(Landroid/view/ViewTreeObserver;)V", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "onEnter", "LS7/k;", "getOnEnter", "()LS7/k;", "onExit", "getOnExit", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener {
    private ViewTreeObserver attachedViewTreeObserver;
    private View focusedChild;
    private final k onEnter = new k() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onEnter$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusEnterExitScope) obj);
            return r.f317a;
        }

        public final void invoke(FocusEnterExitScope focusEnterExitScope) {
            View embeddedView = FocusGroupNode_androidKt.getEmbeddedView(this.this$0);
            if (embeddedView.isFocused() || embeddedView.hasFocus()) {
                return;
            }
            if (FocusInteropUtils_androidKt.requestInteropFocus(embeddedView, FocusInteropUtils_androidKt.m3783toAndroidFocusDirection3ESFkO8(focusEnterExitScope.getRequestedFocusDirection()), FocusGroupNode_androidKt.getCurrentlyFocusedRect(DelegatableNodeKt.requireOwner(this.this$0).getFocusOwner(), DelegatableNode_androidKt.requireView(this.this$0), embeddedView))) {
                return;
            }
            focusEnterExitScope.cancelFocusChange();
        }
    };
    private final k onExit = new k() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onExit$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusEnterExitScope) obj);
            return r.f317a;
        }

        public final void invoke(FocusEnterExitScope focusEnterExitScope) {
            View viewFindNextFocusFromRect;
            View embeddedView = FocusGroupNode_androidKt.getEmbeddedView(this.this$0);
            if (ComposeUiFlags.isViewFocusFixEnabled) {
                if (embeddedView.hasFocus() || embeddedView.isFocused()) {
                    embeddedView.clearFocus();
                    return;
                }
                return;
            }
            if (embeddedView.hasFocus()) {
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this.this$0).getFocusOwner();
                View viewRequireView = DelegatableNode_androidKt.requireView(this.this$0);
                if (!(embeddedView instanceof ViewGroup)) {
                    if (!viewRequireView.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus");
                    }
                    return;
                }
                Rect currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, viewRequireView, embeddedView);
                Integer numM3783toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m3783toAndroidFocusDirection3ESFkO8(focusEnterExitScope.getRequestedFocusDirection());
                int iIntValue = numM3783toAndroidFocusDirection3ESFkO8 != null ? numM3783toAndroidFocusDirection3ESFkO8.intValue() : 130;
                FocusFinder focusFinder = FocusFinder.getInstance();
                FocusGroupPropertiesNode focusGroupPropertiesNode = this.this$0;
                if (focusGroupPropertiesNode.getFocusedChild() != null) {
                    kotlin.jvm.internal.k.d(viewRequireView, "null cannot be cast to non-null type android.view.ViewGroup");
                    viewFindNextFocusFromRect = focusFinder.findNextFocus((ViewGroup) viewRequireView, focusGroupPropertiesNode.getFocusedChild(), iIntValue);
                } else {
                    kotlin.jvm.internal.k.d(viewRequireView, "null cannot be cast to non-null type android.view.ViewGroup");
                    viewFindNextFocusFromRect = focusFinder.findNextFocusFromRect((ViewGroup) viewRequireView, currentlyFocusedRect, iIntValue);
                }
                if (viewFindNextFocusFromRect == null || !FocusGroupNode_androidKt.containsDescendant(embeddedView, viewFindNextFocusFromRect)) {
                    if (!viewRequireView.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus");
                    }
                } else {
                    viewFindNextFocusFromRect.requestFocus(iIntValue, currentlyFocusedRect);
                    focusEnterExitScope.cancelFocusChange();
                }
            }
        }
    };

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(1024);
        if (!getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = getNode();
        if ((node.getAggregateChildKindSet() & iM5862constructorimpl) != 0) {
            boolean z10 = false;
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & iM5862constructorimpl) != 0) {
                    Modifier.Node nodePop = child;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        if (nodePop instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) nodePop;
                            if (z10) {
                                return focusTargetNode;
                            }
                            z10 = true;
                        } else if ((nodePop.getKindSet() & iM5862constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
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
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper");
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setOnEnter(this.onEnter);
        focusProperties.setOnExit(this.onExit);
    }

    public final ViewTreeObserver getAttachedViewTreeObserver() {
        return this.attachedViewTreeObserver;
    }

    public final View getFocusedChild() {
        return this.focusedChild;
    }

    public final k getOnEnter() {
        return this.onEnter;
    }

    public final k getOnExit() {
        return this.onExit;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        ViewTreeObserver viewTreeObserver = DelegatableNode_androidKt.requireView(this).getViewTreeObserver();
        this.attachedViewTreeObserver = viewTreeObserver;
        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        ViewTreeObserver viewTreeObserver = this.attachedViewTreeObserver;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
        }
        this.attachedViewTreeObserver = null;
        DelegatableNode_androidKt.requireView(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        if (DelegatableNodeKt.requireLayoutNode(this).getOwner() == null) {
            return;
        }
        View embeddedView = FocusGroupNode_androidKt.getEmbeddedView(this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Owner ownerRequireOwner = DelegatableNodeKt.requireOwner(this);
        boolean z10 = (oldFocus == null || oldFocus.equals(ownerRequireOwner) || !FocusGroupNode_androidKt.containsDescendant(embeddedView, oldFocus)) ? false : true;
        boolean z11 = (newFocus == null || newFocus.equals(ownerRequireOwner) || !FocusGroupNode_androidKt.containsDescendant(embeddedView, newFocus)) ? false : true;
        if (z10 && z11) {
            this.focusedChild = newFocus;
            return;
        }
        if (z11) {
            this.focusedChild = newFocus;
            FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
            if (focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus()) {
                return;
            }
            FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
            return;
        }
        if (!z10) {
            this.focusedChild = null;
            return;
        }
        this.focusedChild = null;
        if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
            focusOwner.mo3788clearFocusI7lrPNg(false, true, false, FocusDirection.INSTANCE.m3777getExitdhqQ8s());
        }
    }

    public final void setAttachedViewTreeObserver(ViewTreeObserver viewTreeObserver) {
        this.attachedViewTreeObserver = viewTreeObserver;
    }

    public final void setFocusedChild(View view) {
        this.focusedChild = view;
    }
}
