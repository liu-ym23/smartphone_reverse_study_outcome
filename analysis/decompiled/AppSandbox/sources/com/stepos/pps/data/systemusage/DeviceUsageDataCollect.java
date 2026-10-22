package com.stepos.pps.data.systemusage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.PowerManager;
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
import org.json.JSONException;

/* loaded from: classes.dex */
class DeviceUsageDataCollect {
    private static final String EVENT_NAME = "8010003002";
    static final long FIVE_MIN_MS = 300000;
    private static final String K_ACC_DATE = "acc_date";
    private static final String K_ACC_MS = "acc_ms";
    private static final String K_LAST_REPORT_DATE = "last_report_date";
    private static final String K_SESSION_HEARTBEAT = "session_heartbeat";
    private static final String K_SESSION_HEARTBEAT_ELAPSED_RT = "session_heartbeat_elapsed_rt";
    private static final String K_SESSION_START = "session_start";
    private static final String K_SESSION_START_ELAPSED_RT = "session_start_elapsed_rt";
    private static final long MAX_SESSION_MS = 86400000;
    private static final long ONE_DAY_MS = 86400000;
    private static final long ONE_HOUR_MS = 3600000;
    private static final String SP_NAME = "device_usage_collect";
    private static final String TAG = "DeviceUsageDataCollect";
    private final Context mContext;
    private final Handler mHandler;
    private final SharedPreferences mPrefs;
    private final Runnable mFlushRunnable = new Runnable() { // from class: com.stepos.pps.data.systemusage.DeviceUsageDataCollect$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.flushAfterScreenOff();
        }
    };
    private final Runnable mHeartbeatRunnable = new Runnable() { // from class: com.stepos.pps.data.systemusage.DeviceUsageDataCollect.1
        @Override // java.lang.Runnable
        public void run() {
            DeviceUsageDataCollect.this.heartbeat();
            DeviceUsageDataCollect.this.mHandler.postDelayed(this, 300000L);
        }
    };

    private static long clamp(long j) {
        if (j < 0) {
            return 0L;
        }
        return j > Constants.CLEAN_CHECK_INTERVAL ? Constants.CLEAN_CHECK_INTERVAL : j;
    }

    DeviceUsageDataCollect(Context context, Handler handler) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPrefs = applicationContext.getSharedPreferences(SP_NAME, 0);
        this.mHandler = handler;
    }

    void recover() throws JSONException {
        long j;
        long j2;
        long j3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String date = formatDate(jCurrentTimeMillis);
        String string = this.mPrefs.getString(K_ACC_DATE, "");
        long jClamp = this.mPrefs.getLong(K_ACC_MS, 0L);
        long j4 = this.mPrefs.getLong(K_SESSION_START, -1L);
        long j5 = this.mPrefs.getLong(K_SESSION_START_ELAPSED_RT, -1L);
        long j6 = this.mPrefs.getLong(K_SESSION_HEARTBEAT, -1L);
        long j7 = this.mPrefs.getLong(K_SESSION_HEARTBEAT_ELAPSED_RT, -1L);
        boolean z = false;
        if (j6 > 0 && j7 >= 0 && j7 <= jElapsedRealtime && jCurrentTimeMillis - (j6 + (jElapsedRealtime - j7)) > ONE_HOUR_MS) {
            z = true;
        }
        if (j4 > 0) {
            if (j5 >= 0 && j7 >= j5) {
                j3 = j7 - j5;
            } else if (j6 >= j4) {
                j3 = j6 - j4;
            } else {
                j = jElapsedRealtime;
                j2 = 0;
                if (j2 > 0 && j2 <= Constants.CLEAN_CHECK_INTERVAL) {
                    jClamp = clamp(jClamp + j2);
                    Log.w(TAG, "Recovered abnormal session +" + j2 + "ms");
                }
            }
            j = jElapsedRealtime;
            j2 = j3;
            if (j2 > 0) {
                jClamp = clamp(jClamp + j2);
                Log.w(TAG, "Recovered abnormal session +" + j2 + "ms");
            }
        } else {
            j = jElapsedRealtime;
        }
        if (TextUtils.isEmpty(string) || date.equals(string)) {
            if (!TextUtils.isEmpty(string)) {
                date = string;
            }
        } else if (z) {
            Log.w(TAG, "Wall-clock forward jump detected; transferring " + jClamp + "ms from phantom accDate=" + string + " to corrected today=" + date);
        } else {
            tryReport(string, jClamp);
            jClamp = 0;
        }
        boolean zIsScreenOn = isScreenOn();
        long j8 = zIsScreenOn ? jCurrentTimeMillis : -1L;
        this.mPrefs.edit().putString(K_ACC_DATE, date).putLong(K_ACC_MS, jClamp).putLong(K_SESSION_START, j8).putLong(K_SESSION_START_ELAPSED_RT, zIsScreenOn ? j : -1L).putLong(K_SESSION_HEARTBEAT, zIsScreenOn ? jCurrentTimeMillis : -1L).putLong(K_SESSION_HEARTBEAT_ELAPSED_RT, zIsScreenOn ? j : -1L).commit();
        if (zIsScreenOn) {
            startHeartbeat();
        } else {
            stopHeartbeat();
        }
        Log.i(TAG, "Recover: accDate=" + date + " accMs=" + jClamp + " screenOn=" + zIsScreenOn);
    }

    void onScreenOn(long j) throws JSONException {
        String date = formatDate(j);
        String string = this.mPrefs.getString(K_ACC_DATE, date);
        long j2 = 0;
        long j3 = this.mPrefs.getLong(K_ACC_MS, 0L);
        if (date.equals(string)) {
            date = string;
            j2 = j3;
        } else {
            tryReport(string, j3);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mPrefs.edit().putString(K_ACC_DATE, date).putLong(K_ACC_MS, j2).putLong(K_SESSION_START, j).putLong(K_SESSION_START_ELAPSED_RT, jElapsedRealtime).putLong(K_SESSION_HEARTBEAT, j).putLong(K_SESSION_HEARTBEAT_ELAPSED_RT, jElapsedRealtime).commit();
        this.mHandler.removeCallbacks(this.mFlushRunnable);
        startHeartbeat();
        Log.d(TAG, "onScreenOn @" + j);
    }

    void onScreenOff(long j) {
        long j2 = this.mPrefs.getLong(K_SESSION_START, -1L);
        long j3 = this.mPrefs.getLong(K_SESSION_START_ELAPSED_RT, -1L);
        long jClamp = this.mPrefs.getLong(K_ACC_MS, 0L);
        if (j2 > 0) {
            long jElapsedRealtime = j3 >= 0 ? SystemClock.elapsedRealtime() - j3 : j - j2;
            if (jElapsedRealtime > 0 && jElapsedRealtime <= Constants.CLEAN_CHECK_INTERVAL) {
                jClamp = clamp(jClamp + jElapsedRealtime);
            }
        }
        this.mPrefs.edit().putLong(K_ACC_MS, jClamp).putLong(K_SESSION_START, -1L).putLong(K_SESSION_START_ELAPSED_RT, -1L).putLong(K_SESSION_HEARTBEAT, -1L).putLong(K_SESSION_HEARTBEAT_ELAPSED_RT, -1L).commit();
        stopHeartbeat();
        this.mHandler.removeCallbacks(this.mFlushRunnable);
        this.mHandler.postDelayed(this.mFlushRunnable, 300000L);
        Log.d(TAG, "onScreenOff: accMs=" + jClamp);
    }

    void onShutdown() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.mPrefs.getLong(K_SESSION_START, -1L);
        long j2 = this.mPrefs.getLong(K_SESSION_START_ELAPSED_RT, -1L);
        long jClamp = this.mPrefs.getLong(K_ACC_MS, 0L);
        if (j > 0) {
            long jElapsedRealtime = j2 >= 0 ? SystemClock.elapsedRealtime() - j2 : jCurrentTimeMillis - j;
            if (jElapsedRealtime > 0 && jElapsedRealtime <= Constants.CLEAN_CHECK_INTERVAL) {
                jClamp = clamp(jClamp + jElapsedRealtime);
            }
        }
        long j3 = jClamp;
        this.mPrefs.edit().putLong(K_ACC_MS, j3).putLong(K_SESSION_START, -1L).putLong(K_SESSION_START_ELAPSED_RT, -1L).putLong(K_SESSION_HEARTBEAT, -1L).putLong(K_SESSION_HEARTBEAT_ELAPSED_RT, -1L).commit();
        this.mHandler.removeCallbacks(this.mFlushRunnable);
        stopHeartbeat();
        Log.i(TAG, "onShutdown: accMs=" + j3);
    }

    void onDateChanged() throws JSONException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jStartOfDay = startOfDay(jCurrentTimeMillis);
        String date = formatDate(jCurrentTimeMillis);
        String string = this.mPrefs.getString(K_ACC_DATE, formatDate(jStartOfDay - 1));
        long j = this.mPrefs.getLong(K_SESSION_START, -1L);
        long jClamp = this.mPrefs.getLong(K_ACC_MS, 0L);
        if (j > 0 && j < jStartOfDay) {
            long j2 = jStartOfDay - j;
            if (j2 > 0 && j2 <= Constants.CLEAN_CHECK_INTERVAL) {
                jClamp = clamp(jClamp + j2);
            }
        }
        long j3 = jClamp;
        tryReport(string, j3);
        long jMax = Math.max(0L, jElapsedRealtime - (jCurrentTimeMillis - jStartOfDay));
        if (j <= 0) {
            jStartOfDay = -1;
        }
        if (j <= 0) {
            jMax = -1;
        }
        this.mPrefs.edit().putString(K_ACC_DATE, date).putLong(K_ACC_MS, 0L).putLong(K_SESSION_START, jStartOfDay).putLong(K_SESSION_START_ELAPSED_RT, jMax).putLong(K_SESSION_HEARTBEAT, j > 0 ? jCurrentTimeMillis : -1L).putLong(K_SESSION_HEARTBEAT_ELAPSED_RT, j > 0 ? jElapsedRealtime : -1L).commit();
        Log.i(TAG, "onDateChanged: reported " + string + "=" + j3 + "ms");
    }

    void reportYesterday() throws JSONException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String date = formatDate(startOfDay(jCurrentTimeMillis - Constants.CLEAN_CHECK_INTERVAL));
        String string = this.mPrefs.getString(K_ACC_DATE, date);
        long j = this.mPrefs.getLong(K_ACC_MS, 0L);
        if (date.equals(string)) {
            tryReport(string, j);
            this.mPrefs.edit().putString(K_ACC_DATE, formatDate(jCurrentTimeMillis)).putLong(K_ACC_MS, 0L).commit();
        } else {
            Log.d(TAG, "reportYesterday: already handled, accDate=" + string);
        }
    }

    void heartbeat() {
        if (this.mPrefs.getLong(K_SESSION_START, -1L) <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mPrefs.getLong(K_SESSION_HEARTBEAT_ELAPSED_RT, -1L);
        if (j >= 0 && jElapsedRealtime < j) {
            Log.w(TAG, "heartbeat elapsedRT backward, skip");
        } else {
            this.mPrefs.edit().putLong(K_SESSION_HEARTBEAT, jCurrentTimeMillis).putLong(K_SESSION_HEARTBEAT_ELAPSED_RT, jElapsedRealtime).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushAfterScreenOff() {
        this.mPrefs.edit().commit();
        Log.d(TAG, "flushAfterScreenOff committed");
    }

    private void startHeartbeat() {
        this.mHandler.removeCallbacks(this.mHeartbeatRunnable);
        this.mHandler.postDelayed(this.mHeartbeatRunnable, 300000L);
    }

    private void stopHeartbeat() {
        this.mHandler.removeCallbacks(this.mHeartbeatRunnable);
    }

    private void tryReport(String str, long j) throws JSONException {
        if (TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        if (str.equals(this.mPrefs.getString(K_LAST_REPORT_DATE, ""))) {
            Log.d(TAG, "Duplicate device report for " + str + " ignored");
            return;
        }
        HashMap map = new HashMap();
        map.put("daily_date", str);
        map.put("screenon_duration", String.valueOf(j));
        map.put("deviceOAID", safeGetOaid());
        map.put("trigger_time", UsageReport.currentTriggerTime());
        this.mPrefs.edit().putString(K_LAST_REPORT_DATE, str).commit();
        UsageReport.ReportDailyUsage(EVENT_NAME, map);
    }

    private boolean isScreenOn() {
        try {
            PowerManager powerManager = (PowerManager) this.mContext.getSystemService("power");
            if (powerManager == null) {
                return false;
            }
            return powerManager.isInteractive();
        } catch (Throwable unused) {
            return false;
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

    private static String safeGetOaid() {
        try {
            return DeviceUtils.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public void dump(PrintWriter printWriter) {
        long j;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = this.mPrefs.getString(K_ACC_DATE, "");
        long j2 = this.mPrefs.getLong(K_ACC_MS, 0L);
        long j3 = this.mPrefs.getLong(K_SESSION_START, -1L);
        long j4 = this.mPrefs.getLong(K_SESSION_HEARTBEAT, -1L);
        printWriter.println("DeviceUsageDataCollect State:");
        printWriter.println("  Account Date: " + string);
        printWriter.println("  Accumulated (Fixed): " + j2 + " ms (" + (j2 / 1000) + " s)");
        if (j3 > 0) {
            j = jCurrentTimeMillis - j3;
            printWriter.println("  Current Session: Active since " + formatDate(j3));
            printWriter.println("  Current Session Duration: " + j + " ms");
        } else {
            printWriter.println("  Current Session: Inactive");
            j = 0;
        }
        if (j <= 0) {
            j = 0;
        }
        long j5 = j2 + j;
        printWriter.println(String.format("  Total Active Today: %d ms (%.2f min)", Long.valueOf(j5), Double.valueOf(j5 / 60000.0d)));
        StringBuilder sb = new StringBuilder("  Last Heartbeat: ");
        sb.append(j4 > 0 ? formatDate(j4) : "N/A");
        printWriter.println(sb.toString());
    }
}
