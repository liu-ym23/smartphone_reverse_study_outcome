package reactor.core.scheduler;

import java.util.concurrent.ThreadFactory;
import reactor.core.scheduler.BoundedElasticScheduler;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return BoundedElasticScheduler.BoundedServices.lambda$static$0(runnable);
    }
}
