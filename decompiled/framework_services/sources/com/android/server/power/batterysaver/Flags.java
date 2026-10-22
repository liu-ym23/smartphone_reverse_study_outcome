package com.android.server.power.batterysaver;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_UPDATE_AUTO_TURN_ON_NOTIFICATION_STRING_AND_ACTION = "com.android.server.power.batterysaver.update_auto_turn_on_notification_string_and_action";

    public Flags() {
    }

    public static boolean updateAutoTurnOnNotificationStringAndAction() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
