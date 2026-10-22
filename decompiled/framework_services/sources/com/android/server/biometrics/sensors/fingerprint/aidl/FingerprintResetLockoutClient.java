package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
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
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintResetLockoutClient extends HalClientMonitor<AidlSession> implements ErrorConsumer {
    private static final String TAG = "FingerprintResetLockoutClient";
    private final int mBiometricStrength;
    private final HardwareAuthToken mHardwareAuthToken;
    private final LockoutTracker mLockoutCache;
    private final LockoutResetDispatcher mLockoutResetDispatcher;

    public FingerprintResetLockoutClient(Context context, Supplier<AidlSession> lazyDaemon, int userId, String owner, int sensorId, BiometricLogger biometricLogger, BiometricContext biometricContext, byte[] hardwareAuthToken, LockoutTracker lockoutTracker, LockoutResetDispatcher lockoutResetDispatcher, int biometricStrength) {
        super(context, lazyDaemon, null, null, userId, owner, 0, sensorId, biometricLogger, biometricContext, false);
        if (hardwareAuthToken != null) goto L5;
        HardwareAuthToken r1 = null;
    L6:
        this.mHardwareAuthToken = r1;
        this.mLockoutCache = lockoutTracker;
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
        this.mBiometricStrength = biometricStrength;
        return;
    L5:
        r1 = HardwareAuthTokenUtils.toHardwareAuthToken(hardwareAuthToken);
        goto L6
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
        getFreshDaemon().getSession().resetLockout(this.mHardwareAuthToken);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to reset lockout", e);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public boolean interruptsPrecedingClients() {
        return true;
    }

    void onLockoutCleared() {
        resetLocalLockoutStateToNone(getSensorId(), getTargetUserId(), this.mLockoutCache, this.mLockoutResetDispatcher, getBiometricContext().getAuthSessionCoordinator(), this.mBiometricStrength, getRequestId());
        this.mCallback.onClientFinished(this, true);
    }

    static void resetLocalLockoutStateToNone(int sensorId, int userId, LockoutTracker lockoutTracker, LockoutResetDispatcher lockoutResetDispatcher, AuthSessionCoordinator authSessionCoordinator, int biometricStrength, long requestId) {
        lockoutTracker.resetFailedAttemptsForUser(true, userId);
        lockoutTracker.setLockoutModeForUser(userId, 0);
        lockoutResetDispatcher.notifyLockoutResetCallbacks(sensorId);
        authSessionCoordinator.resetLockoutFor(userId, biometricStrength, requestId);
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
