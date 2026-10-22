package y0;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class h {

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public String f43792a;

        /* renamed from: b, reason: collision with root package name */
        public int f43793b;

        /* renamed from: y0.h$a$a, reason: collision with other inner class name */
        public static class C0555a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            public final int f43794a;

            public C0555a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f43794a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.f43794a);
                super.run();
            }
        }

        public a(String str, int i10) {
            this.f43792a = str;
            this.f43793b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0555a(runnable, this.f43792a, this.f43793b);
        }
    }

    public static class b implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f43795a;

        public b(Handler handler) {
            this.f43795a = (Handler) B0.h.f(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f43795a.post((Runnable) B0.h.f(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f43795a + " is shutting down");
        }
    }

    public static class c<T> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Callable<T> f43796a;

        /* renamed from: b, reason: collision with root package name */
        public B0.a<T> f43797b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f43798c;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ B0.a f43799a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f43800b;

            public a(B0.a aVar, Object obj) {
                this.f43799a = aVar;
                this.f43800b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f43799a.accept(this.f43800b);
            }
        }

        public c(Handler handler, Callable<T> callable, B0.a<T> aVar) {
            this.f43796a = callable;
            this.f43797b = aVar;
            this.f43798c = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            T tCall;
            try {
                tCall = this.f43796a.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f43798c.post(new a(this.f43797b, tCall));
        }
    }

    public static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b(Handler handler) {
        return new b(handler);
    }

    public static <T> void c(Executor executor, Callable<T> callable, B0.a<T> aVar) {
        executor.execute(new c(y0.b.a(), callable, aVar));
    }

    public static <T> T d(ExecutorService executorService, Callable<T> callable, int i10) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
