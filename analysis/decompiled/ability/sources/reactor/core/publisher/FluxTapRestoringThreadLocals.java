package reactor.core.publisher;

import io.micrometer.context.ContextSnapshot;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.observability.SignalListener;
import reactor.core.observability.SignalListenerFactory;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxTapRestoringThreadLocals<T, STATE> extends FluxOperator<T, T> {
    final STATE commonTapState;
    final SignalListenerFactory<T, STATE> tapFactory;

    public static class TapSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Fuseable.ConditionalSubscriber<? super T> actualConditional;
        final Context context;
        boolean done;
        final SignalListener<T> listener;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5811s;

        public TapSubscriber(CoreSubscriber<? super T> coreSubscriber, SignalListener<T> signalListener, Context context) {
            this.actual = coreSubscriber;
            this.listener = signalListener;
            this.context = context;
            if (coreSubscriber instanceof Fuseable.ConditionalSubscriber) {
                this.actualConditional = (Fuseable.ConditionalSubscriber) coreSubscriber;
            } else {
                this.actualConditional = null;
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.context);
            try {
                try {
                    this.listener.doOnCancel();
                } catch (Throwable th) {
                    handleListenerErrorAndTerminate(th);
                    if (threadLocals == null) {
                        return;
                    }
                }
                try {
                    this.f5811s.cancel();
                    if (threadLocals == null) {
                        return;
                    }
                    threadLocals.close();
                } finally {
                    try {
                        this.listener.doFinally(SignalType.CANCEL);
                    } catch (Throwable th2) {
                        handleListenerErrorAndTerminate(th2);
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    if (threadLocals != null) {
                        try {
                            threadLocals.close();
                        } catch (Throwable th5) {
                            th3.addSuppressed(th5);
                        }
                    }
                    throw th4;
                }
            }
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        public void handleListenerErrorAndTerminate(Throwable th) {
            this.f5811s.cancel();
            this.listener.handleListenerError(th);
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                this.actual.onError(th);
                if (threadLocals != null) {
                    threadLocals.close();
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (threadLocals != null) {
                        try {
                            threadLocals.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        }

        public void handleListenerErrorMultipleAndTerminate(Throwable th, Throwable th2) {
            this.f5811s.cancel();
            this.listener.handleListenerError(th);
            RuntimeException runtimeExceptionMultiple = Exceptions.multiple(th, th2);
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                this.actual.onError(runtimeExceptionMultiple);
                if (threadLocals != null) {
                    threadLocals.close();
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    if (threadLocals != null) {
                        try {
                            threadLocals.close();
                        } catch (Throwable th5) {
                            th3.addSuppressed(th5);
                        }
                    }
                    throw th4;
                }
            }
        }

        public void handleListenerErrorPostTermination(Throwable th) {
            this.listener.handleListenerError(th);
            Operators.onErrorDropped(th, this.actual.currentContext());
        }

        public void handleListenerErrorPreSubscription(Throwable th, Z9.e eVar) {
            eVar.cancel();
            this.listener.handleListenerError(th);
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                Operators.error(this.actual, th);
                if (threadLocals != null) {
                    threadLocals.close();
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (threadLocals != null) {
                        try {
                            threadLocals.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
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
                ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
                try {
                    this.actual.onComplete();
                    if (threadLocals != null) {
                        threadLocals.close();
                    }
                    try {
                        this.listener.doAfterComplete();
                        this.listener.doFinally(SignalType.ON_COMPLETE);
                    } catch (Throwable th2) {
                        handleListenerErrorPostTermination(th2);
                    }
                } finally {
                }
            } catch (Throwable th3) {
                handleListenerErrorAndTerminate(th3);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
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
                ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
                try {
                    this.actual.onError(th);
                    if (threadLocals != null) {
                        threadLocals.close();
                    }
                    try {
                        this.listener.doAfterError(th);
                        this.listener.doFinally(SignalType.ON_ERROR);
                    } catch (Throwable th2) {
                        handleListenerErrorPostTermination(th2);
                    }
                } finally {
                }
            } catch (Throwable th3) {
                handleListenerErrorMultipleAndTerminate(th3, th);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                try {
                    this.listener.doOnMalformedOnNext(t9);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
            try {
                this.listener.doOnNext(t9);
                ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
                try {
                    this.actual.onNext(t9);
                    if (threadLocals != null) {
                        threadLocals.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (threadLocals != null) {
                            try {
                                threadLocals.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                handleListenerErrorAndTerminate(th4);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5811s, eVar)) {
                this.f5811s = eVar;
                try {
                    this.listener.doOnSubscription();
                    ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
                    try {
                        this.actual.onSubscribe(this);
                        if (threadLocals != null) {
                            threadLocals.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (threadLocals != null) {
                                try {
                                    threadLocals.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    handleListenerErrorPreSubscription(th4, eVar);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.context);
            try {
                if (Operators.validate(j5)) {
                    try {
                        this.listener.doOnRequest(j5);
                        this.f5811s.request(j5);
                    } catch (Throwable th) {
                        handleListenerErrorAndTerminate(th);
                        if (threadLocals != null) {
                            threadLocals.close();
                            return;
                        }
                        return;
                    }
                }
                if (threadLocals != null) {
                    threadLocals.close();
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (threadLocals != null) {
                        try {
                            threadLocals.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5811s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == InternalProducerAttr.INSTANCE ? Boolean.TRUE : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actualConditional;
                if (conditionalSubscriber == null) {
                    this.actual.onNext(t9);
                } else if (!conditionalSubscriber.tryOnNext(t9)) {
                    if (threadLocals != null) {
                        threadLocals.close();
                    }
                    return false;
                }
                if (threadLocals != null) {
                    threadLocals.close();
                }
                try {
                    this.listener.doOnNext(t9);
                    return true;
                } catch (Throwable th) {
                    handleListenerErrorAndTerminate(th);
                    return true;
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (threadLocals != null) {
                        try {
                            threadLocals.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public FluxTapRestoringThreadLocals(Flux<? extends T> flux, SignalListenerFactory<T, STATE> signalListenerFactory) {
        super(flux);
        this.tapFactory = signalListenerFactory;
        this.commonTapState = signalListenerFactory.initializePublisherState(flux);
    }

    @Override // reactor.core.publisher.FluxOperator, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == InternalProducerAttr.INSTANCE ? Boolean.TRUE : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        try {
            SignalListener<T> signalListenerCreateListener = this.tapFactory.createListener(this.source, coreSubscriber.currentContext().readOnly(), this.commonTapState);
            try {
                signalListenerCreateListener.doFirst();
                try {
                    Context contextAddToContext = signalListenerCreateListener.addToContext(coreSubscriber.currentContext());
                    ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(contextAddToContext);
                    try {
                        this.source.subscribe((CoreSubscriber) new TapSubscriber(coreSubscriber, signalListenerCreateListener, contextAddToContext));
                        if (threadLocals != null) {
                            threadLocals.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (threadLocals != null) {
                                try {
                                    threadLocals.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    IllegalStateException illegalStateException = new IllegalStateException("Unable to augment tap Context at subscription via addToContext", th4);
                    signalListenerCreateListener.handleListenerError(illegalStateException);
                    Operators.error(coreSubscriber, illegalStateException);
                }
            } catch (Throwable th5) {
                signalListenerCreateListener.handleListenerError(th5);
                Operators.error(coreSubscriber, th5);
            }
        } catch (Throwable th6) {
            Operators.error(coreSubscriber, th6);
        }
    }
}
