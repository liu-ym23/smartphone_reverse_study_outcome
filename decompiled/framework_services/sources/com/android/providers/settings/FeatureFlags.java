package com.android.providers.settings;

/* JADX INFO: loaded from: classes.dex */
public interface FeatureFlags {
    boolean checkRootAndReadOnly();

    boolean ignoreXmlForReadOnlyFlags();

    boolean loadAconfigDefaults();

    boolean loadApexAconfigProtobufs();

    boolean notifyIndividualAconfigSyspropChanged();

    boolean stageAllAconfigFlags();

    boolean storageTestMission1();

    boolean supportLocalOverridesSysprops();

    boolean supportOverrides();

    boolean syncLocalOverridesRemovalNewStorage();

    boolean useNewStorageValue();
}
