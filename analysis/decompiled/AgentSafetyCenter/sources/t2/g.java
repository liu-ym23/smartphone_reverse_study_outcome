package t2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends a {
    @Override // t2.a
    public final boolean e(i iVar, e eVar, e eVar2) {
        synchronized (iVar) {
            try {
                if (iVar.f13157f != eVar) {
                    return false;
                }
                iVar.f13157f = eVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t2.a
    public final boolean f(i iVar, Object obj, Object obj2) {
        synchronized (iVar) {
            try {
                if (iVar.f13156c != obj) {
                    return false;
                }
                iVar.f13156c = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t2.a
    public final boolean g(i iVar, h hVar, h hVar2) {
        synchronized (iVar) {
            try {
                if (iVar.f13158g != hVar) {
                    return false;
                }
                iVar.f13158g = hVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t2.a
    public final void m(h hVar, h hVar2) {
        hVar.f13152b = hVar2;
    }

    @Override // t2.a
    public final void n(h hVar, Thread thread) {
        hVar.f13151a = thread;
    }
}
