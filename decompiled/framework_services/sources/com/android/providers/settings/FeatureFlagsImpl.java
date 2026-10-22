package com.android.providers.settings;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean checkRootAndReadOnly() {
        return false;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean ignoreXmlForReadOnlyFlags() {
        return true;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean loadAconfigDefaults() {
        return true;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean loadApexAconfigProtobufs() {
        return true;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean notifyIndividualAconfigSyspropChanged() {
        return true;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean stageAllAconfigFlags() {
        return true;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean storageTestMission1() {
        return false;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean supportLocalOverridesSysprops() {
        return true;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean supportOverrides() {
        return false;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean syncLocalOverridesRemovalNewStorage() {
        return true;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean useNewStorageValue() {
        return false;
    }
}
