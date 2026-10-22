package com.stepos.pps.data.systemusage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.data.util.DeviceUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class UptimeProcessCollector {
    private static final String EVENT_NAME = "8010003003";
    private static final String K_LAST_REPORT_DATE = "last_report_date";
    private static final String SP_NAME = "uptime_process";
    private static final String TAG = "UptimeProcCollect";
    private final Context mContext;
    private final SharedPreferences mPrefs;

    UptimeProcessCollector(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPrefs = applicationContext.getSharedPreferences(SP_NAME, 0);
    }

    void reportFor(String str, long j) {
        String deviceId;
        if (TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        if (str.equals(this.mPrefs.getString(K_LAST_REPORT_DATE, ""))) {
            Log.d(TAG, "already reported persist procs for " + str);
            return;
        }
        List<PkgVer> listEnumeratePersistApps = enumeratePersistApps();
        try {
            deviceId = DeviceUtils.getDeviceId();
        } catch (Throwable unused) {
            deviceId = "";
        }
        String str2 = deviceId != null ? deviceId : "";
        String strCurrentTriggerTime = UsageReport.currentTriggerTime();
        for (PkgVer pkgVer : listEnumeratePersistApps) {
            HashMap map = new HashMap();
            map.put("pkg_name", pkgVer.pkg);
            map.put("daily_date", str);
            map.put("app_active_duration", String.valueOf(j));
            map.put("app_code", String.valueOf(pkgVer.versionCode));
            map.put("deviceOAID", str2);
            map.put("trigger_time", strCurrentTriggerTime);
            try {
                UsageReport.ReportDailyUsage(EVENT_NAME, map);
            } catch (Throwable th) {
                Log.e(TAG, "report persist proc fail " + pkgVer.pkg + ": " + th.getMessage());
            }
        }
        this.mPrefs.edit().putString(K_LAST_REPORT_DATE, str).commit();
        Log.i(TAG, "Reported " + listEnumeratePersistApps.size() + " persist procs for " + str + " onMs=" + j);
    }

    private List<PkgVer> enumeratePersistApps() {
        long longVersionCode;
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
            if (installedApplications != null) {
                for (ApplicationInfo applicationInfo : installedApplications) {
                    if (applicationInfo != null && !TextUtils.isEmpty(applicationInfo.packageName) && (applicationInfo.flags & 8) != 0) {
                        try {
                            longVersionCode = packageManager.getPackageInfo(applicationInfo.packageName, 0).getLongVersionCode();
                        } catch (Throwable unused) {
                            longVersionCode = 0;
                        }
                        arrayList.add(new PkgVer(applicationInfo.packageName, longVersionCode));
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(TAG, "enumeratePersistApps fail: " + th.getMessage());
        }
        return arrayList;
    }

    void dump(PrintWriter printWriter) {
        printWriter.println("UptimeProcessCollector State:");
        printWriter.println("  Last Report Date: " + this.mPrefs.getString(K_LAST_REPORT_DATE, "(none)"));
        List<PkgVer> listEnumeratePersistApps = enumeratePersistApps();
        printWriter.println("  Persist apps (" + listEnumeratePersistApps.size() + "):");
        if (listEnumeratePersistApps.isEmpty()) {
            printWriter.println("    (none)");
            return;
        }
        for (PkgVer pkgVer : listEnumeratePersistApps) {
            printWriter.println("    " + pkgVer.pkg + " (code=" + pkgVer.versionCode + ")");
        }
    }

    private static class PkgVer {
        final String pkg;
        final long versionCode;

        PkgVer(String str, long j) {
            this.pkg = str;
            this.versionCode = j;
        }
    }
}
