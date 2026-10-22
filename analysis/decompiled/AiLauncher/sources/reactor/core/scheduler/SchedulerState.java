package reactor.core.scheduler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.SchedulerState;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class SchedulerState<T> {
    final T currentResource;

    @Nullable
    final T initialResource;
    final Mono<Void> onDispose;

    public interface DisposeAwaiter<T> {
        boolean await(T t10, long j10, TimeUnit timeUnit) throws InterruptedException;
    }

    public static class DisposeAwaiterRunnable<T> implements Runnable {
        static final ScheduledExecutorService TRANSITION_AWAIT_POOL;
        private final int awaitMs;
        private final DisposeAwaiter<T> awaiter;
        volatile boolean cancelled;
        private final T initial;
        private final FluxSink<Void> sink;

        static {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0);
            scheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.SECONDS);
            scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
            scheduledThreadPoolExecutor.setMaximumPoolSize(Schedulers.DEFAULT_POOL_SIZE);
            TRANSITION_AWAIT_POOL = scheduledThreadPoolExecutor;
        }

        public DisposeAwaiterRunnable(DisposeAwaiter<T> disposeAwaiter, T t10, FluxSink<Void> fluxSink, int i10) {
            this.awaiter = disposeAwaiter;
            this.initial = t10;
            this.sink = fluxSink;
            this.awaitMs = i10;
            fluxSink.onCancel(new Disposable() { // from class: reactor.core.scheduler.u
                @Override // reactor.core.Disposable
                public final void dispose() {
                    this.f39843a.cancel();
                }
            });
        }

        public static <R> void awaitInPool(DisposeAwaiter<R> disposeAwaiter, R r10, FluxSink<Void> fluxSink, int i10) {
            TRANSITION_AWAIT_POOL.submit(new DisposeAwaiterRunnable(disposeAwaiter, r10, fluxSink, i10));
        }

        public void cancel() {
            this.cancelled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                return;
            }
            try {
                if (this.awaiter.await(this.initial, this.awaitMs, TimeUnit.MILLISECONDS)) {
                    this.sink.complete();
                } else {
                    if (this.cancelled) {
                        return;
                    }
                    TRANSITION_AWAIT_POOL.submit(this);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    private SchedulerState(@Nullable T t10, T t11, Mono<Void> mono) {
        this.initialResource = t10;
        this.currentResource = t11;
        this.onDispose = mono;
    }

    public static <T> SchedulerState<T> init(T t10) {
        return new SchedulerState<>(t10, t10, Mono.empty());
    }

    public static <T> SchedulerState<T> transition(@Nullable final T t10, T t11, final DisposeAwaiter<T> disposeAwaiter) {
        return new SchedulerState<>(t10, t11, t10 == null ? Mono.empty() : Flux.create(new Consumer() { // from class: reactor.core.scheduler.t
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SchedulerState.DisposeAwaiterRunnable.awaitInPool(disposeAwaiter, t10, (FluxSink) obj, 100);
            }
        }).replay().refCount().next());
    }
}
