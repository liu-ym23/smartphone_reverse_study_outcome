package com.android.server.notification;

/* JADX INFO: loaded from: classes2.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean allNotifsNeedTtl() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean autogroupSummaryIconUpdate() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean crossAppPoliteNotifications() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean exitInvalidCancelEarly() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean expireBitmaps() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean fixCallingUidFromCps() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean managedServicesConcurrentMultiuser() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean nmBinderPerfReduceZenBroadcasts() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean nmBinderPerfThrottleEffectsSuppressorBroadcast() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationCustomViewUriRestriction() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationForceGroupConversations() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationForceGroupSingletons() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationHideUnusedChannels() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationLockScreenSettings() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationMinimalism() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationTest() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationVibrationInSoundUri() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationVibrationInSoundUriForChannel() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean persistIncompleteRestoreData() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean politeNotifications() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean politeNotificationsAttnUpdate() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean preventZenDeviceEffectsWhileDriving() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean refactorAttentionHelper() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean rejectOldNotifications() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean screenshareNotificationHiding() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean traceCancelEvents() {
        return false;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean useSsmUserSwitchSignal() {
        return true;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean vibrateWhileUnlocked() {
        return false;
    }
}
