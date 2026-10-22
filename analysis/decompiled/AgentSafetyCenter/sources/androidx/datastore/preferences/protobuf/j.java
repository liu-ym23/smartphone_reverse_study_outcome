package androidx.datastore.preferences.protobuf;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public int f1134a;

    /* renamed from: b, reason: collision with root package name */
    public int f1135b;

    /* renamed from: c, reason: collision with root package name */
    public int f1136c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1137d;

    public static j b(i iVar) {
        j jVar = iVar.f1130b;
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.f1136c = 0;
        Charset charset = x.f1218a;
        jVar2.f1137d = iVar;
        iVar.f1130b = jVar2;
        VarHandle.storeStoreFence();
        return jVar2;
    }

    public void A(int i) throws y {
        if ((this.f1134a & 7) != i) {
            throw z.b();
        }
    }

    public boolean B() {
        int i;
        i iVar = (i) this.f1137d;
        if (iVar.c() || (i = this.f1134a) == this.f1135b) {
            return false;
        }
        return iVar.x(i);
    }

    public void a(o4.f fVar) {
        Object[] objArr = (Object[]) this.f1137d;
        int i = this.f1135b;
        objArr[i] = fVar;
        int i3 = this.f1136c & (i + 1);
        this.f1135b = i3;
        int i10 = this.f1134a;
        if (i3 == i10) {
            int length = objArr.length;
            int i11 = length - i10;
            int i12 = length << 1;
            if (i12 < 0) {
                od.f.o("Max array capacity exceeded");
                return;
            }
            Object[] objArr2 = new Object[i12];
            kb.k.i0(objArr, objArr2, 0, i10, length);
            kb.k.i0((Object[]) this.f1137d, objArr2, i11, 0, this.f1134a);
            this.f1137d = objArr2;
            this.f1134a = 0;
            this.f1135b = length;
            this.f1136c = i12 - 1;
        }
    }

    public int c() {
        int i = this.f1136c;
        if (i != 0) {
            this.f1134a = i;
            this.f1136c = 0;
        } else {
            this.f1134a = ((i) this.f1137d).u();
        }
        int i3 = this.f1134a;
        return (i3 == 0 || i3 == this.f1135b) ? Reader.READ_DONE : i3 >>> 3;
    }

    public int d(int i) {
        return ((l0.k0) this.f1137d).f7690e[this.f1135b + i];
    }

    public Object e(int i) {
        return ((l0.k0) this.f1137d).f7692g[this.f1136c + i];
    }

    public void f(Object obj, w0 w0Var, n nVar) {
        int i = this.f1135b;
        this.f1135b = ((this.f1134a >>> 3) << 3) | 4;
        try {
            w0Var.e(obj, this, nVar);
            if (this.f1134a == this.f1135b) {
            } else {
                throw new z("Failed to parse the message.");
            }
        } finally {
            this.f1135b = i;
        }
    }

    public void g(Object obj, w0 w0Var, n nVar) throws z {
        i iVar = (i) this.f1137d;
        int iV = iVar.v();
        if (iVar.f1129a >= 100) {
            throw new z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iE = iVar.e(iV);
        iVar.f1129a++;
        w0Var.e(obj, this, nVar);
        iVar.a(0);
        iVar.f1129a--;
        iVar.d(iE);
    }

    public void h(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 0) {
            do {
                ((u0) wVar).add(Boolean.valueOf(iVar.f()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = iVar.b() + iVar.v();
        do {
            ((u0) wVar).add(Boolean.valueOf(iVar.f()));
        } while (iVar.b() < iB);
        z(iB);
    }

    public f i() throws y {
        A(2);
        return ((i) this.f1137d).g();
    }

    public void j(w wVar) throws y {
        int iU;
        i iVar = (i) this.f1137d;
        if ((this.f1134a & 7) != 2) {
            throw z.b();
        }
        do {
            ((u0) wVar).add(i());
            if (iVar.c()) {
                return;
            } else {
                iU = iVar.u();
            }
        } while (iU == this.f1134a);
        this.f1136c = iU;
    }

    public void k(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 1) {
            do {
                ((u0) wVar).add(Double.valueOf(iVar.h()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iV = iVar.v();
        if ((iV & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iB = iVar.b() + iV;
        do {
            ((u0) wVar).add(Double.valueOf(iVar.h()));
        } while (iVar.b() < iB);
    }

    public void l(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 0) {
            do {
                ((u0) wVar).add(Integer.valueOf(iVar.i()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = iVar.b() + iVar.v();
        do {
            ((u0) wVar).add(Integer.valueOf(iVar.i()));
        } while (iVar.b() < iB);
        z(iB);
    }

    public Object m(r1 r1Var, Class cls, n nVar) throws z {
        i iVar = (i) this.f1137d;
        switch (r1Var.ordinal()) {
            case 0:
                A(1);
                return Double.valueOf(iVar.h());
            case 1:
                A(5);
                return Float.valueOf(iVar.l());
            case 2:
                A(0);
                return Long.valueOf(iVar.n());
            case 3:
                A(0);
                return Long.valueOf(iVar.w());
            case 4:
                A(0);
                return Integer.valueOf(iVar.m());
            case 5:
                A(1);
                return Long.valueOf(iVar.k());
            case 6:
                A(5);
                return Integer.valueOf(iVar.j());
            case 7:
                A(0);
                return Boolean.valueOf(iVar.f());
            case 8:
                A(2);
                return iVar.t();
            case 9:
            default:
                g5.f.s("unsupported field type.");
                return null;
            case 10:
                A(2);
                w0 w0VarA = t0.f1207c.a(cls);
                v vVarNewInstance = w0VarA.newInstance();
                g(vVarNewInstance, w0VarA, nVar);
                w0VarA.makeImmutable(vVarNewInstance);
                return vVarNewInstance;
            case 11:
                return i();
            case 12:
                A(0);
                return Integer.valueOf(iVar.v());
            case 13:
                A(0);
                return Integer.valueOf(iVar.i());
            case 14:
                A(5);
                return Integer.valueOf(iVar.o());
            case 15:
                A(1);
                return Long.valueOf(iVar.p());
            case 16:
                A(0);
                return Integer.valueOf(iVar.q());
            case 17:
                A(0);
                return Long.valueOf(iVar.r());
        }
    }

    public void n(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 2) {
            int iV = iVar.v();
            if ((iV & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iB = iVar.b() + iV;
            do {
                ((u0) wVar).add(Integer.valueOf(iVar.j()));
            } while (iVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw z.b();
        }
        do {
            ((u0) wVar).add(Integer.valueOf(iVar.j()));
            if (iVar.c()) {
                return;
            } else {
                iU = iVar.u();
            }
        } while (iU == this.f1134a);
        this.f1136c = iU;
    }

    public void o(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 1) {
            do {
                ((u0) wVar).add(Long.valueOf(iVar.k()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iV = iVar.v();
        if ((iV & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iB = iVar.b() + iV;
        do {
            ((u0) wVar).add(Long.valueOf(iVar.k()));
        } while (iVar.b() < iB);
    }

    public void p(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 2) {
            int iV = iVar.v();
            if ((iV & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iB = iVar.b() + iV;
            do {
                ((u0) wVar).add(Float.valueOf(iVar.l()));
            } while (iVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw z.b();
        }
        do {
            ((u0) wVar).add(Float.valueOf(iVar.l()));
            if (iVar.c()) {
                return;
            } else {
                iU = iVar.u();
            }
        } while (iU == this.f1134a);
        this.f1136c = iU;
    }

    public void q(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 0) {
            do {
                ((u0) wVar).add(Integer.valueOf(iVar.m()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = iVar.b() + iVar.v();
        do {
            ((u0) wVar).add(Integer.valueOf(iVar.m()));
        } while (iVar.b() < iB);
        z(iB);
    }

    public void r(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 0) {
            do {
                ((u0) wVar).add(Long.valueOf(iVar.n()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = iVar.b() + iVar.v();
        do {
            ((u0) wVar).add(Long.valueOf(iVar.n()));
        } while (iVar.b() < iB);
        z(iB);
    }

    public void s(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 2) {
            int iV = iVar.v();
            if ((iV & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iB = iVar.b() + iV;
            do {
                ((u0) wVar).add(Integer.valueOf(iVar.o()));
            } while (iVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw z.b();
        }
        do {
            ((u0) wVar).add(Integer.valueOf(iVar.o()));
            if (iVar.c()) {
                return;
            } else {
                iU = iVar.u();
            }
        } while (iU == this.f1134a);
        this.f1136c = iU;
    }

    public void t(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 1) {
            do {
                ((u0) wVar).add(Long.valueOf(iVar.p()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iV = iVar.v();
        if ((iV & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iB = iVar.b() + iV;
        do {
            ((u0) wVar).add(Long.valueOf(iVar.p()));
        } while (iVar.b() < iB);
    }

    public void u(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 0) {
            do {
                ((u0) wVar).add(Integer.valueOf(iVar.q()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = iVar.b() + iVar.v();
        do {
            ((u0) wVar).add(Integer.valueOf(iVar.q()));
        } while (iVar.b() < iB);
        z(iB);
    }

    public void v(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 0) {
            do {
                ((u0) wVar).add(Long.valueOf(iVar.r()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = iVar.b() + iVar.v();
        do {
            ((u0) wVar).add(Long.valueOf(iVar.r()));
        } while (iVar.b() < iB);
        z(iB);
    }

    public void w(w wVar, boolean z10) throws y {
        String strS;
        int iU;
        i iVar = (i) this.f1137d;
        if ((this.f1134a & 7) != 2) {
            throw z.b();
        }
        do {
            if (z10) {
                A(2);
                strS = iVar.t();
            } else {
                A(2);
                strS = iVar.s();
            }
            ((u0) wVar).add(strS);
            if (iVar.c()) {
                return;
            } else {
                iU = iVar.u();
            }
        } while (iU == this.f1134a);
        this.f1136c = iU;
    }

    public void x(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 0) {
            do {
                ((u0) wVar).add(Integer.valueOf(iVar.v()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = iVar.b() + iVar.v();
        do {
            ((u0) wVar).add(Integer.valueOf(iVar.v()));
        } while (iVar.b() < iB);
        z(iB);
    }

    public void y(w wVar) throws z {
        int iU;
        i iVar = (i) this.f1137d;
        int i = this.f1134a & 7;
        if (i == 0) {
            do {
                ((u0) wVar).add(Long.valueOf(iVar.w()));
                if (iVar.c()) {
                    return;
                } else {
                    iU = iVar.u();
                }
            } while (iU == this.f1134a);
            this.f1136c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = iVar.b() + iVar.v();
        do {
            ((u0) wVar).add(Long.valueOf(iVar.w()));
        } while (iVar.b() < iB);
        z(iB);
    }

    public void z(int i) throws z {
        if (((i) this.f1137d).b() != i) {
            throw z.e();
        }
    }
}
