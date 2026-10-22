package com.fasterxml.jackson.databind.deser;

import b3.c;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import e3.a;
import i3.d;
import i3.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AbstractDeserializer extends c<Object> implements e3.c, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final JavaType f3841a;

    /* renamed from: b, reason: collision with root package name */
    public final ObjectIdReader f3842b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, SettableBeanProperty> f3843c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Map<String, SettableBeanProperty> f3844d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3845e;
    public final boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3846j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3847k;

    public AbstractDeserializer(a aVar, b3.a aVar2, HashMap map, Map map2) {
        JavaType javaType = aVar2.f3041a;
        this.f3841a = javaType;
        this.f3842b = aVar.f8605j;
        this.f3843c = map;
        this.f3844d = map2;
        Class<?> cls = javaType.f3690a;
        this.f3845e = cls.isAssignableFrom(String.class);
        boolean z = true;
        this.h = cls == Boolean.TYPE || cls.isAssignableFrom(Boolean.class);
        this.f3846j = cls == Integer.TYPE || cls.isAssignableFrom(Integer.class);
        if (cls != Double.TYPE && !cls.isAssignableFrom(Double.class)) {
            z = false;
        }
        this.f3847k = z;
    }

    @Override // e3.c
    public final c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) throws InvalidDefinitionException {
        AnnotatedMember annotatedMemberD;
        h hVarY;
        JavaType javaType;
        ObjectIdGenerator objectIdGeneratorG;
        SettableBeanProperty settableBeanProperty;
        AnnotationIntrospector annotationIntrospectorD = deserializationContext.f3663c.d();
        Map<String, SettableBeanProperty> map = this.f3844d;
        if (beanProperty == null || annotationIntrospectorD == null || (annotatedMemberD = beanProperty.d()) == null || (hVarY = annotationIntrospectorD.y(annotatedMemberD)) == null) {
            return map == null ? this : new AbstractDeserializer(this, this.f3842b);
        }
        com.fasterxml.jackson.annotation.a aVarH = deserializationContext.h(hVarY);
        h hVarZ = annotationIntrospectorD.z(annotatedMemberD, hVarY);
        Class<? extends ObjectIdGenerator<?>> cls = hVarZ.f9512b;
        if (cls == ObjectIdGenerators$PropertyGenerator.class) {
            PropertyName propertyName = hVarZ.f9511a;
            SettableBeanProperty settableBeanProperty2 = map == null ? null : map.get(propertyName.f3755a);
            if (settableBeanProperty2 == null) {
                deserializationContext.j("Invalid Object Id definition for " + com.fasterxml.jackson.databind.util.a.y(this.f3841a.f3690a) + ": cannot find property with name " + (propertyName == null ? "[null]" : com.fasterxml.jackson.databind.util.a.c(propertyName.f3755a)));
                throw null;
            }
            javaType = settableBeanProperty2.f3892d;
            objectIdGeneratorG = new PropertyBasedObjectIdGenerator(hVarZ.f9514d);
            settableBeanProperty = settableBeanProperty2;
        } else {
            aVarH = deserializationContext.h(hVarZ);
            JavaType javaTypeK = deserializationContext.k(cls);
            deserializationContext.e().getClass();
            javaType = TypeFactory.l(javaTypeK, ObjectIdGenerator.class)[0];
            objectIdGeneratorG = deserializationContext.g(hVarZ);
            settableBeanProperty = null;
        }
        JavaType javaType2 = javaType;
        return new AbstractDeserializer(this, new ObjectIdReader(javaType2, hVarZ.f9511a, objectIdGeneratorG, deserializationContext.t(javaType2), settableBeanProperty, aVarH));
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        JavaType javaType = this.f3841a;
        deserializationContext.x(javaType.f3690a, new ValueInstantiator.Base(javaType), "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    @Override // b3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(com.fasterxml.jackson.core.JsonParser r4, com.fasterxml.jackson.databind.DeserializationContext r5, k3.b r6) throws com.fasterxml.jackson.databind.deser.UnresolvedForwardReference {
        /*
            r3 = this;
            com.fasterxml.jackson.databind.deser.impl.ObjectIdReader r0 = r3.f3842b
            if (r0 == 0) goto L57
            com.fasterxml.jackson.core.JsonToken r1 = r4.K()
            if (r1 == 0) goto L57
            boolean r2 = r1.f3600k
            if (r2 == 0) goto L46
            b3.c<java.lang.Object> r3 = r0.f3932e
            java.lang.Object r3 = r3.d(r4, r5)
            com.fasterxml.jackson.annotation.ObjectIdGenerator<?> r6 = r0.f3930c
            com.fasterxml.jackson.annotation.a r0 = r0.f3931d
            com.fasterxml.jackson.databind.deser.impl.a r5 = r5.s(r3, r6, r0)
            com.fasterxml.jackson.annotation.a r6 = r5.f3951d
            com.fasterxml.jackson.annotation.ObjectIdGenerator$IdKey r0 = r5.f3949b
            java.lang.Object r6 = r6.c(r0)
            r5.f3948a = r6
            if (r6 == 0) goto L29
            return r6
        L29:
            com.fasterxml.jackson.databind.deser.UnresolvedForwardReference r6 = new com.fasterxml.jackson.databind.deser.UnresolvedForwardReference
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not resolve Object Id ["
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = "] -- unresolved forward-reference?"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            com.fasterxml.jackson.core.JsonLocation r0 = r4.x0()
            r6.<init>(r4, r3, r0, r5)
            throw r6
        L46:
            com.fasterxml.jackson.core.JsonToken r2 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            if (r1 != r2) goto L4e
            com.fasterxml.jackson.core.JsonToken r1 = r4.q1()
        L4e:
            com.fasterxml.jackson.core.JsonToken r2 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            if (r1 != r2) goto L57
            com.fasterxml.jackson.annotation.ObjectIdGenerator<?> r0 = r0.f3930c
            r0.getClass()
        L57:
            int r0 = r4.P()
            boolean r1 = r3.h
            switch(r0) {
                case 6: goto L85;
                case 7: goto L78;
                case 8: goto L6b;
                case 9: goto L66;
                case 10: goto L61;
                default: goto L60;
            }
        L60:
            goto L8e
        L61:
            if (r1 == 0) goto L8e
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            goto L8f
        L66:
            if (r1 == 0) goto L8e
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L8f
        L6b:
            boolean r3 = r3.f3847k
            if (r3 == 0) goto L8e
            double r0 = r4.J0()
            java.lang.Double r3 = java.lang.Double.valueOf(r0)
            goto L8f
        L78:
            boolean r3 = r3.f3846j
            if (r3 == 0) goto L8e
            int r3 = r4.M0()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L8f
        L85:
            boolean r3 = r3.f3845e
            if (r3 == 0) goto L8e
            java.lang.String r3 = r4.V0()
            goto L8f
        L8e:
            r3 = 0
        L8f:
            if (r3 == 0) goto L92
            return r3
        L92:
            java.lang.Object r3 = r6.d(r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.AbstractDeserializer.f(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, k3.b):java.lang.Object");
    }

    @Override // b3.c
    public final SettableBeanProperty h(String str) {
        Map<String, SettableBeanProperty> map = this.f3843c;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // b3.c
    public final ObjectIdReader l() {
        return this.f3842b;
    }

    @Override // b3.c
    public final Class<?> m() {
        return this.f3841a.f3690a;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4431d;
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return null;
    }

    public AbstractDeserializer(d dVar) {
        JavaType javaType = dVar.f3041a;
        this.f3841a = javaType;
        this.f3842b = null;
        this.f3843c = null;
        Class<?> cls = javaType.f3690a;
        this.f3845e = cls.isAssignableFrom(String.class);
        boolean z = true;
        this.h = cls == Boolean.TYPE || cls.isAssignableFrom(Boolean.class);
        this.f3846j = cls == Integer.TYPE || cls.isAssignableFrom(Integer.class);
        if (cls != Double.TYPE && !cls.isAssignableFrom(Double.class)) {
            z = false;
        }
        this.f3847k = z;
    }

    public AbstractDeserializer(AbstractDeserializer abstractDeserializer, ObjectIdReader objectIdReader) {
        this.f3841a = abstractDeserializer.f3841a;
        this.f3843c = abstractDeserializer.f3843c;
        this.f3845e = abstractDeserializer.f3845e;
        this.h = abstractDeserializer.h;
        this.f3846j = abstractDeserializer.f3846j;
        this.f3847k = abstractDeserializer.f3847k;
        this.f3842b = objectIdReader;
        this.f3844d = null;
    }
}
