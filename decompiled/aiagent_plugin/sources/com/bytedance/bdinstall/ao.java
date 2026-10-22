package com.bytedance.bdinstall;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: InstallServiceImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class ao implements com.bytedance.bdinstall.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f6123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile an f6124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile InstallDispatcher f6125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile com.bytedance.bdinstall.d.m f6126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile com.bytedance.bdinstall.a.b f6127e;
    private final AtomicBoolean f;
    private aa g;

    @Override // com.bytedance.bdinstall.g.b
    public void a(am r1) {
    }

    static /* synthetic */ InstallDispatcher a(ao r0) {
        return r0.f6125c;
    }

    static /* synthetic */ void a(ao r0, boolean r1) {
        r0.a(r1);
    }

    static /* synthetic */ com.bytedance.bdinstall.d.m b(ao r0) {
        return r0.f6126d;
    }

    static /* synthetic */ AtomicBoolean c(ao r0) {
        return r0.f;
    }

    static /* synthetic */ void d(ao r0) {
        r0.f();
    }

    static {
        f6123a = new AtomicBoolean(false);
    }

    ao(aa r3) {
        aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.aiagent.plugin");
        this.f = new AtomicBoolean(false);
        this.g = r4;
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(an r9, u r10) {
        long r0 = System.currentTimeMillis();
        t.a("main process install#init：aid: " + r9.a());
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f6125c != null) goto L12;
        this.f6124b = r9;     // Catch: Throwable -> L15
        if (TextUtils.equals(r9.k(), "local_test") == true) goto L18;
    L11:
        this.f6126d = new com.bytedance.bdinstall.d.r((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9, r10);     // Catch: Throwable -> L15
        this.f6126d.a(this.f6127e);     // Catch: Throwable -> L15
        this.f6125c = new InstallDispatcher(r9, this.f6126d, i.c(), r10);     // Catch: Throwable -> L15
        this.f6125c.setCallbackCenter(this.f6127e);     // Catch: Throwable -> L15
        this.f6126d.a(this.f6125c);     // Catch: Throwable -> L15
        com.bytedance.bdinstall.g.d.a(r.class, new s(r9, r10), String.valueOf(r9.a()));     // Catch: Throwable -> L15
        goto L12
    L18:
        com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.c.class, (com.bytedance.bdinstall.g.c) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bytedance.bdinstall.nu.NUModeServiceImpl", "com.obric.aiagent.plugin").getConstructor(new Class[]{an.class}).newInstance(new Object[]{r9}), com.bytedance.bdinstall.g.c.class, "com.obric.aiagent.plugin"), String.valueOf(r9.a()));     // Catch: Throwable -> L10
    L10:
        t.c("not find new user mode impl ,ignore");     // Catch: Throwable -> L15
    L12:
        monitor-exit(this);     // Catch: Throwable -> L15
        t.a("init ：" + (System.currentTimeMillis() - r0));
    }

    public void a(com.bytedance.bdinstall.a.b r1) {
        this.f6127e = r1;
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a() {
        if (g() == false) goto L9;
        if (this.f6124b == null) goto L9;
        t.a("install#start aid : " + this.f6124b.a());
        w.c(this.f6124b.b(), new AnonymousClass1(this));
        f();
        return;
    L9:
        throw new RuntimeException("please init first");
    }

    private void f() {
        if (com.bytedance.bdinstall.j.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6124b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f6124b).getBoolean("_install_started_v2", false) == true) goto L6;
        com.bytedance.bdinstall.j.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6124b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f6124b).edit().putBoolean("_install_started_v2", true).apply();
        return;
    }

    public void a(Application r3) {
        Application r2 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        return;
    L6:
        if (f6123a.compareAndSet(false, true) == false) goto L9;
        i.a(r2);
        return;
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(final u r3) {
        t.a("install#clearInstallInfoWhenSwitchChildMode");
        if (this.f6125c != null) goto L5;
    L9:
        t.a(new RuntimeException("not init yet"));
        return;
    L5:
        if (this.f6124b == null) goto L9;
        if (this.f6126d == null) goto L9;
        t.a("clearInstallInfoWhenSwitchChildMode " + r3);
        w.c(this.f6124b.b(), new AnonymousClass2(this, r3));
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(Context r3, final u r4, long r5, as r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        as r8 = (as) ZeusTransformUtils.wrapperContextForParams(r7, as.class, "com.obric.aiagent.plugin");
        t.a("install#resetInstallInfoWhenSwitchChildMode");
        if (this.f6125c == null) goto L7;
        t.a("resetInstallInfoWhenSwitchChildMode " + r4);
        com.bytedance.bdinstall.j.w r9 = new com.bytedance.bdinstall.j.w(r5, r8, this.f6124b);
        this.g.a(false, r9);
        r9.a();
        if (this.f6124b == null) goto L9;
        w.c(this.f6124b.b(), new AnonymousClass3(this, r4));
        return;
    L9:
        return;
    L7:
        t.a(new RuntimeException("not init yet"));
    }

    @Override // com.bytedance.bdinstall.g.b
    public void b(final u r3) {
        t.a("install#changeUriRuntimeAndReInstall");
        if (this.f6125c != null) goto L5;
    L7:
        t.a(new RuntimeException("not init yet"));
        return;
    L5:
        if (this.f6124b == null) goto L7;
        t.a("changeUriRuntimeAndReInstall " + r3);
        w.c(this.f6124b.b(), new AnonymousClass4(this, r3));
    }

    @Override // com.bytedance.bdinstall.g.b
    public am b() {
        if (this.f6126d != null) goto L7;
        return null;
    L7:
        return this.f6126d.h();
    }

    @Override // com.bytedance.bdinstall.g.b
    public String c() {
        if (this.f6126d != null) goto L7;
        return null;
    L7:
        return this.f6126d.g();
    }

    private boolean g() {
        if (this.f6125c == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void a(boolean r4) {
        if (g() == false) goto L15;
        if (this.f6124b == null) goto L15;
        if (this.f.getAndSet(true) == false) goto L9;
        return;
    L9:
        com.bytedance.bdinstall.g.c r0 = (com.bytedance.bdinstall.g.c) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.c.class, this.f6124b.b()), com.bytedance.bdinstall.g.c.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L12;
        r0.b();
    L12:
        this.f6126d.a();
        this.f6125c.start(r4);
        at r5 = new at((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6124b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r5.a(this.f6124b);
        r5.a();
        return;
    L15:
        throw new RuntimeException("please init first");
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(Context r6, Map<String, Object> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (this.f6126d == null) goto L21;
        Iterator r10 = r9.entrySet().iterator();
    L5:
        boolean r0 = false;
    L7:
        if (r10.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (this.f6126d.a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue()) == true) goto L11;
        if (r0 == false) goto L5;
    L11:
        r0 = true;
        goto L7
    L12:
        if (r0 == true) goto L14;
        return;
    L14:
        if (this.f6127e == null) goto L23;
        this.f6127e.b(new com.bytedance.bdinstall.a.a.a(this.f6126d.d()));
        return;
    L23:
        return;
    }

    @Override // com.bytedance.bdinstall.g.b
    public void a(Context r6, Map<String, String> r7, boolean r8, boolean r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        SharedPreferences r12 = com.bytedance.bdinstall.j.j.a(r10, this.f6124b);
        if (r8 == false) goto L5;
        SharedPreferences.Editor r13 = r12.edit();
    L6:
        boolean r0 = false;
        if (this.f6126d == null) goto L22;
        Iterator r14 = r11.entrySet().iterator();
        boolean r15 = false;
    L10:
        if (r14.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin");
        if (this.f6126d.a(r3, r4) == true) goto L16;
        if (r15 == true) goto L16;
        r15 = false;
    L17:
        if (r13 == null) goto L10;
        r13.putString(r3, r4);
    L16:
        r15 = true;
        goto L17
    L19:
        if (r13 == null) goto L21;
        r13.apply();
    L21:
        r0 = r15;
    L22:
        if (r0 == false) goto L27;
        if (r9 == false) goto L27;
        if (this.f6125c == null) goto L27;
        this.f6125c.redoRegister();
    L27:
        if (r0 == true) goto L29;
        return;
    L29:
        if (this.f6127e == null) goto L38;
        this.f6127e.b(new com.bytedance.bdinstall.a.a.a(this.f6126d.d()));
        return;
    L38:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.bdinstall.g.b
    public boolean d() {
        t.a("install#activeManually");
        if (g() == true) goto L5;
        return false;
    L5:
        if (this.f6124b == null) goto L10;
        w.c(this.f6124b.b(), new AnonymousClass5(this));
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.bdinstall.g.b
    public boolean a(JSONObject r2) {
        if (this.f6126d == null) goto L8;
        JSONObject r1 = this.f6126d.i();
        if (r1 == null) goto L10;
        ba.a(r2, r1);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.bytedance.bdinstall.g.b
    public u e() {
        if (this.f6126d != null) goto L7;
        return null;
    L7:
        return this.f6126d.p();
    }
}
