package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Preconditions;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class Threads {
    private static final long TIMEOUT_RUN_ON_MAIN_MS = 30000;

    public static /* synthetic */ void a(Runnable r100, CountDownLatch r101) {
        lambda$runOnMainSync$0(r100, r101);
    }

    private static Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public static void checkBackgroundThread() {
        Preconditions.checkState(isBackgroundThread(), "In application's main thread");
    }

    public static void checkMainThread() {
        Preconditions.checkState(isMainThread(), "Not in application's main thread");
    }

    public static boolean isBackgroundThread() {
        return !isMainThread();
    }

    public static boolean isMainThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    private Threads() {
    }

    public static void runOnMain(Runnable r100) {
        if (isMainThread() == false) goto L6;
        r100.run();
        return;
    L6:
        Preconditions.checkState(getMainHandler().post(r100), "Unable to post to main thread");
    }

    public static void runOnMainSync(final Runnable r100) {
        if (isMainThread() == false) goto L6;
        r100.run();
        return;
    L6:
        final CountDownLatch r101 = new CountDownLatch(1);
        Preconditions.checkState(getMainHandler().post(new a(r100, r101)), "Unable to post to main thread");
    L12:
        e = move-exception;
        throw new InterruptedRuntimeException(e);
    L8:
        if (r101.await(30000, TimeUnit.MILLISECONDS) == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("Timeout to wait main thread execution");     // Catch: InterruptedException -> L12
    }

    private static /* synthetic */ void lambda$runOnMainSync$0(Runnable r100, CountDownLatch r101) {
        r100.run();     // Catch: Throwable -> L5
        r101.countDown();
        return;
    L5:
        th = move-exception;
        r101.countDown();
        throw th;
    }
}
