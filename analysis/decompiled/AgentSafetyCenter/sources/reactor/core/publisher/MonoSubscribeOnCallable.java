package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxSubscribeOnCallable;
import reactor.core.scheduler.Scheduler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoSubscribeOnCallable<T> extends Mono<T> implements Fuseable, Scannable {
    final Callable<? extends T> callable;
    final Scheduler scheduler;

    public MonoSubscribeOnCallable(Callable<? extends T> callable, Scheduler scheduler) {
        Objects.requireNonNull(callable, "callable");
        this.callable = callable;
        Objects.requireNonNull(scheduler, "scheduler");
        this.scheduler = scheduler;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.RUN_ON) {
            return this.scheduler;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.ASYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Mono, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        FluxSubscribeOnCallable.CallableSubscribeOnSubscription callableSubscribeOnSubscription = new FluxSubscribeOnCallable.CallableSubscribeOnSubscription(coreSubscriber, this.callable, this.scheduler);
        coreSubscriber.onSubscribe(callableSubscribeOnSubscription);
        try {
            callableSubscribeOnSubscription.setMainFuture(this.scheduler.schedule(callableSubscribeOnSubscription));
        } catch (RejectedExecutionException e10) {
            if (callableSubscribeOnSubscription.state != 4) {
                coreSubscriber.onError(Operators.onRejectedExecution(e10, coreSubscriber.currentContext()));
            }
        }
    }
}
