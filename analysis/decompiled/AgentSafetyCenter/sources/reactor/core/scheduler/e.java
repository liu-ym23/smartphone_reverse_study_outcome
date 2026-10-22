package reactor.core.scheduler;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10895c;

    public /* synthetic */ e(int i) {
        this.f10895c = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f10895c) {
            case 0:
                return InstantPeriodicWorkerTask.lambda$static$0();
            case 1:
                return PeriodicSchedulerTask.lambda$static$0();
            case 2:
                return PeriodicWorkerTask.lambda$static$0();
            case 3:
                return SchedulerTask.lambda$static$0();
            case 4:
                return SchedulerTask.lambda$static$1();
            case 5:
                return WorkerTask.lambda$static$0();
            case 6:
                return WorkerTask.lambda$static$1();
            default:
                return WorkerTask.lambda$static$2();
        }
    }
}
