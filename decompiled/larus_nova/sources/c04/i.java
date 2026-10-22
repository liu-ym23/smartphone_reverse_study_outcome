package c04;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f21927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f21928b;

    public static void b() {
        ExecutorService r100 = f21927a;
        if (r100 != null) goto L5;
    L8:
        f21927a = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        f21928b = new Handler(Looper.getMainLooper());
        return;
    L5:
        if (r100.isTerminated() == true) goto L8;
        if (f21928b == null) goto L8;
    }

    public static void a(Runnable r100) {
        b();
        f21928b.removeCallbacks(r100);
    }
}
