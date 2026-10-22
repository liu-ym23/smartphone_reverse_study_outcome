package com.bytedance.android.anniex.scene.handler.idle;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f41220a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PriorityQueue<c<?>> f41221b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f41222c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ScheduledExecutorService f41223d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ScheduledExecutorService f41224e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f41225f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<Pair<TaskType, String>, TaskStatus> f41226g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<TaskType, List<i>> f41227h = null;

    public h() {
    }

    static {
        f41220a = new h();
        f41221b = new PriorityQueue();
        f41222c = new LinkedHashSet();
        f41223d = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("IdleTaskQueue"));
        f41224e = PThreadExecutorsUtils.newScheduledThreadPool(3, new DefaultThreadFactory("IdleTaskQueue"));
        f41225f = new AtomicBoolean(false);
        f41226g = new ConcurrentHashMap();
        f41227h = new ConcurrentHashMap();
    }

    public final void d() {
        AtomicBoolean r100 = f41225f;
        int r101 = 0;
        if (r100.get() == true) goto L17;
        c<?> r102 = c(false);
        if (r102 == null) goto L17;
        r100.set(true);
        IdleSignalCenter r103 = IdleSignalCenter.f41188a;
        monitor-enter(r103);
        r103.b();     // Catch: Throwable -> L13
        boolean r104 = ((ArrayList) IdleSignalCenter.f41189b).isEmpty();     // Catch: Throwable -> L13
        monitor-exit(r103);
        if (r104 == true) goto L12;
        r100.set(false);
        f41223d.schedule(e.f41216a, 1000, TimeUnit.MILLISECONDS);
        goto L17
    L12:
        f41223d.execute(new f(r102));
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r101 >= 3) goto L26;
        c<?> r105 = c(true);
        if (r105 == null) goto L34;
        if (IdleSignalCenter.f41188a.a() == true) goto L24;
        b(r105, TaskStatus.TIMEOUT);
    L25:
        r101 = r101 + 1;
        goto L17
    L24:
        f41224e.execute(new d(r105));
        goto L25
    L34:
        return;
    }

    public final synchronized void a(c r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "task");     // Catch: Throwable -> L17
        Set<String> r101 = f41222c;     // Catch: Throwable -> L17
        if (r101.contains(r100.f41198a) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r100.f41206i != null) goto L11;
    L14:
        f41221b.offer(r100);     // Catch: Throwable -> L17
        r101.add(r100.f41198a);     // Catch: Throwable -> L17
        b(r100, TaskStatus.QUEUED);     // Catch: Throwable -> L17
        d();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        if (System.currentTimeMillis() <= r100.f41206i.longValue()) goto L14;
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final c<?> c(boolean r100) {
        monitor-enter(this);
    L23:
        PriorityQueue<c<?>> r101 = f41221b;     // Catch: Throwable -> L20
        c<?> r102 = r101.peek();     // Catch: Throwable -> L20
        if (r102 == null) goto L6;
        if (r102.f41206i == null) goto L14;
        if (System.currentTimeMillis() <= r102.f41206i.longValue()) goto L14;
        r101.poll();     // Catch: Throwable -> L20
        f41222c.remove(r102.f41198a);     // Catch: Throwable -> L20
        b(r102, TaskStatus.TIMEOUT);     // Catch: Throwable -> L20
    L14:
        if (r102.f41204g != r100) goto L18;
        r101.poll();     // Catch: Throwable -> L20
        f41222c.remove(r102.f41198a);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r102;
    L18:
        monitor-exit(this);
        return null;
    L6:
        monitor-exit(this);
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public static void b(c r110, TaskStatus r111) {
        f41226g.put(TuplesKt.to(r110.f41199b, r110.f41198a), r111);
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.f("IdleTaskQueue", "Status [" + r110.f41199b + "][" + r110.f41198a + "] -> " + r111, null, 12);
        List<i> r101 = f41227h.get(r110.f41199b);
        if (r101 == null) goto L9;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        ((i) r102.next()).a(r110.f41199b, r110.f41198a, r110.f41200c, r110.f41201d, r111);
    L9:
        if (r111 != TaskStatus.SUCCESS) goto L11;
    L14:
        TaskType r103 = r110.f41199b;
        String r112 = r110.f41201d;
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.f("TaskReport", "Report: type=" + r103 + " tag=" + r112 + " status=" + r111, null, 12);
        return;
    L11:
        if (r111 == TaskStatus.FAILED) goto L14;
        if (r111 == TaskStatus.TIMEOUT) goto L14;
    }
}
