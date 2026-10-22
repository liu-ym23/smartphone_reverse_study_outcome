package com.android.server.notification;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ALL_NOTIFS_NEED_TTL, Flags.FLAG_AUTOGROUP_SUMMARY_ICON_UPDATE, Flags.FLAG_CROSS_APP_POLITE_NOTIFICATIONS, Flags.FLAG_EXIT_INVALID_CANCEL_EARLY, Flags.FLAG_EXPIRE_BITMAPS, Flags.FLAG_FIX_CALLING_UID_FROM_CPS, Flags.FLAG_MANAGED_SERVICES_CONCURRENT_MULTIUSER, Flags.FLAG_NM_BINDER_PERF_REDUCE_ZEN_BROADCASTS, Flags.FLAG_NM_BINDER_PERF_THROTTLE_EFFECTS_SUPPRESSOR_BROADCAST, Flags.FLAG_NOTIFICATION_CUSTOM_VIEW_URI_RESTRICTION, Flags.FLAG_NOTIFICATION_FORCE_GROUP_CONVERSATIONS, Flags.FLAG_NOTIFICATION_FORCE_GROUP_SINGLETONS, Flags.FLAG_NOTIFICATION_HIDE_UNUSED_CHANNELS, Flags.FLAG_NOTIFICATION_LOCK_SCREEN_SETTINGS, Flags.FLAG_NOTIFICATION_MINIMALISM, Flags.FLAG_NOTIFICATION_TEST, Flags.FLAG_NOTIFICATION_VIBRATION_IN_SOUND_URI, Flags.FLAG_NOTIFICATION_VIBRATION_IN_SOUND_URI_FOR_CHANNEL, Flags.FLAG_PERSIST_INCOMPLETE_RESTORE_DATA, Flags.FLAG_POLITE_NOTIFICATIONS, Flags.FLAG_POLITE_NOTIFICATIONS_ATTN_UPDATE, Flags.FLAG_PREVENT_ZEN_DEVICE_EFFECTS_WHILE_DRIVING, Flags.FLAG_REFACTOR_ATTENTION_HELPER, Flags.FLAG_REJECT_OLD_NOTIFICATIONS, Flags.FLAG_SCREENSHARE_NOTIFICATION_HIDING, Flags.FLAG_TRACE_CANCEL_EVENTS, Flags.FLAG_USE_SSM_USER_SWITCH_SIGNAL, Flags.FLAG_VIBRATE_WHILE_UNLOCKED, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean allNotifsNeedTtl() {
        return getValue(Flags.FLAG_ALL_NOTIFS_NEED_TTL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean autogroupSummaryIconUpdate() {
        return getValue(Flags.FLAG_AUTOGROUP_SUMMARY_ICON_UPDATE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean crossAppPoliteNotifications() {
        return getValue(Flags.FLAG_CROSS_APP_POLITE_NOTIFICATIONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean exitInvalidCancelEarly() {
        return getValue(Flags.FLAG_EXIT_INVALID_CANCEL_EARLY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean expireBitmaps() {
        return getValue(Flags.FLAG_EXPIRE_BITMAPS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean fixCallingUidFromCps() {
        return getValue(Flags.FLAG_FIX_CALLING_UID_FROM_CPS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean managedServicesConcurrentMultiuser() {
        return getValue(Flags.FLAG_MANAGED_SERVICES_CONCURRENT_MULTIUSER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean nmBinderPerfReduceZenBroadcasts() {
        return getValue(Flags.FLAG_NM_BINDER_PERF_REDUCE_ZEN_BROADCASTS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean nmBinderPerfThrottleEffectsSuppressorBroadcast() {
        return getValue(Flags.FLAG_NM_BINDER_PERF_THROTTLE_EFFECTS_SUPPRESSOR_BROADCAST, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationCustomViewUriRestriction() {
        return getValue(Flags.FLAG_NOTIFICATION_CUSTOM_VIEW_URI_RESTRICTION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationForceGroupConversations() {
        return getValue(Flags.FLAG_NOTIFICATION_FORCE_GROUP_CONVERSATIONS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationForceGroupSingletons() {
        return getValue(Flags.FLAG_NOTIFICATION_FORCE_GROUP_SINGLETONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationHideUnusedChannels() {
        return getValue(Flags.FLAG_NOTIFICATION_HIDE_UNUSED_CHANNELS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationLockScreenSettings() {
        return getValue(Flags.FLAG_NOTIFICATION_LOCK_SCREEN_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationMinimalism() {
        return getValue(Flags.FLAG_NOTIFICATION_MINIMALISM, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationTest() {
        return getValue(Flags.FLAG_NOTIFICATION_TEST, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationVibrationInSoundUri() {
        return getValue(Flags.FLAG_NOTIFICATION_VIBRATION_IN_SOUND_URI, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean notificationVibrationInSoundUriForChannel() {
        return getValue(Flags.FLAG_NOTIFICATION_VIBRATION_IN_SOUND_URI_FOR_CHANNEL, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean persistIncompleteRestoreData() {
        return getValue(Flags.FLAG_PERSIST_INCOMPLETE_RESTORE_DATA, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean politeNotifications() {
        return getValue(Flags.FLAG_POLITE_NOTIFICATIONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean politeNotificationsAttnUpdate() {
        return getValue(Flags.FLAG_POLITE_NOTIFICATIONS_ATTN_UPDATE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean preventZenDeviceEffectsWhileDriving() {
        return getValue(Flags.FLAG_PREVENT_ZEN_DEVICE_EFFECTS_WHILE_DRIVING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean refactorAttentionHelper() {
        return getValue(Flags.FLAG_REFACTOR_ATTENTION_HELPER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean rejectOldNotifications() {
        return getValue(Flags.FLAG_REJECT_OLD_NOTIFICATIONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean screenshareNotificationHiding() {
        return getValue(Flags.FLAG_SCREENSHARE_NOTIFICATION_HIDING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean traceCancelEvents() {
        return getValue(Flags.FLAG_TRACE_CANCEL_EVENTS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean useSsmUserSwitchSignal() {
        return getValue(Flags.FLAG_USE_SSM_USER_SWITCH_SIGNAL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.notification.FeatureFlags
    public boolean vibrateWhileUnlocked() {
        return getValue(Flags.FLAG_VIBRATE_WHILE_UNLOCKED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    public boolean isFlagReadOnlyOptimized(String flagName) {
        if (this.mReadOnlyFlagsSet.contains(flagName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isOptimizationEnabled() {
        return false;
    }

    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        return this.mGetValueImpl.test(flagName, getter);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_ALL_NOTIFS_NEED_TTL, Flags.FLAG_AUTOGROUP_SUMMARY_ICON_UPDATE, Flags.FLAG_CROSS_APP_POLITE_NOTIFICATIONS, Flags.FLAG_EXIT_INVALID_CANCEL_EARLY, Flags.FLAG_EXPIRE_BITMAPS, Flags.FLAG_FIX_CALLING_UID_FROM_CPS, Flags.FLAG_MANAGED_SERVICES_CONCURRENT_MULTIUSER, Flags.FLAG_NM_BINDER_PERF_REDUCE_ZEN_BROADCASTS, Flags.FLAG_NM_BINDER_PERF_THROTTLE_EFFECTS_SUPPRESSOR_BROADCAST, Flags.FLAG_NOTIFICATION_CUSTOM_VIEW_URI_RESTRICTION, Flags.FLAG_NOTIFICATION_FORCE_GROUP_CONVERSATIONS, Flags.FLAG_NOTIFICATION_FORCE_GROUP_SINGLETONS, Flags.FLAG_NOTIFICATION_HIDE_UNUSED_CHANNELS, Flags.FLAG_NOTIFICATION_LOCK_SCREEN_SETTINGS, Flags.FLAG_NOTIFICATION_MINIMALISM, Flags.FLAG_NOTIFICATION_TEST, Flags.FLAG_NOTIFICATION_VIBRATION_IN_SOUND_URI, Flags.FLAG_NOTIFICATION_VIBRATION_IN_SOUND_URI_FOR_CHANNEL, Flags.FLAG_PERSIST_INCOMPLETE_RESTORE_DATA, Flags.FLAG_POLITE_NOTIFICATIONS, Flags.FLAG_POLITE_NOTIFICATIONS_ATTN_UPDATE, Flags.FLAG_PREVENT_ZEN_DEVICE_EFFECTS_WHILE_DRIVING, Flags.FLAG_REFACTOR_ATTENTION_HELPER, Flags.FLAG_REJECT_OLD_NOTIFICATIONS, Flags.FLAG_SCREENSHARE_NOTIFICATION_HIDING, Flags.FLAG_TRACE_CANCEL_EVENTS, Flags.FLAG_USE_SSM_USER_SWITCH_SIGNAL, Flags.FLAG_VIBRATE_WHILE_UNLOCKED});
    }
}
