package M3;

import java.util.concurrent.Callable;
import x3.q;
import x3.s;

/* loaded from: classes.dex */
public final class b<T> extends q<T> {

    /* renamed from: a, reason: collision with root package name */
    final Callable<? extends Throwable> f4121a;

    public b(Callable<? extends Throwable> callable) {
        this.f4121a = callable;
    }

    @Override // x3.q
    protected void m(s<? super T> sVar) {
        try {
            th = (Throwable) F3.b.d(this.f4121a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            B3.b.b(th);
        }
        E3.c.e(th, sVar);
    }
}
