package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFilterFuseable;

/* loaded from: classes4.dex */
final class MonoFilterFuseable<T> extends InternalMonoOperator<T, T> implements Fuseable {
    final Predicate<? super T> predicate;

    public MonoFilterFuseable(Mono<? extends T> mono, Predicate<? super T> predicate) {
        super(mono);
        Objects.requireNonNull(predicate, "predicate");
        this.predicate = predicate;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return coreSubscriber instanceof Fuseable.ConditionalSubscriber ? new FluxFilterFuseable.FilterFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, this.predicate) : new FluxFilterFuseable.FilterFuseableSubscriber(coreSubscriber, this.predicate);
    }
}
