package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class ParallelReduceSeed<T, R> extends ParallelFlux<R> implements Scannable, Fuseable {
    final Supplier<R> initialSupplier;
    final BiFunction<R, ? super T, R> reducer;
    final ParallelFlux<? extends T> source;

    public static final class ParallelReduceSeedSubscriber<T, R> extends Operators.BaseFluxToMonoOperator<T, R> {
        R accumulator;
        boolean done;
        final BiFunction<R, ? super T, R> reducer;

        public ParallelReduceSeedSubscriber(CoreSubscriber<? super R> coreSubscriber, R r10, BiFunction<R, ? super T, R> biFunction) {
            super(coreSubscriber);
            this.accumulator = r10;
            this.reducer = biFunction;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public R accumulatedValue() {
            R r10;
            synchronized (this) {
                try {
                    r10 = this.accumulator;
                    if (r10 != null) {
                        this.accumulator = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return r10;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            R r10;
            this.f39687s.cancel();
            synchronized (this) {
                try {
                    r10 = this.accumulator;
                    if (r10 != null) {
                        this.accumulator = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (r10 == null) {
                return;
            }
            Operators.onDiscard(r10, currentContext());
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            completePossiblyEmpty();
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            R r10;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                try {
                    r10 = this.accumulator;
                    if (r10 != null) {
                        this.accumulator = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (r10 == null) {
                return;
            }
            Operators.onDiscard(r10, currentContext());
            this.actual.onError(th);
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            synchronized (this) {
                try {
                    R r10 = this.accumulator;
                    if (r10 == null) {
                        return;
                    }
                    R rApply = this.reducer.apply(r10, t10);
                    Objects.requireNonNull(rApply, "The reducer returned a null value");
                    this.accumulator = rApply;
                } catch (Throwable th) {
                    onError(Operators.onOperatorError(this.f39687s, th, t10, this.actual.currentContext()));
                }
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(!this.done && this.accumulator == null);
            }
            return super.scanUnsafe(attr);
        }
    }

    public ParallelReduceSeed(ParallelFlux<? extends T> parallelFlux, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.source = ParallelFlux.from((ParallelFlux) parallelFlux);
        this.initialSupplier = supplier;
        this.reducer = biFunction;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public int parallelism() {
        return this.source.parallelism();
    }

    public void reportError(qc.c<?>[] cVarArr, Throwable th) {
        for (qc.c<?> cVar : cVarArr) {
            Operators.error(cVar, th);
        }
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.ParallelFlux
    public void subscribe(CoreSubscriber<? super R>[] coreSubscriberArr) {
        if (validate(coreSubscriberArr)) {
            int length = coreSubscriberArr.length;
            CoreSubscriber<? super Object>[] coreSubscriberArr2 = new CoreSubscriber[length];
            for (int i10 = 0; i10 < length; i10++) {
                try {
                    R r10 = this.initialSupplier.get();
                    Objects.requireNonNull(r10, "The initialSupplier returned a null value");
                    coreSubscriberArr2[i10] = new ParallelReduceSeedSubscriber(coreSubscriberArr[i10], r10, this.reducer);
                } catch (Throwable th) {
                    reportError(coreSubscriberArr, Operators.onOperatorError(th, coreSubscriberArr[i10].currentContext()));
                    return;
                }
            }
            this.source.subscribe(coreSubscriberArr2);
        }
    }
}
