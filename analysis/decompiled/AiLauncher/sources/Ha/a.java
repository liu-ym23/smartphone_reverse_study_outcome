package Ha;

import Ia.j;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.p;
import ra.InterfaceC5238k;

/* loaded from: classes5.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        p.i(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final j<InterfaceC5238k> b(Iterable<? extends InterfaceC5238k> scopes) {
        p.i(scopes, "scopes");
        j<InterfaceC5238k> jVar = new j<>();
        for (InterfaceC5238k interfaceC5238k : scopes) {
            InterfaceC5238k interfaceC5238k2 = interfaceC5238k;
            if (interfaceC5238k2 != null && interfaceC5238k2 != InterfaceC5238k.b.f38898b) {
                jVar.add(interfaceC5238k);
            }
        }
        return jVar;
    }
}
