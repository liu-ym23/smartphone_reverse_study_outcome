package r9;

import f8.e0;
import f8.n0;
import i8.c0;
import i8.r0;
import j1.j1;
import java.util.ArrayList;
import java.util.List;
import z8.d1;
import z8.f0;
import z8.p0;
import z8.x0;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final k f9100a;

    /* renamed from: b, reason: collision with root package name */
    public final nb.f f9101b;

    public r(k kVar) {
        this.f9100a = kVar;
        i iVar = (i) kVar.f9070f;
        this.f9101b = new nb.f(iVar.f9048b, iVar.f9058l);
    }

    public final a4.e a(f8.j jVar) {
        if (jVar instanceof e0) {
            e9.c cVar = ((c0) ((e0) jVar)).f4758j;
            k kVar = this.f9100a;
            return new t(cVar, (b9.f) kVar.f9071g, (b9.g) kVar.f9073i, (t9.j) kVar.f9076l);
        }
        if (jVar instanceof t9.i) {
            return ((t9.i) jVar).A;
        }
        return null;
    }

    public final g8.j b(f9.l lVar, int i2, int i10) {
        return !b9.e.f1560c.e(i2).booleanValue() ? g8.h.f3888a : new t9.u(((i) this.f9100a.f9070f).f9047a, new o(this, lVar, i10, 0));
    }

    public final g8.j c(f0 f0Var, boolean z4) {
        return !b9.e.f1560c.e(f0Var.f12135i).booleanValue() ? g8.h.f3888a : new t9.u(((i) this.f9100a.f9070f).f9047a, new j1(this, z4, f0Var));
    }

    public final t9.c d(z8.k kVar, boolean z4) {
        k kVar2 = this.f9100a;
        f8.j jVar = (f8.j) kVar2.f9072h;
        q7.k.c(jVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        f8.e eVar = (f8.e) jVar;
        t9.c cVar = new t9.c(eVar, null, b(kVar, kVar.f12229i, 1), z4, 1, kVar, (b9.f) kVar2.f9071g, (b9.g) kVar2.f9073i, (b9.h) kVar2.f9074j, (t9.j) kVar2.f9076l, null);
        r rVar = (r) kVar2.b(cVar, d7.z.f2978f, (b9.f) kVar2.f9071g, (b9.g) kVar2.f9073i, (b9.h) kVar2.f9074j, (b9.a) kVar2.f9075k).f9078n;
        List list = kVar.f12230j;
        q7.k.d(list, "proto.valueParameterList");
        cVar.U0(rVar.g(list, kVar, 1), n7.a.h((d1) b9.e.f1561d.e(kVar.f12229i)));
        cVar.Q0(eVar.k());
        cVar.f4886w = eVar.Z();
        cVar.A = !b9.e.f1571n.e(kVar.f12229i).booleanValue();
        return cVar;
    }

    public final t9.r e(z8.x xVar) {
        int i2;
        v9.v vVarX;
        k kVar = this.f9100a;
        b9.f fVar = (b9.f) kVar.f9071g;
        b9.g gVar = (b9.g) kVar.f9073i;
        q7.k.e(xVar, "proto");
        int i10 = 1;
        if ((xVar.f12445h & 1) == 1) {
            i2 = xVar.f12446i;
        } else {
            int i11 = xVar.f12447j;
            i2 = ((i11 >> 8) << 6) + (i11 & 63);
        }
        int i12 = i2;
        g8.j jVarB = b(xVar, i12, 1);
        int i13 = xVar.f12445h;
        int i14 = i13 & 32;
        g8.g gVar2 = g8.h.f3888a;
        g8.j aVar = (i14 == 32 || (i13 & 64) == 64) ? new t9.a(((i) kVar.f9070f).f9047a, new o(this, xVar, i10, 1)) : gVar2;
        t9.r rVar = new t9.r((f8.j) kVar.f9072h, null, jVarB, nb.i.y(fVar, xVar.f12448k), n7.a.s((z8.y) b9.e.f1572o.e(i12)), xVar, (b9.f) kVar.f9071g, gVar, l9.d.g((f8.j) kVar.f9072h).c(nb.i.y(fVar, xVar.f12448k)).equals(w.f9108a) ? b9.h.f1585b : (b9.h) kVar.f9074j, (t9.j) kVar.f9076l, null);
        List list = xVar.f12451n;
        q7.k.d(list, "proto.typeParameterList");
        k kVarB = kVar.b(rVar, list, (b9.f) kVar.f9071g, (b9.g) kVar.f9073i, (b9.h) kVar.f9074j, (b9.a) kVar.f9075k);
        a7.g gVar3 = (a7.g) kVarB.f9077m;
        p0 p0VarC0 = a.a.c0(xVar, gVar);
        i8.v vVarK = (p0VarC0 == null || (vVarX = gVar3.x(p0VarC0)) == null) ? null : h9.m.k(rVar, vVarX, aVar);
        f8.j jVar = (f8.j) kVar.f9072h;
        f8.e eVar = jVar instanceof f8.e ? (f8.e) jVar : null;
        i8.v vVarB0 = eVar != null ? eVar.B0() : null;
        List list2 = xVar.f12454q;
        if (list2.isEmpty()) {
            list2 = null;
        }
        if (list2 == null) {
            List<Integer> list3 = xVar.f12455r;
            q7.k.d(list3, "contextReceiverTypeIdList");
            ArrayList arrayList = new ArrayList(d7.t.A0(list3, 10));
            for (Integer num : list3) {
                q7.k.d(num, "it");
                arrayList.add(gVar.a(num.intValue()));
            }
            list2 = arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int i15 = 0;
        for (Object obj : list2) {
            int i16 = i15 + 1;
            if (i15 < 0) {
                d7.s.z0();
                throw null;
            }
            i8.v vVarE = h9.m.e(rVar, gVar3.x((p0) obj), null, gVar2, i15);
            if (vVarE != null) {
                arrayList2.add(vVarE);
            }
            i15 = i16;
        }
        List listN = gVar3.n();
        r rVar2 = (r) kVarB.f9078n;
        List list4 = xVar.f12457t;
        q7.k.d(list4, "proto.valueParameterList");
        rVar.U0(vVarK, vVarB0, arrayList2, listN, rVar2.g(list4, xVar, 1), gVar3.x(a.a.g0(xVar, gVar)), j.d((z8.z) b9.e.f1562e.e(i12)), n7.a.h((d1) b9.e.f1561d.e(i12)), d7.a0.f2944f);
        rVar.f4881r = b9.e.f1573p.e(i12).booleanValue();
        rVar.f4882s = b9.e.f1574q.e(i12).booleanValue();
        rVar.f4883t = b9.e.f1577t.e(i12).booleanValue();
        rVar.f4884u = b9.e.f1575r.e(i12).booleanValue();
        rVar.f4885v = b9.e.f1576s.e(i12).booleanValue();
        rVar.f4889z = b9.e.f1578u.e(i12).booleanValue();
        rVar.f4886w = b9.e.f1579v.e(i12).booleanValue();
        rVar.A = !b9.e.f1580w.e(i12).booleanValue();
        ((i) kVar.f9070f).f9059m.getClass();
        return rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0110  */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [i8.k0] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r3v26, types: [u9.h] */
    /* JADX WARN: Type inference failed for: r5v0, types: [f8.b, f8.l0, i8.i0, i8.n, t9.q] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t9.q f(z8.f0 r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 959
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.r.f(z8.f0):t9.q");
    }

    public final List g(List list, f9.l lVar, int i2) {
        int i10;
        g8.j uVar;
        r rVar = this;
        k kVar = rVar.f9100a;
        b9.g gVar = (b9.g) kVar.f9073i;
        a7.g gVar2 = (a7.g) kVar.f9077m;
        f8.j jVar = (f8.j) kVar.f9072h;
        q7.k.c(jVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        f8.b bVar = (f8.b) jVar;
        f8.j jVarP = bVar.p();
        q7.k.d(jVarP, "callableDescriptor.containingDeclaration");
        a4.e eVarA = rVar.a(jVarP);
        ArrayList arrayList = new ArrayList(d7.t.A0(list, 10));
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            v9.v vVarX = null;
            if (i11 < 0) {
                d7.s.z0();
                throw null;
            }
            x0 x0Var = (x0) obj;
            int i13 = (x0Var.f12466h & 1) == 1 ? x0Var.f12467i : 0;
            if (eVarA == null || !b9.e.f1560c.e(i13).booleanValue()) {
                i10 = i11;
                uVar = g8.h.f3888a;
            } else {
                i10 = i11;
                uVar = new t9.u(((i) kVar.f9070f).f9047a, new q(rVar, eVarA, lVar, i2, i10, x0Var));
            }
            e9.f fVarY = nb.i.y((b9.f) kVar.f9071g, x0Var.f12468j);
            v9.v vVarX2 = gVar2.x(a.a.n0(x0Var, gVar));
            boolean zBooleanValue = b9.e.G.e(i13).booleanValue();
            boolean zBooleanValue2 = b9.e.H.e(i13).booleanValue();
            boolean zBooleanValue3 = b9.e.I.e(i13).booleanValue();
            int i14 = x0Var.f12466h;
            p0 p0VarA = (i14 & 16) == 16 ? x0Var.f12471m : (i14 & 32) == 32 ? gVar.a(x0Var.f12472n) : null;
            if (p0VarA != null) {
                vVarX = gVar2.x(p0VarA);
            }
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new r0(bVar, null, i10, uVar, fVarY, vVarX2, zBooleanValue, zBooleanValue2, zBooleanValue3, vVarX, n0.f3487b));
            arrayList = arrayList2;
            i11 = i12;
            rVar = this;
        }
        return d7.r.m1(arrayList);
    }
}
