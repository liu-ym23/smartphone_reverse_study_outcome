package J3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class w<T> extends C3.a<T> implements y<T> {

    /* renamed from: b, reason: collision with root package name */
    final x3.f<T> f3454b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<c<T>> f3455c;

    /* renamed from: d, reason: collision with root package name */
    final int f3456d;

    /* renamed from: e, reason: collision with root package name */
    final Q4.a<T> f3457e;

    static final class a<T> implements Q4.a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference<c<T>> f3458a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3459b;

        a(AtomicReference<c<T>> atomicReference, int i5) {
            this.f3458a = atomicReference;
            this.f3459b = i5;
        }

        @Override // Q4.a
        public void c(Q4.b<? super T> bVar) {
            c<T> cVar;
            b<T> bVar2 = new b<>(bVar);
            bVar.e(bVar2);
            while (true) {
                cVar = this.f3458a.get();
                if (cVar == null || cVar.g()) {
                    c<T> cVar2 = new c<>(this.f3458a, this.f3459b);
                    if (this.f3458a.compareAndSet(cVar, cVar2)) {
                        cVar = cVar2;
                    } else {
                        continue;
                    }
                }
                if (cVar.b(bVar2)) {
                    break;
                }
            }
            if (bVar2.get() == Long.MIN_VALUE) {
                cVar.i(bVar2);
            } else {
                bVar2.f3461b = cVar;
            }
            cVar.h();
        }
    }

    static final class b<T> extends AtomicLong implements Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3460a;

        /* renamed from: b, reason: collision with root package name */
        volatile c<T> f3461b;

        /* renamed from: c, reason: collision with root package name */
        long f3462c;

        b(Q4.b<? super T> bVar) {
            this.f3460a = bVar;
        }

        @Override // Q4.c
        public void cancel() {
            c<T> cVar;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (cVar = this.f3461b) == null) {
                return;
            }
            cVar.i(this);
            cVar.h();
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.b(this, j5);
                c<T> cVar = this.f3461b;
                if (cVar != null) {
                    cVar.h();
                }
            }
        }
    }

    static final class c<T> extends AtomicInteger implements x3.i<T>, A3.c {

        /* renamed from: i, reason: collision with root package name */
        static final b[] f3463i = new b[0];

        /* renamed from: j, reason: collision with root package name */
        static final b[] f3464j = new b[0];

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<c<T>> f3465a;

        /* renamed from: b, reason: collision with root package name */
        final int f3466b;

        /* renamed from: f, reason: collision with root package name */
        volatile Object f3470f;

        /* renamed from: g, reason: collision with root package name */
        int f3471g;

        /* renamed from: h, reason: collision with root package name */
        volatile G3.f<T> f3472h;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference<Q4.c> f3469e = new AtomicReference<>();

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<b<T>[]> f3467c = new AtomicReference<>(f3463i);

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f3468d = new AtomicBoolean();

        c(AtomicReference<c<T>> atomicReference, int i5) {
            this.f3465a = atomicReference;
            this.f3466b = i5;
        }

        @Override // Q4.b
        public void a() {
            if (this.f3470f == null) {
                this.f3470f = R3.g.d();
                h();
            }
        }

        boolean b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f3467c.get();
                if (bVarArr == f3464j) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f3467c.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        boolean c(Object obj, boolean z5) {
            int i5 = 0;
            if (obj != null) {
                if (!R3.g.i(obj)) {
                    Throwable thG = R3.g.g(obj);
                    this.f3465a.compareAndSet(this, null);
                    b<T>[] andSet = this.f3467c.getAndSet(f3464j);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i5 < length) {
                            andSet[i5].f3460a.onError(thG);
                            i5++;
                        }
                    } else {
                        S3.a.r(thG);
                    }
                    return true;
                }
                if (z5) {
                    this.f3465a.compareAndSet(this, null);
                    b<T>[] andSet2 = this.f3467c.getAndSet(f3464j);
                    int length2 = andSet2.length;
                    while (i5 < length2) {
                        andSet2[i5].f3460a.a();
                        i5++;
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3471g != 0 || this.f3472h.offer(t5)) {
                h();
            } else {
                onError(new B3.c("Prefetch queue is full?!"));
            }
        }

        @Override // A3.c
        public void dispose() {
            b<T>[] bVarArr = this.f3467c.get();
            b<T>[] bVarArr2 = f3464j;
            if (bVarArr == bVarArr2 || this.f3467c.getAndSet(bVarArr2) == bVarArr2) {
                return;
            }
            this.f3465a.compareAndSet(this, null);
            Q3.g.b(this.f3469e);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.j(this.f3469e, cVar)) {
                if (cVar instanceof G3.c) {
                    G3.c cVar2 = (G3.c) cVar;
                    int iB = cVar2.b(7);
                    if (iB == 1) {
                        this.f3471g = iB;
                        this.f3472h = cVar2;
                        this.f3470f = R3.g.d();
                        h();
                        return;
                    }
                    if (iB == 2) {
                        this.f3471g = iB;
                        this.f3472h = cVar2;
                        cVar.h(this.f3466b);
                        return;
                    }
                }
                this.f3472h = new N3.b(this.f3466b);
                cVar.h(this.f3466b);
            }
        }

        @Override // A3.c
        public boolean g() {
            return this.f3467c.get() == f3464j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:75:0x0125, code lost:
        
            if (r11 == 0) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x012a, code lost:
        
            if (r26.f3471g == 1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x012c, code lost:
        
            r26.f3469e.get().h(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0138, code lost:
        
            r4 = r0;
            r3 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void h() {
            /*
                Method dump skipped, instructions count: 365
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.w.c.h():void");
        }

        void i(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f3467c.get();
                int length = bVarArr.length;
                if (length == 0) {
                    return;
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        i5 = -1;
                        break;
                    } else if (bVarArr[i5].equals(bVar)) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f3463i;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i5);
                    System.arraycopy(bVarArr, i5 + 1, bVarArr3, i5, (length - i5) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f3467c.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            if (this.f3470f != null) {
                S3.a.r(th);
            } else {
                this.f3470f = R3.g.e(th);
                h();
            }
        }
    }

    private w(Q4.a<T> aVar, x3.f<T> fVar, AtomicReference<c<T>> atomicReference, int i5) {
        this.f3457e = aVar;
        this.f3454b = fVar;
        this.f3455c = atomicReference;
        this.f3456d = i5;
    }

    public static <T> C3.a<T> g0(x3.f<T> fVar, int i5) {
        AtomicReference atomicReference = new AtomicReference();
        return S3.a.j(new w(new a(atomicReference, i5), fVar, atomicReference, i5));
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3457e.c(bVar);
    }

    @Override // J3.y
    public int a() {
        return this.f3456d;
    }

    @Override // J3.y
    public Q4.a<T> d() {
        return this.f3454b;
    }

    @Override // C3.a
    public void d0(D3.c<? super A3.c> cVar) {
        c<T> cVar2;
        while (true) {
            cVar2 = this.f3455c.get();
            if (cVar2 != null && !cVar2.g()) {
                break;
            }
            c<T> cVar3 = new c<>(this.f3455c, this.f3456d);
            if (this.f3455c.compareAndSet(cVar2, cVar3)) {
                cVar2 = cVar3;
                break;
            }
        }
        boolean z5 = false;
        if (!cVar2.f3468d.get() && cVar2.f3468d.compareAndSet(false, true)) {
            z5 = true;
        }
        try {
            cVar.accept(cVar2);
            if (z5) {
                this.f3454b.V(cVar2);
            }
        } catch (Throwable th) {
            B3.b.b(th);
            throw R3.e.d(th);
        }
    }
}
