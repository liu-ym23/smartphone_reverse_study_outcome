package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class SinkManyUnicast<T> extends Flux<T> implements InternalManySink<T>, Disposable, Fuseable.QueueSubscription<T>, Fuseable {
    volatile CoreSubscriber<? super T> actual;
    volatile boolean cancelled;
    volatile int discardGuard;
    volatile boolean done;
    Throwable error;
    boolean hasDownstream;
    volatile Disposable onTerminate;
    volatile int once;
    boolean outputFused;
    final Queue<T> queue;
    volatile long requested;
    volatile boolean subscriptionDelivered;
    volatile int wip;
    static final AtomicReferenceFieldUpdater<SinkManyUnicast, Disposable> ON_TERMINATE = AtomicReferenceFieldUpdater.newUpdater(SinkManyUnicast.class, Disposable.class, "onTerminate");
    static final AtomicIntegerFieldUpdater<SinkManyUnicast> ONCE = AtomicIntegerFieldUpdater.newUpdater(SinkManyUnicast.class, "once");
    static final AtomicIntegerFieldUpdater<SinkManyUnicast> WIP = AtomicIntegerFieldUpdater.newUpdater(SinkManyUnicast.class, "wip");
    static final AtomicIntegerFieldUpdater<SinkManyUnicast> DISCARD_GUARD = AtomicIntegerFieldUpdater.newUpdater(SinkManyUnicast.class, "discardGuard");
    static final AtomicLongFieldUpdater<SinkManyUnicast> REQUESTED = AtomicLongFieldUpdater.newUpdater(SinkManyUnicast.class, "requested");

    public SinkManyUnicast(Queue<T> queue) {
        Objects.requireNonNull(queue, "queue");
        this.queue = queue;
        this.onTerminate = null;
    }

    public static <E> SinkManyUnicast<E> create() {
        return new SinkManyUnicast<>((Queue) Queues.unbounded().get());
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Flux<T> asFlux() {
        return this;
    }

    @Override // reactor.core.Fuseable.QueueSubscription, qc.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        doTerminate();
        if (WIP.getAndIncrement(this) == 0) {
            if (!this.outputFused) {
                Operators.onDiscardQueueWithClear(this.queue, currentContext(), null);
            }
            this.hasDownstream = false;
        }
    }

    public boolean checkTerminated(boolean z10, boolean z11, CoreSubscriber<? super T> coreSubscriber, Queue<T> queue, @Nullable T t10) {
        if (this.cancelled) {
            Operators.onDiscard(t10, coreSubscriber.currentContext());
            Operators.onDiscardQueueWithClear(queue, coreSubscriber.currentContext(), null);
            this.hasDownstream = false;
            return true;
        }
        if (!z10 || !z11) {
            return false;
        }
        Throwable th = this.error;
        this.hasDownstream = false;
        if (th != null) {
            coreSubscriber.onError(th);
        } else {
            coreSubscriber.onComplete();
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
            Operators.onDiscardQueueWithClear(this.queue, currentContext(), null);
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

    @Override // reactor.core.publisher.ContextHolder
    public Context currentContext() {
        CoreSubscriber<? super T> coreSubscriber = this.actual;
        return coreSubscriber != null ? coreSubscriber.currentContext() : Context.empty();
    }

    @Override // reactor.core.publisher.Sinks.Many
    public int currentSubscriberCount() {
        return this.hasDownstream ? 1 : 0;
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        emitError(new CancellationException("Disposed"), Sinks.EmitFailureHandler.FAIL_FAST);
    }

    public void doTerminate() {
        Disposable disposable = this.onTerminate;
        if (disposable == null || !ON_TERMINATE.compareAndSet(this, disposable, null)) {
            return;
        }
        disposable.dispose();
    }

    public void drain(@Nullable T t10) {
        if (WIP.getAndIncrement(this) != 0) {
            if (t10 != null) {
                if (this.cancelled) {
                    Operators.onDiscard(t10, this.actual.currentContext());
                    return;
                } else {
                    if (this.done) {
                        Operators.onNextDropped(t10, currentContext());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        int iAddAndGet = 1;
        while (!this.subscriptionDelivered) {
            iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        CoreSubscriber<? super T> coreSubscriber = this.actual;
        if (this.outputFused) {
            drainFused(coreSubscriber);
        } else {
            drainRegular(coreSubscriber);
        }
    }

    public void drainFused(CoreSubscriber<? super T> coreSubscriber) {
        int iAddAndGet = 1;
        while (!this.cancelled) {
            boolean z10 = this.done;
            coreSubscriber.onNext(null);
            if (z10) {
                this.hasDownstream = false;
                Throwable th = this.error;
                if (th != null) {
                    coreSubscriber.onError(th);
                    return;
                } else {
                    coreSubscriber.onComplete();
                    return;
                }
            }
            iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        clear();
        this.hasDownstream = false;
    }

    public void drainRegular(CoreSubscriber<? super T> coreSubscriber) {
        boolean z10;
        CoreSubscriber<? super T> coreSubscriber2;
        SinkManyUnicast<T> sinkManyUnicast;
        Queue<T> queue = this.queue;
        int iAddAndGet = 1;
        do {
            long j10 = this.requested;
            long j11 = 0;
            while (j10 != j11) {
                boolean z11 = this.done;
                T tPoll = queue.poll();
                if (tPoll == null) {
                    z10 = true;
                    sinkManyUnicast = this;
                    coreSubscriber2 = coreSubscriber;
                } else {
                    z10 = false;
                    coreSubscriber2 = coreSubscriber;
                    sinkManyUnicast = this;
                }
                if (sinkManyUnicast.checkTerminated(z11, z10, coreSubscriber2, queue, tPoll)) {
                    return;
                }
                if (z10) {
                    break;
                }
                coreSubscriber.onNext(tPoll);
                j11++;
            }
            if (j10 == j11 && checkTerminated(this.done, queue.isEmpty(), coreSubscriber, queue, null)) {
                return;
            }
            if (j11 != 0 && j10 != Long.MAX_VALUE) {
                REQUESTED.addAndGet(this, -j11);
            }
            iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.Scannable
    public Stream<Scannable> inners() {
        return this.hasDownstream ? Stream.of(Scannable.from(this.actual)) : Stream.empty();
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.cancelled || this.done;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.queue.isEmpty();
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
        this.outputFused = true;
        return 2;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (Scannable.Attr.ACTUAL == attr) {
            return this.actual;
        }
        if (Scannable.Attr.BUFFERED == attr) {
            return Integer.valueOf(this.queue.size());
        }
        if (Scannable.Attr.CAPACITY == attr) {
            return Integer.valueOf(Queues.capacity(this.queue));
        }
        if (Scannable.Attr.PREFETCH == attr) {
            return Integer.MAX_VALUE;
        }
        if (Scannable.Attr.CANCELLED == attr) {
            return Boolean.valueOf(this.cancelled);
        }
        if (Scannable.Attr.TERMINATED == attr) {
            return Boolean.valueOf(this.done);
        }
        if (Scannable.Attr.ERROR == attr) {
            return this.error;
        }
        if (InternalProducerAttr.INSTANCE == attr) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // java.util.Collection
    public int size() {
        return this.queue.size();
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "subscribe");
        CoreSubscriber<? super T> coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled = Operators.restoreContextOnSubscriberIfAutoCPEnabled(this, coreSubscriber);
        if (this.once != 0 || !ONCE.compareAndSet(this, 0, 1)) {
            Operators.error(coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled, new IllegalStateException("Sinks.many().unicast() sinks only allow a single Subscriber"));
            return;
        }
        this.hasDownstream = true;
        this.actual = coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled;
        coreSubscriberRestoreContextOnSubscriberIfAutoCPEnabled.onSubscribe(this);
        this.subscriptionDelivered = true;
        if (this.cancelled) {
            this.hasDownstream = false;
        } else {
            drain(null);
        }
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitComplete() {
        if (this.done) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        if (this.cancelled) {
            return Sinks.EmitResult.FAIL_CANCELLED;
        }
        this.done = true;
        doTerminate();
        drain(null);
        return Sinks.EmitResult.OK;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitError(Throwable th) {
        if (this.done) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        if (this.cancelled) {
            return Sinks.EmitResult.FAIL_CANCELLED;
        }
        this.error = th;
        this.done = true;
        doTerminate();
        drain(null);
        return Sinks.EmitResult.OK;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitNext(T t10) {
        if (this.done) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        if (this.cancelled) {
            return Sinks.EmitResult.FAIL_CANCELLED;
        }
        if (!this.queue.offer(t10)) {
            return this.once > 0 ? Sinks.EmitResult.FAIL_OVERFLOW : Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER;
        }
        drain(t10);
        return Sinks.EmitResult.OK;
    }

    public static <E> SinkManyUnicast<E> create(Queue<E> queue) {
        return new SinkManyUnicast<>(Hooks.wrapQueue(queue));
    }

    public static <E> SinkManyUnicast<E> create(Queue<E> queue, Disposable disposable) {
        return new SinkManyUnicast<>(Hooks.wrapQueue(queue), disposable);
    }

    public SinkManyUnicast(Queue<T> queue, Disposable disposable) {
        Objects.requireNonNull(queue, "queue");
        this.queue = queue;
        Objects.requireNonNull(disposable, "onTerminate");
        this.onTerminate = disposable;
    }
}
