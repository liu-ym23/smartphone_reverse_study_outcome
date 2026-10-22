package t9;

import f8.l0;
import f8.m0;
import f8.n0;
import f8.o0;
import f8.r0;
import i8.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import z8.c1;
import z8.d1;
import z8.p0;
import z8.v0;
import z8.z;

/* loaded from: classes.dex */
public final class i extends i8.b implements f8.j {
    public final r9.s A;
    public final g8.j B;

    /* renamed from: j, reason: collision with root package name */
    public final z8.i f9802j;

    /* renamed from: k, reason: collision with root package name */
    public final b9.a f9803k;

    /* renamed from: l, reason: collision with root package name */
    public final n0 f9804l;

    /* renamed from: m, reason: collision with root package name */
    public final e9.b f9805m;

    /* renamed from: n, reason: collision with root package name */
    public final int f9806n;

    /* renamed from: o, reason: collision with root package name */
    public final f8.n f9807o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9808p;

    /* renamed from: q, reason: collision with root package name */
    public final r9.k f9809q;

    /* renamed from: r, reason: collision with root package name */
    public final o9.o f9810r;

    /* renamed from: s, reason: collision with root package name */
    public final s8.h f9811s;

    /* renamed from: t, reason: collision with root package name */
    public final m0 f9812t;

    /* renamed from: u, reason: collision with root package name */
    public final i5.f f9813u;

    /* renamed from: v, reason: collision with root package name */
    public final f8.j f9814v;

    /* renamed from: w, reason: collision with root package name */
    public final u9.h f9815w;

    /* renamed from: x, reason: collision with root package name */
    public final u9.i f9816x;

    /* renamed from: y, reason: collision with root package name */
    public final u9.i f9817y;

    /* renamed from: z, reason: collision with root package name */
    public final u9.h f9818z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(r9.k kVar, z8.i iVar, b9.f fVar, b9.a aVar, n0 n0Var) {
        int i2;
        super(((r9.i) kVar.f9070f).f9047a, nb.i.s(fVar, iVar.f12189j).i());
        q7.k.e(kVar, "outerContext");
        q7.k.e(iVar, "classProto");
        q7.k.e(fVar, "nameResolver");
        q7.k.e(n0Var, "sourceElement");
        this.f9802j = iVar;
        this.f9803k = aVar;
        this.f9804l = n0Var;
        this.f9805m = nb.i.s(fVar, iVar.f12189j);
        this.f9806n = r9.j.d((z) b9.e.f1562e.e(iVar.f12188i));
        this.f9807o = n7.a.h((d1) b9.e.f1561d.e(iVar.f12188i));
        z8.h hVar = (z8.h) b9.e.f1563f.e(iVar.f12188i);
        int i10 = 4;
        int i11 = 5;
        int i12 = 2;
        int i13 = 3;
        int i14 = 1;
        switch (hVar == null ? -1 : r9.u.$EnumSwitchMapping$3[hVar.ordinal()]) {
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            case 5:
                i2 = 5;
                break;
            case 6:
            case 7:
                i2 = 6;
                break;
            default:
                i2 = 1;
                break;
        }
        this.f9808p = i2;
        List list = iVar.f12191l;
        q7.k.d(list, "classProto.typeParameterList");
        v0 v0Var = iVar.J;
        q7.k.d(v0Var, "classProto.typeTable");
        b9.g gVar = new b9.g(v0Var);
        b9.h hVar2 = b9.h.f1585b;
        c1 c1Var = iVar.L;
        q7.k.d(c1Var, "classProto.versionRequirementTable");
        r9.k kVarB = kVar.b(this, list, fVar, gVar, ib.c.t(c1Var), aVar);
        r9.i iVar2 = (r9.i) kVarB.f9070f;
        this.f9809q = kVarB;
        this.f9810r = i2 == 3 ? new o9.s(iVar2.f9047a, this) : o9.m.f7933b;
        this.f9811s = new s8.h(this);
        o0 o0Var = m0.f3480d;
        u9.k kVar2 = iVar2.f9047a;
        u9.k kVar3 = iVar2.f9047a;
        ((w9.m) iVar2.f9063q).getClass();
        s8.l lVar = new s8.l(i14, i12, this);
        o0Var.getClass();
        q7.k.e(kVar2, "storageManager");
        this.f9812t = new m0(this, kVar2, lVar);
        this.f9813u = i2 == 3 ? new i5.f(this) : null;
        f8.j jVar = (f8.j) kVar.f9072h;
        this.f9814v = jVar;
        g gVar2 = new g(this, i10);
        kVar3.getClass();
        this.f9815w = new u9.h(kVar3, gVar2);
        this.f9816x = new u9.i(kVar3, new g(this, i13));
        new u9.h(kVar3, new g(this, i12));
        this.f9817y = new u9.i(kVar3, new g(this, i11));
        this.f9818z = new u9.h(kVar3, new g(this, 6));
        b9.f fVar2 = (b9.f) kVarB.f9071g;
        b9.g gVar3 = (b9.g) kVarB.f9073i;
        i iVar3 = jVar instanceof i ? (i) jVar : null;
        this.A = new r9.s(iVar, fVar2, gVar3, n0Var, iVar3 != null ? iVar3.A : null);
        this.B = !b9.e.f1560c.e(iVar.f12188i).booleanValue() ? g8.h.f3888a : new u(kVar3, new g(this, i14));
    }

    @Override // f8.e
    public final boolean A0() {
        return b9.e.f1565h.e(this.f9802j.f12188i).booleanValue();
    }

    @Override // f8.e
    public final int B() {
        return this.f9808p;
    }

    @Override // f8.e
    public final boolean C() {
        return b9.e.f1563f.e(this.f9802j.f12188i) == z8.h.COMPANION_OBJECT;
    }

    public final f C0() {
        ((w9.m) ((r9.i) this.f9809q.f9070f).f9063q).getClass();
        m0 m0Var = this.f9812t;
        l9.d.j(m0Var.f3482a);
        return (f) ((o9.n) n7.b.q(m0Var.f3484c, m0.f3481e[0]));
    }

    public final v9.z D0(e9.f fVar) {
        Iterator it = C0().a(fVar, n8.c.f6883l).iterator();
        boolean z4 = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z4) {
                    break;
                }
            } else {
                Object next = it.next();
                if (((l0) next).I() == null) {
                    if (z4) {
                        break;
                    }
                    z4 = true;
                    obj = next;
                }
            }
        }
        obj = null;
        l0 l0Var = (l0) obj;
        return (v9.z) (l0Var != null ? l0Var.getType() : null);
    }

    @Override // f8.e
    public final Collection E() {
        return (Collection) this.f9816x.c();
    }

    @Override // f8.e
    public final boolean J() {
        return b9.e.f1569l.e(this.f9802j.f12188i).booleanValue();
    }

    @Override // i8.z
    public final o9.n T(w9.g gVar) {
        m0 m0Var = this.f9812t;
        l9.d.j(m0Var.f3482a);
        return (o9.n) n7.b.q(m0Var.f3484c, m0.f3481e[0]);
    }

    @Override // f8.e
    public final Collection U() {
        return (Collection) this.f9817y.c();
    }

    @Override // f8.w
    public final boolean Z() {
        return b9.e.f1567j.e(this.f9802j.f12188i).booleanValue();
    }

    @Override // f8.e, f8.m, f8.w
    public final f8.n c() {
        return this.f9807o;
    }

    @Override // f8.e
    public final boolean e() {
        if (!b9.e.f1568k.e(this.f9802j.f12188i).booleanValue()) {
            return false;
        }
        b9.a aVar = this.f9803k;
        int i2 = aVar.f1550b;
        if (i2 >= 1) {
            if (i2 > 1) {
                return false;
            }
            int i10 = aVar.f1551c;
            if (i10 >= 4 && (i10 > 4 || aVar.f1552d > 1)) {
                return false;
            }
        }
        return true;
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        return this.B;
    }

    @Override // f8.g
    public final v9.m0 h() {
        return this.f9811s;
    }

    @Override // f8.e, f8.w
    public final int i() {
        return this.f9806n;
    }

    @Override // f8.e
    public final r0 i0() {
        return (r0) this.f9818z.c();
    }

    @Override // f8.e
    public final i8.i k0() {
        return (i8.i) this.f9815w.c();
    }

    @Override // f8.e
    public final boolean l() {
        return b9.e.f1568k.e(this.f9802j.f12188i).booleanValue() && this.f9803k.a(1, 4, 2);
    }

    @Override // f8.e
    public final o9.n l0() {
        return this.f9810r;
    }

    @Override // f8.h
    public final boolean m() {
        return b9.e.f1564g.e(this.f9802j.f12188i).booleanValue();
    }

    @Override // f8.j
    public final f8.j p() {
        return this.f9814v;
    }

    @Override // f8.k
    public final n0 q() {
        return this.f9804l;
    }

    @Override // f8.w
    public final boolean r0() {
        return false;
    }

    @Override // f8.e, f8.h
    public final List s() {
        return ((a7.g) this.f9809q.f9077m).n();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("deserialized ");
        sb2.append(Z() ? "expect " : "");
        sb2.append("class ");
        sb2.append(getName());
        return sb2.toString();
    }

    @Override // f8.w
    public final boolean w() {
        return b9.e.f1566i.e(this.f9802j.f12188i).booleanValue();
    }

    @Override // i8.b, f8.e
    public final List w0() {
        r9.k kVar = this.f9809q;
        b9.g gVar = (b9.g) kVar.f9073i;
        z8.i iVar = this.f9802j;
        q7.k.e(iVar, "<this>");
        List list = iVar.f12197r;
        if (list.isEmpty()) {
            list = null;
        }
        if (list == null) {
            List<Integer> list2 = iVar.f12198s;
            q7.k.d(list2, "contextReceiverTypeIdList");
            ArrayList arrayList = new ArrayList(d7.t.A0(list2, 10));
            for (Integer num : list2) {
                q7.k.d(num, "it");
                arrayList.add(gVar.a(num.intValue()));
            }
            list = arrayList;
        }
        ArrayList arrayList2 = new ArrayList(d7.t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(new v(B0(), new p9.a(this, ((a7.g) kVar.f9077m).x((p0) it.next()), (e9.f) null), g8.h.f3888a));
        }
        return arrayList2;
    }
}
