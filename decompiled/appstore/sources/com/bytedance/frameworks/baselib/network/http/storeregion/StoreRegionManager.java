package com.bytedance.frameworks.baselib.network.http.storeregion;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.h;
import com.bytedance.frameworks.baselib.network.http.util.i;
import g6.a;
import g6.b;
import io.reactivex.annotations.SchedulerSupport;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StoreRegionManager {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile StoreRegionManager f7507m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7508n = "StoreRegionManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f7513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f7515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f7516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f7517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public StoreRegionBridge f7520l;

    public interface StoreRegionCallback {
        void notifyStoreRegionUpdatedForCronet(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17);
    }

    static {
    }

    public StoreRegionManager() {
        this.f7509a = "";
        this.f7510b = "";
        this.f7511c = "";
        this.f7512d = "";
        this.f7513e = "";
        this.f7514f = "";
        this.f7515g = new ArrayList();
        this.f7516h = new ArrayList();
        this.f7518j = false;
        this.f7519k = false;
    }

    public static String g(HttpURLConnection r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return "";
    L6:
        String r12 = r10.getHeaderField(r11);
        if (TextUtils.isEmpty(r12) == true) goto L9;
        return r12;
    L9:
        return r10.getHeaderField(r11.toLowerCase());
    }

    public static StoreRegionManager m() {
        if (f7507m != null) goto L16;
        monitor-enter(StoreRegionManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7507m != null) goto L11;
        f7507m = new StoreRegionManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(StoreRegionManager.class);     // Catch: Throwable -> L9
    L16:
        return f7507m;
    }

    public final void a() {
        if (this.f7512d.isEmpty() == true) goto L6;
        this.f7509a = this.f7512d;
        this.f7513e = "uid";
        return;
    L6:
        if (this.f7511c.isEmpty() == true) goto L9;
        this.f7509a = this.f7511c;
        this.f7513e = "did";
        return;
    L9:
        if (this.f7514f.isEmpty() == true) goto L11;
        this.f7509a = this.f7514f;
        this.f7513e = "local";
        return;
    L11:
        this.f7513e = SchedulerSupport.NONE;
        this.f7509a = "";
    }

    public final void b(b r10, b.a r11, List r12) {
        if (TextUtils.isEmpty(r10.z()) == false) goto L5;
        return;
    L5:
        Iterator r13 = this.f7515g.iterator();
    L7:
        if (r13.hasNext() == false) goto L23;
        String r14 = (String) r13.next();
        if (i.i(r10.z(), r14) == false) goto L7;
        if (this.f7511c.isEmpty() == true) goto L13;
        r12.add(new a("x-tt-store-region-did", this.f7511c));
    L15:
        if (this.f7512d.isEmpty() == true) goto L17;
        r12.add(new a("x-tt-store-region-uid", this.f7512d));
    L18:
        h r15 = new h(r10.D());
        r15.b("okhttp_version", "4.1.79.42-pico");
        r11.c(r15.c());
        return;
    L17:
        r12.add(new a("x-tt-store-region-uid", SchedulerSupport.NONE));
        goto L18
    L13:
        r12.add(new a("x-tt-store-region-did", SchedulerSupport.NONE));
        goto L15
    }

    public void c(Map r10) {
        if (this.f7518j == true) goto L5;
        return;
    L5:
        if (this.f7519k == true) goto L19;
        if (r10 != null) goto L9;
        return;
    L9:
        if (this.f7510b.isEmpty() == true) goto L12;
        r10.put("x-tt-store-idc", this.f7510b);
    L12:
        if (this.f7509a.isEmpty() == true) goto L15;
        r10.put("x-tt-store-region", this.f7509a);
    L15:
        if (this.f7513e.isEmpty() == true) goto L20;
        r10.put("x-tt-store-region-src", this.f7513e);
        return;
    L20:
        return;
    }

    public b d(b r10) {
        if (this.f7518j == true) goto L5;
    L31:
        return null;
    L5:
        if (this.f7519k == true) goto L31;
        if (TextUtils.isEmpty(r10.v()) == true) goto L31;
        Iterator r11 = this.f7516h.iterator();
    L11:
        if (r11.hasNext() == false) goto L31;
        String r12 = (String) r11.next();
        if (i.i(r10.v(), r12) == false) goto L11;
        ArrayList r13 = new ArrayList();
        if (r10.u() == null) goto L18;
        r13.addAll(r10.u());
    L18:
        if (TextUtils.isEmpty(this.f7510b) == true) goto L21;
        r13.add(new a("x-tt-store-idc", this.f7510b));
    L21:
        if (TextUtils.isEmpty(this.f7509a) == false) goto L23;
        r13.add(new a("x-tt-local-region", "unknown"));
    L29:
        b.a r14 = r10.J();
        b(r10, r14, r13);
        r14.b(r13);
        return r14.a();
    L23:
        if (p(this.f7513e) == false) goto L26;
        r13.add(new a("x-tt-store-region", this.f7509a));
        r13.add(new a("x-tt-store-region-src", this.f7513e));
        goto L29
    L26:
        if (this.f7513e.equals("local") == false) goto L29;
        r13.add(new a("x-tt-local-region", this.f7514f));
        goto L29
    }

    public final boolean e(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        Iterator r11 = this.f7515g.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (i.i(r10, (String) r11.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public void f(boolean r10) {
        Context r11 = this.f7517i;
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.f7518j == true) goto L8;
        return;
    L8:
        if (this.f7519k == r10) goto L12;
        this.f7519k = r10;
        SharedPreferences.Editor r12 = r11.getSharedPreferences("ttnet_store_region", 0).edit();
        r12.putBoolean("disable_store_region", this.f7519k);
        r12.apply();
        return;
    }

    public JSONObject h() {
        if (this.f7518j == true) goto L6;
        return null;
    L6:
        JSONObject r10 = new JSONObject();
        r10.put(CommonKey.KEY_REGION, this.f7509a);     // Catch: JSONException -> L9
        r10.put("source", this.f7513e);     // Catch: JSONException -> L9
        r10.put("local_region", this.f7514f);     // Catch: JSONException -> L9
    L11:
        return r10;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String i() {
        return this.f7509a;
    }

    public final String j(Response r10, String r11) {
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        r13.put("url", r11);     // Catch: JSONException -> L5
        r13.put("headers", r10.i().toString());     // Catch: JSONException -> L5
        r12.put(TraceStatsConsts.STATS_BASE_MODULE, r13);     // Catch: JSONException -> L5
        r12.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L5
        r12.put("store_idc", this.f7510b);     // Catch: JSONException -> L5
        r12.put("store_region", this.f7509a);     // Catch: JSONException -> L5
        r12.put("source", this.f7513e);     // Catch: JSONException -> L5
        r12.put("did_region", this.f7511c);     // Catch: JSONException -> L5
        r12.put("uid_region", this.f7512d);     // Catch: JSONException -> L5
        r12.put("local", this.f7514f);     // Catch: JSONException -> L5
    L8:
        return r12.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public String k() {
        return this.f7513e;
    }

    public void l(String r10, String r11, Context r12, StoreRegionBridge r13) {
        Logger.d(f7508n, "rule json: " + r11);
        if (TextUtils.isEmpty(r11) == true) goto L42;
        if (r12 == null) goto L43;
        if (r13 == null) goto L46;
        JSONObject r14 = new JSONObject(r11);     // Catch: JSONException -> L13
        JSONArray r15 = r14.optJSONArray("update_store_idc_path_list");     // Catch: JSONException -> L13
        int r16 = 0;
        int r17 = 0;
    L9:
        if (r17 >= r15.length()) goto L16;
        String r18 = r15.getString(r17);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r18) == true) goto L15;
        this.f7515g.add(r18);     // Catch: JSONException -> L13
    L15:
        r17 = r17 + 1;     // Catch: JSONException -> L13
        goto L9
    L16:
        JSONArray r19 = r14.optJSONArray("add_store_idc_host_list");     // Catch: JSONException -> L13
    L18:
        if (r16 >= r19.length()) goto L23;
        String r20 = r19.getString(r16);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r20) == true) goto L22;
        this.f7516h.add(r20);     // Catch: JSONException -> L13
    L22:
        r16 = r16 + 1;     // Catch: JSONException -> L13
        goto L18
    L23:
        this.f7517i = r12;     // Catch: JSONException -> L13
        this.f7520l = r13;     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r10) == true) goto L27;
        this.f7514f = r10;     // Catch: JSONException -> L13
    L27:
        if (this.f7515g.isEmpty() == false) goto L29;
        return;
    L29:
        if (this.f7515g.isEmpty() == true) goto L45;
        this.f7518j = true;     // Catch: JSONException -> L13
        q();     // Catch: JSONException -> L13
        return;
    L45:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L46:
        return;
    L43:
        return;
    }

    public final boolean n(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L15:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (r11.equals("uid") == false) goto L10;
        return true;
    L10:
        if (r11.equals("did") == true) goto L16;
        return false;
    L16:
        return true;
    }

    public boolean o() {
        if (this.f7518j == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f7519k == true) goto L7;
        return true;
    }

    public final boolean p(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (r10.equals("uid") == false) goto L8;
    L9:
        return true;
    L8:
        if (r10.equals("did") == true) goto L9;
        return false;
    }

    public final void q() {
        SharedPreferences r10 = this.f7517i.getSharedPreferences("ttnet_store_region", 0);
        this.f7510b = r10.getString("store_idc", "");
        this.f7509a = r10.getString("store_region", "");
        this.f7512d = r10.getString("store_region_uid", "");
        this.f7511c = r10.getString("store_region_did", "");
        this.f7513e = r10.getString("store_region_src", "");
        this.f7519k = r10.getBoolean("disable_store_region", false);
        a();
        this.f7520l.onStoreIdcChanged(this.f7510b, this.f7509a, this.f7513e);
        Logger.d(f7508n, "Init idc: " + this.f7510b + " region: " + this.f7509a + " source: " + this.f7513e + " did: " + this.f7511c + " uid: " + this.f7512d + " local: " + this.f7514f);
    }

    public void r(String r10, String r11, String r12) {
        if (this.f7517i != null) goto L5;
        return;
    L5:
        if (this.f7518j == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r12) == false) goto L13;
        return;
    L13:
        if (this.f7510b.equalsIgnoreCase(r10) == true) goto L15;
    L19:
        SharedPreferences.Editor r13 = this.f7517i.getSharedPreferences("ttnet_store_region", 0).edit();
        if (TextUtils.isEmpty(r10) == true) goto L22;
        this.f7510b = r10;
    L22:
        this.f7509a = r11;
        if (r12.equalsIgnoreCase("uid") == false) goto L26;
        this.f7513e = "uid";
        this.f7512d = r11;
    L28:
        Logger.d(f7508n, "saveStoreRegionForCronet idc:" + this.f7510b + " region:" + this.f7509a + " source:" + this.f7513e);
        r13.putString("store_region", this.f7509a);
        r13.putString("store_idc", this.f7510b);
        r13.putString("store_region_src", this.f7513e);
        r13.putString("store_region_did", this.f7511c);
        r13.putString("store_region_uid", this.f7512d);
        r13.apply();
        return;
    L26:
        if (r12.equalsIgnoreCase("did") == false) goto L28;
        this.f7513e = "did";
        this.f7511c = r11;
        goto L28
    L15:
        if (this.f7509a.equalsIgnoreCase(r11) == false) goto L19;
        if (this.f7513e.equalsIgnoreCase(r12) == false) goto L19;
    }

    public void s(HttpURLConnection r11, byte[] r12, StoreRegionCallback r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (this.f7518j == true) goto L6;
        return;
    L6:
        if (this.f7519k == false) goto L9;
        return;
    L9:
        if (e(r11.getURL().getPath()) == true) goto L11;
        return;
    L11:
        String r10 = g(r11, "x-tt-store-region");
        String r14 = g(r11, "x-tt-store-region-src");
        if (n(r10, r14) == true) goto L14;
        return;
    L14:
        String r15 = g(r11, "x-tt-store-idc");
        String r16 = g(r11, "x-tt-with-tnc");
        String r17 = g(r11, "x-tt-tnc-attr");
        String r18 = g(r11, "x-ss-etag");
        String r19 = g(r11, "x-tt-tnc-config");
        if (TextUtils.isEmpty(r16) == false) goto L17;
    L24:
        String r110 = "";
    L21:
        String r20 = r110;
        String r111 = r11.getURL().toString();
        String r112 = r11.getHeaderFields().toString();
        JSONObject r113 = new JSONObject();
        r113.put("url", r111);     // Catch: JSONException -> L28
        r113.put("headers", r112);     // Catch: JSONException -> L28
    L30:
        r13.notifyStoreRegionUpdatedForCronet(r15, r10, r14, r17, r18, r19, r20, r113.toString());
        return;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L17:
        if (r16.equals("1") == false) goto L24;
        if (TextUtils.isEmpty(r17) == true) goto L24;
        r110 = "{\"data\": " + new JSONObject(new String(r12)).getString("tnc_data") + "}";     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public void t(Response r16, String r17, byte[] r18) {
        if (this.f7518j == true) goto L5;
        return;
    L5:
        if (this.f7519k == true) goto L76;
        URI r10 = i.l(r17);     // Catch: Exception -> L67
        if (r10 != null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r10.getPath()) == false) goto L13;
        return;
    L13:
        if (e(r10.getPath()) == true) goto L15;
        return;
    L15:
        String r11 = r16.f("x-tt-store-region");
        String r12 = r16.f("x-tt-store-region-src");
        if (TextUtils.isEmpty(r11) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r12) == false) goto L20;
        return;
    L20:
        if (p(r12) == false) goto L78;
        String r13 = f7508n;
        Logger.d(r13, "origin idc: " + this.f7510b + " region: " + this.f7509a + " source: " + this.f7513e + " did: " + this.f7511c + " uid: " + this.f7512d + " local: " + this.f7514f);
        String r14 = r16.f("x-tt-store-idc");
        boolean r15 = false;
        SharedPreferences.Editor r19 = this.f7517i.getSharedPreferences("ttnet_store_region", 0).edit();
        boolean r110 = true;
        if (r12.equals("did") == false) goto L29;
        if (this.f7511c.equals(r11) == true) goto L29;
        this.f7511c = r11;
        r19.putString("store_region_did", r11);
    L27:
        boolean r20 = true;
    L39:
        String r21 = this.f7509a;
        a();
        if (this.f7509a.equals(r21) == false) goto L48;
        if (TextUtils.isEmpty(r14) == false) goto L44;
    L46:
        r110 = r20;
    L51:
        Logger.d(r13, "update idc: " + this.f7510b + " region: " + this.f7509a + " source: " + this.f7513e + " did: " + this.f7511c + " uid: " + this.f7512d + " local: " + this.f7514f);
        StringBuilder r22 = new StringBuilder();
        r22.append("save config: ");
        r22.append(r110);
        r22.append(" update tnc: ");
        r22.append(r15);
        Logger.d(r13, r22.toString());
        if (r110 == false) goto L54;
        r19.putString("store_region_src", this.f7513e);
        r19.apply();
        this.f7520l.sendFeedbackLog(j(r16, r17), "store_idc");
        this.f7520l.onStoreIdcChanged(this.f7510b, this.f7509a, this.f7513e);
    L54:
        String r23 = r16.f("x-ss-etag");
        String r24 = r16.f("x-tt-tnc-attr");
        String r25 = r16.f("x-tt-with-tnc");
        if (TextUtils.isEmpty(r25) == false) goto L57;
    L64:
        JSONObject r26 = null;
    L65:
        this.f7520l.updateTncConfig(r26, r23, r24, r15);
        return;
    L57:
        if (r25.equals("1") == false) goto L64;
        if (TextUtils.isEmpty(r24) == true) goto L64;
        r26 = new JSONObject(new String(r18)).getJSONObject("tnc_data");     // Catch: JSONException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L44:
        if (r14.equals(this.f7510b) == true) goto L46;
    L48:
        if (TextUtils.isEmpty(r14) == true) goto L50;
        this.f7510b = r14;
    L50:
        r19.putString("store_region", this.f7509a);
        r19.putString("store_idc", this.f7510b);
        r15 = true;
    L29:
        if (r12.equals("uid") == true) goto L31;
    L38:
        r20 = false;
        goto L39
    L31:
        if (this.f7512d.equals(r11) == true) goto L38;
        if (r11.equals(SchedulerSupport.NONE) == true) goto L35;
        this.f7512d = r11;
        r19.putString("store_region_uid", r11);
        goto L27
    L35:
        if (this.f7512d.isEmpty() == true) goto L38;
        this.f7512d = "";
        r19.putString("store_region_uid", "");
        goto L27
    L78:
        return;
    L79:
        return;
    }
}
