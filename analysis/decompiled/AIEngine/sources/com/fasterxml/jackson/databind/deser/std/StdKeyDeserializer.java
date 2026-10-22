package com.fasterxml.jackson.databind.deser.std;

import b3.c;
import b3.g;
import c3.a;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import q3.p;
import x2.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class StdKeyDeserializer extends g implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int f4056a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f4057b;

    /* renamed from: c, reason: collision with root package name */
    public final FromStringDeserializer<?> f4058c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DelegatingKD extends g implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f4059a;

        /* renamed from: b, reason: collision with root package name */
        public final c<?> f4060b;

        public DelegatingKD(Class<?> cls, c<?> cVar) {
            this.f4059a = cls;
            this.f4060b = cVar;
        }

        @Override // b3.g
        public final Object a(DeserializationContext deserializationContext, String str) throws InvalidFormatException {
            Class<?> cls = this.f4059a;
            if (str == null) {
                return null;
            }
            p pVar = new p(deserializationContext.h, deserializationContext);
            pVar.f1(str);
            try {
                p.a aVarT1 = pVar.t1(pVar.f11580b);
                aVarT1.q1();
                Object objD = this.f4060b.d(aVarT1, deserializationContext);
                if (objD != null) {
                    return objD;
                }
                deserializationContext.E(cls, str, "not a valid representation", new Object[0]);
                throw null;
            } catch (Exception e10) {
                deserializationContext.E(cls, str, "not a valid representation: %s", e10.getMessage());
                throw null;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class EnumKD extends StdKeyDeserializer {

        /* renamed from: d, reason: collision with root package name */
        public final EnumResolver f4061d;

        /* renamed from: e, reason: collision with root package name */
        public final AnnotatedMethod f4062e;
        public EnumResolver h;

        /* renamed from: j, reason: collision with root package name */
        public final Enum<?> f4063j;

        public EnumKD(EnumResolver enumResolver, AnnotatedMethod annotatedMethod) {
            super(-1, enumResolver.f4499a, null);
            this.f4061d = enumResolver;
            this.f4062e = annotatedMethod;
            this.f4063j = enumResolver.f4502d;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer
        public final Object b(DeserializationContext deserializationContext, String str) throws InvalidFormatException {
            EnumResolver enumResolverC;
            AnnotatedMethod annotatedMethod = this.f4062e;
            if (annotatedMethod != null) {
                try {
                    return annotatedMethod.q(str);
                } catch (Exception e10) {
                    Throwable thQ = com.fasterxml.jackson.databind.util.a.q(e10);
                    String message = thQ.getMessage();
                    com.fasterxml.jackson.databind.util.a.D(thQ);
                    com.fasterxml.jackson.databind.util.a.B(thQ);
                    throw new IllegalArgumentException(message, thQ);
                }
            }
            if (deserializationContext.J(DeserializationFeature.READ_ENUMS_USING_TO_STRING)) {
                enumResolverC = this.h;
                if (enumResolverC == null) {
                    synchronized (this) {
                        enumResolverC = EnumResolver.c(deserializationContext.f3663c, this.f4061d.f4499a);
                        this.h = enumResolverC;
                    }
                }
            } else {
                enumResolverC = this.f4061d;
            }
            HashMap<String, Enum<?>> map = enumResolverC.f4501c;
            Enum<?> value = map.get(str);
            if (value == null && enumResolverC.f4503e) {
                Iterator<Map.Entry<String, Enum<?>>> it = map.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        value = null;
                        break;
                    }
                    Map.Entry<String, Enum<?>> next = it.next();
                    if (str.equalsIgnoreCase(next.getKey())) {
                        value = next.getValue();
                        break;
                    }
                }
            }
            if (value == null) {
                if (this.f4063j != null && deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
                    return this.f4063j;
                }
                if (!deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    deserializationContext.E(this.f4057b, str, "not one of the values accepted for Enum class: %s", enumResolverC.f4501c.keySet());
                    throw null;
                }
            }
            return value;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class StringCtorKeyDeserializer extends StdKeyDeserializer {

        /* renamed from: d, reason: collision with root package name */
        public final Constructor<?> f4064d;

        public StringCtorKeyDeserializer(Constructor<?> constructor) {
            super(-1, constructor.getDeclaringClass(), null);
            this.f4064d = constructor;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer
        public final Object b(DeserializationContext deserializationContext, String str) {
            return this.f4064d.newInstance(str);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class StringFactoryKeyDeserializer extends StdKeyDeserializer {

        /* renamed from: d, reason: collision with root package name */
        public final Method f4065d;

        public StringFactoryKeyDeserializer(Method method) {
            super(-1, method.getDeclaringClass(), null);
            this.f4065d = method;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer
        public final Object b(DeserializationContext deserializationContext, String str) {
            return this.f4065d.invoke(null, str);
        }
    }

    public StdKeyDeserializer(int i10, Class<?> cls, FromStringDeserializer<?> fromStringDeserializer) {
        this.f4056a = i10;
        this.f4057b = cls;
        this.f4058c = fromStringDeserializer;
    }

    @Override // b3.g
    public Object a(DeserializationContext deserializationContext, String str) throws InvalidFormatException {
        Class<?> cls = this.f4057b;
        if (str != null) {
            try {
                Object objB = b(deserializationContext, str);
                if (objB != null) {
                    return objB;
                }
                Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
                if (!Enum.class.isAssignableFrom(cls) || !deserializationContext.f3663c.p(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    deserializationContext.E(cls, str, "not a valid representation", new Object[0]);
                    throw null;
                }
            } catch (Exception e10) {
                deserializationContext.E(cls, str, "not a valid representation, problem: (%s) %s", e10.getClass().getName(), com.fasterxml.jackson.databind.util.a.i(e10));
                throw null;
            }
        }
        return null;
    }

    public Object b(DeserializationContext deserializationContext, String str) throws InvalidFormatException, NumberFormatException {
        int i10 = this.f4056a;
        FromStringDeserializer<?> fromStringDeserializer = this.f4058c;
        Class<?> cls = this.f4057b;
        switch (i10) {
            case 1:
                if ("true".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(str)) {
                    return Boolean.FALSE;
                }
                deserializationContext.E(cls, str, "value not 'true' or 'false'", new Object[0]);
                throw null;
            case 2:
                int i11 = Integer.parseInt(str);
                if (i11 >= -128 && i11 <= 255) {
                    return Byte.valueOf((byte) i11);
                }
                deserializationContext.E(cls, str, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                throw null;
            case 3:
                int i12 = Integer.parseInt(str);
                if (i12 >= -32768 && i12 <= 32767) {
                    return Short.valueOf((short) i12);
                }
                deserializationContext.E(cls, str, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                throw null;
            case 4:
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                deserializationContext.E(cls, str, "can only convert 1-character Strings", new Object[0]);
                throw null;
            case 5:
                return Integer.valueOf(Integer.parseInt(str));
            case 6:
                return Long.valueOf(Long.parseLong(str));
            case 7:
                return Float.valueOf((float) d.b(str));
            case 8:
                return Double.valueOf(d.b(str));
            case 9:
                try {
                    return fromStringDeserializer.j0(deserializationContext, str);
                } catch (IllegalArgumentException e10) {
                    this.c(deserializationContext, str, e10);
                    throw null;
                }
            case 10:
                return deserializationContext.M(str);
            case 11:
                Date dateM = deserializationContext.M(str);
                deserializationContext.f3663c.f3828b.getClass();
                Calendar calendar = Calendar.getInstance(BaseSettings.f3788l);
                calendar.setTime(dateM);
                return calendar;
            case 12:
                try {
                    return UUID.fromString(str);
                } catch (Exception e11) {
                    this.c(deserializationContext, str, e11);
                    throw null;
                }
            case 13:
                try {
                    return URI.create(str);
                } catch (Exception e12) {
                    this.c(deserializationContext, str, e12);
                    throw null;
                }
            case 14:
                try {
                    return new URL(str);
                } catch (MalformedURLException e13) {
                    c(deserializationContext, str, e13);
                    throw null;
                }
            case 15:
                try {
                    deserializationContext.e().getClass();
                    return TypeFactory.k(str);
                } catch (Exception unused) {
                    deserializationContext.E(cls, str, "unable to parse key as Class", new Object[0]);
                    throw null;
                }
            case 16:
                try {
                    return fromStringDeserializer.j0(deserializationContext, str);
                } catch (IllegalArgumentException e14) {
                    this.c(deserializationContext, str, e14);
                    throw null;
                }
            case 17:
                try {
                    Base64Variant base64Variant = deserializationContext.f3663c.f3828b.f3795k;
                    base64Variant.getClass();
                    a3.c cVar = new a3.c(null);
                    base64Variant.b(str, cVar);
                    return cVar.P();
                } catch (IllegalArgumentException e15) {
                    this.c(deserializationContext, str, e15);
                    throw null;
                }
            default:
                throw new IllegalStateException("Internal error: unknown key type " + cls);
        }
    }

    public final void c(DeserializationContext deserializationContext, String str, Exception exc) throws InvalidFormatException {
        deserializationContext.E(this.f4057b, str, "problem: %s", com.fasterxml.jackson.databind.util.a.i(exc));
        throw null;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class StringKD extends StdKeyDeserializer {

        /* renamed from: d, reason: collision with root package name */
        public static final StringKD f4066d = new StringKD(String.class);

        /* renamed from: e, reason: collision with root package name */
        public static final StringKD f4067e = new StringKD(Object.class);

        public StringKD(Class<?> cls) {
            super(-1, cls, null);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer, b3.g
        public final Object a(DeserializationContext deserializationContext, String str) {
            return str;
        }
    }
}
