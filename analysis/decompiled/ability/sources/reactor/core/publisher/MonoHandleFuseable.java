package reactor.core.publisher;

import java.util.Objects;
import java.util.function.BiConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxHandleFuseable;

/* loaded from: classes4.dex */
final class MonoHandleFuseable<T, R> extends InternalMonoOperator<T, R> implements Fuseable {
    final BiConsumer<? super T, SynchronousSink<R>> handler;

    public MonoHandleFuseable(Mono<? extends T> mono, BiConsumer<? super T, SynchronousSink<R>> biConsumer) {
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
            biConsumerContextRestoreForHandle = ContextPropagation.contextRestoreForHandle(biConsumer, new C1907x(coreSubscriber, 1));
        } else {
            biConsumerContextRestoreForHandle = this.handler;
        }
        return new FluxHandleFuseable.HandleFuseableSubscriber(coreSubscriber, biConsumerContextRestoreForHandle);
    }
}
