package com.bytedance.android.livesdk.room.Task.base;

import android.os.Looper;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdk.room.Task.execute.ExecutorHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f157566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, LiveTask> f157567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, ArrayList<LiveTask>> f157568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CountDownLatch f157569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<LiveTask> f157570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<LiveTask> f157571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f157572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f157573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList<gs2.d> f157574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final hs2.c f157575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f157576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, AtomicInteger> f157577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicLong f157578m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList<gs2.c> f157579n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f157580o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f157581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<LiveTask> f157582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, LiveTask> f157583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, ArrayList<LiveTask>> f157584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<LiveTask> f157585e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<LiveTask> f157586f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CountDownLatch f157587g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicInteger f157588h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, AtomicInteger> f157589i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final CopyOnWriteArrayList<gs2.c> f157590j;

        public a() {
            this.f157581a = "Live_Node";
            this.f157582b = new ArrayList();
            this.f157583c = new HashMap();
            this.f157584d = new HashMap();
            this.f157585e = new ArrayList();
            this.f157586f = new ArrayList();
            this.f157588h = new AtomicInteger();
            this.f157589i = new HashMap();
            this.f157590j = new CopyOnWriteArrayList();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.room.Task.base.b$b, reason: collision with other inner class name */
    public static final class RunnableC2411b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f157591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveTask f157592b;

        public RunnableC2411b(b r100, LiveTask r101) {
            this.f157591a = r100;
            this.f157592b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new com.bytedance.android.livesdk.room.Task.execute.b(this.f157591a, this.f157592b).run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f157593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveTask f157594b;

        public c(b r100, LiveTask r101) {
            this.f157593a = r100;
            this.f157594b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new com.bytedance.android.livesdk.room.Task.execute.b(this.f157593a, this.f157594b).run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f157595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveTask f157596b;

        public d(b r100, LiveTask r101) {
            this.f157595a = r100;
            this.f157596b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<gs2.d> r100 = this.f157595a.f157574i.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            gs2.d r101 = r100.next();     // Catch: Throwable -> L7
            this.f157596b.taskID();     // Catch: Throwable -> L7
            r101.a();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f157597a;

        public e(b r100) {
            this.f157597a = r100;
        }

        public final void a() {
            Iterator<gs2.c> r100 = this.f157597a.f157579n.iterator();
        L4:
            if (r100.hasNext() == false) goto L10;
            gs2.c r101 = r100.next();
            if (r101 == null) goto L8;
            long r102 = this.f157597a.f157575j.f486953c;
            r101.b();
        L8:
            if (r101 == null) goto L4;
            Map<String, Long> r103 = this.f157597a.f157575j.f486951a;
            r101.a();
            goto L4
        L10:
            Iterator<gs2.d> r104 = this.f157597a.f157574i.iterator();
        L12:
            if (r104.hasNext() == false) goto L14;
            r104.next().c();
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(a r100) {
        this.f157580o = r100;
        this.f157566a = (ExecutorService) ExecutorHelper.f157599a.getValue();
        this.f157567b = r100.f157583c;
        this.f157568c = r100.f157584d;
        CountDownLatch r101 = r100.f157587g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("countDownLatch");
    L5:
        this.f157569d = r101;
        this.f157570e = r100.f157585e;
        this.f157571f = r100.f157586f;
        this.f157572g = ((ArrayList) r100.f157582b).size();
        boolean r102 = false;
        this.f157573h = new AtomicInteger(0);
        this.f157574i = new CopyOnWriteArrayList();
        this.f157575j = new hs2.c(r100.f157581a);
        if (fs2.c.a().b() == true) goto L8;
    L10:
        this.f157576k = r102;
        this.f157577l = r100.f157589i;
        this.f157578m = new AtomicLong(0);
        this.f157579n = r100.f157590j;
        return;
    L8:
        if (fs2.c.a().d() == false) goto L10;
        r102 = true;
        goto L10
    }

    public final void a(LiveTask r100) {
        LiveTaskType r101 = r100.d();
        int r102 = com.bytedance.android.livesdk.room.Task.base.c.f157598a[r101.ordinal()];
        if (r102 != 1) goto L5;
        this.f157566a.execute(new com.bytedance.android.livesdk.room.Task.execute.b(this, r100));
        return;
    L5:
        if (r102 == 2) goto L10;
        int r103 = fs2.d.f478652a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L9;
        new com.bytedance.android.livesdk.room.Task.execute.b(this, r100).run();
        return;
    L9:
        fs2.d.a(new c(this, r100));
        return;
    L10:
        long r104 = this.f157578m.getAndAdd(fs2.c.a().a());
        int r105 = fs2.d.f478652a;
        RunnableC2411b r106 = new RunnableC2411b(this, r100);
        Intrinsics.checkNotNullParameter(r106, "r");
        fs2.d.a.f478653a.postDelayed(r106, r104);
    }

    public final void c(LiveTask r110) {
        Intrinsics.checkNotNullParameter(r110, "task");
        ArrayList r100 = (ArrayList) ((HashMap) this.f157568c).get(r110.taskID());
        if (r100 == null) goto L21;
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L21;
        LiveTask r102 = (LiveTask) r101.next();
        monitor-enter(r102);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (r102.f157555a != null) goto L12;
        r102.f157555a = new CountDownLatch(r102.f().size());     // Catch: Throwable -> L17
    L12:
        monitor-exit(r102);
        CountDownLatch r103 = r102.f157555a;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("countDownLatch");
    L16:
        r103.countDown();
    L21:
        if (this.f157576k == false) goto L33;
        ArrayList r104 = (ArrayList) ((HashMap) this.f157568c).get(r110.taskID());
        if (r104 == null) goto L33;
        Iterator r105 = r104.iterator();
    L26:
        if (r105.hasNext() == false) goto L33;
        LiveTask r106 = (LiveTask) r105.next();
        AtomicInteger r107 = (AtomicInteger) ((HashMap) this.f157577l).get(r106.taskID());
        if (r107 == null) goto L30;
        int r108 = r107.decrementAndGet();
    L31:
        if (r108 != 0) goto L26;
        a(r106);
        goto L26
    L30:
        r108 = -1;
    L33:
        this.f157569d.countDown();
        fs2.d.a(new d(this, r110));
        this.f157573h.incrementAndGet();
        if (this.f157573h.get() != this.f157572g) goto L83;
        hs2.c r111 = this.f157575j;
        r111.getClass();
        r111.f486953c = System.currentTimeMillis() - r111.f486952b;
        hs2.a r109 = hs2.d.f486955a;
        if (r109 == null) goto L38;
        boolean r112 = r109.a();
    L39:
        if (r112 == false) goto L65;
        Map<String, Long> r113 = r111.f486951a;
        LinkedHashMap r114 = new LinkedHashMap();
        Iterator r115 = ((ConcurrentHashMap) r113).entrySet().iterator();
    L42:
        if (r115.hasNext() == false) goto L53;
        Map.Entry r116 = (Map.Entry) r115.next();
        String r117 = (String) r116.getKey();
        long r118 = ((Number) r116.getValue()).longValue();
        hs2.a r119 = hs2.d.f486955a;
        if (r119 == null) goto L46;
        long r120 = r119.b();
    L48:
        if (r118 <= r120) goto L50;
        boolean r121 = true;
    L51:
        if (r121 == false) goto L42;
        r114.put(r116.getKey(), r116.getValue());
        goto L42
    L50:
        r121 = false;
        goto L51
    L46:
        r120 = 20;
        goto L48
    L53:
        LinkedHashMap r122 = new LinkedHashMap(MapsKt.mapCapacity(r114.size()));
        Iterator r123 = r114.entrySet().iterator();
    L55:
        if (r123.hasNext() == false) goto L57;
        Map.Entry r124 = (Map.Entry) r123.next();
        r122.put(r124.getKey(), String.valueOf(((Number) r124.getValue()).longValue()));
        goto L55
    L57:
        hs2.a r125 = hs2.d.f486955a;
        Intrinsics.checkNotNullParameter(r122, "logMap");
        hs2.a r126 = hs2.d.f486955a;
        if (r126 == null) goto L60;
        boolean r127 = r126.a();
    L61:
        if (r127 == false) goto L65;
        qm0.b r128 = om0.c.g();
        if (r128 == null) goto L65;
        r128.sendLog("livesdk_task_execute_log", r122, new Object[0]);
        goto L65
    L60:
        r127 = false;
    L65:
        int r129 = hs2.b.f486950a;
        hs2.b.a("Group: " + r111.f486954d + ":::::   group execute finish, cost :  " + r111.f486953c);
        fs2.d.a(new e(this));
        return;
    L38:
        r112 = false;
        goto L39
    }

    public final void b(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        hs2.c r102 = this.f157575j;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "taskName");
        ((ConcurrentHashMap) r102.f486951a).put(r100, Long.valueOf(r101));
        int r103 = hs2.b.f486950a;
        hs2.b.a("Group: " + r102.f486954d + ":::::   TaskID:  " + r100 + "  cost :  " + r101);
    }
}
