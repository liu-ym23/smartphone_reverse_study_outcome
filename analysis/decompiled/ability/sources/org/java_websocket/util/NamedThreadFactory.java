package org.java_websocket.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final boolean daemon;
    private final ThreadFactory defaultThreadFactory;
    private final AtomicInteger threadNumber;
    private final String threadPrefix;

    public NamedThreadFactory(String str) {
        this.defaultThreadFactory = Executors.defaultThreadFactory();
        this.threadNumber = new AtomicInteger(1);
        this.threadPrefix = str;
        this.daemon = false;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.defaultThreadFactory.newThread(runnable);
        threadNewThread.setDaemon(this.daemon);
        threadNewThread.setName(this.threadPrefix + "-" + this.threadNumber);
        return threadNewThread;
    }

    public NamedThreadFactory(String str, boolean z10) {
        this.defaultThreadFactory = Executors.defaultThreadFactory();
        this.threadNumber = new AtomicInteger(1);
        this.threadPrefix = str;
        this.daemon = z10;
    }
}
