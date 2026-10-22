package com.bytedance.monitor.a.b;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: IAsyncTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public interface d extends com.bytedance.monitor.a.b.a.c {

    /* JADX INFO: compiled from: IAsyncTaskManager.java */
    public interface a {
        void a(Throwable r1, String r2);
    }

    long a(b r1);

    void a(a r1);

    void a(Throwable r1, String r2);

    void a(ExecutorService r1);

    ExecutorService b();

    f c();
}
