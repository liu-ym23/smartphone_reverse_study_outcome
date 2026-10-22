package com.bytedance.bdinstall;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: ExecutorUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Executor> f6452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, ExecutorService> f6453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, Looper> f6454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, Handler> f6455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.bytedance.bdinstall.j.r<Executor> f6456e = null;
    private static final com.bytedance.bdinstall.j.r<ExecutorService> f = null;
    private static final com.bytedance.bdinstall.j.r<Looper> g = null;
    private static final com.bytedance.bdinstall.j.r<Handler> h = null;

    static /* synthetic */ com.bytedance.bdinstall.j.r b() {
        return g;
    }

    static {
        f6452a = new ConcurrentHashMap(4);
        f6453b = new ConcurrentHashMap(4);
        f6454c = new ConcurrentHashMap(4);
        f6455d = new ConcurrentHashMap(4);
        f6456e = new AnonymousClass1();
        f = new AnonymousClass2();
        g = new AnonymousClass3();
        h = new AnonymousClass4();
    }

    private static Executor c(String r3) {
        if (r3 == null) goto L9;
        Executor r4 = (Executor) ZeusTransformUtils.preCheckCast(f6452a.get(r3), Executor.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        return r4;
    L8:
        return (Executor) ZeusTransformUtils.preCheckCast(f6456e.c(new Object[0]), Executor.class, "com.obric.aiagent.plugin");
    L9:
        return (Executor) ZeusTransformUtils.preCheckCast(f6456e.c(new Object[0]), Executor.class, "com.obric.aiagent.plugin");
    }

    private static ExecutorService d(String r3) {
        if (r3 == null) goto L9;
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.preCheckCast(f6453b.get(r3), ExecutorService.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        return r4;
    L8:
        return (ExecutorService) ZeusTransformUtils.preCheckCast(f.c(new Object[0]), ExecutorService.class, "com.obric.aiagent.plugin");
    L9:
        return (ExecutorService) ZeusTransformUtils.preCheckCast(f.c(new Object[0]), ExecutorService.class, "com.obric.aiagent.plugin");
    }

    public static Looper a(String r3) {
        if (r3 == null) goto L9;
        Looper r4 = (Looper) ZeusTransformUtils.preCheckCast(f6454c.get(r3), Looper.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        return r4;
    L8:
        return (Looper) ZeusTransformUtils.preCheckCast(g.c(new Object[0]), Looper.class, "com.obric.aiagent.plugin");
    L9:
        return (Looper) ZeusTransformUtils.preCheckCast(g.c(new Object[0]), Looper.class, "com.obric.aiagent.plugin");
    }

    public static Handler a() {
        return b(a(f6455d));
    }

    public static Handler b(String r3) {
        if (r3 == null) goto L5;
        Handler r0 = (Handler) ZeusTransformUtils.preCheckCast(f6455d.get(r3), Handler.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L13;
        Looper r1 = a(r3);
        if (r1 == null) goto L11;
        Handler r2 = new Handler(r1);
        f6455d.put(r3, r2);
        return r2;
    L11:
        t.c("getLooper return null");
        return r0;
    L13:
        return r0;
    L5:
        return (Handler) ZeusTransformUtils.preCheckCast(h.c(new Object[0]), Handler.class, "com.obric.aiagent.plugin");
    }

    public static void a(String r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        c(r2).execute(r4);
    }

    public static void b(String r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        d(r2).execute(r4);
    }

    public static <T> Future<T> a(String r2, Callable<T> r3) {
        Callable<T> r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.aiagent.plugin");
        return d(r2).submit(r4);
    }

    public static <T> Future<T> a(Callable<T> r2) {
        Callable r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.aiagent.plugin");
        return a(a(f6453b), r3);
    }

    public static void c(String r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (Looper.myLooper() != a(r3)) goto L5;
        r5.run();
        return;
    L5:
        Handler r6 = b(r3);
        if (r6 != null) goto L8;
        r6 = (Handler) ZeusTransformUtils.preCheckCast(h.c(new Object[0]), Handler.class, "com.obric.aiagent.plugin");
    L8:
        r6.post(r5);
    }

    public static void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        c(a(f6455d), r3);
    }

    static void a(String r2, v r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Executor r0 = r3.f6449a;
        if (r0 == null) goto L7;
        f6452a.put(r2, r0);
    L7:
        ExecutorService r1 = r3.f6450b;
        if (r1 == null) goto L10;
        f6453b.put(r2, r1);
    L10:
        Looper r4 = r3.f6451c;
        if (r4 == null) goto L14;
        f6454c.put(r2, r4);
        return;
    }

    private static String a(Map r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L13:
        return null;
    L5:
        if (r4.size() == 0) goto L13;
        Set r5 = r4.keySet();
        if (r5 == null) goto L13;
        if (r5.size() <= 0) goto L13;
        return (String) ZeusTransformUtils.preCheckCast(r5.iterator().next(), String.class, "com.obric.aiagent.plugin");
    }
}
