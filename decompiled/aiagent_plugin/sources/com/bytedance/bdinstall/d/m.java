package com.bytedance.bdinstall.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.bdinstall.ae;
import com.bytedance.bdinstall.am;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements com.bytedance.bdinstall.a.g {
    private static final AtomicBoolean n = null;
    private static final com.bytedance.bdinstall.j.r<i> t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f6225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final an f6226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, d> f6227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f6228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6229e;
    private com.bytedance.bdinstall.u f;
    private final j g;
    private volatile boolean h;
    private JSONObject i;
    private com.bytedance.bdinstall.h.i j;
    private boolean k;
    private boolean l;
    private final AtomicBoolean m;
    private com.bytedance.bdinstall.a.b o;
    private com.bytedance.bdinstall.j.b p;
    private com.bytedance.bdinstall.migrate.a q;
    private final com.bytedance.bdinstall.j.v r;
    private com.bytedance.bdinstall.a.d s;
    private int u;

    static {
        n = new AtomicBoolean(true);
        t = new AnonymousClass1();
    }

    public m(Context r4, an r5, com.bytedance.bdinstall.u r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f6227c = new LinkedHashMap(32);
        this.f6228d = new Object();
        this.f6229e = false;
        this.h = false;
        this.m = new AtomicBoolean(false);
        this.p = null;
        this.u = 0;
        this.f6225a = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.f = r6;
        this.f6226b = r5;
        this.i = new JSONObject();
        this.g = new j(r5);
        this.j = a(r7, r6);
        this.p = com.bytedance.bdinstall.l.a(String.valueOf(r5.a())).c();
        com.bytedance.bdinstall.w.c(r5.b(), new AnonymousClass2(this));
        this.r = new com.bytedance.bdinstall.j.v();
    }

    private com.bytedance.bdinstall.h.i a(Context r5, com.bytedance.bdinstall.u r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.bdinstall.g.c r0 = (com.bytedance.bdinstall.g.c) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.c.class, String.valueOf(this.f6226b.a())), com.bytedance.bdinstall.g.c.class, "com.obric.aiagent.plugin");
        com.bytedance.bdinstall.h.j r2 = new com.bytedance.bdinstall.h.j(r7, r6.a(this.f6226b), this.f6226b);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (com.bytedance.bdinstall.h.i) ZeusTransformUtils.preCheckCast(r0.a(com.bytedance.bdinstall.h.i.class, r2), com.bytedance.bdinstall.h.i.class, "com.obric.aiagent.plugin");
    }

    public void a() {
        if (this.m.getAndSet(true) == true) goto L6;
        com.bytedance.bdinstall.h.f.b(this.f6225a, this.f, this.f6226b);
        return;
    }

    public void a(com.bytedance.bdinstall.u r7, boolean r8) {
        this.f = r7;
        this.j = a(this.f6225a, r7);
        com.bytedance.bdinstall.h.f.b(this.f6225a, r7, this.f6226b);
        Map<Class<?>, d> r0 = this.f6227c;
        monitor-enter(r0);
        this.f6227c.put(y.class, new y(this.f6226b, r7));     // Catch: Throwable -> L10
        this.f6227c.put(n.class, new n(this.f6225a, this.f6226b, r7));     // Catch: Throwable -> L10
        this.f6227c.put(g.class, new g(this.f6225a, this.f6226b, r7));     // Catch: Throwable -> L10
        this.f6227c.put(f.class, new f(this.f6225a, this.f6226b));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        a(r7);
        if (r8 == false) goto L15;
        b();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void a(com.bytedance.bdinstall.a.d r3) {
        this.s = (com.bytedance.bdinstall.a.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdinstall.a.d.class, "com.obric.aiagent.plugin");
    }

    public void a(com.bytedance.bdinstall.a.b r1) {
        this.o = r1;
    }

    public void b() {
        e();
        com.bytedance.bdinstall.a.b r0 = this.o;
        if (r0 == null) goto L5;
        r0.b(new com.bytedance.bdinstall.a.a.a(d()));
    L5:
        l();
    }

    private void a(com.bytedance.bdinstall.u r3) {
        SharedPreferences r2 = r3.a(this.f6226b);
        if (r2 == null) goto L6;
        r2.edit().putLong("register_time", 0).apply();
        return;
    }

    public void c() {
        Context r0 = this.f6225a;
    L17:
        th = move-exception;
        monitor-enter(this.f6228d);
        this.h = true;     // Catch: Throwable -> L23
        this.f6228d.notifyAll();     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f6226b.T() == true) goto L6;
        com.bytedance.bdinstall.t.a("disable OneKeyMigrateDetect");     // Catch: Throwable -> L17
        boolean r2 = false;
    L7:
        if (r2 == true) goto L9;
        v.a(r0, this.f, this.f6226b);     // Catch: Throwable -> L17
    L9:
        Object r1 = this.f6228d;
        monitor-enter(r1);
        this.h = true;     // Catch: Throwable -> L14
        this.f6228d.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        r2 = b(r0, this.f);     // Catch: Throwable -> L17
        goto L7
    }

    private boolean b(Context r5, com.bytedance.bdinstall.u r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.bdinstall.migrate.a r0 = new com.bytedance.bdinstall.migrate.a(r7, this.f6226b);
        this.q = r0;
        boolean r1 = r0.b();
        com.bytedance.bdinstall.t.a("is one key migrate：" + r1);
        if (r1 == false) goto L5;
        com.bytedance.bdinstall.migrate.a.a(r7, this.f6226b, g(), true);
        t.a(r7, this.f6226b, r6);
    L5:
        this.q.a();
        return r1;
    }

    public JSONObject d() {
        return this.i;
    }

    private boolean a(d r3) {
        if (ba.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6226b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (com.bytedance.bdinstall.t.a() == false) goto L11;
        com.bytedance.bdinstall.t.a("needSyncFromSub " + r3 + " " + r2);
    L11:
        return r2;
    L5:
        if (r3.f6212d == false) goto L7;
        r2 = true;
        goto L9
    }

    public boolean e() {
        Map<Class<?>, d> r0 = this.f6227c;
        monitor-enter(r0);
    L65:
        th = move-exception;
        throw th;
    L5:
        if (this.f6229e == true) goto L7;
        this.f6229e = true;     // Catch: Throwable -> L65
        this.f6227c.put(g.class, new g(this.f6225a, this.f6226b, this.f));     // Catch: Throwable -> L65
        this.f6227c.put(w.class, new w(this.f6225a, this.f6226b));     // Catch: Throwable -> L65
        this.f6227c.put(y.class, new y(this.f6226b, this.f));     // Catch: Throwable -> L65
        this.f6227c.put(z.class, new z(this.f6225a));     // Catch: Throwable -> L65
        this.f6227c.put(f.class, new f(this.f6225a, this.f6226b));     // Catch: Throwable -> L65
        this.f6227c.put(c.class, new c(this.f6225a, this.f6226b));     // Catch: Throwable -> L65
        this.f6227c.put(b.class, new b(this.f6225a));     // Catch: Throwable -> L65
        this.f6227c.put(h.class, new h(this.f6226b));     // Catch: Throwable -> L65
        this.f6227c.put(ab.class, new ab(this.f6225a, this.f6226b));     // Catch: Throwable -> L65
        this.f6227c.put(l.class, new l(this.f6225a, this.f6226b));     // Catch: Throwable -> L65
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L65
        monitor-enter(m.class);
        JSONObject r1 = d();     // Catch: Throwable -> L62
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L62
        ba.a(r3, r1);     // Catch: Throwable -> L62
        com.bytedance.bdinstall.j.r<i> r2 = t;     // Catch: Throwable -> L62
        if (((i) ZeusTransformUtils.preCheckCast(r2.c(new Object[]{this.f6225a, this.f6226b, this.f}), i.class, "com.obric.aiagent.plugin")).a() == false) goto L13;
        ba.a(r3, ((i) ZeusTransformUtils.preCheckCast(r2.c(new Object[]{this.f6225a, this.f6226b, this.f}), i.class, "com.obric.aiagent.plugin")).b());     // Catch: Throwable -> L62
        boolean r4 = false;
    L14:
        Iterator<d> r5 = this.f6227c.values().iterator();     // Catch: Throwable -> L62
        boolean r6 = true;
        int r7 = 0;
        int r8 = 0;
    L16:
        if (r5.hasNext() == false) goto L50;
        d r9 = (d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L62
        if (r9.f6209a == true) goto L20;
    L72:
        r9.b(r3);     // Catch: SecurityException -> L25 JSONException -> L33 Throwable -> L62
        r9.f6209a = r9.a(r3);     // Catch: SecurityException -> L25 JSONException -> L33 Throwable -> L62
    L36:
        if (r9.f6209a == false) goto L38;
    L42:
        if (r9.f6209a == false) goto L44;
    L48:
        boolean r10 = true;
    L49:
        r6 = r6 & r10;     // Catch: Throwable -> L62
        goto L16
    L44:
        if (r9.f6210b == true) goto L48;
        if (r4 == false) goto L48;
        r10 = false;
        goto L49
    L38:
        if (r9.f6210b == true) goto L42;
        if (r4 == false) goto L42;
        r8 = r8 + 1;     // Catch: Throwable -> L62
    L33:
        e = move-exception;
        com.bytedance.bdinstall.t.a(e);     // Catch: Throwable -> L62
    L25:
        e = move-exception;
        if (r9.f6210b == true) goto L36;
        r7 = r7 + 1;     // Catch: Throwable -> L62
        com.bytedance.bdinstall.t.a("loadHeader, " + this.u, e);     // Catch: Throwable -> L62
        if (r9.f6209a == true) goto L36;
        if (this.u <= 10) goto L36;
        r9.f6209a = true;     // Catch: Throwable -> L62
        goto L36
    L20:
        if (r9.f6211c == true) goto L72;
        if (a(r9) == false) goto L42;
    L50:
        this.i = r3;     // Catch: Throwable -> L62
        this.k = r6;     // Catch: Throwable -> L62
        if (com.bytedance.bdinstall.t.a() == false) goto L53;
        com.bytedance.bdinstall.t.a("loadHeader, " + this.k + ", " + this.u + ", " + this.i);     // Catch: Throwable -> L62
    L54:
        if (r7 <= 0) goto L59;
        if (r7 != r8) goto L59;
        this.u++;     // Catch: Throwable -> L62
        if (f() == 0) goto L59;
        this.u += 10;     // Catch: Throwable -> L62
    L59:
        monitor-exit(m.class);     // Catch: Throwable -> L62
        return this.k;
    L53:
        com.bytedance.bdinstall.t.c("loadHeader, " + this.k + ", " + this.u, null);     // Catch: Throwable -> L62
        goto L54
    L13:
        r4 = true;
    L62:
        th = move-exception;
        throw th;
    }

    private String r() {
        return this.j.a("ssid");
    }

    public int f() {
        String r0 = d().optString("device_id", "");
        String r1 = d().optString("install_id", "");
        String r2 = d().optString("bd_did", "");
        if (ba.c(r0) == true) goto L7;
        if (ba.c(r2) == true) goto L7;
        return 0;
    L7:
        if (ba.c(r1) == true) goto L9;
        return 0;
    L9:
        if (com.bytedance.bdinstall.j.j.a(this.f6225a, this.f6226b).getLong("dr_install_vc", 0) != d().optLong("version_code", -1)) goto L11;
        return 1;
    L11:
        return 2;
    }

    public boolean a(String r5, Object r6) {
        Object r0 = d().opt(r5);
        if (r6 != null) goto L5;
    L6:
        if (r6 != null) goto L20;
        if (r0 == null) goto L20;
    L9:
        monitor-enter(m.class);
        JSONObject r2 = this.i;     // Catch: Throwable -> L12 JSONException -> L14
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L12 JSONException -> L14
        ba.a(r3, r2);     // Catch: Throwable -> L12 JSONException -> L14
        r3.put(r5, r6);     // Catch: Throwable -> L12 JSONException -> L14
        this.i = r3;     // Catch: Throwable -> L12 JSONException -> L14
    L16:
        monitor-exit(m.class);     // Catch: Throwable -> L12
        boolean r4 = true;
    L22:
        if (com.bytedance.bdinstall.t.a() == false) goto L24;
        com.bytedance.bdinstall.t.a("updateHeader, " + r5 + ", " + r0 + ", " + r6);
    L24:
        return r4;
    L12:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        com.bytedance.bdinstall.t.a(e);     // Catch: Throwable -> L12
    L20:
        r4 = false;
        goto L22
    L5:
        if (r6.equals(r0) == false) goto L9;
        goto L6
    }

    public String g() {
        com.bytedance.bdinstall.g.a r0 = (com.bytedance.bdinstall.g.a) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.a.class, this.f6226b.b()), com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        return r0.b();
    L7:
        return this.j.f("", "");
    }

    private String s() {
        return this.j.a("install_id");
    }

    private String t() {
        return com.bytedance.bdinstall.j.j.a(this.f6225a, this.f6226b).getString("clientudid", null);
    }

    private String u() {
        return com.bytedance.bdinstall.j.j.a(this.f6225a, this.f6226b).getString("openudid", null);
    }

    private String v() {
        return com.bytedance.bdinstall.j.j.a(this.f6225a, this.f6226b).getString("klink_egdi", null);
    }

    public am h() {
        Object r0 = this.f6228d;
        monitor-enter(r0);
        w();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        String r1 = g();
        String r2 = s();
        String r3 = u();
        String r4 = t();
        String r5 = r();
        String r7 = v();
        am r6 = new am();
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = "";
    L9:
        r6.a(r1);
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r2 = "";
    L12:
        r6.b(r2);
        r6.d(r4);
        r6.c(r3);
        r6.e(r5);
        r6.f(r7);
        return r6;
    L14:
        th = move-exception;
        throw th;
    }

    public JSONObject i() {
        if (this.k == true) goto L7;
        return null;
    L7:
        return d();
    }

    public boolean j() {
        if (com.bytedance.bdinstall.j.j.a(this.f6225a, this.f6226b).getLong("dr_install_vc", 0) == d().optLong("version_code", 0)) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(JSONObject r1, com.bytedance.bdinstall.u r2) {
        this.g.a(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void k() {
        am r0 = h();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.f();
    L6:
        if (r0 == null) goto L8;
        String r3 = r0.c();
    L9:
        if (r0 == null) goto L11;
        r1 = r0.g();
    L11:
        com.bytedance.bdinstall.j.b r4 = this.p;
        if (r4 == null) goto L14;
        r4.a(r2, r3, r1);
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r0.f()) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r0.c()) == true) goto L27;
        com.bytedance.bdinstall.a.b r5 = this.o;
        if (r5 == null) goto L26;
        r5.b(new com.bytedance.bdinstall.a.a.b(r0));
        return;
    L26:
        return;
    L27:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public void l() {
        am r0 = h();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r0.f()) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r0.c()) == true) goto L16;
        com.bytedance.bdinstall.a.b r2 = this.o;
        if (r2 == null) goto L15;
        r2.b(new com.bytedance.bdinstall.a.a.b(r0));
        return;
    L15:
        return;
    }

    private void w() {
    L3:
        if (this.h == true) goto L8;
        this.f6228d.wait();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        com.bytedance.bdinstall.t.a(e);
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r28v0, types: [com.bytedance.bdinstall.d.m] */
    @Override // com.bytedance.bdinstall.a.g
    public boolean a(com.bytedance.bdinstall.e.a r29, com.bytedance.bdinstall.u r30, com.bytedance.bdinstall.g.a r31) {
        com.bytedance.bdinstall.g.a r11 = (com.bytedance.bdinstall.g.a) ZeusTransformUtils.wrapperContextForParams(r31, com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin");
        JSONObject r13 = new JSONObject(r29.b());     // Catch: JSONException -> L5
    L8:
        if (r13 != null) goto L11;
        com.bytedance.bdinstall.t.a("onRegisterResult# response is null");
        return false;
    L11:
        String r0 = r13.optString("device_id_str", "");
        String r15 = r13.optString("install_id_str", "");
        String r9 = r13.optString("device_token", "");
        String r8 = r13.optString("ssid", "");
        String r1 = r13.optString("cd", "");
        String r7 = r13.optString("klink_egdi", "");
        if (r13.optInt("new_user", 0) <= 0) goto L14;
        boolean r2 = true;
    L15:
        this.l = r2;
        String r4 = r13.optString("klink_edi", "");
        String r5 = r13.optString("klink_eii", "");
        if (com.bytedance.bdinstall.t.a() == false) goto L18;
        com.bytedance.bdinstall.t.a("saveRegisterInfo, " + r0 + ", " + r15 + ", " + r8 + ", , " + r1 + ", " + r13);
    L18:
        boolean r16 = ba.c(r0);
        boolean r17 = ba.c(r15);
        ba.c(r1);
        boolean r25 = ba.c(r4);
        boolean r26 = ba.c(r5);
        boolean r18 = ba.c(r7);
        if (com.bytedance.bdinstall.i.f().f() == false) goto L25;
        if (r16 == false) goto L25;
        if (r18 == true) goto L25;
        com.bytedance.bdinstall.a.d r3 = this.s;
        if (r3 == null) goto L25;
        r3.onEgdiFailed();
    L25:
        SharedPreferences.Editor r6 = this.f6226b.v().edit();
        SharedPreferences r10 = com.bytedance.bdinstall.j.j.a(this.f6225a, this.f6226b);
        SharedPreferences.Editor r12 = r10.edit();
        boolean r19 = ba.c(r8);     // Catch: JSONException -> L163
        JSONObject r27 = r13;
        long r14 = r10.getLong("dr_install_vc", 0);     // Catch: JSONException -> L161
        long r110 = d().optLong("version_code", 0);     // Catch: JSONException -> L159
        if (r14 != r110) goto L182;
    L37:
        r12.putString("dr_channel", this.f6226b.k());     // Catch: JSONException -> L159
        r12.putString("dr_aid", String.valueOf(this.f6226b.a()));     // Catch: JSONException -> L159
        Pair<String, String> r20 = a(r0, r15, r4, r5, r25, r26, r29, r6);     // Catch: JSONException -> L159
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r20.first, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L40;
    L47:
        boolean r21 = r16;
        boolean r22 = r17;
        String r23 = r0;
        String r24 = r15;
        boolean r28 = false;
        boolean r32 = false;
    L48:
        if (r21 == false) goto L180;
        JSONObject r33 = r27;
    L196:
        String r34 = g();     // Catch: JSONException -> L157
        if (com.bytedance.bdinstall.t.a() == false) goto L186;
        com.bytedance.bdinstall.t.a("od=" + r34 + " nd=" + r23 + " ck=" + r21);     // Catch: JSONException -> L64
    L64:
        e = e;
    L58:
        r17 = r22;
        ?? r35 = r21;
    L36:
        boolean r111 = false;
        ?? r36 = r35;
    L166:
        com.bytedance.bdinstall.t.a(e);
        r22 = r17;
        ?? r37 = r36;
    L167:
        if (r37 == 0) goto L170;
        if (r22 == false) goto L170;
    L171:
        boolean r112 = true;
    L173:
        if (r112 == false) goto L177;
        com.bytedance.bdinstall.a.b r38 = this.o;
        if (r38 == null) goto L177;
        r38.b(new com.bytedance.bdinstall.a.a.e(r33));
    L177:
        return r112;
    L170:
        if ((r25 & r26) == true) goto L171;
        r112 = r111;
    L186:
        if (r21 == true) goto L200;
        boolean r210 = r21 ? 1 : 0;
        boolean r39 = r28;
    L191:
        String r40 = d().optString("install_id", "");     // Catch: JSONException -> L154
        if (r22 == true) goto L96;
    L105:
        if (r18 == true) goto L107;
    L110:
        r6.putString("device_id", r23);     // Catch: JSONException -> L154
        r6.putString("install_id", r24);     // Catch: JSONException -> L154
        String r211 = d().optString("ssid", "");     // Catch: JSONException -> L154
        if (r19 == true) goto L113;
    L116:
        boolean r113 = r32;
    L117:
        this.f6226b.a(r12);     // Catch: JSONException -> L154
        r12.apply();     // Catch: JSONException -> L154
        r6.apply();     // Catch: JSONException -> L154
        ((com.bytedance.bdinstall.r) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.r.class, String.valueOf(this.f6226b.a())), com.bytedance.bdinstall.r.class, "com.obric.aiagent.plugin")).a(r9, r30);     // Catch: JSONException -> L154
        if (TextUtils.equals(r23, r34) == false) goto L120;
    L122:
        boolean r41 = false;
    L124:
        if (TextUtils.equals(r24, r40) == false) goto L126;
    L128:
        boolean r42 = false;
    L129:
        if (r39 == false) goto L133;
        com.bytedance.bdinstall.a.b r43 = this.o;     // Catch: JSONException -> L103
        if (r43 == null) goto L133;
        r43.b(new com.bytedance.bdinstall.a.a.a(d()));     // Catch: JSONException -> L103
    L133:
        if (r41 == true) goto L137;
        if (r42 == true) goto L137;
        r111 = false;
    L140:
        com.bytedance.bdinstall.j.b r44 = this.p;     // Catch: JSONException -> L152
        if (r44 == null) goto L143;
        r44.a(r113, r34, r23, r40, r24, r211, r8);     // Catch: JSONException -> L152
    L143:
        com.bytedance.bdinstall.b.c r45 = com.bytedance.bdinstall.j.e.a().c(this.f6226b.a());     // Catch: JSONException -> L152
        if (r45 == null) goto L151;
        if (r41 == true) goto L147;
    L149:
        boolean r46 = r111;
    L150:
        r45.b(r46);     // Catch: JSONException -> L152
    L152:
        e = e;
    L156:
        r17 = r22;
        r36 = r210;
        goto L166
    L147:
        if (this.i.optBoolean("new_user_mode") == true) goto L149;
        r46 = true;
    L151:
        r37 = r210;
    L137:
        l();     // Catch: JSONException -> L154
        r111 = false;
        com.bytedance.bdinstall.migrate.a.a(this.f6225a, this.f6226b, null, false);     // Catch: JSONException -> L152
        goto L140
    L126:
        if (TextUtils.isEmpty(r24) == true) goto L128;
        r42 = true;
        goto L129
    L120:
        if (TextUtils.isEmpty(r23) == true) goto L122;
        r41 = true;
        goto L124
    L113:
        if (a("ssid", r8) == false) goto L116;
        this.j.a("ssid", r8);     // Catch: JSONException -> L103
        r39 = true;
        r113 = true;
        goto L117
    L107:
        if (a("klink_egdi", r7) == false) goto L110;
        this.j.a("klink_egdi", r7);     // Catch: JSONException -> L103
        com.bytedance.bdinstall.t.a("[egdi] no retry. direct cache egdi");     // Catch: JSONException -> L103
        r39 = true;
        r32 = true;
        goto L110
    L96:
        if (a("install_id", r24) == false) goto L105;
        this.j.a("install_id", r24);     // Catch: JSONException -> L103
        if (TextUtils.isEmpty(r40) == true) goto L102;
        JSONObject r47 = new JSONObject();     // Catch: JSONException -> L103
        r47.put("old_id", r40);     // Catch: JSONException -> L103
        r47.put("new_id", r24);     // Catch: JSONException -> L103
        ae r48 = this.f6226b.E();     // Catch: JSONException -> L103
        if (r48 == null) goto L102;
        r48.a("iid_change", r47);     // Catch: JSONException -> L103
    L102:
        r39 = true;
        r32 = true;
    L154:
        e = e;
        r111 = false;
        goto L156
    L200:
    L90:
        e = e;
        boolean r49 = r21 ? 1 : 0;
        goto L58
    L68:
        if (r23.equals(this.i.optString("device_id")) == false) goto L193;
        r39 = r28;
    L84:
        r210 = r21;
        if (r23.equals(r34) == true) goto L191;
        if (TextUtils.isEmpty(r34) == true) goto L89;
        a(r11, r23, r34);     // Catch: JSONException -> L103
    L89:
        r32 = true;
        r210 = r21;
        goto L191
    L193:
        monitor-enter(m.class);     // Catch: JSONException -> L90
        JSONObject r50 = this.i;     // Catch: Throwable -> L79
        JSONObject r51 = new JSONObject();     // Catch: Throwable -> L77
        ba.a(r51, r50);     // Catch: Throwable -> L77
        r51.put("device_id", r23);     // Catch: Throwable -> L77
        this.i = r51;     // Catch: Throwable -> L77
        monitor-exit(m.class);     // Catch: Throwable -> L77
        r11.a(r23);     // Catch: JSONException -> L103
        r39 = true;
        r32 = true;
    L79:
        th = th;
        boolean r52 = r21 ? 1 : 0;
    L81:
        monitor-exit(m.class);     // Catch: Throwable -> L77
        throw th;     // Catch: JSONException -> L103
    L77:
        th = th;
    L103:
        e = e;
        r17 = r22;
        r35 = r27;
    L157:
        e = e;
        boolean r53 = r21 ? 1 : 0;
        r111 = false;
        r17 = r22;
        r36 = r21;
        goto L166
    L180:
        JSONObject r54 = new JSONObject();     // Catch: JSONException -> L56
        r33 = r27;
        r54.put("response", r33);     // Catch: JSONException -> L64
        ae r55 = this.f6226b.E();     // Catch: JSONException -> L64
        if (r55 == null) goto L196;
        r55.a("tt_fetch_did_error", r54);     // Catch: JSONException -> L64
    L56:
        e = e;
        r33 = r27;
        goto L58
    L40:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r20.second, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L47;
        if (r16 == true) goto L45;
        if (r17 == true) goto L45;
        String r56 = (String) ZeusTransformUtils.preCheckCast(r20.first, String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L34
        String r57 = (String) ZeusTransformUtils.preCheckCast(r20.second, String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L34
        r16 = ba.c(r56);     // Catch: JSONException -> L34
        r17 = ba.c(r57);     // Catch: JSONException -> L34
    L46:
        r24 = r57;
        r23 = r56;
        r21 = r16;
        r22 = r17;
        r28 = true;
        r32 = true;
    L34:
        e = e;
        r33 = r27;
        r35 = 0;
    L45:
        r56 = r0;
        r57 = r15;
        goto L46
    L182:
        r12.putLong("dr_install_vc", r110);     // Catch: JSONException -> L34
    L159:
        e = e;
        r33 = r27;
        r111 = false;
    L165:
        r36 = r111;
    L161:
        e = e;
        r111 = false;
        r33 = r27;
    L163:
        e = e;
        r33 = r13;
        r111 = false;
        goto L165
    L14:
        r2 = false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r13 = null;
        goto L8
    }

    private Pair<String, String> a(String r17, String r18, String r19, String r20, boolean r21, boolean r22, com.bytedance.bdinstall.e.a r23, SharedPreferences.Editor r24) {
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r24, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        if (com.bytedance.bdinstall.i.f().c() == false) goto L5;
        String r6 = null;
        List<Map<String, String>> r7 = this.r.a(0, "ts_sign", r23.a().toString(), false, r23.a());     // Catch: Exception -> L39
        com.bytedance.bdinstall.b.d r8 = com.bytedance.bdinstall.j.e.a().e(this.f6226b.a());     // Catch: Exception -> L39
        if (TextUtils.isEmpty(r19) == false) goto L10;
    L16:
        String r9 = null;
    L48:
    L37:
        e = e;
    L41:
        e.printStackTrace();
    L43:
        return new Pair(r6, r9);
    L18:
        if (TextUtils.isEmpty(r17) == true) goto L28;
        if (TextUtils.isEmpty(r18) == true) goto L28;
        boolean r11 = r17.equals(r6);     // Catch: Exception -> L37
        boolean r12 = r18.equals(r9);     // Catch: Exception -> L37
        if (r11 == false) goto L25;
        if (r12 == false) goto L25;
        int r13 = 1;
    L26:
        r8.c(r13);     // Catch: Exception -> L37
        com.bytedance.bdinstall.t.a("TicketGuard# " + String.format("decrypt done: did %s, iid %s, decryptDid %s, decryptIid %s", new Object[]{r17, r18, r6, r9}));     // Catch: Exception -> L37
    L25:
        r13 = 2;
    L28:
        if (r21 == false) goto L33;
        if (r19.equals(this.i.optString("klink_edi")) == true) goto L33;
        this.i.put("klink_edi", r19);     // Catch: Exception -> L37
        this.j.a("klink_edi", r19);     // Catch: Exception -> L37
        com.bytedance.bdinstall.t.a("TicketGuard# update header encrypt did " + this.i.optString("klink_edi"));     // Catch: Exception -> L37
    L33:
        if (r22 == false) goto L35;
        this.i.put("klink_eii", r20);     // Catch: Exception -> L37
        this.j.a("klink_eii", r20);     // Catch: Exception -> L37
        com.bytedance.bdinstall.t.a("TicketGuard# update header encrypt iid " + this.i.optString("klink_eii"));     // Catch: Exception -> L37
    L35:
        r5.putString("klink_edi", r19);     // Catch: Exception -> L37
        r5.putString("klink_eii", r20);     // Catch: Exception -> L37
        this.r.a(r23, this.j, r7);     // Catch: Exception -> L37
        goto L43
    L10:
        if (TextUtils.isEmpty(r20) == true) goto L16;
        String r10 = this.r.a(Base64.decode(r19, 0));     // Catch: Exception -> L39
        r9 = this.r.a(Base64.decode(r20, 0));     // Catch: Exception -> L14
        r6 = r10;
    L14:
        e = e;
        r9 = null;
        r6 = r10;
    L39:
        e = e;
        r9 = null;
        goto L41
    L5:
        return new Pair("", "");
    }

    private void a(com.bytedance.bdinstall.g.a r4, String r5, String r6) {
        com.bytedance.bdinstall.g.a r7 = (com.bytedance.bdinstall.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin");
        String r0 = r7.a();
        JSONObject r1 = new JSONObject();
        r1.put("old_id", r6);
        r1.put("new_id", r5);
        if (this.f.d() == true) goto L5;
        r1.put("openudid", r7.a(true));
    L5:
        r1.put("clientudid", r0);
        ae r3 = this.f6226b.E();
        if (r3 == null) goto L9;
        r3.a("did_change", r1);
        return;
    }

    public boolean m() {
        return !TextUtils.equals(com.bytedance.bdinstall.j.j.a(this.f6225a, this.f6226b).getString("dr_channel", null), this.f6226b.k());
    }

    public boolean n() {
        return !TextUtils.equals(com.bytedance.bdinstall.j.j.a(this.f6225a, this.f6226b).getString("dr_aid", null), String.valueOf(this.f6226b.a()));
    }

    public void o() {
        com.bytedance.bdinstall.g.a r0 = (com.bytedance.bdinstall.g.a) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.a.class, String.valueOf(this.f6226b.a())), com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.c();
    L5:
        com.bytedance.bdinstall.n.a(this.f6225a, this.f6226b);
        com.bytedance.bdinstall.j.o.b();
    }

    public com.bytedance.bdinstall.u p() {
        return this.f;
    }

    public com.bytedance.bdinstall.j.v q() {
        return this.r;
    }
}
