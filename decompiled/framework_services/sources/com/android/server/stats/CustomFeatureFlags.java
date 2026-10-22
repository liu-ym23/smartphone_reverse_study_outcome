package com.android.server.stats;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ACCUMULATE_NETWORK_STATS_SINCE_BOOT, Flags.FLAG_ADD_MOBILE_BYTES_TRANSFER_BY_PROC_STATE_PULLER, Flags.FLAG_ADD_PRESSURE_STALL_INFORMATION_PULLER, Flags.FLAG_APPLY_NETWORK_STATS_POLL_RATE_LIMIT, Flags.FLAG_NETSTATS_USE_ADD_ENTRIES, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean accumulateNetworkStatsSinceBoot() {
        return getValue(Flags.FLAG_ACCUMULATE_NETWORK_STATS_SINCE_BOOT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean addMobileBytesTransferByProcStatePuller() {
        return getValue(Flags.FLAG_ADD_MOBILE_BYTES_TRANSFER_BY_PROC_STATE_PULLER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean addPressureStallInformationPuller() {
        return getValue(Flags.FLAG_ADD_PRESSURE_STALL_INFORMATION_PULLER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean applyNetworkStatsPollRateLimit() {
        return getValue(Flags.FLAG_APPLY_NETWORK_STATS_POLL_RATE_LIMIT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean netstatsUseAddEntries() {
        return getValue(Flags.FLAG_NETSTATS_USE_ADD_ENTRIES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ACCUMULATE_NETWORK_STATS_SINCE_BOOT, Flags.FLAG_ADD_MOBILE_BYTES_TRANSFER_BY_PROC_STATE_PULLER, Flags.FLAG_ADD_PRESSURE_STALL_INFORMATION_PULLER, Flags.FLAG_APPLY_NETWORK_STATS_POLL_RATE_LIMIT, Flags.FLAG_NETSTATS_USE_ADD_ENTRIES});
    }
}
