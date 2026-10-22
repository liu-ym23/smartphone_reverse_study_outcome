package reactor.core.publisher;

import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxCombineLatest<T, R> extends Flux<R> implements Fuseable, SourceProducer<R> {
    final Z9.c[] array;
    final Function<Object[], R> combiner;
    final Iterable<? extends Z9.c> iterable;
    final int prefetch;
    final Supplier<? extends Queue<SourceAndArray>> queueSupplier;

    public static final class CombineLatestCoordinator<T, R> implements Fuseable.QueueSubscription<R>, InnerProducer<R> {
        final CoreSubscriber<? super R> actual;
        volatile boolean cancelled;
        final Function<Object[], R> combiner;
        int completedSources;
        volatile boolean done;
        volatile Throwable error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final Queue<SourceAndArray> queue;
        volatile long requested;
        final CombineLatestInner<T>[] subscribers;
        volatile int wip;
        static final AtomicLongFieldUpdater<CombineLatestCoordinator> REQUESTED = AtomicLongFieldUpdater.newUpdater(CombineLatestCoordinator.class, "requested");
        static final AtomicIntegerFieldUpdater<CombineLatestCoordinator> WIP = AtomicIntegerFieldUpdater.newUpdater(CombineLatestCoordinator.class, "wip");
        static final AtomicReferenceFieldUpdater<CombineLatestCoordinator, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(CombineLatestCoordinator.class, Throwable.class, "error");

        public CombineLatestCoordinator(CoreSubscriber<? super R> coreSubscriber, Function<Object[], R> function, int i, Queue<SourceAndArray> queue, int i6) {
            this.actual = coreSubscriber;
            this.combiner = function;
            CombineLatestInner<T>[] combineLatestInnerArr = new CombineLatestInner[i];
            for (int i10 = 0; i10 < i; i10++) {
                combineLatestInnerArr[i10] = new CombineLatestInner<>(this, i10, i6);
            }
            this.subscribers = combineLatestInnerArr;
            this.latest = new Object[i];
            this.queue = queue;
        }

        private void discardQueue(Queue<SourceAndArray> queue) {
            Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), new C1885a(8));
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (WIP.getAndIncrement(this) == 0) {
                clear();
            }
        }

        public void cancelAll() {
            for (CombineLatestInner<T> combineLatestInner : this.subscribers) {
                combineLatestInner.cancel();
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, Queue<SourceAndArray> queue) {
            if (this.cancelled) {
                cancelAll();
                discardQueue(queue);
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate != null && thTerminate != Exceptions.TERMINATED) {
                cancelAll();
                discardQueue(queue);
                this.actual.onError(thTerminate);
                return true;
            }
            if (!z11) {
                return false;
            }
            cancelAll();
            this.actual.onComplete();
            return true;
        }

        @Override // java.util.Collection
        public void clear() {
            discardQueue(this.queue);
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            if (this.outputFused) {
                drainOutput();
            } else {
                drainAsync();
            }
        }

        public void drainAsync() {
            Queue<SourceAndArray> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j5 = this.requested;
                long j6 = 0;
                while (j6 != j5) {
                    boolean z10 = this.done;
                    SourceAndArray sourceAndArrayPoll = queue.poll();
                    boolean z11 = sourceAndArrayPoll == null;
                    if (checkTerminated(z10, z11, queue)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    try {
                        R rApply = this.combiner.apply(sourceAndArrayPoll.array);
                        Objects.requireNonNull(rApply, "Combiner returned null");
                        this.actual.onNext(rApply);
                        sourceAndArrayPoll.source.requestOne();
                        j6++;
                    } catch (Throwable th) {
                        Context contextCurrentContext = this.actual.currentContext();
                        Operators.onDiscardMultiple((Stream<?>) Stream.of(sourceAndArrayPoll.array), contextCurrentContext);
                        Throwable thOnOperatorError = Operators.onOperatorError(this, th, sourceAndArrayPoll.array, contextCurrentContext);
                        AtomicReferenceFieldUpdater<CombineLatestCoordinator, Throwable> atomicReferenceFieldUpdater = ERROR;
                        Exceptions.addThrowable(atomicReferenceFieldUpdater, this, thOnOperatorError);
                        this.actual.onError(Exceptions.terminate(atomicReferenceFieldUpdater, this));
                        return;
                    }
                }
                if (j6 == j5 && checkTerminated(this.done, queue.isEmpty(), queue)) {
                    return;
                }
                if (j6 != 0 && j5 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -j6);
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void drainOutput() {
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            Queue<SourceAndArray> queue = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                Throwable th = this.error;
                if (th != null) {
                    discardQueue(queue);
                    coreSubscriber.onError(th);
                    return;
                }
                boolean z10 = this.done;
                boolean zIsEmpty = queue.isEmpty();
                if (!zIsEmpty) {
                    coreSubscriber.onNext(null);
                }
                if (z10 && zIsEmpty) {
                    coreSubscriber.onComplete();
                    return;
                } else {
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            discardQueue(queue);
        }

        public void innerComplete(int i) {
            int i6;
            synchronized (this) {
                try {
                    Object[] objArr = this.latest;
                    if (objArr[i] != null && (i6 = this.completedSources + 1) != objArr.length) {
                        this.completedSources = i6;
                    } else {
                        this.done = true;
                        drain();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void innerError(Throwable th) {
            if (Exceptions.addThrowable(ERROR, this, th)) {
                this.done = true;
                drain();
            } else {
                discardQueue(this.queue);
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        public void innerValue(int i, T t9) {
            boolean z10;
            synchronized (this) {
                try {
                    Object[] objArr = this.latest;
                    int i6 = this.nonEmptySources;
                    if (objArr[i] == null) {
                        i6++;
                        this.nonEmptySources = i6;
                    }
                    objArr[i] = t9;
                    if (objArr.length == i6) {
                        if (!this.queue.offer(new SourceAndArray(this.subscribers[i], (Object[]) objArr.clone()))) {
                            innerError(Operators.onOperatorError(this, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), this.actual.currentContext()));
                            return;
                        }
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        this.subscribers[i].requestOne();
                    } else {
                        drain();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // java.util.Queue
        @Nullable
        public R poll() {
            SourceAndArray sourceAndArrayPoll = this.queue.poll();
            if (sourceAndArrayPoll == null) {
                return null;
            }
            R rApply = this.combiner.apply(sourceAndArrayPoll.array);
            sourceAndArrayPoll.source.requestOne();
            return rApply;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
                drain();
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int i6 = i & 2;
            this.outputFused = i6 != 0;
            return i6;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }

        public void subscribe(Z9.c[] cVarArr, int i) {
            CombineLatestInner<T>[] combineLatestInnerArr = this.subscribers;
            for (int i6 = 0; i6 < i && !this.done && !this.cancelled; i6++) {
                cVarArr[i6].subscribe(combineLatestInnerArr[i6]);
            }
        }
    }

    public static final class CombineLatestInner<T> implements InnerConsumer<T> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<CombineLatestInner, Z9.e> f5711S = AtomicReferenceFieldUpdater.newUpdater(CombineLatestInner.class, Z9.e.class, "s");
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5712s;

        public CombineLatestInner(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i6) {
            this.parent = combineLatestCoordinator;
            this.index = i;
            this.prefetch = i6;
            this.limit = Operators.unboundedOrLimit(i6);
        }

        public void cancel() {
            Operators.terminate(f5711S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.parent.innerValue(this.index, t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5711S, this, eVar)) {
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        public void requestOne() {
            int i = this.produced + 1;
            if (i != this.limit) {
                this.produced = i;
            } else {
                this.produced = 0;
                this.f5712s.request(i);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5712s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5712s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static final class SourceAndArray {
        final Object[] array;
        final CombineLatestInner<?> source;

        public SourceAndArray(CombineLatestInner<?> combineLatestInner, Object[] objArr) {
            this.source = combineLatestInner;
            this.array = objArr;
        }

        public final Stream<?> toStream() {
            return Stream.of(this.array);
        }
    }

    public FluxCombineLatest(Z9.c[] cVarArr, Function<Object[], R> function, Supplier<? extends Queue<SourceAndArray>> supplier, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        Objects.requireNonNull(cVarArr, "array");
        this.array = cVarArr;
        this.iterable = null;
        Objects.requireNonNull(function, "combiner");
        this.combiner = function;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
        this.prefetch = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$subscribe$0(Object obj) {
        return this.combiner.apply(new Object[]{obj});
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super R> coreSubscriber) {
        int length;
        Z9.c[] cVarArr = this.array;
        if (cVarArr == null) {
            cVarArr = new Z9.c[8];
            try {
                Iterator<? extends Z9.c> it = this.iterable.iterator();
                Objects.requireNonNull(it, "The iterator returned is null");
                Iterator<? extends Z9.c> it2 = it;
                length = 0;
                while (it2.hasNext()) {
                    try {
                        try {
                            Z9.c next = it2.next();
                            Objects.requireNonNull(next, "The Publisher returned by the iterator is null");
                            Z9.c cVar = next;
                            if (length == cVarArr.length) {
                                Z9.c[] cVarArr2 = new Z9.c[(length >> 2) + length];
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                                cVarArr = cVarArr2;
                            }
                            cVarArr[length] = cVar;
                            length++;
                        } catch (Throwable th) {
                            com.stepos.statsrpk.service.c.t(coreSubscriber, th, coreSubscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        com.stepos.statsrpk.service.c.t(coreSubscriber, th2, coreSubscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                com.stepos.statsrpk.service.c.t(coreSubscriber, th3, coreSubscriber);
                return;
            }
        } else {
            length = cVarArr.length;
        }
        int i = length;
        if (i == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (i == 1) {
            I i6 = new I(this, 0);
            Z9.c cVar2 = cVarArr[0];
            if (cVar2 instanceof Fuseable) {
                new FluxMapFuseable(Flux.from(cVar2), i6).subscribe((CoreSubscriber) coreSubscriber);
                return;
            } else if (!(coreSubscriber instanceof Fuseable.QueueSubscription)) {
                new FluxMap(Flux.from(cVar2), i6).subscribe((CoreSubscriber) coreSubscriber);
                return;
            }
        }
        Operators.toFluxOrMono(cVarArr);
        CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(coreSubscriber, this.combiner, i, this.queueSupplier.get(), this.prefetch);
        coreSubscriber.onSubscribe(combineLatestCoordinator);
        combineLatestCoordinator.subscribe(cVarArr, i);
    }

    public FluxCombineLatest(Iterable<? extends Z9.c> iterable, Function<Object[], R> function, Supplier<? extends Queue<SourceAndArray>> supplier, int i) {
        if (i >= 0) {
            this.array = null;
            Objects.requireNonNull(iterable, "iterable");
            this.iterable = iterable;
            Objects.requireNonNull(function, "combiner");
            this.combiner = function;
            Objects.requireNonNull(supplier, "queueSupplier");
            this.queueSupplier = supplier;
            this.prefetch = i;
            return;
        }
        throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
    }
}
