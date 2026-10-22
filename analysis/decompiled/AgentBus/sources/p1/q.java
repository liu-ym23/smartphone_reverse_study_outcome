package p1;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Trace;
import i1.d1;
import i1.f0;
import java.util.List;
import o4.d0;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final t0.c f8325a = new t0.c(0.0f, 0.0f, 10.0f, 10.0f);

    /* JADX WARN: Removed duplicated region for block: B:35:0x0063 A[LOOP:0: B:4:0x000d->B:35:0x0063, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0066 A[EDGE_INSN: B:43:0x0066->B:36:0x0066 BREAK  A[LOOP:0: B:4:0x000d->B:35:0x0063], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final p1.n a(i1.f0 r8, boolean r9) {
        /*
            i1.a1 r0 = r8.H
            java.lang.Object r0 = r0.f4404j
            n0.l r0 = (n0.l) r0
            int r1 = r0.f6800i
            r1 = r1 & 8
            r2 = 0
            if (r1 == 0) goto L66
        Ld:
            if (r0 == 0) goto L66
            int r1 = r0.f6799h
            r1 = r1 & 8
            if (r1 == 0) goto L5d
            r1 = r0
            r3 = r2
        L17:
            if (r1 == 0) goto L5d
            boolean r4 = r1 instanceof i1.s1
            if (r4 == 0) goto L1f
            r2 = r1
            goto L66
        L1f:
            int r4 = r1.f6799h
            r4 = r4 & 8
            if (r4 == 0) goto L58
            boolean r4 = r1 instanceof i1.k
            if (r4 == 0) goto L58
            r4 = r1
            i1.k r4 = (i1.k) r4
            n0.l r4 = r4.f4514u
            r5 = 0
        L2f:
            r6 = 1
            if (r4 == 0) goto L55
            int r7 = r4.f6799h
            r7 = r7 & 8
            if (r7 == 0) goto L52
            int r5 = r5 + 1
            if (r5 != r6) goto L3e
            r1 = r4
            goto L52
        L3e:
            if (r3 != 0) goto L49
            d0.e r3 = new d0.e
            r6 = 16
            n0.l[] r6 = new n0.l[r6]
            r3.<init>(r6)
        L49:
            if (r1 == 0) goto L4f
            r3.b(r1)
            r1 = r2
        L4f:
            r3.b(r4)
        L52:
            n0.l r4 = r4.f6802k
            goto L2f
        L55:
            if (r5 != r6) goto L58
            goto L17
        L58:
            n0.l r1 = i1.l.e(r3)
            goto L17
        L5d:
            int r1 = r0.f6800i
            r1 = r1 & 8
            if (r1 == 0) goto L66
            n0.l r0 = r0.f6802k
            goto Ld
        L66:
            q7.k.b(r2)
            i1.s1 r2 = (i1.s1) r2
            n0.l r2 = (n0.l) r2
            n0.l r0 = r2.f6797f
            p1.i r1 = r8.q()
            if (r1 != 0) goto L7a
            p1.i r1 = new p1.i
            r1.<init>()
        L7a:
            p1.n r2 = new p1.n
            r2.<init>(r0, r9, r8, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.q.a(i1.f0, boolean):p1.n");
    }

    public static final k.t b(p pVar) {
        Trace.beginSection("getAllUncoveredSemanticsNodesToIntObjectMap");
        try {
            n nVarA = pVar.a();
            f0 f0Var = nVarA.f8314c;
            if (f0Var.C() && f0Var.B()) {
                k.t tVar = new k.t(48);
                d0 d0Var = new d0(3);
                d2.j jVarM = ib.c.M(nVarA.g());
                ((Region) d0Var.f7326g).set(jVarM.f2788a, jVarM.f2789b, jVarM.f2790c, jVarM.f2791d);
                c(d0Var, nVarA, tVar, nVarA, new d0(3));
                return tVar;
            }
            k.t tVar2 = k.k.f5504a;
            q7.k.c(tVar2, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.emptyIntObjectMap>");
            return tVar2;
        } finally {
            Trace.endSection();
        }
    }

    public static final void c(d0 d0Var, n nVar, k.t tVar, n nVar2, d0 d0Var2) {
        t0.c cVarV0;
        f0 f0Var;
        int i2 = nVar.f8318g;
        Region region = (Region) d0Var2.f7326g;
        f0 f0Var2 = nVar2.f8314c;
        int i10 = nVar2.f8318g;
        boolean z4 = (f0Var2.C() && f0Var2.B()) ? false : true;
        Region region2 = (Region) d0Var.f7326g;
        if (!region2.isEmpty() || i10 == i2) {
            if (!z4 || nVar2.f8316e) {
                i1.j jVarF = nVar2.f();
                if (jVarF == null) {
                    cVarV0 = ((i1.r) f0Var2.H.f4401g).V0();
                } else {
                    n0.l lVar = ((n0.l) jVarF).f6797f;
                    Object objG = nVar2.f8315d.f8304f.g(h.f8279b);
                    if (objG == null) {
                        objG = null;
                    }
                    boolean z10 = objG != null;
                    if (!lVar.f6797f.f6810s) {
                        cVarV0 = t0.c.f9655e;
                    } else if (z10) {
                        cVarV0 = i1.l.s(lVar, 8).V0();
                    } else {
                        d1 d1VarS = i1.l.s(lVar, 8);
                        cVarV0 = ib.k.w(d1VarS).B(d1VarS, true);
                    }
                }
                d2.j jVarM = ib.c.M(cVarV0);
                region.set(jVarM.f2788a, jVarM.f2789b, jVarM.f2790c, jVarM.f2791d);
                if (i10 == i2) {
                    i10 = -1;
                }
                if (!region.op(region2, Region.Op.INTERSECT)) {
                    if (nVar2.f8316e) {
                        n nVarL = nVar2.l();
                        tVar.g(i10, new o(nVar2, ib.c.M((nVarL == null || (f0Var = nVarL.f8314c) == null || !f0Var.C()) ? f8325a : nVarL.g())));
                        return;
                    } else {
                        if (i10 == -1) {
                            Rect bounds = region.getBounds();
                            tVar.g(i10, new o(nVar2, new d2.j(bounds.left, bounds.top, bounds.right, bounds.bottom)));
                            return;
                        }
                        return;
                    }
                }
                Rect bounds2 = region.getBounds();
                tVar.g(i10, new o(nVar2, new d2.j(bounds2.left, bounds2.top, bounds2.right, bounds2.bottom)));
                List listI = nVar2.i((4 & 1) != 0 ? !nVar2.f8313b : false, (4 & 2) == 0);
                for (int size = listI.size() - 1; -1 < size; size--) {
                    if (!((n) listI.get(size)).k().f8304f.c(s.f8367x)) {
                        c(d0Var, nVar, tVar, (n) listI.get(size), d0Var2);
                    }
                }
                if (f(nVar2)) {
                    region2.op(jVarM.f2788a, jVarM.f2789b, jVarM.f2790c, jVarM.f2791d, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    public static final Object d(i iVar, v vVar) {
        Object objG = iVar.f8304f.g(vVar);
        if (objG == null) {
            return null;
        }
        return objG;
    }

    public static final boolean e(n nVar) {
        d1 d1VarD = nVar.d();
        i iVar = nVar.f8315d;
        if (d1VarD != null ? d1VarD.H0() : false) {
            return true;
        }
        v vVar = s.f8344a;
        if (iVar.f8304f.c(s.f8359p)) {
            return true;
        }
        return iVar.f8304f.c(s.f8358o);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean f(p1.n r14) {
        /*
            boolean r0 = e(r14)
            r1 = 0
            if (r0 != 0) goto L5b
            p1.i r14 = r14.f8315d
            boolean r0 = r14.f8306h
            if (r0 != 0) goto L59
            k.a0 r14 = r14.f8304f
            java.lang.Object[] r0 = r14.f5447b
            java.lang.Object[] r2 = r14.f5448c
            long[] r14 = r14.f5446a
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L5b
            r4 = r1
        L1b:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L54
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L35:
            if (r9 >= r7) goto L52
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4e
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r0[r10]
            r10 = r2[r10]
            p1.v r11 = (p1.v) r11
            boolean r10 = r11.f8375c
            if (r10 == 0) goto L4e
            goto L59
        L4e:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L35
        L52:
            if (r7 != r8) goto L5b
        L54:
            if (r4 == r3) goto L5b
            int r4 = r4 + 1
            goto L1b
        L59:
            r14 = 1
            return r14
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.q.f(p1.n):boolean");
    }
}
