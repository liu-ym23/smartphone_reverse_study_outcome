package com.android.server.biometrics.sensors.fingerprint.hidl;

import android.hardware.biometrics.common.ICancellationSignal;
import android.hardware.biometrics.common.OperationContext;
import android.hardware.biometrics.fingerprint.ISession;
import android.hardware.biometrics.fingerprint.PointerContext;
import android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint;
import android.hardware.keymaster.HardwareAuthToken;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.Slog;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.sensors.fingerprint.UdfpsHelper;
import com.android.server.biometrics.sensors.fingerprint.aidl.AidlResponseHandler;
import com.android.server.biometrics.sensors.fingerprint.aidl.FingerprintGetAuthenticatorIdClient;
import com.android.server.biometrics.sensors.fingerprint.aidl.FingerprintInvalidationClient;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class HidlToAidlSessionAdapter implements ISession {
    static final int ENROLL_TIMEOUT_SEC = 60;
    private final String TAG;
    private HidlToAidlCallbackConverter mHidlToAidlCallbackConverter;
    private final Supplier<IBiometricsFingerprint> mSession;
    private final int mUserId;

    private class Cancellation extends ICancellationSignal.Stub {
        final /* synthetic */ HidlToAidlSessionAdapter this$0;

        Cancellation(HidlToAidlSessionAdapter r1) {
            this.this$0 = r1;
        }

        public void cancel() throws RemoteException {
            ((IBiometricsFingerprint) HidlToAidlSessionAdapter.m2753$$Nest$fgetmSession(this.this$0).get()).cancel();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e("HidlToAidlSessionAdapter", "Remote exception when requesting cancel", e);
        }

        public int getInterfaceVersion() throws RemoteException {
            return 0;
        }

        public String getInterfaceHash() throws RemoteException {
            return null;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m2753$$Nest$fgetmSession(HidlToAidlSessionAdapter r0) {
        return r0.mSession;
    }

    public HidlToAidlSessionAdapter(Supplier<IBiometricsFingerprint> session, int userId, AidlResponseHandler aidlResponseHandler) {
        this.TAG = "HidlToAidlSessionAdapter";
        this.mSession = session;
        this.mUserId = userId;
        setCallback(aidlResponseHandler);
    }

    public IBinder asBinder() {
        return null;
    }

    public void generateChallenge() throws RemoteException {
        long challenge = this.mSession.get().preEnroll();
        this.mHidlToAidlCallbackConverter.onChallengeGenerated(challenge);
    }

    public void revokeChallenge(long challenge) throws RemoteException {
        this.mSession.get().postEnroll();
        this.mHidlToAidlCallbackConverter.onChallengeRevoked(0);
    }

    public ICancellationSignal enroll(HardwareAuthToken hat) throws RemoteException {
        this.mSession.get().enroll(HardwareAuthTokenUtils.toByteArray(hat), this.mUserId, 60);
        return new Cancellation(this);
    }

    public ICancellationSignal authenticate(long operationId) throws RemoteException {
        this.mSession.get().authenticate(operationId, this.mUserId);
        return new Cancellation(this);
    }

    public ICancellationSignal detectInteraction() throws RemoteException {
        this.mSession.get().authenticate(0, this.mUserId);
        return new Cancellation(this);
    }

    public void enumerateEnrollments() throws RemoteException {
        this.mSession.get().enumerate();
    }

    public void removeEnrollments(int[] enrollmentIds) throws RemoteException {
        if (enrollmentIds.length <= 1) goto L5;
        this.mSession.get().remove(this.mUserId, 0);
        return;
    L5:
        this.mSession.get().remove(this.mUserId, enrollmentIds[0]);
    }

    public void onPointerDown(int pointerId, int x, int y, float minor, float major) throws RemoteException {
        UdfpsHelper.onFingerDown(this.mSession.get(), x, y, minor, major);
    }

    public void onPointerUp(int pointerId) throws RemoteException {
        UdfpsHelper.onFingerUp(this.mSession.get());
    }

    public void getAuthenticatorId() throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "getAuthenticatorId unsupported in HIDL");
        this.mHidlToAidlCallbackConverter.unsupportedClientScheduled(FingerprintGetAuthenticatorIdClient.class);
    }

    public void invalidateAuthenticatorId() throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "invalidateAuthenticatorId unsupported in HIDL");
        this.mHidlToAidlCallbackConverter.unsupportedClientScheduled(FingerprintInvalidationClient.class);
    }

    public void resetLockout(HardwareAuthToken hat) throws RemoteException {
        this.mHidlToAidlCallbackConverter.onResetLockout();
    }

    public void close() throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "close unsupported in HIDL");
    }

    public void onUiReady() throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "onUiReady unsupported in HIDL");
    }

    public ICancellationSignal authenticateWithContext(long operationId, OperationContext context) throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "authenticateWithContext unsupported in HIDL");
        return authenticate(operationId);
    }

    public ICancellationSignal enrollWithContext(HardwareAuthToken hat, OperationContext context) throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "enrollWithContext unsupported in HIDL");
        return enroll(hat);
    }

    public ICancellationSignal detectInteractionWithContext(OperationContext context) throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "enrollWithContext unsupported in HIDL");
        return detectInteraction();
    }

    public void onPointerDownWithContext(PointerContext context) throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "onPointerDownWithContext unsupported in HIDL");
        onPointerDown(context.pointerId, (int) context.x, (int) context.y, context.minor, context.major);
    }

    public void onPointerUpWithContext(PointerContext context) throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "onPointerUpWithContext unsupported in HIDL");
        onPointerUp(context.pointerId);
    }

    public void onContextChanged(OperationContext context) throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "onContextChanged unsupported in HIDL");
    }

    public void onPointerCancelWithContext(PointerContext context) throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "onPointerCancelWithContext unsupported in HIDL");
    }

    public void setIgnoreDisplayTouches(boolean shouldIgnore) throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "setIgnoreDisplayTouches unsupported in HIDL");
    }

    public int getInterfaceVersion() throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "getInterfaceVersion unsupported in HIDL");
        return 0;
    }

    public String getInterfaceHash() throws RemoteException {
        Log.e("HidlToAidlSessionAdapter", "getInterfaceHash unsupported in HIDL");
        return null;
    }

    protected IBiometricsFingerprint getIBiometricsFingerprint() {
        return this.mSession.get();
    }

    public long getAuthenticatorIdForUpdateClient() throws RemoteException {
        return this.mSession.get().getAuthenticatorId();
    }

    public void setActiveGroup(int userId, String absolutePath) throws RemoteException {
        this.mSession.get().setActiveGroup(userId, absolutePath);
    }

    private void setCallback(AidlResponseHandler aidlResponseHandler) {
        this.mHidlToAidlCallbackConverter = new HidlToAidlCallbackConverter(aidlResponseHandler);
        if (this.mSession.get() == null) goto L11;
        long halId = this.mSession.get().setNotify(this.mHidlToAidlCallbackConverter);     // Catch: RemoteException -> L8
        Slog.d("HidlToAidlSessionAdapter", "Fingerprint HAL ready, HAL ID: " + halId);     // Catch: RemoteException -> L8
        if (halId != 0) goto L17;
        Slog.d("HidlToAidlSessionAdapter", "Unable to set HIDL callback.");     // Catch: RemoteException -> L8
    L17:
        return;
    L11:
        Slog.e("HidlToAidlSessionAdapter", "Unable to set HIDL callback. HIDL daemon is null.");     // Catch: RemoteException -> L8
        return;
    L13:
        Slog.d("HidlToAidlSessionAdapter", "Failed to set callback");
    }
}
