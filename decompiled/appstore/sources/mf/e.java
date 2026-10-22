package mf;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e implements ObservableSource {
    public e() {
    }

    public static int a() {
        return b.a();
    }

    public abstract void b(Observer r10);

    @Override // io.reactivex.ObservableSource
    public final void subscribe(Observer r10) {
        io.reactivex.internal.functions.a.b(r10, "observer is null");
        Observer r11 = qf.a.f(this, r10);     // Catch: Throwable -> L5 NullPointerException -> L7
        io.reactivex.internal.functions.a.b(r11, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L7
        b(r11);     // Catch: Throwable -> L5 NullPointerException -> L7
        return;
    L7:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        qf.a.e(th);
        NullPointerException r12 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r12.initCause(th);
        throw r12;
    }
}
