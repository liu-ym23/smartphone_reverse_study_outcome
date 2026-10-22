package reactor.core.publisher;

import java.lang.invoke.VarHandle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxCombineLatest<T, R> extends Flux<R> implements Fuseable, SourceProducer<R> {
    final qd.c[] array;
    final Function<Object[], R> combiner;
    final Iterable<? extends qd.c> iterable;
    final int prefetch;
    final Supplier<? extends Queue<SourceAndArray>> queueSupplier;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        public CombineLatestCoordinator(CoreSubscriber<? super R> coreSubscriber, Function<Object[], R> function, int i, Queue<SourceAndArray> queue, int i3) {
            this.actual = coreSubscriber;
            this.combiner = function;
            CombineLatestInner<T>[] combineLatestInnerArr = new CombineLatestInner[i];
            for (int i10 = 0; i10 < i; i10++) {
                combineLatestInnerArr[i10] = new CombineLatestInner<>(this, i10, i3);
            }
            this.subscribers = combineLatestInnerArr;
            this.latest = new Object[i];
            this.queue = queue;
        }

        private void discardQueue(Queue<SourceAndArray> queue) {
            Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), new a(8));
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
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
                long j10 = this.requested;
                long j11 = 0;
                while (j11 != j10) {
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
                        j11++;
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
                if (j11 == j10 && checkTerminated(this.done, queue.isEmpty(), queue)) {
                    return;
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    REQUESTED.addAndGet(this, -j11);
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
            int i3;
            synchronized (this) {
                try {
                    Object[] objArr = this.latest;
                    if (objArr[i] != null && (i3 = this.completedSources + 1) != objArr.length) {
                        this.completedSources = i3;
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

        public void innerValue(int i, T t10) {
            boolean z10;
            synchronized (this) {
                try {
                    Object[] objArr = this.latest;
                    int i3 = this.nonEmptySources;
                    if (objArr[i] == null) {
                        i3++;
                        this.nonEmptySources = i3;
                    }
                    objArr[i] = t10;
                    if (objArr.length == i3) {
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

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain();
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int i3 = i & 2;
            this.outputFused = i3 != 0;
            return i3;
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

        public void subscribe(qd.c[] cVarArr, int i) {
            CombineLatestInner<T>[] combineLatestInnerArr = this.subscribers;
            for (int i3 = 0; i3 < i && !this.done && !this.cancelled; i3++) {
                cVarArr[i3].subscribe(combineLatestInnerArr[i3]);
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class CombineLatestInner<T> implements InnerConsumer<T> {
        static final AtomicReferenceFieldUpdater<CombineLatestInner, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(CombineLatestInner.class, qd.e.class, "s");
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10594s;

        public CombineLatestInner(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i3) {
            this.parent = combineLatestCoordinator;
            this.index = i;
            this.prefetch = i3;
            this.limit = Operators.unboundedOrLimit(i3);
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
            this.parent.innerComplete(this.index);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.parent.innerValue(this.index, t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        public void requestOne() {
            int i = this.produced + 1;
            if (i != this.limit) {
                this.produced = i;
            } else {
                this.produced = 0;
                this.f10594s.request(i);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10594s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10594s == Operators.cancelledSubscription());
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

    public FluxCombineLatest(qd.c[] cVarArr, Function<Object[], R> function, Supplier<? extends Queue<SourceAndArray>> supplier, int i) {
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "prefetch > 0 required but it was "));
            throw null;
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
        qd.c[] cVarArr = this.array;
        int i = 0;
        if (cVarArr == null) {
            cVarArr = new qd.c[8];
            try {
                Iterator<? extends qd.c> it = this.iterable.iterator();
                Objects.requireNonNull(it, "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            qd.c next = it.next();
                            Objects.requireNonNull(next, "The Publisher returned by the iterator is null");
                            qd.c cVar = next;
                            if (length == cVarArr.length) {
                                qd.c[] cVarArr2 = new qd.c[(length >> 2) + length];
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                                cVarArr = cVarArr2;
                            }
                            cVarArr[length] = cVar;
                            length++;
                        } catch (Throwable th) {
                            k0.a.B(coreSubscriber, th, coreSubscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        k0.a.B(coreSubscriber, th2, coreSubscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                k0.a.B(coreSubscriber, th3, coreSubscriber);
                return;
            }
        } else {
            length = cVarArr.length;
        }
        int i3 = length;
        if (i3 == 0) {
            Operators.complete(coreSubscriber);
            return;
        }
        if (i3 == 1) {
            j0 j0Var = new j0(i);
            j0Var.f10807b = this;
            VarHandle.storeStoreFence();
            qd.c cVar2 = cVarArr[0];
            if (cVar2 instanceof Fuseable) {
                new FluxMapFuseable(Flux.from(cVar2), j0Var).subscribe((CoreSubscriber) coreSubscriber);
                return;
            } else if (!(coreSubscriber instanceof Fuseable.QueueSubscription)) {
                new FluxMap(Flux.from(cVar2), j0Var).subscribe((CoreSubscriber) coreSubscriber);
                return;
            }
        }
        Operators.toFluxOrMono(cVarArr);
        CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(coreSubscriber, this.combiner, i3, this.queueSupplier.get(), this.prefetch);
        coreSubscriber.onSubscribe(combineLatestCoordinator);
        combineLatestCoordinator.subscribe(cVarArr, i3);
    }

    public FluxCombineLatest(Iterable<? extends qd.c> iterable, Function<Object[], R> function, Supplier<? extends Queue<SourceAndArray>> supplier, int i) {
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
        g5.f.s(k0.a.j(i, "prefetch > 0 required but it was "));
        throw null;
    }
}
