package o8;

import d7.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f7814a;

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f7815b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f7816c;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f7817d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set f7818e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set f7819f;

    /* renamed from: g, reason: collision with root package name */
    public static final c0 f7820g;

    /* renamed from: h, reason: collision with root package name */
    public static final Object f7821h;

    /* renamed from: i, reason: collision with root package name */
    public static final LinkedHashMap f7822i;

    /* renamed from: j, reason: collision with root package name */
    public static final ArrayList f7823j;

    /* renamed from: k, reason: collision with root package name */
    public static final LinkedHashMap f7824k;

    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.Object, java.util.Map] */
    static {
        Set<String> setX0 = d7.n.x0(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(d7.t.A0(setX0, 10));
        for (String str : setX0) {
            String strC = m9.c.BOOLEAN.c();
            q7.k.d(strC, "BOOLEAN.desc");
            arrayList.add(m.a("java/util/Collection", str, "Ljava/util/Collection;", strC));
        }
        f7814a = arrayList;
        ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((c0) it.next()).f7797b);
        }
        f7815b = arrayList2;
        ArrayList arrayList3 = f7814a;
        ArrayList arrayList4 = new ArrayList(d7.t.A0(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((c0) it2.next()).f7796a.b());
        }
        String strConcat = "java/util/".concat("Collection");
        m9.c cVar = m9.c.BOOLEAN;
        String strC2 = cVar.c();
        q7.k.d(strC2, "BOOLEAN.desc");
        c0 c0VarA = m.a(strConcat, "contains", "Ljava/lang/Object;", strC2);
        e0 e0Var = e0.f7809i;
        c7.j jVar = new c7.j(c0VarA, e0Var);
        String strConcat2 = "java/util/".concat("Collection");
        String strC3 = cVar.c();
        q7.k.d(strC3, "BOOLEAN.desc");
        c7.j jVar2 = new c7.j(m.a(strConcat2, "remove", "Ljava/lang/Object;", strC3), e0Var);
        String strConcat3 = "java/util/".concat("Map");
        String strC4 = cVar.c();
        q7.k.d(strC4, "BOOLEAN.desc");
        c7.j jVar3 = new c7.j(m.a(strConcat3, "containsKey", "Ljava/lang/Object;", strC4), e0Var);
        String strConcat4 = "java/util/".concat("Map");
        String strC5 = cVar.c();
        q7.k.d(strC5, "BOOLEAN.desc");
        c7.j jVar4 = new c7.j(m.a(strConcat4, "containsValue", "Ljava/lang/Object;", strC5), e0Var);
        String strConcat5 = "java/util/".concat("Map");
        String strC6 = cVar.c();
        q7.k.d(strC6, "BOOLEAN.desc");
        c7.j jVar5 = new c7.j(m.a(strConcat5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", strC6), e0Var);
        c7.j jVar6 = new c7.j(m.a("java/util/".concat("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), e0.f7810j);
        c0 c0VarA2 = m.a("java/util/".concat("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        e0 e0Var2 = e0.f7807g;
        c7.j jVar7 = new c7.j(c0VarA2, e0Var2);
        c7.j jVar8 = new c7.j(m.a("java/util/".concat("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), e0Var2);
        String strConcat6 = "java/util/".concat("List");
        m9.c cVar2 = m9.c.INT;
        String strC7 = cVar2.c();
        q7.k.d(strC7, "INT.desc");
        c0 c0VarA3 = m.a(strConcat6, "indexOf", "Ljava/lang/Object;", strC7);
        e0 e0Var3 = e0.f7808h;
        c7.j jVar9 = new c7.j(c0VarA3, e0Var3);
        String strConcat7 = "java/util/".concat("List");
        String strC8 = cVar2.c();
        q7.k.d(strC8, "INT.desc");
        Map mapU = d7.e0.U(jVar, jVar2, jVar3, jVar4, jVar5, jVar6, jVar7, jVar8, jVar9, new c7.j(m.a(strConcat7, "lastIndexOf", "Ljava/lang/Object;", strC8), e0Var3));
        f7816c = mapU;
        LinkedHashMap linkedHashMap = new LinkedHashMap(d7.e0.S(mapU.size()));
        for (Map.Entry entry : mapU.entrySet()) {
            linkedHashMap.put(((c0) entry.getKey()).f7797b, entry.getValue());
        }
        f7817d = linkedHashMap;
        LinkedHashSet linkedHashSetY = i0.Y(f7816c.keySet(), f7814a);
        ArrayList arrayList5 = new ArrayList(d7.t.A0(linkedHashSetY, 10));
        Iterator it3 = linkedHashSetY.iterator();
        while (it3.hasNext()) {
            arrayList5.add(((c0) it3.next()).f7796a);
        }
        f7818e = d7.r.q1(arrayList5);
        ArrayList arrayList6 = new ArrayList(d7.t.A0(linkedHashSetY, 10));
        Iterator it4 = linkedHashSetY.iterator();
        while (it4.hasNext()) {
            arrayList6.add(((c0) it4.next()).f7797b);
        }
        f7819f = d7.r.q1(arrayList6);
        m9.c cVar3 = m9.c.INT;
        String strC9 = cVar3.c();
        q7.k.d(strC9, "INT.desc");
        c0 c0VarA4 = m.a("java/util/List", "removeAt", strC9, "Ljava/lang/Object;");
        f7820g = c0VarA4;
        String strConcat8 = "java/lang/".concat("Number");
        String strC10 = m9.c.BYTE.c();
        q7.k.d(strC10, "BYTE.desc");
        c7.j jVar10 = new c7.j(m.a(strConcat8, "toByte", "", strC10), e9.f.e("byteValue"));
        String strConcat9 = "java/lang/".concat("Number");
        String strC11 = m9.c.SHORT.c();
        q7.k.d(strC11, "SHORT.desc");
        c7.j jVar11 = new c7.j(m.a(strConcat9, "toShort", "", strC11), e9.f.e("shortValue"));
        String strConcat10 = "java/lang/".concat("Number");
        String strC12 = cVar3.c();
        q7.k.d(strC12, "INT.desc");
        c7.j jVar12 = new c7.j(m.a(strConcat10, "toInt", "", strC12), e9.f.e("intValue"));
        String strConcat11 = "java/lang/".concat("Number");
        String strC13 = m9.c.LONG.c();
        q7.k.d(strC13, "LONG.desc");
        c7.j jVar13 = new c7.j(m.a(strConcat11, "toLong", "", strC13), e9.f.e("longValue"));
        String strConcat12 = "java/lang/".concat("Number");
        String strC14 = m9.c.FLOAT.c();
        q7.k.d(strC14, "FLOAT.desc");
        c7.j jVar14 = new c7.j(m.a(strConcat12, "toFloat", "", strC14), e9.f.e("floatValue"));
        String strConcat13 = "java/lang/".concat("Number");
        String strC15 = m9.c.DOUBLE.c();
        q7.k.d(strC15, "DOUBLE.desc");
        c7.j jVar15 = new c7.j(m.a(strConcat13, "toDouble", "", strC15), e9.f.e("doubleValue"));
        c7.j jVar16 = new c7.j(c0VarA4, e9.f.e("remove"));
        String strConcat14 = "java/lang/".concat("CharSequence");
        String strC16 = cVar3.c();
        q7.k.d(strC16, "INT.desc");
        String strC17 = m9.c.CHAR.c();
        q7.k.d(strC17, "CHAR.desc");
        Map mapU2 = d7.e0.U(jVar10, jVar11, jVar12, jVar13, jVar14, jVar15, jVar16, new c7.j(m.a(strConcat14, "get", strC16, strC17), e9.f.e("charAt")));
        f7821h = mapU2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(d7.e0.S(mapU2.size()));
        for (Map.Entry entry2 : mapU2.entrySet()) {
            linkedHashMap2.put(((c0) entry2.getKey()).f7797b, entry2.getValue());
        }
        f7822i = linkedHashMap2;
        Set setKeySet = f7821h.keySet();
        ArrayList arrayList7 = new ArrayList(d7.t.A0(setKeySet, 10));
        Iterator it5 = setKeySet.iterator();
        while (it5.hasNext()) {
            arrayList7.add(((c0) it5.next()).f7796a);
        }
        f7823j = arrayList7;
        Set<Map.Entry> setEntrySet = f7821h.entrySet();
        ArrayList arrayList8 = new ArrayList(d7.t.A0(setEntrySet, 10));
        for (Map.Entry entry3 : setEntrySet) {
            arrayList8.add(new c7.j(((c0) entry3.getKey()).f7796a, entry3.getValue()));
        }
        int iS = d7.e0.S(d7.t.A0(arrayList8, 10));
        if (iS < 16) {
            iS = 16;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iS);
        Iterator it6 = arrayList8.iterator();
        while (it6.hasNext()) {
            c7.j jVar17 = (c7.j) it6.next();
            linkedHashMap3.put((e9.f) jVar17.f1974g, (e9.f) jVar17.f1973f);
        }
        f7824k = linkedHashMap3;
    }
}
