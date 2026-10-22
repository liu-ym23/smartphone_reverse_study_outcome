package com.bytedance.android.livesdk.widget.monitor;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f161865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f161866b;

    public m() {
        this.f161865a = new AtomicInteger(1);
        this.f161866b = "min-priority-thread-for-widget-log";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f161866b + this.f161865a.getAndIncrement());
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 1) goto L8;
        ThreadMethodProxy.setPriority(r101, 1);
    L8:
        return r101;
    }
}
