package reactor.core.publisher;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxConcatMap<T, R> extends InternalFluxOperator<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Z9.c> mapper;
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;

    /* renamed from: reactor.core.publisher.FluxConcatMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$FluxConcatMap$ErrorMode;

        static {
            int[] iArr = new int[ErrorMode.values().length];
            $SwitchMap$reactor$core$publisher$FluxConcatMap$ErrorMode = iArr;
            try {
                iArr[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxConcatMap$ErrorMode[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class ConcatMapDelayed<T, R> implements FluxConcatMapSupport<T, R> {
        static final AtomicReferenceFieldUpdater<ConcatMapDelayed, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(ConcatMapDelayed.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<ConcatMapDelayed> WIP = AtomicIntegerFieldUpdater.newUpdater(ConcatMapDelayed.class, "wip");
        volatile boolean active;
        final CoreSubscriber<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        volatile Throwable error;
        final ConcatMapInner<R> inner = new ConcatMapInner<>(this);
        final int limit;
        final Function<? super T, ? extends Z9.c> mapper;
        final int prefetch;
        volatile Queue<T> queue;
        final Supplier<? extends Queue<T>> queueSupplier;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5715s;
        int sourceMode;
        final boolean veryEnd;
        volatile int wip;

        public ConcatMapDelayed(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Z9.c> function, Supplier<? extends Queue<T>> supplier, int i, boolean z10) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.queueSupplier = supplier;
            this.prefetch = i;
            this.limit = Operators.unboundedOrLimit(i);
            this.veryEnd = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.f5715s.cancel();
            Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
        }

        public void drain() {
            Z9.c cVar;
            if (WIP.getAndIncrement(this) == 0) {
                Context contextCurrentContext = null;
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z10 = this.done;
                        if (z10 && !this.veryEnd && this.error != null) {
                            Throwable thTerminate = Exceptions.terminate(ERROR, this);
                            if (thTerminate != Exceptions.TERMINATED) {
                                this.actual.onError(thTerminate);
                                return;
                            }
                            return;
                        }
                        try {
                            T tPoll = this.queue.poll();
                            boolean z11 = tPoll == null;
                            if (z10 && z11) {
                                Throwable thTerminate2 = Exceptions.terminate(ERROR, this);
                                if (thTerminate2 == null || thTerminate2 == Exceptions.TERMINATED) {
                                    this.actual.onComplete();
                                    return;
                                } else {
                                    this.actual.onError(thTerminate2);
                                    return;
                                }
                            }
                            if (!z11) {
                                try {
                                    Z9.c cVarApply = this.mapper.apply(tPoll);
                                    Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher");
                                    cVar = cVarApply;
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.f5715s.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (contextCurrentContext == null) {
                                        contextCurrentContext = this.actual.currentContext();
                                    }
                                    Operators.onDiscard(tPoll, contextCurrentContext);
                                    if (Operators.onNextError(tPoll, th, contextCurrentContext, this.f5715s) != null) {
                                        this.actual.onError(Operators.onOperatorError(this.f5715s, th, tPoll, contextCurrentContext));
                                        return;
                                    }
                                }
                                if (cVar instanceof Callable) {
                                    try {
                                        Object objCall = ((Callable) cVar).call();
                                        if (objCall == null) {
                                            continue;
                                        } else if (this.inner.isUnbounded()) {
                                            this.actual.onNext(objCall);
                                        } else {
                                            this.active = true;
                                            ConcatMapInner<R> concatMapInner = this.inner;
                                            concatMapInner.set(new WeakScalarSubscription(objCall, concatMapInner));
                                        }
                                    } catch (Throwable th2) {
                                        if (contextCurrentContext == null) {
                                            contextCurrentContext = this.actual.currentContext();
                                        }
                                        Throwable thOnNextError = Operators.onNextError(tPoll, th2, contextCurrentContext);
                                        if (thOnNextError == null) {
                                            continue;
                                        } else if (!this.veryEnd || !Exceptions.addThrowable(ERROR, this, thOnNextError)) {
                                            this.actual.onError(Operators.onOperatorError(this.f5715s, thOnNextError, tPoll, contextCurrentContext));
                                            return;
                                        }
                                    }
                                } else {
                                    this.active = true;
                                    Operators.toFluxOrMono(cVar).subscribe((Z9.d) this.inner);
                                }
                            }
                        } catch (Throwable th3) {
                            CoreSubscriber<? super R> coreSubscriber = this.actual;
                            coreSubscriber.onError(Operators.onOperatorError(this.f5715s, th3, coreSubscriber.currentContext()));
                            return;
                        }
                    }
                    if (WIP.decrementAndGet(this) == 0) {
                        return;
                    }
                }
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerError(Throwable th) {
            Throwable thOnNextInnerError = Operators.onNextInnerError(th, currentContext(), this.f5715s);
            if (thOnNextInnerError == null) {
                this.active = false;
                return;
            }
            if (!Exceptions.addThrowable(ERROR, this, thOnNextInnerError)) {
                Operators.onErrorDropped(thOnNextInnerError, this.actual.currentContext());
                return;
            }
            if (!this.veryEnd) {
                this.f5715s.cancel();
                this.done = true;
            }
            this.active = false;
            drain();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerNext(R r5) {
            this.actual.onNext(r5);
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.sourceMode == 2) {
                drain();
            } else {
                if (this.queue.offer(t9)) {
                    drain();
                    return;
                }
                Context contextCurrentContext = this.actual.currentContext();
                onError(Operators.onOperatorError(this.f5715s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, contextCurrentContext));
                Operators.onDiscard(t9, contextCurrentContext);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5715s, eVar)) {
                this.f5715s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
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
                this.actual.onSubscribe(this);
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.inner.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5715s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue != null ? this.queue.size() : 0);
            }
            return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.DELAY_ERROR ? Boolean.TRUE : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class ConcatMapImmediate<T, R> implements FluxConcatMapSupport<T, R> {
        volatile boolean active;
        final CoreSubscriber<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        final Context ctx;
        volatile boolean done;
        volatile Throwable error;
        volatile int guard;
        final ConcatMapInner<R> inner = new ConcatMapInner<>(this);
        final int limit;
        final Function<? super T, ? extends Z9.c> mapper;
        final int prefetch;
        volatile Queue<T> queue;
        final Supplier<? extends Queue<T>> queueSupplier;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5716s;
        int sourceMode;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<ConcatMapImmediate, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(ConcatMapImmediate.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<ConcatMapImmediate> WIP = AtomicIntegerFieldUpdater.newUpdater(ConcatMapImmediate.class, "wip");
        static final AtomicIntegerFieldUpdater<ConcatMapImmediate> GUARD = AtomicIntegerFieldUpdater.newUpdater(ConcatMapImmediate.class, "guard");

        public ConcatMapImmediate(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Z9.c> function, Supplier<? extends Queue<T>> supplier, int i) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.mapper = function;
            this.queueSupplier = supplier;
            this.prefetch = i;
            this.limit = Operators.unboundedOrLimit(i);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.f5716s.cancel();
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
        }

        public void drain() {
            Z9.c cVar;
            if (WIP.getAndIncrement(this) == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z10 = this.done;
                        try {
                            T tPoll = this.queue.poll();
                            boolean z11 = tPoll == null;
                            if (z10 && z11) {
                                this.actual.onComplete();
                                return;
                            }
                            if (!z11) {
                                try {
                                    Z9.c cVarApply = this.mapper.apply(tPoll);
                                    Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher");
                                    cVar = cVarApply;
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.f5716s.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                } catch (Throwable th) {
                                    Operators.onDiscard(tPoll, this.ctx);
                                    if (Operators.onNextError(tPoll, th, this.ctx, this.f5716s) != null) {
                                        this.actual.onError(Operators.onOperatorError(this.f5716s, th, tPoll, this.ctx));
                                        return;
                                    }
                                }
                                if (cVar instanceof Callable) {
                                    try {
                                        Object objCall = ((Callable) cVar).call();
                                        if (objCall == null) {
                                            continue;
                                        } else if (!this.inner.isUnbounded()) {
                                            this.active = true;
                                            ConcatMapInner<R> concatMapInner = this.inner;
                                            concatMapInner.set(new WeakScalarSubscription(objCall, concatMapInner));
                                        } else if (this.guard == 0) {
                                            AtomicIntegerFieldUpdater<ConcatMapImmediate> atomicIntegerFieldUpdater = GUARD;
                                            if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                                                this.actual.onNext(objCall);
                                                if (!atomicIntegerFieldUpdater.compareAndSet(this, 1, 0)) {
                                                    Throwable thTerminate = Exceptions.terminate(ERROR, this);
                                                    if (thTerminate != Exceptions.TERMINATED) {
                                                        this.actual.onError(thTerminate);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                continue;
                                            }
                                        } else {
                                            continue;
                                        }
                                    } catch (Throwable th2) {
                                        if (Operators.onNextError(tPoll, th2, this.ctx, this.f5716s) != null) {
                                            this.actual.onError(Operators.onOperatorError(this.f5716s, th2, tPoll, this.ctx));
                                            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
                                            return;
                                        }
                                    }
                                } else {
                                    this.active = true;
                                    Operators.toFluxOrMono(cVar).subscribe((Z9.d) this.inner);
                                }
                            }
                        } catch (Throwable th3) {
                            this.actual.onError(Operators.onOperatorError(this.f5716s, th3, this.ctx));
                            return;
                        }
                    }
                    if (WIP.decrementAndGet(this) == 0) {
                        return;
                    }
                }
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerError(Throwable th) {
            Throwable thTerminate;
            Throwable thOnNextInnerError = Operators.onNextInnerError(th, currentContext(), this.f5716s);
            if (thOnNextInnerError == null) {
                this.active = false;
                drain();
                return;
            }
            AtomicReferenceFieldUpdater<ConcatMapImmediate, Throwable> atomicReferenceFieldUpdater = ERROR;
            if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, this, thOnNextInnerError)) {
                Operators.onErrorDropped(thOnNextInnerError, this.ctx);
                return;
            }
            this.f5716s.cancel();
            if (GUARD.getAndIncrement(this) != 0 || (thTerminate = Exceptions.terminate(atomicReferenceFieldUpdater, this)) == Exceptions.TERMINATED) {
                return;
            }
            this.actual.onError(thTerminate);
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerNext(R r5) {
            Throwable thTerminate;
            if (this.guard == 0) {
                AtomicIntegerFieldUpdater<ConcatMapImmediate> atomicIntegerFieldUpdater = GUARD;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    this.actual.onNext(r5);
                    if (atomicIntegerFieldUpdater.compareAndSet(this, 1, 0) || (thTerminate = Exceptions.terminate(ERROR, this)) == Exceptions.TERMINATED) {
                        return;
                    }
                    this.actual.onError(thTerminate);
                }
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            Throwable thTerminate;
            AtomicReferenceFieldUpdater<ConcatMapImmediate, Throwable> atomicReferenceFieldUpdater = ERROR;
            if (!Exceptions.addThrowable(atomicReferenceFieldUpdater, this, th)) {
                Operators.onErrorDropped(th, this.ctx);
                return;
            }
            this.inner.cancel();
            if (GUARD.getAndIncrement(this) != 0 || (thTerminate = Exceptions.terminate(atomicReferenceFieldUpdater, this)) == Exceptions.TERMINATED) {
                return;
            }
            this.actual.onError(thTerminate);
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.sourceMode == 2) {
                drain();
            } else if (this.queue.offer(t9)) {
                drain();
            } else {
                onError(Operators.onOperatorError(this.f5716s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t9, this.ctx));
                Operators.onDiscard(t9, this.ctx);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5716s, eVar)) {
                this.f5716s = eVar;
                if (eVar instanceof Fuseable.QueueSubscription) {
                    Fuseable.QueueSubscription queueSubscription = (Fuseable.QueueSubscription) eVar;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
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
                this.actual.onSubscribe(this);
                eVar.request(Operators.unboundedOrPrefetch(this.prefetch));
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.inner.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5716s;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done || this.error == Exceptions.TERMINATED);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.cancelled);
            }
            if (attr == Scannable.Attr.PREFETCH) {
                return Integer.valueOf(this.prefetch);
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.queue != null ? this.queue.size() : 0);
            }
            return attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public static final class ConcatMapInner<R> extends Operators.MultiSubscriptionSubscriber<R, R> {
        final FluxConcatMapSupport<?, R> parent;
        long produced;

        public ConcatMapInner(FluxConcatMapSupport<?, R> fluxConcatMapSupport) {
            super(Operators.emptySubscriber());
            this.parent = fluxConcatMapSupport;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.parent.currentContext();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            long j5 = this.produced;
            if (j5 != 0) {
                this.produced = 0L;
                produced(j5);
            }
            this.parent.innerComplete();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            long j5 = this.produced;
            if (j5 != 0) {
                this.produced = 0L;
                produced(j5);
            }
            this.parent.innerError(th);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(R r5) {
            this.produced++;
            this.parent.innerNext(r5);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.ACTUAL ? this.parent : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public enum ErrorMode {
        IMMEDIATE,
        BOUNDARY,
        END
    }

    public interface FluxConcatMapSupport<I, T> extends InnerOperator<I, T> {
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        /* synthetic */ void cancel();

        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t9);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onComplete();

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onError(Throwable th);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        /* synthetic */ void onNext(Object obj);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        /* synthetic */ void request(long j5);
    }

    public static final class WeakScalarSubscription<T> implements Z9.e {
        final CoreSubscriber<? super T> actual;
        boolean once;
        final T value;

        public WeakScalarSubscription(T t9, CoreSubscriber<? super T> coreSubscriber) {
            this.value = t9;
            this.actual = coreSubscriber;
        }

        @Override // Z9.e
        public void cancel() {
            Operators.onDiscard(this.value, this.actual.currentContext());
        }

        @Override // Z9.e
        public void request(long j5) {
            if (j5 <= 0 || this.once) {
                return;
            }
            this.once = true;
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            coreSubscriber.onNext(this.value);
            coreSubscriber.onComplete();
        }
    }

    public FluxConcatMap(Flux<? extends T> flux, Function<? super T, ? extends Z9.c> function, Supplier<? extends Queue<T>> supplier, int i, ErrorMode errorMode) {
        super(flux);
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "prefetch > 0 required but it was "));
        }
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
        this.prefetch = i;
        Objects.requireNonNull(errorMode, "errorMode");
        this.errorMode = errorMode;
    }

    public static <T, R> CoreSubscriber<T> subscriber(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Z9.c> function, Supplier<? extends Queue<T>> supplier, int i, ErrorMode errorMode) {
        int i6 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMap$ErrorMode[errorMode.ordinal()];
        return i6 != 1 ? i6 != 2 ? new ConcatMapImmediate(coreSubscriber, function, supplier, i) : new ConcatMapDelayed(coreSubscriber, function, supplier, i, true) : new ConcatMapDelayed(coreSubscriber, function, supplier, i, false);
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
        if (FluxFlatMap.trySubscribeScalarMap(this.source, coreSubscriber, this.mapper, false, true)) {
            return null;
        }
        return subscriber(coreSubscriber, this.mapper, this.queueSupplier, this.prefetch, this.errorMode);
    }
}
