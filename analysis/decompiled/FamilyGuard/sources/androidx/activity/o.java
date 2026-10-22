package androidx.activity;

import V3.v;
import i4.InterfaceC0761a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7384a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f7385b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0761a<v> f7386c;

    public o(boolean z5) {
        this.f7384a = z5;
    }

    public final void a(c cVar) {
        j4.k.g(cVar, "cancellable");
        this.f7385b.add(cVar);
    }

    public final InterfaceC0761a<v> b() {
        return this.f7386c;
    }

    public void c() {
    }

    public abstract void d();

    public void e(b bVar) {
        j4.k.g(bVar, "backEvent");
    }

    public void f(b bVar) {
        j4.k.g(bVar, "backEvent");
    }

    public final boolean g() {
        return this.f7384a;
    }

    public final void h() {
        Iterator<T> it = this.f7385b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void i(c cVar) {
        j4.k.g(cVar, "cancellable");
        this.f7385b.remove(cVar);
    }

    public final void j(boolean z5) {
        this.f7384a = z5;
        InterfaceC0761a<v> interfaceC0761a = this.f7386c;
        if (interfaceC0761a != null) {
            interfaceC0761a.invoke();
        }
    }

    public final void k(InterfaceC0761a<v> interfaceC0761a) {
        this.f7386c = interfaceC0761a;
    }
}
