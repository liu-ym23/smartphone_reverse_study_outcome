package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricAuthenticator.Identifier;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class RemovalClient<S extends BiometricAuthenticator.Identifier, T> extends HalClientMonitor<T> implements RemovalConsumer, EnrollmentModifier {
    private static final String TAG = "Biometrics/RemovalClient";
    private final Map<Integer, Long> mAuthenticatorIds;
    private final BiometricUtils<S> mBiometricUtils;
    private final boolean mHasEnrollmentsBeforeStarting;
    private final int mReason;

    public RemovalClient(Context context, Supplier<T> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int userId, String owner, BiometricUtils<S> utils, int sensorId, BiometricLogger logger, BiometricContext biometricContext, Map<Integer, Long> authenticatorIds, int reason) {
        super(context, lazyDaemon, token, listener, userId, owner, 0, sensorId, logger, biometricContext, false);
        this.mBiometricUtils = utils;
        this.mAuthenticatorIds = authenticatorIds;
        this.mHasEnrollmentsBeforeStarting = !utils.getBiometricsForUser(context, userId).isEmpty();
        this.mReason = reason;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.RemovalConsumer
    public void onRemoved(BiometricAuthenticator.Identifier identifier, int remaining) {
        if (identifier != null) goto L11;
        Slog.e(TAG, "identifier was null, skipping onRemove()");
        getListener().onError(getSensorId(), getCookie(), 6, 0);     // Catch: RemoteException -> L7
    L9:
        this.mCallback.onClientFinished(this, false);
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to send error to client for onRemoved", e);
        goto L9
    L11:
        Slog.d(TAG, "onRemoved: " + identifier.getBiometricId() + " remaining: " + remaining);
        this.mBiometricUtils.removeBiometricForUser(getContext(), getTargetUserId(), identifier.getBiometricId());
        getLogger().logOnUnEnrolled(getTargetUserId(), this.mReason, identifier.getBiometricId());
        getListener().onRemoved(identifier, remaining);     // Catch: RemoteException -> L14
    L16:
        if (remaining == 0) goto L18;
        return;
    L18:
        if (this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId()).isEmpty() == false) goto L20;
        Slog.d(TAG, "Last biometric removed for user: " + getTargetUserId());
        this.mAuthenticatorIds.put(Integer.valueOf(getTargetUserId()), 0L);
    L20:
        this.mCallback.onClientFinished(this, true);
        return;
    L14:
        e = move-exception;
        Slog.w(TAG, "Failed to notify Removed:", e);
        goto L16
    }

    @Override // com.android.server.biometrics.sensors.EnrollmentModifier
    public boolean hasEnrollmentStateChanged() {
        boolean hasEnrollmentsNow = !this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId()).isEmpty();
        if (hasEnrollmentsNow != this.mHasEnrollmentsBeforeStarting) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.biometrics.sensors.EnrollmentModifier
    public boolean hasEnrollments() {
        return !this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId()).isEmpty();
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 4;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public boolean interruptsPrecedingClients() {
        return true;
    }
}
