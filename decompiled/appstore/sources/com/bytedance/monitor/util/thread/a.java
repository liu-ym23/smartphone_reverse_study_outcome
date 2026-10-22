package com.bytedance.monitor.util.thread;

import com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory;
import com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class a implements IAsyncTaskManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f7841g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f7842h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f7843i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile l5.a f7844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile l5.a f7845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile l5.a f7846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f7847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadLogListener f7848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IAsyncTaskManager.ExceptionListener f7849f;

    /* JADX INFO: renamed from: com.bytedance.monitor.util.thread.a$a, reason: collision with other inner class name */
    public class C0097a implements ApmInnerThreadFactory.IThreadIdCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7850a;

        public C0097a(a r10) {
            this.f7850a = r10;
        }

        @Override // com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory.IThreadIdCallback
        public void onTid(long r10) {
            a.a(this.f7850a).put(AsyncTaskType.IO, Long.valueOf(r10));
        }
    }

    public class b implements ApmInnerThreadFactory.IThreadIdCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7851a;

        public b(a r10) {
            this.f7851a = r10;
        }

        @Override // com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory.IThreadIdCallback
        public void onTid(long r10) {
            a.a(this.f7851a).put(AsyncTaskType.LIGHT_WEIGHT, Long.valueOf(r10));
        }
    }

    public class c implements ApmInnerThreadFactory.IThreadIdCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7852a;

        public c(a r10) {
            this.f7852a = r10;
        }

        @Override // com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory.IThreadIdCallback
        public void onTid(long r10) {
            a.a(this.f7852a).put(AsyncTaskType.TIME_SENSITIVE, Long.valueOf(r10));
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7853a = null;

        static {
            f7853a = new a();
        }
    }

    static {
        f7841g = new Object();
        f7842h = new Object();
        f7843i = new Object();
    }

    public a() {
        this.f7847d = new ConcurrentHashMap(3);
    }

    public static /* synthetic */ Map a(a r10) {
        return r10.f7847d;
    }

    public static a d() {
        return d.f7853a;
    }

    public final IAsyncTaskHandler b(TaskRunnable r10) {
        AsyncTaskType r11 = r10.getTaskType();
        if (r11 != AsyncTaskType.IO) goto L7;
        return c();
    L7:
        if (r11 != AsyncTaskType.TIME_SENSITIVE) goto L11;
        return f();
    L11:
        return e();
    }

    public l5.a c() {
        if (this.f7844a != null) goto L16;
        Object r10 = f7841g;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f7844a != null) goto L11;
        g(this.f7848e);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L16:
        return this.f7844a;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void directReportError(Throwable r10, String r11) {
        IAsyncTaskManager.ExceptionListener r12 = this.f7849f;
        if (r12 == null) goto L6;
        r12.directReportError(r10, r11);
        return;
    }

    public l5.a e() {
        if (this.f7845b != null) goto L16;
        Object r10 = f7842h;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f7845b != null) goto L11;
        h(this.f7848e);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L16:
        return this.f7845b;
    }

    public l5.a f() {
        if (this.f7846c != null) goto L16;
        Object r10 = f7843i;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f7846c != null) goto L11;
        i(this.f7848e);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L16:
        return this.f7846c;
    }

    public final void g(ThreadLogListener r10) {
        Object r11 = f7841g;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f7844a != null) goto L9;
        ApmInnerThreadFactory r12 = new ApmInnerThreadFactory("io-task");     // Catch: Throwable -> L7
        r12.c(r10);     // Catch: Throwable -> L7
        r12.d(new C0097a(this));     // Catch: Throwable -> L7
        l5.a r13 = new l5.a(1, r12);     // Catch: Throwable -> L7
        r13.setThreadLogListener(r10);     // Catch: Throwable -> L7
        this.f7844a = r13;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public ExecutorService getIOExecutor() {
        return c();
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public ThreadLogListener getThreadLogListener() {
        return this.f7848e;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public long getWorkThreadId(AsyncTaskType r10) {
        Long r11 = (Long) this.f7847d.get(r10);
        if (r11 != null) goto L5;
        return -1;
    L5:
        return r11.longValue();
    }

    public final void h(ThreadLogListener r10) {
        Object r11 = f7842h;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f7845b != null) goto L9;
        ApmInnerThreadFactory r12 = new ApmInnerThreadFactory("light-weight-task");     // Catch: Throwable -> L7
        r12.c(r10);     // Catch: Throwable -> L7
        r12.d(new b(this));     // Catch: Throwable -> L7
        l5.a r13 = new l5.a(1, r12);     // Catch: Throwable -> L7
        r13.setThreadLogListener(r10);     // Catch: Throwable -> L7
        this.f7845b = r13;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
    }

    public final void i(ThreadLogListener r10) {
        Object r11 = f7843i;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f7846c != null) goto L9;
        ApmInnerThreadFactory r12 = new ApmInnerThreadFactory("time-sensitive-task");     // Catch: Throwable -> L7
        r12.c(r10);     // Catch: Throwable -> L7
        r12.d(new c(this));     // Catch: Throwable -> L7
        l5.a r13 = new l5.a(1, r12);     // Catch: Throwable -> L7
        r13.setThreadLogListener(r10);     // Catch: Throwable -> L7
        this.f7846c = r13;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public boolean isPending(TaskRunnable r10) {
        return b(r10).isPending(r10);
    L4:
        th = move-exception;
        directReportError(th, "Apm-Async-task-isPending");
        return false;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void post(TaskRunnable r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        b(r10).post(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        directReportError(th, "Apm-Async-task-post");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void postDelayed(TaskRunnable r10, long r11) {
        if (r10 != null) goto L9;
        return;
    L9:
        b(r10).postDelayed(r10, r11);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        directReportError(th, "Apm-Async-task-postDelayed");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void release() {
        c().release();     // Catch: Throwable -> L4
        e().release();     // Catch: Throwable -> L4
        f().release();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        directReportError(th, "Apm-Async-task-release");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void removeTask(TaskRunnable r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        b(r10).removeTask(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        directReportError(th, "Apm-Async-task-removeTask");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void scheduleWithFixedDelay(TaskRunnable r10, long r11, long r12) {
        if (r10 != null) goto L9;
        return;
    L9:
        b(r10).scheduleWithFixedDelay(r10, r11, r12);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        directReportError(th, "Apm-Async-task-removeTask");
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setExceptionListener(IAsyncTaskManager.ExceptionListener r10) {
        this.f7849f = r10;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setIOExecutor(ExecutorService r10) {
        c().l(r10);
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setTaskOverTime(AsyncTaskType r10, int r11) {
        if (r10 != AsyncTaskType.IO) goto L6;
        c().m(r11);
        return;
    L6:
        if (r10 != AsyncTaskType.TIME_SENSITIVE) goto L8;
        f().m(r11);
        return;
    L8:
        e().m(r11);
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void setThreadLogListener(ThreadLogListener r10) {
        this.f7848e = r10;
        c().setThreadLogListener(r10);
        e().setThreadLogListener(r10);
        f().setThreadLogListener(r10);
    }
}
