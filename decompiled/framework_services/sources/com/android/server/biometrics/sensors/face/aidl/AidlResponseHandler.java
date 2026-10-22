package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.hardware.biometrics.face.AuthenticationFrame;
import android.hardware.biometrics.face.EnrollmentFrame;
import android.hardware.biometrics.face.ISessionCallback;
import android.hardware.face.Face;
import android.hardware.keymaster.HardwareAuthToken;
import android.os.Handler;
import android.util.Slog;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.sensors.AcquisitionClient;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import com.android.server.biometrics.sensors.AuthenticationConsumer;
import com.android.server.biometrics.sensors.BaseClientMonitor;
import com.android.server.biometrics.sensors.BiometricScheduler;
import com.android.server.biometrics.sensors.EnumerateConsumer;
import com.android.server.biometrics.sensors.ErrorConsumer;
import com.android.server.biometrics.sensors.LockoutConsumer;
import com.android.server.biometrics.sensors.LockoutResetDispatcher;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.RemovalConsumer;
import com.android.server.biometrics.sensors.face.FaceUtils;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class AidlResponseHandler extends ISessionCallback.Stub {
    private static final String TAG = "AidlResponseHandler";
    private final AidlResponseHandlerCallback mAidlResponseHandlerCallback;
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private final FaceUtils mBiometricUtils;
    private final Context mContext;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private final LockoutTracker mLockoutTracker;
    private final BiometricScheduler mScheduler;
    private final int mSensorId;
    private final int mUserId;

    public interface AidlResponseHandlerCallback {
        void onEnrollSuccess();

        void onHardwareUnavailable();
    }

    public static /* synthetic */ void $r8$lambda$0gbCsAk06ZULzasyP9fGHei9YqY(Face r0, int[] r1, int r2, EnumerateConsumer r3) {
        lambda$onEnrollmentsEnumerated$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$1CnXY_UtDpe1OXC4l2wbghIh5dk(AidlResponseHandler r0, Class r1, Consumer r2, Consumer r3) {
        r0.lambda$handleResponse$20(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$28RAQo1lWTUB-4BoqPBPebWKxMw, reason: not valid java name */
    public static /* synthetic */ void m2648$r8$lambda$28RAQo1lWTUB4BoqPBPebWKxMw(AidlResponseHandler r0, long r1, FaceGenerateChallengeClient r3) {
        r0.lambda$onChallengeGenerated$0(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$9Hqi0iJFFkhaaj-bmtku_3wqokQ, reason: not valid java name */
    public static /* synthetic */ void m2649$r8$lambda$9Hqi0iJFFkhaajbmtku_3wqokQ(AidlResponseHandler r0, long r1) {
        r0.lambda$onLockoutChanged$19(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ay8_VmKwbe21S3wxdRFvX-uvrTw, reason: not valid java name */
    public static /* synthetic */ void m2650$r8$lambda$Ay8_VmKwbe21S3wxdRFvXuvrTw(EnumerateConsumer r0) {
        lambda$onEnrollmentsEnumerated$11(r0);
    }

    public static /* synthetic */ void $r8$lambda$HEae8ZphlmOl3n33QjMvIBJeOd8(AidlResponseHandler r0, int r1, int r2, ErrorConsumer r3) {
        r0.lambda$onError$4(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$JPZVomc-TsUv8oPTWqJRPNHePJo, reason: not valid java name */
    public static /* synthetic */ void m2651$r8$lambda$JPZVomcTsUv8oPTWqJRPNHePJo(Face r0, AuthenticationConsumer r1) {
        lambda$onAuthenticationFailed$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$LJqAtHAO1sAJ8HoUMcR-C0QqWbY, reason: not valid java name */
    public static /* synthetic */ void m2652$r8$lambda$LJqAtHAO1sAJ8HoUMcRC0QqWbY(FaceSetFeatureClient r0) {
        lambda$onFeatureSet$13(r0);
    }

    public static /* synthetic */ void $r8$lambda$NW6hyQNngRK8IwEQRxH3ChDkFnQ(EnrollmentFrame r0, FaceEnrollClient r1) {
        lambda$onEnrollmentFrame$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$QF83JYjDjolHkowMrLXV5XNE-Mo, reason: not valid java name */
    public static /* synthetic */ void m2653$r8$lambda$QF83JYjDjolHkowMrLXV5XNEMo(int r0, int r1, AcquisitionClient r2) {
        lambda$onAcquired$18(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Slz3Vvzcu-eOR7TsJCT0QvS26K0, reason: not valid java name */
    public static /* synthetic */ void m2654$r8$lambda$Slz3VvzcueOR7TsJCT0QvS26K0(RemovalConsumer r0) {
        lambda$onEnrollmentsRemoved$15(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$U-myBNGfhWcUy8BDk69tvKhWxNQ, reason: not valid java name */
    public static /* synthetic */ void m2655$r8$lambda$UmyBNGfhWcUy8BDk69tvKhWxNQ(Face r0, int[] r1, int r2, RemovalConsumer r3) {
        lambda$onEnrollmentsRemoved$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$W7K_BsIF1n7FggRN_unuSxBcyy4(AuthenticationFrame r0, FaceAuthenticationClient r1) {
        lambda$onAuthenticationFrame$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$WmkUriCWl17aIQ7o-YQ61sQ5Zmk, reason: not valid java name */
    public static /* synthetic */ void m2656$r8$lambda$WmkUriCWl17aIQ7oYQ61sQ5Zmk(long r0, FaceInvalidationClient r2) {
        lambda$onAuthenticatorIdInvalidated$17(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$Y_6owfz4ghJTa36StgpISWG8tiA(long r0, FaceGetAuthenticatorIdClient r2) {
        lambda$onAuthenticatorIdRetrieved$16(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$iId0imr_aEB7ndbttpp0lLsmkNM(byte[] r0, FaceGetFeatureClient r1) {
        lambda$onFeaturesRetrieved$12(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$oJFvIK43YWd6HYhViabb2eNKAUo(AidlResponseHandler r0, long r1, FaceRevokeChallengeClient r3) {
        r0.lambda$onChallengeRevoked$1(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$s3ZpbjO5-QyadcQQaQ-StXkyqTk, reason: not valid java name */
    public static /* synthetic */ void m2657$r8$lambda$s3ZpbjO5QyadcQQaQStXkyqTk(Face r0, ArrayList r1, AuthenticationConsumer r2) {
        lambda$onAuthenticationSucceeded$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$tYDjGT_S1VyOAkKtupvtOJKzBSM(AidlResponseHandler r0, Face r1, int r2, FaceEnrollClient r3) {
        r0.lambda$onEnrollmentProgress$5(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$v7Bwx-vmwy2K5YB7bDZAd2wz48s, reason: not valid java name */
    public static /* synthetic */ void m2658$r8$lambda$v7Bwxvmwy2K5YB7bDZAd2wz48s(AidlResponseHandler r0, BaseClientMonitor r1) {
        r0.lambda$onLockoutCleared$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$xrEhMdT1KoD3DRTFLOClafsIdI0(long r0, LockoutConsumer r2) {
        lambda$onLockoutTimed$8(r0, r2);
    }

    public AidlResponseHandler(Context context, BiometricScheduler scheduler, int sensorId, int userId, LockoutTracker lockoutTracker, LockoutResetDispatcher lockoutResetDispatcher, AuthSessionCoordinator authSessionCoordinator, AidlResponseHandlerCallback aidlResponseHandlerCallback, FaceUtils biometricUtils) {
        this.mContext = context;
        this.mScheduler = scheduler;
        this.mSensorId = sensorId;
        this.mUserId = userId;
        this.mLockoutTracker = lockoutTracker;
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
        this.mAuthSessionCoordinator = authSessionCoordinator;
        this.mAidlResponseHandlerCallback = aidlResponseHandlerCallback;
        this.mBiometricUtils = biometricUtils;
    }

    public int getInterfaceVersion() {
        return 4;
    }

    public String getInterfaceHash() {
        return "c43fbb9be4a662cc9ace640dba21cccdb84c6c21";
    }

    private /* synthetic */ void lambda$onChallengeGenerated$0(long challenge, FaceGenerateChallengeClient c) {
        c.onChallengeGenerated(this.mSensorId, this.mUserId, challenge);
    }

    public void onChallengeGenerated(final long challenge) {
        handleResponse(FaceGenerateChallengeClient.class, new AidlResponseHandler$$ExternalSyntheticLambda7(this, challenge));
    }

    private /* synthetic */ void lambda$onChallengeRevoked$1(long challenge, FaceRevokeChallengeClient c) {
        c.onChallengeRevoked(this.mSensorId, this.mUserId, challenge);
    }

    public void onChallengeRevoked(final long challenge) {
        handleResponse(FaceRevokeChallengeClient.class, new AidlResponseHandler$$ExternalSyntheticLambda8(this, challenge));
    }

    public void onAuthenticationFrame(final AuthenticationFrame frame) {
        handleResponse(FaceAuthenticationClient.class, new AidlResponseHandler$$ExternalSyntheticLambda21(frame));
    }

    private static /* synthetic */ void lambda$onAuthenticationFrame$2(AuthenticationFrame frame, FaceAuthenticationClient c) {
        if (frame != null) goto L5;
        Slog.e(TAG, "Received null enrollment frame for face authentication client.");
        return;
    L5:
        c.onAuthenticationFrame(AidlConversionUtils.toFrameworkAuthenticationFrame(frame));
    }

    public void onEnrollmentFrame(final EnrollmentFrame frame) {
        handleResponse(FaceEnrollClient.class, new AidlResponseHandler$$ExternalSyntheticLambda6(frame));
    }

    private static /* synthetic */ void lambda$onEnrollmentFrame$3(EnrollmentFrame frame, FaceEnrollClient c) {
        if (frame != null) goto L5;
        Slog.e(TAG, "Received null enrollment frame for face enroll client.");
        return;
    L5:
        c.onEnrollmentFrame(AidlConversionUtils.toFrameworkEnrollmentFrame(frame));
    }

    public void onError(byte error, int vendorCode) {
        onError(AidlConversionUtils.toFrameworkError(error), vendorCode);
    }

    public void onError(final int error, final int vendorCode) {
        handleResponse(ErrorConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda25(this, error, vendorCode));
    }

    private /* synthetic */ void lambda$onError$4(int error, int vendorCode, ErrorConsumer c) {
        c.onError(error, vendorCode);
        if (error != 1) goto L6;
        this.mAidlResponseHandlerCallback.onHardwareUnavailable();
        return;
    }

    public void onEnrollmentProgress(int enrollmentId, final int remaining) {
        BaseClientMonitor client = this.mScheduler.getCurrentClient();
        if (client != null) goto L5;
        return;
    L5:
        int currentUserId = client.getTargetUserId();
        CharSequence name = this.mBiometricUtils.getUniqueName(this.mContext, currentUserId);
        final Face face = new Face(name, enrollmentId, this.mSensorId);
        handleResponse(FaceEnrollClient.class, new AidlResponseHandler$$ExternalSyntheticLambda2(this, face, remaining));
    }

    private /* synthetic */ void lambda$onEnrollmentProgress$5(Face face, int remaining, FaceEnrollClient c) {
        c.onEnrollResult(face, remaining);
        if (remaining != 0) goto L6;
        this.mAidlResponseHandlerCallback.onEnrollSuccess();
        return;
    }

    public void onAuthenticationSucceeded(int enrollmentId, HardwareAuthToken hat) {
        final Face face = new Face("", enrollmentId, this.mSensorId);
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
        handleResponse(AuthenticationConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda20(face, byteList));
    }

    private static /* synthetic */ void lambda$onAuthenticationSucceeded$6(Face face, ArrayList byteList, AuthenticationConsumer c) {
        c.onAuthenticated(face, true, byteList);
    }

    public void onAuthenticationFailed() {
        final Face face = new Face("", 0, this.mSensorId);
        handleResponse(AuthenticationConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda0(face));
    }

    private static /* synthetic */ void lambda$onAuthenticationFailed$7(Face face, AuthenticationConsumer c) {
        c.onAuthenticated(face, false, null);
    }

    private static /* synthetic */ void lambda$onLockoutTimed$8(long durationMillis, LockoutConsumer c) {
        c.onLockoutTimed(durationMillis);
    }

    public void onLockoutTimed(final long durationMillis) {
        handleResponse(LockoutConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda5(durationMillis));
    }

    public void onLockoutPermanent() {
        handleResponse(LockoutConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda11());
    }

    public void onLockoutCleared() {
        handleResponse(FaceResetLockoutClient.class, new AidlResponseHandler$$ExternalSyntheticLambda13(), new AidlResponseHandler$$ExternalSyntheticLambda14(this));
    }

    private /* synthetic */ void lambda$onLockoutCleared$9(BaseClientMonitor c) {
        FaceResetLockoutClient.resetLocalLockoutStateToNone(this.mSensorId, this.mUserId, this.mLockoutTracker, this.mLockoutResetDispatcher, this.mAuthSessionCoordinator, Utils.getCurrentStrength(this.mSensorId), -1);
    }

    public void onInteractionDetected() {
        handleResponse(FaceDetectClient.class, new AidlResponseHandler$$ExternalSyntheticLambda12());
    }

    public void onEnrollmentsEnumerated(final int[] enrollmentIds) {
        if (enrollmentIds.length <= 0) goto L9;
        int i = 0;
    L6:
        if (i >= enrollmentIds.length) goto L12;
        final Face face = new Face("", enrollmentIds[i], this.mSensorId);
        final int finalI = i;
        handleResponse(EnumerateConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda17(face, enrollmentIds, finalI));
        i = i + 1;
        goto L6
    L12:
        return;
    L9:
        handleResponse(EnumerateConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda18());
    }

    private static /* synthetic */ void lambda$onEnrollmentsEnumerated$10(Face face, int[] enrollmentIds, int finalI, EnumerateConsumer c) {
        c.onEnumerationResult(face, (enrollmentIds.length - finalI) - 1);
    }

    private static /* synthetic */ void lambda$onEnrollmentsEnumerated$11(EnumerateConsumer c) {
        c.onEnumerationResult(null, 0);
    }

    private static /* synthetic */ void lambda$onFeaturesRetrieved$12(byte[] features, FaceGetFeatureClient c) {
        c.onFeatureGet(true, features);
    }

    public void onFeaturesRetrieved(final byte[] features) {
        handleResponse(FaceGetFeatureClient.class, new AidlResponseHandler$$ExternalSyntheticLambda1(features));
    }

    private static /* synthetic */ void lambda$onFeatureSet$13(FaceSetFeatureClient c) {
        c.onFeatureSet(true);
    }

    public void onFeatureSet(byte feature) {
        handleResponse(FaceSetFeatureClient.class, new AidlResponseHandler$$ExternalSyntheticLambda19());
    }

    public void onEnrollmentsRemoved(final int[] enrollmentIds) {
        if (enrollmentIds.length <= 0) goto L9;
        int i = 0;
    L6:
        if (i >= enrollmentIds.length) goto L12;
        final Face face = new Face("", enrollmentIds[i], this.mSensorId);
        final int finalI = i;
        handleResponse(RemovalConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda9(face, enrollmentIds, finalI));
        i = i + 1;
        goto L6
    L12:
        return;
    L9:
        handleResponse(RemovalConsumer.class, new AidlResponseHandler$$ExternalSyntheticLambda10());
    }

    private static /* synthetic */ void lambda$onEnrollmentsRemoved$14(Face face, int[] enrollmentIds, int finalI, RemovalConsumer c) {
        c.onRemoved(face, (enrollmentIds.length - finalI) - 1);
    }

    private static /* synthetic */ void lambda$onEnrollmentsRemoved$15(RemovalConsumer c) {
        c.onRemoved(null, 0);
    }

    private static /* synthetic */ void lambda$onAuthenticatorIdRetrieved$16(long authenticatorId, FaceGetAuthenticatorIdClient c) {
        c.onAuthenticatorIdRetrieved(authenticatorId);
    }

    public void onAuthenticatorIdRetrieved(final long authenticatorId) {
        handleResponse(FaceGetAuthenticatorIdClient.class, new AidlResponseHandler$$ExternalSyntheticLambda3(authenticatorId));
    }

    private static /* synthetic */ void lambda$onAuthenticatorIdInvalidated$17(long newAuthenticatorId, FaceInvalidationClient c) {
        c.onAuthenticatorIdInvalidated(newAuthenticatorId);
    }

    public void onAuthenticatorIdInvalidated(final long newAuthenticatorId) {
        handleResponse(FaceInvalidationClient.class, new AidlResponseHandler$$ExternalSyntheticLambda16(newAuthenticatorId));
    }

    private static /* synthetic */ void lambda$onAcquired$18(int acquiredInfo, int vendorCode, AcquisitionClient c) {
        c.onAcquired(acquiredInfo, vendorCode);
    }

    public void onAcquired(final int acquiredInfo, final int vendorCode) {
        handleResponse(AcquisitionClient.class, new AidlResponseHandler$$ExternalSyntheticLambda4(acquiredInfo, vendorCode));
    }

    public void onLockoutChanged(final long duration) {
        this.mScheduler.getHandler().post(new AidlResponseHandler$$ExternalSyntheticLambda15(this, duration));
    }

    private /* synthetic */ void lambda$onLockoutChanged$19(long duration) {
        if (duration != 0) goto L6;
        int lockoutMode = 0;
    L12:
        this.mLockoutTracker.setLockoutModeForUser(this.mUserId, lockoutMode);
        if (duration != 0) goto L16;
        this.mLockoutResetDispatcher.notifyLockoutResetCallbacks(this.mSensorId);
        return;
    L16:
        return;
    L6:
        if (duration != (-1)) goto L8;
    L11:
        lockoutMode = 2;
        goto L12
    L8:
        if (duration == Long.MAX_VALUE) goto L11;
        lockoutMode = 1;
        goto L12
    }

    public void onUnsupportedClientScheduled() {
        Slog.e(TAG, "FaceInvalidationClient is not supported in the HAL.");
        handleResponse(FaceInvalidationClient.class, new AidlResponseHandler$$ExternalSyntheticLambda23());
    }

    private <T> void handleResponse(Class<T> className, Consumer<T> action) {
        handleResponse(className, action, null);
    }

    private <T> void handleResponse(final Class<T> className, final Consumer<T> actionIfClassMatchesClient, final Consumer<BaseClientMonitor> alternateAction) {
        this.mScheduler.getHandler().post(new AidlResponseHandler$$ExternalSyntheticLambda22(this, className, actionIfClassMatchesClient, alternateAction));
    }

    private /* synthetic */ void lambda$handleResponse$20(Class className, Consumer actionIfClassMatchesClient, Consumer alternateAction) {
        BaseClientMonitor client = this.mScheduler.getCurrentClient();
        if (className.isInstance(client) == false) goto L5;
        actionIfClassMatchesClient.accept(client);
        return;
    L5:
        Slog.d(TAG, "Current client is not an instance of " + className.getName());
        if (alternateAction == null) goto L10;
        alternateAction.accept(client);
        return;
    }

    public void onSessionClosed() {
        Handler r0 = this.mScheduler.getHandler();
        BiometricScheduler r1 = this.mScheduler;
        r1.getClass();
        r0.post(new AidlResponseHandler$$ExternalSyntheticLambda24(r1));
    }
}
