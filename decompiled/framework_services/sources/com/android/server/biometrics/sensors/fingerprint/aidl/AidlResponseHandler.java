package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.hardware.biometrics.fingerprint.ISessionCallback;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.keymaster.HardwareAuthToken;
import android.os.Handler;
import android.pico.utils.ExtImplFactory;
import android.util.Slog;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.sensors.AcquisitionClient;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import com.android.server.biometrics.sensors.AuthenticationConsumer;
import com.android.server.biometrics.sensors.BaseClientMonitor;
import com.android.server.biometrics.sensors.BiometricScheduler;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.EnumerateConsumer;
import com.android.server.biometrics.sensors.ErrorConsumer;
import com.android.server.biometrics.sensors.LockoutConsumer;
import com.android.server.biometrics.sensors.LockoutResetDispatcher;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.RemovalConsumer;
import com.android.server.biometrics.sensors.face.aidl.AidlResponseHandler$$ExternalSyntheticLambda24;
import com.android.server.biometrics.sensors.fingerprint.FingerprintUtils;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class AidlResponseHandler extends ISessionCallback.Stub {
    private static final String TAG = "AidlResponseHandler";
    private final AidlResponseHandlerCallback mAidlResponseHandlerCallback;
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private final FingerprintUtils mBiometricUtils;
    private final Context mContext;
    private final IExtAidlResponseHandler mExt;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private final LockoutTracker mLockoutTracker;
    private final BiometricScheduler mScheduler;
    private final int mSensorId;
    private final int mUserId;

    public interface AidlResponseHandlerCallback {
        void onEnrollSuccess();

        void onHardwareUnavailable();
    }

    /* JADX INFO: renamed from: $r8$lambda$-Zgv1mqNgl7Vc0Pj3KKpTfk4YGE, reason: not valid java name */
    public static /* synthetic */ void m2702$r8$lambda$Zgv1mqNgl7Vc0Pj3KKpTfk4YGE(Fingerprint r0, int r1, EnumerateConsumer r2) {
        lambda$onEnrollmentEnumerated$15(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$1UvuwOLJvnD-5m1tecR-FH0zyog, reason: not valid java name */
    public static /* synthetic */ void m2703$r8$lambda$1UvuwOLJvnD5m1tecRFH0zyog(AidlResponseHandler r0, BaseClientMonitor r1) {
        r0.lambda$onAuthenticationSucceeded$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$4UHfo7wxcpfQ5MoyHPhY8AEqBRM(Fingerprint r0, int r1, RemovalConsumer r2) {
        lambda$onEnrollmentRemoved$16(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$4yCl_S2ltUlImJE4HrmqlY_mTak(long r0, FingerprintGetAuthenticatorIdClient r2) {
        lambda$onAuthenticatorIdRetrieved$18(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$D-uulbFBk_axm517R8ndBMbrelI, reason: not valid java name */
    public static /* synthetic */ void m2704$r8$lambda$DuulbFBk_axm517R8ndBMbrelI(AidlResponseHandler r0, Class r1, Consumer r2, Consumer r3) {
        r0.lambda$handleResponse$21(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$Hl7jQTyKmbS23IYLN2OeF7e5sa0(AidlResponseHandler r0, byte r1, int r2) {
        r0.lambda$onAcquired$4(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$IV1E7z7sc6E3qJhxUsWY2-RHkAE, reason: not valid java name */
    public static /* synthetic */ void m2705$r8$lambda$IV1E7z7sc6E3qJhxUsWY2RHkAE(AidlResponseHandler r0, BaseClientMonitor r1) {
        r0.lambda$onLockoutCleared$13(r1);
    }

    public static /* synthetic */ void $r8$lambda$LYdS3MxthGLSp_haucU7blj0Qu8(RemovalConsumer r0) {
        lambda$onEnrollmentsRemoved$17(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$OX5xB_5MPtKT-E-fLHecnxN6ePU, reason: not valid java name */
    public static /* synthetic */ void m2706$r8$lambda$OX5xB_5MPtKTEfLHecnxN6ePU(Fingerprint r0, ArrayList r1, AuthenticationConsumer r2) {
        lambda$onAuthenticationSucceeded$8(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$PTcZahskrHpUyf39dZq3NOOItU0(AidlResponseHandler r0, int r1, int r2) {
        r0.lambda$onAcquired$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$TIPckxv1On2jPuXD_YN2dNHT0g0(AidlResponseHandler r0, int r1, int r2, ErrorConsumer r3) {
        r0.lambda$onError$6(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$aO3kr3x7zBRyTr-WEMk1WmYZOfw, reason: not valid java name */
    public static /* synthetic */ void m2707$r8$lambda$aO3kr3x7zBRyTrWEMk1WmYZOfw(long r0, FingerprintInvalidationClient r2) {
        lambda$onAuthenticatorIdInvalidated$19(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$hDx4zTxdC2DuIfMbOq0JmTiTzyE(EnumerateConsumer r0) {
        lambda$onEnrollmentsEnumerated$14(r0);
    }

    public static /* synthetic */ void $r8$lambda$hUXJyXJV6mqrTD7GF4Dtm90Rb4I(Fingerprint r0, AuthenticationConsumer r1) {
        lambda$onAuthenticationFailed$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ijghvVbr2mH19bh5ve9axXr7sOk(AidlResponseHandler r0, BaseClientMonitor r1) {
        r0.lambda$onAuthenticationFailed$11(r1);
    }

    public static /* synthetic */ void $r8$lambda$ngnX8YMOdPXHl1hiLGGY2JGHlrY(AidlResponseHandler r0, long r1, FingerprintGenerateChallengeClient r3) {
        r0.lambda$onChallengeGenerated$0(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$sC5AGoDUN7QZR6TicgHW3Cv5peE(long r0, FingerprintRevokeChallengeClient r2) {
        lambda$onChallengeRevoked$1(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$si3XmX47XxcHVbJrCEupYlDsI8k(AidlResponseHandler r0, Fingerprint r1, int r2, FingerprintEnrollClient r3) {
        r0.lambda$onEnrollmentProgress$7(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$zBf5ldf6eVCPMPVtjX1osvw8gmk(BaseClientMonitor r0) {
        lambda$onUnsupportedClientScheduled$20(r0);
    }

    public static /* synthetic */ void $r8$lambda$zjDzR3ltpyhjC__LQNKgUVv_aKE(long r0, LockoutConsumer r2) {
        lambda$onLockoutTimed$12(r0, r2);
    }

    public AidlResponseHandler(Context context, BiometricScheduler scheduler, int sensorId, int userId, LockoutTracker lockoutTracker, LockoutResetDispatcher lockoutResetDispatcher, AuthSessionCoordinator authSessionCoordinator, AidlResponseHandlerCallback aidlResponseHandlerCallback, FingerprintUtils biometricUtils) {
        this.mExt = (IExtAidlResponseHandler) ExtImplFactory.getImpl(IExtAidlResponseHandler.class, new Object[]{this});
        this.mContext = context;
        this.mScheduler = scheduler;
        this.mSensorId = sensorId;
        this.mUserId = userId;
        this.mLockoutTracker = lockoutTracker;
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
        this.mAuthSessionCoordinator = authSessionCoordinator;
        this.mAidlResponseHandlerCallback = aidlResponseHandlerCallback;
        this.mBiometricUtils = biometricUtils;
        Slog.d(TAG, "new AidlResponseHandler this = " + this);
    }

    public int getInterfaceVersion() {
        return 4;
    }

    public String getInterfaceHash() {
        return "41a730a7a6b5aa9cebebce70ee5b5e509b0af6fb";
    }

    private /* synthetic */ void lambda$onChallengeGenerated$0(long challenge, FingerprintGenerateChallengeClient c) {
        c.onChallengeGenerated(this.mSensorId, this.mUserId, challenge);
    }

    public void onChallengeGenerated(final long challenge) {
        handleResponse(FingerprintGenerateChallengeClient.class, new AidlResponseHandler$$ExternalSyntheticLambda11(this, challenge));
    }

    private static /* synthetic */ void lambda$onChallengeRevoked$1(long challenge, FingerprintRevokeChallengeClient c) {
        c.onChallengeRevoked(challenge);
    }

    public void onChallengeRevoked(final long challenge) {
        handleResponse(FingerprintRevokeChallengeClient.class, new AidlResponseHandler$$ExternalSyntheticLambda14(challenge));
    }

    public void onAcquired(final int acquiredInfo, final int vendorCode) {
        this.mScheduler.getHandler().post(new AidlResponseHandler$$ExternalSyntheticLambda18(this, acquiredInfo, vendorCode));
    }

    private /* synthetic */ void lambda$onAcquired$2(int acquiredInfo, int vendorCode) {
        BaseClientMonitor client = this.mScheduler.getCurrentClient();
        this.mExt.handleAcquiredResponse(this.mSensorId, acquiredInfo, vendorCode, client);
    }

    private static /* synthetic */ void lambda$onAcquired$3(int acquiredInfo, int vendorCode, AcquisitionClient c) {
        c.onAcquired(acquiredInfo, vendorCode);
    }

    public void onAcquired(final byte info, final int vendorCode) {
        this.mScheduler.getHandler().post(new AidlResponseHandler$$ExternalSyntheticLambda21(this, info, vendorCode));
    }

    private /* synthetic */ void lambda$onAcquired$4(byte info, int vendorCode) {
        BaseClientMonitor client = this.mScheduler.getCurrentClient();
        this.mExt.handleAcquiredResponse(this.mSensorId, AidlConversionUtils.toFrameworkAcquiredInfo(info), vendorCode, client);
    }

    private static /* synthetic */ void lambda$onAcquired$5(byte info, int vendorCode, AcquisitionClient c) {
        c.onAcquired(AidlConversionUtils.toFrameworkAcquiredInfo(info), vendorCode);
    }

    public void onError(final int error, final int vendorCode) {
        handleResponse(ErrorConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda12(this, error, vendorCode));
    }

    private /* synthetic */ void lambda$onError$6(int error, int vendorCode, ErrorConsumer c) {
        Slog.d(TAG, "onError error=" + error + " vendorCode=" + vendorCode);
        c.onError(error, vendorCode);
        if (error != 1) goto L6;
        this.mAidlResponseHandlerCallback.onHardwareUnavailable();
        return;
    }

    public void onError(byte error, int vendorCode) {
        onError(AidlConversionUtils.toFrameworkError(error), vendorCode);
    }

    public void onEnrollmentProgress(int enrollmentId, final int remaining) {
        BaseClientMonitor client = this.mScheduler.getCurrentClient();
        StringBuilder r1 = new StringBuilder();
        r1.append("onEnrollmentProgress route: sensorId=");
        r1.append(this.mSensorId);
        r1.append(", remaining=");
        r1.append(remaining);
        r1.append(", clientClass=");
        if (client == null) goto L5;
        String r2 = client.getClass().getName();
    L6:
        r1.append(r2);
        r1.append(", clientSensorId=");
        if (client == null) goto L9;
        int r3 = client.getSensorId();
    L10:
        r1.append(r3);
        r1.append(", clientReqId=");
        if (client == null) goto L13;
        long r4 = client.getRequestId();
    L14:
        r1.append(r4);
        r1.append(", scheduler=");
        r1.append(this.mScheduler);
        Slog.d(TAG, r1.toString());
        if (client != null) goto L17;
        return;
    L17:
        int currentUserId = client.getTargetUserId();
        CharSequence name = this.mBiometricUtils.getUniqueName(this.mContext, currentUserId);
        final Fingerprint fingerprint = new Fingerprint(name, currentUserId, enrollmentId, this.mSensorId);
        handleResponse(FingerprintEnrollClient.class, new AidlResponseHandler$$ExternalSyntheticLambda3(this, fingerprint, remaining));
        return;
    L13:
        r4 = -1;
        goto L14
    L9:
        r3 = -1;
        goto L10
    L5:
        r2 = "null";
        goto L6
    }

    private /* synthetic */ void lambda$onEnrollmentProgress$7(Fingerprint fingerprint, int remaining, FingerprintEnrollClient c) {
        c.onEnrollResult(fingerprint, remaining);
        if (remaining != 0) goto L6;
        this.mAidlResponseHandlerCallback.onEnrollSuccess();
        return;
    }

    public void onAuthenticationSucceeded(int enrollmentId, HardwareAuthToken hat) {
        final Fingerprint fp = new Fingerprint("", enrollmentId, this.mSensorId);
        byte[] byteArray = HardwareAuthTokenUtils.toByteArray(hat);
        final ArrayList<Byte> byteList = new ArrayList();
        int r3 = byteArray.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        byte b = byteArray[r4];
        byteList.add(Byte.valueOf(b));
        r4 = r4 + 1;
        goto L3
    L5:
        handleResponse(AuthenticationConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda15(fp, byteList), new AidlResponseHandler$$ExternalSyntheticLambda16(this));
    }

    private static /* synthetic */ void lambda$onAuthenticationSucceeded$8(Fingerprint fp, ArrayList byteList, AuthenticationConsumer c) {
        c.onAuthenticated(fp, true, byteList);
    }

    private /* synthetic */ void lambda$onAuthenticationSucceeded$9(BaseClientMonitor c) {
        onInteractionDetected();
    }

    public void onAuthenticationFailed() {
        final Fingerprint fp = new Fingerprint("", 0, this.mSensorId);
        handleResponse(AuthenticationConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda4(fp), new AidlResponseHandler$$ExternalSyntheticLambda5(this));
    }

    private static /* synthetic */ void lambda$onAuthenticationFailed$10(Fingerprint fp, AuthenticationConsumer c) {
        c.onAuthenticated(fp, false, null);
    }

    private /* synthetic */ void lambda$onAuthenticationFailed$11(BaseClientMonitor c) {
        onInteractionDetected();
    }

    private static /* synthetic */ void lambda$onLockoutTimed$12(long durationMillis, LockoutConsumer c) {
        c.onLockoutTimed(durationMillis);
    }

    public void onLockoutTimed(final long durationMillis) {
        handleResponse(LockoutConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda10(durationMillis));
    }

    public void onLockoutPermanent() {
        handleResponse(LockoutConsumer.class, new com.android.server.biometrics.sensors.face.aidl.AidlResponseHandler$$ExternalSyntheticLambda11());
    }

    public void onLockoutCleared() {
        handleResponse(FingerprintResetLockoutClient.class, new AidlResponseHandler$$ExternalSyntheticLambda1(), new AidlResponseHandler$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$onLockoutCleared$13(BaseClientMonitor c) {
        FingerprintResetLockoutClient.resetLocalLockoutStateToNone(this.mSensorId, this.mUserId, this.mLockoutTracker, this.mLockoutResetDispatcher, this.mAuthSessionCoordinator, Utils.getCurrentStrength(this.mSensorId), -1);
    }

    public void onInteractionDetected() {
        handleResponse(FingerprintDetectClient.class, new AidlResponseHandler$$ExternalSyntheticLambda6());
    }

    public void onEnrollmentsEnumerated(int[] enrollmentIds) {
        if (enrollmentIds.length <= 0) goto L9;
        int i = 0;
    L6:
        if (i >= enrollmentIds.length) goto L12;
        onEnrollmentEnumerated(enrollmentIds[i], (enrollmentIds.length - i) - 1);
        i = i + 1;
        goto L6
    L12:
        return;
    L9:
        handleResponse(EnumerateConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda19());
    }

    private static /* synthetic */ void lambda$onEnrollmentsEnumerated$14(EnumerateConsumer c) {
        c.onEnumerationResult(null, 0);
    }

    public void onEnrollmentEnumerated(int enrollmentId, final int remaining) {
        final Fingerprint fp = new Fingerprint("", enrollmentId, this.mSensorId);
        handleResponse(EnumerateConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda20(fp, remaining));
    }

    private static /* synthetic */ void lambda$onEnrollmentEnumerated$15(Fingerprint fp, int remaining, EnumerateConsumer c) {
        c.onEnumerationResult(fp, remaining);
    }

    public void onEnrollmentRemoved(int enrollmentId, final int remaining) {
        final Fingerprint fp = new Fingerprint("", enrollmentId, this.mSensorId);
        handleResponse(RemovalConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda7(fp, remaining));
    }

    private static /* synthetic */ void lambda$onEnrollmentRemoved$16(Fingerprint fp, int remaining, RemovalConsumer c) {
        c.onRemoved(fp, remaining);
    }

    public void onEnrollmentsRemoved(int[] enrollmentIds) {
        if (enrollmentIds.length <= 0) goto L9;
        int i = 0;
    L6:
        if (i >= enrollmentIds.length) goto L12;
        onEnrollmentRemoved(enrollmentIds[i], (enrollmentIds.length - i) - 1);
        i = i + 1;
        goto L6
    L12:
        return;
    L9:
        handleResponse(RemovalConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda8());
    }

    private static /* synthetic */ void lambda$onEnrollmentsRemoved$17(RemovalConsumer c) {
        c.onRemoved(null, 0);
    }

    public void onAuthenticatorIdRetrieved(final long authenticatorId) {
        handleResponse(FingerprintGetAuthenticatorIdClient.class, new AidlResponseHandler$$ExternalSyntheticLambda9(authenticatorId));
    }

    private static /* synthetic */ void lambda$onAuthenticatorIdRetrieved$18(long authenticatorId, FingerprintGetAuthenticatorIdClient c) {
        c.onAuthenticatorIdRetrieved(authenticatorId);
    }

    private static /* synthetic */ void lambda$onAuthenticatorIdInvalidated$19(long newAuthenticatorId, FingerprintInvalidationClient c) {
        c.onAuthenticatorIdInvalidated(newAuthenticatorId);
    }

    public void onAuthenticatorIdInvalidated(final long newAuthenticatorId) {
        handleResponse(FingerprintInvalidationClient.class, new AidlResponseHandler$$ExternalSyntheticLambda17(newAuthenticatorId));
    }

    public <T extends BaseClientMonitor> void onUnsupportedClientScheduled(Class<T> className) {
        Slog.e(TAG, className + " is not supported in the HAL.");
        handleResponse(className, new AidlResponseHandler$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ void lambda$onUnsupportedClientScheduled$20(BaseClientMonitor c) {
        c.cancel();
    }

    private <T> void handleResponse(Class<T> className, Consumer<T> action) {
        handleResponse(className, action, null);
    }

    private <T> void handleResponse(final Class<T> className, final Consumer<T> action, final Consumer<BaseClientMonitor> alternateAction) {
        this.mScheduler.getHandler().post(new AidlResponseHandler$$ExternalSyntheticLambda13(this, className, action, alternateAction));
    }

    private /* synthetic */ void lambda$handleResponse$21(Class className, Consumer action, Consumer alternateAction) {
        BaseClientMonitor client = this.mScheduler.getCurrentClient();
        StringBuilder r1 = new StringBuilder();
        r1.append("handleResponse route: sensorId=");
        r1.append(this.mSensorId);
        r1.append(", expected=");
        r1.append(className.getName());
        r1.append(", clientClass=");
        if (client == null) goto L5;
        String r2 = client.getClass().getName();
    L6:
        r1.append(r2);
        r1.append(", clientSensorId=");
        if (client == null) goto L9;
        int r3 = client.getSensorId();
    L10:
        r1.append(r3);
        r1.append(", clientReqId=");
        if (client == null) goto L13;
        long r4 = client.getRequestId();
    L14:
        r1.append(r4);
        r1.append(", scheduler=");
        r1.append(this.mScheduler);
        r1.append(", AidlResponseHdl this=");
        r1.append(this);
        Slog.d(TAG, r1.toString());
        if (className.isInstance(client) == false) goto L17;
        action.accept(client);
        return;
    L17:
        Slog.e(TAG, "Client monitor is not an instance of " + className.getName());
        if (alternateAction == null) goto L22;
        alternateAction.accept(client);
        return;
    L22:
        return;
    L13:
        r4 = -1;
        goto L14
    L9:
        r3 = -1;
        goto L10
    L5:
        r2 = "null";
        goto L6
    }

    public void onSessionClosed() {
        this.mExt.onSessionClosed();
        Handler r0 = this.mScheduler.getHandler();
        BiometricScheduler r1 = this.mScheduler;
        r1.getClass();
        r0.post(new AidlResponseHandler$$ExternalSyntheticLambda24(r1));
    }

    public void registerPostAuthAcquiredFallback(ClientMonitorCallbackConverter listener, long requestId) {
        this.mExt.registerPostAuthAcquiredFallback(listener, requestId);
    }
}
