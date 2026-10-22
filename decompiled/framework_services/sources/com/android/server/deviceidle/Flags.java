package com.android.server.deviceidle;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_DISABLE_WAKELOCKS_IN_LIGHT_IDLE = "com.android.server.deviceidle.disable_wakelocks_in_light_idle";
    public static final String FLAG_REMOVE_IDLE_LOCATION = "com.android.server.deviceidle.remove_idle_location";
    public static final String FLAG_USE_CPU_TIME_FOR_TEMP_ALLOWLIST = "com.android.server.deviceidle.use_cpu_time_for_temp_allowlist";

    public Flags() {
    }

    public static boolean disableWakelocksInLightIdle() {
        return false;
    }

    public static boolean removeIdleLocation() {
        return true;
    }

    public static boolean useCpuTimeForTempAllowlist() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
