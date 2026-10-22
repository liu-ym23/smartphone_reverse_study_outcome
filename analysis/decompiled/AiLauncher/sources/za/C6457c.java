package za;

import Z8.C1174w;
import Z8.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.AbstractC5974I;
import ya.AbstractC5990d0;
import ya.C5970E;
import ya.C5977L;
import ya.K0;
import ya.V;
import ya.W;

/* renamed from: za.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6457c {
    public static final K0 a(Collection<? extends K0> types) {
        AbstractC5990d0 abstractC5990d0P0;
        kotlin.jvm.internal.p.i(types, "types");
        int size = types.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types");
        }
        if (size == 1) {
            return (K0) F.W0(types);
        }
        Collection<? extends K0> collection = types;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        boolean z10 = false;
        boolean z11 = false;
        for (K0 k02 : collection) {
            z10 = z10 || W.a(k02);
            if (k02 instanceof AbstractC5990d0) {
                abstractC5990d0P0 = (AbstractC5990d0) k02;
            } else {
                if (!(k02 instanceof AbstractC5974I)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (C5970E.a(k02)) {
                    return k02;
                }
                abstractC5990d0P0 = ((AbstractC5974I) k02).P0();
                z11 = true;
            }
            arrayList.add(abstractC5990d0P0);
        }
        if (z10) {
            return Aa.i.d(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, types.toString());
        }
        if (!z11) {
            return TypeIntersector.f36097a.d(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList2.add(C5977L.d((K0) it.next()));
        }
        TypeIntersector typeIntersector = TypeIntersector.f36097a;
        return V.e(typeIntersector.d(arrayList), typeIntersector.d(arrayList2));
    }
}
