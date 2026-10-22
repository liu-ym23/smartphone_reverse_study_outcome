package kotlinx.coroutines;

import kotlin.coroutines.d;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface Delay {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static DisposableHandle invokeOnTimeout(Delay delay, long j10, Runnable runnable, d dVar) {
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(j10, runnable, dVar);
        }
    }

    DisposableHandle invokeOnTimeout(long j10, Runnable runnable, d dVar);

    void scheduleResumeAfterDelay(long j10, CancellableContinuation<? super n> cancellableContinuation);
}
