package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.function.BiConsumer;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
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
        boolean zShouldRestoreThreadLocalsInSomeOperators = ContextPropagationSupport.shouldRestoreThreadLocalsInSomeOperators();
        BiConsumer<? super T, SynchronousSink<R>> biConsumerContextRestoreForHandle = this.handler;
        if (zShouldRestoreThreadLocalsInSomeOperators) {
            coreSubscriber.getClass();
            y yVar = new y(1);
            yVar.f10881f = coreSubscriber;
            VarHandle.storeStoreFence();
            biConsumerContextRestoreForHandle = ContextPropagation.contextRestoreForHandle(biConsumerContextRestoreForHandle, yVar);
        }
        return new FluxHandle.HandleSubscriber(coreSubscriber, biConsumerContextRestoreForHandle);
    }
}
