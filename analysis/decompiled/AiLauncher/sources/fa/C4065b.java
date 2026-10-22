package fa;

import La.D;
import Z8.C1173v;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.fasterxml.jackson.core.JsonPointer;
import i9.C4180c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.p;

/* renamed from: fa.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4065b {

    /* renamed from: a, reason: collision with root package name */
    public static final C4065b f32574a = new C4065b();

    /* renamed from: b, reason: collision with root package name */
    public static final String f32575b = F.A0(C1173v.p('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f32576c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listP = C1173v.p("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int iC = C4180c.c(0, listP.size() - 1, 2);
        if (iC >= 0) {
            int i10 = 0;
            while (true) {
                StringBuilder sb2 = new StringBuilder();
                String str = f32575b;
                sb2.append(str);
                sb2.append(JsonPointer.SEPARATOR);
                sb2.append((String) listP.get(i10));
                int i11 = i10 + 1;
                linkedHashMap.put(sb2.toString(), listP.get(i11));
                linkedHashMap.put(str + JsonPointer.SEPARATOR + ((String) listP.get(i10)) + "Array", '[' + ((String) listP.get(i11)));
                if (i10 == iC) {
                    break;
                } else {
                    i10 += 2;
                }
            }
        }
        linkedHashMap.put(f32575b + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : C1173v.p("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : C1173v.p("Iterator", CoreUtil.STR_DEX_COLLECTION_NAME, "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i12 = 0; i12 < 23; i12++) {
            StringBuilder sb3 = new StringBuilder();
            String str4 = f32575b;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i12);
            a(linkedHashMap, "Function" + i12, sb3.toString());
            a(linkedHashMap, "reflect/KFunction" + i12, str4 + "/reflect/KFunction");
        }
        for (String str5 : C1173v.p("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, str5 + ".Companion", f32575b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f32576c = linkedHashMap;
    }

    public static final void a(Map<String, String> map, String str, String str2) {
        map.put(f32575b + JsonPointer.SEPARATOR + str, 'L' + str2 + ';');
    }

    public static final String b(String classId) {
        p.i(classId, "classId");
        String str = f32576c.get(classId);
        if (str != null) {
            return str;
        }
        return 'L' + D.S(classId, '.', '$', false, 4, null) + ';';
    }
}
