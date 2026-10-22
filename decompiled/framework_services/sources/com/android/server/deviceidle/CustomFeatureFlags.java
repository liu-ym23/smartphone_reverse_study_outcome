package com.android.server.deviceidle;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_DISABLE_WAKELOCKS_IN_LIGHT_IDLE, Flags.FLAG_REMOVE_IDLE_LOCATION, Flags.FLAG_USE_CPU_TIME_FOR_TEMP_ALLOWLIST, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.deviceidle.FeatureFlags
    public boolean disableWakelocksInLightIdle() {
        return getValue(Flags.FLAG_DISABLE_WAKELOCKS_IN_LIGHT_IDLE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.deviceidle.FeatureFlags
    public boolean removeIdleLocation() {
        return getValue(Flags.FLAG_REMOVE_IDLE_LOCATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.deviceidle.FeatureFlags
    public boolean useCpuTimeForTempAllowlist() {
        return getValue(Flags.FLAG_USE_CPU_TIME_FOR_TEMP_ALLOWLIST, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_DISABLE_WAKELOCKS_IN_LIGHT_IDLE, Flags.FLAG_REMOVE_IDLE_LOCATION, Flags.FLAG_USE_CPU_TIME_FOR_TEMP_ALLOWLIST});
    }
}
