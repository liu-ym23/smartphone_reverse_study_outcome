package W3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends t {
    public static <T> boolean t(Collection<? super T> collection, Iterable<? extends T> iterable) {
        j4.k.g(collection, "<this>");
        j4.k.g(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z5 = true;
            }
        }
        return z5;
    }

    public static <T> boolean u(Collection<? super T> collection, T[] tArr) {
        j4.k.g(collection, "<this>");
        j4.k.g(tArr, "elements");
        return collection.addAll(C0399j.c(tArr));
    }

    public static <T> T v(List<T> list) {
        j4.k.g(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(p.j(list));
    }
}
