package com.android.server.pm.utils;

import android.os.Handler;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class RequestThrottle {
    private static final int DEFAULT_BACKOFF_BASE = 2;
    private static final int DEFAULT_DELAY_MS = 1000;
    private static final int DEFAULT_RETRY_MAX_ATTEMPTS = 5;
    private final int mBackoffBase;
    private final Supplier<Boolean> mBlock;
    private final AtomicInteger mCurrentRetry;
    private final int mFirstDelay;
    private final Handler mHandler;
    private final AtomicInteger mLastCommitted;
    private final AtomicInteger mLastRequest;
    private final int mMaxAttempts;
    private final Runnable mRunnable;

    /* JADX INFO: renamed from: $r8$lambda$8sCQU2PRg_lPz-WoznDN7pdkQmQ, reason: not valid java name */
    public static /* synthetic */ boolean m7117$r8$lambda$8sCQU2PRg_lPzWoznDN7pdkQmQ(RequestThrottle r0) {
        return r0.runInternal();
    }

    public RequestThrottle(Handler handler, Supplier<Boolean> block) {
        this(handler, 5, 1000, 2, block);
    }

    public RequestThrottle(Handler handler, int maxAttempts, int firstDelay, int backoffBase, Supplier<Boolean> block) {
        this.mLastRequest = new AtomicInteger(0);
        this.mLastCommitted = new AtomicInteger(-1);
        this.mCurrentRetry = new AtomicInteger(0);
        this.mHandler = handler;
        this.mBlock = block;
        this.mMaxAttempts = maxAttempts;
        this.mFirstDelay = firstDelay;
        this.mBackoffBase = backoffBase;
        this.mRunnable = new RequestThrottle$$ExternalSyntheticLambda0(this);
    }

    public void schedule() {
        this.mLastRequest.incrementAndGet();
        this.mHandler.post(this.mRunnable);
    }

    public boolean runNow() {
        this.mLastRequest.incrementAndGet();
        return runInternal();
    }

    private boolean runInternal() {
        int lastRequest = this.mLastRequest.get();
        int lastCommitted = this.mLastCommitted.get();
        if (lastRequest != lastCommitted) goto L6;
        return true;
    L6:
        if (this.mBlock.get().booleanValue() == false) goto L9;
        this.mCurrentRetry.set(0);
        this.mLastCommitted.set(lastRequest);
        return true;
    L9:
        int currentRetry = this.mCurrentRetry.getAndIncrement();
        if (currentRetry >= this.mMaxAttempts) goto L12;
        long nextDelay = (long) (((double) this.mFirstDelay) * Math.pow(this.mBackoffBase, currentRetry));
        this.mHandler.postDelayed(this.mRunnable, nextDelay);
    L13:
        return false;
    L12:
        this.mCurrentRetry.set(0);
        goto L13
    }
}
