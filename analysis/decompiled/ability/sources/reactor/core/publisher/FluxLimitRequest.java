package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxLimitRequest<T> extends InternalFluxOperator<T, T> {
    final long cap;

    public static class FluxLimitRequestSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicLongFieldUpdater<FluxLimitRequestSubscriber> REQUEST_REMAINING = AtomicLongFieldUpdater.newUpdater(FluxLimitRequestSubscriber.class, "requestRemaining");
        final CoreSubscriber<? super T> actual;
        boolean done;
        Z9.e parent;
        volatile long requestRemaining;
        long toProduce;

        public FluxLimitRequestSubscriber(CoreSubscriber<? super T> coreSubscriber, long j5) {
            this.actual = coreSubscriber;
            this.toProduce = j5;
            this.requestRemaining = j5;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.parent.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.toProduce;
            if (j5 > 0) {
                long j6 = j5 - 1;
                this.toProduce = j6;
                this.actual.onNext(t9);
                if (j6 == 0) {
                    this.done = true;
                    this.parent.cancel();
                    this.actual.onComplete();
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.parent, eVar)) {
                this.parent = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            long j6;
            FluxLimitRequestSubscriber<T> fluxLimitRequestSubscriber;
            while (true) {
                long j10 = this.requestRemaining;
                j6 = j10 <= j5 ? j10 : j5;
                fluxLimitRequestSubscriber = this;
                if (REQUEST_REMAINING.compareAndSet(fluxLimitRequestSubscriber, j10, j10 - j6)) {
                    break;
                } else {
                    this = fluxLimitRequestSubscriber;
                }
            }
            if (j6 != 0) {
                fluxLimitRequestSubscriber.parent.request(j6);
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.parent : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxLimitRequest(Flux<T> flux, long j5) {
        super(flux);
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "cap >= 0 required but it was "));
        }
        this.cap = j5;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return 0;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.cap) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    @Nullable
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        if (this.cap != 0) {
            return new FluxLimitRequestSubscriber(coreSubscriber, this.cap);
        }
        Operators.complete(coreSubscriber);
        return null;
    }
}
