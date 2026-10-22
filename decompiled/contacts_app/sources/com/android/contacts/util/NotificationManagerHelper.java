package com.android.contacts.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationManagerHelper {
    private static final long ALLOWED_UPDATE_INTERVAL = 1000;
    private long mLastNotificationMillis;

    public NotificationManagerHelper() {
        this.mLastNotificationMillis = 0;
    }

    public boolean shouldNotifyNotificationLimit() {
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.mLastNotificationMillis) >= 1000) goto L6;
        return false;
    L6:
        this.mLastNotificationMillis = r0;
        return true;
    }
}
