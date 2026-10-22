package com.android.server.biometrics;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.PromptInfo;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Slog;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.biometrics.sensors.BaseClientMonitor;
import com.android.server.pm.PackageManagerService;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    private static final String TAG = "BiometricUtils";

    public Utils() {
    }

    public static boolean isDebugEnabled(Context context, int targetUserId) {
        if (targetUserId != (-10000)) goto L6;
        return false;
    L6:
        if (Build.IS_ENG == true) goto L11;
        if (Build.IS_USERDEBUG == true) goto L11;
        return false;
    L11:
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "biometric_debug_enabled", 0, targetUserId) != 0) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean isFingerprintVirtualEnabled(Context context) {
        if (Build.isDebuggable() == true) goto L5;
        return false;
    L5:
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "biometric_fingerprint_virtual_enabled", 0, -2) == 1) goto L10;
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "biometric_virtual_enabled", 0, -2) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isFaceVirtualEnabled(Context context) {
        if (Build.isDebuggable() == true) goto L5;
        return false;
    L5:
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "biometric_face_virtual_enabled", 0, -2) == 1) goto L10;
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "biometric_virtual_enabled", 0, -2) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    static void combineAuthenticatorBundles(PromptInfo promptInfo) {
        boolean deviceCredentialAllowed = promptInfo.isDeviceCredentialAllowed();
        promptInfo.setDeviceCredentialAllowed(false);
        if (promptInfo.getAuthenticators() == 0) goto L5;
        int authenticators = promptInfo.getAuthenticators();
    L9:
        promptInfo.setAuthenticators(authenticators);
        return;
    L5:
        if (deviceCredentialAllowed == false) goto L7;
        authenticators = 33023;
        goto L9
    L7:
        authenticators = 255;
        goto L9
    }

    static boolean isCredentialRequested(int authenticators) {
        if ((32768 & authenticators) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isMandatoryBiometricsRequested(int authenticators) {
        if ((65536 & authenticators) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isCredentialRequested(PromptInfo promptInfo) {
        return isCredentialRequested(promptInfo.getAuthenticators());
    }

    static int getPublicBiometricStrength(int authenticators) {
        return authenticators & 255;
    }

    static int getPublicBiometricStrength(PromptInfo promptInfo) {
        return getPublicBiometricStrength(promptInfo.getAuthenticators());
    }

    static boolean isBiometricRequested(int authenticators) {
        if (getPublicBiometricStrength(authenticators) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isBiometricRequested(PromptInfo promptInfo) {
        if (getPublicBiometricStrength(promptInfo) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAtLeastStrength(int sensorStrength, int requestedStrength) {
        int sensorStrength2 = sensorStrength & 32767;
        if (((~requestedStrength) & sensorStrength2) == 0) goto L5;
        return false;
    L5:
        int i = 1;
    L6:
        if (i > requestedStrength) goto L11;
        if (i == sensorStrength2) goto L9;
        i = (i << 1) | 1;
        goto L6
    L9:
        return true;
    L11:
        Slog.e("BiometricService", "Unknown sensorStrength: " + sensorStrength2 + ", requestedStrength: " + requestedStrength);
        return false;
    }

    static boolean isValidAuthenticatorConfig(Context context, PromptInfo promptInfo) {
        int authenticators = promptInfo.getAuthenticators();
        return isValidAuthenticatorConfig(context, authenticators);
    }

    static boolean isValidAuthenticatorConfig(Context context, int authenticators) {
        if (authenticators != 0) goto L6;
        return true;
    L6:
        if ((authenticators & (-131072)) == 0) goto L9;
        Slog.e("BiometricService", "Non-biometric, non-credential bits found. Authenticators: " + authenticators);
        return false;
    L9:
        int biometricBits = authenticators & 32767;
        if (biometricBits != 0) goto L15;
        if (isCredentialRequested(authenticators) == false) goto L15;
        return true;
    L15:
        if (biometricBits != 15) goto L18;
        return true;
    L18:
        if (biometricBits != 255) goto L21;
        return true;
    L21:
        if (isMandatoryBiometricsRequested(authenticators) == false) goto L24;
        context.enforceCallingOrSelfPermission("android.permission.SET_BIOMETRIC_DIALOG_ADVANCED", "Must have SET_BIOMETRIC_DIALOG_ADVANCED permission");
        return true;
    L24:
        Slog.e("BiometricService", "Unsupported biometric flags. Authenticators: " + authenticators);
        return false;
    }

    static int biometricConstantsToBiometricManager(int biometricConstantsCode) {
        switch(biometricConstantsCode) {
            case 0: goto L12;
            case 1: goto L11;
            case 7: goto L10;
            case 9: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 14: goto L9;
            case 15: goto L7;
            case 18: goto L6;
            case 20: goto L5;
            case 21: goto L4;
            default: goto L3;
        };
    L3:
        Slog.e("BiometricService", "Unhandled result code: " + biometricConstantsCode);
        return 1;
    L4:
        return 21;
    L5:
        return 20;
    L6:
        return 1;
    L7:
        return 15;
    L8:
        return 12;
    L9:
        return 11;
    L10:
        return 7;
    L11:
        return 1;
    L12:
        return 0;
    }

    static int getAuthenticationTypeForResult(int reason) {
        switch(reason) {
            case 1: goto L7;
            case 4: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        return 1;
    L7:
        return 2;
    L4:
        throw new IllegalArgumentException("Unsupported dismissal reason: " + reason);
    }

    static int authenticatorStatusToBiometricConstant(int status) {
        switch(status) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L3;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L3;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L9;
            case 12: goto L7;
            case 13: goto L5;
            default: goto L3;
        };
    L3:
        return 1;
    L5:
        return 20;
    L7:
        return 18;
    L9:
        return 9;
    L11:
        return 7;
    L13:
        return 14;
    L15:
        return 21;
    L17:
        return 11;
    L19:
        return 15;
    L21:
        return 12;
    L23:
        return 0;
    }

    static boolean isConfirmationSupported(int modality) {
        switch(modality) {
            case 4: goto L5;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    static int removeBiometricBits(int authenticators) {
        return authenticators & (-32768);
    }

    public static boolean listContains(int[] haystack, int needle) {
        int i = 0;
    L4:
        if (i >= haystack.length) goto L10;
        if (haystack[i] == needle) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static void checkPermissionOrShell(Context context, String permission) {
        if (Binder.getCallingUid() != 2000) goto L5;
        return;
    L5:
        checkPermission(context, permission);
    }

    public static void checkPermission(Context context, String permission) {
        context.enforceCallingOrSelfPermission(permission, "Must have " + permission + " permission.");
    }

    public static boolean isCurrentUserOrProfile(Context context, int userId) {
        UserManager um = UserManager.get(context);
        if (um != null) goto L6;
        Slog.e(TAG, "Unable to get UserManager");
        return false;
    L6:
        long token = Binder.clearCallingIdentity();
        int[] r4 = um.getEnabledProfileIds(ActivityManager.getCurrentUser());     // Catch: Throwable -> L14
        int r5 = r4.length;     // Catch: Throwable -> L14
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L16;
        int profileId = r4[r6];     // Catch: Throwable -> L14
        if (profileId == userId) goto L11;
        r6 = r6 + 1;
        goto L8
    L11:
        Binder.restoreCallingIdentity(token);
        return true;
    L16:
        Binder.restoreCallingIdentity(token);
        return false;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public static boolean isStrongBiometric(int sensorId) {
        IBiometricService service = IBiometricService.Stub.asInterface(ServiceManager.getService("biometric"));
        return isAtLeastStrength(service.getCurrentStrength(sensorId), 15);
    L5:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
        return false;
    }

    public static int getCurrentStrength(int sensorId) {
        IBiometricService service = IBiometricService.Stub.asInterface(ServiceManager.getService("biometric"));
        return service.getCurrentStrength(sensorId);
    L5:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
        return 0;
    }

    public static boolean isKeyguard(Context context, String clientPackage) {
        boolean hasPermission = hasInternalPermission(context);
        ComponentName keyguardComponent = ComponentName.unflattenFromString(context.getResources().getString(R.string.config_satellite_gateway_service_package));
        if (keyguardComponent == null) goto L5;
        String keyguardPackage = keyguardComponent.getPackageName();
    L6:
        if (hasPermission == false) goto L11;
        if (keyguardPackage == null) goto L11;
        if (keyguardPackage.equals(clientPackage) == false) goto L11;
        return true;
    L11:
        return false;
    L5:
        keyguardPackage = null;
        goto L6
    }

    public static boolean isSystem(Context context, String clientPackage) {
        if (hasInternalPermission(context) == true) goto L5;
    L7:
        return false;
    L5:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(clientPackage) == false) goto L7;
        return true;
    }

    public static boolean isSettings(Context context, String clientPackage) {
        if (hasInternalPermission(context) == true) goto L5;
    L7:
        return false;
    L5:
        if ("com.android.settings".equals(clientPackage) == false) goto L7;
        return true;
    }

    private static boolean hasInternalPermission(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.USE_BIOMETRIC_INTERNAL") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String getClientName(BaseClientMonitor client) {
        if (client != null) goto L6;
        return "null";
    L6:
        return client.getClass().getSimpleName();
    }

    private static boolean containsFlag(int haystack, int needle) {
        if ((haystack & needle) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isUserEncryptedOrLockdown(LockPatternUtils lpu, int user) {
        int strongAuth = lpu.getStrongAuthForUser(user);
        boolean isEncrypted = containsFlag(strongAuth, 1);
        if (containsFlag(strongAuth, 2) == false) goto L5;
    L8:
        boolean isLockDown = true;
    L9:
        Slog.d(TAG, "isEncrypted: " + isEncrypted + " isLockdown: " + isLockDown);
        if (isEncrypted == true) goto L15;
        if (isLockDown == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return true;
    L5:
        if (containsFlag(strongAuth, 32) == true) goto L8;
        isLockDown = false;
        goto L9
    }

    public static boolean isForeground(int callingUid, int callingPid) {
        List<ActivityManager.RunningAppProcessInfo> procs = ActivityManager.getService().getRunningAppProcesses();     // Catch: RemoteException -> L7
        if (procs != null) goto L9;
        Slog.e(TAG, "No running app processes found, defaulting to true");     // Catch: RemoteException -> L7
        return true;
    L9:
        int i = 0;
    L11:
        if (i >= procs.size()) goto L31;
        ActivityManager.RunningAppProcessInfo proc = procs.get(i);     // Catch: RemoteException -> L7
        if (proc.pid != callingPid) goto L20;
        if (proc.uid != callingUid) goto L20;
        if (proc.importance > 125) goto L20;
        return true;
    L20:
        i = i + 1;
        goto L11
    L31:
        return false;
    L22:
        Slog.w(TAG, "am.getRunningAppProcesses() failed");
        return false;
    }

    public static int authenticatorStrengthToPropertyStrength(int strength) {
        switch(strength) {
            case 15: goto L9;
            case 255: goto L7;
            case 4095: goto L5;
            default: goto L4;
        };
    L5:
        return 0;
    L7:
        return 1;
    L9:
        return 2;
    L4:
        throw new IllegalArgumentException("Unknown strength: " + strength);
    }

    public static int propertyStrengthToAuthenticatorStrength(int strength) {
        switch(strength) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return 15;
    L7:
        return 255;
    L9:
        return UnixStat.PERM_MASK;
    L4:
        throw new IllegalArgumentException("Unknown strength: " + strength);
    }

    public static boolean isBackground(String clientPackage) {
        Slog.v(TAG, "Checking if the authenticating is in background, clientPackage:" + clientPackage);
        List<ActivityManager.RunningTaskInfo> tasks = ActivityTaskManager.getInstance().getTasks(Integer.MAX_VALUE);
        if (tasks != null) goto L5;
    L21:
        Slog.d(TAG, "No running tasks reported");
        return true;
    L5:
        if (tasks.isEmpty() == true) goto L21;
        Iterator<ActivityManager.RunningTaskInfo> r3 = tasks.iterator();
    L9:
        if (r3.hasNext() == false) goto L20;
        ActivityManager.RunningTaskInfo taskInfo = r3.next();
        ComponentName topActivity = taskInfo.topActivity;
        if (topActivity == null) goto L9;
        String topPackage = topActivity.getPackageName();
        if (topPackage.contentEquals(clientPackage) == true) goto L15;
    L18:
        Slog.i(TAG, "Running task, top: " + topPackage + ", isVisible: " + taskInfo.isVisible());
        goto L9
    L15:
        if (taskInfo.isVisible() == false) goto L18;
        return false;
    L20:
        return true;
    }
}
