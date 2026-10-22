package N;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class d implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static volatile Executor f4776b;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f4777a = Executors.newSingleThreadExecutor(new a());

    public class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(10);
            thread.setName("CameraX-camerax_high_priority");
            return thread;
        }
    }

    public static Executor a() {
        if (f4776b != null) {
            return f4776b;
        }
        synchronized (d.class) {
            try {
                if (f4776b == null) {
                    f4776b = new d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4776b;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4777a.execute(runnable);
    }
}
