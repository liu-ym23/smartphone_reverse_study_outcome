package x3;

import J3.A;
import J3.B;
import J3.C;
import J3.C0351b;
import J3.C0352c;
import J3.C0353d;
import J3.C0354e;
import J3.C0355f;
import J3.C0356g;
import J3.D;
import J3.E;
import J3.F;
import J3.G;
import J3.v;
import J3.w;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class f<T> implements Q4.a<T> {

    /* renamed from: a, reason: collision with root package name */
    static final int f23811a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static f<Long> A(long j5, TimeUnit timeUnit) {
        return z(j5, j5, timeUnit, T3.a.a());
    }

    public static f<Long> B(long j5, long j6, long j7, long j8, TimeUnit timeUnit) {
        return C(j5, j6, j7, j8, timeUnit, T3.a.a());
    }

    public static f<Long> C(long j5, long j6, long j7, long j8, TimeUnit timeUnit, p pVar) {
        if (j6 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j6);
        }
        if (j6 == 0) {
            return p().k(j7, timeUnit, pVar);
        }
        long j9 = (j6 - 1) + j5;
        if (j5 > 0 && j9 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        F3.b.d(timeUnit, "unit is null");
        F3.b.d(pVar, "scheduler is null");
        return S3.a.l(new J3.o(j5, j9, Math.max(0L, j7), Math.max(0L, j8), timeUnit, pVar));
    }

    public static <T> f<T> D(T t5) {
        F3.b.d(t5, "item is null");
        return S3.a.l(new J3.p(t5));
    }

    public static <T> f<T> F(Q4.a<? extends T> aVar, Q4.a<? extends T> aVar2) {
        F3.b.d(aVar, "source1 is null");
        F3.b.d(aVar2, "source2 is null");
        return w(aVar, aVar2).s(F3.a.c(), false, 2);
    }

    public static f<Long> b0(long j5, TimeUnit timeUnit) {
        return c0(j5, timeUnit, T3.a.a());
    }

    public static f<Long> c0(long j5, TimeUnit timeUnit, p pVar) {
        F3.b.d(timeUnit, "unit is null");
        F3.b.d(pVar, "scheduler is null");
        return S3.a.l(new G(Math.max(0L, j5), timeUnit, pVar));
    }

    public static int g() {
        return f23811a;
    }

    public static <T> f<T> h(h<T> hVar, EnumC1285a enumC1285a) {
        F3.b.d(hVar, "source is null");
        F3.b.d(enumC1285a, "mode is null");
        return S3.a.l(new C0351b(hVar, enumC1285a));
    }

    private f<T> n(D3.c<? super T> cVar, D3.c<? super Throwable> cVar2, D3.a aVar, D3.a aVar2) {
        F3.b.d(cVar, "onNext is null");
        F3.b.d(cVar2, "onError is null");
        F3.b.d(aVar, "onComplete is null");
        F3.b.d(aVar2, "onAfterTerminate is null");
        return S3.a.l(new C0354e(this, cVar, cVar2, aVar, aVar2));
    }

    public static <T> f<T> p() {
        return S3.a.l(C0355f.f3323b);
    }

    public static <T> f<T> w(T... tArr) {
        F3.b.d(tArr, "items is null");
        return tArr.length == 0 ? p() : tArr.length == 1 ? D(tArr[0]) : S3.a.l(new J3.j(tArr));
    }

    public static <T> f<T> x(Callable<? extends T> callable) {
        F3.b.d(callable, "supplier is null");
        return S3.a.l(new J3.k(callable));
    }

    public static f<Long> y(long j5, long j6, TimeUnit timeUnit) {
        return z(j5, j6, timeUnit, T3.a.a());
    }

    public static f<Long> z(long j5, long j6, TimeUnit timeUnit, p pVar) {
        F3.b.d(timeUnit, "unit is null");
        F3.b.d(pVar, "scheduler is null");
        return S3.a.l(new J3.n(Math.max(0L, j5), Math.max(0L, j6), timeUnit, pVar));
    }

    public final <R> f<R> E(D3.h<? super T, ? extends R> hVar) {
        F3.b.d(hVar, "mapper is null");
        return S3.a.l(new J3.q(this, hVar));
    }

    public final f<T> G(p pVar) {
        return H(pVar, false, g());
    }

    public final f<T> H(p pVar, boolean z5, int i5) {
        F3.b.d(pVar, "scheduler is null");
        F3.b.e(i5, "bufferSize");
        return S3.a.l(new J3.r(this, pVar, z5, i5));
    }

    public final f<T> I() {
        return J(g(), false, true);
    }

    public final f<T> J(int i5, boolean z5, boolean z6) {
        F3.b.e(i5, "capacity");
        return S3.a.l(new J3.s(this, i5, z6, z5, F3.a.f1739c));
    }

    public final f<T> K() {
        return S3.a.l(new J3.t(this));
    }

    public final f<T> L() {
        return S3.a.l(new v(this));
    }

    public final C3.a<T> M() {
        return N(g());
    }

    public final C3.a<T> N(int i5) {
        F3.b.e(i5, "bufferSize");
        return w.g0(this, i5);
    }

    public final f<T> O(long j5) {
        return P(j5, F3.a.a());
    }

    public final f<T> P(long j5, D3.j<? super Throwable> jVar) {
        if (j5 >= 0) {
            F3.b.d(jVar, "predicate is null");
            return S3.a.l(new A(this, j5, jVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j5);
    }

    public final q<T> Q(T t5) {
        F3.b.d(t5, "defaultItem is null");
        return S3.a.o(new C(this, t5));
    }

    public final q<T> R() {
        return S3.a.o(new C(this, null));
    }

    public final A3.c S(D3.c<? super T> cVar) {
        return U(cVar, F3.a.f1742f, F3.a.f1739c, J3.m.INSTANCE);
    }

    public final A3.c T(D3.c<? super T> cVar, D3.c<? super Throwable> cVar2) {
        return U(cVar, cVar2, F3.a.f1739c, J3.m.INSTANCE);
    }

    public final A3.c U(D3.c<? super T> cVar, D3.c<? super Throwable> cVar2, D3.a aVar, D3.c<? super Q4.c> cVar3) {
        F3.b.d(cVar, "onNext is null");
        F3.b.d(cVar2, "onError is null");
        F3.b.d(aVar, "onComplete is null");
        F3.b.d(cVar3, "onSubscribe is null");
        P3.c cVar4 = new P3.c(cVar, cVar2, aVar, cVar3);
        V(cVar4);
        return cVar4;
    }

    public final void V(i<? super T> iVar) {
        F3.b.d(iVar, "s is null");
        try {
            Q4.b<? super T> bVarV = S3.a.v(this, iVar);
            F3.b.d(bVarV, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            W(bVarV);
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            B3.b.b(th);
            S3.a.r(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void W(Q4.b<? super T> bVar);

    public final f<T> X(p pVar) {
        F3.b.d(pVar, "scheduler is null");
        return Y(pVar, !(this instanceof C0351b));
    }

    public final f<T> Y(p pVar, boolean z5) {
        F3.b.d(pVar, "scheduler is null");
        return S3.a.l(new D(this, pVar, z5));
    }

    public final f<T> Z(long j5) {
        if (j5 >= 0) {
            return S3.a.l(new E(this, j5));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j5);
    }

    public final f<T> a0(D3.j<? super T> jVar) {
        F3.b.d(jVar, "predicate is null");
        return S3.a.l(new F(this, jVar));
    }

    @Override // Q4.a
    public final void c(Q4.b<? super T> bVar) {
        if (bVar instanceof i) {
            V((i) bVar);
        } else {
            F3.b.d(bVar, "s is null");
            V(new P3.d(bVar));
        }
    }

    public final T e() {
        return R().b();
    }

    public final T f(T t5) {
        return Q(t5).b();
    }

    public final f<T> i(long j5, TimeUnit timeUnit) {
        return j(j5, timeUnit, T3.a.a());
    }

    public final f<T> j(long j5, TimeUnit timeUnit, p pVar) {
        F3.b.d(timeUnit, "unit is null");
        F3.b.d(pVar, "scheduler is null");
        return S3.a.l(new C0352c(this, j5, timeUnit, pVar));
    }

    public final f<T> k(long j5, TimeUnit timeUnit, p pVar) {
        return l(j5, timeUnit, pVar, false);
    }

    public final f<T> l(long j5, TimeUnit timeUnit, p pVar, boolean z5) {
        F3.b.d(timeUnit, "unit is null");
        F3.b.d(pVar, "scheduler is null");
        return S3.a.l(new C0353d(this, Math.max(0L, j5), timeUnit, pVar, z5));
    }

    public final f<T> m(D3.a aVar) {
        return n(F3.a.b(), F3.a.b(), aVar, F3.a.f1739c);
    }

    public final f<T> o(D3.c<? super T> cVar) {
        D3.c<? super Throwable> cVarB = F3.a.b();
        D3.a aVar = F3.a.f1739c;
        return n(cVar, cVarB, aVar, aVar);
    }

    public final f<T> q(D3.j<? super T> jVar) {
        F3.b.d(jVar, "predicate is null");
        return S3.a.l(new C0356g(this, jVar));
    }

    public final <R> f<R> r(D3.h<? super T, ? extends Q4.a<? extends R>> hVar) {
        return t(hVar, false, g(), g());
    }

    public final <R> f<R> s(D3.h<? super T, ? extends Q4.a<? extends R>> hVar, boolean z5, int i5) {
        return t(hVar, z5, i5, g());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> f<R> t(D3.h<? super T, ? extends Q4.a<? extends R>> hVar, boolean z5, int i5, int i6) {
        F3.b.d(hVar, "mapper is null");
        F3.b.e(i5, "maxConcurrency");
        F3.b.e(i6, "bufferSize");
        if (!(this instanceof G3.d)) {
            return S3.a.l(new J3.h(this, hVar, z5, i5, i6));
        }
        Object objCall = ((G3.d) this).call();
        return objCall == null ? p() : B.a(objCall, hVar);
    }

    public final <R> f<R> u(D3.h<? super T, ? extends l<? extends R>> hVar) {
        return v(hVar, false, Integer.MAX_VALUE);
    }

    public final <R> f<R> v(D3.h<? super T, ? extends l<? extends R>> hVar, boolean z5, int i5) {
        F3.b.d(hVar, "mapper is null");
        F3.b.e(i5, "maxConcurrency");
        return S3.a.l(new J3.i(this, hVar, z5, i5));
    }
}
