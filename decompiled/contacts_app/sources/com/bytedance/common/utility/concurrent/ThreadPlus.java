package com.bytedance.common.utility.concurrent;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadPlus implements Runnable {
    protected static final AtomicInteger S_COUNT = null;
    private static ExecutorService mCachedExecutor;
    private static ExecutorService mFixedExecutor;
    private final boolean mBackground;
    private Runnable runnable;

    public static void shutdown() {
    }

    static {
        mCachedExecutor = TTExecutors.getNormalExecutor();
        mFixedExecutor = TTExecutors.getNormalExecutor();
        S_COUNT = new AtomicInteger();
    }

    public ThreadPlus(Runnable r1, String r2, boolean r3) {
        this.runnable = r1;
        this.mBackground = r3;
    }

    public ThreadPlus(String r1) {
        this(false);
    }

    public ThreadPlus() {
        this(false);
    }

    public ThreadPlus(boolean r1) {
        this.mBackground = r1;
    }

    public static void setExecutorService(ExecutorService r0) {
        mCachedExecutor = r0;
        mFixedExecutor = r0;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable r0 = this.runnable;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    public void start() {
        if (Logger.debug() == false) goto L5;
        Runnable r0 = new AnonymousClass1(this);
    L7:
        if (this.mBackground == false) goto L9;
        mFixedExecutor.submit(r0);
        return;
    L9:
        mCachedExecutor.submit(r0);
        return;
    L5:
        r0 = this;
        goto L7
    }

    public static void submitRunnable(Runnable r1) {
        if (r1 == null) goto L5;
        mCachedExecutor.submit(r1);
        return;
    }
}
