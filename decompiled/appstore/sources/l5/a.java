package l5;

import android.util.Pair;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.monitor.util.thread.ThreadLogListener;
import com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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

/* JADX INFO: loaded from: classes.dex */
public class a extends ScheduledThreadPoolExecutor implements IAsyncTaskHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ThreadLogListener f21821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f21822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f21823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExecutorService f21824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ThreadPoolExecutor f21825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f21827i;

    /* JADX INFO: renamed from: l5.a$a, reason: collision with other inner class name */
    public class C0301a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExecutorService f21828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f21829b;

        public C0301a(a r10, ExecutorService r11) {
            this.f21829b = r10;
            this.f21828a = r11;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) {
            Object r13 = r11.invoke(this.f21828a, r12);
            if (a.a(this.f21829b) == false) goto L12;
            String r14 = "null";
            if (r12 == null) goto L9;
            int r15 = r12.length;
            int r16 = 0;
        L7:
            if (r16 >= r15) goto L9;
            r14 = r14 + r12[r16];
            r16 = r16 + 1;
        L9:
            a.b(this.f21829b, "call outer-executor " + r11.getName() + ", args: " + r14);
            if ("submit".equals(r11.getName()) == false) goto L12;
            a.b(this.f21829b, "call outer-executor " + r11.getName() + ", args: " + r14);
        L12:
            return r13;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f21830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Thread f21831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f21832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f21834e;

        public b(a r10, Runnable r11, Thread r12, int r13) {
            this.f21834e = r10;
            this.f21830a = r11;
            this.f21831b = r12;
            this.f21832c = System.currentTimeMillis();
            this.f21833d = r13;
        }

        public void a() {
            Runnable r10 = this.f21830a;
            if (r10 != null) goto L6;
            return;
        L6:
            if ((r10 instanceof FutureTask) == false) goto L11;
            boolean r11 = ((FutureTask) r10).cancel(true);
            if (a.a(this.f21834e) == false) goto L12;
            a.b(this.f21834e, "TimeSensitive + mCancelOverTimeTaskRunnable run ------------ cancel FutureTask, canceled?" + r11);
            return;
        L12:
            return;
        }

        public boolean b() {
            if ((System.currentTimeMillis() - this.f21832c) <= this.f21833d) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public a(int r10, ThreadFactory r11) {
        super(r10, r11);
        this.f21819a = "ApmInnerThreadPool";
        this.f21820b = false;
        this.f21822d = new ConcurrentHashMap();
        this.f21823e = new ConcurrentHashMap();
    }

    public static /* synthetic */ boolean a(a r10) {
        return r10.i();
    }

    public static /* synthetic */ void b(a r10, String r11) {
        r10.g(r11);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable r10, Throwable r11) {
        super.afterExecute(r10, r11);
        e(false, r10, null);
        if ((r10 instanceof ScheduledFuture) == false) goto L18;
        ScheduledFuture r12 = (ScheduledFuture) r10;
        Pair r13 = (Pair) this.f21823e.get(r12);
        if (r13 == null) goto L19;
        Object r14 = r13.first;
        if (r14 == null) goto L20;
        Integer r15 = (Integer) r14;
        int r16 = r15.intValue();
        Boolean r17 = (Boolean) r13.second;
        if (r17 != null) goto L11;
        return;
    L11:
        if (r17.booleanValue() == false) goto L14;
        return;
    L14:
        if (i() == false) goto L16;
        g("z-debug postDelay or scheduled task: " + r10 + ", taskHashCode: " + r16 + ", in map? " + this.f21822d.containsKey(r15));
    L16:
        j(r15, r12);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread r10, Runnable r11) {
        e(true, r11, r10);
        super.beforeExecute(r10, r11);
    }

    public final boolean c(TaskRunnable r10) {
        boolean r11 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        int r12 = r10.hashCode();
        List r13 = (List) this.f21822d.get(Integer.valueOf(r12));
        StringBuilder r14 = new StringBuilder();
        r14.append("z-debug scheduledFutures in ?");
        if (r13 == null) goto L8;
        boolean r15 = true;
    L9:
        r14.append(r15);
        g(r14.toString());
        if (r13 != null) goto L12;
    L25:
        return r11;
    L12:
        if (r13.isEmpty() == true) goto L25;
        if (i() == false) goto L16;
        g("z-debug-removeTask from mTaskFutureMap" + k5.a.b(r10));
        g("z-debug scheduledFutures size:" + r13.size());
    L16:
        Iterator r16 = r13.iterator();
    L18:
        if (r16.hasNext() == false) goto L25;
        ScheduledFuture r17 = (ScheduledFuture) r16.next();
        if (r17.isCancelled() == true) goto L18;
        if (r17.cancel(true) == false) goto L24;
        r11 = true;
    L24:
        j(Integer.valueOf(r12), r17);
        goto L18
    L8:
        r15 = false;
        goto L9
    }

    public final void d() {
        b r10 = this.f21827i;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.b() == false) goto L9;
        this.f21827i.a();
        this.f21827i = null;
        return;
    }

    public final void e(boolean r10, Runnable r11, Thread r12) {
        if (h() == true) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        this.f21827i = new b(this, r11, r12, this.f21826h);
        return;
    L7:
        this.f21827i = null;
    }

    public final String f(Runnable r10) {
        if ((r10 instanceof TaskRunnable) == true) goto L5;
        if (r10 != null) goto L10;
        return "null";
    L10:
        return r10.toString();
    L5:
        return ((TaskRunnable) r10).getTaskName();
    }

    public final void g(String r10) {
        k5.a.c(this.f21821c, "ApmInnerThreadPool", r10);
    }

    public final boolean h() {
        if (this.f21826h <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i() {
        if (this.f21820b == false) goto L9;
        ThreadLogListener r10 = this.f21821c;
        if (r10 == null) goto L9;
        if (r10.isDebug() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public boolean isPending(TaskRunnable r10) {
        ThreadPoolExecutor r11 = this.f21825g;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = getQueue().contains(r10);
        List r13 = (List) this.f21822d.get(Integer.valueOf(r10.hashCode()));
        if (r13 != null) goto L10;
    L17:
        boolean r14 = false;
    L18:
        if (r12 == true) goto L26;
        if (r14 == false) goto L22;
        return true;
    L22:
        return false;
    L26:
        return true;
    L10:
        if (r13.isEmpty() == true) goto L17;
        Iterator r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L17;
        if (((ScheduledFuture) r15.next()).isCancelled() == true) goto L13;
        r14 = true;
        goto L18
    L5:
        if (r11.getQueue().contains(r10) == false) goto L7;
        return true;
    }

    public final void j(Integer r10, ScheduledFuture r11) {
        List r12 = (List) this.f21822d.get(r10);
        if (r12 == null) goto L7;
        boolean r13 = r12.remove(r11);
        if (r12.isEmpty() == false) goto L8;
        this.f21822d.remove(r10);
    L8:
        this.f21823e.remove(r11);
        if (i() == false) goto L12;
        g("z-debug removeMapRecord: " + r11 + ", removed: " + r13);
        return;
    L12:
        return;
    L7:
        r13 = false;
        goto L8
    }

    public final void k(ScheduledFuture r10, int r11, boolean r12) {
        List r13 = (List) this.f21822d.get(Integer.valueOf(r11));
        if (r13 != null) goto L5;
        r13 = new CopyOnWriteArrayList();
        this.f21822d.put(Integer.valueOf(r11), r13);
    L5:
        r13.add(r10);
        this.f21823e.put(r10, new Pair(Integer.valueOf(r11), Boolean.valueOf(r12)));
        if (i() == false) goto L9;
        g("z-debug saveToMap -current task count: " + getQueue().size() + ", thread-count; " + getActiveCount());
        g("z-debug saveToMap >>>>>> mTaskFutureMap size: " + this.f21822d.size() + ", mFutureTaskMap size: " + this.f21823e.size());
        StringBuilder r14 = new StringBuilder();
        r14.append("z-debug saveToMap >>>>>> sameHashCodeFutures size: ");
        r14.append(r13.size());
        g(r14.toString());
        return;
    }

    public void l(ExecutorService r10) {
        if (r10 != null) goto L6;
        this.f21824f = null;
        this.f21825g = null;
        return;
    L6:
        if ((r10 instanceof ThreadPoolExecutor) == false) goto L8;
        this.f21825g = (ThreadPoolExecutor) r10;
    L8:
        this.f21824f = (ExecutorService) Proxy.newProxyInstance(r10.getClass().getClassLoader(), new Class[]{ExecutorService.class}, new C0301a(this, r10));
    }

    public void m(int r10) {
        this.f21826h = r10;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void post(TaskRunnable r10) {
        if (i() == false) goto L5;
        g("post " + k5.a.b(r10));
    L5:
        submit(r10);
        d();
        if (this.f21824f == null) goto L8;
        return;
    L8:
        if (i() == false) goto L12;
        g("current task count: " + getQueue().size());
        return;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void postDelayed(TaskRunnable r10, long r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (i() == false) goto L7;
        g("postDelayed " + k5.a.b(r10));
    L7:
        k(schedule(r10, r11, TimeUnit.MILLISECONDS), r10.hashCode(), false);
        d();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void release() {
        ExecutorService r10 = this.f21824f;
        if (r10 == null) goto L5;
        r10.shutdown();
    L5:
        shutdown();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void removeTask(TaskRunnable r10) {
        ThreadPoolExecutor r11 = this.f21825g;
        if (r11 == null) goto L6;
        r11.remove(r10);
    L6:
        if (c(r10) == false) goto L8;
        return;
    L8:
        if (i() == false) goto L12;
        g("z-debug-removeTask " + k5.a.b(r10) + ", remove failed");
        return;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void scheduleWithFixedDelay(TaskRunnable r10, long r11, long r12) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (i() == false) goto L7;
        g("scheduleWithFixedDelay " + k5.a.b(r10) + ", initialDelay: " + r11 + ", delayInMillis: " + r12 + "\n task count: " + getQueue().size());
    L7:
        c(r10);
        k(scheduleWithFixedDelay(r10, r11, r12, TimeUnit.MILLISECONDS), r10.hashCode(), true);
        d();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void setThreadLogListener(ThreadLogListener r10) {
        this.f21821c = r10;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable r10) {
        if (this.f21824f == null) goto L10;
        if (i() == false) goto L8;
        g("submit task to outer-executor: " + f(r10));
    L8:
        return this.f21824f.submit(r10);
    L10:
        return super.submit(r10);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void terminated() {
        super.terminated();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Callable r10) {
        if (this.f21824f == null) goto L10;
        if (i() == false) goto L8;
        g("submit task to outer-executor: " + r10);
    L8:
        return this.f21824f.submit(r10);
    L10:
        return super.submit(r10);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable r10, Object r11) {
        if (this.f21824f == null) goto L10;
        if (i() == false) goto L8;
        g("submit task to outer-executor: " + f(r10));
    L8:
        return this.f21824f.submit(r10, r11);
    L10:
        return super.submit(r10, r11);
    }
}
