package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.ui.geometry.Offset;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012¢\u0006\u0002\b\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultDraggable2DState;", "Landroidx/compose/foundation/gestures/Draggable2DState;", "onDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "drag2DScope", "Landroidx/compose/foundation/gestures/Drag2DScope;", "drag2DMutex", "Landroidx/compose/foundation/MutatorMutex;", BitableAnalytic.ProgressInputType.DRAG, "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "dispatchRawDelta-k-4lQ0M", "(J)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultDraggable2DState implements Draggable2DState {
    private final MutatorMutex drag2DMutex;
    private final Drag2DScope drag2DScope;
    private final Function1<Offset, Unit> onDelta;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultDraggable2DState$drag$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultDraggable2DState$drag$2", f = "Draggable2D.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Drag2DScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MutatePriority $dragPriority;
        int label;
        final /* synthetic */ DefaultDraggable2DState this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(DefaultDraggable2DState r100, MutatePriority r101, Function2<? super Drag2DScope, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super AnonymousClass2> r103) {
            this.this$0 = r100;
            this.$dragPriority = r101;
            this.$block = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$dragPriority, this.$block, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            MutatorMutex r103 = DefaultDraggable2DState.access$getDrag2DMutex$p(this.this$0);
            Drag2DScope r104 = DefaultDraggable2DState.access$getDrag2DScope$p(this.this$0);
            MutatePriority r105 = this.$dragPriority;
            Function2<Drag2DScope, Continuation<? super Unit>, Object> r106 = this.$block;
            this.label = 1;
            if (r103.mutateWith(r104, r105, r106, this) != r101) goto L12;
            return r101;
        }
    }

    public final Function1<Offset, Unit> getOnDelta() {
        return this.onDelta;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultDraggable2DState(Function1<? super Offset, Unit> r100) {
        this.onDelta = r100;
        this.drag2DScope = new DefaultDraggable2DState$drag2DScope$1(this);
        this.drag2DMutex = new MutatorMutex();
    }

    public static final /* synthetic */ MutatorMutex access$getDrag2DMutex$p(DefaultDraggable2DState r100) {
        return r100.drag2DMutex;
    }

    public static final /* synthetic */ Drag2DScope access$getDrag2DScope$p(DefaultDraggable2DState r100) {
        return r100.drag2DScope;
    }

    @Override // androidx.compose.foundation.gestures.Draggable2DState
    /* JADX INFO: renamed from: dispatchRawDelta-k-4lQ0M, reason: not valid java name */
    public void mo404dispatchRawDeltak4lQ0M(long r100) {
        this.onDelta.invoke(Offset.m4571boximpl(r100));
    }

    @Override // androidx.compose.foundation.gestures.Draggable2DState
    public Object drag(MutatePriority r100, Function2<? super Drag2DScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        Object r103 = CoroutineScopeKt.coroutineScope(new AnonymousClass2(this, r100, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }
}
