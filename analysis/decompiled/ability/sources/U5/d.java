package U5;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class d implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1276a;
    public final Object b;

    public d(int i) {
        this.f1276a = i;
        switch (i) {
            case 1:
                this.b = new Handler(Looper.getMainLooper());
                break;
            default:
                this.b = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, new E1.b(), new b(0));
                break;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1276a) {
            case 0:
                ((ScheduledThreadPoolExecutor) this.b).schedule(runnable, 0L, TimeUnit.NANOSECONDS);
                break;
            default:
                ((Handler) this.b).post(runnable);
                break;
        }
    }
}
