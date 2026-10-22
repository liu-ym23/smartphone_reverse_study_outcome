package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Callable;
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
import reactor.core.publisher.FluxHide;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxFlatMap<T, R> extends InternalFluxOperator<T, R> {
    final boolean delayError;
    final Supplier<? extends Queue<R>> innerQueueSupplier;
    final Supplier<? extends Queue<R>> mainQueueSupplier;
    final Function<? super T, ? extends qd.c> mapper;
    final int maxConcurrency;
    final int prefetch;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FlatMapInner<R> implements InnerConsumer<R>, qd.e {
        static final AtomicReferenceFieldUpdater<FlatMapInner, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(FlatMapInner.class, qd.e.class, "s");
        volatile boolean done;
        int index;
        final int limit;
        final FlatMapMain<?, R> parent;
        final int prefetch;
        long produced;
        volatile Queue<R> queue;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10621s;
        int sourceMode;

        public FlatMapInner(FlatMapMain<?, R> flatMapMain, int i) {
            this.parent = flatMapMain;
            this.prefetch = i;
            this.limit = Operators.unboundedOrLimit(i);
        }

        @Override // qd.e
        public void cancel() {
            Operators.terminate(S, this);
            Operators.onDiscardQueueWithClear(this.queue, this.parent.currentContext(), null);
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            this.parent.innerComplete(this);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(R r10) {
            if (this.sourceMode == 2) {
                this.parent.drain(r10);
                return;
            }
            if (this.done) {
                Operators.onNextDropped(r10, this.parent.currentContext());
                return;
            }
            qd.e eVar = this.f10621s;
            qd.e eVarCancelledSubscription = Operators.cancelledSubscription();
            FlatMapMain<?, R> flatMapMain = this.parent;
            if (eVar == eVarCancelledSubscription) {
                Operators.onDiscard(r10, flatMapMain.currentContext());
            } else {
                flatMapMain.tryEmit(this, r10);
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
                        this.parent.drain(null);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                    }
                }
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // qd.e
        public void request(long j10) {
            if (this.sourceMode == 1) {
                return;
            }
            long j11 = this.produced + j10;
            if (j11 < this.limit) {
                this.produced = j11;
            } else {
                this.produced = 0L;
                this.f10621s.request(j11);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10621s;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.parent;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                if (!this.done || (this.queue != null && !this.queue.isEmpty())) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10621s == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue != null ? this.queue.size() : 0);
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

    public FluxFlatMap(Flux<? extends T> flux, Function<? super T, ? extends qd.c> function, boolean z10, int i, Supplier<? extends Queue<R>> supplier, int i3, Supplier<? extends Queue<R>> supplier2) {
        super(flux);
        if (i3 <= 0) {
            g5.f.s(k0.a.j(i3, "prefetch > 0 required but it was "));
            throw null;
        }
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "maxConcurrency > 0 required but it was "));
            throw null;
        }
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
        this.delayError = z10;
        this.prefetch = i3;
        this.maxConcurrency = i;
        Objects.requireNonNull(supplier, "mainQueueSupplier");
        this.mainQueueSupplier = supplier;
        Objects.requireNonNull(supplier2, "innerQueueSupplier");
        this.innerQueueSupplier = supplier2;
    }

    public static <T, R> boolean trySubscribeScalarMap(qd.c cVar, CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function, boolean z10, boolean z11) {
        if (!(cVar instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) cVar).call();
            a1.c cVar2 = (Object) objCall;
            if (cVar2 == null) {
                Operators.complete(coreSubscriber);
                return true;
            }
            try {
                qd.c cVarApply = function.apply(cVar2);
                Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher");
                qd.c cVar3 = cVarApply;
                if (cVar3 instanceof Callable) {
                    try {
                        Object objCall2 = ((Callable) cVar3).call();
                        if (objCall2 != null) {
                            coreSubscriber.onSubscribe(Operators.scalarSubscription(coreSubscriber, objCall2));
                        } else {
                            Operators.complete(coreSubscriber);
                        }
                    } catch (Throwable th) {
                        Context contextCurrentContext = coreSubscriber.currentContext();
                        Throwable thOnNextError = z11 ? Operators.onNextError(cVar2, th, contextCurrentContext) : Operators.onOperatorError(null, th, cVar2, contextCurrentContext);
                        if (thOnNextError != null) {
                            Operators.error(coreSubscriber, thOnNextError);
                        } else {
                            Operators.complete(coreSubscriber);
                        }
                        return true;
                    }
                } else {
                    CorePublisher fluxOrMono = Operators.toFluxOrMono(cVar3);
                    if (!z10 || (fluxOrMono instanceof Fuseable)) {
                        fluxOrMono.subscribe((qd.d) coreSubscriber);
                    } else {
                        fluxOrMono.subscribe((qd.d) new FluxHide.SuppressFuseableSubscriber(coreSubscriber));
                    }
                }
                return true;
            } catch (Throwable th2) {
                Context contextCurrentContext2 = coreSubscriber.currentContext();
                Throwable thOnNextError2 = z11 ? Operators.onNextError(cVar2, th2, contextCurrentContext2) : Operators.onOperatorError(null, th2, cVar2, contextCurrentContext2);
                if (thOnNextError2 != null) {
                    Operators.error(coreSubscriber, thOnNextError2);
                } else {
                    Operators.complete(coreSubscriber);
                }
                return true;
            }
        } catch (Throwable th3) {
            Context contextCurrentContext3 = coreSubscriber.currentContext();
            Throwable thOnNextError3 = z11 ? Operators.onNextError(null, th3, contextCurrentContext3) : Operators.onOperatorError(th3, contextCurrentContext3);
            if (thOnNextError3 != null) {
                Operators.error(coreSubscriber, thOnNextError3);
            } else {
                Operators.complete(coreSubscriber);
            }
            return true;
        }
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
        if (trySubscribeScalarMap(this.source, coreSubscriber, this.mapper, false, true)) {
            return null;
        }
        return new FlatMapMain(coreSubscriber, this.mapper, this.delayError, this.maxConcurrency, this.mainQueueSupplier, this.prefetch, this.innerQueueSupplier);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class FlatMapMain<T, R> extends FlatMapTracker<FlatMapInner<R>> implements InnerOperator<T, R> {
        final CoreSubscriber<? super R> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        volatile Throwable error;
        final Supplier<? extends Queue<R>> innerQueueSupplier;
        int lastIndex;
        final int limit;
        final Supplier<? extends Queue<R>> mainQueueSupplier;
        final Function<? super T, ? extends qd.c> mapper;
        final int maxConcurrency;
        final int prefetch;
        int produced;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10622s;
        volatile Queue<R> scalarQueue;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<FlatMapMain, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(FlatMapMain.class, Throwable.class, "error");
        static final AtomicLongFieldUpdater<FlatMapMain> REQUESTED = AtomicLongFieldUpdater.newUpdater(FlatMapMain.class, "requested");
        static final AtomicIntegerFieldUpdater<FlatMapMain> WIP = AtomicIntegerFieldUpdater.newUpdater(FlatMapMain.class, "wip");
        static final FlatMapInner[] EMPTY = new FlatMapInner[0];
        static final FlatMapInner[] TERMINATED = new FlatMapInner[0];

        public FlatMapMain(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function, boolean z10, int i, Supplier<? extends Queue<R>> supplier, int i3, Supplier<? extends Queue<R>> supplier2) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.delayError = z10;
            this.maxConcurrency = i;
            this.mainQueueSupplier = supplier;
            this.prefetch = i3;
            this.innerQueueSupplier = supplier2;
            this.limit = Operators.unboundedOrLimit(i);
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (WIP.getAndIncrement(this) == 0) {
                Operators.onDiscardQueueWithClear(this.scalarQueue, this.actual.currentContext(), null);
                this.scalarQueue = null;
                this.f10622s.cancel();
                unsubscribe();
            }
        }

        public boolean checkTerminated(boolean z10, boolean z11, qd.d dVar, @Nullable R r10) {
            if (this.cancelled) {
                Context contextCurrentContext = this.actual.currentContext();
                Operators.onDiscard(r10, contextCurrentContext);
                Operators.onDiscardQueueWithClear(this.scalarQueue, contextCurrentContext, null);
                this.scalarQueue = null;
                this.f10622s.cancel();
                unsubscribe();
                return true;
            }
            if (this.delayError) {
                if (!z10 || !z11) {
                    return false;
                }
                Throwable th = this.error;
                if (th == null || th == Exceptions.TERMINATED) {
                    dVar.onComplete();
                } else {
                    dVar.onError(Exceptions.terminate(ERROR, this));
                }
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 == null || th2 == Exceptions.TERMINATED) {
                if (!z11) {
                    return false;
                }
                dVar.onComplete();
                return true;
            }
            Throwable thTerminate = Exceptions.terminate(ERROR, this);
            Context contextCurrentContext2 = this.actual.currentContext();
            Operators.onDiscard(r10, contextCurrentContext2);
            Operators.onDiscardQueueWithClear(this.scalarQueue, contextCurrentContext2, null);
            this.scalarQueue = null;
            this.f10622s.cancel();
            unsubscribe();
            dVar.onError(thTerminate);
            return true;
        }

        public void drain(@Nullable R r10) {
            if (WIP.getAndIncrement(this) == 0) {
                drainLoop();
            } else {
                if (r10 == null || !this.cancelled) {
                    return;
                }
                Operators.onDiscard(r10, this.actual.currentContext());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:92:0x015d, code lost:
        
            r0 = r26;
         */
        /* JADX WARN: Removed duplicated region for block: B:102:0x017c  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x017a A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void drainLoop() {
            /*
                Method dump skipped, instructions count: 521
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxFlatMap.FlatMapMain.drainLoop():void");
        }

        public boolean failOverflow(R r10, qd.e eVar) {
            Throwable thOnOperatorError = Operators.onOperatorError(eVar, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), r10, this.actual.currentContext());
            Operators.onDiscard(r10, this.actual.currentContext());
            if (Exceptions.addThrowable(ERROR, this, thOnOperatorError)) {
                return true;
            }
            Operators.onErrorDropped(thOnOperatorError, this.actual.currentContext());
            return false;
        }

        public Queue<R> getOrCreateInnerQueue(FlatMapInner<R> flatMapInner) {
            Queue<R> queue = flatMapInner.queue;
            if (queue != null) {
                return queue;
            }
            Queue<R> queue2 = this.innerQueueSupplier.get();
            flatMapInner.queue = queue2;
            return queue2;
        }

        public Queue<R> getOrCreateScalarQueue() {
            Queue<R> queue = this.scalarQueue;
            if (queue != null) {
                return queue;
            }
            Queue<R> queue2 = this.mainQueueSupplier.get();
            this.scalarQueue = queue2;
            return queue2;
        }

        public void innerComplete(FlatMapInner<R> flatMapInner) {
            if (WIP.getAndIncrement(this) != 0) {
                return;
            }
            drainLoop();
        }

        public void innerError(FlatMapInner<R> flatMapInner, Throwable th) {
            Throwable thOnNextInnerError = Operators.onNextInnerError(th, currentContext(), this.f10622s);
            if (thOnNextInnerError == null) {
                flatMapInner.done = true;
                drain(null);
            } else if (!Exceptions.addThrowable(ERROR, this, thOnNextInnerError)) {
                flatMapInner.done = true;
                Operators.onErrorDropped(thOnNextInnerError, this.actual.currentContext());
            } else {
                if (!this.delayError) {
                    this.done = true;
                }
                flatMapInner.done = true;
                drain(null);
            }
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of((Object[]) this.array).filter(new m0(0));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain(null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                drain(null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                qd.c cVarApply = this.mapper.apply(t10);
                Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher");
                qd.c cVar = cVarApply;
                if (!(cVar instanceof Callable)) {
                    FlatMapInner flatMapInner = new FlatMapInner(this, this.prefetch);
                    if (add(flatMapInner)) {
                        Operators.toFluxOrMono(cVar).subscribe((qd.d) flatMapInner);
                        return;
                    } else {
                        Operators.onDiscard(t10, this.actual.currentContext());
                        return;
                    }
                }
                try {
                    tryEmitScalar(((Callable) cVar).call());
                } catch (Throwable th) {
                    Context contextCurrentContext = this.actual.currentContext();
                    Throwable thOnNextError = Operators.onNextError(t10, th, contextCurrentContext);
                    if (thOnNextError == null) {
                        tryEmitScalar(null);
                    } else if (!this.delayError || !Exceptions.addThrowable(ERROR, this, thOnNextError)) {
                        onError(Operators.onOperatorError(this.f10622s, thOnNextError, t10, contextCurrentContext));
                    }
                    Operators.onDiscard(t10, contextCurrentContext);
                    tryEmitScalar(null);
                }
            } catch (Throwable th2) {
                Context contextCurrentContext2 = this.actual.currentContext();
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, contextCurrentContext2, this.f10622s);
                Operators.onDiscard(t10, contextCurrentContext2);
                if (thOnNextError2 != null) {
                    onError(thOnNextError2);
                } else {
                    tryEmitScalar(null);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10622s, eVar)) {
                this.f10622s = eVar;
                this.actual.onSubscribe(this);
                eVar.request(Operators.unboundedOrPrefetch(this.maxConcurrency));
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                Operators.addCap(REQUESTED, this, j10);
                drain(null);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10622s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done && (this.scalarQueue == null || this.scalarQueue.isEmpty()));
            }
            if (attr == Scannable.Attr.DELAY_ERROR) {
                return Boolean.valueOf(this.delayError);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.maxConcurrency);
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.LARGE_BUFFERED) {
                return Long.valueOf((this.scalarQueue != null ? this.scalarQueue.size() : 0L) + this.size);
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            long size = (this.scalarQueue != null ? this.scalarQueue.size() : 0L) + this.size;
            if (size <= 2147483647L) {
                return Integer.valueOf((int) size);
            }
            return Integer.MIN_VALUE;
        }

        public void tryEmit(FlatMapInner<R> flatMapInner, R r10) {
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<FlatMapMain> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    long j10 = this.requested;
                    Queue<R> orCreateInnerQueue = flatMapInner.queue;
                    if (j10 == 0 || !(orCreateInnerQueue == null || orCreateInnerQueue.isEmpty())) {
                        if (orCreateInnerQueue == null) {
                            orCreateInnerQueue = getOrCreateInnerQueue(flatMapInner);
                        }
                        if (!orCreateInnerQueue.offer(r10) && failOverflow(r10, flatMapInner)) {
                            flatMapInner.done = true;
                            drainLoop();
                            return;
                        }
                    } else {
                        this.actual.onNext(r10);
                        if (j10 != Long.MAX_VALUE) {
                            REQUESTED.decrementAndGet(this);
                        }
                        flatMapInner.request(1L);
                    }
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                        drainLoop();
                        return;
                    } else {
                        if (this.cancelled) {
                            Operators.onDiscard(r10, this.actual.currentContext());
                            return;
                        }
                        return;
                    }
                }
            }
            if (!getOrCreateInnerQueue(flatMapInner).offer(r10) && failOverflow(r10, flatMapInner)) {
                flatMapInner.done = true;
            }
            drain(r10);
        }

        public void tryEmitScalar(@Nullable R r10) {
            if (r10 == null) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    int i = this.produced + 1;
                    if (i != this.limit) {
                        this.produced = i;
                        return;
                    } else {
                        this.produced = 0;
                        this.f10622s.request(i);
                        return;
                    }
                }
                return;
            }
            if (this.wip == 0) {
                AtomicIntegerFieldUpdater<FlatMapMain> atomicIntegerFieldUpdater = WIP;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    long j10 = this.requested;
                    Queue<R> orCreateScalarQueue = this.scalarQueue;
                    if (j10 == 0 || !(orCreateScalarQueue == null || orCreateScalarQueue.isEmpty())) {
                        if (orCreateScalarQueue == null) {
                            orCreateScalarQueue = getOrCreateScalarQueue();
                        }
                        if (!orCreateScalarQueue.offer(r10) && failOverflow(r10, this.f10622s)) {
                            this.done = true;
                            drainLoop();
                            return;
                        }
                    } else {
                        this.actual.onNext(r10);
                        if (j10 != Long.MAX_VALUE) {
                            REQUESTED.decrementAndGet(this);
                        }
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            int i3 = this.produced + 1;
                            if (i3 == this.limit) {
                                this.produced = 0;
                                this.f10622s.request(i3);
                            } else {
                                this.produced = i3;
                            }
                        }
                    }
                    if (atomicIntegerFieldUpdater.decrementAndGet(this) != 0) {
                        drainLoop();
                        return;
                    } else {
                        if (this.cancelled) {
                            Operators.onDiscard(r10, this.actual.currentContext());
                            return;
                        }
                        return;
                    }
                }
            }
            if (!getOrCreateScalarQueue().offer(r10) && failOverflow(r10, this.f10622s)) {
                this.done = true;
            }
            drain(r10);
        }

        @Override // reactor.core.publisher.FlatMapTracker
        public FlatMapInner<R>[] empty() {
            return EMPTY;
        }

        @Override // reactor.core.publisher.FlatMapTracker
        public FlatMapInner<R>[] newArray(int i) {
            return new FlatMapInner[i];
        }

        @Override // reactor.core.publisher.FlatMapTracker
        public FlatMapInner<R>[] terminated() {
            return TERMINATED;
        }

        @Override // reactor.core.publisher.FlatMapTracker
        public void setIndex(FlatMapInner<R> flatMapInner, int i) {
            flatMapInner.index = i;
        }

        @Override // reactor.core.publisher.FlatMapTracker
        public void unsubscribeEntry(FlatMapInner<R> flatMapInner) {
            flatMapInner.cancel();
        }
    }
}
