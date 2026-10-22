package androidx.compose.runtime;

import C7.r;
import S7.n;
import androidx.compose.runtime.MonotonicFrameClock;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/FallbackFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", AppAgent.CONSTRUCT, "()V", "R", "Lkotlin/Function1;", "", "onFrame", "withFrameNanos", "(LS7/k;LH7/c;)Ljava/lang/Object;", "DefaultFrameDelay", "J", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class FallbackFrameClock implements MonotonicFrameClock {
    private static final long DefaultFrameDelay = 16;
    public static final FallbackFrameClock INSTANCE = new FallbackFrameClock();

    @J7.c(c = "androidx.compose.runtime.FallbackFrameClock$withFrameNanos$2", f = "MonotonicFrameClock.android.kt", l = {40}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.runtime.FallbackFrameClock$withFrameNanos$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ S7.k $onFrame;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(S7.k kVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$onFrame = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$onFrame, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                this.label = 1;
                if (kotlinx.coroutines.a.f(16L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return this.$onFrame.invoke(new Long(System.nanoTime()));
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private FallbackFrameClock() {
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public <R> R fold(R r5, n nVar) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r5, nVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public <E extends H7.f> E get(H7.g gVar) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, gVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public H7.h minusKey(H7.g gVar) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, gVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, H7.h
    public H7.h plus(H7.h hVar) {
        return MonotonicFrameClock.DefaultImpls.plus(this, hVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(S7.k kVar, H7.c<? super R> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(s9.k.f6003a, new AnonymousClass2(kVar, null), cVar);
    }
}
