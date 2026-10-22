package reactor.core.scheduler;

import java.lang.invoke.VarHandle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class SchedulerState<T> {
    final T currentResource;

    @Nullable
    final T initialResource;
    final Mono<Void> onDispose;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface DisposeAwaiter<T> {
        boolean await(T t10, long j10, TimeUnit timeUnit);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        public DisposeAwaiterRunnable(DisposeAwaiter<T> disposeAwaiter, T t10, FluxSink<Void> fluxSink, int i) {
            this.awaiter = disposeAwaiter;
            this.initial = t10;
            this.sink = fluxSink;
            this.awaitMs = i;
            l lVar = new l();
            lVar.f10904c = this;
            VarHandle.storeStoreFence();
            fluxSink.onCancel(lVar);
        }

        public static <R> void awaitInPool(DisposeAwaiter<R> disposeAwaiter, R r10, FluxSink<Void> fluxSink, int i) {
            TRANSITION_AWAIT_POOL.submit(new DisposeAwaiterRunnable(disposeAwaiter, r10, fluxSink, i));
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

    public static <T> SchedulerState<T> transition(@Nullable T t10, T t11, DisposeAwaiter<T> disposeAwaiter) {
        Mono<T> next;
        if (t10 == null) {
            next = Mono.empty();
        } else {
            k kVar = new k();
            kVar.f10902c = disposeAwaiter;
            kVar.f10903f = t10;
            VarHandle.storeStoreFence();
            next = Flux.create(kVar).replay().refCount().next();
        }
        return new SchedulerState<>(t10, t11, next);
    }
}
