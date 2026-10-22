package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxRetry<T> extends InternalFluxOperator<T, T> {
    final long times;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RetrySubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        static final AtomicIntegerFieldUpdater<RetrySubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(RetrySubscriber.class, "wip");
        long produced;
        long remaining;
        final CorePublisher<? extends T> source;
        volatile int wip;

        public RetrySubscriber(CorePublisher<? extends T> corePublisher, CoreSubscriber<? super T> coreSubscriber, long j10) {
            super(coreSubscriber);
            this.source = corePublisher;
            this.remaining = j10;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            long j10 = this.remaining;
            if (j10 != Long.MAX_VALUE) {
                if (j10 == 0) {
                    this.actual.onError(th);
                    return;
                }
                this.remaining = j10 - 1;
            }
            resubscribe();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
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
                    CorePublisher<? extends T> corePublisher = this.source;
                    corePublisher.subscribe(Operators.restoreContextOnSubscriberIfPublisherNonInternal(corePublisher, this));
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

    public FluxRetry(Flux<? extends T> flux, long j10) {
        super(flux);
        if (j10 >= 0) {
            this.times = j10;
        } else {
            g5.f.s(k0.a.m("times >= 0 required but it was ", j10));
            throw null;
        }
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        RetrySubscriber retrySubscriber = new RetrySubscriber(this.source, coreSubscriber, this.times);
        coreSubscriber.onSubscribe(retrySubscriber);
        if (retrySubscriber.isCancelled()) {
            return null;
        }
        retrySubscriber.resubscribe();
        return null;
    }
}
