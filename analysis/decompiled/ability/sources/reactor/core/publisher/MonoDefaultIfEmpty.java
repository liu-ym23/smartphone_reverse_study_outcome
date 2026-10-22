package reactor.core.publisher;

import java.util.Objects;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxDefaultIfEmpty;

/* loaded from: classes4.dex */
final class MonoDefaultIfEmpty<T> extends InternalMonoOperator<T, T> {
    final T defaultValue;

    public MonoDefaultIfEmpty(Mono<? extends T> mono, T t9) {
        super(mono);
        Objects.requireNonNull(t9, "defaultValue");
        this.defaultValue = t9;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new FluxDefaultIfEmpty.DefaultIfEmptySubscriber(coreSubscriber, this.defaultValue);
    }
}
