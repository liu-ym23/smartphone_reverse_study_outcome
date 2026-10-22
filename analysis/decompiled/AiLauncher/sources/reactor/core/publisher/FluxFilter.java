package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
final class FluxFilter<T> extends InternalFluxOperator<T, T> {
    final Predicate<? super T> predicate;

    public static final class FilterConditionalSubscriber<T> implements InnerOperator<T, T>, Fuseable.ConditionalSubscriber<T> {
        final Fuseable.ConditionalSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39506s;

        public FilterConditionalSubscriber(Fuseable.ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            this.actual = conditionalSubscriber;
            this.ctx = conditionalSubscriber.currentContext();
            this.predicate = predicate;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39506s.cancel();
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
                Operators.onErrorDropped(th, this.ctx);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            try {
                if (this.predicate.test(t10)) {
                    this.actual.onNext(t10);
                } else {
                    this.f39506s.request(1L);
                    Operators.onDiscard(t10, this.ctx);
                }
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.ctx, this.f39506s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f39506s.request(1L);
                }
                Operators.onDiscard(t10, this.ctx);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39506s, dVar)) {
                this.f39506s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39506s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39506s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return false;
            }
            try {
                if (this.predicate.test(t10)) {
                    return this.actual.tryOnNext(t10);
                }
                Operators.onDiscard(t10, this.ctx);
                return false;
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.ctx, this.f39506s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                }
                Operators.onDiscard(t10, this.ctx);
                return false;
            }
        }
    }

    public static final class FilterSubscriber<T> implements InnerOperator<T, T>, Fuseable.ConditionalSubscriber<T> {
        final CoreSubscriber<? super T> actual;
        final Context ctx;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39507s;

        public FilterSubscriber(CoreSubscriber<? super T> coreSubscriber, Predicate<? super T> predicate) {
            this.actual = coreSubscriber;
            this.ctx = coreSubscriber.currentContext();
            this.predicate = predicate;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39507s.cancel();
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
                Operators.onErrorDropped(th, this.ctx);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return;
            }
            try {
                if (this.predicate.test(t10)) {
                    this.actual.onNext(t10);
                } else {
                    Operators.onDiscard(t10, this.ctx);
                    this.f39507s.request(1L);
                }
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.ctx, this.f39507s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f39507s.request(1L);
                }
                Operators.onDiscard(t10, this.ctx);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39507s, dVar)) {
                this.f39507s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39507s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39507s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.ctx);
                return false;
            }
            try {
                boolean zTest = this.predicate.test(t10);
                if (zTest) {
                    this.actual.onNext(t10);
                    return zTest;
                }
                Operators.onDiscard(t10, this.ctx);
                return zTest;
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.ctx, this.f39507s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                }
                Operators.onDiscard(t10, this.ctx);
                return false;
            }
        }
    }

    public FluxFilter(Flux<? extends T> flux, Predicate<? super T> predicate) {
        super(flux);
        Objects.requireNonNull(predicate, "predicate");
        this.predicate = predicate;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FilterConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.predicate) : new FilterSubscriber(coreSubscriber, this.predicate);
    }
}
