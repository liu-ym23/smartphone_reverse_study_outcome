package reactor.core.publisher;

import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;

/* loaded from: classes4.dex */
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
