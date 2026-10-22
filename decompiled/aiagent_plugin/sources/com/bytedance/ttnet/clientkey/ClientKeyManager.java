package com.bytedance.ttnet.clientkey;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.i.j;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.keva.Keva;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.b.b;
import com.bytedance.retrofit2.b.c;
import com.bytedance.retrofit2.b.d;
import com.bytedance.ttnet.a.e;
import com.bytedance.ttnet.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private static final String TAG = "ClientKeyManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ClientKeyManager f11403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Keva f11404b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f11405e = false;
    private static boolean j = true;
    private static Map<String, String> k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f11406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f11407d;
    private String f;
    private String g;
    private String h;
    private String i;
    private boolean l;

    static {
    }

    public static ClientKeyManager a() {
        if (f11403a != null) goto L15;
        monitor-enter(ClientKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11403a != null) goto L9;
        f11403a = new ClientKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ClientKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return f11403a;
    }

    private ClientKeyManager() {
        this.f11406c = new CopyOnWriteArrayList();
        this.f11407d = new CopyOnWriteArrayList();
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.l = true;
    }

    public void a(boolean r7) {
        j = r7;
        f11404b = Keva.getRepo("ttnet_client_key_config", 1);     // Catch: Throwable -> L5
    L7:
        Keva r8 = f11404b;
        if (r8 != null) goto L10;
        return;
    L10:
        String r9 = r8.getString("client_key_config", "");
        if (TextUtils.isEmpty(r9) == true) goto L14;
        a(new JSONObject(r9));     // Catch: Throwable -> L37
    L14:
        if (f11405e == true) goto L16;
        return;
    L16:
        String r0 = f11404b.getString("session_id", "");
        long r2 = f11404b.getLong("session_time", 0);
        this.h = f11404b.getString("session_url", "");
        this.f = f11404b.getString("client_key", "");
        String r1 = f11404b.getString("kms_version", "");
        this.i = r1;
        k = b(this.f, r1);
        if (r0.isEmpty() == false) goto L19;
        return;
    L19:
        if (this.h.isEmpty() == true) goto L43;
        String[] r3 = r0.split(";");
        if (r3 == null) goto L27;
        if (r3.length <= 0) goto L27;
        this.g = r3[0].trim();
    L27:
        if (TextUtils.isEmpty(this.g) == false) goto L29;
        return;
    L29:
        String r4 = a(r3, r2, r0);
        if (TextUtils.isEmpty(r4) == true) goto L33;
        r0 = r4;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "client key: " + this.f + " | kms version: " + this.i + " | session cookie: " + r0 + " | sessionid: " + this.g + " | session time: " + r2 + " session url: " + this.h + " config: " + r9);
    L35:
        a(r0);
        return;
    L43:
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    private static String a(String[] r10, long r11, String r13) {
        if (r10 != null) goto L5;
    L33:
        return null;
    L5:
        if (r10.length < 2) goto L33;
        long r3 = 0;
        if (r11 <= 0) goto L33;
        int r1 = r10.length;
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L18;
        String r7 = r10[r5];
        if (TextUtils.isEmpty(r7) == true) goto L17;
        if (r7.toLowerCase().trim().startsWith("Max-Age=".toLowerCase()) == false) goto L17;
        String[] r12 = r7.split("=");
    L19:
        if (r12 == null) goto L33;
        if (r12.length != 2) goto L33;
        long r2 = Long.parseLong(r12[1]);     // Catch: Throwable -> L34
        if (r2 > 0) goto L27;
        return null;
    L27:
        long r4 = r2 - ((System.currentTimeMillis() - r11) / 1000);     // Catch: Throwable -> L34
        if (r4 <= 0) goto L31;
        r3 = r4;
    L31:
        return r13.replaceFirst(r7.trim(), "Max-Age=" + r3);
    L17:
        r5 = r5 + 1;
        goto L11
    L18:
        r12 = null;
        r7 = null;
        goto L19
    }

    private void a(String r7) {
        CookieHandler r1 = CookieHandler.getDefault();
        if (r1 != null) goto L25;
        return;
    L25:
        URI r2 = j.a(this.h);     // Catch: Throwable -> L24
        if (r2 != null) goto L8;
        return;
    L8:
        Map<String, List<String>> r3 = r1.get(r2, null);     // Catch: Throwable -> L24
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.isEmpty() == false) goto L13;
        return;
    L13:
        if (r3.containsKey("Cookie") == false) goto L28;
        String r0 = ((List) ZeusTransformUtils.preCheckCast(r3.get("Cookie"), List.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L24
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "cookieStr: " + r0 + " sessionId: " + this.g);     // Catch: Throwable -> L24
    L18:
        if (TextUtils.isEmpty(r0) == false) goto L20;
        a(r7, r1, r2);     // Catch: Throwable -> L24
        a("empty", r7);     // Catch: Throwable -> L24
        return;
    L20:
        if (r0.contains(this.g) == true) goto L29;
        a(r7, r1, r2);     // Catch: Throwable -> L24
        a(r0, r7);     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L28:
        return;
    }

    private void a(String r3, CookieHandler r4, URI r5) {
        if (this.l == true) goto L5;
        return;
    L5:
        LinkedHashMap r2 = new LinkedHashMap();
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        r2.put("Set-Cookie", r0);
        r4.put(r5, r2);
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "Refresh session cookie: " + r3);
        return;
    }

    private void a(String r6, String r7) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L4
        r0.put("cookie_line", r6);     // Catch: Throwable -> L4
        r0.put("session_id", r7);     // Catch: Throwable -> L4
        r0.put("url", this.h);     // Catch: Throwable -> L4
        h.a("cookie_mismatch", r0);     // Catch: Throwable -> L4
        return;
    }

    public void a(List<b> r4, af r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (f11404b != null) goto L5;
        return;
    L5:
        if (f11405e == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.i) == true) goto L21;
        if (r5 == null) goto L13;
        r5.R();
    L13:
        r6.add(new b("x-bd-client-key", this.f));
        r6.add(new b("x-bd-kmsv", this.i));
        if (r5 == null) goto L20;
        r5.S();
        return;
    L20:
        return;
    }

    public synchronized void a(c r2, d r3) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (f11404b != null) goto L6;
    L22:
        monitor-exit(this);
        return;
    L6:
        if (f11405e == false) goto L22;
        if (r2.p() == null) goto L27;
        r2.p().V();     // Catch: Throwable -> L24
    L27:
        b(r2, r3);     // Catch: Throwable -> L17
    L13:
        if (r2.p() == null) goto L15;
        r2.p().W();     // Catch: Throwable -> L24
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        if (r2.p() == null) goto L21;
        r2.p().W();     // Catch: Throwable -> L24
    L21:
        throw th;     // Catch: Throwable -> L24
    }

    private void b(c r16, d r17) {
        URI r0 = j.a(r16.b());     // Catch: Throwable -> L5
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.f11406c.isEmpty() == true) goto L20;
        Iterator<String> r1 = this.f11406c.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (l.a(r0.getHost(), (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L12;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L20;
        return;
    L16:
        r2 = false;
    L20:
        if (this.f11407d.isEmpty() == true) goto L27;
        Iterator<String> r3 = this.f11407d.iterator();
    L23:
        if (r3.hasNext() == false) goto L27;
        if (l.a(r0.getPath(), (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L23;
        boolean r4 = true;
    L28:
        if (r4 == true) goto L30;
        return;
    L30:
        List<b> r5 = r17.b("Set-Cookie");
        if (r5 != null) goto L33;
    L40:
        String r11 = "";
    L41:
        String[] r6 = r11.split(";");
        if (r6 != null) goto L44;
    L46:
        String r12 = "";
    L48:
        if (TextUtils.isEmpty(r12) == false) goto L51;
        return;
    L51:
        if (Logger.debug() == false) goto L53;
        Logger.d(TAG, "original sessionid: " + this.g + " new sessionid: " + r12);
    L53:
        b r7 = r17.a("x-bd-lanusk");
        b r8 = r17.a("x-bd-lanusv");
        if (r7 == null) goto L64;
        if (r8 == null) goto L64;
        String r9 = r7.b();
        String r10 = r8.b();
        if (TextUtils.isEmpty(r9) == false) goto L59;
    L62:
        int r13 = 1;
    L67:
        String r14 = "";
        String r15 = r14;
    L68:
        if (r13 != 0) goto L75;
    L70:
        this.f = r14;
        this.i = r15;
        String r18 = r16.b();
        this.h = r18;
        this.g = r12;
        f11404b.storeString("session_url", r18);
        f11404b.storeString("session_id", r11);
        f11404b.storeString("client_key", this.f);
        f11404b.storeString("kms_version", this.i);
        f11404b.storeLong("session_time", System.currentTimeMillis());
        k = b(this.f, this.i);
        if (Logger.debug() == false) goto L88;
        Logger.d(TAG, "save session url: " + this.h + " session cookie: " + r11 + " client key: " + this.f + " kms version: " + this.i);
        return;
    L88:
        return;
    L75:
        a(r13, this.g, r12, this.f, r14, this.i, r15, r17, r0.getPath());     // Catch: Throwable -> L74
        goto L70
    L59:
        if (TextUtils.isEmpty(r10) == true) goto L62;
        r14 = r9;
        r15 = r10;
        r13 = 0;
    L64:
        if (r12.equals(this.g) == false) goto L66;
        String r19 = this.f;
        r15 = this.i;
        r13 = 2;
        r14 = r19;
        goto L68
    L66:
        r13 = 3;
        goto L67
    L44:
        if (r6.length <= 0) goto L46;
        r12 = r6[0].trim();
        goto L48
    L33:
        if (r5.isEmpty() == true) goto L40;
        Iterator<b> r20 = r5.iterator();
    L36:
        if (r20.hasNext() == false) goto L40;
        String r21 = ((b) ZeusTransformUtils.preCheckCast(r20.next(), b.class, "com.obric.aiagent.plugin")).b().trim();
        if (r21.toLowerCase().startsWith("sessionid=") == false) goto L36;
        r11 = r21;
    L27:
        r4 = false;
    L5:
        r0 = null;
        goto L6
    }

    private static String a(d r1, String r2) {
        b r3 = r1.a(r2);
        if (r3 != null) goto L5;
        return "";
    L5:
        return ("" + r3.toString()) + "; ";
    }

    private void a(int r2, String r3, String r4, String r5, String r6, String r7, String r8, d r9, String r10) {
        JSONObject r1 = new JSONObject();
        r1.put("origin_sid", r3);
        r1.put("sid", r4);
        r1.put("origin_key", r5);
        r1.put("key", r6);
        r1.put("origin_kms", r7);
        r1.put("kms", r8);
        if (r9 == null) goto L7;
        String r11 = ((a(r9, "x-tt-token") + a(r9, "x-tt-logid")) + a(r9, "x-bd-lanusk")) + a(r9, "x-bd-lanusv");
        if (TextUtils.isEmpty(r11) == true) goto L7;
        r1.put("headers", r11);
    L7:
        h.a("client_key", r1, r2, r10);
    }

    private void a(JSONObject r7) {
        int r1 = 0;
        boolean r2 = true;
        if (r7.optInt("client_key_sign_enabled", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        f11405e = r0;
        if (f11405e == true) goto L14;
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "clear client key storage.");
    L11:
        f11404b.clear();
        return;
    L14:
        if (r7.optInt("rewrite_session_enabled", 1) > 0) goto L17;
        r2 = false;
    L17:
        this.l = r2;
        this.f11406c.clear();
        String r3 = r7.optString("update_host_list", null);
        if (TextUtils.isEmpty(r3) == true) goto L26;
        JSONArray r4 = new JSONArray(r3);
        int r5 = 0;
    L21:
        if (r5 >= r4.length()) goto L26;
        String r6 = r4.getString(r5);
        if (TextUtils.isEmpty(r6) == true) goto L25;
        this.f11406c.add(r6);
    L25:
        r5 = r5 + 1;
    L26:
        this.f11407d.clear();
        String r8 = r7.optString("update_path_list", null);
        if (TextUtils.isEmpty(r8) == true) goto L35;
        JSONArray r9 = new JSONArray(r8);
    L30:
        if (r1 >= r9.length()) goto L42;
        String r10 = r9.getString(r1);
        if (TextUtils.isEmpty(r10) == true) goto L34;
        this.f11407d.add(r10);
    L34:
        r1 = r1 + 1;
        goto L30
    L42:
        return;
    L35:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void a(Object r6) {
        if (f11404b != null) goto L5;
        return;
    L5:
        if (e.a(r6) == false) goto L26;
        JSONObject r7 = e.b(r6);     // Catch: Throwable -> L23
        if (r7 == null) goto L11;
        JSONObject r8 = r7.getJSONObject("data").optJSONObject("client_key_config");     // Catch: Throwable -> L23
    L12:
        if (r8 == null) goto L14;
        String r1 = r8.toString();     // Catch: Throwable -> L23
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "config: " + r1);     // Catch: Throwable -> L23
    L21:
        f11404b.storeString("client_key_config", r1);     // Catch: Throwable -> L23
        a(r8);     // Catch: Throwable -> L23
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "clear client key storage.");     // Catch: Throwable -> L23
    L16:
        f11405e = false;     // Catch: Throwable -> L23
        f11404b.clear();     // Catch: Throwable -> L23
        return;
    L11:
        r8 = null;
        goto L12
    L27:
        return;
    }

    private static Map<String, String> b(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        HashMap r0 = new HashMap();
        r0.put("x-bd-client-key", r2);
        r0.put("x-bd-kmsv", r3);
        return r0;
    L11:
        return null;
    }

    public static Map<String, String> getClientKeyHeaders() {
        if (f11404b != null) goto L5;
        return null;
    L5:
        if (f11405e == true) goto L8;
        return null;
    L8:
        if (j == false) goto L12;
        return k;
    L12:
        return b(f11404b.getString("client_key", ""), f11404b.getString("kms_version", ""));
    }
}
