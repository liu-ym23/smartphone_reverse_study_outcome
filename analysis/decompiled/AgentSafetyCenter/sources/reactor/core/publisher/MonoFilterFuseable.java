package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Predicate;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxFilterFuseable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
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
        boolean z10 = coreSubscriber instanceof Fuseable.ConditionalSubscriber;
        Predicate<? super T> predicate = this.predicate;
        return z10 ? new FluxFilterFuseable.FilterFuseableConditionalSubscriber((Fuseable.ConditionalSubscriber) coreSubscriber, predicate) : new FluxFilterFuseable.FilterFuseableSubscriber(coreSubscriber, predicate);
    }
}
