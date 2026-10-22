package com.android.server.biometrics.sensors.face.hidl;

import android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.sensors.face.aidl.AidlResponseHandler;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class HidlToAidlCallbackConverter extends IBiometricsFaceClientCallback.Stub {
    private final AidlResponseHandler mAidlResponseHandler;

    public HidlToAidlCallbackConverter(AidlResponseHandler aidlResponseHandler) {
        this.mAidlResponseHandler = aidlResponseHandler;
    }

    @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
    public void onEnrollResult(long deviceId, int faceId, int userId, int remaining) {
        this.mAidlResponseHandler.onEnrollmentProgress(faceId, remaining);
    }

    @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
    public void onAuthenticated(long deviceId, int faceId, int userId, ArrayList<Byte> token) {
        if (faceId == 0) goto L4;
        boolean authenticated = true;
    L5:
        byte[] hardwareAuthToken = new byte[token.size()];
        int i = 0;
    L7:
        if (i >= token.size()) goto L10;
        hardwareAuthToken[i] = token.get(i).byteValue();
        i = i + 1;
        goto L7
    L10:
        if (authenticated == false) goto L12;
        this.mAidlResponseHandler.onAuthenticationSucceeded(faceId, HardwareAuthTokenUtils.toHardwareAuthToken(hardwareAuthToken));
        return;
    L12:
        this.mAidlResponseHandler.onAuthenticationFailed();
        return;
    L4:
        authenticated = false;
        goto L5
    }

    @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
    public void onAcquired(long deviceId, int userId, int acquiredInfo, int vendorCode) {
        this.mAidlResponseHandler.onAcquired(acquiredInfo, vendorCode);
    }

    @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
    public void onError(long deviceId, int userId, int error, int vendorCode) {
        this.mAidlResponseHandler.onError(error, vendorCode);
    }

    @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
    public void onRemoved(long deviceId, ArrayList<Integer> removed, int userId) {
        int[] enrollmentIds = new int[removed.size()];
        int i = 0;
    L4:
        if (i >= removed.size()) goto L6;
        enrollmentIds[i] = removed.get(i).intValue();
        i = i + 1;
        goto L4
    L6:
        this.mAidlResponseHandler.onEnrollmentsRemoved(enrollmentIds);
    }

    @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
    public void onEnumerate(long deviceId, ArrayList<Integer> faceIds, int userId) {
        int[] enrollmentIds = new int[faceIds.size()];
        int i = 0;
    L4:
        if (i >= faceIds.size()) goto L6;
        enrollmentIds[i] = faceIds.get(i).intValue();
        i = i + 1;
        goto L4
    L6:
        this.mAidlResponseHandler.onEnrollmentsEnumerated(enrollmentIds);
    }

    @Override // android.hardware.biometrics.face.V1_0.IBiometricsFaceClientCallback
    public void onLockoutChanged(long duration) {
        this.mAidlResponseHandler.onLockoutChanged(duration);
    }

    void onChallengeGenerated(long challenge) {
        this.mAidlResponseHandler.onChallengeGenerated(challenge);
    }

    void onChallengeRevoked(long challenge) {
        this.mAidlResponseHandler.onChallengeRevoked(challenge);
    }

    void onFeatureGet(byte[] features) {
        this.mAidlResponseHandler.onFeaturesRetrieved(features);
    }

    void onFeatureSet(byte feature) {
        this.mAidlResponseHandler.onFeatureSet(feature);
    }

    void onAuthenticatorIdRetrieved(long authenticatorId) {
        this.mAidlResponseHandler.onAuthenticatorIdRetrieved(authenticatorId);
    }

    void onUnsupportedClientScheduled() {
        this.mAidlResponseHandler.onUnsupportedClientScheduled();
    }
}
