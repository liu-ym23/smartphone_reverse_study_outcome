package ra;

import Z8.A;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ra.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5240m {
    public static final Set<ga.e> a(Iterable<? extends InterfaceC5238k> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends InterfaceC5238k> it = iterable.iterator();
        while (it.hasNext()) {
            Set<ga.e> setF = it.next().f();
            if (setF == null) {
                return null;
            }
            A.E(hashSet, setF);
        }
        return hashSet;
    }
}
