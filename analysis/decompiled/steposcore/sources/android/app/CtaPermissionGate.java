package android.app;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextExt;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.stepostheme.iconfilter.bean.FilterConfigInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.BuildExt;
import android.os.Bundle;
import android.os.ServiceManager;
import android.os.StepOSCtsUtils;
import android.os.UserHandle;
import android.permission.IStepOSPermissionService;
import android.provider.Settings;
import android.util.Log;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.stepos.settings.config.StepOSSettingsKeys;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CtaPermissionGate {
    private static final String TAG = "StepOSPermissionManager";
    private static final boolean DEBUG = Log.isLoggable("StepOSPermissionManager", 3);
    private static final int[] ASK_OPS = {8, 9, 26, 4, 5, 1, 0, 27, 51, 13, 6, 7, 20, 14};

    private CtaPermissionGate() {
    }

    public static boolean isCanAskOp(int switchCode) {
        for (int op : ASK_OPS) {
            if (op == switchCode) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGranted(int privilege, String hostMsg) {
        if (!StepOSPermissionManager.IS_CTA_TESTER) {
            return true;
        }
        if (StepOSCtsUtils.isCtsRunning()) {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "cts is running allow: privilege=" + privilege + ", hostMsg=" + hostMsg);
            }
            return true;
        }
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        Intent intent = new Intent();
        intent.putExtra(StepOSPermissionManager.INTENT_SHORTCUT, false);
        intent.putExtra(StepOSPermissionManager.INTENT_NETMSG, hostMsg);
        if (CtaOpCodes.matchEmOp(privilege)) {
            if (CtaPackageLists.isSystemAppByUid(uid)) {
                return true;
            }
            return true ^ checkEmptyPermission(privilege, null, uid);
        }
        if (privilege == 56 && CtaPackageLists.isSystemAppByUid(uid)) {
            return true;
        }
        try {
            IStepOSPermissionService service = IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION));
            int ret = service.noteIntentPidOperation(privilege, uid, pid, intent);
            if (ret != 0) {
                Log.d("StepOSPermissionManager", "Privilege Denial: pid=" + pid + ", uid=" + uid);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static boolean isGranted(int privilege, String callingPkg, int uid, int pid) {
        return isGranted(privilege, callingPkg, uid, pid, null);
    }

    public static boolean isGranted(int privilege, int uid, int pid) {
        return isGranted(privilege, uid, pid, (Intent) null);
    }

    public static boolean isGranted(int privilege, int uid, int pid, Intent intent) {
        if (BuildExt.isProductInternational()) {
            return true;
        }
        if (uid == 1000) {
            CtaPermissionTrace.printPermissionTrace(uid, pid, null, privilege);
            return true;
        }
        if (StepOSCtsUtils.isCtsRunning()) {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "cts is running allow: pid=" + pid + ", uid=" + uid + " privilege=" + privilege);
            }
            return true;
        }
        if (CtaOpCodes.matchEmOp(privilege)) {
            if (CtaPackageLists.isSystemAppByUid(uid)) {
                if (privilege == 107 && CtaPackageLists.isExposeSystemAppAppListPermission(getPackageNameFromUid(uid), privilege) && checkEmptyPermission(privilege, null, uid)) {
                    return false;
                }
                CtaPermissionTrace.printPermissionTrace(uid, pid, null, privilege);
                return true;
            }
            if (checkEmptyPermission(privilege, null, uid)) {
                return false;
            }
            CtaPermissionTrace.printPermissionTrace(uid, pid, null, privilege);
            return true;
        }
        try {
            IStepOSPermissionService service = IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION));
            if (intent == null) {
                intent = new Intent();
                intent.putExtra(StepOSPermissionManager.INTENT_SHORTCUT, false);
            } else {
                intent.putExtra(StepOSPermissionManager.INTENT_SHORTCUT, true);
            }
            int ret = service.noteIntentPidOperation(privilege, uid, pid, intent);
            if (ret != 0) {
                if (DEBUG) {
                    Log.d("StepOSPermissionManager", "Privilege Denial: pid=" + pid + ", uid=" + uid);
                }
                if (privilege == 77 || privilege == 68) {
                    CtaPermissionTrace.printPermissionTrace(uid, pid, null, privilege);
                }
                return false;
            }
            CtaPermissionTrace.printPermissionTrace(uid, pid, null, privilege);
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "third app granted!");
            }
            return true;
        } catch (Exception ex) {
            if (DEBUG) {
                Log.w("StepOSPermissionManager", "ipc error: " + ex.getMessage());
            }
            return true;
        }
    }

    public static boolean isGranted(int privilege, String callingPkg, int uid, int pid, Intent intent) {
        if (DEBUG) {
            Log.d("StepOSPermissionManager", "isGrantedl: pid=" + pid + ", uid=" + uid + " callingPkg=" + callingPkg + " privilege=" + privilege);
        }
        if (BuildExt.isProductInternational() || uid == 1000) {
            return true;
        }
        if (StepOSCtsUtils.isCtsRunning()) {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "cts is running allow; isGrantedl: pid=" + pid + ", uid=" + uid + " callingPkg=" + callingPkg + " privilege=" + privilege);
            }
            return true;
        }
        if (!StepOSPermissionManager.ISCHECK) {
            if (DEBUG) {
                Log.d("CTACHECK", "check closed and permission allow");
            }
            return true;
        }
        if (callingPkg == null || "system_server".equals(callingPkg) || "android".equals(callingPkg)) {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "android granted!");
            }
            return true;
        }
        Context context = ActivityThread.currentApplication().getApplicationContext();
        String permissionName = CtaPermissionTexts.getPermissonTypeDetails(context, privilege).title;
        if (CtaOpCodes.matchEmOp(privilege)) {
            return !checkEmptyPermission(privilege, callingPkg, uid);
        }
        if (!CtaPackageLists.isSystemApp(callingPkg)) {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "the third app: " + callingPkg + " use permission: " + permissionName + " privilege: " + privilege);
            }
            try {
                IStepOSPermissionService service = IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION));
                if (intent == null) {
                    intent = new Intent();
                    intent.putExtra(StepOSPermissionManager.INTENT_SHORTCUT, false);
                } else {
                    intent.putExtra(StepOSPermissionManager.INTENT_SHORTCUT, true);
                }
                int ret = service.noteIntentOperation(privilege, uid, callingPkg, intent);
                if (ret != 0) {
                    Log.d("StepOSPermissionManager", "Privilege Denial: pid=" + pid + ", uid=" + uid + ", pkg=" + callingPkg + " privilege=" + privilege);
                    if (privilege == 77 || privilege == 68) {
                        CtaPermissionTrace.printPermissionTrace(uid, pid, callingPkg, privilege);
                    }
                    return false;
                }
                if (DEBUG) {
                    Log.d("StepOSPermissionManager", "third app granted! privilege=" + privilege);
                }
                CtaPermissionTrace.printPermissionTrace(uid, pid, callingPkg, privilege);
                return true;
            } catch (Exception ex) {
                if (DEBUG) {
                    Log.w("StepOSPermissionManager", "ipc error: " + ex.getMessage());
                }
                return true;
            }
        }
        if (DEBUG) {
            Log.d("CTACHECK", "the system app: " + callingPkg + " use permission: " + permissionName + " privilege: " + privilege);
            Log.d("StepOSPermissionManager", "system app allow!");
        }
        CtaPermissionTrace.printPermissionTrace(uid, pid, callingPkg, privilege);
        return true;
    }

    public static boolean isStepOSPermissionGranted(int privilege) {
        return isGranted(privilege, Binder.getCallingUid(), Binder.getCallingPid());
    }

    public static boolean isStepOSPermissionGranted(int privilege, String callingPkg) {
        return isGranted(privilege, callingPkg, Binder.getCallingUid(), Binder.getCallingPid());
    }

    public static boolean isStepOSPermissionGranted(int privilege, int uid, String callingPkg) {
        return isGranted(privilege, callingPkg, uid, Binder.getCallingPid());
    }

    public static boolean isSendBroacastGranted(int privilege, Intent intent) {
        if (intent != null && "com.android.launcher.action.INSTALL_SHORTCUT".equals(intent.getAction())) {
            return isGranted(privilege, Binder.getCallingUid(), Binder.getCallingPid(), intent);
        }
        return true;
    }

    public static boolean checkWriteSms(String callingPkg, Uri uri) {
        CtaPermissionTrace.printPermissionTrace(callingPkg, 15);
        try {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "Privilege Denial: writing uri " + uri + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + ", pkg=" + callingPkg);
            }
            return isStepOSPermissionGranted(15, callingPkg);
        } catch (Exception e) {
            Log.w("StepOSPermissionManager", "checkWriteSms", e);
            return true;
        }
    }

    public static int[] isGrantedForMedia(int privilege, int uid, int pid) {
        int[] defaultResult;
        IStepOSPermissionService service;
        Intent intent;
        int[] defaultResult2 = {0, 0};
        int[] defaultDeny = {1, 1};
        if (BuildExt.isProductInternational()) {
            return defaultResult2;
        }
        if (uid == 1000 || CtaPackageLists.isSystemAppByUid(uid)) {
            int[] defaultResult3 = defaultResult2;
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "isGrantedForMedia systemapp allow: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
            }
            return defaultResult3;
        }
        if (!StepOSCtsUtils.isCtsRunning()) {
            if (privilege != 100) {
                Log.d("StepOSPermissionManager", "isGrantedForMedia OP IS NOT OP_ACCESS_MEDIA_LOCATION: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
                return defaultResult2;
            }
            Context context = ActivityThread.currentApplication().getApplicationContext();
            int locationSwitch = Settings.Secure.getIntForUser(context.getContentResolver(), StepOSSettingsKeys.SECURE_PERM_MEDIA_EXIF_LOCATION_SETTINGS, 1, 0);
            int paramSwitch = Settings.Secure.getIntForUser(context.getContentResolver(), StepOSSettingsKeys.SECURE_PERM_MEDIA_EXIF_PARAMETERS_SETTINGS, 1, 0);
            if (locationSwitch == 0 && paramSwitch == 0) {
                if (DEBUG) {
                    Log.d("StepOSPermissionManager", "isGrantedForMedia both switches closed: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
                }
                return defaultDeny;
            }
            try {
                service = IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION));
                intent = new Intent();
                defaultResult = defaultResult2;
            } catch (Exception e) {
                ex = e;
                defaultResult = defaultResult2;
            }
            try {
                intent.putExtra(StepOSPermissionManager.INTENT_SHORTCUT, false);
                int ret = service.noteIntentPidOperation(privilege, uid, pid, intent);
                if (ret == 0) {
                    defaultResult[0] = locationSwitch == 0 ? 1 : 0;
                    defaultResult[1] = paramSwitch == 0 ? 1 : 0;
                    if (DEBUG) {
                        Log.d("StepOSPermissionManager", "Media privacy allow: pid=" + pid + ", uid=" + uid + " OP=" + privilege + " r[0]=" + defaultResult[0] + " r[1]=" + defaultResult[1]);
                    }
                    return defaultResult;
                }
                Log.d("StepOSPermissionManager", "Media privacy denied: return all deny");
                return defaultDeny;
            } catch (Exception e2) {
                ex = e2;
                if (DEBUG) {
                    Log.w("StepOSPermissionManager", "ipc error: " + ex.getMessage());
                }
                return defaultResult;
            }
        }
        if (DEBUG) {
            Log.d("StepOSPermissionManager", "isGrantedForMedia cts is running allow: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
        }
        return defaultResult2;
    }

    public static int checkDirFilePermission(int privilege, int uid, int pid, String topName, String path, Intent intent) {
        return isGrantedForTopDir(privilege, uid, pid, topName, path, intent);
    }

    public static int isGrantedForTopDir(int privilege, int uid, int pid, String topName, String path, Intent intent) {
        IStepOSPermissionService service;
        Intent intent2 = intent;
        if (DEBUG) {
            Log.d("StepOSPermissionManager", "isGrantedForRootDir start: pid=" + pid + ", uid=" + uid + " OP=" + privilege + " topName=" + topName + " path=" + path);
        }
        if (uid == 1000 || CtaPackageLists.isSystemAppByUid(uid)) {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "isGrantedForRootDir systemapp allow: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
                return 0;
            }
            return 0;
        }
        if (StepOSCtsUtils.isCtsRunning()) {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "isGrantedForTopDir cts is running allow: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
            }
            return 0;
        }
        if (!CtaOpCodes.isDirOp(privilege)) {
            if (DEBUG) {
                Log.d("StepOSPermissionManager", "isGrantedForRootDir allow (not dirOp): pid=" + pid + ", uid=" + uid + " OP=" + privilege);
            }
            return 0;
        }
        String pkg = getPackageNameFromUid(uid);
        Context context = ActivityThread.currentApplication().getApplicationContext();
        if (privilege != 204) {
            Slog.w("StepOSPermissionManager", "Unknown privilege " + privilege);
            return 0;
        }
        boolean needSend = true;
        try {
            ArrayList<ContentValues> cvList = intent2.getParcelableArrayListExtra("query_list");
            if (cvList == null) {
                needSend = false;
                if (DEBUG) {
                    Log.d("StepOSPermissionManager", "ContentValues cvList is null");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            needSend = false;
        }
        boolean galleryFirst = Settings.Secure.getIntForUser(context.getContentResolver(), new StringBuilder().append(pkg).append("_op_").append(204).toString(), -1, 0) == -1;
        String opName = pkg + "_op_201";
        boolean needSend2 = needSend;
        int gallery = Settings.Secure.getIntForUser(context.getContentResolver(), opName, -1, 0);
        Slog.d("StepOSPermissionManager", "isGrantedForRootDir pid=" + pid + ", uid=" + uid + " OP=" + privilege + " opName=" + opName + " gallery=" + gallery + " galleryFirst=" + galleryFirst);
        if (gallery == 0 || gallery == -1) {
            Slog.d("StepOSPermissionManager", "isGrantedForRootDir return MODE_ALLOWED: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
            return 0;
        }
        if (gallery == 1 && !galleryFirst) {
            if (needSend2) {
                sendGalleryToast(pkg, privilege, false, intent2, uid);
            }
            Slog.d("StepOSPermissionManager", "isGrantedForRootDir return MODE_DIR_PART_ALLOWED: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
            return 10;
        }
        if (gallery == 2) {
            int deniedCount = Settings.Secure.getIntForUser(context.getContentResolver(), pkg + "_op_201_op_count", -1, 0);
            if (needSend2 && deniedCount == -1) {
                sendGalleryToast(pkg, privilege, true, intent2, uid);
            }
            Slog.d("StepOSPermissionManager", "isGrantedForRootDir return MODE_IGNORED: pid=" + pid + ", uid=" + uid + " OP=" + privilege);
            return 1;
        }
        try {
            service = IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION));
            if (intent2 == null) {
                intent2 = new Intent();
            }
        } catch (Exception e2) {
            ex = e2;
        }
        try {
            intent2.putExtra(StepOSPermissionManager.INTENT_SHORTCUT, false);
            intent2.putExtra("topName", topName);
            intent2.putExtra("path", path);
            intent2.putExtra("pid", pid);
            int ret = service.noteIntentPidOperation(privilege, uid, pid, intent2);
            if (privilege == 204) {
                if (ret == 1) {
                    ret = 10;
                } else if (ret == 0) {
                    ret = 0;
                } else {
                    ret = 1;
                }
            }
            Slog.d("StepOSPermissionManager", "noteIntentPidOperation ret: " + ret);
            return ret;
        } catch (Exception e3) {
            ex = e3;
            Slog.w("StepOSPermissionManager", "noteIntentPidOperation error", ex);
            Slog.d("StepOSPermissionManager", "isGrantedForRootDir MODE_ALLOWED (fallback)");
            return 0;
        }
    }

    static boolean checkEmptyPermission(int op, String callingPkg, int uid) {
        Context context = ActivityThread.currentApplication().getApplicationContext();
        if (callingPkg == null) {
            PackageManager pm = context.getPackageManager();
            String[] pkgs = pm.getPackagesForUid(uid);
            if (pkgs == null || pkgs.length == 0) {
                return false;
            }
            callingPkg = pkgs[0];
        }
        String opName = callingPkg + "_op_" + op;
        int res = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).getAppCategory(opName);
        if (DEBUG) {
            Log.i("StepOSPermissionManager", "matchEmOp op: " + opName + " res: " + res, new Exception());
        }
        return res == 0;
    }

    private static String getPackageNameFromUid(int uid) {
        Context context = ActivityThread.currentApplication().getApplicationContext();
        PackageManager pm = context.getPackageManager();
        String[] pkgs = pm.getPackagesForUid(uid);
        return (pkgs == null || pkgs.length == 0) ? "" : pkgs[0];
    }

    static boolean isAppForeground(Context context, int uid) {
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        return am == null || am.getUidImportance(uid) <= 200;
    }

    static boolean isRunningForeground(Context context, String pkgName) {
        String curIMEId;
        boolean value = true;
        try {
            ActivityManager am = (ActivityManager) context.getSystemService("activity");
            value = am.getRunningTasks(1).get(0).topActivity.getPackageName().equals(pkgName);
            if (!value && (curIMEId = Settings.Secure.getString(context.getContentResolver(), "default_input_method")) != null) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService("input_method");
                for (InputMethodInfo info : imm.getEnabledInputMethodList()) {
                    if (curIMEId.equals(info.getId())) {
                        boolean value2 = info.getPackageName().equals(pkgName);
                        return value2;
                    }
                }
                return value;
            }
            return value;
        } catch (Exception ex) {
            Log.w("StepOSPermissionManager", "isRunningForeground exception", ex);
            return value;
        }
    }

    static void sendGalleryToast(String pkg, int op, boolean limit, Intent oriIntent, int uid) {
        Context context = ActivityThread.currentApplication().getApplicationContext();
        Intent intent = new Intent("com.stepos.safe.action.GALLERY_TOAST");
        intent.setPackage("com.android.permissioncontroller");
        Bundle bundle = new Bundle();
        bundle.putString("pkg", pkg);
        bundle.putInt("uid", uid);
        bundle.putBoolean(FilterConfigInfo.Filter.PARAM_ATTR_VALUE, limit);
        intent.putExtras(bundle);
        context.sendBroadcastAsUser(intent, UserHandle.ALL, "stepos.permission.READ_STORAGE");
    }
}
