package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricFingerprintConstants;
import android.hardware.biometrics.BiometricSourceType;
import android.hardware.biometrics.common.ICancellationSignal;
import android.hardware.biometrics.common.OperationContext;
import android.hardware.biometrics.events.AuthenticationAcquiredInfo;
import android.hardware.biometrics.events.AuthenticationErrorInfo;
import android.hardware.biometrics.events.AuthenticationHelpInfo;
import android.hardware.biometrics.events.AuthenticationStartedInfo;
import android.hardware.biometrics.events.AuthenticationStoppedInfo;
import android.hardware.biometrics.fingerprint.PointerContext;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintEnrollOptions;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.hardware.fingerprint.IUdfpsOverlayController;
import android.hardware.keymaster.HardwareAuthToken;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.accessibility.AccessibilityManager;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.log.CallbackWithProbe;
import com.android.server.biometrics.log.OperationContextExt;
import com.android.server.biometrics.log.Probe;
import com.android.server.biometrics.sensors.AuthenticationStateListeners;
import com.android.server.biometrics.sensors.BiometricNotificationUtils;
import com.android.server.biometrics.sensors.BiometricUtils;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.ClientMonitorCompositeCallback;
import com.android.server.biometrics.sensors.EnrollClient;
import com.android.server.biometrics.sensors.SensorOverlays;
import com.android.server.biometrics.sensors.fingerprint.PowerPressHandler;
import com.android.server.biometrics.sensors.fingerprint.Udfps;
import com.android.server.biometrics.sensors.fingerprint.UdfpsHelper;
import com.android.server.resmng.BoostHintType;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintEnrollClient extends EnrollClient<AidlSession> implements Udfps, PowerPressHandler {
    private static final String TAG = "FingerprintEnrollClient";
    private final CallbackWithProbe<Probe> mALSProbeCallback;
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private ICancellationSignal mCancellationSignal;
    private final int mEnrollReason;
    private boolean mIsPointerDown;
    private final int mMaxTemplatesPerUser;
    private final SensorOverlays mSensorOverlays;
    private final FingerprintSensorPropertiesInternal mSensorProps;
    private final SysOptPerfLock mSysOptPerfLock;

    public static /* synthetic */ void $r8$lambda$0a2kouCmLnei7VJwMg8RXNutO8s(AidlSession r0, OperationContext r1) {
        lambda$doEnroll$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$9u2X-LIO0sH_uafiCOq8qW2w8R8, reason: not valid java name */
    public static /* synthetic */ void m2710$r8$lambda$9u2XLIO0sH_uafiCOq8qW2w8R8(FingerprintEnrollClient r0, int r1, IUdfpsOverlayController r2) {
        r0.lambda$onAcquired$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Va6iePbulBBgpWX5wuITGLjqYhA(FingerprintEnrollClient r0, int r1, int r2, IUdfpsOverlayController r3) {
        r0.lambda$onAcquired$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$YgsUMpCAm9Jt0PeOCbD6Km6PYXo(FingerprintEnrollClient r0, int r1, IUdfpsOverlayController r2) {
        r0.lambda$onEnrollResult$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$kbae79sJn08yS8RqtAWl7WukucY(FingerprintEnrollClient r0, AidlSession r1, HardwareAuthToken r2, OperationContext r3) {
        r0.lambda$doEnroll$3(r1, r2, r3);
    }

    private static boolean shouldVibrateFor(Context context, FingerprintSensorPropertiesInternal sensorProps) {
        if (sensorProps == null) goto L10;
        AccessibilityManager am = (AccessibilityManager) context.getSystemService(AccessibilityManager.class);
        boolean isAccessbilityEnabled = am.isTouchExplorationEnabled();
        if (sensorProps.isAnyUdfpsType() == false) goto L11;
        if (isAccessbilityEnabled == true) goto L12;
        return false;
    L12:
        return true;
    L11:
        return true;
    L10:
        return true;
    }

    public FingerprintEnrollClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, long requestId, ClientMonitorCallbackConverter listener, int userId, byte[] hardwareAuthToken, String owner, BiometricUtils<Fingerprint> utils, int sensorId, BiometricLogger logger, BiometricContext biometricContext, FingerprintSensorPropertiesInternal sensorProps, IUdfpsOverlayController udfpsOverlayController, AuthenticationStateListeners authenticationStateListeners, int maxTemplatesPerUser, int enrollReason, FingerprintEnrollOptions options) {
        super(context, lazyDaemon, token, listener, userId, hardwareAuthToken, owner, utils, 0, sensorId, shouldVibrateFor(context, sensorProps), logger, biometricContext, BiometricFingerprintConstants.reasonToMetric(options.getEnrollReason()));
        this.mSysOptPerfLock = new SysOptPerfLock();
        setRequestId(requestId);
        this.mSensorProps = sensorProps;
        this.mSensorOverlays = new SensorOverlays(udfpsOverlayController);
        this.mAuthenticationStateListeners = authenticationStateListeners;
        this.mMaxTemplatesPerUser = maxTemplatesPerUser;
        this.mALSProbeCallback = getLogger().getAmbientLightProbe(true);
        this.mEnrollReason = enrollReason;
        if (enrollReason != 1) goto L5;
        getLogger().disableMetrics();
    L5:
        Slog.w(TAG, "EnrollOptions " + FingerprintEnrollOptions.enrollReasonToString(options.getEnrollReason()) + " id = " + this.mSensorProps.sensorId + " sensorType=" + this.mSensorProps.sensorType + " strength=" + this.mSensorProps.sensorStrength);
    }

    @Override // com.android.server.biometrics.sensors.EnrollClient, com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        BiometricNotificationUtils.cancelFingerprintEnrollNotification(getContext());
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    protected ClientMonitorCallback wrapCallbackForStart(ClientMonitorCallback callback) {
        return new ClientMonitorCompositeCallback(new ClientMonitorCallback[]{this.mALSProbeCallback, getBiometricContextUnsubscriber(), callback});
    }

    @Override // com.android.server.biometrics.sensors.EnrollClient
    public void onEnrollResult(BiometricAuthenticator.Identifier identifier, final int remaining) {
        super.onEnrollResult(identifier, remaining);
        this.mSensorOverlays.ifUdfps(new FingerprintEnrollClient$$ExternalSyntheticLambda2(this, remaining));
        if (remaining != 0) goto L6;
        this.mSysOptPerfLock.release("onEnrollResult remaining=0");
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReasonFromFingerprintEnrollReason(this.mEnrollReason)).build());
        notifyLastEnrollmentTime(1);
        return;
    }

    private /* synthetic */ void lambda$onEnrollResult$0(int remaining, IUdfpsOverlayController controller) throws RemoteException {
        controller.onEnrollmentProgress(getSensorId(), remaining);
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    public void onAcquired(final int acquiredInfo, final int vendorCode) {
        if (acquiredInfo == 7) goto L5;
        this.mAuthenticationStateListeners.onAuthenticationAcquired(new AuthenticationAcquiredInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReasonFromFingerprintEnrollReason(this.mEnrollReason), acquiredInfo).build());
    L5:
        String helpMsg = FingerprintManager.getAcquiredString(getContext(), acquiredInfo, vendorCode);
        if (helpMsg == null) goto L13;
        if (acquiredInfo != 6) goto L10;
        int helpCode = vendorCode + 1000;
    L11:
        this.mAuthenticationStateListeners.onAuthenticationHelp(new AuthenticationHelpInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReasonFromFingerprintEnrollReason(this.mEnrollReason), helpMsg, helpCode).build());
        goto L13
    L10:
        helpCode = acquiredInfo;
    L13:
        if (acquiredInfo != 0) goto L15;
        boolean acquiredGood = true;
    L17:
        if (this.mSensorProps != null) goto L19;
    L25:
        this.mSensorOverlays.ifUdfps(new FingerprintEnrollClient$$ExternalSyntheticLambda4(this, acquiredInfo, vendorCode));
        this.mCallback.onBiometricAction(0);
        super.onAcquired(acquiredInfo, vendorCode);
        return;
    L19:
        if (this.mSensorProps.isAnyUdfpsType() == false) goto L25;
        if (acquiredGood == true) goto L22;
    L24:
        this.mSensorOverlays.ifUdfps(new FingerprintEnrollClient$$ExternalSyntheticLambda3(this, acquiredInfo));
        goto L25
    L22:
        if (this.mShouldVibrate == false) goto L24;
        vibrateSuccess();
        goto L24
    L15:
        acquiredGood = false;
        goto L17
    }

    private /* synthetic */ void lambda$onAcquired$1(int acquiredInfo, IUdfpsOverlayController controller) throws RemoteException {
        controller.onAcquired(getSensorId(), acquiredInfo);
    }

    private /* synthetic */ void lambda$onAcquired$2(int acquiredInfo, int vendorCode, IUdfpsOverlayController controller) throws RemoteException {
        if (UdfpsHelper.isValidAcquisitionMessage(getContext(), acquiredInfo, vendorCode) == false) goto L6;
        controller.onEnrollmentHelp(getSensorId());
        return;
    }

    @Override // com.android.server.biometrics.sensors.EnrollClient, com.android.server.biometrics.sensors.AcquisitionClient, com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int errorCode, int vendorCode) {
        if (SysOptPerfLock.shouldReleaseOnError(errorCode) == false) goto L5;
        this.mSysOptPerfLock.release("onError errorCode=" + errorCode);
    L5:
        this.mAuthenticationStateListeners.onAuthenticationError(new AuthenticationErrorInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReasonFromFingerprintEnrollReason(this.mEnrollReason), FingerprintManager.getErrorString(getContext(), errorCode, vendorCode), errorCode).build());
        super.onError(errorCode, vendorCode);
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReasonFromFingerprintEnrollReason(this.mEnrollReason)).build());
    }

    @Override // com.android.server.biometrics.sensors.EnrollClient
    protected boolean hasReachedEnrollmentLimit() {
        if (this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId()).size() < this.mMaxTemplatesPerUser) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        this.mSensorOverlays.show(getSensorId(), getRequestReasonFromFingerprintEnrollReason(this.mEnrollReason), this);
        this.mAuthenticationStateListeners.onAuthenticationStarted(new AuthenticationStartedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReasonFromFingerprintEnrollReason(this.mEnrollReason)).build());
        BiometricNotificationUtils.cancelBadCalibrationNotification(getContext());
        doEnroll();     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting enroll", e);
        onError(2, 0);
        this.mCallback.onClientFinished(this, false);
    }

    private void doEnroll() throws RemoteException {
        final AidlSession session = getFreshDaemon();
        final HardwareAuthToken hat = HardwareAuthTokenUtils.toHardwareAuthToken(this.mHardwareAuthToken);
        if (session.hasContextMethods() == false) goto L5;
        OperationContextExt opContext = getOperationContext();
        getBiometricContext().subscribe(opContext, new FingerprintEnrollClient$$ExternalSyntheticLambda0(this, session, hat), new FingerprintEnrollClient$$ExternalSyntheticLambda1(session), null);
        return;
    L5:
        this.mCancellationSignal = session.getSession().enroll(hat);
    }

    private /* synthetic */ void lambda$doEnroll$3(AidlSession session, HardwareAuthToken hat, OperationContext ctx) {
        this.mCancellationSignal = session.getSession().enrollWithContext(hat, ctx);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting enroll", e);
        onError(2, 0);
        this.mCallback.onClientFinished(this, false);
    }

    private static /* synthetic */ void lambda$doEnroll$4(AidlSession session, OperationContext ctx) {
        session.getSession().onContextChanged(ctx);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to notify context changed", e);
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    protected void stopHalOperation() {
        this.mSysOptPerfLock.release("stopHalOperation");
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, getRequestReasonFromFingerprintEnrollReason(this.mEnrollReason)).build());
        unsubscribeBiometricContext();
        if (this.mCancellationSignal == null) goto L11;
        this.mCancellationSignal.cancel();     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting cancel", e);
        onError(1, 0);
        this.mCallback.onClientFinished(this, false);
        return;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public void onPointerDown(PointerContext pc) {
        this.mIsPointerDown = true;     // Catch: RemoteException -> L5
        AidlSession r0 = getFreshDaemon();     // Catch: RemoteException -> L5
        getListener().onUdfpsPointerDown(getSensorId());     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to send pointer down", e);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public void onPointerUp(PointerContext pc) {
        this.mIsPointerDown = false;     // Catch: RemoteException -> L5
        AidlSession r0 = getFreshDaemon();     // Catch: RemoteException -> L5
        getListener().onUdfpsPointerUp(getSensorId());     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to send pointer up", e);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public boolean isPointerDown() {
        return this.mIsPointerDown;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public void onUdfpsUiEvent(int event) {
        switch(event) {
            case 1: goto L8;
            case 2: goto L7;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "No matching event for onUdfpsUiEvent");     // Catch: RemoteException -> L5
    L12:
        return;
    L7:
        getFreshDaemon().getSession().onUiReady();     // Catch: RemoteException -> L5
        goto L12
    L8:
        getListener().onUdfpsOverlayShown();     // Catch: RemoteException -> L5
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to send onUdfpsUiEvent", e);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.Udfps
    public void setIgnoreDisplayTouches(boolean ignoreTouches) {
        getFreshDaemon().getSession().setIgnoreDisplayTouches(ignoreTouches);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to send setIgnoreDisplayTouches", e);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.PowerPressHandler
    public void onPowerPressed() {
    }

    public void onUdfpsTouchDownForPerf() {
        this.mSysOptPerfLock.acquireType(BoostHintType.RESMNG_HINT_SCROLL_CPU_BOOST, 0, 6000);
    }
}
