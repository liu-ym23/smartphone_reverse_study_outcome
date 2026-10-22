package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.work.RunnableScheduler;

/* JADX INFO: loaded from: classes.dex */
public class d implements RunnableScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f5554a;

    public d() {
        this.f5554a = androidx.core.os.d.a(Looper.getMainLooper());
    }

    @Override // androidx.work.RunnableScheduler
    public void cancel(Runnable r10) {
        this.f5554a.removeCallbacks(r10);
    }

    @Override // androidx.work.RunnableScheduler
    public void scheduleWithDelay(long r10, Runnable r11) {
        this.f5554a.postDelayed(r11, r10);
    }
}
