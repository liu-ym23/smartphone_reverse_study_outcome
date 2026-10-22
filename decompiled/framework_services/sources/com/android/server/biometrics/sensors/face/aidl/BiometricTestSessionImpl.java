package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.face.AuthenticationFrame;
import android.hardware.biometrics.face.BaseFrame;
import android.hardware.biometrics.face.EnrollmentFrame;
import android.hardware.biometrics.face.virtualhal.AcquiredInfoAndVendorCode;
import android.hardware.biometrics.face.virtualhal.EnrollmentProgressStep;
import android.hardware.biometrics.face.virtualhal.NextEnrollment;
import android.hardware.face.Face;
import android.hardware.face.FaceEnrollOptions;
import android.hardware.face.IFaceServiceReceiver;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.sensors.EnrollClient;
import com.android.server.biometrics.sensors.face.FaceUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BiometricTestSessionImpl extends ITestSession.Stub {
    private static final String TAG = "face/aidl/BiometricTestSessionImpl";
    private static final int VHAL_ENROLLMENT_ID = 9999;
    private final ITestSessionCallback mCallback;
    private final Context mContext;
    private final Set<Integer> mEnrollmentIds;
    private final FaceProvider mProvider;
    private final Random mRandom;
    private final IFaceServiceReceiver mReceiver;
    private final Sensor mSensor;
    private final int mSensorId;

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITestSessionCallback m2659$$Nest$fgetmCallback(BiometricTestSessionImpl r0) {
        return r0.mCallback;
    }

    BiometricTestSessionImpl(Context context, int sensorId, ITestSessionCallback callback, FaceProvider provider, Sensor sensor) {
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = context;
        this.mSensorId = sensorId;
        this.mCallback = callback;
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

    public void startEnroll(int userId) throws RemoteException {
        super.startEnroll_enforcePermission();
        Slog.i(TAG, "startEnroll(): isVhalForTesting=" + this.mProvider.isVhalForTesting());
        if (this.mProvider.isVhalForTesting() == false) goto L5;
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
        this.mProvider.getVhal().setOperationAuthenticateDuration(6000);
    L5:
        this.mProvider.scheduleEnroll(this.mSensorId, new Binder(), new byte[69], userId, this.mReceiver, this.mContext.getOpPackageName(), new int[0], null, false, new FaceEnrollOptions.Builder().build());
    }

    public void finishEnroll(int userId) {
        super.finishEnroll_enforcePermission();
        if (this.mProvider.isVhalForTesting() == false) goto L5;
        return;
    L5:
        int nextRandomId = this.mRandom.nextInt();
    L7:
        if (this.mEnrollmentIds.contains(Integer.valueOf(nextRandomId)) == false) goto L9;
        nextRandomId = this.mRandom.nextInt();
        goto L7
    L9:
        this.mEnrollmentIds.add(Integer.valueOf(nextRandomId));
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onEnrollmentProgress(nextRandomId, 0);
    }

    public void acceptAuthentication(int userId) throws RemoteException {
        super.acceptAuthentication_enforcePermission();
        if (this.mProvider.isVhalForTesting() == false) goto L6;
        this.mProvider.getVhal().setEnrollmentHit(VHAL_ENROLLMENT_ID);
        return;
    L6:
        List<Face> faces = FaceUtils.getInstance(this.mSensorId).getBiometricsForUser(this.mContext, userId);
        if (faces.isEmpty() == false) goto L10;
        Slog.w(TAG, "No faces, returning");
        return;
    L10:
        int fid = faces.get(0).getBiometricId();
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onAuthenticationSucceeded(fid, HardwareAuthTokenUtils.toHardwareAuthToken(new byte[69]));
    }

    public void rejectAuthentication(int userId) throws RemoteException {
        super.rejectAuthentication_enforcePermission();
        if (this.mProvider.isVhalForTesting() == false) goto L6;
        this.mProvider.getVhal().setEnrollmentHit(10000);
        return;
    L6:
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onAuthenticationFailed();
    }

    public void notifyAcquired(int userId, int acquireInfo) {
        super.notifyAcquired_enforcePermission();
        BaseFrame data = new BaseFrame();
        data.acquiredInfo = (byte) acquireInfo;
        if ((this.mSensor.getScheduler().getCurrentClient() instanceof EnrollClient) == false) goto L5;
        EnrollmentFrame frame = new EnrollmentFrame();
        frame.data = data;
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onEnrollmentFrame(frame);
        return;
    L5:
        AuthenticationFrame frame2 = new AuthenticationFrame();
        frame2.data = data;
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onAuthenticationFrame(frame2);
    }

    public void notifyError(int userId, int errorCode) {
        super.notifyError_enforcePermission();
        this.mSensor.getSessionForUser(userId).getHalSessionCallback().onError((byte) errorCode, 0);
    }

    public void cleanupInternalState(int userId) throws RemoteException {
        super.cleanupInternalState_enforcePermission();
        Slog.d(TAG, "cleanupInternalState: " + userId);
        if (this.mProvider.isVhalForTesting() == false) goto L5;
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
