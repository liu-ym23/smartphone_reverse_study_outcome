package o6;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public final String f7770f = c.class.getSimpleName();

    /* renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f7771g = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new com.stepos.probe.b(3), new RejectedExecutionHandler() { // from class: o6.a
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.e(this.f7768a.f7770f, "Exceeded ThreadPoolExecutor error");
        }
    });

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f7771g.execute(runnable);
    }
}
