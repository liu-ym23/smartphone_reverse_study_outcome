package L0;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import e1.C1403b;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import stepos.support.v7.widget.J;

/* loaded from: classes2.dex */
public final class h {
    public static final M0.h f;
    public static final C1403b g;

    /* renamed from: a, reason: collision with root package name */
    public final J f928a;
    public final ConcurrentLinkedQueue b;
    public final ConcurrentLinkedQueue c;
    public volatile Handler d;
    public final Object e;

    static {
        int i = 3;
        f = new M0.h(i);
        g = new C1403b(i);
    }

    public h() {
        this.b = new ConcurrentLinkedQueue();
        this.c = new ConcurrentLinkedQueue();
        this.e = new Object();
        this.f928a = new J(this, 0);
    }

    public final void a(Runnable runnable) {
        if (!this.b.isEmpty() || !this.c.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.b;
            M0.h hVar = f;
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                if (hVar.f(it.next(), runnable)) {
                    it.remove();
                }
            }
            ConcurrentLinkedQueue concurrentLinkedQueue2 = this.c;
            C1403b c1403b = g;
            Iterator it2 = concurrentLinkedQueue2.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                c1403b.getClass();
                Message message = (Message) next;
                if (message != null && runnable.equals(message.getCallback())) {
                    it2.remove();
                }
            }
        }
        if (this.d != null) {
            this.d.removeCallbacks(runnable);
        }
    }

    public final void b(Runnable runnable, long j5) {
        c(Message.obtain(this.d, runnable), j5);
    }

    public final boolean c(Message message, long j5) {
        if (j5 < 0) {
            j5 = 0;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + j5;
        if (this.d == null) {
            synchronized (this.e) {
                try {
                    if (this.d == null) {
                        ConcurrentLinkedQueue concurrentLinkedQueue = this.b;
                        g gVar = new g();
                        gVar.f927a = message;
                        gVar.b = jUptimeMillis;
                        concurrentLinkedQueue.add(gVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        return this.d.sendMessageAtTime(message, jUptimeMillis);
    }

    public h(int i) {
        this.b = new ConcurrentLinkedQueue();
        this.c = new ConcurrentLinkedQueue();
        this.e = new Object();
        this.f928a = new J(this);
    }
}
