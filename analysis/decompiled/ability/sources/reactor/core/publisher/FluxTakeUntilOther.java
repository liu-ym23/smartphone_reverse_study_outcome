package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes4.dex */
final class FluxTakeUntilOther<T, U> extends InternalFluxOperator<T, T> {
    final Z9.c other;

    public static final class TakeUntilMainSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicReferenceFieldUpdater<TakeUntilMainSubscriber, Z9.e> MAIN = AtomicReferenceFieldUpdater.newUpdater(TakeUntilMainSubscriber.class, Z9.e.class, "main");
        static final AtomicReferenceFieldUpdater<TakeUntilMainSubscriber, Z9.e> OTHER = AtomicReferenceFieldUpdater.newUpdater(TakeUntilMainSubscriber.class, Z9.e.class, "other");
        final CoreSubscriber<? super T> actual;
        volatile Z9.e main;
        volatile Z9.e other;

        public TakeUntilMainSubscriber(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = Operators.serialize(coreSubscriber);
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Z9.e andSet;
            if (this.main != Operators.cancelledSubscription() && (andSet = MAIN.getAndSet(this, Operators.cancelledSubscription())) != null && andSet != Operators.cancelledSubscription()) {
                andSet.cancel();
            }
            cancelOther();
        }

        public void cancelMainAndComplete() {
            if (this.main != Operators.cancelledSubscription()) {
                Z9.e andSet = MAIN.getAndSet(this, Operators.cancelledSubscription());
                if (andSet != null && andSet != Operators.cancelledSubscription()) {
                    andSet.cancel();
                }
                if (andSet == null) {
                    Operators.complete(this.actual);
                } else {
                    this.actual.onComplete();
                }
            }
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
            if (this.main == null && MAIN.compareAndSet(this, null, Operators.cancelledSubscription())) {
                Operators.complete(this.actual);
            } else {
                cancelOther();
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.main == null && MAIN.compareAndSet(this, null, Operators.cancelledSubscription())) {
                Operators.error(this.actual, th);
            } else {
                cancelOther();
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.main.request(j5);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.main;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.main == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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

    public static final class TakeUntilOtherSubscriber<U> implements InnerConsumer<U> {
        final TakeUntilMainSubscriber<?> main;
        boolean once;

        public TakeUntilOtherSubscriber(TakeUntilMainSubscriber<?> takeUntilMainSubscriber) {
            this.main = takeUntilMainSubscriber;
        }

        @Override // reactor.core.CoreSubscriber
        public Context currentContext() {
            return this.main.currentContext();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.once) {
                return;
            }
            this.once = true;
            this.main.cancelMainAndComplete();
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.once) {
                return;
            }
            this.once = true;
            this.main.onError(th);
        }

        @Override // reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(U u) {
            if (this.once) {
                return;
            }
            this.once = true;
            this.main.cancelOther();
            this.main.cancelMainAndComplete();
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            this.main.setOther(eVar);
            eVar.request(Long.MAX_VALUE);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.main.other == Operators.cancelledSubscription());
            }
            if (attr == Scannable.Attr.PARENT) {
                return this.main.other;
            }
            if (attr == Scannable.Attr.ACTUAL) {
                return this.main;
            }
            if (attr == Scannable.Attr.RUN_STYLE) {
                return Scannable.Attr.RunStyle.SYNC;
            }
            return null;
        }
    }

    public FluxTakeUntilOther(Flux<? extends T> flux, Z9.c cVar) {
        super(flux);
        Objects.requireNonNull(cVar, "other");
        this.other = Operators.toFluxOrMono(cVar);
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return Integer.MAX_VALUE;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(coreSubscriber);
        this.other.subscribe(new TakeUntilOtherSubscriber(takeUntilMainSubscriber));
        return takeUntilMainSubscriber;
    }
}
