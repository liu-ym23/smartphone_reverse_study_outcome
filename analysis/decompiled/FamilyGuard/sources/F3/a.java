package F3;

import java.util.Comparator;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final D3.h<Object, Object> f1737a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static final Runnable f1738b = new h();

    /* renamed from: c, reason: collision with root package name */
    public static final D3.a f1739c = new e();

    /* renamed from: d, reason: collision with root package name */
    static final D3.c<Object> f1740d = new f();

    /* renamed from: e, reason: collision with root package name */
    public static final D3.c<Throwable> f1741e = new i();

    /* renamed from: f, reason: collision with root package name */
    public static final D3.c<Throwable> f1742f = new p();

    /* renamed from: g, reason: collision with root package name */
    public static final D3.i f1743g = new g();

    /* renamed from: h, reason: collision with root package name */
    static final D3.j<Object> f1744h = new q();

    /* renamed from: i, reason: collision with root package name */
    static final D3.j<Object> f1745i = new j();

    /* renamed from: j, reason: collision with root package name */
    static final Callable<Object> f1746j = new o();

    /* renamed from: k, reason: collision with root package name */
    static final Comparator<Object> f1747k = new n();

    /* renamed from: l, reason: collision with root package name */
    public static final D3.c<Q4.c> f1748l = new m();

    /* renamed from: F3.a$a, reason: collision with other inner class name */
    static final class C0027a<T1, T2, T3, R> implements D3.h<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final D3.d<T1, T2, T3, R> f1749a;

        C0027a(D3.d<T1, T2, T3, R> dVar) {
            this.f1749a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // D3.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length == 3) {
                return (R) this.f1749a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    static final class b<T1, T2, T3, T4, R> implements D3.h<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final D3.e<T1, T2, T3, T4, R> f1750a;

        b(D3.e<T1, T2, T3, T4, R> eVar) {
            this.f1750a = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // D3.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length == 4) {
                return (R) this.f1750a.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    static final class c<T1, T2, T3, T4, T5, T6, R> implements D3.h<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final D3.f<T1, T2, T3, T4, T5, T6, R> f1751a;

        c(D3.f<T1, T2, T3, T4, T5, T6, R> fVar) {
            this.f1751a = fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // D3.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length == 6) {
                return (R) this.f1751a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    static final class d<T1, T2, T3, T4, T5, T6, T7, R> implements D3.h<Object[], R> {

        /* renamed from: a, reason: collision with root package name */
        final D3.g<T1, T2, T3, T4, T5, T6, T7, R> f1752a;

        d(D3.g<T1, T2, T3, T4, T5, T6, T7, R> gVar) {
            this.f1752a = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // D3.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length == 7) {
                return (R) this.f1752a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    static final class e implements D3.a {
        e() {
        }

        @Override // D3.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class f implements D3.c<Object> {
        f() {
        }

        @Override // D3.c
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class g implements D3.i {
        g() {
        }
    }

    static final class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class i implements D3.c<Throwable> {
        i() {
        }

        @Override // D3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            S3.a.r(th);
        }
    }

    static final class j implements D3.j<Object> {
        j() {
        }

        @Override // D3.j
        public boolean test(Object obj) {
            return false;
        }
    }

    static final class k implements D3.h<Object, Object> {
        k() {
        }

        @Override // D3.h
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class l<T, U> implements Callable<U>, D3.h<T, U> {

        /* renamed from: a, reason: collision with root package name */
        final U f1753a;

        l(U u5) {
            this.f1753a = u5;
        }

        @Override // D3.h
        public U apply(T t5) {
            return this.f1753a;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.f1753a;
        }
    }

    static final class m implements D3.c<Q4.c> {
        m() {
        }

        @Override // D3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Q4.c cVar) {
            cVar.h(Long.MAX_VALUE);
        }
    }

    static final class n implements Comparator<Object> {
        n() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class o implements Callable<Object> {
        o() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class p implements D3.c<Throwable> {
        p() {
        }

        @Override // D3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            S3.a.r(new B3.d(th));
        }
    }

    static final class q implements D3.j<Object> {
        q() {
        }

        @Override // D3.j
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> D3.j<T> a() {
        return (D3.j<T>) f1744h;
    }

    public static <T> D3.c<T> b() {
        return (D3.c<T>) f1740d;
    }

    public static <T> D3.h<T, T> c() {
        return (D3.h<T, T>) f1737a;
    }

    public static <T> Callable<T> d(T t5) {
        return new l(t5);
    }

    public static <T1, T2, T3, R> D3.h<Object[], R> e(D3.d<T1, T2, T3, R> dVar) {
        F3.b.d(dVar, "f is null");
        return new C0027a(dVar);
    }

    public static <T1, T2, T3, T4, R> D3.h<Object[], R> f(D3.e<T1, T2, T3, T4, R> eVar) {
        F3.b.d(eVar, "f is null");
        return new b(eVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> D3.h<Object[], R> g(D3.f<T1, T2, T3, T4, T5, T6, R> fVar) {
        F3.b.d(fVar, "f is null");
        return new c(fVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> D3.h<Object[], R> h(D3.g<T1, T2, T3, T4, T5, T6, T7, R> gVar) {
        F3.b.d(gVar, "f is null");
        return new d(gVar);
    }
}
