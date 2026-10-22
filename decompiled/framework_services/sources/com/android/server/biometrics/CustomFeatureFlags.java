package com.android.server.biometrics;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_FACE_VHAL_FEATURE, Flags.FLAG_FRR_DIALOG_IMPROVEMENT, Flags.FLAG_NOTIFY_FINGERPRINTS_LOE, Flags.FLAG_SET_IGNORE_SPEED_UP, Flags.FLAG_USE_VHAL_FOR_TESTING, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean faceVhalFeature() {
        return getValue(Flags.FLAG_FACE_VHAL_FEATURE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean frrDialogImprovement() {
        return getValue(Flags.FLAG_FRR_DIALOG_IMPROVEMENT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean notifyFingerprintsLoe() {
        return getValue(Flags.FLAG_NOTIFY_FINGERPRINTS_LOE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean setIgnoreSpeedUp() {
        return getValue(Flags.FLAG_SET_IGNORE_SPEED_UP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.biometrics.FeatureFlags
    public boolean useVhalForTesting() {
        return getValue(Flags.FLAG_USE_VHAL_FOR_TESTING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
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
        return Arrays.asList(new String[]{Flags.FLAG_FACE_VHAL_FEATURE, Flags.FLAG_FRR_DIALOG_IMPROVEMENT, Flags.FLAG_NOTIFY_FINGERPRINTS_LOE, Flags.FLAG_SET_IGNORE_SPEED_UP, Flags.FLAG_USE_VHAL_FOR_TESTING});
    }
}
