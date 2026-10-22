package g2;

/* loaded from: classes.dex */
public final class e extends ib.c {
    @Override // ib.c
    public final void H(f fVar, f fVar2) {
        fVar.f3788b = fVar2;
    }

    @Override // ib.c
    public final void I(f fVar, Thread thread) {
        fVar.f3787a = thread;
    }

    @Override // ib.c
    public final boolean k(g gVar, c cVar) {
        c cVar2 = c.f3779b;
        synchronized (gVar) {
            try {
                if (gVar.f3794g != cVar) {
                    return false;
                }
                gVar.f3794g = cVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ib.c
    public final boolean l(g gVar, Object obj, Object obj2) {
        synchronized (gVar) {
            try {
                if (gVar.f3793f != obj) {
                    return false;
                }
                gVar.f3793f = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ib.c
    public final boolean m(g gVar, f fVar, f fVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f3795h != fVar) {
                    return false;
                }
                gVar.f3795h = fVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
