package N;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class b implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f4763a;

    public static Executor a() {
        if (f4763a != null) {
            return f4763a;
        }
        synchronized (b.class) {
            try {
                if (f4763a == null) {
                    f4763a = new b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4763a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
