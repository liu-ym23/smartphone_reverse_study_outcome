package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.hardware.biometrics.BiometricSourceType;
import android.hardware.biometrics.common.ICancellationSignal;
import android.hardware.biometrics.common.OperationContext;
import android.hardware.biometrics.events.AuthenticationStartedInfo;
import android.hardware.biometrics.events.AuthenticationStoppedInfo;
import android.hardware.fingerprint.FingerprintAuthenticateOptions;
import android.hardware.fingerprint.IUdfpsOverlayController;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.log.OperationContextExt;
import com.android.server.biometrics.sensors.AcquisitionClient;
import com.android.server.biometrics.sensors.AuthenticationStateListeners;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.DetectionConsumer;
import com.android.server.biometrics.sensors.SensorOverlays;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintDetectClient extends AcquisitionClient<AidlSession> implements DetectionConsumer {
    private static final String TAG = "FingerprintDetectClient";
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private ICancellationSignal mCancellationSignal;
    private final boolean mIsStrongBiometric;
    private final FingerprintAuthenticateOptions mOptions;
    private final SensorOverlays mSensorOverlays;

    public static /* synthetic */ void $r8$lambda$DIWoqlRgB7vaMQON8Qjb9cvTMnk(FingerprintDetectClient r0, AidlSession r1, OperationContext r2) {
        r0.lambda$doDetectInteraction$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$JMcKdQkB38y2d1Gvj_JDk5lkkeM(AidlSession r0, OperationContext r1) {
        lambda$doDetectInteraction$1(r0, r1);
    }

    public FingerprintDetectClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, long requestId, ClientMonitorCallbackConverter listener, FingerprintAuthenticateOptions options, BiometricLogger biometricLogger, BiometricContext biometricContext, AuthenticationStateListeners authenticationStateListeners, IUdfpsOverlayController udfpsOverlayController, boolean isStrongBiometric) {
        super(context, lazyDaemon, token, listener, options.getUserId(), options.getOpPackageName(), 0, options.getSensorId(), true, biometricLogger, biometricContext, false);
        setRequestId(requestId);
        this.mAuthenticationStateListeners = authenticationStateListeners;
        this.mIsStrongBiometric = isStrongBiometric;
        this.mSensorOverlays = new SensorOverlays(udfpsOverlayController);
        this.mOptions = options;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    protected void stopHalOperation() {
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, 4).build());
        unsubscribeBiometricContext();
        if (this.mCancellationSignal == null) goto L11;
        this.mCancellationSignal.cancel();     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        this.mCallback.onClientFinished(this, false);
        return;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        this.mSensorOverlays.show(getSensorId(), 4, this);
        this.mAuthenticationStateListeners.onAuthenticationStarted(new AuthenticationStartedInfo.Builder(BiometricSourceType.FINGERPRINT, 4).build());
        doDetectInteraction();     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting finger detect", e);
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, 4).build());
        this.mCallback.onClientFinished(this, false);
    }

    private void doDetectInteraction() throws RemoteException {
        final AidlSession session = getFreshDaemon();
        if (session.hasContextMethods() == false) goto L5;
        OperationContextExt opContext = getOperationContext();
        getBiometricContext().subscribe(opContext, new FingerprintDetectClient$$ExternalSyntheticLambda0(this, session), new FingerprintDetectClient$$ExternalSyntheticLambda1(session), this.mOptions);
        return;
    L5:
        this.mCancellationSignal = session.getSession().detectInteraction();
    }

    private /* synthetic */ void lambda$doDetectInteraction$0(AidlSession session, OperationContext ctx) {
        this.mCancellationSignal = session.getSession().detectInteractionWithContext(ctx);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to start detect interaction", e);
        this.mSensorOverlays.hide(getSensorId());
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FINGERPRINT, 4).build());
        this.mCallback.onClientFinished(this, false);
    }

    private static /* synthetic */ void lambda$doDetectInteraction$1(AidlSession session, OperationContext ctx) {
        session.getSession().onContextChanged(ctx);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to notify context changed", e);
    }

    @Override // com.android.server.biometrics.sensors.DetectionConsumer
    public void onInteractionDetected() {
        vibrateSuccess();
        getListener().onDetected(getSensorId(), getTargetUserId(), this.mIsStrongBiometric);     // Catch: RemoteException -> L5
        this.mCallback.onClientFinished(this, true);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception when sending onDetected", e);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 13;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public boolean interruptsPrecedingClients() {
        return true;
    }
}
