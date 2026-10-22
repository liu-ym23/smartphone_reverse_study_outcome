package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

@Deprecated
/* loaded from: classes4.dex */
public final class UnicastProcessor<T> extends FluxProcessor<T, T> implements Fuseable.QueueSubscription<T>, Fuseable, InnerOperator<T, T>, InternalManySink<T> {
    volatile CoreSubscriber<? super T> actual;
    volatile boolean cancelled;
    volatile int discardGuard;
    volatile boolean done;
    Throwable error;
    boolean hasDownstream;
    final Consumer<? super T> onOverflow;
    volatile Disposable onTerminate;
    volatile int once;
    boolean outputFused;
    final Queue<T> queue;
    volatile long requested;
    volatile int wip;
    static final AtomicReferenceFieldUpdater<UnicastProcessor, Disposable> ON_TERMINATE = AtomicReferenceFieldUpdater.newUpdater(UnicastProcessor.class, Disposable.class, "onTerminate");
    static final AtomicIntegerFieldUpdater<UnicastProcessor> ONCE = AtomicIntegerFieldUpdater.newUpdater(UnicastProcessor.class, "once");
    static final AtomicIntegerFieldUpdater<UnicastProcessor> WIP = AtomicIntegerFieldUpdater.newUpdater(UnicastProcessor.class, "wip");
    static final AtomicIntegerFieldUpdater<UnicastProcessor> DISCARD_GUARD = AtomicIntegerFieldUpdater.newUpdater(UnicastProcessor.class, "discardGuard");
    static final AtomicLongFieldUpdater<UnicastProcessor> REQUESTED = AtomicLongFieldUpdater.newUpdater(UnicastProcessor.class, "requested");

    /* renamed from: reactor.core.publisher.UnicastProcessor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$Sinks$EmitResult;

        static {
            int[] iArr = new int[Sinks.EmitResult.values().length];
            $SwitchMap$reactor$core$publisher$Sinks$EmitResult = iArr;
            try {
                iArr[Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$Sinks$EmitResult[Sinks.EmitResult.FAIL_OVERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public UnicastProcessor(Queue<T> queue) {
        Objects.requireNonNull(queue, "queue");
        this.queue = queue;
        this.onTerminate = null;
        this.onOverflow = null;
    }

    @Deprecated
    public static <E> UnicastProcessor<E> create() {
        return new UnicastProcessor<>((Queue) Queues.unbounded().get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$emitNext$0(Sinks.EmitFailureHandler emitFailureHandler, Object obj, SignalType signalType, Sinks.EmitResult emitResult) {
        int i;
        boolean zOnEmitFailure = emitFailureHandler.onEmitFailure(SignalType.ON_NEXT, emitResult);
        if (!zOnEmitFailure && ((i = AnonymousClass1.$SwitchMap$reactor$core$publisher$Sinks$EmitResult[emitResult.ordinal()]) == 1 || i == 2)) {
            try {
                this.onOverflow.accept(obj);
                return zOnEmitFailure;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                emitError(th, Sinks.EmitFailureHandler.FAIL_FAST);
            }
        }
        return zOnEmitFailure;
    }

    @Override // reactor.core.publisher.InnerProducer
    public CoreSubscriber<? super T> actual() {
        return this.actual;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Flux<T> asFlux() {
        return this;
    }

    @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
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

    public boolean checkTerminated(boolean z10, boolean z11, CoreSubscriber<? super T> coreSubscriber, Queue<T> queue, @Nullable T t9) {
        if (this.cancelled) {
            Operators.onDiscard(t9, coreSubscriber.currentContext());
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
            int i = this.discardGuard;
            if (iAddAndGet == i) {
                iAddAndGet = DISCARD_GUARD.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                iAddAndGet = i;
            }
        }
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.CoreSubscriber
    public Context currentContext() {
        CoreSubscriber<? super T> coreSubscriber = this.actual;
        return coreSubscriber != null ? coreSubscriber.currentContext() : Context.empty();
    }

    @Override // reactor.core.publisher.Sinks.Many
    public int currentSubscriberCount() {
        return this.hasDownstream ? 1 : 0;
    }

    public void doTerminate() {
        Disposable disposable = this.onTerminate;
        if (disposable == null || !ON_TERMINATE.compareAndSet(this, disposable, null)) {
            return;
        }
        disposable.dispose();
    }

    @Override // reactor.core.publisher.FluxProcessor
    public long downstreamCount() {
        return hasDownstreams() ? 1L : 0L;
    }

    public void drain(@Nullable T t9) {
        if (WIP.getAndIncrement(this) != 0) {
            if (t9 != null) {
                if (this.cancelled) {
                    Operators.onDiscard(t9, this.actual.currentContext());
                    return;
                } else {
                    if (this.done) {
                        Operators.onNextDropped(t9, currentContext());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        int iAddAndGet = 1;
        do {
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            if (coreSubscriber != null) {
                if (this.outputFused) {
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
        UnicastProcessor<T> unicastProcessor;
        Queue<T> queue = this.queue;
        int iAddAndGet = 1;
        do {
            long j5 = this.requested;
            long j6 = 0;
            while (j5 != j6) {
                boolean z11 = this.done;
                T tPoll = queue.poll();
                if (tPoll == null) {
                    z10 = true;
                    unicastProcessor = this;
                    coreSubscriber2 = coreSubscriber;
                } else {
                    z10 = false;
                    coreSubscriber2 = coreSubscriber;
                    unicastProcessor = this;
                }
                if (unicastProcessor.checkTerminated(z11, z10, coreSubscriber2, queue, tPoll)) {
                    return;
                }
                if (z10) {
                    break;
                }
                coreSubscriber.onNext(tPoll);
                j6++;
            }
            if (j5 == j6 && checkTerminated(this.done, queue.isEmpty(), coreSubscriber, queue, null)) {
                return;
            }
            if (j6 != 0 && j5 != Long.MAX_VALUE) {
                REQUESTED.addAndGet(this, -j6);
            }
            iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // reactor.core.publisher.InternalManySink, reactor.core.publisher.Sinks.Many
    public void emitNext(final T t9, final Sinks.EmitFailureHandler emitFailureHandler) {
        if (this.onOverflow == null) {
            super.emitNext(t9, emitFailureHandler);
        } else {
            super.emitNext(t9, new Sinks.EmitFailureHandler() { // from class: reactor.core.publisher.p0
                @Override // reactor.core.publisher.Sinks.EmitFailureHandler
                public final boolean onEmitFailure(SignalType signalType, Sinks.EmitResult emitResult) {
                    return this.f5931a.lambda$emitNext$0(emitFailureHandler, t9, signalType, emitResult);
                }
            });
        }
    }

    @Override // reactor.core.publisher.FluxProcessor
    public int getBufferSize() {
        return Queues.capacity(this.queue);
    }

    @Override // reactor.core.publisher.FluxProcessor
    @Nullable
    public Throwable getError() {
        return this.error;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean hasDownstreams() {
        return this.hasDownstream;
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.Scannable
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

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isIdentityProcessor() {
        return true;
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isTerminated() {
        return this.done;
    }

    @Override // reactor.core.publisher.FluxProcessor, Z9.d
    public void onComplete() {
        tryEmitComplete();
    }

    @Override // reactor.core.publisher.FluxProcessor, Z9.d
    public void onError(Throwable th) {
        emitError(th, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override // reactor.core.publisher.FluxProcessor, Z9.d
    public void onNext(T t9) {
        emitNext(t9, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override // Z9.d
    public void onSubscribe(Z9.e eVar) {
        if (this.done || this.cancelled) {
            eVar.cancel();
        } else {
            eVar.request(Long.MAX_VALUE);
        }
    }

    @Override // java.util.Queue
    @Nullable
    public T poll() {
        return this.queue.poll();
    }

    @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
    public void request(long j5) {
        if (Operators.validate(j5)) {
            Operators.addCap(REQUESTED, this, j5);
            drain(null);
        }
    }

    @Override // reactor.core.Fuseable.QueueSubscription
    public int requestFusion(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (Scannable.Attr.ACTUAL == attr) {
            return actual();
        }
        if (Scannable.Attr.BUFFERED == attr) {
            return Integer.valueOf(this.queue.size());
        }
        if (Scannable.Attr.PREFETCH == attr) {
            return Integer.MAX_VALUE;
        }
        return Scannable.Attr.CANCELLED == attr ? Boolean.valueOf(this.cancelled) : super.scanUnsafe(attr);
    }

    @Override // java.util.Collection
    public int size() {
        return this.queue.size();
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "subscribe");
        if (this.once != 0 || !ONCE.compareAndSet(this, 0, 1)) {
            Operators.error(coreSubscriber, new IllegalStateException("UnicastProcessor allows only a single Subscriber"));
            return;
        }
        this.hasDownstream = true;
        coreSubscriber.onSubscribe(this);
        this.actual = coreSubscriber;
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
    public Sinks.EmitResult tryEmitNext(T t9) {
        if (this.done) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        if (this.cancelled) {
            return Sinks.EmitResult.FAIL_CANCELLED;
        }
        if (!this.queue.offer(t9)) {
            return this.once > 0 ? Sinks.EmitResult.FAIL_OVERFLOW : Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER;
        }
        drain(t9);
        return Sinks.EmitResult.OK;
    }

    @Deprecated
    public static <E> UnicastProcessor<E> create(Queue<E> queue) {
        return new UnicastProcessor<>(Hooks.wrapQueue(queue));
    }

    @Deprecated
    public static <E> UnicastProcessor<E> create(Queue<E> queue, Disposable disposable) {
        return new UnicastProcessor<>(Hooks.wrapQueue(queue), disposable);
    }

    @Deprecated
    public static <E> UnicastProcessor<E> create(Queue<E> queue, Consumer<? super E> consumer, Disposable disposable) {
        return new UnicastProcessor<>(Hooks.wrapQueue(queue), consumer, disposable);
    }

    public UnicastProcessor(Queue<T> queue, Disposable disposable) {
        Objects.requireNonNull(queue, "queue");
        this.queue = queue;
        Objects.requireNonNull(disposable, "onTerminate");
        this.onTerminate = disposable;
        this.onOverflow = null;
    }

    @Deprecated
    public UnicastProcessor(Queue<T> queue, Consumer<? super T> consumer, Disposable disposable) {
        Objects.requireNonNull(queue, "queue");
        this.queue = queue;
        Objects.requireNonNull(consumer, "onOverflow");
        this.onOverflow = consumer;
        Objects.requireNonNull(disposable, "onTerminate");
        this.onTerminate = disposable;
    }
}
