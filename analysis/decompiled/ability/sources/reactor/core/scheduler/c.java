package reactor.core.scheduler;

import reactor.core.scheduler.BoundedElasticScheduler;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5944a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f5944a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f5944a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((BoundedElasticScheduler.BoundedServices) obj).eviction();
                break;
            default:
                ((Scheduler) obj).dispose();
                break;
        }
    }
}
