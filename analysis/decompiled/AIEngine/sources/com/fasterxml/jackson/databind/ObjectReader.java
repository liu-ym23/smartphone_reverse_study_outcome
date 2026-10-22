package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.a;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.concurrent.ConcurrentHashMap;
import v2.c;
import w2.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ObjectReader extends c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializationConfig f3730a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultDeserializationContext f3731b;

    /* renamed from: c, reason: collision with root package name */
    public final JsonFactory f3732c;

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f3733d;

    /* renamed from: e, reason: collision with root package name */
    public final b3.c<Object> f3734e;
    public final ConcurrentHashMap<JavaType, b3.c<Object>> h;

    public ObjectReader(JsonMapper jsonMapper, DeserializationConfig deserializationConfig, JavaType javaType) {
        b3.c<Object> cVarT;
        this.f3730a = deserializationConfig;
        DefaultDeserializationContext defaultDeserializationContext = jsonMapper.f3728j;
        this.f3731b = defaultDeserializationContext;
        ConcurrentHashMap<JavaType, b3.c<Object>> concurrentHashMap = jsonMapper.f3729k;
        this.h = concurrentHashMap;
        this.f3732c = jsonMapper.f3723a;
        this.f3733d = javaType;
        deserializationConfig.getClass();
        deserializationConfig.p(DeserializationFeature.UNWRAP_ROOT_VALUE);
        if (javaType == null || !deserializationConfig.p(DeserializationFeature.EAGER_DESERIALIZER_FETCH)) {
            cVarT = null;
        } else {
            cVarT = concurrentHashMap.get(javaType);
            if (cVarT == null) {
                try {
                    DefaultDeserializationContext.Impl impl = (DefaultDeserializationContext.Impl) defaultDeserializationContext;
                    impl.getClass();
                    cVarT = new DefaultDeserializationContext.Impl(impl, deserializationConfig).t(javaType);
                    if (cVarT != null) {
                        concurrentHashMap.put(javaType, cVarT);
                    }
                } catch (JsonProcessingException unused) {
                }
            }
        }
        this.f3734e = cVarT;
    }

    @Override // v2.c
    public final void a(JsonGenerator jsonGenerator, Object obj) {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    public final Object b(b bVar) {
        JsonToken jsonTokenQ1;
        DeserializationConfig deserializationConfig = this.f3730a;
        try {
            DefaultDeserializationContext.Impl impl = (DefaultDeserializationContext.Impl) this.f3731b;
            impl.getClass();
            DefaultDeserializationContext.Impl impl2 = new DefaultDeserializationContext.Impl(impl, deserializationConfig, bVar);
            JsonToken jsonTokenQ12 = bVar.f13576c;
            if (jsonTokenQ12 == null && (jsonTokenQ12 = bVar.q1()) == null) {
                impl2.R("No content to map due to end-of-input", new Object[0]);
                throw null;
            }
            JsonToken jsonToken = JsonToken.VALUE_NULL;
            JavaType javaType = this.f3733d;
            Object objA = jsonTokenQ12 == jsonToken ? c(impl2).a(impl2) : (jsonTokenQ12 == JsonToken.END_ARRAY || jsonTokenQ12 == JsonToken.END_OBJECT) ? null : impl2.Z(bVar, javaType, c(impl2));
            if (!deserializationConfig.p(DeserializationFeature.FAIL_ON_TRAILING_TOKENS) || (jsonTokenQ1 = bVar.q1()) == null) {
                bVar.close();
                return objA;
            }
            Annotation[] annotationArr = a.f4529a;
            DeserializationContext.S(javaType == null ? null : javaType.f3690a, bVar, jsonTokenQ1);
            throw null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bVar.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public final b3.c c(DefaultDeserializationContext.Impl impl) throws InvalidDefinitionException {
        b3.c<Object> cVar = this.f3734e;
        if (cVar != null) {
            return cVar;
        }
        JavaType javaType = this.f3733d;
        if (javaType == null) {
            impl.j("No value type configured for ObjectReader");
            throw null;
        }
        ConcurrentHashMap<JavaType, b3.c<Object>> concurrentHashMap = this.h;
        b3.c<Object> cVar2 = concurrentHashMap.get(javaType);
        if (cVar2 != null) {
            return cVar2;
        }
        b3.c<Object> cVarT = impl.t(javaType);
        if (cVarT != null) {
            concurrentHashMap.put(javaType, cVarT);
            return cVarT;
        }
        impl.j("Cannot find a deserializer for type " + javaType);
        throw null;
    }
}
