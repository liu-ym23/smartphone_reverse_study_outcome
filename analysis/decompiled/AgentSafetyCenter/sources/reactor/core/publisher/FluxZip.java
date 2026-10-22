package reactor.core.publisher;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxZip<T, R> extends Flux<R> implements SourceProducer<R> {
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;
    final qd.c[] sources;
    final Iterable<? extends qd.c> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class PairwiseZipper<R> implements Function<Object[], R> {
        final BiFunction[] zippers;

        public PairwiseZipper(BiFunction[] biFunctionArr) {
            this.zippers = biFunctionArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(Object[] objArr) {
            int i = 1;
            T t10 = (R) this.zippers[0].apply(objArr[0], objArr[1]);
            while (true) {
                BiFunction[] biFunctionArr = this.zippers;
                if (i >= biFunctionArr.length) {
                    return (R) t10;
                }
                BiFunction biFunction = biFunctionArr[i];
                i++;
                t10 = (R) biFunction.apply(t10, objArr[i]);
            }
        }

        public PairwiseZipper then(BiFunction biFunction) {
            BiFunction[] biFunctionArr = this.zippers;
            int length = biFunctionArr.length;
            BiFunction[] biFunctionArr2 = new BiFunction[length + 1];
            System.arraycopy(biFunctionArr, 0, biFunctionArr2, 0, length);
            biFunctionArr2[length] = biFunction;
            return new PairwiseZipper(biFunctionArr2);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ZipCoordinator<T, R> implements InnerProducer<R> {
        final CoreSubscriber<? super R> actual;
        volatile boolean cancelled;
        final Object[] current;
        volatile Throwable error;
        volatile long requested;
        final ZipInner<T>[] subscribers;
        volatile int wip;
        final Function<? super Object[], ? extends R> zipper;
        static final AtomicIntegerFieldUpdater<ZipCoordinator> WIP = AtomicIntegerFieldUpdater.newUpdater(ZipCoordinator.class, "wip");
        static final AtomicLongFieldUpdater<ZipCoordinator> REQUESTED = AtomicLongFieldUpdater.newUpdater(ZipCoordinator.class, "requested");
        static final AtomicReferenceFieldUpdater<ZipCoordinator, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(ZipCoordinator.class, Throwable.class, "error");

        public ZipCoordinator(CoreSubscriber<? super R> coreSubscriber, Function<? super Object[], ? extends R> function, int i, Supplier<? extends Queue<T>> supplier, int i3) {
            this.actual = coreSubscriber;
            this.zipper = function;
            ZipInner<T>[] zipInnerArr = new ZipInner[i];
            for (int i10 = 0; i10 < i; i10++) {
                zipInnerArr[i10] = new ZipInner<>(this, i3, i10, supplier);
            }
            this.current = new Object[i];
            this.subscribers = zipInnerArr;
        }

        public static int addWork(ZipCoordinator<?, ?> zipCoordinator) {
            int i;
            do {
                i = zipCoordinator.wip;
                if (i == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } while (!WIP.compareAndSet(zipCoordinator, i, i + 1));
            return i;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (WIP.getAndIncrement(this) == 0) {
                discardAll(1);
            }
        }

        public void cancelAll() {
            for (ZipInner<T> zipInner : this.subscribers) {
                zipInner.cancel();
            }
        }

        public void discardAll(int i) {
            Context contextCurrentContext = this.actual.currentContext();
            Object[] objArr = this.current;
            Operators.onDiscardMultiple(Arrays.asList(objArr), contextCurrentContext);
            Arrays.fill(objArr, (Object) null);
            while (true) {
                for (ZipInner<T> zipInner : this.subscribers) {
                    Queue<T> queue = zipInner.queue;
                    int i3 = zipInner.sourceMode;
                    if (queue != null) {
                        if (i3 == 2) {
                            queue.clear();
                        } else {
                            Operators.onDiscardQueueWithClear(queue, contextCurrentContext, null);
                        }
                    }
                }
                int i10 = this.wip;
                if (i != i10) {
                    i = i10;
                } else if (WIP.compareAndSet(this, i, Integer.MIN_VALUE)) {
                    return;
                } else {
                    i = this.wip;
                }
            }
        }

        public void drain(@Nullable ZipInner<T> zipInner, @Nullable Object obj) {
            int i;
            long j10;
            int iAddWork = addWork(this);
            if (iAddWork != 0) {
                if (zipInner != null) {
                    if (zipInner.sourceMode == 2 && iAddWork == Integer.MIN_VALUE) {
                        zipInner.queue.clear();
                        return;
                    } else {
                        if (obj == null || !this.cancelled) {
                            return;
                        }
                        Operators.onDiscard(obj, this.actual.currentContext());
                        return;
                    }
                }
                return;
            }
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            ZipInner<T>[] zipInnerArr = this.subscribers;
            int length = zipInnerArr.length;
            Object[] objArr = this.current;
            int iAddAndGet = 1;
            do {
                long j11 = this.requested;
                long j12 = 0;
                while (true) {
                    if (j11 == j12) {
                        j10 = 0;
                        break;
                    }
                    if (this.cancelled) {
                        discardAll(iAddAndGet);
                        return;
                    }
                    if (this.error != null) {
                        cancelAll();
                        discardAll(iAddAndGet);
                        coreSubscriber.onError(Exceptions.terminate(ERROR, this));
                        return;
                    }
                    boolean z10 = false;
                    for (int i3 = 0; i3 < length; i3++) {
                        ZipInner<T> zipInner2 = zipInnerArr[i3];
                        if (objArr[i3] == null) {
                            try {
                                boolean z11 = zipInner2.done;
                                Queue<T> queue = zipInner2.queue;
                                T tPoll = queue != null ? queue.poll() : null;
                                boolean z12 = tPoll == null;
                                if (z11 && z12) {
                                    cancelAll();
                                    discardAll(iAddAndGet);
                                    coreSubscriber.onComplete();
                                    return;
                                } else if (z12) {
                                    z10 = true;
                                } else {
                                    objArr[i3] = tPoll;
                                }
                            } catch (Throwable th) {
                                Throwable thOnOperatorError = Operators.onOperatorError(th, this.actual.currentContext());
                                cancelAll();
                                discardAll(iAddAndGet);
                                AtomicReferenceFieldUpdater<ZipCoordinator, Throwable> atomicReferenceFieldUpdater = ERROR;
                                Exceptions.addThrowable(atomicReferenceFieldUpdater, this, thOnOperatorError);
                                coreSubscriber.onError(Exceptions.terminate(atomicReferenceFieldUpdater, this));
                                return;
                            }
                        }
                    }
                    j10 = 0;
                    if (z10) {
                        break;
                    }
                    try {
                        R rApply = this.zipper.apply(objArr.clone());
                        Objects.requireNonNull(rApply, "The zipper returned a null value");
                        coreSubscriber.onNext(rApply);
                        j12++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        Throwable thOnOperatorError2 = Operators.onOperatorError(null, th2, objArr.clone(), this.actual.currentContext());
                        cancelAll();
                        discardAll(iAddAndGet);
                        AtomicReferenceFieldUpdater<ZipCoordinator, Throwable> atomicReferenceFieldUpdater2 = ERROR;
                        Exceptions.addThrowable(atomicReferenceFieldUpdater2, this, thOnOperatorError2);
                        coreSubscriber.onError(Exceptions.terminate(atomicReferenceFieldUpdater2, this));
                        return;
                    }
                }
                if (j11 == j12) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.error != null) {
                        cancelAll();
                        discardAll(iAddAndGet);
                        coreSubscriber.onError(Exceptions.terminate(ERROR, this));
                        return;
                    }
                    for (int i10 = 0; i10 < length; i10++) {
                        ZipInner<T> zipInner3 = zipInnerArr[i10];
                        if (objArr[i10] == null) {
                            try {
                                boolean z13 = zipInner3.done;
                                Queue<T> queue2 = zipInner3.queue;
                                T tPoll2 = queue2 != null ? queue2.poll() : null;
                                boolean z14 = tPoll2 == null;
                                if (z13 && z14) {
                                    cancelAll();
                                    discardAll(iAddAndGet);
                                    coreSubscriber.onComplete();
                                    return;
                                } else if (!z14) {
                                    objArr[i10] = tPoll2;
                                }
                            } catch (Throwable th3) {
                                Throwable thOnOperatorError3 = Operators.onOperatorError(null, th3, objArr, this.actual.currentContext());
                                cancelAll();
                                discardAll(iAddAndGet);
                                AtomicReferenceFieldUpdater<ZipCoordinator, Throwable> atomicReferenceFieldUpdater3 = ERROR;
                                Exceptions.addThrowable(atomicReferenceFieldUpdater3, this, thOnOperatorError3);
                                coreSubscriber.onError(Exceptions.terminate(atomicReferenceFieldUpdater3, this));
                                return;
                            }
                        }
                    }
                }
                if (j12 != j10) {
                    for (ZipInner<T> zipInner4 : zipInnerArr) {
                        zipInner4.request(j12);
                    }
                    if (j11 != Long.MAX_VALUE) {
                        REQUESTED.addAndGet(this, -j12);
                    }
                }
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void error(Throwable th, int i) {
            if (Exceptions.addThrowable(ERROR, this, th)) {
                drain(null, null);
            } else {
                Operators.onErrorDropped(th, this.actual.currentContext());
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain(null, null);
            }
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void subscribe(qd.c[] cVarArr, int i) {
            ZipInner<T>[] zipInnerArr = this.subscribers;
            for (int i3 = 0; i3 < i && !this.cancelled && this.error == null; i3++) {
                ZipInner<T> zipInner = zipInnerArr[i3];
                try {
                    cVarArr[i3].subscribe(zipInner);
                } catch (Throwable th) {
                    Operators.reportThrowInSubscribe(zipInner, th);
                }
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ZipInner<T> implements InnerConsumer<T> {
        static final AtomicReferenceFieldUpdater<ZipInner, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(ZipInner.class, qd.e.class, "s");
        volatile boolean done;
        final int index;
        final int limit;
        final ZipCoordinator<T, ?> parent;
        final int prefetch;
        long produced;
        volatile Queue<T> queue;
        final Supplier<? extends Queue<T>> queueSupplier;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10716s;
        int sourceMode;

        public ZipInner(ZipCoordinator<T, ?> zipCoordinator, int i, int i3, Supplier<? extends Queue<T>> supplier) {
            this.parent = zipCoordinator;
            this.prefetch = i;
            this.index = i3;
            this.queueSupplier = supplier;
            this.limit = Operators.unboundedOrLimit(i);
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
            this.done = true;
            this.parent.drain(this, null);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
            } else {
                this.done = true;
                this.parent.error(th, this.index);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.sourceMode == 2 || this.queue.offer(t10)) {
                this.parent.drain(this, t10);
            } else {
                Operators.onDiscard(t10, currentContext());
                onError(Operators.onOperatorError(this.f10716s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain(this, null);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                    } else {
                        this.queue = this.queueSupplier.get();
                    }
                } else {
                    this.queue = this.queueSupplier.get();
                }
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                this.parent.drain(this, null);
            }
        }

        public void request(long j10) {
            if (this.sourceMode != 1) {
                long j11 = this.produced + j10;
                if (j11 < this.limit) {
                    this.produced = j11;
                } else {
                    this.produced = 0L;
                    this.f10716s.request(j11);
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10716s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10716s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue != null ? this.queue.size() : 0);
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done && this.f10716s != Operators.cancelledSubscription());
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ZipScalarCoordinator<R> implements InnerProducer<R>, Fuseable, Fuseable.QueueSubscription<R> {
        static final AtomicIntegerFieldUpdater<ZipScalarCoordinator> STATE = AtomicIntegerFieldUpdater.newUpdater(ZipScalarCoordinator.class, "state");
        final CoreSubscriber<? super R> actual;
        boolean cancelled;
        boolean done;
        final Object[] scalars;
        volatile int state;
        final Function<? super Object[], ? extends R> zipper;

        public ZipScalarCoordinator(CoreSubscriber<? super R> coreSubscriber, Function<? super Object[], ? extends R> function, Object[] objArr) {
            this.actual = coreSubscriber;
            this.zipper = function;
            this.scalars = objArr;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (this.state == 0) {
                if (STATE.compareAndSet(this, 0, 2)) {
                    Context contextCurrentContext = this.actual.currentContext();
                    for (Object obj : this.scalars) {
                        Operators.onDiscard(obj, contextCurrentContext);
                    }
                }
            }
        }

        @Override // java.util.Collection
        public void clear() {
            if (this.done || this.cancelled) {
                return;
            }
            this.cancelled = true;
            Context contextCurrentContext = this.actual.currentContext();
            for (Object obj : this.scalars) {
                Operators.onDiscard(obj, contextCurrentContext);
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.done;
        }

        @Override // java.util.Queue
        public R poll() {
            if (this.done) {
                return null;
            }
            this.done = true;
            R rApply = this.zipper.apply(this.scalars);
            Objects.requireNonNull(rApply, "The zipper returned a null value");
            return rApply;
        }

        @Override // reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (this.done) {
                return;
            }
            this.done = true;
            if (this.state == 0 && STATE.compareAndSet(this, 0, 1)) {
                try {
                    R rApply = this.zipper.apply(this.scalars);
                    Objects.requireNonNull(rApply, "The zipper returned a null value");
                    this.actual.onNext(rApply);
                    this.actual.onComplete();
                } catch (Throwable th) {
                    CoreSubscriber<? super R> coreSubscriber = this.actual;
                    coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
                }
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return i & 1;
        }

        @Override // reactor.core.publisher.InnerProducer, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(this.cancelled) : attr == Scannable.Attr.BUFFERED ? Integer.valueOf(this.scalars.length) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            return !this.done ? 1 : 0;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ZipSingleCoordinator<T, R> extends Operators.MonoSubscriber<R, R> {
        static final AtomicIntegerFieldUpdater<ZipSingleCoordinator> WIP = AtomicIntegerFieldUpdater.newUpdater(ZipSingleCoordinator.class, "wip");
        final Object[] scalars;
        final ZipSingleSubscriber<T>[] subscribers;
        volatile int wip;
        final Function<? super Object[], ? extends R> zipper;

        public ZipSingleCoordinator(CoreSubscriber<? super R> coreSubscriber, Object[] objArr, int i, int i3, Function<? super Object[], ? extends R> function) {
            super(coreSubscriber);
            this.zipper = function;
            this.scalars = objArr;
            ZipSingleSubscriber<T>[] zipSingleSubscriberArr = new ZipSingleSubscriber[i];
            for (int i10 = 0; i10 < i; i10++) {
                if (objArr[i10] == null) {
                    zipSingleSubscriberArr[i10] = new ZipSingleSubscriber<>(this, i10);
                }
            }
            this.subscribers = zipSingleSubscriberArr;
            WIP.lazySet(this, i - i3);
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            super.cancel();
            if (WIP.getAndSet(this, 0) > 0) {
                cancelAll();
            }
        }

        public void cancelAll() {
            for (ZipSingleSubscriber<T> zipSingleSubscriber : this.subscribers) {
                if (zipSingleSubscriber != null) {
                    zipSingleSubscriber.dispose();
                }
            }
            Operators.onDiscardMultiple(Arrays.asList(this.scalars), this.actual.currentContext());
        }

        public void complete(int i) {
            if (WIP.getAndSet(this, 0) > 0) {
                cancelAll();
                this.actual.onComplete();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.Operators.MonoSubscriber
        public void discard(R r10) {
            if (r10 != 0) {
                if (r10 instanceof Iterable) {
                    Operators.onDiscardMultiple((Iterator<?>) ((Iterable) r10).iterator(), true, this.actual.currentContext());
                } else if (r10.getClass().isArray()) {
                    Operators.onDiscardMultiple(Arrays.asList((Object[]) r10), this.actual.currentContext());
                } else {
                    Operators.onDiscard(r10, this.actual.currentContext());
                }
            }
        }

        public void error(Throwable th, int i) {
            if (WIP.getAndSet(this, 0) <= 0) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                cancelAll();
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.subscribers);
        }

        public void next(T t10, int i) {
            Object[] objArr = this.scalars;
            objArr[i] = t10;
            int iDecrementAndGet = WIP.decrementAndGet(this);
            if (iDecrementAndGet != 0) {
                if (iDecrementAndGet < 0) {
                    Operators.onDiscard(t10, this.actual.currentContext());
                    return;
                }
                return;
            }
            try {
                R rApply = this.zipper.apply(objArr);
                Objects.requireNonNull(rApply, "The zipper returned a null value");
                complete((ZipSingleCoordinator<T, R>) rApply);
            } catch (Throwable th) {
                CoreSubscriber<? super O> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onOperatorError(this, th, t10, coreSubscriber.currentContext()));
            }
        }

        @Override // reactor.core.publisher.Operators.MonoSubscriber, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            z = false;
            boolean z10 = false;
            if (attr != Scannable.Attr.TERMINATED) {
                if (attr == Scannable.Attr.BUFFERED) {
                    return Integer.valueOf(this.wip > 0 ? this.scalars.length : 0);
                }
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            if (this.wip == 0 && !isCancelled()) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }

        public void subscribe(int i, qd.c[] cVarArr) {
            ZipSingleSubscriber<T>[] zipSingleSubscriberArr = this.subscribers;
            for (int i3 = 0; i3 < i && this.wip > 0 && !isCancelled(); i3++) {
                ZipSingleSubscriber<T> zipSingleSubscriber = zipSingleSubscriberArr[i3];
                if (zipSingleSubscriber != null) {
                    try {
                        cVarArr[i3].subscribe(zipSingleSubscriber);
                    } catch (Throwable th) {
                        Operators.reportThrowInSubscribe(zipSingleSubscriber, th);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ZipSingleSubscriber<T> implements InnerConsumer<T>, Disposable {
        static final AtomicReferenceFieldUpdater<ZipSingleSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(ZipSingleSubscriber.class, qd.e.class, "s");
        boolean done;
        boolean hasFirstValue;
        final int index;
        final ZipSingleCoordinator<T, ?> parent;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10717s;

        public ZipSingleSubscriber(ZipSingleCoordinator<T, ?> zipSingleCoordinator, int i) {
            this.parent = zipSingleCoordinator;
            this.index = i;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            Operators.terminate(S, this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.hasFirstValue || this.done) {
                return;
            }
            this.done = true;
            this.parent.complete(this.index);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.hasFirstValue || this.done) {
                Operators.onErrorDropped(th, this.parent.currentContext());
            } else {
                this.done = true;
                this.parent.error(th, this.index);
            }
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.parent.currentContext());
            }
            if (this.hasFirstValue) {
                Operators.onDiscard(t10, this.parent.currentContext());
                return;
            }
            this.hasFirstValue = true;
            Operators.terminate(S, this);
            this.parent.next(t10, this.index);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                this.f10717s = eVar;
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10717s;
            }
            z = true;
            boolean z10 = true;
            if (attr == Scannable.Attr.TERMINATED) {
                if (!this.done && !this.hasFirstValue) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10717s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.parent.scalars[this.index] == null ? 0 : 1);
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public FluxZip(qd.c[] cVarArr, Function<? super Object[], ? extends R> function, Supplier<? extends Queue<T>> supplier, int i) {
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "prefetch > 0 required but it was "));
            throw null;
        }
        Objects.requireNonNull(cVarArr, "sources");
        this.sources = cVarArr;
        if (cVarArr.length == 0) {
            g5.f.s("at least one source is required");
            throw null;
        }
        this.sourcesIterable = null;
        Objects.requireNonNull(function, "zipper");
        this.zipper = function;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
        this.prefetch = i;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.prefetch;
    }

    public void handleArrayMode(CoreSubscriber<? super R> coreSubscriber, qd.c[] cVarArr) {
        int length = cVarArr.length;
        Object[] objArr = null;
        int i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            qd.c cVar = cVarArr[i3];
            if (cVar == null) {
                Operators.error(coreSubscriber, new NullPointerException("The sources contained a null Publisher"));
                return;
            }
            if (cVar instanceof Callable) {
                try {
                    Object objCall = ((Callable) cVar).call();
                    if (objCall == null) {
                        Operators.complete(coreSubscriber);
                        return;
                    }
                    if (objArr == null) {
                        objArr = new Object[length];
                    }
                    objArr[i3] = objCall;
                    i++;
                } catch (Throwable th) {
                    k0.a.B(coreSubscriber, th, coreSubscriber);
                    return;
                }
            }
        }
        handleBoth(coreSubscriber, cVarArr, objArr, length, i);
    }

    public void handleBoth(CoreSubscriber<? super R> coreSubscriber, qd.c[] cVarArr, @Nullable Object[] objArr, int i, int i3) {
        Operators.toFluxOrMono(cVarArr);
        if (i3 == 0 || objArr == null) {
            ZipCoordinator zipCoordinator = new ZipCoordinator(coreSubscriber, this.zipper, i, this.queueSupplier, this.prefetch);
            coreSubscriber.onSubscribe(zipCoordinator);
            zipCoordinator.subscribe(cVarArr, i);
        } else {
            if (i == i3) {
                coreSubscriber.onSubscribe(new ZipScalarCoordinator(coreSubscriber, this.zipper, objArr));
                return;
            }
            ZipSingleCoordinator zipSingleCoordinator = new ZipSingleCoordinator(coreSubscriber, objArr, i, i3, this.zipper);
            coreSubscriber.onSubscribe(zipSingleCoordinator);
            zipSingleCoordinator.subscribe(i, cVarArr);
        }
    }

    public void handleIterableMode(CoreSubscriber<? super R> coreSubscriber, Iterable<? extends qd.c> iterable) {
        Object[] objArrCopyOfRange = new Object[8];
        qd.c[] cVarArr = new qd.c[8];
        int i = 0;
        int i3 = 0;
        for (qd.c cVar : iterable) {
            if (cVar == null) {
                Operators.error(coreSubscriber, Operators.onOperatorError(new NullPointerException("The sourcesIterable returned a null Publisher"), coreSubscriber.currentContext()));
                return;
            }
            if (cVar instanceof Callable) {
                try {
                    Object objCall = ((Callable) cVar).call();
                    if (objCall == null) {
                        Operators.complete(coreSubscriber);
                        return;
                    }
                    if (i == objArrCopyOfRange.length) {
                        int i10 = (i >> 1) + i;
                        Object[] objArr = new Object[i10];
                        System.arraycopy(objArrCopyOfRange, 0, objArr, 0, i);
                        qd.c[] cVarArr2 = new qd.c[i10];
                        System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                        cVarArr = cVarArr2;
                        objArrCopyOfRange = objArr;
                    }
                    objArrCopyOfRange[i] = objCall;
                    i3++;
                } catch (Throwable th) {
                    k0.a.B(coreSubscriber, th, coreSubscriber);
                    return;
                }
            } else {
                if (i == cVarArr.length) {
                    int i11 = (i >> 1) + i;
                    Object[] objArr2 = new Object[i11];
                    System.arraycopy(objArrCopyOfRange, 0, objArr2, 0, i);
                    qd.c[] cVarArr3 = new qd.c[i11];
                    System.arraycopy(cVarArr, 0, cVarArr3, 0, i);
                    cVarArr = cVarArr3;
                    objArrCopyOfRange = objArr2;
                }
                cVarArr[i] = cVar;
            }
            i++;
        }
        if (i == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (i < objArrCopyOfRange.length) {
            objArrCopyOfRange = Arrays.copyOfRange(objArrCopyOfRange, 0, i, objArrCopyOfRange.getClass());
        }
        handleBoth(coreSubscriber, cVarArr, objArrCopyOfRange, i, i3);
    }

    @Override // reactor.core.publisher.SourceProducer, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.PREFETCH ? Integer.valueOf(this.prefetch) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super R> coreSubscriber) {
        qd.c[] cVarArr = this.sources;
        try {
            if (cVarArr != null) {
                handleArrayMode(coreSubscriber, cVarArr);
            } else {
                handleIterableMode(coreSubscriber, this.sourcesIterable);
            }
        } catch (Throwable th) {
            Operators.reportThrowInSubscribe(coreSubscriber, th);
        }
    }

    @Nullable
    public FluxZip<T, R> zipAdditionalSource(qd.c cVar, BiFunction biFunction) {
        qd.c[] cVarArr = this.sources;
        if (cVarArr == null || !(this.zipper instanceof PairwiseZipper)) {
            return null;
        }
        int length = cVarArr.length;
        qd.c[] cVarArr2 = new qd.c[length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
        cVarArr2[length] = cVar;
        return new FluxZip<>(cVarArr2, ((PairwiseZipper) this.zipper).then(biFunction), this.queueSupplier, this.prefetch);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <U> FluxZip(qd.c cVar, qd.c cVar2, BiFunction<? super T, ? super U, ? extends R> biFunction, Supplier<? extends Queue<T>> supplier, int i) {
        this(new qd.c[]{cVar, cVar2}, new PairwiseZipper(new BiFunction[]{biFunction}), supplier, i);
        Objects.requireNonNull(cVar, "p1");
        Objects.requireNonNull(cVar2, "p2");
        Objects.requireNonNull(biFunction, "zipper2");
    }

    public FluxZip(Iterable<? extends qd.c> iterable, Function<? super Object[], ? extends R> function, Supplier<? extends Queue<T>> supplier, int i) {
        if (i > 0) {
            this.sources = null;
            Objects.requireNonNull(iterable, "sourcesIterable");
            this.sourcesIterable = iterable;
            Objects.requireNonNull(function, "zipper");
            this.zipper = function;
            Objects.requireNonNull(supplier, "queueSupplier");
            this.queueSupplier = supplier;
            this.prefetch = i;
            return;
        }
        g5.f.s(k0.a.j(i, "prefetch > 0 required but it was "));
        throw null;
    }
}
