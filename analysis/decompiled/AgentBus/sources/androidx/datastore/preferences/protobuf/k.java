package androidx.datastore.preferences.protobuf;

import com.google.protobuf.LazyStringList;
import com.google.protobuf.d2;
import com.google.protobuf.j2;
import com.google.protobuf.o2;
import com.google.protobuf.p2;
import com.google.protobuf.q2;
import com.google.protobuf.q3;
import com.google.protobuf.r2;
import com.google.protobuf.s4;
import com.google.protobuf.t3;
import com.google.protobuf.x2;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f892a;

    /* renamed from: b, reason: collision with root package name */
    public int f893b;

    /* renamed from: c, reason: collision with root package name */
    public int f894c;

    /* renamed from: d, reason: collision with root package name */
    public int f895d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f896e;

    public k(com.google.protobuf.o oVar) {
        this.f892a = 3;
        this.f895d = 0;
        p2.a(oVar, "input");
        this.f896e = oVar;
        oVar.f2465b = this;
    }

    public static void X(int i2) throws com.google.crypto.tink.shaded.protobuf.b0 {
        if ((i2 & 3) != 0) {
            throw com.google.crypto.tink.shaded.protobuf.b0.f();
        }
    }

    public static void Y(int i2) throws r2 {
        if ((i2 & 3) != 0) {
            throw r2.f();
        }
    }

    public static void Z(int i2) throws com.google.crypto.tink.shaded.protobuf.b0 {
        if ((i2 & 7) != 0) {
            throw com.google.crypto.tink.shaded.protobuf.b0.f();
        }
    }

    public static void a0(int i2) throws r2 {
        if ((i2 & 7) != 0) {
            throw r2.f();
        }
    }

    public void A(o2 o2Var) throws r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof d2)) {
            int i2 = this.f893b & 7;
            if (i2 == 2) {
                int iY = oVar.y();
                Y(iY);
                int iD = oVar.d() + iY;
                do {
                    o2Var.add(Float.valueOf(oVar.o()));
                } while (oVar.d() < iD);
                return;
            }
            if (i2 != 5) {
                throw r2.c();
            }
            do {
                o2Var.add(Float.valueOf(oVar.o()));
                if (oVar.e()) {
                    return;
                } else {
                    iX = oVar.x();
                }
            } while (iX == this.f893b);
            this.f895d = iX;
            return;
        }
        d2 d2Var = (d2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 2) {
            int iY2 = oVar.y();
            Y(iY2);
            int iD2 = oVar.d() + iY2;
            do {
                d2Var.addFloat(oVar.o());
            } while (oVar.d() < iD2);
            return;
        }
        if (i10 != 5) {
            throw r2.c();
        }
        do {
            d2Var.addFloat(oVar.o());
            if (oVar.e()) {
                return;
            } else {
                iX2 = oVar.x();
            }
        } while (iX2 == this.f893b);
        this.f895d = iX2;
    }

    public void B(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 2) {
                    int iD = jVar.D();
                    if ((iD & 3) != 0) {
                        throw new a0("Failed to parse the message.");
                    }
                    int iF = jVar.f() + iD;
                    do {
                        list.add(Float.valueOf(jVar.t()));
                    } while (jVar.f() < iF);
                    return;
                }
                if (i2 != 5) {
                    throw a0.b();
                }
                do {
                    list.add(Float.valueOf(jVar.t()));
                    if (jVar.g()) {
                        return;
                    } else {
                        iC = jVar.C();
                    }
                } while (iC == this.f893b);
                this.f895d = iC;
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.r)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 2) {
                        int iD2 = jVar2.D();
                        X(iD2);
                        int iF2 = jVar2.f() + iD2;
                        do {
                            list.add(Float.valueOf(jVar2.t()));
                        } while (jVar2.f() < iF2);
                        return;
                    }
                    if (i10 != 5) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    do {
                        list.add(Float.valueOf(jVar2.t()));
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC2 = jVar2.C();
                        }
                    } while (iC2 == this.f893b);
                    this.f895d = iC2;
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.r rVar = (com.google.crypto.tink.shaded.protobuf.r) list;
                int i11 = this.f893b & 7;
                if (i11 == 2) {
                    int iD3 = jVar2.D();
                    X(iD3);
                    int iF3 = jVar2.f() + iD3;
                    do {
                        rVar.addFloat(jVar2.t());
                    } while (jVar2.f() < iF3);
                    return;
                }
                if (i11 != 5) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                do {
                    rVar.addFloat(jVar2.t());
                    if (jVar2.g()) {
                        return;
                    } else {
                        iC3 = jVar2.C();
                    }
                } while (iC3 == this.f893b);
                this.f895d = iC3;
                return;
        }
    }

    public void C(o2 o2Var) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof j2)) {
            int i2 = this.f893b & 7;
            if (i2 == 0) {
                do {
                    o2Var.add(Integer.valueOf(oVar.p()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iD = oVar.d() + oVar.y();
            do {
                o2Var.add(Integer.valueOf(oVar.p()));
            } while (oVar.d() < iD);
            U(iD);
            return;
        }
        j2 j2Var = (j2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 0) {
            do {
                j2Var.addInt(oVar.p());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iD2 = oVar.d() + oVar.y();
        do {
            j2Var.addInt(oVar.p());
        } while (oVar.d() < iD2);
        U(iD2);
    }

    public void D(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 0) {
                    do {
                        list.add(Integer.valueOf(jVar.u()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iF = jVar.f() + jVar.D();
                do {
                    list.add(Integer.valueOf(jVar.u()));
                } while (jVar.f() < iF);
                U(iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.w)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 0) {
                        do {
                            list.add(Integer.valueOf(jVar2.u()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iF2 = jVar2.f() + jVar2.D();
                    do {
                        list.add(Integer.valueOf(jVar2.u()));
                    } while (jVar2.f() < iF2);
                    U(iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.w wVar = (com.google.crypto.tink.shaded.protobuf.w) list;
                int i11 = this.f893b & 7;
                if (i11 == 0) {
                    do {
                        wVar.addInt(jVar2.u());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iF3 = jVar2.f() + jVar2.D();
                do {
                    wVar.addInt(jVar2.u());
                } while (jVar2.f() < iF3);
                U(iF3);
                return;
        }
    }

    public void E(o2 o2Var) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof x2)) {
            int i2 = this.f893b & 7;
            if (i2 == 0) {
                do {
                    o2Var.add(Long.valueOf(oVar.q()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iD = oVar.d() + oVar.y();
            do {
                o2Var.add(Long.valueOf(oVar.q()));
            } while (oVar.d() < iD);
            U(iD);
            return;
        }
        x2 x2Var = (x2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 0) {
            do {
                x2Var.addLong(oVar.q());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iD2 = oVar.d() + oVar.y();
        do {
            x2Var.addLong(oVar.q());
        } while (oVar.d() < iD2);
        U(iD2);
    }

    public void F(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 0) {
                    do {
                        list.add(Long.valueOf(jVar.v()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iF = jVar.f() + jVar.D();
                do {
                    list.add(Long.valueOf(jVar.v()));
                } while (jVar.f() < iF);
                U(iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.i0)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 0) {
                        do {
                            list.add(Long.valueOf(jVar2.v()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iF2 = jVar2.f() + jVar2.D();
                    do {
                        list.add(Long.valueOf(jVar2.v()));
                    } while (jVar2.f() < iF2);
                    U(iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.i0 i0Var = (com.google.crypto.tink.shaded.protobuf.i0) list;
                int i11 = this.f893b & 7;
                if (i11 == 0) {
                    do {
                        i0Var.addLong(jVar2.v());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iF3 = jVar2.f() + jVar2.D();
                do {
                    i0Var.addLong(jVar2.v());
                } while (jVar2.f() < iF3);
                U(iF3);
                return;
        }
    }

    public void G(o2 o2Var) throws r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof j2)) {
            int i2 = this.f893b & 7;
            if (i2 == 2) {
                int iY = oVar.y();
                Y(iY);
                int iD = oVar.d() + iY;
                do {
                    o2Var.add(Integer.valueOf(oVar.r()));
                } while (oVar.d() < iD);
                return;
            }
            if (i2 != 5) {
                throw r2.c();
            }
            do {
                o2Var.add(Integer.valueOf(oVar.r()));
                if (oVar.e()) {
                    return;
                } else {
                    iX = oVar.x();
                }
            } while (iX == this.f893b);
            this.f895d = iX;
            return;
        }
        j2 j2Var = (j2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 2) {
            int iY2 = oVar.y();
            Y(iY2);
            int iD2 = oVar.d() + iY2;
            do {
                j2Var.addInt(oVar.r());
            } while (oVar.d() < iD2);
            return;
        }
        if (i10 != 5) {
            throw r2.c();
        }
        do {
            j2Var.addInt(oVar.r());
            if (oVar.e()) {
                return;
            } else {
                iX2 = oVar.x();
            }
        } while (iX2 == this.f893b);
        this.f895d = iX2;
    }

    public void H(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 2) {
                    int iD = jVar.D();
                    if ((iD & 3) != 0) {
                        throw new a0("Failed to parse the message.");
                    }
                    int iF = jVar.f() + iD;
                    do {
                        list.add(Integer.valueOf(jVar.w()));
                    } while (jVar.f() < iF);
                    return;
                }
                if (i2 != 5) {
                    throw a0.b();
                }
                do {
                    list.add(Integer.valueOf(jVar.w()));
                    if (jVar.g()) {
                        return;
                    } else {
                        iC = jVar.C();
                    }
                } while (iC == this.f893b);
                this.f895d = iC;
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.w)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 2) {
                        int iD2 = jVar2.D();
                        X(iD2);
                        int iF2 = jVar2.f() + iD2;
                        do {
                            list.add(Integer.valueOf(jVar2.w()));
                        } while (jVar2.f() < iF2);
                        return;
                    }
                    if (i10 != 5) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    do {
                        list.add(Integer.valueOf(jVar2.w()));
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC2 = jVar2.C();
                        }
                    } while (iC2 == this.f893b);
                    this.f895d = iC2;
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.w wVar = (com.google.crypto.tink.shaded.protobuf.w) list;
                int i11 = this.f893b & 7;
                if (i11 == 2) {
                    int iD3 = jVar2.D();
                    X(iD3);
                    int iF3 = jVar2.f() + iD3;
                    do {
                        wVar.addInt(jVar2.w());
                    } while (jVar2.f() < iF3);
                    return;
                }
                if (i11 != 5) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                do {
                    wVar.addInt(jVar2.w());
                    if (jVar2.g()) {
                        return;
                    } else {
                        iC3 = jVar2.C();
                    }
                } while (iC3 == this.f893b);
                this.f895d = iC3;
                return;
        }
    }

    public void I(o2 o2Var) throws r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof x2)) {
            int i2 = this.f893b & 7;
            if (i2 == 1) {
                do {
                    o2Var.add(Long.valueOf(oVar.s()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iY = oVar.y();
            a0(iY);
            int iD = oVar.d() + iY;
            do {
                o2Var.add(Long.valueOf(oVar.s()));
            } while (oVar.d() < iD);
            return;
        }
        x2 x2Var = (x2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 1) {
            do {
                x2Var.addLong(oVar.s());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iY2 = oVar.y();
        a0(iY2);
        int iD2 = oVar.d() + iY2;
        do {
            x2Var.addLong(oVar.s());
        } while (oVar.d() < iD2);
    }

    public void J(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 1) {
                    do {
                        list.add(Long.valueOf(jVar.x()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iD = jVar.D();
                if ((iD & 7) != 0) {
                    throw new a0("Failed to parse the message.");
                }
                int iF = jVar.f() + iD;
                do {
                    list.add(Long.valueOf(jVar.x()));
                } while (jVar.f() < iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.i0)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 1) {
                        do {
                            list.add(Long.valueOf(jVar2.x()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iD2 = jVar2.D();
                    Z(iD2);
                    int iF2 = jVar2.f() + iD2;
                    do {
                        list.add(Long.valueOf(jVar2.x()));
                    } while (jVar2.f() < iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.i0 i0Var = (com.google.crypto.tink.shaded.protobuf.i0) list;
                int i11 = this.f893b & 7;
                if (i11 == 1) {
                    do {
                        i0Var.addLong(jVar2.x());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iD3 = jVar2.D();
                Z(iD3);
                int iF3 = jVar2.f() + iD3;
                do {
                    i0Var.addLong(jVar2.x());
                } while (jVar2.f() < iF3);
                return;
        }
    }

    public void K(o2 o2Var) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof j2)) {
            int i2 = this.f893b & 7;
            if (i2 == 0) {
                do {
                    o2Var.add(Integer.valueOf(oVar.t()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iD = oVar.d() + oVar.y();
            do {
                o2Var.add(Integer.valueOf(oVar.t()));
            } while (oVar.d() < iD);
            U(iD);
            return;
        }
        j2 j2Var = (j2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 0) {
            do {
                j2Var.addInt(oVar.t());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iD2 = oVar.d() + oVar.y();
        do {
            j2Var.addInt(oVar.t());
        } while (oVar.d() < iD2);
        U(iD2);
    }

    public void L(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 0) {
                    do {
                        list.add(Integer.valueOf(jVar.y()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iF = jVar.f() + jVar.D();
                do {
                    list.add(Integer.valueOf(jVar.y()));
                } while (jVar.f() < iF);
                U(iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.w)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 0) {
                        do {
                            list.add(Integer.valueOf(jVar2.y()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iF2 = jVar2.f() + jVar2.D();
                    do {
                        list.add(Integer.valueOf(jVar2.y()));
                    } while (jVar2.f() < iF2);
                    U(iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.w wVar = (com.google.crypto.tink.shaded.protobuf.w) list;
                int i11 = this.f893b & 7;
                if (i11 == 0) {
                    do {
                        wVar.addInt(jVar2.y());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iF3 = jVar2.f() + jVar2.D();
                do {
                    wVar.addInt(jVar2.y());
                } while (jVar2.f() < iF3);
                U(iF3);
                return;
        }
    }

    public void M(o2 o2Var) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof x2)) {
            int i2 = this.f893b & 7;
            if (i2 == 0) {
                do {
                    o2Var.add(Long.valueOf(oVar.u()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iD = oVar.d() + oVar.y();
            do {
                o2Var.add(Long.valueOf(oVar.u()));
            } while (oVar.d() < iD);
            U(iD);
            return;
        }
        x2 x2Var = (x2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 0) {
            do {
                x2Var.addLong(oVar.u());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iD2 = oVar.d() + oVar.y();
        do {
            x2Var.addLong(oVar.u());
        } while (oVar.d() < iD2);
        U(iD2);
    }

    public void N(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 0) {
                    do {
                        list.add(Long.valueOf(jVar.z()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iF = jVar.f() + jVar.D();
                do {
                    list.add(Long.valueOf(jVar.z()));
                } while (jVar.f() < iF);
                U(iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.i0)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 0) {
                        do {
                            list.add(Long.valueOf(jVar2.z()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iF2 = jVar2.f() + jVar2.D();
                    do {
                        list.add(Long.valueOf(jVar2.z()));
                    } while (jVar2.f() < iF2);
                    U(iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.i0 i0Var = (com.google.crypto.tink.shaded.protobuf.i0) list;
                int i11 = this.f893b & 7;
                if (i11 == 0) {
                    do {
                        i0Var.addLong(jVar2.z());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iF3 = jVar2.f() + jVar2.D();
                do {
                    i0Var.addLong(jVar2.z());
                } while (jVar2.f() < iF3);
                U(iF3);
                return;
        }
    }

    public void O(o2 o2Var, boolean z4) throws z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        String strV;
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if ((this.f893b & 7) != 2) {
            throw r2.c();
        }
        if ((o2Var instanceof LazyStringList) && !z4) {
            LazyStringList lazyStringList = (LazyStringList) o2Var;
            do {
                lazyStringList.add(n());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        do {
            if (z4) {
                V(2);
                strV = oVar.w();
            } else {
                V(2);
                strV = oVar.v();
            }
            o2Var.add(strV);
            if (oVar.e()) {
                return;
            } else {
                iX = oVar.x();
            }
        } while (iX == this.f893b);
        this.f895d = iX;
    }

    public void P(List list, boolean z4) throws z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        String strA;
        int iC;
        int iC2;
        String strA2;
        int iC3;
        int iC4;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                if ((this.f893b & 7) != 2) {
                    throw a0.b();
                }
                if ((list instanceof d0) && !z4) {
                    d0 d0Var = (d0) list;
                    do {
                        d0Var.d(l());
                        if (jVar.g()) {
                            return;
                        } else {
                            iC2 = jVar.C();
                        }
                    } while (iC2 == this.f893b);
                    this.f895d = iC2;
                    return;
                }
                do {
                    if (z4) {
                        V(2);
                        strA = jVar.B();
                    } else {
                        V(2);
                        strA = jVar.A();
                    }
                    list.add(strA);
                    if (jVar.g()) {
                        return;
                    } else {
                        iC = jVar.C();
                    }
                } while (iC == this.f893b);
                this.f895d = iC;
                return;
            default:
                j jVar2 = (j) this.f896e;
                if ((this.f893b & 7) != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                if ((list instanceof com.google.crypto.tink.shaded.protobuf.e0) && !z4) {
                    com.google.crypto.tink.shaded.protobuf.e0 e0Var = (com.google.crypto.tink.shaded.protobuf.e0) list;
                    do {
                        e0Var.e(m());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC4 = jVar2.C();
                        }
                    } while (iC4 == this.f893b);
                    this.f895d = iC4;
                    return;
                }
                do {
                    if (z4) {
                        V(2);
                        strA2 = jVar2.B();
                    } else {
                        V(2);
                        strA2 = jVar2.A();
                    }
                    list.add(strA2);
                    if (jVar2.g()) {
                        return;
                    } else {
                        iC3 = jVar2.C();
                    }
                } while (iC3 == this.f893b);
                this.f895d = iC3;
                return;
        }
    }

    public void Q(o2 o2Var) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof j2)) {
            int i2 = this.f893b & 7;
            if (i2 == 0) {
                do {
                    o2Var.add(Integer.valueOf(oVar.y()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iD = oVar.d() + oVar.y();
            do {
                o2Var.add(Integer.valueOf(oVar.y()));
            } while (oVar.d() < iD);
            U(iD);
            return;
        }
        j2 j2Var = (j2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 0) {
            do {
                j2Var.addInt(oVar.y());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iD2 = oVar.d() + oVar.y();
        do {
            j2Var.addInt(oVar.y());
        } while (oVar.d() < iD2);
        U(iD2);
    }

    public void R(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 0) {
                    do {
                        list.add(Integer.valueOf(jVar.D()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iF = jVar.f() + jVar.D();
                do {
                    list.add(Integer.valueOf(jVar.D()));
                } while (jVar.f() < iF);
                U(iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.w)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 0) {
                        do {
                            list.add(Integer.valueOf(jVar2.D()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iF2 = jVar2.f() + jVar2.D();
                    do {
                        list.add(Integer.valueOf(jVar2.D()));
                    } while (jVar2.f() < iF2);
                    U(iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.w wVar = (com.google.crypto.tink.shaded.protobuf.w) list;
                int i11 = this.f893b & 7;
                if (i11 == 0) {
                    do {
                        wVar.addInt(jVar2.D());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iF3 = jVar2.f() + jVar2.D();
                do {
                    wVar.addInt(jVar2.D());
                } while (jVar2.f() < iF3);
                U(iF3);
                return;
        }
    }

    public void S(o2 o2Var) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof x2)) {
            int i2 = this.f893b & 7;
            if (i2 == 0) {
                do {
                    o2Var.add(Long.valueOf(oVar.z()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iD = oVar.d() + oVar.y();
            do {
                o2Var.add(Long.valueOf(oVar.z()));
            } while (oVar.d() < iD);
            U(iD);
            return;
        }
        x2 x2Var = (x2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 0) {
            do {
                x2Var.addLong(oVar.z());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iD2 = oVar.d() + oVar.y();
        do {
            x2Var.addLong(oVar.z());
        } while (oVar.d() < iD2);
        U(iD2);
    }

    public void T(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 0) {
                    do {
                        list.add(Long.valueOf(jVar.E()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iF = jVar.f() + jVar.D();
                do {
                    list.add(Long.valueOf(jVar.E()));
                } while (jVar.f() < iF);
                U(iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.i0)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 0) {
                        do {
                            list.add(Long.valueOf(jVar2.E()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iF2 = jVar2.f() + jVar2.D();
                    do {
                        list.add(Long.valueOf(jVar2.E()));
                    } while (jVar2.f() < iF2);
                    U(iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.i0 i0Var = (com.google.crypto.tink.shaded.protobuf.i0) list;
                int i11 = this.f893b & 7;
                if (i11 == 0) {
                    do {
                        i0Var.addLong(jVar2.E());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iF3 = jVar2.f() + jVar2.D();
                do {
                    i0Var.addLong(jVar2.E());
                } while (jVar2.f() < iF3);
                U(iF3);
                return;
        }
    }

    public void U(int i2) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        switch (this.f892a) {
            case 0:
                if (((j) this.f896e).f() != i2) {
                    throw a0.e();
                }
                return;
            case 1:
            default:
                if (((com.google.protobuf.o) this.f896e).d() != i2) {
                    throw r2.g();
                }
                return;
            case 2:
                if (((j) this.f896e).f() != i2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.g();
                }
                return;
        }
    }

    public void V(int i2) throws z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        switch (this.f892a) {
            case 0:
                if ((this.f893b & 7) != i2) {
                    throw a0.b();
                }
                return;
            case 1:
            default:
                if ((this.f893b & 7) != i2) {
                    throw r2.c();
                }
                return;
            case 2:
                if ((this.f893b & 7) != i2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                return;
        }
    }

    public boolean W() {
        int i2;
        int i10;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                if (jVar.g() || (i2 = this.f893b) == this.f894c) {
                    return false;
                }
                return jVar.F(i2);
            default:
                com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
                if (oVar.e() || (i10 = this.f893b) == this.f894c) {
                    return false;
                }
                return oVar.A(i10);
        }
    }

    public int a() {
        switch (this.f892a) {
            case 0:
                int i2 = this.f895d;
                if (i2 != 0) {
                    this.f893b = i2;
                    this.f895d = 0;
                } else {
                    this.f893b = ((j) this.f896e).C();
                }
                int i10 = this.f893b;
                if (i10 == 0 || i10 == this.f894c) {
                    return Integer.MAX_VALUE;
                }
                return i10 >>> 3;
            case 1:
            default:
                int i11 = this.f895d;
                if (i11 != 0) {
                    this.f893b = i11;
                    this.f895d = 0;
                } else {
                    this.f893b = ((com.google.protobuf.o) this.f896e).x();
                }
                int i12 = this.f893b;
                if (i12 == 0 || i12 == this.f894c) {
                    return Integer.MAX_VALUE;
                }
                return i12 >>> 3;
            case 2:
                int i13 = this.f895d;
                if (i13 != 0) {
                    this.f893b = i13;
                    this.f895d = 0;
                } else {
                    this.f893b = ((j) this.f896e).C();
                }
                int i14 = this.f893b;
                if (i14 == 0 || i14 == this.f894c) {
                    return Integer.MAX_VALUE;
                }
                return i14 >>> 3;
        }
    }

    public int b(int i2) {
        return ((c0.i0) this.f896e).f1743c[this.f894c + i2];
    }

    public Object c(int i2) {
        return ((c0.i0) this.f896e).f1745e[this.f895d + i2];
    }

    public void d(Object obj, z0 z0Var, o oVar) {
        int i2 = this.f894c;
        this.f894c = ((this.f893b >>> 3) << 3) | 4;
        try {
            z0Var.h(obj, this, oVar);
            if (this.f893b == this.f894c) {
            } else {
                throw new a0("Failed to parse the message.");
            }
        } finally {
            this.f894c = i2;
        }
    }

    public void e(Object obj, com.google.crypto.tink.shaded.protobuf.a1 a1Var, com.google.crypto.tink.shaded.protobuf.n nVar) {
        int i2 = this.f894c;
        this.f894c = ((this.f893b >>> 3) << 3) | 4;
        try {
            a1Var.j(obj, this, nVar);
            if (this.f893b == this.f894c) {
            } else {
                throw com.google.crypto.tink.shaded.protobuf.b0.f();
            }
        } finally {
            this.f894c = i2;
        }
    }

    public void f(Object obj, t3 t3Var, com.google.protobuf.u1 u1Var) {
        int i2 = this.f894c;
        this.f894c = ((this.f893b >>> 3) << 3) | 4;
        try {
            t3Var.j(obj, this, u1Var);
            if (this.f893b == this.f894c) {
            } else {
                throw r2.f();
            }
        } finally {
            this.f894c = i2;
        }
    }

    public void g(Object obj, z0 z0Var, o oVar) throws a0 {
        j jVar = (j) this.f896e;
        int iD = jVar.D();
        if (jVar.f881a >= 100) {
            throw new a0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iL = jVar.l(iD);
        jVar.f881a++;
        z0Var.h(obj, this, oVar);
        jVar.b(0);
        jVar.f881a--;
        jVar.j(iL);
    }

    public void h(Object obj, com.google.crypto.tink.shaded.protobuf.a1 a1Var, com.google.crypto.tink.shaded.protobuf.n nVar) throws com.google.crypto.tink.shaded.protobuf.b0 {
        j jVar = (j) this.f896e;
        int iD = jVar.D();
        if (jVar.f881a >= 100) {
            throw new com.google.crypto.tink.shaded.protobuf.b0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iL = jVar.l(iD);
        jVar.f881a++;
        a1Var.j(obj, this, nVar);
        jVar.b(0);
        jVar.f881a--;
        jVar.j(iL);
    }

    public void i(Object obj, t3 t3Var, com.google.protobuf.u1 u1Var) throws r2 {
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        int iY = oVar.y();
        if (oVar.f2464a >= 100) {
            throw new r2("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iH = oVar.h(iY);
        oVar.f2464a++;
        t3Var.j(obj, this, u1Var);
        oVar.a(0);
        oVar.f2464a--;
        oVar.g(iH);
    }

    public void j(o2 o2Var) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof com.google.protobuf.h)) {
            int i2 = this.f893b & 7;
            if (i2 == 0) {
                do {
                    o2Var.add(Boolean.valueOf(oVar.i()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iD = oVar.d() + oVar.y();
            do {
                o2Var.add(Boolean.valueOf(oVar.i()));
            } while (oVar.d() < iD);
            U(iD);
            return;
        }
        com.google.protobuf.h hVar = (com.google.protobuf.h) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 0) {
            do {
                hVar.addBoolean(oVar.i());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iD2 = oVar.d() + oVar.y();
        do {
            hVar.addBoolean(oVar.i());
        } while (oVar.d() < iD2);
        U(iD2);
    }

    public void k(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 0) {
                    do {
                        list.add(Boolean.valueOf(jVar.m()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iF = jVar.f() + jVar.D();
                do {
                    list.add(Boolean.valueOf(jVar.m()));
                } while (jVar.f() < iF);
                U(iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.d)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 0) {
                        do {
                            list.add(Boolean.valueOf(jVar2.m()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iF2 = jVar2.f() + jVar2.D();
                    do {
                        list.add(Boolean.valueOf(jVar2.m()));
                    } while (jVar2.f() < iF2);
                    U(iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.d dVar = (com.google.crypto.tink.shaded.protobuf.d) list;
                int i11 = this.f893b & 7;
                if (i11 == 0) {
                    do {
                        dVar.addBoolean(jVar2.m());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iF3 = jVar2.f() + jVar2.D();
                do {
                    dVar.addBoolean(jVar2.m());
                } while (jVar2.f() < iF3);
                U(iF3);
                return;
        }
    }

    public g l() throws z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        V(2);
        return ((j) this.f896e).n();
    }

    public com.google.crypto.tink.shaded.protobuf.h m() throws z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        V(2);
        return ((j) this.f896e).o();
    }

    public com.google.protobuf.l n() throws z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        V(2);
        return ((com.google.protobuf.o) this.f896e).j();
    }

    public void o(o2 o2Var) throws q2 {
        int iX;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if ((this.f893b & 7) != 2) {
            throw r2.c();
        }
        do {
            o2Var.add(n());
            if (oVar.e()) {
                return;
            } else {
                iX = oVar.x();
            }
        } while (iX == this.f893b);
        this.f895d = iX;
    }

    public void p(List list) throws z, com.google.crypto.tink.shaded.protobuf.a0 {
        int iC;
        int iC2;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                if ((this.f893b & 7) != 2) {
                    throw a0.b();
                }
                do {
                    list.add(l());
                    if (jVar.g()) {
                        return;
                    } else {
                        iC = jVar.C();
                    }
                } while (iC == this.f893b);
                this.f895d = iC;
                return;
            default:
                j jVar2 = (j) this.f896e;
                if ((this.f893b & 7) != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                do {
                    list.add(m());
                    if (jVar2.g()) {
                        return;
                    } else {
                        iC2 = jVar2.C();
                    }
                } while (iC2 == this.f893b);
                this.f895d = iC2;
                return;
        }
    }

    public void q(o2 o2Var) throws r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof com.google.protobuf.p1)) {
            int i2 = this.f893b & 7;
            if (i2 == 1) {
                do {
                    o2Var.add(Double.valueOf(oVar.k()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iY = oVar.y();
            a0(iY);
            int iD = oVar.d() + iY;
            do {
                o2Var.add(Double.valueOf(oVar.k()));
            } while (oVar.d() < iD);
            return;
        }
        com.google.protobuf.p1 p1Var = (com.google.protobuf.p1) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 1) {
            do {
                p1Var.addDouble(oVar.k());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iY2 = oVar.y();
        a0(iY2);
        int iD2 = oVar.d() + iY2;
        do {
            p1Var.addDouble(oVar.k());
        } while (oVar.d() < iD2);
    }

    public void r(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 1) {
                    do {
                        list.add(Double.valueOf(jVar.p()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iD = jVar.D();
                if ((iD & 7) != 0) {
                    throw new a0("Failed to parse the message.");
                }
                int iF = jVar.f() + iD;
                do {
                    list.add(Double.valueOf(jVar.p()));
                } while (jVar.f() < iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.l)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 1) {
                        do {
                            list.add(Double.valueOf(jVar2.p()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iD2 = jVar2.D();
                    Z(iD2);
                    int iF2 = jVar2.f() + iD2;
                    do {
                        list.add(Double.valueOf(jVar2.p()));
                    } while (jVar2.f() < iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.l lVar = (com.google.crypto.tink.shaded.protobuf.l) list;
                int i11 = this.f893b & 7;
                if (i11 == 1) {
                    do {
                        lVar.addDouble(jVar2.p());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iD3 = jVar2.D();
                Z(iD3);
                int iF3 = jVar2.f() + iD3;
                do {
                    lVar.addDouble(jVar2.p());
                } while (jVar2.f() < iF3);
                return;
        }
    }

    public void s(o2 o2Var) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof j2)) {
            int i2 = this.f893b & 7;
            if (i2 == 0) {
                do {
                    o2Var.add(Integer.valueOf(oVar.l()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iD = oVar.d() + oVar.y();
            do {
                o2Var.add(Integer.valueOf(oVar.l()));
            } while (oVar.d() < iD);
            U(iD);
            return;
        }
        j2 j2Var = (j2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 0) {
            do {
                j2Var.addInt(oVar.l());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iD2 = oVar.d() + oVar.y();
        do {
            j2Var.addInt(oVar.l());
        } while (oVar.d() < iD2);
        U(iD2);
    }

    public void t(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0, r2 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 0) {
                    do {
                        list.add(Integer.valueOf(jVar.q()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iF = jVar.f() + jVar.D();
                do {
                    list.add(Integer.valueOf(jVar.q()));
                } while (jVar.f() < iF);
                U(iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.w)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 0) {
                        do {
                            list.add(Integer.valueOf(jVar2.q()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iF2 = jVar2.f() + jVar2.D();
                    do {
                        list.add(Integer.valueOf(jVar2.q()));
                    } while (jVar2.f() < iF2);
                    U(iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.w wVar = (com.google.crypto.tink.shaded.protobuf.w) list;
                int i11 = this.f893b & 7;
                if (i11 == 0) {
                    do {
                        wVar.addInt(jVar2.q());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iF3 = jVar2.f() + jVar2.D();
                do {
                    wVar.addInt(jVar2.q());
                } while (jVar2.f() < iF3);
                U(iF3);
                return;
        }
    }

    public Object u(a2 a2Var, Class cls, o oVar) throws a0, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        j jVar = (j) this.f896e;
        switch (a2Var.ordinal()) {
            case 0:
                V(1);
                return Double.valueOf(jVar.p());
            case 1:
                V(5);
                return Float.valueOf(jVar.t());
            case 2:
                V(0);
                return Long.valueOf(jVar.v());
            case 3:
                V(0);
                return Long.valueOf(jVar.E());
            case 4:
                V(0);
                return Integer.valueOf(jVar.u());
            case 5:
                V(1);
                return Long.valueOf(jVar.s());
            case 6:
                V(5);
                return Integer.valueOf(jVar.r());
            case 7:
                V(0);
                return Boolean.valueOf(jVar.m());
            case 8:
                V(2);
                return jVar.B();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                V(2);
                z0 z0VarA = w0.f962c.a(cls);
                w wVarD = z0VarA.d();
                g(wVarD, z0VarA, oVar);
                z0VarA.b(wVarD);
                return wVarD;
            case 11:
                return l();
            case 12:
                V(0);
                return Integer.valueOf(jVar.D());
            case 13:
                V(0);
                return Integer.valueOf(jVar.q());
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                V(5);
                return Integer.valueOf(jVar.w());
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                V(1);
                return Long.valueOf(jVar.x());
            case 16:
                V(0);
                return Integer.valueOf(jVar.y());
            case 17:
                V(0);
                return Long.valueOf(jVar.z());
        }
    }

    public Object v(s4 s4Var, Class cls, com.google.protobuf.u1 u1Var) throws z, com.google.crypto.tink.shaded.protobuf.a0, r2 {
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        switch (s4Var.ordinal()) {
            case 0:
                V(1);
                return Double.valueOf(oVar.k());
            case 1:
                V(5);
                return Float.valueOf(oVar.o());
            case 2:
                V(0);
                return Long.valueOf(oVar.q());
            case 3:
                V(0);
                return Long.valueOf(oVar.z());
            case 4:
                V(0);
                return Integer.valueOf(oVar.p());
            case 5:
                V(1);
                return Long.valueOf(oVar.n());
            case 6:
                V(5);
                return Integer.valueOf(oVar.m());
            case 7:
                V(0);
                return Boolean.valueOf(oVar.i());
            case 8:
                V(2);
                return oVar.w();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                V(2);
                t3 t3VarA = q3.f2501c.a(cls);
                Object objD = t3VarA.d();
                i(objD, t3VarA, u1Var);
                t3VarA.b(objD);
                return objD;
            case 11:
                return n();
            case 12:
                V(0);
                return Integer.valueOf(oVar.y());
            case 13:
                V(0);
                return Integer.valueOf(oVar.l());
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                V(5);
                return Integer.valueOf(oVar.r());
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                V(1);
                return Long.valueOf(oVar.s());
            case 16:
                V(0);
                return Integer.valueOf(oVar.t());
            case 17:
                V(0);
                return Long.valueOf(oVar.u());
        }
    }

    public void w(o2 o2Var) throws r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof j2)) {
            int i2 = this.f893b & 7;
            if (i2 == 2) {
                int iY = oVar.y();
                Y(iY);
                int iD = oVar.d() + iY;
                do {
                    o2Var.add(Integer.valueOf(oVar.m()));
                } while (oVar.d() < iD);
                return;
            }
            if (i2 != 5) {
                throw r2.c();
            }
            do {
                o2Var.add(Integer.valueOf(oVar.m()));
                if (oVar.e()) {
                    return;
                } else {
                    iX = oVar.x();
                }
            } while (iX == this.f893b);
            this.f895d = iX;
            return;
        }
        j2 j2Var = (j2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 2) {
            int iY2 = oVar.y();
            Y(iY2);
            int iD2 = oVar.d() + iY2;
            do {
                j2Var.addInt(oVar.m());
            } while (oVar.d() < iD2);
            return;
        }
        if (i10 != 5) {
            throw r2.c();
        }
        do {
            j2Var.addInt(oVar.m());
            if (oVar.e()) {
                return;
            } else {
                iX2 = oVar.x();
            }
        } while (iX2 == this.f893b);
        this.f895d = iX2;
    }

    public void x(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 2) {
                    int iD = jVar.D();
                    if ((iD & 3) != 0) {
                        throw new a0("Failed to parse the message.");
                    }
                    int iF = jVar.f() + iD;
                    do {
                        list.add(Integer.valueOf(jVar.r()));
                    } while (jVar.f() < iF);
                    return;
                }
                if (i2 != 5) {
                    throw a0.b();
                }
                do {
                    list.add(Integer.valueOf(jVar.r()));
                    if (jVar.g()) {
                        return;
                    } else {
                        iC = jVar.C();
                    }
                } while (iC == this.f893b);
                this.f895d = iC;
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.w)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 2) {
                        int iD2 = jVar2.D();
                        X(iD2);
                        int iF2 = jVar2.f() + iD2;
                        do {
                            list.add(Integer.valueOf(jVar2.r()));
                        } while (jVar2.f() < iF2);
                        return;
                    }
                    if (i10 != 5) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    do {
                        list.add(Integer.valueOf(jVar2.r()));
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC2 = jVar2.C();
                        }
                    } while (iC2 == this.f893b);
                    this.f895d = iC2;
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.w wVar = (com.google.crypto.tink.shaded.protobuf.w) list;
                int i11 = this.f893b & 7;
                if (i11 == 2) {
                    int iD3 = jVar2.D();
                    X(iD3);
                    int iF3 = jVar2.f() + iD3;
                    do {
                        wVar.addInt(jVar2.r());
                    } while (jVar2.f() < iF3);
                    return;
                }
                if (i11 != 5) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                do {
                    wVar.addInt(jVar2.r());
                    if (jVar2.g()) {
                        return;
                    } else {
                        iC3 = jVar2.C();
                    }
                } while (iC3 == this.f893b);
                this.f895d = iC3;
                return;
        }
    }

    public void y(o2 o2Var) throws r2 {
        int iX;
        int iX2;
        com.google.protobuf.o oVar = (com.google.protobuf.o) this.f896e;
        if (!(o2Var instanceof x2)) {
            int i2 = this.f893b & 7;
            if (i2 == 1) {
                do {
                    o2Var.add(Long.valueOf(oVar.n()));
                    if (oVar.e()) {
                        return;
                    } else {
                        iX = oVar.x();
                    }
                } while (iX == this.f893b);
                this.f895d = iX;
                return;
            }
            if (i2 != 2) {
                throw r2.c();
            }
            int iY = oVar.y();
            a0(iY);
            int iD = oVar.d() + iY;
            do {
                o2Var.add(Long.valueOf(oVar.n()));
            } while (oVar.d() < iD);
            return;
        }
        x2 x2Var = (x2) o2Var;
        int i10 = this.f893b & 7;
        if (i10 == 1) {
            do {
                x2Var.addLong(oVar.n());
                if (oVar.e()) {
                    return;
                } else {
                    iX2 = oVar.x();
                }
            } while (iX2 == this.f893b);
            this.f895d = iX2;
            return;
        }
        if (i10 != 2) {
            throw r2.c();
        }
        int iY2 = oVar.y();
        a0(iY2);
        int iD2 = oVar.d() + iY2;
        do {
            x2Var.addLong(oVar.n());
        } while (oVar.d() < iD2);
    }

    public void z(List list) throws com.google.crypto.tink.shaded.protobuf.b0, a0 {
        int iC;
        int iC2;
        int iC3;
        switch (this.f892a) {
            case 0:
                j jVar = (j) this.f896e;
                int i2 = this.f893b & 7;
                if (i2 == 1) {
                    do {
                        list.add(Long.valueOf(jVar.s()));
                        if (jVar.g()) {
                            return;
                        } else {
                            iC = jVar.C();
                        }
                    } while (iC == this.f893b);
                    this.f895d = iC;
                    return;
                }
                if (i2 != 2) {
                    throw a0.b();
                }
                int iD = jVar.D();
                if ((iD & 7) != 0) {
                    throw new a0("Failed to parse the message.");
                }
                int iF = jVar.f() + iD;
                do {
                    list.add(Long.valueOf(jVar.s()));
                } while (jVar.f() < iF);
                return;
            default:
                j jVar2 = (j) this.f896e;
                if (!(list instanceof com.google.crypto.tink.shaded.protobuf.i0)) {
                    int i10 = this.f893b & 7;
                    if (i10 == 1) {
                        do {
                            list.add(Long.valueOf(jVar2.s()));
                            if (jVar2.g()) {
                                return;
                            } else {
                                iC2 = jVar2.C();
                            }
                        } while (iC2 == this.f893b);
                        this.f895d = iC2;
                        return;
                    }
                    if (i10 != 2) {
                        throw com.google.crypto.tink.shaded.protobuf.b0.c();
                    }
                    int iD2 = jVar2.D();
                    Z(iD2);
                    int iF2 = jVar2.f() + iD2;
                    do {
                        list.add(Long.valueOf(jVar2.s()));
                    } while (jVar2.f() < iF2);
                    return;
                }
                com.google.crypto.tink.shaded.protobuf.i0 i0Var = (com.google.crypto.tink.shaded.protobuf.i0) list;
                int i11 = this.f893b & 7;
                if (i11 == 1) {
                    do {
                        i0Var.addLong(jVar2.s());
                        if (jVar2.g()) {
                            return;
                        } else {
                            iC3 = jVar2.C();
                        }
                    } while (iC3 == this.f893b);
                    this.f895d = iC3;
                    return;
                }
                if (i11 != 2) {
                    throw com.google.crypto.tink.shaded.protobuf.b0.c();
                }
                int iD3 = jVar2.D();
                Z(iD3);
                int iF3 = jVar2.f() + iD3;
                do {
                    i0Var.addLong(jVar2.s());
                } while (jVar2.f() < iF3);
                return;
        }
    }

    public k(j jVar) {
        this.f892a = 0;
        this.f895d = 0;
        Charset charset = y.f968a;
        this.f896e = jVar;
        jVar.f882b = this;
    }

    public k(j jVar, byte b10) {
        this.f892a = 2;
        this.f895d = 0;
        com.google.crypto.tink.shaded.protobuf.z.a(jVar, "input");
        this.f896e = jVar;
        jVar.f882b = this;
    }

    public k(c0.i0 i0Var) {
        this.f892a = 1;
        this.f896e = i0Var;
    }
}
