package com.android.server.alarm;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ACQUIRE_WAKELOCK_BEFORE_SEND, Flags.FLAG_START_USER_BEFORE_SCHEDULED_ALARMS, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.alarm.FeatureFlags
    public boolean acquireWakelockBeforeSend() {
        return getValue(Flags.FLAG_ACQUIRE_WAKELOCK_BEFORE_SEND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.alarm.FeatureFlags
    public boolean startUserBeforeScheduledAlarms() {
        return getValue(Flags.FLAG_START_USER_BEFORE_SCHEDULED_ALARMS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ACQUIRE_WAKELOCK_BEFORE_SEND, Flags.FLAG_START_USER_BEFORE_SCHEDULED_ALARMS});
    }
}
