package com.android.server.power.hint;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.power.hint.FeatureFlags
    public boolean adpfSessionTag() {
        return true;
    }

    @Override // com.android.server.power.hint.FeatureFlags
    public boolean cpuHeadroomAffinityCheck() {
        return false;
    }

    @Override // com.android.server.power.hint.FeatureFlags
    public boolean powerhintThreadCleanup() {
        return true;
    }

    @Override // com.android.server.power.hint.FeatureFlags
    public boolean resetOnForkEnabled() {
        return true;
    }
}
