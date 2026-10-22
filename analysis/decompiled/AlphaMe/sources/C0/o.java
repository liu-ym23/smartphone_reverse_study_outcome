package C0;

import androidx.appcompat.widget.RunnableC0209k;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class o implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f310b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f311c;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f309a = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final Object f312d = new Object();

    public o(ExecutorService executorService) {
        this.f310b = executorService;
    }

    public final void a() {
        Runnable runnable = (Runnable) this.f309a.poll();
        this.f311c = runnable;
        if (runnable != null) {
            this.f310b.execute(runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f312d) {
            try {
                this.f309a.add(new RunnableC0209k(this, runnable, 10));
                if (this.f311c == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
