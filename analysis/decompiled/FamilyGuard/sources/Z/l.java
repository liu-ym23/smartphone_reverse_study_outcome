package Z;

import d0.InterfaceC0651f;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6615a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final g f6616b;

    /* renamed from: c, reason: collision with root package name */
    private volatile InterfaceC0651f f6617c;

    public l(g gVar) {
        this.f6616b = gVar;
    }

    private InterfaceC0651f c() {
        return this.f6616b.c(d());
    }

    private InterfaceC0651f e(boolean z5) {
        if (!z5) {
            return c();
        }
        if (this.f6617c == null) {
            this.f6617c = c();
        }
        return this.f6617c;
    }

    public InterfaceC0651f a() {
        b();
        return e(this.f6615a.compareAndSet(false, true));
    }

    protected void b() {
        this.f6616b.a();
    }

    protected abstract String d();

    public void f(InterfaceC0651f interfaceC0651f) {
        if (interfaceC0651f == this.f6617c) {
            this.f6615a.set(false);
        }
    }
}
