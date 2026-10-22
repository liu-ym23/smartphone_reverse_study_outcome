package android.uprobestats.flags;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    public FeatureFlagsImpl() {
    }

    @Override // android.uprobestats.flags.FeatureFlags
    public boolean enableUprobestats() {
        return false;
    }

    @Override // android.uprobestats.flags.FeatureFlags
    public boolean executableMethodFileOffsets() {
        return true;
    }

    @Override // android.uprobestats.flags.FeatureFlags
    public boolean uprobestatsSupportUpdateDeviceIdleTempAllowlist() {
        return false;
    }
}
