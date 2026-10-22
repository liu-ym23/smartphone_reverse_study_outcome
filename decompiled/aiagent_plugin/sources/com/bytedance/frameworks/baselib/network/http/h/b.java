package com.bytedance.frameworks.baselib.network.http.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.i.k;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.retrofit2.b.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.ad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: StoreRegionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "StoreRegionManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f8347a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f8348b;
    private static boolean p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8351e;
    private String f;
    private String g;
    private String h;
    private String i;
    private boolean j;
    private List<String> k;
    private List<String> l;
    private Context m;
    private boolean n;
    private com.bytedance.frameworks.baselib.network.http.h.a o;

    /* JADX INFO: compiled from: StoreRegionManager.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f8353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f8354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f8355d;

        a(b r1, String r2, String r3, String r4) {
            this.f8355d = r1;
            this.f8352a = r2;
            this.f8353b = r3;
            this.f8354c = r4;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.h.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StoreRegionManager.java */
    public interface InterfaceC0189b {
        void notifyStoreRegionUpdatedForCronet(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11);
    }

    static {
    }

    public static String g() {
        return "ttnet_store_region";
    }

    public static b a() {
        if (f8348b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8348b != null) goto L9;
        f8348b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f8348b;
    }

    private b() {
        this.f8349c = "";
        this.f8350d = "";
        this.f8351e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.k = new ArrayList();
        this.l = new ArrayList();
    }

    public void b() {
        if (this.j == true) goto L6;
        this.j = true;
        SharedPreferences.Editor r3 = this.m.getSharedPreferences("ttnet_store_region", 0).edit();
        r3.putBoolean("received_region_config", true);
        r3.apply();
        return;
    }

    public boolean c() {
        return this.n;
    }

    public String d() {
        return this.f8349c;
    }

    public void a(String r7, String r8, String r9, Context r10, com.bytedance.frameworks.baselib.network.http.h.a r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.h.a r13 = (com.bytedance.frameworks.baselib.network.http.h.a) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.frameworks.baselib.network.http.h.a.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "rule json: " + r8);
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L44;
        if (r12 == null) goto L45;
        if (r13 == null) goto L48;
        JSONObject r0 = new JSONObject(r8);     // Catch: JSONException -> L33
        JSONArray r14 = r0.optJSONArray("update_store_idc_path_list");     // Catch: JSONException -> L33
        int r2 = 0;
        int r3 = 0;
    L12:
        if (r3 >= r14.length()) goto L17;
        String r4 = r14.getString(r3);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r4) == true) goto L16;
        this.k.add(r4);     // Catch: JSONException -> L33
    L16:
        r3 = r3 + 1;     // Catch: JSONException -> L33
        goto L12
    L17:
        JSONArray r15 = r0.optJSONArray("add_store_idc_host_list");     // Catch: JSONException -> L33
    L19:
        if (r2 >= r15.length()) goto L24;
        String r1 = r15.getString(r2);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r1) == true) goto L23;
        this.l.add(r1);     // Catch: JSONException -> L33
    L23:
        r2 = r2 + 1;     // Catch: JSONException -> L33
        goto L19
    L24:
        this.m = ZeusTransformUtils.wrapperContext(r12, "com.obric.aiagent.plugin");     // Catch: JSONException -> L33
        this.o = r13;     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r7) == true) goto L28;
        this.g = r7.toLowerCase();     // Catch: JSONException -> L33
    L28:
        if (this.l.isEmpty() == false) goto L30;
        return;
    L30:
        if (this.k.isEmpty() == true) goto L47;
        this.n = true;     // Catch: JSONException -> L33
        this.i = r9;     // Catch: JSONException -> L33
        h();     // Catch: JSONException -> L33
        return;
    L47:
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        return;
    L48:
        return;
    L45:
        return;
    }

    private void h() {
        SharedPreferences r0 = this.m.getSharedPreferences("ttnet_store_region", 0);
        this.f8349c = r0.getString("store_region", "");
        this.f8350d = r0.getString("store_region_src", "");
        this.f8351e = r0.getString("region_legacy_user", "");
        this.f = r0.getString("store_sec_uid", "");
        this.h = r0.getString("update_region_info", "");
        this.j = r0.getBoolean("received_region_config", false);
        if (TextUtils.isEmpty(this.f8349c) == true) goto L5;
    L7:
        this.o.a("", this.f8349c, this.f8350d, this.f8351e, this.f, "");
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "Init region:" + this.f8349c + " sec_uid:" + this.f + " source:" + this.f8350d + " local:" + this.g + " init region:" + this.i + " region config:" + this.j);
        return;
    L11:
        return;
    L5:
        if (TextUtils.isEmpty(this.g) == true) goto L7;
        this.f8349c = this.g;
        this.f8350d = "local";
        goto L7
    }

    private boolean a(c r6, c.a r7) {
        if (TextUtils.isEmpty(r6.o()) == false) goto L6;
        return false;
    L6:
        if ("/get_domains/v5/".equals(r6.o()) == false) goto L8;
        return true;
    L8:
        Iterator<String> r5 = this.k.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        if (l.a(r6.o(), (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L10;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L17;
        return false;
    L17:
        k r9 = new k(r6.b());
        r9.a("okhttp_version", "4.2.243.22-doubao");
        r9.a("use_store_region_cookie", "1");
        r7.a(r9.a());
        return true;
    L14:
        r8 = false;
        goto L15
    }

    public c a(c r8) {
        if (this.n == true) goto L5;
    L46:
        return null;
    L5:
        if (TextUtils.isEmpty(r8.n()) == true) goto L46;
        if (r8.t() == false) goto L10;
        return null;
    L10:
        boolean r0 = false;
        Iterator<String> r2 = this.l.iterator();
    L11:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L16;
        if (l.a(r8.n(), (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L11;
        r0 = true;
    L16:
        ArrayList r3 = new ArrayList();
        if (this.j == false) goto L19;
    L21:
        r4 = r0;
    L22:
        if (r4 == true) goto L25;
        return null;
    L25:
        if (r8.c() == null) goto L27;
        r3.addAll(r8.c());
    L27:
        c.a r1 = r8.m();
        if (a(r8, r1) == false) goto L32;
        r1.a(r3);
        return r1.b();
    L32:
        if (this.f8349c.isEmpty() == true) goto L35;
        String r9 = this.f8349c;
    L39:
        if (TextUtils.isEmpty(r9) == true) goto L42;
        r3.add(new com.bytedance.retrofit2.b.b("x-tt-store-region", r9));
    L42:
        if (TextUtils.isEmpty(this.f8350d) == true) goto L44;
        r3.add(new com.bytedance.retrofit2.b.b("x-tt-store-region-src", this.f8350d));
    L44:
        r1.a(r3);
        return r1.b();
    L35:
        if (this.g.isEmpty() == true) goto L37;
        r9 = this.g;
        goto L39
    L37:
        r9 = "";
        goto L39
    L19:
        if (TextUtils.isEmpty(this.i) == true) goto L21;
        r3.add(new com.bytedance.retrofit2.b.b("x-tt-app-init-region", this.i));
        goto L22
    }

    public void a(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (this.n == false) goto L12;
        if (r4 != null) goto L7;
        return;
    L7:
        if (this.j == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.i) == true) goto L14;
        r4.put("x-tt-app-init-region", this.i);
        return;
    L14:
        return;
    }

    public void a(ad r22, String r23, byte[] r24) {
        if (this.n == true) goto L54;
        return;
    L54:
        URI r3 = l.a(r23);     // Catch: Exception -> L53
        String r4 = r3.getHost() + r3.getPath();     // Catch: Exception -> L53
        if (r3 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3.getPath()) == false) goto L11;
        return;
    L11:
        if (a(r3.getPath()) == true) goto L13;
        return;
    L13:
        a r5 = a(r22.a("Set-Cookie"));
        String r6 = r22.b("x-ss-etag");
        String r7 = r22.b("x-tt-tnc-attr");
        String r0 = r22.b("x-tt-with-tnc");
        JSONObject r8 = null;
        if (TextUtils.isEmpty(r0) == true) goto L22;
        if (r0.equals("1") == false) goto L22;
        r8 = new JSONObject(new String(r24)).getJSONObject("tnc_data");     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L22:
        if (r5 != null) goto L26;
        if (r8 == null) goto L26;
        this.o.a(r8, r6, r7, false);
        return;
    L26:
        if (r5 != null) goto L29;
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "origin region:" + this.f8349c + " sec_uid:" + this.f + " source:" + this.f8350d + " local:" + this.g);
    L31:
        boolean r9 = !this.f8349c.equals(r5.f8352a);
        String r14 = r22.b("x-tt-store-sec-uid");
        if (r14 != null) goto L34;
        r14 = "";
    L34:
        SharedPreferences.Editor r13 = this.m.getSharedPreferences("ttnet_store_region", 0).edit();
        if (this.f8349c.equals(r5.f8352a) == true) goto L37;
    L42:
        this.f8349c = r5.f8352a;
        this.f8350d = r5.f8353b;
        this.f = r14;
        r13.putString("store_region", this.f8349c);
        r13.putString("store_region_src", this.f8350d);
        r13.putString("store_sec_uid", this.f);
        boolean r1 = true;
    L44:
        if (this.f8351e.equals(r5.f8354c) == true) goto L47;
        String r2 = r5.f8354c;
        this.f8351e = r2;
        r13.putString("region_legacy_user", r2);
        r1 = true;
    L47:
        if (Logger.debug() == false) goto L49;
        Logger.d(TAG, "update region:" + this.f8349c + " sec_uid:" + this.f + " source:" + this.f8350d + " regionLegacyUser:" + this.f8351e + "local:" + this.g);
        Logger.d(TAG, "save config:" + r1 + " update tnc:" + r9);
    L49:
        boolean r10 = this.o.a(r8, r6, r7, r9);
        if (r1 == false) goto L59;
        String r11 = r22.b("x-tt-logid");
        String r12 = r3.getPath() + "," + r11 + "," + r5.f8352a + "," + r5.f8353b;
        this.h = r12;
        r13.putString("update_region_info", r12);
        r13.apply();
        this.o.a(a(r11, r4, r10), "store_idc");
        this.o.a("", this.f8349c, this.f8350d, this.f8351e, this.f, r11);
        return;
    L59:
        return;
    L37:
        if (this.f8350d.equals(r5.f8353b) == false) goto L42;
        if (r14.equals(this.f) == false) goto L42;
        r1 = false;
    }

    public void a(String r1, String r2, String r3, String r4, String r5, String r6) {
        if (this.m != null) goto L5;
        return;
    L5:
        if (this.n == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return;
    L13:
        if (f8347a == true) goto L22;
        if (this.f8349c == null) goto L20;
        if (this.f8350d != null) goto L22;
    L20:
        throw new AssertionError();
    L22:
        if (this.f8349c.equalsIgnoreCase(r2) == true) goto L24;
    L28:
        this.f = r5;
        this.f8349c = r2;
        this.f8350d = r3;
        this.f8351e = r4;
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "saveStoreRegionForCronet region:" + this.f8349c + " source:" + this.f8350d + " sec uid:" + this.f);
    L31:
        SharedPreferences.Editor r7 = this.m.getSharedPreferences("ttnet_store_region", 0).edit();
        r7.putString("store_region", this.f8349c);
        r7.putString("store_region_src", this.f8350d);
        r7.putString("store_sec_uid", this.f);
        r7.apply();
        return;
    L24:
        if (this.f8350d.equalsIgnoreCase(r3) == false) goto L28;
        if (this.f.equalsIgnoreCase(r5) == false) goto L28;
    }

    private String a(String r4, String r5, boolean r6) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put("url", r5);     // Catch: JSONException -> L5
        r1.put("logId", r4);     // Catch: JSONException -> L5
        r0.put("tnc", r6);     // Catch: JSONException -> L5
        r0.put("base", r1);     // Catch: JSONException -> L5
        r0.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L5
        r0.put("store_region", this.f8349c);     // Catch: JSONException -> L5
        r0.put(DBHelper.BATTERY_COL_SOURCE, this.f8350d);     // Catch: JSONException -> L5
        r0.put("region_legacy_user", this.f8351e);     // Catch: JSONException -> L5
        r0.put("local", this.g);     // Catch: JSONException -> L5
    L8:
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        Iterator<String> r4 = this.k.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (l.a(r5, (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private String b(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return "";
    L5:
        String[] r2 = r3.split(";");
        if (r2 != null) goto L8;
    L15:
        return "";
    L8:
        if (r2.length <= 0) goto L15;
        String[] r4 = r2[0].trim().split("=");
        if (r4 == null) goto L15;
        if (r4.length != 2) goto L15;
        return r4[1];
    }

    private a a(List<String> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L5;
    L31:
        return null;
    L5:
        if (r12.isEmpty() == true) goto L31;
        if (p == false) goto L10;
        String r2 = "store-region=";
        String r3 = "store-region-src=";
    L11:
        Iterator r13 = r12.iterator();
        String r4 = "";
        String r5 = "";
        String r6 = r5;
    L13:
        if (r13.hasNext() == false) goto L24;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        if (r7.toLowerCase().startsWith(r2) == true) goto L16;
        if (r7.toLowerCase().startsWith(r3) == true) goto L19;
        if (r7.toLowerCase().startsWith("region_legacy_user=") == false) goto L13;
        r6 = r7;
        goto L13
    L19:
        r5 = r7;
        goto L13
    L16:
        r4 = r7;
        goto L13
    L24:
        if (TextUtils.isEmpty(r4) == false) goto L26;
        return null;
    L26:
        String r14 = b(r4);
        if (r14.isEmpty() == false) goto L30;
        return null;
    L30:
        return new a(this, r14, b(r5), b(r6));
    L10:
        r2 = "store-country-code=";
        r3 = "store-country-code-src=";
        goto L11
    }

    public void a(HttpURLConnection r16, byte[] r17, InterfaceC0189b r18) {
        InterfaceC0189b r3 = (InterfaceC0189b) ZeusTransformUtils.wrapperContextForParams(r18, InterfaceC0189b.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L5;
        return;
    L5:
        if (this.n == true) goto L8;
        return;
    L8:
        if (a(r16.getURL().getPath()) == true) goto L10;
        return;
    L10:
        Map<String, List<String>> r4 = r16.getHeaderFields();
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(r4.get("Set-Cookie"), List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L13;
    L14:
        r5 = (List) ZeusTransformUtils.preCheckCast(r4.get("Set-Cookie".toLowerCase()), List.class, "com.obric.aiagent.plugin");
    L15:
        a r2 = a(r5);
        String r0 = a(r4, "x-tt-with-tnc");
        String r6 = "";
        if (TextUtils.isEmpty(r0) == false) goto L18;
    L23:
        String r11 = "";
    L24:
        if (r2 == null) goto L26;
    L28:
        if (r2 != null) goto L30;
        r2 = new a(this, "", "", "");
    L30:
        String r13 = a(r4, "x-tt-store-sec-uid");
        String r14 = a(r4, "x-tt-logid");
        String r8 = a(r4, "x-tt-tnc-attr");
        String r9 = a(r4, "x-ss-etag");
        String r10 = a(r4, "x-tt-tnc-config");
        JSONObject r1 = new JSONObject();
        r6 = r16.getURL().getPath();     // Catch: JSONException -> L33
        r1.put("url", r16.getURL().getHost() + r6);     // Catch: JSONException -> L33
        r1.put("store_region", r2.f8352a + "," + r2.f8353b);     // Catch: JSONException -> L33
        r1.put("region_legacy_user", r2.f8354c);     // Catch: JSONException -> L33
        r1.put("logId", r14);     // Catch: JSONException -> L33
    L35:
        r3.notifyStoreRegionUpdatedForCronet(r6, r2.f8352a, r2.f8353b, r2.f8354c, r8, r9, r10, r11, r1.toString(), r13, r14);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L26:
        if (TextUtils.isEmpty(r11) == false) goto L28;
        return;
    L18:
        if (r0.equals("1") == false) goto L23;
        r11 = "{\"data\": " + new JSONObject(new String(r17)).getString("tnc_data") + "}";     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L13:
        if (r5.isEmpty() == false) goto L15;
        goto L14
    }

    private static String a(Map<String, List<String>> r6, String r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
    L18:
        return "";
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L18;
        List r2 = null;
        Iterator r3 = r8.keySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (r7.equalsIgnoreCase(r4) == false) goto L9;
        r2 = (List) ZeusTransformUtils.preCheckCast(r8.get(r4), List.class, "com.obric.aiagent.plugin");
    L13:
        if (r2 == null) goto L18;
        if (r2.size() <= 0) goto L18;
        return (String) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), String.class, "com.obric.aiagent.plugin");
    }

    public JSONObject e() {
        if (this.n == true) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put("region", this.f8349c);     // Catch: JSONException -> L9
        r0.put(DBHelper.BATTERY_COL_SOURCE, this.f8350d);     // Catch: JSONException -> L9
        r0.put("local_region", this.g);     // Catch: JSONException -> L9
        r0.put("update_region", this.h);     // Catch: JSONException -> L9
    L11:
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void a(boolean r0) {
        p = r0;
    }

    public static boolean f() {
        return p;
    }
}
