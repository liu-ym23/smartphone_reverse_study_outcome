package x3;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class j<T> implements l<T> {
    public static <T> j<T> b(Callable<? extends T> callable) {
        F3.b.d(callable, "callable is null");
        return S3.a.m(new K3.a(callable));
    }

    @Override // x3.l
    public final void a(k<? super T> kVar) {
        F3.b.d(kVar, "observer is null");
        k<? super T> kVarX = S3.a.x(this, kVar);
        F3.b.d(kVarX, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            c(kVarX);
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            B3.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void c(k<? super T> kVar);
}
