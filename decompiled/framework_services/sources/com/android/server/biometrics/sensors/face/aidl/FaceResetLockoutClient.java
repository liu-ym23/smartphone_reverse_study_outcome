package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.hardware.biometrics.face.ISession;
import android.hardware.keymaster.HardwareAuthToken;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ErrorConsumer;
import com.android.server.biometrics.sensors.HalClientMonitor;
import com.android.server.biometrics.sensors.LockoutResetDispatcher;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.face.hidl.HidlToAidlSessionAdapter;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceResetLockoutClient extends HalClientMonitor<AidlSession> implements ErrorConsumer {
    private static final String TAG = "FaceResetLockoutClient";
    private final int mBiometricStrength;
    private final HardwareAuthToken mHardwareAuthToken;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private final LockoutTracker mLockoutTracker;

    public FaceResetLockoutClient(Context context, Supplier<AidlSession> lazyDaemon, int userId, String owner, int sensorId, BiometricLogger logger, BiometricContext biometricContext, byte[] hardwareAuthToken, LockoutTracker lockoutTracker, LockoutResetDispatcher lockoutResetDispatcher, int biometricStrength) {
        super(context, lazyDaemon, null, null, userId, owner, 0, sensorId, logger, biometricContext, false);
        this.mHardwareAuthToken = HardwareAuthTokenUtils.toHardwareAuthToken(hardwareAuthToken);
        this.mLockoutTracker = lockoutTracker;
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
        this.mBiometricStrength = biometricStrength;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        ISession session = getFreshDaemon().getSession();     // Catch: RemoteException -> L6
        session.resetLockout(this.mHardwareAuthToken);     // Catch: RemoteException -> L6
        if ((session instanceof HidlToAidlSessionAdapter) == false) goto L13;
        this.mCallback.onClientFinished(this, true);     // Catch: RemoteException -> L6
        return;
    L13:
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Unable to reset lockout", e);
        this.mCallback.onClientFinished(this, false);
    }

    void onLockoutCleared() {
        resetLocalLockoutStateToNone(getSensorId(), getTargetUserId(), this.mLockoutTracker, this.mLockoutResetDispatcher, getBiometricContext().getAuthSessionCoordinator(), this.mBiometricStrength, getRequestId());
        this.mCallback.onClientFinished(this, true);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public boolean interruptsPrecedingClients() {
        return true;
    }

    static void resetLocalLockoutStateToNone(int sensorId, int userId, LockoutTracker lockoutTracker, LockoutResetDispatcher lockoutResetDispatcher, AuthSessionCoordinator authSessionCoordinator, int biometricStrength, long requestId) {
        authSessionCoordinator.resetLockoutFor(userId, biometricStrength, requestId);
        lockoutTracker.setLockoutModeForUser(userId, 0);
        lockoutResetDispatcher.notifyLockoutResetCallbacks(sensorId);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 12;
    }

    @Override // com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int errorCode, int vendorCode) {
        Slog.e(TAG, "Error during resetLockout: " + errorCode);
        this.mCallback.onClientFinished(this, false);
    }
}
