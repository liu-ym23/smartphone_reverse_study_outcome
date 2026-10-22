package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.observability.SignalListener;
import reactor.core.observability.SignalListenerFactory;
import reactor.core.publisher.FluxTap;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxTapFuseable<T, STATE> extends InternalFluxOperator<T, T> implements Fuseable {
    final STATE commonTapState;
    final SignalListenerFactory<T, STATE> tapFactory;

    public static final class TapConditionalFuseableSubscriber<T> extends TapFuseableSubscriber<T> implements Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> actualConditional;

        public TapConditionalFuseableSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, SignalListener<T> signalListener, Context context) {
            super(conditionalSubscriber, signalListener, context);
            this.actualConditional = conditionalSubscriber;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            if (!this.actualConditional.tryOnNext(t9)) {
                return false;
            }
            try {
                this.listener.doOnNext(t9);
                return true;
            } catch (Throwable th) {
                handleListenerErrorAndTerminate(th);
                return true;
            }
        }
    }

    public static class TapFuseableSubscriber<T> extends FluxTap.TapSubscriber<T> implements Fuseable.QueueSubscription<T> {
        int mode;
        Fuseable.QueueSubscription<T> qs;

        public TapFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, SignalListener<T> signalListener, Context context) {
            super(coreSubscriber, signalListener, context);
        }

        @Override // java.util.Collection
        public void clear() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription != null) {
                queueSubscription.clear();
            }
        }

        public RuntimeException handleObserverErrorInPoll(Throwable th) {
            this.qs.cancel();
            this.listener.handleListenerError(th);
            return Exceptions.propagate(th);
        }

        public RuntimeException handleObserverErrorMultipleInPoll(Throwable th, RuntimeException runtimeException) {
            this.qs.cancel();
            this.listener.handleListenerError(th);
            return Exceptions.multiple(th, runtimeException);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            return queueSubscription == null || queueSubscription.isEmpty();
        }

        @Override // reactor.core.publisher.FluxTap.TapSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.mode == 2) {
                this.actual.onNext(null);
            } else {
                super.onNext(t9);
            }
        }

        @Override // reactor.core.publisher.FluxTap.TapSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5810s, eVar)) {
                if (!(eVar instanceof Fuseable.QueueSubscription)) {
                    handleListenerErrorPreSubscription(new IllegalStateException("Fuseable subscriber but no QueueSubscription"), eVar);
                    return;
                }
                this.f5810s = eVar;
                this.qs = (Fuseable.QueueSubscription) eVar;
                try {
                    this.listener.doOnSubscription();
                    this.actual.onSubscribe(this);
                } catch (Throwable th) {
                    handleListenerErrorPreSubscription(th, eVar);
                }
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            RuntimeException runtimeExceptionHandleObserverErrorMultipleInPoll;
            RuntimeException runtimeExceptionHandleObserverErrorInPoll;
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return null;
            }
            try {
                T tPoll = queueSubscription.poll();
                if (tPoll == null && (this.done || this.mode == 1)) {
                    try {
                        this.listener.doOnComplete();
                        try {
                            this.listener.doFinally(SignalType.ON_COMPLETE);
                            return null;
                        } finally {
                        }
                    } finally {
                    }
                }
                if (tPoll == null) {
                    return tPoll;
                }
                try {
                    this.listener.doOnNext(tPoll);
                    return tPoll;
                } catch (Throwable th) {
                    if (this.mode == 1) {
                        throw handleObserverErrorInPoll(th);
                    }
                    handleListenerErrorAndTerminate(th);
                    return null;
                }
            } catch (RuntimeException e) {
                try {
                    this.listener.doOnError(e);
                    try {
                        this.listener.doFinally(SignalType.ON_ERROR);
                        throw e;
                    } finally {
                    }
                } finally {
                }
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                this.mode = 0;
                return 0;
            }
            int iRequestFusion = queueSubscription.requestFusion(i);
            this.mode = iRequestFusion;
            try {
                this.listener.doOnFusion(iRequestFusion);
                return this.mode;
            } catch (Throwable th) {
                int i6 = this.mode;
                if (i6 == 2 || i6 == 0) {
                    this.handleListenerErrorAndTerminate(th);
                    return 0;
                }
                this.listener.handleListenerError(th);
                return this.mode;
            }
        }

        @Override // java.util.Collection
        public int size() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            return queueSubscription.size();
        }
    }

    public FluxTapFuseable(Flux<? extends T> flux, SignalListenerFactory<T, STATE> signalListenerFactory) {
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
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) throws Throwable {
        try {
            SignalListener<T> signalListenerCreateListener = this.tapFactory.createListener(this.source, coreSubscriber.currentContext().readOnly(), this.commonTapState);
            if (ContextPropagationSupport.isContextPropagationAvailable()) {
                signalListenerCreateListener = ContextPropagation.contextRestoreForTap(signalListenerCreateListener, new C1907x(coreSubscriber, 1));
            }
            try {
                signalListenerCreateListener.doFirst();
                try {
                    Context contextAddToContext = signalListenerCreateListener.addToContext(coreSubscriber.currentContext());
                    return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new TapConditionalFuseableSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, signalListenerCreateListener, contextAddToContext) : new TapFuseableSubscriber(coreSubscriber, signalListenerCreateListener, contextAddToContext);
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
