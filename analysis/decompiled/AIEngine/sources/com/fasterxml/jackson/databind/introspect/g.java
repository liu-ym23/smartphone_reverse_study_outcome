package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {
    public static ParameterizedType a(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return a(upperBounds[0]);
            }
        }
        return null;
    }

    public static TypeVariable<?> b(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return b(upperBounds[0]);
            }
        }
        return null;
    }

    public static boolean c(a aVar, JavaType javaType, Type type) {
        if (javaType.D(aVar.a(type).f3690a)) {
            ParameterizedType parameterizedTypeA = a(type);
            if (parameterizedTypeA == null || !Objects.equals(javaType.f3690a, parameterizedTypeA.getRawType())) {
                return true;
            }
            Type[] actualTypeArguments = parameterizedTypeA.getActualTypeArguments();
            TypeBindings typeBindingsJ = javaType.j();
            if (typeBindingsJ.f4454b.length == actualTypeArguments.length) {
                for (int i10 = 0; i10 < typeBindingsJ.f4454b.length; i10++) {
                    if (c(aVar, typeBindingsJ.d(i10), actualTypeArguments[i10])) {
                    }
                }
                return true;
            }
        }
        return false;
    }
}
