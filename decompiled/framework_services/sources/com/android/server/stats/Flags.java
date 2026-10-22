package com.android.server.stats;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ACCUMULATE_NETWORK_STATS_SINCE_BOOT = "com.android.server.stats.accumulate_network_stats_since_boot";
    public static final String FLAG_ADD_MOBILE_BYTES_TRANSFER_BY_PROC_STATE_PULLER = "com.android.server.stats.add_mobile_bytes_transfer_by_proc_state_puller";
    public static final String FLAG_ADD_PRESSURE_STALL_INFORMATION_PULLER = "com.android.server.stats.add_pressure_stall_information_puller";
    public static final String FLAG_APPLY_NETWORK_STATS_POLL_RATE_LIMIT = "com.android.server.stats.apply_network_stats_poll_rate_limit";
    public static final String FLAG_NETSTATS_USE_ADD_ENTRIES = "com.android.server.stats.netstats_use_add_entries";

    public Flags() {
    }

    public static boolean accumulateNetworkStatsSinceBoot() {
        return true;
    }

    public static boolean addMobileBytesTransferByProcStatePuller() {
        return true;
    }

    public static boolean addPressureStallInformationPuller() {
        return true;
    }

    public static boolean applyNetworkStatsPollRateLimit() {
        return true;
    }

    public static boolean netstatsUseAddEntries() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
