package reactor.core.publisher;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxFlattenIterable<T, R> extends InternalFluxOperator<T, R> implements Fuseable {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Supplier<Queue<T>> queueSupplier;

    public static final class FlattenIterableSubscriber<T, R> implements InnerOperator<T, R>, Fuseable.QueueSubscription<R>, Consumer<R> {
        final CoreSubscriber<? super R> actual;
        volatile boolean cancelled;
        int consumed;

        @Nullable
        Spliterator<? extends R> current;
        boolean currentKnownToBeFinite;
        volatile boolean done;
        volatile Throwable error;
        int fusionMode;
        final int limit;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        R nextElement;
        final int prefetch;
        Queue<T> queue;
        final Supplier<Queue<T>> queueSupplier;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5743s;
        boolean valueReady = false;
        volatile int wip;
        static final AtomicIntegerFieldUpdater<FlattenIterableSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(FlattenIterableSubscriber.class, "wip");
        static final AtomicLongFieldUpdater<FlattenIterableSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(FlattenIterableSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<FlattenIterableSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(FlattenIterableSubscriber.class, Throwable.class, "error");

        public FlattenIterableSubscriber(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i, Supplier<Queue<T>> supplier) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.prefetch = i;
            this.queueSupplier = supplier;
            this.limit = Operators.unboundedOrLimit(i);
        }

        @Override // java.util.function.Consumer
        public void accept(R r5) {
            this.valueReady = true;
            this.nextElement = r5;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f5743s.cancel();
            if (WIP.getAndIncrement(this) == 0) {
                Context contextCurrentContext = this.actual.currentContext();
                Operators.onDiscardQueueWithClear(this.queue, contextCurrentContext, null);
                Operators.onDiscard(this.nextElement, contextCurrentContext);
                Operators.onDiscardMultiple(this.current, this.currentKnownToBeFinite, contextCurrentContext);
            }
        }

        @Override // java.util.Collection
        public void clear() {
            Context contextCurrentContext = this.actual.currentContext();
            Operators.onDiscard(this.nextElement, contextCurrentContext);
            Operators.onDiscardMultiple(this.current, this.currentKnownToBeFinite, contextCurrentContext);
            resetCurrent();
            Operators.onDiscardQueueWithClear(this.queue, contextCurrentContext, null);
        }

        public void drain(@Nullable T t9) {
            if (WIP.getAndIncrement(this) != 0) {
                if (t9 == null || !this.cancelled) {
                    return;
                }
                Operators.onDiscard(t9, this.actual.currentContext());
                return;
            }
            if (this.fusionMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x01d3, code lost:
        
            if (r14 == r17) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x01dc, code lost:
        
            if (r12 == Long.MAX_VALUE) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x01de, code lost:
        
            reactor.core.publisher.FluxFlattenIterable.FlattenIterableSubscriber.REQUESTED.addAndGet(r19, -r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x01e4, code lost:
        
            if (r0 != null) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x017d, code lost:
        
            if (r14 != r12) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0181, code lost:
        
            if (r19.cancelled == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0183, code lost:
        
            resetCurrent();
            r2 = r19.actual.currentContext();
            reactor.core.publisher.Operators.onDiscardQueueWithClear(r3, r2, null);
            reactor.core.publisher.Operators.onDiscard(r19.nextElement, r2);
            reactor.core.publisher.Operators.onDiscardMultiple(r0, r4, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0197, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x019a, code lost:
        
            if (r19.error == null) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x019c, code lost:
        
            r5 = reactor.core.Exceptions.terminate(reactor.core.publisher.FluxFlattenIterable.FlattenIterableSubscriber.ERROR, r19);
            resetCurrent();
            r6 = r19.actual.currentContext();
            reactor.core.publisher.Operators.onDiscardQueueWithClear(r3, r6, null);
            reactor.core.publisher.Operators.onDiscard(r19.nextElement, r6);
            reactor.core.publisher.Operators.onDiscardMultiple(r0, r4, r6);
            r2.onError(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x01b9, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x01ba, code lost:
        
            r5 = r19.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x01c0, code lost:
        
            if (r3.isEmpty() == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x01c2, code lost:
        
            if (r0 != null) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x01c4, code lost:
        
            r9 = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x01c6, code lost:
        
            if (r5 == false) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x01c8, code lost:
        
            if (r9 == 0) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x01ca, code lost:
        
            resetCurrent();
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x01d0, code lost:
        
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0082  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void drainAsync() {
            /*
                Method dump skipped, instructions count: 508
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.FluxFlattenIterable.FlattenIterableSubscriber.drainAsync():void");
        }

        public void drainSync() {
            CoreSubscriber<? super R> coreSubscriber = this.actual;
            Spliterator<? extends R> spliterator = this.current;
            boolean zCheckFinite = this.currentKnownToBeFinite;
            int iAddAndGet = 1;
            while (true) {
                boolean z10 = false;
                if (spliterator == null) {
                    if (this.cancelled) {
                        Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
                        return;
                    }
                    boolean z11 = this.done;
                    Queue<T> queue = this.queue;
                    try {
                        T tPoll = queue.poll();
                        boolean z12 = tPoll == null;
                        if (z11 && z12) {
                            coreSubscriber.onComplete();
                            return;
                        }
                        if (!z12) {
                            try {
                                spliterator = this.mapper.apply(tPoll).spliterator();
                                zCheckFinite = FluxIterable.checkFinite(spliterator);
                                if (zCheckFinite) {
                                    if (spliterator.estimateSize() == 0) {
                                        zCheckFinite = false;
                                        spliterator = null;
                                    }
                                } else if (!hasNext(spliterator)) {
                                    zCheckFinite = false;
                                    spliterator = null;
                                }
                            } catch (Throwable th) {
                                resetCurrent();
                                Context contextCurrentContext = this.actual.currentContext();
                                Throwable thOnNextError = Operators.onNextError(tPoll, th, contextCurrentContext, this.f5743s);
                                Operators.onDiscard(tPoll, contextCurrentContext);
                                if (thOnNextError != null) {
                                    coreSubscriber.onError(thOnNextError);
                                    return;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        resetCurrent();
                        Operators.onDiscardQueueWithClear(queue, this.actual.currentContext(), null);
                        coreSubscriber.onError(th2);
                        return;
                    }
                }
                if (spliterator != null) {
                    long j5 = this.requested;
                    long j6 = 0;
                    while (true) {
                        if (j6 == j5) {
                            break;
                        }
                        if (this.cancelled) {
                            resetCurrent();
                            Context contextCurrentContext2 = this.actual.currentContext();
                            Operators.onDiscardQueueWithClear(this.queue, contextCurrentContext2, null);
                            Operators.onDiscard(this.nextElement, contextCurrentContext2);
                            Operators.onDiscardMultiple(spliterator, zCheckFinite, contextCurrentContext2);
                            return;
                        }
                        try {
                            R next = next(spliterator);
                            Objects.requireNonNull(next, "iterator returned null");
                            coreSubscriber.onNext(next);
                            if (this.cancelled) {
                                resetCurrent();
                                Context contextCurrentContext3 = this.actual.currentContext();
                                Operators.onDiscardQueueWithClear(this.queue, contextCurrentContext3, null);
                                Operators.onDiscard(this.nextElement, contextCurrentContext3);
                                Operators.onDiscardMultiple(spliterator, zCheckFinite, contextCurrentContext3);
                                return;
                            }
                            j6++;
                            try {
                                if (!hasNext(spliterator)) {
                                    resetCurrent();
                                    zCheckFinite = false;
                                    spliterator = null;
                                    break;
                                }
                            } catch (Throwable th3) {
                                resetCurrent();
                                coreSubscriber.onError(Operators.onOperatorError(this.f5743s, th3, this.actual.currentContext()));
                                return;
                            }
                        } catch (Throwable th4) {
                            resetCurrent();
                            coreSubscriber.onError(Operators.onOperatorError(this.f5743s, th4, this.actual.currentContext()));
                            return;
                        }
                    }
                    if (j6 == j5) {
                        if (this.cancelled) {
                            resetCurrent();
                            Context contextCurrentContext4 = this.actual.currentContext();
                            Operators.onDiscardQueueWithClear(this.queue, contextCurrentContext4, null);
                            Operators.onDiscard(this.nextElement, contextCurrentContext4);
                            Operators.onDiscardMultiple(spliterator, zCheckFinite, contextCurrentContext4);
                            return;
                        }
                        boolean z13 = this.done;
                        if (this.queue.isEmpty() && spliterator == null) {
                            z10 = true;
                        }
                        if (z13 && z10) {
                            resetCurrent();
                            coreSubscriber.onComplete();
                            return;
                        }
                    }
                    if (j6 != 0 && j5 != Long.MAX_VALUE) {
                        REQUESTED.addAndGet(this, -j6);
                    }
                    if (spliterator == null) {
                        continue;
                    }
                }
                this.current = spliterator;
                this.currentKnownToBeFinite = zCheckFinite;
                iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        public boolean hasNext(Spliterator<? extends R> spliterator) {
            if (!this.valueReady) {
                spliterator.tryAdvance(this);
            }
            return this.valueReady;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.current != null ? !hasNext(r0) : this.queue.isEmpty();
        }

        public R next(Spliterator<? extends R> spliterator) {
            if (!this.valueReady && !hasNext(spliterator)) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            R r5 = this.nextElement;
            this.nextElement = null;
            return r5;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            drain(null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                drain(null);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.fusionMode == 2 || this.queue.offer(t9)) {
                drain(t9);
                return;
            }
            Context contextCurrentContext = this.actual.currentContext();
            onError(Operators.onOperatorError(this.f5743s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), contextCurrentContext));
            Operators.onDiscard(t9, contextCurrentContext);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5743s, eVar)) {
                this.f5743s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
                    int iRequestFusion = queueSubscription.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
                        return;
                    }
                }
                this.queue = this.queueSupplier.get();
                this.actual.onSubscribe(this);
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // java.util.Queue
        @Nullable
        public R poll() {
            Spliterator<? extends R> spliterator = this.current;
            while (true) {
                Spliterator<? extends R> spliterator2 = null;
                if (spliterator != null) {
                    if (hasNext(spliterator)) {
                        break;
                    }
                    spliterator = spliterator2;
                } else {
                    T tPoll = this.queue.poll();
                    if (tPoll == null) {
                        return null;
                    }
                    try {
                        spliterator2 = this.mapper.apply(tPoll).spliterator();
                        boolean zCheckFinite = FluxIterable.checkFinite(spliterator2);
                        if (hasNext(spliterator2)) {
                            this.current = spliterator2;
                            this.currentKnownToBeFinite = zCheckFinite;
                            spliterator = spliterator2;
                            break;
                        }
                        spliterator = spliterator2;
                    } catch (Throwable th) {
                        Operators.onDiscard(tPoll, this.actual.currentContext());
                        throw th;
                    }
                }
            }
            R next = next(spliterator);
            Objects.requireNonNull(next, "iterator returned null");
            if (!hasNext(spliterator)) {
                resetCurrent();
            }
            return next;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Operators.addCap(REQUESTED, this, j5);
                drain(null);
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }

        public final void resetCurrent() {
            this.current = null;
            this.currentKnownToBeFinite = false;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5743s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.ERROR) {
                return this.error;
            }
            if (attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM) {
                return Long.valueOf(this.requested);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr != Scannable.Attr.BUFFERED) {
                return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
            }
            Queue<T> queue = this.queue;
            return Integer.valueOf(queue != null ? queue.size() : 0);
        }

        @Override // java.util.Collection
        public int size() {
            return this.queue.size();
        }
    }

    public FluxFlattenIterable(Flux<? extends T> flux, Function<? super T, ? extends Iterable<? extends R>> function, int i, Supplier<Queue<T>> supplier) {
        super(flux);
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
        this.prefetch = i;
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
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) throws Exception {
        Object obj = this.source;
        if (!(obj instanceof Callable)) {
            return new FlattenIterableSubscriber(coreSubscriber, this.mapper, this.prefetch, this.queueSupplier);
        }
        Object objCall = ((Callable) obj).call();
        if (objCall == null) {
            Operators.complete(coreSubscriber);
            return null;
        }
        try {
            Spliterator<? extends R> spliterator = this.mapper.apply(objCall).spliterator();
            FluxIterable.subscribe(coreSubscriber, spliterator, FluxIterable.checkFinite(spliterator));
            return null;
        } catch (Throwable th) {
            Context contextCurrentContext = coreSubscriber.currentContext();
            Throwable thOnNextError = Operators.onNextError(objCall, th, contextCurrentContext);
            Operators.onDiscard(objCall, contextCurrentContext);
            if (thOnNextError != null) {
                Operators.error(coreSubscriber, thOnNextError);
            } else {
                Operators.complete(coreSubscriber);
            }
            return null;
        }
    }
}
