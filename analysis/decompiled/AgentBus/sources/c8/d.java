package c8;

import d7.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f1993a;

    static {
        Set<j> set = j.f2006j;
        ArrayList arrayList = new ArrayList(t.A0(set, 10));
        for (j jVar : set) {
            q7.k.e(jVar, "primitiveType");
            arrayList.add(n.f2066k.c(jVar.f2016f));
        }
        ArrayList arrayListD1 = d7.r.d1(d7.r.d1(d7.r.d1(arrayList, m.f2035f.g()), m.f2037h.g()), m.f2039j.g());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayListD1.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(e9.b.j((e9.c) it.next()));
        }
        f1993a = linkedHashSet;
    }
}
