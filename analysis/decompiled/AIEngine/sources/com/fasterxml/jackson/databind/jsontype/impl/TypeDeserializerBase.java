package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.util.a;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.concurrent.ConcurrentHashMap;
import k3.b;
import k3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class TypeDeserializerBase extends b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final c f4248a;

    /* renamed from: b, reason: collision with root package name */
    public final JavaType f4249b;

    /* renamed from: c, reason: collision with root package name */
    public final BeanProperty f4250c;

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f4251d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4252e;
    public final boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f4253j;

    /* renamed from: k, reason: collision with root package name */
    public b3.c<Object> f4254k;

    public TypeDeserializerBase(JavaType javaType, c cVar, String str, boolean z, JavaType javaType2) {
        this.f4249b = javaType;
        this.f4248a = cVar;
        Annotation[] annotationArr = a.f4529a;
        this.f4252e = str == null ? "" : str;
        this.h = z;
        this.f4253j = new ConcurrentHashMap(16, 0.75f, 2);
        this.f4251d = javaType2;
        this.f4250c = null;
    }

    @Override // k3.b
    public final Class<?> g() {
        Annotation[] annotationArr = a.f4529a;
        JavaType javaType = this.f4251d;
        if (javaType == null) {
            return null;
        }
        return javaType.f3690a;
    }

    @Override // k3.b
    public final String h() {
        return this.f4252e;
    }

    @Override // k3.b
    public final c i() {
        return this.f4248a;
    }

    @Override // k3.b
    public final boolean k() {
        return this.f4251d != null;
    }

    public final Object l(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return n(deserializationContext, obj instanceof String ? (String) obj : String.valueOf(obj)).d(jsonParser, deserializationContext);
    }

    public final b3.c<Object> m(DeserializationContext deserializationContext) {
        b3.c<Object> cVar;
        JavaType javaType = this.f4251d;
        if (javaType == null) {
            if (deserializationContext.J(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
                return null;
            }
            return NullifyingDeserializer.f4015d;
        }
        if (a.t(javaType.f3690a)) {
            return NullifyingDeserializer.f4015d;
        }
        synchronized (this.f4251d) {
            try {
                if (this.f4254k == null) {
                    this.f4254k = deserializationContext.o(this.f4251d, this.f4250c);
                }
                cVar = this.f4254k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public final b3.c<Object> n(DeserializationContext deserializationContext, String str) throws InvalidTypeIdException {
        b3.c<Object> cVarO;
        ConcurrentHashMap concurrentHashMap = this.f4253j;
        b3.c<Object> cVar = (b3.c) concurrentHashMap.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = this.f4248a;
        JavaType javaTypeC = cVar2.c(deserializationContext, str);
        BeanProperty beanProperty = this.f4250c;
        JavaType javaType = this.f4249b;
        if (javaTypeC == null) {
            cVarO = m(deserializationContext);
            if (cVarO == null) {
                String strB = cVar2.b();
                String strConcat = strB == null ? "type ids are not statically known" : "known type ids = ".concat(strB);
                if (beanProperty != null) {
                    strConcat = strConcat + " (for POJO property '" + beanProperty.getName() + "')";
                }
                deserializationContext.D(javaType, str, strConcat);
                return NullifyingDeserializer.f4015d;
            }
        } else {
            if (javaType != null && javaType.getClass() == javaTypeC.getClass() && !javaTypeC.s()) {
                try {
                    Class<?> cls = javaTypeC.f3690a;
                    deserializationContext.getClass();
                    javaTypeC = javaType.u(cls) ? javaType : deserializationContext.f3663c.f3828b.f3789a.i(javaType, cls, false);
                } catch (IllegalArgumentException e10) {
                    throw deserializationContext.f(javaType, str, e10.getMessage());
                }
            }
            cVarO = deserializationContext.o(javaTypeC, beanProperty);
        }
        concurrentHashMap.put(str, cVarO);
        return cVarO;
    }

    public final String toString() {
        return "[" + getClass().getName() + "; base-type:" + this.f4249b + "; id-resolver: " + this.f4248a + ']';
    }

    public TypeDeserializerBase(TypeDeserializerBase typeDeserializerBase, BeanProperty beanProperty) {
        this.f4249b = typeDeserializerBase.f4249b;
        this.f4248a = typeDeserializerBase.f4248a;
        this.f4252e = typeDeserializerBase.f4252e;
        this.h = typeDeserializerBase.h;
        this.f4253j = typeDeserializerBase.f4253j;
        this.f4251d = typeDeserializerBase.f4251d;
        this.f4254k = typeDeserializerBase.f4254k;
        this.f4250c = beanProperty;
    }
}
