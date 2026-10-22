package t9;

import f8.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z8.p0;
import z8.t0;
import z8.u0;

/* loaded from: classes.dex */
public final class t extends i8.c {

    /* renamed from: p, reason: collision with root package name */
    public final r9.k f9856p;

    /* renamed from: q, reason: collision with root package name */
    public final u0 f9857q;

    /* renamed from: r, reason: collision with root package name */
    public final a f9858r;

    /* JADX WARN: Illegal instructions before constructor call */
    public t(r9.k kVar, u0 u0Var, int i2) {
        int i10;
        r9.i iVar = (r9.i) kVar.f9070f;
        u9.k kVar2 = iVar.f9047a;
        f8.j jVar = (f8.j) kVar.f9072h;
        e9.f fVarY = nb.i.y((b9.f) kVar.f9071g, u0Var.f12392j);
        t0 t0Var = u0Var.f12394l;
        q7.k.d(t0Var, "proto.variance");
        int iOrdinal = t0Var.ordinal();
        int i11 = 2;
        if (iOrdinal != 0) {
            i10 = 1;
            if (iOrdinal == 1) {
                i11 = 3;
                i10 = i11;
            } else if (iOrdinal != 2) {
                throw new a4.u();
            }
        } else {
            i10 = i11;
        }
        super(kVar2, jVar, g8.h.f3888a, fVarY, i10, u0Var.f12393k, i2, o0.f3504h);
        this.f9856p = kVar;
        this.f9857q = u0Var;
        this.f9858r = new a(iVar.f9047a, new h(2, this));
    }

    @Override // i8.h
    public final List H0() {
        r9.k kVar = this.f9856p;
        b9.g gVar = (b9.g) kVar.f9073i;
        u0 u0Var = this.f9857q;
        q7.k.e(u0Var, "<this>");
        List list = u0Var.f12395m;
        if (list.isEmpty()) {
            list = null;
        }
        if (list == null) {
            List<Integer> list2 = u0Var.f12396n;
            q7.k.d(list2, "upperBoundIdList");
            ArrayList arrayList = new ArrayList(d7.t.A0(list2, 10));
            for (Integer num : list2) {
                q7.k.d(num, "it");
                arrayList.add(gVar.a(num.intValue()));
            }
            list = arrayList;
        }
        if (list.isEmpty()) {
            return a.a.S(l9.d.e(this).m());
        }
        a7.g gVar2 = (a7.g) kVar.f9077m;
        ArrayList arrayList2 = new ArrayList(d7.t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(gVar2.x((p0) it.next()));
        }
        return arrayList2;
    }

    @Override // a4.d, g8.a
    public final g8.j getAnnotations() {
        return this.f9858r;
    }
}
