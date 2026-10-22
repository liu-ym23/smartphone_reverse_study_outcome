package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.util.ClassUtil;
import g5.f;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class EnumNamingStrategyFactory {
    private EnumNamingStrategyFactory() {
    }

    public static EnumNamingStrategy createEnumNamingStrategyInstance(Object obj, boolean z10, EnumNamingStrategy enumNamingStrategy) {
        if (obj == null) {
            return enumNamingStrategy;
        }
        if (obj instanceof EnumNamingStrategy) {
            return (EnumNamingStrategy) obj;
        }
        if (!(obj instanceof Class)) {
            f.s(a.C("AnnotationIntrospector returned EnumNamingStrategy definition of type ", ClassUtil.classNameOf(obj), "; expected type `Class<EnumNamingStrategy>` instead"));
            return null;
        }
        Class cls = (Class) obj;
        if (cls == EnumNamingStrategy.class) {
            return null;
        }
        if (EnumNamingStrategy.class.isAssignableFrom(cls)) {
            return (EnumNamingStrategy) ClassUtil.createInstance(cls, z10);
        }
        f.s(a.C("Problem with AnnotationIntrospector returned Class ", ClassUtil.classNameOf(cls), "; expected `Class<EnumNamingStrategy>`"));
        return null;
    }

    @Deprecated
    public static EnumNamingStrategy createEnumNamingStrategyInstance(Object obj, boolean z10) {
        return createEnumNamingStrategyInstance(obj, z10, null);
    }
}
