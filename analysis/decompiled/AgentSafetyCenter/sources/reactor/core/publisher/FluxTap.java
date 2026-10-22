package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.observability.SignalListener;
import reactor.core.observability.SignalListenerFactory;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxTap<T, STATE> extends InternalFluxOperator<T, T> {
    final STATE commonTapState;
    final SignalListenerFactory<T, STATE> tapFactory;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class TapConditionalSubscriber<T> extends TapSubscriber<T> implements Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> actualConditional;

        public TapConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, SignalListener<T> signalListener, Context context) {
            super(conditionalSubscriber, signalListener, context);
            this.actualConditional = conditionalSubscriber;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (!this.actualConditional.tryOnNext(t10)) {
                return false;
            }
            try {
                this.listener.doOnNext(t10);
                return true;
            } catch (Throwable th) {
                handleListenerErrorAndTerminate(th);
                return true;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class TapSubscriber<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Context context;
        boolean done;
        final SignalListener<T> listener;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10697s;

        public TapSubscriber(CoreSubscriber<? super T> coreSubscriber, SignalListener<T> signalListener, Context context) {
            this.actual = coreSubscriber;
            this.listener = signalListener;
            this.context = context;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            try {
                this.listener.doOnCancel();
                try {
                    this.f10697s.cancel();
                } finally {
                    try {
                        this.listener.doFinally(SignalType.CANCEL);
                    } catch (Throwable th) {
                        handleListenerErrorAndTerminate(th);
                    }
                }
            } catch (Throwable th2) {
                handleListenerErrorAndTerminate(th2);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        public void handleListenerErrorAndTerminate(Throwable th) {
            this.f10697s.cancel();
            this.listener.handleListenerError(th);
            this.actual.onError(th);
        }

        public void handleListenerErrorMultipleAndTerminate(Throwable th, Throwable th2) {
            this.f10697s.cancel();
            this.listener.handleListenerError(th);
            this.actual.onError(Exceptions.multiple(th, th2));
        }

        public void handleListenerErrorPostTermination(Throwable th) {
            this.listener.handleListenerError(th);
            Operators.onErrorDropped(th, this.actual.currentContext());
        }

        public void handleListenerErrorPreSubscription(Throwable th, qd.e eVar) {
            eVar.cancel();
            this.listener.handleListenerError(th);
            Operators.error(this.actual, th);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                try {
                    this.listener.doOnMalformedOnComplete();
                    return;
                } catch (Throwable th) {
                    handleListenerErrorPostTermination(th);
                    return;
                }
            }
            this.done = true;
            try {
                this.listener.doOnComplete();
                this.actual.onComplete();
                try {
                    this.listener.doAfterComplete();
                    this.listener.doFinally(SignalType.ON_COMPLETE);
                } catch (Throwable th2) {
                    handleListenerErrorPostTermination(th2);
                }
            } catch (Throwable th3) {
                handleListenerErrorAndTerminate(th3);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                try {
                    this.listener.doOnMalformedOnError(th);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
            this.done = true;
            try {
                this.listener.doOnError(th);
                this.actual.onError(th);
                try {
                    this.listener.doAfterError(th);
                    this.listener.doFinally(SignalType.ON_ERROR);
                } catch (Throwable th2) {
                    handleListenerErrorPostTermination(th2);
                }
            } catch (Throwable th3) {
                handleListenerErrorMultipleAndTerminate(th3, th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            boolean z10 = this.done;
            SignalListener<T> signalListener = this.listener;
            if (!z10) {
                try {
                    signalListener.doOnNext(t10);
                    this.actual.onNext(t10);
                    return;
                } catch (Throwable th) {
                    handleListenerErrorAndTerminate(th);
                    return;
                }
            }
            try {
                signalListener.doOnMalformedOnNext(t10);
            } catch (Throwable th2) {
                try {
                    handleListenerErrorPostTermination(th2);
                } finally {
                    Operators.onNextDropped(t10, currentContext());
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10697s, eVar)) {
                this.f10697s = eVar;
                try {
                    this.listener.doOnSubscription();
                    this.actual.onSubscribe(this);
                } catch (Throwable th) {
                    handleListenerErrorPreSubscription(th, eVar);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                try {
                    this.listener.doOnRequest(j10);
                    this.f10697s.request(j10);
                } catch (Throwable th) {
                    handleListenerErrorAndTerminate(th);
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10697s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxTap(Flux<? extends T> flux, SignalListenerFactory<T, STATE> signalListenerFactory) {
        super(flux);
        this.tapFactory = signalListenerFactory;
        this.commonTapState = signalListenerFactory.initializePublisherState(flux);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        try {
            SignalListener<T> signalListenerCreateListener = this.tapFactory.createListener(this.source, coreSubscriber.currentContext().readOnly(), this.commonTapState);
            if (ContextPropagationSupport.isContextPropagationAvailable()) {
                y yVar = new y(1);
                yVar.f10881f = coreSubscriber;
                VarHandle.storeStoreFence();
                signalListenerCreateListener = ContextPropagation.contextRestoreForTap(signalListenerCreateListener, yVar);
            }
            try {
                signalListenerCreateListener.doFirst();
                try {
                    Context contextAddToContext = signalListenerCreateListener.addToContext(coreSubscriber.currentContext());
                    return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new TapConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, signalListenerCreateListener, contextAddToContext) : new TapSubscriber(coreSubscriber, signalListenerCreateListener, contextAddToContext);
                } catch (Throwable th) {
                    IllegalStateException illegalStateException = new IllegalStateException("Unable to augment tap Context at subscription via addToContext", th);
                    signalListenerCreateListener.handleListenerError(illegalStateException);
                    Operators.error(coreSubscriber, illegalStateException);
                    return null;
                }
            } catch (Throwable th2) {
                signalListenerCreateListener.handleListenerError(th2);
                Operators.error(coreSubscriber, th2);
                return null;
            }
        } catch (Throwable th3) {
            Operators.error(coreSubscriber, th3);
            return null;
        }
    }
}
