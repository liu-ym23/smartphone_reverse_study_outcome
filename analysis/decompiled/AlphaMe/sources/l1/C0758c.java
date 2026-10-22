package l1;

/* renamed from: l1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0758c {

    /* renamed from: a, reason: collision with root package name */
    public final h f13454a = new h();

    public final void a(Object obj) {
        h hVar = this.f13454a;
        synchronized (hVar.f13463a) {
            hVar.a();
            hVar.f13465c = true;
            hVar.f13466d = obj;
        }
        hVar.f13464b.g(hVar);
    }

    public final boolean b(Exception exc) {
        h hVar = this.f13454a;
        hVar.getClass();
        com.stepos.statsrpk.c.m(exc, "Exception must not be null");
        synchronized (hVar.f13463a) {
            try {
                if (hVar.f13465c) {
                    return false;
                }
                hVar.f13465c = true;
                hVar.f13467e = exc;
                hVar.f13464b.g(hVar);
                return true;
            } finally {
            }
        }
    }

    public final boolean c(Object obj) {
        h hVar = this.f13454a;
        synchronized (hVar.f13463a) {
            try {
                if (hVar.f13465c) {
                    return false;
                }
                hVar.f13465c = true;
                hVar.f13466d = obj;
                hVar.f13464b.g(hVar);
                return true;
            } finally {
            }
        }
    }
}
