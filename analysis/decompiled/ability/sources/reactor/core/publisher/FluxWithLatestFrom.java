package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxWithLatestFrom<T, U, R> extends InternalFluxOperator<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Z9.c other;

    public static final class WithLatestFromOtherSubscriber<U> implements InnerConsumer<U> {
        final WithLatestFromSubscriber<?, U, ?> main;

        public WithLatestFromOtherSubscriber(WithLatestFromSubscriber<?, U, ?> withLatestFromSubscriber) {
            this.main = withLatestFromSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.main.otherComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            this.main.otherError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(U u) {
            this.main.otherValue = u;
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            this.main.setOther(eVar);
            eVar.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.ACTUAL) {
                return this.main;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public static final class WithLatestFromSubscriber<T, U, R> implements InnerOperator<T, R> {
        static final AtomicReferenceFieldUpdater<WithLatestFromSubscriber, Z9.e> MAIN = AtomicReferenceFieldUpdater.newUpdater(WithLatestFromSubscriber.class, Z9.e.class, "main");
        static final AtomicReferenceFieldUpdater<WithLatestFromSubscriber, Z9.e> OTHER = AtomicReferenceFieldUpdater.newUpdater(WithLatestFromSubscriber.class, Z9.e.class, "other");
        final CoreSubscriber<? super R> actual;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        volatile Z9.e main;
        volatile Z9.e other;
        volatile U otherValue;

        public WithLatestFromSubscriber(CoreSubscriber<? super R> coreSubscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.actual = coreSubscriber;
            this.combiner = biFunction;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super R> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            cancelMain();
            cancelOther();
        }

        public void cancelMain() {
            Z9.e andSet;
            if (this.main == Operators.cancelledSubscription() || (andSet = MAIN.getAndSet(this, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
                return;
            }
            andSet.cancel();
        }

        public void cancelOther() {
            Z9.e andSet;
            if (this.other == Operators.cancelledSubscription() || (andSet = OTHER.getAndSet(this, Operators.cancelledSubscription())) == null || andSet == Operators.cancelledSubscription()) {
                return;
            }
            andSet.cancel();
        }

        @Override // reactor.core.Scannable
        public Stream<? extends Scannable> inners() {
            return Stream.of(Scannable.from(this.other));
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            cancelOther();
            this.otherValue = null;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.main == null && MAIN.compareAndSet(this, null, Operators.cancelledSubscription())) {
                cancelOther();
                Operators.error(this.actual, th);
            } else {
                cancelOther();
                this.otherValue = null;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            U u = this.otherValue;
            if (u == null) {
                this.main.request(1L);
                return;
            }
            try {
                R rApply = this.combiner.apply(t9, u);
                Objects.requireNonNull(rApply, "The combiner returned a null value");
                this.actual.onNext(rApply);
            } catch (Throwable th) {
                onError(Operators.onOperatorError(this, th, t9, this.actual.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (MAIN.compareAndSet(this, null, eVar)) {
                this.actual.onSubscribe(this);
                return;
            }
            eVar.cancel();
            if (this.main != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }

        public void otherComplete() {
            if (this.otherValue == null) {
                if (this.main == null && MAIN.compareAndSet(this, null, Operators.cancelledSubscription())) {
                    cancelMain();
                    Operators.complete(this.actual);
                } else {
                    cancelMain();
                    this.actual.onComplete();
                }
            }
        }

        public void otherError(Throwable th) {
            if (this.main == null && MAIN.compareAndSet(this, null, Operators.cancelledSubscription())) {
                cancelMain();
                Operators.error(this.actual, th);
            } else {
                cancelMain();
                this.otherValue = null;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.main.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.main == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.PARENT ? this.main : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void setOther(Z9.e eVar) {
            if (OTHER.compareAndSet(this, null, eVar)) {
                return;
            }
            eVar.cancel();
            if (this.other != Operators.cancelledSubscription()) {
                Operators.reportSubscriptionSet();
            }
        }
    }

    public FluxWithLatestFrom(Flux<? extends T> flux, Z9.c cVar, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
        Objects.requireNonNull(biFunction, "combiner");
        this.combiner = biFunction;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(Operators.serialize(coreSubscriber), this.combiner);
        this.other.subscribe(new WithLatestFromOtherSubscriber(withLatestFromSubscriber));
        return withLatestFromSubscriber;
    }
}
