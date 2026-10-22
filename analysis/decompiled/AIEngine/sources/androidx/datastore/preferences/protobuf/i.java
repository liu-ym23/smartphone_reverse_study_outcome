package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final h f1840a;

    /* renamed from: b, reason: collision with root package name */
    public int f1841b;

    /* renamed from: c, reason: collision with root package name */
    public int f1842c;

    /* renamed from: d, reason: collision with root package name */
    public int f1843d = 0;

    public i(h hVar) {
        u.a(hVar, "input");
        this.f1840a = hVar;
        hVar.f1826d = this;
    }

    public static void T(int i10) throws InvalidProtocolBufferException {
        if ((i10 & 3) != 0) {
            throw InvalidProtocolBufferException.e();
        }
    }

    public static void U(int i10) throws InvalidProtocolBufferException {
        if ((i10 & 7) != 0) {
            throw InvalidProtocolBufferException.e();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void A(List<Integer> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof t;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 2) {
                int iW = hVar.w();
                T(iW);
                int iC = hVar.c() + iW;
                do {
                    list.add(Integer.valueOf(hVar.k()));
                } while (hVar.c() < iC);
                return;
            }
            if (i10 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                list.add(Integer.valueOf(hVar.k()));
                if (hVar.d()) {
                    return;
                } else {
                    iV = hVar.v();
                }
            } while (iV == this.f1841b);
            this.f1843d = iV;
            return;
        }
        t tVar = (t) list;
        int i11 = this.f1841b & 7;
        if (i11 == 2) {
            int iW2 = hVar.w();
            T(iW2);
            int iC2 = hVar.c() + iW2;
            do {
                tVar.b(hVar.k());
            } while (hVar.c() < iC2);
            return;
        }
        if (i11 != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            tVar.b(hVar.k());
            if (hVar.d()) {
                return;
            } else {
                iV2 = hVar.v();
            }
        } while (iV2 == this.f1841b);
        this.f1843d = iV2;
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final long B() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(0);
        return this.f1840a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final String C() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(2);
        return this.f1840a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final int D() {
        int i10 = this.f1843d;
        if (i10 != 0) {
            this.f1841b = i10;
            this.f1843d = 0;
        } else {
            this.f1841b = this.f1840a.v();
        }
        int i11 = this.f1841b;
        if (i11 == 0 || i11 == this.f1842c) {
            return Integer.MAX_VALUE;
        }
        return i11 >>> 3;
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void E(List<String> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        Q(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void F(List<Float> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof r;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 2) {
                int iW = hVar.w();
                T(iW);
                int iC = hVar.c() + iW;
                do {
                    list.add(Float.valueOf(hVar.m()));
                } while (hVar.c() < iC);
                return;
            }
            if (i10 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                list.add(Float.valueOf(hVar.m()));
                if (hVar.d()) {
                    return;
                } else {
                    iV = hVar.v();
                }
            } while (iV == this.f1841b);
            this.f1843d = iV;
            return;
        }
        r rVar = (r) list;
        int i11 = this.f1841b & 7;
        if (i11 == 2) {
            int iW2 = hVar.w();
            T(iW2);
            int iC2 = hVar.c() + iW2;
            do {
                rVar.b(hVar.m());
            } while (hVar.c() < iC2);
            return;
        }
        if (i11 != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            rVar.b(hVar.m());
            if (hVar.d()) {
                return;
            } else {
                iV2 = hVar.v();
            }
        } while (iV2 == this.f1841b);
        this.f1843d = iV2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.v0
    public final <T> void G(List<T> list, w0<T> w0Var, m mVar) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iV;
        int i10 = this.f1841b;
        if ((i10 & 7) != 3) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            list.add(O(w0Var, mVar));
            h hVar = this.f1840a;
            if (hVar.d() || this.f1843d != 0) {
                return;
            } else {
                iV = hVar.v();
            }
        } while (iV == i10);
        this.f1843d = iV;
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final boolean H() {
        int i10;
        h hVar = this.f1840a;
        if (hVar.d() || (i10 = this.f1841b) == this.f1842c) {
            return false;
        }
        return hVar.y(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final int I() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(5);
        return this.f1840a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void J(List<ByteString> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iV;
        if ((this.f1841b & 7) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            list.add(o());
            h hVar = this.f1840a;
            if (hVar.d()) {
                return;
            } else {
                iV = hVar.v();
            }
        } while (iV == this.f1841b);
        this.f1843d = iV;
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void K(List<Double> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof k;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 1) {
                do {
                    list.add(Double.valueOf(hVar.i()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iW = hVar.w();
            U(iW);
            int iC = hVar.c() + iW;
            do {
                list.add(Double.valueOf(hVar.i()));
            } while (hVar.c() < iC);
            return;
        }
        k kVar = (k) list;
        int i11 = this.f1841b & 7;
        if (i11 == 1) {
            do {
                kVar.b(hVar.i());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iW2 = hVar.w();
        U(iW2);
        int iC2 = hVar.c() + iW2;
        do {
            kVar.b(hVar.i());
        } while (hVar.c() < iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final long L() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(0);
        return this.f1840a.o();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final String M() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(2);
        return this.f1840a.u();
    }

    public final Object N(WireFormat$FieldType wireFormat$FieldType, Class<?> cls, m mVar) throws InvalidProtocolBufferException.InvalidWireTypeException {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                return Double.valueOf(readDouble());
            case 1:
                return Float.valueOf(readFloat());
            case 2:
                return Long.valueOf(L());
            case 3:
                return Long.valueOf(u());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Long.valueOf(b());
            case 6:
                return Integer.valueOf(w());
            case 7:
                return Boolean.valueOf(e());
            case 8:
                return M();
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                S(2);
                return P(s0.f1880c.a(cls), mVar);
            case 11:
                return o();
            case 12:
                return Integer.valueOf(h());
            case 13:
                return Integer.valueOf(k());
            case 14:
                return Integer.valueOf(I());
            case 15:
                return Long.valueOf(f());
            case 16:
                return Integer.valueOf(l());
            case 17:
                return Long.valueOf(B());
        }
    }

    public final <T> T O(w0<T> w0Var, m mVar) {
        int i10 = this.f1842c;
        this.f1842c = ((this.f1841b >>> 3) << 3) | 4;
        try {
            T tE = w0Var.e();
            w0Var.a(tE, this, mVar);
            w0Var.b(tE);
            if (this.f1841b == this.f1842c) {
                return tE;
            }
            throw InvalidProtocolBufferException.e();
        } finally {
            this.f1842c = i10;
        }
    }

    public final <T> T P(w0<T> w0Var, m mVar) throws InvalidProtocolBufferException {
        h hVar = this.f1840a;
        int iW = hVar.w();
        if (hVar.f1823a >= hVar.f1824b) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iF = hVar.f(iW);
        T tE = w0Var.e();
        hVar.f1823a++;
        w0Var.a(tE, this, mVar);
        w0Var.b(tE);
        hVar.a(0);
        hVar.f1823a--;
        hVar.e(iF);
        return tE;
    }

    public final void Q(List<String> list, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iV;
        int iV2;
        if ((this.f1841b & 7) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        boolean z3 = list instanceof y;
        h hVar = this.f1840a;
        if (!z3 || z) {
            do {
                list.add(z ? M() : C());
                if (hVar.d()) {
                    return;
                } else {
                    iV = hVar.v();
                }
            } while (iV == this.f1841b);
            this.f1843d = iV;
            return;
        }
        y yVar = (y) list;
        do {
            yVar.g0(o());
            if (hVar.d()) {
                return;
            } else {
                iV2 = hVar.v();
            }
        } while (iV2 == this.f1841b);
        this.f1843d = iV2;
    }

    public final void R(int i10) throws InvalidProtocolBufferException {
        if (this.f1840a.c() != i10) {
            throw InvalidProtocolBufferException.f();
        }
    }

    public final void S(int i10) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if ((this.f1841b & 7) != i10) {
            throw InvalidProtocolBufferException.b();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final <T> T a(w0<T> w0Var, m mVar) throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(2);
        return (T) P(w0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final long b() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(1);
        return this.f1840a.l();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void c(List<Integer> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof t;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 2) {
                int iW = hVar.w();
                T(iW);
                int iC = hVar.c() + iW;
                do {
                    list.add(Integer.valueOf(hVar.p()));
                } while (hVar.c() < iC);
                return;
            }
            if (i10 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                list.add(Integer.valueOf(hVar.p()));
                if (hVar.d()) {
                    return;
                } else {
                    iV = hVar.v();
                }
            } while (iV == this.f1841b);
            this.f1843d = iV;
            return;
        }
        t tVar = (t) list;
        int i11 = this.f1841b & 7;
        if (i11 == 2) {
            int iW2 = hVar.w();
            T(iW2);
            int iC2 = hVar.c() + iW2;
            do {
                tVar.b(hVar.p());
            } while (hVar.c() < iC2);
            return;
        }
        if (i11 != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            tVar.b(hVar.p());
            if (hVar.d()) {
                return;
            } else {
                iV2 = hVar.v();
            }
        } while (iV2 == this.f1841b);
        this.f1843d = iV2;
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void d(List<Long> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof a0;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 0) {
                do {
                    list.add(Long.valueOf(hVar.s()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iC = hVar.c() + hVar.w();
            do {
                list.add(Long.valueOf(hVar.s()));
            } while (hVar.c() < iC);
            R(iC);
            return;
        }
        a0 a0Var = (a0) list;
        int i11 = this.f1841b & 7;
        if (i11 == 0) {
            do {
                a0Var.b(hVar.s());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iC2 = hVar.c() + hVar.w();
        do {
            a0Var.b(hVar.s());
        } while (hVar.c() < iC2);
        R(iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final boolean e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(0);
        return this.f1840a.g();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final long f() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(1);
        return this.f1840a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void g(List<Long> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof a0;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 0) {
                do {
                    list.add(Long.valueOf(hVar.x()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iC = hVar.c() + hVar.w();
            do {
                list.add(Long.valueOf(hVar.x()));
            } while (hVar.c() < iC);
            R(iC);
            return;
        }
        a0 a0Var = (a0) list;
        int i11 = this.f1841b & 7;
        if (i11 == 0) {
            do {
                a0Var.b(hVar.x());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iC2 = hVar.c() + hVar.w();
        do {
            a0Var.b(hVar.x());
        } while (hVar.c() < iC2);
        R(iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final int getTag() {
        return this.f1841b;
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final int h() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(0);
        return this.f1840a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void i(List<Long> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof a0;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 0) {
                do {
                    list.add(Long.valueOf(hVar.o()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iC = hVar.c() + hVar.w();
            do {
                list.add(Long.valueOf(hVar.o()));
            } while (hVar.c() < iC);
            R(iC);
            return;
        }
        a0 a0Var = (a0) list;
        int i11 = this.f1841b & 7;
        if (i11 == 0) {
            do {
                a0Var.b(hVar.o());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iC2 = hVar.c() + hVar.w();
        do {
            a0Var.b(hVar.o());
        } while (hVar.c() < iC2);
        R(iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void j(List<Integer> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof t;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 0) {
                do {
                    list.add(Integer.valueOf(hVar.j()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iC = hVar.c() + hVar.w();
            do {
                list.add(Integer.valueOf(hVar.j()));
            } while (hVar.c() < iC);
            R(iC);
            return;
        }
        t tVar = (t) list;
        int i11 = this.f1841b & 7;
        if (i11 == 0) {
            do {
                tVar.b(hVar.j());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iC2 = hVar.c() + hVar.w();
        do {
            tVar.b(hVar.j());
        } while (hVar.c() < iC2);
        R(iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(0);
        return this.f1840a.j();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final int l() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(0);
        return this.f1840a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void m(List<Boolean> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof e;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 0) {
                do {
                    list.add(Boolean.valueOf(hVar.g()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iC = hVar.c() + hVar.w();
            do {
                list.add(Boolean.valueOf(hVar.g()));
            } while (hVar.c() < iC);
            R(iC);
            return;
        }
        e eVar = (e) list;
        int i11 = this.f1841b & 7;
        if (i11 == 0) {
            do {
                eVar.b(hVar.g());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iC2 = hVar.c() + hVar.w();
        do {
            eVar.b(hVar.g());
        } while (hVar.c() < iC2);
        R(iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void n(List<String> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        Q(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final ByteString o() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(2);
        return this.f1840a.h();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final int p() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(0);
        return this.f1840a.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.v0
    public final <T> void q(List<T> list, w0<T> w0Var, m mVar) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iV;
        int i10 = this.f1841b;
        if ((i10 & 7) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            list.add(P(w0Var, mVar));
            h hVar = this.f1840a;
            if (hVar.d() || this.f1843d != 0) {
                return;
            } else {
                iV = hVar.v();
            }
        } while (iV == i10);
        this.f1843d = iV;
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void r(List<Long> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof a0;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 1) {
                do {
                    list.add(Long.valueOf(hVar.l()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iW = hVar.w();
            U(iW);
            int iC = hVar.c() + iW;
            do {
                list.add(Long.valueOf(hVar.l()));
            } while (hVar.c() < iC);
            return;
        }
        a0 a0Var = (a0) list;
        int i11 = this.f1841b & 7;
        if (i11 == 1) {
            do {
                a0Var.b(hVar.l());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iW2 = hVar.w();
        U(iW2);
        int iC2 = hVar.c() + iW2;
        do {
            a0Var.b(hVar.l());
        } while (hVar.c() < iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(1);
        return this.f1840a.i();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(5);
        return this.f1840a.m();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final <T> T s(w0<T> w0Var, m mVar) throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(3);
        return (T) O(w0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void t(List<Integer> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof t;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 0) {
                do {
                    list.add(Integer.valueOf(hVar.r()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iC = hVar.c() + hVar.w();
            do {
                list.add(Integer.valueOf(hVar.r()));
            } while (hVar.c() < iC);
            R(iC);
            return;
        }
        t tVar = (t) list;
        int i11 = this.f1841b & 7;
        if (i11 == 0) {
            do {
                tVar.b(hVar.r());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iC2 = hVar.c() + hVar.w();
        do {
            tVar.b(hVar.r());
        } while (hVar.c() < iC2);
        R(iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final long u() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(0);
        return this.f1840a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void v(List<Integer> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof t;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 0) {
                do {
                    list.add(Integer.valueOf(hVar.w()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iC = hVar.c() + hVar.w();
            do {
                list.add(Integer.valueOf(hVar.w()));
            } while (hVar.c() < iC);
            R(iC);
            return;
        }
        t tVar = (t) list;
        int i11 = this.f1841b & 7;
        if (i11 == 0) {
            do {
                tVar.b(hVar.w());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iC2 = hVar.c() + hVar.w();
        do {
            tVar.b(hVar.w());
        } while (hVar.c() < iC2);
        R(iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final int w() throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(5);
        return this.f1840a.k();
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void x(List<Long> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof a0;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 1) {
                do {
                    list.add(Long.valueOf(hVar.q()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iW = hVar.w();
            U(iW);
            int iC = hVar.c() + iW;
            do {
                list.add(Long.valueOf(hVar.q()));
            } while (hVar.c() < iC);
            return;
        }
        a0 a0Var = (a0) list;
        int i11 = this.f1841b & 7;
        if (i11 == 1) {
            do {
                a0Var.b(hVar.q());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iW2 = hVar.w();
        U(iW2);
        int iC2 = hVar.c() + iW2;
        do {
            a0Var.b(hVar.q());
        } while (hVar.c() < iC2);
    }

    @Override // androidx.datastore.preferences.protobuf.v0
    public final void y(List<Integer> list) throws InvalidProtocolBufferException {
        int iV;
        int iV2;
        boolean z = list instanceof t;
        h hVar = this.f1840a;
        if (!z) {
            int i10 = this.f1841b & 7;
            if (i10 == 0) {
                do {
                    list.add(Integer.valueOf(hVar.n()));
                    if (hVar.d()) {
                        return;
                    } else {
                        iV = hVar.v();
                    }
                } while (iV == this.f1841b);
                this.f1843d = iV;
                return;
            }
            if (i10 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iC = hVar.c() + hVar.w();
            do {
                list.add(Integer.valueOf(hVar.n()));
            } while (hVar.c() < iC);
            R(iC);
            return;
        }
        t tVar = (t) list;
        int i11 = this.f1841b & 7;
        if (i11 == 0) {
            do {
                tVar.b(hVar.n());
                if (hVar.d()) {
                    return;
                } else {
                    iV2 = hVar.v();
                }
            } while (iV2 == this.f1841b);
            this.f1843d = iV2;
            return;
        }
        if (i11 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int iC2 = hVar.c() + hVar.w();
        do {
            tVar.b(hVar.n());
        } while (hVar.c() < iC2);
        R(iC2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r10.put(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r1.e(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.v0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, V> void z(java.util.Map<K, V> r10, androidx.datastore.preferences.protobuf.c0.a<K, V> r11, androidx.datastore.preferences.protobuf.m r12) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        /*
            r9 = this;
            r0 = 2
            r9.S(r0)
            androidx.datastore.preferences.protobuf.h r1 = r9.f1840a
            int r2 = r1.w()
            int r2 = r1.f(r2)
            r11.getClass()
            V r3 = r11.f1797c
            java.lang.String r4 = ""
            r5 = r3
        L16:
            int r6 = r9.D()     // Catch: java.lang.Throwable -> L3a
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r7) goto L5c
            boolean r7 = r1.d()     // Catch: java.lang.Throwable -> L3a
            if (r7 == 0) goto L26
            goto L5c
        L26:
            r7 = 1
            java.lang.String r8 = "Unable to parse map entry."
            if (r6 == r7) goto L47
            if (r6 == r0) goto L3c
            boolean r6 = r9.H()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            if (r6 == 0) goto L34
            goto L16
        L34:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r6 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            throw r6     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
        L3a:
            r9 = move-exception
            goto L63
        L3c:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = r11.f1796b     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            java.lang.Class r7 = r3.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            java.lang.Object r5 = r9.N(r6, r7, r12)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            goto L16
        L47:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = r11.f1795a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            r7 = 0
            java.lang.Object r4 = r9.N(r6, r7, r7)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            goto L16
        L4f:
            boolean r6 = r9.H()     // Catch: java.lang.Throwable -> L3a
            if (r6 == 0) goto L56
            goto L16
        L56:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L3a
            throw r9     // Catch: java.lang.Throwable -> L3a
        L5c:
            r10.put(r4, r5)     // Catch: java.lang.Throwable -> L3a
            r1.e(r2)
            return
        L63:
            r1.e(r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i.z(java.util.Map, androidx.datastore.preferences.protobuf.c0$a, androidx.datastore.preferences.protobuf.m):void");
    }
}
