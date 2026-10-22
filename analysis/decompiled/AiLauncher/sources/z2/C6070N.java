package z2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: z2.N, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6070N {
    public static int a(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static boolean b(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean c(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof InterfaceC6067K) {
            collection = ((InterfaceC6067K) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return d(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean d(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
