package com.ttnet.org.chromium.base;

import android.os.Process;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EarlyTraceEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile int f37614a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f37615b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static List<b> f37616c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static List<a> f37617d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f37618e = true;
    private static boolean f;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f37619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f37620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f37621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f37622d;
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f37623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f37624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f37625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f37626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final long f37627e;
        final long f;

        b(String r1, boolean r2, boolean r3) {
            this.f37623a = r2;
            this.f37624b = r3;
            this.f37625c = r1;
            this.f37626d = Process.myTid();
            this.f37627e = System.nanoTime();
            this.f = SystemClock.currentThreadTimeMillis();
        }
    }

    interface c {
        void a(String r1, long r2, int r4, long r5);

        void a(String r1, long r2, long r4);

        void b(String r1, long r2, int r4, long r5);

        void b(String r1, long r2, long r4);

        void c(String r1, long r2, int r4, long r5);

        void d(String r1, long r2, int r4, long r5);
    }

    public EarlyTraceEvent() {
    }

    static {
        f37615b = new Object();
    }

    static void a() {
        Object r0 = f37615b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f37614a == 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        f37616c = new ArrayList();     // Catch: Throwable -> L11
        f37617d = new ArrayList();     // Catch: Throwable -> L11
        f37614a = 1;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    static void b() {
        Object r0 = f37615b;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (c() == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        if (f37616c.isEmpty() == true) goto L12;
        a(f37616c);     // Catch: Throwable -> L17
        f37616c.clear();     // Catch: Throwable -> L17
    L12:
        if (f37617d.isEmpty() == true) goto L14;
        b(f37617d);     // Catch: Throwable -> L17
        f37617d.clear();     // Catch: Throwable -> L17
    L14:
        f37614a = 2;     // Catch: Throwable -> L17
        f37616c = null;     // Catch: Throwable -> L17
        f37617d = null;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    static boolean c() {
        if (f37614a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    static void setBackgroundStartupTracingFlag(boolean r2) {
        d.b().edit().putBoolean("bg_startup_tracing", r2).apply();
    }

    public static boolean getBackgroundStartupTracingFlag() {
        return f;
    }

    public static void a(String r2, boolean r3) {
        if (c() == true) goto L5;
        return;
    L5:
        b r0 = new b(r2, true, r3);
        Object r4 = f37615b;
        monitor-enter(r4);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (c() == true) goto L11;
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L11:
        f37616c.add(r0);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
    }

    public static void b(String r2, boolean r3) {
        if (c() == true) goto L5;
        return;
    L5:
        b r0 = new b(r2, false, r3);
        Object r4 = f37615b;
        monitor-enter(r4);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (c() == true) goto L11;
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L11:
        f37616c.add(r0);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
    }

    private static void a(List<b> r18) {
        Iterator r0 = ((List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin");
        if (r2.f37623a == true) goto L8;
        if (r2.f37624b == true) goto L13;
        e.a().b(r2.f37625c, r2.f37627e, r2.f37626d, r2.f);
        goto L4
    L13:
        e.a().d(r2.f37625c, r2.f37627e, r2.f37626d, r2.f);
        goto L4
    L8:
        if (r2.f37624b == true) goto L9;
        e.a().a(r2.f37625c, r2.f37627e, r2.f37626d, r2.f);
        goto L4
    L9:
        e.a().c(r2.f37625c, r2.f37627e, r2.f37626d, r2.f);
        goto L4
    }

    private static void b(List<a> r15) {
        Iterator r16 = ((List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r16.hasNext() == false) goto L9;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r16.next(), a.class, "com.obric.aiagent.plugin");
        if (r0.f37619a == true) goto L7;
        e.a().b(r0.f37620b, r0.f37621c, r0.f37622d);
        goto L4
    L7:
        e.a().a(r0.f37620b, r0.f37621c, r0.f37622d);
        goto L4
    }
}
