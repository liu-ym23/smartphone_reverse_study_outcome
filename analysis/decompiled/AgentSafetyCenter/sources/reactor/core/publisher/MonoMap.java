package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
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
        boolean z10 = coreSubscriber instanceof Fuseable.ConditionalSubscriber;
        Function<? super T, ? extends R> function = this.mapper;
        return z10 ? new FluxMap.MapConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, function) : new FluxMap.MapSubscriber(coreSubscriber, function);
    }
}
