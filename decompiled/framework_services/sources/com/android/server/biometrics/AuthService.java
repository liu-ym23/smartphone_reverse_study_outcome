package com.android.server.biometrics;

import android.R;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.biometrics.AuthenticationStateListener;
import android.hardware.biometrics.ComponentInfoInternal;
import android.hardware.biometrics.IAuthService;
import android.hardware.biometrics.IBiometricEnabledOnKeyguardCallback;
import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.IBiometricServiceReceiver;
import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.PromptInfo;
import android.hardware.biometrics.SensorLocationInternal;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.hardware.face.FaceSensorConfigurations;
import android.hardware.face.FaceSensorPropertiesInternal;
import android.hardware.face.IFaceService;
import android.hardware.fingerprint.FingerprintSensorConfigurations;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.hardware.fingerprint.IFingerprintService;
import android.hardware.iris.IIrisService;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.SystemService;
import com.android.server.biometrics.sensors.face.FaceService;
import com.android.server.biometrics.sensors.fingerprint.FingerprintService;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes.dex */
public class AuthService extends SystemService {
    private static final int DEFAULT_HIDL_DISABLED = 0;
    private static final String SETTING_HIDL_DISABLED = "com.android.server.biometrics.AuthService.hidlDisabled";
    private static final String SYSPROP_API_LEVEL = "ro.board.api_level";
    private static final String SYSPROP_FIRST_API_LEVEL = "ro.board.first_api_level";
    private static final String TAG = "AuthService";
    private IBiometricService mBiometricService;
    final IAuthService.Stub mImpl;
    private final Injector mInjector;

    private final class AuthServiceImpl extends IAuthService.Stub {
        final /* synthetic */ AuthService this$0;

        /* synthetic */ AuthServiceImpl(AuthService r1, AuthServiceIA r2) {
            this(r1);
        }

        private AuthServiceImpl(AuthService r1) {
            this.this$0 = r1;
        }

        public ITestSession createTestSession(int sensorId, ITestSessionCallback callback, String opPackageName) throws RemoteException {
            super.createTestSession_enforcePermission();
            long identity = Binder.clearCallingIdentity();
            ITestSession r2 = AuthService.m2552$$Nest$fgetmInjector(this.this$0).getBiometricService().createTestSession(sensorId, callback, opPackageName);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<SensorPropertiesInternal> getSensorProperties(String opPackageName) throws RemoteException {
            super.getSensorProperties_enforcePermission();
            long identity = Binder.clearCallingIdentity();
            List<SensorPropertiesInternal> r2 = AuthService.m2552$$Nest$fgetmInjector(this.this$0).getBiometricService().getSensorProperties(opPackageName);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public String getUiPackage() {
            super.getUiPackage_enforcePermission();
            return this.this$0.getContext().getResources().getString(R.string.config_defaultListenerAccessPackages);
        }

        public long authenticate(IBinder token, long sessionId, int userId, IBiometricServiceReceiver receiver, String opPackageName, PromptInfo promptInfo) throws RemoteException {
            int callingUserId = UserHandle.getCallingUserId();
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            if (userId != callingUserId) goto L5;
            AuthService.m2556$$Nest$mcheckPermission(this.this$0);
        L7:
            if (AuthService.m2553$$Nest$mcheckAppOps(this.this$0, callingUid, opPackageName, "authenticate()") == true) goto L10;
            authenticateFastFail("Denied by app ops: " + opPackageName, receiver);
            return -1;
        L10:
            if (token == null) goto L41;
            if (receiver == null) goto L41;
            if (opPackageName == null) goto L41;
            if (promptInfo == null) goto L41;
            if (Utils.isForeground(callingUid, callingPid) == true) goto L20;
            authenticateFastFail("Caller is not foreground: " + opPackageName, receiver);
            return -1;
        L20:
            if (promptInfo.requiresTestOrInternalPermission() == false) goto L25;
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.TEST_BIOMETRIC") == 0) goto L25;
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
        L25:
            if (promptInfo.requiresInternalPermission() == false) goto L28;
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
        L28:
            if (promptInfo.requiresAdvancedPermission() == false) goto L30;
            AuthService.m2554$$Nest$mcheckBiometricAdvancedPermission(this.this$0);
        L30:
            long identity = Binder.clearCallingIdentity();
            VirtualDeviceManagerInternal vdm = (VirtualDeviceManagerInternal) AuthService.access$100(this.this$0, VirtualDeviceManagerInternal.class);     // Catch: Throwable -> L34
            if (vdm == null) goto L36;
            vdm.onAuthenticationPrompt(callingUid);     // Catch: Throwable -> L34
        L36:
            long r15 = AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).authenticate(token, sessionId, userId, receiver, opPackageName, promptInfo);     // Catch: Throwable -> L34
            Binder.restoreCallingIdentity(identity);
            return r15;
        L34:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L41:
            authenticateFastFail("Unable to authenticate, one or more null arguments", receiver);
            return -1;
        L5:
            Slog.w(AuthService.TAG, "User " + callingUserId + " is requesting authentication of userid: " + userId);
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
            goto L7
        }

        private void authenticateFastFail(String message, IBiometricServiceReceiver receiver) {
            Slog.e(AuthService.TAG, "authenticateFastFail: " + message);
            receiver.onError(0, 5, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(AuthService.TAG, "authenticateFastFail failed to notify caller", e);
        }

        public void cancelAuthentication(IBinder token, String opPackageName, long requestId) throws RemoteException {
            AuthService.m2556$$Nest$mcheckPermission(this.this$0);
            if (token == null) goto L13;
            if (opPackageName == null) goto L13;
            long identity = Binder.clearCallingIdentity();
            AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).cancelAuthentication(token, opPackageName, requestId);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L13:
            Slog.e(AuthService.TAG, "Unable to cancel authentication, one or more null arguments");
        }

        public int canAuthenticate(String opPackageName, int userId, int authenticators) throws RemoteException {
            int callingUserId = UserHandle.getCallingUserId();
            if (userId == callingUserId) goto L5;
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
        L6:
            long identity = Binder.clearCallingIdentity();
            int result = AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).canAuthenticate(opPackageName, userId, callingUserId, authenticators);     // Catch: Throwable -> L10
            Slog.d(AuthService.TAG, "canAuthenticate, userId: " + userId + ", callingUserId: " + callingUserId + ", authenticators: " + authenticators + ", result: " + result);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return result;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L5:
            AuthService.m2556$$Nest$mcheckPermission(this.this$0);
            goto L6
        }

        public long getLastAuthenticationTime(int userId, int authenticators) throws RemoteException {
            int callingUserId = UserHandle.getCallingUserId();
            if (userId == callingUserId) goto L5;
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
        L6:
            long identity = Binder.clearCallingIdentity();
            long r3 = AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).getLastAuthenticationTime(userId, authenticators);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return r3;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L5:
            AuthService.m2556$$Nest$mcheckPermission(this.this$0);
            goto L6
        }

        public boolean hasEnrolledBiometrics(int userId, String opPackageName) throws RemoteException {
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
            long identity = Binder.clearCallingIdentity();
            boolean r2 = AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).hasEnrolledBiometrics(userId, opPackageName);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void registerEnabledOnKeyguardCallback(IBiometricEnabledOnKeyguardCallback callback) throws RemoteException {
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
            long identity = Binder.clearCallingIdentity();
            AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).registerEnabledOnKeyguardCallback(callback);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void registerAuthenticationStateListener(AuthenticationStateListener listener) throws RemoteException {
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
            IFingerprintService fingerprintService = AuthService.m2552$$Nest$fgetmInjector(this.this$0).getFingerprintService();
            if (fingerprintService == null) goto L5;
            fingerprintService.registerAuthenticationStateListener(listener);
        L5:
            IFaceService faceService = AuthService.m2552$$Nest$fgetmInjector(this.this$0).getFaceService();
            if (faceService == null) goto L9;
            faceService.registerAuthenticationStateListener(listener);
            return;
        }

        public void unregisterAuthenticationStateListener(AuthenticationStateListener listener) throws RemoteException {
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
            IFingerprintService fingerprintService = AuthService.m2552$$Nest$fgetmInjector(this.this$0).getFingerprintService();
            if (fingerprintService == null) goto L5;
            fingerprintService.unregisterAuthenticationStateListener(listener);
        L5:
            IFaceService faceService = AuthService.m2552$$Nest$fgetmInjector(this.this$0).getFaceService();
            if (faceService == null) goto L9;
            faceService.unregisterAuthenticationStateListener(listener);
            return;
        }

        public void invalidateAuthenticatorIds(int userId, int fromSensorId, IInvalidationCallback callback) throws RemoteException {
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
            long identity = Binder.clearCallingIdentity();
            AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).invalidateAuthenticatorIds(userId, fromSensorId, callback);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public long[] getAuthenticatorIds(int userId) throws RemoteException {
            int callingUserId = UserHandle.getCallingUserId();
            if (userId == callingUserId) goto L5;
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.USE_BIOMETRIC_INTERNAL", "Must have android.permission.USE_BIOMETRIC_INTERNAL permission.");
        L5:
            long identity = Binder.clearCallingIdentity();
            long[] r3 = AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).getAuthenticatorIds(userId);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return r3;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void resetLockoutTimeBound(IBinder token, String opPackageName, int fromSensorId, int userId, byte[] hardwareAuthToken) throws RemoteException {
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
            long identity = Binder.clearCallingIdentity();
            AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).resetLockoutTimeBound(token, opPackageName, fromSensorId, userId, hardwareAuthToken);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L8:
            th = move-exception;
            Throwable r10 = th;
        L12:
            Binder.restoreCallingIdentity(identity);
            throw r10;
        L10:
            th = move-exception;
            r10 = th;
            goto L12
        }

        public void resetLockout(int userId, byte[] hardwareAuthToken) throws RemoteException {
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
            long identity = Binder.clearCallingIdentity();
            AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).resetLockout(userId, hardwareAuthToken);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public CharSequence getButtonLabel(int userId, String opPackageName, int authenticators) throws RemoteException {
            int callingUserId = UserHandle.getCallingUserId();
            if (userId == callingUserId) goto L5;
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
        L6:
            long identity = Binder.clearCallingIdentity();
            int modality = AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).getCurrentModality(opPackageName, userId, callingUserId, authenticators);     // Catch: Throwable -> L10
            switch(AuthService.m2557$$Nest$smgetCredentialBackupModality(modality)) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L13;
                case 8: goto L12;
                default: goto L9;
            };     // Catch: Throwable -> L10
        L9:
            String result = this.this$0.getContext().getString(R.string.capability_desc_canPerformGestures);     // Catch: Throwable -> L10
        L17:
            Binder.restoreCallingIdentity(identity);
            return result;
        L12:
            result = this.this$0.getContext().getString(R.string.fingerprints);     // Catch: Throwable -> L10
            goto L17
        L13:
            result = this.this$0.getContext().getString(R.string.granularity_label_character);     // Catch: Throwable -> L10
            goto L17
        L14:
            result = this.this$0.getContext().getString(R.string.usb_contaminant_not_detected_title);     // Catch: Throwable -> L10
            goto L17
        L16:
            result = null;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L5:
            AuthService.m2556$$Nest$mcheckPermission(this.this$0);
            goto L6
        }

        public CharSequence getPromptMessage(int userId, String opPackageName, int authenticators) throws RemoteException {
            int callingUserId = UserHandle.getCallingUserId();
            if (userId == callingUserId) goto L5;
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
        L6:
            long identity = Binder.clearCallingIdentity();
            int modality = AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).getCurrentModality(opPackageName, userId, callingUserId, authenticators);     // Catch: Throwable -> L11
            boolean isCredentialAllowed = Utils.isCredentialRequested(authenticators);     // Catch: Throwable -> L11
            switch(AuthService.m2557$$Nest$smgetCredentialBackupModality(modality)) {
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L17;
                case 8: goto L14;
                default: goto L9;
            };     // Catch: Throwable -> L11
        L9:
            if (isCredentialAllowed == false) goto L13;
            String result = this.this$0.getContext().getString(R.string.capital_on);     // Catch: Throwable -> L11
        L23:
            Binder.restoreCallingIdentity(identity);
            return result;
        L13:
            result = this.this$0.getContext().getString(R.string.capability_desc_canRetrieveWindowContent);     // Catch: Throwable -> L11
            goto L23
        L14:
            if (isCredentialAllowed == false) goto L16;
            result = this.this$0.getContext().getString(R.string.fp_power_button_bp_message);     // Catch: Throwable -> L11
            goto L23
        L16:
            result = this.this$0.getContext().getString(R.string.font_family_button_material);     // Catch: Throwable -> L11
            goto L23
        L17:
            if (isCredentialAllowed == false) goto L19;
            result = this.this$0.getContext().getString(R.string.httpErrorConnect);     // Catch: Throwable -> L11
            goto L23
        L19:
            result = this.this$0.getContext().getString(R.string.harmful_app_warning_open_anyway);     // Catch: Throwable -> L11
            goto L23
        L20:
            result = this.this$0.getContext().getString(R.string.usb_device_resolve_prompt_warn);     // Catch: Throwable -> L11
            goto L23
        L22:
            result = null;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L5:
            AuthService.m2556$$Nest$mcheckPermission(this.this$0);
            goto L6
        }

        public CharSequence getSettingName(int userId, String opPackageName, int authenticators) throws RemoteException {
            int callingUserId = UserHandle.getCallingUserId();
            if (userId == callingUserId) goto L5;
            AuthService.m2555$$Nest$mcheckInternalPermission(this.this$0);
        L6:
            long identity = Binder.clearCallingIdentity();
            int modality = AuthService.m2551$$Nest$fgetmBiometricService(this.this$0).getSupportedModalities(authenticators);     // Catch: Throwable -> L12
            switch(modality) {
                case 0: goto L26;
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L10;
                case 4: goto L22;
                case 5: goto L10;
                case 6: goto L10;
                case 7: goto L10;
                case 8: goto L21;
                default: goto L10;
            };     // Catch: Throwable -> L12
        L21:
            String result = this.this$0.getContext().getString(R.string.fingerprints);     // Catch: Throwable -> L12
        L27:
            Binder.restoreCallingIdentity(identity);
            return result;
        L22:
            result = this.this$0.getContext().getString(R.string.capability_desc_canPerformGestures);     // Catch: Throwable -> L12
            goto L27
        L23:
            result = this.this$0.getContext().getString(R.string.granularity_label_character);     // Catch: Throwable -> L12
            goto L27
        L24:
            result = this.this$0.getContext().getString(R.string.usb_contaminant_not_detected_title);     // Catch: Throwable -> L12
            goto L27
        L26:
            result = null;
            goto L27
        L10:
            if ((modality & 1) != 0) goto L14;
            result = this.this$0.getContext().getString(R.string.capability_desc_canPerformGestures);     // Catch: Throwable -> L12
            goto L27
        L14:
            int biometricModality = modality & (-2);     // Catch: Throwable -> L12
            if (biometricModality != 2) goto L18;
            result = this.this$0.getContext().getString(R.string.httpErrorAuth);     // Catch: Throwable -> L12
            goto L27
        L18:
            if (biometricModality != 8) goto L20;
            result = this.this$0.getContext().getString(R.string.forward_intent_to_work);     // Catch: Throwable -> L12
            goto L27
        L20:
            result = this.this$0.getContext().getString(R.string.capital_off);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L5:
            AuthService.m2556$$Nest$mcheckPermission(this.this$0);
            goto L6
        }
    }

    public static class Injector {
        public Injector() {
        }

        public IBiometricService getBiometricService() {
            return IBiometricService.Stub.asInterface(ServiceManager.getService("biometric"));
        }

        public void publishBinderService(AuthService service, IAuthService.Stub impl) {
            AuthService.access$000(service, "auth", impl);
        }

        public String[] getConfiguration(Context context) {
            return context.getResources().getStringArray(R.array.config_convert_to_emergency_number_map);
        }

        public String[] getFingerprintConfiguration(Context context) {
            return getConfiguration(context);
        }

        public String[] getFaceConfiguration(Context context) {
            return getConfiguration(context);
        }

        public String[] getIrisConfiguration(Context context) {
            return getConfiguration(context);
        }

        public IFingerprintService getFingerprintService() {
            return IFingerprintService.Stub.asInterface(ServiceManager.getService("fingerprint"));
        }

        public IFaceService getFaceService() {
            return IFaceService.Stub.asInterface(ServiceManager.getService("face"));
        }

        public IIrisService getIrisService() {
            return IIrisService.Stub.asInterface(ServiceManager.getService("iris"));
        }

        public AppOpsManager getAppOps(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }

        public boolean isHidlDisabled(Context context) {
            if (Build.IS_ENG == true) goto L9;
            if (Build.IS_USERDEBUG == true) goto L9;
            return false;
        L9:
            if (Settings.Secure.getIntForUser(context.getContentResolver(), AuthService.SETTING_HIDL_DISABLED, 0, -2) == 1) goto L11;
            return false;
        L11:
            return true;
        }

        public String[] getFingerprintAidlInstances() {
            return FingerprintService.getDeclaredInstances();
        }

        public String[] getFaceAidlInstances() {
            return FaceService.getDeclaredInstances();
        }

        public BiometricHandlerProvider getBiometricHandlerProvider() {
            return BiometricHandlerProvider.getInstance();
        }
    }

    public static /* synthetic */ void $r8$lambda$8WVvXqW3t71Xu3Pnd87JYdrqrbA(String[] r0, Context r1, String[] r2, IFingerprintService r3) {
        lambda$registerFingerprintSensors$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$QH_Ki2CXRp4czGmln7B_Z5KU08U(boolean r0, String[] r1, Context r2, String[] r3, IFaceService r4) {
        lambda$registerFaceSensors$0(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBiometricService m2551$$Nest$fgetmBiometricService(AuthService r0) {
        return r0.mBiometricService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m2552$$Nest$fgetmInjector(AuthService r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckAppOps, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2553$$Nest$mcheckAppOps(AuthService r0, int r1, String r2, String r3) {
        return r0.checkAppOps(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckBiometricAdvancedPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2554$$Nest$mcheckBiometricAdvancedPermission(AuthService r0) {
        r0.checkBiometricAdvancedPermission();
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckInternalPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2555$$Nest$mcheckInternalPermission(AuthService r0) {
        r0.checkInternalPermission();
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2556$$Nest$mcheckPermission(AuthService r0) {
        r0.checkPermission();
    }

    /* JADX INFO: renamed from: -$$Nest$smgetCredentialBackupModality, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2557$$Nest$smgetCredentialBackupModality(int r0) {
        return getCredentialBackupModality(r0);
    }

    static /* synthetic */ void access$000(AuthService x0, String x1, IBinder x2) {
        x0.publishBinderService(x1, x2);
    }

    static /* synthetic */ Object access$100(AuthService x0, Class x1) {
        return x0.getLocalService(x1);
    }

    public AuthService(Context context) {
        this(context, new Injector());
    }

    public AuthService(Context context, Injector injector) {
        super(context);
        this.mInjector = injector;
        this.mImpl = new AuthServiceImpl(this, null);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mBiometricService = this.mInjector.getBiometricService();
        if (this.mInjector.isHidlDisabled(getContext()) == true) goto L15;
        int firstApiLevel = SystemProperties.getInt(SYSPROP_FIRST_API_LEVEL, 0);
        int apiLevel = SystemProperties.getInt(SYSPROP_API_LEVEL, firstApiLevel);
        String[] configStrings = this.mInjector.getConfiguration(getContext());
        if (configStrings.length == 0) goto L7;
    L9:
        SensorConfig[] hidlConfigs = new SensorConfig[configStrings.length];
        int i = 0;
    L11:
        if (i >= configStrings.length) goto L15;
        hidlConfigs[i] = new SensorConfig(configStrings[i]);
        i = i + 1;
        goto L11
    L7:
        if (apiLevel != 30) goto L9;
        Slog.w(TAG, "Found R vendor partition without config_biometric_sensors");
        configStrings = generateRSdkCompatibleConfiguration();
    L15:
        registerAuthenticators();
        this.mInjector.publishBinderService(this, this.mImpl);
    }

    private void registerAuthenticators() {
        BiometricHandlerProvider handlerProvider = this.mInjector.getBiometricHandlerProvider();
        registerFingerprintSensors(this.mInjector.getFingerprintAidlInstances(), this.mInjector.getFingerprintConfiguration(getContext()), getContext(), this.mInjector.getFingerprintService(), handlerProvider);
        registerFaceSensors(this.mInjector.getFaceAidlInstances(), this.mInjector.getFaceConfiguration(getContext()), getContext(), this.mInjector.getFaceService(), handlerProvider);
        registerIrisSensors(this.mInjector.getIrisConfiguration(getContext()));
    }

    private void registerIrisSensors(String[] hidlConfigStrings) {
        int r1 = 0;
        if (this.mInjector.isHidlDisabled(getContext()) == true) goto L14;
        int firstApiLevel = SystemProperties.getInt(SYSPROP_FIRST_API_LEVEL, 0);
        int apiLevel = SystemProperties.getInt(SYSPROP_API_LEVEL, firstApiLevel);
        if (hidlConfigStrings.length == 0) goto L7;
    L9:
        SensorConfig[] hidlConfigs = new SensorConfig[hidlConfigStrings.length];
        int i = 0;
    L11:
        if (i >= hidlConfigStrings.length) goto L15;
        hidlConfigs[i] = new SensorConfig(hidlConfigStrings[i]);
        i = i + 1;
    L15:
        List<SensorPropertiesInternal> hidlIrisSensors = new ArrayList();
        if (hidlConfigs == null) goto L25;
        int r3 = hidlConfigs.length;
    L19:
        if (r1 >= r3) goto L25;
        SensorConfig sensor = hidlConfigs[r1];
        switch(sensor.modality) {
            case 4: goto L23;
            default: goto L22;
        };
    L22:
        Slog.e(TAG, "Unknown modality: " + sensor.modality);
    L24:
        r1 = r1 + 1;
        goto L19
    L23:
        hidlIrisSensors.add(getHidlIrisSensorProps(sensor.id, sensor.strength));
    L25:
        IIrisService irisService = this.mInjector.getIrisService();
        if (irisService == null) goto L32;
        irisService.registerAuthenticators(hidlIrisSensors);     // Catch: RemoteException -> L29
        return;
    L29:
        e = move-exception;
        Slog.e(TAG, "RemoteException when registering iris authenticators", e);
        return;
    L32:
        if (hidlIrisSensors.size() <= 0) goto L41;
        Slog.e(TAG, "HIDL iris configuration exists, but IrisService is null.");
        return;
    L41:
        return;
    L7:
        if (apiLevel != 30) goto L9;
        Slog.w(TAG, "Found R vendor partition without config_biometric_sensors");
        hidlConfigStrings = generateRSdkCompatibleConfiguration();
        goto L9
    L14:
        hidlConfigs = null;
        goto L15
    }

    private static void registerFaceSensors(final String[] faceAidlInstances, final String[] hidlConfigStrings, final Context context, final IFaceService faceService, BiometricHandlerProvider handlerProvider) {
        if (hidlConfigStrings != null) goto L5;
    L6:
        if (faceAidlInstances == null) goto L30;
        if (faceAidlInstances.length == 0) goto L30;
    L10:
        boolean tempResetLockoutRequiresChallenge = false;
        if (hidlConfigStrings != null) goto L13;
    L27:
        final boolean resetLockoutRequiresChallenge = tempResetLockoutRequiresChallenge;
        handlerProvider.getFaceHandler().post(new AuthService$$ExternalSyntheticLambda0(resetLockoutRequiresChallenge, hidlConfigStrings, context, faceAidlInstances, faceService));
        return;
    L13:
        if (hidlConfigStrings.length <= 0) goto L27;
        int r2 = hidlConfigStrings.length;
        int r4 = 0;
        boolean tempResetLockoutRequiresChallenge2 = false;
    L16:
        if (r4 >= r2) goto L26;
        String configString = hidlConfigStrings[r4];
        SensorConfig sensor = new SensorConfig(configString);     // Catch: Exception -> L23
        switch(sensor.modality) {
            case 8: goto L21;
            default: goto L25;
        };
    L21:
        tempResetLockoutRequiresChallenge2 = true;
    L25:
        r4 = r4 + 1;
    L23:
        e = move-exception;
        Slog.e(TAG, "Error parsing configString: " + configString, e);
        goto L25
    L26:
        tempResetLockoutRequiresChallenge = tempResetLockoutRequiresChallenge2;
    L30:
        Slog.d(TAG, "No face sensors.");
        return;
    L5:
        if (hidlConfigStrings.length != 0) goto L10;
        goto L6
    }

    private static /* synthetic */ void lambda$registerFaceSensors$0(boolean resetLockoutRequiresChallenge, String[] hidlConfigStrings, Context context, String[] faceAidlInstances, IFaceService faceService) {
        FaceSensorConfigurations mFaceSensorConfigurations = new FaceSensorConfigurations(resetLockoutRequiresChallenge);
        if (hidlConfigStrings != null) goto L5;
    L7:
        if (faceAidlInstances == null) goto L12;
        if (faceAidlInstances.length <= 0) goto L12;
        mFaceSensorConfigurations.addAidlConfigs(faceAidlInstances);
    L12:
        if (faceService == null) goto L18;
        faceService.registerAuthenticators(mFaceSensorConfigurations);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        Slog.e(TAG, "RemoteException when registering face authenticators", e);
        return;
    L18:
        if (mFaceSensorConfigurations.hasSensorConfigurations() == false) goto L23;
        Slog.e(TAG, "Face configuration exists, but FaceService is null.");
        return;
    L23:
        return;
    L5:
        if (hidlConfigStrings.length <= 0) goto L7;
        mFaceSensorConfigurations.addHidlConfigs(hidlConfigStrings, context);
        goto L7
    }

    private static void registerFingerprintSensors(final String[] fingerprintAidlInstances, final String[] hidlConfigStrings, final Context context, final IFingerprintService fingerprintService, BiometricHandlerProvider handlerProvider) {
        if (hidlConfigStrings != null) goto L4;
    L5:
        if (fingerprintAidlInstances != null) goto L7;
    L11:
        Slog.d(TAG, "No fingerprint sensors.");
        return;
    L7:
        if (fingerprintAidlInstances.length == 0) goto L11;
    L9:
        handlerProvider.getFingerprintHandler().post(new AuthService$$ExternalSyntheticLambda1(hidlConfigStrings, context, fingerprintAidlInstances, fingerprintService));
        return;
    L4:
        if (hidlConfigStrings.length != 0) goto L9;
        goto L5
    }

    private static /* synthetic */ void lambda$registerFingerprintSensors$1(String[] hidlConfigStrings, Context context, String[] fingerprintAidlInstances, IFingerprintService fingerprintService) {
        if (hidlConfigStrings != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        FingerprintSensorConfigurations mFingerprintSensorConfigurations = new FingerprintSensorConfigurations(r1);
        if (hidlConfigStrings != null) goto L12;
    L14:
        if (fingerprintAidlInstances == null) goto L19;
        if (fingerprintAidlInstances.length <= 0) goto L19;
        mFingerprintSensorConfigurations.addAidlSensors(fingerprintAidlInstances);
    L19:
        if (fingerprintService == null) goto L25;
        fingerprintService.registerAuthenticators(mFingerprintSensorConfigurations);     // Catch: RemoteException -> L22
        return;
    L22:
        e = move-exception;
        Slog.e(TAG, "RemoteException when registering fingerprint authenticators", e);
        return;
    L25:
        if (mFingerprintSensorConfigurations.hasSensorConfigurations() == false) goto L30;
        Slog.e(TAG, "Fingerprint configuration exists, but FingerprintService is null.");
        return;
    L30:
        return;
    L12:
        if (hidlConfigStrings.length <= 0) goto L14;
        mFingerprintSensorConfigurations.addHidlSensors(hidlConfigStrings, context);
        goto L14
    L5:
        if (hidlConfigStrings.length <= 0) goto L8;
        r1 = false;
        goto L9
    }

    private String[] generateRSdkCompatibleConfiguration() {
        PackageManager pm = getContext().getPackageManager();
        ArrayList<String> modalities = new ArrayList();
        if (pm.hasSystemFeature("android.hardware.fingerprint") == false) goto L6;
        modalities.add(String.valueOf(2));
    L6:
        if (pm.hasSystemFeature("android.hardware.biometrics.face") == false) goto L8;
        modalities.add(String.valueOf(8));
    L8:
        String strength = String.valueOf(UnixStat.PERM_MASK);
        String[] configStrings = new String[modalities.size()];
        int i = 0;
    L10:
        if (i >= modalities.size()) goto L12;
        String id = String.valueOf(i);
        String modality = modalities.get(i);
        configStrings[i] = String.join(":", new CharSequence[]{id, modality, strength});
        i = i + 1;
        goto L10
    L12:
        Slog.d(TAG, "Generated config_biometric_sensors: " + Arrays.toString(configStrings));
        return configStrings;
    }

    private void checkInternalPermission() {
        getContext().enforceCallingOrSelfPermission("android.permission.USE_BIOMETRIC_INTERNAL", "Must have USE_BIOMETRIC_INTERNAL permission");
    }

    private void checkBiometricAdvancedPermission() {
        getContext().enforceCallingOrSelfPermission("android.permission.SET_BIOMETRIC_DIALOG_ADVANCED", "Must have SET_BIOMETRIC_DIALOG_ADVANCED permission");
    }

    private void checkPermission() {
        if (getContext().checkCallingOrSelfPermission("android.permission.USE_FINGERPRINT") == 0) goto L6;
        getContext().enforceCallingOrSelfPermission("android.permission.USE_BIOMETRIC", "Must have USE_BIOMETRIC permission");
        return;
    }

    private boolean checkAppOps(int uid, String opPackageName, String reason) {
        if (this.mInjector.getAppOps(getContext()).noteOp(78, uid, opPackageName, null, reason) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static int getCredentialBackupModality(int modality) {
        if (modality != 1) goto L6;
        return modality;
    L6:
        return modality & (-2);
    }

    private FingerprintSensorPropertiesInternal getHidlFingerprintSensorProps(int sensorId, int strength) {
        int[] udfpsProps = getContext().getResources().getIntArray(R.array.face_acquired_vendor);
        boolean isUdfps = !ArrayUtils.isEmpty(udfpsProps);
        boolean isPowerbuttonFps = getContext().getResources().getBoolean(R.bool.config_launchCameraOnCameraLensCoverToggle);
        if (isUdfps == false) goto L5;
        int sensorType = 3;
    L8:
        int maxEnrollmentsPerUser = getContext().getResources().getInteger(R.integer.config_jobSchedulerInactivityIdleThresholdOnStablePower);
        List<ComponentInfoInternal> componentInfo = new ArrayList();
        if (isUdfps == false) goto L15;
        if (udfpsProps.length != 3) goto L15;
        return new FingerprintSensorPropertiesInternal(sensorId, Utils.authenticatorStrengthToPropertyStrength(strength), maxEnrollmentsPerUser, componentInfo, sensorType, true, false, List.of(new SensorLocationInternal("", udfpsProps[0], udfpsProps[1], udfpsProps[2])));
    L15:
        return new FingerprintSensorPropertiesInternal(sensorId, Utils.authenticatorStrengthToPropertyStrength(strength), maxEnrollmentsPerUser, componentInfo, sensorType, false);
    L5:
        if (isPowerbuttonFps == false) goto L7;
        sensorType = 4;
        goto L8
    L7:
        sensorType = 1;
        goto L8
    }

    private FaceSensorPropertiesInternal getHidlFaceSensorProps(int sensorId, int strength) {
        boolean supportsSelfIllumination = getContext().getResources().getBoolean(R.bool.config_focusScrollContainersInTouchMode);
        int maxTemplatesAllowed = getContext().getResources().getInteger(R.integer.config_jobSchedulerInactivityIdleThreshold);
        List<ComponentInfoInternal> componentInfo = new ArrayList();
        return new FaceSensorPropertiesInternal(sensorId, Utils.authenticatorStrengthToPropertyStrength(strength), maxTemplatesAllowed, componentInfo, 0, false, supportsSelfIllumination, true);
    }

    private SensorPropertiesInternal getHidlIrisSensorProps(int sensorId, int strength) {
        List<ComponentInfoInternal> componentInfo = new ArrayList();
        return new SensorPropertiesInternal(sensorId, Utils.authenticatorStrengthToPropertyStrength(strength), 1, componentInfo, false, false);
    }
}
