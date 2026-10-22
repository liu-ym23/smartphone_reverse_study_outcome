package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxSwitchIfEmpty;

/* loaded from: classes4.dex */
final class MonoSwitchIfEmpty<T> extends InternalMonoOperator<T, T> {
    final Mono<? extends T> other;

    public MonoSwitchIfEmpty(Mono<? extends T> mono, Mono<? extends T> mono2) {
        super(mono);
        Objects.requireNonNull(mono2, "other");
        this.other = Mono.fromDirect(mono2);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        FluxSwitchIfEmpty.SwitchIfEmptySubscriber switchIfEmptySubscriber = new FluxSwitchIfEmpty.SwitchIfEmptySubscriber(coreSubscriber, this.other);
        coreSubscriber.onSubscribe(switchIfEmptySubscriber);
        return switchIfEmptySubscriber;
    }
}
