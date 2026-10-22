package com.bytedance.frameworks.baselib.network.e;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.i.k;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.ies.common.cpp_shared.BuildConfig;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.e.j;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueryFilterEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String TAG = "QueryFilterEngine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f8075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f8076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f8077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<c> f8078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f8079e;
    private boolean f;
    private boolean g;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.e.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: QueryFilterEngine.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8080a = null;

        static {
            int[] r0 = new int[af.a.values().length];
            f8080a = r0;
            r0[af.a.f9445d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f8080a[af.a.f9444c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f8080a[af.a.f9443b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: compiled from: QueryFilterEngine.java */
    class a implements Comparator<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f8081a;

        a(d r1) {
            this.f8081a = r1;
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(c r3, c r4) {
            return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin"));
        }

        public int a(c r1, c r2) {
            return r1.a() - r2.a();
        }
    }

    public static d a() {
        if (f8075a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8075a != null) goto L9;
        f8075a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f8075a;
    }

    public void a(boolean r1) {
        this.f8077c = r1;
    }

    public void a(String r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onNetConfigChanged config: " + r3 + " enabled: " + this.f8077c);
    L6:
        if (this.f8077c == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L18;
        c(r3);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.f8079e.clear();
        JSONArray r0 = new JSONArray(r4);     // Catch: JSONException -> L11
        int r5 = 0;
    L8:
        if (r5 >= r0.length()) goto L17;
        String r1 = r0.getString(r5);     // Catch: JSONException -> L11
        this.f8079e.add(r1);     // Catch: JSONException -> L11
        r5 = r5 + 1;
        goto L8
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r10) {
        if (this.f8077c == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "Query filter engine is not enabled");
    L7:
        return null;
    L9:
        if (r10.t() == false) goto L11;
        return null;
    L11:
        String r1 = r10.b();
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return null;
    L15:
        if (r10.p() == null) goto L75;
        r10.p().au();
    L75:
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L64
        Pair<String, String> r2 = l.b(r1, r3);     // Catch: Throwable -> L64
        if (r2 != null) goto L24;
        if (r10.p() == null) goto L22;
        r10.p().av();
    L22:
        return null;
    L24:
        if (a(r10, r3) == true) goto L31;
        if (r10.p() == null) goto L28;
        r10.p().av();
    L28:
        return null;
    L31:
        if (r10.r() == true) goto L33;
    L39:
        String r9 = null;
    L40:
        k r0 = new k(((String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.aiagent.plugin")) + ((String) ZeusTransformUtils.preCheckCast(r2.second, String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L64
        if (r3.isEmpty() == true) goto L59;
        Iterator<Map.Entry<String, List<String>>> r4 = r3.entrySet().iterator();     // Catch: Throwable -> L64
    L44:
        if (r4.hasNext() == false) goto L59;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        if (r5 == null) goto L44;
        if (r5.getKey() == null) goto L44;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5.getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        if (r6 == null) goto L44;
        if (r6.isEmpty() == true) goto L44;
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L64
    L57:
        if (r7.hasNext() == false) goto L44;
        r0.a((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
    L59:
        com.bytedance.retrofit2.b.c.a r8 = r10.m();     // Catch: Throwable -> L64
        a(r8, r10, r9);     // Catch: Throwable -> L64
        r8.a(r0.a());     // Catch: Throwable -> L64
        com.bytedance.retrofit2.b.c r11 = r8.b();     // Catch: Throwable -> L64
        if (r10.p() == null) goto L63;
        r10.p().av();
    L63:
        return r11;
    L33:
        if (r3.containsKey("x-tt-encrypt-queries") == false) goto L39;
        List r12 = (List) ZeusTransformUtils.preCheckCast(r3.get("x-tt-encrypt-queries"), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        if (r12 == null) goto L39;
        if (r12.size() <= 0) goto L39;
        r9 = (String) ZeusTransformUtils.preCheckCast(r12.get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L64
        r3.remove("x-tt-encrypt-queries");     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L70
        if (r10.p() == null) goto L69;
        r10.p().av();
    L69:
        return null;
    L70:
        th = move-exception;
        if (r10.p() == null) goto L74;
        r10.p().av();
    L74:
        throw th;
    }

    private d() {
        this.f8077c = false;
        this.f8078d = new CopyOnWriteArrayList();
        this.f8079e = new CopyOnWriteArrayList();
        this.f = false;
        this.g = true;
    }

    private JSONArray a(List<com.bytedance.frameworks.baselib.network.e.a> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        JSONArray r0 = new JSONArray();
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L21;
        com.bytedance.frameworks.baselib.network.e.a r2 = (com.bytedance.frameworks.baselib.network.e.a) ZeusTransformUtils.preCheckCast(r13.next(), com.bytedance.frameworks.baselib.network.e.a.class, "com.obric.aiagent.plugin");
        long r3 = r2.a();     // Catch: JSONException -> L18
        if (this.g == false) goto L13;
        if (r2.b() == true) goto L13;
        if (r3 <= 0) goto L4;
    L13:
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L18
        r5.put("hit", r2.b());     // Catch: JSONException -> L18
        r5.put("priority", r2.c());     // Catch: JSONException -> L18
        if (r3 <= 0) goto L16;
        r5.put("consume", r3);     // Catch: JSONException -> L18
    L16:
        r0.put(r5);     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L21:
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "action info: " + r0.toString());
    L23:
        return r0;
    }

    private boolean a(com.bytedance.retrofit2.b.c r7, Map<String, List<String>> r8) {
        Map<String, List<String>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        boolean r2 = false;
        r7.b(0);
        Iterator<c> r3 = this.f8078d.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.aiagent.plugin")).a(r7, r9, r0) == false) goto L4;
        r2 = true;
        goto L4
    L9:
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "dispatchQueryMap hit: " + r2);
    L12:
        if (r7.p() == null) goto L14;
        r7.p().ag = a(r0);
    L14:
        return r2;
    }

    private synchronized void c(String r5) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.f8076b) == false) goto L6;
    L12:
        ArrayList<c> r0 = new ArrayList();     // Catch: Throwable -> L19
        JSONArray r1 = new JSONArray(r5);     // Catch: Throwable -> L19
        int r2 = 0;
    L14:
        if (r2 >= r1.length()) goto L16;
        a(r1.getJSONObject(r2), r0);     // Catch: Throwable -> L19
        r2 = r2 + 1;     // Catch: Throwable -> L19
        goto L14
    L16:
        Collections.sort(r0, new a(this));     // Catch: Throwable -> L19
        this.f8078d.clear();     // Catch: Throwable -> L19
        this.f8078d.addAll(r0);     // Catch: Throwable -> L19
        this.f8076b = r5;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L6:
        if (this.f8076b.equals(r5) == false) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "Config is same with local config, do not parse.");     // Catch: Throwable -> L19
    L10:
        monitor-exit(this);
    }

    private void a(JSONObject r4, ArrayList<c> r5) {
        String r3 = r4.getString("action");
        int r0 = r4.getInt("act_priority");
        if (r0 >= 0) goto L5;
        return;
    L5:
        JSONObject r1 = r4.getJSONObject(AutoTestConstant.PARAM);
        int r6 = r4.optInt("set_req_priority", r0);
        if (r6 != (-1)) goto L8;
        r6 = Integer.MAX_VALUE;
    L8:
        c r7 = c.a(r3, r0, r6, r1);
        if (r7 == null) goto L12;
        r5.add(r7);
        return;
    }

    private static void a(com.bytedance.retrofit2.b.c.a r5, com.bytedance.retrofit2.b.c r6, String r7) {
        if (ZeusTransformUtils.instanceOf(r6.d(), com.bytedance.retrofit2.e.a.class) == false) goto L7;
        boolean r0 = ((com.bytedance.retrofit2.e.a) ZeusTransformUtils.preCheckCast(r6.d(), com.bytedance.retrofit2.e.a.class, "com.obric.aiagent.plugin")).g();
        if (r0 == false) goto L9;
        Logger.i(TAG, "Request body has been encrypted before.");
    L9:
        if (r6.r() == false) goto L11;
    L14:
        ArrayList r2 = new ArrayList();
        if (TextUtils.isEmpty(r7) == true) goto L18;
        r2.add(new com.bytedance.retrofit2.b.b("x-tt-encrypt-queries", r7));
    L18:
        if (r6.c() == null) goto L20;
        r2.addAll(r6.c());
    L20:
        af r8 = r6.p();
        if (r0 == false) goto L23;
    L36:
        af.a r1 = af.a.f9442a;
        if (r0 == true) goto L39;
    L41:
        if (r0 == false) goto L44;
        a(r2, af.a.f9444c);
        r1 = af.a.f9444c;
    L46:
        if (r8 == null) goto L48;
        r8.a(r1);
    L48:
        r5.a(r2);
        return;
    L44:
        if (r6.r() == false) goto L46;
        a(r2, af.a.f9443b);
        r1 = af.a.f9443b;
        goto L46
    L39:
        if (r6.r() == false) goto L41;
        a(r2, af.a.f9445d);
        r1 = af.a.f9445d;
        goto L46
    L23:
        if (r6.s() == false) goto L36;
        j r3 = r6.d();
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.retrofit2.e.a.class) == false) goto L36;
        com.bytedance.retrofit2.e.a r4 = (com.bytedance.retrofit2.e.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.a.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L50;
        r8.ac();
    L50:
        r0 = r4.e();     // Catch: Throwable -> L32
        if (r8 == null) goto L36;
        r8.ad();
    L32:
        th = move-exception;
        if (r8 == null) goto L35;
        r8.ad();
    L35:
        throw th;
    L11:
        if (r6.s() == true) goto L14;
        if (r0 == true) goto L14;
        return;
    L7:
        r0 = false;
        goto L9
    }

    private static void a(List<com.bytedance.retrofit2.b.b> r4, af.a r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        int r7 = AnonymousClass1.f8080a[r5.ordinal()];
        if (r7 != 1) goto L5;
        r6.add(new com.bytedance.retrofit2.b.b("x-tt-cipher-version", BuildConfig.VERSION_NAME));
        r6.add(new com.bytedance.retrofit2.b.b("x-tt-encrypt-info", "2"));
        return;
    L5:
        if (r7 != 2) goto L7;
        r6.add(new com.bytedance.retrofit2.b.b("x-tt-cipher-version", BuildConfig.VERSION_NAME));
        r6.add(new com.bytedance.retrofit2.b.b("x-tt-encrypt-info", "1"));
        return;
    L7:
        if (r7 != 3) goto L15;
        r6.add(new com.bytedance.retrofit2.b.b("x-tt-cipher-version", BuildConfig.VERSION_NAME));
        r6.add(new com.bytedance.retrofit2.b.b("x-tt-encrypt-info", "0"));
        return;
    }

    static void a(JSONArray r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L13;
        if (r5 == null) goto L20;
        int r0 = 0;
    L15:
        if (r0 >= r3.length()) goto L22;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L14
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r5.add(r1);     // Catch: JSONException -> L14
    L12:
        r0 = r0 + 1;
        goto L15
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }
}
