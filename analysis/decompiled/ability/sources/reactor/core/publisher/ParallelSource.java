package reactor.core.publisher;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class ParallelSource<T> extends ParallelFlux<T> implements Scannable {
    final int parallelism;
    final int prefetch;
    final Supplier<Queue<T>> queueSupplier;
    final Z9.c source;

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
        Z9.e f5886s;
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

            public ParallelSourceInner(ParallelSourceMain<T> parallelSourceMain, int i, int i6) {
                this.index = i;
                this.length = i6;
                this.parent = parallelSourceMain;
            }

            @Override // reactor.core.publisher.InnerProducer
            public CoreSubscriber<? super T> actual() {
                return this.parent.subscribers[this.index];
            }

            @Override // reactor.core.publisher.InnerProducer, Z9.e
            public void cancel() {
                this.parent.cancel();
            }

            @Override // reactor.core.publisher.InnerProducer, Z9.e
            public void request(long j5) {
                long j6;
                if (Operators.validate(j5)) {
                    AtomicLongArray atomicLongArray = this.parent.requests;
                    do {
                        j6 = atomicLongArray.get(this.index);
                        if (j6 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.index, j6, Operators.addCap(j6, j5)));
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

        public ParallelSourceMain(CoreSubscriber<? super T>[] coreSubscriberArr, int i, Supplier<Queue<T>> supplier) {
            this.subscribers = coreSubscriberArr;
            this.prefetch = i;
            this.queueSupplier = supplier;
            this.limit = Operators.unboundedOrLimit(i);
            this.requests = new AtomicLongArray(coreSubscriberArr.length);
            this.emissions = new long[coreSubscriberArr.length];
        }

        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f5886s.cancel();
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
            int i = this.index;
            int i6 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                int i10 = 0;
                int i11 = 0;
                while (!this.cancelled) {
                    boolean z10 = this.done;
                    if (z10 && (th = this.error) != null) {
                        queue.clear();
                        int length2 = coreSubscriberArr.length;
                        while (i10 < length2) {
                            coreSubscriberArr[i10].onError(th);
                            i10++;
                        }
                        return;
                    }
                    boolean zIsEmpty = queue.isEmpty();
                    if (z10 && zIsEmpty) {
                        int length3 = coreSubscriberArr.length;
                        while (i10 < length3) {
                            coreSubscriberArr[i10].onComplete();
                            i10++;
                        }
                        return;
                    }
                    if (!zIsEmpty) {
                        long j5 = atomicLongArray.get(i);
                        long j6 = jArr[i];
                        if (j5 != j6) {
                            try {
                                T tPoll = queue.poll();
                                if (tPoll != null) {
                                    coreSubscriberArr[i].onNext(tPoll);
                                    jArr[i] = j6 + 1;
                                    i6++;
                                    if (i6 == this.limit) {
                                        this.f5886s.request(i6);
                                        i6 = 0;
                                    }
                                    i11 = 0;
                                }
                            } catch (Throwable th2) {
                                Throwable thOnOperatorError = Operators.onOperatorError(this.f5886s, th2, coreSubscriberArr[i].currentContext());
                                int length4 = coreSubscriberArr.length;
                                while (i10 < length4) {
                                    coreSubscriberArr[i10].onError(thOnOperatorError);
                                    i10++;
                                }
                                return;
                            }
                        } else {
                            i11++;
                        }
                        i++;
                        if (i == length) {
                            i = 0;
                        }
                        if (i11 == length) {
                        }
                    }
                    int i12 = this.wip;
                    if (i12 == iAddAndGet) {
                        this.index = i;
                        this.produced = i6;
                        iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i12;
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
            int i = this.index;
            int iAddAndGet = 1;
            while (true) {
                int i6 = 0;
                int i10 = 0;
                while (!this.cancelled) {
                    if (queue.isEmpty()) {
                        int length2 = coreSubscriberArr.length;
                        while (i6 < length2) {
                            coreSubscriberArr[i6].onComplete();
                            i6++;
                        }
                        return;
                    }
                    long j5 = atomicLongArray.get(i);
                    long j6 = jArr[i];
                    if (j5 != j6) {
                        try {
                            T tPoll = queue.poll();
                            if (tPoll == null) {
                                int length3 = coreSubscriberArr.length;
                                while (i6 < length3) {
                                    coreSubscriberArr[i6].onComplete();
                                    i6++;
                                }
                                return;
                            }
                            coreSubscriberArr[i].onNext(tPoll);
                            jArr[i] = j6 + 1;
                            i10 = 0;
                        } catch (Throwable th) {
                            Throwable thOnOperatorError = Operators.onOperatorError(this.f5886s, th, coreSubscriberArr[i].currentContext());
                            int length4 = coreSubscriberArr.length;
                            while (i6 < length4) {
                                coreSubscriberArr[i6].onError(thOnOperatorError);
                                i6++;
                            }
                            return;
                        }
                    } else {
                        i10++;
                    }
                    i++;
                    if (i == length) {
                        i = 0;
                    }
                    if (i10 == length) {
                        int i11 = this.wip;
                        if (i11 == iAddAndGet) {
                            this.index = i;
                            iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                            if (iAddAndGet == 0) {
                                return;
                            }
                        } else {
                            iAddAndGet = i11;
                        }
                    }
                }
                queue.clear();
                return;
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers).map(new W(1));
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, currentContext());
            } else if (this.sourceMode != 0 || this.queue.offer(t9)) {
                drain();
            } else {
                onError(Operators.onOperatorError(this.f5886s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5886s, eVar)) {
                this.f5886s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
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
                        eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = this.queueSupplier.get();
                setupSubscribers();
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5886s;
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
            int i = 0;
            while (i < length && !this.cancelled) {
                int i6 = i + 1;
                SUBSCRIBER_COUNT.lazySet(this, i6);
                this.subscribers[i].onSubscribe(new ParallelSourceInner(this, i, length));
                i = i6;
            }
        }
    }

    public ParallelSource(Z9.c cVar, int i, int i6, Supplier<Queue<T>> supplier) {
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "parallelism > 0 required but it was "));
        }
        if (i6 <= 0) {
            throw new IllegalArgumentException(B7.a.h(i6, "prefetch > 0 required but it was "));
        }
        this.source = Operators.toFluxOrMono(cVar);
        this.parallelism = i;
        this.prefetch = i6;
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
