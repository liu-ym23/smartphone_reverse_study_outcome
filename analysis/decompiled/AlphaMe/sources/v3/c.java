package v3;

import android.os.Handler;
import t3.h;
import w3.e;

/* loaded from: classes2.dex */
public final class c implements Runnable, h {

    /* renamed from: a, reason: collision with root package name */
    public final x3.a f15727a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f15728b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f15729c;

    public c(x3.a aVar, Handler handler) {
        this.f15727a = aVar;
        this.f15728b = handler;
    }

    @Override // t3.h
    public final boolean a() {
        return this.f15729c;
    }

    @Override // t3.h
    public final void c() {
        this.f15729c = true;
        this.f15728b.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f15727a.b();
        } catch (Throwable th) {
            IllegalStateException illegalStateException = th instanceof e ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
            E3.h.f420f.b().getClass();
            Thread threadCurrentThread = Thread.currentThread();
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
        }
    }
}
