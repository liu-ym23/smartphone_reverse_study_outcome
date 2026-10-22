package N;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class e implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static volatile Executor f4779b;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f4780a = Executors.newFixedThreadPool(2, new a());

    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f4781a = new AtomicInteger(0);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, "CameraX-camerax_io_%d", Integer.valueOf(this.f4781a.getAndIncrement())));
            return thread;
        }
    }

    public static Executor a() {
        if (f4779b != null) {
            return f4779b;
        }
        synchronized (e.class) {
            try {
                if (f4779b == null) {
                    f4779b = new e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4779b;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4780a.execute(runnable);
    }
}
