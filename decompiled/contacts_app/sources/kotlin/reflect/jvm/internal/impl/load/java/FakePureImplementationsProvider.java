package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

/* JADX INFO: compiled from: FakePureImplementationsProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE = null;
    private static final Map<ClassId, ClassId> pureImplementationsClassIds = null;
    private static final Map<FqName, FqName> pureImplementationsFqNames = null;

    private FakePureImplementationsProvider() {
    }

    public final FqName getPurelyImplementedInterface(FqName r1) {
        Intrinsics.checkNotNullParameter(r1, "classFqName");
        return pureImplementationsFqNames.get(r1);
    }

    static {
        FakePureImplementationsProvider r0 = new FakePureImplementationsProvider();
        INSTANCE = r0;
        LinkedHashMap r1 = new LinkedHashMap();
        pureImplementationsClassIds = r1;
        r0.implementedWith(StandardClassIds.INSTANCE.getMutableList(), r0.fqNameListOf(new String[]{"java.util.ArrayList", "java.util.LinkedList"}));
        r0.implementedWith(StandardClassIds.INSTANCE.getMutableSet(), r0.fqNameListOf(new String[]{"java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"}));
        r0.implementedWith(StandardClassIds.INSTANCE.getMutableMap(), r0.fqNameListOf(new String[]{"java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"}));
        ClassId r2 = ClassId.topLevel(new FqName("java.util.function.Function"));
        Intrinsics.checkNotNullExpressionValue(r2, "topLevel(FqName(\"java.util.function.Function\"))");
        r0.implementedWith(r2, r0.fqNameListOf(new String[]{"java.util.function.UnaryOperator"}));
        ClassId r3 = ClassId.topLevel(new FqName("java.util.function.BiFunction"));
        Intrinsics.checkNotNullExpressionValue(r3, "topLevel(FqName(\"java.util.function.BiFunction\"))");
        r0.implementedWith(r3, r0.fqNameListOf(new String[]{"java.util.function.BinaryOperator"}));
        ArrayList r4 = new ArrayList(r1.size());
        Iterator r5 = r1.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r6 = (Map.Entry) r5.next();
        ClassId r7 = (ClassId) r6.getKey();
        ClassId r8 = (ClassId) r6.getValue();
        r4.add(TuplesKt.to(r7.asSingleFqName(), r8.asSingleFqName()));
        goto L4
    L6:
        pureImplementationsFqNames = MapsKt.toMap(r4);
    }

    private final void implementedWith(ClassId r3, List<ClassId> r4) {
        Map<ClassId, ClassId> r2 = pureImplementationsClassIds;
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Object r0 = r5.next();
        ClassId r1 = (ClassId) r0;
        r2.put((ClassId) r0, r3);
        goto L4
    }

    private final List<ClassId> fqNameListOf(String... r5) {
        ArrayList r4 = new ArrayList(r5.length);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r4.add(ClassId.topLevel(new FqName(r5[r1])));
        r1 = r1 + 1;
        goto L3
    L6:
        return r4;
    }
}
