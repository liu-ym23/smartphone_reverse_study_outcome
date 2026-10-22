package V9;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
public class d extends y {
    public static final ReentrantLock h;
    public static final Condition i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f1415j;
    public static final long k;
    public static d l;
    public boolean e;
    public d f;
    public long g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.k.e(conditionNewCondition, "newCondition(...)");
        i = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f1415j = millis;
        k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void h() {
        d dVar;
        long j5 = this.c;
        boolean z10 = this.f1428a;
        if (j5 != 0 || z10) {
            ReentrantLock reentrantLock = h;
            reentrantLock.lock();
            try {
                if (this.e) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.e = true;
                if (l == null) {
                    l = new d();
                    E2.b bVar = new E2.b("Okio Watchdog");
                    bVar.setDaemon(true);
                    bVar.start();
                }
                long jNanoTime = System.nanoTime();
                if (j5 != 0 && z10) {
                    this.g = Math.min(j5, c() - jNanoTime) + jNanoTime;
                } else if (j5 != 0) {
                    this.g = j5 + jNanoTime;
                } else {
                    if (!z10) {
                        throw new AssertionError();
                    }
                    this.g = c();
                }
                long j6 = this.g - jNanoTime;
                d dVar2 = l;
                kotlin.jvm.internal.k.c(dVar2);
                while (true) {
                    dVar = dVar2.f;
                    if (dVar == null || j6 < dVar.g - jNanoTime) {
                        break;
                    } else {
                        dVar2 = dVar;
                    }
                }
                this.f = dVar;
                dVar2.f = this;
                if (dVar2 == l) {
                    i.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = h;
        reentrantLock.lock();
        try {
            if (!this.e) {
                return false;
            }
            this.e = false;
            d dVar = l;
            while (dVar != null) {
                d dVar2 = dVar.f;
                if (dVar2 == this) {
                    dVar.f = this.f;
                    this.f = null;
                    return false;
                }
                dVar = dVar2;
            }
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void j() {
    }
}
