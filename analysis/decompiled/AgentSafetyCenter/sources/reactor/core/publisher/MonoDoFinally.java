package reactor.core.publisher;

import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoDoFinally<T> extends InternalMonoOperator<T, T> {
    final Consumer<SignalType> onFinally;

    public MonoDoFinally(Mono<? extends T> mono, Consumer<SignalType> consumer) {
        super(mono);
        this.onFinally = consumer;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return FluxDoFinally.createSubscriber(coreSubscriber, this.onFinally);
    }
}
