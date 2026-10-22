package com.bytedance.android.live.initialize.scheduler;

import com.bytedance.android.live.initialize.IWTORepeatableTask;
import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.android.live.initialize.LiveWTO;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadPoolHelper;
import com.bytedance.android.live.initialize.WTOThreadWorkType;
import com.bytedance.android.live.initialize.api.IWTOLogger;
import com.bytedance.android.live.initialize.model.WTOTaskProxy;
import com.bytedance.android.live.initialize.state.WTOSchedulerStatus;
import com.bytedance.android.live.initialize.state.WTOTaskStatus;
import com.bytedance.common.jato.Jato;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes45.dex */
public final class WTOTaskScheduler implements wa0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile WTOSchedulerStatus f69421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f69423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f69424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f69425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f69426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.live.initialize.model.a f69427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f69428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReentrantLock f69429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.live.initialize.scheduler.a f69430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Boolean> f69431k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.initialize.a f69432l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.initialize.model.b f69433m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ExecutorService f69434n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final WTOSchedulerNotify f69435o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/initialize/scheduler/WTOTaskScheduler$TaskExecuteError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "msg", "", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TaskExecuteError extends RuntimeException {
        private final Exception exception;
        private final String msg;

        public static /* synthetic */ TaskExecuteError copy$default(TaskExecuteError r100, String r101, Exception r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.msg;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.exception;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.msg;
        }

        public final Exception component2() {
            return this.exception;
        }

        public final TaskExecuteError copy(String r100, Exception r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return new TaskExecuteError(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof TaskExecuteError) == false) goto L10;
            TaskExecuteError r101 = (TaskExecuteError) r100;
            if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.exception, r101.exception) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.msg;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Exception r104 = this.exception;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "TaskExecuteError(msg=" + this.msg + ", exception=" + this.exception + ")";
        }

        public final Exception getException() {
            return this.exception;
        }

        public final String getMsg() {
            return this.msg;
        }

        public TaskExecuteError(String r100, Exception r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super(r100, r101);
            this.msg = r100;
            this.exception = r101;
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WTOTaskProxy f69436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WTOTaskScheduler f69437b;

        public b(WTOTaskProxy r100, WTOTaskScheduler r101) {
            this.f69436a = r100;
            this.f69437b = r101;
        }

        public final void a() {
            IWTOLogger r100 = ya0.a.f567013a;
            ya0.a.c("thread:" + ThreadMethodProxy.currentThread().getId() + ", " + this.f69436a.f69403k.taskBusinessInfo() + " execute finish!");
            if (Intrinsics.areEqual(this.f69436a.f69403k.taskExecutePeriod(), this.f69437b.f69432l) == true) goto L5;
            return;
        L5:
            if (this.f69437b.f69423c.get() != this.f69437b.f69422b) goto L7;
            ya0.a.c("thread:" + ThreadMethodProxy.currentThread().getId() + ", " + this.f69437b.f69432l.f69375b + " block task execute finish!");
            this.f69437b.e();
        L7:
            int r101 = this.f69437b.f69425e.get();
            WTOTaskScheduler r102 = this.f69437b;
            if (r101 == r102.f69424d) goto L12;
            r102.d();
            return;
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

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IWTOTask f69438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WTOTaskScheduler f69439b;

        public c(IWTOTask r100, WTOTaskScheduler r101) {
            this.f69438a = r100;
            this.f69439b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WTOTaskScheduler.g(this.f69439b, com.bytedance.android.live.initialize.model.c.a(this.f69438a), null, null, 6);     // Catch: Throwable -> L4
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
        public final /* synthetic */ WTOTaskScheduler f69440a;

        public d(WTOTaskScheduler r100) {
            this.f69440a = r100;
        }

        public final void a() {
            IWTOLogger r100 = ya0.a.f567013a;
            ya0.a.c("new thread" + ThreadMethodProxy.currentThread().getId() + " to execute task");
            this.f69440a.d();
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

    static {
    }

    public final void d() {
        Object r100 = this.f69428h;
        monitor-enter(r100);
        IWTOTask r101 = (IWTOTask) CollectionsKt.firstOrNull(this.f69433m.a(this.f69432l));     // Catch: Throwable -> L14
        if (r101 == null) goto L7;
        WTOTaskProxy r102 = com.bytedance.android.live.initialize.model.c.a(r101);     // Catch: Throwable -> L14
    L8:
        if (r102 == null) goto L10;
        r102.f69393a = WTOTaskStatus.QUEUE;     // Catch: Throwable -> L14
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L10:
        monitor-exit(r100);
        if (r102 == null) goto L19;
        g(this, r102, null, new b(r102, this), 2);
        return;
    L19:
        return;
    L7:
        r102 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final void e() {
        WTOSchedulerStatus r100 = this.f69421a;
        WTOSchedulerStatus r101 = WTOSchedulerStatus.BLOCK_FINISHED;
        if (r100 == r101) goto L11;
        this.f69421a = r101;
        if (this.f69431k.invoke().booleanValue() == true) goto L9;
        com.bytedance.android.live.initialize.scheduler.a r102 = this.f69430j;
        if (r102 == null) goto L9;
        r102.sendMessage(r102.obtainMessage(SearchCommonConstants.SearchResultType.FILE));
    L9:
        IWTOLogger r103 = ya0.a.f567013a;
        com.bytedance.android.live.initialize.a r104 = this.f69432l;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("finishTime", Long.valueOf(System.currentTimeMillis()));
        r105.put("duration", Long.valueOf(System.currentTimeMillis() - this.f69426f));
        r105.put("schedule_thread_id", Long.valueOf(ThreadMethodProxy.currentThread().getId()));
        r105.put("all_block_size", Integer.valueOf(this.f69422b));
        r105.put("complete_block_size", this.f69423c);
        r105.put("lock_status", Boolean.valueOf(this.f69429i.isLocked()));
        Unit r106 = Unit.INSTANCE;
        ya0.a.d(r104, "     SCHEDULE UNLOCK     ", r105);
        return;
    }

    public final void f() {
        WTOSchedulerStatus r100 = this.f69421a;
        WTOSchedulerStatus r101 = WTOSchedulerStatus.FINISHED;
        if (r100 == r101) goto L6;
        this.f69421a = r101;
        long r102 = System.currentTimeMillis() - this.f69426f;
        com.bytedance.android.live.initialize.a r103 = this.f69432l;
        r103.f69374a = r102;
        this.f69435o.d(10005, r103);
        IWTOLogger r104 = ya0.a.f567013a;
        com.bytedance.android.live.initialize.a r105 = this.f69432l;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("finishTime", Long.valueOf(System.currentTimeMillis()));
        r106.put("duration", Long.valueOf(r102));
        r106.put("schedule_thread_id", Long.valueOf(ThreadMethodProxy.currentThread().getId()));
        r106.put("all_task_size", Integer.valueOf(this.f69424d));
        r106.put("complete_size", this.f69425e);
        Unit r107 = Unit.INSTANCE;
        ya0.a.d(r105, "______SCHEDULE FINISHED______", r106);
        return;
    }

    public final void h() {
        Iterator<T> r100 = this.f69433m.a(this.f69432l).iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        IWTOTask r101 = (IWTOTask) r100.next();
        WTOTaskProxy r102 = com.bytedance.android.live.initialize.model.c.a(r101);
        r102.f69393a = WTOTaskStatus.QUEUE;
        if ((r101 instanceof IWTORepeatableTask) == false) goto L11;
        if (((IWTORepeatableTask) r101).taskThreadWorkType() != WTOThreadWorkType.IO) goto L11;
        ExecutorService r103 = WTOThreadPoolHelper.INSTANCE.getMIOThreadPool();
    L14:
        this.f69434n = r103;
        r103.execute(new c(r101, this));
    L11:
        if (r101.taskPriorityType() != WTOPriorityType.NOW) goto L13;
        r103 = WTOThreadPoolHelper.INSTANCE.getMCpuMixedHighPriorityThreadPool();
        goto L14
    L13:
        r103 = WTOThreadPoolHelper.INSTANCE.getMCpuMixedCommonThreadPool();
        goto L14
    }

    public final void i() {
        IWTOLogger r100 = ya0.a.f567013a;
        ya0.a.c("thread:" + ThreadMethodProxy.currentThread().getId() + ", start schedule " + this.f69432l.f69375b + " tasks");
        Iterator<Integer> r101 = RangesKt.until(1, LiveWTO.INSTANCE.getInitThreadPoolSize()).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        ((IntIterator) r101).nextInt();
        Executor r102 = LiveWTO.INSTANCE.getInitExecutor();
        if (r102 != null) goto L8;
        r102 = WTOThreadPoolHelper.INSTANCE.getMCpuMixedCommonThreadPool();
    L8:
        r102.execute(new d(this));
        goto L4
    L9:
        d();
        Object r103 = this.f69428h;
        monitor-enter(r103);
    L21:
    L18:
        th = move-exception;
        throw th;
    L12:
        if (this.f69425e.get() >= this.f69424d) goto L14;
        IWTOLogger r104 = ya0.a.f567013a;     // Catch: Throwable -> L18
        ya0.a.c("thread:" + ThreadMethodProxy.currentThread().getId() + ",  wait task execute finish!");     // Catch: Throwable -> L18
        this.f69428h.wait();     // Catch: Throwable -> L18
        goto L21
    L14:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r103);
        f();
        IWTOLogger r106 = ya0.a.f567013a;
        ya0.a.c(this.f69432l.f69375b + " all task execute finish!");
    }

    @Override // wa0.c
    public final void a(WTOTaskProxy r100) {
        Intrinsics.checkNotNullParameter(r100, "taskProxy");
        Intrinsics.checkNotNullParameter(r100, "taskProxy");
    }

    @Override // wa0.c
    public final void b(WTOTaskProxy r100) {
        Intrinsics.checkNotNullParameter(r100, "taskProxy");
        Intrinsics.checkNotNullParameter(r100, "taskProxy");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // wa0.c
    public final void c(WTOTaskProxy r100) {
        Intrinsics.checkNotNullParameter(r100, "taskProxy");
        Intrinsics.checkNotNullParameter(r100, "taskProxy");
        if (Intrinsics.areEqual(r100.f69403k.taskExecutePeriod(), this.f69432l) == true) goto L5;
        return;
    L5:
        if (this.f69425e.get() != this.f69424d) goto L13;
        com.bytedance.android.live.initialize.model.a r101 = this.f69427g;
        if (r101 == null) goto L12;
        Object r102 = r101.f69404a.get();
        if (r102 == null) goto L11;
        r101.f69405b.invoke((T) r102);
    L11:
        r101.f69404a.clear();
    L12:
        f();
        return;
    L13:
        h();
    }

    public WTOTaskScheduler(com.bytedance.android.live.initialize.a r100, com.bytedance.android.live.initialize.model.b r101, ExecutorService r102, WTOSchedulerNotify r103) {
        Intrinsics.checkNotNullParameter(r100, "period");
        Intrinsics.checkNotNullParameter(r101, "mWTOTaskManager");
        Intrinsics.checkNotNullParameter(r102, "executorService");
        Intrinsics.checkNotNullParameter(r103, "schedulerNotify");
        this.f69432l = r100;
        this.f69433m = r101;
        this.f69434n = r102;
        this.f69435o = r103;
        this.f69421a = WTOSchedulerStatus.IDLE;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "period");
        CopyOnWriteArrayList<IWTOTask> r104 = r101.f69408c.get(r100);
        if (r104 == null) goto L11;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L10;
        Object r107 = r106.next();
        if (((Boolean) com.bytedance.android.live.initialize.model.c.a((IWTOTask) r107).f69395c.getValue()).booleanValue() == false) goto L6;
        r105.add(r107);
        goto L6
    L10:
        int r108 = r105.size();
    L12:
        this.f69422b = r108;
        this.f69423c = new AtomicInteger(0);
        com.bytedance.android.live.initialize.model.b r109 = this.f69433m;
        com.bytedance.android.live.initialize.a r110 = this.f69432l;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "period");
        CopyOnWriteArrayList<IWTOTask> r111 = r109.f69408c.get(r110);
        if (r111 == null) goto L15;
        int r112 = r111.size();
    L16:
        this.f69424d = r112;
        this.f69425e = new AtomicInteger(0);
        this.f69428h = new Object();
        this.f69429i = new ReentrantLock();
        this.f69431k = new WTOTaskScheduler$unLockAction$1(this);
        return;
    L15:
        r112 = 0;
        goto L16
    L11:
        r108 = 0;
        goto L12
    }

    public static void g(final WTOTaskScheduler r100, final WTOTaskProxy r101, String r110, b r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        r110 = "scheduler";
    L5:
        final String r102 = r110;
        int r113 = r112 & 4;
        Exception r114 = null;
        if (r113 == 0) goto L8;
        final b r103 = null;
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "task");
        Intrinsics.checkNotNullParameter(r102, "source");
        final long r104 = System.currentTimeMillis();
        IWTOLogger r115 = ya0.a.f567013a;
        com.bytedance.android.live.initialize.a r116 = r100.f69432l;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("taskName", (String) r101.f69397e.getValue());
        r105.put("source", r102);
        r105.put("taskInfo", Integer.valueOf(r101.f69403k.taskID()));
        r105.put(DyPayConstant.KEY_START_TIME, Long.valueOf(r104));
        r105.put("threadId", Long.valueOf(ThreadMethodProxy.currentThread().getId()));
        r105.put("taskDetail", (String) r101.f69399g.getValue());
        Unit r117 = Unit.INSTANCE;
        ya0.a.d(r116, "TASK STARTED", r105);
        WTOSchedulerNotify r118 = r100.f69435o;
        Function2<Boolean, Exception, Unit> r119 = new WTOTaskScheduler$runTask$2(r100, r101, r104, r102, r103);
        Intrinsics.checkNotNullParameter(r118, "schNotify");
        Intrinsics.checkNotNullParameter(r119, "callback");
        if (r101.f69393a != WTOTaskStatus.IDLE) goto L12;
    L13:
        r101.f69394b.lock();
        WTOTaskStatus r106 = r101.f69393a;
        WTOTaskStatus r107 = WTOTaskStatus.FINISHED;
        boolean r108 = false;
        if (r106 != r107) goto L58;
    L53:
        r101.f69394b.unlock();
        if (r101.f69393a != r107) goto L56;
        r108 = true;
    L56:
        r119.invoke(Boolean.valueOf(r108), null);
        return;
    L58:
        if (r101.f69393a == WTOTaskStatus.FAILED) goto L53;
        r101.f69393a = WTOTaskStatus.RUNNING;     // Catch: Throwable -> L21 Exception -> L41
        Thread r109 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L21 Exception -> L41
        String r120 = r109.getName();     // Catch: Throwable -> L21 Exception -> L41
        if ((!Intrinsics.areEqual((String) r101.f69398f.getValue(), "")) == false) goto L23;
        String r121 = (String) r101.f69398f.getValue();     // Catch: Throwable -> L21 Exception -> L41
    L24:
        ThreadMethodProxy.setName(r109, r121);     // Catch: Throwable -> L21 Exception -> L41
        r101.f69400h = r109.getId();     // Catch: Throwable -> L21 Exception -> L41
        r118.d(10001, r101);     // Catch: Throwable -> L21 Exception -> L41
        if (((Boolean) r101.f69401i.getValue()).booleanValue() == true) goto L27;
    L33:
        boolean r122 = false;
    L34:
        r101.f69403k.run();     // Catch: Throwable -> L21 Exception -> L41
        if (r122 == false) goto L37;
        Jato.resetCoreBind((int) r101.f69400h);     // Catch: Throwable -> L21 Exception -> L41
        Jato.releaseBoost();     // Catch: Throwable -> L21 Exception -> L41
    L37:
        r101.f69393a = r107;     // Catch: Throwable -> L21 Exception -> L41
        LinkedHashMap r123 = new LinkedHashMap();     // Catch: Throwable -> L21 Exception -> L41
        r123.put("threadName", r109.getName());     // Catch: Throwable -> L21 Exception -> L41
        ya0.a.a("runWithCallback before reset origin name", r123.toString());     // Catch: Throwable -> L21 Exception -> L41
        ThreadMethodProxy.setName(r109, r120);     // Catch: Throwable -> L21 Exception -> L41
        LinkedHashMap r124 = new LinkedHashMap();     // Catch: Throwable -> L21 Exception -> L41
        r124.put("threadName", r109.getName());     // Catch: Throwable -> L21 Exception -> L41
        ya0.a.a("runWithCallback after reset origin name", r124.toString());     // Catch: Throwable -> L21 Exception -> L41
        r101.f69394b.unlock();
        if (r101.f69393a == r107) goto L46;
    L47:
        r119.invoke(Boolean.valueOf(r108), r114);
        return;
    L46:
        r108 = true;
        goto L47
    L27:
        if (r101.f69403k.taskPriorityType() != WTOPriorityType.BACKGROUND) goto L30;
        Jato.bindLittleCore((int) r101.f69400h);     // Catch: Throwable -> L21 Exception -> L41
    L32:
        r122 = true;
        goto L34
    L30:
        if (r101.f69403k.taskPriorityType() != WTOPriorityType.NOW) goto L33;
        Jato.bindBigCore((int) r101.f69400h);     // Catch: Throwable -> L21 Exception -> L41
        Jato.tryCpuBoost(1000);     // Catch: Throwable -> L21 Exception -> L41
        goto L32
    L23:
        r121 = "WTO_" + ((String) r101.f69397e.getValue());     // Catch: Throwable -> L21 Exception -> L41
    L41:
        e = move-exception;
        r114 = e;
        r101.f69393a = WTOTaskStatus.FAILED;     // Catch: Throwable -> L21
        r101.f69394b.unlock();
        if (r101.f69393a != WTOTaskStatus.FINISHED) goto L47;
    L21:
        th = move-exception;
        r101.f69394b.unlock();
        if (r101.f69393a != WTOTaskStatus.FINISHED) goto L51;
        r108 = true;
    L51:
        r119.invoke(Boolean.valueOf(r108), null);
        throw th;
    L12:
        if (r101.f69393a == WTOTaskStatus.QUEUE) goto L13;
        return;
    L8:
        r103 = r111;
        goto L9
    }
}
