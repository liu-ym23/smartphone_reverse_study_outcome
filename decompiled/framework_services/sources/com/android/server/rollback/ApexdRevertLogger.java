package com.android.server.rollback;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.VersionedPackage;
import android.os.SystemProperties;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.crashrecovery.proto.CrashRecoveryStatsLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class ApexdRevertLogger {
    private static final String LOGGING_PARENT_KEY = "android.content.pm.LOGGING_PARENT";
    private static final String TAG = "WatchdogRollbackLogger";

    public ApexdRevertLogger() {
    }

    public static void logApexdRevert(Context context, List<String> failedPackageNames, String failingNativeProcess) {
        Set<VersionedPackage> logPackages = getLogPackages(context, failedPackageNames);
        Iterator<VersionedPackage> r1 = logPackages.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        VersionedPackage logPackage = r1.next();
        logEvent(logPackage, failingNativeProcess);
        goto L4
    }

    private static Set<VersionedPackage> getLogPackages(Context context, List<String> failedPackageNames) {
        Set<VersionedPackage> parentPackages = new ArraySet();
        Iterator<String> r1 = failedPackageNames.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String failedPackageName = r1.next();
        parentPackages.add(getLogPackage(context, new VersionedPackage(failedPackageName, 0)));
        goto L4
    L6:
        return parentPackages;
    }

    private static VersionedPackage getLogPackage(Context context, VersionedPackage failingPackage) {
        String logPackageName = getLoggingParentName(context, failingPackage.getPackageName());
        if (logPackageName != null) goto L9;
        return null;
    L9:
        VersionedPackage loggingParent = new VersionedPackage(logPackageName, context.getPackageManager().getPackageInfo(logPackageName, 0).getLongVersionCode());     // Catch: PackageManager.NameNotFoundException -> L7
        return loggingParent;
    L8:
        return null;
    }

    private static String getLoggingParentName(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo ai = packageManager.getPackageInfo(packageName, 1073741952).applicationInfo;     // Catch: Exception -> L10
        if (ai == null) goto L12;
        if (ai.metaData == null) goto L12;
        return ai.metaData.getString(LOGGING_PARENT_KEY);
    L12:
        return null;
    L10:
        e = move-exception;
        Slog.w(TAG, "Unable to discover logging parent package: " + packageName, e);
        return null;
    }

    private static void logEvent(VersionedPackage logPackage, String failingPackageName) {
        Slog.i(TAG, "Watchdog event occurred with type: ROLLBACK_SUCCESS logPackage: " + logPackage + " rollbackReason: REASON_NATIVE_CRASH_DURING_BOOT failedPackageName: " + failingPackageName);
        if (logPackage == null) goto L6;
        String r0 = logPackage.getPackageName();
    L5:
        String r3 = r0;
        if (logPackage == null) goto L10;
        int r4 = logPackage.getVersionCode();
    L11:
        CrashRecoveryStatsLog.write(147, 2, r3, r4, 5, failingPackageName, new byte[0]);
        logTestProperties(logPackage, failingPackageName);
        return;
    L10:
        r4 = 0;
        goto L11
    L6:
        r0 = "";
        goto L5
    }

    private static void logTestProperties(VersionedPackage logPackage, String failingPackageName) {
        if (SystemProperties.getBoolean("persist.sys.rollbacktest.enabled", false) == true) goto L5;
        return;
    L5:
        SystemProperties.set("persist.sys.rollbacktest.ROLLBACK_SUCCESS", String.valueOf(true));
        String r2 = "persist.sys.rollbacktest.ROLLBACK_SUCCESS.logPackage";
        if (logPackage == null) goto L8;
        String r3 = logPackage.toString();
    L9:
        SystemProperties.set(r2, r3);
        SystemProperties.set("persist.sys.rollbacktest.ROLLBACK_SUCCESS.rollbackReason", "REASON_NATIVE_CRASH_DURING_BOOT");
        SystemProperties.set("persist.sys.rollbacktest.ROLLBACK_SUCCESS.failedPackageName", failingPackageName);
        return;
    L8:
        r3 = "";
        goto L9
    }
}
