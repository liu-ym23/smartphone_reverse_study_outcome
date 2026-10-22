package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f7775a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7776b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[][] f7777c = new byte[11][];

    public v(int i4, t1 t1Var) {
        this.f7775a = t1Var;
        this.f7776b = i4;
    }

    public final d a() throws IOException {
        int i4 = this.f7775a.read();
        if (i4 == -1) {
            return null;
        }
        InputStream inputStream = this.f7775a;
        if (inputStream instanceof q1) {
            q1 q1Var = (q1) inputStream;
            q1Var.f7760f = false;
            q1Var.c();
        }
        int iB = i.b(i4, this.f7775a);
        boolean z4 = (i4 & 32) != 0;
        int iA = i.a(this.f7776b, this.f7775a);
        if (iA < 0) {
            if (!z4) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            v vVar = new v(this.f7776b, new q1(this.f7776b, this.f7775a));
            if ((i4 & 64) != 0) {
                return new z(iB, vVar);
            }
            if ((i4 & 128) != 0) {
                return new i0(true, iB, vVar);
            }
            if (iB == 4) {
                return new c0(vVar);
            }
            if (iB == 8) {
                return new o0(vVar);
            }
            if (iB == 16) {
                return new e0(vVar);
            }
            if (iB == 17) {
                return new g0(vVar);
            }
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("unknown BER object encountered: 0x");
            sbA.append(Integer.toHexString(iB));
            throw new g(sbA.toString());
        }
        o1 o1Var = new o1(iA, this.f7775a);
        if ((i4 & 64) != 0) {
            return new k0(z4, iB, o1Var.c());
        }
        if ((i4 & 128) != 0) {
            return new i0(z4, iB, new v(u1.a(o1Var), o1Var));
        }
        if (!z4) {
            if (iB == 4) {
                return new w0(o1Var);
            }
            try {
                return i.a(iB, o1Var, this.f7777c);
            } catch (IllegalArgumentException e4) {
                throw new g("corrupted stream detected", e4);
            }
        }
        if (iB == 4) {
            return new c0(new v(u1.a(o1Var), o1Var));
        }
        if (iB == 8) {
            return new o0(new v(u1.a(o1Var), o1Var));
        }
        if (iB == 16) {
            return new a1(new v(u1.a(o1Var), o1Var));
        }
        if (iB == 17) {
            return new c1(new v(u1.a(o1Var), o1Var));
        }
        throw new IOException(B0.g.j("unknown tag ", iB, " encountered"));
    }

    public final e b() throws IOException {
        e eVar = new e();
        while (true) {
            d dVarA = a();
            if (dVarA == null) {
                return eVar;
            }
            eVar.f7709a.addElement(dVarA instanceof p1 ? ((p1) dVarA).a() : dVarA.c());
        }
    }

    public final w a(boolean z4, int i4) throws IOException {
        if (!z4) {
            return new e1(false, i4, new v0(((o1) this.f7775a).c()));
        }
        e eVarB = b();
        if (this.f7775a instanceof q1) {
            if (eVarB.f7709a.size() == 1) {
                return new h0(true, i4, eVarB.a(0));
            }
            d0 d0Var = a0.f7692a;
            if (eVarB.f7709a.size() >= 1) {
                d0Var = new d0(eVarB);
            }
            return new h0(false, i4, d0Var);
        }
        if (eVarB.f7709a.size() == 1) {
            return new e1(true, i4, eVarB.a(0));
        }
        d l1Var = p0.f7751a;
        if (eVarB.f7709a.size() >= 1) {
            l1Var = new l1(eVarB);
        }
        return new e1(false, i4, l1Var);
    }
}
