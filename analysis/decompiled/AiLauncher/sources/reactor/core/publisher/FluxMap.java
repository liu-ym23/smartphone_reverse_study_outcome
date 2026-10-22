package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxMap<T, R> extends InternalFluxOperator<T, R> {
    final Function<? super T, ? extends R> mapper;

    public static final class MapConditionalSubscriber<T, R> implements Fuseable.ConditionalSubscriber<T>, InnerOperator<T, R> {
        final Fuseable.ConditionalSubscriber<? super R> actual;
        boolean done;
        final Function<? super T, ? extends R> mapper;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39525s;

        public MapConditionalSubscriber(Fuseable.ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
            this.actual = conditionalSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39525s.cancel();
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
                R rApply = this.mapper.apply(t10);
                if (rApply != null) {
                    this.actual.onNext(rApply);
                    return;
                }
                throw new NullPointerException("The mapper [" + this.mapper.getClass().getName() + "] returned a null value.");
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39525s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f39525s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39525s, dVar)) {
                this.f39525s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39525s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39525s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        @Override // reactor.core.Fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return true;
            }
            try {
                R rApply = this.mapper.apply(t10);
                if (rApply != null) {
                    return this.actual.tryOnNext(rApply);
                }
                throw new NullPointerException("The mapper [" + this.mapper.getClass().getName() + "] returned a null value.");
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39525s);
                if (thOnNextError == null) {
                    return false;
                }
                this.done = true;
                this.actual.onError(thOnNextError);
                return true;
            }
        }
    }

    public static final class MapSubscriber<T, R> implements InnerOperator<T, R> {
        final CoreSubscriber<? super R> actual;
        boolean done;
        final Function<? super T, ? extends R> mapper;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39526s;

        public MapSubscriber(CoreSubscriber<? super R> coreSubscriber, Function<? super T, ? extends R> function) {
            this.actual = coreSubscriber;
            this.mapper = function;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39526s.cancel();
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
                R rApply = this.mapper.apply(t10);
                if (rApply != null) {
                    this.actual.onNext(rApply);
                    return;
                }
                throw new NullPointerException("The mapper [" + this.mapper.getClass().getName() + "] returned a null value.");
            } catch (Throwable th) {
                Throwable thOnNextError = Operators.onNextError(t10, th, this.actual.currentContext(), this.f39526s);
                if (thOnNextError != null) {
                    onError(thOnNextError);
                } else {
                    this.f39526s.request(1L);
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39526s, dVar)) {
                this.f39526s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39526s.request(j10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39526s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxMap(Flux<? extends T> flux, Function<? super T, ? extends R> function) {
        super(flux);
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new MapConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.mapper) : new MapSubscriber(coreSubscriber, this.mapper);
    }
}
