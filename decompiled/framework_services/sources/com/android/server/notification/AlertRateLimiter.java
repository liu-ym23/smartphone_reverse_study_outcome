package com.android.server.notification;

/* JADX INFO: loaded from: classes2.dex */
public class AlertRateLimiter {
    static final long ALLOWED_ALERT_INTERVAL = 1000;
    private long mLastNotificationMillis;

    public AlertRateLimiter() {
        this.mLastNotificationMillis = 0;
    }

    boolean shouldRateLimitAlert(long now) {
        long millisSinceLast = now - this.mLastNotificationMillis;
        if (millisSinceLast >= 0) goto L5;
        return true;
    L5:
        if (millisSinceLast < 1000) goto L11;
        this.mLastNotificationMillis = now;
        return false;
    L11:
        return true;
    }
}
