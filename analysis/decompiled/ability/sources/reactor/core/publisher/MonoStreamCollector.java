package reactor.core.publisher;

import java.util.Collection;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class MonoStreamCollector<T, A, R> extends MonoFromFluxOperator<T, R> implements Fuseable {
    final Collector<? super T, A, ? extends R> collector;

    public static final class StreamCollectorSubscriber<T, A, R> extends Operators.BaseFluxToMonoOperator<T, R> {
        final BiConsumer<? super A, ? super T> accumulator;
        A container;
        boolean done;
        final Function<? super A, ? extends R> finisher;

        public StreamCollectorSubscriber(CoreSubscriber<? super R> coreSubscriber, A a3, BiConsumer<? super A, ? super T> biConsumer, Function<? super A, ? extends R> function) {
            super(coreSubscriber);
            this.container = a3;
            this.accumulator = biConsumer;
            this.finisher = function;
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator
        public R accumulatedValue() {
            A a3;
            synchronized (this) {
                a3 = this.container;
                this.container = null;
            }
            if (a3 == null) {
                return null;
            }
            try {
                R rApply = this.finisher.apply(a3);
                if (rApply == null) {
                    this.actual.onError(Operators.onOperatorError(new NullPointerException("Collector returned null"), this.actual.currentContext()));
                }
                return rApply;
            } catch (Throwable th) {
                discardIntermediateContainer(a3);
                CoreSubscriber<? super O> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
                return null;
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            A a3;
            super.cancel();
            synchronized (this) {
                a3 = this.container;
                this.container = null;
            }
            if (a3 != null) {
                discardIntermediateContainer(a3);
            }
        }

        public void discardIntermediateContainer(A a3) {
            Context contextCurrentContext = this.actual.currentContext();
            if (a3 instanceof Collection) {
                Operators.onDiscardMultiple((Collection<?>) a3, contextCurrentContext);
            } else {
                Operators.onDiscard(a3, contextCurrentContext);
            }
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
            A a3;
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
                return;
            }
            this.done = true;
            synchronized (this) {
                a3 = this.container;
                this.container = null;
            }
            if (a3 == null) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                discardIntermediateContainer(a3);
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            try {
                synchronized (this) {
                    try {
                        A a3 = this.container;
                        if (a3 != null) {
                            this.accumulator.accept(a3, t9);
                        } else {
                            Operators.onDiscard(t9, this.actual.currentContext());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Context contextCurrentContext = this.actual.currentContext();
                Operators.onDiscard(t9, contextCurrentContext);
                onError(Operators.onOperatorError(this.f5875s, th2, t9, contextCurrentContext));
            }
        }

        @Override // reactor.core.publisher.Operators.BaseFluxToMonoOperator, reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : super.scanUnsafe(attr);
        }
    }

    public MonoStreamCollector(Flux<? extends T> flux, Collector<? super T, A, ? extends R> collector) {
        super(flux);
        Objects.requireNonNull(collector, "collector");
        this.collector = collector;
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.MonoFromFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        return new StreamCollectorSubscriber(coreSubscriber, this.collector.supplier().get(), this.collector.accumulator(), this.collector.finisher());
    }
}
