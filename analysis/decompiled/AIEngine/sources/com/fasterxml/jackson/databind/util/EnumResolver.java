package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.MapperFeature;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EnumResolver implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Class<Enum<?>> f4499a;

    /* renamed from: b, reason: collision with root package name */
    public final Enum<?>[] f4500b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Enum<?>> f4501c;

    /* renamed from: d, reason: collision with root package name */
    public final Enum<?> f4502d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4503e;

    public EnumResolver(Class<Enum<?>> cls, Enum<?>[] enumArr, HashMap<String, Enum<?>> map, Enum<?> r42, boolean z) {
        this.f4499a = cls;
        this.f4500b = enumArr;
        this.f4501c = map;
        this.f4502d = r42;
        this.f4503e = z;
    }

    public static Enum<?>[] a(Class<?> cls) {
        Enum<?>[] enumArr = (Enum[]) cls.getEnumConstants();
        if (enumArr != null) {
            return enumArr;
        }
        throw new IllegalArgumentException("No enum constants for class ".concat(cls.getName()));
    }

    public static EnumResolver c(DeserializationConfig deserializationConfig, Class<?> cls) {
        AnnotationIntrospector annotationIntrospectorD = deserializationConfig.d();
        boolean zK = deserializationConfig.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Enum<?>[] enumArrA = a(cls);
        HashMap map = new HashMap();
        String[][] strArr = new String[enumArrA.length][];
        annotationIntrospectorD.k(cls, enumArrA, strArr);
        int length = enumArrA.length;
        while (true) {
            length--;
            if (length < 0) {
                return new EnumResolver(cls, enumArrA, map, annotationIntrospectorD.g(cls), zK);
            }
            Enum<?> r22 = enumArrA[length];
            map.put(r22.toString(), r22);
            String[] strArr2 = strArr[length];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    if (!map.containsKey(str)) {
                        map.put(str, r22);
                    }
                }
            }
        }
    }

    public final CompactStringObjectMap b() {
        int i10;
        HashMap<String, Enum<?>> map = this.f4501c;
        if (map.isEmpty()) {
            return CompactStringObjectMap.f4495d;
        }
        int size = map.size();
        if (size <= 5) {
            i10 = 8;
        } else if (size <= 12) {
            i10 = 16;
        } else {
            int i11 = 32;
            while (i11 < size + (size >> 2)) {
                i11 += i11;
            }
            i10 = i11;
        }
        int i12 = i10 - 1;
        int i13 = (i10 >> 1) + i10;
        Object[] objArrCopyOf = new Object[i13 * 2];
        int i14 = 0;
        for (Map.Entry<String, Enum<?>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                int iHashCode = key.hashCode() & i12;
                int i15 = iHashCode + iHashCode;
                if (objArrCopyOf[i15] != null) {
                    i15 = ((iHashCode >> 1) + i10) << 1;
                    if (objArrCopyOf[i15] != null) {
                        i15 = (i13 << 1) + i14;
                        i14 += 2;
                        if (i15 >= objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length + 4);
                        }
                    }
                }
                objArrCopyOf[i15] = key;
                objArrCopyOf[i15 + 1] = entry.getValue();
            }
        }
        return new CompactStringObjectMap(objArrCopyOf, i12, i14);
    }
}
