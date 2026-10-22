package K3;

import A3.c;
import A3.d;
import B3.b;
import java.util.concurrent.Callable;
import x3.j;
import x3.k;

/* loaded from: classes.dex */
public final class a<T> extends j<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends T> f3667a;

    public a(Callable<? extends T> callable) {
        this.f3667a = callable;
    }

    @Override // x3.j
    protected void c(k<? super T> kVar) {
        c cVarB = d.b();
        kVar.b(cVarB);
        if (cVarB.g()) {
            return;
        }
        try {
            T tCall = this.f3667a.call();
            if (cVarB.g()) {
                return;
            }
            if (tCall == null) {
                kVar.a();
            } else {
                kVar.c(tCall);
            }
        } catch (Throwable th) {
            b.b(th);
            if (cVarB.g()) {
                S3.a.r(th);
            } else {
                kVar.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return this.f3667a.call();
    }
}
