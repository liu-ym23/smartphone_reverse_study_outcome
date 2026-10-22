package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.util.ClassUtil;

/* loaded from: classes2.dex */
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
            throw new IllegalArgumentException(String.format("AnnotationIntrospector returned EnumNamingStrategy definition of type %s; expected type `Class<EnumNamingStrategy>` instead", ClassUtil.classNameOf(obj)));
        }
        Class cls = (Class) obj;
        if (cls == EnumNamingStrategy.class) {
            return null;
        }
        if (EnumNamingStrategy.class.isAssignableFrom(cls)) {
            return (EnumNamingStrategy) ClassUtil.createInstance(cls, z10);
        }
        throw new IllegalArgumentException(String.format("Problem with AnnotationIntrospector returned Class %s; expected `Class<EnumNamingStrategy>`", ClassUtil.classNameOf(cls)));
    }
}
