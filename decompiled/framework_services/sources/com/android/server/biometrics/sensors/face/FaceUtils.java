package com.android.server.biometrics.sensors.face;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.face.Face;
import android.text.TextUtils;
import android.util.SparseArray;
import com.android.server.biometrics.sensors.BiometricUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FaceUtils implements BiometricUtils<Face> {
    private static final String LEGACY_FACE_FILE = "settings_face.xml";
    private static final Object sInstanceLock = null;
    private static SparseArray<FaceUtils> sInstances;
    private final String mFileName;
    private final SparseArray<FaceUserState> mUserStates;

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public /* bridge */ /* synthetic */ void addBiometricForUser(Context r1, int r2, BiometricAuthenticator.Identifier r3) {
        addBiometricForUser(r1, r2, (Face) r3);
    }

    static {
        sInstanceLock = new Object();
    }

    public static FaceUtils getInstance(int sensorId) {
        return getInstance(sensorId, null);
    }

    private static FaceUtils getInstance(int sensorId, String fileName) {
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
        fileName = "settings_face_" + sensorId + ".xml";     // Catch: Throwable -> L7
    L13:
        sInstances.put(sensorId, new FaceUtils(fileName));     // Catch: Throwable -> L7
    L14:
        FaceUtils utils = sInstances.get(sensorId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return utils;
    }

    public static FaceUtils getLegacyInstance(int sensorId) {
        return getInstance(sensorId, LEGACY_FACE_FILE);
    }

    private FaceUtils(String fileName) {
        this.mUserStates = new SparseArray();
        this.mFileName = fileName;
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public List<Face> getBiometricsForUser(Context ctx, int userId) {
        return getStateForUser(ctx, userId).getBiometrics();
    }

    public void addBiometricForUser(Context ctx, int userId, Face face) {
        getStateForUser(ctx, userId).addBiometric(face);
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public void removeBiometricForUser(Context ctx, int userId, int faceId) {
        getStateForUser(ctx, userId).removeBiometric(faceId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricUtils
    public void renameBiometricForUser(Context ctx, int userId, int faceId, CharSequence name) {
        if (TextUtils.isEmpty(name) == false) goto L5;
        return;
    L5:
        getStateForUser(ctx, userId).renameBiometric(faceId, name);
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
        FaceUserState state = this.mUserStates.get(userId);     // Catch: Throwable -> L6
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

    private FaceUserState getStateForUser(Context ctx, int userId) {
        monitor-enter(this);
        FaceUserState state = this.mUserStates.get(userId);     // Catch: Throwable -> L6
        if (state != null) goto L8;
        state = new FaceUserState(ctx, userId, this.mFileName);     // Catch: Throwable -> L6
        this.mUserStates.put(userId, state);     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return state;
    L6:
        th = move-exception;
        throw th;
    }
}
