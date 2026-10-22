package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a extends e1 implements nb.c, t {

    /* renamed from: g, reason: collision with root package name */
    public final nb.g f7414g;

    public a(nb.g gVar, boolean z10) {
        super(z10);
        K((x0) gVar.get(w0.f7498c));
        this.f7414g = gVar.plus(this);
    }

    @Override // kc.e1
    public final void J(androidx.fragment.app.d dVar) {
        w.p(this.f7414g, dVar);
    }

    @Override // kc.e1
    public final void T(Object obj) {
        if (!(obj instanceof n)) {
            b0(obj);
        } else {
            n nVar = (n) obj;
            a0(nVar.f7461a, n.f7460b.get(nVar) != 0);
        }
    }

    public final void c0(u uVar, a aVar, xb.p pVar) {
        Object objInvoke;
        int iOrdinal = uVar.ordinal();
        jb.v vVar = jb.v.f6774a;
        if (iOrdinal == 0) {
            try {
                pc.a.h(vVar, td.h.y(td.h.m(aVar, this, pVar)));
                return;
            } finally {
                resumeWith(id.c.l(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                pVar.getClass();
                td.h.y(td.h.m(aVar, this, pVar)).resumeWith(vVar);
                return;
            }
            if (iOrdinal != 3) {
                g5.f.a();
                return;
            }
            try {
                nb.g gVar = this.f7414g;
                Object objL = pc.a.l(gVar, null);
                try {
                    if (pVar instanceof pb.a) {
                        yb.x.c(2, pVar);
                        objInvoke = pVar.invoke(aVar, this);
                    } else {
                        objInvoke = td.h.Q(pVar, aVar, this);
                    }
                    pc.a.g(gVar, objL);
                    if (objInvoke != ob.a.f9351c) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th) {
                    pc.a.g(gVar, objL);
                    throw th;
                }
            } catch (Throwable th2) {
            }
        }
    }

    @Override // nb.c
    public final nb.g getContext() {
        return this.f7414g;
    }

    @Override // kc.t
    public final nb.g n() {
        return this.f7414g;
    }

    @Override // nb.c
    public final void resumeWith(Object obj) {
        Throwable thB = jb.i.b(obj);
        if (thB != null) {
            obj = new n(thB, false);
        }
        Object objP = P(obj);
        if (objP == w.f7493e) {
            return;
        }
        q(objP);
    }

    @Override // kc.e1
    public final String w() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public void b0(Object obj) {
    }

    public void a0(Throwable th, boolean z10) {
    }
}
