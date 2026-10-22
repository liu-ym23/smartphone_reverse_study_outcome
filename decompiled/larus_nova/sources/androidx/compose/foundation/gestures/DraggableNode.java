package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Velocity;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012<\u0010\u000e\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u0018\u0012<\u0010\u0019\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJM\u0010 \u001a\u00020\u00162=\u0010!\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00160\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\"H\u0096@¢\u0006\u0002\u0010%J\u0017\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010'J\b\u0010\r\u001a\u00020\u0007H\u0016JÍ\u0001\u0010*\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00072<\u0010\u000e\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u00182<\u0010\u0019\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001eJ\u0013\u0010+\u001a\u00020(*\u00020(H\u0002¢\u0006\u0004\b,\u0010-J\u0013\u0010+\u001a\u00020\u0011*\u00020\u0011H\u0002¢\u0006\u0004\b.\u0010-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010\u000e\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001fRF\u0010\u0019\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\b\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "reverseDirection", "<init>", "(Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Lkotlin/jvm/functions/Function3;", BitableAnalytic.ProgressInputType.DRAG, "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted-k-4lQ0M", "(J)V", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "update", "reverseIfNeeded", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded-MK-Hz9U", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DraggableNode extends DragGestureNode {
    public static final int $stable = 8;
    private Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    private Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    private Orientation orientation;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private DraggableState state;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$drag$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$drag$2", f = "Draggable.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DraggableNode this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r100, DraggableNode r101, Continuation<? super AnonymousClass2> r102) {
            this.$forEachDelta = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        public static /* synthetic */ Unit a(DragScope r100, DraggableNode r101, DragEvent.DragDelta r102) {
            return invokeSuspend$lambda$0(r100, r101, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.$forEachDelta, this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(DragScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(DragScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            final DragScope r103 = (DragScope) this.L$0;
            Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> r104 = this.$forEachDelta;
            final DraggableNode r105 = this.this$0;
            Function1<? super DragEvent.DragDelta, Unit> r106 = new r1(r103, r105);
            this.label = 1;
            if (r104.invoke(r106, this) != r101) goto L12;
            return r101;
        }

        private static final Unit invokeSuspend$lambda$0(DragScope r100, DraggableNode r101, DragEvent.DragDelta r102) {
            r100.dragBy(DraggableKt.m435access$toFloat3MmeM6k(DraggableNode.m443access$reverseIfNeededMKHz9U(r101, r102.m410getDeltaF1C5BW0()), DraggableNode.access$getOrientation$p(r101)));
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public static final /* synthetic */ Function3 access$getOnDragStarted$p(DraggableNode r100) {
        return r100.onDragStarted;
    }

    public static final /* synthetic */ Function3 access$getOnDragStopped$p(DraggableNode r100) {
        return r100.onDragStopped;
    }

    public static final /* synthetic */ Orientation access$getOrientation$p(DraggableNode r100) {
        return r100.orientation;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    private final long m444reverseIfNeededAH228Gc(long r100) {
        if (this.reverseDirection == false) goto L5;
        float r101 = -1.0f;
    L7:
        return Velocity.m7792timesadjELrA(r100, r101);
    L5:
        r101 = 1.0f;
        goto L7
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    private final long m445reverseIfNeededMKHz9U(long r100) {
        if (this.reverseDirection == false) goto L5;
        float r101 = -1.0f;
    L7:
        return Offset.m4589timestuRUvjQ(r100, r101);
    L5:
        r101 = 1.0f;
        goto L7
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public void mo389onDragStartedk4lQ0M(long r100) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.onDragStarted, DraggableKt.access$getNoOpOnDragStarted$p()) == true) goto L10;
        BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new DraggableNode$onDragStarted$1(this, r100, null), 1, null);
        return;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-TH1AsA0 */
    public void mo390onDragStoppedTH1AsA0(long r100) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.onDragStopped, DraggableKt.access$getNoOpOnDragStopped$p()) == true) goto L10;
        BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new DraggableNode$onDragStopped$1(this, r100, null), 1, null);
        return;
    }

    /* JADX INFO: renamed from: access$reverseIfNeeded-AH228Gc, reason: not valid java name */
    public static final /* synthetic */ long m442access$reverseIfNeededAH228Gc(DraggableNode r100, long r101) {
        return r100.m444reverseIfNeededAH228Gc(r101);
    }

    /* JADX INFO: renamed from: access$reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public static final /* synthetic */ long m443access$reverseIfNeededMKHz9U(DraggableNode r100, long r101) {
        return r100.m445reverseIfNeededMKHz9U(r101);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101) {
        Object r102 = this.state.drag(MutatePriority.UserInput, new AnonymousClass2(r100, this, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public DraggableNode(DraggableState r100, Function1<? super PointerInputChange, Boolean> r101, Orientation r102, boolean r103, MutableInteractionSource r104, boolean r105, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r106, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> r107, boolean r108) {
        super(r101, r103, r104, r102);
        this.state = r100;
        this.orientation = r102;
        this.startDragImmediately = r105;
        this.onDragStarted = r106;
        this.onDragStopped = r107;
        this.reverseDirection = r108;
    }

    public final void update(DraggableState r100, Function1<? super PointerInputChange, Boolean> r101, Orientation r110, boolean r111, MutableInteractionSource r112, boolean r113, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r114, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> r115, boolean r116) {
        if (Intrinsics.areEqual(this.state, r100) == true) goto L5;
        this.state = r100;
        boolean r102 = true;
    L7:
        if (this.orientation == r110) goto L10;
        this.orientation = r110;
        r102 = true;
    L10:
        if (this.reverseDirection == r116) goto L12;
        this.reverseDirection = r116;
        boolean r103 = true;
    L13:
        this.onDragStarted = r114;
        this.onDragStopped = r115;
        this.startDragImmediately = r113;
        update(r101, r111, r112, r110, r103);
        return;
    L12:
        r103 = r102;
        goto L13
    L5:
        r102 = false;
        goto L7
    }
}
