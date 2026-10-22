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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxTapRestoringThreadLocals<T, STATE> extends FluxOperator<T, T> {
    final STATE commonTapState;
    final SignalListenerFactory<T, STATE> tapFactory;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class TapSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Fuseable.ConditionalSubscriber<? super T> actualConditional;
        final Context context;
        boolean done;
        final SignalListener<T> listener;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10698s;

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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
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
                    this.f10698s.cancel();
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
            this.f10698s.cancel();
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
            this.f10698s.cancel();
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

        public void handleListenerErrorPreSubscription(Throwable th, qd.e eVar) {
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            boolean z10 = this.done;
            SignalListener<T> signalListener = this.listener;
            if (z10) {
                try {
                    signalListener.doOnMalformedOnNext(t10);
                    return;
                } catch (Throwable th) {
                    try {
                        handleListenerErrorPostTermination(th);
                        return;
                    } finally {
                        Operators.onNextDropped(t10, currentContext());
                    }
                }
            }
            try {
                signalListener.doOnNext(t10);
                ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
                try {
                    this.actual.onNext(t10);
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
            } catch (Throwable th5) {
                handleListenerErrorAndTerminate(th5);
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10698s, eVar)) {
                this.f10698s = eVar;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.context);
            try {
                if (Operators.validate(j10)) {
                    try {
                        this.listener.doOnRequest(j10);
                        this.f10698s.request(j10);
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
            return attr == Scannable.Attr.PARENT ? this.f10698s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == InternalProducerAttr.INSTANCE ? Boolean.TRUE : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actualConditional;
                if (conditionalSubscriber == null) {
                    this.actual.onNext(t10);
                } else if (!conditionalSubscriber.tryOnNext(t10)) {
                    if (threadLocals != null) {
                        threadLocals.close();
                    }
                    return false;
                }
                if (threadLocals != null) {
                    threadLocals.close();
                }
                try {
                    this.listener.doOnNext(t10);
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
