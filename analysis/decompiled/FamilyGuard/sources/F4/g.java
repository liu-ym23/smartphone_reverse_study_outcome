package F4;

import C4.C0271a;
import C4.H;
import F4.k;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: g, reason: collision with root package name */
    private static final Executor f1803g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), D4.e.H("OkHttp ConnectionPool", true));

    /* renamed from: a, reason: collision with root package name */
    private final int f1804a;

    /* renamed from: b, reason: collision with root package name */
    private final long f1805b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f1806c = new Runnable() { // from class: F4.f
        @Override // java.lang.Runnable
        public final void run() throws IOException {
            g.a(this.f1802a);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private final Deque<e> f1807d = new ArrayDeque();

    /* renamed from: e, reason: collision with root package name */
    final h f1808e = new h();

    /* renamed from: f, reason: collision with root package name */
    boolean f1809f;

    public g(int i5, long j5, TimeUnit timeUnit) {
        this.f1804a = i5;
        this.f1805b = timeUnit.toNanos(j5);
        if (j5 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j5);
    }

    public static /* synthetic */ void a(g gVar) throws IOException {
        gVar.getClass();
        while (true) {
            long jB = gVar.b(System.nanoTime());
            if (jB == -1) {
                return;
            }
            if (jB > 0) {
                long j5 = jB / 1000000;
                long j6 = jB - (1000000 * j5);
                synchronized (gVar) {
                    try {
                        gVar.wait(j5, (int) j6);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    private int e(e eVar, long j5) {
        List<Reference<k>> list = eVar.f1800p;
        int i5 = 0;
        while (i5 < list.size()) {
            Reference<k> reference = list.get(i5);
            if (reference.get() != null) {
                i5++;
            } else {
                okhttp3.internal.platform.f.get().logCloseableLeak("A connection to " + eVar.q().a().l() + " was leaked. Did you forget to close a response body?", ((k.b) reference).f1839a);
                list.remove(i5);
                eVar.f1795k = true;
                if (list.isEmpty()) {
                    eVar.f1801q = j5 - this.f1805b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long b(long j5) throws IOException {
        synchronized (this) {
            try {
                e eVar = null;
                long j6 = Long.MIN_VALUE;
                int i5 = 0;
                int i6 = 0;
                for (e eVar2 : this.f1807d) {
                    if (e(eVar2, j5) > 0) {
                        i6++;
                    } else {
                        i5++;
                        long j7 = j5 - eVar2.f1801q;
                        if (j7 > j6) {
                            eVar = eVar2;
                            j6 = j7;
                        }
                    }
                }
                long j8 = this.f1805b;
                if (j6 < j8 && i5 <= this.f1804a) {
                    if (i5 > 0) {
                        return j8 - j6;
                    }
                    if (i6 > 0) {
                        return j8;
                    }
                    this.f1809f = false;
                    return -1L;
                }
                this.f1807d.remove(eVar);
                D4.e.h(eVar.s());
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(H h5, IOException iOException) {
        if (h5.b().type() != Proxy.Type.DIRECT) {
            C0271a c0271aA = h5.a();
            c0271aA.i().connectFailed(c0271aA.l().E(), h5.b().address(), iOException);
        }
        this.f1808e.b(h5);
    }

    boolean d(e eVar) {
        if (eVar.f1795k || this.f1804a == 0) {
            this.f1807d.remove(eVar);
            return true;
        }
        notifyAll();
        return false;
    }

    void f(e eVar) {
        if (!this.f1809f) {
            this.f1809f = true;
            f1803g.execute(this.f1806c);
        }
        this.f1807d.add(eVar);
    }

    boolean g(C0271a c0271a, k kVar, @Nullable List<H> list, boolean z5) {
        for (e eVar : this.f1807d) {
            if (!z5 || eVar.n()) {
                if (eVar.l(c0271a, list)) {
                    kVar.a(eVar);
                    return true;
                }
            }
        }
        return false;
    }
}
