package y3;

import androidx.room.AbstractC0351g;
import java.util.AbstractQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import rx.internal.util.unsafe.p;
import rx.internal.util.unsafe.v;

/* loaded from: classes2.dex */
public final class i extends t3.g implements x3.a {

    /* renamed from: e, reason: collision with root package name */
    public final t3.g f16368e;

    /* renamed from: f, reason: collision with root package name */
    public final t3.e f16369f;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f16371h;

    /* renamed from: i, reason: collision with root package name */
    public final AbstractQueue f16372i;

    /* renamed from: j, reason: collision with root package name */
    public final int f16373j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f16374k;

    /* renamed from: n, reason: collision with root package name */
    public Throwable f16377n;

    /* renamed from: o, reason: collision with root package name */
    public long f16378o;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicLong f16375l = new AtomicLong();

    /* renamed from: m, reason: collision with root package name */
    public final AtomicLong f16376m = new AtomicLong();

    /* renamed from: g, reason: collision with root package name */
    public final b f16370g = b.f16349a;

    public i(t3.f fVar, t3.g gVar, boolean z4, int i4) {
        this.f16368e = gVar;
        this.f16369f = fVar.b();
        this.f16371h = z4;
        i4 = i4 <= 0 ? B3.f.f227b : i4;
        this.f16373j = i4 - (i4 >> 2);
        if (v.f14123a == null || v.f14124b) {
            this.f16372i = new C3.b(i4);
        } else {
            this.f16372i = new p(i4);
        }
        h(i4);
    }

    @Override // x3.a
    public final void b() {
        long j4;
        long j5;
        long j6 = this.f16378o;
        AbstractQueue abstractQueue = this.f16372i;
        t3.g gVar = this.f16368e;
        b bVar = this.f16370g;
        long jAddAndGet = 1;
        do {
            long j7 = this.f16375l.get();
            while (j7 != j6) {
                boolean z4 = this.f16374k;
                Object objPoll = abstractQueue.poll();
                boolean z5 = objPoll == null;
                if (j(z4, z5, gVar, abstractQueue)) {
                    return;
                }
                if (z5) {
                    break;
                }
                bVar.getClass();
                if (objPoll == b.f16350b) {
                    objPoll = null;
                }
                gVar.g(objPoll);
                j6++;
                if (j6 == this.f16373j) {
                    AtomicLong atomicLong = this.f16375l;
                    do {
                        j4 = atomicLong.get();
                        j5 = LongCompanionObject.MAX_VALUE;
                        if (j4 == LongCompanionObject.MAX_VALUE) {
                            break;
                        }
                        j5 = j4 - j6;
                        if (j5 < 0) {
                            throw new IllegalStateException(AbstractC0351g.n("More produced than requested: ", j5));
                        }
                    } while (!atomicLong.compareAndSet(j4, j5));
                    h(j6);
                    j7 = j5;
                    j6 = 0;
                }
            }
            if (j7 == j6 && j(this.f16374k, abstractQueue.isEmpty(), gVar, abstractQueue)) {
                return;
            }
            this.f16378o = j6;
            jAddAndGet = this.f16376m.addAndGet(-jAddAndGet);
        } while (jAddAndGet != 0);
    }

    @Override // t3.g
    public final void e() {
        if (this.f15444a.a() || this.f16374k) {
            return;
        }
        this.f16374k = true;
        k();
    }

    @Override // t3.g
    public final void f(Throwable th) {
        if (this.f15444a.a() || this.f16374k) {
            E3.c.a(th);
            return;
        }
        this.f16377n = th;
        this.f16374k = true;
        k();
    }

    @Override // t3.g
    public final void g(Object obj) {
        if (this.f15444a.a() || this.f16374k) {
            return;
        }
        AbstractQueue abstractQueue = this.f16372i;
        this.f16370g.getClass();
        if (obj == null) {
            obj = b.f16350b;
        }
        if (abstractQueue.offer(obj)) {
            k();
        } else {
            f(new X0.a());
        }
    }

    public final boolean j(boolean z4, boolean z5, t3.g gVar, Queue queue) {
        if (gVar.f15444a.a()) {
            queue.clear();
            return true;
        }
        if (!z4) {
            return false;
        }
        boolean z6 = this.f16371h;
        t3.e eVar = this.f16369f;
        if (z6) {
            if (!z5) {
                return false;
            }
            Throwable th = this.f16377n;
            try {
                if (th != null) {
                    gVar.f(th);
                } else {
                    gVar.e();
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Throwable th3 = this.f16377n;
        if (th3 != null) {
            queue.clear();
            try {
                gVar.f(th3);
                return true;
            } finally {
            }
        }
        if (!z5) {
            return false;
        }
        try {
            gVar.e();
            return true;
        } finally {
        }
    }

    public final void k() {
        if (this.f16376m.getAndIncrement() == 0) {
            this.f16369f.b(this);
        }
    }
}
