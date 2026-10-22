package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricAuthenticator.Identifier;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface BiometricUtils<T extends BiometricAuthenticator.Identifier> {
    void addBiometricForUser(Context r1, int r2, T r3);

    void deleteStateForUser(int r1);

    List<T> getBiometricsForUser(Context r1, int r2);

    CharSequence getUniqueName(Context r1, int r2);

    boolean hasValidBiometricUserState(Context r1, int r2);

    boolean isInvalidationInProgress(Context r1, int r2);

    void removeBiometricForUser(Context r1, int r2, int r3);

    void renameBiometricForUser(Context r1, int r2, int r3, CharSequence r4);

    void setInvalidationInProgress(Context r1, int r2, boolean r3);
}
