package a2;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Trace;
import java.lang.invoke.VarHandle;
import java.util.List;
import p.f0;
import s1.v0;
import u1.g0;
import u1.g1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final c1.c f98a = new c1.c(0.0f, 0.0f, 10.0f, 10.0f);

    /* JADX WARN: Removed duplicated region for block: B:35:0x0061 A[LOOP:0: B:4:0x000b->B:35:0x0061, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0064 A[EDGE_INSN: B:43:0x0064->B:36:0x0064 BREAK  A[LOOP:0: B:4:0x000b->B:35:0x0061], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a2.p a(u1.g0 r8, boolean r9) {
        /*
            u1.c1 r0 = r8.H
            w0.l r0 = r0.f13746f
            int r1 = r0.f15117h
            r1 = r1 & 8
            r2 = 0
            if (r1 == 0) goto L64
        Lb:
            if (r0 == 0) goto L64
            int r1 = r0.f15116g
            r1 = r1 & 8
            if (r1 == 0) goto L5b
            r1 = r0
            r3 = r2
        L15:
            if (r1 == 0) goto L5b
            boolean r4 = r1 instanceof u1.v1
            if (r4 == 0) goto L1d
            r2 = r1
            goto L64
        L1d:
            int r4 = r1.f15116g
            r4 = r4 & 8
            if (r4 == 0) goto L56
            boolean r4 = r1 instanceof u1.m
            if (r4 == 0) goto L56
            r4 = r1
            u1.m r4 = (u1.m) r4
            w0.l r4 = r4.f13866t
            r5 = 0
        L2d:
            r6 = 1
            if (r4 == 0) goto L53
            int r7 = r4.f15116g
            r7 = r7 & 8
            if (r7 == 0) goto L50
            int r5 = r5 + 1
            if (r5 != r6) goto L3c
            r1 = r4
            goto L50
        L3c:
            if (r3 != 0) goto L47
            m0.e r3 = new m0.e
            r6 = 16
            w0.l[] r6 = new w0.l[r6]
            r3.<init>(r6)
        L47:
            if (r1 == 0) goto L4d
            r3.b(r1)
            r1 = r2
        L4d:
            r3.b(r4)
        L50:
            w0.l r4 = r4.f15118j
            goto L2d
        L53:
            if (r5 != r6) goto L56
            goto L15
        L56:
            w0.l r1 = u1.f.e(r3)
            goto L15
        L5b:
            int r1 = r0.f15117h
            r1 = r1 & 8
            if (r1 == 0) goto L64
            w0.l r0 = r0.f15118j
            goto Lb
        L64:
            r2.getClass()
            u1.v1 r2 = (u1.v1) r2
            w0.l r2 = (w0.l) r2
            w0.l r0 = r2.f15114c
            a2.k r1 = r8.v()
            if (r1 != 0) goto L78
            a2.k r1 = new a2.k
            r1.<init>()
        L78:
            a2.p r2 = new a2.p
            r2.<init>(r0, r9, r8, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.s.a(u1.g0, boolean):a2.p");
    }

    public static final p.u b(r rVar) {
        Trace.beginSection("getAllUncoveredSemanticsNodesToIntObjectMap");
        try {
            p pVarA = rVar.a();
            g0 g0Var = pVarA.f87c;
            if (g0Var.H() && g0Var.G()) {
                p.u uVar = new p.u(48);
                int i = 0;
                i iVar = new i(i);
                Region region = new Region();
                iVar.f49f = region;
                VarHandle.storeStoreFence();
                o2.j jVarU = a.a.U(pVarA.g());
                region.set(jVarU.f9118a, jVarU.f9119b, jVarU.f9120c, jVarU.f9121d);
                i iVar2 = new i(i);
                iVar2.f49f = new Region();
                VarHandle.storeStoreFence();
                c(iVar, pVarA, uVar, pVarA, iVar2);
                return uVar;
            }
            p.u uVar2 = p.k.f9586a;
            uVar2.getClass();
            return uVar2;
        } finally {
            Trace.endSection();
        }
    }

    public static final void c(i iVar, p pVar, p.u uVar, p pVar2, i iVar2) {
        c1.c cVarA1;
        g0 g0Var;
        int i = pVar.f91g;
        Region region = (Region) iVar2.f49f;
        g0 g0Var2 = pVar2.f87c;
        int i3 = pVar2.f91g;
        boolean z10 = (g0Var2.H() && g0Var2.G()) ? false : true;
        Region region2 = (Region) iVar.f49f;
        if (!region2.isEmpty() || i3 == i) {
            if (!z10 || pVar2.f89e) {
                Object objF = pVar2.f();
                if (objF == null) {
                    cVarA1 = g0Var2.H.f13743c.a1();
                } else {
                    w0.l lVar = ((w0.l) objF).f15114c;
                    Object objG = pVar2.f88d.f75c.g(j.f51b);
                    if (objG == null) {
                        objG = null;
                    }
                    boolean z11 = objG != null;
                    if (!lVar.f15114c.f15126r) {
                        cVarA1 = c1.c.f2166e;
                    } else if (z11) {
                        cVarA1 = u1.f.s(lVar, 8).a1();
                    } else {
                        g1 g1VarS = u1.f.s(lVar, 8);
                        cVarA1 = v0.i(g1VarS).g(g1VarS, true);
                    }
                }
                o2.j jVarU = a.a.U(cVarA1);
                region.set(jVarU.f9118a, jVarU.f9119b, jVarU.f9120c, jVarU.f9121d);
                if (i3 == i) {
                    i3 = -1;
                }
                if (!region.op(region2, Region.Op.INTERSECT)) {
                    if (pVar2.f89e) {
                        p pVarL = pVar2.l();
                        uVar.h(i3, new q(pVar2, a.a.U((pVarL == null || (g0Var = pVarL.f87c) == null || !g0Var.H()) ? f98a : pVarL.g())));
                        return;
                    } else {
                        if (i3 == -1) {
                            Rect bounds = region.getBounds();
                            uVar.h(i3, new q(pVar2, new o2.j(bounds.left, bounds.top, bounds.right, bounds.bottom)));
                            return;
                        }
                        return;
                    }
                }
                Rect bounds2 = region.getBounds();
                uVar.h(i3, new q(pVar2, new o2.j(bounds2.left, bounds2.top, bounds2.right, bounds2.bottom)));
                List listJ = p.j(4, pVar2);
                for (int size = listJ.size() - 1; -1 < size; size--) {
                    if (!((p) listJ.get(size)).k().f75c.c(u.f140y)) {
                        c(iVar, pVar, uVar, (p) listJ.get(size), iVar2);
                    }
                }
                if (f(pVar2)) {
                    region2.op(jVarU.f9118a, jVarU.f9119b, jVarU.f9120c, jVarU.f9121d, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    public static final Object d(k kVar, x xVar) {
        Object objG = kVar.f75c.g(xVar);
        if (objG == null) {
            return null;
        }
        return objG;
    }

    public static final boolean e(p pVar) {
        g1 g1VarD = pVar.d();
        f0 f0Var = pVar.f88d.f75c;
        return (g1VarD != null ? g1VarD.P0() : false) || f0Var.c(u.f131p) || f0Var.c(u.f130o);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean f(a2.p r14) {
        /*
            boolean r0 = e(r14)
            r1 = 0
            if (r0 != 0) goto L5b
            a2.k r14 = r14.f88d
            boolean r0 = r14.f77g
            if (r0 != 0) goto L59
            p.f0 r14 = r14.f75c
            java.lang.Object[] r0 = r14.f9553b
            java.lang.Object[] r2 = r14.f9554c
            long[] r14 = r14.f9552a
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
            a2.x r11 = (a2.x) r11
            boolean r10 = r11.f147c
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
        throw new UnsupportedOperationException("Method not decompiled: a2.s.f(a2.p):boolean");
    }
}
