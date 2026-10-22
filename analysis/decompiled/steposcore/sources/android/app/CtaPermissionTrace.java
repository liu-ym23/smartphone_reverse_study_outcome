package android.app;

import android.content.ContextExt;
import android.os.Binder;
import android.os.Process;
import android.os.ServiceManager;
import android.permission.IStepOSPermissionService;
import android.permission.PrivPermInfo;
import android.text.TextUtils;
import android.util.Log;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/* loaded from: classes.dex */
public final class CtaPermissionTrace {
    private static final String TAG = "CtaPermissionTrace";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final DateTimeFormatter TIMESTAMP_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    private CtaPermissionTrace() {
    }

    public static void printPermissionTrace(String pkg, int op) {
        printPermissionTrace(Binder.getCallingUid(), Binder.getCallingPid(), pkg, op);
    }

    public static void printPermissionTraceConnect(String msg) {
        if (DEBUG) {
            Log.i("StepOSPermTrace", "connect Internet : " + msg);
        }
        printPermissionTrace(Process.myUid(), Process.myPid(), null, 58);
    }

    public static void printPermissionTrace(int uid, int op, String pkg) {
        printPermissionTrace(uid, Binder.getCallingPid(), pkg, op + 10000);
    }

    public static void printPermissionTraceForCtaTest(String stackTrace, int op, String pkg, int uid, int pid, boolean isOp) {
        Exception e;
        if ((StepOSPermissionManager.IS_CTA_TESTER || StepOSPermissionManager.DEBUG_CTA) && !"android".equals(pkg) && CtaOpCodes.isCtaOps(op)) {
            try {
            } catch (Exception e2) {
                e = e2;
            }
            try {
                IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).printPermissionTraceForCtaTest(stackTrace, uid, pid, pkg, op, isOp);
            } catch (Exception e3) {
                e = e3;
                Log.w(TAG, "printPermissionTraceForCtaTest failed", e);
            }
        }
    }

    public static void printPermissionTrace(int uid, int pid, String pkg, int op) {
        if (StepOSPermissionManager.IS_CTA_TESTER || StepOSPermissionManager.DEBUG_CTA) {
            if ((op >= 10000 && !CtaOpCodes.isCtaOps(op - 10000)) || "android".equals(pkg) || CtaOpCodes.matchEmOp(op) || CtaOpCodes.isNotShowOp(op)) {
                return;
            }
            try {
                IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).printPermissionTrace(uid, pid, pkg, op);
            } catch (Exception e) {
                Log.w(TAG, "printPermissionTrace failed", e);
            }
        }
    }

    public static List<PrivPermInfo> getPrivPermissions() {
        try {
            return IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).getPrivPermissions();
        } catch (Exception e) {
            Log.w(TAG, "getPrivPermissions failed", e);
            return null;
        }
    }

    public static void clearPrivPermissions(int type) {
        try {
            IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).clearPrivPermissions(type);
        } catch (Exception e) {
            Log.w(TAG, "clearPrivPermissions failed", e);
        }
    }

    public static boolean needRecordPermission(String packageName, int op) {
        return CtaPackageLists.hasLaunchSystemApp(packageName) || CtaPackageLists.needShowSensitiveNotice(packageName) || !CtaPackageLists.isSystemApp(packageName);
    }

    public static String getRealTime(long timestampMs) {
        return TIMESTAMP_FMT.format(Instant.ofEpochMilli(timestampMs));
    }

    public static boolean sameAppHistorical(String lastpkg, int lastop, String laststatus, String lastpermuse, long lasttimestap, String nowpkg, int nowop, String nowstatus, String nowpermuse, long nowtimestap) {
        return TextUtils.equals(lastpkg, nowpkg) && (lastop == nowop || isSameLocationAppHistorical(lastop, nowop)) && TextUtils.equals(laststatus, nowstatus) && TextUtils.equals(lastpermuse, nowpermuse) && TextUtils.equals(getRealTime(lasttimestap), getRealTime(nowtimestap));
    }

    private static boolean isSameLocationAppHistorical(int lastop, int nowop) {
        return isSameLocationOp(lastop) && isSameLocationOp(nowop);
    }

    private static boolean isSameLocationOp(int op) {
        return op == 2 || op == 41 || op == 42 || op == 0 || op == 1;
    }

    public static boolean filterUidStateStatus(int uidStateTime) {
        return uidStateTime == 200 || uidStateTime == 300 || uidStateTime == 400 || uidStateTime == 500 || uidStateTime == 100 || uidStateTime == 600;
    }

    public static boolean filterAccessTime(long accessTime, long beforeTime) {
        if (accessTime <= 0) {
            return false;
        }
        return beforeTime == 0 || (System.currentTimeMillis() - accessTime) / 60000 <= beforeTime;
    }

    public static boolean outOfTime(String oldTime, String nowTime) {
        try {
            LocalDateTime oldDt = LocalDateTime.parse(oldTime, TIMESTAMP_FMT);
            LocalDateTime nowDt = LocalDateTime.parse(nowTime, TIMESTAMP_FMT);
            return Duration.between(oldDt, nowDt).toDays() > 6;
        } catch (DateTimeParseException e) {
            Log.w(TAG, "outOfTime parse failed", e);
            return false;
        }
    }
}
