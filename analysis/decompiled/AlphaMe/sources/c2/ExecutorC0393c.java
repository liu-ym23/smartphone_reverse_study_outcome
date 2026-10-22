package c2;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: c2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ExecutorC0393c implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final String f4468a = ExecutorC0393c.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f4469b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new com.stepos.alphame.dailyusage.a(7), new RejectedExecutionHandler() { // from class: c2.a
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.e(this.f4466a.f4468a, "Exceeded ThreadPoolExecutor error");
        }
    });

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f4469b.execute(runnable);
    }
}
