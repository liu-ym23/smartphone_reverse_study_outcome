package com.bytedance.monitor.a.b.a;

import android.util.Pair;
import com.bytedance.monitor.a.b.e;
import com.bytedance.monitor.a.b.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ApmInnerThreadPool.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends ScheduledThreadPoolExecutor implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f8897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Integer, List<ScheduledFuture<?>>> f8898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<ScheduledFuture<?>, Pair<Integer, Boolean>> f8899e;
    private ExecutorService f;
    private ThreadPoolExecutor g;
    private int h;
    private a i;

    /* JADX INFO: compiled from: ApmInnerThreadPool.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f8902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Thread f8903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8905d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f8906e;

        public a(b r3, Runnable r4, Thread r5, int r6) {
            Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            this.f8906e = r3;
            this.f8902a = r7;
            this.f8903b = r5;
            this.f8904c = System.currentTimeMillis();
            this.f8905d = r6;
        }

        public boolean a() {
            if ((System.currentTimeMillis() - this.f8904c) <= this.f8905d) goto L5;
            return true;
        L5:
            return false;
        }

        public void b() {
            Runnable r0 = this.f8902a;
            if (r0 != null) goto L6;
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r0, FutureTask.class) == false) goto L11;
            boolean r1 = ((FutureTask) ZeusTransformUtils.preCheckCast(this.f8902a, FutureTask.class, "com.obric.aiagent.plugin")).cancel(true);
            if (b.a(this.f8906e) == false) goto L12;
            b.a(this.f8906e, "TimeSensitive + mCancelOverTimeTaskRunnable run ------------ cancel FutureTask, canceled?" + r1);
            return;
        L12:
            return;
        }
    }

    static /* synthetic */ void a(b r0, String r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.b();
    }

    public b(int r3, ThreadFactory r4) {
        super(r3, (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r4, ThreadFactory.class, "com.obric.aiagent.plugin"));
        this.f8895a = "ApmInnerThreadPool";
        this.f8896b = false;
        this.f8898d = new ConcurrentHashMap();
        this.f8899e = new ConcurrentHashMap();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f == null) goto L10;
        if (b() == false) goto L8;
        a("submit task to outer-executor: " + a(r4));
    L8:
        return this.f.submit(r4);
    L10:
        return super.submit(r4);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r3) {
        Callable<T> r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.aiagent.plugin");
        if (this.f == null) goto L10;
        if (b() == false) goto L8;
        a("submit task to outer-executor: " + r4);
    L8:
        return this.f.submit(r4);
    L10:
        return super.submit(r4);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r3, T r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f == null) goto L10;
        if (b() == false) goto L8;
        a("submit task to outer-executor: " + a(r5));
    L8:
        return this.f.submit(r5, r4);
    L10:
        return super.submit(r5, r4);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        a(true, r5, r3);
        super.beforeExecute(r3, r5);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable r5, Throwable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        super.afterExecute(r7, r6);
        a(false, r7, null);
        if (ZeusTransformUtils.instanceOf(r7, ScheduledFuture.class) == false) goto L18;
        ScheduledFuture r8 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(r7, ScheduledFuture.class, "com.obric.aiagent.plugin");
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(this.f8899e.get(r8), Pair.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.first == null) goto L20;
        int r2 = ((Integer) ZeusTransformUtils.preCheckCast(r0.first, Integer.class, "com.obric.aiagent.plugin")).intValue();
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(r0.second, Boolean.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.booleanValue() == false) goto L14;
        return;
    L14:
        if (b() == false) goto L16;
        a("z-debug postDelay or scheduled task: " + r7 + ", taskHashCode: " + r2 + ", in map? " + this.f8898d.containsKey(Integer.valueOf(r2)));
    L16:
        a(Integer.valueOf(r2), r8);
        return;
    L20:
        return;
    }

    private void a(boolean r3, Runnable r4, Thread r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (a() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        this.i = new a(this, r6, r5, this.h);
        return;
    L7:
        this.i = null;
    }

    private boolean a() {
        if (this.h <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void terminated() {
        super.terminated();
    }

    private boolean b() {
        if (this.f8896b == false) goto L9;
        f r1 = this.f8897c;
        if (r1 == null) goto L9;
        if (r1.a() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public void a(ExecutorService r6) {
        final ExecutorService r7 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r6, ExecutorService.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L7;
        this.f = null;
        this.g = null;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, ThreadPoolExecutor.class) == false) goto L9;
        this.g = (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r7, ThreadPoolExecutor.class, "com.obric.aiagent.plugin");
    L9:
        this.f = (ExecutorService) ZeusTransformUtils.preCheckCast(Proxy.newProxyInstance(r7.getClass().getClassLoader(), new Class[]{ExecutorService.class}, new AnonymousClass1(this, r7)), ExecutorService.class, "com.obric.aiagent.plugin");
    }

    private String a(Runnable r2) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, e.class) == true) goto L5;
        if (r1 != null) goto L10;
        return "null";
    L10:
        return r1.toString();
    L5:
        return ((e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin")).a();
    }

    @Override // com.bytedance.monitor.a.b.a.c
    public void a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (b() == false) goto L5;
        a("post " + com.bytedance.monitor.a.b.c.a(r4));
    L5:
        submit(r4);
        c();
        if (this.f == null) goto L8;
        return;
    L8:
        if (b() == false) goto L12;
        a("current task count: " + getQueue().size());
        return;
    }

    @Override // com.bytedance.monitor.a.b.a.c
    public void b(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        ThreadPoolExecutor r0 = this.g;
        if (r0 == null) goto L6;
        r0.remove(r4);
    L6:
        if (c(r4) == false) goto L8;
        return;
    L8:
        if (b() == false) goto L12;
        a("z-debug-removeTask " + com.bytedance.monitor.a.b.c.a(r4) + ", remove failed");
        return;
    }

    @Override // com.bytedance.monitor.a.b.a.c
    public void a(e r3, long r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return;
    L6:
        if (b() == false) goto L8;
        a("postDelayed " + com.bytedance.monitor.a.b.c.a(r5));
    L8:
        a(schedule(r5, r4, TimeUnit.MILLISECONDS), r5.hashCode(), false);
        c();
    }

    @Override // com.bytedance.monitor.a.b.a.c
    public void a(e r8, long r9, long r11) {
        e r10 = (e) ZeusTransformUtils.wrapperContextForParams(r8, e.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        return;
    L6:
        if (b() == false) goto L8;
        a("scheduleWithFixedDelay " + com.bytedance.monitor.a.b.c.a(r10) + ", initialDelay: " + r9 + ", delayInMillis: " + r11 + "\n task count: " + getQueue().size());
    L8:
        c(r10);
        a(scheduleWithFixedDelay(r10, r9, r11, TimeUnit.MILLISECONDS), r10.hashCode(), true);
        c();
    }

    public void a(f r3) {
        this.f8897c = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
    }

    private void a(String r2) {
        com.bytedance.monitor.a.b.c.a(this.f8897c, "ApmInnerThreadPool", r2);
    }

    private void c() {
        a r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a() == false) goto L9;
        this.i.b();
        this.i = null;
        return;
    }

    private boolean c(e r8) {
        e r9 = (e) ZeusTransformUtils.wrapperContextForParams(r8, e.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
        if (r9 != null) goto L5;
        return false;
    L5:
        int r2 = r9.hashCode();
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.f8898d.get(Integer.valueOf(r2)), List.class, "com.obric.aiagent.plugin");
        StringBuilder r4 = new StringBuilder().append("z-debug scheduledFutures in ?");
        if (r3 == null) goto L8;
        boolean r6 = true;
    L9:
        a(r4.append(r6).toString());
        if (r3 != null) goto L12;
    L25:
        return r0;
    L12:
        if (r3.isEmpty() == true) goto L25;
        if (b() == false) goto L16;
        a("z-debug-removeTask from mTaskFutureMap" + com.bytedance.monitor.a.b.c.a(r9));
        a("z-debug scheduledFutures size:" + r3.size());
    L16:
        Iterator r10 = r3.iterator();
    L18:
        if (r10.hasNext() == false) goto L25;
        ScheduledFuture r5 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(r10.next(), ScheduledFuture.class, "com.obric.aiagent.plugin");
        if (r5.isCancelled() == true) goto L18;
        if (r5.cancel(true) == false) goto L24;
        r0 = true;
    L24:
        a(Integer.valueOf(r2), r5);
        goto L18
    L8:
        r6 = false;
        goto L9
    }

    private void a(ScheduledFuture<?> r4, int r5, boolean r6) {
        ScheduledFuture<?> r7 = (ScheduledFuture) ZeusTransformUtils.wrapperContextForParams(r4, ScheduledFuture.class, "com.obric.aiagent.plugin");
        List<ScheduledFuture<?>> r0 = (List) ZeusTransformUtils.preCheckCast(this.f8898d.get(Integer.valueOf(r5)), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArrayList();
        this.f8898d.put(Integer.valueOf(r5), r0);
    L5:
        r0.add(r7);
        this.f8899e.put(r7, new Pair(Integer.valueOf(r5), Boolean.valueOf(r6)));
        if (b() == false) goto L9;
        a("z-debug saveToMap -current task count: " + getQueue().size() + ", thread-count; " + getActiveCount());
        a("z-debug saveToMap >>>>>> mTaskFutureMap size: " + this.f8898d.size() + ", mFutureTaskMap size: " + this.f8899e.size());
        a("z-debug saveToMap >>>>>> sameHashCodeFutures size: " + r0.size());
        return;
    }

    private void a(Integer r4, ScheduledFuture r5) {
        ScheduledFuture r6 = (ScheduledFuture) ZeusTransformUtils.wrapperContextForParams(r5, ScheduledFuture.class, "com.obric.aiagent.plugin");
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.f8898d.get(r4), List.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        boolean r1 = r0.remove(r6);
        if (r0.isEmpty() == false) goto L8;
        this.f8898d.remove(r4);
    L8:
        this.f8899e.remove(r6);
        if (b() == false) goto L12;
        a("z-debug removeMapRecord: " + r6 + ", removed: " + r1);
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }
}
