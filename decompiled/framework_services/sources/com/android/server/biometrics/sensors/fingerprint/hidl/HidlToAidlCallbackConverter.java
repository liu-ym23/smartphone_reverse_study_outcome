package com.android.server.biometrics.sensors.fingerprint.hidl;

import android.hardware.biometrics.fingerprint.V2_2.IBiometricsFingerprintClientCallback;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.sensors.BaseClientMonitor;
import com.android.server.biometrics.sensors.fingerprint.aidl.AidlResponseHandler;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class HidlToAidlCallbackConverter extends IBiometricsFingerprintClientCallback.Stub {
    final AidlResponseHandler mAidlResponseHandler;

    public HidlToAidlCallbackConverter(AidlResponseHandler aidlResponseHandler) {
        this.mAidlResponseHandler = aidlResponseHandler;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprintClientCallback
    public void onEnrollResult(long deviceId, int fingerId, int groupId, int remaining) {
        this.mAidlResponseHandler.onEnrollmentProgress(fingerId, remaining);
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprintClientCallback
    public void onAcquired(long deviceId, int acquiredInfo, int vendorCode) {
        onAcquired_2_2(deviceId, acquiredInfo, vendorCode);
    }

    @Override // android.hardware.biometrics.fingerprint.V2_2.IBiometricsFingerprintClientCallback
    public void onAcquired_2_2(long deviceId, int acquiredInfo, int vendorCode) {
        this.mAidlResponseHandler.onAcquired(acquiredInfo, vendorCode);
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprintClientCallback
    public void onAuthenticated(long deviceId, int fingerId, int groupId, ArrayList<Byte> token) {
        if (fingerId == 0) goto L8;
        byte[] hardwareAuthToken = new byte[token.size()];
        int i = 0;
    L5:
        if (i >= token.size()) goto L7;
        hardwareAuthToken[i] = token.get(i).byteValue();
        i = i + 1;
        goto L5
    L7:
        this.mAidlResponseHandler.onAuthenticationSucceeded(fingerId, HardwareAuthTokenUtils.toHardwareAuthToken(hardwareAuthToken));
        return;
    L8:
        this.mAidlResponseHandler.onAuthenticationFailed();
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprintClientCallback
    public void onError(long deviceId, int error, int vendorCode) {
        this.mAidlResponseHandler.onError(error, vendorCode);
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprintClientCallback
    public void onRemoved(long deviceId, int fingerId, int groupId, int remaining) {
        this.mAidlResponseHandler.onEnrollmentRemoved(fingerId, remaining);
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprintClientCallback
    public void onEnumerate(long deviceId, int fingerId, int groupId, int remaining) {
        this.mAidlResponseHandler.onEnrollmentEnumerated(fingerId, remaining);
    }

    void onChallengeGenerated(long challenge) {
        this.mAidlResponseHandler.onChallengeGenerated(challenge);
    }

    void onChallengeRevoked(long challenge) {
        this.mAidlResponseHandler.onChallengeRevoked(challenge);
    }

    void onResetLockout() {
        this.mAidlResponseHandler.onLockoutCleared();
    }

    <T extends BaseClientMonitor> void unsupportedClientScheduled(Class<T> className) {
        this.mAidlResponseHandler.onUnsupportedClientScheduled(className);
    }
}
