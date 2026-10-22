package com.bytedance.ttnet.clientkey;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.keva.Keva;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.ttnet.TTNetInit;
import g6.a;
import g6.b;
import g6.c;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ClientKeyManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile ClientKeyManager f8142g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Keva f8143h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f8144i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f8145j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Map f8146k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8147l = "ClientKeyManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f8148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f8149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8153f;

    static {
    }

    public ClientKeyManager() {
        this.f8148a = new CopyOnWriteArrayList();
        this.f8149b = new CopyOnWriteArrayList();
        this.f8150c = "";
        this.f8151d = "";
        this.f8152e = "";
        this.f8153f = "";
    }

    public static String e(String[] r10, long r11, String r13) {
        if (r10 != null) goto L5;
    L33:
        return null;
    L5:
        if (r10.length < 2) goto L33;
        long r12 = 0;
        if (r11 <= 0) goto L33;
        int r14 = r10.length;
        int r15 = 0;
    L11:
        if (r15 >= r14) goto L18;
        String r16 = r10[r15];
        if (TextUtils.isEmpty(r16) == true) goto L17;
        if (r16.toLowerCase().trim().startsWith("Max-Age=".toLowerCase()) == false) goto L17;
        String[] r17 = r16.split("=");
    L19:
        if (r17 == null) goto L33;
        if (r17.length != 2) goto L33;
        long r18 = Long.parseLong(r17[1]);     // Catch: Throwable -> L34
        if (r18 > 0) goto L27;
        return null;
    L27:
        long r19 = r18 - ((System.currentTimeMillis() - r11) / 1000);     // Catch: Throwable -> L34
        if (r19 <= 0) goto L31;
        r12 = r19;
    L31:
        return r13.replaceFirst(r16.trim(), "Max-Age=" + r12);
    L17:
        r15 = r15 + 1;
        goto L11
    L18:
        r17 = null;
        r16 = null;
        goto L19
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (f8143h != null) goto L5;
        return null;
    L5:
        if (f8144i == true) goto L8;
        return null;
    L8:
        if (f8145j == false) goto L12;
        return f8146k;
    L12:
        return i(f8143h.getString("client_key", ""), f8143h.getString("kms_version", ""));
    }

    public static Map i(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L11;
        HashMap r12 = new HashMap();
        r12.put("x-bd-client-key", r10);
        r12.put("x-bd-kmsv", r11);
        return r12;
    L11:
        return null;
    }

    public static ClientKeyManager j() {
        if (f8142g != null) goto L16;
        monitor-enter(ClientKeyManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f8142g != null) goto L11;
        f8142g = new ClientKeyManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L9
    L16:
        return f8142g;
    }

    public void a(List r10, RetrofitMetrics r11) {
        if (f8143h != null) goto L5;
        return;
    L5:
        if (f8144i == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f8150c) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.f8153f) == true) goto L19;
        long r12 = SystemClock.uptimeMillis();
        r10.add(new a("x-bd-client-key", this.f8150c));
        r10.add(new a("x-bd-kmsv", this.f8153f));
        if (r11 == null) goto L18;
        r11.H = SystemClock.uptimeMillis() - r12;
        return;
    L18:
        return;
    }

    public void b(boolean r10) {
        f8145j = r10;
        f8143h = Keva.getRepo("ttnet_client_key_config", 1);     // Catch: Throwable -> L5
    L7:
        Keva r11 = f8143h;
        if (r11 != null) goto L10;
        return;
    L10:
        String r12 = r11.getString("client_key_config", "");
        if (TextUtils.isEmpty(r12) == true) goto L14;
        d(new JSONObject(r12));     // Catch: Throwable -> L34
    L14:
        if (f8144i == true) goto L16;
        return;
    L16:
        String r13 = f8143h.getString(CommonKey.KEY_SESSION_ID, "");
        long r14 = f8143h.getLong("session_time", 0);
        this.f8152e = f8143h.getString("session_url", "");
        this.f8150c = f8143h.getString("client_key", "");
        String r15 = f8143h.getString("kms_version", "");
        this.f8153f = r15;
        f8146k = i(this.f8150c, r15);
        if (r13.isEmpty() == false) goto L19;
        return;
    L19:
        if (this.f8152e.isEmpty() == true) goto L40;
        String[] r16 = r13.split(";");
        if (r16 == null) goto L27;
        if (r16.length <= 0) goto L27;
        this.f8151d = r16[0].trim();
    L27:
        if (TextUtils.isEmpty(this.f8151d) == false) goto L29;
        return;
    L29:
        String r17 = e(r16, r14, r13);
        if (TextUtils.isEmpty(r17) == true) goto L32;
        r13 = r17;
    L32:
        Logger.d(f8147l, "client key: " + this.f8150c + " | kms version: " + this.f8153f + " | session cookie: " + r13 + " | sessionid: " + this.f8151d + " | session time: " + r14 + " session url: " + this.f8152e + " config: " + r12);
        h(r13);
        return;
    L40:
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void c(String r10) {
        if (f8143h != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        JSONObject r11 = new JSONObject(r10).getJSONObject("data").optJSONObject("client_key_config");     // Catch: Throwable -> L13
        if (r11 != null) goto L11;
        Logger.d(f8147l, "clear client key storage.");     // Catch: Throwable -> L13
        f8144i = false;     // Catch: Throwable -> L13
        f8143h.clear();     // Catch: Throwable -> L13
        return;
    L11:
        String r12 = r11.toString();     // Catch: Throwable -> L13
        Logger.d(f8147l, "config: " + r12);     // Catch: Throwable -> L13
        f8143h.storeString("client_key_config", r12);     // Catch: Throwable -> L13
        d(r11);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    }

    public final void d(JSONObject r10) {
        int r11 = 0;
        if (r10.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r12 = true;
    L6:
        f8144i = r12;
        if (f8144i == true) goto L10;
        Logger.d(f8147l, "clear client key storage.");
        f8143h.clear();
        return;
    L10:
        this.f8148a.clear();
        String r13 = r10.optString("update_host_list", null);
        if (TextUtils.isEmpty(r13) == true) goto L19;
        JSONArray r14 = new JSONArray(r13);
        int r15 = 0;
    L14:
        if (r15 >= r14.length()) goto L19;
        String r16 = r14.getString(r15);
        if (TextUtils.isEmpty(r16) == true) goto L18;
        this.f8148a.add(r16);
    L18:
        r15 = r15 + 1;
    L19:
        this.f8149b.clear();
        String r17 = r10.optString("update_path_list", null);
        if (TextUtils.isEmpty(r17) == true) goto L28;
        JSONArray r18 = new JSONArray(r17);
    L23:
        if (r11 >= r18.length()) goto L35;
        String r19 = r18.getString(r11);
        if (TextUtils.isEmpty(r19) == true) goto L27;
        this.f8149b.add(r19);
    L27:
        r11 = r11 + 1;
        goto L23
    L35:
        return;
    L28:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void f(String r10) {
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L4
        r11.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r11.put("cookie_line", r10);     // Catch: Throwable -> L4
        r11.put(CommonKey.KEY_SESSION_ID, this.f8151d);     // Catch: Throwable -> L4
        r11.put("url", this.f8152e);     // Catch: Throwable -> L4
        TTNetInit.getTTNetDepend().monitorLogSend("cookie_mismatch", r11);     // Catch: Throwable -> L4
        return;
    }

    public synchronized void g(b r10, c r11) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (f8143h != null) goto L6;
    L75:
        monitor-exit(this);
        return;
    L6:
        if (f8144i == false) goto L75;
        long r12 = SystemClock.uptimeMillis();     // Catch: Throwable -> L24
        URI r13 = g.b(r10.D());     // Catch: Throwable -> L11
    L12:
        if (r13 != null) goto L14;
    L73:
        monitor-exit(this);
        return;
    L14:
        if (r13.getScheme().equals("https") == false) goto L73;
        if (this.f8148a.isEmpty() == true) goto L29;
        Iterator r14 = this.f8148a.iterator();     // Catch: Throwable -> L24
    L20:
        if (r14.hasNext() == false) goto L26;
        if (i.i(r13.getHost(), (String) r14.next()) == false) goto L20;
    L26:
        monitor-exit(this);
        return;
    L29:
        if (this.f8149b.isEmpty() == true) goto L71;
        Iterator r15 = this.f8149b.iterator();     // Catch: Throwable -> L24
    L32:
        if (r15.hasNext() == false) goto L71;
        if (i.i(r13.getPath(), (String) r15.next()) == false) goto L32;
        String r16 = "";
        String r17 = "";
        List r18 = r11.f("Set-Cookie");     // Catch: Throwable -> L24
        if (r18 != null) goto L38;
    L45:
        String[] r19 = r16.split(";");     // Catch: Throwable -> L24
        if (r19 == null) goto L51;
        if (r19.length <= 0) goto L51;
        r17 = r19[0].trim();     // Catch: Throwable -> L24
    L51:
        if (TextUtils.isEmpty(r17) == false) goto L54;
        monitor-exit(this);
        return;
    L54:
        String r20 = f8147l;     // Catch: Throwable -> L24
        Logger.d(r20, "original sessionid: " + this.f8151d + " new sessionid: " + r17);     // Catch: Throwable -> L24
        String r21 = "";
        String r22 = "";
        a r23 = r11.c("x-bd-lanusk");     // Catch: Throwable -> L24
        a r110 = r11.c("x-bd-lanusv");     // Catch: Throwable -> L24
        if (r23 == null) goto L63;
        if (r110 == null) goto L63;
        r21 = r23.b();     // Catch: Throwable -> L24
        r22 = r110.b();     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r21) == false) goto L60;
    L61:
        this.f8150c = "";     // Catch: Throwable -> L24
        this.f8153f = "";     // Catch: Throwable -> L24
    L65:
        this.f8150c = r21;     // Catch: Throwable -> L24
        this.f8153f = r22;     // Catch: Throwable -> L24
        String r111 = r10.D();     // Catch: Throwable -> L24
        this.f8152e = r111;     // Catch: Throwable -> L24
        this.f8151d = r17;     // Catch: Throwable -> L24
        f8143h.storeString("session_url", r111);     // Catch: Throwable -> L24
        f8143h.storeString(CommonKey.KEY_SESSION_ID, r16);     // Catch: Throwable -> L24
        f8143h.storeString("client_key", this.f8150c);     // Catch: Throwable -> L24
        f8143h.storeString("kms_version", this.f8153f);     // Catch: Throwable -> L24
        f8143h.storeLong("session_time", System.currentTimeMillis());     // Catch: Throwable -> L24
        f8146k = i(this.f8150c, this.f8153f);     // Catch: Throwable -> L24
        if (r10.y() == null) goto L68;
        r10.y().I = SystemClock.uptimeMillis() - r12;     // Catch: Throwable -> L24
    L68:
        Logger.d(r20, "save session url: " + this.f8152e + " session cookie: " + r16 + " client key: " + this.f8150c + " kms version: " + this.f8153f);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L60:
        if (TextUtils.isEmpty(r22) == false) goto L65;
    L63:
        if (r17.equals(this.f8151d) == false) goto L65;
        r21 = this.f8150c;     // Catch: Throwable -> L24
        r22 = this.f8153f;     // Catch: Throwable -> L24
        goto L65
    L38:
        if (r18.isEmpty() == true) goto L45;
        Iterator r24 = r18.iterator();     // Catch: Throwable -> L24
    L41:
        if (r24.hasNext() == false) goto L45;
        String r25 = ((a) r24.next()).b().trim();     // Catch: Throwable -> L24
        if (r25.toLowerCase().startsWith("sessionid=") == false) goto L41;
        r16 = r25;
    L71:
        monitor-exit(this);
        return;
    L11:
        r13 = null;
        goto L12
    }

    public final void h(String r10) {
        CookieHandler r11 = CookieHandler.getDefault();
        if (r11 != null) goto L23;
        return;
    L23:
        URI r12 = g.b(this.f8152e);     // Catch: Throwable -> L21
        if (r12 != null) goto L8;
        return;
    L8:
        Map<String, List<String>> r13 = r11.get(r12, null);     // Catch: Throwable -> L21
        if (r13 != null) goto L11;
    L22:
        return;
    L11:
        if (r13.isEmpty() == true) goto L22;
        if (r13.containsKey("Cookie") == false) goto L22;
        String r14 = r13.get("Cookie").toString();     // Catch: Throwable -> L21
        Logger.d(f8147l, "cookieStr: " + r14 + " sessionId: " + this.f8151d);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r14) == false) goto L17;
        k(r10, r11, r12);     // Catch: Throwable -> L21
        f("empty");     // Catch: Throwable -> L21
        goto L22
    L17:
        if (r14.contains(this.f8151d) == true) goto L22;
        k(r10, r11, r12);     // Catch: Throwable -> L21
        f(r14);     // Catch: Throwable -> L21
    }

    public final void k(String r10, CookieHandler r11, URI r12) {
        LinkedHashMap r13 = new LinkedHashMap();
        ArrayList r14 = new ArrayList();
        r14.add(r10);
        r13.put("Set-Cookie", r14);
        r11.put(r12, r13);
        Logger.d(f8147l, "Refresh session cookie: " + r10);
    }
}
