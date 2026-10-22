package com.android.server.usage;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.usage.FeatureFlags
    public boolean adjustDefaultBucketElevationParams() {
        return true;
    }

    @Override // com.android.server.usage.FeatureFlags
    public boolean avoidIdleCheck() {
        return true;
    }

    @Override // com.android.server.usage.FeatureFlags
    public boolean persistRestoreToRareAppsList() {
        return true;
    }

    @Override // com.android.server.usage.FeatureFlags
    public boolean screenTimeBypass() {
        return true;
    }
}
