package com.android.server.powerstats;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.powerstats.FeatureFlags
    public boolean alarmBasedPowerstatsLogging() {
        return false;
    }

    @Override // com.android.server.powerstats.FeatureFlags
    public boolean verifyNonNullArguments() {
        return true;
    }
}
