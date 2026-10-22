package M3;

import M3.g;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import x3.q;
import x3.s;
import x3.u;

/* loaded from: classes.dex */
public final class j<T, R> extends q<R> {

    /* renamed from: a, reason: collision with root package name */
    final u<? extends T>[] f4151a;

    /* renamed from: b, reason: collision with root package name */
    final D3.h<? super Object[], ? extends R> f4152b;

    final class a implements D3.h<T, R> {
        a() {
        }

        @Override // D3.h
        public R apply(T t5) {
            return (R) F3.b.d(j.this.f4152b.apply(new Object[]{t5}), "The zipper returned a null value");
        }
    }

    static final class b<T, R> extends AtomicInteger implements A3.c {

        /* renamed from: a, reason: collision with root package name */
        final s<? super R> f4154a;

        /* renamed from: b, reason: collision with root package name */
        final D3.h<? super Object[], ? extends R> f4155b;

        /* renamed from: c, reason: collision with root package name */
        final c<T>[] f4156c;

        /* renamed from: d, reason: collision with root package name */
        final Object[] f4157d;

        b(s<? super R> sVar, int i5, D3.h<? super Object[], ? extends R> hVar) {
            super(i5);
            this.f4154a = sVar;
            this.f4155b = hVar;
            c<T>[] cVarArr = new c[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                cVarArr[i6] = new c<>(this, i6);
            }
            this.f4156c = cVarArr;
            this.f4157d = new Object[i5];
        }

        void a(int i5) {
            c<T>[] cVarArr = this.f4156c;
            int length = cVarArr.length;
            for (int i6 = 0; i6 < i5; i6++) {
                cVarArr[i6].a();
            }
            while (true) {
                i5++;
                if (i5 >= length) {
                    return;
                } else {
                    cVarArr[i5].a();
                }
            }
        }

        void b(Throwable th, int i5) {
            if (getAndSet(0) <= 0) {
                S3.a.r(th);
            } else {
                a(i5);
                this.f4154a.onError(th);
            }
        }

        void c(T t5, int i5) {
            this.f4157d[i5] = t5;
            if (decrementAndGet() == 0) {
                try {
                    this.f4154a.c(F3.b.d(this.f4155b.apply(this.f4157d), "The zipper returned a null value"));
                } catch (Throwable th) {
                    B3.b.b(th);
                    this.f4154a.onError(th);
                }
            }
        }

        @Override // A3.c
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (c<T> cVar : this.f4156c) {
                    cVar.a();
                }
            }
        }

        @Override // A3.c
        public boolean g() {
            return get() <= 0;
        }
    }

    static final class c<T> extends AtomicReference<A3.c> implements s<T> {

        /* renamed from: a, reason: collision with root package name */
        final b<T, ?> f4158a;

        /* renamed from: b, reason: collision with root package name */
        final int f4159b;

        c(b<T, ?> bVar, int i5) {
            this.f4158a = bVar;
            this.f4159b = i5;
        }

        public void a() {
            E3.b.b(this);
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void b(A3.c cVar) {
            E3.b.j(this, cVar);
        }

        @Override // x3.s, x3.k
        public void c(T t5) {
            this.f4158a.c(t5, this.f4159b);
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void onError(Throwable th) {
            this.f4158a.b(th, this.f4159b);
        }
    }

    public j(u<? extends T>[] uVarArr, D3.h<? super Object[], ? extends R> hVar) {
        this.f4151a = uVarArr;
        this.f4152b = hVar;
    }

    @Override // x3.q
    protected void m(s<? super R> sVar) {
        u<? extends T>[] uVarArr = this.f4151a;
        int length = uVarArr.length;
        if (length == 1) {
            uVarArr[0].a(new g.a(sVar, new a()));
            return;
        }
        b bVar = new b(sVar, length, this.f4152b);
        sVar.b(bVar);
        for (int i5 = 0; i5 < length && !bVar.g(); i5++) {
            u<? extends T> uVar = uVarArr[i5];
            if (uVar == null) {
                bVar.b(new NullPointerException("One of the sources is null"), i5);
                return;
            }
            uVar.a(bVar.f4156c[i5]);
        }
    }
}
