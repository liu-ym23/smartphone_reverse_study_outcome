package com.stepos.pps.data.systemusage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.DeviceUtils;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
class BootDurationDataCollect {
    private static final String EVENT_NAME = "8010003001";
    static final long FIVE_MIN_MS = 300000;
    private static final String K_ACC_DATE = "acc_date";
    private static final String K_ACC_MS = "acc_ms";
    private static final String K_HEARTBEAT = "heartbeat";
    private static final String K_HEARTBEAT_ELAPSED_RT = "heartbeat_elapsed_rt";
    private static final String K_LAST_REPORT_DATE = "last_report_date";
    private static final String K_LAST_REPORT_MS = "last_report_ms";
    private static final String K_SESSION_ELAPSED_RT = "session_elapsed_rt";
    private static final String K_SESSION_START = "session_start";
    private static final long MAX_SESSION_MS = 86400000;
    private static final long ONE_DAY_MS = 86400000;
    private static final long ONE_HOUR_MS = 3600000;
    private static final String SP_NAME = "boot_duration_collect";
    private static final String TAG = "BootDurationCollect";
    private final Context mContext;
    private final Handler mHandler;
    private final Runnable mHeartbeatRunnable = new Runnable() { // from class: com.stepos.pps.data.systemusage.BootDurationDataCollect.1
        @Override // java.lang.Runnable
        public void run() {
            BootDurationDataCollect.this.heartbeat();
            BootDurationDataCollect.this.mHandler.postDelayed(this, 300000L);
        }
    };
    private final SharedPreferences mPrefs;

    private static long clamp(long j) {
        if (j < 0) {
            return 0L;
        }
        return j > Constants.CLEAN_CHECK_INTERVAL ? Constants.CLEAN_CHECK_INTERVAL : j;
    }

    BootDurationDataCollect(Context context, Handler handler) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPrefs = applicationContext.getSharedPreferences(SP_NAME, 0);
        this.mHandler = handler;
    }

    void recover() {
        long jMin;
        long j;
        long j2;
        long jMax;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jStartOfDay = startOfDay(jCurrentTimeMillis);
        String date = formatDate(jCurrentTimeMillis);
        String string = this.mPrefs.getString(K_ACC_DATE, "");
        long jClamp = this.mPrefs.getLong(K_ACC_MS, 0L);
        long j3 = this.mPrefs.getLong(K_SESSION_START, -1L);
        long j4 = this.mPrefs.getLong(K_HEARTBEAT, -1L);
        long j5 = this.mPrefs.getLong(K_SESSION_ELAPSED_RT, -1L);
        long j6 = this.mPrefs.getLong(K_HEARTBEAT_ELAPSED_RT, -1L);
        if (j5 >= 0 && j5 <= jElapsedRealtime) {
            jMin = jElapsedRealtime - j5;
        } else if (j5 <= jElapsedRealtime || j6 < j5) {
            jMin = (j5 >= 0 || j3 <= 0 || j4 < j3) ? 0L : Math.min(j4 - j3, jElapsedRealtime);
        } else {
            jMin = j6 - j5;
        }
        if (jMin <= 0 || jMin > Constants.CLEAN_CHECK_INTERVAL) {
            j = jElapsedRealtime;
        } else {
            jClamp = clamp(jClamp + jMin);
            j = jElapsedRealtime;
            Log.w(TAG, "Salvaged " + jMin + "ms from prev session");
        }
        long j7 = jClamp;
        if (TextUtils.isEmpty(string) || date.equals(string)) {
            if (!TextUtils.isEmpty(string)) {
                date = string;
            }
        } else if (j3 > 0 && j5 >= 0 && j5 <= j && jCurrentTimeMillis - (j3 + (j - j5)) > ONE_HOUR_MS) {
            Log.w(TAG, "Wall-clock forward jump detected; transferring " + j7 + "ms from phantom accDate=" + string + " to corrected today=" + date);
        } else {
            tryReport(string, j7);
            j7 = 0;
        }
        if (j5 >= 0 || j3 >= 0) {
            j2 = jCurrentTimeMillis;
            jMax = j;
        } else {
            long jMax2 = Math.max(jCurrentTimeMillis - j, jStartOfDay);
            jMax = Math.max(0L, j - (jCurrentTimeMillis - jMax2));
            j2 = jMax2;
        }
        long j8 = j;
        this.mPrefs.edit().putString(K_ACC_DATE, date).putLong(K_ACC_MS, j7).putLong(K_SESSION_START, j2).putLong(K_SESSION_ELAPSED_RT, jMax).putLong(K_HEARTBEAT, jCurrentTimeMillis).putLong(K_HEARTBEAT_ELAPSED_RT, j8).commit();
        startHeartbeat();
        Log.i(TAG, "Recover: accDate=" + date + " accMs=" + j7 + " sessionStart=" + j2 + " sessionElapsedRT=" + jMax + " elapsedRT=" + j8);
    }

    void onDateChanged() {
        long j;
        long j2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jStartOfDay = startOfDay(jCurrentTimeMillis);
        String date = formatDate(jCurrentTimeMillis);
        String string = this.mPrefs.getString(K_ACC_DATE, formatDate(jStartOfDay - 1));
        long j3 = this.mPrefs.getLong(K_ACC_MS, 0L);
        long j4 = this.mPrefs.getLong(K_SESSION_START, -1L);
        long j5 = this.mPrefs.getLong(K_SESSION_ELAPSED_RT, -1L);
        long j6 = (j5 < 0 || jElapsedRealtime < j5) ? 0L : jElapsedRealtime - j5;
        if (j4 <= 0 || j4 >= jStartOfDay) {
            j = jElapsedRealtime;
            j2 = 0;
        } else {
            long j7 = jStartOfDay - j4;
            j = jElapsedRealtime;
            j2 = j7;
        }
        long jMin = Math.min(j6, j2);
        long jClamp = (jMin <= 0 || jMin > Constants.CLEAN_CHECK_INTERVAL) ? j3 : clamp(j3 + jMin);
        tryReport(string, jClamp);
        this.mPrefs.edit().putString(K_ACC_DATE, date).putLong(K_ACC_MS, 0L).putLong(K_SESSION_START, jStartOfDay).putLong(K_SESSION_ELAPSED_RT, Math.max(0L, j - (jCurrentTimeMillis - jStartOfDay))).putLong(K_HEARTBEAT, jCurrentTimeMillis).putLong(K_HEARTBEAT_ELAPSED_RT, j).commit();
        Log.i(TAG, "onDateChanged: reported " + string + "=" + jClamp + "ms");
    }

    void onShutdown() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mPrefs.getLong(K_SESSION_ELAPSED_RT, -1L);
        long jClamp = this.mPrefs.getLong(K_ACC_MS, 0L);
        if (j >= 0 && jElapsedRealtime >= j) {
            long j2 = jElapsedRealtime - j;
            if (j2 > 0 && j2 <= Constants.CLEAN_CHECK_INTERVAL) {
                jClamp = clamp(jClamp + j2);
            }
        }
        this.mPrefs.edit().putLong(K_ACC_MS, jClamp).putLong(K_SESSION_START, -1L).putLong(K_SESSION_ELAPSED_RT, -1L).putLong(K_HEARTBEAT, -1L).putLong(K_HEARTBEAT_ELAPSED_RT, -1L).commit();
        stopHeartbeat();
        Log.i(TAG, "onShutdown: accMs=" + jClamp);
    }

    void reportYesterday() {
        String date = formatDate(startOfDay(System.currentTimeMillis() - Constants.CLEAN_CHECK_INTERVAL));
        if (date.equals(this.mPrefs.getString(K_ACC_DATE, date))) {
            onDateChanged();
        } else {
            tryReport(date, this.mPrefs.getLong(K_ACC_MS, 0L));
        }
    }

    void heartbeat() {
        long j = this.mPrefs.getLong(K_SESSION_ELAPSED_RT, -1L);
        if (j < 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime < this.mPrefs.getLong(K_HEARTBEAT_ELAPSED_RT, j)) {
            Log.w(TAG, "heartbeat elapsedRT backward, skip");
        } else {
            this.mPrefs.edit().putLong(K_HEARTBEAT, jCurrentTimeMillis).putLong(K_HEARTBEAT_ELAPSED_RT, jElapsedRealtime).apply();
        }
    }

    private void startHeartbeat() {
        this.mHandler.removeCallbacks(this.mHeartbeatRunnable);
        this.mHandler.postDelayed(this.mHeartbeatRunnable, 300000L);
    }

    private void stopHeartbeat() {
        this.mHandler.removeCallbacks(this.mHeartbeatRunnable);
    }

    private void tryReport(String str, long j) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        if (str.equals(this.mPrefs.getString(K_LAST_REPORT_DATE, ""))) {
            Log.d(TAG, "Duplicate boot duration report for " + str + " ignored");
            return;
        }
        HashMap map = new HashMap();
        map.put("daily_date", str);
        map.put("daily_boot_duration", String.valueOf(j));
        map.put("deviceOAID", safeGetOaid());
        map.put("trigger_time", UsageReport.currentTriggerTime());
        try {
            UsageReport.ReportDailyUsage(EVENT_NAME, map);
            this.mPrefs.edit().putString(K_LAST_REPORT_DATE, str).putLong(K_LAST_REPORT_MS, j).commit();
            Log.i(TAG, "Report boot duration " + str + " dur=" + j + "ms");
        } catch (Throwable th) {
            Log.e(TAG, "report error: " + th.getMessage(), th);
        }
    }

    String getLastReportedDate() {
        return this.mPrefs.getString(K_LAST_REPORT_DATE, "");
    }

    long getLastReportedOnMs() {
        return this.mPrefs.getLong(K_LAST_REPORT_MS, 0L);
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

    private static String safeGetOaid() {
        try {
            return DeviceUtils.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public void dump(PrintWriter printWriter) {
        long j;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String string = this.mPrefs.getString(K_ACC_DATE, "");
        long j2 = this.mPrefs.getLong(K_ACC_MS, 0L);
        long j3 = this.mPrefs.getLong(K_SESSION_START, -1L);
        long j4 = this.mPrefs.getLong(K_SESSION_ELAPSED_RT, -1L);
        printWriter.println("BootDurationDataCollect State:");
        printWriter.println("  Account Date: " + string);
        printWriter.println("  Accumulated (Fixed): " + j2 + " ms (" + (j2 / 1000) + " s)");
        if (j4 >= 0 && jElapsedRealtime >= j4) {
            j = jElapsedRealtime - j4;
            printWriter.println("  Current Session: Active since " + formatDate(j3) + " (real " + (j / 1000) + " s)");
        } else {
            printWriter.println("  Current Session: Inactive");
            j = 0;
        }
        long j5 = j2 + j;
        printWriter.println(String.format(Locale.US, "  Total Boot Today: %d ms (%.2f min)", Long.valueOf(j5), Double.valueOf(j5 / 60000.0d)));
        printWriter.println("  elapsedRealtime: " + jElapsedRealtime + " ms");
    }
}
