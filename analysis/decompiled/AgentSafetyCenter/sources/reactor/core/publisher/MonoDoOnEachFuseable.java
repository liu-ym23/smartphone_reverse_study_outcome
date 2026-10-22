package reactor.core.publisher;

import java.util.Objects;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoDoOnEachFuseable<T> extends InternalMonoOperator<T, T> implements Fuseable {
    final Consumer<? super Signal<T>> onSignal;

    public MonoDoOnEachFuseable(Mono<? extends T> mono, Consumer<? super Signal<T>> consumer) {
        super(mono);
        Objects.requireNonNull(consumer, "onSignal");
        this.onSignal = consumer;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return FluxDoOnEach.createSubscriber(coreSubscriber, this.onSignal, true, true);
    }
}
