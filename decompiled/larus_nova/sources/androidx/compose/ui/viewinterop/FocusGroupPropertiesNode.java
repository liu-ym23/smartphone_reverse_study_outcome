package androidx.compose.ui.viewinterop;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusEnterExitScope;
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
import com.alipay.sdk.m.x.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006%"}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "<init>", "()V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "attachedViewTreeObserver", "Landroid/view/ViewTreeObserver;", "getAttachedViewTreeObserver", "()Landroid/view/ViewTreeObserver;", "setAttachedViewTreeObserver", "(Landroid/view/ViewTreeObserver;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "getOnEnter", "()Lkotlin/jvm/functions/Function1;", d.f25928r, "getOnExit", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onGlobalFocusChanged", "oldFocus", "newFocus", "onAttach", "onDetach", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener {
    private ViewTreeObserver attachedViewTreeObserver;
    private View focusedChild;
    private final Function1<FocusEnterExitScope, Unit> onEnter;
    private final Function1<FocusEnterExitScope, Unit> onExit;

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        int r100 = NodeKind.m6556constructorimpl(1024);
        if (getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
    L5:
        Modifier.Node r101 = getNode();
        if ((r101.getAggregateChildKindSet$ui_release() & r100) == 0) goto L47;
        Modifier.Node r102 = r101.getChild$ui_release();
        boolean r103 = false;
    L8:
        if (r102 == null) goto L47;
        if ((r102.getKindSet$ui_release() & r100) == 0) goto L45;
        Modifier.Node r104 = r102;
        MutableVector r105 = null;
    L12:
        if (r104 == null) goto L45;
        if ((r104 instanceof FocusTargetNode) == true) goto L15;
        if ((r104.getKindSet$ui_release() & r100) == 0) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == false) goto L44;
        if ((r104 instanceof DelegatingNode) == false) goto L44;
        Modifier.Node r107 = ((DelegatingNode) r104).getDelegate$ui_release();
        int r108 = 0;
    L27:
        if (r107 == null) goto L42;
        if ((r107.getKindSet$ui_release() & r100) == 0) goto L31;
        boolean r110 = true;
    L32:
        if (r110 == false) goto L41;
        r108 = r108 + 1;
        if (r108 != 1) goto L36;
        r104 = r107;
        goto L41
    L36:
        if (r105 != null) goto L38;
        r105 = new MutableVector(new Modifier.Node[16], 0);
    L38:
        if (r104 == null) goto L40;
        r105.add(r104);
        r104 = null;
    L40:
        r105.add(r107);
    L41:
        r107 = r107.getChild$ui_release();
        goto L27
    L31:
        r110 = false;
        goto L32
    L42:
        if (r108 == 1) goto L12;
    L44:
        r104 = DelegatableNodeKt.access$pop(r105);
        goto L12
    L22:
        r106 = false;
        goto L23
    L15:
        FocusTargetNode r109 = (FocusTargetNode) r104;
        if (r103 == true) goto L17;
        r103 = true;
        goto L44
    L17:
        return r109;
    L45:
        r102 = r102.getChild$ui_release();
    L47:
        throw new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        ViewTreeObserver r100 = this.attachedViewTreeObserver;
        if (r100 != null) goto L5;
    L7:
        this.attachedViewTreeObserver = null;
        DelegatableNode_androidKt.requireView(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
        return;
    L5:
        if (r100.isAlive() == false) goto L7;
        r100.removeOnGlobalFocusChangeListener(this);
        goto L7
    }

    public FocusGroupPropertiesNode() {
        this.onEnter = new FocusGroupPropertiesNode$onEnter$1(this);
        this.onExit = new FocusGroupPropertiesNode$onExit$1(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        ViewTreeObserver r100 = DelegatableNode_androidKt.requireView(this).getViewTreeObserver();
        this.attachedViewTreeObserver = r100;
        r100.addOnGlobalFocusChangeListener(this);
    }

    public final ViewTreeObserver getAttachedViewTreeObserver() {
        return this.attachedViewTreeObserver;
    }

    public final View getFocusedChild() {
        return this.focusedChild;
    }

    public final Function1<FocusEnterExitScope, Unit> getOnEnter() {
        return this.onEnter;
    }

    public final Function1<FocusEnterExitScope, Unit> getOnExit() {
        return this.onExit;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties r100) {
        r100.setCanFocus(false);
        r100.setOnEnter(this.onEnter);
        r100.setOnExit(this.onExit);
    }

    public final void setAttachedViewTreeObserver(ViewTreeObserver r100) {
        this.attachedViewTreeObserver = r100;
    }

    public final void setFocusedChild(View r100) {
        this.focusedChild = r100;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View r100, View r101) {
        if (DelegatableNodeKt.requireLayoutNode(this).getOwner$ui_release() != null) goto L5;
        return;
    L5:
        View r102 = FocusGroupNode_androidKt.access$getEmbeddedView(this);
        FocusOwner r103 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Owner r104 = DelegatableNodeKt.requireOwner(this);
        if (r100 != null) goto L8;
    L12:
        boolean r105 = false;
    L13:
        if (r101 != null) goto L15;
    L19:
        boolean r106 = false;
    L20:
        if (r105 == false) goto L23;
        if (r106 == false) goto L23;
        this.focusedChild = r101;
        return;
    L23:
        if (r106 == false) goto L28;
        this.focusedChild = r101;
        FocusTargetNode r107 = getFocusTargetOfEmbeddedViewWrapper();
        if (r107.getFocusState().getHasFocus() == true) goto L35;
        FocusTransactionsKt.performRequestFocus(r107);
        return;
    L35:
        return;
    L28:
        if (r105 == false) goto L32;
        this.focusedChild = null;
        if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused() == false) goto L37;
        r103.mo4476clearFocusI7lrPNg(false, true, false, FocusDirection.Companion.m4467getExitdhqQ8s());
        return;
    L37:
        return;
    L32:
        this.focusedChild = null;
        return;
    L15:
        if (Intrinsics.areEqual(r101, r104) == true) goto L19;
        if (FocusGroupNode_androidKt.access$containsDescendant(r102, r101) == false) goto L19;
        r106 = true;
        goto L20
    L8:
        if (Intrinsics.areEqual(r100, r104) == true) goto L12;
        if (FocusGroupNode_androidKt.access$containsDescendant(r102, r100) == false) goto L12;
        r105 = true;
        goto L13
    }
}
