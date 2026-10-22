package Z8;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0006\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a.\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\t\u0010\u0004\u001a4\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "element", "n", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "", "elements", "m", "(Ljava/util/Set;Ljava/lang/Iterable;)Ljava/util/Set;", "p", "o", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
/* loaded from: classes4.dex */
public class Z extends Y {
    public static <T> Set<T> m(Set<? extends T> set, Iterable<? extends T> elements) {
        kotlin.jvm.internal.p.i(set, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        Collection<?> collectionG = A.G(elements);
        if (collectionG.isEmpty()) {
            return F.r1(set);
        }
        if (!(collectionG instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionG);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t10 : set) {
            if (!((Set) collectionG).contains(t10)) {
                linkedHashSet2.add(t10);
            }
        }
        return linkedHashSet2;
    }

    public static <T> Set<T> n(Set<? extends T> set, T t10) {
        kotlin.jvm.internal.p.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(Q.e(set.size()));
        boolean z10 = false;
        for (T t11 : set) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.p.d(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                linkedHashSet.add(t11);
            }
        }
        return linkedHashSet;
    }

    public static <T> Set<T> o(Set<? extends T> set, Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.p.i(set, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        Integer numY = C1174w.y(elements);
        if (numY != null) {
            size = set.size() + numY.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(Q.e(size));
        linkedHashSet.addAll(set);
        A.E(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static <T> Set<T> p(Set<? extends T> set, T t10) {
        kotlin.jvm.internal.p.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(Q.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t10);
        return linkedHashSet;
    }
}
