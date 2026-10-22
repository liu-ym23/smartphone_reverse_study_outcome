package mc;

import kc.t1;
import kc.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements t1 {

    /* renamed from: c, reason: collision with root package name */
    public Object f8554c;

    /* renamed from: f, reason: collision with root package name */
    public kc.g f8555f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ e f8556g;

    @Override // kc.t1
    public final void a(pc.r rVar, int i) {
        kc.g gVar = this.f8555f;
        if (gVar != null) {
            gVar.a(rVar, i);
        }
    }

    public final Object b(pb.c cVar) {
        m mVarP;
        e eVar = this.f8556g;
        Object obj = this.f8554c;
        boolean z10 = true;
        if (obj == g.f8587p || obj == g.f8583l) {
            m mVar = (m) e.f8567k.get(eVar);
            while (true) {
                if (eVar.w()) {
                    this.f8554c = g.f8583l;
                    Throwable thQ = eVar.q();
                    if (thQ != null) {
                        int i = pc.s.f9983a;
                        throw thQ;
                    }
                    z10 = false;
                } else {
                    long andIncrement = e.f8564g.getAndIncrement(eVar);
                    long j10 = g.f8574b;
                    long j11 = andIncrement / j10;
                    int i3 = (int) (andIncrement % j10);
                    if (mVar.f9982c != j11) {
                        m mVarP2 = eVar.p(j11, mVar);
                        if (mVarP2 == null) {
                            continue;
                        } else {
                            mVar = mVarP2;
                        }
                    }
                    Object objH = eVar.H(mVar, i3, andIncrement, null);
                    pc.t tVar = g.f8584m;
                    if (objH == tVar) {
                        od.f.e("unreachable");
                        return null;
                    }
                    pc.t tVar2 = g.f8586o;
                    if (objH == tVar2) {
                        if (andIncrement < eVar.t()) {
                            mVar.a();
                        }
                    } else {
                        if (objH == g.f8585n) {
                            kc.g gVarO = w.o(td.h.y(cVar));
                            try {
                                this.f8555f = gVarO;
                                b bVar = this;
                                Object objH2 = eVar.H(mVar, i3, andIncrement, bVar);
                                if (objH2 == tVar) {
                                    bVar.a(mVar, i3);
                                } else {
                                    if (objH2 == tVar2) {
                                        if (andIncrement < eVar.t()) {
                                            mVar.a();
                                        }
                                        m mVar2 = (m) e.f8567k.get(eVar);
                                        while (true) {
                                            if (eVar.w()) {
                                                kc.g gVar = bVar.f8555f;
                                                gVar.getClass();
                                                bVar.f8555f = null;
                                                bVar.f8554c = g.f8583l;
                                                Throwable thQ2 = eVar.q();
                                                if (thQ2 == null) {
                                                    gVar.resumeWith(Boolean.FALSE);
                                                } else {
                                                    gVar.resumeWith(id.c.l(thQ2));
                                                }
                                            } else {
                                                long andIncrement2 = e.f8564g.getAndIncrement(eVar);
                                                long j12 = g.f8574b;
                                                long j13 = andIncrement2 / j12;
                                                int i10 = (int) (andIncrement2 % j12);
                                                if (mVar2.f9982c != j13) {
                                                    mVarP = eVar.p(j13, mVar2);
                                                    if (mVarP == null) {
                                                    }
                                                } else {
                                                    mVarP = mVar2;
                                                }
                                                Object objH3 = eVar.H(mVarP, i10, andIncrement2, bVar);
                                                e eVar2 = eVar;
                                                b bVar2 = bVar;
                                                if (objH3 == g.f8584m) {
                                                    bVar2.a(mVarP, i10);
                                                    break;
                                                }
                                                if (objH3 == g.f8586o) {
                                                    if (andIncrement2 < eVar2.t()) {
                                                        mVarP.a();
                                                    }
                                                    bVar = bVar2;
                                                    mVar2 = mVarP;
                                                    eVar = eVar2;
                                                } else {
                                                    if (objH3 == g.f8585n) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    mVarP.a();
                                                    bVar2.f8554c = objH3;
                                                    bVar2.f8555f = null;
                                                }
                                            }
                                        }
                                    } else {
                                        mVar.a();
                                        bVar.f8554c = objH2;
                                        bVar.f8555f = null;
                                    }
                                    gVarO.l(Boolean.TRUE, null);
                                }
                                Object objR = gVarO.r();
                                ob.a aVar = ob.a.f9351c;
                                return objR;
                            } catch (Throwable th) {
                                gVarO.z();
                                throw th;
                            }
                        }
                        mVar.a();
                        this.f8554c = objH;
                    }
                }
            }
        }
        return Boolean.valueOf(z10);
    }

    public final Object c() {
        Object obj = this.f8554c;
        pc.t tVar = g.f8587p;
        if (obj == tVar) {
            od.f.e("`hasNext()` has not been invoked");
            return null;
        }
        this.f8554c = tVar;
        if (obj != g.f8583l) {
            return obj;
        }
        Throwable thR = this.f8556g.r();
        int i = pc.s.f9983a;
        throw thR;
    }
}
