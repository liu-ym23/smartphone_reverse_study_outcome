package com.android.server.locksettings;

import android.hardware.biometrics.BiometricManager;
import android.hardware.face.FaceManager;
import android.hardware.face.FaceSensorPropertiesInternal;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.os.Handler;
import android.os.IBinder;
import android.os.ServiceManager;
import android.service.gatekeeper.IGateKeeperService;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.server.biometrics.BiometricHandlerProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BiometricDeferredQueue {
    private static final String TAG = "BiometricDeferredQueue";
    private BiometricManager mBiometricManager;
    private final FaceResetLockoutTask.FinishCallback mFaceFinishCallback;
    private FaceManager mFaceManager;
    private FaceResetLockoutTask mFaceResetLockoutTask;
    private FingerprintManager mFingerprintManager;
    private final Handler mHandler;
    private final ArrayList<UserAuthInfo> mPendingResetLockouts;
    private final ArrayList<UserAuthInfo> mPendingResetLockoutsForFace;
    private final ArrayList<UserAuthInfo> mPendingResetLockoutsForFingerprint;
    private final SyntheticPasswordManager mSpManager;

    private static class FaceResetLockoutTask implements FaceManager.GenerateChallengeCallback {
        FaceManager faceManager;
        FinishCallback finishCallback;
        List<UserAuthInfo> pendingResetLockuts;
        Set<Integer> sensorIds;
        SyntheticPasswordManager spManager;

        interface FinishCallback {
            void onFinished();
        }

        FaceResetLockoutTask(FinishCallback finishCallback, FaceManager faceManager, SyntheticPasswordManager spManager, Set<Integer> sensorIds, List<UserAuthInfo> pendingResetLockouts) {
            this.finishCallback = finishCallback;
            this.faceManager = faceManager;
            this.spManager = spManager;
            this.sensorIds = sensorIds;
            this.pendingResetLockuts = pendingResetLockouts;
        }

        public void onGenerateChallengeResult(int sensorId, int userId, long challenge) {
            if (this.sensorIds.contains(Integer.valueOf(sensorId)) == true) goto L6;
            Slog.e(BiometricDeferredQueue.TAG, "Unknown sensorId received: " + sensorId);
            return;
        L6:
            Iterator<UserAuthInfo> r0 = this.pendingResetLockuts.iterator();
        L8:
            if (r0.hasNext() == false) goto L13;
            UserAuthInfo userAuthInfo = r0.next();
            Slog.d(BiometricDeferredQueue.TAG, "Resetting face lockout for sensor: " + sensorId + ", user: " + userAuthInfo.userId);
            byte[] hat = BiometricDeferredQueue.m5418$$Nest$smrequestHatFromGatekeeperPassword(this.spManager, userAuthInfo, challenge);
            if (hat == null) goto L8;
            this.faceManager.resetLockout(sensorId, userAuthInfo.userId, hat);
            goto L8
        L13:
            this.sensorIds.remove(Integer.valueOf(sensorId));
            this.faceManager.revokeChallenge(sensorId, userId, challenge);
            if (this.sensorIds.isEmpty() == false) goto L22;
            Slog.d(BiometricDeferredQueue.TAG, "Done requesting resetLockout for all face sensors");
            this.finishCallback.onFinished();
            return;
        }
    }

    private static class UserAuthInfo {
        final byte[] gatekeeperPassword;
        final int userId;

        UserAuthInfo(int userId, byte[] gatekeeperPassword) {
            this.userId = userId;
            this.gatekeeperPassword = gatekeeperPassword;
        }
    }

    public static /* synthetic */ void $r8$lambda$JRBzkLR89Jgz5E2z6vNkjU7WKZ8(BiometricDeferredQueue r0, int r1, byte[] r2) {
        r0.lambda$addPendingLockoutResetForUser$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$NeFZD9qqpdXxMLuT5ZveNGJxOUY(BiometricDeferredQueue r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$SxGTZn2GWZqPcXFdOlwl3f2L1sg(BiometricDeferredQueue r0) {
        r0.lambda$processPendingLockoutResets$2();
    }

    /* JADX INFO: renamed from: -$$Nest$smrequestHatFromGatekeeperPassword, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m5418$$Nest$smrequestHatFromGatekeeperPassword(SyntheticPasswordManager r0, UserAuthInfo r1, long r2) {
        return requestHatFromGatekeeperPassword(r0, r1, r2);
    }

    private /* synthetic */ void lambda$new$0() {
        this.mFaceResetLockoutTask = null;
    }

    BiometricDeferredQueue(SyntheticPasswordManager spManager) {
        this.mFaceFinishCallback = new BiometricDeferredQueue$$ExternalSyntheticLambda2(this);
        this.mSpManager = spManager;
        this.mHandler = BiometricHandlerProvider.getInstance().getBiometricCallbackHandler();
        this.mPendingResetLockoutsForFingerprint = new ArrayList();
        this.mPendingResetLockoutsForFace = new ArrayList();
        this.mPendingResetLockouts = new ArrayList();
    }

    public void systemReady(FingerprintManager fingerprintManager, FaceManager faceManager, BiometricManager biometricManager) {
        this.mFingerprintManager = fingerprintManager;
        this.mFaceManager = faceManager;
        this.mBiometricManager = biometricManager;
    }

    void addPendingLockoutResetForUser(final int userId, final byte[] gatekeeperPassword) {
        this.mHandler.post(new BiometricDeferredQueue$$ExternalSyntheticLambda0(this, userId, gatekeeperPassword));
    }

    private /* synthetic */ void lambda$addPendingLockoutResetForUser$1(int userId, byte[] gatekeeperPassword) {
        if (this.mFaceManager == null) goto L8;
        if (this.mFaceManager.hasEnrolledTemplates(userId) == false) goto L8;
        Slog.d(TAG, "Face addPendingLockoutResetForUser: " + userId);
        this.mPendingResetLockoutsForFace.add(new UserAuthInfo(userId, gatekeeperPassword));
    L8:
        if (this.mFingerprintManager == null) goto L13;
        if (this.mFingerprintManager.hasEnrolledFingerprints(userId) == false) goto L13;
        Slog.d(TAG, "Fingerprint addPendingLockoutResetForUser: " + userId);
        this.mPendingResetLockoutsForFingerprint.add(new UserAuthInfo(userId, gatekeeperPassword));
    L13:
        if (this.mBiometricManager == null) goto L16;
        Slog.d(TAG, "Fingerprint addPendingLockoutResetForUser: " + userId);
        this.mPendingResetLockouts.add(new UserAuthInfo(userId, gatekeeperPassword));
        return;
    }

    void processPendingLockoutResets() {
        this.mHandler.post(new BiometricDeferredQueue$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$processPendingLockoutResets$2() {
        if (this.mPendingResetLockoutsForFace.isEmpty() == true) goto L6;
        Slog.d(TAG, "Processing pending resetLockout for face");
        processPendingLockoutsForFace(new ArrayList(this.mPendingResetLockoutsForFace));
        this.mPendingResetLockoutsForFace.clear();
    L6:
        if (this.mPendingResetLockoutsForFingerprint.isEmpty() == true) goto L9;
        Slog.d(TAG, "Processing pending resetLockout for fingerprint");
        processPendingLockoutsForFingerprint(new ArrayList(this.mPendingResetLockoutsForFingerprint));
        this.mPendingResetLockoutsForFingerprint.clear();
    L9:
        if (this.mPendingResetLockouts.isEmpty() == true) goto L12;
        Slog.d(TAG, "Processing pending resetLockouts(Generic)");
        processPendingLockoutsGeneric(new ArrayList(this.mPendingResetLockouts));
        this.mPendingResetLockouts.clear();
        return;
    }

    private void processPendingLockoutsForFingerprint(List<UserAuthInfo> pendingResetLockouts) {
        if (this.mFingerprintManager == null) goto L26;
        List<FingerprintSensorPropertiesInternal> fingerprintSensorProperties = this.mFingerprintManager.getSensorPropertiesInternal();
        Iterator<FingerprintSensorPropertiesInternal> r1 = fingerprintSensorProperties.iterator();
    L6:
        if (r1.hasNext() == false) goto L40;
        FingerprintSensorPropertiesInternal prop = r1.next();
        if (prop.resetLockoutRequiresHardwareAuthToken == false) goto L9;
        if (prop.resetLockoutRequiresChallenge == false) goto L16;
        Slog.w(TAG, "No fingerprint HAL interface requires HAT with challenge, sensorId: " + prop.sensorId);
        goto L6
    L16:
        Iterator<UserAuthInfo> r3 = pendingResetLockouts.iterator();
    L18:
        if (r3.hasNext() == false) goto L6;
        UserAuthInfo user = r3.next();
        Slog.d(TAG, "Resetting fingerprint lockout for sensor: " + prop.sensorId + ", user: " + user.userId);
        byte[] hat = requestHatFromGatekeeperPassword(this.mSpManager, user, 0);
        if (hat == null) goto L18;
        this.mFingerprintManager.resetLockout(prop.sensorId, user.userId, hat);
        goto L18
    L9:
        Iterator<UserAuthInfo> r4 = pendingResetLockouts.iterator();
    L11:
        if (r4.hasNext() == false) goto L6;
        this.mFingerprintManager.resetLockout(prop.sensorId, r4.next().userId, null);
        goto L11
    L40:
        return;
    }

    private void processPendingLockoutsForFace(List<UserAuthInfo> pendingResetLockouts) {
        if (this.mFaceManager == null) goto L30;
        if (this.mFaceResetLockoutTask == null) goto L7;
        Slog.w(TAG, "mFaceGenerateChallengeCallback not null, previous operation may be stuck");
    L7:
        List<FaceSensorPropertiesInternal> faceSensorProperties = this.mFaceManager.getSensorPropertiesInternal();
        Set<Integer> sensorIds = new ArraySet();
        Iterator<FaceSensorPropertiesInternal> r2 = faceSensorProperties.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        sensorIds.add(Integer.valueOf(r2.next().sensorId));
        goto L9
    L11:
        this.mFaceResetLockoutTask = new FaceResetLockoutTask(this.mFaceFinishCallback, this.mFaceManager, this.mSpManager, sensorIds, pendingResetLockouts);
        Iterator<FaceSensorPropertiesInternal> r12 = faceSensorProperties.iterator();
    L13:
        if (r12.hasNext() == false) goto L45;
        FaceSensorPropertiesInternal prop = r12.next();
        if (prop.resetLockoutRequiresHardwareAuthToken == true) goto L16;
        Slog.w(TAG, "Lockout is below the HAL for all face authentication interfaces, sensorId: " + prop.sensorId);
        goto L13
    L16:
        Iterator<UserAuthInfo> r3 = pendingResetLockouts.iterator();
    L18:
        if (r3.hasNext() == false) goto L13;
        UserAuthInfo user = r3.next();
        if (prop.resetLockoutRequiresChallenge == true) goto L21;
        Slog.d(TAG, "Resetting face lockout for sensor: " + prop.sensorId + ", user: " + user.userId);
        byte[] hat = requestHatFromGatekeeperPassword(this.mSpManager, user, 0);
        if (hat == null) goto L18;
        this.mFaceManager.resetLockout(prop.sensorId, user.userId, hat);
        goto L18
    L21:
        Slog.d(TAG, "Generating challenge for sensor: " + prop.sensorId + ", user: " + user.userId);
        this.mFaceManager.generateChallenge(prop.sensorId, user.userId, this.mFaceResetLockoutTask);
        goto L18
    L45:
        return;
    }

    private void processPendingLockoutsGeneric(List<UserAuthInfo> pendingResetLockouts) {
        Iterator<UserAuthInfo> r0 = pendingResetLockouts.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        UserAuthInfo user = r0.next();
        Slog.d(TAG, "Resetting biometric lockout for user: " + user.userId);
        byte[] hat = requestHatFromGatekeeperPassword(this.mSpManager, user, 0);
        if (hat == null) goto L4;
        this.mBiometricManager.resetLockout(user.userId, hat);
        goto L4
    }

    private static byte[] requestHatFromGatekeeperPassword(SyntheticPasswordManager spManager, UserAuthInfo userAuthInfo, long challenge) {
        VerifyCredentialResponse response = spManager.verifyChallengeInternal(getGatekeeperService(), userAuthInfo.gatekeeperPassword, challenge, userAuthInfo.userId);
        if (response != null) goto L7;
        Slog.wtf(TAG, "VerifyChallenge failed, null response");
        return null;
    L7:
        if (response.getResponseCode() == 0) goto L11;
        Slog.wtf(TAG, "VerifyChallenge failed, response: " + response.getResponseCode());
        return null;
    L11:
        if (response.getGatekeeperHAT() != null) goto L14;
        Slog.e(TAG, "Null HAT received from spManager");
    L14:
        return response.getGatekeeperHAT();
    }

    private static synchronized IGateKeeperService getGatekeeperService() {
        monitor-enter(BiometricDeferredQueue.class);
        IBinder service = ServiceManager.waitForService("android.service.gatekeeper.IGateKeeperService");     // Catch: Throwable -> L10
        if (service != null) goto L12;
        Slog.e(TAG, "Unable to acquire GateKeeperService");     // Catch: Throwable -> L10
        monitor-exit(BiometricDeferredQueue.class);
        return null;
    L12:
        IGateKeeperService r2 = IGateKeeperService.Stub.asInterface(service);     // Catch: Throwable -> L10
        monitor-exit(BiometricDeferredQueue.class);
        return r2;
    L10:
        th = move-exception;
        throw th;
    }
}
