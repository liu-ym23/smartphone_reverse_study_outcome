package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import e3.i;
import i3.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MethodProperty extends SettableBeanProperty {

    /* renamed from: p, reason: collision with root package name */
    public final AnnotatedMethod f3921p;

    /* renamed from: q, reason: collision with root package name */
    public final transient Method f3922q;
    public final boolean r;

    public MethodProperty(e eVar, JavaType javaType, b bVar, q3.a aVar, AnnotatedMethod annotatedMethod) {
        super(eVar, javaType, bVar, aVar);
        this.f3921p = annotatedMethod;
        this.f3922q = annotatedMethod.f4124d;
        this.r = NullsConstantProvider.b(this.f3894j);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object A(Object obj, Object obj2) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = this.f3922q.invoke(obj, obj2);
            return objInvoke == null ? obj : objInvoke;
        } catch (Exception e10) {
            this.f(null, e10, obj2);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty B(PropertyName propertyName) {
        return new MethodProperty(this, propertyName);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty C(i iVar) {
        return new MethodProperty(this, this.f3893e, iVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty D(c<?> cVar) {
        c<?> cVar2 = this.f3893e;
        if (cVar2 == cVar) {
            return this;
        }
        i iVar = this.f3894j;
        if (cVar2 == iVar) {
            iVar = cVar;
        }
        return new MethodProperty(this, cVar, iVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public final AnnotatedMember d() {
        return this.f3921p;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        Object objF;
        boolean zI1 = jsonParser.i1(JsonToken.VALUE_NULL);
        i iVar = this.f3894j;
        boolean z = this.r;
        if (!zI1) {
            c<Object> cVar = this.f3893e;
            b bVar = this.h;
            if (bVar == null) {
                Object objD = cVar.d(jsonParser, deserializationContext);
                if (objD != null) {
                    objF = objD;
                } else if (z) {
                    return;
                } else {
                    objF = iVar.a(deserializationContext);
                }
            } else {
                objF = cVar.f(jsonParser, deserializationContext, bVar);
            }
        } else if (z) {
            return;
        } else {
            objF = iVar.a(deserializationContext);
        }
        try {
            this.f3922q.invoke(obj, objF);
        } catch (Exception e10) {
            f(jsonParser, e10, objF);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b A[RETURN] */
    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(com.fasterxml.jackson.core.JsonParser r5, com.fasterxml.jackson.databind.DeserializationContext r6, java.lang.Object r7) throws java.lang.IllegalAccessException, com.fasterxml.jackson.databind.JsonMappingException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            boolean r0 = r5.i1(r0)
            e3.i r1 = r4.f3894j
            boolean r2 = r4.r
            if (r0 == 0) goto L14
            if (r2 == 0) goto Lf
            goto L3a
        Lf:
            java.lang.Object r6 = r1.a(r6)
            goto L2e
        L14:
            b3.c<java.lang.Object> r0 = r4.f3893e
            k3.b r3 = r4.h
            if (r3 != 0) goto L2a
            java.lang.Object r0 = r0.d(r5, r6)
            if (r0 != 0) goto L28
            if (r2 == 0) goto L23
            goto L3a
        L23:
            java.lang.Object r6 = r1.a(r6)
            goto L2e
        L28:
            r6 = r0
            goto L2e
        L2a:
            java.lang.Object r6 = r0.f(r5, r6, r3)
        L2e:
            java.lang.reflect.Method r0 = r4.f3922q     // Catch: java.lang.Exception -> L3c
            java.lang.Object[] r1 = new java.lang.Object[]{r6}     // Catch: java.lang.Exception -> L3c
            java.lang.Object r4 = r0.invoke(r7, r1)     // Catch: java.lang.Exception -> L3c
            if (r4 != 0) goto L3b
        L3a:
            return r7
        L3b:
            return r4
        L3c:
            r7 = move-exception
            r4.f(r5, r7, r6)
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.MethodProperty.j(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.lang.Object):java.lang.Object");
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void l(DeserializationConfig deserializationConfig) {
        this.f3921p.g(deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public Object readResolve() {
        return new MethodProperty(this, this.f3921p.f4124d);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void z(Object obj, Object obj2) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f3922q.invoke(obj, obj2);
        } catch (Exception e10) {
            f(null, e10, obj2);
            throw null;
        }
    }

    public MethodProperty(MethodProperty methodProperty, c<?> cVar, i iVar) {
        super(methodProperty, cVar, iVar);
        this.f3921p = methodProperty.f3921p;
        this.f3922q = methodProperty.f3922q;
        this.r = NullsConstantProvider.b(iVar);
    }

    public MethodProperty(MethodProperty methodProperty, PropertyName propertyName) {
        super(methodProperty, propertyName);
        this.f3921p = methodProperty.f3921p;
        this.f3922q = methodProperty.f3922q;
        this.r = methodProperty.r;
    }

    public MethodProperty(MethodProperty methodProperty, Method method) {
        super(methodProperty);
        this.f3921p = methodProperty.f3921p;
        this.f3922q = method;
        this.r = methodProperty.r;
    }
}
