package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012*\b\u0002\u0010\u0013\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u0004\u0012*\b\u0002\u0010\u0016\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001c\u001a\u00020\u0015*\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u000f*\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001bJ@\u0010!\u001a\u00020\u00112.\u0010 \u001a*\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00110\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001eH\u0096@¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010%J\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010(JÏ\u0001\u0010)\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062*\b\u0002\u0010\u0013\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r2*\b\u0002\u0010\u0016\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u00042\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\u0004\b)\u0010*R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010,R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010,R8\u0010\u0013\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010-R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010.R8\u0010\u0016\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010-R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010.\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Landroidx/compose/foundation/gestures/Draggable2DNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/foundation/gestures/Draggable2DState;", "state", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "canDrag", "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "startDragImmediately", "reverseDirection", "Lkotlin/Function3;", "Lm9/z;", "Landroidx/compose/ui/geometry/Offset;", "LH7/c;", "LC7/r;", "", "onDragStarted", "onDragStart", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped", "onDragStop", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/gestures/Draggable2DState;LS7/k;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZZLS7/o;LS7/k;LS7/o;LS7/k;)V", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "forEachDelta", "drag", "(LS7/n;LH7/c;)Ljava/lang/Object;", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "velocity", "onDragStopped-TH1AsA0", "()Z", "update", "(Landroidx/compose/foundation/gestures/Draggable2DState;LS7/k;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZZLS7/o;LS7/o;LS7/k;LS7/k;)V", "Landroidx/compose/foundation/gestures/Draggable2DState;", "Z", "LS7/o;", "LS7/k;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Draggable2DNode extends DragGestureNode {
    public static final int $stable = 8;
    private k onDragStart;
    private o onDragStarted;
    private k onDragStop;
    private o onDragStopped;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private Draggable2DState state;

    @c(c = "androidx.compose.foundation.gestures.Draggable2DNode$drag$2", f = "Draggable2D.kt", l = {TypedValues.CycleType.TYPE_PATH_ROTATE}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/Drag2DScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/Drag2DScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.Draggable2DNode$drag$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ n $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Draggable2DNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(n nVar, Draggable2DNode draggable2DNode, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$forEachDelta = nVar;
            this.this$0 = draggable2DNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$forEachDelta, this.this$0, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(Drag2DScope drag2DScope, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(drag2DScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final Drag2DScope drag2DScope = (Drag2DScope) this.L$0;
                n nVar = this.$forEachDelta;
                final Draggable2DNode draggable2DNode = this.this$0;
                k kVar = new k() { // from class: androidx.compose.foundation.gestures.Draggable2DNode.drag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((DragEvent.DragDelta) obj2);
                        return r.f317a;
                    }

                    public final void invoke(DragEvent.DragDelta dragDelta) {
                        drag2DScope.mo412dragByk4lQ0M(draggable2DNode.m460reverseIfNeededMKHz9U(dragDelta.getDelta()));
                    }
                };
                this.label = 1;
                if (nVar.invoke(kVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    public /* synthetic */ Draggable2DNode(Draggable2DState draggable2DState, k kVar, boolean z10, MutableInteractionSource mutableInteractionSource, boolean z11, boolean z12, o oVar, k kVar2, o oVar2, k kVar3, int i, e eVar) {
        this(draggable2DState, kVar, z10, mutableInteractionSource, z11, z12, (i & 64) != 0 ? Draggable2DKt.NoOpOnDragStarted : oVar, (i & 128) != 0 ? Draggable2DKt.NoOpOnDragStart : kVar2, (i & 256) != 0 ? Draggable2DKt.NoOpOnDragStopped : oVar2, (i & 512) != 0 ? Draggable2DKt.NoOpOnDragStop : kVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    public final long m459reverseIfNeededAH228Gc(long j5) {
        return Velocity.m7088timesadjELrA(j5, this.reverseDirection ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m460reverseIfNeededMKHz9U(long j5) {
        return Offset.m3902timestuRUvjQ(j5, this.reverseDirection ? -1.0f : 1.0f);
    }

    public static /* synthetic */ void update$default(Draggable2DNode draggable2DNode, Draggable2DState draggable2DState, k kVar, boolean z10, MutableInteractionSource mutableInteractionSource, boolean z11, boolean z12, o oVar, o oVar2, k kVar2, k kVar3, int i, Object obj) {
        k kVar4;
        Draggable2DNode draggable2DNode2;
        Draggable2DState draggable2DState2;
        k kVar5;
        boolean z13;
        MutableInteractionSource mutableInteractionSource2;
        boolean z14;
        boolean z15;
        o oVar3 = (i & 64) != 0 ? draggable2DNode.onDragStarted : oVar;
        o oVar4 = (i & 128) != 0 ? draggable2DNode.onDragStopped : oVar2;
        k kVar6 = (i & 256) != 0 ? draggable2DNode.onDragStart : kVar2;
        if ((i & 512) != 0) {
            kVar4 = draggable2DNode.onDragStop;
            draggable2DNode2 = draggable2DNode;
            kVar5 = kVar;
            z13 = z10;
            mutableInteractionSource2 = mutableInteractionSource;
            z14 = z11;
            z15 = z12;
            draggable2DState2 = draggable2DState;
        } else {
            kVar4 = kVar3;
            draggable2DNode2 = draggable2DNode;
            draggable2DState2 = draggable2DState;
            kVar5 = kVar;
            z13 = z10;
            mutableInteractionSource2 = mutableInteractionSource;
            z14 = z11;
            z15 = z12;
        }
        draggable2DNode2.update(draggable2DState2, kVar5, z13, mutableInteractionSource2, z14, z15, oVar3, oVar4, kVar6, kVar4);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(n nVar, H7.c<? super r> cVar) {
        Object objDrag = this.state.drag(MutatePriority.UserInput, new AnonymousClass2(nVar, this, null), cVar);
        return objDrag == CoroutineSingletons.f4909a ? objDrag : r.f317a;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStarted-k-4lQ0M */
    public void mo398onDragStartedk4lQ0M(long startedPosition) {
        this.onDragStart.invoke(Offset.m3884boximpl(startedPosition));
        if (!getIsAttached() || this.onDragStarted == Draggable2DKt.NoOpOnDragStarted) {
            return;
        }
        AbstractC1683A.n(getCoroutineScope(), null, new Draggable2DNode$onDragStarted$1(this, startedPosition, null), 3);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStopped-TH1AsA0 */
    public void mo399onDragStoppedTH1AsA0(long velocity) {
        this.onDragStop.invoke(Velocity.m7073boximpl(velocity));
        if (!getIsAttached() || this.onDragStopped == Draggable2DKt.NoOpOnDragStopped) {
            return;
        }
        AbstractC1683A.n(getCoroutineScope(), null, new Draggable2DNode$onDragStopped$1(this, velocity, null), 3);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: startDragImmediately, reason: from getter */
    public boolean getStartDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(Draggable2DState state, k canDrag, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, boolean reverseDirection, o onDragStarted, o onDragStopped, k onDragStart, k onDragStop) {
        boolean z10;
        boolean z11 = true;
        if (kotlin.jvm.internal.k.b(this.state, state)) {
            z10 = false;
        } else {
            this.state = state;
            z10 = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
        } else {
            z11 = z10;
        }
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.onDragStart = onDragStart;
        this.onDragStop = onDragStop;
        this.startDragImmediately = startDragImmediately;
        update(canDrag, enabled, interactionSource, null, z11);
    }

    public Draggable2DNode(Draggable2DState draggable2DState, k kVar, boolean z10, MutableInteractionSource mutableInteractionSource, boolean z11, boolean z12, o oVar, k kVar2, o oVar2, k kVar3) {
        super(kVar, z10, mutableInteractionSource, null);
        this.state = draggable2DState;
        this.startDragImmediately = z11;
        this.reverseDirection = z12;
        this.onDragStarted = oVar;
        this.onDragStart = kVar2;
        this.onDragStopped = oVar2;
        this.onDragStop = kVar3;
    }
}
