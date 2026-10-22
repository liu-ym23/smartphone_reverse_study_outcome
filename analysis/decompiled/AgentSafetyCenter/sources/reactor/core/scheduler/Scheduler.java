package reactor.core.scheduler;

import java.lang.invoke.VarHandle;
import java.util.concurrent.TimeUnit;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public interface Scheduler extends Disposable {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Worker extends Disposable {
        Disposable schedule(Runnable runnable);

        default Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            throw Exceptions.failWithRejectedNotTimeCapable();
        }

        default Disposable schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            throw Exceptions.failWithRejectedNotTimeCapable();
        }
    }

    Worker createWorker();

    default Mono<Void> disposeGracefully() {
        c cVar = new c(1);
        cVar.f10894f = this;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(cVar);
    }

    default void init() {
        start();
    }

    default long now(TimeUnit timeUnit) {
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        return timeUnit.compareTo(timeUnit2) >= 0 ? timeUnit.convert(System.currentTimeMillis(), timeUnit2) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    Disposable schedule(Runnable runnable);

    default Disposable schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        throw Exceptions.failWithRejectedNotTimeCapable();
    }

    default Disposable schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        throw Exceptions.failWithRejectedNotTimeCapable();
    }

    @Override // reactor.core.Disposable
    default void dispose() {
    }

    @Deprecated
    default void start() {
    }
}
