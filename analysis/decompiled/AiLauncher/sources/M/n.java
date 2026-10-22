package M;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.impl.utils.InterruptedRuntimeException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n {
    public static /* synthetic */ void a(Runnable runnable, CountDownLatch countDownLatch) {
        try {
            runnable.run();
        } finally {
            countDownLatch.countDown();
        }
    }

    public static void b() {
        B0.h.i(d(), "Not in application's main thread");
    }

    public static Handler c() {
        return new Handler(Looper.getMainLooper());
    }

    public static boolean d() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void e(Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            B0.h.i(c().post(runnable), "Unable to post to main thread");
        }
    }

    public static void f(final Runnable runnable) {
        if (d()) {
            runnable.run();
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        B0.h.i(c().post(new Runnable() { // from class: M.m
            @Override // java.lang.Runnable
            public final void run() {
                n.a(runnable, countDownLatch);
            }
        }), "Unable to post to main thread");
        try {
            if (countDownLatch.await(30000L, TimeUnit.MILLISECONDS)) {
            } else {
                throw new IllegalStateException("Timeout to wait main thread execution");
            }
        } catch (InterruptedException e10) {
            throw new InterruptedRuntimeException(e10);
        }
    }
}
