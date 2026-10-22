package com.android.server.dreams;

/* JADX INFO: loaded from: classes2.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_USE_BATTERY_CHANGED_BROADCAST = "com.android.server.dreams.use_battery_changed_broadcast";

    public Flags() {
    }

    public static boolean useBatteryChangedBroadcast() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
