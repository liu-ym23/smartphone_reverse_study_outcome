package com.android.server.power.batterysaver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class FakeFeatureFlagsImpl extends CustomFeatureFlags {
    private final FeatureFlags mDefaults;
    private final Map<String, Boolean> mFlagMap;

    public FakeFeatureFlagsImpl() {
        this(null);
    }

    public FakeFeatureFlagsImpl(FeatureFlags defaults) {
        super(null);
        this.mFlagMap = new HashMap();
        this.mDefaults = defaults;
        Iterator<String> r1 = getFlagNames().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String flagName = r1.next();
        this.mFlagMap.put(flagName, null);
        goto L4
    }

    @Override // com.android.server.power.batterysaver.CustomFeatureFlags
    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        Boolean value = this.mFlagMap.get(flagName);
        if (value == null) goto L7;
        return value.booleanValue();
    L7:
        if (this.mDefaults == null) goto L11;
        return getter.test(this.mDefaults);
    L11:
        throw new IllegalArgumentException(flagName + " is not set");
    }

    public void setFlag(String flagName, boolean value) {
        if (this.mFlagMap.containsKey(flagName) == false) goto L7;
        this.mFlagMap.put(flagName, Boolean.valueOf(value));
        return;
    L7:
        throw new IllegalArgumentException("no such flag " + flagName);
    }

    public void resetAll() {
        Iterator<Map.Entry<String, Boolean>> r0 = this.mFlagMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setValue(null);
        goto L4
    }
}
