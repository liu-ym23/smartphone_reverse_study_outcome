package com.android.server.notification;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationAdjustmentExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    private static final String TAG = "AdjustmentExtractor";
    private GroupHelper mGroupHelper;

    /* JADX INFO: renamed from: -$$Nest$fgetmGroupHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ GroupHelper m6076$$Nest$fgetmGroupHelper(NotificationAdjustmentExtractor r0) {
        return r0.mGroupHelper;
    }

    public NotificationAdjustmentExtractor() {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context ctx, NotificationUsageStats usageStats) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record != null) goto L5;
    L13:
        return null;
    L5:
        if (record.getNotification() == null) goto L13;
        boolean hasAdjustedClassification = record.hasAdjustment("key_type");
        record.applyAdjustments();
        if (this.mGroupHelper == null) goto L12;
        if (hasAdjustedClassification == false) goto L12;
        final String r2 = record.getKey();
        final long r3 = 0;
        return new AnonymousClass1(this, r2, r3);
    L12:
        return null;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setGroupHelper(GroupHelper groupHelper) {
        this.mGroupHelper = groupHelper;
    }
}
