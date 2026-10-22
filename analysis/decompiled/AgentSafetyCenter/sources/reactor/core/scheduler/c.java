package reactor.core.scheduler;

import reactor.core.scheduler.BoundedElasticScheduler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10893c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10894f;

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f10893c;
        Object obj = this.f10894f;
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
