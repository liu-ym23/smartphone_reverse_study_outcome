package com.stepos.pps.data.systemusage;

import android.util.Log;
import com.stepos.pps.PPSApplication;
import com.stepos.pps.data.ouc.cloud.CloudUserConfigManager;
import com.stepos.pps.data.stats.helper.exceptioncode.MetricReporter;
import com.stepos.pps.data.util.Utils;
import java.time.LocalDateTime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UsageReport {
    private static final String TAG = "UsageReport";

    public static String currentTriggerTime() {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        return localDateTimeNow == null ? "" : localDateTimeNow.toString();
    }

    public static void ReportDailyUsage(String str, Map<String, String> map) throws JSONException {
        try {
            if (!Utils.checkVersionTypeAvailable()) {
                Log.d(TAG, "skip report: version type not available, " + str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("versionType", CloudUserConfigManager.currentVersionType());
            PPSApplication pPSApplication = PPSApplication.getInstance();
            if (pPSApplication == null) {
                Log.w(TAG, "skip report, application not ready: " + str);
                return;
            }
            MetricReporter.getInstance(pPSApplication).report("zy_" + str, jSONObject);
        } catch (Exception e) {
            Log.e(TAG, "Failed to report daily usage: " + str, e);
        }
    }
}
