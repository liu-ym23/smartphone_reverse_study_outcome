package com.android.server.stats;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean accumulateNetworkStatsSinceBoot() {
        return true;
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean addMobileBytesTransferByProcStatePuller() {
        return true;
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean addPressureStallInformationPuller() {
        return true;
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean applyNetworkStatsPollRateLimit() {
        return true;
    }

    @Override // com.android.server.stats.FeatureFlags
    public boolean netstatsUseAddEntries() {
        return true;
    }
}
