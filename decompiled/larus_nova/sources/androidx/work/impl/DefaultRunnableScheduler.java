package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultRunnableScheduler implements RunnableScheduler {
    private final Handler mHandler;

    public DefaultRunnableScheduler() {
        this.mHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public DefaultRunnableScheduler(Handler r100) {
        this.mHandler = r100;
    }

    @Override // androidx.work.RunnableScheduler
    public void cancel(Runnable r100) {
        this.mHandler.removeCallbacks(r100);
    }

    @Override // androidx.work.RunnableScheduler
    public void scheduleWithDelay(long r100, Runnable r101) {
        this.mHandler.postDelayed(r101, r100);
    }
}
