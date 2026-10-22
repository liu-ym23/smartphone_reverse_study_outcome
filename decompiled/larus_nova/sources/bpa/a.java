package bpa;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.privacy.azerothprivacy.AzerothPrivacy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: bpa.a$a, reason: collision with other inner class name */
    public static class C0336a implements SDKMonitor.IGetExtendParams {
        public C0336a() {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final String getSessionId() {
            return null;
        }
    }

    public static synchronized void a(Context r100) {
        monitor-enter(a.class);
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L20
        r101.put("device_id", AzerothPrivacy.getAppInfo().f530145d);     // Catch: JSONException -> L17 Throwable -> L20
        r101.put("host_aid", AzerothPrivacy.getAppInfo().f530142a);     // Catch: JSONException -> L17 Throwable -> L20
        r101.put("sdk_version", AzerothPrivacy.getVersion());     // Catch: JSONException -> L17 Throwable -> L20
        r101.put("channel", AzerothPrivacy.getAppInfo().f530147f);     // Catch: JSONException -> L17 Throwable -> L20
        r101.put("app_version", AzerothPrivacy.getAppInfo().f530143b);     // Catch: JSONException -> L17 Throwable -> L20
        r101.put("update_version_code", AzerothPrivacy.getAppInfo().f530144c);     // Catch: JSONException -> L17 Throwable -> L20
        if (TextUtils.isEmpty(AzerothPrivacy.getAppInfo().f530148g) == true) goto L8;
        r101.put("package_name", AzerothPrivacy.getAppInfo().f530148g);     // Catch: JSONException -> L17 Throwable -> L20
    L8:
        AzerothPrivacy.getSdkConfig().f530151a.getClass();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty("https://mon.snssdk.com/monitor/appmonitor/v4/settings") == true) goto L11;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L20
        r102.add("https://mon.snssdk.com/monitor/appmonitor/v4/settings");     // Catch: Throwable -> L20
        SDKMonitorUtils.setConfigUrl("23330", r102);     // Catch: Throwable -> L20
    L11:
        AzerothPrivacy.getSdkConfig().f530151a.getClass();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(ReportConstant.DEFAULT_URL_REPORT) == true) goto L14;
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L20
        r103.add(ReportConstant.DEFAULT_URL_REPORT);     // Catch: Throwable -> L20
        SDKMonitorUtils.setDefaultReportUrl("23330", r103);     // Catch: Throwable -> L20
    L14:
        SDKMonitorUtils.initMonitor(r100.getApplicationContext(), "23330", r101, new C0336a());     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return;
    L17:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static void f(b r100) {
    L27:
        e = move-exception;
        apa.a.c("AzerothMonitor", "reportDebugEvent", e);
        return;
    L3:
        if (TextUtils.isEmpty(r100.f19997a) == true) goto L37;
        String r101 = r100.f19997a + "[" + r100.f19998b + "]";     // Catch: Exception -> L27
        Exception r102 = r100.f19999c;     // Catch: Exception -> L27
        if (apa.a.f15862a == null) goto L10;
        apa.a.f15862a.w(r101, r102);     // Catch: Exception -> L27
    L10:
        if (r100.f20000d != null) goto L12;
        r100.f20000d = new HashMap();     // Catch: Exception -> L27
    L12:
        ((HashMap) r100.f20000d).put("tag", r100.f19997a);     // Catch: Exception -> L27
        if (r100.f20001e != null) goto L15;
        r100.f20001e = new HashMap();     // Catch: Exception -> L27
    L15:
        ((HashMap) r100.f20001e).putAll(fpa.a.a());     // Catch: Exception -> L27
        Exception r103 = r100.f19999c;     // Catch: Exception -> L27
        if (r103 == null) goto L25;
        ((HashMap) r100.f20000d).put("exceptionType", r103.getClass().getName());     // Catch: Exception -> L27
        ((HashMap) r100.f20001e).put("errInfo", r100.f19999c.getMessage());     // Catch: Exception -> L27
        Map<String, String> r104 = fpa.b.a(r100.f19999c);     // Catch: Exception -> L27
        if (r104 == null) goto L25;
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();     // Catch: Exception -> L27
    L21:
        if (r105.hasNext() == false) goto L25;
        Map.Entry<String, String> r106 = r105.next();     // Catch: Exception -> L27
        if (((HashMap) r100.f20001e).get(r106.getKey()) != null) goto L21;
        ((HashMap) r100.f20001e).put(r106.getKey(), r106.getValue());     // Catch: Exception -> L27
    L25:
        c("debug_event", r100.f19998b, new JSONObject(r100.f20000d), null, new JSONObject(r100.f20001e));     // Catch: Exception -> L27
        return;
    }

    public static void g(HashMap r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        r101.put("KexgNetError", "key exchange common http exception");     // Catch: JSONException -> L8
        Iterator r103 = r100.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: JSONException -> L8
        r102.put((String) r104.getKey(), r104.getValue());     // Catch: JSONException -> L8
    L10:
        b("crypto", r101, null, r102);
        return;
    L8:
        e = move-exception;
        xoa.a.a(e, "key exchange network event reporter Json exception", r100);
        goto L10
    }

    public static void d(long r100, int r101, JSONObject r102) {
        long r103 = System.currentTimeMillis() - r100;
        JSONObject r104 = new JSONObject();
        r104.put("duration", r103);     // Catch: JSONException -> L5
    L7:
        c("crypto", r101, r102, r104, null);
        return;
    L5:
        e = move-exception;
        xoa.a.a(e, "json exception", null);
        goto L7
    }

    public static void b(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        SDKMonitorUtils.getInstance("23330").monitorEvent(r100, r101, r102, r103);
    }

    public static void c(String r100, int r101, JSONObject r102, JSONObject r110, JSONObject r111) {
        SDKMonitorUtils.getInstance("23330").monitorStatusAndEvent(r100, r101, r102, r110, r111);
    }

    public static void e(long r100, int r101, long r102, long r103, JSONObject r110) {
        long r104 = System.currentTimeMillis() - r100;
        JSONObject r105 = new JSONObject();
        JSONObject r106 = new JSONObject();
        r105.put("duration", r104);     // Catch: JSONException -> L5
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();     // Catch: JSONException -> L5
        r106.put("shared_preference", epa.a.a().toString());     // Catch: JSONException -> L5
        r106.put("key_version_in_mem", r102);     // Catch: JSONException -> L5
        r106.put("pre_key_version_in_mem", r103);     // Catch: JSONException -> L5
    L7:
        c("crypto", r101, r110, r105, r106);
        return;
    L5:
        e = move-exception;
        xoa.a.a(e, "json exception", null);
        goto L7
    }
}
