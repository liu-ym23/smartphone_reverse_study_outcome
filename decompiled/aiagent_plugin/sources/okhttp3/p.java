package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f40182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f40183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f40184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f40185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque<okhttp3.internal.d.e.a> f40186e;
    private final ArrayDeque<okhttp3.internal.d.e.a> f;
    private final ArrayDeque<okhttp3.internal.d.e> g;

    public p() {
        this.f40182a = 64;
        this.f40183b = 5;
        this.f40186e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
    }

    public final synchronized ExecutorService a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f40185d != null) goto L6;
        this.f40185d = (ExecutorService) ZeusTransformUtils.preCheckCast(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new SynchronousQueue(), BlockingQueue.class, "com.obric.aiagent.plugin"), okhttp3.internal.c.a(okhttp3.internal.c.g + " Dispatcher", false)), ExecutorService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L6:
        ExecutorService r0 = this.f40185d;     // Catch: Throwable -> L9
        d.h.b.o.a(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public p(ExecutorService r3) {
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "executorService");
        this();
        this.f40185d = r4;
    }

    public final void a(okhttp3.internal.d.e.a r2) {
        d.h.b.o.e(r2, "call");
        monitor-enter(this);
        this.f40186e.add(r2);     // Catch: Throwable -> L13
        if (r2.c().g() == true) goto L9;
        okhttp3.internal.d.e.a r0 = a(r2.b());     // Catch: Throwable -> L13
        if (r0 == null) goto L9;
        r2.a(r0);     // Catch: Throwable -> L13
    L9:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(this);
        c();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private final okhttp3.internal.d.e.a a(String r5) {
        Iterator<okhttp3.internal.d.e.a> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        okhttp3.internal.d.e.a r1 = (okhttp3.internal.d.e.a) ZeusTransformUtils.preCheckCast(r0.next(), okhttp3.internal.d.e.a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r1.b(), r5) == false) goto L4;
        return r1;
    L8:
        Iterator<okhttp3.internal.d.e.a> r4 = this.f40186e.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        okhttp3.internal.d.e.a r2 = (okhttp3.internal.d.e.a) ZeusTransformUtils.preCheckCast(r4.next(), okhttp3.internal.d.e.a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r2.b(), r5) == false) goto L10;
        return r2;
    L14:
        return null;
    }

    public final synchronized void a(okhttp3.internal.d.e r2) {
        monitor-enter(this);
        d.h.b.o.e(r2, "call");     // Catch: Throwable -> L6
        this.g.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void b(okhttp3.internal.d.e.a r4) {
        d.h.b.o.e(r4, "call");
        r4.a().decrementAndGet();
        a((Deque) ZeusTransformUtils.preCheckCast(this.f, Deque.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void b(okhttp3.internal.d.e r4) {
        d.h.b.o.e(r4, "call");
        a((Deque) ZeusTransformUtils.preCheckCast(this.g, Deque.class, "com.obric.aiagent.plugin"), r4);
    }

    private final <T> void a(Deque<T> r3, T r4) {
        Deque r5 = (Deque) ZeusTransformUtils.wrapperContextForParams(r3, Deque.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r5.remove(r4) == false) goto L14;
        Runnable r6 = this.f40184c;     // Catch: Throwable -> L15
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(this);
        if (c() == true) goto L19;
        if (r6 == null) goto L20;
        r6.run();
        return;
    L20:
        return;
    L19:
        return;
    L14:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L15
    }

    public final synchronized int b() {
        monitor-enter(this);
        int r0 = this.f.size() + this.g.size();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private final boolean c() {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        Iterator<okhttp3.internal.d.e.a> r1 = this.f40186e.iterator();     // Catch: Throwable -> L29
        d.h.b.o.c(r1, "readyAsyncCalls.iterator()");     // Catch: Throwable -> L29
    L13:
        if (r1.hasNext() == false) goto L19;
        okhttp3.internal.d.e.a r2 = (okhttp3.internal.d.e.a) ZeusTransformUtils.preCheckCast(r1.next(), okhttp3.internal.d.e.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (this.f.size() >= this.f40182a) goto L19;
        if (r2.a().get() >= this.f40183b) goto L13;
        r1.remove();     // Catch: Throwable -> L29
        r2.a().incrementAndGet();     // Catch: Throwable -> L29
        d.h.b.o.c(r2, "asyncCall");     // Catch: Throwable -> L29
        r0.add(r2);     // Catch: Throwable -> L29
        this.f.add(r2);     // Catch: Throwable -> L29
    L19:
        int r3 = 0;
        if (b() <= 0) goto L22;
        boolean r4 = true;
    L23:
        d.x r5 = d.x.f38692a;     // Catch: Throwable -> L29
        monitor-exit(this);
        int r6 = r0.size();
    L26:
        if (r3 >= r6) goto L28;
        ((okhttp3.internal.d.e.a) ZeusTransformUtils.preCheckCast(r0.get(r3), okhttp3.internal.d.e.a.class, "com.obric.aiagent.plugin")).a(a());
        r3 = r3 + 1;
        goto L26
    L28:
        return r4;
    L22:
        r4 = false;
    L29:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
