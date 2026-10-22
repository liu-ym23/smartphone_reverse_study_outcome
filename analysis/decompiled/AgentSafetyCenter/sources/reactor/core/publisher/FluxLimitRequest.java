package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxLimitRequest<T> extends InternalFluxOperator<T, T> {
    final long cap;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class FluxLimitRequestSubscriber<T> implements InnerOperator<T, T> {
        static final AtomicLongFieldUpdater<FluxLimitRequestSubscriber> REQUEST_REMAINING = AtomicLongFieldUpdater.newUpdater(FluxLimitRequestSubscriber.class, "requestRemaining");
        final CoreSubscriber<? super T> actual;
        boolean done;
        qd.e parent;
        volatile long requestRemaining;
        long toProduce;

        public FluxLimitRequestSubscriber(CoreSubscriber<? super T> coreSubscriber, long j10) {
            this.actual = coreSubscriber;
            this.toProduce = j10;
            this.requestRemaining = j10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.parent.cancel();
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
                Operators.onErrorDropped(th, currentContext());
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
            long j10 = this.toProduce;
            if (j10 > 0) {
                long j11 = j10 - 1;
                this.toProduce = j11;
                this.actual.onNext(t10);
                if (j11 == 0) {
                    this.done = true;
                    this.parent.cancel();
                    this.actual.onComplete();
                }
            }
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.parent, eVar)) {
                this.parent = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            long j11;
            FluxLimitRequestSubscriber<T> fluxLimitRequestSubscriber;
            while (true) {
                long j12 = this.requestRemaining;
                j11 = j12 <= j10 ? j12 : j10;
                fluxLimitRequestSubscriber = this;
                if (REQUEST_REMAINING.compareAndSet(fluxLimitRequestSubscriber, j12, j12 - j11)) {
                    break;
                } else {
                    this = fluxLimitRequestSubscriber;
                }
            }
            if (j11 != 0) {
                fluxLimitRequestSubscriber.parent.request(j11);
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.parent : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxLimitRequest(Flux<T> flux, long j10) {
        super(flux);
        if (j10 >= 0) {
            this.cap = j10;
        } else {
            g5.f.s(k0.a.m("cap >= 0 required but it was ", j10));
            throw null;
        }
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
