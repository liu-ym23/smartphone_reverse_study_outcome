package ob;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class n0 extends o {

    /* renamed from: e, reason: collision with root package name */
    public static final z f8018e;

    /* renamed from: b, reason: collision with root package name */
    public final z f8019b;

    /* renamed from: c, reason: collision with root package name */
    public final o f8020c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f8021d;

    static {
        String str = z.f8042g;
        f8018e = h4.n.l("/", false);
    }

    public n0(z zVar, o oVar, LinkedHashMap linkedHashMap) {
        this.f8019b = zVar;
        this.f8020c = oVar;
        this.f8021d = linkedHashMap;
    }

    @Override // ob.o
    public final void a(z zVar, z zVar2) throws IOException {
        q7.k.e(zVar2, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // ob.o
    public final void b(z zVar) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // ob.o
    public final void c(z zVar) throws IOException {
        throw new IOException("zip file systems are read-only");
    }

    @Override // ob.o
    public final n e(z zVar) throws Throwable {
        n nVarF;
        Throwable th;
        q7.k.e(zVar, "path");
        z zVar2 = f8018e;
        zVar2.getClass();
        pb.g gVar = (pb.g) this.f8021d.get(pb.c.b(zVar2, zVar, true));
        Throwable th2 = null;
        if (gVar == null) {
            return null;
        }
        long j2 = gVar.f8598g;
        boolean z4 = gVar.f8593b;
        n nVar = new n(!z4, z4, z4 ? null : Long.valueOf(gVar.f8595d), null, gVar.f8597f, null);
        if (j2 == -1) {
            return nVar;
        }
        u uVarF = this.f8020c.f(this.f8019b);
        try {
            e0 e0VarC = b.c(uVarF.b(j2));
            try {
                nVarF = pb.b.f(e0VarC, nVar);
                q7.k.b(nVarF);
                try {
                    e0VarC.close();
                    th = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                try {
                    e0VarC.close();
                } catch (Throwable th5) {
                    ib.k.e(th4, th5);
                }
                th = th4;
                nVarF = null;
            }
        } catch (Throwable th6) {
            if (uVarF != null) {
                try {
                    uVarF.close();
                } catch (Throwable th7) {
                    ib.k.e(th6, th7);
                }
            }
            nVarF = null;
            th2 = th6;
        }
        if (th != null) {
            throw th;
        }
        q7.k.b(nVarF);
        try {
            uVarF.close();
        } catch (Throwable th8) {
            th2 = th8;
        }
        if (th2 != null) {
            throw th2;
        }
        q7.k.b(nVarF);
        return nVarF;
    }

    @Override // ob.o
    public final u f(z zVar) {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // ob.o
    public final u g(z zVar) throws IOException {
        q7.k.e(zVar, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // ob.o
    public final k0 h(z zVar) throws Throwable {
        Throwable th;
        e0 e0VarC;
        q7.k.e(zVar, "file");
        z zVar2 = f8018e;
        zVar2.getClass();
        pb.g gVar = (pb.g) this.f8021d.get(pb.c.b(zVar2, zVar, true));
        if (gVar == null) {
            throw new FileNotFoundException("no such file: " + zVar);
        }
        long j2 = gVar.f8595d;
        u uVarF = this.f8020c.f(this.f8019b);
        try {
            e0VarC = b.c(uVarF.b(gVar.f8598g));
            try {
                uVarF.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (uVarF != null) {
                try {
                    uVarF.close();
                } catch (Throwable th4) {
                    ib.k.e(th3, th4);
                }
            }
            th = th3;
            e0VarC = null;
        }
        if (th != null) {
            throw th;
        }
        q7.k.b(e0VarC);
        pb.b.f(e0VarC, null);
        if (gVar.f8596e == 0) {
            return new pb.e(e0VarC, j2, true);
        }
        return new pb.e(new t(b.c(new pb.e(e0VarC, gVar.f8594c, true)), new Inflater(true)), j2, false);
    }
}
