package com.android.server.power.hint;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ADPF_SESSION_TAG, Flags.FLAG_CPU_HEADROOM_AFFINITY_CHECK, Flags.FLAG_POWERHINT_THREAD_CLEANUP, Flags.FLAG_RESET_ON_FORK_ENABLED, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.power.hint.FeatureFlags
    public boolean adpfSessionTag() {
        return getValue(Flags.FLAG_ADPF_SESSION_TAG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.power.hint.FeatureFlags
    public boolean cpuHeadroomAffinityCheck() {
        return getValue(Flags.FLAG_CPU_HEADROOM_AFFINITY_CHECK, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.power.hint.FeatureFlags
    public boolean powerhintThreadCleanup() {
        return getValue(Flags.FLAG_POWERHINT_THREAD_CLEANUP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.power.hint.FeatureFlags
    public boolean resetOnForkEnabled() {
        return getValue(Flags.FLAG_RESET_ON_FORK_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ADPF_SESSION_TAG, Flags.FLAG_CPU_HEADROOM_AFFINITY_CHECK, Flags.FLAG_POWERHINT_THREAD_CLEANUP, Flags.FLAG_RESET_ON_FORK_ENABLED});
    }
}
