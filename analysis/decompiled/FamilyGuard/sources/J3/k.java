package J3;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class k<T> extends x3.f<T> implements Callable<T> {

    /* renamed from: b, reason: collision with root package name */
    final Callable<? extends T> f3379b;

    public k(Callable<? extends T> callable) {
        this.f3379b = callable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x3.f
    public void W(Q4.b<? super T> bVar) {
        Q3.c cVar = new Q3.c(bVar);
        bVar.e(cVar);
        try {
            cVar.c(F3.b.d(this.f3379b.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            B3.b.b(th);
            if (cVar.g()) {
                S3.a.r(th);
            } else {
                bVar.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return (T) F3.b.d(this.f3379b.call(), "The callable returned a null value");
    }
}
