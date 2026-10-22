package A2;

import java.util.Iterator;
import java.util.Set;

/* renamed from: A2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0576b {
    public static int a(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}
