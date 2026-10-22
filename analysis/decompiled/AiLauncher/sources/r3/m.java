package r3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    public boolean f38803b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f38802a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Queue f38804c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f38805d = new AtomicReference();

    public void a(Executor executor, Runnable runnable) {
        synchronized (this.f38802a) {
            try {
                if (this.f38803b) {
                    this.f38804c.add(new C5204F(executor, runnable, null));
                } else {
                    this.f38803b = true;
                    e(executor, runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (this.f38802a) {
            try {
                if (this.f38804c.isEmpty()) {
                    this.f38803b = false;
                } else {
                    C5204F c5204f = (C5204F) this.f38804c.remove();
                    e(c5204f.f38755a, c5204f.f38756b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(Executor executor, final Runnable runnable) {
        try {
            executor.execute(new Runnable() { // from class: r3.D
                @Override // java.lang.Runnable
                public final void run() {
                    C5206H c5206h = new C5206H(this.f38753a, null);
                    try {
                        runnable.run();
                        c5206h.close();
                    } catch (Throwable th) {
                        try {
                            c5206h.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            d();
        }
    }
}
