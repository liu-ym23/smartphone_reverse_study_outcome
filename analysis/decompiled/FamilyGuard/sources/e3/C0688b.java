package e3;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: e3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0688b {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f16705a;

    /* renamed from: e3.b$b, reason: collision with other inner class name */
    private static class C0211b {

        /* renamed from: a, reason: collision with root package name */
        private static final C0688b f16706a = new C0688b();
    }

    public static /* synthetic */ Thread a(Runnable runnable) {
        return new Thread(runnable, "GlobalTask");
    }

    public static void b(Runnable runnable) {
        c().f16705a.execute(runnable);
    }

    public static C0688b c() {
        return C0211b.f16706a;
    }

    private C0688b() {
        this.f16705a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: e3.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C0688b.a(runnable);
            }
        });
    }
}
