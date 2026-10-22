package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.retry.Retry;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoRetryWhen<T> extends InternalMonoOperator<T, T> {
    final Retry whenSourceFactory;

    public MonoRetryWhen(Mono<? extends T> mono, Retry retry) {
        super(Mono.fromDirect(mono));
        Objects.requireNonNull(retry, "whenSourceFactory");
        this.whenSourceFactory = retry;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        FluxRetryWhen.subscribe(coreSubscriber, this.whenSourceFactory, this.source);
        return null;
    }
}
