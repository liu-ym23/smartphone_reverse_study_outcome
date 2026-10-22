package d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class x extends w {
    public static void D0(Collection collection, Iterable iterable) {
        q7.k.e(collection, "<this>");
        q7.k.e(iterable, "elements");
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static boolean E0(List list, p7.k kVar) {
        int i2;
        if (!(list instanceof RandomAccess)) {
            if ((list instanceof r7.a) && !(list instanceof r7.b)) {
                q7.z.g(list, "kotlin.collections.MutableIterable");
                throw null;
            }
            Iterator it = list.iterator();
            boolean z4 = false;
            while (it.hasNext()) {
                if (((Boolean) kVar.invoke(it.next())).booleanValue()) {
                    it.remove();
                    z4 = true;
                }
            }
            return z4;
        }
        int iT0 = s.t0(list);
        if (iT0 >= 0) {
            int i10 = 0;
            i2 = 0;
            while (true) {
                Object obj = list.get(i10);
                if (!((Boolean) kVar.invoke(obj)).booleanValue()) {
                    if (i2 != i10) {
                        list.set(i2, obj);
                    }
                    i2++;
                }
                if (i10 == iT0) {
                    break;
                }
                i10++;
            }
        } else {
            i2 = 0;
        }
        if (i2 >= list.size()) {
            return false;
        }
        int iT02 = s.t0(list);
        if (i2 <= iT02) {
            while (true) {
                list.remove(iT02);
                if (iT02 == i2) {
                    break;
                }
                iT02--;
            }
        }
        return true;
    }
}
