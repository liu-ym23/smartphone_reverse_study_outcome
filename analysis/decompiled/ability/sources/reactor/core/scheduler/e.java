package reactor.core.scheduler;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5945a;

    public /* synthetic */ e(int i) {
        this.f5945a = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5945a) {
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
