package android.app;

import android.content.Context;
import android.content.ContextExt;
import android.os.ServiceManager;
import android.permission.IStepOSPermissionService;
import android.provider.Settings;
import android.util.Log;

/* loaded from: classes.dex */
public final class CtaPermissionNotifier {
    private static final String CTA_REVIEW_STR = "_cta_review";
    private static final boolean DEBUG = Log.isLoggable("StepOSPermissionManager", 3);
    private static final String TAG = "StepOSPermissionManager";

    private CtaPermissionNotifier() {
    }

    public static void showPermissionNotice(int uid, int op, String pkg, boolean isNote) {
        if (CtaOpCodes.filterOp(op)) {
            if (CtaPackageLists.isSystemApp(pkg) && !CtaPackageLists.hasLaunchSystemApp(pkg) && !CtaPackageLists.needShowSensitiveNotice(pkg)) {
                return;
            }
            try {
                if (DEBUG) {
                    Log.d("StepOSPermissionManager", "show pkg: " + pkg + ", op: " + op);
                }
                if (op == 41) {
                    Log.d("StepOSPermissionManager", "show pkg skip");
                    return;
                }
                IStepOSPermissionService service = IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION));
                if (isNote) {
                    service.notePermissionNotice(uid, op, pkg);
                } else {
                    service.showPermissionNotice(uid, op, pkg);
                }
            } catch (Exception e) {
                Log.w("StepOSPermissionManager", "showPermissionNotice failed", e);
            }
        }
    }

    public static void cancelPermissionNotice(int op, String pkg) {
        if (CtaOpCodes.filterOp(op)) {
            if (CtaPackageLists.isSystemApp(pkg) && !CtaPackageLists.hasLaunchSystemApp(pkg) && !CtaPackageLists.needShowSensitiveNotice(pkg)) {
                return;
            }
            try {
                if (DEBUG) {
                    Log.d("StepOSPermissionManager", "finished pkg: " + pkg + ", op: " + op);
                }
                if (op == 41) {
                    Log.d("StepOSPermissionManager", "finished pkg skip");
                } else {
                    IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).cancelPermissionNotice(op, pkg);
                }
            } catch (Exception e) {
                Log.w("StepOSPermissionManager", "cancelPermissionNotice failed", e);
            }
        }
    }

    public static void cancelUninstallPermissionNotice(int op, String pkg) {
        try {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "uninstall finished pkg: " + pkg + ", op: " + op);
            }
            IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).cancelUninstallPermissionNotice(op, pkg);
        } catch (Exception e) {
            Log.w("StepOSPermissionManager", "cancelUninstallPermissionNotice failed", e);
        }
    }

    public static boolean isCtaPermissionsReviewRequired(Context context, String pkg, int userId) {
        return Settings.Secure.getIntForUser(context.getContentResolver(), new StringBuilder().append(pkg).append(CTA_REVIEW_STR).toString(), 0, userId) == 1;
    }

    public static void setCtaPermissionsReviewRequired(Context context, String pkg, int value, int userId) {
        Settings.Secure.putIntForUser(context.getContentResolver(), pkg + CTA_REVIEW_STR, value, userId);
    }

    public static void askOpsOperation(int uid, String packageName, int switchCode) {
        if (CtaPermissionGate.isCanAskOp(switchCode)) {
            try {
                IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).askOpsOperation(switchCode, uid, packageName);
            } catch (Exception e) {
                Log.w("StepOSPermissionManager", "askOpsOperation failed", e);
            }
        }
    }

    public static void clearOpsOperation(int uid) {
        try {
            IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).clearOpsOperation(uid);
        } catch (Exception e) {
            Log.w("StepOSPermissionManager", "clearOpsOperation failed", e);
        }
    }

    public static void writeOpAskState() {
        try {
            IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).writeOpAskState();
        } catch (Exception e) {
            Log.w("StepOSPermissionManager", "writeOpAskState failed", e);
        }
    }

    public static void systemReady() {
        try {
            IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).systemReady();
        } catch (Exception e) {
            Log.w("StepOSPermissionManager", "systemReady failed", e);
        }
        CtaPackageLists.registerLaunchSystemAppCollector();
    }
}
