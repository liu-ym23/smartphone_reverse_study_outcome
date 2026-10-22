package C;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
class h {

    private static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private String f283a;

        /* renamed from: b, reason: collision with root package name */
        private int f284b;

        /* renamed from: C.h$a$a, reason: collision with other inner class name */
        private static class C0008a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            private final int f285a;

            C0008a(Runnable runnable, String str, int i5) {
                super(runnable, str);
                this.f285a = i5;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.f285a);
                super.run();
            }
        }

        a(String str, int i5) {
            this.f283a = str;
            this.f284b = i5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0008a(runnable, this.f283a, this.f284b);
        }
    }

    private static class b<T> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Callable<T> f286a;

        /* renamed from: b, reason: collision with root package name */
        private D.a<T> f287b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f288c;

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ D.a f289a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f290b;

            a(D.a aVar, Object obj) {
                this.f289a = aVar;
                this.f290b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f289a.accept(this.f290b);
            }
        }

        b(Handler handler, Callable<T> callable, D.a<T> aVar) {
            this.f286a = callable;
            this.f287b = aVar;
            this.f288c = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            T tCall;
            try {
                tCall = this.f286a.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f288c.post(new a(this.f287b, tCall));
        }
    }

    static ThreadPoolExecutor a(String str, int i5, int i6) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i6, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i5));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(Executor executor, Callable<T> callable, D.a<T> aVar) {
        executor.execute(new b(C.b.a(), callable, aVar));
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable, int i5) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i5, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e6) {
            throw e6;
        } catch (ExecutionException e7) {
            throw new RuntimeException(e7);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
