package com.android.server.notification;

import android.content.Context;
import android.util.Log;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    private static final String TAG = "ZenModeExtractor";
    private ZenModeHelper mZenModeHelper;

    public ZenModeExtractor() {
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
        if (record == null) goto L19;
        if (record.getNotification() == null) goto L19;
        if (this.mZenModeHelper == null) goto L10;
        record.setIntercepted(this.mZenModeHelper.shouldIntercept(record));
        if (record.isIntercepted() == false) goto L16;
        record.setSuppressedVisualEffects(this.mZenModeHelper.getConsolidatedNotificationPolicy().suppressedVisualEffects);
    L17:
        return null;
    L16:
        record.setSuppressedVisualEffects(0);
        goto L17
    L10:
        if (DBG == false) goto L12;
        Slog.d(TAG, "skipping - no zen info available");
    L12:
        return null;
    L19:
        if (DBG == false) goto L21;
        Slog.d(TAG, "skipping empty notification");
    L21:
        return null;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
        this.mZenModeHelper = helper;
    }
}
