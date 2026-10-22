package com.android.server.dreams;

/* JADX INFO: loaded from: classes2.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.dreams.FeatureFlags
    public boolean useBatteryChangedBroadcast() {
        return true;
    }
}
