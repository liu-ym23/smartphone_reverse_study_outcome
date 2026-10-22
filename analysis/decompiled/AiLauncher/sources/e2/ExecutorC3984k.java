package e2;

import h2.C4124a;
import java.util.concurrent.Executor;

/* renamed from: e2.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ExecutorC3984k implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f32272a;

    /* renamed from: e2.k$a */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f32273a;

        public a(Runnable runnable) {
            this.f32273a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f32273a.run();
            } catch (Exception e10) {
                C4124a.c("Executor", "Background execution failure.", e10);
            }
        }
    }

    public ExecutorC3984k(Executor executor) {
        this.f32272a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f32272a.execute(new a(runnable));
    }
}
