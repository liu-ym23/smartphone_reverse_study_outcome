package D0;

import t0.J;

/* loaded from: classes.dex */
public final class f extends J {
    @Override // t0.J
    public final void F(g gVar, g gVar2) {
        gVar.f385b = gVar2;
    }

    @Override // t0.J
    public final void G(g gVar, Thread thread) {
        gVar.f384a = thread;
    }

    @Override // t0.J
    public final boolean g(h hVar, c cVar, c cVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f391b != cVar) {
                    return false;
                }
                hVar.f391b = cVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t0.J
    public final boolean h(h hVar, Object obj, Object obj2) {
        synchronized (hVar) {
            try {
                if (hVar.f390a != obj) {
                    return false;
                }
                hVar.f390a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t0.J
    public final boolean i(h hVar, g gVar, g gVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f392c != gVar) {
                    return false;
                }
                hVar.f392c = gVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
