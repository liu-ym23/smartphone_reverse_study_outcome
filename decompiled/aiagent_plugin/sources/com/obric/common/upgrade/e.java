package com.obric.common.upgrade;

import android.app.Activity;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: AppUpgradeManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32625a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static e f32626e;
    private static boolean f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f32627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i f32628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f32629d;

    /* JADX INFO: compiled from: AppUpgradeManager.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final e a(Context r4, i r5) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r3, "context");
            o.e(r5, "config");
            if (e.e() == null) goto L5;
        L15:
            e r6 = e.e();
            o.a(r6);
            return r6;
        L5:
            monitor-enter(e.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (e.e() != null) goto L9;
            com.obric.common.upgrade.util.c.f32650a.b("init AppUpgradeManager");     // Catch: Throwable -> L12
            a r0 = e.f32625a;     // Catch: Throwable -> L12
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
            o.c(r7, "context.applicationContext");     // Catch: Throwable -> L12
            e.a(new e(r7, r5, null));     // Catch: Throwable -> L12
            a r8 = e.f32625a;     // Catch: Throwable -> L12
            e.a(true);     // Catch: Throwable -> L12
            com.obric.common.upgrade.util.c.f32650a.a(r5.f());     // Catch: Throwable -> L12
        L9:
            x r9 = x.f38692a;     // Catch: Throwable -> L12
            monitor-exit(e.class);
            goto L15
        }

        public final e a() {
            if (e.e() == null) goto L7;
            e r1 = e.e();
            o.a(r1);
            return r1;
        L7:
            throw new IllegalStateException("AppUpgradeManager 还未初始化，请先调用 init 方法。".toString());
        }

        public final boolean b() {
            return e.f();
        }
    }

    static {
        f32625a = new a(null);
    }

    public /* synthetic */ e(Context r2, i r3, d.h.b.h r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    /* JADX INFO: renamed from: lambda$ZOl9B4IhdLpa6cvF-BAHiIHOsNw, reason: not valid java name */
    public static /* synthetic */ void m938lambda$ZOl9B4IhdLpa6cvFBAHiIHOsNw(e r0, boolean r1, d.h.a.b r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$obA51XJF5EE5ZBiHZ-QtqtNO1uA, reason: not valid java name */
    public static /* synthetic */ void m939lambda$obA51XJF5EE5ZBiHZQtqtNO1uA(e r0, VersionCheckResponse r1, g r2) {
        a(r0, r1, r2);
    }

    private e(Context r3, i r4) {
        this.f32627b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f32628c = r4;
        this.f32629d = "obric_app_upgrade";
    }

    public static final /* synthetic */ void a(e r0) {
        f32626e = r0;
    }

    public static final /* synthetic */ void a(boolean r0) {
        f = r0;
    }

    public static final /* synthetic */ e e() {
        return f32626e;
    }

    public static final /* synthetic */ boolean f() {
        return f;
    }

    public final i a() {
        return this.f32628c;
    }

    public final boolean a(long r3) {
        return com.obric.common.upgrade.util.f.f32654a.a(this.f32627b, this.f32629d).a("ignored_version_codes_" + r3, false);
    }

    public final boolean b() {
        long r0 = com.obric.common.upgrade.util.f.f32654a.a(this.f32627b, this.f32629d).b("last_check_time", 0);
        if ((System.currentTimeMillis() - r0) <= (((long) (this.f32628c.k() * 60)) * 1000)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void c() {
        com.obric.common.upgrade.util.f.f32654a.a(this.f32627b, this.f32629d).a("last_check_tips_time", System.currentTimeMillis());
    }

    public final boolean d() {
        long r0 = com.obric.common.upgrade.util.f.f32654a.a(this.f32627b, this.f32629d).b("last_check_tips_time", 0);
        if ((System.currentTimeMillis() - r0) <= (((long) (this.f32628c.l() * 60)) * 1000)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void a(final boolean r6, d.h.a.b<? super VersionCheckResponse, x> r7) {
        final d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r8, "block");
        if (r6 == false) goto L5;
    L8:
        if (r6 == true) goto L14;
        if (b() == true) goto L14;
        com.obric.common.upgrade.util.c.f32650a.b("还未到时间，不检查. checkGap = " + this.f32628c.k() + " tipsGap = " + this.f32628c.l());
        r8.invoke(a(this, 0, 1, null));
        return;
    L14:
        if (com.obric.common.upgrade.a.a.f32592a.a().d() == false) goto L17;
        com.obric.common.upgrade.util.c.f32650a.b("上次check网络请求正在处理中，此次check请求抛弃");
        return;
    L17:
        if (r6 == true) goto L19;
        com.obric.common.upgrade.util.f.f32654a.a(this.f32627b, this.f32629d).a("last_check_time", System.currentTimeMillis());
    L19:
        com.obric.common.upgrade.util.h.f32659a.a(new $$Lambda$e$ZOl9B4IhdLpa6cvFBAHiIHOsNw(this, r6, r8));
        return;
    L5:
        if (com.obric.common.upgrade.util.d.f32652a.a(this.f32627b) == true) goto L8;
        com.obric.common.upgrade.util.c.f32650a.b("不是wifi网络，不检查");
        r8.invoke(a(this, 0, 1, null));
    }

    private static final void a(e r2, boolean r3, d.h.a.b r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        o.e(r5, "$block");
        r5.invoke(r2.a(r3, com.obric.common.upgrade.a.a.f32592a.a().c()));
    }

    public final VersionCheckResponse a(boolean r33, f r34) {
        long r6 = f32625a.a().a().c();
        if (r34 == null) goto L45;
        if (r34.a() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        f r3 = r34;
    L11:
        if (r3 == null) goto L45;
        c r4 = r3.b();
        if (r4 == null) goto L45;
        List<com.obric.common.upgrade.a> r5 = r4.a();
        if (r5 == null) goto L45;
        com.obric.common.upgrade.a r15 = (com.obric.common.upgrade.a) ZeusTransformUtils.preCheckCast(p.l(r5), com.obric.common.upgrade.a.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L45;
        if (r15.c() <= r6) goto L21;
        boolean r7 = true;
    L22:
        boolean r8 = a(r15.c());
        if (r33 == false) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r8 == false) goto L31;
        com.obric.common.upgrade.util.c.f32650a.b("用户忽略了" + r15.c() + "这一版本的升级，不提示");
    L31:
        if (r9 == true) goto L33;
        com.obric.common.upgrade.util.c.f32650a.b("用户之前点击了 稍后再试，间隔时间不够，不提示");
    L33:
        if (r7 == false) goto L37;
        if (r8 == true) goto L37;
        if (r9 == false) goto L37;
        com.obric.common.upgrade.d.a.a(com.obric.common.upgrade.d.a.f32620a.a(), 1, r15.e(), r6, r15.c(), null, 16, null);
        VersionCheckResponse r10 = new VersionCheckResponse(true, r15.c(), r15.d(), r15.a(), r15.b(), r15.f(), r15.g(), null, 0, false, r15.e(), 896, null);
    L43:
        if (r10 == null) goto L45;
        return r10;
    L37:
        if (r9 == true) goto L39;
        int r11 = -1;
    L40:
        if (r8 == false) goto L42;
        r11 = -2;
    L42:
        r10 = a(r11);
        goto L43
    L39:
        r11 = 0;
        goto L40
    L25:
        if (d() == true) goto L28;
        r9 = false;
        goto L29
    L21:
        r7 = false;
        goto L22
    L10:
        r3 = null;
        goto L11
    L7:
        r2 = false;
    L45:
        return a(this, 0, 1, null);
    }

    static /* synthetic */ VersionCheckResponse a(e r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return r0.a(r1);
    }

    private final VersionCheckResponse a(int r18) {
        return new VersionCheckResponse(false, -1, "", "", "", -1, null, null, r18, false, 0, 1728, null);
    }

    public final void a(boolean r3, final VersionCheckResponse r4, g r5) {
        final g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.aiagent.plugin");
        o.e(r4, "response");
        o.e(r6, "listener");
        if (r3 == true) goto L9;
        if (com.obric.common.upgrade.util.d.f32652a.a(this.f32627b) == true) goto L9;
        r6.a(-2, "不是wifi网络，不下载(暂时的策略，后期会修改)");
        return;
    L9:
        if (r4.getHasNewVersion() == true) goto L13;
        r6.a(-1, "没有新版本可下载");
        return;
    L13:
        if (com.obric.common.upgrade.b.a.f32601a.a() == false) goto L16;
        r6.a(-3, "当前正在下载，此次下载请求抛弃");
        return;
    L16:
        Runnable r7 = new $$Lambda$e$obA51XJF5EE5ZBiHZQtqtNO1uA(this, r4, r6);
        com.obric.common.upgrade.util.h.f32659a.a(r7);
    }

    private static final void a(e r2, VersionCheckResponse r3, g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        o.e(r3, "$response");
        o.e(r5, "$listener");
        com.obric.common.upgrade.b.a.f32601a.a(r2.f32627b, r3).a(r5);
    }

    public final void a(File r3, com.obric.common.upgrade.c.a r4) {
        com.obric.common.upgrade.c.a r5 = (com.obric.common.upgrade.c.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.upgrade.c.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "apkFile");
        o.e(r5, "installListener");
        com.obric.common.upgrade.c.b.f32608a.a(this.f32627b, r3, r5);
    }

    public final boolean a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return com.obric.common.upgrade.c.b.f32608a.a(r1);
    }

    public final void a(Activity r2, int r3) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        o.e(r1, "activity");
        com.obric.common.upgrade.c.b.f32608a.a(r1, r3);
    }

    public final Context getContext() {
        return this.f32627b;
    }
}
