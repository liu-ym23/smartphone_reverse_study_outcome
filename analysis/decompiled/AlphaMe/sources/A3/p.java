package A3;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class p extends AtomicReference implements Runnable, t3.h {

    /* renamed from: a, reason: collision with root package name */
    public final B3.l f125a;

    /* renamed from: b, reason: collision with root package name */
    public final x3.a f126b;

    public p(x3.a aVar) {
        this.f126b = aVar;
        this.f125a = new B3.l(0);
    }

    @Override // t3.h
    public final boolean a() {
        return this.f125a.a();
    }

    public final void b(Future future) {
        this.f125a.b(new n(this, future));
    }

    @Override // t3.h
    public final void c() {
        B3.l lVar = this.f125a;
        if (lVar.a()) {
            return;
        }
        lVar.c();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.f126b.b();
            } catch (Throwable th) {
                c();
                throw th;
            }
        } catch (w3.e e4) {
            IllegalStateException illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e4);
            E3.c.a(illegalStateException);
            Thread threadCurrentThread = Thread.currentThread();
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            c();
        } catch (Throwable th2) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th2);
            E3.c.a(illegalStateException2);
            Thread threadCurrentThread2 = Thread.currentThread();
            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, illegalStateException2);
            c();
        }
        c();
    }

    public p(x3.a aVar, B3.l lVar) {
        this.f126b = aVar;
        this.f125a = new B3.l(new o(this, lVar, 1));
    }

    public p(x3.a aVar, B3.l lVar, int i4) {
        this.f126b = aVar;
        this.f125a = new B3.l(new o(this, lVar, 0));
    }
}
