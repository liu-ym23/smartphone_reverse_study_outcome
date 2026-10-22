package y;

import androidx.compose.ui.semantics.AppendedSemanticsElement;
import b0.z1;
import j1.g1;
import java.util.concurrent.atomic.AtomicInteger;
import n.f1;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final float f11537a;

    /* renamed from: b, reason: collision with root package name */
    public static final float f11538b;

    /* renamed from: c, reason: collision with root package name */
    public static final n.r f11539c;

    static {
        float f10 = 10;
        f11537a = f10;
        androidx.compose.foundation.layout.a.e(androidx.compose.ui.layout.a.a(x.f11536g).c(new AppendedSemanticsElement(e.f11379i, true)), 0, f10);
        f11538b = a0.g.f66b - (a0.g.f65a * 2);
        new n.r(0.2f, 0.0f, 0.8f);
        new n.r(0.4f, 0.0f, 1.0f);
        new n.r(0.0f, 0.0f, 0.65f);
        new n.r(0.1f, 0.0f, 0.45f);
        f11539c = new n.r(0.4f, 0.0f, 0.2f);
    }

    public static final void a(n0.m mVar, long j2, float f10, long j4, int i2, b0.p pVar, int i10) {
        long j10;
        int i11;
        n0.m mVar2;
        int i12;
        Float fValueOf = Float.valueOf(290.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        pVar.T(-115871647);
        if (((i10 | 25600) & 9363) == 9362 && pVar.z()) {
            pVar.O();
            mVar2 = mVar;
            j10 = j4;
            i12 = i2;
        } else {
            pVar.Q();
            if ((i10 & 1) == 0 || pVar.x()) {
                int i13 = t.f11520a;
                j10 = u0.m.f9915e;
                i11 = t.f11520a;
            } else {
                pVar.O();
                j10 = j4;
                i11 = i2;
            }
            pVar.r();
            w0.g gVar = new w0.g(((d2.c) pVar.j(g1.f5174h)).o(f10), i11, 26);
            Object objJ = pVar.J();
            Object obj = b0.k.f1229a;
            if (objJ == obj) {
                objJ = new n.d0();
                pVar.b0(objJ);
            }
            n.d0 d0Var = (n.d0) objJ;
            d0Var.a(0, pVar);
            q6.b bVar = n.g1.f6622b;
            b4.b bVar2 = n.u.f6737b;
            n.a0 a0VarD = n.d.d(d0Var, 0, 5, bVar, n.d.h(new f1(6660, bVar2)), pVar, 33208, 16);
            n.a0 a0VarC = n.d.c(d0Var, 286.0f, n.d.h(new f1(1332, bVar2)), pVar);
            d1.b bVar3 = new d1.b(5);
            bVar3.f2767g = 1332;
            n.f0 f0VarD = bVar3.d(fValueOf2, 0);
            n.r rVar = f11539c;
            f0VarD.f6608b = rVar;
            bVar3.d(fValueOf, 666);
            n.a0 a0VarC2 = n.d.c(d0Var, 290.0f, n.d.h(new n.g0(bVar3)), pVar);
            d1.b bVar4 = new d1.b(5);
            bVar4.f2767g = 1332;
            bVar4.d(fValueOf2, 666).f6608b = rVar;
            bVar4.d(fValueOf, bVar4.f2767g);
            n.a0 a0VarC3 = n.d.c(d0Var, 290.0f, n.d.h(new n.g0(bVar4)), pVar);
            o.k kVar = o.k.f7073i;
            AtomicInteger atomicInteger = p1.j.f8308a;
            AppendedSemanticsElement appendedSemanticsElement = new AppendedSemanticsElement(kVar, true);
            mVar2 = mVar;
            n0.m mVarG = androidx.compose.foundation.layout.a.g(mVar2.c(appendedSemanticsElement), f11538b);
            boolean zE = pVar.e(j10) | pVar.h(gVar) | pVar.f(a0VarD) | pVar.f(a0VarC2) | pVar.f(a0VarC3) | pVar.f(a0VarC);
            Object objJ2 = pVar.J();
            if (zE || objJ2 == obj) {
                i12 = i11;
                Object uVar = new u(j10, gVar, a0VarD, a0VarC2, a0VarC3, a0VarC, f10, j2);
                pVar.b0(uVar);
                objJ2 = uVar;
            } else {
                i12 = i11;
            }
            n7.b.a(mVarG, (p7.k) objJ2, pVar, 0);
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new v(mVar2, j2, f10, j10, i12, i10);
        }
    }

    public static final void b(w0.d dVar, float f10, float f11, long j2, w0.g gVar) {
        float f12 = 2;
        float f13 = gVar.f10636b / f12;
        float fD = t0.e.d(dVar.d()) - (f12 * f13);
        dVar.z(j2, f10, f11, n7.b.b(f13, f13), nb.i.e(fD, fD), gVar);
    }
}
