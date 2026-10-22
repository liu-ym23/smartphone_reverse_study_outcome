package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.android.vcard.VCardConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: ClassMapperLite.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f6kotlin = null;
    private static final Map<String, String> map = null;

    private ClassMapperLite() {
    }

    static {
        INSTANCE = new ClassMapperLite();
        int r2 = 0;
        f6kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        LinkedHashMap r0 = new LinkedHashMap();
        List r1 = CollectionsKt.listOf(new String[]{"Boolean", "Z", "Char", "C", "Byte", VCardConstants.PARAM_ENCODING_B, "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int r3 = ProgressionUtilKt.getProgressionLastElement(0, r1.size() - 1, 2);
        if (r3 < 0) goto L8;
        int r4 = 0;
    L5:
        StringBuilder r5 = new StringBuilder();
        String r6 = f6kotlin;
        int r8 = r4 + 1;
        r0.put(r5.append(r6).append('/').append((String) r1.get(r4)).toString(), r1.get(r8));
        r0.put(r6 + '/' + ((String) r1.get(r4)) + "Array", "[" + ((String) r1.get(r8)));
        if (r4 == r3) goto L8;
        r4 = r4 + 2;
    L8:
        r0.put(f6kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        map$lambda$0$add(r0, "Any", "java/lang/Object");
        map$lambda$0$add(r0, "Nothing", "java/lang/Void");
        map$lambda$0$add(r0, "Annotation", "java/lang/annotation/Annotation");
        Iterator r7 = CollectionsKt.listOf(new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"}).iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        String r9 = (String) r7.next();
        map$lambda$0$add(r0, r9, "java/lang/" + r9);
        goto L10
    L12:
        Iterator r10 = CollectionsKt.listOf(new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"}).iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        String r11 = (String) r10.next();
        map$lambda$0$add(r0, "collections/" + r11, "java/util/" + r11);
        map$lambda$0$add(r0, "collections/Mutable" + r11, "java/util/" + r11);
        goto L14
    L16:
        map$lambda$0$add(r0, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(r0, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(r0, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(r0, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    L18:
        if (r2 >= 23) goto L20;
        StringBuilder r12 = new StringBuilder();
        String r13 = f6kotlin;
        map$lambda$0$add(r0, "Function" + r2, r12.append(r13).append("/jvm/functions/Function").append(r2).toString());
        map$lambda$0$add(r0, "reflect/KFunction" + r2, r13 + "/reflect/KFunction");
        r2 = r2 + 1;
        goto L18
    L20:
        Iterator r14 = CollectionsKt.listOf(new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"}).iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        String r15 = (String) r14.next();
        map$lambda$0$add(r0, r15 + ".Companion", f6kotlin + "/jvm/internal/" + r15 + "CompanionObject");
        goto L22
    L24:
        map = r0;
    }

    private static final void map$lambda$0$add(Map<String, String> r2, String r3, String r4) {
        r2.put(f6kotlin + '/' + r3, "L" + r4 + ';');
    }

    @JvmStatic
    public static final String mapClass(String r8) {
        Intrinsics.checkNotNullParameter(r8, "classId");
        String r0 = map.get(r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return "L" + StringsKt.replace$default(r8, '.', Typography.dollar, false, 4, null) + ';';
    }
}
