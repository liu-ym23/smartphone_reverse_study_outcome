package d9;

import d7.r;
import d7.s;
import java.util.LinkedHashMap;
import java.util.List;
import q7.k;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3001a = r.U0(s.u0('k', 'o', 't', 'l', 'i', 'n'), "", null, null, null, 62);

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f3002b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listU0 = s.u0("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int iB = ib.c.B(0, listU0.size() - 1, 2);
        if (iB >= 0) {
            int i2 = 0;
            while (true) {
                StringBuilder sb2 = new StringBuilder();
                String str = f3001a;
                sb2.append(str);
                sb2.append('/');
                sb2.append((String) listU0.get(i2));
                int i10 = i2 + 1;
                linkedHashMap.put(sb2.toString(), listU0.get(i10));
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append('/');
                linkedHashMap.put(a1.a.m(sb3, (String) listU0.get(i2), "Array"), "[" + ((String) listU0.get(i10)));
                if (i2 == iB) {
                    break;
                } else {
                    i2 += 2;
                }
            }
        }
        linkedHashMap.put(f3001a + "/Unit", "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : s.u0("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : s.u0("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, a1.a.w("collections/", str3), "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i11 = 0; i11 < 23; i11++) {
            String strC = n.f.c(i11, "Function");
            StringBuilder sb4 = new StringBuilder();
            String str4 = f3001a;
            sb4.append(str4);
            sb4.append("/jvm/functions/Function");
            sb4.append(i11);
            a(linkedHashMap, strC, sb4.toString());
            a(linkedHashMap, "reflect/KFunction" + i11, str4 + "/reflect/KFunction");
        }
        for (String str5 : s.u0("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, a1.a.i(str5, ".Companion"), f3001a + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f3002b = linkedHashMap;
    }

    public static final void a(LinkedHashMap linkedHashMap, String str, String str2) {
        linkedHashMap.put(f3001a + '/' + str, "L" + str2 + ';');
    }

    public static final String b(String str) {
        k.e(str, "classId");
        String str2 = (String) f3002b.get(str);
        if (str2 != null) {
            return str2;
        }
        return "L" + ga.r.d0(str, '.', '$') + ';';
    }
}
