package com.android.server.notification;

/* JADX INFO: loaded from: classes2.dex */
public interface FeatureFlags {
    boolean allNotifsNeedTtl();

    boolean autogroupSummaryIconUpdate();

    boolean crossAppPoliteNotifications();

    boolean exitInvalidCancelEarly();

    boolean expireBitmaps();

    boolean fixCallingUidFromCps();

    boolean managedServicesConcurrentMultiuser();

    boolean nmBinderPerfReduceZenBroadcasts();

    boolean nmBinderPerfThrottleEffectsSuppressorBroadcast();

    boolean notificationCustomViewUriRestriction();

    boolean notificationForceGroupConversations();

    boolean notificationForceGroupSingletons();

    boolean notificationHideUnusedChannels();

    boolean notificationLockScreenSettings();

    boolean notificationMinimalism();

    boolean notificationTest();

    boolean notificationVibrationInSoundUri();

    boolean notificationVibrationInSoundUriForChannel();

    boolean persistIncompleteRestoreData();

    boolean politeNotifications();

    boolean politeNotificationsAttnUpdate();

    boolean preventZenDeviceEffectsWhileDriving();

    boolean refactorAttentionHelper();

    boolean rejectOldNotifications();

    boolean screenshareNotificationHiding();

    boolean traceCancelEvents();

    boolean useSsmUserSwitchSignal();

    boolean vibrateWhileUnlocked();
}
