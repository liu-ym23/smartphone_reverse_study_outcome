package E9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes5.dex */
public final class J {
    public static final void a(F f10, ga.c fqName, Collection<E> packageFragments) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(packageFragments, "packageFragments");
        if (f10 instanceof K) {
            ((K) f10).a(fqName, packageFragments);
        } else {
            packageFragments.addAll(f10.b(fqName));
        }
    }

    public static final boolean b(F f10, ga.c fqName) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return f10 instanceof K ? ((K) f10).c(fqName) : c(f10, fqName).isEmpty();
    }

    public static final List<E> c(F f10, ga.c fqName) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        kotlin.jvm.internal.p.i(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        a(f10, fqName, arrayList);
        return arrayList;
    }
}
