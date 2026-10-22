package reactor.core.publisher;

import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxRepeat;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoRepeat<T> extends FluxFromMonoOperator<T, T> {
    final long times;

    public MonoRepeat(Mono<? extends T> mono, long j10) {
        super(mono);
        if (j10 > 0) {
            this.times = j10;
        } else {
            g5.f.s("times > 0 required");
            throw null;
        }
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        FluxRepeat.RepeatSubscriber repeatSubscriber = new FluxRepeat.RepeatSubscriber(this.source, coreSubscriber, this.times + 1);
        coreSubscriber.onSubscribe(repeatSubscriber);
        if (repeatSubscriber.isCancelled()) {
            return null;
        }
        repeatSubscriber.onComplete();
        return null;
    }
}
