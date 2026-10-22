package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.ui.geometry.Offset;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J<\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\nH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultDraggable2DState;", "Landroidx/compose/foundation/gestures/Draggable2DState;", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "LC7/r;", "onDelta", AppAgent.CONSTRUCT, "(LS7/k;)V", "Landroidx/compose/foundation/MutatePriority;", "dragPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/Drag2DScope;", "LH7/c;", "", "block", "drag", "(Landroidx/compose/foundation/MutatePriority;LS7/n;LH7/c;)Ljava/lang/Object;", "delta", "dispatchRawDelta-k-4lQ0M", "(J)V", "dispatchRawDelta", "LS7/k;", "getOnDelta", "()LS7/k;", "drag2DScope", "Landroidx/compose/foundation/gestures/Drag2DScope;", "Landroidx/compose/foundation/MutatorMutex;", "drag2DMutex", "Landroidx/compose/foundation/MutatorMutex;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultDraggable2DState implements Draggable2DState {
    private final k onDelta;
    private final Drag2DScope drag2DScope = new Drag2DScope() { // from class: androidx.compose.foundation.gestures.DefaultDraggable2DState$drag2DScope$1
        @Override // androidx.compose.foundation.gestures.Drag2DScope
        /* renamed from: dragBy-k-4lQ0M, reason: not valid java name */
        public void mo412dragByk4lQ0M(long pixels) {
            this.this$0.getOnDelta().invoke(Offset.m3884boximpl(pixels));
        }
    };
    private final MutatorMutex drag2DMutex = new MutatorMutex();

    @c(c = "androidx.compose.foundation.gestures.DefaultDraggable2DState$drag$2", f = "Draggable2D.kt", l = {497}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.DefaultDraggable2DState$drag$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ MutatePriority $dragPriority;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MutatePriority mutatePriority, n nVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$dragPriority = mutatePriority;
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return DefaultDraggable2DState.this.new AnonymousClass2(this.$dragPriority, this.$block, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                MutatorMutex mutatorMutex = DefaultDraggable2DState.this.drag2DMutex;
                Drag2DScope drag2DScope = DefaultDraggable2DState.this.drag2DScope;
                MutatePriority mutatePriority = this.$dragPriority;
                n nVar = this.$block;
                this.label = 1;
                if (mutatorMutex.mutateWith(drag2DScope, mutatePriority, nVar, this) == coroutineSingletons) {
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

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public DefaultDraggable2DState(k kVar) {
        this.onDelta = kVar;
    }

    @Override // androidx.compose.foundation.gestures.Draggable2DState
    /* renamed from: dispatchRawDelta-k-4lQ0M, reason: not valid java name */
    public void mo411dispatchRawDeltak4lQ0M(long delta) {
        this.onDelta.invoke(Offset.m3884boximpl(delta));
    }

    @Override // androidx.compose.foundation.gestures.Draggable2DState
    public Object drag(MutatePriority mutatePriority, n nVar, H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new AnonymousClass2(mutatePriority, nVar, null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    public final k getOnDelta() {
        return this.onDelta;
    }
}
