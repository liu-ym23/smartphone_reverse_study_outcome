package i1;

import androidx.compose.ui.semantics.AppendedSemanticsElement;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class c extends n0.l implements v, m, s1, p1, h1.d, h1.e, n1, u, n, s0.d, s0.l, s0.n, l1, r0.a {

    /* renamed from: t, reason: collision with root package name */
    public n0.k f4415t;

    /* renamed from: u, reason: collision with root package name */
    public h1.a f4416u;

    /* renamed from: v, reason: collision with root package name */
    public HashSet f4417v;

    @Override // i1.p1
    public final void C(c1.f fVar, c1.g gVar, long j2) {
        q7.k.c(this.f4415t, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        throw new ClassCastException();
    }

    @Override // i1.p1
    public final boolean E() {
        q7.k.c(this.f4415t, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        throw new ClassCastException();
    }

    @Override // i1.v
    public final l0 G(m0 m0Var, g1.o oVar, long j2) {
        n0.k kVar = this.f4415t;
        q7.k.c(kVar, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        b0.o1 o1Var = ((r.y) kVar).f8951b;
        int iD = ((r.o0) o1Var.getValue()).d(m0Var, m0Var.c0());
        int iB = ((r.o0) o1Var.getValue()).b(m0Var);
        int iA = ((r.o0) o1Var.getValue()).a(m0Var, m0Var.c0()) + iD;
        int iC = ((r.o0) o1Var.getValue()).c(m0Var) + iB;
        g1.s sVarB = oVar.b(d2.b.h(j2, -iA, -iC));
        return m0Var.l0(d2.b.f(sVarB.f3756f + iA, j2), d2.b.e(sVarB.f3757g + iC, j2), d7.a0.f2944f, new r.x(sVarB, iD, iB));
    }

    @Override // i1.p1
    public final void M() {
        q7.k.c(this.f4415t, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        throw new ClassCastException();
    }

    @Override // i1.n1
    public final Object S(Object obj) {
        q7.k.c(this.f4415t, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        throw new ClassCastException();
    }

    @Override // i1.m
    public final void T() {
        l.l(this);
    }

    @Override // i1.p1
    public final boolean V() {
        q7.k.c(this.f4415t, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        throw new ClassCastException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r8v3, types: [p7.a, q7.m] */
    @Override // h1.d, h1.e
    public final Object a(h1.f fVar) {
        a1 a1Var;
        this.f4417v.add(fVar);
        if (!this.f6797f.f6810s) {
            f1.a.b("visitAncestors called on an unattached node");
        }
        n0.l lVar = this.f6797f.f6801j;
        f0 f0VarU = l.u(this);
        while (f0VarU != null) {
            if ((((n0.l) f0VarU.H.f4404j).f6800i & 32) != 0) {
                while (lVar != null) {
                    if ((lVar.f6799h & 32) != 0) {
                        k kVarE = lVar;
                        ?? eVar = 0;
                        while (kVarE != 0) {
                            if (kVarE instanceof h1.d) {
                                h1.d dVar = (h1.d) kVarE;
                                if (dVar.h().j(fVar)) {
                                    return dVar.h().s(fVar);
                                }
                            } else if ((kVarE.f6799h & 32) != 0 && (kVarE instanceof k)) {
                                n0.l lVar2 = kVarE.f4514u;
                                int i2 = 0;
                                kVarE = kVarE;
                                eVar = eVar;
                                while (lVar2 != null) {
                                    if ((lVar2.f6799h & 32) != 0) {
                                        i2++;
                                        eVar = eVar;
                                        if (i2 == 1) {
                                            kVarE = lVar2;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new d0.e(new n0.l[16]);
                                            }
                                            if (kVarE != 0) {
                                                eVar.b(kVarE);
                                                kVarE = 0;
                                            }
                                            eVar.b(lVar2);
                                        }
                                    }
                                    lVar2 = lVar2.f6802k;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                }
                                if (i2 == 1) {
                                }
                            }
                            kVarE = l.e(eVar);
                        }
                    }
                    lVar = lVar.f6801j;
                }
            }
            f0VarU = f0VarU.n();
            lVar = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
        }
        return fVar.f4073a.c();
    }

    @Override // i1.j, i1.p1
    public final void b() {
    }

    @Override // r0.a
    public final d2.c c() {
        return l.u(this).A;
    }

    @Override // r0.a
    public final long d() {
        return ib.k.W(l.s(this, 128).f3758h);
    }

    @Override // n0.l
    public final void d0() {
        l0(true);
    }

    @Override // i1.m
    public final void e(h0 h0Var) {
        n0.k kVar = this.f4415t;
        q7.k.c(kVar, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        ((r0.e) kVar).e(h0Var);
    }

    @Override // n0.l
    public final void e0() {
        m0();
    }

    @Override // s0.d
    public final void f(s0.p pVar) {
        n0.k kVar = this.f4415t;
        f1.a.b("onFocusEvent called on wrong node");
        kVar.getClass();
        throw new ClassCastException();
    }

    @Override // r0.a
    public final d2.l getLayoutDirection() {
        return l.u(this).B;
    }

    @Override // h1.d
    public final s7.a h() {
        h1.a aVar = this.f4416u;
        return aVar != null ? aVar : h1.b.f4066b;
    }

    @Override // i1.u
    public final void l(g1.k kVar) {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l0(boolean r6) {
        /*
            r5 = this;
            boolean r0 = r5.f6810s
            if (r0 != 0) goto L9
            java.lang.String r0 = "initializeModifier called on unattached node"
            f1.a.b(r0)
        L9:
            n0.k r0 = r5.f4415t
            int r1 = r5.f6799h
            r1 = r1 & 32
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode"
            if (r1 == 0) goto L8e
            boolean r1 = r0 instanceof r.y
            if (r1 == 0) goto L2f
            i1.b r1 = new i1.b
            r3 = 0
            r1.<init>(r5, r3)
            i1.k1 r3 = i1.l.v(r5)
            j1.y r3 = (j1.y) r3
            k.z r3 = r3.f5391x0
            int r4 = r3.f(r1)
            if (r4 < 0) goto L2c
            goto L2f
        L2c:
            r3.a(r1)
        L2f:
            boolean r1 = r0 instanceof r.y
            if (r1 == 0) goto L8e
            r.y r0 = (r.y) r0
            h1.a r1 = r5.f4416u
            if (r1 == 0) goto L5b
            h1.f r3 = r.r0.f8937a
            boolean r4 = r1.j(r3)
            if (r4 == 0) goto L5b
            r1.f4065b = r0
            i1.k1 r0 = i1.l.v(r5)
            j1.y r0 = (j1.y) r0
            h1.c r0 = r0.getModifierLocalManager()
            d0.e r1 = r0.f4068b
            r1.b(r5)
            d0.e r1 = r0.f4069c
            r1.b(r3)
            r0.a()
            goto L8e
        L5b:
            h1.a r1 = new h1.a
            r1.<init>()
            r1.f4065b = r0
            r5.f4416u = r1
            i1.f0 r0 = i1.l.u(r5)
            i1.a1 r0 = r0.H
            java.lang.Object r0 = r0.f4403i
            i1.u1 r0 = (i1.u1) r0
            q7.k.c(r0, r2)
            boolean r0 = r0.f4606t
            if (r0 == 0) goto L8e
            i1.k1 r0 = i1.l.v(r5)
            j1.y r0 = (j1.y) r0
            h1.c r0 = r0.getModifierLocalManager()
            h1.f r1 = r.r0.f8937a
            d0.e r3 = r0.f4068b
            r3.b(r5)
            d0.e r3 = r0.f4069c
            r3.b(r1)
            r0.a()
        L8e:
            int r0 = r5.f6799h
            r0 = r0 & 4
            r1 = 2
            if (r0 == 0) goto L9e
            if (r6 != 0) goto L9e
            i1.d1 r0 = i1.l.s(r5, r1)
            r0.G0()
        L9e:
            int r0 = r5.f6799h
            r0 = r0 & r1
            if (r0 == 0) goto Ld8
            i1.f0 r0 = i1.l.u(r5)
            i1.a1 r0 = r0.H
            java.lang.Object r0 = r0.f4403i
            i1.u1 r0 = (i1.u1) r0
            q7.k.c(r0, r2)
            boolean r0 = r0.f4606t
            if (r0 == 0) goto Lc8
            i1.d1 r0 = r5.f6804m
            q7.k.b(r0)
            r2 = r0
            i1.x r2 = (i1.x) r2
            r2.Z0(r5)
            i1.j1 r0 = r0.N
            if (r0 == 0) goto Lc8
            j1.n1 r0 = (j1.n1) r0
            r0.invalidate()
        Lc8:
            if (r6 != 0) goto Ld8
            i1.d1 r6 = i1.l.s(r5, r1)
            r6.G0()
            i1.f0 r6 = i1.l.u(r5)
            r6.x()
        Ld8:
            int r6 = r5.f6799h
            r6 = r6 & 8
            if (r6 == 0) goto Le7
            i1.k1 r5 = i1.l.v(r5)
            j1.y r5 = (j1.y) r5
            r5.w()
        Le7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.c.l0(boolean):void");
    }

    @Override // i1.u
    public final void m(long j2) {
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [p7.a, q7.m] */
    public final void m0() {
        if (!this.f6810s) {
            f1.a.b("unInitializeModifier called on unattached node");
        }
        n0.k kVar = this.f4415t;
        if ((this.f6799h & 32) != 0) {
            if (kVar instanceof r.y) {
                h1.c modifierLocalManager = ((j1.y) l.v(this)).getModifierLocalManager();
                h1.f fVar = r.r0.f8937a;
                modifierLocalManager.f4070d.b(l.u(this));
                modifierLocalManager.f4071e.b(fVar);
                modifierLocalManager.a();
            }
            if (kVar instanceof r.y) {
                r.y yVar = (r.y) kVar;
                r.o0 o0Var = (r.o0) r.r0.f8937a.f4073a.c();
                r.o0 o0Var2 = yVar.f8950a;
                yVar.f8951b.setValue(new r.t(o0Var2, o0Var));
                yVar.f8952c.setValue(new r.l0(o0Var, o0Var2));
            }
        }
        if ((this.f6799h & 8) != 0) {
            ((j1.y) l.v(this)).w();
        }
    }

    public final void n0() {
        if (this.f6810s) {
            this.f4417v.clear();
            ((j1.y) l.v(this)).getSnapshotObserver().a(this, d.f4420h, new b(this, 1));
        }
    }

    @Override // i1.l1
    public final boolean p() {
        return this.f6810s;
    }

    @Override // i1.n
    public final void q(d1 d1Var) {
        q7.k.c(this.f4415t, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        throw new ClassCastException();
    }

    public final String toString() {
        return this.f4415t.toString();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [p7.k, q7.m] */
    @Override // i1.s1
    public final void u(p1.i iVar) {
        n0.k kVar = this.f4415t;
        q7.k.c(kVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) kVar;
        p1.i iVar2 = new p1.i();
        iVar2.f8306h = appendedSemanticsElement.f774a;
        appendedSemanticsElement.f775b.invoke(iVar2);
        q7.k.c(iVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        k.a0 a0Var = iVar.f8304f;
        if (iVar2.f8306h) {
            iVar.f8306h = true;
        }
        if (iVar2.f8307i) {
            iVar.f8307i = true;
        }
        k.a0 a0Var2 = iVar2.f8304f;
        Object[] objArr = a0Var2.f5447b;
        Object[] objArr2 = a0Var2.f5448c;
        long[] jArr = a0Var2.f5446a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        int i12 = (i2 << 3) + i11;
                        Object obj = objArr[i12];
                        Object obj2 = objArr2[i12];
                        p1.v vVar = (p1.v) obj;
                        if (!a0Var.b(vVar)) {
                            a0Var.l(vVar, obj2);
                        } else if (obj2 instanceof p1.a) {
                            Object objG = a0Var.g(vVar);
                            q7.k.c(objG, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                            p1.a aVar = (p1.a) objG;
                            String str = aVar.f8266a;
                            if (str == null) {
                                str = ((p1.a) obj2).f8266a;
                            }
                            c7.c cVar = aVar.f8267b;
                            if (cVar == null) {
                                cVar = ((p1.a) obj2).f8267b;
                            }
                            a0Var.l(vVar, new p1.a(str, cVar));
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    @Override // s0.l
    public final void x(s0.i iVar) {
        n0.k kVar = this.f4415t;
        f1.a.b("applyFocusProperties called on wrong node");
        kVar.getClass();
        throw new ClassCastException();
    }
}
