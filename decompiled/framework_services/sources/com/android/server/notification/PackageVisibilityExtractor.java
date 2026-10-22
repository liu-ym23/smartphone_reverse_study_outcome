package com.android.server.notification;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class PackageVisibilityExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    private static final String TAG = "PackageVisibilityExtractor";
    private RankingConfig mConfig;

    public PackageVisibilityExtractor() {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context ctx, NotificationUsageStats usageStats) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record != null) goto L5;
    L14:
        return null;
    L5:
        if (record.getNotification() == null) goto L14;
        if (this.mConfig != null) goto L11;
        return null;
    L11:
        if ((this.mConfig instanceof PreferencesHelper) == false) goto L13;
        record.getSmtEx().setSmtPackageVisibility(((PreferencesHelper) this.mConfig).getSmtEx().getSmtPackageVisibility(record.getSbn().getPackageName(), record.getSbn().getUid()));
    L13:
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
