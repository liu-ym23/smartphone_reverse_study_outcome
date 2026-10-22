package com.android.server.location.contexthub;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AuthStateDenialTimer {
    private static final int MSG = 1;
    private static final long TIMEOUT_MS = 0;
    private boolean mCancelled;
    private final ContextHubClientBroker mClient;
    private final Handler mHandler;
    private final long mNanoAppId;
    private long mStopTimeInFuture;

    private class CountDownHandler extends Handler {
        final /* synthetic */ AuthStateDenialTimer this$0;

        CountDownHandler(AuthStateDenialTimer r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            AuthStateDenialTimer r0 = this.this$0;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (AuthStateDenialTimer.m5154$$Nest$fgetmCancelled(this.this$0) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            long millisLeft = AuthStateDenialTimer.m5155$$Nest$fgetmStopTimeInFuture(this.this$0) - SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
            if (millisLeft > 0) goto L13;
            this.this$0.onFinish();     // Catch: Throwable -> L8
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L13:
            sendMessageDelayed(obtainMessage(1), millisLeft);     // Catch: Throwable -> L8
            goto L14
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCancelled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5154$$Nest$fgetmCancelled(AuthStateDenialTimer r0) {
        return r0.mCancelled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStopTimeInFuture, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5155$$Nest$fgetmStopTimeInFuture(AuthStateDenialTimer r2) {
        return r2.mStopTimeInFuture;
    }

    static {
        TIMEOUT_MS = TimeUnit.SECONDS.toMillis(60);
    }

    public AuthStateDenialTimer(ContextHubClientBroker client, long nanoAppId, Looper looper) {
        this.mCancelled = false;
        this.mClient = client;
        this.mNanoAppId = nanoAppId;
        this.mHandler = new CountDownHandler(this, looper);
    }

    public synchronized void cancel() {
        monitor-enter(this);
        this.mCancelled = true;     // Catch: Throwable -> L7
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void start() {
        monitor-enter(this);
        this.mCancelled = false;     // Catch: Throwable -> L7
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + TIMEOUT_MS;     // Catch: Throwable -> L7
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onFinish() {
        this.mClient.handleAuthStateTimerExpiry(this.mNanoAppId);
    }
}
