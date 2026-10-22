package androidx.compose.runtime;

import C7.r;
import S7.n;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1718k;
import m9.InterfaceC1717j;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/DefaultChoreographerFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", AppAgent.CONSTRUCT, "()V", "R", "Lkotlin/Function1;", "", "onFrame", "withFrameNanos", "(LS7/k;LH7/c;)Ljava/lang/Object;", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "choreographer", "Landroid/view/Choreographer;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultChoreographerFrameClock implements MonotonicFrameClock {
    public static final DefaultChoreographerFrameClock INSTANCE = new DefaultChoreographerFrameClock();
    private static final Choreographer choreographer;

    static {
        u9.d dVar = AbstractC1691I.f5315a;
        choreographer = (Choreographer) AbstractC1683A.r(s9.k.f6003a.d, new DefaultChoreographerFrameClock$choreographer$1(null));
    }

    private DefaultChoreographerFrameClock() {
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
    public <R> Object withFrameNanos(final S7.k kVar, H7.c<? super R> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        final Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: androidx.compose.runtime.DefaultChoreographerFrameClock$withFrameNanos$2$callback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j5) {
                Object objA;
                InterfaceC1717j interfaceC1717j = c1718k;
                DefaultChoreographerFrameClock defaultChoreographerFrameClock = DefaultChoreographerFrameClock.INSTANCE;
                try {
                    objA = kVar.invoke(Long.valueOf(j5));
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                interfaceC1717j.resumeWith(objA);
            }
        };
        choreographer.postFrameCallback(frameCallback);
        c1718k.j(new S7.k() { // from class: androidx.compose.runtime.DefaultChoreographerFrameClock$withFrameNanos$2$1
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                DefaultChoreographerFrameClock.choreographer.removeFrameCallback(frameCallback);
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }
}
