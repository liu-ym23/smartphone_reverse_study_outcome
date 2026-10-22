package reactor.core.publisher;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxOnBackpressureBuffer<O> extends InternalFluxOperator<O, O> implements Fuseable {
    final int bufferSize;
    final Consumer<? super O> onOverflow;
    final boolean unbounded;

    public static final class BackpressureBufferSubscriber<T> implements Fuseable.QueueSubscription<T>, InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        volatile boolean cancelled;
        final int capacityOrSkip;
        final Context ctx;
        volatile int discardGuard;
        volatile boolean done;
        volatile boolean enabledFusion;
        Throwable error;
        final Consumer<? super T> onOverflow;
        final Queue<T> queue;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39536s;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<BackpressureBufferSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(BackpressureBufferSubscriber.class, "wip");
        static final AtomicIntegerFieldUpdater<BackpressureBufferSubscriber> DISCARD_GUARD = AtomicIntegerFieldUpdater.newUpdater(BackpressureBufferSubscriber.class, "discardGuard");
        static final AtomicLongFieldUpdater<BackpressureBufferSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(BackpressureBufferSubscriber.class, "requested");

        public BackpressureBufferSubscriber(CoreSubscriber<? super T> coreSubscriber, int i10, boolean z10, @Nullable Consumer<? super T> consumer) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.onOverflow = consumer;
            Queue<T> queue = z10 ? (Queue) Queues.unbounded(i10).get() : (Queue) Queues.get(i10).get();
            if (z10 || Queues.capacity(queue) <= i10) {
                this.capacityOrSkip = Integer.MAX_VALUE;
            } else {
                this.capacityOrSkip = i10;
            }
            this.queue = queue;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f39536s.cancel();
            if (WIP.getAndIncrement(this) != 0 || this.enabledFusion) {
                return;
            }
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
        }

        public boolean checkTerminated(boolean z10, boolean z11, qc.c<? super T> cVar, @Nullable T t10) {
            if (this.cancelled) {
                this.f39536s.cancel();
                Operators.onDiscard(t10, this.ctx);
                Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
                return true;
            }
            if (!z10 || !z11) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
            return true;
        }

        @Override // java.util.Collection
        public void clear() {
            if (DISCARD_GUARD.getAndIncrement(this) != 0) {
                return;
            }
            int iAddAndGet = 1;
            while (true) {
                Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
                int i10 = this.discardGuard;
                if (iAddAndGet == i10) {
                    iAddAndGet = DISCARD_GUARD.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i10;
                }
            }
        }

        public void drain(@Nullable T t10) {
            if (WIP.getAndIncrement(this) != 0) {
                if (t10 == null || !this.cancelled) {
                    return;
                }
                Operators.onDiscard(t10, this.actual.currentContext());
                return;
            }
            int iAddAndGet = 1;
            do {
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                if (coreSubscriber != null) {
                    if (this.enabledFusion) {
                        drainFused(coreSubscriber);
                        return;
                    } else {
                        drainRegular(coreSubscriber);
                        return;
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void drainFused(qc.c<? super T> cVar) {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                cVar.onNext(null);
                if (z10) {
                    Throwable th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainRegular(qc.c<? super T> cVar) {
            Queue<T> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested;
                long j11 = 0;
                while (j10 != j11) {
                    boolean z10 = this.done;
                    T tPoll = queue.poll();
                    boolean z11 = tPoll == 0;
                    if (checkTerminated(z10, z11, cVar, tPoll)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    cVar.onNext(tPoll);
                    j11++;
                }
                if (j10 == j11 && checkTerminated(this.done, queue.isEmpty(), cVar, null)) {
                    return;
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -j11);
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain(null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.error = th;
            this.done = true;
            drain(null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            if (this.cancelled) {
                Operators.onDiscard(t10, this.ctx);
            }
            if ((this.capacityOrSkip == Integer.MAX_VALUE || this.queue.size() < this.capacityOrSkip) && this.queue.offer(t10)) {
                drain(t10);
                return;
            }
            Throwable thOnOperatorError = Operators.onOperatorError(this.f39536s, Exceptions.failWithOverflow(), t10, this.ctx);
            Consumer<? super T> consumer = this.onOverflow;
            if (consumer != null) {
                try {
                    consumer.accept(t10);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    thOnOperatorError.initCause(th);
                }
            }
            Operators.onDiscard(t10, this.ctx);
            onError(thOnOperatorError);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39536s, dVar)) {
                this.f39536s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return this.queue.poll();
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain(null);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.enabledFusion = true;
            return 2;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39536s;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done && this.queue.isEmpty());
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue.size());
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            if (attr == Scannable.Attr.DELAY_ERROR) {
                return Boolean.TRUE;
            }
            if (attr != Scannable.Attr.CAPACITY) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            int iCapacity = this.capacityOrSkip;
            if (iCapacity == Integer.MAX_VALUE) {
                iCapacity = Queues.capacity(this.queue);
            }
            return Integer.valueOf(iCapacity);
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }
    }

    public FluxOnBackpressureBuffer(Flux<? extends O> flux, int i10, boolean z10, @Nullable Consumer<? super O> consumer) {
        super(flux);
        if (i10 < 1) {
            throw new IllegalArgumentException("Buffer Size must be strictly positive");
        }
        this.bufferSize = i10;
        this.unbounded = z10;
        this.onOverflow = consumer;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super O> subscribeOrReturn(CoreSubscriber<? super O> coreSubscriber) {
        return new BackpressureBufferSubscriber(coreSubscriber, this.bufferSize, this.unbounded, this.onOverflow);
    }
}
