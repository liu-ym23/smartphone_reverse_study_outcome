package com.android.server.biometrics.sensors;

import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.IBiometricSensorReceiver;
import android.hardware.face.Face;
import android.hardware.face.FaceAuthenticationFrame;
import android.hardware.face.FaceEnrollFrame;
import android.hardware.face.IFaceServiceReceiver;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.IFingerprintServiceReceiver;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class ClientMonitorCallbackConverter {
    private final IFaceServiceReceiver mFaceServiceReceiver;
    private final IFingerprintServiceReceiver mFingerprintServiceReceiver;
    private final IBiometricSensorReceiver mSensorReceiver;

    public ClientMonitorCallbackConverter(IBiometricSensorReceiver sensorReceiver) {
        this.mSensorReceiver = sensorReceiver;
        this.mFaceServiceReceiver = null;
        this.mFingerprintServiceReceiver = null;
    }

    public ClientMonitorCallbackConverter(IFaceServiceReceiver faceServiceReceiver) {
        this.mSensorReceiver = null;
        this.mFaceServiceReceiver = faceServiceReceiver;
        this.mFingerprintServiceReceiver = null;
    }

    public ClientMonitorCallbackConverter(IFingerprintServiceReceiver fingerprintServiceReceiver) {
        this.mSensorReceiver = null;
        this.mFaceServiceReceiver = null;
        this.mFingerprintServiceReceiver = fingerprintServiceReceiver;
    }

    public int getModality() {
        if (this.mFaceServiceReceiver == null) goto L7;
        return 8;
    L7:
        if (this.mFingerprintServiceReceiver == null) goto L10;
        return 2;
    L10:
        return 0;
    }

    public void onAcquired(int sensorId, int acquiredInfo, int vendorCode) throws RemoteException {
        if (this.mSensorReceiver == null) goto L6;
        this.mSensorReceiver.onAcquired(sensorId, acquiredInfo, vendorCode);
        return;
    L6:
        if (this.mFaceServiceReceiver == null) goto L9;
        this.mFaceServiceReceiver.onAcquired(acquiredInfo, vendorCode);
        return;
    L9:
        if (this.mFingerprintServiceReceiver == null) goto L14;
        this.mFingerprintServiceReceiver.onAcquiredClient(sensorId, acquiredInfo, vendorCode);
        return;
    }

    void onAuthenticationSucceeded(int sensorId, BiometricAuthenticator.Identifier identifier, byte[] token, int userId, boolean isStrongBiometric) throws RemoteException {
        if (this.mSensorReceiver == null) goto L6;
        this.mSensorReceiver.onAuthenticationSucceeded(sensorId, token);
        return;
    L6:
        if (this.mFaceServiceReceiver == null) goto L9;
        this.mFaceServiceReceiver.onAuthenticationSucceeded((Face) identifier, userId, isStrongBiometric);
        return;
    L9:
        if (this.mFingerprintServiceReceiver == null) goto L14;
        this.mFingerprintServiceReceiver.onAuthenticationSucceeded((Fingerprint) identifier, userId, isStrongBiometric);
        return;
    }

    void onAuthenticationFailed(int sensorId) throws RemoteException {
        if (this.mSensorReceiver == null) goto L6;
        this.mSensorReceiver.onAuthenticationFailed(sensorId);
        return;
    L6:
        if (this.mFaceServiceReceiver == null) goto L9;
        this.mFaceServiceReceiver.onAuthenticationFailed();
        return;
    L9:
        if (this.mFingerprintServiceReceiver == null) goto L14;
        this.mFingerprintServiceReceiver.onAuthenticationFailed();
        return;
    }

    public void onError(int sensorId, int cookie, int error, int vendorCode) throws RemoteException {
        if (this.mSensorReceiver == null) goto L6;
        this.mSensorReceiver.onError(sensorId, cookie, error, vendorCode);
        return;
    L6:
        if (this.mFaceServiceReceiver == null) goto L9;
        this.mFaceServiceReceiver.onError(error, vendorCode);
        return;
    L9:
        if (this.mFingerprintServiceReceiver == null) goto L14;
        this.mFingerprintServiceReceiver.onErrorClient(sensorId, error, vendorCode);
        return;
    }

    public void onDetected(int sensorId, int userId, boolean isStrongBiometric) throws RemoteException {
        if (this.mFaceServiceReceiver == null) goto L6;
        this.mFaceServiceReceiver.onFaceDetected(sensorId, userId, isStrongBiometric);
        return;
    L6:
        if (this.mFingerprintServiceReceiver == null) goto L10;
        this.mFingerprintServiceReceiver.onFingerprintDetected(sensorId, userId, isStrongBiometric);
        return;
    }

    void onEnrollResult(BiometricAuthenticator.Identifier identifier, int remaining) throws RemoteException {
        if (this.mFaceServiceReceiver == null) goto L6;
        this.mFaceServiceReceiver.onEnrollResult((Face) identifier, remaining);
        return;
    L6:
        if (this.mFingerprintServiceReceiver == null) goto L10;
        this.mFingerprintServiceReceiver.onEnrollResult((Fingerprint) identifier, remaining);
        return;
    }

    public void onRemoved(BiometricAuthenticator.Identifier identifier, int remaining) throws RemoteException {
        if (this.mFaceServiceReceiver == null) goto L6;
        this.mFaceServiceReceiver.onRemoved((Face) identifier, remaining);
        return;
    L6:
        if (this.mFingerprintServiceReceiver == null) goto L10;
        this.mFingerprintServiceReceiver.onRemoved((Fingerprint) identifier, remaining);
        return;
    }

    public void onChallengeGenerated(int sensorId, int userId, long challenge) throws RemoteException {
        if (this.mFaceServiceReceiver == null) goto L6;
        this.mFaceServiceReceiver.onChallengeGenerated(sensorId, userId, challenge);
        return;
    L6:
        if (this.mFingerprintServiceReceiver == null) goto L10;
        this.mFingerprintServiceReceiver.onChallengeGenerated(sensorId, userId, challenge);
        return;
    }

    public void onFeatureSet(boolean success, int feature) throws RemoteException {
        if (this.mFaceServiceReceiver == null) goto L6;
        this.mFaceServiceReceiver.onFeatureSet(success, feature);
        return;
    }

    public void onFeatureGet(boolean success, int[] features, boolean[] featureState) throws RemoteException {
        if (this.mFaceServiceReceiver == null) goto L6;
        this.mFaceServiceReceiver.onFeatureGet(success, features, featureState);
        return;
    }

    public void onUdfpsPointerDown(int sensorId) throws RemoteException {
        if (this.mFingerprintServiceReceiver == null) goto L6;
        this.mFingerprintServiceReceiver.onUdfpsPointerDown(sensorId);
        return;
    }

    public void onUdfpsPointerUp(int sensorId) throws RemoteException {
        if (this.mFingerprintServiceReceiver == null) goto L6;
        this.mFingerprintServiceReceiver.onUdfpsPointerUp(sensorId);
        return;
    }

    public void onUdfpsOverlayShown() throws RemoteException {
        if (this.mFingerprintServiceReceiver == null) goto L6;
        this.mFingerprintServiceReceiver.onUdfpsOverlayShown();
        return;
    }

    public void onAuthenticationFrame(FaceAuthenticationFrame frame) throws RemoteException {
        if (this.mFaceServiceReceiver == null) goto L6;
        this.mFaceServiceReceiver.onAuthenticationFrame(frame);
        return;
    }

    public void onEnrollmentFrame(FaceEnrollFrame frame) throws RemoteException {
        if (this.mFaceServiceReceiver == null) goto L6;
        this.mFaceServiceReceiver.onEnrollmentFrame(frame);
        return;
    }
}
