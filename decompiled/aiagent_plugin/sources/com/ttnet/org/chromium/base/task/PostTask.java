package com.ttnet.org.chromium.base.task;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public class PostTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37735a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f37736b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<l> f37737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f37738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f37739e = null;
    private static volatile Executor f;
    private static AtomicReferenceArray<j> g;

    interface a {
        void a(int r1, boolean r2, boolean r3, byte r4, byte[] r5, Runnable r6, long r7, String r9);
    }

    public PostTask() {
    }

    static {
        f37736b = new Object();
        f37737c = new ArrayList();
        f37739e = new d();
        g = b();
    }

    private static AtomicReferenceArray<j> b() {
        AtomicReferenceArray<j> r0 = new AtomicReferenceArray(5);
        r0.set(0, new e());
        return r0;
    }

    public static void a(n r2, Runnable r3) {
        a(r2, (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), 0);
    }

    public static void a(n r10, Runnable r11, long r12) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.aiagent.plugin");
        if (f37738d == true) goto L5;
    L8:
        a(r10).a(r10, r6, r12);
        return;
    L5:
        if (r10.q == true) goto L8;
        n r13 = r10.d();
        f.a().a(r13.l, r13.m, r13.n, r13.o, r13.p, r6, r12, r6.getClass().getName());
    }

    static Executor a() {
        if (f == null) goto L7;
        return f;
    L7:
        return f37739e;
    }

    static boolean a(l r2) {
        Object r0 = f37736b;
        monitor-enter(r0);
        List<l> r1 = f37737c;     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.add(r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    private static j a(n r2) {
        return (j) ZeusTransformUtils.preCheckCast(g.get(r2.o), j.class, "com.obric.aiagent.plugin");
    }

    private static void onNativeSchedulerReady() {
        if (f37735a == false) goto L5;
    L9:
        f37738d = true;
        Object r0 = f37736b;
        monitor-enter(r0);
        List<l> r1 = f37737c;     // Catch: Throwable -> L18
        f37737c = null;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        Iterator<l> r2 = r1.iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        ((l) ZeusTransformUtils.preCheckCast(r2.next(), l.class, "com.obric.aiagent.plugin")).c();
        goto L15
    L17:
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (f37738d == false) goto L9;
        throw new AssertionError();
    }

    private static void onNativeSchedulerShutdownForTesting() {
        Object r0 = f37736b;
        monitor-enter(r0);
        f37737c = new ArrayList();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        f37738d = false;
        g.set(0, new e());
        int r1 = 1;
    L8:
        if (r1 >= g.length()) goto L10;
        g.set(r1, null);
        r1 = r1 + 1;
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
