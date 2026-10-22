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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxConcatMap<T, R> extends InternalFluxOperator<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends qd.c> mapper;
    final int prefetch;
    final Supplier<? extends Queue<T>> queueSupplier;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
        final Function<? super T, ? extends qd.c> mapper;
        final int prefetch;
        volatile Queue<T> queue;
        final Supplier<? extends Queue<T>> queueSupplier;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10597s;
        int sourceMode;
        final boolean veryEnd;
        volatile int wip;

        public ConcatMapDelayed(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function, Supplier<? extends Queue<T>> supplier, int i, boolean z10) {
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

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.f10597s.cancel();
            Operators.onDiscardQueueWithClear(this.queue, this.actual.currentContext(), null);
        }

        public void drain() {
            qd.c cVar;
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
                                    qd.c cVarApply = this.mapper.apply(tPoll);
                                    Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher");
                                    cVar = cVarApply;
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.f10597s.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (contextCurrentContext == null) {
                                        contextCurrentContext = this.actual.currentContext();
                                    }
                                    Operators.onDiscard(tPoll, contextCurrentContext);
                                    if (Operators.onNextError(tPoll, th, contextCurrentContext, this.f10597s) != null) {
                                        this.actual.onError(Operators.onOperatorError(this.f10597s, th, tPoll, contextCurrentContext));
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
                                            this.actual.onError(Operators.onOperatorError(this.f10597s, thOnNextError, tPoll, contextCurrentContext));
                                            return;
                                        }
                                    }
                                } else {
                                    this.active = true;
                                    Operators.toFluxOrMono(cVar).subscribe((qd.d) this.inner);
                                }
                            }
                        } catch (Throwable th3) {
                            CoreSubscriber<? super R> coreSubscriber = this.actual;
                            coreSubscriber.onError(Operators.onOperatorError(this.f10597s, th3, coreSubscriber.currentContext()));
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
            Throwable thOnNextInnerError = Operators.onNextInnerError(th, currentContext(), this.f10597s);
            if (thOnNextInnerError == null) {
                this.active = false;
                return;
            }
            if (!Exceptions.addThrowable(ERROR, this, thOnNextInnerError)) {
                Operators.onErrorDropped(thOnNextInnerError, this.actual.currentContext());
                return;
            }
            if (!this.veryEnd) {
                this.f10597s.cancel();
                this.done = true;
            }
            this.active = false;
            drain();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerNext(R r10) {
            this.actual.onNext(r10);
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (!Exceptions.addThrowable(ERROR, this, th)) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                drain();
            } else {
                if (this.queue.offer(t10)) {
                    drain();
                    return;
                }
                Context contextCurrentContext = this.actual.currentContext();
                onError(Operators.onOperatorError(this.f10597s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, contextCurrentContext));
                Operators.onDiscard(t10, contextCurrentContext);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10597s, eVar)) {
                this.f10597s = eVar;
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

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.inner.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10597s;
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
        final Function<? super T, ? extends qd.c> mapper;
        final int prefetch;
        volatile Queue<T> queue;
        final Supplier<? extends Queue<T>> queueSupplier;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10598s;
        int sourceMode;
        volatile int wip;
        static final AtomicReferenceFieldUpdater<ConcatMapImmediate, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(ConcatMapImmediate.class, Throwable.class, "error");
        static final AtomicIntegerFieldUpdater<ConcatMapImmediate> WIP = AtomicIntegerFieldUpdater.newUpdater(ConcatMapImmediate.class, "wip");
        static final AtomicIntegerFieldUpdater<ConcatMapImmediate> GUARD = AtomicIntegerFieldUpdater.newUpdater(ConcatMapImmediate.class, "guard");

        public ConcatMapImmediate(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function, Supplier<? extends Queue<T>> supplier, int i) {
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

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.f10598s.cancel();
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
        }

        public void drain() {
            qd.c cVar;
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
                                    qd.c cVarApply = this.mapper.apply(tPoll);
                                    Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher");
                                    cVar = cVarApply;
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.f10598s.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                } catch (Throwable th) {
                                    Operators.onDiscard(tPoll, this.ctx);
                                    if (Operators.onNextError(tPoll, th, this.ctx, this.f10598s) != null) {
                                        this.actual.onError(Operators.onOperatorError(this.f10598s, th, tPoll, this.ctx));
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
                                        if (Operators.onNextError(tPoll, th2, this.ctx, this.f10598s) != null) {
                                            this.actual.onError(Operators.onOperatorError(this.f10598s, th2, tPoll, this.ctx));
                                            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
                                            return;
                                        }
                                    }
                                } else {
                                    this.active = true;
                                    Operators.toFluxOrMono(cVar).subscribe((qd.d) this.inner);
                                }
                            }
                        } catch (Throwable th3) {
                            this.actual.onError(Operators.onOperatorError(this.f10598s, th3, this.ctx));
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
            Throwable thOnNextInnerError = Operators.onNextInnerError(th, currentContext(), this.f10598s);
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
            this.f10598s.cancel();
            if (GUARD.getAndIncrement(this) != 0 || (thTerminate = Exceptions.terminate(atomicReferenceFieldUpdater, this)) == Exceptions.TERMINATED) {
                return;
            }
            this.actual.onError(thTerminate);
            Operators.onDiscardQueueWithClear(this.queue, this.ctx, null);
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerNext(R r10) {
            Throwable thTerminate;
            if (this.guard == 0) {
                AtomicIntegerFieldUpdater<ConcatMapImmediate> atomicIntegerFieldUpdater = GUARD;
                if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                    this.actual.onNext(r10);
                    if (atomicIntegerFieldUpdater.compareAndSet(this, 1, 0) || (thTerminate = Exceptions.terminate(ERROR, this)) == Exceptions.TERMINATED) {
                        return;
                    }
                    this.actual.onError(thTerminate);
                }
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.sourceMode == 2) {
                drain();
            } else if (this.queue.offer(t10)) {
                drain();
            } else {
                onError(Operators.onOperatorError(this.f10598s, Exceptions.failWithOverflow(Exceptions.BACKPRESSURE_ERROR_QUEUE_FULL), t10, this.ctx));
                Operators.onDiscard(t10, this.ctx);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10598s, eVar)) {
                this.f10598s = eVar;
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

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.inner.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10598s;
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            long j10 = this.produced;
            if (j10 != 0) {
                this.produced = 0L;
                produced(j10);
            }
            this.parent.innerComplete();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            long j10 = this.produced;
            if (j10 != 0) {
                this.produced = 0L;
                produced(j10);
            }
            this.parent.innerError(th);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(R r10) {
            this.produced++;
            this.parent.innerNext(r10);
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.ACTUAL ? this.parent : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum ErrorMode {
        IMMEDIATE,
        BOUNDARY,
        END
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface FluxConcatMapSupport<I, T> extends InnerOperator<I, T> {
        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        /* synthetic */ void cancel();

        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t10);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        /* synthetic */ void onComplete();

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        /* synthetic */ void onError(Throwable th);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        /* synthetic */ void onNext(Object obj);

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        /* synthetic */ void request(long j10);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class WeakScalarSubscription<T> implements qd.e {
        final CoreSubscriber<? super T> actual;
        boolean once;
        final T value;

        public WeakScalarSubscription(T t10, CoreSubscriber<? super T> coreSubscriber) {
            this.value = t10;
            this.actual = coreSubscriber;
        }

        @Override // qd.e
        public void cancel() {
            Operators.onDiscard(this.value, this.actual.currentContext());
        }

        @Override // qd.e
        public void request(long j10) {
            if (j10 <= 0 || this.once) {
                return;
            }
            this.once = true;
            CoreSubscriber<? super T> coreSubscriber = this.actual;
            coreSubscriber.onNext(this.value);
            coreSubscriber.onComplete();
        }
    }

    public FluxConcatMap(Flux<? extends T> flux, Function<? super T, ? extends qd.c> function, Supplier<? extends Queue<T>> supplier, int i, ErrorMode errorMode) {
        super(flux);
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "prefetch > 0 required but it was "));
            throw null;
        }
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
        Objects.requireNonNull(supplier, "queueSupplier");
        this.queueSupplier = supplier;
        this.prefetch = i;
        Objects.requireNonNull(errorMode, "errorMode");
        this.errorMode = errorMode;
    }

    public static <T, R> CoreSubscriber<T> subscriber(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qd.c> function, Supplier<? extends Queue<T>> supplier, int i, ErrorMode errorMode) {
        int i3 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMap$ErrorMode[errorMode.ordinal()];
        return i3 != 1 ? i3 != 2 ? new ConcatMapImmediate(coreSubscriber, function, supplier, i) : new ConcatMapDelayed(coreSubscriber, function, supplier, i, true) : new ConcatMapDelayed(coreSubscriber, function, supplier, i, false);
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
