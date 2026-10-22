package com.byted.cast.common.threadpool;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes39.dex */
public class CastThreadFactory implements ThreadFactory {
    private static final String DEFAULT_NAME = "ByteCast";
    private final ThreadGroup mGroup;
    private final String mNamePrefix;
    private final AtomicInteger mThreadNumber;

    public String getNamePrefix() {
        return this.mNamePrefix;
    }

    public CastThreadFactory(String r100) {
        this.mThreadNumber = new AtomicInteger(1);
        SecurityManager r101 = System.getSecurityManager();
        if (r101 == null) goto L5;
        ThreadGroup r102 = r101.getThreadGroup();
    L6:
        this.mGroup = r102;
        this.mNamePrefix = r100;
        return;
    L5:
        r102 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(this.mGroup, r100, "ByteCast#" + this.mNamePrefix + "#" + this.mThreadNumber.getAndIncrement(), 0);
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, 5);
    L8:
        return r101;
    }
}
