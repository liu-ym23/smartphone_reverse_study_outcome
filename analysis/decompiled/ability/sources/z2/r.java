package z2;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public final class r {
    public static final F1.a f = new F1.a();
    public static final M0.h g = new M0.h(11);

    /* renamed from: a, reason: collision with root package name */
    public final p f6940a;
    public volatile Handler d;
    public final ConcurrentLinkedQueue b = new ConcurrentLinkedQueue();
    public final ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();
    public final Object e = new Object();

    public r(String str) {
        this.f6940a = new p(this, str);
    }

    public static void c(ConcurrentLinkedQueue concurrentLinkedQueue, Runnable runnable, o oVar) {
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        try {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                if (oVar.f(it.next(), runnable)) {
                    it.remove();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(Runnable runnable) {
        d(Message.obtain(this.d, runnable), 0L);
    }

    public final void b(Runnable runnable, long j5) {
        d(Message.obtain(this.d, runnable), j5);
    }

    public final boolean d(Message message, long j5) {
        if (j5 < 0) {
            j5 = 0;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + j5;
        if (this.d == null) {
            synchronized (this.e) {
                try {
                    if (this.d == null) {
                        ConcurrentLinkedQueue concurrentLinkedQueue = this.b;
                        q qVar = new q();
                        qVar.f6939a = message;
                        qVar.b = jUptimeMillis;
                        concurrentLinkedQueue.add(qVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        try {
            return this.d.sendMessageAtTime(message, jUptimeMillis);
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void e(Runnable runnable) {
        if (!this.b.isEmpty() || !this.c.isEmpty()) {
            c(this.b, runnable, f);
            c(this.c, runnable, g);
        }
        if (this.d != null) {
            this.d.removeCallbacks(runnable);
        }
    }
}
