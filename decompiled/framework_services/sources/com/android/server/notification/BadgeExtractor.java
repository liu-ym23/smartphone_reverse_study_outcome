package com.android.server.notification;

import android.app.Notification;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    private static final String TAG = "BadgeExtractor";
    private RankingConfig mConfig;

    public BadgeExtractor() {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context ctx, NotificationUsageStats usageStats) {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record != null) goto L5;
    L40:
        return null;
    L5:
        if (record.getNotification() == null) goto L40;
        if (this.mConfig != null) goto L10;
        return null;
    L10:
        boolean userWantsBadges = this.mConfig.badgingEnabled(record.getSbn().getUser());
        boolean appCanShowBadge = this.mConfig.canShowBadge(record.getSbn().getPackageName(), record.getSbn().getUid());
        if (userWantsBadges == false) goto L23;
        if (appCanShowBadge == false) goto L23;
        if (record.getChannel() != null) goto L17;
        record.setShowBadge(appCanShowBadge);
    L25:
        if (record.isIntercepted() == true) goto L27;
    L29:
        Notification.BubbleMetadata metadata = record.getNotification().getBubbleMetadata();
        if (metadata == null) goto L35;
        if (metadata.isNotificationSuppressed() == false) goto L35;
        record.setShowBadge(false);
    L35:
        if (this.mConfig.isMediaNotificationFilteringEnabled() == false) goto L39;
        Notification notif = record.getNotification();
        if (notif.isMediaNotification() == false) goto L39;
        record.setShowBadge(false);
    L39:
        return null;
    L27:
        if ((record.getSuppressedVisualEffects() & 64) == 0) goto L29;
        record.setShowBadge(false);
        goto L29
    L17:
        if (record.getChannel().canShowBadge() == false) goto L20;
        if (appCanShowBadge == false) goto L20;
        boolean r4 = true;
    L21:
        record.setShowBadge(r4);
    L20:
        r4 = false;
    L23:
        record.setShowBadge(false);
        goto L25
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
        this.mConfig = config;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }
}
