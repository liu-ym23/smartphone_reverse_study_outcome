package com.android.server.biometrics.sensors;

import android.app.ActivityTaskManager;
import android.app.TaskStackListener;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.hardware.biometrics.AuthenticateOptions;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.security.KeyStoreAuthorization;
import android.util.EventLog;
import android.util.Slog;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class AuthenticationClient<T, O extends AuthenticateOptions> extends AcquisitionClient<T> implements AuthenticationConsumer {
    public static final int STATE_NEW = 0;
    public static final int STATE_STARTED = 1;
    public static final int STATE_STARTED_PAUSED = 2;
    public static final int STATE_STARTED_PAUSED_ATTEMPTED = 3;
    public static final int STATE_STOPPED = 4;
    private static final String TAG = "Biometrics/AuthenticationClient";
    private static final boolean ZTE_IFAA_TEST = false;
    private final ActivityTaskManager mActivityTaskManager;
    private final boolean mAllowBackgroundAuthentication;
    private boolean mAuthAttempted;
    private boolean mAuthSuccess;
    private final BiometricManager mBiometricManager;
    private FingerprintManager mFingerprintManager;
    private final boolean mIsRestricted;
    private final boolean mIsStrongBiometric;
    private final LockoutTracker mLockoutTracker;
    protected final long mOperationId;
    private final O mOptions;
    private final boolean mRequireConfirmation;
    private final int mSensorStrength;
    private final boolean mShouldUseLockoutTracker;
    private long mStartTimeMs;
    protected int mState;
    private final TaskStackListener mTaskStackListener;

    @interface State {
    }

    protected abstract void handleLifecycleAfterAuth(boolean r1);

    public abstract boolean wasUserDetected();

    public AuthenticationClient(Context context, Supplier<T> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, long operationId, boolean restricted, O options, int cookie, boolean requireConfirmation, BiometricLogger biometricLogger, BiometricContext biometricContext, boolean isStrongBiometric, TaskStackListener taskStackListener, LockoutTracker lockoutTracker, boolean allowBackgroundAuthentication, boolean shouldVibrate, int sensorStrength) {
        super(context, lazyDaemon, token, listener, options.getUserId(), options.getOpPackageName(), cookie, options.getSensorId(), shouldVibrate, biometricLogger, biometricContext, options.isMandatoryBiometrics());
        boolean r3 = false;
        this.mState = 0;
        this.mAuthSuccess = false;
        this.mIsStrongBiometric = isStrongBiometric;
        this.mOperationId = operationId;
        this.mRequireConfirmation = requireConfirmation;
        this.mActivityTaskManager = getActivityTaskManager();
        this.mBiometricManager = (BiometricManager) context.getSystemService(BiometricManager.class);
        this.mTaskStackListener = taskStackListener;
        this.mLockoutTracker = lockoutTracker;
        this.mIsRestricted = restricted;
        this.mAllowBackgroundAuthentication = allowBackgroundAuthentication;
        if (lockoutTracker == null) goto L5;
        r3 = true;
    L5:
        this.mShouldUseLockoutTracker = r3;
        this.mSensorStrength = sensorStrength;
        this.mOptions = options;
        this.mFingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    private int handleFailedAttempt(int userId) {
        if (this.mLockoutTracker == null) goto L5;
        this.mLockoutTracker.addFailedAttemptForUser(getTargetUserId());
    L5:
        int lockoutMode = getLockoutTracker().getLockoutModeForUser(userId);
        PerformanceTracker performanceTracker = PerformanceTracker.getInstanceForSensorId(getSensorId());
        if (lockoutMode != 2) goto L9;
        performanceTracker.incrementPermanentLockoutForUser(userId);
    L11:
        return lockoutMode;
    L9:
        if (lockoutMode != 1) goto L11;
        performanceTracker.incrementTimedLockoutForUser(userId);
        goto L11
    }

    protected long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    protected ActivityTaskManager getActivityTaskManager() {
        return ActivityTaskManager.getInstance();
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor, android.os.IBinder.DeathRecipient
    public void binderDied() {
        boolean clearListener = !isBiometricPrompt();
        binderDiedInternal(clearListener);
    }

    public long getOperationId() {
        return this.mOperationId;
    }

    public boolean isRestricted() {
        return this.mIsRestricted;
    }

    public boolean isKeyguard() {
        return Utils.isKeyguard(getContext(), getOwnerString());
    }

    private boolean isSettings() {
        return Utils.isSettings(getContext(), getOwnerString());
    }

    protected O getOptions() {
        return this.mOptions;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    protected boolean isCryptoOperation() {
        if (this.mOperationId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationConsumer
    public void onAuthenticated(BiometricAuthenticator.Identifier identifier, boolean authenticated, ArrayList<Byte> hardwareAuthToken) {
        getLogger().logOnAuthenticated(getContext(), getOperationContext(), authenticated, this.mRequireConfirmation, getTargetUserId(), isBiometricPrompt());
        ClientMonitorCallbackConverter listener = getListener();
        Slog.v(TAG, "onAuthenticated(" + authenticated + "), ID:" + identifier.getBiometricId() + ", Owner: " + getOwnerString() + ", isBP: " + isBiometricPrompt() + ", listener: " + listener + ", requireConfirmation: " + this.mRequireConfirmation + ", user: " + getTargetUserId() + ", clientMonitor: " + this);
        PerformanceTracker pm = PerformanceTracker.getInstanceForSensorId(getSensorId());
        if (isCryptoOperation() == false) goto L5;
        pm.incrementCryptoAuthForUser(getTargetUserId(), authenticated);
    L7:
        if (this.mAllowBackgroundAuthentication == false) goto L10;
        Slog.w(TAG, "Allowing background authentication, this is allowed only for platform or test invocations");
    L10:
        if (this.mAllowBackgroundAuthentication == true) goto L17;
        if (authenticated == false) goto L17;
        if (Utils.isKeyguard(getContext(), getOwnerString()) == true) goto L17;
        if (Utils.isSystem(getContext(), getOwnerString()) == true) goto L17;
        boolean isBackgroundAuth = Utils.isBackground(getOwnerString());
        boolean isBackgroundAuth2 = isBackgroundAuth;
    L18:
        int r0 = -1;
        if (isBackgroundAuth2 == false) goto L25;
        Slog.e(TAG, "Failing possible background authentication");
        ApplicationInfo appInfo = getContext().getApplicationInfo();
        if (appInfo == null) goto L23;
        int r7 = appInfo.uid;
    L24:
        EventLog.writeEvent(1397638484, new Object[]{"159249069", Integer.valueOf(r7), "Attempted background authentication"});
        boolean authenticated2 = false;
    L27:
        if (authenticated2 == false) goto L57;
        if (isBackgroundAuth2 == false) goto L33;
        ApplicationInfo appInfo2 = getContext().getApplicationInfo();
        if (appInfo2 == null) goto L32;
        r0 = appInfo2.uid;
    L32:
        EventLog.writeEvent(1397638484, new Object[]{"159249069", Integer.valueOf(r0), "Successful background authentication!"});
    L33:
        this.mAuthSuccess = true;
        markAlreadyDone();
        if (this.mTaskStackListener == null) goto L36;
        this.mActivityTaskManager.unregisterTaskStackListener(this.mTaskStackListener);
    L36:
        byte[] byteToken = new byte[hardwareAuthToken.size()];
        int i = 0;
    L38:
        if (i >= hardwareAuthToken.size()) goto L41;
        byteToken[i] = hardwareAuthToken.get(i).byteValue();
        i = i + 1;
        goto L38
    L41:
        if (isBiometricPrompt() == true) goto L47;
        this.mBiometricManager.resetLockoutTimeBound(getToken(), getContext().getOpPackageName(), getSensorId(), getTargetUserId(), byteToken);
        int result = KeyStoreAuthorization.getInstance().addAuthToken(byteToken);
        if (result == 0) goto L45;
        Slog.d(TAG, "Error adding auth token : " + result);
    L74:
    L51:
        e = move-exception;
        Slog.e(TAG, "Unable to notify listener", e);
        this.mCallback.onClientFinished(this, false);
        return;
    L49:
        if (this.mIsRestricted == true) goto L53;
        listener.onAuthenticationSucceeded(getSensorId(), identifier, byteToken, getTargetUserId(), this.mIsStrongBiometric);     // Catch: RemoteException -> L51
    L73:
    L68:
        handleLifecycleAfterAuth(authenticated2);
        return;
    L53:
        listener.onAuthenticationSucceeded(getSensorId(), null, byteToken, getTargetUserId(), this.mIsStrongBiometric);     // Catch: RemoteException -> L51
        goto L73
    L45:
        Slog.d(TAG, "addAuthToken succeeded");
        goto L74
    L47:
        Slog.d(TAG, "Skipping addAuthToken");
        goto L74
    L57:
        if (isBackgroundAuth2 == false) goto L63;
        Slog.e(TAG, "Sending cancel to client(Due to background auth)");
        if (this.mTaskStackListener == null) goto L61;
        this.mActivityTaskManager.unregisterTaskStackListener(this.mTaskStackListener);
    L61:
        sendCancelOnly(getListener());
        this.mCallback.onClientFinished(this, false);
        goto L68
    L63:
        if (this.mShouldUseLockoutTracker == false) goto L76;
        int lockoutMode = handleFailedAttempt(getTargetUserId());
        if (lockoutMode == 0) goto L76;
        markAlreadyDone();
    L76:
        int lockoutMode2 = getSensorId();     // Catch: RemoteException -> L70
        listener.onAuthenticationFailed(lockoutMode2);     // Catch: RemoteException -> L70
    L70:
        e = move-exception;
        Slog.e(TAG, "Unable to notify listener", e);
        this.mCallback.onClientFinished(this, false);
        return;
    L23:
        r7 = -1;
        goto L24
    L25:
        authenticated2 = authenticated;
    L17:
        isBackgroundAuth2 = false;
        goto L18
    L5:
        pm.incrementAuthForUser(getTargetUserId(), authenticated);
        goto L7
    }

    private void sendCancelOnly(ClientMonitorCallbackConverter listener) {
        if (listener != null) goto L11;
        Slog.e(TAG, "Unable to sendAuthenticationCanceled, listener null");
        return;
    L11:
        listener.onError(getSensorId(), getCookie(), 5, 0);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    public void onAcquired(int acquiredInfo, int vendorCode) {
        super.onAcquired(acquiredInfo, vendorCode);
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient, com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int errorCode, int vendorCode) {
        super.onError(errorCode, vendorCode);
        this.mState = 4;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        if (this.mShouldUseLockoutTracker == false) goto L5;
        int lockoutMode = this.mLockoutTracker.getLockoutModeForUser(getTargetUserId());
    L7:
        if (lockoutMode == 0) goto L15;
        Slog.v(TAG, "In lockout mode(" + lockoutMode + ") ; disallowing authentication");
        if (lockoutMode != 1) goto L11;
        int errorCode = 7;
    L12:
        onError(errorCode, 0);
        return;
    L11:
        errorCode = 9;
        goto L12
    L15:
        if (this.mTaskStackListener == null) goto L17;
        this.mActivityTaskManager.registerTaskStackListener(this.mTaskStackListener);
    L17:
        Slog.d(TAG, "Requesting auth for " + getOwnerString() + " id=" + this.mOptions.getSensorId());
        this.mStartTimeMs = System.currentTimeMillis();
        this.mAuthAttempted = true;
        startHalOperation();
        return;
    L5:
        lockoutMode = getBiometricContext().getAuthSessionCoordinator().getLockoutStateFor(getTargetUserId(), this.mSensorStrength);
        goto L7
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient, com.android.server.biometrics.sensors.BaseClientMonitor
    public void cancel() {
        super.cancel();
        if (this.mTaskStackListener == null) goto L6;
        this.mActivityTaskManager.unregisterTaskStackListener(this.mTaskStackListener);
        return;
    }

    public int getState() {
        return this.mState;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 3;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public boolean interruptsPrecedingClients() {
        return true;
    }

    public boolean wasAuthAttempted() {
        return this.mAuthAttempted;
    }

    public boolean wasAuthSuccessful() {
        return this.mAuthSuccess;
    }

    protected int getSensorStrength() {
        return this.mSensorStrength;
    }

    protected LockoutTracker getLockoutTracker() {
        return this.mLockoutTracker;
    }

    protected int getRequestReason() {
        if (isKeyguard() == false) goto L7;
        return 4;
    L7:
        if (isBiometricPrompt() == false) goto L11;
        return 3;
    L11:
        if (isSettings() == false) goto L14;
        return 6;
    L14:
        return 5;
    }
}
