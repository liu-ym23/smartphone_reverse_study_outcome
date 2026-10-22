package L8;

import h8.InterfaceC1540w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.z;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes4.dex */
public final class h {
    public static b a(List list, InterfaceC1540w interfaceC1540w, PrimitiveType primitiveType) {
        List listF1 = D7.v.f1(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listF1.iterator();
        while (it.hasNext()) {
            g gVarB = b(it.next(), null);
            if (gVarB != null) {
                arrayList.add(gVarB);
            }
        }
        return interfaceC1540w != null ? new x(arrayList, interfaceC1540w.c().q(primitiveType)) : new b(new J4.b(primitiveType, 2), arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v23, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v29, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v31, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v32, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v34, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v39, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v40, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v42, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v43, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v46, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v47, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v48, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v49, types: [java.util.ArrayList] */
    public static g b(Object obj, z zVar) {
        ?? M5;
        ?? M10;
        ?? M11;
        ?? M12;
        ?? M13;
        ?? M14;
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new v(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new k(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new t(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            Character ch = (Character) obj;
            ch.getClass();
            return new e(ch);
        }
        if (obj instanceof Float) {
            return new c(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new c(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            Boolean bool = (Boolean) obj;
            bool.getClass();
            return new c(bool);
        }
        if (obj instanceof String) {
            String value = (String) obj;
            kotlin.jvm.internal.k.f(value, "value");
            return new w(value);
        }
        if (obj instanceof byte[]) {
            return a(D7.q.G0((byte[]) obj), zVar, PrimitiveType.h);
        }
        int i = 0;
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            kotlin.jvm.internal.k.f(sArr, "<this>");
            int length = sArr.length;
            if (length == 0) {
                M14 = EmptyList.f4893a;
            } else if (length != 1) {
                M14 = new ArrayList(sArr.length);
                int length2 = sArr.length;
                while (i < length2) {
                    M14.add(Short.valueOf(sArr[i]));
                    i++;
                }
            } else {
                M14 = H4.o.M(Short.valueOf(sArr[0]));
            }
            return a(M14, zVar, PrimitiveType.i);
        }
        if (obj instanceof int[]) {
            return a(D7.q.H0((int[]) obj), zVar, PrimitiveType.f4942j);
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            kotlin.jvm.internal.k.f(jArr, "<this>");
            int length3 = jArr.length;
            if (length3 == 0) {
                M13 = EmptyList.f4893a;
            } else if (length3 != 1) {
                M13 = new ArrayList(jArr.length);
                int length4 = jArr.length;
                while (i < length4) {
                    M13.add(Long.valueOf(jArr[i]));
                    i++;
                }
            } else {
                M13 = H4.o.M(Long.valueOf(jArr[0]));
            }
            return a(M13, zVar, PrimitiveType.l);
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            kotlin.jvm.internal.k.f(cArr, "<this>");
            int length5 = cArr.length;
            if (length5 == 0) {
                M12 = EmptyList.f4893a;
            } else if (length5 != 1) {
                M12 = new ArrayList(cArr.length);
                int length6 = cArr.length;
                while (i < length6) {
                    M12.add(Character.valueOf(cArr[i]));
                    i++;
                }
            } else {
                M12 = H4.o.M(Character.valueOf(cArr[0]));
            }
            return a(M12, zVar, PrimitiveType.g);
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            kotlin.jvm.internal.k.f(fArr, "<this>");
            int length7 = fArr.length;
            if (length7 == 0) {
                M11 = EmptyList.f4893a;
            } else if (length7 != 1) {
                M11 = new ArrayList(fArr.length);
                int length8 = fArr.length;
                while (i < length8) {
                    M11.add(Float.valueOf(fArr[i]));
                    i++;
                }
            } else {
                M11 = H4.o.M(Float.valueOf(fArr[0]));
            }
            return a(M11, zVar, PrimitiveType.k);
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            kotlin.jvm.internal.k.f(dArr, "<this>");
            int length9 = dArr.length;
            if (length9 == 0) {
                M10 = EmptyList.f4893a;
            } else if (length9 != 1) {
                M10 = new ArrayList(dArr.length);
                int length10 = dArr.length;
                while (i < length10) {
                    M10.add(Double.valueOf(dArr[i]));
                    i++;
                }
            } else {
                M10 = H4.o.M(Double.valueOf(dArr[0]));
            }
            return a(M10, zVar, PrimitiveType.m);
        }
        if (!(obj instanceof boolean[])) {
            if (obj == null) {
                return new u(null);
            }
            return null;
        }
        boolean[] zArr = (boolean[]) obj;
        kotlin.jvm.internal.k.f(zArr, "<this>");
        int length11 = zArr.length;
        if (length11 == 0) {
            M5 = EmptyList.f4893a;
        } else if (length11 != 1) {
            M5 = new ArrayList(zArr.length);
            int length12 = zArr.length;
            while (i < length12) {
                M5.add(Boolean.valueOf(zArr[i]));
                i++;
            }
        } else {
            M5 = H4.o.M(Boolean.valueOf(zArr[0]));
        }
        return a(M5, zVar, PrimitiveType.f);
    }
}
