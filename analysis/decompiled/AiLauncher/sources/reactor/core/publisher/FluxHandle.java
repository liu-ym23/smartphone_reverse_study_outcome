package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* loaded from: classes5.dex */
final class FluxHandle<T, R> extends InternalFluxOperator<T, R> {
    final BiConsumer<? super T, SynchronousSink<R>> handler;

    public static final class HandleConditionalSubscriber<T, R> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, R>, SynchronousSink<R> {
        final Fuseable.ConditionalSubscriber<? super R> actual;
        R data;
        boolean done;
        Throwable error;
        final BiConsumer<? super T, SynchronousSink<R>> handler;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39515s;
        boolean stop;

        public HandleConditionalSubscriber(Fuseable.ConditionalSubscriber<? super R> conditionalSubscriber, BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
            this.actual = conditionalSubscriber;
            this.handler = biConsumer;
        }

        private void reset() {
            this.done = false;
            this.stop = false;
            this.error = null;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39515s.cancel();
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void complete() {
            if (this.stop) {
                throw new IllegalStateException("Cannot complete after a complete or error");
            }
            this.stop = true;
        }

        @Override // reactor.core.publisher.SynchronousSink
        public ContextView contextView() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.CoreSubscriber
        @Deprecated
        public Context currentContext() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void error(Throwable th) {
            if (this.stop) {
                throw new IllegalStateException("Cannot error after a complete or error");
            }
            Objects.requireNonNull(th, "error");
            this.error = th;
            this.stop = true;
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void next(R r10) {
            if (this.data != null) {
                throw new IllegalStateException("Cannot emit more than one data");
            }
            if (this.stop) {
                throw new IllegalStateException("Cannot emit after a complete or error");
            }
            Objects.requireNonNull(r10, "data");
            this.data = r10;
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                this.handler.accept(t10, this);
                R r10 = this.data;
                this.data = null;
                if (r10 != null) {
                    this.actual.onNext(r10);
                }
                if (!this.stop) {
                    if (r10 == null) {
                        this.f39515s.request(1L);
                        return;
                    }
                    return;
                }
                this.done = true;
                Throwable th = this.error;
                if (th == null) {
                    this.f39515s.cancel();
                    this.actual.onComplete();
                    return;
                }
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39515s);
                if (thOnNextError != null) {
                    this.actual.onError(thOnNextError);
                } else {
                    reset();
                    this.f39515s.request(1L);
                }
            } catch (Throwable th2) {
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, this.actual.currentContext(), this.f39515s);
                if (thOnNextError2 != null) {
                    onError(thOnNextError2);
                } else {
                    this.error = null;
                    this.f39515s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39515s, dVar)) {
                this.f39515s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39515s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39515s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return false;
            }
            try {
                this.handler.accept(t10, this);
                R r10 = this.data;
                this.data = null;
                boolean zTryOnNext = r10 != null ? this.actual.tryOnNext(r10) : false;
                if (!this.stop) {
                    return zTryOnNext;
                }
                this.done = true;
                Throwable th = this.error;
                if (th != null) {
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39515s);
                    if (thOnNextError == null) {
                        reset();
                        return false;
                    }
                    this.actual.onError(thOnNextError);
                } else {
                    this.f39515s.cancel();
                    this.actual.onComplete();
                }
                return true;
            } catch (Throwable th2) {
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, this.actual.currentContext(), this.f39515s);
                if (thOnNextError2 != null) {
                    onError(thOnNextError2);
                    return true;
                }
                reset();
                return false;
            }
        }
    }

    public static final class HandleSubscriber<T, R> implements InnerOperator<T, R>, Fuseable.ConditionalSubscriber<T>, SynchronousSink<R> {
        final CoreSubscriber<? super R> actual;
        R data;
        boolean done;
        Throwable error;
        final BiConsumer<? super T, SynchronousSink<R>> handler;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39516s;
        boolean stop;

        public HandleSubscriber(CoreSubscriber<? super R> coreSubscriber, BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
            this.actual = coreSubscriber;
            this.handler = biConsumer;
        }

        private void reset() {
            this.done = false;
            this.stop = false;
            this.error = null;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39516s.cancel();
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void complete() {
            if (this.stop) {
                throw new IllegalStateException("Cannot complete after a complete or error");
            }
            this.stop = true;
        }

        @Override // reactor.core.publisher.SynchronousSink
        public ContextView contextView() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.CoreSubscriber
        @Deprecated
        public Context currentContext() {
            return this.actual.currentContext();
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void error(Throwable th) {
            if (this.stop) {
                throw new IllegalStateException("Cannot error after a complete or error");
            }
            Objects.requireNonNull(th, "error");
            this.error = th;
            this.stop = true;
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void next(R r10) {
            if (this.data != null) {
                throw new IllegalStateException("Cannot emit more than one data");
            }
            if (this.stop) {
                throw new IllegalStateException("Cannot emit after a complete or error");
            }
            Objects.requireNonNull(r10, "data");
            this.data = r10;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            try {
                this.handler.accept(t10, this);
                R r10 = this.data;
                this.data = null;
                if (r10 != null) {
                    this.actual.onNext(r10);
                }
                if (!this.stop) {
                    if (r10 == null) {
                        this.f39516s.request(1L);
                        return;
                    }
                    return;
                }
                Throwable th = this.error;
                if (th == null) {
                    this.f39516s.cancel();
                    onComplete();
                    return;
                }
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39516s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    reset();
                    this.f39516s.request(1L);
                }
            } catch (Throwable th2) {
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, this.actual.currentContext(), this.f39516s);
                if (thOnNextError2 != null) {
                    onError(thOnNextError2);
                } else {
                    reset();
                    this.f39516s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39516s, dVar)) {
                this.f39516s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39516s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39516s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return false;
            }
            try {
                this.handler.accept(t10, this);
                R r10 = this.data;
                this.data = null;
                if (r10 != null) {
                    this.actual.onNext(r10);
                }
                if (!this.stop) {
                    return r10 != null;
                }
                Throwable th = this.error;
                if (th != null) {
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39516s);
                    if (thOnNextError == null) {
                        reset();
                        return false;
                    }
                    onError(thOnNextError);
                } else {
                    this.f39516s.cancel();
                    onComplete();
                }
                return true;
            } catch (Throwable th2) {
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, this.actual.currentContext(), this.f39516s);
                if (thOnNextError2 != null) {
                    onError(thOnNextError2);
                    return true;
                }
                reset();
                return false;
            }
        }
    }

    public FluxHandle(Flux<? extends T> flux, BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
        super(flux);
        Objects.requireNonNull(biConsumer, "handler");
        this.handler = biConsumer;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        BiConsumer<? super T, SynchronousSink<R>> biConsumerContextRestoreForHandle;
        if (ContextPropagationSupport.shouldRestoreThreadLocalsInSomeOperators()) {
            BiConsumer<? super T, SynchronousSink<R>> biConsumer = this.handler;
            coreSubscriber.getClass();
            biConsumerContextRestoreForHandle = ContextPropagation.contextRestoreForHandle(biConsumer, new J0(coreSubscriber));
        } else {
            biConsumerContextRestoreForHandle = this.handler;
        }
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new HandleConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, biConsumerContextRestoreForHandle) : new HandleSubscriber(coreSubscriber, biConsumerContextRestoreForHandle);
    }
}
