package android.uprobestats.flags;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ENABLE_UPROBESTATS, Flags.FLAG_EXECUTABLE_METHOD_FILE_OFFSETS, Flags.FLAG_UPROBESTATS_SUPPORT_UPDATE_DEVICE_IDLE_TEMP_ALLOWLIST, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // android.uprobestats.flags.FeatureFlags
    public boolean enableUprobestats() {
        return getValue(Flags.FLAG_ENABLE_UPROBESTATS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // android.uprobestats.flags.FeatureFlags
    public boolean executableMethodFileOffsets() {
        return getValue(Flags.FLAG_EXECUTABLE_METHOD_FILE_OFFSETS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // android.uprobestats.flags.FeatureFlags
    public boolean uprobestatsSupportUpdateDeviceIdleTempAllowlist() {
        return getValue(Flags.FLAG_UPROBESTATS_SUPPORT_UPDATE_DEVICE_IDLE_TEMP_ALLOWLIST, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ENABLE_UPROBESTATS, Flags.FLAG_EXECUTABLE_METHOD_FILE_OFFSETS, Flags.FLAG_UPROBESTATS_SUPPORT_UPDATE_DEVICE_IDLE_TEMP_ALLOWLIST});
    }
}
