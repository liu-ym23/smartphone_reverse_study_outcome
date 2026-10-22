package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.fingerprint.virtualhal.AcquiredInfoAndVendorCode;
import android.hardware.biometrics.fingerprint.virtualhal.EnrollmentProgressStep;
import android.hardware.biometrics.fingerprint.virtualhal.NextEnrollment;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintEnrollOptions;
import android.hardware.fingerprint.IFingerprintServiceReceiver;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.sensors.BiometricStateCallback;
import com.android.server.biometrics.sensors.fingerprint.FingerprintUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class BiometricTestSessionImpl extends ITestSession.Stub {
    private static final String TAG = "fp/aidl/BiometricTestSessionImpl";
    private static final int VHAL_ENROLLMENT_ID = 9999;
    private final BiometricStateCallback mBiometricStateCallback;
    private final ITestSessionCallback mCallback;
    private final Context mContext;
    private final Set<Integer> mEnrollmentIds;
    private final FingerprintProvider mProvider;
    private final Random mRandom;
    private final IFingerprintServiceReceiver mReceiver;
    private final Sensor mSensor;
    private final int mSensorId;

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITestSessionCallback m2708$$Nest$fgetmCallback(BiometricTestSessionImpl r0) {
        return r0.mCallback;
    }

    BiometricTestSessionImpl(Context context, int sensorId, ITestSessionCallback callback, BiometricStateCallback biometricStateCallback, FingerprintProvider provider, Sensor sensor) {
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = context;
        this.mSensorId = sensorId;
        this.mCallback = callback;
        this.mBiometricStateCallback = biometricStateCallback;
        this.mProvider = provider;
        this.mSensor = sensor;
        this.mEnrollmentIds = new HashSet();
        this.mRandom = new Random();
    }

    public void setTestHalEnabled(boolean enabled) {
        super.setTestHalEnabled_enforcePermission();
        this.mSensor.setTestHalEnabled(enabled);
        this.mProvider.setTestHalEnabled(enabled);
    }

    public void startEnroll(int userId) {
        super.startEnroll_enforcePermission();
        this.mProvider.scheduleEnroll(this.mSensorId, new Binder(), new byte[69], userId, this.mReceiver, this.mContext.getOpPackageName(), 2, new FingerprintEnrollOptions.Builder().build());
    }

    public void finishEnroll(int userId) throws RemoteException {
        super.finishEnroll_enforcePermission();
        Slog.i(TAG, "finishEnroll(): useVhalForTesting=" + this.mProvider.useVhalForTesting());
        if (this.mProvider.useVhalForTesting() == false) goto L6;
        AcquiredInfoAndVendorCode[] acquiredInfoAndVendorCodes = {new AcquiredInfoAndVendorCode()};
        EnrollmentProgressStep[] enrollmentProgressSteps = {new EnrollmentProgressStep(), new EnrollmentProgressStep()};
        enrollmentProgressSteps[0].durationMs = 100;
        enrollmentProgressSteps[0].acquiredInfoAndVendorCodes = acquiredInfoAndVendorCodes;
        enrollmentProgressSteps[1].durationMs = 200;
        enrollmentProgressSteps[1].acquiredInfoAndVendorCodes = acquiredInfoAndVendorCodes;
        NextEnrollment nextEnrollment = new NextEnrollment();
        nextEnrollment.id = VHAL_ENROLLMENT_ID;
        nextEnrollment.progressSteps = enrollmentProgressSteps;
        nextEnrollment.result = true;
        this.mProvider.getVhal().setNextEnrollment(nextEnrollment);
        this.mProvider.simulateVhalFingerDown(userId, this.mSensorId);
        return;
    L6:
        int nextRandomId = this.mRandom.nextInt();
    L8:
        if (this.mEnrollmentIds.contains(Integer.valueOf(nextRandomId)) == false) goto L10;
        nextRandomId = this.mRandom.nextInt();
        goto L8
    L10:
        this.mEnrollmentIds.add(Integer.valueOf(nextRandomId));
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onEnrollmentProgress(nextRandomId, 0);
    }

    public void acceptAuthentication(int userId) throws RemoteException {
        super.acceptAuthentication_enforcePermission();
        if (this.mProvider.useVhalForTesting() == false) goto L6;
        this.mProvider.getVhal().setEnrollmentHit(VHAL_ENROLLMENT_ID);
        this.mProvider.simulateVhalFingerDown(userId, this.mSensorId);
        return;
    L6:
        List<Fingerprint> fingerprints = FingerprintUtils.getInstance(this.mSensorId).getBiometricsForUser(this.mContext, userId);
        if (fingerprints.isEmpty() == false) goto L10;
        Slog.w(TAG, "No fingerprints, returning");
        return;
    L10:
        int fid = fingerprints.get(0).getBiometricId();
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onAuthenticationSucceeded(fid, HardwareAuthTokenUtils.toHardwareAuthToken(new byte[69]));
    }

    public void rejectAuthentication(int userId) throws RemoteException {
        super.rejectAuthentication_enforcePermission();
        if (this.mProvider.useVhalForTesting() == false) goto L6;
        this.mProvider.getVhal().setEnrollmentHit(10000);
        this.mProvider.simulateVhalFingerDown(userId, this.mSensorId);
        return;
    L6:
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onAuthenticationFailed();
    }

    public void notifyAcquired(int userId, int acquireInfo) {
        super.notifyAcquired_enforcePermission();
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onAcquired((byte) acquireInfo, 0);
    }

    public void notifyError(int userId, int errorCode) {
        super.notifyError_enforcePermission();
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onError((byte) errorCode, 0);
    }

    public void cleanupInternalState(int userId) throws RemoteException {
        super.cleanupInternalState_enforcePermission();
        Slog.d(TAG, "cleanupInternalState: " + userId);
        if (this.mProvider.useVhalForTesting() == false) goto L5;
        Slog.i(TAG, "cleanup virtualhal configurations");
        this.mProvider.getVhal().resetConfigurations();
    L5:
        this.mProvider.scheduleInternalCleanup(this.mSensorId, userId, new AnonymousClass2(this));
    }

    public int getSensorId() {
        super.getSensorId_enforcePermission();
        return this.mSensorId;
    }
}
