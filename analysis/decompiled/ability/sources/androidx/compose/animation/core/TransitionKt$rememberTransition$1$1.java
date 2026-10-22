package androidx.compose.animation.core;

import C7.r;
import J7.c;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;
import w9.InterfaceC2108a;

@c(c = "androidx.compose.animation.core.TransitionKt$rememberTransition$1$1", f = "Transition.kt", l = {2189}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class TransitionKt$rememberTransition$1$1 extends SuspendLambda implements n {
    final /* synthetic */ TransitionState<T> $transitionState;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransitionKt$rememberTransition$1$1(TransitionState<T> transitionState, H7.c<? super TransitionKt$rememberTransition$1$1> cVar) {
        super(2, cVar);
        this.$transitionState = transitionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new TransitionKt$rememberTransition$1$1(this.$transitionState, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterfaceC2108a interfaceC2108a;
        TransitionState transitionState;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            ((SeekableTransitionState) this.$transitionState).observeTotalDuration$animation_core_release();
            InterfaceC2108a compositionContinuationMutex = ((SeekableTransitionState) this.$transitionState).getCompositionContinuationMutex();
            TransitionState transitionState2 = this.$transitionState;
            this.L$0 = compositionContinuationMutex;
            this.L$1 = transitionState2;
            this.label = 1;
            if (compositionContinuationMutex.lock(null, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            interfaceC2108a = compositionContinuationMutex;
            transitionState = transitionState2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            transitionState = (TransitionState) this.L$1;
            interfaceC2108a = (InterfaceC2108a) this.L$0;
            b.b(obj);
        }
        try {
            ((SeekableTransitionState) transitionState).setComposedTargetState$animation_core_release(transitionState.getTargetState());
            InterfaceC1717j compositionContinuation = ((SeekableTransitionState) transitionState).getCompositionContinuation();
            if (compositionContinuation != null) {
                compositionContinuation.resumeWith(transitionState.getTargetState());
            }
            ((SeekableTransitionState) transitionState).setCompositionContinuation$animation_core_release(null);
            interfaceC2108a.unlock(null);
            return r.f317a;
        } catch (Throwable th) {
            interfaceC2108a.unlock(null);
            throw th;
        }
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((TransitionKt$rememberTransition$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
