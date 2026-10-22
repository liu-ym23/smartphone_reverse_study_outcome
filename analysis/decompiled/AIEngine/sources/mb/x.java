package mb;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class x extends y {
    public static Set T(Set set, Iterable elements) {
        kotlin.jvm.internal.g.f(set, "<this>");
        kotlin.jvm.internal.g.f(elements, "elements");
        Collection<?> collectionO0 = elements instanceof Collection ? (Collection) elements : kotlin.collections.a.O0(elements);
        if (collectionO0.isEmpty()) {
            return kotlin.collections.a.R0(set);
        }
        if (!(collectionO0 instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionO0);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!((Set) collectionO0).contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static Set U(Object... objArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(v.a0(objArr.length));
        l.n0(objArr, linkedHashSet);
        return linkedHashSet;
    }

    public static LinkedHashSet V(LinkedHashSet linkedHashSet, String str) {
        kotlin.jvm.internal.g.f(linkedHashSet, "<this>");
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(v.a0(linkedHashSet.size() + 1));
        linkedHashSet2.addAll(linkedHashSet);
        linkedHashSet2.add(str);
        return linkedHashSet2;
    }

    public static LinkedHashSet W(Set set, Iterable elements) {
        kotlin.jvm.internal.g.f(set, "<this>");
        kotlin.jvm.internal.g.f(elements, "elements");
        Integer numValueOf = elements instanceof Collection ? Integer.valueOf(((Collection) elements).size()) : null;
        LinkedHashSet linkedHashSet = new LinkedHashSet(v.a0(numValueOf != null ? set.size() + numValueOf.intValue() : set.size() * 2));
        linkedHashSet.addAll(set);
        q.g0(linkedHashSet, elements);
        return linkedHashSet;
    }
}
