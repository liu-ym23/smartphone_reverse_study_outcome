package com.bytedance.crash.anr;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.runtime.DefaultWorkThread;

/* JADX INFO: compiled from: AnrSignalMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    void b() {
    }

    public g() {
    }

    void a() {
        c();
        d();
    }

    private void c() {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this));
    }

    private void d() {
        DefaultWorkThread.post(new AnonymousClass2(this));
    }
}
