package t3;

import a4.v;
import com.google.crypto.tink.shaded.protobuf.b0;
import f4.c2;
import f4.h1;
import f4.i1;
import f4.j1;
import f4.m1;
import f4.o1;
import f4.p1;
import f4.q1;
import f4.r1;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f9709c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f9710d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f9711e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9712a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9713b;

    static {
        int i2 = 0;
        f9709c = new f(i2, "ENABLED");
        f9710d = new f(i2, "DISABLED");
        f9711e = new f(i2, "DESTROYED");
    }

    public /* synthetic */ f(int i2, Object obj) {
        this.f9712a = i2;
        this.f9713b = obj;
    }

    public synchronized void a(m1 m1Var) {
        q1 q1VarB;
        synchronized (this) {
            q1VarB = b(n.d(m1Var), m1Var.z());
        }
        o1 o1Var = (o1) this.f9713b;
        o1Var.d();
        r1.w((r1) o1Var.f2287g, q1VarB);
    }

    public synchronized q1 b(j1 j1Var, c2 c2Var) {
        int iA;
        synchronized (this) {
            iA = v.a();
            while (d(iA)) {
                iA = v.a();
            }
        }
        return (q1) p1VarE.a();
        if (c2Var == c2.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        p1 p1VarE = q1.E();
        p1VarE.d();
        q1.v((q1) p1VarE.f2287g, j1Var);
        p1VarE.d();
        q1.y((q1) p1VarE.f2287g, iA);
        p1VarE.d();
        q1.x((q1) p1VarE.f2287g);
        p1VarE.d();
        q1.w((q1) p1VarE.f2287g, c2Var);
        return (q1) p1VarE.a();
    }

    public synchronized i5.l c() {
        return i5.l.w((r1) ((o1) this.f9713b).a());
    }

    public synchronized boolean d(int i2) {
        Iterator it = Collections.unmodifiableList(((r1) ((o1) this.f9713b).f2287g).z()).iterator();
        while (it.hasNext()) {
            if (((q1) it.next()).A() == i2) {
                return true;
            }
        }
        return false;
    }

    public j1 e(com.google.crypto.tink.shaded.protobuf.h hVar) throws GeneralSecurityException {
        a4.e eVar = (a4.e) this.f9713b;
        try {
            a4.d dVarG = eVar.g();
            com.google.crypto.tink.shaded.protobuf.a aVarC0 = dVarG.C0(hVar);
            dVarG.D0(aVarC0);
            com.google.crypto.tink.shaded.protobuf.a aVarJ0 = dVarG.j0(aVarC0);
            h1 h1VarC = j1.C();
            String strE = eVar.e();
            h1VarC.d();
            j1.v((j1) h1VarC.f2287g, strE);
            try {
                int iA = ((com.google.crypto.tink.shaded.protobuf.v) aVarJ0).a(null);
                byte[] bArr = new byte[iA];
                com.google.crypto.tink.shaded.protobuf.k kVar = new com.google.crypto.tink.shaded.protobuf.k(iA, bArr);
                aVarJ0.e(kVar);
                if (kVar.f2236c - kVar.f2237d != 0) {
                    throw new IllegalStateException("Did not write as much data as expected.");
                }
                com.google.crypto.tink.shaded.protobuf.g gVar = new com.google.crypto.tink.shaded.protobuf.g(bArr);
                h1VarC.d();
                j1.w((j1) h1VarC.f2287g, gVar);
                i1 i1VarH = eVar.h();
                h1VarC.d();
                j1.x((j1) h1VarC.f2287g, i1VarH);
                return (j1) h1VarC.a();
            } catch (IOException e10) {
                throw new RuntimeException(aVarJ0.b("ByteString"), e10);
            }
        } catch (b0 e11) {
            throw new GeneralSecurityException("Unexpected proto", e11);
        }
    }

    public String toString() {
        switch (this.f9712a) {
            case 0:
                return (String) this.f9713b;
            default:
                return super.toString();
        }
    }

    public f(a4.e eVar, Class cls) {
        this.f9712a = 2;
        if (!((Map) eVar.f176d).keySet().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(a1.a.k("Given internalKeyMananger ", eVar.toString(), " does not support primitive class ", cls.getName()));
        }
        this.f9713b = eVar;
    }
}
