package com.android.server.biometrics.sensors;

import android.hardware.biometrics.BiometricAuthenticator;

/* JADX INFO: loaded from: classes.dex */
public interface RemovalConsumer {
    void onRemoved(BiometricAuthenticator.Identifier r1, int r2);
}
