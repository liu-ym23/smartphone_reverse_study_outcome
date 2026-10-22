package com.android.server.alarm;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ACQUIRE_WAKELOCK_BEFORE_SEND = "com.android.server.alarm.acquire_wakelock_before_send";
    public static final String FLAG_START_USER_BEFORE_SCHEDULED_ALARMS = "com.android.server.alarm.start_user_before_scheduled_alarms";

    public Flags() {
    }

    public static boolean acquireWakelockBeforeSend() {
        return false;
    }

    public static boolean startUserBeforeScheduledAlarms() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
