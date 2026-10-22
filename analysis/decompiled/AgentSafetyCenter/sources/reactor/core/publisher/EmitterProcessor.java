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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
public final class EmitterProcessor<T> extends FluxProcessor<T, T> implements InternalManySink<T>, Sinks.ManyWithUpstream<T> {
    final boolean autoCancel;
    volatile boolean done;
    volatile Throwable error;
    final int prefetch;
    volatile Queue<T> queue;

    /* renamed from: s, reason: collision with root package name */
    volatile qd.e f10584s;
    int sourceMode;
    volatile FluxPublish.PubSubInner<T>[] subscribers;
    volatile EmitterDisposable upstreamDisposable;
    volatile int wip;
    static final FluxPublish.PubSubInner[] EMPTY = new FluxPublish.PublishInner[0];
    static final AtomicReferenceFieldUpdater<EmitterProcessor, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(EmitterProcessor.class, qd.e.class, "s");
    static final AtomicReferenceFieldUpdater<EmitterProcessor, FluxPublish.PubSubInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(EmitterProcessor.class, FluxPublish.PubSubInner[].class, "subscribers");
    static final AtomicReferenceFieldUpdater<EmitterProcessor, EmitterDisposable> UPSTREAM_DISPOSABLE = AtomicReferenceFieldUpdater.newUpdater(EmitterProcessor.class, EmitterDisposable.class, "upstreamDisposable");
    static final AtomicIntegerFieldUpdater<EmitterProcessor> WIP = AtomicIntegerFieldUpdater.newUpdater(EmitterProcessor.class, "wip");
    static final AtomicReferenceFieldUpdater<EmitterProcessor, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(EmitterProcessor.class, Throwable.class, "error");

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    public EmitterProcessor(boolean z10, int i) {
        if (i < 1) {
            g5.f.s(k0.a.j(i, "bufferSize must be strictly positive, was: "));
            throw null;
        }
        this.autoCancel = z10;
        this.prefetch = i;
        SUBSCRIBERS.lazySet(this, EMPTY);
    }

    @Deprecated
    public static <E> EmitterProcessor<E> create() {
        return create(Queues.SMALL_BUFFER_SIZE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean detach() {
        if (Operators.terminate(S, this)) {
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
        return this.f10584s == Operators.cancelledSubscription() && this.done && (this.error instanceof CancellationException);
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

    public boolean checkTerminated(boolean z10, boolean z11) {
        if (this.f10584s == Operators.cancelledSubscription()) {
            if (this.autoCancel) {
                terminate();
                Queue<T> queue = this.queue;
                if (queue != null) {
                    queue.clear();
                }
            }
            return true;
        }
        int i = 0;
        if (z10) {
            Throwable th = this.error;
            if (th != null && th != Exceptions.TERMINATED) {
                Queue<T> queue2 = this.queue;
                if (queue2 != null) {
                    queue2.clear();
                }
                FluxPublish.PubSubInner<T>[] pubSubInnerArrTerminate = terminate();
                int length = pubSubInnerArrTerminate.length;
                while (i < length) {
                    pubSubInnerArrTerminate[i].actual.onError(th);
                    i++;
                }
                return true;
            }
            if (z11) {
                FluxPublish.PubSubInner<T>[] pubSubInnerArrTerminate2 = terminate();
                int length2 = pubSubInnerArrTerminate2.length;
                while (i < length2) {
                    pubSubInnerArrTerminate2[i].actual.onComplete();
                    i++;
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
        return Operators.cancelledSubscription() == this.f10584s;
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

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onComplete() {
        tryEmitComplete();
    }

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onError(Throwable th) {
        emitError(th, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override // reactor.core.publisher.FluxProcessor, qd.d
    public void onNext(T t10) {
        if (this.sourceMode == 2) {
            drain();
        } else {
            emitNext(t10, Sinks.EmitFailureHandler.FAIL_FAST);
        }
    }

    @Override // qd.d
    public void onSubscribe(qd.e eVar) {
        if (Operators.setOnce(S, this, eVar)) {
            if (eVar instanceof Fuseable.QueueSubscription) {
                Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
                int iRequestFusion = queueSubscription.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.sourceMode = iRequestFusion;
                    this.queue = queueSubscription;
                    drain();
                    return;
                } else if (iRequestFusion == 2) {
                    this.sourceMode = iRequestFusion;
                    this.queue = queueSubscription;
                    eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                    return;
                }
            }
            this.queue = (Queue) Queues.get(this.prefetch).get();
            eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
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
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (pubSubInnerArr[i] == pubSubInner) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                pubSubInnerArr2 = EMPTY;
            } else {
                FluxPublish.PubSubInner[] pubSubInnerArr3 = new FluxPublish.PubSubInner[length - 1];
                System.arraycopy(pubSubInnerArr, 0, pubSubInnerArr3, 0, i);
                System.arraycopy(pubSubInnerArr, i + 1, pubSubInnerArr3, i, (length - i) - 1);
                pubSubInnerArr2 = pubSubInnerArr3;
            }
        } while (!SUBSCRIBERS.compareAndSet(this, pubSubInnerArr, pubSubInnerArr2));
        if (this.autoCancel && pubSubInnerArr2 == EMPTY && Operators.terminate(S, this) && WIP.getAndIncrement(this) == 0) {
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
        return attr == Scannable.Attr.PARENT ? this.f10584s : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(getPending()) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled()) : attr == Scannable.Attr.PREFETCH ? Integer.valueOf(getPrefetch()) : super.scanUnsafe(attr);
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
            CoreSubscriber<? super T> coreSubscriber2 = emitterInner.actual;
            if (th != null) {
                coreSubscriber2.onError(th);
            } else {
                coreSubscriber2.onComplete();
            }
        }
    }

    @Override // reactor.core.publisher.Sinks.ManyWithUpstream
    public Disposable subscribeTo(qd.c cVar) {
        EmitterDisposable emitterDisposable = new EmitterDisposable(this);
        if (UPSTREAM_DISPOSABLE.compareAndSet(this, null, emitterDisposable)) {
            cVar.subscribe(this);
            return emitterDisposable;
        }
        od.f.e("A Sinks.ManyWithUpstream must be subscribed to a source only once");
        return null;
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
        if (this.done) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        if (!Exceptions.addThrowable(ERROR, this, th)) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        this.done = true;
        drain();
        return Sinks.EmitResult.OK;
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Sinks.EmitResult tryEmitNext(T t10) {
        if (this.done) {
            return Sinks.EmitResult.FAIL_TERMINATED;
        }
        Objects.requireNonNull(t10, "onNext");
        Queue<T> queue = this.queue;
        if (queue == null) {
            if (!Operators.setOnce(S, this, Operators.emptySubscription())) {
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
    public static <E> EmitterProcessor<E> create(int i) {
        return create(i, true);
    }

    @Deprecated
    public static <E> EmitterProcessor<E> create(int i, boolean z10) {
        return new EmitterProcessor<>(z10, i);
    }

    @Override // reactor.core.publisher.Sinks.Many
    public Flux<T> asFlux() {
        return this;
    }
}
