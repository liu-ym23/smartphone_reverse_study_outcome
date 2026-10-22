package reactor.core.publisher;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxPeekFuseable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxPeek<T> extends InternalFluxOperator<T, T> implements SignalPeek<T> {
    final Runnable onAfterTerminateCall;
    final Runnable onCancelCall;
    final Runnable onCompleteCall;
    final Consumer<? super Throwable> onErrorCall;
    final Consumer<? super T> onNextCall;
    final LongConsumer onRequestCall;
    final Consumer<? super qd.e> onSubscribeCall;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class PeekSubscriber<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        boolean done;
        final SignalPeek<T> parent;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10652s;

        public PeekSubscriber(CoreSubscriber<? super T> coreSubscriber, SignalPeek<T> signalPeek) {
            this.actual = coreSubscriber;
            this.parent = signalPeek;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            Runnable runnableOnCancelCall = this.parent.onCancelCall();
            if (runnableOnCancelCall != null) {
                try {
                    runnableOnCancelCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f10652s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.f10652s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            Context contextCurrentContext = this.actual.currentContext();
            if (!contextCurrentContext.isEmpty() && this.parent.onCurrentContextCall() != null) {
                this.parent.onCurrentContextCall().accept(contextCurrentContext);
            }
            return contextCurrentContext;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            Runnable runnableOnCompleteCall = this.parent.onCompleteCall();
            if (runnableOnCompleteCall != null) {
                try {
                    runnableOnCompleteCall.run();
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f10652s, th, this.actual.currentContext()));
                    return;
                }
            }
            this.done = true;
            this.actual.onComplete();
            Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
            if (runnableOnAfterTerminateCall != null) {
                try {
                    runnableOnAfterTerminateCall.run();
                } catch (Throwable th2) {
                    FluxPeek.afterCompleteWithFailure(this.parent, th2, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            Consumer<? super Throwable> consumerOnErrorCall = this.parent.onErrorCall();
            if (consumerOnErrorCall != null) {
                try {
                    consumerOnErrorCall.accept(th);
                } catch (Throwable th2) {
                    th = Operators.onOperatorError(null, th2, th, this.actual.currentContext());
                }
            }
            try {
                this.actual.onError(th);
            } catch (UnsupportedOperationException e10) {
                if (consumerOnErrorCall == null || (!Exceptions.isErrorCallbackNotImplemented(e10) && e10.getCause() != th)) {
                    throw e10;
                }
            }
            Runnable runnableOnAfterTerminateCall = this.parent.onAfterTerminateCall();
            if (runnableOnAfterTerminateCall != null) {
                try {
                    runnableOnAfterTerminateCall.run();
                } catch (Throwable th3) {
                    FluxPeek.afterErrorWithFailure(this.parent, th3, th, this.actual.currentContext());
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            Consumer<? super T> consumerOnNextCall = this.parent.onNextCall();
            if (consumerOnNextCall != null) {
                try {
                    consumerOnNextCall.accept(t10);
                } catch (Throwable th) {
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f10652s);
                    if (thOnNextError == null) {
                        request(1L);
                        return;
                    } else {
                        onError(thOnNextError);
                        return;
                    }
                }
            }
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10652s, eVar)) {
                Consumer<? super qd.e> consumerOnSubscribeCall = this.parent.onSubscribeCall();
                if (consumerOnSubscribeCall != null) {
                    try {
                        consumerOnSubscribeCall.accept(eVar);
                    } catch (Throwable th) {
                        Operators.error(this.actual, Operators.onOperatorError(eVar, th, this.actual.currentContext()));
                        return;
                    }
                }
                this.f10652s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            LongConsumer longConsumerOnRequestCall = this.parent.onRequestCall();
            if (longConsumerOnRequestCall != null) {
                try {
                    longConsumerOnRequestCall.accept(j10);
                } catch (Throwable th) {
                    Operators.onOperatorError(th, this.actual.currentContext());
                }
            }
            this.f10652s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10652s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxPeek(Flux<? extends T> flux, @Nullable Consumer<? super qd.e> consumer, @Nullable Consumer<? super T> consumer2, @Nullable Consumer<? super Throwable> consumer3, @Nullable Runnable runnable, @Nullable Runnable runnable2, @Nullable LongConsumer longConsumer, @Nullable Runnable runnable3) {
        super(flux);
        this.onSubscribeCall = consumer;
        this.onNextCall = consumer2;
        this.onErrorCall = consumer3;
        this.onCompleteCall = runnable;
        this.onAfterTerminateCall = runnable2;
        this.onRequestCall = longConsumer;
        this.onCancelCall = runnable3;
    }

    public static <T> void afterCompleteWithFailure(SignalPeek<T> signalPeek, Throwable th, Context context) {
        Exceptions.throwIfFatal(th);
        Operators.onErrorDropped(Operators.onOperatorError(th, context), context);
    }

    public static <T> void afterErrorWithFailure(SignalPeek<T> signalPeek, Throwable th, Throwable th2, Context context) {
        Exceptions.throwIfFatal(th);
        Operators.onErrorDropped(Operators.onOperatorError(null, th, th2, context), context);
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onAfterTerminateCall() {
        return this.onAfterTerminateCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCancelCall() {
        return this.onCancelCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCompleteCall() {
        return this.onCompleteCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Throwable> onErrorCall() {
        return this.onErrorCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super T> onNextCall() {
        return this.onNextCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public LongConsumer onRequestCall() {
        return this.onRequestCall;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super qd.e> onSubscribeCall() {
        return this.onSubscribeCall;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FluxPeekFuseable.PeekConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this) : new PeekSubscriber(coreSubscriber, this);
    }
}
