package com.android.aconfig_new_storage;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean bluetoothFlagValueBugFix() {
        return true;
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean enableAconfigStorageDaemon() {
        return true;
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean enableAconfigdFromMainline() {
        return true;
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean enableFullRustSystemAconfigd() {
        return true;
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean supportClearLocalOverridesImmediately() {
        return true;
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean supportImmediateLocalOverrides() {
        return false;
    }
}
