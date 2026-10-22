package k0;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f7151a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final l0 f7152b = new l0();

    public static final void B(Object obj, s sVar, xb.p pVar) {
        if (sVar.S || !yb.k.a(sVar.M(), obj)) {
            sVar.i0(obj);
            sVar.b(obj, pVar);
        }
    }

    public static final int C(p.t tVar) {
        int iC;
        int i = tVar.f9630b;
        int iC2 = tVar.c(0);
        while (tVar.f9630b != 0 && tVar.c(0) == iC2) {
            int i3 = tVar.f9630b;
            if (i3 == 0) {
                g5.f.m("IntList is empty.");
                return 0;
            }
            tVar.e(0, tVar.f9629a[i3 - 1]);
            tVar.d(tVar.f9630b - 1);
            int i10 = tVar.f9630b;
            int i11 = i10 >>> 1;
            int i12 = 0;
            while (i12 < i11) {
                int iC3 = tVar.c(i12);
                int i13 = (i12 + 1) * 2;
                int i14 = i13 - 1;
                int iC4 = tVar.c(i14);
                if (i13 >= i10 || (iC = tVar.c(i13)) <= iC4) {
                    if (iC4 > iC3) {
                        tVar.e(i12, iC4);
                        tVar.e(i14, iC3);
                        i12 = i14;
                    }
                } else if (iC > iC3) {
                    tVar.e(i12, iC);
                    tVar.e(i13, iC3);
                    i12 = i13;
                }
            }
        }
        return iC2;
    }

    public static final int D(int i) {
        int i3 = 306783378 & i;
        int i10 = 613566756 & i;
        return (i & (-920350135)) | (i10 >> 1) | i3 | ((i3 << 1) & i10);
    }

    public static final s0.g E(t1[] t1VarArr, s0.g gVar, s0.g gVar2) {
        s0.f fVar = new s0.f(s0.g.f11181h);
        for (t1 t1Var : t1VarArr) {
            s1 s1Var = (s1) t1Var.f7075d;
            if (t1Var.f7074c || !gVar.containsKey(s1Var)) {
                fVar.put(s1Var, s1Var.c(t1Var, (u2) gVar2.get(s1Var)));
            }
        }
        return fVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(k0.t1 r11, s0.c r12, k0.s r13, int r14) {
        /*
            r0 = -149765515(0xfffffffff712c275, float:-2.9766383E33)
            r13.Z(r0)
            k0.r0 r0 = r13.f7055x
            s0.g r1 = r13.l()
            r2 = 201(0xc9, float:2.82E-43)
            k0.e1 r3 = k0.t.f7063b
            r13.V(r2, r3)
            java.lang.Object r2 = r13.M()
            k0.y0 r3 = k0.m.f6974a
            boolean r3 = yb.k.a(r2, r3)
            r4 = 0
            if (r3 == 0) goto L22
            r2 = r4
            goto L27
        L22:
            r2.getClass()
            k0.u2 r2 = (k0.u2) r2
        L27:
            java.lang.Object r3 = r11.f7075d
            k0.s1 r3 = (k0.s1) r3
            k0.u2 r5 = r3.c(r11, r2)
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L38
            r13.i0(r5)
        L38:
            boolean r6 = r13.S
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L50
            boolean r2 = r11.f7074c
            if (r2 != 0) goto L48
            boolean r2 = r1.containsKey(r3)
            if (r2 != 0) goto L4c
        L48:
            s0.g r1 = r1.b(r3, r5)
        L4c:
            r13.J = r7
        L4e:
            r2 = r8
            goto L8b
        L50:
            k0.e2 r6 = r13.G
            int r9 = r6.f6888g
            int[] r10 = r6.f6883b
            java.lang.Object r6 = r6.b(r10, r9)
            r6.getClass()
            s0.g r6 = (s0.g) r6
            boolean r9 = r13.B()
            if (r9 == 0) goto L67
            if (r2 != 0) goto L72
        L67:
            boolean r9 = r11.f7074c
            if (r9 != 0) goto L80
            boolean r9 = r1.containsKey(r3)
            if (r9 != 0) goto L72
            goto L80
        L72:
            if (r2 == 0) goto L79
            boolean r2 = r13.f7054w
            if (r2 != 0) goto L79
            goto L7e
        L79:
            boolean r2 = r13.f7054w
            if (r2 == 0) goto L7e
            goto L84
        L7e:
            r1 = r6
            goto L84
        L80:
            s0.g r1 = r1.b(r3, r5)
        L84:
            boolean r2 = r13.f7056y
            if (r2 != 0) goto L8a
            if (r6 == r1) goto L4e
        L8a:
            r2 = r7
        L8b:
            if (r2 == 0) goto L94
            boolean r3 = r13.S
            if (r3 != 0) goto L94
            r13.K(r1)
        L94:
            boolean r3 = r13.f7054w
            r0.c(r3)
            r13.f7054w = r2
            r13.K = r1
            r2 = 202(0xca, float:2.83E-43)
            k0.e1 r3 = k0.t.f7064c
            r13.T(r3, r2, r8, r1)
            int r1 = r14 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.invoke(r13, r1)
            r13.q(r8)
            r13.q(r8)
            int r0 = r0.b()
            if (r0 == 0) goto Lbc
            goto Lbd
        Lbc:
            r7 = r8
        Lbd:
            r13.f7054w = r7
            r13.K = r4
            k0.v1 r13 = r13.s()
            if (r13 == 0) goto Ld7
            k0.a0 r0 = new k0.a0
            r0.<init>(r8)
            r0.f6862g = r11
            r0.f6863h = r12
            r0.f6861f = r14
            java.lang.invoke.VarHandle.storeStoreFence()
            r13.f7091d = r0
        Ld7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.z.a(k0.t1, s0.c, k0.s, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(k0.t1[] r8, xb.p r9, k0.s r10, int r11) {
        /*
            r0 = 415205898(0x18bf8a0a, float:4.9511727E-24)
            r10.Z(r0)
            k0.r0 r0 = r10.f7055x
            s0.g r1 = r10.l()
            r2 = 201(0xc9, float:2.82E-43)
            k0.e1 r3 = k0.t.f7063b
            r10.V(r2, r3)
            boolean r2 = r10.S
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L27
            s0.g r2 = s0.g.f11181h
            s0.g r2 = E(r8, r1, r2)
            s0.g r1 = r10.h0(r1, r2)
            r10.J = r3
        L25:
            r2 = r4
            goto L72
        L27:
            k0.e2 r2 = r10.G
            int r5 = r2.f6888g
            java.lang.Object r2 = r2.h(r5, r4)
            r2.getClass()
            s0.g r2 = (s0.g) r2
            k0.e2 r5 = r10.G
            int r6 = r5.f6888g
            java.lang.Object r5 = r5.h(r6, r3)
            r5.getClass()
            s0.g r5 = (s0.g) r5
            s0.g r6 = E(r8, r1, r5)
            boolean r7 = r10.B()
            if (r7 == 0) goto L63
            boolean r7 = r10.f7056y
            if (r7 != 0) goto L63
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L56
            goto L63
        L56:
            int r1 = r10.f7043l
            k0.e2 r5 = r10.G
            int r5 = r5.s()
            int r5 = r5 + r1
            r10.f7043l = r5
            r1 = r2
            goto L25
        L63:
            s0.g r1 = r10.h0(r1, r6)
            boolean r5 = r10.f7056y
            if (r5 != 0) goto L71
            boolean r2 = yb.k.a(r1, r2)
            if (r2 != 0) goto L25
        L71:
            r2 = r3
        L72:
            if (r2 == 0) goto L7b
            boolean r5 = r10.S
            if (r5 != 0) goto L7b
            r10.K(r1)
        L7b:
            boolean r5 = r10.f7054w
            r0.c(r5)
            r10.f7054w = r2
            r10.K = r1
            r2 = 202(0xca, float:2.83E-43)
            k0.e1 r5 = k0.t.f7064c
            r10.T(r5, r2, r4, r1)
            int r1 = r11 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r9.invoke(r10, r1)
            r10.q(r4)
            r10.q(r4)
            int r0 = r0.b()
            if (r0 == 0) goto La3
            r4 = r3
        La3:
            r10.f7054w = r4
            r0 = 0
            r10.K = r0
            k0.v1 r10 = r10.s()
            if (r10 == 0) goto Lbe
            k0.a0 r0 = new k0.a0
            r0.<init>(r3)
            r0.f6862g = r8
            r0.f6863h = r9
            r0.f6861f = r11
            java.lang.invoke.VarHandle.storeStoreFence()
            r10.f7091d = r0
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.z.b(k0.t1[], xb.p, k0.s, int):void");
    }

    public static final void c(Object obj, Object obj2, xb.l lVar, s sVar) {
        boolean zF = sVar.f(obj) | sVar.f(obj2);
        Object objM = sVar.M();
        if (zF || objM == m.f6974a) {
            objM = new j0(lVar);
            sVar.i0(objM);
        }
    }

    public static final void d(Object obj, xb.l lVar, s sVar) {
        boolean zF = sVar.f(obj);
        Object objM = sVar.M();
        if (zF || objM == m.f6974a) {
            objM = new j0(lVar);
            sVar.i0(objM);
        }
    }

    public static final void e(Object[] objArr, xb.l lVar, s sVar) {
        boolean zF = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zF |= sVar.f(obj);
        }
        Object objM = sVar.M();
        if (zF || objM == m.f6974a) {
            sVar.i0(new j0(lVar));
        }
    }

    public static final void f(Object obj, Object obj2, Object obj3, xb.p pVar, s sVar) {
        nb.g gVar = sVar.R;
        boolean zF = sVar.f(obj) | sVar.f(obj2) | sVar.f(obj3);
        Object objM = sVar.M();
        if (zF || objM == m.f6974a) {
            objM = new w0(gVar, pVar);
            sVar.i0(objM);
        }
    }

    public static final void g(Object obj, Object obj2, xb.p pVar, s sVar) {
        nb.g gVar = sVar.R;
        boolean zF = sVar.f(obj) | sVar.f(obj2);
        Object objM = sVar.M();
        if (zF || objM == m.f6974a) {
            objM = new w0(gVar, pVar);
            sVar.i0(objM);
        }
    }

    public static final void h(Object obj, s sVar, xb.p pVar) {
        nb.g gVar = sVar.R;
        boolean zF = sVar.f(obj);
        Object objM = sVar.M();
        if (zF || objM == m.f6974a) {
            objM = new w0(gVar, pVar);
            sVar.i0(objM);
        }
    }

    public static final void i(Object[] objArr, xb.p pVar, s sVar) {
        nb.g gVar = sVar.R;
        boolean zF = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zF |= sVar.f(obj);
        }
        Object objM = sVar.M();
        if (zF || objM == m.f6974a) {
            sVar.i0(new w0(gVar, pVar));
        }
    }

    public static final void j(xb.a aVar, s sVar) {
        l0.k0 k0Var = sVar.M.f7659b.f7656c;
        k0Var.T(l0.a0.f7657c);
        id.k.R(k0Var, 0, aVar);
    }

    public static final void k(p.t tVar, int i) {
        if (tVar.f9630b == 0 || !(tVar.c(0) == i || tVar.c(tVar.f9630b - 1) == i)) {
            int i3 = tVar.f9630b;
            tVar.a(i);
            while (i3 > 0) {
                int i10 = ((i3 + 1) >>> 1) - 1;
                int iC = tVar.c(i10);
                if (i <= iC) {
                    break;
                }
                tVar.e(i3, iC);
                i3 = i10;
            }
            tVar.e(i3, i);
        }
    }

    public static void l(i2 i2Var, List list, y yVar) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iC = i2Var.c((b) list.get(i));
            int iM = i2Var.M(i2Var.f6939b, i2Var.r(iC));
            Object obj = iM < i2Var.g(i2Var.f6939b, i2Var.r(iC + 1)) ? i2Var.f6940c[i2Var.h(iM)] : m.f6974a;
            v1 v1Var = obj instanceof v1 ? (v1) obj : null;
            if (v1Var != null) {
                v1Var.f7088a = yVar;
            }
        }
    }

    public static e0 n(xb.a aVar) {
        y0 y0Var = y0.f7139j;
        e0 e0Var = new e0(1, aVar);
        e0Var.f6880c = y0Var;
        VarHandle.storeStoreFence();
        return e0Var;
    }

    public static final kc.t o(s sVar) {
        nb.g gVar = sVar.R;
        d2 d2Var = new d2();
        d2Var.f6874c = gVar;
        d2Var.f6875f = d2Var;
        VarHandle.storeStoreFence();
        return d2Var;
    }

    public static final m0.e p() {
        p5.m mVar = n2.f6987b;
        m0.e eVar = (m0.e) mVar.w();
        if (eVar != null) {
            return eVar;
        }
        m0.e eVar2 = new m0.e(new q[0]);
        mVar.N(eVar2);
        return eVar2;
    }

    public static final i0 q(xb.a aVar) {
        p5.m mVar = n2.f6986a;
        return new i0(aVar, null);
    }

    public static final int r(s sVar) {
        sVar.getClass();
        return Long.hashCode(sVar.T);
    }

    public static final z0 s(nb.g gVar) {
        z0 z0Var = (z0) gVar.get(y0.f7136f);
        if (z0Var != null) {
            return z0Var;
        }
        od.f.e("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List u(i2 i2Var, int i, i2 i2Var2, boolean z10, boolean z11, boolean z12) {
        kb.s sVar;
        boolean z13;
        int i3;
        int i10;
        int iT = i2Var.t(i);
        int i11 = i + iT;
        int iF = i2Var.f(i);
        int iF2 = i2Var.f(i11);
        int i12 = iF2 - iF;
        boolean z14 = i >= 0 && (i2Var.f6939b[(i2Var.r(i) * 5) + 1] & 201326592) != 0;
        i2Var2.v(iT);
        i2Var2.w(i12, i2Var2.f6956t);
        if (i2Var.f6944g < i11) {
            i2Var.A(i11);
        }
        if (i2Var.f6947k < iF2) {
            i2Var.B(iF2, i11);
        }
        int[] iArr = i2Var2.f6939b;
        int i13 = i2Var2.f6956t;
        int i14 = i13 * 5;
        kb.k.f0(i14, i * 5, i2Var.f6939b, iArr, i11 * 5);
        Object[] objArr = i2Var2.f6940c;
        int i15 = i2Var2.i;
        System.arraycopy(i2Var.f6940c, iF, objArr, i15, i12);
        int i16 = i2Var2.f6958v;
        iArr[i14 + 2] = i16;
        int i17 = i13 - i;
        int i18 = i13 + iT;
        int iG = i15 - i2Var2.g(iArr, i13);
        int i19 = i2Var2.f6949m;
        int i20 = i2Var2.f6948l;
        int length = objArr.length;
        boolean z15 = z14;
        int i21 = i19;
        int i22 = i13;
        while (i22 < i18) {
            if (i22 != i13) {
                int i23 = (i22 * 5) + 2;
                iArr[i23] = iArr[i23] + i17;
            }
            int[] iArr2 = iArr;
            int iG2 = i2Var2.g(iArr, i22) + iG;
            if (i21 < i22) {
                i3 = i13;
                i10 = 0;
            } else {
                i3 = i13;
                i10 = i2Var2.f6947k;
            }
            iArr2[(i22 * 5) + 4] = i2.i(iG2, i10, i20, length);
            if (i22 == i21) {
                i21++;
            }
            i22++;
            i13 = i3;
            iArr = iArr2;
        }
        int[] iArr3 = iArr;
        i2Var2.f6949m = i21;
        int iB = h2.b(i2Var.f6941d, i, i2Var.p());
        int iB2 = h2.b(i2Var.f6941d, i11, i2Var.p());
        if (iB < iB2) {
            ArrayList arrayList = i2Var.f6941d;
            ArrayList arrayList2 = new ArrayList(iB2 - iB);
            for (int i24 = iB; i24 < iB2; i24++) {
                b bVar = (b) arrayList.get(i24);
                bVar.f6864a += i17;
                arrayList2.add(bVar);
            }
            i2Var2.f6941d.addAll(h2.b(i2Var2.f6941d, i2Var2.f6956t, i2Var2.p()), arrayList2);
            arrayList.subList(iB, iB2).clear();
            sVar = arrayList2;
        } else {
            sVar = kb.s.f7404c;
        }
        if (!sVar.isEmpty()) {
            HashMap map = i2Var.f6942e;
            HashMap map2 = i2Var2.f6942e;
            if (map != null && map2 != null) {
                int size = sVar.size();
                for (int i25 = 0; i25 < size; i25++) {
                }
            }
        }
        int i26 = i2Var2.f6958v;
        i2Var2.N(i16);
        int iD = i2Var.D(i2Var.f6939b, i);
        if (!z12) {
            z13 = false;
        } else if (z10) {
            boolean z16 = iD >= 0;
            if (z16) {
                i2Var.O();
                i2Var.a(iD - i2Var.f6956t);
                i2Var.O();
            }
            i2Var.a(i - i2Var.f6956t);
            boolean zG = i2Var.G();
            if (z16) {
                i2Var.L();
                i2Var.j();
                i2Var.L();
                i2Var.j();
            }
            z13 = zG;
        } else {
            boolean zH = i2Var.H(i, iT);
            i2Var.I(iF, i12, i - 1);
            z13 = zH;
        }
        if (z13) {
            t.c("Unexpectedly removed anchors");
        }
        int i27 = i2Var2.f6951o;
        int i28 = iArr3[i14 + 1];
        i2Var2.f6951o = i27 + ((1073741824 & i28) != 0 ? 1 : i28 & 67108863);
        if (z11) {
            i2Var2.f6956t = i18;
            i2Var2.i = i15 + i12;
        }
        if (z15) {
            i2Var2.S(i16);
        }
        return sVar;
    }

    public static k1 v(Object obj) {
        return new k1(obj, y0.f7139j);
    }

    public static final c1 w(String str, xb.p pVar, s sVar, int i) {
        Object objM = sVar.M();
        nb.c cVar = null;
        y0 y0Var = m.f6974a;
        if (objM == y0Var) {
            objM = v(null);
            sVar.i0(objM);
        }
        c1 c1Var = (c1) objM;
        boolean zH = sVar.h(pVar);
        Object objM2 = sVar.M();
        if (zH || objM2 == y0Var) {
            objM2 = new o2(pVar, c1Var, cVar, 1);
            sVar.i0(objM2);
        }
        h(str, sVar, (xb.p) objM2);
        return c1Var;
    }

    public static final Object x(s0.g gVar, s1 s1Var) {
        s1Var.getClass();
        Object objB = gVar.get(s1Var);
        if (objB == null) {
            objB = s1Var.b();
        }
        return ((u2) objB).a(gVar);
    }

    public static final p y(s sVar) {
        sVar.V(206, t.f7066e);
        if (sVar.S) {
            i2.y(sVar.I);
        }
        Object objE = sVar.E();
        o oVar = objE instanceof o ? (o) objE : null;
        if (oVar == null) {
            long j10 = sVar.T;
            boolean z10 = sVar.f7048q;
            boolean z11 = sVar.C;
            p pVar = new p();
            pVar.f7003g = sVar;
            pVar.f6997a = j10;
            pVar.f6998b = z10;
            pVar.f6999c = z11;
            pVar.f7001e = new LinkedHashSet();
            pVar.f7002f = new k1(s0.g.f11181h, y0.f7138h);
            VarHandle.storeStoreFence();
            oVar = new o();
            oVar.f6988c = pVar;
            VarHandle.storeStoreFence();
            sVar.j0(oVar);
        }
        p pVar2 = oVar.f6988c;
        pVar2.f7002f.setValue(sVar.l());
        sVar.q(false);
        return pVar2;
    }

    public static final c1 z(Object obj, s sVar) {
        Object objM = sVar.M();
        if (objM == m.f6974a) {
            objM = v(obj);
            sVar.i0(objM);
        }
        c1 c1Var = (c1) objM;
        c1Var.setValue(obj);
        return c1Var;
    }

    public abstract void A(od.f fVar);

    public abstract void m();

    public abstract void t();
}
