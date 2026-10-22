package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxRetry;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoRetry<T> extends InternalMonoOperator<T, T> {
    final long times;

    public MonoRetry(Mono<? extends T> mono, long j10) {
        super(mono);
        if (j10 >= 0) {
            this.times = j10;
        } else {
            g5.f.s("times >= 0 required");
            throw null;
        }
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        FluxRetry.RetrySubscriber retrySubscriber = new FluxRetry.RetrySubscriber(this.source, coreSubscriber, this.times);
        coreSubscriber.onSubscribe(retrySubscriber);
        if (retrySubscriber.isCancelled()) {
            return null;
        }
        retrySubscriber.resubscribe();
        return null;
    }
}
