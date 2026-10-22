package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxRepeatPredicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoRepeatPredicate<T> extends FluxFromMonoOperator<T, T> {
    final BooleanSupplier predicate;

    public MonoRepeatPredicate(Mono<? extends T> mono, BooleanSupplier booleanSupplier) {
        super(mono);
        Objects.requireNonNull(booleanSupplier, "predicate");
        this.predicate = booleanSupplier;
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.FluxFromMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        FluxRepeatPredicate.RepeatPredicateSubscriber repeatPredicateSubscriber = new FluxRepeatPredicate.RepeatPredicateSubscriber(this.source, coreSubscriber, this.predicate);
        coreSubscriber.onSubscribe(repeatPredicateSubscriber);
        if (repeatPredicateSubscriber.isCancelled()) {
            return null;
        }
        repeatPredicateSubscriber.resubscribe();
        return null;
    }
}
