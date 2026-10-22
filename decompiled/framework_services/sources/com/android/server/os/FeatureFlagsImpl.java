package com.android.server.os;

/* JADX INFO: loaded from: classes2.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.os.FeatureFlags
    public boolean asyncStartBugreport() {
        return false;
    }

    @Override // com.android.server.os.FeatureFlags
    public boolean protoTombstone() {
        return false;
    }
}
