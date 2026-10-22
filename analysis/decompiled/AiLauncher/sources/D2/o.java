package D2;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public final class o<T> implements p<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f2221a = new CountDownLatch(1);

    public /* synthetic */ o(n nVar) {
    }

    @Override // D2.InterfaceC0794f
    public final void a(T t10) {
        this.f2221a.countDown();
    }

    @Override // D2.InterfaceC0791c
    public final void b() {
        this.f2221a.countDown();
    }

    public final void c() throws InterruptedException {
        this.f2221a.await();
    }

    @Override // D2.InterfaceC0793e
    public final void onFailure(Exception exc) {
        this.f2221a.countDown();
    }
}
