package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u000e\u0010\u0016\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/HoverableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "updateInteractionSource", "", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onDetach", "emitEnter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitExit", "tryEmitExit", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {
    private HoverInteraction.Enter hoverInteraction;
    private MutableInteractionSource interactionSource;

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitEnter$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", i = {0}, l = {106}, m = "emitEnter", n = {"interaction"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HoverableNode this$0;

        public AnonymousClass1(HoverableNode r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return HoverableNode.access$emitEnter(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitExit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", i = {}, l = {114}, m = "emitExit", n = {}, s = {})
    public static final class C85601 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HoverableNode this$0;

        public C85601(HoverableNode r100, Continuation<? super C85601> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return HoverableNode.access$emitExit(this.this$0, this);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    public final /* synthetic */ long mo195getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.CC.m6621$default$getTouchBoundsExpansionRZrCHBk(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    @Override // androidx.compose.ui.Modifier.Node, androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    private final void tryEmitExit() {
        HoverInteraction.Enter r100 = this.hoverInteraction;
        if (r100 == null) goto L6;
        HoverInteraction.Exit r101 = new HoverInteraction.Exit(r100);
        this.interactionSource.tryEmit(r101);
        this.hoverInteraction = null;
        return;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        tryEmitExit();
    }

    public HoverableNode(MutableInteractionSource r100) {
        this.interactionSource = r100;
    }

    private final Object emitEnter(Continuation<? super Unit> r100) {
        if ((r100 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r101 = (AnonymousClass1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        HoverInteraction.Enter r106 = (HoverInteraction.Enter) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L20:
        this.hoverInteraction = r106;
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (this.hoverInteraction != null) goto L22;
        HoverInteraction.Enter r107 = new HoverInteraction.Enter();
        MutableInteractionSource r108 = this.interactionSource;
        r101.L$0 = r107;
        r101.label = 1;
        if (r108.emit(r107, r101) != r104) goto L19;
        return r104;
    L19:
        r106 = r107;
    L7:
        r101 = new AnonymousClass1(this, r100);
        goto L8
    }

    private final Object emitExit(Continuation<? super Unit> r100) {
        if ((r100 instanceof C85601) == false) goto L7;
        C85601 r101 = (C85601) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        this.hoverInteraction = null;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        HoverInteraction.Enter r106 = this.hoverInteraction;
        if (r106 == null) goto L21;
        HoverInteraction.Exit r107 = new HoverInteraction.Exit(r106);
        MutableInteractionSource r108 = this.interactionSource;
        r101.label = 1;
        if (r108.emit(r107, r101) != r104) goto L19;
        return r104;
    L7:
        r101 = new C85601(this, r100);
        goto L8
    }

    public final void updateInteractionSource(MutableInteractionSource r100) {
        if (Intrinsics.areEqual(this.interactionSource, r100) == true) goto L6;
        tryEmitExit();
        this.interactionSource = r100;
        return;
    }

    public static final /* synthetic */ Object access$emitEnter(HoverableNode r100, Continuation r101) {
        return r100.emitEnter(r101);
    }

    public static final /* synthetic */ Object access$emitExit(HoverableNode r100, Continuation r101) {
        return r100.emitExit(r101);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo202onPointerEventH0pRuoY(PointerEvent r100, PointerEventPass r101, long r102) {
        if (r101 != PointerEventPass.Main) goto L11;
        int r103 = r100.m6068getType7fucELk();
        PointerEventType.Companion r104 = PointerEventType.Companion;
        if (PointerEventType.m6075equalsimpl0(r103, r104.m6079getEnter7fucELk()) == false) goto L8;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null), 3, null);
        return;
    L8:
        if (PointerEventType.m6075equalsimpl0(r103, r104.m6080getExit7fucELk()) == false) goto L13;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$2(this, null), 3, null);
        return;
    L13:
        return;
    }
}
