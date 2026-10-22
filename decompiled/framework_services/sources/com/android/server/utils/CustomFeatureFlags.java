package com.android.server.utils;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ANR_TIMER_FREEZER, Flags.FLAG_ANR_TIMER_SERVICE, Flags.FLAG_ANR_TIMER_TRACE, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.utils.FeatureFlags
    public boolean anrTimerFreezer() {
        return getValue(Flags.FLAG_ANR_TIMER_FREEZER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.utils.FeatureFlags
    public boolean anrTimerService() {
        return getValue(Flags.FLAG_ANR_TIMER_SERVICE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.utils.FeatureFlags
    public boolean anrTimerTrace() {
        return getValue(Flags.FLAG_ANR_TIMER_TRACE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
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
        return Arrays.asList(new String[]{Flags.FLAG_ANR_TIMER_FREEZER, Flags.FLAG_ANR_TIMER_SERVICE, Flags.FLAG_ANR_TIMER_TRACE});
    }
}
