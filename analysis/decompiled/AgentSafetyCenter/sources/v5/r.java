package v5;

import java.io.File;
import od.b0;
import od.c0;
import od.v;
import od.z;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends p {

    /* renamed from: c, reason: collision with root package name */
    public final i1 f14807c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14808f;

    /* renamed from: g, reason: collision with root package name */
    public od.k f14809g;

    /* renamed from: h, reason: collision with root package name */
    public xb.a f14810h;
    public z i;

    public r(od.k kVar, xb.a aVar, i1 i1Var) {
        this.f14807c = i1Var;
        this.f14809g = kVar;
        this.f14810h = aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            this.f14808f = true;
            od.k kVar = this.f14809g;
            if (kVar != null) {
                i6.d.a(kVar);
            }
            z zVar = this.i;
            if (zVar != null) {
                v vVar = od.o.f9478a;
                vVar.getClass();
                vVar.d(zVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // v5.p
    public final synchronized z d() {
        Throwable th;
        if (this.f14808f) {
            throw new IllegalStateException("closed");
        }
        z zVar = this.i;
        if (zVar != null) {
            return zVar;
        }
        xb.a aVar = this.f14810h;
        aVar.getClass();
        File file = (File) aVar.invoke();
        if (!file.isDirectory()) {
            throw new IllegalStateException("cacheDirectory must be a directory.");
        }
        String str = z.f9497f;
        z zVarO = f8.b.o(File.createTempFile("tmp", null, file));
        b0 b0VarJ = ac.a.j(od.o.f9478a.k(zVarO));
        try {
            od.k kVar = this.f14809g;
            kVar.getClass();
            while (kVar.l(b0VarJ.f9422f, 8192L) != -1) {
                b0VarJ.d();
            }
            try {
                b0VarJ.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            try {
                b0VarJ.close();
            } catch (Throwable th4) {
                com.stepos.statsrpk.h.b(th3, th4);
            }
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        this.f14809g = null;
        this.i = zVarO;
        this.f14810h = null;
        return zVarO;
    }

    @Override // v5.p
    public final i1 e() {
        return this.f14807c;
    }

    @Override // v5.p
    public final synchronized od.k g() {
        if (this.f14808f) {
            throw new IllegalStateException("closed");
        }
        od.k kVar = this.f14809g;
        if (kVar != null) {
            return kVar;
        }
        v vVar = od.o.f9478a;
        z zVar = this.i;
        zVar.getClass();
        c0 c0Var = new c0(vVar.l(zVar));
        this.f14809g = c0Var;
        return c0Var;
    }
}
