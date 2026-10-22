package com.bytedance.monitor.util.thread.inner;

import android.os.Process;
import com.bytedance.monitor.util.thread.ThreadLogListener;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class ApmInnerThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ThreadLogListener f7856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IThreadIdCallback f7857d;

    public interface IThreadIdCallback {
        void onTid(long r10);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f7858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ApmInnerThreadFactory f7859b;

        public a(ApmInnerThreadFactory r10, Runnable r11) {
            this.f7859b = r10;
            this.f7858a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            if (ApmInnerThreadFactory.a(this.f7859b) == null) goto L14;
            ApmInnerThreadFactory.a(this.f7859b).onTid(Thread.currentThread().getId());
        L14:
            Runnable r10 = this.f7858a;     // Catch: Throwable -> L9
            if (r10 == null) goto L16;
            r10.run();     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            k5.a.a().directReportError(th, "APM_INNER_ERROR_async_task");
            if (ApmInnerThreadFactory.b(this.f7859b) == null) goto L17;
            ApmInnerThreadFactory.b(this.f7859b).onError(this.f7859b.f7854a, th.getMessage());
            return;
        }
    }

    public ApmInnerThreadFactory(String r10) {
        this.f7854a = getClass().getSimpleName();
        this.f7855b = "APM_" + r10;
    }

    public static /* synthetic */ IThreadIdCallback a(ApmInnerThreadFactory r10) {
        return r10.f7857d;
    }

    public static /* synthetic */ ThreadLogListener b(ApmInnerThreadFactory r10) {
        return r10.f7856c;
    }

    public void c(ThreadLogListener r10) {
        this.f7856c = r10;
    }

    public void d(IThreadIdCallback r10) {
        this.f7857d = r10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        return new Thread(new a(this, r10), this.f7855b);
    }
}
