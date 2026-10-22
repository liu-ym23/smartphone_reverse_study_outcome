package reactor.core.scheduler;

import java.lang.invoke.VarHandle;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Predicate;
import reactor.blockhound.BlockHound;
import reactor.blockhound.integration.BlockHoundIntegration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class ReactorBlockHoundIntegration implements BlockHoundIntegration {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Predicate lambda$applyTo$0(Predicate predicate) {
        a aVar = new a(1);
        VarHandle.storeStoreFence();
        return predicate.or(aVar);
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
