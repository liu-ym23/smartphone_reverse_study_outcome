package e8;

import D7.v;
import D7.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f4380a;

    static {
        Set<PrimitiveType> set = PrimitiveType.e;
        ArrayList arrayList = new ArrayList(w.c0(set, 10));
        for (PrimitiveType primitiveType : set) {
            kotlin.jvm.internal.k.f(primitiveType, "primitiveType");
            arrayList.add(o.l.c(primitiveType.f4943a));
        }
        ArrayList arrayListR0 = v.R0(v.R0(v.R0(arrayList, n.f.g()), n.h.g()), n.f4417j.g());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayListR0.iterator();
        while (it.hasNext()) {
            G8.c topLevelFqName = (G8.c) it.next();
            kotlin.jvm.internal.k.f(topLevelFqName, "topLevelFqName");
            G8.c cVarE = topLevelFqName.e();
            G8.f fVarF = topLevelFqName.f();
            kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
            linkedHashSet.add(new G8.b(cVarE, fVarF));
        }
        f4380a = linkedHashSet;
    }
}
