package com.android.server.biometrics;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.IBiometricSensorReceiver;
import android.hardware.biometrics.IBiometricServiceReceiver;
import android.hardware.biometrics.IBiometricSysuiReceiver;
import android.hardware.biometrics.PromptInfo;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.os.IBinder;
import android.os.RemoteException;
import android.security.KeyStoreAuthorization;
import android.util.Slog;
import com.android.internal.statusbar.IStatusBarService;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricFrameworkStatsLogger;
import com.android.server.biometrics.log.OperationContextExt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes.dex */
public final class AuthSession implements IBinder.DeathRecipient {
    private static final boolean DEBUG = true;
    private static final String TAG = "BiometricService/AuthSession";
    private int mAuthenticatedSensorId;
    private long mAuthenticatedTimeMs;
    private final BiometricContext mBiometricContext;
    final BiometricFrameworkStatsLogger mBiometricFrameworkStatsLogger;
    private final BiometricManager mBiometricManager;
    private boolean mCancelled;
    private final ClientDeathReceiver mClientDeathReceiver;
    private final IBiometricServiceReceiver mClientReceiver;
    private final Context mContext;
    private final boolean mDebugEnabled;
    private int mErrorEscrow;
    private final List<FingerprintSensorPropertiesInternal> mFingerprintSensorProperties;
    private final KeyStoreAuthorization mKeyStoreAuthorization;
    private final String mOpPackageName;
    private final OperationContextExt mOperationContext;
    private final long mOperationId;
    final PreAuthInfo mPreAuthInfo;
    final PromptInfo mPromptInfo;
    private final Random mRandom;
    private final long mRequestId;
    final IBiometricSensorReceiver mSensorReceiver;
    private int[] mSensors;
    private final List<Integer> mSfpsSensorIds;
    private long mStartTimeMs;
    private int mState;
    private final IStatusBarService mStatusBarService;
    final IBiometricSysuiReceiver mSysuiReceiver;
    final IBinder mToken;
    private byte[] mTokenEscrow;
    private final int mUserId;
    private int mVendorCodeEscrow;

    interface ClientDeathReceiver {
        void onClientDied();
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface SessionState {
    }

    public static /* synthetic */ Boolean $r8$lambda$2M4LopX4Ez2rKcMHs76UjWeEzSc(BiometricSensor r0) {
        return lambda$startAllPreparedSensorsExceptFingerprint$1(r0);
    }

    public static /* synthetic */ Boolean $r8$lambda$ChHPsLtcbiJMupuEDhJZUfAZROQ(int r0, BiometricSensor r1) {
        return lambda$onAuthenticationSucceeded$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ID5A6A-jPDHI5JoGe-udE9UUIvk, reason: not valid java name */
    public static /* synthetic */ Boolean m2558$r8$lambda$ID5A6AjPDHI5JoGeudE9UUIvk(BiometricSensor r0) {
        return lambda$startAllPreparedFingerprintSensors$2(r0);
    }

    public static /* synthetic */ Boolean $r8$lambda$M7eQp7jg92vLYvWd3vPSSiGJwBo(int r0, BiometricSensor r1) {
        return lambda$pauseSensorIfSupported$7(r0, r1);
    }

    public static /* synthetic */ Boolean $r8$lambda$bXUoZ1akYP8TSERLcQsRxOhHGpg(BiometricSensor r0) {
        return lambda$cancelAllSensors$3(r0);
    }

    public static /* synthetic */ Boolean $r8$lambda$g8qp1XVNJHFOHIT4_u_o6wyL8I0(AuthSession r0, int r1, BiometricSensor r2) {
        return r0.lambda$onAuthenticationSucceeded$5(r1, r2);
    }

    public static /* synthetic */ Boolean $r8$lambda$kXVbxXAD3wv3_6Jp9ulzyk5Wb2k(AuthSession r0, int r1, BiometricSensor r2) {
        return r0.lambda$onErrorReceived$4(r1, r2);
    }

    public static /* synthetic */ Integer $r8$lambda$pscd1KBAusTe8AFE4gvOAKtBqfE(FingerprintSensorPropertiesInternal r0) {
        return lambda$new$0(r0);
    }

    AuthSession(Context context, BiometricContext biometricContext, IStatusBarService statusBarService, IBiometricSysuiReceiver sysuiReceiver, KeyStoreAuthorization keyStoreAuthorization, Random random, ClientDeathReceiver clientDeathReceiver, PreAuthInfo preAuthInfo, IBinder token, long requestId, long operationId, int userId, IBiometricSensorReceiver sensorReceiver, IBiometricServiceReceiver clientReceiver, String opPackageName, PromptInfo promptInfo, boolean debugEnabled, List<FingerprintSensorPropertiesInternal> fingerprintSensorProperties) {
        this(context, biometricContext, statusBarService, sysuiReceiver, keyStoreAuthorization, random, clientDeathReceiver, preAuthInfo, token, requestId, operationId, userId, sensorReceiver, clientReceiver, opPackageName, promptInfo, debugEnabled, fingerprintSensorProperties, BiometricFrameworkStatsLogger.getInstance());
    }

    AuthSession(Context context, BiometricContext biometricContext, IStatusBarService statusBarService, IBiometricSysuiReceiver sysuiReceiver, KeyStoreAuthorization keyStoreAuthorization, Random random, ClientDeathReceiver clientDeathReceiver, PreAuthInfo preAuthInfo, IBinder token, long requestId, long operationId, int userId, IBiometricSensorReceiver sensorReceiver, IBiometricServiceReceiver clientReceiver, String opPackageName, PromptInfo promptInfo, boolean debugEnabled, List<FingerprintSensorPropertiesInternal> fingerprintSensorProperties, BiometricFrameworkStatsLogger logger) {
        this.mState = 0;
        this.mAuthenticatedSensorId = -1;
        Slog.d(TAG, "Creating AuthSession with: " + preAuthInfo);
        this.mContext = context;
        this.mBiometricContext = biometricContext;
        this.mStatusBarService = statusBarService;
        this.mSysuiReceiver = sysuiReceiver;
        this.mKeyStoreAuthorization = keyStoreAuthorization;
        this.mRandom = random;
        this.mClientDeathReceiver = clientDeathReceiver;
        this.mPreAuthInfo = preAuthInfo;
        this.mToken = token;
        this.mRequestId = requestId;
        this.mOperationId = operationId;
        this.mUserId = userId;
        this.mSensorReceiver = sensorReceiver;
        this.mClientReceiver = clientReceiver;
        this.mOpPackageName = opPackageName;
        this.mPromptInfo = promptInfo;
        this.mDebugEnabled = debugEnabled;
        this.mFingerprintSensorProperties = fingerprintSensorProperties;
        this.mCancelled = false;
        this.mBiometricFrameworkStatsLogger = logger;
        this.mOperationContext = new OperationContextExt(true, preAuthInfo.getIsMandatoryBiometricsAuthentication());
        this.mBiometricManager = (BiometricManager) this.mContext.getSystemService(BiometricManager.class);
        this.mSfpsSensorIds = this.mFingerprintSensorProperties.stream().filter(new AuthSession$$ExternalSyntheticLambda3()).map(new AuthSession$$ExternalSyntheticLambda4()).toList();
        this.mClientReceiver.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
    L7:
        setSensorsToStateUnknown();
        return;
    L6:
        Slog.w(TAG, "Unable to link to death");
        goto L7
    }

    private static /* synthetic */ Integer lambda$new$0(FingerprintSensorPropertiesInternal prop) {
        return Integer.valueOf(prop.sensorId);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.e(TAG, "Binder died, session: " + this);
        this.mClientDeathReceiver.onClientDied();
    }

    private int getEligibleModalities() {
        return this.mPreAuthInfo.getEligibleModalities();
    }

    private void setSensorsToStateUnknown() {
        Iterator<BiometricSensor> r0 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        BiometricSensor sensor = r0.next();
        Slog.v(TAG, "set to unknown state sensor: " + sensor.id);
        sensor.goToStateUnknown();
        goto L4
    }

    private void setSensorsToStateWaitingForCookie(boolean isTryAgain) throws RemoteException {
        Iterator<BiometricSensor> r1 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        BiometricSensor sensor = r1.next();
        int state = sensor.getSensorState();
        if (isTryAgain == false) goto L11;
        if (state == 5) goto L11;
        if (state == 4) goto L11;
        Slog.d(TAG, "Skip retry because sensor: " + sensor.id + " is: " + state);
    L11:
        if (isTryAgain == false) goto L13;
        this.mState = 5;
    L13:
        int cookie = this.mRandom.nextInt(2147483646) + 1;
        boolean requireConfirmation = isConfirmationRequired(sensor);
        Slog.v(TAG, "waiting for cooking for sensor: " + sensor.id);
        sensor.goToStateWaitingForCookie(requireConfirmation, this.mToken, this.mOperationId, this.mUserId, this.mSensorReceiver, this.mOpPackageName, this.mRequestId, cookie, this.mPromptInfo.isAllowBackgroundAuthentication(), this.mPromptInfo.isForLegacyFingerprintManager(), this.mOperationContext.getIsMandatoryBiometrics());
        r1 = r1;
        goto L4
    }

    void goToInitialState() throws RemoteException {
        if (this.mPreAuthInfo.credentialAvailable == false) goto L8;
        if (this.mPreAuthInfo.eligibleSensors.isEmpty() == false) goto L8;
        this.mState = 9;
        this.mSensors = new int[0];
        this.mStatusBarService.showAuthenticationDialog(this.mPromptInfo, this.mSysuiReceiver, this.mSensors, true, false, this.mPreAuthInfo.callingUserId, this.mOperationId, this.mOpPackageName, this.mRequestId);
        return;
    L8:
        if (this.mPreAuthInfo.eligibleSensors.isEmpty() == true) goto L12;
        setSensorsToStateWaitingForCookie(false);
        this.mState = 1;
        return;
    L12:
        throw new IllegalStateException("No authenticators requested");
    }

    void onCookieReceived(int cookie) {
        if (this.mCancelled == false) goto L7;
        Slog.w(TAG, "Received cookie but already cancelled (ignoring): " + cookie);
        return;
    L7:
        if (hasAuthenticatedAndConfirmed() == false) goto L10;
        Slog.d(TAG, "onCookieReceived after successful auth");
        return;
    L10:
        Iterator<BiometricSensor> r0 = this.mPreAuthInfo.eligibleSensors.iterator();
    L12:
        if (r0.hasNext() == false) goto L15;
        BiometricSensor sensor = r0.next();
        sensor.goToStateCookieReturnedIfCookieMatches(cookie);
        goto L12
    L15:
        if (allCookiesReceived() == false) goto L28;
        this.mStartTimeMs = System.currentTimeMillis();
        startAllPreparedSensorsExceptFingerprint();
        if (this.mState != 5) goto L30;
        this.mState = 3;
        return;
    L30:
        boolean requireConfirmation = isConfirmationRequiredByAnyEligibleSensor();     // Catch: RemoteException -> L22
        this.mSensors = new int[this.mPreAuthInfo.eligibleSensors.size()];     // Catch: RemoteException -> L22
        int i = 0;
    L20:
        if (i >= this.mPreAuthInfo.eligibleSensors.size()) goto L24;
        this.mSensors[i] = this.mPreAuthInfo.eligibleSensors.get(i).id;     // Catch: RemoteException -> L22
        i = i + 1;     // Catch: RemoteException -> L22
        goto L20
    L24:
        this.mStatusBarService.showAuthenticationDialog(this.mPromptInfo, this.mSysuiReceiver, this.mSensors, this.mPreAuthInfo.shouldShowCredential(), requireConfirmation, this.mPreAuthInfo.callingUserId, this.mOperationId, this.mOpPackageName, this.mRequestId);     // Catch: RemoteException -> L22
        this.mState = 2;     // Catch: RemoteException -> L22
        return;
    L22:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        return;
    L28:
        Slog.v(TAG, "onCookieReceived: still waiting");
    }

    private boolean isConfirmationRequired(BiometricSensor sensor) {
        if (sensor.confirmationSupported() == true) goto L5;
    L9:
        return false;
    L5:
        if (sensor.confirmationAlwaysRequired(this.mUserId) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mPreAuthInfo.confirmationRequested == false) goto L9;
        goto L8
    }

    private boolean isConfirmationRequiredByAnyEligibleSensor() {
        Iterator<BiometricSensor> r0 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        BiometricSensor sensor = r0.next();
        if (isConfirmationRequired(sensor) == false) goto L4;
        return true;
    L10:
        return false;
    }

    private static /* synthetic */ Boolean lambda$startAllPreparedSensorsExceptFingerprint$1(BiometricSensor sensor) {
        if (sensor.modality == 2) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    private void startAllPreparedSensorsExceptFingerprint() {
        startAllPreparedSensors(new AuthSession$$ExternalSyntheticLambda8());
    }

    private static /* synthetic */ Boolean lambda$startAllPreparedFingerprintSensors$2(BiometricSensor sensor) {
        if (sensor.modality != 2) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    private void startAllPreparedFingerprintSensors() {
        startAllPreparedSensors(new AuthSession$$ExternalSyntheticLambda2());
    }

    private void startAllPreparedSensors(Function<BiometricSensor, Boolean> filter) {
        Iterator<BiometricSensor> r1 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        BiometricSensor sensor = r1.next();
        if (filter.apply(sensor).booleanValue() == false) goto L4;
        Slog.v(TAG, "Starting sensor: " + sensor.id);     // Catch: RemoteException -> L9
        sensor.startSensor();     // Catch: RemoteException -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Unable to start prepared client, sensor: " + sensor, e);
        goto L4
    }

    private void cancelAllSensors() {
        cancelAllSensors(new AuthSession$$ExternalSyntheticLambda5());
    }

    private static /* synthetic */ Boolean lambda$cancelAllSensors$3(BiometricSensor sensor) {
        return true;
    }

    private void cancelAllSensors(Function<BiometricSensor, Boolean> filter) {
        Iterator<BiometricSensor> r1 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        BiometricSensor sensor = r1.next();
        if (filter.apply(sensor).booleanValue() == false) goto L4;
        Slog.d(TAG, "Cancelling sensorId: " + sensor.id);     // Catch: RemoteException -> L10
        sensor.goToStateCancelling(this.mToken, this.mOpPackageName, this.mRequestId);     // Catch: RemoteException -> L10
    L13:
        Slog.e(TAG, "Unable to cancel authentication");
        goto L4
    }

    boolean onErrorReceived(final int sensorId, int cookie, int error, int vendorCode) throws RemoteException {
        Slog.d(TAG, "onErrorReceived sensor: " + sensorId + " error: " + error);
        if (containsCookie(cookie) == true) goto L6;
        Slog.e(TAG, "Unknown/expired cookie: " + cookie);
        return false;
    L6:
        Iterator<BiometricSensor> r5 = this.mPreAuthInfo.eligibleSensors.iterator();
    L8:
        if (r5.hasNext() == false) goto L14;
        BiometricSensor sensor = r5.next();
        if (sensor.getSensorState() != 3) goto L8;
        sensor.goToStoppedStateIfCookieMatches(cookie, error);
        goto L8
    L14:
        if (hasAuthenticated() == false) goto L18;
        Slog.d(TAG, "onErrorReceived after successful auth (ignoring)");
        return false;
    L18:
        if (error == 7) goto L22;
        if (error == 9) goto L22;
        boolean errorLockout = false;
    L23:
        if (errorLockout == false) goto L25;
        cancelAllSensors(new AuthSession$$ExternalSyntheticLambda1(this, sensorId));
    L25:
        this.mErrorEscrow = error;
        this.mVendorCodeEscrow = vendorCode;
        int modality = sensorIdToModality(sensorId);
        switch(this.mState) {
            case 1: goto L43;
            case 2: goto L34;
            case 3: goto L34;
            case 4: goto L31;
            case 5: goto L27;
            case 6: goto L34;
            case 7: goto L27;
            case 8: goto L27;
            case 9: goto L30;
            case 10: goto L28;
            default: goto L27;
        };
    L27:
        Slog.e(TAG, "Unhandled error state, mState: " + this.mState);
        return false;
    L28:
        this.mStatusBarService.hideAuthenticationDialog(this.mRequestId);
        return true;
    L30:
        Slog.d(TAG, "Biometric canceled, ignoring from state: " + this.mState);
        return false;
    L31:
        this.mClientReceiver.onError(modality, error, vendorCode);
        this.mStatusBarService.hideAuthenticationDialog(this.mRequestId);
        return true;
    L34:
        if (isAllowDeviceCredential() == false) goto L38;
        if (errorLockout == false) goto L38;
        this.mState = 9;
        this.mStatusBarService.onBiometricErrorWithId(modality, error, vendorCode, sensorId);
        return false;
    L38:
        if (error != 5) goto L41;
        this.mStatusBarService.hideAuthenticationDialog(this.mRequestId);
        this.mClientReceiver.onError(modality, error, vendorCode);
        return true;
    L41:
        this.mState = 8;
        this.mStatusBarService.onBiometricErrorWithId(modality, error, vendorCode, sensorId);
        return false;
    L43:
        if (isAllowDeviceCredential() == false) goto L46;
        int authenticators = this.mPromptInfo.getAuthenticators();
        this.mPromptInfo.setAuthenticators(Utils.removeBiometricBits(authenticators));
        this.mState = 9;
        this.mSensors = new int[0];
        this.mStatusBarService.showAuthenticationDialog(this.mPromptInfo, this.mSysuiReceiver, this.mSensors, true, false, this.mPreAuthInfo.callingUserId, this.mOperationId, this.mOpPackageName, this.mRequestId);
        return false;
    L46:
        this.mClientReceiver.onError(modality, error, vendorCode);
        return true;
    L22:
        errorLockout = true;
        goto L23
    }

    private /* synthetic */ Boolean lambda$onErrorReceived$4(int sensorId, BiometricSensor sensor) {
        return Boolean.valueOf(Utils.isAtLeastStrength(sensorIdToStrength(sensorId), sensor.getCurrentStrength()));
    }

    void onAcquired(int sensorId, int acquiredInfo, int vendorCode) {
        if (hasAuthenticatedAndConfirmed() == false) goto L6;
        Slog.d(TAG, "onAcquired after successful auth");
        return;
    L6:
        String message = getAcquiredMessageForSensor(sensorId, acquiredInfo, vendorCode);
        Slog.d(TAG, "sensorId: " + sensorId + " acquiredInfo: " + acquiredInfo + " message: " + message);
        if (message != null) goto L9;
        return;
    L9:
        if (message.isEmpty() == true) goto L24;
        this.mStatusBarService.onBiometricHelp(sensorIdToModality(sensorId), message);     // Catch: RemoteException -> L17
        if (acquiredInfo != 6) goto L14;
        int aAcquiredInfo = vendorCode + 1000;     // Catch: RemoteException -> L17
    L15:
        this.mClientReceiver.onAcquired(aAcquiredInfo, message);     // Catch: RemoteException -> L17
        return;
    L14:
        aAcquiredInfo = acquiredInfo;
    L17:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        return;
    }

    void onSystemEvent(int event) {
        if (hasAuthenticatedAndConfirmed() == false) goto L7;
        Slog.d(TAG, "onSystemEvent after successful auth");
        return;
    L7:
        if (this.mPromptInfo.isReceiveSystemEvents() == true) goto L14;
        return;
    L14:
        this.mClientReceiver.onSystemEvent(event);     // Catch: RemoteException -> L11
        return;
    L11:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
    }

    void onDialogAnimatedIn(boolean startFingerprintNow) {
        if (this.mState == 2) goto L13;
        if (this.mState == 8) goto L13;
        if (this.mState == 4) goto L13;
        if (this.mState == 6) goto L13;
        Slog.e(TAG, "onDialogAnimatedIn, unexpected state: " + this.mState);
        return;
    L13:
        if (this.mState == 6) goto L15;
        this.mState = 3;
    L15:
        if (startFingerprintNow == false) goto L17;
        startAllPreparedFingerprintSensors();
    L18:
        this.mBiometricContext.updateContext(this.mOperationContext, isCrypto());
        return;
    L17:
        Slog.d(TAG, "delaying fingerprint sensor start");
        goto L18
    }

    void onStartFingerprint() {
        if (this.mState != 2) goto L5;
    L13:
        startAllPreparedFingerprintSensors();
        return;
    L5:
        if (this.mState == 3) goto L13;
        if (this.mState == 4) goto L13;
        if (this.mState == 6) goto L13;
        if (this.mState == 8) goto L13;
        Slog.w(TAG, "onStartFingerprint, started from unexpected state: " + this.mState);
        goto L13
    }

    void onTryAgainPressed() {
        if (hasAuthenticatedAndConfirmed() == false) goto L7;
        Slog.d(TAG, "onTryAgainPressed after successful auth");
        return;
    L7:
        if (this.mState == 4) goto L15;
        Slog.w(TAG, "onTryAgainPressed, state: " + this.mState);
    L15:
        setSensorsToStateWaitingForCookie(true);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "RemoteException: " + e);
    }

    void onAuthenticationSucceeded(final int sensorId, boolean strong, byte[] token) {
        if (hasAuthenticatedAndConfirmed() == false) goto L6;
        Slog.d(TAG, "onAuthenticationSucceeded after successful auth");
        return;
    L6:
        this.mAuthenticatedSensorId = sensorId;
        if (strong == false) goto L9;
        this.mTokenEscrow = token;
    L26:
        this.mStatusBarService.onBiometricAuthenticatedWithId(sensorIdToModality(sensorId), sensorId);     // Catch: RemoteException -> L15
        boolean requireConfirmation = isConfirmationRequiredByAnyEligibleSensor();     // Catch: RemoteException -> L15
        if (requireConfirmation == true) goto L17;
        this.mState = 7;     // Catch: RemoteException -> L15
    L25:
    L21:
        if (this.mState != 6) goto L23;
        cancelAllSensors(new AuthSession$$ExternalSyntheticLambda6(this, sensorId));
        return;
    L23:
        cancelAllSensors(new AuthSession$$ExternalSyntheticLambda7(sensorId));
        return;
    L17:
        this.mAuthenticatedTimeMs = System.currentTimeMillis();     // Catch: RemoteException -> L15
        this.mState = 6;     // Catch: RemoteException -> L15
    L15:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
        goto L21
    L9:
        if (token == null) goto L26;
        Slog.w(TAG, "Dropping authToken for non-strong biometric, id: " + sensorId);
        goto L26
    }

    private /* synthetic */ Boolean lambda$onAuthenticationSucceeded$5(int sensorId, BiometricSensor sensor) {
        if (sensor.id != sensorId) goto L5;
    L7:
        boolean r0 = false;
    L9:
        return Boolean.valueOf(r0);
    L5:
        if (this.mSfpsSensorIds.contains(Integer.valueOf(sensor.id)) == true) goto L7;
        r0 = true;
        goto L9
    }

    private static /* synthetic */ Boolean lambda$onAuthenticationSucceeded$6(int sensorId, BiometricSensor sensor) {
        if (sensor.id == sensorId) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    void onAuthenticationRejected(int sensorId) {
        if (hasAuthenticatedAndConfirmed() == false) goto L15;
        Slog.d(TAG, "onAuthenticationRejected after successful auth");
        return;
    L15:
        this.mStatusBarService.onBiometricErrorWithId(sensorIdToModality(sensorId), 100, 0, sensorId);     // Catch: RemoteException -> L9
        if (pauseSensorIfSupported(sensorId) == false) goto L11;
        this.mState = 4;     // Catch: RemoteException -> L9
    L11:
        this.mClientReceiver.onAuthenticationFailed();     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
    }

    void onAuthenticationTimedOut(int sensorId, int cookie, int error, int vendorCode) {
        if (hasAuthenticatedAndConfirmed() == false) goto L11;
        Slog.d(TAG, "onAuthenticationTimedOut after successful auth");
        return;
    L11:
        this.mStatusBarService.onBiometricErrorWithId(sensorIdToModality(sensorId), error, vendorCode, sensorId);     // Catch: RemoteException -> L8
        pauseSensorIfSupported(sensorId);     // Catch: RemoteException -> L8
        this.mState = 4;     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
    }

    private boolean pauseSensorIfSupported(final int sensorId) {
        if (sensorIdToState(sensorId) != 4) goto L5;
        boolean isSensorCancelling = true;
    L7:
        if (sensorIdToModality(sensorId) != 8) goto L11;
        if (isSensorCancelling == true) goto L11;
        cancelAllSensors(new AuthSession$$ExternalSyntheticLambda0(sensorId));
        return true;
    L11:
        return false;
    L5:
        isSensorCancelling = false;
        goto L7
    }

    private static /* synthetic */ Boolean lambda$pauseSensorIfSupported$7(int sensorId, BiometricSensor sensor) {
        if (sensor.id != sensorId) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    void onDeviceCredentialPressed() {
        if (hasAuthenticatedAndConfirmed() == false) goto L6;
        Slog.d(TAG, "onDeviceCredentialPressed after successful auth");
        return;
    L6:
        cancelAllSensors();
        this.mState = 9;
    }

    boolean onClientDied() {
    L7:
        e = move-exception;
        Slog.e(TAG, "Remote Exception: " + e);
        return true;
    L4:
        switch(this.mState) {
            case 2: goto L9;
            case 3: goto L9;
            default: goto L5;
        };     // Catch: RemoteException -> L7
    L5:
        this.mStatusBarService.hideAuthenticationDialog(this.mRequestId);     // Catch: RemoteException -> L7
        return true;
    L9:
        this.mState = 10;     // Catch: RemoteException -> L7
        cancelAllSensors();     // Catch: RemoteException -> L7
        return false;
    }

    private boolean hasAuthenticated() {
        if (this.mAuthenticatedSensorId == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasAuthenticatedAndConfirmed() {
        if (this.mAuthenticatedSensorId != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.mState != 7) goto L7;
        return true;
    }

    private void logOnDialogDismissed(int reason) {
        if (reason != 1) goto L5;
        long latency = System.currentTimeMillis() - this.mAuthenticatedTimeMs;
        Slog.v(TAG, "Confirmed! Modality: " + statsModality() + ", User: " + this.mUserId + ", IsCrypto: " + isCrypto() + ", Client: " + getStatsClient() + ", RequireConfirmation: " + this.mPreAuthInfo.confirmationRequested + ", State: 3, Latency: " + latency + ", SessionId: " + this.mOperationContext.getId());
        this.mBiometricFrameworkStatsLogger.authenticate(this.mOperationContext, statsModality(), 0, getStatsClient(), this.mDebugEnabled, latency, 3, this.mPreAuthInfo.confirmationRequested, this.mUserId, -1.0f);
        return;
    L5:
        long latency2 = System.currentTimeMillis() - this.mStartTimeMs;
        int error = 0;
        switch(reason) {
            case 2: goto L10;
            case 3: goto L9;
            case 8: goto L8;
            default: goto L11;
        };
    L8:
        error = 22;
        goto L11
    L9:
        error = 10;
        goto L11
    L10:
        error = 13;
    L11:
        Slog.v(TAG, "Dismissed! Modality: " + statsModality() + ", User: " + this.mUserId + ", IsCrypto: " + isCrypto() + ", Action: 2, Client: " + getStatsClient() + ", Reason: " + reason + ", Error: " + error + ", Latency: " + latency2 + ", SessionId: " + this.mOperationContext.getId());
        if (error == 0) goto L15;
        this.mBiometricFrameworkStatsLogger.error(this.mOperationContext, statsModality(), 2, getStatsClient(), this.mDebugEnabled, latency2, error, 0, this.mUserId);
        return;
    }

    void onDialogDismissed(int reason, byte[] credentialAttestation) {
        logOnDialogDismissed(reason);
        switch(reason) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L17;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L10;
            case 8: goto L15;
            case 9: goto L9;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Unhandled reason: " + reason);     // Catch: Throwable -> L5 RemoteException -> L7
    L22:
        if (this.mTokenEscrow != null) goto L24;
    L30:
        cancelAllSensors();
        return;
    L24:
        if (this.mBiometricManager == null) goto L30;
        byte[] byteToken = new byte[this.mTokenEscrow.length];
        int i = 0;
    L27:
        if (i >= this.mTokenEscrow.length) goto L29;
        byteToken[i] = this.mTokenEscrow[i];
        i = i + 1;
        goto L27
    L29:
        this.mBiometricManager.resetLockoutTimeBound(this.mToken, this.mContext.getOpPackageName(), this.mAuthenticatedSensorId, this.mUserId, byteToken);
        goto L30
    L9:
        this.mClientReceiver.onError(getEligibleModalities(), 1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        goto L22
    L10:
        if (credentialAttestation == null) goto L12;
        this.mKeyStoreAuthorization.addAuthToken(credentialAttestation);     // Catch: Throwable -> L5 RemoteException -> L7
        goto L17
    L12:
        Slog.e(TAG, "credentialAttestation is null");     // Catch: Throwable -> L5 RemoteException -> L7
        goto L17
    L13:
        this.mClientReceiver.onError(getEligibleModalities(), this.mErrorEscrow, this.mVendorCodeEscrow);     // Catch: Throwable -> L5 RemoteException -> L7
        goto L22
    L14:
        this.mClientReceiver.onError(getEligibleModalities(), 10, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        goto L22
    L15:
        this.mClientReceiver.onDialogDismissed(reason);     // Catch: Throwable -> L5 RemoteException -> L7
    L17:
        if (this.mTokenEscrow == null) goto L19;
        int result = this.mKeyStoreAuthorization.addAuthToken(this.mTokenEscrow);     // Catch: Throwable -> L5 RemoteException -> L7
        Slog.d(TAG, "addAuthToken: " + result);     // Catch: Throwable -> L5 RemoteException -> L7
    L20:
        this.mClientReceiver.onAuthenticationSucceeded(Utils.getAuthenticationTypeForResult(reason));     // Catch: Throwable -> L5 RemoteException -> L7
        goto L22
    L19:
        Slog.e(TAG, "mTokenEscrow is null");     // Catch: Throwable -> L5 RemoteException -> L7
    L7:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);     // Catch: Throwable -> L5
        if (this.mTokenEscrow == null) goto L30;
        if (this.mBiometricManager == null) goto L30;
        byte[] byteToken2 = new byte[this.mTokenEscrow.length];
        int i2 = 0;
    L39:
        if (i2 >= this.mTokenEscrow.length) goto L41;
        byteToken2[i2] = this.mTokenEscrow[i2];
        i2 = i2 + 1;
        goto L39
    L41:
        this.mBiometricManager.resetLockoutTimeBound(this.mToken, this.mContext.getOpPackageName(), this.mAuthenticatedSensorId, this.mUserId, byteToken2);
    L5:
        th = move-exception;
        if (this.mTokenEscrow != null) goto L46;
    L52:
        cancelAllSensors();
        throw th;
    L46:
        if (this.mBiometricManager == null) goto L52;
        byte[] byteToken3 = new byte[this.mTokenEscrow.length];
        int i3 = 0;
    L49:
        if (i3 >= this.mTokenEscrow.length) goto L51;
        byteToken3[i3] = this.mTokenEscrow[i3];
        i3 = i3 + 1;
        goto L49
    L51:
        this.mBiometricManager.resetLockoutTimeBound(this.mToken, this.mContext.getOpPackageName(), this.mAuthenticatedSensorId, this.mUserId, byteToken3);
        goto L52
    }

    boolean onCancelAuthSession(boolean force) {
        if (hasAuthenticatedAndConfirmed() == false) goto L6;
        Slog.d(TAG, "onCancelAuthSession after successful auth");
        return true;
    L6:
        this.mCancelled = true;
        if (this.mState != 1) goto L9;
    L14:
        boolean authStarted = true;
    L15:
        cancelAllSensors();
        if (authStarted == false) goto L24;
        if (force == true) goto L24;
        return false;
    L24:
        this.mClientReceiver.onError(getEligibleModalities(), 5, 0);     // Catch: RemoteException -> L21
        this.mStatusBarService.hideAuthenticationDialog(this.mRequestId);     // Catch: RemoteException -> L21
        return true;
    L21:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        return false;
    L9:
        if (this.mState == 2) goto L14;
        if (this.mState == 3) goto L14;
        authStarted = false;
        goto L15
    }

    boolean isCrypto() {
        if (this.mOperationId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean containsCookie(int cookie) {
        Iterator<BiometricSensor> r0 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        BiometricSensor sensor = r0.next();
        if (sensor.getCookie() != cookie) goto L4;
        return true;
    L10:
        return false;
    }

    private boolean isAllowDeviceCredential() {
        return Utils.isCredentialRequested(this.mPromptInfo);
    }

    boolean allCookiesReceived() {
        int remainingCookies = this.mPreAuthInfo.numSensorsWaitingForCookie();
        Slog.d(TAG, "Remaining cookies: " + remainingCookies);
        if (remainingCookies != 0) goto L5;
        return true;
    L5:
        return false;
    }

    int getState() {
        return this.mState;
    }

    long getRequestId() {
        return this.mRequestId;
    }

    private int statsModality() {
        int modality = 0;
        Iterator<BiometricSensor> r1 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        BiometricSensor sensor = r1.next();
        if ((sensor.modality & 2) == 0) goto L9;
        modality = modality | 1;
    L9:
        if ((sensor.modality & 4) == 0) goto L12;
        modality = modality | 2;
    L12:
        if ((sensor.modality & 8) == 0) goto L4;
        modality = modality | 4;
        goto L4
    L15:
        return modality;
    }

    private int sensorIdToModality(int sensorId) {
        Iterator<BiometricSensor> r0 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        BiometricSensor sensor = r0.next();
        if (sensorId != sensor.id) goto L4;
        return sensor.modality;
    L10:
        Slog.e(TAG, "Unknown sensor: " + sensorId);
        return 0;
    }

    private int sensorIdToState(int sensorId) {
        Iterator<BiometricSensor> r0 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        BiometricSensor sensor = r0.next();
        if (sensorId != sensor.id) goto L4;
        return sensor.getSensorState();
    L10:
        Slog.e(TAG, "Unknown sensor: " + sensorId);
        return 0;
    }

    private int sensorIdToStrength(int sensorId) {
        Iterator<BiometricSensor> r0 = this.mPreAuthInfo.eligibleSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        BiometricSensor sensor = r0.next();
        if (sensorId != sensor.id) goto L4;
        return sensor.getCurrentStrength();
    L10:
        Slog.e(TAG, "Unknown sensor: " + sensorId);
        return UnixStat.PERM_MASK;
    }

    private String getAcquiredMessageForSensor(int sensorId, int acquiredInfo, int vendorCode) {
        int modality = sensorIdToModality(sensorId);
        switch(modality) {
            case 2: goto L9;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return FaceManager.getAuthHelpMessage(this.mContext, acquiredInfo, vendorCode);
    L9:
        return FingerprintManager.getAcquiredString(this.mContext, acquiredInfo, vendorCode);
    }

    private int getStatsClient() {
        if (this.mPromptInfo.isForLegacyFingerprintManager() == false) goto L5;
        return 3;
    L5:
        return 2;
    }

    public String toString() {
        return "State: " + this.mState + ", cancelled: " + this.mCancelled + ", isCrypto: " + isCrypto() + ", PreAuthInfo: " + this.mPreAuthInfo + ", requestId: " + this.mRequestId;
    }
}
