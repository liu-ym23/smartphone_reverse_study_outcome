package M3;

import A0.e;
import java.util.concurrent.Callable;
import x3.q;
import x3.s;

/* loaded from: classes.dex */
public final class e<T> extends q<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends T> f4134a;

    public e(Callable<? extends T> callable) {
        this.f4134a = callable;
    }

    @Override // x3.q
    protected void m(s<? super T> sVar) {
        A3.c cVarB = A3.d.b();
        sVar.b(cVarB);
        if (cVarB.g()) {
            return;
        }
        try {
            e.a aVar = (Object) F3.b.d(this.f4134a.call(), "The callable returned a null value");
            if (cVarB.g()) {
                return;
            }
            sVar.c(aVar);
        } catch (Throwable th) {
            B3.b.b(th);
            if (cVarB.g()) {
                S3.a.r(th);
            } else {
                sVar.onError(th);
            }
        }
    }
}
