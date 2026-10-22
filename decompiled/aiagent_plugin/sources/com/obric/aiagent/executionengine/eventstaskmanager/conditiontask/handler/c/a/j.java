package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import android.util.LruCache;
import com.obric.eventkit.task.model.LocationCondition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorFrameBuffer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static final String TAG = "LocationMonitorFrameBuffer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f17138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayDeque<n> f17141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LruCache<String, b> f17142e;

    /* JADX INFO: compiled from: LocationMonitorFrameBuffer.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LocationMonitorFrameBuffer.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LocationCondition f17144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f17145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private n f17146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f17147e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f17143a, r10.f17143a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f17144b, r10.f17144b) == true) goto L15;
            return false;
        L15:
            if (this.f17145c == r10.f17145c) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f17146d, r10.f17146d) == true) goto L21;
            return false;
        L21:
            if (this.f17147e == r10.f17147e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f17143a.hashCode() * 31) + this.f17144b.hashCode()) * 31) + Long.hashCode(this.f17145c)) * 31;
            n r1 = this.f17146d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Integer.hashCode(this.f17147e);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TriggerRecord(taskId=" + this.f17143a + ", condition=" + this.f17144b + ", triggerTime=" + this.f17145c + ", triggerFrame=" + this.f17146d + ", triggerResult=" + this.f17147e + ')';
        }

        public b(String r2, LocationCondition r3, long r4, n r6, int r7) {
            d.h.b.o.e(r2, DBDefinition.TASK_ID);
            d.h.b.o.e(r3, "condition");
            this.f17143a = r2;
            this.f17144b = r3;
            this.f17145c = r4;
            this.f17146d = r6;
            this.f17147e = r7;
        }

        public /* synthetic */ b(String r8, LocationCondition r9, long r10, n r12, int r13, int r14, d.h.b.h r15) {
            if ((r14 & 8) == 0) goto L5;
            r12 = null;
        L5:
            this(r8, r9, r10, r12, r13);
        }

        public final String a() {
            return this.f17143a;
        }

        public final LocationCondition b() {
            return this.f17144b;
        }

        public final long c() {
            return this.f17145c;
        }

        public final void a(n r1) {
            this.f17146d = r1;
        }

        public final n d() {
            return this.f17146d;
        }

        public final int e() {
            return this.f17147e;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f17138a = new a(null);
    }

    public j() {
        int r0 = 0;
        this(r0, r0, 3, null);
    }

    public j(int r1, int r2) {
        this.f17139b = r1;
        this.f17140c = r2;
        this.f17141d = new ArrayDeque();
        this.f17142e = new LruCache(r2);
    }

    public /* synthetic */ j(int r1, int r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 300;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 50;
    L8:
        this(r1, r2);
    }

    public final synchronized void a(n r6) {
        monitor-enter(this);
        d.h.b.o.e(r6, "frame");     // Catch: Throwable -> L10
        this.f17141d.addLast(r6);     // Catch: Throwable -> L10
    L5:
        if (this.f17141d.size() <= this.f17139b) goto L7;
        this.f17141d.removeFirst();     // Catch: Throwable -> L10
        goto L5
    L7:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "append frame time=" + r6.a() + " provider=" + r6.f() + " size=" + this.f17141d.size());     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r16, LocationCondition r17, long r18, int r20) {
        monitor-enter(this);
        d.h.b.o.e(r16, DBDefinition.TASK_ID);     // Catch: Throwable -> L12
        d.h.b.o.e(r17, "condition");     // Catch: Throwable -> L12
        if (this.f17142e.get(r16) == null) goto L9;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "skip duplicate trigger record taskId=" + r16 + " triggerTime=" + r18);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        this.f17142e.put(r16, new b(r16, r17, r18, null, r20, 8, null));     // Catch: Throwable -> L12
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "mark trigger taskId=" + r16 + " triggerTime=" + r18 + " triggerResult=" + r20 + " recordSize=" + this.f17142e.size());     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized List<ae> b(n r15) {
        monitor-enter(this);
        d.h.b.o.e(r15, "nextFrame");     // Catch: Throwable -> L26
        List<n> r0 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f17141d, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        if (r0.isEmpty() == false) goto L8;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "resolve trigger skipped empty frame buffer recordSize=" + this.f17142e.size());     // Catch: Throwable -> L26
        List<ae> r16 = d.a.p.b();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r16;
    L8:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L26
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L26
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f17142e.snapshot().values(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L26
    L10:
        if (r3.hasNext() == false) goto L19;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r4.d() != null) goto L10;
        if (r15.a() < r4.c()) goto L10;
        n r10 = a(r4.c(), r0);     // Catch: Throwable -> L26
        r4.a(r10);     // Catch: Throwable -> L26
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "resolve trigger frame taskId=" + r4.a() + " triggerTime=" + r4.c() + " frameTime=" + r10.a());     // Catch: Throwable -> L26
        ae r5 = a(r4.a(), new ae(r4.a(), r4.b(), r10, d.a.p.b(), d.a.p.b(), r4.e()), true);     // Catch: Throwable -> L26
        if (r5 == null) goto L10;
        r1.add(r5);     // Catch: Throwable -> L26
        r2.add(r4.a());     // Catch: Throwable -> L26
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "sample before window taskId=" + r4.a() + " beforeCount=" + r5.d().size());     // Catch: Throwable -> L26
        goto L10
    L19:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L26
    L21:
        if (r17.hasNext() == false) goto L23;
        this.f17142e.remove((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        goto L21
    L23:
        List<ae> r18 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        monitor-exit(this);
        return r18;
    L26:
        th = move-exception;
        throw th;
    }

    public final synchronized ae a(String r22, ae r23, boolean r24) {
        monitor-enter(this);
        d.h.b.o.e(r22, DBDefinition.TASK_ID);     // Catch: Throwable -> L44
        if (r23 != null) goto L19;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f17142e.get(r22), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (r1 == null) goto L14;
        n r6 = r1.d();     // Catch: Throwable -> L44
        if (r6 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        ae r10 = new ae(r1.a(), r1.b(), r6, d.a.p.b(), d.a.p.b(), r1.e());     // Catch: Throwable -> L44
    L15:
        if (r10 != null) goto L18;
        monitor-exit(this);
        return null;
    L18:
        ae r12 = r10;
    L20:
        n r2 = r12.c();     // Catch: Throwable -> L44
        List r3 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f17141d, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L44
        p r4 = q.f17157a.a();     // Catch: Throwable -> L44
        if (r24 == false) goto L32;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        Iterator r8 = r5.iterator();     // Catch: Throwable -> L44
    L24:
        if (r8.hasNext() == false) goto L31;
        Object r9 = r8.next();     // Catch: Throwable -> L44
        if (((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin")).a() >= r2.a()) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == false) goto L24;
        r7.add(r9);     // Catch: Throwable -> L44
        goto L24
    L28:
        r11 = false;
        goto L29
    L31:
        ae r13 = ae.a(r12, null, null, null, a((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), r2.a(), -r4.a(), -r4.b(), r4.b()), null, 0, 55, null);     // Catch: Throwable -> L44
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "sample before taskId=" + r22 + " count=" + r13.d().size());     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return r13;
    L32:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L44
    L34:
        if (r16.hasNext() == false) goto L41;
        Object r17 = r16.next();     // Catch: Throwable -> L44
        if (((n) ZeusTransformUtils.preCheckCast(r17, n.class, "com.obric.aiagent.plugin")).a() <= r2.a()) goto L38;
        boolean r18 = true;
    L39:
        if (r18 == false) goto L34;
        r15.add(r17);     // Catch: Throwable -> L44
        goto L34
    L38:
        r18 = false;
        goto L39
    L41:
        r13 = ae.a(r12, null, null, null, null, a((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin"), r2.a(), r4.b(), r4.a(), r4.b()), 0, 47, null);     // Catch: Throwable -> L44
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "sample after taskId=" + r22 + " count=" + r13.e().size());     // Catch: Throwable -> L44
        goto L42
    L14:
        r10 = null;
        goto L15
    L19:
        r12 = r23;
    L44:
        th = move-exception;
        throw th;
    }

    private final n a(long r7, List<n> r9) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Object r10 = d.a.p.k(r6);
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        n r1 = (n) ZeusTransformUtils.preCheckCast(r8.next(), n.class, "com.obric.aiagent.plugin");
        if (Math.abs(r1.a() - r7) >= Math.abs(((n) ZeusTransformUtils.preCheckCast(r10, n.class, "com.obric.aiagent.plugin")).a() - r7)) goto L4;
        r10 = r1;
        goto L4
    L9:
        return (n) ZeusTransformUtils.preCheckCast(r10, n.class, "com.obric.aiagent.plugin");
    }

    private final List<n> a(List<n> r14, long r15, long r17, long r19, long r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        if (r0.isEmpty() == true) goto L5;
        ArrayList r2 = new ArrayList();
        int r5 = 0;
        long r3 = r17;
    L8:
        if (r3 > r19) goto L20;
        long r6 = r15 + r3;
    L10:
        int r8 = r5 + 1;
        if (r8 >= r0.size()) goto L15;
        if (Math.abs(((n) ZeusTransformUtils.preCheckCast(r0.get(r8), n.class, "com.obric.aiagent.plugin")).a() - r6) > Math.abs(((n) ZeusTransformUtils.preCheckCast(r0.get(r5), n.class, "com.obric.aiagent.plugin")).a() - r6)) goto L15;
        r5 = r8;
    L15:
        n r7 = (n) ZeusTransformUtils.preCheckCast(r0.get(r5), n.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(d.a.p.n((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")), r7) == true) goto L18;
        r2.add(r7);
    L18:
        r3 = r3 + r21;
        goto L8
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L5:
        return d.a.p.b();
    }
}
