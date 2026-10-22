package com.bytedance.retrofit2.f;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: IHttpCallThrottleControl.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    void a(com.bytedance.retrofit2.b.c r1);

    boolean a(com.bytedance.retrofit2.b.c r1, Executor r2, Runnable r3);

    void b(com.bytedance.retrofit2.b.c r1);

    default com.bytedance.retrofit2.b.c c(com.bytedance.retrofit2.b.c r1) {
        return r1;
    }
}
