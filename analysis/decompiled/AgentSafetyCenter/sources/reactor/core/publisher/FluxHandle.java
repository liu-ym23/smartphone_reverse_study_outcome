package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.function.BiConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxHandle<T, R> extends InternalFluxOperator<T, R> {
    final BiConsumer<? super T, SynchronousSink<R>> handler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class HandleConditionalSubscriber<T, R> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, R>, SynchronousSink<R> {
        final Fuseable.ConditionalSubscriber<? super R> actual;
        R data;
        boolean done;
        Throwable error;
        final BiConsumer<? super T, SynchronousSink<R>> handler;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10625s;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10625s.cancel();
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void complete() {
            if (this.stop) {
                od.f.e("Cannot complete after a complete or error");
            } else {
                this.stop = true;
            }
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
                od.f.e("Cannot error after a complete or error");
                return;
            }
            Objects.requireNonNull(th, "error");
            this.error = th;
            this.stop = true;
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void next(R r10) {
            if (this.data != null) {
                od.f.e("Cannot emit more than one data");
            } else if (this.stop) {
                od.f.e("Cannot emit after a complete or error");
            } else {
                Objects.requireNonNull(r10, "data");
                this.data = r10;
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber, reactor.core.CoreSubscriber, qd.d
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
                        this.f10625s.request(1L);
                        return;
                    }
                    return;
                }
                this.done = true;
                Throwable th = this.error;
                if (th == null) {
                    this.f10625s.cancel();
                    this.actual.onComplete();
                    return;
                }
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f10625s);
                if (thOnNextError != null) {
                    this.actual.onError(thOnNextError);
                } else {
                    reset();
                    this.f10625s.request(1L);
                }
            } catch (Throwable th2) {
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, this.actual.currentContext(), this.f10625s);
                if (thOnNextError2 != null) {
                    onError(thOnNextError2);
                } else {
                    this.error = null;
                    this.f10625s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10625s, eVar)) {
                this.f10625s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10625s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10625s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f10625s);
                    if (thOnNextError == null) {
                        reset();
                        return false;
                    }
                    this.actual.onError(thOnNextError);
                } else {
                    this.f10625s.cancel();
                    this.actual.onComplete();
                }
                return true;
            } catch (Throwable th2) {
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, this.actual.currentContext(), this.f10625s);
                if (thOnNextError2 != null) {
                    onError(thOnNextError2);
                    return true;
                }
                reset();
                return false;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class HandleSubscriber<T, R> implements InnerOperator<T, R>, Fuseable.ConditionalSubscriber<T>, SynchronousSink<R> {
        final CoreSubscriber<? super R> actual;
        R data;
        boolean done;
        Throwable error;
        final BiConsumer<? super T, SynchronousSink<R>> handler;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10626s;
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10626s.cancel();
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void complete() {
            if (this.stop) {
                od.f.e("Cannot complete after a complete or error");
            } else {
                this.stop = true;
            }
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
                od.f.e("Cannot error after a complete or error");
                return;
            }
            Objects.requireNonNull(th, "error");
            this.error = th;
            this.stop = true;
        }

        @Override // reactor.core.publisher.SynchronousSink
        public void next(R r10) {
            if (this.data != null) {
                od.f.e("Cannot emit more than one data");
            } else if (this.stop) {
                od.f.e("Cannot emit after a complete or error");
            } else {
                Objects.requireNonNull(r10, "data");
                this.data = r10;
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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
                        this.f10626s.request(1L);
                        return;
                    }
                    return;
                }
                Throwable th = this.error;
                if (th == null) {
                    this.f10626s.cancel();
                    onComplete();
                    return;
                }
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f10626s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    reset();
                    this.f10626s.request(1L);
                }
            } catch (Throwable th2) {
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, this.actual.currentContext(), this.f10626s);
                if (thOnNextError2 != null) {
                    onError(thOnNextError2);
                } else {
                    reset();
                    this.f10626s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10626s, eVar)) {
                this.f10626s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10626s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10626s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.ERROR ? this.error : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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
                    Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f10626s);
                    if (thOnNextError == null) {
                        reset();
                        return false;
                    }
                    onError(thOnNextError);
                } else {
                    this.f10626s.cancel();
                    onComplete();
                }
                return true;
            } catch (Throwable th2) {
                Throwable thOnNextError2 = Operators.onNextError(t10, th2, this.actual.currentContext(), this.f10626s);
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
        boolean zShouldRestoreThreadLocalsInSomeOperators = ContextPropagationSupport.shouldRestoreThreadLocalsInSomeOperators();
        BiConsumer<? super T, SynchronousSink<R>> biConsumerContextRestoreForHandle = this.handler;
        if (zShouldRestoreThreadLocalsInSomeOperators) {
            coreSubscriber.getClass();
            y yVar = new y(1);
            yVar.f10881f = coreSubscriber;
            VarHandle.storeStoreFence();
            biConsumerContextRestoreForHandle = ContextPropagation.contextRestoreForHandle(biConsumerContextRestoreForHandle, yVar);
        }
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new HandleConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, biConsumerContextRestoreForHandle) : new HandleSubscriber(coreSubscriber, biConsumerContextRestoreForHandle);
    }
}
