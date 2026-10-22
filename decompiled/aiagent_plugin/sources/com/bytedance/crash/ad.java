package com.bytedance.crash;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.services.apm.api.IFdCheck;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: NpthCore.java */
/* JADX INFO: loaded from: classes.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7119a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f7120b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f7121c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7122d = false;

    /* JADX INFO: compiled from: NpthCore.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f7123a;

        static void a(Context r2, File r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (f7123a == null) goto L5;
            return;
        L5:
            monitor-enter(a.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f7123a != null) goto L9;
            f7123a = new a(r4, r3);     // Catch: Throwable -> L11
        L9:
            monitor-exit(a.class);     // Catch: Throwable -> L11
        }

        static void b(Context r2, File r3) {
            a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
        }

        static boolean a() {
            if (f7123a == null) goto L5;
            return true;
        L5:
            return false;
        }

        private a(Context r3, File r4) {
            c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
        }

        private void c(Context r3, File r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (com.bytedance.crash.crash.b.a(r4) == true) goto L5;
            ActivityLifecycle.c();
        L5:
            com.bytedance.crash.crash.b.a(r5, r4);
            com.bytedance.crash.c.a.a("Crash_Init");
            com.bytedance.crash.anr.e.a(r5, r4);
            com.bytedance.crash.c.a.a("Anr_Init");
            DefaultWorkThread.postAtFront(new AnonymousClass1(this));
            com.bytedance.crash.tracker.b.a().a(true);
            DefaultWorkThread.post(new AnonymousClass2(this));
            com.bytedance.crash.c.a.a("DefaultWorkThread_Init");
        }
    }

    /* JADX INFO: compiled from: NpthCore.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f7126a;

        static void a() {
            if (f7126a == null) goto L5;
            return;
        L5:
            monitor-enter(b.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f7126a != null) goto L9;
            f7126a = new b();     // Catch: Throwable -> L11
        L9:
            monitor-exit(b.class);     // Catch: Throwable -> L11
        }

        private b() {
            c();
        }

        private void c() {
            DefaultWorkThread.post(new AnonymousClass1(this));
        }

        static void b() {
            a();
        }
    }

    static {
    }

    public static void a(com.bytedance.crash.runtime.b r2) {
        com.bytedance.crash.runtime.b r3 = (com.bytedance.crash.runtime.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.runtime.b.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static void b(String r0) {
    }

    @Deprecated
    public static boolean f() {
        return false;
    }

    static /* synthetic */ void l() {
        n();
    }

    static /* synthetic */ void m() {
        o();
    }

    public static void a(Context r2, File r3) {
        a.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    public static void a() {
        b.b();
    }

    public static boolean b() {
        return a.a();
    }

    private static void n() {
        com.bytedance.crash.o.r.b("initAsyncForEvent");
        com.bytedance.crash.c.b.a();
        com.bytedance.crash.general.a.a();
        com.bytedance.crash.ensure.a.a();
    }

    private static void o() {
        com.bytedance.crash.o.r.b("initAsyncForCrash");
        com.bytedance.crash.m.a.a();
        n();
        com.bytedance.crash.tracker.c.a();
        com.bytedance.crash.crash.b.c();
        com.bytedance.crash.crash.b.d();
        com.bytedance.crash.j.b.a();
        com.bytedance.crash.applog.b.a();     // Catch: Throwable -> L9
    L19:
        ab.a();     // Catch: Throwable -> L10
    L13:
        y.a();     // Catch: Throwable -> L11
        com.bytedance.crash.alog.a.a();     // Catch: Throwable -> L11
    L15:
        ag.d();     // Catch: Throwable -> L12
    L7:
        com.bytedance.crash.i.a.a();
        com.bytedance.crash.upload.h.a();
        com.bytedance.news.common.service.manager.d.a(IFdCheck.class, new NpthCore$1());
        com.bytedance.crash.o.q.a().b();
    }

    public static void a(String r2, r r3) {
        com.bytedance.crash.anr.e.a(r2, (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin"));
    }

    public static boolean c() {
        if (b() == true) goto L7;
        return false;
    L7:
        return com.bytedance.crash.anr.e.d();
    }

    public static void a(String r1) {
        if (b() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        com.bytedance.crash.b.a.a(r1);
        return;
    }

    public static void a(String r2, Map<? extends String, ? extends String> r3, Map<String, String> r4, w r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        w r8 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
        if (b() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        com.bytedance.crash.b.a.a(r2, r6, r7, r8);
        return;
    }

    public static void a(String r1, String r2, String r3) {
        if (b() == true) goto L5;
        return;
    L5:
        com.bytedance.crash.e.a.a(r1, r2, r3);
    }

    @Deprecated
    public static void a(Throwable r0) {
        if (ac.a().isReportErrorEnable() == false) goto L4;
    }

    public static void d() {
        com.bytedance.crash.resource.b.a.g();
    }

    public static void a(u r2) {
        u r3 = (u) ZeusTransformUtils.wrapperContextForParams(r2, u.class, "com.obric.aiagent.plugin");
        if (b() == true) goto L5;
        return;
    L5:
        com.bytedance.crash.e.b.a(r3);
    }

    public static void e() {
        if (b() == true) goto L5;
        return;
    L5:
        com.bytedance.crash.anr.e.c();
    }

    public static void a(com.bytedance.crash.upload.f r2) {
        com.bytedance.crash.upload.b.a((com.bytedance.crash.upload.f) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.upload.f.class, "com.obric.aiagent.plugin"));
    }

    public static void a(String r2, com.bytedance.crash.alog.c r3, com.bytedance.crash.alog.d r4) {
        com.bytedance.crash.alog.c r5 = (com.bytedance.crash.alog.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.crash.alog.c.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.alog.d r6 = (com.bytedance.crash.alog.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.crash.alog.d.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (new File(r2).exists() == false) goto L9;
        com.bytedance.crash.alog.a.a(r2, r5, r6);
        return;
    }

    public static void a(o r2) {
        com.bytedance.crash.config.h.a((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.aiagent.plugin"));
    }

    public static boolean g() {
        return com.bytedance.crash.config.h.e();
    }

    public static void a(boolean r0) {
        f7119a = r0;
    }

    public static boolean h() {
        return f7119a;
    }

    static void a(int r0, String r1) {
        f7120b = r0;
        f7121c = r1;
    }

    public static int i() {
        return f7120b;
    }

    public static String j() {
        return f7121c;
    }

    public static int a(int r0) {
        return com.bytedance.crash.k.a.a(r0);
    }

    public static void b(boolean r0) {
        f7122d = r0;
    }

    public static boolean k() {
        return f7122d;
    }

    public static void c(boolean r0) {
        NativeBridge.d(r0);
    }
}
