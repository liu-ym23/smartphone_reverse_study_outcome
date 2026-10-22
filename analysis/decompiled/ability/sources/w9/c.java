package w9;

import m9.InterfaceC1693K;
import s9.p;
import v9.InterfaceC2075d;

/* loaded from: classes4.dex */
public final class c implements InterfaceC2075d {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2075d f6854a;
    public final Object b;
    public final /* synthetic */ kotlinx.coroutines.sync.a c;

    public c(kotlinx.coroutines.sync.a aVar, InterfaceC2075d interfaceC2075d, Object obj) {
        this.c = aVar;
        this.f6854a = interfaceC2075d;
        this.b = obj;
    }

    @Override // v9.InterfaceC2075d
    public final void a(InterfaceC1693K interfaceC1693K) {
        this.f6854a.a(interfaceC1693K);
    }

    @Override // m9.y0
    public final void c(p pVar, int i) {
        this.f6854a.c(pVar, i);
    }

    @Override // v9.InterfaceC2075d
    public final void f(Object obj) {
        kotlinx.coroutines.sync.a.i.set(this.c, this.b);
        this.f6854a.f(obj);
    }

    @Override // v9.InterfaceC2075d
    public final boolean g(Object obj, Object obj2) {
        boolean zG = this.f6854a.g(obj, obj2);
        if (zG) {
            kotlinx.coroutines.sync.a.i.set(this.c, this.b);
        }
        return zG;
    }
}
