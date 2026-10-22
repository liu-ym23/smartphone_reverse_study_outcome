package android.internal.os.profiling;

import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private Map<String, Integer> mFinalizedFlags;
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{""}));
        this.mFinalizedFlags = new HashMap(Map.ofEntries(new Map.Entry[]{Map.entry(Flags.FLAG_REDACTION_ENABLED, 35), Map.entry(Flags.FLAG_TELEMETRY_APIS, 35), Map.entry("", Integer.MAX_VALUE)}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // android.internal.os.profiling.FeatureFlags
    public boolean persistQueue() {
        return getValue(Flags.FLAG_PERSIST_QUEUE, new CustomFeatureFlags$$ExternalSyntheticLambda3());
    }

    @Override // android.internal.os.profiling.FeatureFlags
    public boolean redactionEnabled() {
        return getValue(Flags.FLAG_REDACTION_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // android.internal.os.profiling.FeatureFlags
    public boolean systemTriggeredProfilingNew() {
        return getValue(Flags.FLAG_SYSTEM_TRIGGERED_PROFILING_NEW, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // android.internal.os.profiling.FeatureFlags
    public boolean telemetryApis() {
        return getValue(Flags.FLAG_TELEMETRY_APIS, new CustomFeatureFlags$$ExternalSyntheticLambda2());
    }

    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        return this.mGetValueImpl.test(flagName, getter);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_PERSIST_QUEUE, Flags.FLAG_REDACTION_ENABLED, Flags.FLAG_SYSTEM_TRIGGERED_PROFILING_NEW, Flags.FLAG_TELEMETRY_APIS});
    }

    public boolean isFlagFinalized(String flagName) {
        if (this.mFinalizedFlags.containsKey(flagName) == true) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < this.mFinalizedFlags.get(flagName).intValue()) goto L9;
        return true;
    L9:
        return false;
    }
}
