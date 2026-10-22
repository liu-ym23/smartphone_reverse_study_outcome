package z8;

import X8.A;
import X8.AbstractC0272c;
import X8.w;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import v8.C2071g;

/* renamed from: z8.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2196h implements T8.p {
    public static final C2196h b = new C2196h();
    public static final C2196h c = new C2196h();
    public static final C2196h d = new C2196h();

    public static String[] a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static m c(String representation) {
        JvmPrimitiveType jvmPrimitiveType;
        kotlin.jvm.internal.k.f(representation, "representation");
        char cCharAt = representation.charAt(0);
        JvmPrimitiveType[] jvmPrimitiveTypeArrValues = JvmPrimitiveType.values();
        int length = jvmPrimitiveTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = jvmPrimitiveTypeArrValues[i];
            if (jvmPrimitiveType.c().charAt(0) == cCharAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new l(jvmPrimitiveType);
        }
        if (cCharAt == 'V') {
            return new l(null);
        }
        if (cCharAt == '[') {
            String strSubstring = representation.substring(1);
            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
            return new C2198j(c(strSubstring));
        }
        if (cCharAt == 'L') {
            j9.m.l0(representation, ';');
        }
        String strSubstring2 = representation.substring(1, representation.length() - 1);
        kotlin.jvm.internal.k.e(strSubstring2, "substring(...)");
        return new k(strSubstring2);
    }

    public static k d(String internalName) {
        kotlin.jvm.internal.k.f(internalName, "internalName");
        return new k(internalName);
    }

    public static LinkedHashSet e(String internalName, String... signatures) {
        kotlin.jvm.internal.k.f(internalName, "internalName");
        kotlin.jvm.internal.k.f(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + '.' + str);
        }
        return linkedHashSet;
    }

    public static LinkedHashSet f(String str, String... signatures) {
        kotlin.jvm.internal.k.f(signatures, "signatures");
        return e("java/lang/".concat(str), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public static LinkedHashSet g(String str, String... strArr) {
        return e("java/util/".concat(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static String h(m type) {
        String strC;
        kotlin.jvm.internal.k.f(type, "type");
        if (type instanceof C2198j) {
            return "[" + h(((C2198j) type).i);
        }
        if (type instanceof l) {
            JvmPrimitiveType jvmPrimitiveType = ((l) type).i;
            return (jvmPrimitiveType == null || (strC = jvmPrimitiveType.c()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : strC;
        }
        if (type instanceof k) {
            return B7.a.g(';', ((k) type).i, new StringBuilder("L"));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // T8.p
    public w b(ProtoBuf$Type proto, String flexibleId, A lowerBound, A upperBound) {
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(flexibleId, "flexibleId");
        kotlin.jvm.internal.k.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.k.f(upperBound, "upperBound");
        return !flexibleId.equals("kotlin.jvm.PlatformType") ? Z8.i.c(ErrorTypeKind.m, flexibleId, lowerBound.toString(), upperBound.toString()) : proto.j(E8.c.g) ? new C2071g(lowerBound, upperBound) : AbstractC0272c.f(lowerBound, upperBound);
    }
}
