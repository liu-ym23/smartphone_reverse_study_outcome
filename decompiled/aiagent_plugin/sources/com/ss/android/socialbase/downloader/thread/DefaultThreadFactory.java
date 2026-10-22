package com.ss.android.socialbase.downloader.thread;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private final boolean ignoreStatusCheck;
    private final String threadName;
    private final AtomicInteger threadSeq;

    public DefaultThreadFactory(String r2) {
        this(r2, false);
    }

    public DefaultThreadFactory(String r2, boolean r3) {
        this.threadSeq = new AtomicInteger();
        this.threadName = r2;
        this.ignoreStatusCheck = r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        Thread r1 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"), this.threadName + "-" + this.threadSeq.incrementAndGet());
        if (this.ignoreStatusCheck == false) goto L5;
    L10:
        return r1;
    L5:
        if (r1.isDaemon() == false) goto L8;
        r1.setDaemon(false);
    L8:
        if (r1.getPriority() == 5) goto L10;
        r1.setPriority(5);
        goto L10
    }
}
