package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import v2.a;
import v2.c;
import v2.d;
import y2.b;
import y2.e;
import y2.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ObjectMapper extends c implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final BaseSettings f3722l = new BaseSettings(null, new JacksonAnnotationIntrospector(), TypeFactory.f4468d, StdDateFormat.f4521p, Locale.getDefault(), a.f13372b, LaissezFaireSubTypeValidator.f4247a, new DefaultAccessorNamingStrategy.Provider());

    /* renamed from: a, reason: collision with root package name */
    public final JsonFactory f3723a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeFactory f3724b;

    /* renamed from: c, reason: collision with root package name */
    public SerializationConfig f3725c;

    /* renamed from: d, reason: collision with root package name */
    public final DefaultSerializerProvider f3726d;

    /* renamed from: e, reason: collision with root package name */
    public final BeanSerializerFactory f3727e;
    public DeserializationConfig h;

    /* renamed from: j, reason: collision with root package name */
    public final DefaultDeserializationContext f3728j;

    /* renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap<JavaType, b3.c<Object>> f3729k;

    public ObjectMapper() {
        this(null, 0);
    }

    @Override // v2.c
    public final void a(JsonGenerator jsonGenerator, Object obj) throws IOException {
        SerializationConfig serializationConfig = this.f3725c;
        if (serializationConfig.q(SerializationFeature.INDENT_OUTPUT) && jsonGenerator.f3540a == null) {
            d dVarK = serializationConfig.f3760n;
            if (dVarK instanceof a3.d) {
                dVarK = ((a3.d) dVarK).k();
            }
            jsonGenerator.f3540a = dVarK;
        }
        if (!serializationConfig.q(SerializationFeature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            d(serializationConfig).I(jsonGenerator, obj);
            if (serializationConfig.q(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
                return;
            }
            return;
        }
        Closeable closeable = (Closeable) obj;
        try {
            d(serializationConfig).I(jsonGenerator, obj);
            if (serializationConfig.q(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
            }
            closeable.close();
        } catch (Exception e10) {
            com.fasterxml.jackson.databind.util.a.g(null, closeable, e10);
            throw null;
        }
    }

    public final b3.c b(DefaultDeserializationContext.Impl impl, JavaType javaType) throws InvalidDefinitionException {
        ConcurrentHashMap<JavaType, b3.c<Object>> concurrentHashMap = this.f3729k;
        b3.c<Object> cVar = concurrentHashMap.get(javaType);
        if (cVar != null) {
            return cVar;
        }
        b3.c<Object> cVarT = impl.t(javaType);
        if (cVarT != null) {
            concurrentHashMap.put(javaType, cVarT);
            return cVarT;
        }
        impl.j("Cannot find a deserializer for type " + javaType);
        throw null;
    }

    public final b3.d c(e eVar) {
        b3.d dVar;
        JsonToken jsonTokenQ1;
        try {
            JavaType javaTypeJ = this.f3724b.j(b3.d.class);
            DeserializationConfig deserializationConfig = this.h;
            deserializationConfig.getClass();
            JsonNodeFactory jsonNodeFactory = deserializationConfig.f3658n;
            JsonToken jsonTokenQ12 = eVar.f13576c;
            if (jsonTokenQ12 == null && (jsonTokenQ12 = eVar.q1()) == null) {
                jsonNodeFactory.getClass();
                MissingNode missingNode = MissingNode.f4280a;
                eVar.close();
                return missingNode;
            }
            DefaultDeserializationContext.Impl impl = (DefaultDeserializationContext.Impl) this.f3728j;
            impl.getClass();
            DefaultDeserializationContext.Impl impl2 = new DefaultDeserializationContext.Impl(impl, deserializationConfig, eVar);
            if (jsonTokenQ12 == JsonToken.VALUE_NULL) {
                jsonNodeFactory.getClass();
                dVar = NullNode.f4282a;
            } else {
                dVar = (b3.d) impl2.Z(eVar, javaTypeJ, b(impl2, javaTypeJ));
            }
            if (!deserializationConfig.p(DeserializationFeature.FAIL_ON_TRAILING_TOKENS) || (jsonTokenQ1 = eVar.q1()) == null) {
                eVar.close();
                return dVar;
            }
            Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
            DeserializationContext.S(javaTypeJ == null ? null : javaTypeJ.f3690a, eVar, jsonTokenQ1);
            throw null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    eVar.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public final DefaultSerializerProvider.Impl d(SerializationConfig serializationConfig) {
        DefaultSerializerProvider.Impl impl = (DefaultSerializerProvider.Impl) this.f3726d;
        impl.getClass();
        return new DefaultSerializerProvider.Impl(impl, serializationConfig, this.f3727e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(b bVar, BaseJsonNode baseJsonNode) throws IOException {
        SerializationConfig serializationConfig = this.f3725c;
        if (!serializationConfig.q(SerializationFeature.CLOSE_CLOSEABLE) || !(baseJsonNode instanceof Closeable)) {
            try {
                d(serializationConfig).I(bVar, baseJsonNode);
                bVar.close();
                return;
            } catch (Exception e10) {
                Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
                bVar.n1(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
                try {
                    bVar.close();
                } catch (Exception e11) {
                    e10.addSuppressed(e11);
                }
                com.fasterxml.jackson.databind.util.a.C(e10);
                com.fasterxml.jackson.databind.util.a.D(e10);
                throw new RuntimeException(e10);
            }
        }
        Closeable closeable = (Closeable) baseJsonNode;
        try {
            d(serializationConfig).I(bVar, baseJsonNode);
            try {
                closeable.close();
                bVar.close();
            } catch (Exception e12) {
                e = e12;
                closeable = null;
                com.fasterxml.jackson.databind.util.a.g(bVar, closeable, e);
                throw null;
            }
        } catch (Exception e13) {
            e = e13;
        }
    }

    public final b f(a3.c cVar) {
        JsonFactory jsonFactory = this.f3723a;
        x2.b bVar = new x2.b(jsonFactory.a(), cVar, false);
        bVar.f13714b = JsonEncoding.UTF8;
        f fVar = new f(bVar, jsonFactory.f3531e, jsonFactory.h, cVar, jsonFactory.f3533k);
        v2.e eVar = jsonFactory.f3532j;
        if (eVar != JsonFactory.f3526o) {
            fVar.f13977m = eVar;
        }
        this.f3725c.o(fVar);
        return fVar;
    }

    public final b3.d g(String str) throws JsonProcessingException {
        if (str == null) {
            throw new IllegalArgumentException(a0.a.k("argument \"", "content", "\" is null"));
        }
        try {
            return c(this.f3723a.b(str));
        } catch (JsonProcessingException e10) {
            throw e10;
        } catch (IOException e11) {
            throw JsonMappingException.e(e11);
        }
    }

    public ObjectMapper(JsonFactory jsonFactory, int i10) {
        this.f3729k = new ConcurrentHashMap<>(64, 0.6f, 2);
        if (jsonFactory == null) {
            this.f3723a = new MappingJsonFactory(this);
        } else {
            this.f3723a = jsonFactory;
            if (jsonFactory.h == null) {
                jsonFactory.h = this;
            }
        }
        StdSubtypeResolver stdSubtypeResolver = new StdSubtypeResolver();
        RootNameLookup rootNameLookup = new RootNameLookup();
        this.f3724b = TypeFactory.f4468d;
        SimpleMixInResolver simpleMixInResolver = new SimpleMixInResolver();
        BasicClassIntrospector basicClassIntrospector = new BasicClassIntrospector();
        BaseSettings baseSettings = f3722l;
        BaseSettings baseSettings2 = baseSettings.f3790b == basicClassIntrospector ? baseSettings : new BaseSettings(basicClassIntrospector, baseSettings.f3791c, baseSettings.f3789a, baseSettings.h, baseSettings.f3794j, baseSettings.f3795k, baseSettings.f3793e, baseSettings.f3792d);
        ConfigOverrides configOverrides = new ConfigOverrides();
        CoercionConfigs coercionConfigs = new CoercionConfigs();
        this.f3725c = new SerializationConfig(baseSettings2, stdSubtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides);
        this.h = new DeserializationConfig(baseSettings2, stdSubtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides, coercionConfigs);
        this.f3723a.getClass();
        SerializationConfig serializationConfig = this.f3725c;
        MapperFeature mapperFeature = MapperFeature.SORT_PROPERTIES_ALPHABETICALLY;
        if (serializationConfig.k(mapperFeature)) {
            this.f3725c = this.f3725c.n(mapperFeature);
            this.h = this.h.n(mapperFeature);
        }
        this.f3726d = new DefaultSerializerProvider.Impl();
        this.f3728j = new DefaultDeserializationContext.Impl(BeanDeserializerFactory.f3872c);
        this.f3727e = BeanSerializerFactory.f4304d;
    }
}
