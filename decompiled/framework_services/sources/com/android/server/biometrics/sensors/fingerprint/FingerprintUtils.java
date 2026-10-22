package com.android.server.biometrics.sensors.fingerprint;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.fingerprint.Fingerprint;
import android.text.TextUtils;
import android.util.SparseArray;
import com.android.server.biometrics.sensors.BiometricUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintUtils implements BiometricUtils<Fingerprint> {
    private static final String LEGACY_FINGERPRINT_FILE = "settings_fingerprint.xml";
    private static final Object sInstanceLock = null;
    private static SparseArray<FingerprintUtils> sInstances;
    private final String mFileName;
    private final SparseArray<FingerprintUserState> mUserStates;

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public /* bridge */ /* synthetic */ void addBiometricForUser(Context r1, int r2, BiometricAuthenticator.Identifier r3) {
        addBiometricForUser(r1, r2, (Fingerprint) r3);
    }

    static {
        sInstanceLock = new Object();
    }

    public static FingerprintUtils getInstance(int sensorId) {
        return getInstance(sensorId, null);
    }

    private static FingerprintUtils getInstance(int sensorId, String fileName) {
        Object r0 = sInstanceLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstances != null) goto L10;
        sInstances = new SparseArray();     // Catch: Throwable -> L7
    L10:
        if (sInstances.get(sensorId) != null) goto L14;
        if (fileName != null) goto L13;
        fileName = "settings_fingerprint_" + sensorId + ".xml";     // Catch: Throwable -> L7
    L13:
        sInstances.put(sensorId, new FingerprintUtils(fileName));     // Catch: Throwable -> L7
    L14:
        FingerprintUtils utils = sInstances.get(sensorId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return utils;
    }

    public static FingerprintUtils getLegacyInstance(int sensorId) {
        return getInstance(sensorId, LEGACY_FINGERPRINT_FILE);
    }

    private FingerprintUtils(String fileName) {
        this.mUserStates = new SparseArray();
        this.mFileName = fileName;
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public List<Fingerprint> getBiometricsForUser(Context ctx, int userId) {
        return getStateForUser(ctx, userId).getBiometrics();
    }

    public void addBiometricForUser(Context context, int userId, Fingerprint fingerprint) {
        getStateForUser(context, userId).addBiometric(fingerprint);
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public void removeBiometricForUser(Context context, int userId, int fingerId) {
        getStateForUser(context, userId).removeBiometric(fingerId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public void renameBiometricForUser(Context context, int userId, int fingerId, CharSequence name) {
        if (TextUtils.isEmpty(name) == false) goto L5;
        return;
    L5:
        getStateForUser(context, userId).renameBiometric(fingerId, name);
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public CharSequence getUniqueName(Context context, int userId) {
        return getStateForUser(context, userId).getUniqueName();
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public void setInvalidationInProgress(Context context, int userId, boolean inProgress) {
        getStateForUser(context, userId).setInvalidationInProgress(inProgress);
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public boolean isInvalidationInProgress(Context context, int userId) {
        return getStateForUser(context, userId).isInvalidationInProgress();
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public boolean hasValidBiometricUserState(Context context, int userId) {
        return getStateForUser(context, userId).isInvalidBiometricState();
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public void deleteStateForUser(int userId) {
        monitor-enter(this);
        FingerprintUserState state = this.mUserStates.get(userId);     // Catch: Throwable -> L6
        if (state == null) goto L8;
        state.deleteBiometricFile();     // Catch: Throwable -> L6
        this.mUserStates.delete(userId);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private FingerprintUserState getStateForUser(Context ctx, int userId) {
        monitor-enter(this);
        FingerprintUserState state = this.mUserStates.get(userId);     // Catch: Throwable -> L6
        if (state != null) goto L8;
        state = new FingerprintUserState(ctx, userId, this.mFileName);     // Catch: Throwable -> L6
        this.mUserStates.put(userId, state);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return state;
    L6:
        th = move-exception;
        throw th;
    }

    public static boolean isKnownErrorCode(int errorCode) {
        switch(errorCode) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public static boolean isKnownAcquiredCode(int acquiredCode) {
        switch(acquiredCode) {
            case 0: goto L5;
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L3;
            case 9: goto L5;
            case 10: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }
}
