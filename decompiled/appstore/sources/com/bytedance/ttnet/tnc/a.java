package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.ttnet.TTReqController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y4.e;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f8183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s6.a f8184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8189g;

    public a(Context r10, boolean r11) {
        this.f8186d = "";
        this.f8187e = "";
        this.f8188f = "";
        this.f8189g = "";
        this.f8183a = r10;
        this.f8185c = r11;
        this.f8184b = new s6.a();
    }

    public String a() {
        return this.f8186d;
    }

    public String b() {
        return this.f8188f;
    }

    public s6.a c() {
        return this.f8184b;
    }

    public boolean d(JSONObject r18, TNCManager.TNCUpdateSource r19, String r20, String r21, long r22) {
        Logger.d("TNCConfigHandler", "handleConfigChanged");
        if (this.f8185c == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d("TNCConfigHandler", "handleConfigChanged: no mainProc");
    L7:
        return false;
    L9:
        if (j(r21) == true) goto L11;
        return false;
    L11:
        g.l().p(r18, r19.mValue, r20, this.f8189g, r22);
        b.q().x(r18);
        TTReqController.a(r18);
        TTDelayStateManager.e(r18);
        e.f().g(r18);
        s6.a r10 = h(r18);     // Catch: Throwable -> L17
        if (Logger.debug() == false) goto L21;
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L17
        r11.append("handleConfigChanged, newConfig: ");     // Catch: Throwable -> L17
        if (r10 != null) goto L19;
        String r12 = "null";
    L20:
        r11.append(r12);     // Catch: Throwable -> L17
        Logger.d("TNCConfigHandler", r11.toString());     // Catch: Throwable -> L17
        goto L21
    L19:
        r12 = r10.toString();     // Catch: Throwable -> L17
    L21:
        if (r10 != null) goto L31;
        SharedPreferences.Editor r13 = this.f8183a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r13.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L26;
        r13.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 5, r20);
    L26:
        if (TextUtils.isEmpty(this.f8189g) == false) goto L28;
        this.f8189g = "";
    L28:
        String r14 = this.f8189g;
        String r15 = "ttnet_tnc_abtest";
    L29:
        r13.putString(r15, r14).apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 6, this.f8189g);
        return false;
    L31:
        r15 = "ttnet_tnc_abtest";
        this.f8184b = r10;     // Catch: Throwable -> L41
        String r16 = r18.toString();     // Catch: Throwable -> L41
        SharedPreferences.Editor r17 = this.f8183a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r17.putString("tnc_config_str", r16).apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 4, r16);
        if (TextUtils.isEmpty(r20) == true) goto L37;
        r17.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 5, r20);
    L37:
        if (TextUtils.isEmpty(this.f8189g) == false) goto L39;
        this.f8189g = "";
    L39:
        r17.putString(r15, this.f8189g).apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 6, this.f8189g);
        return true;
    L41:
        th = th;
    L63:
        th.printStackTrace();     // Catch: Throwable -> L50
        this.f8184b = new s6.a();     // Catch: Throwable -> L50
        r13 = this.f8183a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r13.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L47;
        r13.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 5, r20);
    L47:
        if (TextUtils.isEmpty(this.f8189g) == false) goto L49;
        this.f8189g = "";
    L49:
        r14 = this.f8189g;
    L50:
        th = move-exception;
        SharedPreferences.Editor r23 = this.f8183a.getSharedPreferences("ttnet_tnc_config", 0).edit();
        r23.putString("tnc_config_str", "").apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 4, "");
        if (TextUtils.isEmpty(r20) == true) goto L55;
        r23.putString("ttnet_tnc_etag", r20).apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 5, r20);
    L55:
        if (TextUtils.isEmpty(this.f8189g) == false) goto L57;
        this.f8189g = "";
    L57:
        r23.putString(r15, this.f8189g).apply();
        com.bytedance.ttnet.utils.b.b(this.f8183a, 6, this.f8189g);
        throw th;
    L17:
        th = th;
        r15 = "ttnet_tnc_abtest";
        goto L63
    }

    public final String e() {
        if (TextUtils.isEmpty(TNCManager.g()) == false) goto L11;
        Logger.d("TNCConfigHandler", "getGetDomainDefaultJson no existed");
        return null;
    L11:
        String r10 = new JSONObject(TNCManager.g()).getString("data");     // Catch: JSONException -> L8
        Logger.d("TNCConfigHandler", "use get domain default json.");     // Catch: JSONException -> L8
        return r10;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void f(long r13) {
        Logger.d("TNCConfigHandler", "load local config");
        if (this.f8185c == true) goto L5;
        return;
    L5:
        SharedPreferences r10 = this.f8183a.getSharedPreferences("ttnet_tnc_config", 0);
        String r11 = r10.getString("tnc_config_str", null);
        String r12 = r10.getString("ttnet_tnc_etag", null);
        String r14 = r10.getString("ttnet_tnc_abtest", null);
        if (TextUtils.isEmpty(r11) == false) goto L28;
        r11 = e();
        if (TextUtils.isEmpty(r11) == false) goto L28;
        Logger.d("TNCConfigHandler", "load local config failed.");
        return;
    L28:
        JSONObject r15 = new JSONObject(r11);     // Catch: Throwable -> L14
        g.l().p(r15, TNCManager.TNCUpdateSource.TTCACHE.mValue, r12, r14, r13);     // Catch: Throwable -> L14
        b.q().x(r15);     // Catch: Throwable -> L14
        TTReqController.a(r15);     // Catch: Throwable -> L14
        TTDelayStateManager.e(r15);     // Catch: Throwable -> L14
        e.f().g(r15);     // Catch: Throwable -> L14
        s6.a r16 = h(r15);     // Catch: Throwable -> L14
        if (r16 == null) goto L17;
        this.f8184b = r16;     // Catch: Throwable -> L14
    L17:
        if (Logger.debug() == false) goto L30;
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L14
        r17.append("loadLocalConfig: ");     // Catch: Throwable -> L14
        if (r16 != null) goto L21;
        String r18 = "null";
    L22:
        r17.append(r18);     // Catch: Throwable -> L14
        Logger.d("TNCConfigHandler", r17.toString());     // Catch: Throwable -> L14
        return;
    L21:
        r18 = r16.toString();     // Catch: Throwable -> L14
        goto L22
    L30:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L31;
        Logger.d("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
        return;
    }

    public void g(long r11) {
        String r10 = com.bytedance.ttnet.utils.b.a(this.f8183a, 4);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r10) == false) goto L11;
        r10 = e();     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r10) == false) goto L11;
        Logger.d("TNCConfigHandler", "load local config failed.");     // Catch: Throwable -> L9
        return;
    L11:
        JSONObject r12 = new JSONObject(r10);     // Catch: Throwable -> L9
        s6.a r13 = h(r12);     // Catch: Throwable -> L9
        g.l().p(r12, TNCManager.TNCUpdateSource.TTCACHE.mValue, com.bytedance.ttnet.utils.b.a(this.f8183a, 5), com.bytedance.ttnet.utils.b.a(this.f8183a, 6), r11);     // Catch: Throwable -> L9
        b.q().x(r12);     // Catch: Throwable -> L9
        TTReqController.a(r12);     // Catch: Throwable -> L9
        TTDelayStateManager.e(r12);     // Catch: Throwable -> L9
        e.f().g(r12);     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L18;
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L9
        r14.append("loadLocalConfigForOtherProcess, config: ");     // Catch: Throwable -> L9
        if (r13 != null) goto L16;
        String r15 = "null";
    L17:
        r14.append(r15);     // Catch: Throwable -> L9
        Logger.d("TNCConfigHandler", r14.toString());     // Catch: Throwable -> L9
        goto L18
    L16:
        r15 = r13.toString();     // Catch: Throwable -> L9
    L18:
        if (r13 == null) goto L26;
        this.f8184b = r13;     // Catch: Throwable -> L9
        return;
    L26:
        return;
    L9:
        th = move-exception;
        if (Logger.debug() == false) goto L27;
        Logger.d("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        return;
    }

    public final s6.a h(JSONObject r10) {
        g.l().f().clear();     // Catch: Throwable -> L13
        JSONObject r11 = r10.optJSONObject("tnc_config");     // Catch: Throwable -> L13
        s6.a r12 = new s6.a();     // Catch: Throwable -> L13
        if (r11 != null) goto L6;
        return r12;
    L6:
        boolean r13 = true;
        if (r11.has("local_enable") == false) goto L16;
        if (r11.getInt("local_enable") != 0) goto L11;
        boolean r14 = false;
    L12:
        r12.f24508a = r14;     // Catch: Throwable -> L13
        goto L16
    L11:
        r14 = true;
    L16:
        if (r11.has("probe_enable") == false) goto L22;
        if (r11.getInt("probe_enable") != 0) goto L20;
        r13 = false;
    L20:
        r12.f24509b = r13;     // Catch: Throwable -> L13
    L22:
        if (r11.has("local_host_filter") == false) goto L34;
        JSONArray r15 = r11.getJSONArray("local_host_filter");     // Catch: Throwable -> L13
        HashMap r16 = new HashMap();     // Catch: Throwable -> L13
        if (r15.length() <= 0) goto L33;
        int r17 = 0;
    L27:
        if (r17 >= r15.length()) goto L33;
        String r18 = r15.getString(r17);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r18) == true) goto L32;
        r16.put(r18, 0);     // Catch: Throwable -> L13
    L32:
        r17 = r17 + 1;     // Catch: Throwable -> L13
    L33:
        r12.f24510c = r16;     // Catch: Throwable -> L13
    L36:
        if (r11.has("host_replace_map") == false) goto L48;
        JSONObject r19 = r11.getJSONObject("host_replace_map");     // Catch: Throwable -> L13
        if (r19.length() <= 0) goto L48;
        Iterator<String> r20 = r19.keys();     // Catch: Throwable -> L13
    L41:
        if (r20.hasNext() == false) goto L48;
        String r21 = r20.next();     // Catch: Throwable -> L13
        String r22 = r19.getString(r21);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r21) == true) goto L41;
        if (TextUtils.isEmpty(r22) == true) goto L41;
        g.l().f().put(r21, r22);     // Catch: Throwable -> L13
    L48:
        r12.f24511d = r11.optInt("req_to_cnt", r12.f24511d);     // Catch: Throwable -> L13
        r12.f24512e = r11.optInt("req_to_api_cnt", r12.f24512e);     // Catch: Throwable -> L13
        r12.f24513f = r11.optInt("req_to_ip_cnt", r12.f24513f);     // Catch: Throwable -> L13
        r12.f24514g = r11.optInt("req_err_cnt", r12.f24514g);     // Catch: Throwable -> L13
        r12.f24515h = r11.optInt("req_err_api_cnt", r12.f24515h);     // Catch: Throwable -> L13
        r12.f24516i = r11.optInt("req_err_ip_cnt", r12.f24516i);     // Catch: Throwable -> L13
        r12.f24517j = r11.optInt("update_interval", r12.f24517j);     // Catch: Throwable -> L13
        r12.f24518k = r11.optInt("update_random_range", r12.f24518k);     // Catch: Throwable -> L13
        r12.f24519l = r11.optString("http_code_black", r12.f24519l);     // Catch: Throwable -> L13
        return r12;
    L34:
        r12.f24510c = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void i(String r10) {
        this.f8189g = r10;
    }

    public final boolean j(String r10) {
        boolean r11 = true;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L39:
        return true;
    L5:
        if (StoreRegionManager.m().o() == false) goto L39;
        ArrayList r12 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.util.e.b(r10, ";", "=", r12) == true) goto L10;
    L38:
        return false;
    L10:
        if (r12.size() != 3) goto L38;
        String r13 = (String) ((Pair) r12.get(1)).second;
        String r14 = (String) ((Pair) r12.get(0)).second;
        if (((String) ((Pair) r12.get(2)).first).equals("force_accept") == true) goto L15;
    L18:
        String r15 = StoreRegionManager.m().k();
        if (r15.equals("did") == true) goto L29;
        if (r15.equals("uid") == true) goto L29;
        if (r13.equals("did") == false) goto L26;
    L33:
        r11 = false;
    L34:
        if (r11 == false) goto L36;
        this.f8186d = r14;
        this.f8188f = r13;
    L36:
        Logger.d("TNCConfigHandler", "accept: " + r11 + " tnc source: " + r13 + " tnc region: " + r14 + " user source: " + r15 + " user region: " + StoreRegionManager.m().i());
        return r11;
    L26:
        if (r13.equals("uid") == true) goto L33;
    L29:
        if (r13.equals(r15) == false) goto L33;
        if (r14.equals(StoreRegionManager.m().i()) == false) goto L33;
    L15:
        if (((String) ((Pair) r12.get(2)).second).equals("true") == false) goto L18;
        this.f8186d = r14;
        this.f8188f = r13;
        return true;
    }
}
