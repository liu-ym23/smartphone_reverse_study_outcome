package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.text.TextUtils;
import com.bytedanceos.common.model.AppInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DowngradeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f6736b;

    public static final enum LogType extends Enum<LogType> {
        private static final /* synthetic */ LogType[] $VALUES = null;
        public static final LogType OTHER_LOG_TYPE = null;
        public static final LogType SERVICE_MONITOR = null;
        public final String logType;

        static {
            LogType r10 = new LogType("OTHER_LOG_TYPE", 0, AppInfo.SEARCH_SOURCE_EXTENAL);
            OTHER_LOG_TYPE = r10;
            LogType r11 = new LogType("SERVICE_MONITOR", 1, "service_monitor");
            SERVICE_MONITOR = r11;
            $VALUES = new LogType[]{r10, r11};
        }

        private LogType(String r10, int r11, String r12) {
            super(r10, r11);
            this.logType = r12;
        }

        public static LogType valueOf(String r10) {
            return (LogType) Enum.valueOf(LogType.class, r10);
        }

        public static LogType[] values() {
            return (LogType[]) $VALUES.clone();
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f6738b;

        public a() {
            this.f6738b = new HashMap();
        }

        public static a a(JSONObject r10) {
            a r11 = new a();
            boolean r12 = true;
            if (r10.optInt("default", 1) == 1) goto L6;
            r12 = false;
        L6:
            r11.f6737a = r12;
            Iterator<String> r13 = r10.keys();
        L8:
            if (r13.hasNext() == false) goto L14;
            String r14 = r13.next();
            if (TextUtils.equals(r14, "default") == true) goto L8;
            JSONObject r15 = r10.optJSONObject(r14);
            if (r15 == null) goto L8;
            r11.f6738b.put(r14, r15);
            goto L8
        L14:
            return r11;
        }

        public JSONObject b() {
            JSONObject r10 = new JSONObject();     // Catch: JSONException -> L8
            r10.put("default", this.f6737a ? 1 : 0);     // Catch: JSONException -> L8
            Iterator r11 = this.f6738b.entrySet().iterator();     // Catch: JSONException -> L8
        L4:
            if (r11.hasNext() == false) goto L7;
            Map.Entry r12 = (Map.Entry) r11.next();     // Catch: JSONException -> L8
            r10.put((String) r12.getKey(), (JSONObject) r12.getValue());     // Catch: JSONException -> L8
            goto L4
        L7:
            return r10;
        L8:
            return null;
        }
    }

    public DowngradeInfo() {
        this.f6736b = new HashMap();
    }

    public static DowngradeInfo a(JSONObject r10) {
        if (r3.a.c() == false) goto L5;
        s3.a.d(n2.a.f22354a, "DowngradeRule=" + r10.toString());
    L5:
        DowngradeInfo r11 = new DowngradeInfo();
        long r12 = r10.optLong("duration", 0);
        long r13 = r10.optLong("expire_time", 0);
        if (r13 <= 0) goto L8;
        r11.f6735a = r13;
    L9:
        LogType r14 = LogType.OTHER_LOG_TYPE;
        JSONObject r15 = r10.optJSONObject(r14.logType);
        if (r15 == null) goto L12;
        r11.f6736b.put(r14, a.a(r15));
    L12:
        LogType r16 = LogType.SERVICE_MONITOR;
        JSONObject r17 = r10.optJSONObject(r16.logType);
        if (r17 == null) goto L15;
        r11.f6736b.put(r16, a.a(r17));
    L15:
        return r11;
    L8:
        r11.f6735a = System.currentTimeMillis() + (r12 * 1000);
        goto L9
    }

    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L8
        r10.put("expire_time", this.f6735a);     // Catch: JSONException -> L8
        Iterator r11 = this.f6736b.entrySet().iterator();     // Catch: JSONException -> L8
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: JSONException -> L8
        r10.put(((LogType) r12.getKey()).logType, ((a) r12.getValue()).b());     // Catch: JSONException -> L8
        goto L4
    L7:
        return r10;
    L8:
        return null;
    }
}
