package reactor.core.scheduler;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Predicate;
import reactor.blockhound.BlockHound;
import reactor.blockhound.integration.BlockHoundIntegration;

/* loaded from: classes4.dex */
public final class ReactorBlockHoundIntegration implements BlockHoundIntegration {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Predicate lambda$applyTo$0(Predicate predicate) {
        return predicate.or(new a(1));
    }

    public void applyTo(BlockHound.Builder builder) {
        builder.nonBlockingThreadPredicate(new g(3));
        builder.allowBlockingCallsInside(ScheduledThreadPoolExecutor.class.getName().concat("$DelayedWorkQueue"), "offer");
        builder.allowBlockingCallsInside(ScheduledThreadPoolExecutor.class.getName().concat("$DelayedWorkQueue"), "take");
        builder.allowBlockingCallsInside(BoundedElasticScheduler.class.getName().concat("$BoundedScheduledExecutorService"), "ensureQueueCapacity");
        builder.allowBlockingCallsInside(SchedulerTask.class.getName(), "dispose");
        builder.allowBlockingCallsInside(WorkerTask.class.getName(), "dispose");
        builder.allowBlockingCallsInside(ThreadPoolExecutor.class.getName(), "processWorkerExit");
        builder.allowBlockingCallsInside("reactor.core.publisher.ContextPropagation", "<clinit>");
        builder.allowBlockingCallsInside(FutureTask.class.getName(), "handlePossibleCancellationInterrupt");
    }
}
