package com.bytedance.crash.monitor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: InnerAppMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends com.bytedance.crash.monitor.a {
    private final ICommonParams n;
    private final b o;
    private final b p;
    private final b q;
    private String r;
    private boolean s;
    private int t;
    private Runnable u;

    /* JADX INFO: compiled from: InnerAppMonitor.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f7600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7601b;

        a(g r1) {
            this.f7600a = r1;
        }

        private long a() {
            int r0 = this.f7601b + 1;
            this.f7601b = r0;
            if (r0 <= 120) goto L7;
            return -1;
        L7:
            if (r0 >= 30) goto L10;
            return 2000;
        L10:
            if (r0 >= 60) goto L14;
            return 5000;
        L14:
            return 600000;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7600a.g != null) goto L6;
            this.f7600a.s();
        L6:
            if (this.f7600a.f7595e != null) goto L8;
        L15:
            this.f7600a.q();
        L17:
            if (this.f7600a.g != null) goto L19;
        L28:
            long r3 = a();
            if (r3 < 0) goto L33;
            DefaultWorkThread.postDelayed(this, r3);
            return;
        L33:
            return;
        L19:
            if (this.f7600a.f7595e == null) goto L28;
            if (this.f7600a.h == null) goto L28;
            if (g.d(this.f7600a) == null) goto L28;
            if (this.f7600a.i == null) goto L28;
            if (this.f7600a.j == 0) goto L28;
            return;
        L8:
            if (this.f7600a.h == null) goto L15;
            if (this.f7600a.i == null) goto L15;
            if (this.f7600a.j == 0) goto L15;
            if (g.d(this.f7600a) != null) goto L17;
            goto L15
        }
    }

    /* JADX INFO: compiled from: InnerAppMonitor.java */
    static class b {
        b() {
        }

        void a(long r1) {
            monitor-enter(this);
            wait(r1);     // Catch: Throwable -> L9
        L12:
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        void a() {
            monitor-enter(this);
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ int a(g r2) {
        int r0 = r2.t;
        r2.t = r0 - 1;
        return r0;
    }

    static /* synthetic */ int b(g r0) {
        return r0.t;
    }

    static /* synthetic */ Runnable c(g r0) {
        return r0.u;
    }

    static /* synthetic */ String d(g r0) {
        return r0.r;
    }

    static /* synthetic */ b e(g r0) {
        return r0.o;
    }

    static /* synthetic */ b f(g r0) {
        return r0.p;
    }

    static /* synthetic */ b g(g r0) {
        return r0.q;
    }

    g(ICommonParams r3) {
        ICommonParams r4 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r3, ICommonParams.class, "com.obric.aiagent.plugin");
        this.o = new b();
        this.p = new b();
        this.q = new b();
        this.t = 3;
        this.u = new AnonymousClass1(this);
        this.n = r4;
        DefaultWorkThread.post(new a(this));
        DefaultWorkThread.postDelayed(this.u, WsConstants.EXIT_DELAY_TIME);
    }

    void a(Map<String, Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (this.s == false) goto L6;
        return;
    L6:
        Object r7 = r6.get("app_start_time");     // Catch: Throwable -> L13
        if (r7 != null) goto L9;
        return;
    L9:
        long r0 = a(r7);     // Catch: Throwable -> L13
        if (r0 <= 0) goto L16;
        this.s = true;     // Catch: Throwable -> L13
        com.bytedance.crash.i.a(Long.valueOf(r0));     // Catch: Throwable -> L13
        return;
    L16:
        return;
    }

    void q() {
        Map<String, Object> r2 = this.n.getCommonParams();     // Catch: Throwable -> L59
        if (this.f7595e != null) goto L8;
        Object r3 = r2.get(WsConstants.KEY_APP_ID);     // Catch: Throwable -> L59
        if (r3 == null) goto L8;
        d(String.valueOf(r3));     // Catch: Throwable -> L59
    L8:
        a(r2);     // Catch: Throwable -> L59
        if (this.h != null) goto L15;
        Object r4 = r2.get("channel");     // Catch: Throwable -> L59
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L15;
        b((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L59
    L15:
        if (this.i != null) goto L17;
    L20:
        Object r5 = r2.get(WsConstants.KEY_APP_VERSION);     // Catch: Throwable -> L59
        Object r7 = r2.get("version_code");     // Catch: Throwable -> L59
        Object r8 = r2.get("version_name");     // Catch: Throwable -> L59
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L23;
        this.r = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
    L23:
        String r9 = this.r;     // Catch: Throwable -> L59
        if (r9 == null) goto L27;
        r5 = r9;
    L27:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == true) goto L30;
        return;
    L30:
        if (r7 != null) goto L32;
        PackageInfo r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName(), 128);     // Catch: Throwable -> L59
        Object r11 = Integer.valueOf(r10.versionCode);     // Catch: Throwable -> L59
    L33:
        long r12 = a(r2.get("manifest_version_code"));     // Catch: Throwable -> L59
        long r13 = a(r2.get("update_version_code"));     // Catch: Throwable -> L59
        if (r13 != 0) goto L46;
        if (r10 != null) goto L39;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName(), 128);     // Catch: Throwable -> L62
    L39:
        if (r10.applicationInfo.metaData == null) goto L41;
        Object r14 = r10.applicationInfo.metaData.get("UPDATE_VERSION_CODE");     // Catch: Throwable -> L62
    L42:
        if (r14 != null) goto L44;
        r14 = Long.valueOf(a(r2.get("version_code")));     // Catch: Throwable -> L62
    L44:
        r13 = a(r14);     // Catch: Throwable -> L62
        goto L46
    L41:
        r14 = null;
    L46:
        if (ZeusTransformUtils.instanceOf(r11, Long.class) == false) goto L48;
    L65:
        long r15 = a(r11);     // Catch: Throwable -> L56
        if (r12 > 0) goto L54;
        r12 = r15;
    L54:
        long r6 = r13;
        long r16 = r12;
        a(r15, r6, r16, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L56
    L71:
        return;
    L56:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);     // Catch: Throwable -> L59
        return;
    L48:
        if (ZeusTransformUtils.instanceOf(r11, Integer.class) == true) goto L65;
        if (ZeusTransformUtils.instanceOf(r11, String.class) == true) goto L65;
        return;
    L32:
        r11 = r7;
        r10 = null;
        goto L33
    L17:
        if (this.j == 0) goto L20;
        if (this.r == null) goto L20;
        return;
    L59:
        th = move-exception;
        r.b(th);
    }

    @Override // com.bytedance.crash.monitor.a, com.bytedance.crash.monitor.f
    public Map<String, Object> b() {
        ICommonParams r1 = this.n;
        HashMap r2 = null;
        if (r1 == null) goto L23;
        Map<String, Object> r3 = r1.getCommonParams();
        if (r3 == null) goto L12;
        r2 = new HashMap(r3);
        if (r2.containsKey("version_name") == true) goto L25;
    L11:
        r2.remove("release_build");
        goto L12
    L25:
        if (r2.containsKey(WsConstants.KEY_APP_VERSION) == true) goto L11;
        r2.put(WsConstants.KEY_APP_VERSION, r2.get("version_name"));     // Catch: Throwable -> L24
        r2.put("app_version_from_name", "1");     // Catch: Throwable -> L24
    L12:
        String r0 = this.n.getSessionId();
        long r4 = this.n.getUserId();
        if (r0 == null) goto L15;
    L16:
        if (r2 != null) goto L18;
        r2 = new HashMap();
    L18:
        if (r0 == null) goto L21;
        r2.put("session_id", r0);
    L21:
        if (r4 <= 0) goto L23;
        r2.put("user_id", Long.valueOf(r4));
        goto L23
    L15:
        if (r4 > 0) goto L16;
    L23:
        return r2;
    }

    private long a(Object r3) {
        if (r3 != null) goto L8;
        return 0;
    L8:
        return Long.parseLong(String.valueOf(r3));
    L7:
        return 0;
    }

    void r() {
        if (DefaultWorkThread.getThread() != Thread.currentThread()) goto L5;
        q();
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass2(this));
        this.o.a(200);
    }

    void s() {
        String r0 = this.n.getDeviceId();     // Catch: Throwable -> L6
        r.b("ConfigManager", "doUpdateDeviceId:" + r0);     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        c(r0);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
    }

    void t() {
        if (DefaultWorkThread.getThread() != Thread.currentThread()) goto L5;
        s();
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass3(this));
        this.p.a(100);
    }

    void u() {
        long r0 = this.n.getUserId();     // Catch: Throwable -> L6
        if (r0 == 0) goto L11;
        g(r0);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
    }

    void v() {
        if (DefaultWorkThread.getThread() != Thread.currentThread()) goto L5;
        u();
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass4(this));
        this.q.a(200);
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public String e() {
        if (this.f7595e != null) goto L6;
        r();
    L6:
        return super.e();
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public String f() {
        if (this.h != null) goto L6;
        r();
    L6:
        return super.f();
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public c h() {
        if (this.i != null) goto L5;
    L6:
        r();
    L8:
        return super.h();
    L5:
        if (this.j != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public long i() {
        if (this.i != null) goto L5;
    L6:
        r();
    L8:
        return super.i();
    L5:
        if (this.j != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public long j() {
        if (this.i != null) goto L5;
    L6:
        r();
    L8:
        return super.j();
    L5:
        if (this.j != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public long k() {
        if (this.i != null) goto L5;
    L6:
        r();
    L8:
        return super.k();
    L5:
        if (this.j != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public String l() {
        if (this.i != null) goto L5;
    L6:
        r();
    L8:
        return super.l();
    L5:
        if (this.j != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public String a(String r2) {
        if (TextUtils.isEmpty(this.g) == false) goto L6;
        t();
    L6:
        return super.a(r2);
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public long g() {
        if (this.f != 0) goto L6;
        v();
    L6:
        return super.g();
    }

    public void d(String r1) {
        this.f7595e = r1;
        this.f7579a.b(r1);
    }

    public void a(long r9, long r11, long r13, String r15) {
        this.l = r11;
        this.j = r9;
        this.i = r15;
        this.k = r13;
        this.f7579a.a(r9, r11, r13, r15);
        com.bytedance.crash.i.a(r9, r11, r13, r15);
    }
}
