package androidx.compose.ui.focus;

import C7.c;
import C7.r;
import S7.k;
import S7.n;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a7\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetModifierNode;", "FocusTargetModifierNode", "()Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/focus/Focusability;", "focusability", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusState;", "LC7/r;", "onFocusChange", "FocusTargetModifierNode-PYyLHbc", "(ILS7/n;)Landroidx/compose/ui/focus/FocusTargetModifierNode;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTargetModifierNodeKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.focus.FocusTargetModifierNodeKt$FocusTargetModifierNode$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements k {
        public AnonymousClass1(Object obj) {
            super(1, obj, InvalidateSemantics.class, "onDispatchEventsCompleted", "onDispatchEventsCompleted(Landroidx/compose/ui/focus/FocusTargetNode;)V", 0);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusTargetNode) obj);
            return r.f317a;
        }

        public final void invoke(FocusTargetNode focusTargetNode) {
            ((InvalidateSemantics) this.receiver).onDispatchEventsCompleted(focusTargetNode);
        }
    }

    @c
    public static final /* synthetic */ FocusTargetModifierNode FocusTargetModifierNode() {
        return new FocusTargetNode(0, null, new AnonymousClass1(InvalidateSemantics.INSTANCE), 3, null);
    }

    /* renamed from: FocusTargetModifierNode-PYyLHbc, reason: not valid java name */
    public static final FocusTargetModifierNode m3806FocusTargetModifierNodePYyLHbc(int i, n nVar) {
        return new FocusTargetNode(i, nVar, null, 4, null);
    }

    /* renamed from: FocusTargetModifierNode-PYyLHbc$default, reason: not valid java name */
    public static /* synthetic */ FocusTargetModifierNode m3807FocusTargetModifierNodePYyLHbc$default(int i, n nVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = Focusability.INSTANCE.m3829getAlwaysLCbbffg();
        }
        if ((i6 & 2) != 0) {
            nVar = null;
        }
        return m3806FocusTargetModifierNodePYyLHbc(i, nVar);
    }
}
