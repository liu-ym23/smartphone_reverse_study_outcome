package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxMap;

/* loaded from: classes5.dex */
final class MonoMap<T, R> extends InternalMonoOperator<T, R> {
    final Function<? super T, ? extends R> mapper;

    public MonoMap(Mono<? extends T> mono, Function<? super T, ? extends R> function) {
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
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FluxMap.MapConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.mapper) : new FluxMap.MapSubscriber(coreSubscriber, this.mapper);
    }
}
