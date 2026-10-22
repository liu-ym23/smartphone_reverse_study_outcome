package com.stepos.pps.data.ouc;

import android.content.Context;
import com.stepos.pps.data.ouc.cloud.CloudUserConfigManager;
import com.stepos.pps.data.stats.helper.exceptioncode.MetricReporter;
import com.stepos.pps.data.util.DeviceUtils;
import com.stepos.pps.data.util.LogUtil;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class EmsLogDropReporter {
    public static final String CODE = "8010004000";
    private static final String EVENT_NAME = "zy_8010004000";
    public static final int R_SANDBOX_DB_INSERT_FAIL = 306;
    public static final int R_SANDBOX_DISK_FULL = 302;
    public static final int R_SANDBOX_DUPLICATE = 304;
    public static final int R_SANDBOX_EMPTY_TAG = 303;
    public static final int R_SANDBOX_EVICT_CAPACITY = 307;
    public static final int R_SANDBOX_EVICT_EXPIRED = 308;
    public static final int R_SANDBOX_NO_PARSER = 301;
    public static final int R_UPLOAD_APPLY_EMPTY = 402;
    public static final int R_UPLOAD_APPLY_FAIL = 406;
    public static final int R_UPLOAD_BLOCKED = 404;
    public static final int R_UPLOAD_HTTP_FAIL = 403;
    public static final int R_UPLOAD_PRIVACY_OFF = 401;
    public static final int R_UPLOAD_REJECTED = 405;
    public static final int STAGE_SANDBOX_INGEST = 3;
    public static final int STAGE_UPLOAD = 4;
    private static final String TAG = "EmsLogDrop";

    private EmsLogDropReporter() {
    }

    public static void report(Context context, int i, int i2, ErrorInfo errorInfo, JSONObject jSONObject) {
        if (errorInfo == null) {
            report(context, i, i2, null, null, null, null, jSONObject);
        } else {
            report(context, i, i2, errorInfo.type, errorInfo.packageName, errorInfo.expLogId, errorInfo.uuid, jSONObject);
        }
    }

    public static void report(Context context, int i, int i2, String str, String str2, String str3, String str4, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("drop_stage", i);
            jSONObject2.put("reason_code", i2);
            if (str == null) {
                str = "";
            }
            jSONObject2.put("exc_type", str);
            if (str2 == null) {
                str2 = "";
            }
            jSONObject2.put("package_name", str2);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("exp_log_id", str3);
            if (str4 == null) {
                str4 = "";
            }
            jSONObject2.put("uuid", str4);
            jSONObject2.put("source_module", "appsandbox");
            jSONObject2.put("drop_detail", jSONObject == null ? "{}" : jSONObject.toString());
            jSONObject2.put("trigger_time", String.valueOf(System.currentTimeMillis()));
            String deviceId = DeviceUtils.getDeviceId();
            if (deviceId == null) {
                deviceId = "";
            }
            jSONObject2.put("deviceOAID", deviceId);
            jSONObject2.put("deviceDSID", "");
            try {
                jSONObject2.put("versionType", CloudUserConfigManager.currentVersionType());
            } catch (Throwable unused) {
            }
            MetricReporter.getInstance(context).report(EVENT_NAME, jSONObject2);
        } catch (Throwable th) {
            LogUtil.w(TAG, "report drop failed, stage=" + i + " reason=" + i2 + ", " + th);
        }
    }
}
