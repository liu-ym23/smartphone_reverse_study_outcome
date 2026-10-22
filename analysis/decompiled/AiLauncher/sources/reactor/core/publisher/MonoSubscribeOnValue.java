package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxSubscribeOnValue;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoSubscribeOnValue<T> extends Mono<T> implements Scannable {
    final Scheduler scheduler;
    final T value;

    public MonoSubscribeOnValue(@Nullable T t10, Scheduler scheduler) {
        this.value = t10;
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
        T t10 = this.value;
        if (t10 != null) {
            coreSubscriber.onSubscribe(new FluxSubscribeOnValue.ScheduledScalar(coreSubscriber, t10, this.scheduler));
            return;
        }
        FluxSubscribeOnValue.ScheduledEmpty scheduledEmpty = new FluxSubscribeOnValue.ScheduledEmpty(coreSubscriber);
        coreSubscriber.onSubscribe(scheduledEmpty);
        try {
            scheduledEmpty.setFuture(this.scheduler.schedule(scheduledEmpty));
        } catch (RejectedExecutionException e10) {
            if (scheduledEmpty.future != OperatorDisposables.DISPOSED) {
                coreSubscriber.onError(Operators.onRejectedExecution(e10, coreSubscriber.currentContext()));
            }
        }
    }
}
