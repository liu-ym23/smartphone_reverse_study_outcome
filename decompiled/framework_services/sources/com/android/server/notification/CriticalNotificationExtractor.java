package com.android.server.notification;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class CriticalNotificationExtractor implements NotificationSignalExtractor {
    static final int CRITICAL = 0;
    static final int CRITICAL_LOW = 1;
    private static final boolean DBG = false;
    static final int NORMAL = 2;
    private static final String TAG = "CriticalNotificationExt";
    private boolean mSupportsCriticalNotifications;

    public CriticalNotificationExtractor() {
        this.mSupportsCriticalNotifications = false;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context context, NotificationUsageStats usageStats) {
        this.mSupportsCriticalNotifications = supportsCriticalNotifications(context);
    }

    private boolean supportsCriticalNotifications(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive", 0);
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (this.mSupportsCriticalNotifications == true) goto L5;
        return null;
    L5:
        if (record != null) goto L7;
    L17:
        return null;
    L7:
        if (record.getNotification() == null) goto L17;
        if (record.isCategory("car_emergency") == false) goto L13;
        record.setCriticality(0);
    L16:
        return null;
    L13:
        if (record.isCategory("car_warning") == false) goto L15;
        record.setCriticality(1);
        goto L16
    L15:
        record.setCriticality(2);
        goto L16
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }
}
