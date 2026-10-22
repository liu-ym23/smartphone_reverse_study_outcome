package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.f.d;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l;
import com.bytedance.ttnet.a.e;
import com.bytedance.ttnet.a.j;
import com.bytedance.ttnet.f;
import com.bytedance.ttnet.g.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TNCConfigHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "TNCConfigHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f11506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11509e;
    private String f;
    private String g;

    public b(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f11508d = "";
        this.f11509e = "";
        this.f = "";
        this.g = "";
        this.f11505a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f11507c = r4;
        this.f11506b = new a();
    }

    public boolean a(Object r18, c.b r19, String r20, String r21, long r22) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "handleConfigChanged");
    L6:
        if (this.f11507c == false) goto L8;
        JSONObject r6 = e.c(r18);
        l.a().a(r6, r19.l, r20, this.g, r22);
        b(r6);
        a r7 = a(r6);     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L19;
        StringBuilder r8 = new StringBuilder().append("handleConfigChanged, newConfig: ");     // Catch: Throwable -> L47
        if (r7 != null) goto L17;
        String r9 = "null";
    L18:
        Logger.d(TAG, r8.append(r9).toString());     // Catch: Throwable -> L47
        goto L19
    L17:
        r9 = r7.toString();     // Catch: Throwable -> L47
    L19:
        if (r7 != null) goto L28;
        SharedPreferences.Editor r0 = this.f11505a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r0.putBoolean("is_full_config", false);
        r0.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 7, com.bytedance.ttnet.utils.b.a(false));
        com.bytedance.ttnet.utils.b.a(this.f11505a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L24;
        r0.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 5, r20);
    L24:
        if (TextUtils.isEmpty(this.g) == false) goto L26;
        this.g = "";
    L26:
        r0.putString("ttnet_tnc_abtest", this.g).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 6, this.g);
        return false;
    L28:
        String r10 = "ttnet_tnc_abtest";
        this.f11506b = r7;     // Catch: Throwable -> L45
        if (ZeusTransformUtils.instanceOf(r18, e.b.class) == true) goto L68;
        String r1 = r6.toString();     // Catch: Throwable -> L45
        boolean r11 = false;
    L37:
        SharedPreferences.Editor r12 = this.f11505a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r12.putBoolean("is_full_config", r11);
        r12.putString("tnc_config_str", r1).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 7, com.bytedance.ttnet.utils.b.a(r11));
        com.bytedance.ttnet.utils.b.a(this.f11505a, 4, r1);
        if (TextUtils.isEmpty(r20) == true) goto L41;
        r12.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 5, r20);
    L41:
        if (TextUtils.isEmpty(this.g) == false) goto L43;
        this.g = "";
    L43:
        r12.putString(r10, this.g).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 6, this.g);
        return true;
    L68:
        r1 = ((e.b) ZeusTransformUtils.preCheckCast(r18, e.b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L33
        r11 = true;
    L33:
        th = th;
        boolean r13 = true;
    L72:
        th.printStackTrace();     // Catch: Throwable -> L59
        this.f11506b = new a();     // Catch: Throwable -> L59
        SharedPreferences.Editor r2 = this.f11505a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r2.putBoolean("is_full_config", r13);
        r2.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 7, com.bytedance.ttnet.utils.b.a(r13));
        com.bytedance.ttnet.utils.b.a(this.f11505a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L55;
        r2.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 5, r20);
    L55:
        if (TextUtils.isEmpty(this.g) == false) goto L57;
        this.g = "";
    L57:
        r2.putString(r10, this.g).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 6, this.g);
        return false;
    L59:
        th = move-exception;
        SharedPreferences.Editor r14 = this.f11505a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r14.putBoolean("is_full_config", r13);
        r14.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 7, com.bytedance.ttnet.utils.b.a(r13));
        com.bytedance.ttnet.utils.b.a(this.f11505a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L64;
        r14.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 5, r20);
    L64:
        if (TextUtils.isEmpty(this.g) == false) goto L66;
        this.g = "";
    L66:
        r14.putString(r10, this.g).apply();
        com.bytedance.ttnet.utils.b.a(this.f11505a, 6, this.g);
        throw th;
    L45:
        th = th;
    L49:
        r13 = false;
    L47:
        th = th;
        r10 = "ttnet_tnc_abtest";
        goto L49
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "handleConfigChanged: no mainProc");
    L10:
        return false;
    }

    private String d() {
        if (TextUtils.isEmpty(c.b()) == false) goto L13;
        Logger.d(TAG, "getGetDomainDefaultJson no existed");
        return null;
    L13:
        String r3 = new JSONObject(c.b()).getString("data");     // Catch: JSONException -> L10
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "use get domain default json.");     // Catch: JSONException -> L10
    L9:
        return r3;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void a(long r16) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "load local config");
    L6:
        if (this.f11507c == true) goto L8;
        return;
    L8:
        boolean r4 = false;
        SharedPreferences r1 = this.f11505a.getSharedPreferences("ttnet_tnc_config", 0);
        boolean r3 = r1.getBoolean("is_full_config", false);
        String r5 = r1.getString("tnc_config_str", null);
        String r11 = r1.getString("ttnet_tnc_etag", null);
        String r12 = r1.getString("ttnet_tnc_abtest", null);
        if (TextUtils.isEmpty(r5) == false) goto L16;
        r5 = d();
        if (TextUtils.isEmpty(r5) == true) goto L13;
    L38:
        JSONObject r2 = new JSONObject(r5);     // Catch: Throwable -> L33
        if (r4 == false) goto L22;
        JSONObject r6 = r2.optJSONObject("data");     // Catch: Throwable -> L33
        if (r6 == null) goto L22;
        r2 = r6;
    L22:
        l.a().a(r2, c.b.f11519c.l, r11, r12, r16);     // Catch: Throwable -> L33
        b(r2);     // Catch: Throwable -> L33
        a r7 = a(r2);     // Catch: Throwable -> L33
        if (r7 == null) goto L26;
        this.f11506b = r7;     // Catch: Throwable -> L33
    L26:
        if (Logger.debug() == false) goto L41;
        StringBuilder r0 = new StringBuilder().append("loadLocalConfig: ");     // Catch: Throwable -> L33
        if (r7 != null) goto L30;
        String r8 = "null";
    L31:
        Logger.d(TAG, r0.append(r8).toString());     // Catch: Throwable -> L33
        return;
    L30:
        r8 = r7.toString();     // Catch: Throwable -> L33
        goto L31
    L41:
        return;
    L33:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L42;
        Logger.d(TAG, "loadLocalConfig: except: " + th.getMessage());
        return;
    L42:
        return;
    L13:
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "load local config failed.");
        return;
    L40:
        return;
    L16:
        r4 = r3;
        goto L38
    }

    public void b(long r11) {
        boolean r1 = com.bytedance.ttnet.utils.b.a(com.bytedance.ttnet.utils.b.a(this.f11505a, 7));     // Catch: Throwable -> L26
        String r2 = com.bytedance.ttnet.utils.b.a(this.f11505a, 4);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r2) == false) goto L11;
        r1 = false;
        r2 = d();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r2) == false) goto L11;
        if (Logger.debug() == false) goto L32;
        Logger.d(TAG, "load local config failed.");     // Catch: Throwable -> L26
        return;
    L32:
        return;
    L11:
        JSONObject r3 = new JSONObject(r2);     // Catch: Throwable -> L26
        if (r1 == false) goto L16;
        JSONObject r4 = r3.optJSONObject("data");     // Catch: Throwable -> L26
        if (r4 == null) goto L16;
        r3 = r4;
    L16:
        JSONObject r8 = r3;
        a r9 = a(r8);     // Catch: Throwable -> L26
        l.a().a(r8, c.b.f11519c.l, com.bytedance.ttnet.utils.b.a(this.f11505a, 5), com.bytedance.ttnet.utils.b.a(this.f11505a, 6), r11);     // Catch: Throwable -> L26
        b(r8);     // Catch: Throwable -> L26
        if (Logger.debug() == false) goto L23;
        StringBuilder r12 = new StringBuilder().append("loadLocalConfigForOtherProcess, config: ");     // Catch: Throwable -> L26
        if (r9 != null) goto L21;
        String r13 = "null";
    L22:
        Logger.d(TAG, r12.append(r13).toString());     // Catch: Throwable -> L26
        goto L23
    L21:
        r13 = r9.toString();     // Catch: Throwable -> L26
    L23:
        if (r9 == null) goto L33;
        this.f11506b = r9;     // Catch: Throwable -> L26
        return;
    L33:
        return;
    L26:
        th = move-exception;
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        return;
    }

    public a a() {
        return this.f11506b;
    }

    private a a(JSONObject r9) {
        l.a().h().clear();     // Catch: Throwable -> L48
        JSONObject r10 = r9.optJSONObject("tnc_config");     // Catch: Throwable -> L48
        a r4 = new a();     // Catch: Throwable -> L48
        if (r10 != null) goto L6;
        return r4;
    L6:
        boolean r6 = true;
        if (r10.has("local_enable") == false) goto L14;
        if (r10.getInt("local_enable") != 0) goto L11;
        boolean r2 = false;
    L12:
        r4.f11500a = r2;     // Catch: Throwable -> L48
        goto L14
    L11:
        r2 = true;
    L14:
        if (r10.has("probe_enable") == false) goto L20;
        if (r10.getInt("probe_enable") != 0) goto L18;
        r6 = false;
    L18:
        r4.f11501b = r6;     // Catch: Throwable -> L48
    L20:
        if (r10.has("local_host_filter") == false) goto L32;
        JSONArray r0 = r10.getJSONArray("local_host_filter");     // Catch: Throwable -> L48
        HashMap r1 = new HashMap();     // Catch: Throwable -> L48
        if (r0.length() <= 0) goto L31;
        int r3 = 0;
    L25:
        if (r3 >= r0.length()) goto L31;
        String r5 = r0.getString(r3);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r5) == true) goto L30;
        r1.put(r5, 0);     // Catch: Throwable -> L48
    L30:
        r3 = r3 + 1;     // Catch: Throwable -> L48
    L31:
        r4.f11502c = r1;     // Catch: Throwable -> L48
    L34:
        if (r10.has("host_replace_map") == false) goto L46;
        JSONObject r8 = r10.getJSONObject("host_replace_map");     // Catch: Throwable -> L48
        if (r8.length() <= 0) goto L46;
        Iterator<String> r7 = r8.keys();     // Catch: Throwable -> L48
    L39:
        if (r7.hasNext() == false) goto L46;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        String r12 = r8.getString(r11);     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r11) == true) goto L39;
        if (TextUtils.isEmpty(r12) == true) goto L39;
        l.a().h().put(r11, r12);     // Catch: Throwable -> L48
    L46:
        r4.f11503d = r10.optInt("req_to_cnt", r4.f11503d);     // Catch: Throwable -> L48
        r4.f11504e = r10.optInt("req_to_api_cnt", r4.f11504e);     // Catch: Throwable -> L48
        r4.f = r10.optInt("req_to_ip_cnt", r4.f);     // Catch: Throwable -> L48
        r4.g = r10.optInt("req_err_cnt", r4.g);     // Catch: Throwable -> L48
        r4.h = r10.optInt("req_err_api_cnt", r4.h);     // Catch: Throwable -> L48
        r4.i = r10.optInt("req_err_ip_cnt", r4.i);     // Catch: Throwable -> L48
        r4.j = r10.optInt("update_interval", r4.j);     // Catch: Throwable -> L48
        r4.k = r10.optInt("update_random_range", r4.k);     // Catch: Throwable -> L48
        r4.l = r10.optString("http_code_black", r4.l);     // Catch: Throwable -> L48
        return r4;
    L32:
        r4.f11502c = null;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private void b(JSONObject r1) {
        if (com.bytedance.ttnet.a.a.a(this.f11505a).g() == true) goto L5;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.e.getService().a(r1);
        TTConfigManager.inst().onServerConfigChanged(r1);
    L5:
        com.bytedance.ttnet.a.c.a(r1);
        j.a().a(r1);
        i.a().a(r1);
        f.a().a(r1);
        com.bytedance.frameworks.baselib.network.http.f.e.a(r1);
        com.bytedance.frameworks.baselib.network.b.a(r1);
        com.bytedance.frameworks.baselib.network.e.e.e().a(r1);
        com.bytedance.retrofit2.e.f.a(r1);
        com.bytedance.frameworks.baselib.network.http.i.c.a(r1);
        com.bytedance.frameworks.baselib.network.b.a.a(r1);
        com.bytedance.frameworks.baselib.network.b.b.a(r1);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.c.a(r1);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.b.a(r1);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.e.a().a(r1);
        d.a(r1);
    }

    public void a(String r1) {
        this.g = r1;
        l.a().a(r1);
    }

    public String b() {
        return this.f11508d;
    }

    public String c() {
        return this.f;
    }
}
