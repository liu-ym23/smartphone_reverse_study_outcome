package com.alipay.sdk.m.p;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.u.m;
import com.alipay.sdk.m.u.n;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public abstract class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25655c = "msp-gzip";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25656d = "Msp-Param";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25657e = "Operation-Type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25658f = "content-type";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25659g = "Version";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f25660h = "AppId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f25661i = "des-mode";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f25662j = "namespace";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f25663k = "api_name";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f25664l = "api_version";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f25665m = "data";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f25666n = "params";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f25667o = "public_key";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f25668p = "device";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f25669q = "action";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f25670r = "type";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f25671s = "method";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25673b;

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return "4.9.0";
    }

    public abstract boolean c();

    public e() {
        this.f25672a = true;
        this.f25673b = true;
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return false;
    L15:
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r100), "data");     // Catch: JSONException -> L12
        if (r101.has("params") == true) goto L8;
        return false;
    L8:
        String r102 = JSONObjectProtectorUtils.getJSONObject(r101, "params").optString("public_key", null);     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r102) == true) goto L17;
        com.alipay.sdk.m.m.b.a(r102);     // Catch: JSONException -> L12
        return true;
    L17:
        return false;
    L12:
        e = move-exception;
        com.alipay.sdk.m.u.e.a(e);
        return false;
    }

    public String a(com.alipay.sdk.m.s.a r100) throws JSONException {
        HashMap<String, String> r101 = new HashMap();
        r101.put("device", Build.MODEL);
        r101.put("namespace", "com.alipay.mobilecashier");
        r101.put("api_name", "com.alipay.mcpay");
        r101.put("api_version", b());
        return a(r100, r101, new HashMap());
    }

    public static boolean a(com.alipay.sdk.m.o.a.b r100) {
        return Boolean.valueOf(a(r100, f25655c)).booleanValue();
    }

    public Map<String, String> a(boolean r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put(f25655c, String.valueOf(r100));
        r102.put(f25657e, "alipay.msp.cashier.dispatch.bytes");
        r102.put(f25658f, "application/octet-stream");
        r102.put("Version", EventConstant.Value.AUTH_VERSION_2);
        r102.put(f25660h, "TAOBAO");
        r102.put(f25656d, a.a(r101));
        r102.put(f25661i, "CBC");
        return r102;
    }

    public static String a(com.alipay.sdk.m.o.a.b r100, String r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        Map<String, List<String>> r102 = r100.f25642a;
        if (r102 != null) goto L9;
        return null;
    L9:
        List<String> r103 = r102.get(r101);
        if (r103 != null) goto L13;
        return null;
    L13:
        return TextUtils.join(",", r103);
    L14:
        return null;
    }

    public static JSONObject a(String r100, String r101) throws JSONException {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        r103.put("type", r100);
        r103.put(f25671s, r101);
        r102.put("action", r103);
        return r102;
    }

    public b a(com.alipay.sdk.m.s.a r100, Context r101) throws Throwable {
        return a(r100, r101, "");
    }

    public String a(com.alipay.sdk.m.s.a r100, String r101, JSONObject r102) {
        com.alipay.sdk.m.s.b r103 = com.alipay.sdk.m.s.b.d();
        com.alipay.sdk.m.t.a r104 = com.alipay.sdk.m.t.a.a(r103.b());
        JSONObject r105 = com.alipay.sdk.m.u.d.a(new JSONObject(), r102);
        r105.put(com.alipay.sdk.m.l.b.f25482d, r101);     // Catch: Throwable -> L19
        r105.put("tid", r104.d());     // Catch: Throwable -> L19
        r105.put(com.alipay.sdk.m.l.b.f25480b, r103.a().a(r100, r104, c()));     // Catch: Throwable -> L19
        r105.put(com.alipay.sdk.m.l.b.f25483e, n.a(r100, r103.b(), com.alipay.sdk.m.j.a.f25359d, false));     // Catch: Throwable -> L19
        r105.put(com.alipay.sdk.m.l.b.f25484f, n.h(r103.b()));     // Catch: Throwable -> L19
        r105.put("app_key", com.alipay.sdk.m.l.a.f25459g);     // Catch: Throwable -> L19
        r105.put(com.alipay.sdk.m.l.b.f25485g, r103.c());     // Catch: Throwable -> L19
        r105.put(com.alipay.sdk.m.l.b.f25488j, r104.c());     // Catch: Throwable -> L19
        r105.put(com.alipay.sdk.m.l.b.f25489k, com.alipay.sdk.m.m.b.b(r103.b()));     // Catch: Throwable -> L19
    L22:
        return r105.toString();
    L19:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", "BodyErr", th);
        com.alipay.sdk.m.u.e.a(th);
        goto L22
    }

    public String a(com.alipay.sdk.m.s.a r100, HashMap<String, String> r101, HashMap<String, String> r102) throws JSONException {
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        Map.Entry<String, String> r106 = r105.next();
        r104.put(r106.getKey(), r106.getValue());
    L8:
        if (r102 == null) goto L14;
        JSONObject r107 = new JSONObject();
        Iterator<Map.Entry<String, String>> r108 = r102.entrySet().iterator();
    L11:
        if (r108.hasNext() == false) goto L13;
        Map.Entry<String, String> r109 = r108.next();
        r107.put(r109.getKey(), r109.getValue());
        goto L11
    L13:
        r104.put("params", r107);
    L14:
        r103.put("data", r104);
        return r103.toString();
    }

    public b a(com.alipay.sdk.m.s.a r100, Context r101, String r102) throws Throwable {
        return a(r100, r101, r102, m.b(r101));
    }

    public b a(com.alipay.sdk.m.s.a r100, Context r101, String r102, String r110) throws Throwable {
        return a(r100, r101, r102, r110, true);
    }

    public b a(com.alipay.sdk.m.s.a r100, Context r110, String r111, String r112, boolean r113) throws Throwable {
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.A, "Packet: " + r112);
        c r101 = new c(this.f25673b);
        b r102 = new b(a(r100), a(r100, r111, a()));
        Map<String, String> r103 = a(false, r111);
        d r104 = r101.a(r102, this.f25672a, r103.get("iSr"));
        com.alipay.sdk.m.o.a.b r105 = com.alipay.sdk.m.o.a.a(r110, new com.alipay.sdk.m.o.a.C0489a(r112, a(r104.b(), r111), r104.a()));
        if (r105 == null) goto L12;
        b r106 = r101.a(new d(a(r105), r105.f25644c), r103.get("iSr"));
        if (r106 != null) goto L7;
        return r106;
    L7:
        if (a(r106.b()) == false) goto L14;
        if (r113 == true) goto L10;
        return r106;
    L10:
        return a(r100, r110, r111, r112, false);
    L14:
        return r106;
    L12:
        throw new RuntimeException("Response is null.");
    }
}
