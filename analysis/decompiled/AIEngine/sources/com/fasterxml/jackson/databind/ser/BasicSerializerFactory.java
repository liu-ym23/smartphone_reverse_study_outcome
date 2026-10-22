package com.fasterxml.jackson.databind.ser;

import b3.h;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.ClassSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers$Base;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers$DoubleSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers$FloatSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers$IntLikeSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers$IntegerSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers$LongSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers$ShortSerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers$AtomicBooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers$AtomicIntegerSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers$AtomicLongSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import i3.a;
import i3.d;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import k3.e;
import n3.f;
import q3.g;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BasicSerializerFactory extends f implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<String, b3.f<?>> f4287b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Class<? extends b3.f<?>>> f4288c;

    /* renamed from: a, reason: collision with root package name */
    public final SerializerFactoryConfig f4289a = new SerializerFactoryConfig();

    static {
        HashMap<String, Class<? extends b3.f<?>>> map = new HashMap<>();
        HashMap<String, b3.f<?>> map2 = new HashMap<>();
        map2.put(String.class.getName(), new StringSerializer());
        ToStringSerializer toStringSerializer = ToStringSerializer.f4418c;
        map2.put(StringBuffer.class.getName(), toStringSerializer);
        map2.put(StringBuilder.class.getName(), toStringSerializer);
        map2.put(Character.class.getName(), toStringSerializer);
        map2.put(Character.TYPE.getName(), toStringSerializer);
        map2.put(Integer.class.getName(), new NumberSerializers$IntegerSerializer(Integer.class));
        Class cls = Integer.TYPE;
        map2.put(cls.getName(), new NumberSerializers$IntegerSerializer(cls));
        map2.put(Long.class.getName(), new NumberSerializers$LongSerializer(Long.class));
        Class cls2 = Long.TYPE;
        map2.put(cls2.getName(), new NumberSerializers$LongSerializer(cls2));
        String name = Byte.class.getName();
        NumberSerializers$IntLikeSerializer numberSerializers$IntLikeSerializer = new NumberSerializers$Base<Object>() { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$IntLikeSerializer
            @Override // b3.f
            public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
                jsonGenerator.M0(((Number) obj).intValue());
            }
        };
        map2.put(name, numberSerializers$IntLikeSerializer);
        map2.put(Byte.TYPE.getName(), numberSerializers$IntLikeSerializer);
        String name2 = Short.class.getName();
        NumberSerializers$ShortSerializer numberSerializers$ShortSerializer = new NumberSerializers$Base<Object>() { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$ShortSerializer
            @Override // b3.f
            public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
                jsonGenerator.R0(((Short) obj).shortValue());
            }
        };
        map2.put(name2, numberSerializers$ShortSerializer);
        map2.put(Short.TYPE.getName(), numberSerializers$ShortSerializer);
        map2.put(Double.class.getName(), new NumberSerializers$DoubleSerializer(Double.class));
        Class cls3 = Double.TYPE;
        map2.put(cls3.getName(), new NumberSerializers$DoubleSerializer(cls3));
        String name3 = Float.class.getName();
        NumberSerializers$FloatSerializer numberSerializers$FloatSerializer = new NumberSerializers$Base<Object>() { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$FloatSerializer
            @Override // b3.f
            public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
                jsonGenerator.L0(((Float) obj).floatValue());
            }
        };
        map2.put(name3, numberSerializers$FloatSerializer);
        map2.put(Float.TYPE.getName(), numberSerializers$FloatSerializer);
        map2.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
        map2.put(Boolean.class.getName(), new BooleanSerializer(false));
        map2.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
        map2.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
        map2.put(Calendar.class.getName(), CalendarSerializer.h);
        map2.put(Date.class.getName(), DateSerializer.h);
        HashMap map3 = new HashMap();
        map3.put(URL.class, new ToStringSerializer(URL.class, 0));
        map3.put(URI.class, new ToStringSerializer(URI.class, 0));
        map3.put(Currency.class, new ToStringSerializer(Currency.class, 0));
        map3.put(UUID.class, new UUIDSerializer());
        map3.put(Pattern.class, new ToStringSerializer(Pattern.class, 0));
        map3.put(Locale.class, new ToStringSerializer(Locale.class, 0));
        map3.put(AtomicBoolean.class, StdJdkSerializers$AtomicBooleanSerializer.class);
        map3.put(AtomicInteger.class, StdJdkSerializers$AtomicIntegerSerializer.class);
        map3.put(AtomicLong.class, StdJdkSerializers$AtomicLongSerializer.class);
        map3.put(File.class, FileSerializer.class);
        map3.put(Class.class, ClassSerializer.class);
        NullSerializer nullSerializer = NullSerializer.f4389c;
        map3.put(Void.class, nullSerializer);
        map3.put(Void.TYPE, nullSerializer);
        for (Map.Entry entry : map3.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof b3.f) {
                map2.put(((Class) entry.getKey()).getName(), (b3.f) value);
            } else {
                map.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        map.put(p.class.getName(), TokenBufferSerializer.class);
        f4287b = map2;
        f4288c = map;
    }

    public static JsonInclude.Value c(h hVar, d dVar, JavaType javaType, Class cls) {
        SerializationConfig serializationConfig = hVar.f3044a;
        JsonInclude.Value valueA = serializationConfig.f3835j.f3810a;
        AnnotationIntrospector annotationIntrospector = dVar.f9498d;
        if (annotationIntrospector != null) {
            JsonInclude.Value valueJ = annotationIntrospector.J(dVar.f9499e);
            valueA = valueA == null ? valueJ : valueA.a(valueJ);
        }
        serializationConfig.e(cls).getClass();
        serializationConfig.e(javaType.f3690a).getClass();
        return valueA;
    }

    public static b3.f e(h hVar, a aVar) {
        SerializationConfig serializationConfig = hVar.f3044a;
        Object objU = serializationConfig.d().U(aVar);
        if (objU == null) {
            return null;
        }
        b3.f<Object> fVarG = hVar.G(aVar, objU);
        Object objQ = serializationConfig.d().Q(aVar);
        g gVarC = objQ != null ? hVar.c(objQ) : null;
        if (gVarC == null) {
            return fVarG;
        }
        hVar.e();
        return new StdDelegatingSerializer(gVarC, gVarC.b(), fVarG);
    }

    public static boolean f(SerializationConfig serializationConfig, d dVar) {
        JsonSerialize.Typing typingT = serializationConfig.d().T(dVar.f9499e);
        return (typingT == null || typingT == JsonSerialize.Typing.f3786c) ? serializationConfig.k(MapperFeature.USE_STATIC_TYPING) : typingT == JsonSerialize.Typing.f3785b;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0163  */
    @Override // n3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f a(b3.h r12, com.fasterxml.jackson.databind.JavaType r13) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.BasicSerializerFactory.a(b3.h, com.fasterxml.jackson.databind.JavaType):b3.f");
    }

    @Override // n3.f
    public final e b(SerializationConfig serializationConfig, JavaType javaType) {
        ArrayList arrayList;
        com.fasterxml.jackson.databind.introspect.a aVar = serializationConfig.j(javaType.f3690a).f9499e;
        k3.d dVarY = serializationConfig.d().Y(javaType, serializationConfig, aVar);
        if (dVarY == null) {
            serializationConfig.f3828b.getClass();
            arrayList = null;
            dVarY = null;
        } else {
            serializationConfig.f3833d.getClass();
            AnnotationIntrospector annotationIntrospectorD = serializationConfig.d();
            HashMap map = new HashMap();
            StdSubtypeResolver.a(aVar, new NamedType(aVar.f4175b, null), serializationConfig, annotationIntrospectorD, map);
            arrayList = new ArrayList(map.values());
        }
        if (dVarY == null) {
            return null;
        }
        return dVarY.b(serializationConfig, javaType, arrayList);
    }

    public final StdSerializer d(h hVar, JavaType javaType, d dVar) {
        if (b3.e.class.isAssignableFrom(javaType.f3690a)) {
            return SerializableSerializer.f4406c;
        }
        AnnotatedMember annotatedMemberF = dVar.f();
        if (annotatedMemberF == null) {
            return null;
        }
        SerializationConfig serializationConfig = hVar.f3044a;
        serializationConfig.getClass();
        if (serializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            com.fasterxml.jackson.databind.util.a.e(annotatedMemberF.j(), serializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        JavaType javaTypeF = annotatedMemberF.f();
        b3.f fVarE = e(hVar, annotatedMemberF);
        if (fVarE == null) {
            fVarE = (b3.f) javaTypeF.f3692c;
        }
        e eVarB = (e) javaTypeF.f3693d;
        if (eVarB == null) {
            eVarB = b(serializationConfig, javaTypeF);
        }
        return new JsonValueSerializer(annotatedMemberF, eVarB, fVarE);
    }
}
