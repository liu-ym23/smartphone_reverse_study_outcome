package w9;

import C7.r;
import S7.k;
import S7.o;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m9.C1718k;
import m9.InterfaceC1717j;
import m9.y0;
import s9.p;

/* renamed from: w9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2109b implements InterfaceC1717j, y0 {

    /* renamed from: a, reason: collision with root package name */
    public final C1718k f6853a;
    public final Object b;
    public final /* synthetic */ kotlinx.coroutines.sync.a c;

    public C2109b(kotlinx.coroutines.sync.a aVar, C1718k c1718k, Object obj) {
        this.c = aVar;
        this.f6853a = c1718k;
        this.b = obj;
    }

    @Override // m9.y0
    public final void c(p pVar, int i) {
        this.f6853a.c(pVar, i);
    }

    @Override // m9.InterfaceC1717j
    public final void d(Object obj, o oVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kotlinx.coroutines.sync.a.i;
        Object obj2 = this.b;
        kotlinx.coroutines.sync.a aVar = this.c;
        atomicReferenceFieldUpdater.set(aVar, obj2);
        this.f6853a.e(new R3.b(28, aVar, this), r.f317a);
    }

    @Override // m9.InterfaceC1717j
    public final void e(k kVar, Object obj) {
        this.f6853a.e(kVar, (r) obj);
    }

    @Override // H7.c
    public final H7.h getContext() {
        return this.f6853a.e;
    }

    @Override // m9.InterfaceC1717j
    public final a5.d h(Object obj, o oVar) {
        kotlinx.coroutines.sync.a aVar = this.c;
        W3.c cVar = new W3.c(3, aVar, this);
        a5.d dVarI = this.f6853a.I((r) obj, cVar);
        if (dVarI != null) {
            kotlinx.coroutines.sync.a.i.set(aVar, this.b);
        }
        return dVarI;
    }

    @Override // m9.InterfaceC1717j
    public final boolean isActive() {
        return this.f6853a.isActive();
    }

    @Override // m9.InterfaceC1717j
    public final void j(k kVar) {
        this.f6853a.j(kVar);
    }

    @Override // m9.InterfaceC1717j
    public final boolean l(Throwable th) {
        return this.f6853a.l(th);
    }

    @Override // H7.c
    public final void resumeWith(Object obj) {
        this.f6853a.resumeWith(obj);
    }

    @Override // m9.InterfaceC1717j
    public final void v(Object obj) {
        this.f6853a.v(obj);
    }
}
