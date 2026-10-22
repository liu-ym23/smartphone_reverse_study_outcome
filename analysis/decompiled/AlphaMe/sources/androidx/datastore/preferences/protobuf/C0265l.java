package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0265l implements InterfaceC0260h0 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0264k f3507a;

    /* renamed from: b, reason: collision with root package name */
    public int f3508b;

    /* renamed from: c, reason: collision with root package name */
    public int f3509c;

    /* renamed from: d, reason: collision with root package name */
    public int f3510d = 0;

    public C0265l(AbstractC0264k abstractC0264k) {
        Charset charset = D.f3396a;
        this.f3507a = abstractC0264k;
        abstractC0264k.f3499d = this;
    }

    public static void T(int i4) throws F {
        if ((i4 & 3) != 0) {
            throw F.e();
        }
    }

    public static void U(int i4) throws F {
        if ((i4 & 7) != 0) {
            throw F.e();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final int A() throws E {
        R(5);
        return this.f3507a.o();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void B(List list) throws E {
        int iU;
        if ((this.f3508b & 7) != 2) {
            throw F.b();
        }
        do {
            list.add(v());
            AbstractC0264k abstractC0264k = this.f3507a;
            if (abstractC0264k.c()) {
                return;
            } else {
                iU = abstractC0264k.u();
            }
        } while (iU == this.f3508b);
        this.f3510d = iU;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void C(List list) throws F {
        int iU;
        boolean z4 = list instanceof AbstractC0269p;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 1) {
                abstractC0264k.h();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            U(abstractC0264k.v());
            abstractC0264k.h();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 1) {
            do {
                list.add(Double.valueOf(abstractC0264k.h()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iV = abstractC0264k.v();
        U(iV);
        int iB = abstractC0264k.b() + iV;
        do {
            list.add(Double.valueOf(abstractC0264k.h()));
        } while (abstractC0264k.b() < iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void D(List list, InterfaceC0262i0 interfaceC0262i0, r rVar) throws E {
        int iU;
        int i4 = this.f3508b;
        if ((i4 & 7) != 2) {
            throw F.b();
        }
        do {
            list.add(O(interfaceC0262i0, rVar));
            AbstractC0264k abstractC0264k = this.f3507a;
            if (abstractC0264k.c() || this.f3510d != 0) {
                return;
            } else {
                iU = abstractC0264k.u();
            }
        } while (iU == i4);
        this.f3510d = iU;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void E(List list) throws F {
        int iU;
        boolean z4 = list instanceof M;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 0) {
                abstractC0264k.n();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            abstractC0264k.v();
            abstractC0264k.n();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 0) {
            do {
                list.add(Long.valueOf(abstractC0264k.n()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iB = abstractC0264k.b() + abstractC0264k.v();
        do {
            list.add(Long.valueOf(abstractC0264k.n()));
        } while (abstractC0264k.b() < iB);
        Q(iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void F(List list) throws F {
        int iU;
        boolean z4 = list instanceof M;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 1) {
                abstractC0264k.p();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            U(abstractC0264k.v());
            abstractC0264k.p();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 1) {
            do {
                list.add(Long.valueOf(abstractC0264k.p()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iV = abstractC0264k.v();
        U(iV);
        int iB = abstractC0264k.b() + iV;
        do {
            list.add(Long.valueOf(abstractC0264k.p()));
        } while (abstractC0264k.b() < iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final long G() throws E {
        R(0);
        return this.f3507a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final String H() throws E {
        R(2);
        return this.f3507a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void I(List list) throws F {
        int iU;
        boolean z4 = list instanceof M;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 1) {
                abstractC0264k.k();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            U(abstractC0264k.v());
            abstractC0264k.k();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 1) {
            do {
                list.add(Long.valueOf(abstractC0264k.k()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iV = abstractC0264k.v();
        U(iV);
        int iB = abstractC0264k.b() + iV;
        do {
            list.add(Long.valueOf(abstractC0264k.k()));
        } while (abstractC0264k.b() < iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void J(List list) throws F {
        int iU;
        boolean z4 = list instanceof B;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 0) {
                abstractC0264k.m();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            abstractC0264k.v();
            abstractC0264k.m();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 0) {
            do {
                list.add(Integer.valueOf(abstractC0264k.m()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iB = abstractC0264k.b() + abstractC0264k.v();
        do {
            list.add(Integer.valueOf(abstractC0264k.m()));
        } while (abstractC0264k.b() < iB);
        Q(iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void K(List list) throws F {
        int iU;
        boolean z4 = list instanceof B;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 0) {
                abstractC0264k.i();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            abstractC0264k.v();
            abstractC0264k.i();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 0) {
            do {
                list.add(Integer.valueOf(abstractC0264k.i()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iB = abstractC0264k.b() + abstractC0264k.v();
        do {
            list.add(Integer.valueOf(abstractC0264k.i()));
        } while (abstractC0264k.b() < iB);
        Q(iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final Object L(InterfaceC0262i0 interfaceC0262i0, r rVar) throws E {
        R(3);
        return N(interfaceC0262i0, rVar);
    }

    public final Object M(H0 h02, Class cls, r rVar) throws E {
        switch (h02.ordinal()) {
            case 0:
                return Double.valueOf(readDouble());
            case 1:
                return Float.valueOf(readFloat());
            case 2:
                return Long.valueOf(G());
            case 3:
                return Long.valueOf(e());
            case 4:
                return Integer.valueOf(y());
            case 5:
                return Long.valueOf(g());
            case 6:
                return Integer.valueOf(o());
            case 7:
                return Boolean.valueOf(p());
            case 8:
                return H();
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                R(2);
                return O(C0254e0.f3467c.a(cls), rVar);
            case 11:
                return v();
            case 12:
                return Integer.valueOf(x());
            case 13:
                return Integer.valueOf(c());
            case 14:
                return Integer.valueOf(A());
            case 15:
                return Long.valueOf(s());
            case 16:
                return Integer.valueOf(i());
            case 17:
                return Long.valueOf(k());
        }
    }

    public final Object N(InterfaceC0262i0 interfaceC0262i0, r rVar) {
        int i4 = this.f3509c;
        this.f3509c = ((this.f3508b >>> 3) << 3) | 4;
        try {
            Object objH = interfaceC0262i0.h();
            interfaceC0262i0.a(objH, this, rVar);
            interfaceC0262i0.d(objH);
            if (this.f3508b == this.f3509c) {
                return objH;
            }
            throw F.e();
        } finally {
            this.f3509c = i4;
        }
    }

    public final Object O(InterfaceC0262i0 interfaceC0262i0, r rVar) throws F {
        AbstractC0264k abstractC0264k = this.f3507a;
        int iV = abstractC0264k.v();
        if (abstractC0264k.f3496a >= abstractC0264k.f3497b) {
            throw new F("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iE = abstractC0264k.e(iV);
        Object objH = interfaceC0262i0.h();
        abstractC0264k.f3496a++;
        interfaceC0262i0.a(objH, this, rVar);
        interfaceC0262i0.d(objH);
        abstractC0264k.a(0);
        abstractC0264k.f3496a--;
        abstractC0264k.d(iE);
        return objH;
    }

    public final void P(List list, boolean z4) throws E {
        int iU;
        int iU2;
        if ((this.f3508b & 7) != 2) {
            throw F.b();
        }
        boolean z5 = list instanceof I;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (!z5 || z4) {
            do {
                list.add(z4 ? H() : n());
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        I i4 = (I) list;
        do {
            i4.l(v());
            if (abstractC0264k.c()) {
                return;
            } else {
                iU2 = abstractC0264k.u();
            }
        } while (iU2 == this.f3508b);
        this.f3510d = iU2;
    }

    public final void Q(int i4) throws F {
        if (this.f3507a.b() != i4) {
            throw F.f();
        }
    }

    public final void R(int i4) throws E {
        if ((this.f3508b & 7) != i4) {
            throw F.b();
        }
    }

    public final boolean S() {
        int i4;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (abstractC0264k.c() || (i4 = this.f3508b) == this.f3509c) {
            return false;
        }
        return abstractC0264k.x(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final Object a(InterfaceC0262i0 interfaceC0262i0, r rVar) throws E {
        R(2);
        return O(interfaceC0262i0, rVar);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void b(List list) throws F {
        int iU;
        boolean z4 = list instanceof B;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 0) {
                abstractC0264k.q();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            abstractC0264k.v();
            abstractC0264k.q();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 0) {
            do {
                list.add(Integer.valueOf(abstractC0264k.q()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iB = abstractC0264k.b() + abstractC0264k.v();
        do {
            list.add(Integer.valueOf(abstractC0264k.q()));
        } while (abstractC0264k.b() < iB);
        Q(iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final int c() throws E {
        R(0);
        return this.f3507a.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r9.put(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r1.d(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(androidx.datastore.preferences.protobuf.S r9, t.d r10, androidx.datastore.preferences.protobuf.r r11) throws androidx.datastore.preferences.protobuf.E {
        /*
            r8 = this;
            r0 = 2
            r8.R(r0)
            androidx.datastore.preferences.protobuf.k r1 = r8.f3507a
            int r2 = r1.v()
            int r2 = r1.e(r2)
            java.lang.Object r3 = r10.f15274b
            java.lang.Object r4 = r10.f15276d
        L12:
            int r5 = r8.q()     // Catch: java.lang.Throwable -> L36
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r5 == r6) goto L5e
            boolean r6 = r1.c()     // Catch: java.lang.Throwable -> L36
            if (r6 == 0) goto L22
            goto L5e
        L22:
            r6 = 1
            java.lang.String r7 = "Unable to parse map entry."
            if (r5 == r6) goto L47
            if (r5 == r0) goto L38
            boolean r5 = r8.S()     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            if (r5 == 0) goto L30
            goto L12
        L30:
            androidx.datastore.preferences.protobuf.F r5 = new androidx.datastore.preferences.protobuf.F     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            throw r5     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
        L36:
            r8 = move-exception
            goto L65
        L38:
            java.lang.Object r5 = r10.f15275c     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            androidx.datastore.preferences.protobuf.H0 r5 = (androidx.datastore.preferences.protobuf.H0) r5     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            java.lang.Object r6 = r10.f15276d     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            java.lang.Class r6 = r6.getClass()     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            java.lang.Object r4 = r8.M(r5, r6, r11)     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            goto L12
        L47:
            java.lang.Object r5 = r10.f15273a     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            androidx.datastore.preferences.protobuf.H0 r5 = (androidx.datastore.preferences.protobuf.H0) r5     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            r6 = 0
            java.lang.Object r3 = r8.M(r5, r6, r6)     // Catch: java.lang.Throwable -> L36 androidx.datastore.preferences.protobuf.E -> L51
            goto L12
        L51:
            boolean r5 = r8.S()     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L58
            goto L12
        L58:
            androidx.datastore.preferences.protobuf.F r8 = new androidx.datastore.preferences.protobuf.F     // Catch: java.lang.Throwable -> L36
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L36
            throw r8     // Catch: java.lang.Throwable -> L36
        L5e:
            r9.put(r3, r4)     // Catch: java.lang.Throwable -> L36
            r1.d(r2)
            return
        L65:
            r1.d(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0265l.d(androidx.datastore.preferences.protobuf.S, t.d, androidx.datastore.preferences.protobuf.r):void");
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final long e() throws E {
        R(0);
        return this.f3507a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void f(List list) throws F {
        int iU;
        boolean z4 = list instanceof B;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 2) {
                T(abstractC0264k.v());
                abstractC0264k.j();
                throw null;
            }
            if (i4 != 5) {
                throw F.b();
            }
            abstractC0264k.j();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 2) {
            int iV = abstractC0264k.v();
            T(iV);
            int iB = abstractC0264k.b() + iV;
            do {
                list.add(Integer.valueOf(abstractC0264k.j()));
            } while (abstractC0264k.b() < iB);
            return;
        }
        if (i5 != 5) {
            throw F.b();
        }
        do {
            list.add(Integer.valueOf(abstractC0264k.j()));
            if (abstractC0264k.c()) {
                return;
            } else {
                iU = abstractC0264k.u();
            }
        } while (iU == this.f3508b);
        this.f3510d = iU;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final long g() throws E {
        R(1);
        return this.f3507a.k();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final int getTag() {
        return this.f3508b;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void h(List list) throws F {
        int iU;
        boolean z4 = list instanceof B;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 2) {
                T(abstractC0264k.v());
                abstractC0264k.o();
                throw null;
            }
            if (i4 != 5) {
                throw F.b();
            }
            abstractC0264k.o();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 2) {
            int iV = abstractC0264k.v();
            T(iV);
            int iB = abstractC0264k.b() + iV;
            do {
                list.add(Integer.valueOf(abstractC0264k.o()));
            } while (abstractC0264k.b() < iB);
            return;
        }
        if (i5 != 5) {
            throw F.b();
        }
        do {
            list.add(Integer.valueOf(abstractC0264k.o()));
            if (abstractC0264k.c()) {
                return;
            } else {
                iU = abstractC0264k.u();
            }
        } while (iU == this.f3508b);
        this.f3510d = iU;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final int i() throws E {
        R(0);
        return this.f3507a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void j(List list) throws F {
        int iU;
        boolean z4 = list instanceof M;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 0) {
                abstractC0264k.r();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            abstractC0264k.v();
            abstractC0264k.r();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 0) {
            do {
                list.add(Long.valueOf(abstractC0264k.r()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iB = abstractC0264k.b() + abstractC0264k.v();
        do {
            list.add(Long.valueOf(abstractC0264k.r()));
        } while (abstractC0264k.b() < iB);
        Q(iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final long k() throws E {
        R(0);
        return this.f3507a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void l(List list) throws F {
        int iU;
        boolean z4 = list instanceof B;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 0) {
                abstractC0264k.v();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            abstractC0264k.v();
            abstractC0264k.v();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 0) {
            do {
                list.add(Integer.valueOf(abstractC0264k.v()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iB = abstractC0264k.b() + abstractC0264k.v();
        do {
            list.add(Integer.valueOf(abstractC0264k.v()));
        } while (abstractC0264k.b() < iB);
        Q(iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void m(List list) throws F {
        int iU;
        boolean z4 = list instanceof AbstractC0253e;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 0) {
                abstractC0264k.f();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            abstractC0264k.v();
            abstractC0264k.f();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 0) {
            do {
                list.add(Boolean.valueOf(abstractC0264k.f()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iB = abstractC0264k.b() + abstractC0264k.v();
        do {
            list.add(Boolean.valueOf(abstractC0264k.f()));
        } while (abstractC0264k.b() < iB);
        Q(iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final String n() throws E {
        R(2);
        return this.f3507a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final int o() throws E {
        R(5);
        return this.f3507a.j();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final boolean p() throws E {
        R(0);
        return this.f3507a.f();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final int q() {
        int i4 = this.f3510d;
        if (i4 != 0) {
            this.f3508b = i4;
            this.f3510d = 0;
        } else {
            this.f3508b = this.f3507a.u();
        }
        int i5 = this.f3508b;
        if (i5 == 0 || i5 == this.f3509c) {
            return Integer.MAX_VALUE;
        }
        return i5 >>> 3;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void r(List list) throws E {
        P(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final double readDouble() throws E {
        R(1);
        return this.f3507a.h();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final float readFloat() throws E {
        R(5);
        return this.f3507a.l();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final long s() throws E {
        R(1);
        return this.f3507a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void t(List list) throws F {
        int iU;
        boolean z4 = list instanceof M;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 0) {
                abstractC0264k.w();
                throw null;
            }
            if (i4 != 2) {
                throw F.b();
            }
            abstractC0264k.v();
            abstractC0264k.w();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 0) {
            do {
                list.add(Long.valueOf(abstractC0264k.w()));
                if (abstractC0264k.c()) {
                    return;
                } else {
                    iU = abstractC0264k.u();
                }
            } while (iU == this.f3508b);
            this.f3510d = iU;
            return;
        }
        if (i5 != 2) {
            throw F.b();
        }
        int iB = abstractC0264k.b() + abstractC0264k.v();
        do {
            list.add(Long.valueOf(abstractC0264k.w()));
        } while (abstractC0264k.b() < iB);
        Q(iB);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void u(List list) throws E {
        P(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final AbstractC0259h v() throws E {
        R(2);
        return this.f3507a.g();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void w(List list) throws F {
        int iU;
        boolean z4 = list instanceof AbstractC0275w;
        AbstractC0264k abstractC0264k = this.f3507a;
        if (z4) {
            int i4 = this.f3508b & 7;
            if (i4 == 2) {
                T(abstractC0264k.v());
                abstractC0264k.l();
                throw null;
            }
            if (i4 != 5) {
                throw F.b();
            }
            abstractC0264k.l();
            throw null;
        }
        int i5 = this.f3508b & 7;
        if (i5 == 2) {
            int iV = abstractC0264k.v();
            T(iV);
            int iB = abstractC0264k.b() + iV;
            do {
                list.add(Float.valueOf(abstractC0264k.l()));
            } while (abstractC0264k.b() < iB);
            return;
        }
        if (i5 != 5) {
            throw F.b();
        }
        do {
            list.add(Float.valueOf(abstractC0264k.l()));
            if (abstractC0264k.c()) {
                return;
            } else {
                iU = abstractC0264k.u();
            }
        } while (iU == this.f3508b);
        this.f3510d = iU;
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final int x() throws E {
        R(0);
        return this.f3507a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final int y() throws E {
        R(0);
        return this.f3507a.m();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0260h0
    public final void z(List list, InterfaceC0262i0 interfaceC0262i0, r rVar) throws E {
        int iU;
        int i4 = this.f3508b;
        if ((i4 & 7) != 3) {
            throw F.b();
        }
        do {
            list.add(N(interfaceC0262i0, rVar));
            AbstractC0264k abstractC0264k = this.f3507a;
            if (abstractC0264k.c() || this.f3510d != 0) {
                return;
            } else {
                iU = abstractC0264k.u();
            }
        } while (iU == i4);
        this.f3510d = iU;
    }
}
