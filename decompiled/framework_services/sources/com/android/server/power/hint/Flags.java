package com.android.server.power.hint;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ADPF_SESSION_TAG = "com.android.server.power.hint.adpf_session_tag";
    public static final String FLAG_CPU_HEADROOM_AFFINITY_CHECK = "com.android.server.power.hint.cpu_headroom_affinity_check";
    public static final String FLAG_POWERHINT_THREAD_CLEANUP = "com.android.server.power.hint.powerhint_thread_cleanup";
    public static final String FLAG_RESET_ON_FORK_ENABLED = "com.android.server.power.hint.reset_on_fork_enabled";

    public Flags() {
    }

    public static boolean adpfSessionTag() {
        return true;
    }

    public static boolean cpuHeadroomAffinityCheck() {
        return false;
    }

    public static boolean powerhintThreadCleanup() {
        return true;
    }

    public static boolean resetOnForkEnabled() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
