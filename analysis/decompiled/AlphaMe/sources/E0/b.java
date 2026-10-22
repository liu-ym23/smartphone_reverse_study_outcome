package E0;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l.ThreadFactoryC0745c;

/* loaded from: classes.dex */
public final class b implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f398a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f399b;

    public b() {
        this.f398a = 1;
        this.f399b = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, new ThreadFactoryC0745c(0), new com.stepos.statsapp.v3.lib.plugin.emitter.remote.a(1));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i4 = this.f398a;
        Object obj = this.f399b;
        switch (i4) {
            case 0:
                ((c) obj).f402c.post(runnable);
                break;
            default:
                ((ScheduledThreadPoolExecutor) obj).schedule(runnable, 0L, TimeUnit.NANOSECONDS);
                break;
        }
    }

    public b(c cVar) {
        this.f398a = 0;
        this.f399b = cVar;
    }
}
