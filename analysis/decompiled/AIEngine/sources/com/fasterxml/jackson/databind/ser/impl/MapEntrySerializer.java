package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.a;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Map;
import k3.e;
import n3.c;
import q3.b;
import q3.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public class MapEntrySerializer extends ContainerSerializer<Map.Entry<?, ?>> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final BeanProperty f4315c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4316d;

    /* renamed from: e, reason: collision with root package name */
    public final JavaType f4317e;
    public final JavaType h;

    /* renamed from: j, reason: collision with root package name */
    public final f<Object> f4318j;

    /* renamed from: k, reason: collision with root package name */
    public final f<Object> f4319k;

    /* renamed from: l, reason: collision with root package name */
    public final e f4320l;

    /* renamed from: m, reason: collision with root package name */
    public a f4321m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f4322n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f4323o;

    public MapEntrySerializer(JavaType javaType, JavaType javaType2, JavaType javaType3, boolean z, e eVar, BeanProperty beanProperty) {
        super(javaType);
        this.f4317e = javaType2;
        this.h = javaType3;
        this.f4316d = z;
        this.f4320l = eVar;
        this.f4315c = beanProperty;
        this.f4321m = a.b.f4334a;
        this.f4322n = null;
        this.f4323o = false;
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        f<Object> fVarG;
        f<?> fVarG2;
        boolean zD;
        boolean z;
        Object obj;
        JsonInclude.Value valueE;
        JsonInclude.Include include;
        SerializationConfig serializationConfig = hVar.f3044a;
        AnnotationIntrospector annotationIntrospectorD = serializationConfig.d();
        Object objB = null;
        AnnotatedMember annotatedMemberD = beanProperty == null ? null : beanProperty.d();
        if (annotatedMemberD == null || annotationIntrospectorD == null) {
            fVarG = null;
            fVarG2 = null;
        } else {
            Object objS = annotationIntrospectorD.s(annotatedMemberD);
            fVarG2 = objS != null ? hVar.G(annotatedMemberD, objS) : null;
            Object objD = annotationIntrospectorD.d(annotatedMemberD);
            fVarG = objD != null ? hVar.G(annotatedMemberD, objD) : null;
        }
        if (fVarG == null) {
            fVarG = this.f4319k;
        }
        f<Object> fVarJ = StdSerializer.j(hVar, beanProperty, fVarG);
        JavaType javaType = this.h;
        if (fVarJ == null && this.f4316d && !javaType.A()) {
            fVarJ = hVar.q(javaType, beanProperty);
        }
        f<Object> fVar = fVarJ;
        if (fVarG2 == null) {
            fVarG2 = this.f4318j;
        }
        f<?> fVarS = fVarG2 == null ? hVar.s(this.f4317e, beanProperty) : hVar.B(fVarG2, beanProperty);
        if (beanProperty != null && (valueE = beanProperty.e(serializationConfig, null)) != null && (include = valueE.f3471b) != JsonInclude.Include.f3468e) {
            int iOrdinal = include.ordinal();
            zD = true;
            if (iOrdinal != 1) {
                JsonInclude.Include include2 = JsonInclude.Include.f3466c;
                if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        z = true;
                        obj = include2;
                    } else if (iOrdinal == 4) {
                        objB = d.b(javaType);
                        if (objB != null && objB.getClass().isArray()) {
                            objB = b.a(objB);
                        }
                    } else if (iOrdinal != 5) {
                        zD = false;
                    } else {
                        objB = hVar.C(valueE.f3473d);
                        if (objB != null) {
                            zD = hVar.D(objB);
                        }
                    }
                } else if (javaType.d()) {
                    objB = include2;
                }
            }
            return new MapEntrySerializer(this, fVarS, fVar, obj, z);
        }
        objB = this.f4322n;
        zD = this.f4323o;
        z = zD;
        obj = objB;
        return new MapEntrySerializer(this, fVarS, fVar, obj, z);
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        Object value = ((Map.Entry) obj).getValue();
        if (value == null) {
            return this.f4323o;
        }
        Object obj2 = this.f4322n;
        if (obj2 == null) {
            return false;
        }
        f<Object> fVar = this.f4319k;
        if (fVar == null) {
            Class<?> cls = value.getClass();
            f<Object> fVarC = this.f4321m.c(cls);
            if (fVarC == null) {
                try {
                    a aVar = this.f4321m;
                    BeanProperty beanProperty = this.f4315c;
                    aVar.getClass();
                    f<Object> fVarR = hVar.r(cls, beanProperty);
                    a aVarB = aVar.b(cls, fVarR);
                    if (aVar != aVarB) {
                        this.f4321m = aVarB;
                    }
                    fVar = fVarR;
                } catch (JsonMappingException unused) {
                    return false;
                }
            } else {
                fVar = fVarC;
            }
        }
        return obj2 == JsonInclude.Include.f3466c ? fVar.d(hVar, value) : obj2.equals(value);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) obj;
        jsonGenerator.d1(entry);
        p(entry, jsonGenerator, hVar);
        jsonGenerator.G0();
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) obj;
        jsonGenerator.Q(entry);
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.START_OBJECT, entry));
        p(entry, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer<?> o(e eVar) {
        return new MapEntrySerializer(this, this.f4318j, this.f4319k, this.f4322n, this.f4323o);
    }

    public final void p(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, h hVar) throws IOException {
        f<Object> fVar;
        Object key = entry.getKey();
        f<Object> fVar2 = key == null ? hVar.f3049j : this.f4318j;
        Object value = entry.getValue();
        if (value != null) {
            fVar = this.f4319k;
            if (fVar == null) {
                Class<?> cls = value.getClass();
                f<Object> fVarC = this.f4321m.c(cls);
                if (fVarC == null) {
                    JavaType javaType = this.h;
                    boolean zS = javaType.s();
                    BeanProperty beanProperty = this.f4315c;
                    if (zS) {
                        a aVar = this.f4321m;
                        a.d dVarA = aVar.a(hVar.o(javaType, cls), hVar, beanProperty);
                        a aVar2 = dVarA.f4337b;
                        if (aVar != aVar2) {
                            this.f4321m = aVar2;
                        }
                        fVar = dVarA.f4336a;
                    } else {
                        a aVar3 = this.f4321m;
                        aVar3.getClass();
                        f<Object> fVarR = hVar.r(cls, beanProperty);
                        a aVarB = aVar3.b(cls, fVarR);
                        if (aVar3 != aVarB) {
                            this.f4321m = aVarB;
                        }
                        fVar = fVarR;
                    }
                } else {
                    fVar = fVarC;
                }
            }
            Object obj = this.f4322n;
            if (obj != null && ((obj == JsonInclude.Include.f3466c && fVar.d(hVar, value)) || obj.equals(value))) {
                return;
            }
        } else if (this.f4323o) {
            return;
        } else {
            fVar = hVar.h;
        }
        fVar2.f(key, jsonGenerator, hVar);
        e eVar = this.f4320l;
        try {
            if (eVar == null) {
                fVar.f(value, jsonGenerator, hVar);
            } else {
                fVar.g(value, jsonGenerator, hVar, eVar);
            }
        } catch (Exception e10) {
            StdSerializer.n(hVar, e10, entry, "" + key);
            throw null;
        }
    }

    public MapEntrySerializer(MapEntrySerializer mapEntrySerializer, f fVar, f fVar2, Object obj, boolean z) {
        super(Map.class, 0);
        this.f4317e = mapEntrySerializer.f4317e;
        this.h = mapEntrySerializer.h;
        this.f4316d = mapEntrySerializer.f4316d;
        this.f4320l = mapEntrySerializer.f4320l;
        this.f4318j = fVar;
        this.f4319k = fVar2;
        this.f4321m = a.b.f4334a;
        this.f4315c = mapEntrySerializer.f4315c;
        this.f4322n = obj;
        this.f4323o = z;
    }
}
