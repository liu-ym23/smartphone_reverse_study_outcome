package k5;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.monitor.util.thread.ThreadLogListener;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: k5.a$a, reason: collision with other inner class name */
    public static class C0287a implements TaskRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AsyncTaskType f21032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f21033c;

        public C0287a(String r10, AsyncTaskType r11, Runnable r12) {
            this.f21031a = r10;
            this.f21032b = r11;
            this.f21033c = r12;
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public String getTaskName() {
            return this.f21031a;
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public AsyncTaskType getTaskType() {
            return this.f21032b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r10 = this.f21033c;     // Catch: Throwable -> L12
            if (r10 == null) goto L17;
            r10.run();     // Catch: Throwable -> L12
            IAsyncTaskManager r11 = a.a();     // Catch: Throwable -> L12
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.getThreadLogListener() != null) goto L9;
            return;
        L9:
            if (r11.getThreadLogListener().isDebug() == false) goto L20;
            a.c(r11.getThreadLogListener(), "AsyncTaskUtil", "task execute: " + this.f21032b + "  /  " + this.f21031a);     // Catch: Throwable -> L12
            return;
        L20:
            return;
        L17:
            return;
        L12:
            th = move-exception;
            a.a().directReportError(th, "APM_INNER_ERROR_async_task");
        }
    }

    public static IAsyncTaskManager a() {
        return com.bytedance.monitor.util.thread.a.d();
    }

    public static String b(TaskRunnable r10) {
        if (r10 != null) goto L6;
        return "null";
    L6:
        return r10.getTaskName() + ", " + r10.getTaskType();
    }

    public static void c(ThreadLogListener r10, String r11, String r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isDebug() == false) goto L8;
        String r13 = Thread.currentThread().getName();
        r10.onLog(r11, String.format(Locale.CHINA, "[callerThread: %s] \n %s", new Object[]{r13, r12}));
        return;
    }

    public static TaskRunnable d(String r10, Runnable r11) {
        return e(AsyncTaskType.LIGHT_WEIGHT, r10, r11);
    }

    public static TaskRunnable e(AsyncTaskType r10, String r11, Runnable r12) {
        return new C0287a(r11, r10, r12);
    }
}
