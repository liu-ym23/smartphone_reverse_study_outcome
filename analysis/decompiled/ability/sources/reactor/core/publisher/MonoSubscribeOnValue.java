package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.publisher.FluxSubscribeOnValue;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoSubscribeOnValue<T> extends Mono<T> implements Scannable {
    final Scheduler scheduler;
    final T value;

    public MonoSubscribeOnValue(@Nullable T t9, Scheduler scheduler) {
        this.value = t9;
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
        T t9 = this.value;
        if (t9 != null) {
            coreSubscriber.onSubscribe(new FluxSubscribeOnValue.ScheduledScalar(coreSubscriber, t9, this.scheduler));
            return;
        }
        FluxSubscribeOnValue.ScheduledEmpty scheduledEmpty = new FluxSubscribeOnValue.ScheduledEmpty(coreSubscriber);
        coreSubscriber.onSubscribe(scheduledEmpty);
        try {
            scheduledEmpty.setFuture(this.scheduler.schedule(scheduledEmpty));
        } catch (RejectedExecutionException e) {
            if (scheduledEmpty.future != OperatorDisposables.DISPOSED) {
                coreSubscriber.onError(Operators.onRejectedExecution(e, coreSubscriber.currentContext()));
            }
        }
    }
}
