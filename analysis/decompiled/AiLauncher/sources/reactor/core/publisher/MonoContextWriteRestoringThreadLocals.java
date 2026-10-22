package reactor.core.publisher;

import io.micrometer.context.ContextSnapshot;
import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class MonoContextWriteRestoringThreadLocals<T> extends MonoOperator<T, T> {
    final Function<Context, Context> doOnContext;

    public static final class ContextWriteRestoringThreadLocalsSubscriber<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Context context;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39648s;

        public ContextWriteRestoringThreadLocalsSubscriber(CoreSubscriber<? super T> coreSubscriber, Context context) {
            this.actual = coreSubscriber;
            this.context = context;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.context);
            try {
                this.f39648s.cancel();
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.context;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.context);
                return;
            }
            this.done = true;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.done = true;
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                this.actual.onNext(t10);
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

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.actual.currentContext());
            try {
                if (Operators.validate(this.f39648s, dVar)) {
                    this.f39648s = dVar;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(this.context);
            try {
                this.f39648s.request(j10);
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

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39648s : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public MonoContextWriteRestoringThreadLocals(Mono<? extends T> mono, Function<Context, Context> function) {
        super(mono);
        Objects.requireNonNull(function, "doOnContext");
        this.doOnContext = function;
    }

    @Override // reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == InternalProducerAttr.INSTANCE ? Boolean.TRUE : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        Context contextApply = this.doOnContext.apply(coreSubscriber.currentContext());
        ContextSnapshot.Scope threadLocals = ContextPropagation.setThreadLocals(contextApply);
        try {
            this.source.subscribe((CoreSubscriber) new ContextWriteRestoringThreadLocalsSubscriber(coreSubscriber, contextApply));
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
