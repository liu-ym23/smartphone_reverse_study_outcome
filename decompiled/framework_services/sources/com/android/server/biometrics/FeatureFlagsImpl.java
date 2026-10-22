package com.android.server.biometrics;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean faceVhalFeature() {
        return false;
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean frrDialogImprovement() {
        return false;
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean notifyFingerprintsLoe() {
        return true;
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean setIgnoreSpeedUp() {
        return true;
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean useVhalForTesting() {
        return false;
    }
}
