package com.android.server.biometrics;

import android.R;
import android.app.admin.DevicePolicyManager;
import android.app.trust.ITrustManager;
import android.content.Context;
import android.hardware.biometrics.PromptInfo;
import android.os.RemoteException;
import android.os.UserManager;
import android.pico.utils.ExtImplFactory;
import android.util.Pair;
import android.util.Slog;
import com.obric.utils.ObricImplFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class PreAuthInfo {
    static final int AUTHENTICATOR_OK = 1;
    static final int BIOMETRIC_DISABLED_BY_DEVICE_POLICY = 3;
    static final int BIOMETRIC_HARDWARE_NOT_DETECTED = 6;
    static final int BIOMETRIC_INSUFFICIENT_STRENGTH = 4;
    static final int BIOMETRIC_INSUFFICIENT_STRENGTH_AFTER_DOWNGRADE = 5;
    static final int BIOMETRIC_LOCKOUT_PERMANENT = 11;
    static final int BIOMETRIC_LOCKOUT_TIMED = 10;
    static final int BIOMETRIC_NOT_ENABLED_FOR_APPS = 8;
    static final int BIOMETRIC_NOT_ENROLLED = 7;
    static final int BIOMETRIC_NO_HARDWARE = 2;
    static final int BIOMETRIC_SENSOR_PRIVACY_ENABLED = 12;
    static final int CREDENTIAL_NOT_ENROLLED = 9;
    static final int MANDATORY_BIOMETRIC_UNAVAILABLE_ERROR = 13;
    private static final String TAG = "BiometricService/PreAuthInfo";
    private static IExtPreAuthInfo sExt;
    private static IObricPreAuthInfo sObricExt;
    final int callingUserId;
    final boolean confirmationRequested;
    final Context context;
    final boolean credentialAvailable;
    final boolean credentialRequested;
    final List<BiometricSensor> eligibleSensors;
    final boolean ignoreEnrollmentState;
    final List<Pair<BiometricSensor, Integer>> ineligibleSensors;
    private final BiometricCameraManager mBiometricCameraManager;
    private final boolean mBiometricRequested;
    private final int mBiometricStrengthRequested;
    private final boolean mIsMandatoryBiometricsAuthentication;
    private final boolean mOnlyMandatoryBiometricsRequested;
    final int userId;

    @Retention(RetentionPolicy.SOURCE)
    @interface AuthenticatorStatus {
    }

    private PreAuthInfo(boolean biometricRequested, int biometricStrengthRequested, boolean credentialRequested, List<BiometricSensor> eligibleSensors, List<Pair<BiometricSensor, Integer>> ineligibleSensors, boolean credentialAvailable, PromptInfo promptInfo, int userId, int callingUserId, Context context, BiometricCameraManager biometricCameraManager, boolean isOnlyMandatoryBiometricsRequested, boolean isMandatoryBiometricsAuthentication) {
        this.mBiometricRequested = biometricRequested;
        this.mBiometricStrengthRequested = biometricStrengthRequested;
        this.mBiometricCameraManager = biometricCameraManager;
        this.credentialRequested = credentialRequested;
        this.eligibleSensors = eligibleSensors;
        this.ineligibleSensors = ineligibleSensors;
        this.credentialAvailable = credentialAvailable;
        this.confirmationRequested = promptInfo.isConfirmationRequested();
        this.ignoreEnrollmentState = promptInfo.isIgnoreEnrollmentState();
        this.userId = userId;
        this.callingUserId = callingUserId;
        this.context = context;
        this.mOnlyMandatoryBiometricsRequested = isOnlyMandatoryBiometricsRequested;
        this.mIsMandatoryBiometricsAuthentication = isMandatoryBiometricsAuthentication;
    }

    static PreAuthInfo create(ITrustManager trustManager, DevicePolicyManager devicePolicyManager, BiometricService.SettingObserver settingObserver, List<BiometricSensor> sensors, int userId, PromptInfo promptInfo, String opPackageName, boolean checkDevicePolicyManager, Context context, BiometricCameraManager biometricCameraManager, UserManager userManager) throws RemoteException {
        if (promptInfo.getAuthenticators() != 65536) goto L5;
        boolean r13 = true;
    L6:
        boolean isOnlyMandatoryBiometricsRequested = r13;
        boolean isMandatoryBiometricsAuthentication = false;
        int effectiveUserId = userId;
        BiometricService.SettingObserver r10 = settingObserver;
        if (dropCredentialFallback(promptInfo.getAuthenticators(), r10.getMandatoryBiometricsEnabledAndRequirementsSatisfiedForUser(effectiveUserId), trustManager) == false) goto L12;
        isMandatoryBiometricsAuthentication = true;
        promptInfo.setAuthenticators(15);
        if (promptInfo.getNegativeButtonText() != null) goto L11;
        Context r5 = context;
        promptInfo.setNegativeButtonText(r5.getString(R.string.cancel));
    L13:
        boolean isMandatoryBiometricsAuthentication2 = isMandatoryBiometricsAuthentication;
        boolean biometricRequested = Utils.isBiometricRequested(promptInfo);
        int requestedStrength = Utils.getPublicBiometricStrength(promptInfo);
        boolean isMandatoryBiometricsAuthentication3 = isMandatoryBiometricsAuthentication2;
        boolean credentialRequested = Utils.isCredentialRequested(promptInfo);
        boolean credentialAvailable = trustManager.isDeviceSecure(userId, r5.getDeviceId());
        List<BiometricSensor> eligibleSensors = new ArrayList();
        List<Pair<BiometricSensor, Integer>> ineligibleSensors = new ArrayList();
        if (biometricRequested == false) goto L24;
        Iterator<BiometricSensor> r19 = sensors.iterator();
    L17:
        if (r19.hasNext() == false) goto L23;
        BiometricSensor sensor = r19.next();
        boolean isMandatoryBiometricsAuthentication4 = isMandatoryBiometricsAuthentication3;
        List<BiometricSensor> eligibleSensors2 = eligibleSensors;
        List<Pair<BiometricSensor, Integer>> ineligibleSensors2 = ineligibleSensors;
        int effectiveUserId2 = effectiveUserId;
        int status = getStatusForBiometricAuthenticator(devicePolicyManager, r10, sensor, effectiveUserId2, opPackageName, checkDevicePolicyManager, requestedStrength, promptInfo.getAllowedSensorIds(), promptInfo.isIgnoreEnrollmentState(), biometricCameraManager);
        effectiveUserId = effectiveUserId2;
        int requestedStrength2 = requestedStrength;
        Slog.d(TAG, "Package: " + opPackageName + " Sensor ID: " + sensor.id + " Modality: " + sensor.modality + " User id: " + effectiveUserId + " Status: " + status);
        if (status != 1) goto L21;
        eligibleSensors2.add(sensor);
    L22:
        eligibleSensors = eligibleSensors2;
        ineligibleSensors = ineligibleSensors2;
        requestedStrength = requestedStrength2;
        isMandatoryBiometricsAuthentication3 = isMandatoryBiometricsAuthentication4;
        r10 = settingObserver;
        goto L17
    L21:
        ineligibleSensors2.add(new Pair(sensor, Integer.valueOf(status)));
        goto L22
    L23:
        boolean isMandatoryBiometricsAuthentication5 = isMandatoryBiometricsAuthentication3;
        List<BiometricSensor> eligibleSensors3 = eligibleSensors;
        List<Pair<BiometricSensor, Integer>> ineligibleSensors3 = ineligibleSensors;
        int requestedStrength3 = requestedStrength;
        sExt.disableUdfpsIfNeed(opPackageName, requestedStrength3, eligibleSensors3, ineligibleSensors3);
    L26:
        return new PreAuthInfo(biometricRequested, requestedStrength3, credentialRequested, eligibleSensors3, ineligibleSensors3, credentialAvailable, promptInfo, effectiveUserId, userId, context, biometricCameraManager, isOnlyMandatoryBiometricsRequested, isMandatoryBiometricsAuthentication5);
    L24:
        isMandatoryBiometricsAuthentication5 = isMandatoryBiometricsAuthentication3;
        eligibleSensors3 = eligibleSensors;
        ineligibleSensors3 = ineligibleSensors;
        requestedStrength3 = requestedStrength;
        goto L26
    L11:
        r5 = context;
        goto L13
    L12:
        r5 = context;
        goto L13
    L5:
        r13 = false;
        goto L6
    }

    private static boolean dropCredentialFallback(int authenticators, boolean isMandatoryBiometricsEnabled, ITrustManager trustManager) {
        if ((authenticators & 65536) != 65536) goto L5;
        boolean isMandatoryBiometricsRequested = true;
    L6:
        if (isMandatoryBiometricsEnabled == false) goto L15;
        if (isMandatoryBiometricsRequested == false) goto L15;
        boolean isInSignificantPlace = trustManager.isInSignificantPlace();     // Catch: RemoteException -> L13
        if (isInSignificantPlace == true) goto L12;
        return true;
    L12:
        return false;
    L14:
        Slog.e(TAG, "Remote exception while trying to check if user is in a trusted location.");
    L15:
        return false;
    L5:
        isMandatoryBiometricsRequested = false;
        goto L6
    }

    private static int getStatusForBiometricAuthenticator(DevicePolicyManager devicePolicyManager, BiometricService.SettingObserver settingObserver, BiometricSensor sensor, int userId, String opPackageName, boolean checkDevicePolicyManager, int requestedStrength, List<Integer> requestedSensorIds, boolean ignoreEnrollmentState, BiometricCameraManager biometricCameraManager) {
        if (requestedSensorIds.isEmpty() == true) goto L8;
        if (requestedSensorIds.contains(Integer.valueOf(sensor.id)) == true) goto L8;
        return 2;
    L8:
        boolean isStrongEnough = false;
        if (Utils.isAtLeastStrength(sensor.oemStrength, requestedStrength) == false) goto L11;
    L14:
        boolean r0 = true;
    L15:
        boolean wasStrongEnough = r0;
        if (Utils.isAtLeastStrength(sensor.getCurrentStrength(), requestedStrength) == false) goto L18;
    L19:
        isStrongEnough = true;
    L20:
        if (wasStrongEnough == false) goto L24;
        if (isStrongEnough == true) goto L24;
        return 5;
    L24:
        if (wasStrongEnough == true) goto L28;
        return 4;
    L28:
        if (sensor.modality == 8) goto L30;
    L67:
        if (sensor.impl.isHardwareDetected(opPackageName) == true) goto L36;
        return 6;
    L36:
        if (sensor.impl.hasEnrolledTemplates(userId, opPackageName) == true) goto L40;
        if (ignoreEnrollmentState == true) goto L40;
        return 7;
    L40:
        if (biometricCameraManager != null) goto L42;
    L49:
        int lockoutMode = sensor.impl.getLockoutModeForUser(userId);     // Catch: RemoteException -> L47
        if (lockoutMode != 1) goto L53;
        return 10;
    L53:
        if (lockoutMode != 2) goto L57;
        return 11;
    L57:
        if (isEnabledForApp(settingObserver, sensor.modality, userId) == true) goto L59;
        return 8;
    L59:
        if (checkDevicePolicyManager == true) goto L61;
    L64:
        return 1;
    L61:
        if (isBiometricDisabledByDevicePolicy(devicePolicyManager, sensor.modality, userId) == false) goto L64;
        return 3;
    L42:
        if (sensor.modality != 8) goto L49;
        if (biometricCameraManager.isCameraPrivacyEnabled() == false) goto L49;
        return 12;
    L66:
        return 6;
    L30:
        if (biometricCameraManager.isAnyCameraUnavailable() == false) goto L67;
        return 6;
    L18:
        if (getObricExt().forceAllowFace(sensor.modality, opPackageName, requestedStrength) == false) goto L20;
    L11:
        if (getObricExt().forceAllowFace(sensor.modality, opPackageName, requestedStrength) == true) goto L14;
        r0 = false;
        goto L15
    }

    private static boolean isEnabledForApp(BiometricService.SettingObserver settingObserver, int modality, int userId) {
        return settingObserver.getEnabledForApps(userId, modality);
    }

    private static boolean isBiometricDisabledByDevicePolicy(DevicePolicyManager devicePolicyManager, int modality, int effectiveUserId) {
        int biometricToCheck = mapModalityToDevicePolicyType(modality);
        if (biometricToCheck == 0) goto L11;
        int devicePolicyDisabledFeatures = devicePolicyManager.getKeyguardDisabledFeatures(null, effectiveUserId);
        if ((biometricToCheck & devicePolicyDisabledFeatures) == 0) goto L7;
        boolean isBiometricDisabled = true;
    L8:
        Slog.w(TAG, "isBiometricDisabledByDevicePolicy(" + modality + "," + effectiveUserId + ")=" + isBiometricDisabled);
        return isBiometricDisabled;
    L7:
        isBiometricDisabled = false;
        goto L8
    L11:
        throw new IllegalStateException("Modality unknown to devicePolicyManager: " + modality);
    }

    private static int mapModalityToDevicePolicyType(int modality) {
        switch(modality) {
            case 2: goto L9;
            case 4: goto L7;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        Slog.e(TAG, "Error modality=" + modality);
        return 0;
    L5:
        return 128;
    L7:
        return 256;
    L9:
        return 32;
    }

    private Pair<BiometricSensor, Integer> calculateErrorByPriority() {
        Pair<BiometricSensor, Integer> sensorNotEnrolled = null;
        Pair<BiometricSensor, Integer> sensorLockout = null;
        Pair<BiometricSensor, Integer> hardwareNotDetected = null;
        Pair<BiometricSensor, Integer> biometricAppNotAllowed = null;
        Iterator<Pair<BiometricSensor, Integer>> r4 = this.ineligibleSensors.iterator();
    L4:
        if (r4.hasNext() == false) goto L20;
        Pair<BiometricSensor, Integer> pair = r4.next();
        int status = ((Integer) pair.second).intValue();
        if (status != 10) goto L8;
    L9:
        sensorLockout = pair;
    L11:
        if (status != 7) goto L14;
        sensorNotEnrolled = pair;
    L14:
        if (status != 6) goto L17;
        hardwareNotDetected = pair;
    L17:
        if (status != 8) goto L4;
        biometricAppNotAllowed = pair;
        goto L4
    L8:
        if (status != 11) goto L11;
    L20:
        if (sensorLockout == null) goto L22;
        return sensorLockout;
    L22:
        if (hardwareNotDetected == null) goto L24;
        return hardwareNotDetected;
    L24:
        if (biometricAppNotAllowed == null) goto L26;
        return biometricAppNotAllowed;
    L26:
        if (sensorNotEnrolled == null) goto L29;
        return sensorNotEnrolled;
    L29:
        return this.ineligibleSensors.get(0);
    }

    private Pair<Integer, Integer> getInternalStatus() {
        int modality = 0;
        boolean cameraPrivacyEnabled = false;
        if (this.mBiometricCameraManager == null) goto L6;
        cameraPrivacyEnabled = this.mBiometricCameraManager.isCameraPrivacyEnabled();
    L6:
        if (this.mBiometricRequested == false) goto L30;
        if (this.credentialRequested == false) goto L30;
        if (this.credentialAvailable == false) goto L12;
    L18:
        Iterator<BiometricSensor> r2 = this.eligibleSensors.iterator();
    L20:
        if (r2.hasNext() == false) goto L23;
        BiometricSensor sensor = r2.next();
        modality = modality | sensor.modality;
        goto L20
    L23:
        if (this.credentialAvailable == false) goto L25;
        modality = modality | 1;
        int status = 1;
    L58:
        Slog.d(TAG, "getCanAuthenticateInternal Modality: " + modality + " AuthenticatorStatus: " + status);
        return new Pair(Integer.valueOf(modality), Integer.valueOf(status));
    L25:
        if (modality != 8) goto L28;
        if (cameraPrivacyEnabled == false) goto L28;
        status = 12;
    L28:
        status = 1;
        goto L58
    L12:
        if (this.eligibleSensors.isEmpty() == false) goto L18;
        if (this.ineligibleSensors.isEmpty() == true) goto L17;
        Pair<BiometricSensor, Integer> pair = calculateErrorByPriority();
        modality = 0 | ((BiometricSensor) pair.first).modality;
        status = ((Integer) pair.second).intValue();
        goto L58
    L17:
        modality = 0 | 1;
        status = 9;
    L30:
        if (this.mBiometricRequested == false) goto L46;
        if (this.eligibleSensors.isEmpty() == true) goto L42;
        Iterator<BiometricSensor> r3 = this.eligibleSensors.iterator();
    L35:
        if (r3.hasNext() == false) goto L37;
        BiometricSensor sensor2 = r3.next();
        modality = modality | sensor2.modality;
        goto L35
    L37:
        if (modality != 8) goto L40;
        if (cameraPrivacyEnabled == false) goto L40;
        status = 12;
    L40:
        status = 1;
        goto L58
    L42:
        if (this.ineligibleSensors.isEmpty() == true) goto L44;
        Pair<BiometricSensor, Integer> pair2 = calculateErrorByPriority();
        modality = 0 | ((BiometricSensor) pair2.first).modality;
        status = ((Integer) pair2.second).intValue();
        goto L58
    L44:
        modality = 0 | 0;
        status = 2;
        goto L58
    L46:
        if (this.credentialRequested == false) goto L53;
        modality = 0 | 1;
        if (this.credentialAvailable == false) goto L50;
        status = 1;
        goto L58
    L50:
        status = 9;
        goto L58
    L53:
        if (this.mOnlyMandatoryBiometricsRequested == true) goto L55;
    L57:
        Slog.e(TAG, "No authenticators requested");
        status = 2;
        goto L58
    L55:
        if (this.mIsMandatoryBiometricsAuthentication == true) goto L57;
        status = 13;
        goto L58
    }

    int getCanAuthenticateResult() {
        return Utils.biometricConstantsToBiometricManager(Utils.authenticatorStatusToBiometricConstant(((Integer) getInternalStatus().second).intValue()));
    }

    boolean getIsMandatoryBiometricsAuthentication() {
        return this.mIsMandatoryBiometricsAuthentication;
    }

    Pair<Integer, Integer> getPreAuthenticateStatus() {
        Pair<Integer, Integer> internalStatus = getInternalStatus();
        int publicError = Utils.authenticatorStatusToBiometricConstant(((Integer) internalStatus.second).intValue());
        int modality = ((Integer) internalStatus.first).intValue();
        switch(((Integer) internalStatus.second).intValue()) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L4;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L4;
        };
    L4:
        modality = 0;
    L7:
        return new Pair(Integer.valueOf(modality), Integer.valueOf(publicError));
    }

    boolean shouldShowCredential() {
        if (this.credentialRequested == true) goto L5;
    L7:
        return false;
    L5:
        if (this.credentialAvailable == false) goto L7;
        return true;
    }

    int getEligibleModalities() {
        int modalities = 0;
        Iterator<BiometricSensor> r1 = this.eligibleSensors.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        BiometricSensor sensor = r1.next();
        modalities = modalities | sensor.modality;
        goto L4
    L7:
        if (this.credentialRequested == true) goto L9;
        return modalities;
    L9:
        if (this.credentialAvailable == true) goto L11;
        return modalities;
    L11:
        return modalities | 1;
    }

    int numSensorsWaitingForCookie() {
        int numWaiting = 0;
        Iterator<BiometricSensor> r1 = this.eligibleSensors.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        BiometricSensor sensor = r1.next();
        if (sensor.getSensorState() != 1) goto L4;
        Slog.d(TAG, "Sensor ID: " + sensor.id + " Waiting for cookie: " + sensor.getCookie());
        numWaiting = numWaiting + 1;
        goto L4
    L9:
        return numWaiting;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("BiometricRequested: " + this.mBiometricRequested + ", StrengthRequested: " + this.mBiometricStrengthRequested + ", CredentialRequested: " + this.credentialRequested);
        string.append(", Eligible:{");
        Iterator<BiometricSensor> r1 = this.eligibleSensors.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        BiometricSensor sensor = r1.next();
        string.append(sensor.id);
        string.append(" ");
        goto L4
    L6:
        string.append("}");
        string.append(", Ineligible:{");
        Iterator<Pair<BiometricSensor, Integer>> r2 = this.ineligibleSensors.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Pair<BiometricSensor, Integer> ineligible = r2.next();
        string.append(ineligible.first);
        string.append(":");
        string.append(ineligible.second);
        string.append(" ");
        goto L8
    L10:
        string.append("}");
        string.append(", CredentialAvailable: ");
        string.append(this.credentialAvailable);
        string.append(", ");
        return string.toString();
    }

    private static synchronized IObricPreAuthInfo getObricExt() {
        monitor-enter(PreAuthInfo.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sObricExt != null) goto L9;
        sObricExt = (IObricPreAuthInfo) ObricImplFactory.getImpl(IObricPreAuthInfo.class, new Object[0]);     // Catch: Throwable -> L7
    L9:
        IObricPreAuthInfo r1 = sObricExt;     // Catch: Throwable -> L7
        monitor-exit(PreAuthInfo.class);
        return r1;
    }

    static {
        sExt = (IExtPreAuthInfo) ExtImplFactory.getImpl(IExtPreAuthInfo.class, new Object[0]);
    }
}
