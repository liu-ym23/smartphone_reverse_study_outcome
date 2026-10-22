package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoReduceSeed<T, R> extends MonoFromFluxOperator<T, R> implements Fuseable {
    final BiFunction<R, ? super T, R> accumulator;
    final Supplier<R> initialSupplier;

    public static final class ReduceSeedSubscriber<T, R> extends Operators.BaseFluxToMonoOperator<T, R> {
        final BiFunction<R, ? super T, R> accumulator;
        boolean done;
        R seed;

        public ReduceSeedSubscriber(CoreSubscriber<? super R> coreSubscriber, BiFunction<R, ? super T, R> biFunction, R r5) {
            super(coreSubscriber);
            this.accumulator = biFunction;
            this.seed = r5;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public R accumulatedValue() {
            R r5;
            synchronized (this) {
                r5 = this.seed;
                this.seed = null;
            }
            return r5;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            R r5;
            this.f5875s.cancel();
            synchronized (this) {
                r5 = this.seed;
                this.seed = null;
            }
            if (r5 == null) {
                return;
            }
            Operators.onDiscard(r5, this.actual.currentContext());
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            completePossiblyEmpty();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            R r5;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                r5 = this.seed;
                this.seed = null;
            }
            if (r5 == null) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                Operators.onDiscard(r5, this.actual.currentContext());
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            try {
                synchronized (this) {
                    try {
                        R r5 = this.seed;
                        if (r5 == null) {
                            Operators.onDiscard(t9, this.actual.currentContext());
                            return;
                        }
                        R rApply = this.accumulator.apply(r5, t9);
                        Objects.requireNonNull(rApply, "The accumulator returned a null value");
                        this.seed = rApply;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                onError(Operators.onOperatorError(this.f5875s, th2, t9, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(!this.done && this.seed == null);
            }
            return super.scanUnsafe(attr);
        }
    }

    public MonoReduceSeed(Flux<? extends T> flux, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(flux);
        Objects.requireNonNull(supplier, "initialSupplier");
        this.initialSupplier = supplier;
        Objects.requireNonNull(biFunction, "accumulator");
        this.accumulator = biFunction;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        R r5 = this.initialSupplier.get();
        Objects.requireNonNull(r5, "The initial value supplied is null");
        return new ReduceSeedSubscriber(coreSubscriber, this.accumulator, r5);
    }
}
