package com.stepos.probe;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2727a;

    public /* synthetic */ b(int i2) {
        this.f2727a = i2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f2727a) {
            case 0:
                return ProbeStore.io$lambda$0(runnable);
            case 1:
                Thread thread = new Thread(runnable, "agentbus-fastpath");
                thread.setDaemon(true);
                return thread;
            case 2:
                Thread thread2 = new Thread(runnable, "agentbus-metrics");
                thread2.setDaemon(true);
                thread2.setPriority(1);
                return thread2;
            case 3:
                return new Thread(runnable, "ResponseTask");
            default:
                Thread thread3 = new Thread(runnable, "securedata-init");
                thread3.setDaemon(true);
                return thread3;
        }
    }
}
