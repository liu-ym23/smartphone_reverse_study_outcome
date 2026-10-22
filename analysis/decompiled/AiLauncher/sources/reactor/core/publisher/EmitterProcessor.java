package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPublish;
import reactor.core.publisher.Sinks;
import reactor.util.annotation.Nullable;
import reactor.util.concurrent.Queues;
import reactor.util.context.Context;

@Deprecated
/* loaded from: classes5.dex */
public final class EmitterProcessor<T> extends FluxProcessor<T, T> implements InternalManySink<T>, Sinks.ManyWithUpstream<T> {
    final boolean autoCancel;
    volatile boolean done;
    volatile Throwable error;
    final int prefetch;
    volatile Queue<T> queue;

    /* renamed from: s, reason: collision with root package name */
    volatile qc.d f39465s;
    int sourceMode;
    volatile FluxPublish.PubSubInner<T>[] subscribers;
    volatile EmitterDisposable upstreamDisposable;
    volatile int wip;
    static final FluxPublish.PubSubInner[] EMPTY = new FluxPublish.PublishInner[0];

    /* renamed from: S, reason: collision with root package name */
    static final AtomicReferenceFieldUpdater<EmitterProcessor, qc.d> f39464S = AtomicReferenceFieldUpdater.newUpdater(EmitterProcessor.class, qc.d.class, "s");
    static final AtomicReferenceFieldUpdater<EmitterProcessor, FluxPublish.PubSubInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(EmitterProcessor.class, FluxPublish.PubSubInner[].class, "subscribers");
    static final AtomicReferenceFieldUpdater<EmitterProcessor, EmitterDisposable> UPSTREAM_DISPOSABLE = AtomicReferenceFieldUpdater.newUpdater(EmitterProcessor.class, EmitterDisposable.class, "upstreamDisposable");
    static final AtomicIntegerFieldUpdater<EmitterProcessor> WIP = AtomicIntegerFieldUpdater.newUpdater(EmitterProcessor.class, "wip");
    static final AtomicReferenceFieldUpdater<EmitterProcessor, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(EmitterProcessor.class, Throwable.class, "error");

    public static final class EmitterDisposable implements Disposable {

        @Nullable
        EmitterProcessor<?> target;

        public EmitterDisposable(EmitterProcessor<?> emitterProcessor) {
            this.target = emitterProcessor;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            EmitterProcessor<?> emitterProcessor = this.target;
            if (emitterProcessor == null) {
                return;
            }
            if (emitterProcessor.detach() || emitterProcessor.isDetached()) {
                this.target = null;
            }
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            EmitterProcessor<?> emitterProcessor = this.target;
            return emitterProcessor == null || emitterProcessor.isDetached();
        }
    }

    public static final class EmitterInner<T> extends FluxPublish.PubSubInner<T> {
        final EmitterProcessor<T> parent;

        public EmitterInner(CoreSubscriber<? super T> coreSubscriber, EmitterProcessor<T> emitterProcessor) {
            super(coreSubscriber);
            this.parent = emitterProcessor;
        }

        @Override // reactor.core.publisher.FluxPublish.PubSubInner
        public void drainParent() {
            this.parent.drain();
        }

        @Override // reactor.core.publisher.FluxPublish.PubSubInner
        public void removeAndDrainParent() {
            this.parent.remove(this);
            this.parent.drain();
        }
    }

    public EmitterProcessor(boolean z10, int i10) {
        if (i10 >= 1) {
            this.autoCancel = z10;
            this.prefetch = i10;
            SUBSCRIBERS.lazySet(this, EMPTY);
        } else {
            throw new IllegalArgumentException("bufferSize must be strictly positive, was: " + i10);
        }
    }

    @Deprecated
    public static <E> EmitterProcessor<E> create() {
        return create(Queues.SMALL_BUFFER_SIZE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean detach() {
        if (Operators.terminate(f39464S, this)) {
            this.done = true;
            CancellationException cancellationException = new CancellationException("the ManyWithUpstream sink had a Subscription to an upstream which has been manually cancelled");
            if (ERROR.compareAndSet(this, null, cancellationException)) {
                Queue<T> queue = this.queue;
                if (queue != null) {
                    queue.clear();
                }
                for (FluxPublish.PubSubInner<T> pubSubInner : terminate()) {
                    pubSubInner.actual.onError(cancellationException);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDetached() {
        return this.f39465s == Operators.cancelledSubscription() && this.done && (this.error instanceof CancellationException);
    }

    public final boolean add(EmitterInner<T> emitterInner) {
        FluxPublish.PubSubInner<T>[] pubSubInnerArr;
        FluxPublish.PubSubInner[] pubSubInnerArr2;
        do {
            pubSubInnerArr = this.subscribers;
            if (pubSubInnerArr == FluxPublish.PublishSubscriber.TERMINATED) {
                return false;
            }
            int length = pubSubInnerArr.length;
            pubSubInnerArr2 = new FluxPublish.PubSubInner[length + 1];
            System.arraycopy(pubSubInnerArr, 0, pubSubInnerArr2, 0, length);
            pubSubInnerArr2[length] = emitterInner;
        } while (!SUBSCRIBERS.compareAndSet(this, pubSubInnerArr, pubSubInnerArr2));
        return true;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Flux<T> asFlux() {
        return this;
    }

    public boolean checkTerminated(boolean z10, boolean z11) {
        if (this.f39465s == Operators.cancelledSubscription()) {
            if (this.autoCancel) {
                terminate();
                Queue<T> queue = this.queue;
                if (queue != null) {
                    queue.clear();
                }
            }
            return true;
        }
        int i10 = 0;
        if (z10) {
            Throwable th = this.error;
            if (th != null && th != Exceptions.TERMINATED) {
                Queue<T> queue2 = this.queue;
                if (queue2 != null) {
                    queue2.clear();
                }
                FluxPublish.PubSubInner<T>[] pubSubInnerArrTerminate = terminate();
                int length = pubSubInnerArrTerminate.length;
                while (i10 < length) {
                    pubSubInnerArrTerminate[i10].actual.onError(th);
                    i10++;
                }
                return true;
            }
            if (z11) {
                FluxPublish.PubSubInner<T>[] pubSubInnerArrTerminate2 = terminate();
                int length2 = pubSubInnerArrTerminate2.length;
                while (i10 < length2) {
                    pubSubInnerArrTerminate2[i10].actual.onComplete();
                    i10++;
                }
                return true;
            }
        }
        return false;
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.CoreSubscriber
    public Context currentContext() {
        return Operators.multiSubscribersContext(this.subscribers);
    }

    @Override // reactor.core.publisher.Sinks.Many
    public int currentSubscriberCount() {
        return this.subscribers.length;
    }

    @Override // reactor.core.publisher.FluxProcessor
    public long downstreamCount() {
        return this.subscribers.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f5, code lost:
    
        r21 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drain() {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.EmitterProcessor.drain():void");
    }

    @Override // reactor.core.publisher.FluxProcessor
    public final int getBufferSize() {
        return this.prefetch;
    }

    @Override // reactor.core.publisher.FluxProcessor
    @Nullable
    public Throwable getError() {
        return this.error;
    }

    public int getPending() {
        Queue<T> queue = this.queue;
        if (queue != null) {
            return queue.size();
        }
        return 0;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.Scannable
    public Stream<? extends Scannable> inners() {
        return Stream.of((Object[]) this.subscribers);
    }

    public boolean isCancelled() {
        return Operators.cancelledSubscription() == this.f39465s;
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return isTerminated() || isCancelled();
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isIdentityProcessor() {
        return true;
    }

    @Override // reactor.core.publisher.FluxProcessor
    public boolean isTerminated() {
        return this.done && getPending() == 0;
    }

    @Override // reactor.core.publisher.FluxProcessor, qc.c
    public void onComplete() {
        tryEmitComplete();
    }

    @Override // reactor.core.publisher.FluxProcessor, qc.c
    public void onError(Throwable th) {
        emitError(th, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override // reactor.core.publisher.FluxProcessor, qc.c
    public void onNext(T t10) {
        if (this.sourceMode == 2) {
            drain();
        } else {
            emitNext(t10, Sinks.EmitFailureHandler.FAIL_FAST);
        }
    }

    @Override // qc.c
    public void onSubscribe(qc.d dVar) {
        if (Operators.setOnce(f39464S, this, dVar)) {
            if (dVar instanceof Fuseable.QueueSubscription) {
                Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) dVar;
                int iRequestFusion = queueSubscription.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.sourceMode = iRequestFusion;
                    this.queue = queueSubscription;
                    drain();
                    return;
                } else if (iRequestFusion == 2) {
                    this.sourceMode = iRequestFusion;
                    this.queue = queueSubscription;
                    dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                    return;
                }
            }
            this.queue = (Queue) Queues.get(this.prefetch).get();
            dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
        }
    }

    public final void remove(FluxPublish.PubSubInner<T> pubSubInner) {
        FluxPublish.PubSubInner<T>[] pubSubInnerArr;
        FluxPublish.PubSubInner[] pubSubInnerArr2;
        do {
            pubSubInnerArr = this.subscribers;
            if (pubSubInnerArr == FluxPublish.PublishSubscriber.TERMINATED || pubSubInnerArr == EMPTY) {
                return;
            }
            int length = pubSubInnerArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                } else if (pubSubInnerArr[i10] == pubSubInner) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                pubSubInnerArr2 = EMPTY;
            } else {
                FluxPublish.PubSubInner[] pubSubInnerArr3 = new FluxPublish.PubSubInner[length - 1];
                System.arraycopy(pubSubInnerArr, 0, pubSubInnerArr3, 0, i10);
                System.arraycopy(pubSubInnerArr, i10 + 1, pubSubInnerArr3, i10, (length - i10) - 1);
                pubSubInnerArr2 = pubSubInnerArr3;
            }
        } while (!SUBSCRIBERS.compareAndSet(this, pubSubInnerArr, pubSubInnerArr2));
        if (this.autoCancel && pubSubInnerArr2 == EMPTY && Operators.terminate(f39464S, this) && WIP.getAndIncrement(this) == 0) {
            terminate();
            Queue<T> queue = this.queue;
            if (queue != null) {
                queue.clear();
            }
        }
    }

    @Override // reactor.core.publisher.FluxProcessor, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.PARENT ? this.f39465s : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(getPending()) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled()) : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(getPrefetch()) : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Objects.requireNonNull(coreSubscriber, "subscribe");
        EmitterInner<T> emitterInner = new EmitterInner<>(coreSubscriber, this);
        coreSubscriber.onSubscribe(emitterInner);
        if (emitterInner.isCancelled()) {
            return;
        }
        if (add(emitterInner)) {
            if (emitterInner.isCancelled()) {
                remove(emitterInner);
            }
            drain();
        } else {
            Throwable th = this.error;
            if (th != null) {
                emitterInner.actual.onError(th);
            } else {
                emitterInner.actual.onComplete();
            }
        }
    }

    @Override // reactor.core.publisher.Sinks.ManyWithUpstream
    public Disposable subscribeTo(qc.b<? extends T> bVar) {
        EmitterDisposable emitterDisposable = new EmitterDisposable(this);
        if (!UPSTREAM_DISPOSABLE.compareAndSet(this, null, emitterDisposable)) {
            throw new IllegalStateException("A Sinks.ManyWithUpstream must be subscribed to a source only once");
        }
        bVar.subscribe(this);
        return emitterDisposable;
    }

    public FluxPublish.PubSubInner<T>[] terminate() {
        return SUBSCRIBERS.getAndSet(this, FluxPublish.PublishSubscriber.TERMINATED);
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitComplete() {
        if (this.done) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        this.done = true;
        drain();
        return Sinks.EmitResult.OK;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitError(Throwable th) {
        Objects.requireNonNull(th, "onError");
        if (!this.done && Exceptions.addThrowable(ERROR, this, th)) {
            this.done = true;
            drain();
            return Sinks.EmitResult.OK;
        }
        return Sinks.EmitResult.FAIL_TERMINATED;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitNext(T t10) {
        if (this.done) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        Objects.requireNonNull(t10, "onNext");
        Queue<T> queue = this.queue;
        if (queue == null) {
            if (!Operators.setOnce(f39464S, this, Operators.emptySubscription())) {
                while (!isCancelled()) {
                    queue = this.queue;
                    if (queue != null) {
                    }
                }
                return Sinks.EmitResult.FAIL_CANCELLED;
            }
            queue = (Queue) Queues.get(this.prefetch).get();
            this.queue = queue;
        }
        if (!queue.offer(t10)) {
            return this.subscribers == EMPTY ? Sinks.EmitResult.FAIL_ZERO_SUBSCRIBER : Sinks.EmitResult.FAIL_OVERFLOW;
        }
        drain();
        return Sinks.EmitResult.OK;
    }

    @Deprecated
    public static <E> EmitterProcessor<E> create(boolean z10) {
        return create(Queues.SMALL_BUFFER_SIZE, z10);
    }

    @Deprecated
    public static <E> EmitterProcessor<E> create(int i10) {
        return create(i10, true);
    }

    @Deprecated
    public static <E> EmitterProcessor<E> create(int i10, boolean z10) {
        return new EmitterProcessor<>(z10, i10);
    }
}
