package com.android.server.notification;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class PriorityExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    private static final String TAG = "PriorityExtractor";
    private RankingConfig mConfig;

    public PriorityExtractor() {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context ctx, NotificationUsageStats usageStats) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record != null) goto L5;
    L16:
        return null;
    L5:
        if (record.getNotification() == null) goto L16;
        if (this.mConfig != null) goto L11;
        return null;
    L11:
        if (record.getChannel().canBypassDnd() == false) goto L13;
        int r1 = 2;
    L14:
        record.setPackagePriority(r1);
        return null;
    L13:
        r1 = 0;
        goto L14
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
        this.mConfig = config;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }
}
