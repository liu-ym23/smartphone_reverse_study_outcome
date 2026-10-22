package d8;

import a4.u;
import c8.n;
import d7.r;
import d7.s;
import d7.t;
import f8.o0;
import f8.v;
import f8.z;
import i8.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import q7.k;
import v9.i0;
import v9.q0;

/* loaded from: classes.dex */
public final class b extends v9.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f2981c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(cVar.f2984j);
        this.f2981c = cVar;
    }

    @Override // v9.m0
    public final boolean a() {
        return true;
    }

    @Override // v9.b, v9.m0
    public final f8.g c() {
        return this.f2981c;
    }

    @Override // v9.f
    public final Collection e() {
        List<e9.b> listS;
        Iterable iterableS;
        c cVar = this.f2981c;
        int i2 = cVar.f2987m;
        int iOrdinal = cVar.f2986l.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            listS = a.a.S(c.f2982q);
        } else if (iOrdinal == 2) {
            listS = s.u0(c.f2983r, new e9.b(n.f2066k, e.f2994i.a(i2)));
        } else {
            if (iOrdinal != 3) {
                throw new u();
            }
            listS = s.u0(c.f2983r, new e9.b(n.f2060e, e.f2995j.a(i2)));
        }
        z zVarP = ((c0) cVar.f2985k).p();
        ArrayList arrayList = new ArrayList(t.A0(listS, 10));
        for (e9.b bVar : listS) {
            f8.e eVarD = v.d(zVarP, bVar);
            if (eVarD == null) {
                throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
            }
            List list = cVar.f2990p;
            int size = eVarD.h().getParameters().size();
            k.e(list, "<this>");
            if (size < 0) {
                throw new IllegalArgumentException(a1.a.f(size, "Requested element count ", " is less than zero.").toString());
            }
            if (size == 0) {
                iterableS = d7.z.f2978f;
            } else {
                int size2 = list.size();
                if (size >= size2) {
                    iterableS = r.m1(list);
                } else if (size == 1) {
                    iterableS = a.a.S(r.W0(list));
                } else {
                    ArrayList arrayList2 = new ArrayList(size);
                    if (list instanceof RandomAccess) {
                        for (int i10 = size2 - size; i10 < size2; i10++) {
                            arrayList2.add(list.get(i10));
                        }
                    } else {
                        ListIterator listIterator = list.listIterator(size2 - size);
                        while (listIterator.hasNext()) {
                            arrayList2.add(listIterator.next());
                        }
                    }
                    iterableS = arrayList2;
                }
            }
            ArrayList arrayList3 = new ArrayList(t.A0(iterableS, 10));
            Iterator it = iterableS.iterator();
            while (it.hasNext()) {
                arrayList3.add(new q0(((f8.q0) it.next()).k()));
            }
            i0.f10557g.getClass();
            arrayList.add(v9.d.q(i0.f10558h, eVarD, arrayList3));
        }
        return r.m1(arrayList);
    }

    @Override // v9.f
    public final o0 g() {
        return o0.f3504h;
    }

    @Override // v9.m0
    public final List getParameters() {
        return this.f2981c.f2990p;
    }

    @Override // v9.b
    /* renamed from: l */
    public final f8.e c() {
        return this.f2981c;
    }

    public final String toString() {
        return this.f2981c.toString();
    }
}
