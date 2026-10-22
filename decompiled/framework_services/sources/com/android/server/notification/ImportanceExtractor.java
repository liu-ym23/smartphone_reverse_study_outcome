package com.android.server.notification;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ImportanceExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    private static final String TAG = "ImportanceExtractor";
    private RankingConfig mConfig;

    public ImportanceExtractor() {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context ctx, NotificationUsageStats usageStats) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record != null) goto L5;
    L12:
        return null;
    L5:
        if (record.getNotification() == null) goto L12;
        if (this.mConfig != null) goto L10;
        return null;
    L10:
        record.calculateImportance();
        return null;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
        this.mConfig = config;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }
}
