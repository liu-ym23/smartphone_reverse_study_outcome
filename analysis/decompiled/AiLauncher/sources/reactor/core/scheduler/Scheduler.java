package reactor.core.scheduler;

import java.util.concurrent.TimeUnit;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

/* loaded from: classes5.dex */
public interface Scheduler extends Disposable {

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

    @Override // reactor.core.Disposable
    default void dispose() {
    }

    default Mono<Void> disposeGracefully() {
        return Mono.fromRunnable(new Runnable() { // from class: reactor.core.scheduler.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f39836a.dispose();
            }
        });
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

    @Deprecated
    default void start() {
    }
}
