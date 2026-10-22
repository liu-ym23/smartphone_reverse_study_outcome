package reactor.core.scheduler;

import java.util.concurrent.TimeUnit;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface Scheduler extends Disposable {

    public interface Worker extends Disposable {
        Disposable schedule(Runnable runnable);

        default Disposable schedule(Runnable runnable, long j5, TimeUnit timeUnit) {
            throw Exceptions.failWithRejectedNotTimeCapable();
        }

        default Disposable schedulePeriodically(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
            throw Exceptions.failWithRejectedNotTimeCapable();
        }
    }

    Worker createWorker();

    @Override // reactor.core.Disposable
    default void dispose() {
    }

    default Mono<Void> disposeGracefully() {
        return Mono.fromRunnable(new c(this, 1));
    }

    default void init() {
        start();
    }

    default long now(TimeUnit timeUnit) {
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        return timeUnit.compareTo(timeUnit2) >= 0 ? timeUnit.convert(System.currentTimeMillis(), timeUnit2) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    Disposable schedule(Runnable runnable);

    default Disposable schedule(Runnable runnable, long j5, TimeUnit timeUnit) {
        throw Exceptions.failWithRejectedNotTimeCapable();
    }

    default Disposable schedulePeriodically(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        throw Exceptions.failWithRejectedNotTimeCapable();
    }

    @Deprecated
    default void start() {
    }
}
