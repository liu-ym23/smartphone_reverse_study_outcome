package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Oaid.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile j f6405c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f6406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f6407b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f6408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6409e;
    private final AtomicBoolean f;
    private Runnable g;
    private Future<m> h;
    private m i;
    private com.bytedance.bdinstall.a.b j;
    private an k;

    static /* synthetic */ m a(j r0) {
        return r0.g();
    }

    static /* synthetic */ Runnable a(j r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        r2.g = r4;
        return r4;
    }

    static /* synthetic */ Context b(j r0) {
        return r0.f6409e;
    }

    static /* synthetic */ an c(j r0) {
        return r0.k;
    }

    static /* synthetic */ m d(j r0) {
        return r0.i;
    }

    static /* synthetic */ com.bytedance.bdinstall.a.b e(j r0) {
        return r0.j;
    }

    static /* synthetic */ boolean f(j r0) {
        return r0.f6408d;
    }

    public static j a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f6405c != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6405c != null) goto L9;
        f6405c = new j(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f6405c;
    }

    public void a(com.bytedance.bdinstall.a.b r1) {
        this.j = r1;
    }

    public void a(an r1) {
        this.k = r1;
    }

    private j(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.f = new AtomicBoolean(false);
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f6409e = r0;
        k r1 = l.a(r6);
        this.f6406a = r1;
        if (r1 == null) goto L5;
        this.f6408d = r1.b(r6);
    L6:
        this.f6407b = new o(r0);
        return;
    L5:
        this.f6408d = false;
        goto L6
    }

    public void a() {
        if (this.f.compareAndSet(false, true) == false) goto L6;
        n.a();
        this.h = w.a(new AnonymousClass1(this));
        return;
    }

    private m g() {
        com.bytedance.bdinstall.t.a("Oaid#initOaid");
        n.b();
        com.bytedance.bdinstall.t.a("Oaid#initOaid exec");     // Catch: Throwable -> L14
        m r0 = this.f6407b.a();     // Catch: Throwable -> L14
        com.bytedance.bdinstall.t.a("Oaid#initOaid fetch=" + r0);     // Catch: Throwable -> L14
        if (r0 == null) goto L6;
        this.i = r0;     // Catch: Throwable -> L14
    L6:
        n.c();     // Catch: Throwable -> L14
        m r1 = a(this.f6409e, r0);     // Catch: Throwable -> L14
        n.d();     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        this.f6407b.a(r1);     // Catch: Throwable -> L14
    L9:
        if (r1 == null) goto L11;
        this.i = r1;     // Catch: Throwable -> L14
    L11:
        com.bytedance.bdinstall.t.a("Oaid#initOaid oaidModel=" + r1);     // Catch: Throwable -> L14
        n.e();
        this.g = new AnonymousClass2(this);
        h();
        return r1;
    L14:
        th = move-exception;
        n.e();
        this.g = new AnonymousClass2(this);
        h();
        throw th;
    }

    private synchronized void h() {
        monitor-enter(this);
        Runnable r0 = this.g;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.run();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void b() {
        h();
    }

    public Map<String, String> a(long r9) {
        Map<String, String> r3 = null;
        if (this.f6408d == true) goto L5;
        return null;
    L5:
        a();
        m r2 = this.i;
        if (r2 != null) goto L19;
        long r4 = SystemClock.elapsedRealtime();
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        com.bytedance.bdinstall.t.a("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
    L16:
        th = move-exception;
        com.bytedance.bdinstall.t.a("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        throw th;
    L9:
        if (ZeusTransformUtils.instanceOf(this.f6406a, f.class) == false) goto L11;
        r9 = r9 + 100;     // Catch: Throwable -> L13
    L11:
        com.bytedance.bdinstall.t.b("Oaid#getOaid timeoutMills=" + r9);     // Catch: Throwable -> L13
        m r10 = (m) ZeusTransformUtils.preCheckCast(this.h.get(r9, TimeUnit.MILLISECONDS), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        com.bytedance.bdinstall.t.a("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        r2 = r10;
    L19:
        if (r2 != null) goto L21;
        r2 = this.i;
    L21:
        if (r2 == null) goto L33;
        r3 = r2.a();
        if (this.k == null) goto L33;
        com.bytedance.bdinstall.b.b r11 = com.bytedance.bdinstall.j.e.a().b(this.k.a());
        if (r11 == null) goto L33;
        if (r2.f6416c != null) goto L29;
    L31:
        r11.c(0);
    L32:
        r11.b(!TextUtils.isEmpty(r2.f6414a) ? 1 : 0);
        r11.a(1);
        r11.a(n.k() - n.j());
        goto L33
    L29:
        if (r2.f6416c.booleanValue() == false) goto L31;
        r11.c(1);
    L33:
        an r8 = this.k;
        if (r8 == null) goto L36;
        com.bytedance.bdinstall.j.e.a(r8);
    L36:
        com.bytedance.bdinstall.t.b("Oaid#getOaid return apiMap=" + r3);
        return r3;
    }

    public String c() {
        a();
        m r2 = this.i;
        if (r2 == null) goto L5;
        String r3 = r2.f6414a;
    L6:
        com.bytedance.bdinstall.t.b("Oaid#getOaidId sOaidId=" + r3);
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public boolean d() {
        a();
        return this.f6408d;
    }

    private m a(Context r14, m r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        long r2 = SystemClock.elapsedRealtime();
        k r13 = this.f6406a;
        String r0 = null;
        if (r13 == null) goto L25;
        k.a r17 = r13.c(r16);
        if (r17 == null) goto L26;
        int r18 = -1;
        int r4 = 1;
        if (r15 == null) goto L14;
        r0 = r15.f6415b;
        if (r15.f != null) goto L11;
        int r19 = 0;
    L12:
        r18 = r19 + 1;
        goto L14
    L11:
        r19 = r15.f.intValue();
    L14:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        r0 = UUID.randomUUID().toString();
    L16:
        String r7 = r0;
        if (r18 <= 0) goto L20;
        r4 = r18;
    L20:
        long r110 = SystemClock.elapsedRealtime() - r2;
        long r3 = 0;
        if (ZeusTransformUtils.instanceOf(r17, e.a.class) == false) goto L24;
        r3 = ((e.a) ZeusTransformUtils.preCheckCast(r17, e.a.class, "com.obric.aiagent.plugin")).f6398a;
    L24:
        return new m(r17.f6412b, r7, Boolean.valueOf(r17.f6413c), Long.valueOf(r110), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r4), Long.valueOf(r3));
    L26:
        return null;
    L25:
        return null;
    }

    static void a(JSONObject r1, String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r3 == null) goto L13;
        r1.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    static <K, V> void a(Map<K, V> r2, K r3, V r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        r5.put(r3, r4);
        return;
    L8:
        return;
    }

    static boolean a(Context r2, String r3) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(r3, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public String e() {
        k r0 = this.f6406a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public void f() {
        this.f6407b.b();
    }
}
