package k0;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements z0 {

    /* renamed from: c, reason: collision with root package name */
    public ab.e f6910c;

    /* renamed from: f, reason: collision with root package name */
    public Object f6911f;

    /* renamed from: g, reason: collision with root package name */
    public Throwable f6912g;

    /* renamed from: h, reason: collision with root package name */
    public s0.a f6913h;
    public p.a0 i;

    /* renamed from: j, reason: collision with root package name */
    public p.a0 f6914j;

    @Override // k0.z0
    public final Object C(xb.l lVar, pb.c cVar) {
        int i;
        int i3;
        int i10;
        kc.g gVar = new kc.g(1, td.h.y(cVar));
        gVar.s();
        e eVar = new e();
        eVar.f6877a = lVar;
        eVar.f6878b = gVar;
        yb.s sVar = new yb.s();
        sVar.f16096c = -1;
        synchronized (this.f6911f) {
            Throwable th = this.f6912g;
            if (th != null) {
                gVar.resumeWith(id.c.l(th));
            } else {
                s0.a aVar = this.f6913h;
                do {
                    i = aVar.get();
                    i3 = i + 1;
                } while (!aVar.compareAndSet(i, i3));
                boolean z10 = (134217727 & i3) == 1;
                sVar.f16096c = (i3 >>> 27) & 15;
                this.i.a(eVar);
                f fVar = new f();
                fVar.f6895c = eVar;
                fVar.f6896f = this;
                fVar.f6897g = sVar;
                VarHandle.storeStoreFence();
                gVar.u(fVar);
                if (z10) {
                    try {
                        this.f6910c.invoke();
                    } catch (Throwable th2) {
                        synchronized (this.f6911f) {
                            try {
                                if (this.f6912g == null) {
                                    this.f6912g = th2;
                                    p.a0 a0Var = this.i;
                                    Object[] objArr = a0Var.f9516a;
                                    int i11 = a0Var.f9517b;
                                    for (int i12 = 0; i12 < i11; i12++) {
                                        kc.g gVar2 = ((e) objArr[i12]).f6878b;
                                        if (gVar2 != null) {
                                            gVar2.resumeWith(id.c.l(th2));
                                        }
                                    }
                                    this.i.c();
                                    s0.a aVar2 = this.f6913h;
                                    do {
                                        i10 = aVar2.get();
                                    } while (!aVar2.compareAndSet(i10, ((((i10 >>> 27) & 15) + 1) & 15) << 27));
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                }
            }
        }
        Object objR = gVar.r();
        ob.a aVar3 = ob.a.f9351c;
        return objR;
    }

    public final void a(long j10) {
        int i;
        kc.g gVar;
        Object objL;
        synchronized (this.f6911f) {
            try {
                p.a0 a0Var = this.i;
                this.i = this.f6914j;
                this.f6914j = a0Var;
                s0.a aVar = this.f6913h;
                do {
                    i = aVar.get();
                } while (!aVar.compareAndSet(i, ((((i >>> 27) & 15) + 1) & 15) << 27));
                int i3 = a0Var.f9517b;
                for (int i10 = 0; i10 < i3; i10++) {
                    e eVar = (e) a0Var.e(i10);
                    xb.l lVar = eVar.f6877a;
                    if (lVar != null && (gVar = eVar.f6878b) != null) {
                        try {
                            objL = lVar.invoke(Long.valueOf(j10));
                        } catch (Throwable th) {
                            objL = id.c.l(th);
                        }
                        gVar.resumeWith(objL);
                    }
                }
                a0Var.c();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // nb.g
    public final Object fold(Object obj, xb.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // nb.g
    public final nb.e get(nb.f fVar) {
        return ac.a.t(this, fVar);
    }

    @Override // nb.g
    public final nb.g minusKey(nb.f fVar) {
        return ac.a.H(this, fVar);
    }

    @Override // nb.g
    public final nb.g plus(nb.g gVar) {
        return ac.a.N(this, gVar);
    }
}
