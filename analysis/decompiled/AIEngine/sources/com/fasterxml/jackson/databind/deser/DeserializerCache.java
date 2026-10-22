package com.fasterxml.jackson.databind.deser;

import b3.c;
import b3.g;
import c3.e;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.introspect.h;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.util.LRUMap;
import e3.b;
import e3.f;
import e3.j;
import i3.d;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeserializerCache implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<JavaType, c<Object>> f3880b = new HashMap<>(8);

    /* renamed from: a, reason: collision with root package name */
    public final LRUMap<JavaType, c<Object>> f3879a = new LRUMap<>(Math.min(64, 500), 2000);

    public static c b(DeserializationContext deserializationContext, f fVar, JavaType javaType) throws InvalidDefinitionException {
        c cVarL;
        JavaType javaTypeO0;
        Object objC;
        c cVarL2;
        JavaType javaTypeO;
        Object objR;
        g gVarK;
        JavaType javaType2;
        boolean z;
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        if (javaType.v() || javaType.B() || javaType.w()) {
            fVar.c(javaType);
        }
        d dVarO = deserializationConfig.o(javaType);
        a aVar = dVarO.f9499e;
        Object objJ = deserializationConfig.d().j(aVar);
        if (objJ == null) {
            cVarL = null;
        } else {
            cVarL = deserializationContext.l(objJ);
            Object objI = deserializationConfig.d().i(aVar);
            q3.g gVarC = objI == null ? null : deserializationContext.c(objI);
            if (gVarC != null) {
                deserializationContext.e();
                cVarL = new StdDelegatingDeserializer(gVarC, gVarC.getInputType(), cVarL);
            }
        }
        if (cVarL != null) {
            return cVarL;
        }
        AnnotationIntrospector annotationIntrospectorD = deserializationConfig.d();
        if (annotationIntrospectorD == null) {
            javaTypeO0 = javaType;
        } else {
            JavaType javaTypeS = (!javaType.B() || (javaTypeO = javaType.o()) == null || javaTypeO.f3692c != null || (objR = annotationIntrospectorD.r(aVar)) == null || (gVarK = deserializationContext.K(objR)) == null) ? javaType : ((MapLikeType) javaType).S(gVarK);
            JavaType javaTypeK = javaTypeS.k();
            if (javaTypeK != null && javaTypeK.f3692c == null && (objC = annotationIntrospectorD.c(aVar)) != null) {
                if (objC instanceof c) {
                    cVarL2 = (c) objC;
                } else {
                    Class cls = (Class) objC;
                    if (cls == c.a.class || com.fasterxml.jackson.databind.util.a.t(cls)) {
                        cls = null;
                    }
                    cVarL2 = cls != null ? deserializationContext.l(cls) : null;
                }
                if (cVarL2 != null) {
                    javaTypeS = javaTypeS.I(cVarL2);
                }
            }
            javaTypeO0 = annotationIntrospectorD.o0(deserializationConfig, aVar, javaTypeS);
        }
        if (javaTypeO0 != javaType) {
            dVarO = deserializationConfig.o(javaTypeO0);
            javaType2 = javaTypeO0;
        } else {
            javaType2 = javaType;
        }
        Class<?> cls2 = javaType2.f3690a;
        a aVar2 = dVarO.f9499e;
        AnnotationIntrospector annotationIntrospector = dVarO.f9498d;
        Class<?> clsA = annotationIntrospector == null ? null : annotationIntrospector.A(aVar2);
        if (clsA == null) {
            q3.g<Object, Object> gVarC2 = annotationIntrospector != null ? dVarO.c(annotationIntrospector.i(aVar2)) : null;
            if (gVarC2 == null) {
                return c(deserializationContext, fVar, javaType2, dVarO);
            }
            deserializationContext.e();
            JavaType inputType = gVarC2.getInputType();
            if (!inputType.u(cls2)) {
                dVarO = deserializationConfig.o(inputType);
            }
            return new StdDelegatingDeserializer(gVarC2, inputType, c(deserializationContext, fVar, inputType, dVarO));
        }
        BeanDeserializerFactory beanDeserializerFactory = (BeanDeserializerFactory) fVar;
        beanDeserializerFactory.getClass();
        JavaType javaTypeC = deserializationConfig.k(MapperFeature.INFER_BUILDER_TYPE_BINDINGS) ? deserializationContext.e().c(null, clsA, javaType2.j()) : deserializationContext.k(clsA);
        BaseSettings baseSettings = deserializationConfig.f3828b;
        ((BasicClassIntrospector) baseSettings.f3790b).getClass();
        a aVarC = BasicClassIntrospector.c(deserializationConfig, javaTypeC, deserializationConfig);
        DefaultAccessorNamingStrategy.Provider provider = baseSettings.f3792d;
        AnnotationIntrospector annotationIntrospectorD2 = deserializationConfig.k(MapperFeature.USE_ANNOTATIONS) ? deserializationConfig.d() : null;
        e.a aVarB = annotationIntrospectorD2 == null ? null : annotationIntrospectorD2.B(aVarC);
        d dVar = new d(new h(deserializationConfig, false, javaTypeC, aVarC, new DefaultAccessorNamingStrategy(deserializationConfig, aVarB == null ? provider.f4156b : aVarB.f3284b, provider.f4157c, provider.f4158d)));
        DeserializerFactoryConfig deserializerFactoryConfig = beanDeserializerFactory.f3848a;
        try {
            ValueInstantiator valueInstantiatorO = beanDeserializerFactory.o(deserializationContext, dVar);
            e3.a aVar3 = new e3.a(dVar, deserializationContext);
            aVar3.f8604i = valueInstantiatorO;
            beanDeserializerFactory.r(deserializationContext, dVar, aVar3);
            BeanDeserializerFactory.t(deserializationContext, dVar, aVar3);
            beanDeserializerFactory.q(deserializationContext, dVar, aVar3);
            BeanDeserializerFactory.s(dVar, aVar3);
            a aVar4 = dVar.f9499e;
            AnnotationIntrospector annotationIntrospector2 = dVar.f9498d;
            e.a aVarB2 = annotationIntrospector2 == null ? null : annotationIntrospector2.B(aVar4);
            String str = aVarB2 == null ? "build" : aVarB2.f3283a;
            LinkedHashMap linkedHashMap = aVar4.h().f9492a;
            AnnotatedMethod annotatedMethod = linkedHashMap == null ? null : (AnnotatedMethod) linkedHashMap.get(new i3.g(str, null));
            if (annotatedMethod != null && deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                com.fasterxml.jackson.databind.util.a.e(annotatedMethod.f4124d, deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            aVar3.f8608m = annotatedMethod;
            if (deserializerFactoryConfig.c()) {
                q3.c cVarA = deserializerFactoryConfig.a();
                while (cVarA.hasNext()) {
                    ((b) cVarA.next()).getClass();
                }
            }
            AnnotatedMethod annotatedMethod2 = aVar3.f8608m;
            d dVar2 = aVar3.f8599c;
            DeserializationContext deserializationContext2 = aVar3.f8598b;
            if (annotatedMethod2 != null) {
                Class<?> returnType = annotatedMethod2.f4124d.getReturnType();
                if (returnType != cls2 && !returnType.isAssignableFrom(cls2) && !cls2.isAssignableFrom(returnType)) {
                    JavaType javaType3 = dVar2.f3041a;
                    String strI = aVar3.f8608m.i();
                    String strM = com.fasterxml.jackson.databind.util.a.m(returnType);
                    String strR = com.fasterxml.jackson.databind.util.a.r(javaType2);
                    StringBuilder sbS = ai.onnxruntime.a.s("Build method `", strI, "` has wrong return type (", strM, "), not compatible with POJO type (");
                    sbS.append(strR);
                    sbS.append(")");
                    deserializationContext2.j(sbS.toString());
                    throw null;
                }
            } else if (!str.isEmpty()) {
                deserializationContext2.j(h0.e.c("Builder class ", com.fasterxml.jackson.databind.util.a.r(dVar2.f3041a), " does not have build method (name: '", str, "')"));
                throw null;
            }
            Collection<SettableBeanProperty> collectionValues = aVar3.f8600d.values();
            aVar3.b(collectionValues);
            Map<String, List<PropertyName>> mapA = aVar3.a(collectionValues);
            Boolean boolB = dVar2.a().b(JsonFormat.Feature.f3435b);
            DeserializationConfig deserializationConfig2 = aVar3.f8597a;
            BeanPropertyMap beanPropertyMap = new BeanPropertyMap(boolB == null ? deserializationConfig2.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES) : boolB.booleanValue(), collectionValues, mapA, deserializationConfig2.f3828b.f3794j);
            int length = beanPropertyMap.f3906e.length;
            int i10 = 0;
            for (int i11 = 1; i11 < length; i11 += 2) {
                SettableBeanProperty settableBeanProperty = (SettableBeanProperty) beanPropertyMap.f3906e[i11];
                if (settableBeanProperty != null) {
                    settableBeanProperty.g(i10);
                    i10++;
                }
            }
            boolean zK = deserializationConfig2.k(MapperFeature.DEFAULT_VIEW_INCLUSION);
            boolean z3 = !zK;
            if (zK) {
                Iterator<SettableBeanProperty> it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (it.next().v()) {
                        z = true;
                        break;
                    }
                }
                z = z3;
            } else {
                z = z3;
            }
            if (aVar3.f8605j != null) {
                beanPropertyMap = beanPropertyMap.g(new ObjectIdValueProperty(aVar3.f8605j, PropertyMetadata.f3742k));
            }
            BuilderBasedDeserializer builderBasedDeserializer = new BuilderBasedDeserializer(aVar3, aVar3.f8599c, javaType2, beanPropertyMap, aVar3.f8602f, aVar3.f8603g, aVar3.f8607l, aVar3.h, z);
            if (deserializerFactoryConfig.c()) {
                q3.c cVarA2 = deserializerFactoryConfig.a();
                while (cVarA2.hasNext()) {
                    ((b) cVarA2.next()).getClass();
                }
            }
            return builderBasedDeserializer;
        } catch (IllegalArgumentException e10) {
            throw new InvalidDefinitionException(deserializationContext.h, com.fasterxml.jackson.databind.util.a.i(e10));
        } catch (NoClassDefFoundError e11) {
            return new f3.c(e11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:528:0x0849, code lost:
    
        if (r10.endsWith("DataSource") != false) goto L560;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x020d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x068d A[PHI: r12
      0x068d: PHI (r12v68 b3.c) = (r12v40 b3.c), (r12v88 b3.c) binds: [B:407:0x068b, B:444:0x0719] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0711  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x07fb  */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r4v9, types: [b3.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b3.c c(com.fasterxml.jackson.databind.DeserializationContext r21, e3.f r22, com.fasterxml.jackson.databind.JavaType r23, i3.d r24) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        /*
            Method dump skipped, instructions count: 2373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.DeserializerCache.c(com.fasterxml.jackson.databind.DeserializationContext, e3.f, com.fasterxml.jackson.databind.JavaType, i3.d):b3.c");
    }

    public static boolean d(JavaType javaType) {
        if (!javaType.y()) {
            return false;
        }
        JavaType javaTypeK = javaType.k();
        if (javaTypeK == null || (javaTypeK.f3692c == null && javaTypeK.f3693d == null)) {
            return javaType.B() && javaType.o().f3692c != null;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c<Object> a(DeserializationContext deserializationContext, f fVar, JavaType javaType) throws JsonMappingException {
        try {
            c<Object> cVarB = b(deserializationContext, fVar, javaType);
            if (cVarB == 0) {
                return null;
            }
            boolean z = !d(javaType) && cVarB.n();
            if (cVarB instanceof j) {
                HashMap<JavaType, c<Object>> map = this.f3880b;
                map.put(javaType, cVarB);
                ((j) cVarB).b(deserializationContext);
                map.remove(javaType);
            }
            if (z) {
                this.f3879a.a(javaType, cVarB);
            }
            return cVarB;
        } catch (IllegalArgumentException e10) {
            throw new JsonMappingException(deserializationContext.h, com.fasterxml.jackson.databind.util.a.i(e10), e10);
        }
    }

    public final c<Object> e(DeserializationContext deserializationContext, f fVar, JavaType javaType) throws JsonMappingException {
        c<Object> cVarA;
        c<Object> cVar;
        if (javaType == null) {
            throw new IllegalArgumentException("Null JavaType passed");
        }
        c<Object> cVar2 = d(javaType) ? null : this.f3879a.f4509b.get(javaType);
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this.f3880b) {
            try {
                cVarA = d(javaType) ? null : this.f3879a.f4509b.get(javaType);
                if (cVarA == null) {
                    int size = this.f3880b.size();
                    if (size <= 0 || (cVar = this.f3880b.get(javaType)) == null) {
                        try {
                            cVarA = a(deserializationContext, fVar, javaType);
                        } finally {
                            if (size == 0 && this.f3880b.size() > 0) {
                                this.f3880b.clear();
                            }
                        }
                    } else {
                        cVarA = cVar;
                    }
                }
            } finally {
            }
        }
        if (cVarA != null) {
            return cVarA;
        }
        Class<?> cls = javaType.f3690a;
        Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
        if ((cls.getModifiers() & 1536) == 0) {
            deserializationContext.j("Cannot find a Value deserializer for type " + javaType);
            throw null;
        }
        deserializationContext.j("Cannot find a Value deserializer for abstract type " + javaType);
        throw null;
    }

    public Object writeReplace() {
        this.f3880b.clear();
        return this;
    }
}
