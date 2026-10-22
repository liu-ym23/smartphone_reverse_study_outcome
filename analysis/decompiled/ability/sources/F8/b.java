package F8;

import D7.v;
import H4.o;
import Z6.k;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.JsonPointer;
import j9.t;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f589a = v.I0(o.N('k', 'o', 't', 'l', 'i', 'n'), "", null, null, null, 62);
    public static final LinkedHashMap b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listN = o.N("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int iD = k.D(0, listN.size() - 1, 2);
        if (iD >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f589a;
                sb.append(str);
                sb.append(JsonPointer.SEPARATOR);
                sb.append((String) listN.get(i));
                int i6 = i + 1;
                linkedHashMap.put(sb.toString(), listN.get(i6));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(JsonPointer.SEPARATOR);
                linkedHashMap.put(B7.a.q(sb2, (String) listN.get(i), "Array"), "[" + ((String) listN.get(i6)));
                if (i == iD) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        linkedHashMap.put(f589a + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : o.N("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : o.N("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, B7.a.k("collections/", str3), "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i10 = 0; i10 < 23; i10++) {
            String strH = B7.a.h(i10, "Function");
            StringBuilder sb3 = new StringBuilder();
            String str4 = f589a;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i10);
            a(linkedHashMap, strH, sb3.toString());
            a(linkedHashMap, "reflect/KFunction" + i10, str4 + "/reflect/KFunction");
        }
        for (String str5 : o.N("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, androidx.appfunctions.metadata.a.l(str5, ".Companion"), androidx.appfunctions.metadata.a.p(new StringBuilder(), f589a, "/jvm/internal/", str5, "CompanionObject"));
        }
        b = linkedHashMap;
    }

    public static final void a(LinkedHashMap linkedHashMap, String str, String str2) {
        linkedHashMap.put(f589a + JsonPointer.SEPARATOR + str, "L" + str2 + ';');
    }

    public static final String b(String classId) {
        kotlin.jvm.internal.k.f(classId, "classId");
        String str = (String) b.get(classId);
        if (str != null) {
            return str;
        }
        return "L" + t.b0(classId, '.', '$') + ';';
    }
}
