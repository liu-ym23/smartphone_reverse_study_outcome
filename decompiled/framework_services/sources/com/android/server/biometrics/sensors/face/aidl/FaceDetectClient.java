package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.hardware.SensorPrivacyManager;
import android.hardware.biometrics.BiometricSourceType;
import android.hardware.biometrics.common.ICancellationSignal;
import android.hardware.biometrics.common.OperationContext;
import android.hardware.biometrics.events.AuthenticationErrorInfo;
import android.hardware.biometrics.events.AuthenticationStartedInfo;
import android.hardware.biometrics.events.AuthenticationStoppedInfo;
import android.hardware.face.FaceAuthenticateOptions;
import android.hardware.face.FaceManager;
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
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceDetectClient extends AcquisitionClient<AidlSession> implements DetectionConsumer {
    private static final String TAG = "FaceDetectClient";
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private ICancellationSignal mCancellationSignal;
    private final boolean mIsStrongBiometric;
    private final FaceAuthenticateOptions mOptions;
    private SensorPrivacyManager mSensorPrivacyManager;

    /* JADX INFO: renamed from: $r8$lambda$VdXaVH2fkF0c-kpHNkPwXASKJlU, reason: not valid java name */
    public static /* synthetic */ void m2661$r8$lambda$VdXaVH2fkF0ckpHNkPwXASKJlU(FaceDetectClient r0, AidlSession r1, OperationContext r2) {
        r0.lambda$doDetectInteraction$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$hhfZHzWIXh2_YZbPVhD4K4QPWZI(AidlSession r0, OperationContext r1) {
        lambda$doDetectInteraction$1(r0, r1);
    }

    FaceDetectClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, long requestId, ClientMonitorCallbackConverter listener, FaceAuthenticateOptions options, BiometricLogger logger, BiometricContext biometricContext, AuthenticationStateListeners authenticationStateListeners, boolean isStrongBiometric) {
        this(context, lazyDaemon, token, requestId, listener, options, logger, biometricContext, authenticationStateListeners, isStrongBiometric, (SensorPrivacyManager) context.getSystemService(SensorPrivacyManager.class));
    }

    FaceDetectClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, long requestId, ClientMonitorCallbackConverter listener, FaceAuthenticateOptions options, BiometricLogger logger, BiometricContext biometricContext, AuthenticationStateListeners authenticationStateListeners, boolean isStrongBiometric, SensorPrivacyManager sensorPrivacyManager) {
        super(context, lazyDaemon, token, listener, options.getUserId(), options.getOpPackageName(), 0, options.getSensorId(), false, logger, biometricContext, false);
        setRequestId(requestId);
        this.mAuthenticationStateListeners = authenticationStateListeners;
        this.mIsStrongBiometric = isStrongBiometric;
        this.mSensorPrivacyManager = sensorPrivacyManager;
        this.mOptions = options;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    protected void stopHalOperation() {
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FACE, 4).build());
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
        this.mAuthenticationStateListeners.onAuthenticationStarted(new AuthenticationStartedInfo.Builder(BiometricSourceType.FACE, 4).build());
        if (this.mSensorPrivacyManager != null) goto L5;
    L13:
        doDetectInteraction();     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting face detect", e);
        this.mCallback.onClientFinished(this, false);
        return;
    L5:
        if (this.mSensorPrivacyManager.isSensorPrivacyEnabled(1, 2) == false) goto L13;
        onError(1, 0);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient, com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int error, int vendorCode) {
        this.mAuthenticationStateListeners.onAuthenticationError(new AuthenticationErrorInfo.Builder(BiometricSourceType.FACE, 4, FaceManager.getErrorString(getContext(), error, vendorCode), error).build());
        super.onError(error, vendorCode);
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FACE, 4).build());
    }

    private void doDetectInteraction() throws RemoteException {
        final AidlSession session = getFreshDaemon();
        if (session.hasContextMethods() == false) goto L5;
        OperationContextExt opContext = getOperationContext();
        getBiometricContext().subscribe(opContext, new FaceDetectClient$$ExternalSyntheticLambda0(this, session), new FaceDetectClient$$ExternalSyntheticLambda1(session), this.mOptions);
        return;
    L5:
        this.mCancellationSignal = session.getSession().detectInteraction();
    }

    private /* synthetic */ void lambda$doDetectInteraction$0(AidlSession session, OperationContext ctx) {
        this.mCancellationSignal = session.getSession().detectInteractionWithContext(ctx);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting face detect", e);
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
