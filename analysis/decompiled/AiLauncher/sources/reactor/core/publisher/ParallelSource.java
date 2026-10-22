package reactor.core.publisher;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class ParallelSource<T> extends ParallelFlux<T> implements Scannable {
    final int parallelism;
    final int prefetch;
    final Supplier<Queue<T>> queueSupplier;
    final qc.b<? extends T> source;

    public static final class ParallelSourceMain<T> implements InnerConsumer<T> {
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        Queue<T> queue;
        final Supplier<Queue<T>> queueSupplier;
        final AtomicLongArray requests;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39701s;
        int sourceMode;
        volatile int subscriberCount;
        final CoreSubscriber<? super T>[] subscribers;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<ParallelSourceMain> WIP = AtomicIntegerFieldUpdater.newUpdater(ParallelSourceMain.class, "wip");
        static final AtomicIntegerFieldUpdater<ParallelSourceMain> SUBSCRIBER_COUNT = AtomicIntegerFieldUpdater.newUpdater(ParallelSourceMain.class, "subscriberCount");

        public static final class ParallelSourceInner<T> implements InnerProducer<T> {
            final int index;
            final int length;
            final ParallelSourceMain<T> parent;

            public ParallelSourceInner(ParallelSourceMain<T> parallelSourceMain, int i10, int i11) {
                this.index = i10;
                this.length = i11;
                this.parent = parallelSourceMain;
            }

            @Override // reactor.core.publisher.InnerProducer
            public CoreSubscriber<? super T> actual() {
                return this.parent.subscribers[this.index];
            }

            @Override // reactor.core.publisher.InnerProducer, qc.d
            public void cancel() {
                this.parent.cancel();
            }

            @Override // reactor.core.publisher.InnerProducer, qc.d
            public void request(long j10) {
                long j11;
                if (Operators.validate(j10)) {
                    AtomicLongArray atomicLongArray = this.parent.requests;
                    do {
                        j11 = atomicLongArray.get(this.index);
                        if (j11 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.index, j11, Operators.addCap(j11, j10)));
                    if (this.parent.subscriberCount == this.length) {
                        this.parent.drain();
                    }
                }
            }

            @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
            @Nullable
            public Object scanUnsafe(Scannable.Attr attr) {
                return attr == Scannable.Attr.PARENT ? this.parent : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
        }

        public ParallelSourceMain(CoreSubscriber<? super T>[] coreSubscriberArr, int i10, Supplier<Queue<T>> supplier) {
            this.subscribers = coreSubscriberArr;
            this.prefetch = i10;
            this.queueSupplier = supplier;
            this.limit = Operators.unboundedOrLimit(i10);
            this.requests = new AtomicLongArray(coreSubscriberArr.length);
            this.emissions = new long[coreSubscriberArr.length];
        }

        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f39701s.cancel();
            if (WIP.getAndIncrement(this) == 0) {
                this.queue.clear();
            }
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.subscribers[0].currentContext();
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
            Throwable th;
            Queue<T> queue = this.queue;
            CoreSubscriber<? super T>[] coreSubscriberArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i10 = this.index;
            int i11 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                int i12 = 0;
                int i13 = 0;
                while (!this.cancelled) {
                    boolean z10 = this.done;
                    if (z10 && (th = this.error) != null) {
                        queue.clear();
                        int length2 = coreSubscriberArr.length;
                        while (i12 < length2) {
                            coreSubscriberArr[i12].onError(th);
                            i12++;
                        }
                        return;
                    }
                    boolean zIsEmpty = queue.isEmpty();
                    if (z10 && zIsEmpty) {
                        int length3 = coreSubscriberArr.length;
                        while (i12 < length3) {
                            coreSubscriberArr[i12].onComplete();
                            i12++;
                        }
                        return;
                    }
                    if (!zIsEmpty) {
                        long j10 = atomicLongArray.get(i10);
                        long j11 = jArr[i10];
                        if (j10 != j11) {
                            try {
                                T tPoll = queue.poll();
                                if (tPoll != null) {
                                    coreSubscriberArr[i10].onNext(tPoll);
                                    jArr[i10] = j11 + 1;
                                    i11++;
                                    if (i11 == this.limit) {
                                        this.f39701s.request(i11);
                                        i11 = 0;
                                    }
                                    i13 = 0;
                                }
                            } catch (Throwable th2) {
                                Throwable thOnOperatorError = Operators.onOperatorError(this.f39701s, th2, coreSubscriberArr[i10].currentContext());
                                int length4 = coreSubscriberArr.length;
                                while (i12 < length4) {
                                    coreSubscriberArr[i12].onError(thOnOperatorError);
                                    i12++;
                                }
                                return;
                            }
                        } else {
                            i13++;
                        }
                        i10++;
                        if (i10 == length) {
                            i10 = 0;
                        }
                        if (i13 == length) {
                        }
                    }
                    int i14 = this.wip;
                    if (i14 == iAddAndGet) {
                        this.index = i10;
                        this.produced = i11;
                        iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i14;
                    }
                }
                queue.clear();
                return;
            }
        }

        public void drainSync() {
            Queue<T> queue = this.queue;
            CoreSubscriber<? super T>[] coreSubscriberArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i10 = this.index;
            int iAddAndGet = 1;
            while (true) {
                int i11 = 0;
                int i12 = 0;
                while (!this.cancelled) {
                    if (queue.isEmpty()) {
                        int length2 = coreSubscriberArr.length;
                        while (i11 < length2) {
                            coreSubscriberArr[i11].onComplete();
                            i11++;
                        }
                        return;
                    }
                    long j10 = atomicLongArray.get(i10);
                    long j11 = jArr[i10];
                    if (j10 != j11) {
                        try {
                            T tPoll = queue.poll();
                            if (tPoll == null) {
                                int length3 = coreSubscriberArr.length;
                                while (i11 < length3) {
                                    coreSubscriberArr[i11].onComplete();
                                    i11++;
                                }
                                return;
                            }
                            coreSubscriberArr[i10].onNext(tPoll);
                            jArr[i10] = j11 + 1;
                            i12 = 0;
                        } catch (Throwable th) {
                            Throwable thOnOperatorError = Operators.onOperatorError(this.f39701s, th, coreSubscriberArr[i10].currentContext());
                            int length4 = coreSubscriberArr.length;
                            while (i11 < length4) {
                                coreSubscriberArr[i11].onError(thOnOperatorError);
                                i11++;
                            }
                            return;
                        }
                    } else {
                        i12++;
                    }
                    i10++;
                    if (i10 == length) {
                        i10 = 0;
                    }
                    if (i12 == length) {
                        int i13 = this.wip;
                        if (i13 == iAddAndGet) {
                            this.index = i10;
                            iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                            if (iAddAndGet == 0) {
                                return;
                            }
                        } else {
                            iAddAndGet = i13;
                        }
                    }
                }
                queue.clear();
                return;
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers).map(new Function() { // from class: reactor.core.publisher.w2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Scannable.from((CoreSubscriber) obj);
                }
            });
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, currentContext());
            } else if (this.sourceMode != 0 || this.queue.offer(t10)) {
                drain();
            } else {
                onError(Operators.onOperatorError(this.f39701s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39701s, dVar)) {
                this.f39701s = dVar;
                if (dVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) dVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        setupSubscribers();
                        dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = this.queueSupplier.get();
                setupSubscribers();
                dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39701s;
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
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

        public void setupSubscribers() {
            int length = this.subscribers.length;
            int i10 = 0;
            while (i10 < length && !this.cancelled) {
                int i11 = i10 + 1;
                SUBSCRIBER_COUNT.lazySet(this, i11);
                this.subscribers[i10].onSubscribe(new ParallelSourceInner(this, i10, length));
                i10 = i11;
            }
        }
    }

    public ParallelSource(qc.b<? extends T> bVar, int i10, int i11, Supplier<Queue<T>> supplier) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("parallelism > 0 required but it was " + i10);
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i11);
        }
        this.source = Operators.toFluxOrMono(bVar);
        this.parallelism = i10;
        this.prefetch = i11;
        this.queueSupplier = supplier;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int getPrefetch() {
        return this.prefetch;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.parallelism;
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public void subscribe(CoreSubscriber<? super T>[] coreSubscriberArr) {
        if (validate(coreSubscriberArr)) {
            this.source.subscribe(new ParallelSourceMain(coreSubscriberArr, this.prefetch, this.queueSupplier));
        }
    }
}
