package com.android.server.biometrics.sensors.face.hidl;

import android.content.Context;
import android.hardware.biometrics.common.ICancellationSignal;
import android.hardware.biometrics.common.OperationContext;
import android.hardware.biometrics.face.EnrollmentStageConfig;
import android.hardware.biometrics.face.FaceEnrollOptions;
import android.hardware.biometrics.face.ISession;
import android.hardware.biometrics.face.V1_0.IBiometricsFace;
import android.hardware.biometrics.face.V1_0.OptionalBool;
import android.hardware.common.NativeHandle;
import android.hardware.face.Face;
import android.hardware.face.FaceManager;
import android.hardware.keymaster.HardwareAuthToken;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.sensors.face.aidl.AidlConversionUtils;
import com.android.server.biometrics.sensors.face.aidl.AidlResponseHandler;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class HidlToAidlSessionAdapter implements ISession {
    static final int CHALLENGE_TIMEOUT_SEC = 600;
    static final int ENROLL_TIMEOUT_SEC = 75;
    private static final int GENERATE_CHALLENGE_COUNTER_TTL_MILLIS = 600000;
    private static final int GENERATE_CHALLENGE_REUSE_INTERVAL_MILLIS = 60000;
    private static final int INVALID_VALUE = -1;
    private static final String TAG = "HidlToAidlSessionAdapter";
    private final Clock mClock;
    private final Context mContext;
    private int mFeature;
    private long mGenerateChallengeCreatedAt;
    private long mGenerateChallengeResult;
    private final List<Long> mGeneratedChallengeCount;
    private HidlToAidlCallbackConverter mHidlToAidlCallbackConverter;
    private Supplier<IBiometricsFace> mSession;
    private final int mUserId;

    private class Cancellation extends ICancellationSignal.Stub {
        final /* synthetic */ HidlToAidlSessionAdapter this$0;

        Cancellation(HidlToAidlSessionAdapter r1) {
            this.this$0 = r1;
        }

        public void cancel() throws RemoteException {
            ((IBiometricsFace) HidlToAidlSessionAdapter.m2691$$Nest$fgetmSession(this.this$0).get()).cancel();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(HidlToAidlSessionAdapter.TAG, "Remote exception when requesting cancel", e);
        }

        public int getInterfaceVersion() throws RemoteException {
            return 0;
        }

        public String getInterfaceHash() throws RemoteException {
            return null;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$Kl4RMBQFGs9hwUMPzJBbWmChYCg(long r0, Long r2) {
        return lambda$decrementChallengeCount$0(r0, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m2691$$Nest$fgetmSession(HidlToAidlSessionAdapter r0) {
        return r0.mSession;
    }

    public HidlToAidlSessionAdapter(Context context, Supplier<IBiometricsFace> session, int userId, AidlResponseHandler aidlResponseHandler) {
        this(context, session, userId, aidlResponseHandler, Clock.systemUTC());
    }

    HidlToAidlSessionAdapter(Context context, Supplier<IBiometricsFace> session, int userId, AidlResponseHandler aidlResponseHandler, Clock clock) {
        this.mGeneratedChallengeCount = new ArrayList();
        this.mGenerateChallengeCreatedAt = -1;
        this.mGenerateChallengeResult = -1;
        this.mFeature = -1;
        this.mSession = session;
        this.mUserId = userId;
        this.mContext = context;
        this.mClock = clock;
        setCallback(aidlResponseHandler);
    }

    public IBinder asBinder() {
        return null;
    }

    public void generateChallenge() throws RemoteException {
        incrementChallengeCount();
        if (isGeneratedChallengeCacheValid() == false) goto L6;
        Slog.d(TAG, "Current challenge is cached and will be reused");
        this.mHidlToAidlCallbackConverter.onChallengeGenerated(this.mGenerateChallengeResult);
        return;
    L6:
        this.mGenerateChallengeCreatedAt = this.mClock.millis();
        this.mGenerateChallengeResult = this.mSession.get().generateChallenge(600).value;
        this.mHidlToAidlCallbackConverter.onChallengeGenerated(this.mGenerateChallengeResult);
    }

    public void revokeChallenge(long challenge) throws RemoteException {
        if (decrementChallengeCount() != 0) goto L5;
        boolean shouldRevoke = true;
    L6:
        if (shouldRevoke == true) goto L9;
        Slog.w(TAG, "scheduleRevokeChallenge skipped - challenge still in use: " + this.mGeneratedChallengeCount);
        this.mHidlToAidlCallbackConverter.onError(0, this.mUserId, 2, 0);
        return;
    L9:
        this.mGenerateChallengeCreatedAt = -1;
        this.mGenerateChallengeResult = -1;
        this.mSession.get().revokeChallenge();
        this.mHidlToAidlCallbackConverter.onChallengeRevoked(0);
        return;
    L5:
        shouldRevoke = false;
        goto L6
    }

    public EnrollmentStageConfig[] getEnrollmentConfig(byte enrollmentType) throws RemoteException {
        Slog.e(TAG, "getEnrollmentConfig unsupported in HIDL");
        return null;
    }

    public ICancellationSignal enroll(HardwareAuthToken hat, byte type, byte[] features, NativeHandle previewSurface) throws RemoteException {
        ArrayList<Byte> token = new ArrayList();
        byte[] hardwareAuthTokenArray = HardwareAuthTokenUtils.toByteArray(hat);
        int r2 = hardwareAuthTokenArray.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        byte b = hardwareAuthTokenArray[r4];
        token.add(Byte.valueOf(b));
        r4 = r4 + 1;
        goto L3
    L5:
        ArrayList<Integer> disabledFeatures = new ArrayList();
        int r5 = features.length;
    L6:
        if (r3 >= r5) goto L8;
        byte b2 = features[r3];
        disabledFeatures.add(Integer.valueOf(AidlConversionUtils.convertAidlToFrameworkFeature(b2)));
        r3 = r3 + 1;
        goto L6
    L8:
        this.mSession.get().enroll(token, 75, disabledFeatures);
        return new Cancellation(this);
    }

    public ICancellationSignal authenticate(long operationId) throws RemoteException {
        this.mSession.get().authenticate(operationId);
        return new Cancellation(this);
    }

    public ICancellationSignal detectInteraction() throws RemoteException {
        this.mSession.get().authenticate(0);
        return new Cancellation(this);
    }

    public void enumerateEnrollments() throws RemoteException {
        this.mSession.get().enumerate();
    }

    public void removeEnrollments(int[] enrollmentIds) throws RemoteException {
        this.mSession.get().remove(enrollmentIds[0]);
    }

    public void setFeature(int feature) {
        this.mFeature = feature;
    }

    public void getFeatures() throws RemoteException {
        int faceId = getFaceId();
        if (faceId != (-1)) goto L5;
        return;
    L5:
        if (this.mFeature == (-1)) goto L19;
        OptionalBool result = this.mSession.get().getFeature(this.mFeature, faceId);
        if (result.status != 0) goto L13;
        if (result.value == false) goto L13;
        this.mHidlToAidlCallbackConverter.onFeatureGet(new byte[]{AidlConversionUtils.convertFrameworkToAidlFeature(this.mFeature)});
    L16:
        this.mFeature = -1;
        return;
    L13:
        if (result.status != 0) goto L15;
        this.mHidlToAidlCallbackConverter.onFeatureGet(new byte[0]);
        goto L16
    L15:
        this.mHidlToAidlCallbackConverter.onError(0, this.mUserId, 17, 0);
        goto L16
    }

    public void setFeature(HardwareAuthToken hat, byte feature, boolean enabled) throws RemoteException {
        int faceId = getFaceId();
        if (faceId != (-1)) goto L5;
        return;
    L5:
        ArrayList<Byte> hardwareAuthTokenList = new ArrayList();
        byte[] r2 = HardwareAuthTokenUtils.toByteArray(hat);
        int r3 = r2.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        byte b = r2[r4];
        hardwareAuthTokenList.add(Byte.valueOf(b));
        r4 = r4 + 1;
        goto L6
    L8:
        int result = this.mSession.get().setFeature(AidlConversionUtils.convertAidlToFrameworkFeature(feature), enabled, hardwareAuthTokenList, faceId);
        if (result != 0) goto L11;
        this.mHidlToAidlCallbackConverter.onFeatureSet(feature);
        return;
    L11:
        this.mHidlToAidlCallbackConverter.onError(0, this.mUserId, 17, 0);
    }

    public void getAuthenticatorId() throws RemoteException {
        long authenticatorId = this.mSession.get().getAuthenticatorId().value;
        this.mHidlToAidlCallbackConverter.onAuthenticatorIdRetrieved(authenticatorId);
    }

    public void invalidateAuthenticatorId() throws RemoteException {
        Slog.e(TAG, "invalidateAuthenticatorId unsupported in HIDL");
        this.mHidlToAidlCallbackConverter.onUnsupportedClientScheduled();
    }

    public void resetLockout(HardwareAuthToken hat) throws RemoteException {
        ArrayList<Byte> hardwareAuthToken = new ArrayList();
        byte[] r1 = HardwareAuthTokenUtils.toByteArray(hat);
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        byte b = r1[r3];
        hardwareAuthToken.add(Byte.valueOf(b));
        r3 = r3 + 1;
        goto L3
    L5:
        this.mSession.get().resetLockout(hardwareAuthToken);
    }

    public void close() throws RemoteException {
        Slog.e(TAG, "close unsupported in HIDL");
    }

    public ICancellationSignal authenticateWithContext(long operationId, OperationContext context) throws RemoteException {
        Slog.e(TAG, "authenticateWithContext unsupported in HIDL");
        return authenticate(operationId);
    }

    public ICancellationSignal enrollWithContext(HardwareAuthToken hat, byte type, byte[] features, NativeHandle previewSurface, OperationContext context) throws RemoteException {
        Slog.e(TAG, "enrollWithContext unsupported in HIDL");
        return enroll(hat, type, features, previewSurface);
    }

    public ICancellationSignal detectInteractionWithContext(OperationContext context) throws RemoteException {
        Slog.e(TAG, "detectInteractionWithContext unsupported in HIDL");
        return detectInteraction();
    }

    public void onContextChanged(OperationContext context) throws RemoteException {
        Slog.e(TAG, "onContextChanged unsupported in HIDL");
    }

    public int getInterfaceVersion() throws RemoteException {
        Slog.e(TAG, "getInterfaceVersion unsupported in HIDL");
        return 0;
    }

    public String getInterfaceHash() throws RemoteException {
        Slog.e(TAG, "getInterfaceHash unsupported in HIDL");
        return null;
    }

    public ICancellationSignal enrollWithOptions(FaceEnrollOptions options) {
        Slog.e(TAG, "enrollWithOptions unsupported in HIDL");
        return null;
    }

    private boolean isGeneratedChallengeCacheValid() {
        if (this.mGenerateChallengeCreatedAt != (-1)) goto L5;
    L9:
        return false;
    L5:
        if (this.mGenerateChallengeResult == (-1)) goto L9;
        if ((this.mClock.millis() - this.mGenerateChallengeCreatedAt) >= 60000) goto L9;
        return true;
    }

    private void incrementChallengeCount() {
        this.mGeneratedChallengeCount.add(0, Long.valueOf(this.mClock.millis()));
    }

    private int decrementChallengeCount() {
        final long now = this.mClock.millis();
        this.mGeneratedChallengeCount.removeIf(new HidlToAidlSessionAdapter$$ExternalSyntheticLambda0(now));
        if (this.mGeneratedChallengeCount.isEmpty() == true) goto L6;
        this.mGeneratedChallengeCount.remove(0);
    L6:
        return this.mGeneratedChallengeCount.size();
    }

    private static /* synthetic */ boolean lambda$decrementChallengeCount$0(long now, Long x) {
        if ((now - x.longValue()) <= 600000) goto L5;
        return true;
    L5:
        return false;
    }

    private void setCallback(AidlResponseHandler aidlResponseHandler) {
        this.mHidlToAidlCallbackConverter = new HidlToAidlCallbackConverter(aidlResponseHandler);
        if (this.mSession.get() == null) goto L11;
        long halId = this.mSession.get().setCallback(this.mHidlToAidlCallbackConverter).value;     // Catch: RemoteException -> L8
        Slog.d(TAG, "Face HAL ready, HAL ID: " + halId);     // Catch: RemoteException -> L8
        if (halId != 0) goto L17;
        Slog.d(TAG, "Unable to set HIDL callback.");     // Catch: RemoteException -> L8
    L17:
        return;
    L11:
        Slog.e(TAG, "Unable to set HIDL callback. HIDL daemon is null.");     // Catch: RemoteException -> L8
        return;
    L13:
        Slog.d(TAG, "Failed to set callback");
    }

    private int getFaceId() {
        FaceManager faceManager = (FaceManager) this.mContext.getSystemService(FaceManager.class);
        List<Face> faces = faceManager.getEnrolledFaces(this.mUserId);
        if (faces.isEmpty() == false) goto L7;
        Slog.d(TAG, "No faces to get feature from.");
        this.mHidlToAidlCallbackConverter.onError(0, this.mUserId, 11, 0);
        return -1;
    L7:
        return faces.get(0).getBiometricId();
    }
}
