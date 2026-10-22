package com.android.providers.settings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_CHECK_ROOT_AND_READ_ONLY, Flags.FLAG_IGNORE_XML_FOR_READ_ONLY_FLAGS, Flags.FLAG_LOAD_ACONFIG_DEFAULTS, Flags.FLAG_LOAD_APEX_ACONFIG_PROTOBUFS, Flags.FLAG_NOTIFY_INDIVIDUAL_ACONFIG_SYSPROP_CHANGED, Flags.FLAG_STAGE_ALL_ACONFIG_FLAGS, Flags.FLAG_STORAGE_TEST_MISSION_1, Flags.FLAG_SUPPORT_LOCAL_OVERRIDES_SYSPROPS, Flags.FLAG_SUPPORT_OVERRIDES, Flags.FLAG_SYNC_LOCAL_OVERRIDES_REMOVAL_NEW_STORAGE, Flags.FLAG_USE_NEW_STORAGE_VALUE, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean checkRootAndReadOnly() {
        return getValue(Flags.FLAG_CHECK_ROOT_AND_READ_ONLY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean ignoreXmlForReadOnlyFlags() {
        return getValue(Flags.FLAG_IGNORE_XML_FOR_READ_ONLY_FLAGS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean loadAconfigDefaults() {
        return getValue(Flags.FLAG_LOAD_ACONFIG_DEFAULTS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean loadApexAconfigProtobufs() {
        return getValue(Flags.FLAG_LOAD_APEX_ACONFIG_PROTOBUFS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean notifyIndividualAconfigSyspropChanged() {
        return getValue(Flags.FLAG_NOTIFY_INDIVIDUAL_ACONFIG_SYSPROP_CHANGED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean stageAllAconfigFlags() {
        return getValue(Flags.FLAG_STAGE_ALL_ACONFIG_FLAGS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean storageTestMission1() {
        return getValue(Flags.FLAG_STORAGE_TEST_MISSION_1, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean supportLocalOverridesSysprops() {
        return getValue(Flags.FLAG_SUPPORT_LOCAL_OVERRIDES_SYSPROPS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean supportOverrides() {
        return getValue(Flags.FLAG_SUPPORT_OVERRIDES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean syncLocalOverridesRemovalNewStorage() {
        return getValue(Flags.FLAG_SYNC_LOCAL_OVERRIDES_REMOVAL_NEW_STORAGE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.providers.settings.FeatureFlags
    public boolean useNewStorageValue() {
        return getValue(Flags.FLAG_USE_NEW_STORAGE_VALUE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    public boolean isFlagReadOnlyOptimized(String flagName) {
        if (this.mReadOnlyFlagsSet.contains(flagName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isOptimizationEnabled() {
        return false;
    }

    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        return this.mGetValueImpl.test(flagName, getter);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_CHECK_ROOT_AND_READ_ONLY, Flags.FLAG_IGNORE_XML_FOR_READ_ONLY_FLAGS, Flags.FLAG_LOAD_ACONFIG_DEFAULTS, Flags.FLAG_LOAD_APEX_ACONFIG_PROTOBUFS, Flags.FLAG_NOTIFY_INDIVIDUAL_ACONFIG_SYSPROP_CHANGED, Flags.FLAG_STAGE_ALL_ACONFIG_FLAGS, Flags.FLAG_STORAGE_TEST_MISSION_1, Flags.FLAG_SUPPORT_LOCAL_OVERRIDES_SYSPROPS, Flags.FLAG_SUPPORT_OVERRIDES, Flags.FLAG_SYNC_LOCAL_OVERRIDES_REMOVAL_NEW_STORAGE, Flags.FLAG_USE_NEW_STORAGE_VALUE});
    }
}
