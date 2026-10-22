package H3;

import R3.e;
import java.util.concurrent.CountDownLatch;
import x3.InterfaceC1287c;
import x3.k;
import x3.s;

/* loaded from: classes.dex */
public final class a<T> extends CountDownLatch implements s<T>, InterfaceC1287c, k<T> {

    /* renamed from: a, reason: collision with root package name */
    T f2854a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f2855b;

    /* renamed from: c, reason: collision with root package name */
    A3.c f2856c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f2857d;

    public a() {
        super(1);
    }

    @Override // x3.InterfaceC1287c, x3.k
    public void a() {
        countDown();
    }

    @Override // x3.s, x3.InterfaceC1287c, x3.k
    public void b(A3.c cVar) {
        this.f2856c = cVar;
        if (this.f2857d) {
            cVar.dispose();
        }
    }

    @Override // x3.s, x3.k
    public void c(T t5) {
        this.f2854a = t5;
        countDown();
    }

    public T d() throws InterruptedException {
        if (getCount() != 0) {
            try {
                R3.d.a();
                await();
            } catch (InterruptedException e6) {
                e();
                throw e.d(e6);
            }
        }
        Throwable th = this.f2855b;
        if (th == null) {
            return this.f2854a;
        }
        throw e.d(th);
    }

    void e() {
        this.f2857d = true;
        A3.c cVar = this.f2856c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // x3.s, x3.InterfaceC1287c, x3.k
    public void onError(Throwable th) {
        this.f2855b = th;
        countDown();
    }
}
