package com.bytedance.crash.monitor;

import android.content.Context;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.ad;
import com.bytedance.crash.ah;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: MonitorManager.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f7602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.crash.d.e f7603b;

    public h() {
    }

    public static a a(Context r2, ICommonParams r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        ICommonParams r5 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r3, ICommonParams.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.i.b(r4);
        monitor-enter(a.class);
        a r1 = f7602a;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return r1;
    L8:
        g r6 = new g(r5);     // Catch: Throwable -> L15
        f7602a = r6;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        com.bytedance.crash.d.e r7 = f7603b;
        if (r7 == null) goto L13;
        r7.a(r6);
    L13:
        ad.a(r4, com.bytedance.crash.i.a(r4));
        return f7602a;
    L15:
        th = move-exception;
        throw th;
    }

    public static a a(Context r2, String r3, String r4, long r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.i.b(r6);
        monitor-enter(a.class);
        a r1 = f7602a;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return r1;
    L8:
        a r7 = new a(r3, r4, r5);     // Catch: Throwable -> L15
        f7602a = r7;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        com.bytedance.crash.d.e r8 = f7603b;
        if (r8 == null) goto L13;
        r8.a(r7);
    L13:
        com.bytedance.crash.h.a(r6, f7602a);
        return f7602a;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized f a(Context r11, String r12, long r13, long r15, String r17) {
        monitor-enter(h.class);
        com.bytedance.crash.i.b((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        final f r0 = new f(r12, r17, r13, r15, 0);     // Catch: Throwable -> L7
        ad.a();     // Catch: Throwable -> L7
        DefaultWorkThread.post(new AnonymousClass1(r0));     // Catch: Throwable -> L7
        monitor-exit(h.class);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public static i a(Context r8, String r9, String r10, long r11, String[] r13, String[] r14) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.i.b(r12);
        i r7 = new i(r9, r10, r11, r13, r14);
        com.bytedance.crash.h.b(r12, r7);
        return r7;
    }

    public static a a() {
        return f7602a;
    }

    public static com.bytedance.crash.d.e b() {
        if (f7603b != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7603b != null) goto L9;
        f7603b = new com.bytedance.crash.d.e(f7602a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f7603b;
    }

    public static String c() {
        a r0 = f7602a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    public static ArrayList<d> d() {
        return d.d();
    }

    public static ah e() {
        return a.a();
    }
}
