package com.android.server.powerstats;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ALARM_BASED_POWERSTATS_LOGGING, Flags.FLAG_VERIFY_NON_NULL_ARGUMENTS, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.powerstats.FeatureFlags
    public boolean alarmBasedPowerstatsLogging() {
        return getValue(Flags.FLAG_ALARM_BASED_POWERSTATS_LOGGING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.powerstats.FeatureFlags
    public boolean verifyNonNullArguments() {
        return getValue(Flags.FLAG_VERIFY_NON_NULL_ARGUMENTS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ALARM_BASED_POWERSTATS_LOGGING, Flags.FLAG_VERIFY_NON_NULL_ARGUMENTS});
    }
}
