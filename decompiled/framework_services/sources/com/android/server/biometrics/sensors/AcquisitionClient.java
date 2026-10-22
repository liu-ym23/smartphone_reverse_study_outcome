package com.android.server.biometrics.sensors;

import android.content.Context;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class AcquisitionClient<T> extends HalClientMonitor<T> implements ErrorConsumer {
    private static final VibrationEffect ERROR_VIBRATION_EFFECT = null;
    private static final VibrationAttributes HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES = null;
    private static final VibrationEffect SUCCESS_VIBRATION_EFFECT = null;
    private static final String TAG = "Biometrics/AcquisitionClient";
    private boolean mAlreadyCancelled;
    private final Object mCancelLock;
    private final PowerManager mPowerManager;
    private boolean mShouldSendErrorToClient;
    protected final boolean mShouldVibrate;

    protected abstract void stopHalOperation();

    static {
        HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES = VibrationAttributes.createForUsage(50);
        SUCCESS_VIBRATION_EFFECT = VibrationEffect.get(0);
        ERROR_VIBRATION_EFFECT = VibrationEffect.get(1);
    }

    public AcquisitionClient(Context context, Supplier<T> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int userId, String owner, int cookie, int sensorId, boolean shouldVibrate, BiometricLogger logger, BiometricContext biometricContext, boolean isMandatoryBiometrics) {
        super(context, lazyDaemon, token, listener, userId, owner, cookie, sensorId, logger, biometricContext, isMandatoryBiometrics);
        this.mShouldSendErrorToClient = true;
        this.mCancelLock = new Object();
        this.mPowerManager = (PowerManager) context.getSystemService(PowerManager.class);
        this.mShouldVibrate = shouldVibrate;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
        getListener().onError(getSensorId(), getCookie(), 1, 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to send error", e);
    }

    @Override // com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int errorCode, int vendorCode) {
        onErrorInternal(errorCode, vendorCode, true);
    }

    public void onUserCanceled() {
        Slog.d(TAG, "onUserCanceled");
        onErrorInternal(10, 0, false);
        Object r0 = this.mCancelLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAlreadyCancelled == false) goto L11;
        Slog.w(TAG, "onUserCanceled Cancel was already requested");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mAlreadyCancelled = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        stopHalOperation();
    }

    protected void onErrorInternal(int errorCode, int vendorCode, boolean finish) {
        Slog.d(TAG, "onErrorInternal code: " + errorCode + ", finish: " + finish);
        if (this.mShouldSendErrorToClient == false) goto L10;
        getLogger().logOnError(getContext(), getOperationContext(), errorCode, vendorCode, getTargetUserId());
        this.mShouldSendErrorToClient = false;     // Catch: RemoteException -> L7
        getListener().onError(getSensorId(), getCookie(), errorCode, vendorCode);     // Catch: RemoteException -> L7
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to invoke sendError", e);
    L10:
        if (finish == true) goto L12;
        return;
    L12:
        if (this.mCallback != null) goto L14;
        Slog.e(TAG, "Callback is null, perhaps the client hasn't been started yet?");
        return;
    L14:
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void cancel() {
        Object r0 = this.mCancelLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAlreadyCancelled == false) goto L11;
        Slog.w(TAG, "Cancel was already requested");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mAlreadyCancelled = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        stopHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void cancelWithoutStarting(ClientMonitorCallback callback) {
        Slog.d(TAG, "cancelWithoutStarting: " + this);
        getListener().onError(getSensorId(), getCookie(), 5, 0);     // Catch: RemoteException -> L5
    L7:
        callback.onClientFinished(this, true);
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Failed to invoke sendError", e);
        goto L7
    }

    public void onAcquired(int acquiredInfo, int vendorCode) {
        onAcquiredInternal(acquiredInfo, vendorCode, true);
    }

    protected final void onAcquiredInternal(int acquiredInfo, int vendorCode, boolean shouldSend) {
        getLogger().logOnAcquired(getContext(), getOperationContext(), acquiredInfo, vendorCode, getTargetUserId());
        Slog.v(TAG, "Acquired: " + acquiredInfo + " " + vendorCode + ", shouldSend: " + shouldSend);
        if (acquiredInfo != 0) goto L5;
        notifyUserActivity();
    L5:
        if (shouldSend == false) goto L14;
        getListener().onAcquired(getSensorId(), acquiredInfo, vendorCode);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to invoke sendAcquired", e);
        this.mCallback.onClientFinished(this, false);
        return;
    }

    final void notifyUserActivity() {
        long now = SystemClock.uptimeMillis();
        this.mPowerManager.userActivity(now, 2, 0);
    }

    protected final void vibrateSuccess() {
        Vibrator vibrator = (Vibrator) getContext().getSystemService(Vibrator.class);
        if (vibrator != null) goto L5;
        return;
    L5:
        if (this.mShouldVibrate == false) goto L9;
        vibrator.vibrate(Process.myUid(), getContext().getOpPackageName(), VibrationEffect.get(1), getClass().getSimpleName() + "::success", HARDWARE_FEEDBACK_VIBRATION_ATTRIBUTES);
        return;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public boolean isInterruptable() {
        return true;
    }

    public boolean isAlreadyCancelled() {
        Object r0 = this.mCancelLock;
        monitor-enter(r0);
        boolean r1 = this.mAlreadyCancelled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
