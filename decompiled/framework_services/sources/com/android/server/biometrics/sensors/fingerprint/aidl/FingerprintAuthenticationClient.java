package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.app.TaskStackListener;
import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricSourceType;
import android.hardware.biometrics.common.ICancellationSignal;
import android.hardware.biometrics.common.OperationContext;
import android.hardware.biometrics.events.AuthenticationAcquiredInfo;
import android.hardware.biometrics.events.AuthenticationErrorInfo;
import android.hardware.biometrics.events.AuthenticationFailedInfo;
import android.hardware.biometrics.events.AuthenticationHelpInfo;
import android.hardware.biometrics.events.AuthenticationStartedInfo;
import android.hardware.biometrics.events.AuthenticationStoppedInfo;
import android.hardware.biometrics.events.AuthenticationSucceededInfo;
import android.hardware.biometrics.fingerprint.PointerContext;
import android.hardware.fingerprint.FingerprintAuthenticateOptions;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.hardware.fingerprint.IUdfpsOverlayController;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.log.CallbackWithProbe;
import com.android.server.biometrics.log.OperationContextExt;
import com.android.server.biometrics.log.Probe;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import com.android.server.biometrics.sensors.AuthenticationClient;
import com.android.server.biometrics.sensors.AuthenticationStateListeners;
import com.android.server.biometrics.sensors.BiometricNotificationUtils;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.ClientMonitorCompositeCallback;
import com.android.server.biometrics.sensors.LockoutConsumer;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.PerformanceTracker;
import com.android.server.biometrics.sensors.SensorOverlays;
import com.android.server.biometrics.sensors.fingerprint.PowerPressHandler;
import com.android.server.biometrics.sensors.fingerprint.Udfps;
import com.android.server.resmng.BoostHintType;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintAuthenticationClient extends AuthenticationClient<AidlSession, FingerprintAuthenticateOptions> implements Udfps, LockoutConsumer, PowerPressHandler {
    private static final String TAG = "FingerprintAuthenticationClient";
    private final CallbackWithProbe<Probe> mALSProbeCallback;
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private ICancellationSignal mCancellationSignal;
    private boolean mIsPointerDown;
    private final boolean mIsStrongBiometric;
    private final SensorOverlays mSensorOverlays;
    private final FingerprintSensorPropertiesInternal mSensorProps;
    private final SysOptPerfLock mSysOptPerfLock;

    public static /* synthetic */ void $r8$lambda$VCApUq2pd4oQhJ0f2eJ1baHvYjs(FingerprintAuthenticationClient r0, int r1, IUdfpsOverlayController r2) {
        r0.lambda$onAcquired$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$pRuCvm5SDZPS85SCF205HlaSRcQ(FingerprintAuthenticationClient r0, AidlSession r1, OperationContext r2) {
        r0.lambda$doAuthenticate$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$yqOAMBDaASaakK4jKwj1pbG-M1g, reason: not valid java name */
    public static /* synthetic */ void m2709$r8$lambda$yqOAMBDaASaakK4jKwj1pbGM1g(FingerprintAuthenticationClient r0, AidlSession r1, OperationContext r2) {
        r0.lambda$doAuthenticate$2(r1, r2);
    }

    public FingerprintAuthenticationClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, long requestId, ClientMonitorCallbackConverter listener, long operationId, boolean restricted, FingerprintAuthenticateOptions options, int cookie, boolean requireConfirmation, BiometricLogger biometricLogger, BiometricContext biometricContext, boolean isStrongBiometric, TaskStackListener taskStackListener, IUdfpsOverlayController udfpsOverlayController, AuthenticationStateListeners authenticationStateListeners, boolean allowBackgroundAuthentication, FingerprintSensorPropertiesInternal sensorProps, int biometricStrength, LockoutTracker lockoutTracker) {
        super(context, lazyDaemon, token, listener, operationId, restricted, options, cookie, requireConfirmation, biometricLogger, biometricContext, isStrongBiometric, taskStackListener, lockoutTracker, allowBackgroundAuthentication, false, biometricStrength);
        this.mSysOptPerfLock = new SysOptPerfLock();
        setRequestId(requestId);
        this.mSensorOverlays = new SensorOverlays(udfpsOverlayController);
        this.mAuthenticationStateListeners = authenticationStateListeners;
        this.mIsStrongBiometric = isStrongBiometric;
        this.mSensorProps = sensorProps;
        this.mALSProbeCallback = getLogger().getAmbientLightProbe(false);
        this.mAuthSessionCoordinator = biometricContext.getAuthSessionCoordinator();
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient, com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        if (this.mSensorProps.isAnyUdfpsType() == false) goto L5;
        this.mState = 2;
        return;
    L5:
        this.mState = 1;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    protected ClientMonitorCallback wrapCallbackForStart(ClientMonitorCallback callback) {
        return new ClientMonitorCompositeCallback(new ClientMonitorCallback[]{this.mALSProbeCallback, getBiometricContextUnsubscriber(), callback});
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient
    protected void handleLifecycleAfterAuth(boolean authenticated) {
        if (authenticated == false) goto L5;
        this.mCallback.onClientFinished(this, true);
        return;
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient
    public boolean wasUserDetected() {
        return false;
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient, com.android.server.biometrics.sensors.AuthenticationConsumer
    public void onAuthenticated(BiometricAuthenticator.Identifier identifier, boolean authenticated, ArrayList<Byte> token) {
        this.mSysOptPerfLock.release("onAuthenticated authenticated=" + authenticated);
        super.onAuthenticated(identifier, authenticated, token);
        handleLockout(authenticated);
        if (authenticated == false) goto L5;
        this.mState = 4;
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationSucceeded(new AuthenticationSucceededInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason(), this.mIsStrongBiometric, getTargetUserId()).build());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason()).build());
        return;
    L5:
        this.mState = 3;
        this.mAuthenticationStateListeners.onAuthenticationFailed(new AuthenticationFailedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason(), getTargetUserId()).build());
    }

    private void handleLockout(boolean authenticated) {
        if (getLockoutTracker() != null) goto L7;
        Slog.d(TAG, "Lockout is implemented by the HAL");
        return;
    L7:
        if (authenticated == false) goto L9;
        getLockoutTracker().resetFailedAttemptsForUser(true, getTargetUserId());
        return;
    L9:
        int lockoutMode = getLockoutTracker().getLockoutModeForUser(getTargetUserId());
        if (lockoutMode == 0) goto L18;
        Slog.w(TAG, "Fingerprint locked out, lockoutMode(" + lockoutMode + ")");
        if (lockoutMode != 1) goto L14;
        int errorCode = 7;
    L15:
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationError(new AuthenticationErrorInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason(), FingerprintManager.getErrorString(getContext(), errorCode, 0), errorCode).build());
        onErrorInternal(errorCode, 0, false);
        cancel();
        return;
    L14:
        errorCode = 9;
        goto L15
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient, com.android.server.biometrics.sensors.AcquisitionClient
    public void onAcquired(final int acquiredInfo, int vendorCode) {
        this.mAuthenticationStateListeners.onAuthenticationAcquired(new AuthenticationAcquiredInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason(), acquiredInfo).build());
        if (acquiredInfo == 7) goto L11;
        String helpMsg = FingerprintManager.getAcquiredString(getContext(), acquiredInfo, vendorCode);
        if (helpMsg == null) goto L11;
        if (acquiredInfo != 6) goto L9;
        int helpCode = vendorCode + 1000;
    L10:
        this.mAuthenticationStateListeners.onAuthenticationHelp(new AuthenticationHelpInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason(), helpMsg, helpCode).build());
        goto L11
    L9:
        helpCode = acquiredInfo;
    L11:
        this.mSensorOverlays.ifUdfps(new FingerprintAuthenticationClient$$ExternalSyntheticLambda0(this, acquiredInfo));
        super.onAcquired(acquiredInfo, vendorCode);
        PerformanceTracker pt = PerformanceTracker.getInstanceForSensorId(getSensorId());
        pt.incrementAcquireForUser(getTargetUserId(), isCryptoOperation());
    }

    private /* synthetic */ void lambda$onAcquired$0(int acquiredInfo, IUdfpsOverlayController controller) throws RemoteException {
        controller.onAcquired(getSensorId(), acquiredInfo);
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient, com.android.server.biometrics.sensors.AcquisitionClient, com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int errorCode, int vendorCode) {
        if (SysOptPerfLock.shouldReleaseOnError(errorCode) == false) goto L5;
        this.mSysOptPerfLock.release("onError errorCode=" + errorCode);
    L5:
        this.mAuthenticationStateListeners.onAuthenticationError(new AuthenticationErrorInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason(), FingerprintManager.getErrorString(getContext(), errorCode, vendorCode), errorCode).build());
        super.onError(errorCode, vendorCode);
        if (errorCode != 18) goto L8;
        BiometricNotificationUtils.showBadCalibrationNotification(getContext());
    L8:
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason()).build());
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        this.mSensorOverlays.show(getSensorId(), getRequestReason(), this);
        this.mAuthenticationStateListeners.onAuthenticationStarted(new AuthenticationStartedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason()).build());
        doAuthenticate();     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        onError(1, 0);
        this.mSensorOverlays.hide(getSensorId());
        this.mCallback.onClientFinished(this, false);
    }

    private void doAuthenticate() throws RemoteException {
        final AidlSession session = getFreshDaemon();
        OperationContextExt opContext = getOperationContext();
        getBiometricContext().subscribe(opContext, new FingerprintAuthenticationClient$$ExternalSyntheticLambda1(this, session), new FingerprintAuthenticationClient$$ExternalSyntheticLambda2(this, session), getOptions());
    }

    private /* synthetic */ void lambda$doAuthenticate$1(AidlSession session, OperationContext ctx) {
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        onError(1, 0);
        this.mSensorOverlays.hide(getSensorId());
        this.mCallback.onClientFinished(this, false);
        return;
    L3:
        if (session.hasContextMethods() == false) goto L7;
        this.mCancellationSignal = session.getSession().authenticateWithContext(this.mOperationId, ctx);     // Catch: RemoteException -> L5
    L9:
        if (getBiometricContext().isAwake() == false) goto L11;
        this.mALSProbeCallback.getProbe().enable();     // Catch: RemoteException -> L5
        return;
    L11:
        this.mALSProbeCallback.getProbe().disable();     // Catch: RemoteException -> L5
        return;
    L7:
        this.mCancellationSignal = session.getSession().authenticate(this.mOperationId);     // Catch: RemoteException -> L5
        goto L9
    }

    private /* synthetic */ void lambda$doAuthenticate$2(AidlSession session, OperationContext ctx) {
        if (session.hasContextMethods() == true) goto L13;
    L8:
        boolean isAwake = getBiometricContext().isAwake();
        if (isAwake == false) goto L11;
        this.mALSProbeCallback.getProbe().enable();
        return;
    L11:
        this.mALSProbeCallback.getProbe().disable();
        return;
    L13:
        session.getSession().onContextChanged(ctx);     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Unable to notify context changed", e);
        goto L8
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    protected void stopHalOperation() {
        this.mSysOptPerfLock.release("stopHalOperation");
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason()).build());
        unsubscribeBiometricContext();
        Slog.d(TAG, "stopHalOperation start cancel id=" + getSensorId() + " trace=" + Log.getStackTraceString(new Throwable()));
        if (this.mCancellationSignal != null) goto L11;
        Slog.e(TAG, "Cancellation signal was null");
        this.mCallback.onClientFinished(this, false);
    L9:
        Slog.d(TAG, "stopHalOperation start end id=" + getSensorId());
        return;
    L11:
        this.mCancellationSignal.cancel();     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        onError(1, 0);
        this.mCallback.onClientFinished(this, false);
        goto L9
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public void onPointerDown(PointerContext pc) {
        this.mIsPointerDown = true;     // Catch: RemoteException -> L5
        this.mState = 1;     // Catch: RemoteException -> L5
        AidlSession r0 = getFreshDaemon();     // Catch: RemoteException -> L5
        getListener().onUdfpsPointerDown(getSensorId());     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public void onPointerUp(PointerContext pc) {
        this.mIsPointerDown = false;     // Catch: RemoteException -> L5
        this.mState = 3;     // Catch: RemoteException -> L5
        AidlSession r0 = getFreshDaemon();     // Catch: RemoteException -> L5
        getListener().onUdfpsPointerUp(getSensorId());     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public void setIgnoreDisplayTouches(boolean ignoreTouches) {
        getFreshDaemon().getSession().setIgnoreDisplayTouches(ignoreTouches);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public boolean isPointerDown() {
        return this.mIsPointerDown;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public void onUdfpsUiEvent(int event) {
        if (event != 2) goto L12;
        getFreshDaemon().getSession().onUiReady();     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        return;
    }

    @Override // com.android.server.biometrics.sensors.LockoutConsumer
    public void onLockoutTimed(long durationMillis) {
        this.mAuthSessionCoordinator.lockOutTimed(getTargetUserId(), getSensorStrength(), getSensorId(), durationMillis, getRequestId());
        getLogger().logOnError(getContext(), getOperationContext(), 7, 0, getTargetUserId());
        PerformanceTracker.getInstanceForSensorId(getSensorId()).incrementTimedLockoutForUser(getTargetUserId());
        this.mAuthenticationStateListeners.onAuthenticationError(new AuthenticationErrorInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason(), FingerprintManager.getErrorString(getContext(), 7, 0), 7).build());     // Catch: RemoteException -> L5
        getListener().onError(getSensorId(), getCookie(), 7, 0);     // Catch: RemoteException -> L5
    L7:
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason()).build());
        this.mCallback.onClientFinished(this, false);
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        goto L7
    }

    @Override // com.android.server.biometrics.sensors.LockoutConsumer
    public void onLockoutPermanent() {
        this.mAuthSessionCoordinator.lockedOutFor(getTargetUserId(), getSensorStrength(), getSensorId(), getRequestId());
        getLogger().logOnError(getContext(), getOperationContext(), 9, 0, getTargetUserId());
        PerformanceTracker.getInstanceForSensorId(getSensorId()).incrementPermanentLockoutForUser(getTargetUserId());
        this.mAuthenticationStateListeners.onAuthenticationError(new AuthenticationErrorInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason(), FingerprintManager.getErrorString(getContext(), 9, 0), 9).build());     // Catch: RemoteException -> L5
        getListener().onError(getSensorId(), getCookie(), 9, 0);     // Catch: RemoteException -> L5
    L7:
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReason()).build());
        this.mCallback.onClientFinished(this, false);
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        goto L7
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.PowerPressHandler
    public void onPowerPressed() {
    }

    public void onUdfpsTouchDownForPerf() {
        this.mSysOptPerfLock.acquireType(BoostHintType.RESMNG_HINT_SCROLL_CPU_BOOST, 0, 800);
    }
}
