package reactor.core.publisher;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiFunction;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ParallelMergeReduce<T> extends Mono<T> implements Scannable, Fuseable {
    final BiFunction<T, T, T> reducer;
    final ParallelFlux<? extends T> source;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MergeReduceInner<T> implements InnerConsumer<T> {
        static final AtomicReferenceFieldUpdater<MergeReduceInner, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(MergeReduceInner.class, qd.e.class, "s");
        boolean done;
        final MergeReduceMain<T> parent;
        final BiFunction<T, T, T> reducer;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10746s;
        T value;

        public MergeReduceInner(MergeReduceMain<T> mergeReduceMain, BiFunction<T, T, T> biFunction) {
            this.parent = mergeReduceMain;
            this.reducer = biFunction;
        }

        public void cancel() {
            Operators.terminate(S, this);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.parent.actual.currentContext());
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, currentContext());
                return;
            }
            T t11 = this.value;
            if (t11 == null) {
                this.value = t10;
                return;
            }
            try {
                T tApply = this.reducer.apply(t11, t10);
                Objects.requireNonNull(tApply, "The reducer returned a null value");
                this.value = tApply;
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this.f10746s, th, t10, currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10746s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.f10746s;
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
                return Integer.valueOf(Reader.READ_DONE);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
            for (int i3 = 0; i3 < i; i3++) {
                mergeReduceInnerArr[i3] = new MergeReduceInner<>(this, biFunction);
            }
            this.subscribers = mergeReduceInnerArr;
            this.reducer = biFunction;
            REMAINING.lazySet(this, Integer.MIN_VALUE | i);
        }

        public static <T> int decrementAndGet(MergeReduceMain<T> mergeReduceMain) {
            int i;
            int i3;
            do {
                i = mergeReduceMain.remaining;
                if (i == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                i3 = i - 1;
            } while (!REMAINING.compareAndSet(mergeReduceMain, i, i3));
            return i3;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Nullable
        public SlotPair<T> addValue(T t10) {
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
                slotPair.first = t10;
            } else {
                slotPair.second = t10;
            }
            if (!slotPair.releaseSlot()) {
                return null;
            }
            CURRENT.compareAndSet(this, slotPair, null);
            return slotPair;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if ((REMAINING.getAndSet(this, Integer.MIN_VALUE) & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
                for (MergeReduceInner<T> mergeReduceInner : this.subscribers) {
                    mergeReduceInner.cancel();
                }
            }
        }

        public void innerComplete(@Nullable T t10) {
            if (t10 != null) {
                while (true) {
                    SlotPair<T> slotPairAddValue = addValue(t10);
                    if (slotPairAddValue == null) {
                        break;
                    }
                    try {
                        t10 = this.reducer.apply(slotPairAddValue.first, slotPairAddValue.second);
                        Objects.requireNonNull(t10, "The reducer returned a null value");
                    } catch (Throwable th) {
                        innerError(Operators.onOperatorError(this, th, this.actual.currentContext()));
                        return;
                    }
                }
            }
            if (decrementAndGet(this) == 0) {
                SlotPair<T> slotPair = this.current;
                CURRENT.lazySet(this, null);
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                if (slotPair == null) {
                    coreSubscriber.onComplete();
                } else {
                    coreSubscriber.onNext(slotPair.first);
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

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
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

        @Override // java.util.Collection
        public void clear() {
        }
    }
}
