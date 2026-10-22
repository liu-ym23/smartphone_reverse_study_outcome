package od;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 extends o {

    /* renamed from: e, reason: collision with root package name */
    public static final z f9463e;

    /* renamed from: b, reason: collision with root package name */
    public z f9464b;

    /* renamed from: c, reason: collision with root package name */
    public o f9465c;

    /* renamed from: d, reason: collision with root package name */
    public LinkedHashMap f9466d;

    static {
        String str = z.f9497f;
        f9463e = f8.b.n("/");
    }

    @Override // od.o
    public final g0 a(z zVar) throws IOException {
        zVar.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // od.o
    public final void b(z zVar, z zVar2) throws IOException {
        zVar.getClass();
        zVar2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // od.o
    public final void c(z zVar) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // od.o
    public final void d(z zVar) throws IOException {
        zVar.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // od.o
    public final List g(z zVar) throws IOException {
        zVar.getClass();
        z zVar2 = f9463e;
        zVar2.getClass();
        pd.g gVar = (pd.g) this.f9466d.get(pd.c.b(zVar2, zVar, true));
        if (gVar != null) {
            return kb.l.L0(gVar.f10028q);
        }
        f.k(zVar, "not a directory: ");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0124  */
    @Override // od.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final od.n i(od.z r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: od.l0.i(od.z):od.n");
    }

    @Override // od.o
    public final u j(z zVar) {
        zVar.getClass();
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // od.o
    public final g0 k(z zVar) throws IOException {
        zVar.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // od.o
    public final i0 l(z zVar) throws Throwable {
        c0 c0Var;
        Throwable th;
        zVar.getClass();
        z zVar2 = f9463e;
        zVar2.getClass();
        pd.g gVar = (pd.g) this.f9466d.get(pd.c.b(zVar2, zVar, true));
        if (gVar == null) {
            f.d(zVar, "no such file: ");
            return null;
        }
        long j10 = gVar.f10018f;
        u uVarJ = this.f9465c.j(this.f9464b);
        try {
            c0Var = new c0(uVarJ.d(gVar.f10020h));
            try {
                uVarJ.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (uVarJ != null) {
                try {
                    uVarJ.close();
                } catch (Throwable th4) {
                    com.stepos.statsrpk.h.b(th3, th4);
                }
            }
            c0Var = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        c0Var.getClass();
        pd.b.f(c0Var, null);
        if (gVar.f10019g == 0) {
            return new pd.e(c0Var, j10, true);
        }
        return new pd.e(new t(new c0(new pd.e(c0Var, gVar.f10017e, true)), new Inflater(true)), j10, false);
    }
}
