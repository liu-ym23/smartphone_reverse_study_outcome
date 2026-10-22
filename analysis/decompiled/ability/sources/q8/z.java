package q8;

import D7.N;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$TypeSafeBarrierDescription;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes4.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f5620a;
    public static final ArrayList b;
    public static final Object c;
    public static final LinkedHashMap d;
    public static final Set e;
    public static final Set f;
    public static final y g;
    public static final Object h;
    public static final LinkedHashMap i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashSet f5621j;
    public static final LinkedHashMap k;

    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v32, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.Object, java.util.Map] */
    static {
        Set<String> setK0 = D7.q.K0(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(D7.w.c0(setK0, 10));
        for (String str : setK0) {
            String strC = JvmPrimitiveType.BOOLEAN.c();
            kotlin.jvm.internal.k.e(strC, "getDesc(...)");
            arrayList.add(C1838k.a("java/util/Collection", str, "Ljava/util/Collection;", strC));
        }
        f5620a = arrayList;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((y) it.next()).e);
        }
        b = arrayList2;
        ArrayList arrayList3 = f5620a;
        ArrayList arrayList4 = new ArrayList(D7.w.c0(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((y) it2.next()).b.b());
        }
        String strConcat = "java/util/".concat("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String strC2 = jvmPrimitiveType.c();
        kotlin.jvm.internal.k.e(strC2, "getDesc(...)");
        y yVarA = C1838k.a(strConcat, "contains", "Ljava/lang/Object;", strC2);
        SpecialGenericSignatures$TypeSafeBarrierDescription specialGenericSignatures$TypeSafeBarrierDescription = SpecialGenericSignatures$TypeSafeBarrierDescription.d;
        Pair pair = new Pair(yVarA, specialGenericSignatures$TypeSafeBarrierDescription);
        String strConcat2 = "java/util/".concat("Collection");
        String strC3 = jvmPrimitiveType.c();
        kotlin.jvm.internal.k.e(strC3, "getDesc(...)");
        Pair pair2 = new Pair(C1838k.a(strConcat2, "remove", "Ljava/lang/Object;", strC3), specialGenericSignatures$TypeSafeBarrierDescription);
        String strConcat3 = "java/util/".concat("Map");
        String strC4 = jvmPrimitiveType.c();
        kotlin.jvm.internal.k.e(strC4, "getDesc(...)");
        Pair pair3 = new Pair(C1838k.a(strConcat3, "containsKey", "Ljava/lang/Object;", strC4), specialGenericSignatures$TypeSafeBarrierDescription);
        String strConcat4 = "java/util/".concat("Map");
        String strC5 = jvmPrimitiveType.c();
        kotlin.jvm.internal.k.e(strC5, "getDesc(...)");
        Pair pair4 = new Pair(C1838k.a(strConcat4, "containsValue", "Ljava/lang/Object;", strC5), specialGenericSignatures$TypeSafeBarrierDescription);
        String strConcat5 = "java/util/".concat("Map");
        String strC6 = jvmPrimitiveType.c();
        kotlin.jvm.internal.k.e(strC6, "getDesc(...)");
        Pair pair5 = new Pair(C1838k.a(strConcat5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", strC6), specialGenericSignatures$TypeSafeBarrierDescription);
        Pair pair6 = new Pair(C1838k.a("java/util/".concat("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), SpecialGenericSignatures$TypeSafeBarrierDescription.e);
        y yVarA2 = C1838k.a("java/util/".concat("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        SpecialGenericSignatures$TypeSafeBarrierDescription specialGenericSignatures$TypeSafeBarrierDescription2 = SpecialGenericSignatures$TypeSafeBarrierDescription.b;
        Pair pair7 = new Pair(yVarA2, specialGenericSignatures$TypeSafeBarrierDescription2);
        Pair pair8 = new Pair(C1838k.a("java/util/".concat("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), specialGenericSignatures$TypeSafeBarrierDescription2);
        String strConcat6 = "java/util/".concat("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String strC7 = jvmPrimitiveType2.c();
        kotlin.jvm.internal.k.e(strC7, "getDesc(...)");
        y yVarA3 = C1838k.a(strConcat6, "indexOf", "Ljava/lang/Object;", strC7);
        SpecialGenericSignatures$TypeSafeBarrierDescription specialGenericSignatures$TypeSafeBarrierDescription3 = SpecialGenericSignatures$TypeSafeBarrierDescription.c;
        Pair pair9 = new Pair(yVarA3, specialGenericSignatures$TypeSafeBarrierDescription3);
        String strConcat7 = "java/util/".concat("List");
        String strC8 = jvmPrimitiveType2.c();
        kotlin.jvm.internal.k.e(strC8, "getDesc(...)");
        Map mapR = kotlin.collections.a.R(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, new Pair(C1838k.a(strConcat7, "lastIndexOf", "Ljava/lang/Object;", strC8), specialGenericSignatures$TypeSafeBarrierDescription3));
        c = mapR;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(mapR.size()));
        for (Map.Entry entry : mapR.entrySet()) {
            linkedHashMap.put(((y) entry.getKey()).e, entry.getValue());
        }
        d = linkedHashMap;
        LinkedHashSet linkedHashSetL = N.L(c.keySet(), f5620a);
        ArrayList arrayList5 = new ArrayList(D7.w.c0(linkedHashSetL, 10));
        Iterator it3 = linkedHashSetL.iterator();
        while (it3.hasNext()) {
            arrayList5.add(((y) it3.next()).b);
        }
        e = D7.v.j1(arrayList5);
        ArrayList arrayList6 = new ArrayList(D7.w.c0(linkedHashSetL, 10));
        Iterator it4 = linkedHashSetL.iterator();
        while (it4.hasNext()) {
            arrayList6.add(((y) it4.next()).e);
        }
        f = D7.v.j1(arrayList6);
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String strC9 = jvmPrimitiveType3.c();
        kotlin.jvm.internal.k.e(strC9, "getDesc(...)");
        y yVarA4 = C1838k.a("java/util/List", "removeAt", strC9, "Ljava/lang/Object;");
        g = yVarA4;
        String strConcat8 = "java/lang/".concat("Number");
        String strC10 = JvmPrimitiveType.BYTE.c();
        kotlin.jvm.internal.k.e(strC10, "getDesc(...)");
        Pair pair10 = new Pair(C1838k.a(strConcat8, "toByte", "", strC10), G8.f.e("byteValue"));
        String strConcat9 = "java/lang/".concat("Number");
        String strC11 = JvmPrimitiveType.SHORT.c();
        kotlin.jvm.internal.k.e(strC11, "getDesc(...)");
        Pair pair11 = new Pair(C1838k.a(strConcat9, "toShort", "", strC11), G8.f.e("shortValue"));
        String strConcat10 = "java/lang/".concat("Number");
        String strC12 = jvmPrimitiveType3.c();
        kotlin.jvm.internal.k.e(strC12, "getDesc(...)");
        Pair pair12 = new Pair(C1838k.a(strConcat10, "toInt", "", strC12), G8.f.e("intValue"));
        String strConcat11 = "java/lang/".concat("Number");
        String strC13 = JvmPrimitiveType.LONG.c();
        kotlin.jvm.internal.k.e(strC13, "getDesc(...)");
        Pair pair13 = new Pair(C1838k.a(strConcat11, "toLong", "", strC13), G8.f.e("longValue"));
        String strConcat12 = "java/lang/".concat("Number");
        String strC14 = JvmPrimitiveType.FLOAT.c();
        kotlin.jvm.internal.k.e(strC14, "getDesc(...)");
        Pair pair14 = new Pair(C1838k.a(strConcat12, "toFloat", "", strC14), G8.f.e("floatValue"));
        String strConcat13 = "java/lang/".concat("Number");
        String strC15 = JvmPrimitiveType.DOUBLE.c();
        kotlin.jvm.internal.k.e(strC15, "getDesc(...)");
        Pair pair15 = new Pair(C1838k.a(strConcat13, "toDouble", "", strC15), G8.f.e("doubleValue"));
        Pair pair16 = new Pair(yVarA4, G8.f.e("remove"));
        String strConcat14 = "java/lang/".concat("CharSequence");
        String strC16 = jvmPrimitiveType3.c();
        kotlin.jvm.internal.k.e(strC16, "getDesc(...)");
        String strC17 = JvmPrimitiveType.CHAR.c();
        kotlin.jvm.internal.k.e(strC17, "getDesc(...)");
        Map mapR2 = kotlin.collections.a.R(pair10, pair11, pair12, pair13, pair14, pair15, pair16, new Pair(C1838k.a(strConcat14, "get", strC16, strC17), G8.f.e("charAt")));
        h = mapR2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.collections.a.P(mapR2.size()));
        for (Map.Entry entry2 : mapR2.entrySet()) {
            linkedHashMap2.put(((y) entry2.getKey()).e, entry2.getValue());
        }
        i = linkedHashMap2;
        ?? r02 = h;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry entry3 : r02.entrySet()) {
            y yVar = (y) entry3.getKey();
            G8.f name = (G8.f) entry3.getValue();
            String classInternalName = yVar.f5619a;
            String str2 = yVar.c;
            String str3 = yVar.d;
            kotlin.jvm.internal.k.f(classInternalName, "classInternalName");
            kotlin.jvm.internal.k.f(name, "name");
            String jvmDescriptor = name + '(' + str2 + ')' + str3;
            kotlin.jvm.internal.k.f(jvmDescriptor, "jvmDescriptor");
            linkedHashSet.add(classInternalName + '.' + jvmDescriptor);
        }
        Set setKeySet = h.keySet();
        HashSet hashSet = new HashSet();
        Iterator it5 = setKeySet.iterator();
        while (it5.hasNext()) {
            hashSet.add(((y) it5.next()).b);
        }
        f5621j = hashSet;
        Set<Map.Entry> setEntrySet = h.entrySet();
        ArrayList arrayList7 = new ArrayList(D7.w.c0(setEntrySet, 10));
        for (Map.Entry entry4 : setEntrySet) {
            arrayList7.add(new Pair(((y) entry4.getKey()).b, entry4.getValue()));
        }
        int iP = kotlin.collections.a.P(D7.w.c0(arrayList7, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iP);
        Iterator it6 = arrayList7.iterator();
        while (it6.hasNext()) {
            Pair pair17 = (Pair) it6.next();
            linkedHashMap3.put((G8.f) pair17.b, (G8.f) pair17.f4886a);
        }
        k = linkedHashMap3;
    }
}
