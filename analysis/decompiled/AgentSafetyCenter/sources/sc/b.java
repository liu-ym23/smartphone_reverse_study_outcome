package sc;

import e9.e0;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jb.v;
import kc.t1;
import pc.r;
import pc.t;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements kc.f, t1 {

    /* renamed from: c, reason: collision with root package name */
    public kc.g f12173c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c f12174f;

    @Override // kc.t1
    public final void a(r rVar, int i) {
        this.f12173c.a(rVar, i);
    }

    @Override // kc.f
    public final boolean f(Throwable th) {
        return this.f12173c.f(th);
    }

    @Override // nb.c
    public final nb.g getContext() {
        return this.f12173c.i;
    }

    @Override // kc.f
    public final t k(Object obj, q qVar) {
        kc.g gVar = this.f12173c;
        c cVar = this.f12174f;
        e0 e0Var = new e0(3);
        e0Var.f3643f = cVar;
        VarHandle.storeStoreFence();
        t tVarK = gVar.k((v) obj, e0Var);
        if (tVarK != null) {
            c.f12175l.set(cVar, null);
        }
        return tVarK;
    }

    @Override // kc.f
    public final void l(Object obj, q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f12175l;
        c cVar = this.f12174f;
        atomicReferenceFieldUpdater.set(cVar, null);
        kc.g gVar = this.f12173c;
        a9.e eVar = new a9.e(14);
        eVar.f257f = cVar;
        VarHandle.storeStoreFence();
        int i = gVar.f7419g;
        e0 e0Var = new e0(1);
        e0Var.f3643f = eVar;
        VarHandle.storeStoreFence();
        gVar.A(v.f6774a, i, e0Var);
    }

    @Override // kc.f
    public final void m(Object obj) {
        this.f12173c.m(obj);
    }

    @Override // nb.c
    public final void resumeWith(Object obj) {
        this.f12173c.resumeWith(obj);
    }
}
