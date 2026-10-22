package com.android.server.notification;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationIntrusivenessExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    static final long HANG_TIME_MS = 10000;
    private static final String TAG = "IntrusivenessExtractor";

    public NotificationIntrusivenessExtractor() {
    }

    static {
        DBG = Log.isLoggable(TAG, 3);
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context ctx, NotificationUsageStats usageStats) {
        if (DBG == false) goto L6;
        Slog.d(TAG, "Initializing  " + getClass().getSimpleName() + ".");
        return;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record == null) goto L28;
        if (record.getNotification() == null) goto L28;
        final long r3 = 10000;
        if (record.getFreshnessMs(System.currentTimeMillis()) >= 10000) goto L23;
        if (record.getImportance() < 3) goto L23;
        if (record.getSound() == null) goto L17;
        if (record.getSound() == Uri.EMPTY) goto L17;
        record.setRecentlyIntrusive(true);
    L17:
        if (record.getVibration() == null) goto L20;
        record.setRecentlyIntrusive(true);
    L20:
        if (record.getNotification().fullScreenIntent == null) goto L23;
        record.setRecentlyIntrusive(true);
    L23:
        if (record.isRecentlyIntrusive() == true) goto L25;
        return null;
    L25:
        final String r1 = record.getKey();
        return new AnonymousClass1(this, r1, r3);
    L28:
        if (DBG == false) goto L30;
        Slog.d(TAG, "skipping empty notification");
    L30:
        return null;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }
}
