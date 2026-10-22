package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxPublishMulticast<T, R> extends InternalFluxOperator<T, R> implements Fuseable {
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;
    final Function<? super Flux<T>, ? extends qc.b<? extends R>> transform;

    public static final class CancelFuseableMulticaster<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final PublishMulticasterParent parent;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f39547s;

        public CancelFuseableMulticaster(CoreSubscriber<? super T> coreSubscriber, PublishMulticasterParent publishMulticasterParent) {
            this.actual = coreSubscriber;
            this.parent = publishMulticasterParent;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39547s.cancel();
            this.parent.terminate();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f39547s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f39547s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
            this.parent.terminate();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.parent.terminate();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39547s, dVar)) {
                this.f39547s = Operators.as(dVar);
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return this.f39547s.poll();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39547s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            return this.f39547s.requestFusion(i10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39547s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f39547s.size();
        }
    }

    public static final class CancelMulticaster<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final PublishMulticasterParent parent;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39548s;

        public CancelMulticaster(CoreSubscriber<? super T> coreSubscriber, PublishMulticasterParent publishMulticasterParent) {
            this.actual = coreSubscriber;
            this.parent = publishMulticasterParent;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39548s.cancel();
            this.parent.terminate();
        }

        @Override // java.util.Collection
        public void clear() {
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
            this.parent.terminate();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.parent.terminate();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39548s, dVar)) {
                this.f39548s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39548s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39548s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }
    }

    public static final class FluxPublishMulticaster<T> extends Flux<T> implements InnerConsumer<T>, PublishMulticasterParent {
        volatile boolean connected;
        final Context context;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        int produced;
        Queue<T> queue;
        final Supplier<? extends Queue<T>> queueSupplier;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39550s;
        int sourceMode;
        volatile PublishMulticastInner<T>[] subscribers;
        volatile int wip;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<FluxPublishMulticaster, qc.d> f39549S = AtomicReferenceFieldUpdater.newUpdater(FluxPublishMulticaster.class, qc.d.class, "s");
        static final AtomicIntegerFieldUpdater<FluxPublishMulticaster> WIP = AtomicIntegerFieldUpdater.newUpdater(FluxPublishMulticaster.class, "wip");
        static final AtomicReferenceFieldUpdater<FluxPublishMulticaster, PublishMulticastInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(FluxPublishMulticaster.class, PublishMulticastInner[].class, "subscribers");
        static final PublishMulticastInner[] EMPTY = new PublishMulticastInner[0];
        static final PublishMulticastInner[] TERMINATED = new PublishMulticastInner[0];

        public FluxPublishMulticaster(int i10, Supplier<? extends Queue<T>> supplier, Context context) {
            this.prefetch = i10;
            this.limit = Operators.unboundedOrLimit(i10);
            this.queueSupplier = supplier;
            SUBSCRIBERS.lazySet(this, EMPTY);
            this.context = context;
        }

        public boolean add(PublishMulticastInner<T> publishMulticastInner) {
            PublishMulticastInner<T>[] publishMulticastInnerArr;
            PublishMulticastInner[] publishMulticastInnerArr2;
            do {
                publishMulticastInnerArr = this.subscribers;
                if (publishMulticastInnerArr == TERMINATED) {
                    return false;
                }
                int length = publishMulticastInnerArr.length;
                publishMulticastInnerArr2 = new PublishMulticastInner[length + 1];
                System.arraycopy(publishMulticastInnerArr, 0, publishMulticastInnerArr2, 0, length);
                publishMulticastInnerArr2[length] = publishMulticastInner;
            } while (!SUBSCRIBERS.compareAndSet(this, publishMulticastInnerArr, publishMulticastInnerArr2));
            return true;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }

        public void drainAsync() {
            int i10 = this.produced;
            int iAddAndGet = 1;
            do {
                if (this.connected) {
                    if (this.f39550s == Operators.cancelledSubscription()) {
                        this.queue.clear();
                        return;
                    }
                    Queue<T> queue = this.queue;
                    PublishMulticastInner<T>[] publishMulticastInnerArr = this.subscribers;
                    int length = publishMulticastInnerArr.length;
                    if (length != 0) {
                        int i11 = 0;
                        long jMin = Long.MAX_VALUE;
                        for (PublishMulticastInner<T> publishMulticastInner : publishMulticastInnerArr) {
                            long j10 = publishMulticastInner.requested;
                            if (j10 != Long.MIN_VALUE) {
                                jMin = Math.min(jMin, j10);
                            }
                        }
                        long j11 = 0;
                        while (j11 != jMin) {
                            if (this.f39550s == Operators.cancelledSubscription()) {
                                queue.clear();
                                return;
                            }
                            boolean z10 = this.done;
                            try {
                                T tPoll = queue.poll();
                                boolean z11 = tPoll == null;
                                if (z10) {
                                    Throwable th = this.error;
                                    if (th != null) {
                                        queue.clear();
                                        PublishMulticastInner[] andSet = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                        int length2 = andSet.length;
                                        while (i11 < length2) {
                                            andSet[i11].actual.onError(th);
                                            i11++;
                                        }
                                        return;
                                    }
                                    if (z11) {
                                        PublishMulticastInner[] andSet2 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                        int length3 = andSet2.length;
                                        while (i11 < length3) {
                                            andSet2[i11].actual.onComplete();
                                            i11++;
                                        }
                                        return;
                                    }
                                }
                                if (z11) {
                                    break;
                                }
                                for (PublishMulticastInner<T> publishMulticastInner2 : publishMulticastInnerArr) {
                                    publishMulticastInner2.actual.onNext(tPoll);
                                }
                                j11++;
                                i10++;
                                if (i10 == this.limit) {
                                    this.f39550s.request(i10);
                                    i10 = 0;
                                }
                            } catch (Throwable th2) {
                                queue.clear();
                                this.error = Operators.onOperatorError(this.f39550s, th2, this.context);
                                PublishMulticastInner[] andSet3 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                int length4 = andSet3.length;
                                while (i11 < length4) {
                                    andSet3[i11].actual.onError(th2);
                                    i11++;
                                }
                                return;
                            }
                        }
                        if (j11 == jMin) {
                            if (this.f39550s == Operators.cancelledSubscription()) {
                                queue.clear();
                                return;
                            }
                            if (this.done) {
                                Throwable th3 = this.error;
                                if (th3 != null) {
                                    queue.clear();
                                    PublishMulticastInner[] andSet4 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                    int length5 = andSet4.length;
                                    while (i11 < length5) {
                                        andSet4[i11].actual.onError(th3);
                                        i11++;
                                    }
                                    return;
                                }
                                if (queue.isEmpty()) {
                                    PublishMulticastInner[] andSet5 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                    int length6 = andSet5.length;
                                    while (i11 < length6) {
                                        andSet5[i11].actual.onComplete();
                                        i11++;
                                    }
                                    return;
                                }
                            }
                        }
                        if (j11 != 0) {
                            while (i11 < length) {
                                publishMulticastInnerArr[i11].produced(j11);
                                i11++;
                            }
                        }
                    }
                }
                this.produced = i10;
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void drainSync() {
            int iAddAndGet = 1;
            do {
                if (this.connected) {
                    if (this.f39550s == Operators.cancelledSubscription()) {
                        this.queue.clear();
                        return;
                    }
                    Queue<T> queue = this.queue;
                    PublishMulticastInner<T>[] publishMulticastInnerArr = this.subscribers;
                    int length = publishMulticastInnerArr.length;
                    if (length != 0) {
                        int i10 = 0;
                        long jMin = Long.MAX_VALUE;
                        for (PublishMulticastInner<T> publishMulticastInner : publishMulticastInnerArr) {
                            long j10 = publishMulticastInner.requested;
                            if (j10 != Long.MIN_VALUE) {
                                jMin = Math.min(jMin, j10);
                            }
                        }
                        long j11 = 0;
                        while (j11 != jMin) {
                            if (this.f39550s == Operators.cancelledSubscription()) {
                                queue.clear();
                                return;
                            }
                            try {
                                T tPoll = queue.poll();
                                if (tPoll == null) {
                                    PublishMulticastInner[] andSet = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                    int length2 = andSet.length;
                                    while (i10 < length2) {
                                        andSet[i10].actual.onComplete();
                                        i10++;
                                    }
                                    return;
                                }
                                for (PublishMulticastInner<T> publishMulticastInner2 : publishMulticastInnerArr) {
                                    publishMulticastInner2.actual.onNext(tPoll);
                                }
                                j11++;
                            } catch (Throwable th) {
                                this.error = Operators.onOperatorError(this.f39550s, th, this.context);
                                queue.clear();
                                PublishMulticastInner[] andSet2 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                int length3 = andSet2.length;
                                while (i10 < length3) {
                                    andSet2[i10].actual.onError(th);
                                    i10++;
                                }
                                return;
                            }
                        }
                        if (this.f39550s == Operators.cancelledSubscription()) {
                            queue.clear();
                            return;
                        }
                        if (queue.isEmpty()) {
                            PublishMulticastInner[] andSet3 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                            int length4 = andSet3.length;
                            while (i10 < length4) {
                                andSet3[i10].actual.onComplete();
                                i10++;
                            }
                            return;
                        }
                        if (j11 != 0) {
                            while (i10 < length) {
                                publishMulticastInnerArr[i10].produced(j11);
                                i10++;
                            }
                        }
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.context);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.context);
            } else if (this.sourceMode == 2 || this.queue.offer(t10)) {
                drain();
            } else {
                onError(Operators.onOperatorError(this.f39550s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, this.context));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39549S, this, dVar)) {
                if (dVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) dVar;
                    int iRequestFusion = queueSubscription.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.connected = true;
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.connected = true;
                        dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = this.queueSupplier.get();
                this.connected = true;
                dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        public void remove(PublishMulticastInner<T> publishMulticastInner) {
            PublishMulticastInner<T>[] publishMulticastInnerArr;
            PublishMulticastInner[] publishMulticastInnerArr2;
            do {
                publishMulticastInnerArr = this.subscribers;
                if (publishMulticastInnerArr == TERMINATED || publishMulticastInnerArr == EMPTY) {
                    return;
                }
                int length = publishMulticastInnerArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (publishMulticastInnerArr[i10] == publishMulticastInner) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    publishMulticastInnerArr2 = EMPTY;
                } else {
                    PublishMulticastInner[] publishMulticastInnerArr3 = new PublishMulticastInner[length - 1];
                    System.arraycopy(publishMulticastInnerArr, 0, publishMulticastInnerArr3, 0, i10);
                    System.arraycopy(publishMulticastInnerArr, i10 + 1, publishMulticastInnerArr3, i10, (length - i10) - 1);
                    publishMulticastInnerArr2 = publishMulticastInnerArr3;
                }
            } while (!SUBSCRIBERS.compareAndSet(this, publishMulticastInnerArr, publishMulticastInnerArr2));
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39550s;
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39550s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                Queue<T> queue = this.queue;
                return Integer.valueOf(queue != null ? queue.size() : 0);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
            PublishMulticastInner<T> publishMulticastInner = new PublishMulticastInner<>(this, coreSubscriber);
            coreSubscriber.onSubscribe(publishMulticastInner);
            if (add(publishMulticastInner)) {
                if (publishMulticastInner.requested == Long.MIN_VALUE) {
                    remove(publishMulticastInner);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            Throwable th = this.error;
            if (th != null) {
                coreSubscriber.onError(th);
            } else {
                coreSubscriber.onComplete();
            }
        }

        @Override // reactor.core.publisher.FluxPublishMulticast.PublishMulticasterParent
        public void terminate() {
            Operators.terminate(f39549S, this);
            if (WIP.getAndIncrement(this) == 0 && this.connected) {
                this.queue.clear();
            }
        }
    }

    public static final class PublishMulticastInner<T> implements InnerProducer<T> {
        static final AtomicLongFieldUpdater<PublishMulticastInner> REQUESTED = AtomicLongFieldUpdater.newUpdater(PublishMulticastInner.class, "requested");
        final CoreSubscriber<? super T> actual;
        final FluxPublishMulticaster<T> parent;
        volatile long requested;

        public PublishMulticastInner(FluxPublishMulticaster<T> fluxPublishMulticaster, CoreSubscriber<? super T> coreSubscriber) {
            this.parent = fluxPublishMulticaster;
            this.actual = coreSubscriber;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            if (REQUESTED.getAndSet(this, Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public void produced(long j10) {
            Operators.producedCancellable(REQUESTED, this, j10);
        }

        @Override // reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCapCancellable(REQUESTED, this, j10);
                this.parent.drain();
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(Math.max(0L, this.requested));
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(Long.MIN_VALUE == this.requested);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public interface PublishMulticasterParent {
        void terminate();
    }

    public FluxPublishMulticast(Flux<? extends T> flux, Function<? super Flux<T>, ? extends qc.b<? extends R>> function, int i10, Supplier<? extends Queue<T>> supplier) {
        super(flux);
        if (i10 < 1) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i10);
        }
        this.prefetch = i10;
        Objects.requireNonNull(function, "transform");
        this.transform = function;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        FluxPublishMulticaster fluxPublishMulticaster = new FluxPublishMulticaster(this.prefetch, this.queueSupplier, coreSubscriber.currentContext());
        qc.b<? extends R> bVarApply = this.transform.apply(fluxPublishMulticaster);
        Objects.requireNonNull(bVarApply, "The transform returned a null Publisher");
        CorePublisher fluxOrMono = Operators.toFluxOrMono(bVarApply);
        if (fluxOrMono instanceof Fuseable) {
            fluxOrMono.subscribe((qc.c) new CancelFuseableMulticaster(coreSubscriber, fluxPublishMulticaster));
            return fluxPublishMulticaster;
        }
        fluxOrMono.subscribe((qc.c) new CancelMulticaster(coreSubscriber, fluxPublishMulticaster));
        return fluxPublishMulticaster;
    }
}
