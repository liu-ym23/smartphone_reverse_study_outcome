package com.ttnet.org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import com.ttnet.org.chromium.base.TraceEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: TaskRunnerImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class l implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f37762b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReferenceQueue<Object> f37763c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<b> f37764d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Runnable f37765a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final n f37766e;
    private final String f;
    private final int g;
    private volatile long h;
    private final Object i;
    private boolean j;
    private LinkedList<Runnable> k;
    private List<Pair<Runnable, Long>> l;

    /* JADX INFO: compiled from: TaskRunnerImpl.java */
    interface a {
        long a(int r1, int r2, boolean r3, boolean r4, byte r5, byte[] r6);

        void a(long r1);

        void a(long r1, Runnable r3, long r4, String r6);
    }

    /* JADX INFO: compiled from: TaskRunnerImpl.java */
    private static class b extends WeakReference<l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f37767a;

        b(l r3) {
            super(r3, l.d());
            this.f37767a = l.a(r3);
        }

        void a() {
            m.a().a(this.f37767a);
        }
    }

    static /* synthetic */ long a(l r2) {
        return r2.h;
    }

    static /* synthetic */ ReferenceQueue d() {
        return f37763c;
    }

    static {
        f37763c = new ReferenceQueue();
        f37764d = new HashSet();
    }

    private static void e() {
    L2:
        b r0 = (b) ZeusTransformUtils.preCheckCast(f37763c.poll(), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        r0.a();
        Set<b> r1 = f37764d;
        monitor-enter(r1);
        r1.remove(r0);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    l(n r3) {
        this(r3, "TaskRunnerImpl", 0);
        e();
    }

    public l(n r2, String r3, int r4) {
        this.f37765a = new $$Lambda$3tPHoGa8LUrFDB62Q4wJtfwYSoE(this);
        this.i = new Object();
        this.f37766e = r2.d();
        this.f = r3 + ".PreNativeTask.run";
        this.g = r4;
    }

    @Override // com.ttnet.org.chromium.base.task.k
    public void a(Runnable r8, long r9) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.aiagent.plugin");
        if (this.h == 0) goto L6;
        m.a().a(this.h, r3, r9, r3.getClass().getName());
        return;
    L6:
        Object r10 = this.i;
        monitor-enter(r10);
        f();     // Catch: Throwable -> L19
        if (this.h == 0) goto L14;
        m.a().a(this.h, r3, r9, r3.getClass().getName());     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L14:
        if (r9 != 0) goto L16;
        this.k.add(r3);     // Catch: Throwable -> L19
        a();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L16:
        Pair<Runnable, Long> r0 = new Pair(r3, Long.valueOf(r9));     // Catch: Throwable -> L19
        this.l.add(r0);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private void f() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        if (PostTask.a(this) == true) goto L8;
        c();
        return;
    L8:
        this.k = new LinkedList();
        this.l = new ArrayList();
    }

    public void a() {
        PostTask.a().execute(this.f37765a);
    }

    public void b() {
        TraceEvent r0 = TraceEvent.a(this.f);
        Object r1 = this.i;     // Catch: Throwable -> L27
        monitor-enter(r1);     // Catch: Throwable -> L27
        LinkedList<Runnable> r2 = this.k;     // Catch: Throwable -> L24
        if (r2 != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L24
        if (r0 == null) goto L38;
        r0.close();
        return;
    L38:
        return;
    L11:
        Runnable r3 = (Runnable) ZeusTransformUtils.preCheckCast(r2.poll(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        int r5 = this.f37766e.l;     // Catch: Throwable -> L27
        if (r5 != 1) goto L16;
        Process.setThreadPriority(0);     // Catch: Throwable -> L27
    L20:
        r3.run();     // Catch: Throwable -> L27
        if (r0 == null) goto L39;
        r0.close();
        return;
    L39:
        return;
    L16:
        if (r5 == 2) goto L18;
        Process.setThreadPriority(10);     // Catch: Throwable -> L27
        goto L20
    L18:
        Process.setThreadPriority(-1);     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        if (r0 != null) goto L36;
    L33:
        throw th;
    L36:
        r0.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);
        goto L33
    }

    void c() {
        long r0 = m.a().a(this.g, this.f37766e.l, this.f37766e.m, this.f37766e.n, this.f37766e.o, this.f37766e.p);
        Object r2 = this.i;
        monitor-enter(r2);
        LinkedList<Runnable> r3 = this.k;     // Catch: Throwable -> L36
        if (r3 == null) goto L11;
        Iterator<Runnable> r4 = r3.iterator();     // Catch: Throwable -> L36
    L8:
        if (r4.hasNext() == false) goto L10;
        Runnable r10 = (Runnable) ZeusTransformUtils.preCheckCast(r4.next(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        m.a().a(r0, r10, 0, r10.getClass().getName());     // Catch: Throwable -> L36
        goto L8
    L10:
        this.k = null;     // Catch: Throwable -> L36
    L11:
        List<Pair<Runnable, Long>> r5 = this.l;     // Catch: Throwable -> L36
        if (r5 == null) goto L19;
        Iterator<Pair<Runnable, Long>> r6 = r5.iterator();     // Catch: Throwable -> L36
    L15:
        if (r6.hasNext() == false) goto L17;
        Pair r7 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        m.a().a(r0, (Runnable) ZeusTransformUtils.preCheckCast(r7.first, Runnable.class, "com.obric.aiagent.plugin"), ((Long) ZeusTransformUtils.preCheckCast(r7.second, Long.class, "com.obric.aiagent.plugin")).longValue(), r7.getClass().getName());     // Catch: Throwable -> L36
        goto L15
    L17:
        this.l = null;     // Catch: Throwable -> L36
    L19:
        if (f37762b == false) goto L21;
    L25:
        this.h = r0;     // Catch: Throwable -> L36
        monitor-exit(r2);     // Catch: Throwable -> L36
        Set<b> r1 = f37764d;
        monitor-enter(r1);
        r1.add(new b(this));     // Catch: Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L33
        e();
        return;
    L33:
        th = move-exception;
        throw th;
    L21:
        if (this.h == 0) goto L25;
        throw new AssertionError();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }
}
