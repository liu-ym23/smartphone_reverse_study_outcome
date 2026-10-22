package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxOnBackpressureBufferTimeout<O> extends InternalFluxOperator<O, O> {
    private static final Logger LOGGER = Loggers.getLogger((Class<?>) FluxOnBackpressureBufferTimeout.class);
    final int bufferSize;
    final Consumer<? super O> onBufferEviction;
    final Duration ttl;
    final Scheduler ttlScheduler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class BackpressureBufferTimeoutSubscriber<T> extends ArrayDeque<Object> implements InnerOperator<T, T>, Runnable {
        final CoreSubscriber<? super T> actual;
        final int bufferSizeDouble;
        volatile boolean cancelled;
        final Context ctx;
        volatile boolean done;
        Throwable error;
        final Consumer<? super T> onBufferEviction;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10648s;
        final Duration ttl;
        final Scheduler ttlScheduler;
        volatile int wip;
        final Scheduler.Worker worker;
        static final AtomicIntegerFieldUpdater<BackpressureBufferTimeoutSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(BackpressureBufferTimeoutSubscriber.class, "wip");
        static final AtomicLongFieldUpdater<BackpressureBufferTimeoutSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BackpressureBufferTimeoutSubscriber.class, "requested");

        public BackpressureBufferTimeoutSubscriber(CoreSubscriber<? super T> coreSubscriber, Duration duration, Scheduler scheduler, int i, Consumer<? super T> consumer) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            Objects.requireNonNull(consumer, "buffer eviction callback must not be null");
            this.onBufferEviction = consumer;
            this.bufferSizeDouble = i << 1;
            this.ttl = duration;
            Objects.requireNonNull(scheduler, "ttl Scheduler must not be null");
            this.ttlScheduler = scheduler;
            this.worker = scheduler.createWorker();
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.cancelled = true;
            this.f10648s.cancel();
            this.worker.dispose();
            if (WIP.getAndIncrement(this) == 0) {
                clearQueue();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void clearQueue() {
            Object objPoll;
            while (true) {
                synchronized (this) {
                    try {
                        if (isEmpty()) {
                            return;
                        }
                        poll();
                        objPoll = poll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                evict(objPoll);
            }
        }

        public void drain() {
            boolean zIsEmpty;
            Object objPoll;
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                long j10 = this.requested;
                long j11 = 0;
                while (j11 != j10) {
                    if (this.cancelled) {
                        clearQueue();
                        return;
                    }
                    boolean z10 = this.done;
                    synchronized (this) {
                        try {
                            objPoll = poll() != null ? poll() : null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    boolean z11 = objPoll == null;
                    if (z10 && z11) {
                        Throwable th2 = this.error;
                        CoreSubscriber<? super T> coreSubscriber = this.actual;
                        if (th2 != null) {
                            coreSubscriber.onError(th2);
                        } else {
                            coreSubscriber.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    this.actual.onNext(objPoll);
                    j11++;
                }
                if (j11 == j10) {
                    if (this.cancelled) {
                        clearQueue();
                        return;
                    }
                    boolean z12 = this.done;
                    synchronized (this) {
                        zIsEmpty = isEmpty();
                    }
                    if (z12 && zIsEmpty) {
                        Throwable th3 = this.error;
                        CoreSubscriber<? super T> coreSubscriber2 = this.actual;
                        if (th3 != null) {
                            coreSubscriber2.onError(th3);
                        } else {
                            coreSubscriber2.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -j11);
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void evict(@Nullable T t10) {
            if (t10 != null) {
                try {
                    this.onBufferEviction.accept(t10);
                } catch (Throwable th) {
                    if (FluxOnBackpressureBufferTimeout.LOGGER.isDebugEnabled()) {
                        FluxOnBackpressureBufferTimeout.LOGGER.debug("value [{}] couldn't be evicted due to a callback error. This error will be dropped: {}", t10, th);
                    }
                    Operators.onErrorDropped(th, this.actual.currentContext());
                }
                Operators.onDiscard(t10, this.actual.currentContext());
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            Object objPoll;
            TimeUnit timeUnit;
            synchronized (this) {
                try {
                    if (size() == this.bufferSizeDouble) {
                        poll();
                        objPoll = poll();
                    } else {
                        objPoll = null;
                    }
                    Scheduler scheduler = this.ttlScheduler;
                    timeUnit = TimeUnit.NANOSECONDS;
                    offer(Long.valueOf(scheduler.now(timeUnit)));
                    offer(t10);
                } catch (Throwable th) {
                    throw th;
                }
            }
            evict(objPoll);
            try {
                this.worker.schedule(this, this.ttl.toNanos(), timeUnit);
            } catch (RejectedExecutionException e10) {
                this.done = true;
                this.error = Operators.onRejectedExecution(e10, this, null, t10, this.actual.currentContext());
            }
            drain();
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10648s, eVar)) {
                this.f10648s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object objPoll;
            while (!this.cancelled) {
                boolean z10 = this.done;
                synchronized (this) {
                    try {
                        Long l2 = (Long) peek();
                        boolean z11 = l2 == null;
                        if (z11) {
                            objPoll = null;
                        } else {
                            if (l2.longValue() > this.ttlScheduler.now(TimeUnit.NANOSECONDS) - this.ttl.toNanos()) {
                                return;
                            }
                            poll();
                            objPoll = poll();
                        }
                        evict(objPoll);
                        if (z11) {
                            if (z10) {
                                drain();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10648s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done && isEmpty());
            }
            return attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(size()) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(Reader.READ_DONE) : attr == Scannable.Attr.DELAY_ERROR ? Boolean.FALSE : attr == Scannable.Attr.RUN_ON ? this.ttlScheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }
    }

    public FluxOnBackpressureBufferTimeout(Flux<? extends O> flux, Duration duration, Scheduler scheduler, int i, Consumer<? super O> consumer) {
        super(flux);
        this.ttl = duration;
        this.ttlScheduler = scheduler;
        this.bufferSize = i;
        this.onBufferEviction = consumer;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Reader.READ_DONE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.ttlScheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super O> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber) {
        return new BackpressureBufferTimeoutSubscriber(coreSubscriber, this.ttl, this.ttlScheduler, this.bufferSize, this.onBufferEviction);
    }
}
