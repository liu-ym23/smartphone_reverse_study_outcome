package reactor.core.scheduler;

import java.util.concurrent.ThreadFactory;
import reactor.core.scheduler.BoundedElasticScheduler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return BoundedElasticScheduler.BoundedServices.lambda$static$0(runnable);
    }
}
