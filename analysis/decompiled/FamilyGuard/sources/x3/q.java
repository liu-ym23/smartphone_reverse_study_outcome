package x3;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class q<T> implements u<T> {
    public static <T> q<T> c(t<T> tVar) {
        F3.b.d(tVar, "source is null");
        return S3.a.o(new M3.a(tVar));
    }

    public static <T> q<T> d(Throwable th) {
        F3.b.d(th, "exception is null");
        return e(F3.a.d(th));
    }

    public static <T> q<T> e(Callable<? extends Throwable> callable) {
        F3.b.d(callable, "errorSupplier is null");
        return S3.a.o(new M3.b(callable));
    }

    public static <T> q<T> h(Callable<? extends T> callable) {
        F3.b.d(callable, "callable is null");
        return S3.a.o(new M3.e(callable));
    }

    public static <T> q<T> i(T t5) {
        F3.b.d(t5, "item is null");
        return S3.a.o(new M3.f(t5));
    }

    public static <T1, T2, T3, R> q<R> o(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, D3.d<? super T1, ? super T2, ? super T3, ? extends R> dVar) {
        F3.b.d(uVar, "source1 is null");
        F3.b.d(uVar2, "source2 is null");
        F3.b.d(uVar3, "source3 is null");
        return s(F3.a.e(dVar), uVar, uVar2, uVar3);
    }

    public static <T1, T2, T3, T4, R> q<R> p(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, D3.e<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> eVar) {
        F3.b.d(uVar, "source1 is null");
        F3.b.d(uVar2, "source2 is null");
        F3.b.d(uVar3, "source3 is null");
        F3.b.d(uVar4, "source4 is null");
        return s(F3.a.f(eVar), uVar, uVar2, uVar3, uVar4);
    }

    public static <T1, T2, T3, T4, T5, T6, R> q<R> q(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, D3.f<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> fVar) {
        F3.b.d(uVar, "source1 is null");
        F3.b.d(uVar2, "source2 is null");
        F3.b.d(uVar3, "source3 is null");
        F3.b.d(uVar4, "source4 is null");
        F3.b.d(uVar5, "source5 is null");
        F3.b.d(uVar6, "source6 is null");
        return s(F3.a.g(fVar), uVar, uVar2, uVar3, uVar4, uVar5, uVar6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> q<R> r(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, u<? extends T7> uVar7, D3.g<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> gVar) {
        F3.b.d(uVar, "source1 is null");
        F3.b.d(uVar2, "source2 is null");
        F3.b.d(uVar3, "source3 is null");
        F3.b.d(uVar4, "source4 is null");
        F3.b.d(uVar5, "source5 is null");
        F3.b.d(uVar6, "source6 is null");
        F3.b.d(uVar7, "source7 is null");
        return s(F3.a.h(gVar), uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7);
    }

    public static <T, R> q<R> s(D3.h<? super Object[], ? extends R> hVar, u<? extends T>... uVarArr) {
        F3.b.d(hVar, "zipper is null");
        F3.b.d(uVarArr, "sources is null");
        return uVarArr.length == 0 ? d(new NoSuchElementException()) : S3.a.o(new M3.j(uVarArr, hVar));
    }

    @Override // x3.u
    public final void a(s<? super T> sVar) {
        F3.b.d(sVar, "observer is null");
        s<? super T> sVarZ = S3.a.z(this, sVar);
        F3.b.d(sVarZ, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            m(sVarZ);
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            B3.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final T b() {
        H3.a aVar = new H3.a();
        a(aVar);
        return (T) aVar.d();
    }

    public final <R> q<R> f(D3.h<? super T, ? extends u<? extends R>> hVar) {
        F3.b.d(hVar, "mapper is null");
        return S3.a.o(new M3.c(this, hVar));
    }

    public final <R> f<R> g(D3.h<? super T, ? extends Q4.a<? extends R>> hVar) {
        F3.b.d(hVar, "mapper is null");
        return S3.a.l(new M3.d(this, hVar));
    }

    public final <R> q<R> j(D3.h<? super T, ? extends R> hVar) {
        F3.b.d(hVar, "mapper is null");
        return S3.a.o(new M3.g(this, hVar));
    }

    public final q<T> k(p pVar) {
        F3.b.d(pVar, "scheduler is null");
        return S3.a.o(new M3.h(this, pVar));
    }

    public final A3.c l(D3.c<? super T> cVar, D3.c<? super Throwable> cVar2) {
        F3.b.d(cVar, "onSuccess is null");
        F3.b.d(cVar2, "onError is null");
        H3.c cVar3 = new H3.c(cVar, cVar2);
        a(cVar3);
        return cVar3;
    }

    protected abstract void m(s<? super T> sVar);

    public final q<T> n(p pVar) {
        F3.b.d(pVar, "scheduler is null");
        return S3.a.o(new M3.i(this, pVar));
    }
}
