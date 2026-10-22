package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxConcatMap;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxConcatMapNoPrefetch<T, R> extends InternalFluxOperator<T, R> {
    final FluxConcatMap.ErrorMode errorMode;
    final Function<? super T, ? extends qc.b<? extends R>> mapper;

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
        final Function<? super T, ? extends qc.b<? extends R>> mapper;
        volatile State state;
        qc.d upstream;
        static final AtomicReferenceFieldUpdater<FluxConcatMapNoPrefetchSubscriber, State> STATE = AtomicReferenceFieldUpdater.newUpdater(FluxConcatMapNoPrefetchSubscriber.class, State.class, VoiceWakeupReceiver.EXTRA_STATE);
        static final AtomicReferenceFieldUpdater<FluxConcatMapNoPrefetchSubscriber, Throwable> ERROR = AtomicReferenceFieldUpdater.newUpdater(FluxConcatMapNoPrefetchSubscriber.class, Throwable.class, "error");

        public enum State {
            INITIAL,
            REQUESTED,
            ACTIVE,
            LAST_ACTIVE,
            TERMINATED,
            CANCELLED
        }

        public FluxConcatMapNoPrefetchSubscriber(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends qc.b<? extends R>> function, FluxConcatMap.ErrorMode errorMode) {
            this.actual = coreSubscriber;
            this.mapper = function;
            this.errorMode = errorMode;
            STATE.lazySet(this, State.INITIAL);
        }

        private boolean maybeOnError(@Nullable Throwable th, Context context, qc.d dVar) {
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
                int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[state.ordinal()];
                if (i10 == 1 || i10 == 2) {
                    return true;
                }
            } while (!STATE.compareAndSet(this, state, State.TERMINATED));
            dVar.cancel();
            synchronized (this) {
                this.actual.onError(this.error);
            }
            return true;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[STATE.getAndSet(this, State.CANCELLED).ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
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
                int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[state.ordinal()];
                if (i10 != 5) {
                    if (i10 != 6) {
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
        public synchronized void innerNext(R r10) {
            try {
                int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[this.state.ordinal()];
                if (i10 == 5 || i10 == 6) {
                    this.actual.onNext(r10);
                } else {
                    Operators.onDiscard(r10, currentContext());
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            while (true) {
                State state = this.state;
                int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[state.ordinal()];
                if (i10 == 3 || i10 == 4) {
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
                } else if (i10 != 5 || STATE.compareAndSet(this, state, State.LAST_ACTIVE)) {
                    return;
                }
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (maybeOnError(th, currentContext(), this.inner)) {
                return;
            }
            onComplete();
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (!STATE.compareAndSet(this, State.REQUESTED, State.ACTIVE)) {
                int i10 = AnonymousClass1.$SwitchMap$reactor$core$publisher$FluxConcatMapNoPrefetch$FluxConcatMapNoPrefetchSubscriber$State[this.state.ordinal()];
                if (i10 == 1) {
                    Operators.onDiscard(t10, currentContext());
                    return;
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    Operators.onNextDropped(t10, currentContext());
                    return;
                }
            }
            try {
                qc.b<? extends R> bVarApply = this.mapper.apply(t10);
                Objects.requireNonNull(bVarApply, "The mapper returned a null Publisher");
                if (!(bVarApply instanceof Callable)) {
                    Operators.toFluxOrMono(bVarApply).subscribe((qc.c) this.inner);
                    return;
                }
                Object objCall = ((Callable) bVarApply).call();
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
                Operators.onDiscard(t10, contextCurrentContext);
                if (maybeOnError(Operators.onNextError(t10, th, contextCurrentContext), contextCurrentContext, this.upstream)) {
                    return;
                }
                innerComplete();
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.FluxConcatMap.FluxConcatMapSupport, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (STATE.compareAndSet(this, State.INITIAL, State.REQUESTED)) {
                this.upstream.request(1L);
            }
            this.inner.request(j10);
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

    public FluxConcatMapNoPrefetch(Flux<? extends T> flux, Function<? super T, ? extends qc.b<? extends R>> function, FluxConcatMap.ErrorMode errorMode) {
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
