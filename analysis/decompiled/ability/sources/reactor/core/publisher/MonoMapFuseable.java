package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxMapFuseable;

/* loaded from: classes4.dex */
final class MonoMapFuseable<T, R> extends InternalMonoOperator<T, R> implements Fuseable {
    final Function<? super T, ? extends R> mapper;

    public MonoMapFuseable(Mono<? extends T> mono, Function<? super T, ? extends R> function) {
        super(mono);
        Objects.requireNonNull(function, "mapper");
        this.mapper = function;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FluxMapFuseable.MapFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.mapper) : new FluxMapFuseable.MapFuseableSubscriber(coreSubscriber, this.mapper);
    }
}
