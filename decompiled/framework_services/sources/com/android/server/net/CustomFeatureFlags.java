package com.android.server.net;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_NEVER_APPLY_RULES_TO_CORE_UIDS, Flags.FLAG_USE_DIFFERENT_DELAYS_FOR_BACKGROUND_CHAIN, Flags.FLAG_USE_METERED_FIREWALL_CHAINS, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.net.FeatureFlags
    public boolean neverApplyRulesToCoreUids() {
        return getValue(Flags.FLAG_NEVER_APPLY_RULES_TO_CORE_UIDS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.net.FeatureFlags
    public boolean useDifferentDelaysForBackgroundChain() {
        return getValue(Flags.FLAG_USE_DIFFERENT_DELAYS_FOR_BACKGROUND_CHAIN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.net.FeatureFlags
    public boolean useMeteredFirewallChains() {
        return getValue(Flags.FLAG_USE_METERED_FIREWALL_CHAINS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_NEVER_APPLY_RULES_TO_CORE_UIDS, Flags.FLAG_USE_DIFFERENT_DELAYS_FOR_BACKGROUND_CHAIN, Flags.FLAG_USE_METERED_FIREWALL_CHAINS});
    }
}
