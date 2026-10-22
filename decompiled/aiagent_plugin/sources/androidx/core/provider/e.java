package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: RequestExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: compiled from: RequestExecutor.java */
    private static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1321b;

        /* JADX INFO: renamed from: androidx.core.provider.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RequestExecutor.java */
        private static class C0032a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f1322a;

            C0032a(Runnable r3, String r4, int r5) {
                super((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), r4);
                this.f1322a = r5;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f1322a);
                super.run();
            }
        }

        a(String r1, int r2) {
            this.f1320a = r1;
            this.f1321b = r2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            return new C0032a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), this.f1320a, this.f1321b);
        }
    }

    /* JADX INFO: compiled from: RequestExecutor.java */
    private static class b<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Callable<T> f1323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private androidx.core.util.a<T> f1324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Handler f1325c;

        b(Handler r3, Callable<T> r4, androidx.core.util.a<T> r5) {
            Callable<T> r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.aiagent.plugin");
            androidx.core.util.a<T> r7 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r5, androidx.core.util.a.class, "com.obric.aiagent.plugin");
            this.f1323a = r6;
            this.f1324b = r7;
            this.f1325c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T r0 = this.f1323a.call();     // Catch: Exception -> L4
        L5:
            final androidx.core.util.a<T> r1 = this.f1324b;
            this.f1325c.post(new AnonymousClass1(this, r1, r0));
            return;
        L4:
            r0 = null;
            goto L5
        }
    }

    static <T> void a(Executor r2, Callable<T> r3, androidx.core.util.a<T> r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.aiagent.plugin");
        Callable r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.aiagent.plugin");
        androidx.core.util.a r7 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r4, androidx.core.util.a.class, "com.obric.aiagent.plugin");
        r5.execute(new b(androidx.core.provider.b.a(), r6, r7));
    }

    static <T> T a(ExecutorService r2, Callable<T> r3, int r4) {
        return ((ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.aiagent.plugin")).submit((Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.aiagent.plugin")).get(r4, TimeUnit.MILLISECONDS);
    L7:
        e = move-exception;
        throw e;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L6:
        throw new InterruptedException("timeout");
    }

    static ThreadPoolExecutor a(String r8, int r9, int r10) {
        ThreadPoolExecutor r11 = new ThreadPoolExecutor(0, 1, r10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(r8, r9));
        r11.allowCoreThreadTimeOut(true);
        return r11;
    }
}
