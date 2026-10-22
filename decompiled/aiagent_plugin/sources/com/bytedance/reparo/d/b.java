package com.bytedance.reparo.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SimpleThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f9347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadGroup f9348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f9349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9350d;

    static {
        f9347a = new AtomicInteger(1);
    }

    public b(String r3) {
        this.f9349c = new AtomicInteger(1);
        SecurityManager r0 = System.getSecurityManager();
        if (r0 == null) goto L5;
        ThreadGroup r1 = r0.getThreadGroup();
    L6:
        this.f9348b = r1;
        this.f9350d = r3 + "-" + f9347a.getAndIncrement() + '-';
        return;
    L5:
        r1 = Thread.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r7) {
        Thread r8 = new Thread(this.f9348b, (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin"), this.f9350d + this.f9349c.getAndIncrement(), 0);
        if (r8.isDaemon() == false) goto L6;
        r8.setDaemon(false);
    L6:
        if (r8.getPriority() == 5) goto L8;
        r8.setPriority(5);
    L8:
        return r8;
    }
}
