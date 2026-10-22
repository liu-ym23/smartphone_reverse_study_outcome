package J3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class x<T> extends C3.a<T> implements E3.e {

    /* renamed from: b, reason: collision with root package name */
    final Q4.a<T> f3473b;

    /* renamed from: c, reason: collision with root package name */
    final int f3474c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference<b<T>> f3475d = new AtomicReference<>();

    static final class a<T> extends AtomicLong implements Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3476a;

        /* renamed from: b, reason: collision with root package name */
        final b<T> f3477b;

        /* renamed from: c, reason: collision with root package name */
        long f3478c;

        a(Q4.b<? super T> bVar, b<T> bVar2) {
            this.f3476a = bVar;
            this.f3477b = bVar2;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        @Override // Q4.c
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f3477b.i(this);
                this.f3477b.h();
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            R3.c.b(this, j5);
            this.f3477b.h();
        }
    }

    static final class b<T> extends AtomicInteger implements x3.i<T>, A3.c {

        /* renamed from: k, reason: collision with root package name */
        static final a[] f3479k = new a[0];

        /* renamed from: l, reason: collision with root package name */
        static final a[] f3480l = new a[0];

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<b<T>> f3481a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<Q4.c> f3482b = new AtomicReference<>();

        /* renamed from: c, reason: collision with root package name */
        final AtomicBoolean f3483c = new AtomicBoolean();

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<a<T>[]> f3484d = new AtomicReference<>(f3479k);

        /* renamed from: e, reason: collision with root package name */
        final int f3485e;

        /* renamed from: f, reason: collision with root package name */
        volatile G3.f<T> f3486f;

        /* renamed from: g, reason: collision with root package name */
        int f3487g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f3488h;

        /* renamed from: i, reason: collision with root package name */
        Throwable f3489i;

        /* renamed from: j, reason: collision with root package name */
        int f3490j;

        b(AtomicReference<b<T>> atomicReference, int i5) {
            this.f3481a = atomicReference;
            this.f3485e = i5;
        }

        @Override // Q4.b
        public void a() {
            this.f3488h = true;
            h();
        }

        boolean b(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f3484d.get();
                if (aVarArr == f3480l) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f3484d.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        boolean c(boolean z5, boolean z6) {
            if (!z5 || !z6) {
                return false;
            }
            Throwable th = this.f3489i;
            if (th != null) {
                j(th);
                return true;
            }
            for (a<T> aVar : this.f3484d.getAndSet(f3480l)) {
                if (!aVar.a()) {
                    aVar.f3476a.a();
                }
            }
            return true;
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3487g != 0 || this.f3486f.offer(t5)) {
                h();
            } else {
                onError(new B3.c("Prefetch queue is full?!"));
            }
        }

        @Override // A3.c
        public void dispose() {
            this.f3484d.getAndSet(f3480l);
            this.f3481a.compareAndSet(this, null);
            Q3.g.b(this.f3482b);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.j(this.f3482b, cVar)) {
                if (cVar instanceof G3.c) {
                    G3.c cVar2 = (G3.c) cVar;
                    int iB = cVar2.b(7);
                    if (iB == 1) {
                        this.f3487g = iB;
                        this.f3486f = cVar2;
                        this.f3488h = true;
                        h();
                        return;
                    }
                    if (iB == 2) {
                        this.f3487g = iB;
                        this.f3486f = cVar2;
                        cVar.h(this.f3485e);
                        return;
                    }
                }
                this.f3486f = new N3.b(this.f3485e);
                cVar.h(this.f3485e);
            }
        }

        @Override // A3.c
        public boolean g() {
            return this.f3484d.get() == f3480l;
        }

        void h() {
            if (getAndIncrement() != 0) {
                return;
            }
            G3.f<T> fVar = this.f3486f;
            int i5 = this.f3490j;
            int i6 = this.f3485e;
            int i7 = i6 - (i6 >> 2);
            boolean z5 = this.f3487g != 1;
            G3.f<T> fVar2 = fVar;
            int i8 = i5;
            int iAddAndGet = 1;
            while (true) {
                if (fVar2 != null) {
                    a<T>[] aVarArr = this.f3484d.get();
                    long jMin = Long.MAX_VALUE;
                    boolean z6 = false;
                    for (a<T> aVar : aVarArr) {
                        long j5 = aVar.get();
                        if (j5 != Long.MIN_VALUE) {
                            jMin = Math.min(j5 - aVar.f3478c, jMin);
                            z6 = true;
                        }
                    }
                    if (!z6) {
                        jMin = 0;
                    }
                    for (long j6 = 0; jMin != j6; j6 = 0) {
                        boolean z7 = this.f3488h;
                        try {
                            T tPoll = fVar2.poll();
                            boolean z8 = tPoll == null;
                            if (c(z7, z8)) {
                                return;
                            }
                            if (z8) {
                                break;
                            }
                            for (a<T> aVar2 : aVarArr) {
                                if (!aVar2.a()) {
                                    aVar2.f3476a.d(tPoll);
                                    aVar2.f3478c++;
                                }
                            }
                            if (z5 && (i8 = i8 + 1) == i7) {
                                this.f3482b.get().h(i7);
                                i8 = 0;
                            }
                            jMin--;
                            if (aVarArr != this.f3484d.get()) {
                                break;
                            }
                        } catch (Throwable th) {
                            B3.b.b(th);
                            this.f3482b.get().cancel();
                            fVar2.clear();
                            this.f3488h = true;
                            j(th);
                            return;
                        }
                    }
                    if (c(this.f3488h, fVar2.isEmpty())) {
                        return;
                    }
                }
                this.f3490j = i8;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (fVar2 == null) {
                    fVar2 = this.f3486f;
                }
            }
        }

        void i(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f3484d.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        i5 = -1;
                        break;
                    } else if (aVarArr[i5] == aVar) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f3479k;
                } else {
                    a<T>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i5);
                    System.arraycopy(aVarArr, i5 + 1, aVarArr3, i5, (length - i5) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f3484d.compareAndSet(aVarArr, aVarArr2));
        }

        void j(Throwable th) {
            for (a<T> aVar : this.f3484d.getAndSet(f3480l)) {
                if (!aVar.a()) {
                    aVar.f3476a.onError(th);
                }
            }
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            if (this.f3488h) {
                S3.a.r(th);
                return;
            }
            this.f3489i = th;
            this.f3488h = true;
            h();
        }
    }

    public x(Q4.a<T> aVar, int i5) {
        this.f3473b = aVar;
        this.f3474c = i5;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        b<T> bVar2;
        while (true) {
            bVar2 = this.f3475d.get();
            if (bVar2 != null) {
                break;
            }
            b<T> bVar3 = new b<>(this.f3475d, this.f3474c);
            if (this.f3475d.compareAndSet(bVar2, bVar3)) {
                bVar2 = bVar3;
                break;
            }
        }
        a<T> aVar = new a<>(bVar, bVar2);
        bVar.e(aVar);
        if (bVar2.b(aVar)) {
            if (aVar.a()) {
                bVar2.i(aVar);
                return;
            } else {
                bVar2.h();
                return;
            }
        }
        Throwable th = bVar2.f3489i;
        if (th != null) {
            bVar.onError(th);
        } else {
            bVar.a();
        }
    }

    @Override // E3.e
    public void b(A3.c cVar) {
        this.f3475d.compareAndSet((b) cVar, null);
    }

    @Override // C3.a
    public void d0(D3.c<? super A3.c> cVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f3475d.get();
            if (bVar != null && !bVar.g()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f3475d, this.f3474c);
            if (this.f3475d.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z5 = false;
        if (!bVar.f3483c.get() && bVar.f3483c.compareAndSet(false, true)) {
            z5 = true;
        }
        try {
            cVar.accept(bVar);
            if (z5) {
                this.f3473b.c(bVar);
            }
        } catch (Throwable th) {
            B3.b.b(th);
            throw R3.e.d(th);
        }
    }
}
