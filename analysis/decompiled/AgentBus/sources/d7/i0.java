package d7;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class i0 extends ib.k {
    public static LinkedHashSet Y(Set set, Iterable iterable) {
        q7.k.e(set, "<this>");
        q7.k.e(iterable, "elements");
        Integer numValueOf = iterable instanceof Collection ? Integer.valueOf(((Collection) iterable).size()) : null;
        LinkedHashSet linkedHashSet = new LinkedHashSet(e0.S(numValueOf != null ? set.size() + numValueOf.intValue() : set.size() * 2));
        linkedHashSet.addAll(set);
        x.D0(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static LinkedHashSet Z(Set set, Object obj) {
        q7.k.e(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(e0.S(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
