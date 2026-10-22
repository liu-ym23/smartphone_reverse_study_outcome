package com.android.server.os;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ASYNC_START_BUGREPORT, Flags.FLAG_PROTO_TOMBSTONE, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.os.FeatureFlags
    public boolean asyncStartBugreport() {
        return getValue(Flags.FLAG_ASYNC_START_BUGREPORT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.os.FeatureFlags
    public boolean protoTombstone() {
        return getValue(Flags.FLAG_PROTO_TOMBSTONE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ASYNC_START_BUGREPORT, Flags.FLAG_PROTO_TOMBSTONE});
    }
}
