package com.android.server.notification;

/* JADX INFO: loaded from: classes2.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ALL_NOTIFS_NEED_TTL = "com.android.server.notification.all_notifs_need_ttl";
    public static final String FLAG_AUTOGROUP_SUMMARY_ICON_UPDATE = "com.android.server.notification.autogroup_summary_icon_update";
    public static final String FLAG_CROSS_APP_POLITE_NOTIFICATIONS = "com.android.server.notification.cross_app_polite_notifications";
    public static final String FLAG_EXIT_INVALID_CANCEL_EARLY = "com.android.server.notification.exit_invalid_cancel_early";
    public static final String FLAG_EXPIRE_BITMAPS = "com.android.server.notification.expire_bitmaps";
    public static final String FLAG_FIX_CALLING_UID_FROM_CPS = "com.android.server.notification.fix_calling_uid_from_cps";
    public static final String FLAG_MANAGED_SERVICES_CONCURRENT_MULTIUSER = "com.android.server.notification.managed_services_concurrent_multiuser";
    public static final String FLAG_NM_BINDER_PERF_REDUCE_ZEN_BROADCASTS = "com.android.server.notification.nm_binder_perf_reduce_zen_broadcasts";
    public static final String FLAG_NM_BINDER_PERF_THROTTLE_EFFECTS_SUPPRESSOR_BROADCAST = "com.android.server.notification.nm_binder_perf_throttle_effects_suppressor_broadcast";
    public static final String FLAG_NOTIFICATION_CUSTOM_VIEW_URI_RESTRICTION = "com.android.server.notification.notification_custom_view_uri_restriction";
    public static final String FLAG_NOTIFICATION_FORCE_GROUP_CONVERSATIONS = "com.android.server.notification.notification_force_group_conversations";
    public static final String FLAG_NOTIFICATION_FORCE_GROUP_SINGLETONS = "com.android.server.notification.notification_force_group_singletons";
    public static final String FLAG_NOTIFICATION_HIDE_UNUSED_CHANNELS = "com.android.server.notification.notification_hide_unused_channels";
    public static final String FLAG_NOTIFICATION_LOCK_SCREEN_SETTINGS = "com.android.server.notification.notification_lock_screen_settings";
    public static final String FLAG_NOTIFICATION_MINIMALISM = "com.android.server.notification.notification_minimalism";
    public static final String FLAG_NOTIFICATION_TEST = "com.android.server.notification.notification_test";
    public static final String FLAG_NOTIFICATION_VIBRATION_IN_SOUND_URI = "com.android.server.notification.notification_vibration_in_sound_uri";
    public static final String FLAG_NOTIFICATION_VIBRATION_IN_SOUND_URI_FOR_CHANNEL = "com.android.server.notification.notification_vibration_in_sound_uri_for_channel";
    public static final String FLAG_PERSIST_INCOMPLETE_RESTORE_DATA = "com.android.server.notification.persist_incomplete_restore_data";
    public static final String FLAG_POLITE_NOTIFICATIONS = "com.android.server.notification.polite_notifications";
    public static final String FLAG_POLITE_NOTIFICATIONS_ATTN_UPDATE = "com.android.server.notification.polite_notifications_attn_update";
    public static final String FLAG_PREVENT_ZEN_DEVICE_EFFECTS_WHILE_DRIVING = "com.android.server.notification.prevent_zen_device_effects_while_driving";
    public static final String FLAG_REFACTOR_ATTENTION_HELPER = "com.android.server.notification.refactor_attention_helper";
    public static final String FLAG_REJECT_OLD_NOTIFICATIONS = "com.android.server.notification.reject_old_notifications";
    public static final String FLAG_SCREENSHARE_NOTIFICATION_HIDING = "com.android.server.notification.screenshare_notification_hiding";
    public static final String FLAG_TRACE_CANCEL_EVENTS = "com.android.server.notification.trace_cancel_events";
    public static final String FLAG_USE_SSM_USER_SWITCH_SIGNAL = "com.android.server.notification.use_ssm_user_switch_signal";
    public static final String FLAG_VIBRATE_WHILE_UNLOCKED = "com.android.server.notification.vibrate_while_unlocked";

    public Flags() {
    }

    public static boolean allNotifsNeedTtl() {
        return true;
    }

    public static boolean autogroupSummaryIconUpdate() {
        return true;
    }

    public static boolean crossAppPoliteNotifications() {
        return true;
    }

    public static boolean exitInvalidCancelEarly() {
        return false;
    }

    public static boolean expireBitmaps() {
        return true;
    }

    public static boolean fixCallingUidFromCps() {
        return true;
    }

    public static boolean managedServicesConcurrentMultiuser() {
        return false;
    }

    public static boolean nmBinderPerfReduceZenBroadcasts() {
        return false;
    }

    public static boolean nmBinderPerfThrottleEffectsSuppressorBroadcast() {
        return false;
    }

    public static boolean notificationCustomViewUriRestriction() {
        return false;
    }

    public static boolean notificationForceGroupConversations() {
        return false;
    }

    public static boolean notificationForceGroupSingletons() {
        return true;
    }

    public static boolean notificationHideUnusedChannels() {
        return true;
    }

    public static boolean notificationLockScreenSettings() {
        return false;
    }

    public static boolean notificationMinimalism() {
        return false;
    }

    public static boolean notificationTest() {
        return false;
    }

    public static boolean notificationVibrationInSoundUri() {
        return false;
    }

    public static boolean notificationVibrationInSoundUriForChannel() {
        return false;
    }

    public static boolean persistIncompleteRestoreData() {
        return true;
    }

    public static boolean politeNotifications() {
        return true;
    }

    public static boolean politeNotificationsAttnUpdate() {
        return true;
    }

    public static boolean preventZenDeviceEffectsWhileDriving() {
        return true;
    }

    public static boolean refactorAttentionHelper() {
        return true;
    }

    public static boolean rejectOldNotifications() {
        return true;
    }

    public static boolean screenshareNotificationHiding() {
        return true;
    }

    public static boolean traceCancelEvents() {
        return false;
    }

    public static boolean useSsmUserSwitchSignal() {
        return true;
    }

    public static boolean vibrateWhileUnlocked() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
