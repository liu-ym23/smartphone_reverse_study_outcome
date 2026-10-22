package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.Operators;

/* loaded from: classes4.dex */
final class FluxRetry<T> extends InternalFluxOperator<T, T> {
    final long times;

    public static final class RetrySubscriber<T> extends Operators.MultiSubscriptionSubscriber<T, T> {
        static final AtomicIntegerFieldUpdater<RetrySubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(RetrySubscriber.class, "wip");
        long produced;
        long remaining;
        final CorePublisher<? extends T> source;
        volatile int wip;

        public RetrySubscriber(CorePublisher<? extends T> corePublisher, CoreSubscriber<? super T> coreSubscriber, long j5) {
            super(coreSubscriber);
            this.source = corePublisher;
            this.remaining = j5;
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            long j5 = this.remaining;
            if (j5 != Long.MAX_VALUE) {
                if (j5 == 0) {
                    this.actual.onError(th);
                    return;
                }
                this.remaining = j5 - 1;
            }
            resubscribe();
        }

        @Override // reactor.core.publisher.Operators.MultiSubscriptionSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.produced++;
            this.actual.onNext(t9);
        }

        public void resubscribe() {
            if (WIP.getAndIncrement(this) == 0) {
                while (!isCancelled()) {
                    long j5 = this.produced;
                    if (j5 != 0) {
                        this.produced = 0L;
                        produced(j5);
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

    public FluxRetry(Flux<? extends T> flux, long j5) {
        super(flux);
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "times >= 0 required but it was "));
        }
        this.times = j5;
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
