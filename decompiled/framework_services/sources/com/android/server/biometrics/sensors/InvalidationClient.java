package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricAuthenticator.Identifier;
import android.hardware.biometrics.IInvalidationCallback;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class InvalidationClient<S extends BiometricAuthenticator.Identifier, T> extends HalClientMonitor<T> {
    private static final String TAG = "InvalidationClient";
    private final Map<Integer, Long> mAuthenticatorIds;
    private final IInvalidationCallback mInvalidationCallback;

    public InvalidationClient(Context context, Supplier<T> lazyDaemon, int userId, int sensorId, BiometricLogger logger, BiometricContext biometricContext, Map<Integer, Long> authenticatorIds, IInvalidationCallback callback) {
        super(context, lazyDaemon, null, null, userId, context.getOpPackageName(), 0, sensorId, logger, biometricContext, false);
        this.mAuthenticatorIds = authenticatorIds;
        this.mInvalidationCallback = callback;
    }

    public void onAuthenticatorIdInvalidated(long newAuthenticatorId) {
        long oldAuthenticatorId = this.mAuthenticatorIds.getOrDefault(Integer.valueOf(getTargetUserId()), 0L).longValue();
        Slog.i(TAG, "onAuthenticatorIdInvalidated: userId=" + getTargetUserId() + ", sensorId=" + getSensorId() + ", oldAuthenticatorId=" + oldAuthenticatorId + ", newAuthenticatorId=" + newAuthenticatorId);
        this.mAuthenticatorIds.put(Integer.valueOf(getTargetUserId()), Long.valueOf(newAuthenticatorId));
        this.mInvalidationCallback.onCompleted();     // Catch: RemoteException -> L5
    L7:
        this.mCallback.onClientFinished(this, true);
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        goto L7
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void cancel() {
        super.cancel();
        this.mInvalidationCallback.onCompleted();     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to complete invalidation client due to exception: " + e);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 15;
    }
}
