package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.text.TextUtils;
import av3.b;
import com.bytedance.apm.constant.UploadTypeInf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DowngradeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f190726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<LogType, a> f190727b;

    public static final enum LogType extends Enum<LogType> {
        public static final LogType OTHER_LOG_TYPE = null;
        public static final LogType SERVICE_MONITOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogType[] f190728a = null;
        public final String logType;

        static {
            LogType r100 = new LogType("OTHER_LOG_TYPE", 0, "other");
            OTHER_LOG_TYPE = r100;
            LogType r101 = new LogType("SERVICE_MONITOR", 1, UploadTypeInf.SERVICE_MONITOR);
            SERVICE_MONITOR = r101;
            f190728a = new LogType[]{r100, r101};
        }

        public static LogType[] values() {
            return (LogType[]) f190728a.clone();
        }

        public static LogType valueOf(String r100) {
            return (LogType) r27.a.a(LogType.class, r100);
        }

        public LogType(String r100, int r101, String r102) {
            super(r100, r101);
            this.logType = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f190729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, JSONObject> f190730b;

        public final JSONObject b() {
            JSONObject r100 = new JSONObject();     // Catch: JSONException -> L12
            if (this.f190729a == false) goto L5;
            int r101 = 1;
        L6:
            r100.put("default", r101);     // Catch: JSONException -> L12
            Iterator r102 = ((HashMap) this.f190730b).entrySet().iterator();     // Catch: JSONException -> L12
        L8:
            if (r102.hasNext() == false) goto L11;
            Map.Entry r103 = (Map.Entry) r102.next();     // Catch: JSONException -> L12
            r100.put((String) r103.getKey(), (JSONObject) r103.getValue());     // Catch: JSONException -> L12
            goto L8
        L11:
            return r100;
        L5:
            r101 = 0;
        L12:
            return null;
        }

        public a() {
            this.f190730b = new HashMap();
        }

        public static a a(JSONObject r100) {
            a r101 = new a();
            boolean r102 = true;
            if (r100.optInt("default", 1) == 1) goto L6;
            r102 = false;
        L6:
            r101.f190729a = r102;
            Iterator<String> r103 = r100.keys();
        L8:
            if (r103.hasNext() == false) goto L14;
            String r104 = r103.next();
            if (TextUtils.equals(r104, "default") == true) goto L8;
            JSONObject r105 = r100.optJSONObject(r104);
            if (r105 == null) goto L8;
            ((HashMap) r101.f190730b).put(r104, r105);
            goto L8
        L14:
            return r101;
        }
    }

    public DowngradeInfo() {
        this.f190727b = new HashMap();
    }

    public static DowngradeInfo a(JSONObject r100) {
        if (xu3.a.a() == false) goto L5;
        List<String> r101 = mt3.a.f515607a;
        b.d("APM-Slardar", "DowngradeRule=" + r100.toString());
    L5:
        DowngradeInfo r102 = new DowngradeInfo();
        long r103 = r100.optLong("duration", 0);
        long r104 = r100.optLong("expire_time", 0);
        if (r104 <= 0) goto L8;
        r102.f190726a = r104;
    L9:
        LogType r105 = LogType.OTHER_LOG_TYPE;
        JSONObject r106 = r100.optJSONObject(r105.logType);
        if (r106 == null) goto L12;
        ((HashMap) r102.f190727b).put(r105, a.a(r106));
    L12:
        LogType r107 = LogType.SERVICE_MONITOR;
        JSONObject r108 = r100.optJSONObject(r107.logType);
        if (r108 == null) goto L15;
        ((HashMap) r102.f190727b).put(r107, a.a(r108));
    L15:
        return r102;
    L8:
        r102.f190726a = System.currentTimeMillis() + (r103 * 1000);
        goto L9
    }
}
