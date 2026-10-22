package y2;

import java.util.Iterator;
import java.util.Set;

/* renamed from: y2.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5925f {
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
