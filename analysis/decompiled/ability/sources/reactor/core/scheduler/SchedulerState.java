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

/* loaded from: classes4.dex */
final class SchedulerState<T> {
    final T currentResource;

    @Nullable
    final T initialResource;
    final Mono<Void> onDispose;

    public interface DisposeAwaiter<T> {
        boolean await(T t9, long j5, TimeUnit timeUnit) throws InterruptedException;
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

        public DisposeAwaiterRunnable(DisposeAwaiter<T> disposeAwaiter, T t9, FluxSink<Void> fluxSink, int i) {
            this.awaiter = disposeAwaiter;
            this.initial = t9;
            this.sink = fluxSink;
            this.awaitMs = i;
            fluxSink.onCancel(new Disposable() { // from class: reactor.core.scheduler.l
                @Override // reactor.core.Disposable
                public final void dispose() {
                    this.f5952a.cancel();
                }
            });
        }

        public static <R> void awaitInPool(DisposeAwaiter<R> disposeAwaiter, R r5, FluxSink<Void> fluxSink, int i) {
            TRANSITION_AWAIT_POOL.submit(new DisposeAwaiterRunnable(disposeAwaiter, r5, fluxSink, i));
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

    private SchedulerState(@Nullable T t9, T t10, Mono<Void> mono) {
        this.initialResource = t9;
        this.currentResource = t10;
        this.onDispose = mono;
    }

    public static <T> SchedulerState<T> init(T t9) {
        return new SchedulerState<>(t9, t9, Mono.empty());
    }

    public static <T> SchedulerState<T> transition(@Nullable final T t9, T t10, final DisposeAwaiter<T> disposeAwaiter) {
        return new SchedulerState<>(t9, t10, t9 == null ? Mono.empty() : Flux.create(new Consumer() { // from class: reactor.core.scheduler.k
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SchedulerState.DisposeAwaiterRunnable.awaitInPool(disposeAwaiter, t9, (FluxSink) obj, 100);
            }
        }).replay().refCount().next());
    }
}
