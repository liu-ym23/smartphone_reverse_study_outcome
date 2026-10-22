package com.c.a;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.apm.h.e;
import com.bytedance.apm.util.aa;
import com.c.a.b.c;
import com.c.a.b.d;
import com.c.a.b.f;
import com.c.a.b.g;
import com.c.a.b.h;
import com.c.a.b.i;
import com.c.a.b.j;
import com.c.a.d.a.k;
import com.c.a.d.a.l;
import com.c.a.d.a.m;
import com.c.a.d.a.n;
import com.c.a.d.a.o;
import com.c.a.d.a.p;
import com.c.a.d.a.q;
import com.c.a.d.a.r;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CloudMessageManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Context f11877c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f11878d = null;
    private static h f = null;
    private static g g = null;
    private static com.c.a.b.a h = null;
    private static c i = null;
    private static f j = null;
    private static i k = null;
    private static j l = null;
    private static volatile boolean m = false;
    private static volatile boolean n = false;
    private static volatile String o = "";
    private static volatile String p = "";
    private static volatile String q = "";
    private static volatile String s = "";
    private static volatile String[] u;
    private static String v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Vector f11879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<com.c.a.d.b> f11880b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ExecutorService f11881e;
    private volatile HashMap<String, String> r;
    private volatile WeakReference<d> t;
    private long w;

    static {
    }

    static /* synthetic */ void a(a r0, com.c.a.c.a r1) {
        r0.a(r1);
    }

    static /* synthetic */ Context k() {
        return f11877c;
    }

    public static void a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        n = true;
        f11877c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        a();
        if (com.bytedance.apm.c.i() == false) goto L6;
        e.d("cloudmessage", new String[]{"CloudMessageManager Init."});
        return;
    }

    private a() {
        this.r = new HashMap();
        this.t = null;
        this.f11879a = new Vector(10);
        this.f11881e = (ExecutorService) ZeusTransformUtils.preCheckCast(AsyncTask.THREAD_POOL_EXECUTOR, ExecutorService.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList(20);
        r0.add(new com.c.a.d.a.f());
        r0.add(new com.c.a.d.a.c());
        r0.add(new q());
        r0.add(new com.c.a.d.a.j());
        r0.add(new o());
        r0.add(new r());
        r0.add(new com.c.a.d.a.d());
        r0.add(new p());
        r0.add(new m());
        r0.add(new com.c.a.d.a.h());
        r0.add(new com.c.a.d.a.b());
        r0.add(new com.c.a.d.a.a());
        r0.add(new l());
        r0.add(new n());
        r0.add(new com.c.a.d.a.g());
        r0.add(new com.c.a.d.a.i());
        r0.add(new com.c.a.d.a.e());
        r0.add(new k());
        this.f11880b = Collections.unmodifiableList(r0);
        l();
        m();
        s = b(f11877c).getAbsolutePath() + "/dump.hprof";     // Catch: Exception -> L5
        return;
    }

    public static a a() {
        if (f11878d != null) goto L19;
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f11878d == null) goto L9;
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (n == false) goto L12;
        f11878d = new a();     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("call CloudMessageManager.init() first");     // Catch: Throwable -> L15
    L19:
        return f11878d;
    }

    private void l() {
        h r0 = f;
        if (r0 == null) goto L5;
        a(r0);
        f = null;
    L5:
        g r1 = g;
        if (r1 == null) goto L8;
        a(r1);
        g = null;
    L8:
        com.c.a.b.a r2 = h;
        if (r2 == null) goto L11;
        a(r2);
        h = null;
    L11:
        c r3 = i;
        if (r3 == null) goto L14;
        b(r3);
        i = null;
    L14:
        f r4 = j;
        if (r4 == null) goto L17;
        b(r4);
        j = null;
    L17:
        i r5 = k;
        if (r5 == null) goto L20;
        a(r5);
        k = null;
    L20:
        j r6 = l;
        if (r6 == null) goto L24;
        a(r6);
        l = null;
        return;
    }

    public Context getContext() {
        return f11877c;
    }

    public static boolean b() {
        return m;
    }

    public Enumeration c() {
        return this.f11879a.elements();
    }

    public void a(final String r3) {
        this.f11881e.execute(new AnonymousClass1(this, r3));
    }

    private void a(com.c.a.c.a r5) {
        if (com.bytedance.apm.c.i() == false) goto L5;
        e.d("cloudmessage", new String[]{"handleCloudMessageInternal cloudMessage=" + r5});
    L5:
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.t != null) goto L10;
        d r0 = null;
    L11:
        if (r0 == null) goto L13;
        r0.a(r5);
    L13:
        Iterator<com.c.a.d.b> r4 = this.f11880b.iterator();
    L15:
        if (r4.hasNext() == false) goto L22;
        if (((com.c.a.d.b) ZeusTransformUtils.preCheckCast(r4.next(), com.c.a.d.b.class, "com.obric.aiagent.plugin")).a(r5) == false) goto L15;
        return;
    L22:
        return;
    L10:
        r0 = (d) ZeusTransformUtils.preCheckCast(this.t.get(), d.class, "com.obric.aiagent.plugin");
        goto L11
    }

    private void a(j r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Iterator<com.c.a.d.b> r3 = this.f11880b.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        com.c.a.d.b r0 = (com.c.a.d.b) ZeusTransformUtils.preCheckCast(r3.next(), com.c.a.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, r.class) == false) goto L6;
        ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L15:
        return;
    }

    private void a(i r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Iterator<com.c.a.d.b> r3 = this.f11880b.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        com.c.a.d.b r0 = (com.c.a.d.b) ZeusTransformUtils.preCheckCast(r3.next(), com.c.a.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, o.class) == false) goto L6;
        ((o) ZeusTransformUtils.preCheckCast(r0, o.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L15:
        return;
    }

    private void b(f r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Iterator<com.c.a.d.b> r3 = this.f11880b.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        com.c.a.d.b r0 = (com.c.a.d.b) ZeusTransformUtils.preCheckCast(r3.next(), com.c.a.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.c.a.d.a.h.class) == false) goto L6;
        ((com.c.a.d.a.h) ZeusTransformUtils.preCheckCast(r0, com.c.a.d.a.h.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static void a(f r2) {
        f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
        if (n == false) goto L5;
        a().b(r3);
        return;
    L5:
        j = r3;
    }

    private void b(c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Iterator<com.c.a.d.b> r3 = this.f11880b.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        com.c.a.d.b r0 = (com.c.a.d.b) ZeusTransformUtils.preCheckCast(r3.next(), com.c.a.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.c.a.d.a.b.class) == false) goto L6;
        ((com.c.a.d.a.b) ZeusTransformUtils.preCheckCast(r0, com.c.a.d.a.b.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static void a(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        if (n == false) goto L5;
        a().b(r3);
        return;
    L5:
        i = r3;
    }

    private void a(com.c.a.b.a r4) {
        com.c.a.b.a r5 = (com.c.a.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.c.a.b.a.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Iterator<com.c.a.d.b> r3 = this.f11880b.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        com.c.a.d.b r0 = (com.c.a.d.b) ZeusTransformUtils.preCheckCast(r3.next(), com.c.a.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.c.a.d.a.a.class) == false) goto L6;
        ((com.c.a.d.a.a) ZeusTransformUtils.preCheckCast(r0, com.c.a.d.a.a.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L15:
        return;
    }

    private void a(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Iterator<com.c.a.d.b> r3 = this.f11880b.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        com.c.a.d.b r0 = (com.c.a.d.b) ZeusTransformUtils.preCheckCast(r3.next(), com.c.a.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, l.class) == false) goto L6;
        ((l) ZeusTransformUtils.preCheckCast(r0, l.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L15:
        return;
    }

    private void a(h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Iterator<com.c.a.d.b> r3 = this.f11880b.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        com.c.a.d.b r0 = (com.c.a.d.b) ZeusTransformUtils.preCheckCast(r3.next(), com.c.a.d.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, n.class) == false) goto L6;
        ((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static String d() {
        return o;
    }

    public static void b(String r0) {
        o = r0;
    }

    public static String e() {
        return p;
    }

    public static String f() {
        return q;
    }

    public static String g() {
        return s;
    }

    public HashMap<String, String> h() {
        return this.r;
    }

    public static String[] i() {
        return u;
    }

    public static File b(Context r3) {
        File r0 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getExternalFilesDir(null) + "/monitor");
        if (r0.exists() == true) goto L5;
        r0.mkdir();
    L5:
        return r0;
    }

    private void m() {
        this.f11881e.execute(new AnonymousClass2(this));
    }

    public void j() {
        v = com.bytedance.apm.k.a.f4719c;
        long r3 = System.currentTimeMillis();
        if ((r3 - this.w) >= 120000) goto L6;
        e.d("cloudmessage", new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
        return;
    L6:
        this.w = r3;
        String r4 = aa.a("https://" + v + "/monitor/collect/c/cloudcontrol/get", com.bytedance.apm.c.o());     // Catch: Exception -> L53
        HashMap r5 = new HashMap();     // Catch: Exception -> L53
        r5.put(DownloadHelper.CONTENT_TYPE, "application/json");     // Catch: Exception -> L53
        r5.put("Version-Code", "1");     // Catch: Exception -> L53
        r5.put("Accept", "application/json");     // Catch: Exception -> L53
        com.bytedance.services.apm.api.c r1 = com.bytedance.apm.c.a(r4, com.bytedance.apm6.util.i.a(new JSONObject().toString()), r5);     // Catch: Exception -> L53
        int r6 = 0;
        if (com.bytedance.apm.c.i() == false) goto L10;
        e.d("cloudmessage", new String[]{"fetchCommandImmediately: url=" + r4});     // Catch: Exception -> L53
    L10:
        if (r1 != null) goto L14;
        e.d("cloudmessage", new String[]{"fetchCommandImmediately: res null"});     // Catch: Exception -> L53
        return;
    L14:
        if (r1.a() != 200) goto L64;
        JSONObject r7 = new JSONObject(new String(r1.b()));     // Catch: Exception -> L53
        if (com.bytedance.apm.c.i() == false) goto L18;
        e.d("cloudmessage", new String[]{"fetchCommandImmediately: resultMsg=" + r7.toString()});     // Catch: Exception -> L53
    L18:
        Map<String, String> r2 = r1.c();     // Catch: Exception -> L53
        String r8 = null;
        if (r2 != null) goto L21;
    L32:
        String r0 = r7.optString("data");     // Catch: Exception -> L53
        if (r0.isEmpty() == true) goto L39;
        if (TextUtils.isEmpty(r8) == true) goto L37;
        r7 = new JSONObject(com.bytedance.apm.util.c.a(r0.getBytes(), r8));     // Catch: Exception -> L53
        goto L39
    L37:
        r7 = new JSONObject(new String(r0.getBytes()));     // Catch: Exception -> L53
    L39:
        if (com.bytedance.apm.c.i() == false) goto L42;
        e.d("cloudmessage", new String[]{"fetchCommandImmediately resultMsg=" + r7});     // Catch: Exception -> L53
    L42:
        if (com.bytedance.apm.util.i.c(r7) == false) goto L44;
        return;
    L44:
        JSONObject r9 = r7.optJSONObject("configs");     // Catch: Exception -> L53
        if (com.bytedance.apm.util.i.c(r9) == false) goto L47;
        return;
    L47:
        JSONArray r10 = r9.optJSONArray("cloud_commands");     // Catch: Exception -> L53
        if (r10 != null) goto L50;
        return;
    L50:
        if (r6 >= r10.length()) goto L66;
        a(r10.optString(r6));     // Catch: Exception -> L53
        r6 = r6 + 1;
        goto L50
    L66:
        return;
    L21:
        if (r2.isEmpty() == true) goto L32;
        r8 = (String) ZeusTransformUtils.preCheckCast(r2.get("ran"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L53
        if (TextUtils.isEmpty(r8) == false) goto L32;
        Iterator<Map.Entry<String, String>> r11 = r2.entrySet().iterator();     // Catch: Throwable -> L56
    L27:
        if (r11.hasNext() == false) goto L32;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if ("ran".equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin")) == false) goto L27;
        r8 = (String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        goto L32
    L64:
        return;
    L53:
        e = move-exception;
        e.a("cloudmessage", e, new String[]{"fetchCommandImmediately error."});
    }
}
