package com.fasterxml.jackson.databind.introspect;

import B7.a;
import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.util.ClassUtil;

/* loaded from: classes3.dex */
public class EnumNamingStrategyFactory {
    private EnumNamingStrategyFactory() {
    }

    @Deprecated
    public static EnumNamingStrategy createEnumNamingStrategyInstance(Object obj, boolean z10) {
        return createEnumNamingStrategyInstance(obj, z10, null);
    }

    public static EnumNamingStrategy createEnumNamingStrategyInstance(Object obj, boolean z10, EnumNamingStrategy enumNamingStrategy) {
        if (obj == null) {
            return enumNamingStrategy;
        }
        if (obj instanceof EnumNamingStrategy) {
            return (EnumNamingStrategy) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalArgumentException(a.m("AnnotationIntrospector returned EnumNamingStrategy definition of type ", ClassUtil.classNameOf(obj), "; expected type `Class<EnumNamingStrategy>` instead"));
        }
        Class cls = (Class) obj;
        if (cls == EnumNamingStrategy.class) {
            return null;
        }
        if (EnumNamingStrategy.class.isAssignableFrom(cls)) {
            return (EnumNamingStrategy) ClassUtil.createInstance(cls, z10);
        }
        throw new IllegalArgumentException(a.m("Problem with AnnotationIntrospector returned Class ", ClassUtil.classNameOf(cls), "; expected `Class<EnumNamingStrategy>`"));
    }
}
