package T3;

import O3.o;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import x3.p;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final p f5416a = S3.a.g(new h());

    /* renamed from: b, reason: collision with root package name */
    static final p f5417b = S3.a.d(new b());

    /* renamed from: c, reason: collision with root package name */
    static final p f5418c = S3.a.e(new c());

    /* renamed from: d, reason: collision with root package name */
    static final p f5419d = O3.p.e();

    /* renamed from: e, reason: collision with root package name */
    static final p f5420e = S3.a.f(new f());

    /* renamed from: T3.a$a, reason: collision with other inner class name */
    static final class C0082a {

        /* renamed from: a, reason: collision with root package name */
        static final p f5421a = new O3.b();
    }

    static final class b implements Callable<p> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return C0082a.f5421a;
        }
    }

    static final class c implements Callable<p> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return d.f5422a;
        }
    }

    static final class d {

        /* renamed from: a, reason: collision with root package name */
        static final p f5422a = new O3.f();
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        static final p f5423a = new O3.g();
    }

    static final class f implements Callable<p> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return e.f5423a;
        }
    }

    static final class g {

        /* renamed from: a, reason: collision with root package name */
        static final p f5424a = new o();
    }

    static final class h implements Callable<p> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return g.f5424a;
        }
    }

    public static p a() {
        return S3.a.q(f5417b);
    }

    public static p b(Executor executor) {
        return new O3.d(executor, false);
    }

    public static p c() {
        return S3.a.s(f5418c);
    }

    public static p d() {
        return S3.a.u(f5416a);
    }
}
