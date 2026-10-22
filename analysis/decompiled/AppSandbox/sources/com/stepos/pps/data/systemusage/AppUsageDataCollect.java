package com.stepos.pps.data.systemusage;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.data.util.DeviceUtils;
import com.stepos.pps.logpull.LogPullAuthActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class AppUsageDataCollect {
    private static final String KEY_LAST_REPORT_DATE = "last_report_date";
    private static final long ONE_DAY_MS = 86400000;
    private static final String SP_NAME = "app_usage_collect";
    private static final String TAG = "AppUsageDataCollect";
    private final Context mContext;
    private final SharedPreferences mPrefs;

    AppUsageDataCollect(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPrefs = applicationContext.getSharedPreferences(SP_NAME, 0);
    }

    void checkAndBackfill() throws Throwable {
        long jStartOfDay = startOfDay(System.currentTimeMillis() - 86400000);
        String date = formatDate(jStartOfDay);
        if (date.equals(this.mPrefs.getString(KEY_LAST_REPORT_DATE, ""))) {
            Log.d(TAG, "Backfill skipped, already reported " + date);
        } else {
            Log.i(TAG, "Backfill report for " + date);
            collectAndReport(jStartOfDay);
        }
    }

    void reportYesterday() throws Throwable {
        collectAndReport(startOfDay(System.currentTimeMillis() - 86400000));
    }

    private synchronized void collectAndReport(long j) throws Throwable {
        Throwable th;
        AppUsageDataCollect appUsageDataCollect;
        AppUsageDataCollect appUsageDataCollect2;
        Throwable th2;
        UsageStatsManager usageStatsManager;
        Map<String, AggregateEntry> mapAggregateByEvents;
        try {
            try {
                long jStartOfDay = startOfDay(j);
                long j2 = jStartOfDay + 86400000;
                String date = formatDate(jStartOfDay);
                if (date.equals(this.mPrefs.getString(KEY_LAST_REPORT_DATE, ""))) {
                    try {
                        Log.d(TAG, "Duplicate report for " + date + " ignored");
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        appUsageDataCollect = this;
                        throw th;
                    }
                }
                Log.i(TAG, "Collect & report for " + date);
                try {
                    usageStatsManager = (UsageStatsManager) this.mContext.getSystemService("usagestats");
                } catch (Throwable th4) {
                    th = th4;
                    appUsageDataCollect2 = this;
                }
                if (usageStatsManager == null) {
                    try {
                        Log.w(TAG, "UsageStatsManager unavailable");
                        return;
                    } catch (Throwable th5) {
                        th2 = th5;
                        appUsageDataCollect2 = this;
                        Log.e(TAG, "collectAndReport error: " + th2.getMessage(), th2);
                    }
                }
                appUsageDataCollect2 = this;
                try {
                    mapAggregateByEvents = appUsageDataCollect2.aggregateByEvents(usageStatsManager, jStartOfDay, j2);
                } catch (Throwable th6) {
                    th = th6;
                    th2 = th;
                    Log.e(TAG, "collectAndReport error: " + th2.getMessage(), th2);
                }
                if (mapAggregateByEvents.isEmpty()) {
                    Log.d(TAG, "No usage data for " + date);
                    appUsageDataCollect2.mPrefs.edit().putString(KEY_LAST_REPORT_DATE, date).apply();
                    return;
                }
                safeGetOaid();
                for (AggregateEntry aggregateEntry : mapAggregateByEvents.values()) {
                    Log.d(TAG, "********************");
                    Log.d(TAG, "pkg_name: " + aggregateEntry.pkgName);
                    Log.d(TAG, "cpt_name: " + aggregateEntry.cptName);
                    Log.d(TAG, "duration: " + aggregateEntry.duration);
                }
                appUsageDataCollect2.mPrefs.edit().putString(KEY_LAST_REPORT_DATE, date).apply();
                Log.i(TAG, "Reported " + mapAggregateByEvents.size() + " entries for " + date);
            } catch (Throwable th7) {
                th = th7;
                appUsageDataCollect = this;
                th = th;
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    private Map<String, AggregateEntry> aggregateByEvents(UsageStatsManager usageStatsManager, long j, long j2) {
        String str;
        String strSubstring;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        UsageEvents usageEventsQueryEvents = usageStatsManager.queryEvents(j, j2);
        if (usageEventsQueryEvents != null) {
            UsageEvents.Event event = new UsageEvents.Event();
            while (true) {
                if (!usageEventsQueryEvents.hasNextEvent()) {
                    break;
                }
                usageEventsQueryEvents.getNextEvent(event);
                String packageName = event.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    String className = event.getClassName();
                    StringBuilder sb = new StringBuilder();
                    sb.append(packageName);
                    sb.append("/");
                    sb.append(className != null ? className : "");
                    String string = sb.toString();
                    int eventType = event.getEventType();
                    if (eventType == 1) {
                        map2.put(string, Long.valueOf(event.getTimeStamp()));
                    } else if (eventType == 2 || eventType == 23) {
                        Long l = (Long) map2.remove(string);
                        if (l != null) {
                            long timeStamp = event.getTimeStamp() - l.longValue();
                            if (timeStamp > 0) {
                                accumulate(map, string, packageName, className, timeStamp);
                            }
                        }
                    }
                }
            }
            for (Map.Entry entry : map2.entrySet()) {
                long jLongValue = j2 - ((Long) entry.getValue()).longValue();
                if (jLongValue > 0) {
                    String str2 = (String) entry.getKey();
                    int iIndexOf = str2.indexOf(47);
                    String strSubstring2 = iIndexOf >= 0 ? str2.substring(0, iIndexOf) : str2;
                    if (iIndexOf >= 0) {
                        String str3 = strSubstring2;
                        strSubstring = str2.substring(iIndexOf + 1);
                        str = str3;
                    } else {
                        str = strSubstring2;
                        strSubstring = "";
                    }
                    accumulate(map, str2, str, strSubstring, jLongValue);
                }
            }
        }
        return map;
    }

    private static void accumulate(Map<String, AggregateEntry> map, String str, String str2, String str3, long j) {
        AggregateEntry aggregateEntry = map.get(str);
        if (aggregateEntry == null) {
            aggregateEntry = new AggregateEntry(str2, str3);
            map.put(str, aggregateEntry);
        }
        aggregateEntry.duration += j;
    }

    private void reportOne(String str, AggregateEntry aggregateEntry, String str2) throws PackageManager.NameNotFoundException {
        HashMap map = new HashMap();
        if (str == null) {
            str = "";
        }
        map.put(LogPullAuthActivity.EXTRA_OAID, str);
        map.put("pkg_name", aggregateEntry.pkgName);
        map.put("cpt_name", aggregateEntry.cptName != null ? aggregateEntry.cptName : "");
        map.put("date", str2);
        fillVersion(map, aggregateEntry.pkgName);
        map.put("app_active_dur", String.valueOf(aggregateEntry.duration));
        Log.d(TAG, "report " + aggregateEntry.pkgName + "/" + aggregateEntry.cptName + " dur=" + aggregateEntry.duration);
    }

    private void fillVersion(Map<String, String> map, String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(str, 0);
            map.put("pkg_code", packageInfo.versionName == null ? "" : packageInfo.versionName);
            map.put("app_code", String.valueOf(packageInfo.getLongVersionCode()));
        } catch (PackageManager.NameNotFoundException unused) {
            map.put("pkg_code", "");
            map.put("app_code", "0");
        }
    }

    private static String safeGetOaid() {
        try {
            return DeviceUtils.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static long startOfDay(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static String formatDate(long j) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date(j));
    }

    private static final class AggregateEntry {
        final String cptName;
        long duration;
        final String pkgName;

        AggregateEntry(String str, String str2) {
            this.pkgName = str;
            this.cptName = str2;
        }
    }

    public static void diagnose(Context context) {
        Log.i(TAG, "[DIAG] === diagnose ===");
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
        if (usageStatsManager == null) {
            Log.w(TAG, "[DIAG] usm null");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = 3600000;
        int i = 2;
        long[][] jArr = {new long[]{jCurrentTimeMillis - 3600000, jCurrentTimeMillis}, new long[]{jCurrentTimeMillis - 86400000, jCurrentTimeMillis}};
        int i2 = 0;
        while (i2 < i) {
            long[] jArr2 = jArr[i2];
            long j2 = jArr2[0];
            long j3 = jArr2[1];
            Log.i(TAG, "[DIAG] window=[" + j2 + "," + j3 + ") spanH=" + ((j3 - j2) / j));
            List<UsageStats> listQueryUsageStats = usageStatsManager.queryUsageStats(0, j2, j3);
            StringBuilder sb = new StringBuilder("[DIAG]   queryUsageStats size=");
            sb.append(listQueryUsageStats == null ? -1 : listQueryUsageStats.size());
            Log.i(TAG, sb.toString());
            if (listQueryUsageStats != null) {
                for (UsageStats usageStats : listQueryUsageStats) {
                    if (usageStats.getTotalTimeInForeground() > 0) {
                        Log.i(TAG, "[DIAG]     " + usageStats.getPackageName() + " fg=" + usageStats.getTotalTimeInForeground());
                    }
                }
            }
            UsageEvents usageEventsQueryEvents = usageStatsManager.queryEvents(j2, j3);
            UsageEvents.Event event = new UsageEvents.Event();
            int i3 = 0;
            int i4 = 0;
            while (usageEventsQueryEvents != null && usageEventsQueryEvents.hasNextEvent()) {
                usageEventsQueryEvents.getNextEvent(event);
                i3++;
                int i5 = i4 + 1;
                if (i4 < 5) {
                    Log.i(TAG, "[DIAG]     ev " + event.getPackageName() + "/" + event.getClassName() + " type=" + event.getEventType());
                }
                i4 = i5;
            }
            Log.i(TAG, "[DIAG]   queryEvents count=" + i3);
            i2++;
            i = 2;
            j = 3600000;
        }
        Log.i(TAG, "[DIAG] === end ===");
    }
}
