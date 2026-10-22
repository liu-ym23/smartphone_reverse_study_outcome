package x3;

import java.util.concurrent.TimeUnit;

/* renamed from: x3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1286b implements InterfaceC1288d {
    public static AbstractC1286b b() {
        return S3.a.k(I3.a.f2958a);
    }

    public static AbstractC1286b c(D3.a aVar) {
        F3.b.d(aVar, "run is null");
        return S3.a.k(new I3.b(aVar));
    }

    public static AbstractC1286b d(Runnable runnable) {
        F3.b.d(runnable, "run is null");
        return S3.a.k(new I3.c(runnable));
    }

    public static AbstractC1286b k(long j5, TimeUnit timeUnit) {
        return l(j5, timeUnit, T3.a.a());
    }

    public static AbstractC1286b l(long j5, TimeUnit timeUnit, p pVar) {
        F3.b.d(timeUnit, "unit is null");
        F3.b.d(pVar, "scheduler is null");
        return S3.a.k(new I3.f(j5, timeUnit, pVar));
    }

    private static NullPointerException m(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // x3.InterfaceC1288d
    public final void a(InterfaceC1287c interfaceC1287c) {
        F3.b.d(interfaceC1287c, "observer is null");
        try {
            InterfaceC1287c interfaceC1287cW = S3.a.w(this, interfaceC1287c);
            F3.b.d(interfaceC1287cW, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            i(interfaceC1287cW);
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            B3.b.b(th);
            S3.a.r(th);
            throw m(th);
        }
    }

    public final AbstractC1286b e(p pVar) {
        F3.b.d(pVar, "scheduler is null");
        return S3.a.k(new I3.d(this, pVar));
    }

    public final A3.c f() {
        H3.d dVar = new H3.d();
        a(dVar);
        return dVar;
    }

    public final A3.c g(D3.a aVar) {
        F3.b.d(aVar, "onComplete is null");
        H3.b bVar = new H3.b(aVar);
        a(bVar);
        return bVar;
    }

    public final A3.c h(D3.a aVar, D3.c<? super Throwable> cVar) {
        F3.b.d(cVar, "onError is null");
        F3.b.d(aVar, "onComplete is null");
        H3.b bVar = new H3.b(cVar, aVar);
        a(bVar);
        return bVar;
    }

    protected abstract void i(InterfaceC1287c interfaceC1287c);

    public final AbstractC1286b j(p pVar) {
        F3.b.d(pVar, "scheduler is null");
        return S3.a.k(new I3.e(this, pVar));
    }
}
