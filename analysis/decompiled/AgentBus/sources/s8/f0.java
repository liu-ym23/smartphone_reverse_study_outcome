package s8;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v9.x0;

/* loaded from: classes.dex */
public final class f0 extends i8.c {

    /* renamed from: p, reason: collision with root package name */
    public final a3.b f9552p;

    /* renamed from: q, reason: collision with root package name */
    public final l8.c0 f9553q;

    /* JADX WARN: Illegal instructions before constructor call */
    public f0(a3.b bVar, l8.c0 c0Var, int i2, f8.k kVar) {
        q7.k.e(c0Var, "javaTypeParameter");
        r8.a aVar = (r8.a) bVar.f162f;
        super(aVar.f9002a, kVar, new r8.d(bVar, c0Var, false), e9.f.e(c0Var.f5856a.getName()), 1, false, i2, aVar.f9014m);
        this.f9552p = bVar;
        this.f9553q = c0Var;
    }

    @Override // i8.h
    public final List G0(List list) {
        f0 f0Var;
        w8.d dVar;
        a3.b bVar = this.f9552p;
        w8.d dVar2 = ((r8.a) bVar.f162f).f9019r;
        dVar2.getClass();
        ArrayList arrayList = new ArrayList(d7.t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v9.v vVarB = (v9.v) it.next();
            w8.m mVar = w8.m.f10916k;
            q7.k.e(vVarB, "<this>");
            if (x0.c(vVarB, mVar, null)) {
                f0Var = this;
                dVar = dVar2;
            } else {
                f0Var = this;
                dVar = dVar2;
                vVarB = dVar.b(new w8.o(f0Var, false, bVar, o8.a.TYPE_PARAMETER_BOUNDS, false), vVarB, d7.z.f2978f, null, false);
                if (vVarB == null) {
                    vVarB = vVarB;
                }
            }
            arrayList.add(vVarB);
            this = f0Var;
            dVar2 = dVar;
        }
        return arrayList;
    }

    @Override // i8.h
    public final List H0() {
        Type[] bounds = this.f9553q.f5856a.getBounds();
        q7.k.d(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new l8.q(type));
        }
        l8.q qVar = (l8.q) d7.r.h1(arrayList);
        List list = arrayList;
        if (q7.k.a(qVar != null ? qVar.f5880a : null, Object.class)) {
            list = d7.z.f2978f;
        }
        boolean zIsEmpty = list.isEmpty();
        a3.b bVar = this.f9552p;
        if (zIsEmpty) {
            return a.a.S(v9.d.j(((r8.a) bVar.f162f).f9016o.n().e(), ((r8.a) bVar.f162f).f9016o.n().o()));
        }
        ArrayList arrayList2 = new ArrayList(d7.t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((i5.l) bVar.f166j).R((l8.q) it.next(), n7.b.x(2, false, this, 3)));
        }
        return arrayList2;
    }
}
