package com.android.server.deviceidle;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.deviceidle.FeatureFlags
    public boolean disableWakelocksInLightIdle() {
        return false;
    }

    @Override // com.android.server.deviceidle.FeatureFlags
    public boolean removeIdleLocation() {
        return true;
    }

    @Override // com.android.server.deviceidle.FeatureFlags
    public boolean useCpuTimeForTempAllowlist() {
        return true;
    }
}
