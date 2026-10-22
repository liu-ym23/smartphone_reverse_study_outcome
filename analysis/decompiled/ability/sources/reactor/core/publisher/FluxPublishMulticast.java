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

/* loaded from: classes4.dex */
final class FluxPublishMulticast<T, R> extends InternalFluxOperator<T, R> implements Fuseable {
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;
    final Function<? super Flux<T>, ? extends Z9.c> transform;

    public static final class CancelFuseableMulticaster<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final PublishMulticasterParent parent;

        /* renamed from: s, reason: collision with root package name */
        Fuseable.QueueSubscription<T> f5777s;

        public CancelFuseableMulticaster(CoreSubscriber<? super T> coreSubscriber, PublishMulticasterParent publishMulticasterParent) {
            this.actual = coreSubscriber;
            this.parent = publishMulticasterParent;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5777s.cancel();
            this.parent.terminate();
        }

        @Override // java.util.Collection
        public void clear() {
            this.f5777s.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f5777s.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
            this.parent.terminate();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.parent.terminate();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5777s, eVar)) {
                this.f5777s = Operators.as(eVar);
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return this.f5777s.poll();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5777s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return this.f5777s.requestFusion(i);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5777s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.f5777s.size();
        }
    }

    public static final class CancelMulticaster<T> implements InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final PublishMulticasterParent parent;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5778s;

        public CancelMulticaster(CoreSubscriber<? super T> coreSubscriber, PublishMulticasterParent publishMulticasterParent) {
            this.actual = coreSubscriber;
            this.parent = publishMulticasterParent;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5778s.cancel();
            this.parent.terminate();
        }

        @Override // java.util.Collection
        public void clear() {
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
            this.parent.terminate();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.parent.terminate();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5778s, eVar)) {
                this.f5778s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5778s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5778s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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
        volatile Z9.e f5780s;
        int sourceMode;
        volatile PublishMulticastInner<T>[] subscribers;
        volatile int wip;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<FluxPublishMulticaster, Z9.e> f5779S = AtomicReferenceFieldUpdater.newUpdater(FluxPublishMulticaster.class, Z9.e.class, "s");
        static final AtomicIntegerFieldUpdater<FluxPublishMulticaster> WIP = AtomicIntegerFieldUpdater.newUpdater(FluxPublishMulticaster.class, "wip");
        static final AtomicReferenceFieldUpdater<FluxPublishMulticaster, PublishMulticastInner[]> SUBSCRIBERS = AtomicReferenceFieldUpdater.newUpdater(FluxPublishMulticaster.class, PublishMulticastInner[].class, "subscribers");
        static final PublishMulticastInner[] EMPTY = new PublishMulticastInner[0];
        static final PublishMulticastInner[] TERMINATED = new PublishMulticastInner[0];

        public FluxPublishMulticaster(int i, Supplier<? extends Queue<T>> supplier, Context context) {
            this.prefetch = i;
            this.limit = Operators.unboundedOrLimit(i);
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
            int i = this.produced;
            int iAddAndGet = 1;
            do {
                if (this.connected) {
                    if (this.f5780s == Operators.cancelledSubscription()) {
                        this.queue.clear();
                        return;
                    }
                    Queue<T> queue = this.queue;
                    PublishMulticastInner<T>[] publishMulticastInnerArr = this.subscribers;
                    int length = publishMulticastInnerArr.length;
                    if (length != 0) {
                        int i6 = 0;
                        long jMin = Long.MAX_VALUE;
                        for (PublishMulticastInner<T> publishMulticastInner : publishMulticastInnerArr) {
                            long j5 = publishMulticastInner.requested;
                            if (j5 != Long.MIN_VALUE) {
                                jMin = Math.min(jMin, j5);
                            }
                        }
                        long j6 = 0;
                        while (j6 != jMin) {
                            if (this.f5780s == Operators.cancelledSubscription()) {
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
                                        while (i6 < length2) {
                                            andSet[i6].actual.onError(th);
                                            i6++;
                                        }
                                        return;
                                    }
                                    if (z11) {
                                        PublishMulticastInner[] andSet2 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                        int length3 = andSet2.length;
                                        while (i6 < length3) {
                                            andSet2[i6].actual.onComplete();
                                            i6++;
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
                                j6++;
                                i++;
                                if (i == this.limit) {
                                    this.f5780s.request(i);
                                    i = 0;
                                }
                            } catch (Throwable th2) {
                                queue.clear();
                                this.error = Operators.onOperatorError(this.f5780s, th2, this.context);
                                PublishMulticastInner[] andSet3 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                int length4 = andSet3.length;
                                while (i6 < length4) {
                                    andSet3[i6].actual.onError(th2);
                                    i6++;
                                }
                                return;
                            }
                        }
                        if (j6 == jMin) {
                            if (this.f5780s == Operators.cancelledSubscription()) {
                                queue.clear();
                                return;
                            }
                            if (this.done) {
                                Throwable th3 = this.error;
                                if (th3 != null) {
                                    queue.clear();
                                    PublishMulticastInner[] andSet4 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                    int length5 = andSet4.length;
                                    while (i6 < length5) {
                                        andSet4[i6].actual.onError(th3);
                                        i6++;
                                    }
                                    return;
                                }
                                if (queue.isEmpty()) {
                                    PublishMulticastInner[] andSet5 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                    int length6 = andSet5.length;
                                    while (i6 < length6) {
                                        andSet5[i6].actual.onComplete();
                                        i6++;
                                    }
                                    return;
                                }
                            }
                        }
                        if (j6 != 0) {
                            while (i6 < length) {
                                publishMulticastInnerArr[i6].produced(j6);
                                i6++;
                            }
                        }
                    }
                }
                this.produced = i;
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void drainSync() {
            int iAddAndGet = 1;
            do {
                if (this.connected) {
                    if (this.f5780s == Operators.cancelledSubscription()) {
                        this.queue.clear();
                        return;
                    }
                    Queue<T> queue = this.queue;
                    PublishMulticastInner<T>[] publishMulticastInnerArr = this.subscribers;
                    int length = publishMulticastInnerArr.length;
                    if (length != 0) {
                        int i = 0;
                        long jMin = Long.MAX_VALUE;
                        for (PublishMulticastInner<T> publishMulticastInner : publishMulticastInnerArr) {
                            long j5 = publishMulticastInner.requested;
                            if (j5 != Long.MIN_VALUE) {
                                jMin = Math.min(jMin, j5);
                            }
                        }
                        long j6 = 0;
                        while (j6 != jMin) {
                            if (this.f5780s == Operators.cancelledSubscription()) {
                                queue.clear();
                                return;
                            }
                            try {
                                T tPoll = queue.poll();
                                if (tPoll == null) {
                                    PublishMulticastInner[] andSet = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                    int length2 = andSet.length;
                                    while (i < length2) {
                                        andSet[i].actual.onComplete();
                                        i++;
                                    }
                                    return;
                                }
                                for (PublishMulticastInner<T> publishMulticastInner2 : publishMulticastInnerArr) {
                                    publishMulticastInner2.actual.onNext(tPoll);
                                }
                                j6++;
                            } catch (Throwable th) {
                                this.error = Operators.onOperatorError(this.f5780s, th, this.context);
                                queue.clear();
                                PublishMulticastInner[] andSet2 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                                int length3 = andSet2.length;
                                while (i < length3) {
                                    andSet2[i].actual.onError(th);
                                    i++;
                                }
                                return;
                            }
                        }
                        if (this.f5780s == Operators.cancelledSubscription()) {
                            queue.clear();
                            return;
                        }
                        if (queue.isEmpty()) {
                            PublishMulticastInner[] andSet3 = SUBSCRIBERS.getAndSet(this, TERMINATED);
                            int length4 = andSet3.length;
                            while (i < length4) {
                                andSet3[i].actual.onComplete();
                                i++;
                            }
                            return;
                        }
                        if (j6 != 0) {
                            while (i < length) {
                                publishMulticastInnerArr[i].produced(j6);
                                i++;
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

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.context);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.context);
            } else if (this.sourceMode == 2 || this.queue.offer(t9)) {
                drain();
            } else {
                onError(Operators.onOperatorError(this.f5780s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, this.context));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5779S, this, eVar)) {
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
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
                        eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = this.queueSupplier.get();
                this.connected = true;
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
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
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (publishMulticastInnerArr[i] == publishMulticastInner) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    publishMulticastInnerArr2 = EMPTY;
                } else {
                    PublishMulticastInner[] publishMulticastInnerArr3 = new PublishMulticastInner[length - 1];
                    System.arraycopy(publishMulticastInnerArr, 0, publishMulticastInnerArr3, 0, i);
                    System.arraycopy(publishMulticastInnerArr, i + 1, publishMulticastInnerArr3, i, (length - i) - 1);
                    publishMulticastInnerArr2 = publishMulticastInnerArr3;
                }
            } while (!SUBSCRIBERS.compareAndSet(this, publishMulticastInnerArr, publishMulticastInnerArr2));
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5780s;
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5780s == Operators.cancelledSubscription());
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
            Operators.terminate(f5779S, this);
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

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (REQUESTED.getAndSet(this, Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public void produced(long j5) {
            Operators.producedCancellable(REQUESTED, this, j5);
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCapCancellable(REQUESTED, this, j5);
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

    public FluxPublishMulticast(Flux<? extends T> flux, Function<? super Flux<T>, ? extends Z9.c> function, int i, Supplier<? extends Queue<T>> supplier) {
        super(flux);
        if (i < 1) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        this.prefetch = i;
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
        Z9.c cVarApply = this.transform.apply(fluxPublishMulticaster);
        Objects.requireNonNull(cVarApply, "The transform returned a null Publisher");
        CorePublisher fluxOrMono = Operators.toFluxOrMono(cVarApply);
        if (fluxOrMono instanceof Fuseable) {
            fluxOrMono.subscribe((Z9.d) new CancelFuseableMulticaster(coreSubscriber, fluxPublishMulticaster));
            return fluxPublishMulticaster;
        }
        fluxOrMono.subscribe((Z9.d) new CancelMulticaster(coreSubscriber, fluxPublishMulticaster));
        return fluxPublishMulticaster;
    }
}
