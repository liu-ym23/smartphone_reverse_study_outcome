package reactor.core.publisher;

import io.micrometer.context.ContextSnapshot;
import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxContextWriteRestoringThreadLocalsFuseable<T> extends FluxOperator<T, T> implements Fuseable {
    final Function<Context, Context> doOnContext;

    public static class FuseableContextWriteRestoringThreadLocalsSubscriber<T> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, T>, Fuseable.QueueSubscription<T> {
        final CoreSubscriber<? super T> actual;
        final Fuseable.ConditionalSubscriber<? super T> actualConditional;
        final Context context;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5719s;

        public FuseableContextWriteRestoringThreadLocalsSubscriber(CoreSubscriber<? super T> coreSubscriber, Context context) {
            this.actual = coreSubscriber;
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
                this.f5719s.cancel();
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
        }

        @Override // java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Nope");
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            throw new UnsupportedOperationException("Nope");
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                this.actual.onComplete();
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
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
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

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
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
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                if (Operators.validate(this.f5719s, eVar)) {
                    this.f5719s = eVar;
                    this.actual.onSubscribe(this);
                }
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
        }

        @Override // java.util.Queue
        public T poll() {
            throw new UnsupportedOperationException("Nope");
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.context);
            try {
                this.f5719s.request(j5);
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
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f5719s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // java.util.Collection
        public int size() {
            throw new UnsupportedOperationException("Nope");
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t9) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber = this.actualConditional;
                if (conditionalSubscriber != null) {
                    boolean zTryOnNext = conditionalSubscriber.tryOnNext(t9);
                    if (threadLocals != null) {
                        threadLocals.close();
                    }
                    return zTryOnNext;
                }
                this.actual.onNext(t9);
                if (threadLocals != null) {
                    threadLocals.close();
                }
                return true;
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
        }
    }

    public FluxContextWriteRestoringThreadLocalsFuseable(Flux<? extends T> flux, Function<Context, Context> function) {
        super(flux);
        Objects.requireNonNull(function, "doOnContext");
        this.doOnContext = function;
    }

    @Override // reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == InternalProducerAttr.INSTANCE ? Boolean.TRUE : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Context contextApply = this.doOnContext.apply(coreSubscriber.currentContext());
        ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(contextApply);
        try {
            this.source.subscribe((CoreSubscriber) new FuseableContextWriteRestoringThreadLocalsSubscriber(coreSubscriber, contextApply));
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
    }
}
