package com.fasterxml.jackson.databind.deser;

import b3.c;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.h;
import com.fasterxml.jackson.databind.type.TypeFactory;
import e3.a;
import i3.d;
import i3.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f3871b = {Throwable.class};

    /* renamed from: c, reason: collision with root package name */
    public static final BeanDeserializerFactory f3872c = new BeanDeserializerFactory(new DeserializerFactoryConfig());

    public static void s(d dVar, a aVar) {
        Map map;
        h hVar = dVar.f9496b;
        if (hVar != null) {
            if (!hVar.f4221i) {
                hVar.g();
            }
            map = hVar.f4230s;
        } else {
            map = Collections.EMPTY_MAP;
        }
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                AnnotatedMember annotatedMember = (AnnotatedMember) entry.getValue();
                PropertyName propertyNameA = PropertyName.a(annotatedMember.d());
                JavaType javaTypeF = annotatedMember.f();
                q3.a aVar2 = dVar.f9499e.f4182m;
                Object key = entry.getKey();
                DeserializationConfig deserializationConfig = aVar.f8597a;
                if (aVar.f8601e == null) {
                    aVar.f8601e = new ArrayList();
                }
                deserializationConfig.getClass();
                if (deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                    annotatedMember.g(deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
                aVar.f8601e.add(new ValueInjector(propertyNameA, javaTypeF, annotatedMember, key));
            }
        }
    }

    public static void t(DeserializationContext deserializationContext, d dVar, a aVar) {
        JavaType javaType;
        ObjectIdGenerator objectIdGeneratorG;
        SettableBeanProperty settableBeanProperty;
        i3.h hVar = dVar.f9502i;
        if (hVar == null) {
            return;
        }
        Class<? extends ObjectIdGenerator<?>> cls = hVar.f9512b;
        com.fasterxml.jackson.annotation.a aVarH = deserializationContext.h(hVar);
        if (cls == ObjectIdGenerators$PropertyGenerator.class) {
            PropertyName propertyName = hVar.f9511a;
            settableBeanProperty = (SettableBeanProperty) aVar.f8600d.get(propertyName.f3755a);
            if (settableBeanProperty == null) {
                throw new IllegalArgumentException(ai.onnxruntime.a.l("Invalid Object Id definition for ", com.fasterxml.jackson.databind.util.a.r(dVar.f3041a), ": cannot find property with name ", com.fasterxml.jackson.databind.util.a.c(propertyName.f3755a)));
            }
            javaType = settableBeanProperty.f3892d;
            objectIdGeneratorG = new PropertyBasedObjectIdGenerator(hVar.f9514d);
        } else {
            JavaType javaTypeK = deserializationContext.k(cls);
            deserializationContext.e().getClass();
            javaType = TypeFactory.l(javaTypeK, ObjectIdGenerator.class)[0];
            objectIdGeneratorG = deserializationContext.g(hVar);
            settableBeanProperty = null;
        }
        JavaType javaType2 = javaType;
        ObjectIdGenerator objectIdGenerator = objectIdGeneratorG;
        SettableBeanProperty settableBeanProperty2 = settableBeanProperty;
        aVar.f8605j = new ObjectIdReader(javaType2, hVar.f9511a, objectIdGenerator, deserializationContext.t(javaType2), settableBeanProperty2, aVarH);
    }

    public final void q(DeserializationContext deserializationContext, d dVar, a aVar) throws InvalidDefinitionException {
        ArrayList arrayList = null;
        HashSet hashSet = null;
        for (e eVar : dVar.d()) {
            AnnotationIntrospector.ReferenceProperty referencePropertyK = eVar.k();
            if (referencePropertyK != null && referencePropertyK.f3647a == AnnotationIntrospector.ReferenceProperty.Type.f3650b) {
                String str = referencePropertyK.f3648b;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashSet = new HashSet();
                    hashSet.add(str);
                } else if (!hashSet.add(str)) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name " + com.fasterxml.jackson.databind.util.a.x(str));
                }
                arrayList.add(eVar);
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                e eVar2 = (e) obj;
                AnnotationIntrospector.ReferenceProperty referencePropertyK2 = eVar2.k();
                String str2 = referencePropertyK2 == null ? null : referencePropertyK2.f3648b;
                SettableBeanProperty settableBeanPropertyU = u(deserializationContext, dVar, eVar2, eVar2.r());
                DeserializationConfig deserializationConfig = aVar.f8597a;
                if (aVar.f8602f == null) {
                    aVar.f8602f = new HashMap<>(4);
                }
                deserializationConfig.getClass();
                if (deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                    settableBeanPropertyU.l(deserializationConfig);
                }
                aVar.f8602f.put(str2, settableBeanPropertyU);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013f  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r16v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r25v0, types: [com.fasterxml.jackson.databind.DeserializationContext] */
    /* JADX WARN: Type inference failed for: r27v0, types: [e3.a] */
    /* JADX WARN: Type inference failed for: r8v36 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(com.fasterxml.jackson.databind.DeserializationContext r25, i3.d r26, e3.a r27) throws com.fasterxml.jackson.databind.exc.InvalidDefinitionException {
        /*
            Method dump skipped, instructions count: 1064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BeanDeserializerFactory.r(com.fasterxml.jackson.databind.DeserializationContext, i3.d, e3.a):void");
    }

    public final SettableBeanProperty u(DeserializationContext deserializationContext, d dVar, e eVar, JavaType javaType) throws InvalidDefinitionException {
        e eVar2;
        SettableBeanProperty fieldProperty;
        com.fasterxml.jackson.databind.introspect.a aVar = dVar.f9499e;
        AnnotatedMember annotatedMemberT = eVar.t();
        if (annotatedMemberT == null) {
            annotatedMemberT = eVar.p();
        }
        if (annotatedMemberT == null) {
            deserializationContext.N(dVar, eVar, "No non-constructor mutator available", new Object[0]);
            throw null;
        }
        JavaType javaTypeP = p(deserializationContext, annotatedMemberT, javaType);
        b bVar = (b) javaTypeP.f3693d;
        if (annotatedMemberT instanceof AnnotatedMethod) {
            eVar2 = eVar;
            fieldProperty = new MethodProperty(eVar2, javaTypeP, bVar, aVar.f4182m, (AnnotatedMethod) annotatedMemberT);
        } else {
            eVar2 = eVar;
            fieldProperty = new FieldProperty(eVar2, javaTypeP, bVar, aVar.f4182m, (AnnotatedField) annotatedMemberT);
        }
        c<?> cVarM = BasicDeserializerFactory.m(deserializationContext, annotatedMemberT);
        if (cVarM == null) {
            cVarM = (c) javaTypeP.f3692c;
        }
        if (cVarM != null) {
            fieldProperty = fieldProperty.D(deserializationContext.y(cVarM, fieldProperty, javaTypeP));
        }
        AnnotationIntrospector.ReferenceProperty referencePropertyK = eVar2.k();
        if (referencePropertyK != null && referencePropertyK.f3647a == AnnotationIntrospector.ReferenceProperty.Type.f3649a) {
            fieldProperty.f3895k = referencePropertyK.f3648b;
        }
        i3.h hVarJ = eVar2.j();
        if (hVarJ != null) {
            fieldProperty.f3896l = hVarJ;
        }
        return fieldProperty;
    }

    public final SetterlessProperty v(DeserializationContext deserializationContext, d dVar, e eVar) throws InvalidDefinitionException {
        AnnotatedMethod annotatedMethodQ = eVar.q();
        JavaType javaTypeP = p(deserializationContext, annotatedMethodQ, annotatedMethodQ.f());
        SetterlessProperty setterlessProperty = new SetterlessProperty(eVar, javaTypeP, (b) javaTypeP.f3693d, dVar.f9499e.f4182m, annotatedMethodQ);
        c<?> cVarM = BasicDeserializerFactory.m(deserializationContext, annotatedMethodQ);
        if (cVarM == null) {
            cVarM = (c) javaTypeP.f3692c;
        }
        return cVarM != null ? (SetterlessProperty) setterlessProperty.D(deserializationContext.y(cVarM, setterlessProperty, javaTypeP)) : setterlessProperty;
    }
}
