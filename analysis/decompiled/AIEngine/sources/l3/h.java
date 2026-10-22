package l3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsExternalTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsWrapperTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements k3.d<h> {

    /* renamed from: a, reason: collision with root package name */
    public JsonTypeInfo.Id f10204a;

    /* renamed from: b, reason: collision with root package name */
    public JsonTypeInfo.As f10205b;

    /* renamed from: c, reason: collision with root package name */
    public String f10206c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10207d = false;

    /* renamed from: e, reason: collision with root package name */
    public Class<?> f10208e;

    /* renamed from: f, reason: collision with root package name */
    public k3.c f10209f;

    @Override // k3.d
    public final h a(Class cls) {
        this.f10208e = cls;
        return this;
    }

    @Override // k3.d
    public final l b(SerializationConfig serializationConfig, JavaType javaType, ArrayList arrayList) {
        if (this.f10204a == JsonTypeInfo.Id.NONE || javaType.f3690a.isPrimitive()) {
            return null;
        }
        PolymorphicTypeValidator defaultBaseTypeLimitingValidator = serializationConfig.f3828b.f3793e;
        if (defaultBaseTypeLimitingValidator == LaissezFaireSubTypeValidator.f4247a && serializationConfig.k(MapperFeature.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            defaultBaseTypeLimitingValidator = new DefaultBaseTypeLimitingValidator();
        }
        k3.c cVarF = f(serializationConfig, javaType, defaultBaseTypeLimitingValidator, arrayList, true, false);
        if (this.f10204a == JsonTypeInfo.Id.DEDUCTION) {
            return new b(cVarF, null, this.f10206c);
        }
        int iOrdinal = this.f10205b.ordinal();
        if (iOrdinal == 0) {
            return new d(cVarF, null, this.f10206c);
        }
        if (iOrdinal == 1) {
            return new e(cVarF, null);
        }
        if (iOrdinal == 2) {
            return new a(cVarF, null);
        }
        if (iOrdinal == 3) {
            return new c(cVarF, null, this.f10206c);
        }
        if (iOrdinal == 4) {
            return new b(cVarF, null, this.f10206c);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f10205b);
    }

    @Override // k3.d
    public final TypeDeserializerBase c(DeserializationConfig deserializationConfig, JavaType javaType, ArrayList arrayList) {
        JavaType javaTypeJ;
        JavaType javaType2;
        if (this.f10204a == JsonTypeInfo.Id.NONE || javaType.f3690a.isPrimitive()) {
            return null;
        }
        PolymorphicTypeValidator defaultBaseTypeLimitingValidator = deserializationConfig.f3828b.f3793e;
        LaissezFaireSubTypeValidator laissezFaireSubTypeValidator = LaissezFaireSubTypeValidator.f4247a;
        if (defaultBaseTypeLimitingValidator == laissezFaireSubTypeValidator && deserializationConfig.k(MapperFeature.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            defaultBaseTypeLimitingValidator = new DefaultBaseTypeLimitingValidator();
        }
        BaseSettings baseSettings = deserializationConfig.f3828b;
        JsonTypeInfo.Id id2 = this.f10204a;
        if (id2 == JsonTypeInfo.Id.CLASS || id2 == JsonTypeInfo.Id.MINIMAL_CLASS) {
            PolymorphicTypeValidator.Validity validityA = defaultBaseTypeLimitingValidator.a(javaType);
            if (validityA == PolymorphicTypeValidator.Validity.f4239b) {
                throw new IllegalArgumentException(ai.onnxruntime.a.l("Configured `PolymorphicTypeValidator` (of type ", com.fasterxml.jackson.databind.util.a.f(defaultBaseTypeLimitingValidator), ") denied resolution of all subtypes of base type ", com.fasterxml.jackson.databind.util.a.f(javaType.f3690a)));
            }
            if (validityA == PolymorphicTypeValidator.Validity.f4238a) {
                defaultBaseTypeLimitingValidator = laissezFaireSubTypeValidator;
            }
        }
        k3.c cVarF = f(deserializationConfig, javaType, defaultBaseTypeLimitingValidator, arrayList, false, true);
        Class<?> cls = this.f10208e;
        if (cls == null) {
            javaType2 = (!deserializationConfig.k(MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL) || javaType.v()) ? null : javaType;
        } else {
            if (cls == Void.class || cls == c3.i.class) {
                javaTypeJ = baseSettings.f3789a.j(cls);
            } else {
                if (!javaType.u(cls)) {
                    if (javaType.E(this.f10208e)) {
                        javaTypeJ = baseSettings.f3789a.i(javaType, this.f10208e, false);
                    }
                }
            }
            javaType2 = javaTypeJ;
        }
        if (this.f10204a == JsonTypeInfo.Id.DEDUCTION) {
            return new AsDeductionTypeDeserializer(javaType, cVarF, javaType2, deserializationConfig, arrayList);
        }
        int iOrdinal = this.f10205b.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return new AsWrapperTypeDeserializer(javaType, cVarF, this.f10206c, this.f10207d, javaType2);
            }
            if (iOrdinal == 2) {
                return new AsArrayTypeDeserializer(javaType, cVarF, this.f10206c, this.f10207d, javaType2);
            }
            if (iOrdinal == 3) {
                return new AsExternalTypeDeserializer(javaType, cVarF, this.f10206c, this.f10207d, javaType2);
            }
            if (iOrdinal != 4) {
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f10205b);
            }
        }
        return new AsPropertyTypeDeserializer(javaType, cVarF, this.f10206c, this.f10207d, javaType2, this.f10205b);
    }

    @Override // k3.d
    public final h d(JsonTypeInfo.Id id2, k3.c cVar) {
        if (id2 == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this.f10204a = id2;
        this.f10209f = cVar;
        this.f10206c = id2.f3490a;
        return this;
    }

    @Override // k3.d
    public final Class<?> e() {
        return this.f10208e;
    }

    public final k3.c f(MapperConfigBase mapperConfigBase, JavaType javaType, PolymorphicTypeValidator polymorphicTypeValidator, Collection collection, boolean z, boolean z3) {
        ConcurrentHashMap concurrentHashMap;
        String name;
        k3.c cVar = this.f10209f;
        if (cVar != null) {
            return cVar;
        }
        JsonTypeInfo.Id id2 = this.f10204a;
        if (id2 == null) {
            throw new IllegalStateException("Cannot build, 'init()' not yet called");
        }
        int iOrdinal = id2.ordinal();
        HashMap map = null;
        if (iOrdinal == 0) {
            return null;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return new g(javaType, mapperConfigBase.f3828b.f3789a, polymorphicTypeValidator);
            }
            if (iOrdinal == 3) {
                if (z == z3) {
                    throw new IllegalArgumentException();
                }
                if (z) {
                    concurrentHashMap = new ConcurrentHashMap();
                } else {
                    map = new HashMap();
                    concurrentHashMap = new ConcurrentHashMap(4);
                }
                boolean zK = mapperConfigBase.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
                if (collection != null) {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        NamedType namedType = (NamedType) it.next();
                        Class<?> cls = namedType.f4235a;
                        if (namedType.a()) {
                            name = namedType.f4237c;
                        } else {
                            name = cls.getName();
                            int iLastIndexOf = name.lastIndexOf(46);
                            if (iLastIndexOf >= 0) {
                                name = name.substring(iLastIndexOf + 1);
                            }
                        }
                        if (z) {
                            concurrentHashMap.put(cls.getName(), name);
                        }
                        if (z3) {
                            if (zK) {
                                name = name.toLowerCase();
                            }
                            JavaType javaType2 = (JavaType) map.get(name);
                            if (javaType2 == null || !cls.isAssignableFrom(javaType2.f3690a)) {
                                map.put(name, mapperConfigBase.c(cls));
                            }
                        }
                    }
                }
                return new k(mapperConfigBase, javaType, concurrentHashMap, map);
            }
            if (iOrdinal != 4) {
                throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.f10204a);
            }
        }
        return new f(javaType, mapperConfigBase.f3828b.f3789a, polymorphicTypeValidator);
    }
}
