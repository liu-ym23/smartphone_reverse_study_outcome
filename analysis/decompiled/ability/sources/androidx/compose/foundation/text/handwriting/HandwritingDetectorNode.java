package androidx.compose.foundation.text.handwriting;

import C7.f;
import S7.a;
import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/foundation/text/handwriting/HandwritingDetectorNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Lkotlin/Function0;", "LC7/r;", "callback", AppAgent.CONSTRUCT, "(LS7/a;)V", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Landroidx/compose/ui/unit/IntSize;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPointerEvent", "onCancelPointerInput", "()V", "LS7/a;", "getCallback", "()LS7/a;", "setCallback", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "composeImm$delegate", "LC7/f;", "getComposeImm", "()Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "composeImm", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "pointerInputNode", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "getPointerInputNode", "()Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class HandwritingDetectorNode extends DelegatingNode implements PointerInputModifierNode {
    private a callback;

    /* renamed from: composeImm$delegate, reason: from kotlin metadata */
    private final f composeImm = kotlin.a.b(LazyThreadSafetyMode.c, new a() { // from class: androidx.compose.foundation.text.handwriting.HandwritingDetectorNode$composeImm$2
        {
            super(0);
        }

        @Override // S7.a
        public final ComposeInputMethodManager invoke() {
            return ComposeInputMethodManager_androidKt.ComposeInputMethodManager(DelegatableNode_androidKt.requireView(this.this$0));
        }
    });
    private final StylusHandwritingNodeWithNegativePadding pointerInputNode = (StylusHandwritingNodeWithNegativePadding) delegate(new StylusHandwritingNodeWithNegativePadding(new a() { // from class: androidx.compose.foundation.text.handwriting.HandwritingDetectorNode$pointerInputNode$1
        {
            super(0);
        }

        @Override // S7.a
        public final Boolean invoke() {
            this.this$0.getCallback().invoke();
            this.this$0.getComposeImm().prepareStylusHandwritingDelegation();
            return Boolean.TRUE;
        }
    }));

    public HandwritingDetectorNode(a aVar) {
        this.callback = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeInputMethodManager getComposeImm() {
        return (ComposeInputMethodManager) this.composeImm.getF4884a();
    }

    public final a getCallback() {
        return this.callback;
    }

    public final StylusHandwritingNodeWithNegativePadding getPointerInputNode() {
        return this.pointerInputNode;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo212onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.pointerInputNode.mo212onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    public final void setCallback(a aVar) {
        this.callback = aVar;
    }
}
