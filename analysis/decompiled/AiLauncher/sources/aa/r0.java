package aa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import ya.G0;

/* loaded from: classes5.dex */
public final class r0 {
    public static final C1261i a(C1261i c1261i, Collection<C1261i> superQualifiers, boolean z10, boolean z11, boolean z12) {
        NullabilityQualifier nullabilityQualifierF;
        kotlin.jvm.internal.p.i(c1261i, "<this>");
        kotlin.jvm.internal.p.i(superQualifiers, "superQualifiers");
        Collection<C1261i> collection = superQualifiers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            NullabilityQualifier nullabilityQualifierB = b((C1261i) it.next());
            if (nullabilityQualifierB != null) {
                arrayList.add(nullabilityQualifierB);
            }
        }
        NullabilityQualifier nullabilityQualifierF2 = f(Z8.F.r1(arrayList), b(c1261i), z10);
        if (nullabilityQualifierF2 == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                NullabilityQualifier nullabilityQualifierF3 = ((C1261i) it2.next()).f();
                if (nullabilityQualifierF3 != null) {
                    arrayList2.add(nullabilityQualifierF3);
                }
            }
            nullabilityQualifierF = f(Z8.F.r1(arrayList2), c1261i.f(), z10);
        } else {
            nullabilityQualifierF = nullabilityQualifierF2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it3 = collection.iterator();
        while (it3.hasNext()) {
            MutabilityQualifier mutabilityQualifierE = ((C1261i) it3.next()).e();
            if (mutabilityQualifierE != null) {
                arrayList3.add(mutabilityQualifierE);
            }
        }
        MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) e(Z8.F.r1(arrayList3), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, c1261i.e(), z10);
        if (nullabilityQualifierF == null || z12 || (z11 && nullabilityQualifierF == NullabilityQualifier.NULLABLE)) {
            nullabilityQualifierF = null;
        }
        boolean z13 = false;
        boolean z14 = nullabilityQualifierF != null && nullabilityQualifierF2 == null;
        if (nullabilityQualifierF == NullabilityQualifier.NOT_NULL) {
            if (d(c1261i, z14)) {
                z13 = true;
                break;
            }
            if (!collection.isEmpty()) {
                Iterator<T> it4 = collection.iterator();
                while (it4.hasNext()) {
                    if (d((C1261i) it4.next(), z14)) {
                        z13 = true;
                        break;
                    }
                }
            }
        }
        return new C1261i(nullabilityQualifierF, mutabilityQualifier, z13, z14);
    }

    public static final NullabilityQualifier b(C1261i c1261i) {
        if (c1261i.g()) {
            return null;
        }
        return c1261i.f();
    }

    public static final boolean c(G0 g02, Ca.g type) {
        kotlin.jvm.internal.p.i(g02, "<this>");
        kotlin.jvm.internal.p.i(type, "type");
        ga.c ENHANCED_NULLABILITY_ANNOTATION = S9.F.f5704v;
        kotlin.jvm.internal.p.h(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return g02.u0(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    public static final boolean d(C1261i c1261i, boolean z10) {
        return c1261i.g() == z10 && c1261i.d();
    }

    public static final <T> T e(Set<? extends T> set, T t10, T t11, T t12, boolean z10) {
        Set<? extends T> setR1;
        if (!z10) {
            if (t12 != null && (setR1 = Z8.F.r1(Z8.Z.p(set, t12))) != null) {
                set = setR1;
            }
            return (T) Z8.F.Y0(set);
        }
        T t13 = set.contains(t10) ? t10 : set.contains(t11) ? t11 : null;
        if (kotlin.jvm.internal.p.d(t13, t10) && kotlin.jvm.internal.p.d(t12, t11)) {
            return null;
        }
        return t12 == null ? t13 : t12;
    }

    public static final NullabilityQualifier f(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z10) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) e(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z10);
    }
}
