package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.impl.a;
import java.io.IOException;
import java.lang.reflect.Modifier;
import k3.e;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public class JsonValueSerializer extends StdSerializer<Object> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final AnnotatedMember f4366c;

    /* renamed from: d, reason: collision with root package name */
    public final e f4367d;

    /* renamed from: e, reason: collision with root package name */
    public final f<Object> f4368e;
    public final BeanProperty h;

    /* renamed from: j, reason: collision with root package name */
    public final JavaType f4369j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4370k;

    /* renamed from: l, reason: collision with root package name */
    public transient com.fasterxml.jackson.databind.ser.impl.a f4371l;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public final e f4372a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f4373b;

        public a(e eVar, Object obj) {
            this.f4372a = eVar;
            this.f4373b = obj;
        }

        @Override // k3.e
        public final e a(BeanProperty beanProperty) {
            throw new UnsupportedOperationException();
        }

        @Override // k3.e
        public final String b() {
            return this.f4372a.b();
        }

        @Override // k3.e
        public final JsonTypeInfo.As c() {
            return this.f4372a.c();
        }

        @Override // k3.e
        public final WritableTypeId e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
            writableTypeId.f3619a = this.f4373b;
            return this.f4372a.e(jsonGenerator, writableTypeId);
        }

        @Override // k3.e
        public final WritableTypeId f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
            return this.f4372a.f(jsonGenerator, writableTypeId);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JsonValueSerializer(JsonValueSerializer jsonValueSerializer, BeanProperty beanProperty, e eVar, f<?> fVar, boolean z) {
        Class cls = jsonValueSerializer.f4417a;
        super(cls == null ? Object.class : cls);
        this.f4366c = jsonValueSerializer.f4366c;
        this.f4369j = jsonValueSerializer.f4369j;
        this.f4367d = eVar;
        this.f4368e = fVar;
        this.h = beanProperty;
        this.f4370k = z;
        this.f4371l = a.b.f4334a;
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        e eVarA = this.f4367d;
        if (eVarA != null) {
            eVarA = eVarA.a(beanProperty);
        }
        boolean z = this.f4370k;
        f<?> fVar = this.f4368e;
        if (fVar != null) {
            return p(beanProperty, eVarA, hVar.A(fVar, beanProperty), z);
        }
        boolean zK = hVar.f3044a.k(MapperFeature.USE_STATIC_TYPING);
        JavaType javaType = this.f4369j;
        if (!zK && !Modifier.isFinal(javaType.f3690a.getModifiers())) {
            return beanProperty != this.h ? p(beanProperty, eVarA, fVar, z) : this;
        }
        f<Object> fVarU = hVar.u(javaType, beanProperty);
        Class<?> cls = javaType.f3690a;
        boolean zV = false;
        if (!cls.isPrimitive() ? cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class : cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE) {
            zV = com.fasterxml.jackson.databind.util.a.v(fVarU);
        }
        return p(beanProperty, eVarA, fVarU, zV);
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        Object objK = this.f4366c.k(obj);
        if (objK == null) {
            return true;
        }
        f<Object> fVarO = this.f4368e;
        if (fVarO == null) {
            try {
                fVarO = o(hVar, objK.getClass());
            } catch (JsonMappingException e10) {
                throw new RuntimeJsonMappingException(e10);
            }
        }
        return fVarO.d(hVar, objK);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) throws IOException {
        AnnotatedMember annotatedMember = this.f4366c;
        try {
            Object objK = annotatedMember.k(obj);
            if (objK == null) {
                hVar.p(jsonGenerator);
                return;
            }
            f<Object> fVarO = this.f4368e;
            if (fVarO == null) {
                fVarO = o(hVar, objK.getClass());
            }
            e eVar = this.f4367d;
            if (eVar != null) {
                fVarO.g(objK, jsonGenerator, hVar, eVar);
            } else {
                fVarO.f(objK, jsonGenerator, hVar);
            }
        } catch (Exception e10) {
            StdSerializer.n(hVar, e10, obj, annotatedMember.d() + "()");
            throw null;
        }
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) throws IOException {
        AnnotatedMember annotatedMember = this.f4366c;
        try {
            Object objK = annotatedMember.k(obj);
            if (objK == null) {
                hVar.p(jsonGenerator);
                return;
            }
            f<Object> fVarO = this.f4368e;
            if (fVarO == null) {
                fVarO = o(hVar, objK.getClass());
            } else if (this.f4370k) {
                WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.VALUE_STRING, obj));
                fVarO.f(objK, jsonGenerator, hVar);
                eVar.f(jsonGenerator, writableTypeIdE);
                return;
            }
            fVarO.g(objK, jsonGenerator, hVar, new a(eVar, obj));
        } catch (Exception e10) {
            StdSerializer.n(hVar, e10, obj, annotatedMember.d() + "()");
            throw null;
        }
    }

    public final f<Object> o(h hVar, Class<?> cls) {
        f<Object> fVarC = this.f4371l.c(cls);
        if (fVarC != null) {
            return fVarC;
        }
        JavaType javaType = this.f4369j;
        boolean zS = javaType.s();
        BeanProperty beanProperty = this.h;
        if (!zS) {
            f<Object> fVarV = hVar.v(cls, beanProperty);
            this.f4371l = this.f4371l.b(cls, fVarV);
            return fVarV;
        }
        JavaType javaTypeO = hVar.o(javaType, cls);
        f<Object> fVarU = hVar.u(javaTypeO, beanProperty);
        com.fasterxml.jackson.databind.ser.impl.a aVar = this.f4371l;
        aVar.getClass();
        this.f4371l = aVar.b(javaTypeO.f3690a, fVarU);
        return fVarU;
    }

    public final JsonValueSerializer p(BeanProperty beanProperty, e eVar, f<?> fVar, boolean z) {
        return (this.h == beanProperty && this.f4367d == eVar && this.f4368e == fVar && z == this.f4370k) ? this : new JsonValueSerializer(this, beanProperty, eVar, fVar, z);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("(@JsonValue serializer for method ");
        AnnotatedMember annotatedMember = this.f4366c;
        sb2.append(annotatedMember.h());
        sb2.append("#");
        sb2.append(annotatedMember.d());
        sb2.append(")");
        return sb2.toString();
    }

    public JsonValueSerializer(AnnotatedMember annotatedMember, e eVar, f<?> fVar) {
        super(annotatedMember.f());
        this.f4366c = annotatedMember;
        this.f4369j = annotatedMember.f();
        this.f4367d = eVar;
        this.f4368e = fVar;
        this.h = null;
        this.f4370k = true;
        this.f4371l = a.b.f4334a;
    }
}
