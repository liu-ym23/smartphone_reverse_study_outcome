package J3;

import java.util.concurrent.atomic.AtomicLong;
import x3.p;

/* loaded from: classes.dex */
public final class r<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final x3.p f3406c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f3407d;

    /* renamed from: e, reason: collision with root package name */
    final int f3408e;

    static abstract class a<T> extends Q3.a<T> implements x3.i<T>, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final p.c f3409a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f3410b;

        /* renamed from: c, reason: collision with root package name */
        final int f3411c;

        /* renamed from: d, reason: collision with root package name */
        final int f3412d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicLong f3413e = new AtomicLong();

        /* renamed from: f, reason: collision with root package name */
        Q4.c f3414f;

        /* renamed from: g, reason: collision with root package name */
        G3.f<T> f3415g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f3416h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f3417i;

        /* renamed from: j, reason: collision with root package name */
        Throwable f3418j;

        /* renamed from: k, reason: collision with root package name */
        int f3419k;

        /* renamed from: l, reason: collision with root package name */
        long f3420l;

        /* renamed from: m, reason: collision with root package name */
        boolean f3421m;

        a(p.c cVar, boolean z5, int i5) {
            this.f3409a = cVar;
            this.f3410b = z5;
            this.f3411c = i5;
            this.f3412d = i5 - (i5 >> 2);
        }

        @Override // Q4.b
        public final void a() {
            if (this.f3417i) {
                return;
            }
            this.f3417i = true;
            k();
        }

        @Override // G3.b
        public final int b(int i5) {
            if ((i5 & 2) == 0) {
                return 0;
            }
            this.f3421m = true;
            return 2;
        }

        final boolean c(boolean z5, boolean z6, Q4.b<?> bVar) {
            if (this.f3416h) {
                clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            if (this.f3410b) {
                if (!z6) {
                    return false;
                }
                this.f3416h = true;
                Throwable th = this.f3418j;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.a();
                }
                this.f3409a.dispose();
                return true;
            }
            Throwable th2 = this.f3418j;
            if (th2 != null) {
                this.f3416h = true;
                clear();
                bVar.onError(th2);
                this.f3409a.dispose();
                return true;
            }
            if (!z6) {
                return false;
            }
            this.f3416h = true;
            bVar.a();
            this.f3409a.dispose();
            return true;
        }

        @Override // Q4.c
        public final void cancel() {
            if (this.f3416h) {
                return;
            }
            this.f3416h = true;
            this.f3414f.cancel();
            this.f3409a.dispose();
            if (getAndIncrement() == 0) {
                this.f3415g.clear();
            }
        }

        @Override // G3.f
        public final void clear() {
            this.f3415g.clear();
        }

        @Override // Q4.b
        public final void d(T t5) {
            if (this.f3417i) {
                return;
            }
            if (this.f3419k == 2) {
                k();
                return;
            }
            if (!this.f3415g.offer(t5)) {
                this.f3414f.cancel();
                this.f3418j = new B3.c("Queue is full?!");
                this.f3417i = true;
            }
            k();
        }

        abstract void g();

        @Override // Q4.c
        public final void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.a(this.f3413e, j5);
                k();
            }
        }

        abstract void i();

        @Override // G3.f
        public final boolean isEmpty() {
            return this.f3415g.isEmpty();
        }

        abstract void j();

        final void k() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.f3409a.b(this);
        }

        @Override // Q4.b
        public final void onError(Throwable th) {
            if (this.f3417i) {
                S3.a.r(th);
                return;
            }
            this.f3418j = th;
            this.f3417i = true;
            k();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f3421m) {
                i();
            } else if (this.f3419k == 1) {
                j();
            } else {
                g();
            }
        }
    }

    static final class b<T> extends a<T> {

        /* renamed from: n, reason: collision with root package name */
        final G3.a<? super T> f3422n;

        /* renamed from: o, reason: collision with root package name */
        long f3423o;

        b(G3.a<? super T> aVar, p.c cVar, boolean z5, int i5) {
            super(cVar, z5, i5);
            this.f3422n = aVar;
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3414f, cVar)) {
                this.f3414f = cVar;
                if (cVar instanceof G3.c) {
                    G3.c cVar2 = (G3.c) cVar;
                    int iB = cVar2.b(7);
                    if (iB == 1) {
                        this.f3419k = 1;
                        this.f3415g = cVar2;
                        this.f3417i = true;
                        this.f3422n.e(this);
                        return;
                    }
                    if (iB == 2) {
                        this.f3419k = 2;
                        this.f3415g = cVar2;
                        this.f3422n.e(this);
                        cVar.h(this.f3411c);
                        return;
                    }
                }
                this.f3415g = new N3.b(this.f3411c);
                this.f3422n.e(this);
                cVar.h(this.f3411c);
            }
        }

        @Override // J3.r.a
        void g() {
            G3.a<? super T> aVar = this.f3422n;
            G3.f<T> fVar = this.f3415g;
            long j5 = this.f3420l;
            long j6 = this.f3423o;
            int iAddAndGet = 1;
            while (true) {
                long j7 = this.f3413e.get();
                while (j5 != j7) {
                    boolean z5 = this.f3417i;
                    try {
                        T tPoll = fVar.poll();
                        boolean z6 = tPoll == null;
                        if (c(z5, z6, aVar)) {
                            return;
                        }
                        if (z6) {
                            break;
                        }
                        if (aVar.f(tPoll)) {
                            j5++;
                        }
                        j6++;
                        if (j6 == this.f3412d) {
                            this.f3414f.h(j6);
                            j6 = 0;
                        }
                    } catch (Throwable th) {
                        B3.b.b(th);
                        this.f3416h = true;
                        this.f3414f.cancel();
                        fVar.clear();
                        aVar.onError(th);
                        this.f3409a.dispose();
                        return;
                    }
                }
                if (j5 == j7 && c(this.f3417i, fVar.isEmpty(), aVar)) {
                    return;
                }
                int i5 = get();
                if (iAddAndGet == i5) {
                    this.f3420l = j5;
                    this.f3423o = j6;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i5;
                }
            }
        }

        @Override // J3.r.a
        void i() {
            int iAddAndGet = 1;
            while (!this.f3416h) {
                boolean z5 = this.f3417i;
                this.f3422n.d(null);
                if (z5) {
                    this.f3416h = true;
                    Throwable th = this.f3418j;
                    if (th != null) {
                        this.f3422n.onError(th);
                    } else {
                        this.f3422n.a();
                    }
                    this.f3409a.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // J3.r.a
        void j() {
            G3.a<? super T> aVar = this.f3422n;
            G3.f<T> fVar = this.f3415g;
            long j5 = this.f3420l;
            int iAddAndGet = 1;
            while (true) {
                long j6 = this.f3413e.get();
                while (j5 != j6) {
                    try {
                        T tPoll = fVar.poll();
                        if (this.f3416h) {
                            return;
                        }
                        if (tPoll == null) {
                            this.f3416h = true;
                            aVar.a();
                            this.f3409a.dispose();
                            return;
                        } else if (aVar.f(tPoll)) {
                            j5++;
                        }
                    } catch (Throwable th) {
                        B3.b.b(th);
                        this.f3416h = true;
                        this.f3414f.cancel();
                        aVar.onError(th);
                        this.f3409a.dispose();
                        return;
                    }
                }
                if (this.f3416h) {
                    return;
                }
                if (fVar.isEmpty()) {
                    this.f3416h = true;
                    aVar.a();
                    this.f3409a.dispose();
                    return;
                } else {
                    int i5 = get();
                    if (iAddAndGet == i5) {
                        this.f3420l = j5;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i5;
                    }
                }
            }
        }

        @Override // G3.f
        public T poll() {
            T tPoll = this.f3415g.poll();
            if (tPoll != null && this.f3419k != 1) {
                long j5 = this.f3423o + 1;
                if (j5 == this.f3412d) {
                    this.f3423o = 0L;
                    this.f3414f.h(j5);
                    return tPoll;
                }
                this.f3423o = j5;
            }
            return tPoll;
        }
    }

    static final class c<T> extends a<T> implements x3.i<T> {

        /* renamed from: n, reason: collision with root package name */
        final Q4.b<? super T> f3424n;

        c(Q4.b<? super T> bVar, p.c cVar, boolean z5, int i5) {
            super(cVar, z5, i5);
            this.f3424n = bVar;
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3414f, cVar)) {
                this.f3414f = cVar;
                if (cVar instanceof G3.c) {
                    G3.c cVar2 = (G3.c) cVar;
                    int iB = cVar2.b(7);
                    if (iB == 1) {
                        this.f3419k = 1;
                        this.f3415g = cVar2;
                        this.f3417i = true;
                        this.f3424n.e(this);
                        return;
                    }
                    if (iB == 2) {
                        this.f3419k = 2;
                        this.f3415g = cVar2;
                        this.f3424n.e(this);
                        cVar.h(this.f3411c);
                        return;
                    }
                }
                this.f3415g = new N3.b(this.f3411c);
                this.f3424n.e(this);
                cVar.h(this.f3411c);
            }
        }

        @Override // J3.r.a
        void g() {
            Q4.b<? super T> bVar = this.f3424n;
            G3.f<T> fVar = this.f3415g;
            long j5 = this.f3420l;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.f3413e.get();
                while (j5 != jAddAndGet) {
                    boolean z5 = this.f3417i;
                    try {
                        T tPoll = fVar.poll();
                        boolean z6 = tPoll == null;
                        if (c(z5, z6, bVar)) {
                            return;
                        }
                        if (z6) {
                            break;
                        }
                        bVar.d(tPoll);
                        j5++;
                        if (j5 == this.f3412d) {
                            if (jAddAndGet != Long.MAX_VALUE) {
                                jAddAndGet = this.f3413e.addAndGet(-j5);
                            }
                            this.f3414f.h(j5);
                            j5 = 0;
                        }
                    } catch (Throwable th) {
                        B3.b.b(th);
                        this.f3416h = true;
                        this.f3414f.cancel();
                        fVar.clear();
                        bVar.onError(th);
                        this.f3409a.dispose();
                        return;
                    }
                }
                if (j5 == jAddAndGet && c(this.f3417i, fVar.isEmpty(), bVar)) {
                    return;
                }
                int i5 = get();
                if (iAddAndGet == i5) {
                    this.f3420l = j5;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i5;
                }
            }
        }

        @Override // J3.r.a
        void i() {
            int iAddAndGet = 1;
            while (!this.f3416h) {
                boolean z5 = this.f3417i;
                this.f3424n.d(null);
                if (z5) {
                    this.f3416h = true;
                    Throwable th = this.f3418j;
                    if (th != null) {
                        this.f3424n.onError(th);
                    } else {
                        this.f3424n.a();
                    }
                    this.f3409a.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // J3.r.a
        void j() {
            Q4.b<? super T> bVar = this.f3424n;
            G3.f<T> fVar = this.f3415g;
            long j5 = this.f3420l;
            int iAddAndGet = 1;
            while (true) {
                long j6 = this.f3413e.get();
                while (j5 != j6) {
                    try {
                        T tPoll = fVar.poll();
                        if (this.f3416h) {
                            return;
                        }
                        if (tPoll == null) {
                            this.f3416h = true;
                            bVar.a();
                            this.f3409a.dispose();
                            return;
                        }
                        bVar.d(tPoll);
                        j5++;
                    } catch (Throwable th) {
                        B3.b.b(th);
                        this.f3416h = true;
                        this.f3414f.cancel();
                        bVar.onError(th);
                        this.f3409a.dispose();
                        return;
                    }
                }
                if (this.f3416h) {
                    return;
                }
                if (fVar.isEmpty()) {
                    this.f3416h = true;
                    bVar.a();
                    this.f3409a.dispose();
                    return;
                } else {
                    int i5 = get();
                    if (iAddAndGet == i5) {
                        this.f3420l = j5;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i5;
                    }
                }
            }
        }

        @Override // G3.f
        public T poll() {
            T tPoll = this.f3415g.poll();
            if (tPoll != null && this.f3419k != 1) {
                long j5 = this.f3420l + 1;
                if (j5 == this.f3412d) {
                    this.f3420l = 0L;
                    this.f3414f.h(j5);
                    return tPoll;
                }
                this.f3420l = j5;
            }
            return tPoll;
        }
    }

    public r(x3.f<T> fVar, x3.p pVar, boolean z5, int i5) {
        super(fVar);
        this.f3406c = pVar;
        this.f3407d = z5;
        this.f3408e = i5;
    }

    @Override // x3.f
    public void W(Q4.b<? super T> bVar) {
        p.c cVarA = this.f3406c.a();
        if (bVar instanceof G3.a) {
            this.f3267b.V(new b((G3.a) bVar, cVarA, this.f3407d, this.f3408e));
        } else {
            this.f3267b.V(new c(bVar, cVarA, this.f3407d, this.f3408e));
        }
    }
}
