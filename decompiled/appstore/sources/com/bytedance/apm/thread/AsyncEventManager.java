package com.bytedance.apm.thread;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class AsyncEventManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f6523h = 30000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f6524i = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ExecutorService f6525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f6526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IAsyncTaskManager f6527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TaskRunnable f6528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TaskRunnable f6529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CopyOnWriteArraySet f6530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CopyOnWriteArraySet f6531g;

    public interface IMonitorTimeTask {
        void onTimeEvent(long r10);
    }

    public class a implements TaskRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncEventManager f6532a;

        public a(AsyncEventManager r10) {
            this.f6532a = r10;
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public String getTaskName() {
            return "AsyncEventManager-mTimerRunnable";
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f6532a.f6530f.iterator();
        L4:
            if (r10.hasNext() == false) goto L7;
            ((IMonitorTimeTask) r10.next()).onTimeEvent(System.currentTimeMillis());
            goto L4
        L7:
            if (AsyncEventManager.a(this.f6532a) == false) goto L11;
            this.f6532a.i(this, AsyncEventManager.f6523h);
            return;
        }
    }

    public class b implements TaskRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncEventManager f6533a;

        public b(AsyncEventManager r10) {
            this.f6533a = r10;
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public String getTaskName() {
            return "AsyncEventManager-mControlledTimerRunnable";
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f6533a.f6531g.iterator();
        L4:
            if (r10.hasNext() == false) goto L7;
            ((IMonitorTimeTask) r10.next()).onTimeEvent(System.currentTimeMillis());
            goto L4
        L7:
            if (AsyncEventManager.a(this.f6533a) == false) goto L11;
            this.f6533a.i(this, AsyncEventManager.b());
            return;
        }
    }

    public class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncEventManager f6534a;

        public c(AsyncEventManager r10) {
            this.f6534a = r10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            return new Thread(r10, "Apm_Normal");
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AsyncEventManager f6535a = null;

        static {
            f6535a = new AsyncEventManager(null);
        }
    }

    static {
    }

    public /* synthetic */ AsyncEventManager(a r10) {
        this();
    }

    public static /* synthetic */ boolean a(AsyncEventManager r10) {
        return r10.f6526b;
    }

    public static /* synthetic */ long b() {
        return f6524i;
    }

    public static AsyncEventManager e() {
        return d.f6535a;
    }

    public void addControlledTimeTask(IMonitorTimeTask r10) {
        if (r10 == null) goto L10;
        if (this.f6526b == false) goto L11;
        this.f6531g.add(r10);     // Catch: Throwable -> L7
        k(this.f6529e);     // Catch: Throwable -> L7
        i(this.f6529e, f6524i);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void addTimeTask(IMonitorTimeTask r10) {
        if (r10 == null) goto L12;
        if (this.f6526b == true) goto L6;
        return;
    L6:
        if (this.f6530f.contains(r10) == true) goto L14;
        this.f6530f.add(r10);     // Catch: Throwable -> L9
        k(this.f6528d);     // Catch: Throwable -> L9
        i(this.f6528d, f6523h);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L15:
        return;
    }

    public void c(Runnable r10) {
        IAsyncTaskManager r11 = this.f6527c;
        if (r11 == null) goto L8;
        if (r10 == null) goto L9;
        r11.post(o(r10, "post"));
        return;
    L9:
        return;
    }

    public void d(TaskRunnable r10, long r11) {
        IAsyncTaskManager r12 = this.f6527c;
        if (r12 == null) goto L8;
        if (r10 == null) goto L9;
        r12.postDelayed(r10, r11);
        return;
    L9:
        return;
    }

    public boolean f() {
        if (this.f6527c != null) goto L5;
    L7:
        return false;
    L5:
        if (Thread.currentThread().getId() != this.f6527c.getWorkThreadId(AsyncTaskType.LIGHT_WEIGHT)) goto L7;
        return true;
    }

    public void g(ExecutorService r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        this.f6525a = r10;     // Catch: Throwable -> L8
        IAsyncTaskManager r11 = this.f6527c;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        r11.setIOExecutor(r10);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void h(Runnable r10) {
        if (this.f6527c == null) goto L10;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f6526b == false) goto L12;
        this.f6527c.post(o(r10, "post"));
        return;
    L12:
        return;
    }

    public void i(TaskRunnable r10, long r11) {
        if (this.f6527c == null) goto L10;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f6526b == false) goto L12;
        this.f6527c.postDelayed(r10, r11);
        return;
    L12:
        return;
    }

    public void j(Runnable r10, long r11) {
        if (this.f6527c == null) goto L10;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f6526b == false) goto L12;
        this.f6527c.postDelayed(o(r10, "postDelayed"), r11);
        return;
    L12:
        return;
    }

    public void k(TaskRunnable r10) {
        IAsyncTaskManager r11 = this.f6527c;
        if (r11 == null) goto L8;
        if (r10 == null) goto L9;
        r11.removeTask(r10);
        return;
    L9:
        return;
    }

    public void l() {
        this.f6526b = true;
        if (this.f6530f.isEmpty() == true) goto L6;
        k(this.f6528d);
        i(this.f6528d, f6523h);
    L6:
        if (this.f6531g.isEmpty() == true) goto L9;
        k(this.f6529e);
        i(this.f6529e, f6524i);
        return;
    }

    public void m() {
        this.f6526b = false;
        k(this.f6528d);
        k(this.f6529e);
    }

    public void n(Runnable r10) {
        if (this.f6525a != null) goto L17;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f6525a != null) goto L13;
        IAsyncTaskManager r11 = this.f6527c;     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        this.f6525a = r11.getIOExecutor();     // Catch: Throwable -> L10
        goto L13
    L12:
        this.f6525a = Executors.newFixedThreadPool(1, new c(this));     // Catch: Throwable -> L10
    L13:
        monitor-exit(this);     // Catch: Throwable -> L10
    L17:
        this.f6525a.submit(r10);
    }

    public final TaskRunnable o(Runnable r10, String r11) {
        return k5.a.d("AsyncEventManager-" + r11, r10);
    }

    public void removeControlledTimeTask(IMonitorTimeTask r10) {
        if (r10 == null) goto L10;
        this.f6531g.remove(r10);     // Catch: Throwable -> L7
        if (this.f6531g.isEmpty() == false) goto L11;
        k(this.f6529e);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public void removeTimeTask(IMonitorTimeTask r10) {
        if (r10 == null) goto L8;
        this.f6530f.remove(r10);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public AsyncEventManager() {
        this.f6526b = true;
        this.f6528d = new a(this);
        this.f6529e = new b(this);
        this.f6530f = new CopyOnWriteArraySet();
        this.f6531g = new CopyOnWriteArraySet();
        this.f6527c = k5.a.a();
    }
}
