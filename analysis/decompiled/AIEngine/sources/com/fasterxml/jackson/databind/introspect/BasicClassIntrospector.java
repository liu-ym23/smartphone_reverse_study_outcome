package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.f;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BasicClassIntrospector extends f implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final i3.d f4144a;

    /* renamed from: b, reason: collision with root package name */
    public static final i3.d f4145b;

    /* renamed from: c, reason: collision with root package name */
    public static final i3.d f4146c;

    /* renamed from: d, reason: collision with root package name */
    public static final i3.d f4147d;

    /* renamed from: e, reason: collision with root package name */
    public static final i3.d f4148e;

    static {
        SimpleType simpleTypeP = SimpleType.P(String.class);
        AnnotationCollector.NoAnnotations noAnnotations = b.f4190g;
        f4144a = i3.d.g(simpleTypeP, null, new a(String.class));
        Class cls = Boolean.TYPE;
        f4145b = i3.d.g(SimpleType.P(cls), null, new a(cls));
        Class cls2 = Integer.TYPE;
        f4146c = i3.d.g(SimpleType.P(cls2), null, new a(cls2));
        Class cls3 = Long.TYPE;
        f4147d = i3.d.g(SimpleType.P(cls3), null, new a(cls3));
        f4148e = i3.d.g(SimpleType.P(Object.class), null, new a(Object.class));
    }

    public static i3.d a(MapperConfigBase mapperConfigBase, JavaType javaType) {
        if (!javaType.y() || (javaType instanceof ArrayType)) {
            return null;
        }
        Class<?> cls = javaType.f3690a;
        if (!com.fasterxml.jackson.databind.util.a.u(cls)) {
            return null;
        }
        if (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return i3.d.g(javaType, mapperConfigBase, c(mapperConfigBase, javaType, mapperConfigBase));
        }
        return null;
    }

    public static i3.d b(MapperConfig mapperConfig, JavaType javaType) {
        Class<?> cls = javaType.f3690a;
        if (cls.isPrimitive()) {
            if (cls != Integer.TYPE) {
                if (cls != Long.TYPE) {
                    if (cls != Boolean.TYPE) {
                        return null;
                    }
                    return f4145b;
                }
                return f4147d;
            }
            return f4146c;
        }
        if (!com.fasterxml.jackson.databind.util.a.u(cls)) {
            if (!b3.d.class.isAssignableFrom(cls)) {
                return null;
            }
            AnnotationCollector.NoAnnotations noAnnotations = b.f4190g;
            return i3.d.g(javaType, mapperConfig, new a(cls));
        }
        if (cls == Object.class) {
            return f4148e;
        }
        if (cls == String.class) {
            return f4144a;
        }
        if (cls != Integer.class) {
            if (cls != Long.class) {
                if (cls != Boolean.class) {
                    return null;
                }
                return f4145b;
            }
            return f4147d;
        }
        return f4146c;
    }

    public static a c(MapperConfig mapperConfig, JavaType javaType, f.a aVar) {
        AnnotationCollector.NoAnnotations noAnnotations = b.f4190g;
        javaType.getClass();
        Class<?> cls = javaType.f3690a;
        if (javaType instanceof ArrayType) {
            if (mapperConfig != null) {
                ((MapperConfigBase) mapperConfig).f3832c.getClass();
            }
            return new a(cls);
        }
        b bVar = new b((MapperConfig<?>) mapperConfig, javaType, aVar);
        ArrayList arrayList = new ArrayList(8);
        if (!javaType.u(Object.class)) {
            if (cls.isInterface()) {
                b.d(javaType, arrayList, false);
            } else {
                b.e(javaType, arrayList, false);
            }
        }
        return new a(javaType, bVar.f4197d, arrayList, bVar.f4198e, bVar.f(arrayList), bVar.f4196c, bVar.f4194a, aVar, mapperConfig.f3828b.f3789a, bVar.f4199f);
    }

    public static h d(MapperConfigBase mapperConfigBase, JavaType javaType, MapperConfigBase mapperConfigBase2, boolean z) {
        DefaultAccessorNamingStrategy defaultAccessorNamingStrategy;
        BaseSettings baseSettings = mapperConfigBase.f3828b;
        a aVarC = c(mapperConfigBase, javaType, mapperConfigBase2);
        if (javaType.C()) {
            DefaultAccessorNamingStrategy.Provider provider = baseSettings.f3792d;
            defaultAccessorNamingStrategy = new DefaultAccessorNamingStrategy.a(mapperConfigBase, aVarC);
        } else {
            DefaultAccessorNamingStrategy.Provider provider2 = baseSettings.f3792d;
            defaultAccessorNamingStrategy = new DefaultAccessorNamingStrategy(mapperConfigBase, provider2.f4155a, provider2.f4157c, provider2.f4158d);
        }
        return new h(mapperConfigBase, z, javaType, aVarC, defaultAccessorNamingStrategy);
    }
}
