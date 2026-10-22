package com.android.server.biometrics.sensors.face.aidl;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.SensorPrivacyManager;
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
import android.hardware.face.FaceAuthenticateOptions;
import android.hardware.face.FaceAuthenticationFrame;
import android.hardware.face.FaceManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.log.OperationContextExt;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import com.android.server.biometrics.sensors.AuthenticationClient;
import com.android.server.biometrics.sensors.AuthenticationStateListeners;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.ClientMonitorCompositeCallback;
import com.android.server.biometrics.sensors.LockoutConsumer;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.PerformanceTracker;
import com.android.server.biometrics.sensors.face.UsageStats;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceAuthenticationClient extends AuthenticationClient<AidlSession, FaceAuthenticateOptions> implements LockoutConsumer {
    private static final String TAG = "FaceAuthenticationClient";
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private final int[] mBiometricPromptIgnoreList;
    private final int[] mBiometricPromptIgnoreListVendor;
    private ICancellationSignal mCancellationSignal;
    private final boolean mIsStrongBiometric;
    private final int[] mKeyguardIgnoreList;
    private final int[] mKeyguardIgnoreListVendor;
    private int mLastAcquire;
    private final SensorPrivacyManager mSensorPrivacyManager;
    private final UsageStats mUsageStats;

    /* JADX INFO: renamed from: $r8$lambda$Pav-y8GBl-jPxuxHPc1knrj_V8I, reason: not valid java name */
    public static /* synthetic */ void m2660$r8$lambda$Pavy8GBljPxuxHPc1knrj_V8I(AidlSession r0, OperationContext r1) {
        lambda$doAuthenticate$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$a8THIas3fvOxRS0hIcvKiZx6mpQ(FaceAuthenticationClient r0, AidlSession r1, OperationContext r2) {
        r0.lambda$doAuthenticate$0(r1, r2);
    }

    public FaceAuthenticationClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, long requestId, ClientMonitorCallbackConverter listener, long operationId, boolean restricted, FaceAuthenticateOptions options, int cookie, boolean requireConfirmation, BiometricLogger logger, BiometricContext biometricContext, boolean isStrongBiometric, UsageStats usageStats, LockoutTracker lockoutCache, boolean allowBackgroundAuthentication, int sensorStrength, AuthenticationStateListeners authenticationStateListeners) {
        this(context, lazyDaemon, token, requestId, listener, operationId, restricted, options, cookie, requireConfirmation, logger, biometricContext, isStrongBiometric, usageStats, lockoutCache, allowBackgroundAuthentication, (SensorPrivacyManager) context.getSystemService(SensorPrivacyManager.class), sensorStrength, authenticationStateListeners);
    }

    FaceAuthenticationClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, long requestId, ClientMonitorCallbackConverter listener, long operationId, boolean restricted, FaceAuthenticateOptions options, int cookie, boolean requireConfirmation, BiometricLogger logger, BiometricContext biometricContext, boolean isStrongBiometric, UsageStats usageStats, LockoutTracker lockoutTracker, boolean allowBackgroundAuthentication, SensorPrivacyManager sensorPrivacyManager, int biometricStrength, AuthenticationStateListeners authenticationStateListeners) {
        super(context, lazyDaemon, token, listener, operationId, restricted, options, cookie, requireConfirmation, logger, biometricContext, isStrongBiometric, null, lockoutTracker, allowBackgroundAuthentication, false, biometricStrength);
        this.mLastAcquire = 23;
        setRequestId(requestId);
        this.mIsStrongBiometric = isStrongBiometric;
        this.mUsageStats = usageStats;
        this.mSensorPrivacyManager = sensorPrivacyManager;
        this.mAuthSessionCoordinator = biometricContext.getAuthSessionCoordinator();
        this.mAuthenticationStateListeners = authenticationStateListeners;
        Resources resources = getContext().getResources();
        this.mBiometricPromptIgnoreList = resources.getIntArray(R.array.config_highDisplayBrightnessThresholdsOfFixedRefreshRate);
        this.mBiometricPromptIgnoreListVendor = resources.getIntArray(R.array.config_keep_warming_services);
        this.mKeyguardIgnoreList = resources.getIntArray(R.array.config_integrityRuleProviderPackages);
        this.mKeyguardIgnoreListVendor = resources.getIntArray(R.array.config_localPrivateDisplayPorts);
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient, com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        this.mState = 1;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    protected ClientMonitorCallback wrapCallbackForStart(ClientMonitorCallback callback) {
        return new ClientMonitorCompositeCallback(new ClientMonitorCallback[]{getLogger().getAmbientLightProbe(true), callback});
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        this.mAuthenticationStateListeners.onAuthenticationStarted(new AuthenticationStartedInfo.Builder(BiometricSourceType.FACE, getRequestReason()).build());
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting auth", e);
        onError(1, 0);
        this.mCallback.onClientFinished(this, false);
        return;
    L4:
        if (this.mSensorPrivacyManager != null) goto L6;
    L10:
        doAuthenticate();     // Catch: RemoteException -> L8
    L14:
        return;
    L6:
        if (this.mSensorPrivacyManager.isSensorPrivacyEnabled(1, 2) == false) goto L10;
        onError(1, 0);     // Catch: RemoteException -> L8
        this.mCallback.onClientFinished(this, false);     // Catch: RemoteException -> L8
        goto L14
    }

    private void doAuthenticate() throws RemoteException {
        final AidlSession session = getFreshDaemon();
        if (session.hasContextMethods() == false) goto L5;
        OperationContextExt opContext = getOperationContext();
        getBiometricContext().subscribe(opContext, new FaceAuthenticationClient$$ExternalSyntheticLambda0(this, session), new FaceAuthenticationClient$$ExternalSyntheticLambda1(session), getOptions());
        return;
    L5:
        this.mCancellationSignal = session.getSession().authenticate(this.mOperationId);
    }

    private /* synthetic */ void lambda$doAuthenticate$0(AidlSession session, OperationContext ctx) {
        this.mCancellationSignal = session.getSession().authenticateWithContext(this.mOperationId, ctx);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting auth", e);
        onError(1, 0);
        this.mCallback.onClientFinished(this, false);
    }

    private static /* synthetic */ void lambda$doAuthenticate$1(AidlSession session, OperationContext ctx) {
        session.getSession().onContextChanged(ctx);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to notify context changed", e);
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    protected void stopHalOperation() {
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FACE, getRequestReason()).build());
        unsubscribeBiometricContext();
        if (this.mCancellationSignal != null) goto L10;
        Slog.e(TAG, "Cancellation signal is null");
        this.mCallback.onClientFinished(this, false);
        return;
    L10:
        this.mCancellationSignal.cancel();     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting cancel", e);
        onError(1, 0);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient
    public boolean wasUserDetected() {
        if (this.mLastAcquire != 11) goto L5;
    L9:
        return false;
    L5:
        if (this.mLastAcquire == 21) goto L9;
        if (this.mLastAcquire == 23) goto L9;
        return true;
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient
    protected void handleLifecycleAfterAuth(boolean authenticated) {
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FACE, getRequestReason()).build());
        this.mCallback.onClientFinished(this, true);
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient, com.android.server.biometrics.sensors.AuthenticationConsumer
    public void onAuthenticated(BiometricAuthenticator.Identifier identifier, boolean authenticated, ArrayList<Byte> token) {
        super.onAuthenticated(identifier, authenticated, token);
        this.mState = 4;
        this.mUsageStats.addEvent(new UsageStats.AuthenticationEvent(getStartTimeMs(), System.currentTimeMillis() - getStartTimeMs(), authenticated, 0, 0, getTargetUserId()));
        if (authenticated == false) goto L5;
        this.mAuthenticationStateListeners.onAuthenticationSucceeded(new AuthenticationSucceededInfo.Builder(BiometricSourceType.FACE, getRequestReason(), this.mIsStrongBiometric, getTargetUserId()).build());
        return;
    L5:
        this.mAuthenticationStateListeners.onAuthenticationFailed(new AuthenticationFailedInfo.Builder(BiometricSourceType.FACE, getRequestReason(), getTargetUserId()).build());
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient, com.android.server.biometrics.sensors.AcquisitionClient, com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int error, int vendorCode) {
        this.mUsageStats.addEvent(new UsageStats.AuthenticationEvent(getStartTimeMs(), System.currentTimeMillis() - getStartTimeMs(), false, error, vendorCode, getTargetUserId()));
        this.mAuthenticationStateListeners.onAuthenticationError(new AuthenticationErrorInfo.Builder(BiometricSourceType.FACE, getRequestReason(), FaceManager.getErrorString(getContext(), error, vendorCode), error).build());
        super.onError(error, vendorCode);
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FACE, getRequestReason()).build());
    }

    private int[] getAcquireIgnorelist() {
        if (isBiometricPrompt() == false) goto L6;
        return this.mBiometricPromptIgnoreList;
    L6:
        return this.mKeyguardIgnoreList;
    }

    private int[] getAcquireVendorIgnorelist() {
        if (isBiometricPrompt() == false) goto L6;
        return this.mBiometricPromptIgnoreListVendor;
    L6:
        return this.mKeyguardIgnoreListVendor;
    }

    private boolean shouldSendAcquiredMessage(int acquireInfo, int vendorCode) {
        if (acquireInfo != 22) goto L8;
        if (Utils.listContains(getAcquireVendorIgnorelist(), vendorCode) == false) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (Utils.listContains(getAcquireIgnorelist(), acquireInfo) == false) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.android.server.biometrics.sensors.AuthenticationClient, com.android.server.biometrics.sensors.AcquisitionClient
    public void onAcquired(int acquireInfo, int vendorCode) {
        this.mLastAcquire = acquireInfo;
        boolean shouldSend = shouldSendAcquiredMessage(acquireInfo, vendorCode);
        if (shouldSend == false) goto L7;
        this.mAuthenticationStateListeners.onAuthenticationAcquired(new AuthenticationAcquiredInfo.Builder(BiometricSourceType.FACE, getRequestReason(), acquireInfo).build());
        String helpMessage = FaceManager.getAuthHelpMessage(getContext(), acquireInfo, vendorCode);
        if (helpMessage == null) goto L7;
        int helpCode = getHelpCode(acquireInfo, vendorCode);
        this.mAuthenticationStateListeners.onAuthenticationHelp(new AuthenticationHelpInfo.Builder(BiometricSourceType.FACE, getRequestReason(), helpMessage, helpCode).build());
    L7:
        onAcquiredInternal(acquireInfo, vendorCode, shouldSend);
        if (getLockoutTracker() != null) goto L10;
    L11:
        PerformanceTracker pt = PerformanceTracker.getInstanceForSensorId(getSensorId());
        pt.incrementAcquireForUser(getTargetUserId(), isCryptoOperation());
        return;
    L10:
        if (getLockoutTracker().getLockoutModeForUser(getTargetUserId()) == 0) goto L11;
    }

    public void onAuthenticationFrame(FaceAuthenticationFrame frame) {
        int acquireInfo = frame.getData().getAcquiredInfo();
        int vendorCode = frame.getData().getVendorCode();
        this.mLastAcquire = acquireInfo;
        onAcquiredInternal(acquireInfo, vendorCode, false);
        boolean shouldSend = shouldSendAcquiredMessage(acquireInfo, vendorCode);
        if (shouldSend == false) goto L16;
        if (shouldSend == true) goto L14;
    L10:
        getListener().onAuthenticationFrame(frame);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to send authentication frame", e);
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FACE, getRequestReason()).build());
        this.mCallback.onClientFinished(this, false);
        return;
    L14:
        this.mAuthenticationStateListeners.onAuthenticationAcquired(new AuthenticationAcquiredInfo.Builder(BiometricSourceType.FACE, getRequestReason(), acquireInfo).build());     // Catch: RemoteException -> L8
        String helpMessage = FaceManager.getAuthHelpMessage(getContext(), acquireInfo, vendorCode);     // Catch: RemoteException -> L8
        if (helpMessage == null) goto L10;
        int helpCode = getHelpCode(acquireInfo, vendorCode);     // Catch: RemoteException -> L8
        this.mAuthenticationStateListeners.onAuthenticationHelp(new AuthenticationHelpInfo.Builder(BiometricSourceType.FACE, getRequestReason(), helpMessage, helpCode).build());     // Catch: RemoteException -> L8
        goto L10
    }

    @Override // com.android.server.biometrics.sensors.LockoutConsumer
    public void onLockoutTimed(long durationMillis) {
        this.mAuthSessionCoordinator.lockOutTimed(getTargetUserId(), getSensorStrength(), getSensorId(), durationMillis, getRequestId());
        getLogger().logOnError(getContext(), getOperationContext(), 7, 0, getTargetUserId());
        PerformanceTracker.getInstanceForSensorId(getSensorId()).incrementTimedLockoutForUser(getTargetUserId());
        onError(7, 0);
    }

    @Override // com.android.server.biometrics.sensors.LockoutConsumer
    public void onLockoutPermanent() {
        this.mAuthSessionCoordinator.lockedOutFor(getTargetUserId(), getSensorStrength(), getSensorId(), getRequestId());
        getLogger().logOnError(getContext(), getOperationContext(), 9, 0, getTargetUserId());
        PerformanceTracker.getInstanceForSensorId(getSensorId()).incrementPermanentLockoutForUser(getTargetUserId());
        onError(9, 0);
    }

    private static int getHelpCode(int acquireInfo, int vendorCode) {
        if (acquireInfo != 22) goto L6;
        return vendorCode + 1000;
    L6:
        return acquireInfo;
    }
}
