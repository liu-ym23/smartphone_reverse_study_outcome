package ka;

import ia.d0;
import ia.g2;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w7.e0;

/* loaded from: classes.dex */
public final class b implements g2 {

    /* renamed from: f, reason: collision with root package name */
    public Object f5666f = i.f5703p;

    /* renamed from: g, reason: collision with root package name */
    public ia.m f5667g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g f5668h;

    public b(g gVar) {
        this.f5668h = gVar;
    }

    public final Object a(i7.c cVar) {
        o oVarN;
        Object obj = this.f5666f;
        boolean z4 = true;
        if (obj == i.f5703p || obj == i.f5699l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g.f5682l;
            g gVar = this.f5668h;
            o oVar = (o) atomicReferenceFieldUpdater.get(gVar);
            while (true) {
                if (gVar.x()) {
                    this.f5666f = i.f5699l;
                    Throwable thO = gVar.o();
                    if (thO != null) {
                        int i2 = na.t.f6928a;
                        throw thO;
                    }
                    z4 = false;
                } else {
                    long andIncrement = g.f5678h.getAndIncrement(gVar);
                    long j2 = i.f5689b;
                    long j4 = andIncrement / j2;
                    int i10 = (int) (andIncrement % j2);
                    if (oVar.f6927c != j4) {
                        oVarN = gVar.n(j4, oVar);
                        if (oVarN == null) {
                            continue;
                        }
                    } else {
                        oVarN = oVar;
                    }
                    Object objI = gVar.I(oVarN, i10, andIncrement, null);
                    f8.x xVar = i.f5700m;
                    if (objI == xVar) {
                        throw new IllegalStateException("unreachable");
                    }
                    f8.x xVar2 = i.f5702o;
                    if (objI == xVar2) {
                        if (andIncrement < gVar.s()) {
                            oVarN.b();
                        }
                        oVar = oVarN;
                    } else {
                        if (objI == i.f5701n) {
                            g gVar2 = this.f5668h;
                            ia.m mVarM = d0.m(ib.k.C(cVar));
                            try {
                                this.f5667g = mVarM;
                                Object objI2 = gVar2.I(oVarN, i10, andIncrement, this);
                                if (objI2 == xVar) {
                                    b(oVarN, i10);
                                } else {
                                    if (objI2 == xVar2) {
                                        if (andIncrement < gVar2.s()) {
                                            oVarN.b();
                                        }
                                        o oVar2 = (o) g.f5682l.get(gVar2);
                                        while (true) {
                                            if (gVar2.x()) {
                                                ia.m mVar = this.f5667g;
                                                q7.k.b(mVar);
                                                this.f5667g = null;
                                                this.f5666f = i.f5699l;
                                                Throwable thO2 = gVar.o();
                                                if (thO2 == null) {
                                                    mVar.resumeWith(Boolean.FALSE);
                                                } else {
                                                    mVar.resumeWith(e0.n(thO2));
                                                }
                                            } else {
                                                long andIncrement2 = g.f5678h.getAndIncrement(gVar2);
                                                long j10 = i.f5689b;
                                                long j11 = andIncrement2 / j10;
                                                int i11 = (int) (andIncrement2 % j10);
                                                if (oVar2.f6927c != j11) {
                                                    o oVarN2 = gVar2.n(j11, oVar2);
                                                    if (oVarN2 != null) {
                                                        oVar2 = oVarN2;
                                                    }
                                                }
                                                Object objI3 = gVar2.I(oVar2, i11, andIncrement2, this);
                                                if (objI3 == i.f5700m) {
                                                    b(oVar2, i11);
                                                    break;
                                                }
                                                if (objI3 == i.f5702o) {
                                                    if (andIncrement2 < gVar2.s()) {
                                                        oVar2.b();
                                                    }
                                                } else {
                                                    if (objI3 == i.f5701n) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    oVar2.b();
                                                    this.f5666f = objI3;
                                                    this.f5667g = null;
                                                }
                                            }
                                        }
                                    } else {
                                        oVarN.b();
                                        this.f5666f = objI2;
                                        this.f5667g = null;
                                    }
                                    mVarM.m(Boolean.TRUE, null);
                                }
                                Object objR = mVarM.r();
                                h7.a aVar = h7.a.f4212f;
                                return objR;
                            } catch (Throwable th) {
                                mVarM.B();
                                throw th;
                            }
                        }
                        oVarN.b();
                        this.f5666f = objI;
                    }
                }
            }
        }
        return Boolean.valueOf(z4);
    }

    @Override // ia.g2
    public final void b(na.s sVar, int i2) {
        ia.m mVar = this.f5667g;
        if (mVar != null) {
            mVar.b(sVar, i2);
        }
    }

    public final Object c() throws Throwable {
        Object obj = this.f5666f;
        f8.x xVar = i.f5703p;
        if (obj == xVar) {
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
        this.f5666f = xVar;
        if (obj != i.f5699l) {
            return obj;
        }
        Throwable thQ = this.f5668h.q();
        int i2 = na.t.f6928a;
        throw thQ;
    }
}
