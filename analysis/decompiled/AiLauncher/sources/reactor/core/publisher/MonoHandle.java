package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxHandle;

/* loaded from: classes5.dex */
final class MonoHandle<T, R> extends InternalMonoOperator<T, R> {
    final BiConsumer<? super T, SynchronousSink<R>> handler;

    public MonoHandle(Mono<? extends T> mono, BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
        super(mono);
        Objects.requireNonNull(biConsumer, "handler");
        this.handler = biConsumer;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super R> coreSubscriber) {
        BiConsumer<? super T, SynchronousSink<R>> biConsumerContextRestoreForHandle;
        if (ContextPropagationSupport.shouldRestoreThreadLocalsInSomeOperators()) {
            BiConsumer<? super T, SynchronousSink<R>> biConsumer = this.handler;
            coreSubscriber.getClass();
            biConsumerContextRestoreForHandle = ContextPropagation.contextRestoreForHandle(biConsumer, new J0(coreSubscriber));
        } else {
            biConsumerContextRestoreForHandle = this.handler;
        }
        return new FluxHandle.HandleSubscriber(coreSubscriber, biConsumerContextRestoreForHandle);
    }
}
