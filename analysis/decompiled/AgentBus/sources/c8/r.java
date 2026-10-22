package c8;

import d7.e0;
import i8.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import v9.v;
import v9.x0;

/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f2083a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f2084b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f2085c;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashSet f2086d;

    static {
        q[] qVarArrValues = q.values();
        ArrayList arrayList = new ArrayList(qVarArrValues.length);
        for (q qVar : qVarArrValues) {
            arrayList.add(qVar.f2081g);
        }
        f2083a = d7.r.q1(arrayList);
        p[] pVarArrValues = p.values();
        ArrayList arrayList2 = new ArrayList(pVarArrValues.length);
        for (p pVar : pVarArrValues) {
            arrayList2.add(pVar.f2078f);
        }
        d7.r.q1(arrayList2);
        f2084b = new HashMap();
        f2085c = new HashMap();
        e0.Y(new HashMap(e0.S(4)), new c7.j[]{new c7.j(p.UBYTEARRAY, e9.f.e("ubyteArrayOf")), new c7.j(p.USHORTARRAY, e9.f.e("ushortArrayOf")), new c7.j(p.UINTARRAY, e9.f.e("uintArrayOf")), new c7.j(p.ULONGARRAY, e9.f.e("ulongArrayOf"))});
        q[] qVarArrValues2 = q.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (q qVar2 : qVarArrValues2) {
            linkedHashSet.add(qVar2.f2082h.i());
        }
        f2086d = linkedHashSet;
        for (q qVar3 : q.values()) {
            HashMap map = f2084b;
            e9.b bVar = qVar3.f2082h;
            e9.b bVar2 = qVar3.f2080f;
            map.put(bVar, bVar2);
            f2085c.put(bVar2, qVar3.f2082h);
        }
    }

    public static final boolean a(v vVar) {
        f8.g gVarC;
        if (x0.l(vVar) || (gVarC = vVar.E0().c()) == null) {
            return false;
        }
        f8.j jVarP = gVarC.p();
        return (jVarP instanceof f8.e0) && q7.k.a(((c0) ((f8.e0) jVarP)).f4758j, n.f2066k) && f2083a.contains(gVarC.getName());
    }
}
