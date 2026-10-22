package reactor.core.publisher;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
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

/* loaded from: classes5.dex */
final class FluxGroupBy<T, K, V> extends InternalFluxOperator<T, GroupedFlux<K, V>> implements Fuseable {
    final Supplier<? extends Queue<V>> groupQueueSupplier;
    final Function<? super T, ? extends K> keySelector;
    final Supplier<? extends Queue<GroupedFlux<K, V>>> mainQueueSupplier;
    final int prefetch;
    final Function<? super T, ? extends V> valueSelector;

    public static final class GroupByMain<T, K, V> implements Fuseable.QueueSubscription<GroupedFlux<K, V>>, InnerOperator<T, GroupedFlux<K, V>> {
        final CoreSubscriber<? super GroupedFlux<K, V>> actual;
        volatile int cancelled;
        volatile boolean done;
        volatile boolean enableAsyncFusion;
        volatile Throwable error;
        volatile int groupCount;
        final Map<K, UnicastGroupedFlux<K, V>> groupMap = new ConcurrentHashMap();
        final Supplier<? extends Queue<V>> groupQueueSupplier;
        final Function<? super T, ? extends K> keySelector;
        final int prefetch;
        final Queue<GroupedFlux<K, V>> queue;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39514s;
        final Function<? super T, ? extends V> valueSelector;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<GroupByMain> WIP = AtomicIntegerFieldUpdater.newUpdater(GroupByMain.class, "wip");
        static final AtomicLongFieldUpdater<GroupByMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(GroupByMain.class, "requested");
        static final AtomicReferenceFieldUpdater<GroupByMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(GroupByMain.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<GroupByMain> CANCELLED = AtomicIntegerFieldUpdater.newUpdater(GroupByMain.class, "cancelled");
        static final AtomicIntegerFieldUpdater<GroupByMain> GROUP_COUNT = AtomicIntegerFieldUpdater.newUpdater(GroupByMain.class, "groupCount");

        public GroupByMain(CoreSubscriber<? super GroupedFlux<K, V>> coreSubscriber, Queue<GroupedFlux<K, V>> queue, Supplier<? extends Queue<V>> supplier, int i10, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
            this.actual = coreSubscriber;
            this.queue = queue;
            this.groupQueueSupplier = supplier;
            this.prefetch = i10;
            this.keySelector = function;
            this.valueSelector = function2;
            GROUP_COUNT.lazySet(this, 1);
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super GroupedFlux<K, V>> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void cancel() {
            if (CANCELLED.compareAndSet(this, 0, 1)) {
                if (GROUP_COUNT.decrementAndGet(this) == 0) {
                    this.f39514s.cancel();
                    return;
                }
                if (this.enableAsyncFusion || WIP.getAndIncrement(this) != 0) {
                    return;
                }
                while (true) {
                    GroupedFlux<K, V> groupedFluxPoll = this.queue.poll();
                    if (groupedFluxPoll == null) {
                        break;
                    } else {
                        ((UnicastGroupedFlux) groupedFluxPoll).cancel();
                    }
                }
                if (WIP.decrementAndGet(this) == 0) {
                    return;
                }
                drainLoop();
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, qc.c<?> cVar, Queue<GroupedFlux<K, V>> queue) {
            if (!z10) {
                return false;
            }
            Throwable th = this.error;
            if (th != null && th != Exceptions.TERMINATED) {
                queue.clear();
                signalAsyncError();
                return true;
            }
            if (!z11) {
                return false;
            }
            cVar.onComplete();
            return true;
        }

        @Override // java.util.Collection
        public void clear() {
            this.queue.clear();
        }

        public void drain() {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            if (this.enableAsyncFusion) {
                drainFused();
            } else {
                drainLoop();
            }
        }

        public void drainFused() {
            CoreSubscriber<? super GroupedFlux<K, V>> coreSubscriber = this.actual;
            Queue<GroupedFlux<K, V>> queue = this.queue;
            int iAddAndGet = 1;
            while (this.cancelled == 0) {
                boolean z10 = this.done;
                coreSubscriber.onNext(null);
                if (z10) {
                    if (this.error != null) {
                        signalAsyncError();
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
            queue.clear();
        }

        public void drainLoop() {
            CoreSubscriber<? super GroupedFlux<K, V>> coreSubscriber = this.actual;
            Queue<GroupedFlux<K, V>> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested;
                long j11 = 0;
                while (j11 != j10) {
                    boolean z10 = this.done;
                    GroupedFlux<K, V> groupedFluxPoll = queue.poll();
                    boolean z11 = groupedFluxPoll == null;
                    if (checkTerminated(z10, z11, coreSubscriber, queue)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    coreSubscriber.onNext(groupedFluxPoll);
                    j11++;
                }
                if (j11 == j10 && checkTerminated(this.done, queue.isEmpty(), coreSubscriber, queue)) {
                    return;
                }
                if (j11 != 0) {
                    this.f39514s.request(j11);
                    if (j10 != Long.MAX_VALUE) {
                        REQUESTED.addAndGet(this, -j11);
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void groupTerminated(K k10) {
            if (this.groupCount == 0) {
                return;
            }
            this.groupMap.remove(k10);
            int iDecrementAndGet = GROUP_COUNT.decrementAndGet(this);
            if (iDecrementAndGet == 0) {
                this.f39514s.cancel();
            } else if (iDecrementAndGet == 1) {
                this.f39514s.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return this.groupMap.values().stream();
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
            Iterator<UnicastGroupedFlux<K, V>> it = this.groupMap.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groupMap.clear();
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                K kApply = this.keySelector.apply(t10);
                Objects.requireNonNull(kApply, "The keySelector returned a null value");
                V vApply = this.valueSelector.apply(t10);
                Objects.requireNonNull(vApply, "The valueSelector returned a null value");
                UnicastGroupedFlux<K, V> unicastGroupedFlux = this.groupMap.get(kApply);
                if (unicastGroupedFlux != null) {
                    unicastGroupedFlux.onNext(vApply);
                    return;
                }
                if (this.cancelled == 0) {
                    Queue<V> queue = this.groupQueueSupplier.get();
                    GROUP_COUNT.getAndIncrement(this);
                    UnicastGroupedFlux<K, V> unicastGroupedFlux2 = new UnicastGroupedFlux<>(kApply, queue, this, this.prefetch);
                    unicastGroupedFlux2.onNext(vApply);
                    this.groupMap.put(kApply, unicastGroupedFlux2);
                    this.queue.offer(unicastGroupedFlux2);
                    drain();
                }
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f39514s, th, t10, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39514s, dVar)) {
                this.f39514s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain();
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.enableAsyncFusion = true;
            return 2;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39514s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue.size());
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled == 1);
            }
            return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void signalAsyncError() {
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            if (thTerminate == null) {
                thTerminate = new IllegalStateException("FluxGroupBy.signalAsyncError called without error set");
            }
            this.groupCount = 0;
            Iterator<UnicastGroupedFlux<K, V>> it = this.groupMap.values().iterator();
            while (it.hasNext()) {
                it.next().onError(thTerminate);
            }
            this.actual.onError(thTerminate);
            this.groupMap.clear();
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }

        @Override // java.util.Queue
        @Nullable
        public GroupedFlux<K, V> poll() {
            return this.queue.poll();
        }
    }

    public static final class UnicastGroupedFlux<K, V> extends GroupedFlux<K, V> implements Fuseable, Fuseable.QueueSubscription<V>, InnerProducer<V> {
        volatile CoreSubscriber<? super V> actual;
        volatile boolean cancelled;
        final Context context;
        volatile boolean done;
        Throwable error;
        boolean isFirstRequest = true;
        final K key;
        final int limit;
        volatile int once;
        volatile boolean outputFused;
        volatile GroupByMain<?, K, V> parent;
        int produced;
        final Queue<V> queue;
        volatile long requested;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<UnicastGroupedFlux, GroupByMain> PARENT = AtomicReferenceFieldUpdater.newUpdater(UnicastGroupedFlux.class, GroupByMain.class, "parent");
        static final AtomicReferenceFieldUpdater<UnicastGroupedFlux, CoreSubscriber> ACTUAL = AtomicReferenceFieldUpdater.newUpdater(UnicastGroupedFlux.class, CoreSubscriber.class, "actual");
        static final AtomicIntegerFieldUpdater<UnicastGroupedFlux> ONCE = AtomicIntegerFieldUpdater.newUpdater(UnicastGroupedFlux.class, "once");
        static final AtomicIntegerFieldUpdater<UnicastGroupedFlux> WIP = AtomicIntegerFieldUpdater.newUpdater(UnicastGroupedFlux.class, "wip");
        static final AtomicLongFieldUpdater<UnicastGroupedFlux> REQUESTED = AtomicLongFieldUpdater.newUpdater(UnicastGroupedFlux.class, "requested");

        public UnicastGroupedFlux(K k10, Queue<V> queue, GroupByMain<?, K, V> groupByMain, int i10) {
            this.key = k10;
            this.queue = queue;
            this.context = groupByMain.currentContext();
            this.parent = groupByMain;
            this.limit = Operators.unboundedOrLimit(i10);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super V> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            doTerminate();
            if (this.outputFused || WIP.getAndIncrement(this) != 0) {
                return;
            }
            this.queue.clear();
        }

        public boolean checkTerminated(boolean z10, boolean z11, qc.c<?> cVar, Queue<?> queue) {
            if (this.cancelled) {
                queue.clear();
                this.actual = null;
                return true;
            }
            if (!z10 || !z11) {
                return false;
            }
            Throwable th = this.error;
            this.actual = null;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
            return true;
        }

        @Override // java.util.Collection
        public void clear() {
            this.queue.clear();
        }

        public void doTerminate() {
            GroupByMain<?, K, V> groupByMain = this.parent;
            if (groupByMain == null || !PARENT.compareAndSet(this, groupByMain, null)) {
                return;
            }
            groupByMain.groupTerminated(this.key);
        }

        public void drain() {
            CoreSubscriber<? super V> coreSubscriber = this.actual;
            if (coreSubscriber == null || WIP.getAndIncrement(this) != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused(coreSubscriber);
            } else {
                drainRegular(coreSubscriber);
            }
        }

        public void drainFused(qc.c<? super V> cVar) {
            Queue<V> queue = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                cVar.onNext(null);
                if (z10) {
                    this.actual = null;
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
            queue.clear();
            this.actual = null;
        }

        public void drainRegular(qc.c<? super V> cVar) {
            long j10;
            Queue<V> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j11 = this.requested;
                long j12 = 0;
                while (true) {
                    if (j11 == j12) {
                        j10 = 0;
                        break;
                    }
                    boolean z10 = this.done;
                    V vPoll = queue.poll();
                    boolean z11 = vPoll == null;
                    j10 = 0;
                    if (checkTerminated(z10, z11, cVar, queue)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    cVar.onNext(vPoll);
                    j12++;
                }
                if (j11 == j12 && checkTerminated(this.done, queue.isEmpty(), cVar, queue)) {
                    return;
                }
                if (j12 != j10) {
                    GroupByMain<?, K, V> groupByMain = this.parent;
                    if (groupByMain != null) {
                        if (this.isFirstRequest) {
                            this.isFirstRequest = false;
                            long j13 = j12 - 1;
                            if (j13 > j10) {
                                groupByMain.f39514s.request(j13);
                            }
                        } else {
                            groupByMain.f39514s.request(j12);
                        }
                    }
                    if (j11 != Long.MAX_VALUE) {
                        REQUESTED.addAndGet(this, -j12);
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            if (!this.queue.isEmpty()) {
                return false;
            }
            tryReplenish();
            return true;
        }

        @Override // reactor.core.publisher.GroupedFlux
        public K key() {
            return this.key;
        }

        public void onComplete() {
            this.done = true;
            doTerminate();
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            doTerminate();
            drain();
        }

        public void onNext(V v10) {
            CoreSubscriber<? super V> coreSubscriber = this.actual;
            if (!this.queue.offer(v10)) {
                onError(Operators.onOperatorError(this, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), v10, this.actual.currentContext()));
            } else if (!this.outputFused) {
                drain();
            } else if (coreSubscriber != null) {
                coreSubscriber.onNext(null);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public V poll() {
            V vPoll = this.queue.poll();
            if (vPoll != null) {
                this.produced++;
                return vPoll;
            }
            tryReplenish();
            return vPoll;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain();
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

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.parent;
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
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            Queue<V> queue = this.queue;
            return Integer.valueOf(queue != null ? queue.size() : 0);
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }

        @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
        public void subscribe(CoreSubscriber<? super V> coreSubscriber) {
            if (this.once != 0 || !ONCE.compareAndSet(this, 0, 1)) {
                Operators.error(coreSubscriber, new IllegalStateException("GroupedFlux allows only one Subscriber"));
                return;
            }
            coreSubscriber.onSubscribe(this);
            ACTUAL.lazySet(this, coreSubscriber);
            drain();
        }

        public void tryReplenish() {
            int i10 = this.produced;
            if (i10 != 0) {
                this.produced = 0;
                GroupByMain<?, K, V> groupByMain = this.parent;
                if (groupByMain != null) {
                    if (!this.isFirstRequest) {
                        groupByMain.f39514s.request(i10);
                        return;
                    }
                    this.isFirstRequest = false;
                    int i11 = i10 - 1;
                    if (i11 > 0) {
                        groupByMain.f39514s.request(i11);
                    }
                }
            }
        }
    }

    public FluxGroupBy(Flux<? extends T> flux, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Supplier<? extends Queue<GroupedFlux<K, V>>> supplier, Supplier<? extends Queue<V>> supplier2, int i10) {
        super(flux);
        if (i10 <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i10);
        }
        Objects.requireNonNull(function, "keySelector");
        this.keySelector = function;
        Objects.requireNonNull(function2, "valueSelector");
        this.valueSelector = function2;
        Objects.requireNonNull(supplier, "mainQueueSupplier");
        this.mainQueueSupplier = supplier;
        Objects.requireNonNull(supplier2, "groupQueueSupplier");
        this.groupQueueSupplier = supplier2;
        this.prefetch = i10;
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
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super GroupedFlux<K, V>> coreSubscriber) {
        return new GroupByMain(coreSubscriber, this.mainQueueSupplier.get(), this.groupQueueSupplier, this.prefetch, this.keySelector, this.valueSelector);
    }
}
