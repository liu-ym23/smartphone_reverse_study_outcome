package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.BooleanSupplier;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* loaded from: classes5.dex */
final class FluxRepeatPredicate<T> extends InternalFluxOperator<T, T> {
    final BooleanSupplier predicate;

    public static final class RepeatPredicateSubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        static final AtomicIntegerFieldUpdater<RepeatPredicateSubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(RepeatPredicateSubscriber.class, "wip");
        final BooleanSupplier predicate;
        long produced;
        final CorePublisher<? extends T> source;
        volatile int wip;

        public RepeatPredicateSubscriber(CorePublisher<? extends T> corePublisher, CoreSubscriber<? super T> coreSubscriber, BooleanSupplier booleanSupplier) {
            super(coreSubscriber);
            this.source = corePublisher;
            this.predicate = booleanSupplier;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            try {
                if (this.predicate.getAsBoolean()) {
                    resubscribe();
                } else {
                    this.actual.onComplete();
                }
            } catch (Throwable th) {
                CoreSubscriber<? super O> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onOperatorError(th, coreSubscriber.currentContext()));
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.produced++;
            this.actual.onNext(t10);
        }

        public void resubscribe() {
            if (WIP.getAndIncrement(this) == 0) {
                while (!isCancelled()) {
                    long j10 = this.produced;
                    if (j10 != 0) {
                        this.produced = 0L;
                        produced(j10);
                    }
                    this.source.subscribe((CoreSubscriber<? super Object>) this);
                    if (WIP.decrementAndGet(this) == 0) {
                        return;
                    }
                }
            }
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxRepeatPredicate(Flux<? extends T> flux, BooleanSupplier booleanSupplier) {
        super(flux);
        Objects.requireNonNull(booleanSupplier, "predicate");
        this.predicate = booleanSupplier;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        RepeatPredicateSubscriber repeatPredicateSubscriber = new RepeatPredicateSubscriber(this.source, coreSubscriber, this.predicate);
        coreSubscriber.onSubscribe(repeatPredicateSubscriber);
        if (repeatPredicateSubscriber.isCancelled()) {
            return null;
        }
        repeatPredicateSubscriber.resubscribe();
        return null;
    }
}
