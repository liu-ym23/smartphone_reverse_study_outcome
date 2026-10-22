package com.android.server.notification;

import android.app.admin.DevicePolicyManager;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class VisibilityExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    private static final String TAG = "VisibilityExtractor";
    private RankingConfig mConfig;
    private DevicePolicyManager mDpm;

    public VisibilityExtractor() {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context ctx, NotificationUsageStats usageStats) {
        this.mDpm = (DevicePolicyManager) ctx.getSystemService(DevicePolicyManager.class);
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record != null) goto L5;
    L33:
        return null;
    L5:
        if (record.getNotification() == null) goto L33;
        if (this.mConfig != null) goto L10;
        return null;
    L10:
        int userId = record.getUserId();
        if (userId != (-1)) goto L13;
        record.setPackageVisibilityOverride(record.getChannel().getLockscreenVisibility());
    L32:
        return null;
    L13:
        boolean userCanShowNotifications = this.mConfig.canShowNotificationsOnLockscreen(userId);
        boolean dpmCanShowNotifications = adminAllowsKeyguardFeature(userId, 4);
        boolean channelCanShowContents = true;
        if (record.getChannel().getLockscreenVisibility() == (-1)) goto L16;
        boolean channelCanShowNotifications = true;
    L17:
        if (userCanShowNotifications == false) goto L31;
        if (dpmCanShowNotifications == false) goto L31;
        if (channelCanShowNotifications == false) goto L31;
        boolean userCanShowContents = this.mConfig.canShowPrivateNotificationsOnLockScreen(userId);
        boolean dpmCanShowContents = adminAllowsKeyguardFeature(userId, 8);
        if (record.getChannel().getLockscreenVisibility() != 0) goto L25;
        channelCanShowContents = false;
    L25:
        if (userCanShowContents == false) goto L30;
        if (dpmCanShowContents == false) goto L30;
        if (channelCanShowContents == false) goto L30;
        record.setPackageVisibilityOverride(-1000);
    L30:
        record.setPackageVisibilityOverride(0);
    L31:
        record.setPackageVisibilityOverride(-1);
        goto L32
    L16:
        channelCanShowNotifications = false;
        goto L17
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
        this.mConfig = config;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }

    private boolean adminAllowsKeyguardFeature(int userHandle, int feature) {
        if (userHandle != (-1)) goto L5;
        return true;
    L5:
        int dpmFlags = this.mDpm.getKeyguardDisabledFeatures(null, userHandle);
        if ((dpmFlags & feature) == 0) goto L10;
        return false;
    L10:
        return true;
    }
}
