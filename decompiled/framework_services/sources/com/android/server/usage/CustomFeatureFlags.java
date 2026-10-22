package com.android.server.usage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ADJUST_DEFAULT_BUCKET_ELEVATION_PARAMS, Flags.FLAG_AVOID_IDLE_CHECK, Flags.FLAG_PERSIST_RESTORE_TO_RARE_APPS_LIST, Flags.FLAG_SCREEN_TIME_BYPASS, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.usage.FeatureFlags
    public boolean adjustDefaultBucketElevationParams() {
        return getValue(Flags.FLAG_ADJUST_DEFAULT_BUCKET_ELEVATION_PARAMS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.usage.FeatureFlags
    public boolean avoidIdleCheck() {
        return getValue(Flags.FLAG_AVOID_IDLE_CHECK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.usage.FeatureFlags
    public boolean persistRestoreToRareAppsList() {
        return getValue(Flags.FLAG_PERSIST_RESTORE_TO_RARE_APPS_LIST, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.usage.FeatureFlags
    public boolean screenTimeBypass() {
        return getValue(Flags.FLAG_SCREEN_TIME_BYPASS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ADJUST_DEFAULT_BUCKET_ELEVATION_PARAMS, Flags.FLAG_AVOID_IDLE_CHECK, Flags.FLAG_PERSIST_RESTORE_TO_RARE_APPS_LIST, Flags.FLAG_SCREEN_TIME_BYPASS});
    }
}
