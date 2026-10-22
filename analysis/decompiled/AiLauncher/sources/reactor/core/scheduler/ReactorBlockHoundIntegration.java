package reactor.core.scheduler;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import java.util.function.Predicate;
import reactor.blockhound.BlockHound;
import reactor.blockhound.integration.BlockHoundIntegration;

/* loaded from: classes5.dex */
public final class ReactorBlockHoundIntegration implements BlockHoundIntegration {
    public static /* synthetic */ Predicate a(Predicate predicate) {
        final Class<NonBlocking> cls = NonBlocking.class;
        return predicate.or(new Predicate() { // from class: reactor.core.scheduler.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance((Thread) obj);
            }
        });
    }

    public void applyTo(BlockHound.Builder builder) {
        builder.nonBlockingThreadPredicate(new Function() { // from class: reactor.core.scheduler.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ReactorBlockHoundIntegration.a((Predicate) obj);
            }
        });
        builder.allowBlockingCallsInside(ScheduledThreadPoolExecutor.class.getName() + "$DelayedWorkQueue", "offer");
        builder.allowBlockingCallsInside(ScheduledThreadPoolExecutor.class.getName() + "$DelayedWorkQueue", "take");
        builder.allowBlockingCallsInside(BoundedElasticScheduler.class.getName() + "$BoundedScheduledExecutorService", "ensureQueueCapacity");
        builder.allowBlockingCallsInside(SchedulerTask.class.getName(), "dispose");
        builder.allowBlockingCallsInside(WorkerTask.class.getName(), "dispose");
        builder.allowBlockingCallsInside(ThreadPoolExecutor.class.getName(), "processWorkerExit");
        builder.allowBlockingCallsInside("reactor.core.publisher.ContextPropagation", "<clinit>");
        builder.allowBlockingCallsInside(FutureTask.class.getName(), "handlePossibleCancellationInterrupt");
    }
}
