package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DelayKt {
    public static final Object delay(long j10, b<? super n> bVar) {
        if (j10 <= 0) {
            return n.f10413a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        if (j10 < Long.MAX_VALUE) {
            getDelay(cancellableContinuationImpl.getContext()).scheduleResumeAfterDelay(j10, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.f10059a ? result : n.f10413a;
    }

    public static final Delay getDelay(d dVar) {
        d.a aVar = dVar.get(c.a.f10058a);
        Delay delay = aVar instanceof Delay ? (Delay) aVar : null;
        return delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
    }
}
