package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class ParallelMergeReduce<T> extends Mono<T> implements Scannable, Fuseable {
    final BiFunction<T, T, T> reducer;
    final ParallelFlux<? extends T> source;

    public static final class MergeReduceInner<T> implements InnerConsumer<T> {

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<MergeReduceInner, Z9.e> f5880S = AtomicReferenceFieldUpdater.newUpdater(MergeReduceInner.class, Z9.e.class, "s");
        boolean done;
        final MergeReduceMain<T> parent;
        final BiFunction<T, T, T> reducer;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5881s;
        T value;

        public MergeReduceInner(MergeReduceMain<T> mergeReduceMain, BiFunction<T, T, T> biFunction) {
            this.parent = mergeReduceMain;
            this.reducer = biFunction;
        }

        public void cancel() {
            Operators.terminate(f5880S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, currentContext());
                return;
            }
            T t10 = this.value;
            if (t10 == null) {
                this.value = t9;
                return;
            }
            try {
                T tApply = this.reducer.apply(t10, t9);
                Objects.requireNonNull(tApply, "The reducer returned a null value");
                this.value = tApply;
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f5881s, th, t9, currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5880S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5881s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f5881s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.value != null ? 1 : 0);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.MAX_VALUE;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static final class MergeReduceMain<T> implements InnerProducer<T>, Fuseable, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        volatile SlotPair<T> current;
        volatile Throwable error;
        final BiFunction<T, T, T> reducer;
        volatile int remaining;
        final ParallelFlux<? extends T> source;
        final MergeReduceInner<T>[] subscribers;
        static final AtomicReferenceFieldUpdater<MergeReduceMain, SlotPair> CURRENT = AtomicReferenceFieldUpdater.newUpdater(MergeReduceMain.class, SlotPair.class, "current");
        static final AtomicIntegerFieldUpdater<MergeReduceMain> REMAINING = AtomicIntegerFieldUpdater.newUpdater(MergeReduceMain.class, "remaining");
        static final AtomicReferenceFieldUpdater<MergeReduceMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(MergeReduceMain.class, Throwable.class, "error");

        public MergeReduceMain(ParallelFlux<? extends T> parallelFlux, CoreSubscriber<? super T> coreSubscriber, int i, BiFunction<T, T, T> biFunction) {
            this.actual = coreSubscriber;
            this.source = parallelFlux;
            MergeReduceInner<T>[] mergeReduceInnerArr = new MergeReduceInner[i];
            for (int i6 = 0; i6 < i; i6++) {
                mergeReduceInnerArr[i6] = new MergeReduceInner<>(this, biFunction);
            }
            this.subscribers = mergeReduceInnerArr;
            this.reducer = biFunction;
            REMAINING.lazySet(this, Integer.MIN_VALUE | i);
        }

        public static <T> int decrementAndGet(MergeReduceMain<T> mergeReduceMain) {
            int i;
            int i6;
            do {
                i = mergeReduceMain.remaining;
                if (i == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                i6 = i - 1;
            } while (!REMAINING.compareAndSet(mergeReduceMain, i, i6));
            return i6;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Nullable
        public SlotPair<T> addValue(T t9) {
            SlotPair<T> slotPair;
            int iTryAcquireSlot;
            while (true) {
                slotPair = this.current;
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!CURRENT.compareAndSet(this, null, slotPair)) {
                        continue;
                    }
                }
                iTryAcquireSlot = slotPair.tryAcquireSlot();
                if (iTryAcquireSlot >= 0) {
                    break;
                }
                CURRENT.compareAndSet(this, slotPair, null);
            }
            if (iTryAcquireSlot == 0) {
                slotPair.first = t9;
            } else {
                slotPair.second = t9;
            }
            if (!slotPair.releaseSlot()) {
                return null;
            }
            CURRENT.compareAndSet(this, slotPair, null);
            return slotPair;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if ((REMAINING.getAndSet(this, Integer.MIN_VALUE) & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                for (MergeReduceInner<T> mergeReduceInner : this.subscribers) {
                    mergeReduceInner.cancel();
                }
            }
        }

        @Override // java.util.Collection
        public void clear() {
        }

        public void innerComplete(@Nullable T t9) {
            if (t9 != null) {
                while (true) {
                    SlotPair<T> slotPairAddValue = addValue(t9);
                    if (slotPairAddValue == null) {
                        break;
                    }
                    try {
                        t9 = this.reducer.apply(slotPairAddValue.first, slotPairAddValue.second);
                        Objects.requireNonNull(t9, "The reducer returned a null value");
                    } catch (Throwable th) {
                        innerError(Operators.onOperatorError(this, th, this.actual.currentContext()));
                        return;
                    }
                }
            }
            if (decrementAndGet(this) == 0) {
                SlotPair<T> slotPair = this.current;
                CURRENT.lazySet(this, null);
                if (slotPair == null) {
                    this.actual.onComplete();
                } else {
                    this.actual.onNext(slotPair.first);
                    this.actual.onComplete();
                }
            }
        }

        public void innerError(Throwable th) {
            if (ERROR.compareAndSet(this, null, th)) {
                cancel();
                this.actual.onError(th);
            } else if (this.error != th) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Queue
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            int i = this.remaining;
            if ((i & Integer.MIN_VALUE) == Integer.MIN_VALUE && REMAINING.compareAndSet(this, i, Integer.MAX_VALUE & i)) {
                this.source.subscribe(this.subscribers);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.remaining == 0);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.remaining == Integer.MIN_VALUE);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }
    }

    public static final class SlotPair<T> {
        static final AtomicIntegerFieldUpdater<SlotPair> ACQ = AtomicIntegerFieldUpdater.newUpdater(SlotPair.class, "acquireIndex");
        static final AtomicIntegerFieldUpdater<SlotPair> REL = AtomicIntegerFieldUpdater.newUpdater(SlotPair.class, "releaseIndex");
        volatile int acquireIndex;
        T first;
        volatile int releaseIndex;
        T second;

        public boolean releaseSlot() {
            return REL.incrementAndGet(this) == 2;
        }

        public int tryAcquireSlot() {
            int i;
            do {
                i = this.acquireIndex;
                if (i >= 2) {
                    return -1;
                }
            } while (!ACQ.compareAndSet(this, i, i + 1));
            return i;
        }
    }

    public ParallelMergeReduce(ParallelFlux<? extends T> parallelFlux, BiFunction<T, T, T> biFunction) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.reducer = biFunction;
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        ParallelFlux<? extends T> parallelFlux = this.source;
        coreSubscriber.onSubscribe(new MergeReduceMain(parallelFlux, coreSubscriber, parallelFlux.parallelism(), this.reducer));
    }
}
