package com.android.server.biometrics.sensors.fingerprint.hidl;

import android.content.Context;
import android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprintClientCallback;
import android.hardware.biometrics.fingerprint.V2_3.IBiometricsFingerprint;
import android.hardware.fingerprint.Fingerprint;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.sensors.fingerprint.FingerprintUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TestHal extends IBiometricsFingerprint.Stub {
    private static final String TAG = "fingerprint.hidl.TestHal";
    private IBiometricsFingerprintClientCallback mCallback;
    private final Context mContext;
    private final int mSensorId;

    TestHal(Context context, int sensorId) {
        this.mContext = context;
        this.mSensorId = sensorId;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_3.IBiometricsFingerprint
    public boolean isUdfps(int sensorId) {
        return false;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_3.IBiometricsFingerprint
    public void onFingerDown(int x, int y, float minor, float major) {
    }

    @Override // android.hardware.biometrics.fingerprint.V2_3.IBiometricsFingerprint
    public void onFingerUp() {
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public long setNotify(IBiometricsFingerprintClientCallback clientCallback) {
        this.mCallback = clientCallback;
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public long preEnroll() {
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public int enroll(byte[] hat, int gid, int timeoutSec) {
        Slog.w(TAG, "enroll");
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public int postEnroll() {
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public long getAuthenticatorId() {
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public int cancel() throws RemoteException {
        if (this.mCallback == null) goto L5;
        this.mCallback.onError(0, 5, 0);
    L5:
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public int enumerate() throws RemoteException {
        Slog.w(TAG, "Enumerate");
        if (this.mCallback == null) goto L7;
        this.mCallback.onEnumerate(0, 0, 0, 0);
        return 0;
    L7:
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public int remove(int gid, int fid) throws RemoteException {
        Slog.w(TAG, "Remove");
        if (this.mCallback == null) goto L14;
        if (fid != 0) goto L10;
        List<Fingerprint> fingerprints = FingerprintUtils.getInstance(this.mSensorId).getBiometricsForUser(this.mContext, gid);
        int i = 0;
    L7:
        if (i >= fingerprints.size()) goto L15;
        Fingerprint fp = fingerprints.get(i);
        this.mCallback.onRemoved(0, fp.getBiometricId(), gid, (fingerprints.size() - i) - 1);
        i = i + 1;
        goto L7
    L15:
        return 0;
    L10:
        this.mCallback.onRemoved(0, fid, gid, 0);
        return 0;
    L14:
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public int setActiveGroup(int gid, String storePath) {
        return 0;
    }

    @Override // android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint
    public int authenticate(long operationId, int gid) {
        Slog.w(TAG, "Authenticate");
        return 0;
    }
}
