package com.android.providers.settings;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_CHECK_ROOT_AND_READ_ONLY = "com.android.providers.settings.check_root_and_read_only";
    public static final String FLAG_IGNORE_XML_FOR_READ_ONLY_FLAGS = "com.android.providers.settings.ignore_xml_for_read_only_flags";
    public static final String FLAG_LOAD_ACONFIG_DEFAULTS = "com.android.providers.settings.load_aconfig_defaults";
    public static final String FLAG_LOAD_APEX_ACONFIG_PROTOBUFS = "com.android.providers.settings.load_apex_aconfig_protobufs";
    public static final String FLAG_NOTIFY_INDIVIDUAL_ACONFIG_SYSPROP_CHANGED = "com.android.providers.settings.notify_individual_aconfig_sysprop_changed";
    public static final String FLAG_STAGE_ALL_ACONFIG_FLAGS = "com.android.providers.settings.stage_all_aconfig_flags";
    public static final String FLAG_STORAGE_TEST_MISSION_1 = "com.android.providers.settings.storage_test_mission_1";
    public static final String FLAG_SUPPORT_LOCAL_OVERRIDES_SYSPROPS = "com.android.providers.settings.support_local_overrides_sysprops";
    public static final String FLAG_SUPPORT_OVERRIDES = "com.android.providers.settings.support_overrides";
    public static final String FLAG_SYNC_LOCAL_OVERRIDES_REMOVAL_NEW_STORAGE = "com.android.providers.settings.sync_local_overrides_removal_new_storage";
    public static final String FLAG_USE_NEW_STORAGE_VALUE = "com.android.providers.settings.use_new_storage_value";

    public Flags() {
    }

    public static boolean checkRootAndReadOnly() {
        return false;
    }

    public static boolean ignoreXmlForReadOnlyFlags() {
        return true;
    }

    public static boolean loadAconfigDefaults() {
        return true;
    }

    public static boolean loadApexAconfigProtobufs() {
        return true;
    }

    public static boolean notifyIndividualAconfigSyspropChanged() {
        return true;
    }

    public static boolean stageAllAconfigFlags() {
        return true;
    }

    public static boolean storageTestMission1() {
        return false;
    }

    public static boolean supportLocalOverridesSysprops() {
        return true;
    }

    public static boolean supportOverrides() {
        return false;
    }

    public static boolean syncLocalOverridesRemovalNewStorage() {
        return true;
    }

    public static boolean useNewStorageValue() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
