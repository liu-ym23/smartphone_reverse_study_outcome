package com.bytedance.apm6.consumer.slardar.d.a;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DowngradeInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<a, b> f5122b;

    /* JADX INFO: compiled from: DowngradeInfo.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5123a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f5124b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f5125d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f5126c;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f5125d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("OTHER_LOG_TYPE", 0, "other");
            f5123a = r0;
            a r1 = new a("SERVICE_MONITOR", 1, "service_monitor");
            f5124b = r1;
            f5125d = new a[]{r0, r1};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.f5126c = r3;
        }
    }

    /* JADX INFO: compiled from: DowngradeInfo.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, JSONObject> f5128b;

        b() {
            this.f5128b = new HashMap();
        }

        public static b a(JSONObject r6) {
            b r0 = new b();
            boolean r2 = true;
            if (r6.optInt(DownloadSettingKeys.BugFix.DEFAULT, 1) == 1) goto L6;
            r2 = false;
        L6:
            r0.f5127a = r2;
            Iterator<String> r3 = r6.keys();
        L8:
            if (r3.hasNext() == false) goto L14;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
            if (TextUtils.equals(r4, DownloadSettingKeys.BugFix.DEFAULT) == true) goto L8;
            JSONObject r5 = r6.optJSONObject(r4);
            if (r5 == null) goto L8;
            r0.f5128b.put(r4, r5);
            goto L8
        L14:
            return r0;
        }

        public JSONObject a() {
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L13
            if (this.f5127a == false) goto L6;
            int r3 = 1;
        L7:
            r1.put(DownloadSettingKeys.BugFix.DEFAULT, r3);     // Catch: JSONException -> L13
            Iterator<Map.Entry<String, JSONObject>> r5 = this.f5128b.entrySet().iterator();     // Catch: JSONException -> L13
        L9:
            if (r5.hasNext() == false) goto L12;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L13
            r1.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r2.getValue(), JSONObject.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L13
            goto L9
        L12:
            return r1;
        L6:
            r3 = 0;
        L13:
            return null;
        }
    }

    public c() {
        this.f5122b = new HashMap();
    }

    public static c a(JSONObject r8) {
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L5;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "DowngradeRule=" + r8.toString());
    L5:
        c r0 = new c();
        long r4 = r8.optLong("duration", 0);
        long r6 = r8.optLong("expire_time", 0);
        if (r6 <= 0) goto L8;
        r0.f5121a = r6;
    L9:
        JSONObject r1 = r8.optJSONObject(a.f5123a.f5126c);
        if (r1 == null) goto L12;
        r0.f5122b.put(a.f5123a, b.a(r1));
    L12:
        JSONObject r9 = r8.optJSONObject(a.f5124b.f5126c);
        if (r9 == null) goto L15;
        r0.f5122b.put(a.f5124b, b.a(r9));
    L15:
        return r0;
    L8:
        r0.f5121a = System.currentTimeMillis() + (r4 * 1000);
        goto L9
    }

    public JSONObject a() {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L9
        r1.put("expire_time", this.f5121a);     // Catch: JSONException -> L9
        Iterator<Map.Entry<a, b>> r5 = this.f5122b.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L9
        r1.put(((a) ZeusTransformUtils.preCheckCast(r2.getKey(), a.class, "com.obric.aiagent.plugin")).f5126c, ((b) ZeusTransformUtils.preCheckCast(r2.getValue(), b.class, "com.obric.aiagent.plugin")).a());     // Catch: JSONException -> L9
        goto L5
    L8:
        return r1;
    L9:
        return null;
    }
}
