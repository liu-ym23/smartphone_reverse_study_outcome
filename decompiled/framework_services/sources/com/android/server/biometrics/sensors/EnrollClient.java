package com.android.server.biometrics.sensors;

import android.content.Context;
import android.content.Intent;
import android.hardware.biometrics.BiometricAuthenticator;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.AuthenticationStatsCollector;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.Arrays;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class EnrollClient<T> extends AcquisitionClient<T> implements EnrollmentModifier {
    private static final String TAG = "Biometrics/EnrollClient";
    protected final BiometricUtils mBiometricUtils;
    private final int mEnrollReason;
    private long mEnrollmentStartTimeMs;
    protected final byte[] mHardwareAuthToken;
    private final boolean mHasEnrollmentsBeforeStarting;
    protected final int mTimeoutSec;

    protected abstract boolean hasReachedEnrollmentLimit();

    public EnrollClient(Context context, Supplier<T> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int userId, byte[] hardwareAuthToken, String owner, BiometricUtils utils, int timeoutSec, int sensorId, boolean shouldVibrate, BiometricLogger logger, BiometricContext biometricContext, int enrollReason) {
        super(context, lazyDaemon, token, listener, userId, owner, 0, sensorId, shouldVibrate, logger, biometricContext, false);
        this.mBiometricUtils = utils;
        this.mHardwareAuthToken = Arrays.copyOf(hardwareAuthToken, hardwareAuthToken.length);
        this.mTimeoutSec = timeoutSec;
        this.mHasEnrollmentsBeforeStarting = hasEnrollments();
        this.mEnrollReason = enrollReason;
    }

    @Override // com.android.server.biometrics.sensors.EnrollmentModifier
    public boolean hasEnrollmentStateChanged() {
        boolean hasEnrollmentsNow = hasEnrollments();
        if (hasEnrollmentsNow == this.mHasEnrollmentsBeforeStarting) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.biometrics.sensors.EnrollmentModifier
    public boolean hasEnrollments() {
        return !this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId()).isEmpty();
    }

    public void onEnrollResult(BiometricAuthenticator.Identifier identifier, int remaining) {
        if (this.mShouldVibrate == false) goto L5;
        vibrateSuccess();
    L5:
        ClientMonitorCallbackConverter listener = getListener();
        listener.onEnrollResult(identifier, remaining);     // Catch: RemoteException -> L8
    L10:
        if (remaining != 0) goto L12;
        this.mBiometricUtils.addBiometricForUser(getContext(), getTargetUserId(), identifier);
        getLogger().logOnEnrolled(getTargetUserId(), System.currentTimeMillis() - this.mEnrollmentStartTimeMs, true, this.mEnrollReason, identifier.getBiometricId());
        this.mCallback.onClientFinished(this, true);
    L12:
        notifyUserActivity();
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        goto L10
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        if (hasReachedEnrollmentLimit() == false) goto L6;
        Slog.e(TAG, "Reached enrollment limit");
        callback.onClientFinished(this, false);
        return;
    L6:
        this.mEnrollmentStartTimeMs = System.currentTimeMillis();
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient, com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int error, int vendorCode) {
        getLogger().logOnEnrolled(getTargetUserId(), System.currentTimeMillis() - this.mEnrollmentStartTimeMs, false, this.mEnrollReason, -1);
        super.onError(error, vendorCode);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 2;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public boolean interruptsPrecedingClients() {
        return true;
    }

    protected int getRequestReasonFromFingerprintEnrollReason(int reason) {
        switch(reason) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 2;
    L7:
        return 1;
    }

    protected int getRequestReasonFromFaceEnrollReason(int reason) {
        switch(reason) {
            case 1: goto L4;
            case 2: goto L4;
            case 3: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 2;
    }

    protected void notifyLastEnrollmentTime(int modality) {
        Intent intent = new Intent(AuthenticationStatsCollector.ACTION_LAST_ENROLL_TIME_CHANGED);
        intent.putExtra("android.intent.extra.user_handle", getTargetUserId());
        intent.putExtra(AuthenticationStatsCollector.EXTRA_MODALITY, modality);
        getContext().sendBroadcast(intent);
    }
}
