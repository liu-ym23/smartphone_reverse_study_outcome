package com.android.aconfig_new_storage;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_BLUETOOTH_FLAG_VALUE_BUG_FIX, Flags.FLAG_ENABLE_ACONFIG_STORAGE_DAEMON, Flags.FLAG_ENABLE_ACONFIGD_FROM_MAINLINE, Flags.FLAG_ENABLE_FULL_RUST_SYSTEM_ACONFIGD, Flags.FLAG_SUPPORT_CLEAR_LOCAL_OVERRIDES_IMMEDIATELY, Flags.FLAG_SUPPORT_IMMEDIATE_LOCAL_OVERRIDES, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean bluetoothFlagValueBugFix() {
        return getValue(Flags.FLAG_BLUETOOTH_FLAG_VALUE_BUG_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean enableAconfigStorageDaemon() {
        return getValue(Flags.FLAG_ENABLE_ACONFIG_STORAGE_DAEMON, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean enableAconfigdFromMainline() {
        return getValue(Flags.FLAG_ENABLE_ACONFIGD_FROM_MAINLINE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean enableFullRustSystemAconfigd() {
        return getValue(Flags.FLAG_ENABLE_FULL_RUST_SYSTEM_ACONFIGD, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean supportClearLocalOverridesImmediately() {
        return getValue(Flags.FLAG_SUPPORT_CLEAR_LOCAL_OVERRIDES_IMMEDIATELY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.aconfig_new_storage.FeatureFlags
    public boolean supportImmediateLocalOverrides() {
        return getValue(Flags.FLAG_SUPPORT_IMMEDIATE_LOCAL_OVERRIDES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
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
        return Arrays.asList(new String[]{Flags.FLAG_BLUETOOTH_FLAG_VALUE_BUG_FIX, Flags.FLAG_ENABLE_ACONFIG_STORAGE_DAEMON, Flags.FLAG_ENABLE_ACONFIGD_FROM_MAINLINE, Flags.FLAG_ENABLE_FULL_RUST_SYSTEM_ACONFIGD, Flags.FLAG_SUPPORT_CLEAR_LOCAL_OVERRIDES_IMMEDIATELY, Flags.FLAG_SUPPORT_IMMEDIATE_LOCAL_OVERRIDES});
    }
}
