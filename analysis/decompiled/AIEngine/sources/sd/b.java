package sd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b extends f0 {
    public static final ReentrantLock h;

    /* renamed from: i, reason: collision with root package name */
    public static final Condition f11908i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f11909j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f11910k;

    /* renamed from: l, reason: collision with root package name */
    public static b f11911l;

    /* renamed from: e, reason: collision with root package name */
    public int f11912e;

    /* renamed from: f, reason: collision with root package name */
    public b f11913f;

    /* renamed from: g, reason: collision with root package name */
    public long f11914g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static final void a(b bVar, long j10, boolean z) {
            b bVar2;
            ReentrantLock reentrantLock = b.h;
            if (b.f11911l == null) {
                b.f11911l = new b();
                C0140b c0140b = new C0140b("Okio Watchdog");
                c0140b.setDaemon(true);
                c0140b.start();
            }
            long jNanoTime = System.nanoTime();
            if (j10 != 0 && z) {
                bVar.f11914g = Math.min(j10, bVar.c() - jNanoTime) + jNanoTime;
            } else if (j10 != 0) {
                bVar.f11914g = j10 + jNanoTime;
            } else {
                if (!z) {
                    throw new AssertionError();
                }
                bVar.f11914g = bVar.c();
            }
            long j11 = bVar.f11914g - jNanoTime;
            b bVar3 = b.f11911l;
            kotlin.jvm.internal.g.c(bVar3);
            while (true) {
                bVar2 = bVar3.f11913f;
                if (bVar2 == null || j11 < bVar2.f11914g - jNanoTime) {
                    break;
                }
                kotlin.jvm.internal.g.c(bVar2);
                bVar3 = bVar2;
            }
            bVar.f11913f = bVar2;
            bVar3.f11913f = bVar;
            if (bVar3 == b.f11911l) {
                b.f11908i.signal();
            }
        }

        public static b b() throws InterruptedException {
            b bVar = b.f11911l;
            kotlin.jvm.internal.g.c(bVar);
            b bVar2 = bVar.f11913f;
            if (bVar2 == null) {
                long jNanoTime = System.nanoTime();
                b.f11908i.await(b.f11909j, TimeUnit.MILLISECONDS);
                b bVar3 = b.f11911l;
                kotlin.jvm.internal.g.c(bVar3);
                if (bVar3.f11913f != null || System.nanoTime() - jNanoTime < b.f11910k) {
                    return null;
                }
                return b.f11911l;
            }
            long jNanoTime2 = bVar2.f11914g - System.nanoTime();
            if (jNanoTime2 > 0) {
                b.f11908i.await(jNanoTime2, TimeUnit.NANOSECONDS);
                return null;
            }
            b bVar4 = b.f11911l;
            kotlin.jvm.internal.g.c(bVar4);
            bVar4.f11913f = bVar2.f11913f;
            bVar2.f11913f = null;
            bVar2.f11912e = 2;
            return bVar2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: sd.b$b, reason: collision with other inner class name */
    public static final class C0140b extends Thread {
        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            ReentrantLock reentrantLock;
            b bVarB;
            while (true) {
                try {
                    ReentrantLock reentrantLock2 = b.h;
                    reentrantLock = b.h;
                    reentrantLock.lock();
                    try {
                        bVarB = a.b();
                    } finally {
                        reentrantLock.unlock();
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
                if (bVarB == b.f11911l) {
                    b.f11911l = null;
                    return;
                }
                lb.n nVar = lb.n.f10413a;
                reentrantLock.unlock();
                if (bVarB != null) {
                    bVarB.k();
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.g.e(conditionNewCondition, "newCondition(...)");
        f11908i = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f11909j = millis;
        f11910k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void i() {
        long j10 = this.f11938c;
        boolean z = this.f11936a;
        if (j10 != 0 || z) {
            ReentrantLock reentrantLock = h;
            reentrantLock.lock();
            try {
                if (this.f11912e != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f11912e = 1;
                a.a(this, j10, z);
                lb.n nVar = lb.n.f10413a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean j() {
        ReentrantLock reentrantLock = h;
        reentrantLock.lock();
        try {
            int i10 = this.f11912e;
            this.f11912e = 0;
            if (i10 != 1) {
                return i10 == 2;
            }
            b bVar = f11911l;
            while (bVar != null) {
                b bVar2 = bVar.f11913f;
                if (bVar2 == this) {
                    bVar.f11913f = this.f11913f;
                    this.f11913f = null;
                    return false;
                }
                bVar = bVar2;
            }
            throw new IllegalStateException("node was not found in the queue");
        } finally {
            reentrantLock.unlock();
        }
    }

    public void k() {
    }
}
