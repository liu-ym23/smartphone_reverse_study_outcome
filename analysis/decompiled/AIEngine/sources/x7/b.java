package x7;

import android.util.Log;
import com.stepos.aicgroup.d;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final String f13756a = b.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f13757b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d(9), new RejectedExecutionHandler() { // from class: x7.a
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.e(this.f13755a.f13756a, "Exceeded ThreadPoolExecutor error");
        }
    });

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f13758a = new b();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f13757b.execute(runnable);
    }
}
