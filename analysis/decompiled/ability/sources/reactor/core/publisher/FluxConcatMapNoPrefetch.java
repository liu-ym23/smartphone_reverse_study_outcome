package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxConcatMap;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxConcatMapNoPrefetch<T, R> extends InternalFluxOperator<T, R> {
    final FluxConcatMap.ErrorMode errorMode;
    final Function<? super T, ? extends Z9.c> mapper;

    /* renamed from: reactor.core.publisher.FluxConcatMapNoPrefetch$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State;

        static {
            int[] iArr = new int[FluxConcatMapNoPrefetchSubscriber.State.values().length];
            $SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State = iArr;
            try {
                iArr[FluxConcatMapNoPrefetchSubscriber.State.CANCELLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[FluxConcatMapNoPrefetchSubscriber.State.TERMINATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[FluxConcatMapNoPrefetchSubscriber.State.INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[FluxConcatMapNoPrefetchSubscriber.State.REQUESTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[FluxConcatMapNoPrefetchSubscriber.State.ACTIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[FluxConcatMapNoPrefetchSubscriber.State.LAST_ACTIVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static final class FluxConcatMapNoPrefetchSubscriber<T, R> implements FluxConcatMap.FluxConcatMapSupport<T, R> {
        final CoreSubscriber<? super R> actual;
        volatile Throwable error;
        final FluxConcatMap.ErrorMode errorMode;
        final FluxConcatMap.ConcatMapInner<R> inner = new FluxConcatMap.ConcatMapInner<>(this);
        final Function<? super T, ? extends Z9.c> mapper;
        volatile State state;
        Z9.e upstream;
        static final AtomicReferenceFieldUpdater<FluxConcatMapNoPrefetchSubscriber, State> STATE = AtomicReferenceFieldUpdater.newUpdater(FluxConcatMapNoPrefetchSubscriber.class, State.class, "state");
        static final AtomicReferenceFieldUpdater<FluxConcatMapNoPrefetchSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(FluxConcatMapNoPrefetchSubscriber.class, Throwable.class, "error");

        public enum State {
            INITIAL,
            REQUESTED,
            ACTIVE,
            LAST_ACTIVE,
            TERMINATED,
            CANCELLED
        }

        public FluxConcatMapNoPrefetchSubscriber(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends Z9.c> function, FluxConcatMap.ErrorMode errorMode) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.errorMode = errorMode;
            STATE.lazySet(this, State.INITIAL);
        }

        private boolean maybeOnError(@Nullable Throwable th, Context context, Z9.e eVar) {
            State state;
            if (th == null) {
                return false;
            }
            if (!ERROR.compareAndSet(this, null, th)) {
                Operators.onErrorDropped(th, context);
            }
            if (this.errorMode == FluxConcatMap.ErrorMode.END) {
                return false;
            }
            do {
                state = this.state;
                int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[state.ordinal()];
                if (i == 1 || i == 2) {
                    return true;
                }
            } while (!STATE.compareAndSet(this, state, State.TERMINATED));
            eVar.cancel();
            synchronized (this) {
                this.actual.onError(this.error);
            }
            return true;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[STATE.getAndSet(this, State.CANCELLED).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.inner.cancel();
                } else {
                    this.inner.cancel();
                    this.upstream.cancel();
                }
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerComplete() {
            while (true) {
                State state = this.state;
                int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[state.ordinal()];
                if (i != 5) {
                    if (i != 6) {
                        return;
                    }
                    if (STATE.compareAndSet(this, state, State.TERMINATED)) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.actual.onError(th);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                } else if (STATE.compareAndSet(this, state, State.REQUESTED)) {
                    this.upstream.request(1L);
                    return;
                }
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public void innerError(Throwable th) {
            Context contextCurrentContext = currentContext();
            if (maybeOnError(Operators.onNextInnerError(th, contextCurrentContext, null), contextCurrentContext, this.upstream)) {
                return;
            }
            innerComplete();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport
        public synchronized void innerNext(R r5) {
            try {
                int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[this.state.ordinal()];
                if (i == 5 || i == 6) {
                    this.actual.onNext(r5);
                } else {
                    Operators.onDiscard(r5, currentContext());
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            while (true) {
                State state = this.state;
                int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[state.ordinal()];
                if (i == 3 || i == 4) {
                    if (STATE.compareAndSet(this, state, State.TERMINATED)) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.actual.onError(th);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                } else if (i != 5 || STATE.compareAndSet(this, state, State.LAST_ACTIVE)) {
                    return;
                }
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (maybeOnError(th, currentContext(), this.inner)) {
                return;
            }
            onComplete();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (!STATE.compareAndSet(this, State.REQUESTED, State.ACTIVE)) {
                int i = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[this.state.ordinal()];
                if (i == 1) {
                    Operators.onDiscard(t9, currentContext());
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    Operators.onNextDropped(t9, currentContext());
                    return;
                }
            }
            try {
                Z9.c cVarApply = this.mapper.apply(t9);
                Objects.requireNonNull(cVarApply, "The mapper returned a null Publisher");
                if (!(cVarApply instanceof Callable)) {
                    Operators.toFluxOrMono(cVarApply).subscribe((Z9.d) this.inner);
                    return;
                }
                Object objCall = ((Callable) cVarApply).call();
                if (objCall == null) {
                    innerComplete();
                } else if (this.inner.isUnbounded()) {
                    this.actual.onNext(objCall);
                    innerComplete();
                } else {
                    FluxConcatMap.ConcatMapInner<R> concatMapInner = this.inner;
                    concatMapInner.set(new FluxConcatMap.WeakScalarSubscription(objCall, concatMapInner));
                }
            } catch (Throwable th) {
                Context contextCurrentContext = this.actual.currentContext();
                Operators.onDiscard(t9, contextCurrentContext);
                if (maybeOnError(Operators.onNextError(t9, th, contextCurrentContext), contextCurrentContext, this.upstream)) {
                    return;
                }
                innerComplete();
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (STATE.compareAndSet(this, State.INITIAL, State.REQUESTED)) {
                this.upstream.request(1L);
            }
            this.inner.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.upstream;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.state == State.TERMINATED);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.state == State.CANCELLED);
            }
            if (attr == Scannable.Attr.DELAY_ERROR) {
                return Boolean.valueOf(this.errorMode != FluxConcatMap.ErrorMode.IMMEDIATE);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxConcatMapNoPrefetch(Flux<? extends T> flux, Function<? super T, ? extends Z9.c> function, FluxConcatMap.ErrorMode errorMode) {
        super(flux);
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
        this.errorMode = errorMode;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return 0;
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
        return new FluxConcatMapNoPrefetchSubscriber(coreSubscriber, this.mapper, this.errorMode);
    }
}
