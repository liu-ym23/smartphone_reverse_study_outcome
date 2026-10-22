package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.List;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f500a;

    /* renamed from: b, reason: collision with root package name */
    public int f501b;

    /* renamed from: c, reason: collision with root package name */
    public int f502c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f503e;

    public j(a2.e eVar) {
        this.f500a = 0;
        this.d = 0;
        Charset charset = x.f579a;
        this.f503e = eVar;
        eVar.f86b = this;
    }

    public static void R(int i8) throws com.google.crypto.tink.shaded.protobuf.c0 {
        if ((i8 & 3) != 0) {
            throw com.google.crypto.tink.shaded.protobuf.c0.f();
        }
    }

    public static void S(int i8) throws com.google.crypto.tink.shaded.protobuf.c0 {
        if ((i8 & 7) != 0) {
            throw com.google.crypto.tink.shaded.protobuf.c0.f();
        }
    }

    public void A(w wVar) throws z {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 2) {
            int iD = eVar.D();
            if ((iD & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iF = eVar.f() + iD;
            do {
                ((s0) wVar).add(Integer.valueOf(eVar.w()));
            } while (eVar.f() < iF);
            return;
        }
        if (i8 != 5) {
            throw z.b();
        }
        do {
            ((s0) wVar).add(Integer.valueOf(eVar.w()));
            if (eVar.g()) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == this.f501b);
        this.d = iC;
    }

    public void B(List list) throws com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.x)) {
            int i8 = this.f501b & 7;
            if (i8 == 2) {
                int iD = eVar.D();
                R(iD);
                int iF = eVar.f() + iD;
                do {
                    list.add(Integer.valueOf(eVar.w()));
                } while (eVar.f() < iF);
                return;
            }
            if (i8 != 5) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            do {
                list.add(Integer.valueOf(eVar.w()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        com.google.crypto.tink.shaded.protobuf.x xVar = (com.google.crypto.tink.shaded.protobuf.x) list;
        int i9 = this.f501b & 7;
        if (i9 == 2) {
            int iD2 = eVar.D();
            R(iD2);
            int iF2 = eVar.f() + iD2;
            do {
                xVar.g(eVar.w());
            } while (eVar.f() < iF2);
            return;
        }
        if (i9 != 5) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        do {
            xVar.g(eVar.w());
            if (eVar.g()) {
                return;
            } else {
                iC2 = eVar.C();
            }
        } while (iC2 == this.f501b);
        this.d = iC2;
    }

    public void C(w wVar) throws z {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 1) {
            do {
                ((s0) wVar).add(Long.valueOf(eVar.x()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iD = eVar.D();
        if ((iD & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iF = eVar.f() + iD;
        do {
            ((s0) wVar).add(Long.valueOf(eVar.x()));
        } while (eVar.f() < iF);
    }

    public void D(List list) throws com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.j0)) {
            int i8 = this.f501b & 7;
            if (i8 == 1) {
                do {
                    list.add(Long.valueOf(eVar.x()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iD = eVar.D();
            S(iD);
            int iF = eVar.f() + iD;
            do {
                list.add(Long.valueOf(eVar.x()));
            } while (eVar.f() < iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.j0 j0Var = (com.google.crypto.tink.shaded.protobuf.j0) list;
        int i9 = this.f501b & 7;
        if (i9 == 1) {
            do {
                j0Var.g(eVar.x());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iD2 = eVar.D();
        S(iD2);
        int iF2 = eVar.f() + iD2;
        do {
            j0Var.g(eVar.x());
        } while (eVar.f() < iF2);
    }

    public void E(w wVar) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 0) {
            do {
                ((s0) wVar).add(Integer.valueOf(eVar.y()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iF = eVar.f() + eVar.D();
        do {
            ((s0) wVar).add(Integer.valueOf(eVar.y()));
        } while (eVar.f() < iF);
        O(iF);
    }

    public void F(List list) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.x)) {
            int i8 = this.f501b & 7;
            if (i8 == 0) {
                do {
                    list.add(Integer.valueOf(eVar.y()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iF = eVar.f() + eVar.D();
            do {
                list.add(Integer.valueOf(eVar.y()));
            } while (eVar.f() < iF);
            O(iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.x xVar = (com.google.crypto.tink.shaded.protobuf.x) list;
        int i9 = this.f501b & 7;
        if (i9 == 0) {
            do {
                xVar.g(eVar.y());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iF2 = eVar.f() + eVar.D();
        do {
            xVar.g(eVar.y());
        } while (eVar.f() < iF2);
        O(iF2);
    }

    public void G(w wVar) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 0) {
            do {
                ((s0) wVar).add(Long.valueOf(eVar.z()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iF = eVar.f() + eVar.D();
        do {
            ((s0) wVar).add(Long.valueOf(eVar.z()));
        } while (eVar.f() < iF);
        O(iF);
    }

    public void H(List list) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.j0)) {
            int i8 = this.f501b & 7;
            if (i8 == 0) {
                do {
                    list.add(Long.valueOf(eVar.z()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iF = eVar.f() + eVar.D();
            do {
                list.add(Long.valueOf(eVar.z()));
            } while (eVar.f() < iF);
            O(iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.j0 j0Var = (com.google.crypto.tink.shaded.protobuf.j0) list;
        int i9 = this.f501b & 7;
        if (i9 == 0) {
            do {
                j0Var.g(eVar.z());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iF2 = eVar.f() + eVar.D();
        do {
            j0Var.g(eVar.z());
        } while (eVar.f() < iF2);
        O(iF2);
    }

    public void I(w wVar, boolean z) throws y, com.google.crypto.tink.shaded.protobuf.b0 {
        String strA;
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        if ((this.f501b & 7) != 2) {
            throw z.b();
        }
        do {
            if (z) {
                P(2);
                strA = eVar.B();
            } else {
                P(2);
                strA = eVar.A();
            }
            ((s0) wVar).add(strA);
            if (eVar.g()) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == this.f501b);
        this.d = iC;
    }

    public void J(List list, boolean z) throws y, com.google.crypto.tink.shaded.protobuf.b0 {
        String strA;
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if ((this.f501b & 7) != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        if ((list instanceof com.google.crypto.tink.shaded.protobuf.f0) && !z) {
            com.google.crypto.tink.shaded.protobuf.f0 f0Var = (com.google.crypto.tink.shaded.protobuf.f0) list;
            do {
                f0Var.b(i());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        do {
            if (z) {
                P(2);
                strA = eVar.B();
            } else {
                P(2);
                strA = eVar.A();
            }
            list.add(strA);
            if (eVar.g()) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == this.f501b);
        this.d = iC;
    }

    public void K(w wVar) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 0) {
            do {
                ((s0) wVar).add(Integer.valueOf(eVar.D()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iF = eVar.f() + eVar.D();
        do {
            ((s0) wVar).add(Integer.valueOf(eVar.D()));
        } while (eVar.f() < iF);
        O(iF);
    }

    public void L(List list) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.x)) {
            int i8 = this.f501b & 7;
            if (i8 == 0) {
                do {
                    list.add(Integer.valueOf(eVar.D()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iF = eVar.f() + eVar.D();
            do {
                list.add(Integer.valueOf(eVar.D()));
            } while (eVar.f() < iF);
            O(iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.x xVar = (com.google.crypto.tink.shaded.protobuf.x) list;
        int i9 = this.f501b & 7;
        if (i9 == 0) {
            do {
                xVar.g(eVar.D());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iF2 = eVar.f() + eVar.D();
        do {
            xVar.g(eVar.D());
        } while (eVar.f() < iF2);
        O(iF2);
    }

    public void M(w wVar) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 0) {
            do {
                ((s0) wVar).add(Long.valueOf(eVar.E()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iF = eVar.f() + eVar.D();
        do {
            ((s0) wVar).add(Long.valueOf(eVar.E()));
        } while (eVar.f() < iF);
        O(iF);
    }

    public void N(List list) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.j0)) {
            int i8 = this.f501b & 7;
            if (i8 == 0) {
                do {
                    list.add(Long.valueOf(eVar.E()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iF = eVar.f() + eVar.D();
            do {
                list.add(Long.valueOf(eVar.E()));
            } while (eVar.f() < iF);
            O(iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.j0 j0Var = (com.google.crypto.tink.shaded.protobuf.j0) list;
        int i9 = this.f501b & 7;
        if (i9 == 0) {
            do {
                j0Var.g(eVar.E());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iF2 = eVar.f() + eVar.D();
        do {
            j0Var.g(eVar.E());
        } while (eVar.f() < iF2);
        O(iF2);
    }

    public void O(int i8) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        switch (this.f500a) {
            case 0:
                if (((a2.e) this.f503e).f() != i8) {
                    throw z.e();
                }
                return;
            default:
                if (((a2.e) this.f503e).f() != i8) {
                    throw com.google.crypto.tink.shaded.protobuf.c0.g();
                }
                return;
        }
    }

    public void P(int i8) throws y, com.google.crypto.tink.shaded.protobuf.b0 {
        switch (this.f500a) {
            case 0:
                if ((this.f501b & 7) != i8) {
                    throw z.b();
                }
                return;
            default:
                if ((this.f501b & 7) != i8) {
                    throw com.google.crypto.tink.shaded.protobuf.c0.c();
                }
                return;
        }
    }

    public boolean Q() {
        int i8;
        a2.e eVar = (a2.e) this.f503e;
        if (eVar.g() || (i8 = this.f501b) == this.f502c) {
            return false;
        }
        return eVar.F(i8);
    }

    public int a() {
        switch (this.f500a) {
            case 0:
                int i8 = this.d;
                if (i8 != 0) {
                    this.f501b = i8;
                    this.d = 0;
                } else {
                    this.f501b = ((a2.e) this.f503e).C();
                }
                int i9 = this.f501b;
                if (i9 == 0 || i9 == this.f502c) {
                    return Integer.MAX_VALUE;
                }
                return i9 >>> 3;
            default:
                int i10 = this.d;
                if (i10 != 0) {
                    this.f501b = i10;
                    this.d = 0;
                } else {
                    this.f501b = ((a2.e) this.f503e).C();
                }
                int i11 = this.f501b;
                if (i11 == 0 || i11 == this.f502c) {
                    return Integer.MAX_VALUE;
                }
                return i11 >>> 3;
        }
    }

    public void b(Object obj, u0 u0Var, n nVar) {
        int i8 = this.f502c;
        this.f502c = ((this.f501b >>> 3) << 3) | 4;
        try {
            u0Var.h(obj, this, nVar);
            if (this.f501b == this.f502c) {
            } else {
                throw new z("Failed to parse the message.");
            }
        } finally {
            this.f502c = i8;
        }
    }

    public void c(Object obj, com.google.crypto.tink.shaded.protobuf.b1 b1Var, com.google.crypto.tink.shaded.protobuf.o oVar) {
        int i8 = this.f502c;
        this.f502c = ((this.f501b >>> 3) << 3) | 4;
        try {
            b1Var.j(obj, this, oVar);
            if (this.f501b == this.f502c) {
            } else {
                throw com.google.crypto.tink.shaded.protobuf.c0.f();
            }
        } finally {
            this.f502c = i8;
        }
    }

    public void d(Object obj, u0 u0Var, n nVar) throws z {
        a2.e eVar = (a2.e) this.f503e;
        int iD = eVar.D();
        if (eVar.f85a >= 100) {
            throw new z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iL = eVar.l(iD);
        eVar.f85a++;
        u0Var.h(obj, this, nVar);
        eVar.b(0);
        eVar.f85a--;
        eVar.j(iL);
    }

    public void e(Object obj, com.google.crypto.tink.shaded.protobuf.b1 b1Var, com.google.crypto.tink.shaded.protobuf.o oVar) throws com.google.crypto.tink.shaded.protobuf.c0 {
        a2.e eVar = (a2.e) this.f503e;
        int iD = eVar.D();
        if (eVar.f85a >= 100) {
            throw new com.google.crypto.tink.shaded.protobuf.c0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iL = eVar.l(iD);
        eVar.f85a++;
        b1Var.j(obj, this, oVar);
        eVar.b(0);
        eVar.f85a--;
        eVar.j(iL);
    }

    public void f(w wVar) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 0) {
            do {
                ((s0) wVar).add(Boolean.valueOf(eVar.m()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iF = eVar.f() + eVar.D();
        do {
            ((s0) wVar).add(Boolean.valueOf(eVar.m()));
        } while (eVar.f() < iF);
        O(iF);
    }

    public void g(List list) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.e)) {
            int i8 = this.f501b & 7;
            if (i8 == 0) {
                do {
                    list.add(Boolean.valueOf(eVar.m()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iF = eVar.f() + eVar.D();
            do {
                list.add(Boolean.valueOf(eVar.m()));
            } while (eVar.f() < iF);
            O(iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.e eVar2 = (com.google.crypto.tink.shaded.protobuf.e) list;
        int i9 = this.f501b & 7;
        if (i9 == 0) {
            do {
                eVar2.g(eVar.m());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iF2 = eVar.f() + eVar.D();
        do {
            eVar2.g(eVar.m());
        } while (eVar.f() < iF2);
        O(iF2);
    }

    public g h() throws y, com.google.crypto.tink.shaded.protobuf.b0 {
        P(2);
        return ((a2.e) this.f503e).n();
    }

    public com.google.crypto.tink.shaded.protobuf.i i() throws y, com.google.crypto.tink.shaded.protobuf.b0 {
        P(2);
        return ((a2.e) this.f503e).o();
    }

    public void j(w wVar) throws y {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        if ((this.f501b & 7) != 2) {
            throw z.b();
        }
        do {
            ((s0) wVar).add(h());
            if (eVar.g()) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == this.f501b);
        this.d = iC;
    }

    public void k(List list) throws com.google.crypto.tink.shaded.protobuf.b0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        if ((this.f501b & 7) != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        do {
            list.add(i());
            if (eVar.g()) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == this.f501b);
        this.d = iC;
    }

    public void l(w wVar) throws z {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 1) {
            do {
                ((s0) wVar).add(Double.valueOf(eVar.p()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iD = eVar.D();
        if ((iD & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iF = eVar.f() + iD;
        do {
            ((s0) wVar).add(Double.valueOf(eVar.p()));
        } while (eVar.f() < iF);
    }

    public void m(List list) throws com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.m)) {
            int i8 = this.f501b & 7;
            if (i8 == 1) {
                do {
                    list.add(Double.valueOf(eVar.p()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iD = eVar.D();
            S(iD);
            int iF = eVar.f() + iD;
            do {
                list.add(Double.valueOf(eVar.p()));
            } while (eVar.f() < iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.m mVar = (com.google.crypto.tink.shaded.protobuf.m) list;
        int i9 = this.f501b & 7;
        if (i9 == 1) {
            do {
                mVar.g(eVar.p());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iD2 = eVar.D();
        S(iD2);
        int iF2 = eVar.f() + iD2;
        do {
            mVar.g(eVar.p());
        } while (eVar.f() < iF2);
    }

    public void n(w wVar) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 0) {
            do {
                ((s0) wVar).add(Integer.valueOf(eVar.q()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iF = eVar.f() + eVar.D();
        do {
            ((s0) wVar).add(Integer.valueOf(eVar.q()));
        } while (eVar.f() < iF);
        O(iF);
    }

    public void o(List list) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.x)) {
            int i8 = this.f501b & 7;
            if (i8 == 0) {
                do {
                    list.add(Integer.valueOf(eVar.q()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iF = eVar.f() + eVar.D();
            do {
                list.add(Integer.valueOf(eVar.q()));
            } while (eVar.f() < iF);
            O(iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.x xVar = (com.google.crypto.tink.shaded.protobuf.x) list;
        int i9 = this.f501b & 7;
        if (i9 == 0) {
            do {
                xVar.g(eVar.q());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iF2 = eVar.f() + eVar.D();
        do {
            xVar.g(eVar.q());
        } while (eVar.f() < iF2);
        O(iF2);
    }

    public Object p(p1 p1Var, Class cls, n nVar) throws z, com.google.crypto.tink.shaded.protobuf.b0 {
        a2.e eVar = (a2.e) this.f503e;
        switch (p1Var.ordinal()) {
            case 0:
                P(1);
                return Double.valueOf(eVar.p());
            case 1:
                P(5);
                return Float.valueOf(eVar.t());
            case 2:
                P(0);
                return Long.valueOf(eVar.v());
            case 3:
                P(0);
                return Long.valueOf(eVar.E());
            case 4:
                P(0);
                return Integer.valueOf(eVar.u());
            case 5:
                P(1);
                return Long.valueOf(eVar.s());
            case 6:
                P(5);
                return Integer.valueOf(eVar.r());
            case 7:
                P(0);
                return Boolean.valueOf(eVar.m());
            case 8:
                P(2);
                return eVar.B();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                P(2);
                u0 u0VarA = r0.f559c.a(cls);
                v vVarD = u0VarA.d();
                d(vVarD, u0VarA, nVar);
                u0VarA.b(vVarD);
                return vVarD;
            case BERTags.EMBEDDED_PDV /* 11 */:
                return h();
            case 12:
                P(0);
                return Integer.valueOf(eVar.D());
            case BERTags.RELATIVE_OID /* 13 */:
                P(0);
                return Integer.valueOf(eVar.q());
            case BERTags.TIME /* 14 */:
                P(5);
                return Integer.valueOf(eVar.w());
            case 15:
                P(1);
                return Long.valueOf(eVar.x());
            case 16:
                P(0);
                return Integer.valueOf(eVar.y());
            case 17:
                P(0);
                return Long.valueOf(eVar.z());
        }
    }

    public void q(w wVar) throws z {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 2) {
            int iD = eVar.D();
            if ((iD & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iF = eVar.f() + iD;
            do {
                ((s0) wVar).add(Integer.valueOf(eVar.r()));
            } while (eVar.f() < iF);
            return;
        }
        if (i8 != 5) {
            throw z.b();
        }
        do {
            ((s0) wVar).add(Integer.valueOf(eVar.r()));
            if (eVar.g()) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == this.f501b);
        this.d = iC;
    }

    public void r(List list) throws com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.x)) {
            int i8 = this.f501b & 7;
            if (i8 == 2) {
                int iD = eVar.D();
                R(iD);
                int iF = eVar.f() + iD;
                do {
                    list.add(Integer.valueOf(eVar.r()));
                } while (eVar.f() < iF);
                return;
            }
            if (i8 != 5) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            do {
                list.add(Integer.valueOf(eVar.r()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        com.google.crypto.tink.shaded.protobuf.x xVar = (com.google.crypto.tink.shaded.protobuf.x) list;
        int i9 = this.f501b & 7;
        if (i9 == 2) {
            int iD2 = eVar.D();
            R(iD2);
            int iF2 = eVar.f() + iD2;
            do {
                xVar.g(eVar.r());
            } while (eVar.f() < iF2);
            return;
        }
        if (i9 != 5) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        do {
            xVar.g(eVar.r());
            if (eVar.g()) {
                return;
            } else {
                iC2 = eVar.C();
            }
        } while (iC2 == this.f501b);
        this.d = iC2;
    }

    public void s(w wVar) throws z {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 1) {
            do {
                ((s0) wVar).add(Long.valueOf(eVar.s()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iD = eVar.D();
        if ((iD & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iF = eVar.f() + iD;
        do {
            ((s0) wVar).add(Long.valueOf(eVar.s()));
        } while (eVar.f() < iF);
    }

    public void t(List list) throws com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.j0)) {
            int i8 = this.f501b & 7;
            if (i8 == 1) {
                do {
                    list.add(Long.valueOf(eVar.s()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iD = eVar.D();
            S(iD);
            int iF = eVar.f() + iD;
            do {
                list.add(Long.valueOf(eVar.s()));
            } while (eVar.f() < iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.j0 j0Var = (com.google.crypto.tink.shaded.protobuf.j0) list;
        int i9 = this.f501b & 7;
        if (i9 == 1) {
            do {
                j0Var.g(eVar.s());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iD2 = eVar.D();
        S(iD2);
        int iF2 = eVar.f() + iD2;
        do {
            j0Var.g(eVar.s());
        } while (eVar.f() < iF2);
    }

    public void u(w wVar) throws z {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 2) {
            int iD = eVar.D();
            if ((iD & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iF = eVar.f() + iD;
            do {
                ((s0) wVar).add(Float.valueOf(eVar.t()));
            } while (eVar.f() < iF);
            return;
        }
        if (i8 != 5) {
            throw z.b();
        }
        do {
            ((s0) wVar).add(Float.valueOf(eVar.t()));
            if (eVar.g()) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == this.f501b);
        this.d = iC;
    }

    public void v(List list) throws com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.s)) {
            int i8 = this.f501b & 7;
            if (i8 == 2) {
                int iD = eVar.D();
                R(iD);
                int iF = eVar.f() + iD;
                do {
                    list.add(Float.valueOf(eVar.t()));
                } while (eVar.f() < iF);
                return;
            }
            if (i8 != 5) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            do {
                list.add(Float.valueOf(eVar.t()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        com.google.crypto.tink.shaded.protobuf.s sVar = (com.google.crypto.tink.shaded.protobuf.s) list;
        int i9 = this.f501b & 7;
        if (i9 == 2) {
            int iD2 = eVar.D();
            R(iD2);
            int iF2 = eVar.f() + iD2;
            do {
                sVar.g(eVar.t());
            } while (eVar.f() < iF2);
            return;
        }
        if (i9 != 5) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        do {
            sVar.g(eVar.t());
            if (eVar.g()) {
                return;
            } else {
                iC2 = eVar.C();
            }
        } while (iC2 == this.f501b);
        this.d = iC2;
    }

    public void w(w wVar) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 0) {
            do {
                ((s0) wVar).add(Integer.valueOf(eVar.u()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iF = eVar.f() + eVar.D();
        do {
            ((s0) wVar).add(Integer.valueOf(eVar.u()));
        } while (eVar.f() < iF);
        O(iF);
    }

    public void x(List list) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.x)) {
            int i8 = this.f501b & 7;
            if (i8 == 0) {
                do {
                    list.add(Integer.valueOf(eVar.u()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iF = eVar.f() + eVar.D();
            do {
                list.add(Integer.valueOf(eVar.u()));
            } while (eVar.f() < iF);
            O(iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.x xVar = (com.google.crypto.tink.shaded.protobuf.x) list;
        int i9 = this.f501b & 7;
        if (i9 == 0) {
            do {
                xVar.g(eVar.u());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iF2 = eVar.f() + eVar.D();
        do {
            xVar.g(eVar.u());
        } while (eVar.f() < iF2);
        O(iF2);
    }

    public void y(w wVar) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        a2.e eVar = (a2.e) this.f503e;
        int i8 = this.f501b & 7;
        if (i8 == 0) {
            do {
                ((s0) wVar).add(Long.valueOf(eVar.v()));
                if (eVar.g()) {
                    return;
                } else {
                    iC = eVar.C();
                }
            } while (iC == this.f501b);
            this.d = iC;
            return;
        }
        if (i8 != 2) {
            throw z.b();
        }
        int iF = eVar.f() + eVar.D();
        do {
            ((s0) wVar).add(Long.valueOf(eVar.v()));
        } while (eVar.f() < iF);
        O(iF);
    }

    public void z(List list) throws z, com.google.crypto.tink.shaded.protobuf.c0 {
        int iC;
        int iC2;
        a2.e eVar = (a2.e) this.f503e;
        if (!(list instanceof com.google.crypto.tink.shaded.protobuf.j0)) {
            int i8 = this.f501b & 7;
            if (i8 == 0) {
                do {
                    list.add(Long.valueOf(eVar.v()));
                    if (eVar.g()) {
                        return;
                    } else {
                        iC = eVar.C();
                    }
                } while (iC == this.f501b);
                this.d = iC;
                return;
            }
            if (i8 != 2) {
                throw com.google.crypto.tink.shaded.protobuf.c0.c();
            }
            int iF = eVar.f() + eVar.D();
            do {
                list.add(Long.valueOf(eVar.v()));
            } while (eVar.f() < iF);
            O(iF);
            return;
        }
        com.google.crypto.tink.shaded.protobuf.j0 j0Var = (com.google.crypto.tink.shaded.protobuf.j0) list;
        int i9 = this.f501b & 7;
        if (i9 == 0) {
            do {
                j0Var.g(eVar.v());
                if (eVar.g()) {
                    return;
                } else {
                    iC2 = eVar.C();
                }
            } while (iC2 == this.f501b);
            this.d = iC2;
            return;
        }
        if (i9 != 2) {
            throw com.google.crypto.tink.shaded.protobuf.c0.c();
        }
        int iF2 = eVar.f() + eVar.D();
        do {
            j0Var.g(eVar.v());
        } while (eVar.f() < iF2);
        O(iF2);
    }

    public j(a2.e eVar, byte b9) {
        this.f500a = 1;
        this.d = 0;
        com.google.crypto.tink.shaded.protobuf.a0.a(eVar, "input");
        this.f503e = eVar;
        eVar.f86b = this;
    }

    public j(int i8, Class cls, int i9, int i10) {
        this.f500a = 2;
        this.f501b = i8;
        this.f503e = cls;
        this.d = i9;
        this.f502c = i10;
    }
}
