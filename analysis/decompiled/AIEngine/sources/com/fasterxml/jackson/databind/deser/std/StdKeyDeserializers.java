package com.fasterxml.jackson.databind.deser.std;

import b3.c;
import b3.g;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.util.EnumResolver;
import e3.h;
import i3.d;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StdKeyDeserializers implements h, Serializable {
    public static g b(JavaType javaType, c cVar) {
        return new StdKeyDeserializer.DelegatingKD(javaType.f3690a, cVar);
    }

    public static g c(EnumResolver enumResolver) {
        return new StdKeyDeserializer.EnumKD(enumResolver, null);
    }

    public static g d(EnumResolver enumResolver, AnnotatedMethod annotatedMethod) {
        return new StdKeyDeserializer.EnumKD(enumResolver, annotatedMethod);
    }

    public static StdKeyDeserializer e(DeserializationConfig deserializationConfig, JavaType javaType) {
        Constructor<?> constructor;
        Method method;
        d dVarO = deserializationConfig.o(javaType);
        Class<?>[] clsArr = {String.class};
        a aVar = dVarO.f9499e;
        Iterator<AnnotatedConstructor> it = aVar.g().f4188b.iterator();
        while (true) {
            if (!it.hasNext()) {
                constructor = null;
                break;
            }
            AnnotatedConstructor next = it.next();
            if (next.s() == 1) {
                if (clsArr[0] == next.u(0)) {
                    constructor = next.f4114d;
                    break;
                }
            }
        }
        if (constructor != null) {
            if (deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                com.fasterxml.jackson.databind.util.a.e(constructor, deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new StdKeyDeserializer.StringCtorKeyDeserializer(constructor);
        }
        Class<?>[] clsArr2 = {String.class};
        Iterator<AnnotatedMethod> it2 = aVar.g().f4189c.iterator();
        while (true) {
            if (!it2.hasNext()) {
                method = null;
                break;
            }
            AnnotatedMethod next2 = it2.next();
            if (dVarO.i(next2) && next2.v().length == 1 && next2.u(0).isAssignableFrom(clsArr2[0])) {
                method = next2.f4124d;
                break;
            }
        }
        if (method == null) {
            return null;
        }
        if (deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            com.fasterxml.jackson.databind.util.a.e(method, deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new StdKeyDeserializer.StringFactoryKeyDeserializer(method);
    }

    @Override // e3.h
    public final StdKeyDeserializer a(JavaType javaType) {
        int i10;
        Class<?> clsF = javaType.f3690a;
        if (clsF.isPrimitive()) {
            clsF = com.fasterxml.jackson.databind.util.a.F(clsF);
        }
        if (clsF == String.class || clsF == Object.class || clsF == CharSequence.class || clsF == Serializable.class) {
            return clsF == String.class ? StdKeyDeserializer.StringKD.f4066d : clsF == Object.class ? StdKeyDeserializer.StringKD.f4067e : new StdKeyDeserializer.StringKD(clsF);
        }
        if (clsF == UUID.class) {
            i10 = 12;
        } else if (clsF == Integer.class) {
            i10 = 5;
        } else if (clsF == Long.class) {
            i10 = 6;
        } else if (clsF == Date.class) {
            i10 = 10;
        } else if (clsF == Calendar.class) {
            i10 = 11;
        } else if (clsF == Boolean.class) {
            i10 = 1;
        } else if (clsF == Byte.class) {
            i10 = 2;
        } else if (clsF == Character.class) {
            i10 = 4;
        } else if (clsF == Short.class) {
            i10 = 3;
        } else if (clsF == Float.class) {
            i10 = 7;
        } else if (clsF == Double.class) {
            i10 = 8;
        } else if (clsF == URI.class) {
            i10 = 13;
        } else if (clsF == URL.class) {
            i10 = 14;
        } else if (clsF == Class.class) {
            i10 = 15;
        } else {
            if (clsF == Locale.class) {
                return new StdKeyDeserializer(9, clsF, FromStringDeserializer.m0(Locale.class));
            }
            if (clsF == Currency.class) {
                return new StdKeyDeserializer(16, clsF, FromStringDeserializer.m0(Currency.class));
            }
            if (clsF != byte[].class) {
                return null;
            }
            i10 = 17;
        }
        return new StdKeyDeserializer(i10, clsF, null);
    }
}
