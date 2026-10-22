package com.stepos.pps.data.stats.helper.exceptioncode;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.applog.AppLog;
import com.stepos.pps.data.stats.helper.exceptioncode.MetricLogDbHelper;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.Utils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MetricReporter {
    private static final String KEY_DAY = "mobile_day";
    private static final String KEY_DAY_BYTES = "mobile_day_bytes";
    private static final String KEY_LAST_UPLOAD = "last_upload_time";
    private static final String KEY_MONTH = "mobile_month";
    private static final String KEY_MONTH_BYTES = "mobile_month_bytes";
    private static final long MOBILE_FALLBACK_INTERVAL_MS = 172800000;
    private static final long MOBILE_FALLBACK_MAX_BYTES = 3145728;
    private static final long MOBILE_MONTHLY_MAX_BYTES = 20971520;
    private static final String PREFS = "metric_reporter";
    private static final String TAG = "PPS:MetricReporter";
    private static volatile MetricReporter sInstance;
    private final Context mContext;
    private final MetricLogDbHelper mDbHelper;
    private final SharedPreferences mPrefs;

    private MetricReporter(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mDbHelper = MetricLogDbHelper.getInstance(applicationContext);
        this.mPrefs = applicationContext.getSharedPreferences(PREFS, 0);
    }

    public static MetricReporter getInstance(Context context) {
        if (sInstance == null) {
            synchronized (MetricReporter.class) {
                if (sInstance == null) {
                    sInstance = new MetricReporter(context);
                }
            }
        }
        return sInstance;
    }

    public void report(List<MetricEvent> list) {
        if (!Utils.canDataCollect(this.mContext)) {
            Log.w(TAG, "Ignore report for user privacy: data collect not consented");
            return;
        }
        boolean zIsWiFiWorking = Utils.isWiFiWorking(this.mContext);
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (MetricEvent metricEvent : list) {
                if (metricEvent != null && metricEvent.eventName != null && metricEvent.json != null) {
                    if (zIsWiFiWorking) {
                        AppLog.onEventV3(metricEvent.eventName, metricEvent.json);
                        z = true;
                    } else {
                        this.mDbHelper.insert(metricEvent.eventName, metricEvent.json.toString());
                    }
                }
            }
            if (!zIsWiFiWorking) {
                Log.d(TAG, "non-wifi, cache " + list.size() + " metrics to db");
            } else if (z) {
                markUploaded();
            }
        }
        maybeMobileFallback();
    }

    public void report(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new MetricEvent(str, jSONObject));
        report(arrayList);
    }

    public void flushPendingIfWifi() {
        if (!Utils.canDataCollect(this.mContext)) {
            Log.w(TAG, "Ignore flushPending for user privacy: data collect not consented");
            return;
        }
        if (Utils.isWiFiWorking(this.mContext)) {
            List<MetricLogDbHelper.Record> listQueryAll = this.mDbHelper.queryAll();
            if (listQueryAll.isEmpty()) {
                return;
            }
            Log.d(TAG, "flush pending metrics, count=" + listQueryAll.size());
            for (MetricLogDbHelper.Record record : listQueryAll) {
                try {
                    AppLog.onEventV3(record.eventName, new JSONObject(record.eventJson));
                    this.mDbHelper.delete(record.id);
                } catch (JSONException e) {
                    Log.e(TAG, "flush bad json, drop id=" + record.id, e);
                    this.mDbHelper.delete(record.id);
                }
            }
            markUploaded();
        }
    }

    private void maybeMobileFallback() {
        if (Utils.canDataCollect(this.mContext) && !Utils.isWiFiWorking(this.mContext) && isMobileConnected()) {
            if (!isMainlandChina()) {
                Log.d(TAG, "overseas, skip 2MB mobile fallback");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.mPrefs.getLong("last_upload_time", 0L);
            if (j <= 0) {
                markUploaded();
                return;
            }
            if (jCurrentTimeMillis - j <= MOBILE_FALLBACK_INTERVAL_MS) {
                return;
            }
            long monthSentBytes = MOBILE_MONTHLY_MAX_BYTES - getMonthSentBytes();
            if (monthSentBytes <= 0) {
                Log.d(TAG, "monthly mobile quota (20MB) exhausted, skip fallback");
                return;
            }
            List<MetricLogDbHelper.Record> listQueryUpToSize = this.mDbHelper.queryUpToSize(Math.min(MOBILE_FALLBACK_MAX_BYTES, monthSentBytes));
            if (listQueryUpToSize.isEmpty()) {
                return;
            }
            int i = 0;
            long j2 = 0;
            for (MetricLogDbHelper.Record record : listQueryUpToSize) {
                try {
                    AppLog.onEventV3(record.eventName, new JSONObject(record.eventJson));
                    this.mDbHelper.delete(record.id);
                    i++;
                    j2 += record.size;
                } catch (JSONException unused) {
                    this.mDbHelper.delete(record.id);
                }
            }
            if (j2 > 0) {
                addSentBytes(j2);
            }
            if (i > 0) {
                markUploaded();
            }
            Log.d(TAG, "mobile fallback uploaded " + i + " records, " + j2 + " bytes; month used=" + getMonthSentBytes() + "/20971520");
        }
    }

    private long getMonthSentBytes() {
        int iCurrentMonthKey = currentMonthKey();
        if (this.mPrefs.getInt(KEY_MONTH, -1) != iCurrentMonthKey) {
            this.mPrefs.edit().putInt(KEY_MONTH, iCurrentMonthKey).putLong(KEY_MONTH_BYTES, 0L).apply();
            return 0L;
        }
        return this.mPrefs.getLong(KEY_MONTH_BYTES, 0L);
    }

    private long getDaySentBytes() {
        int iCurrentDayKey = currentDayKey();
        if (this.mPrefs.getInt(KEY_DAY, -1) != iCurrentDayKey) {
            this.mPrefs.edit().putInt(KEY_DAY, iCurrentDayKey).putLong(KEY_DAY_BYTES, 0L).apply();
            return 0L;
        }
        return this.mPrefs.getLong(KEY_DAY_BYTES, 0L);
    }

    private void addSentBytes(long j) {
        int iCurrentMonthKey = currentMonthKey();
        long j2 = this.mPrefs.getInt(KEY_MONTH, -1) == iCurrentMonthKey ? this.mPrefs.getLong(KEY_MONTH_BYTES, 0L) : 0L;
        int iCurrentDayKey = currentDayKey();
        this.mPrefs.edit().putInt(KEY_MONTH, iCurrentMonthKey).putLong(KEY_MONTH_BYTES, j2 + j).putInt(KEY_DAY, iCurrentDayKey).putLong(KEY_DAY_BYTES, (this.mPrefs.getInt(KEY_DAY, -1) == iCurrentDayKey ? this.mPrefs.getLong(KEY_DAY_BYTES, 0L) : 0L) + j).apply();
    }

    private static int currentMonthKey() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(1) * 100) + calendar.get(2) + 1;
    }

    private static int currentDayKey() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(1) * Constants.LOGCAT_MAX_LINES) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public void dump(PrintWriter printWriter) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCount = this.mDbHelper.count();
        long j = this.mDbHelper.totalPendingSize() / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        long j2 = this.mPrefs.getLong("last_upload_time", 0L);
        long daySentBytes = getDaySentBytes();
        long monthSentBytes = getMonthSentBytes();
        printWriter.println("MetricReporter status:");
        printWriter.println("  pending records : " + jCount);
        printWriter.println("  pending size    : " + j + " KB");
        if (j2 <= 0) {
            printWriter.println("  last upload     : never");
        } else {
            printWriter.println("  last upload     : " + ((jCurrentTimeMillis - j2) / 3600000) + " hours ago");
        }
        printWriter.println("  today  mobile used : " + daySentBytes + " bytes (" + (daySentBytes / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) + " KB)");
        printWriter.println("  month  mobile used : " + monthSentBytes + " bytes (" + (monthSentBytes / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) + " KB), limit 20480 KB");
    }

    private void markUploaded() {
        this.mPrefs.edit().putLong("last_upload_time", System.currentTimeMillis()).apply();
    }

    private boolean isMobileConnected() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean isMainlandChina() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager == null) {
                return true;
            }
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return "cn".equalsIgnoreCase(networkCountryIso);
            }
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (TextUtils.isEmpty(simCountryIso)) {
                return true;
            }
            return "cn".equalsIgnoreCase(simCountryIso);
        } catch (Throwable th) {
            Log.e(TAG, "isMainlandChina failed: " + th.getMessage());
            return true;
        }
    }

    public static class MetricEvent {
        final String eventName;
        final JSONObject json;

        public MetricEvent(String str, JSONObject jSONObject) {
            this.eventName = str;
            this.json = jSONObject;
        }
    }
}
