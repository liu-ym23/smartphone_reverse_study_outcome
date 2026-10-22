package com.android.server.biometrics;

/* JADX INFO: loaded from: classes.dex */
public interface FeatureFlags {
    boolean faceVhalFeature();

    boolean frrDialogImprovement();

    boolean notifyFingerprintsLoe();

    boolean setIgnoreSpeedUp();

    boolean useVhalForTesting();
}
