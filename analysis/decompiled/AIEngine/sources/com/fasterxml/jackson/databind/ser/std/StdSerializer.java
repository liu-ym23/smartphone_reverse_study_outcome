package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import q3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class StdSerializer<T> extends f<T> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f4416b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Class<T> f4417a;

    public StdSerializer(Class<T> cls) {
        this.f4417a = cls;
    }

    public static f j(h hVar, BeanProperty beanProperty, f fVar) {
        Object obj;
        f stdDelegatingSerializer;
        AnnotatedMember annotatedMemberD;
        Object objP;
        f fVarA;
        ContextAttributes.Impl impl = (ContextAttributes.Impl) hVar.f3047d;
        HashMap map = impl.f3817b;
        Object obj2 = f4416b;
        if (map == null || (obj = map.get(obj2)) == null) {
            obj = impl.f3816a.get(obj2);
        } else if (obj == ContextAttributes.Impl.f3815d) {
            obj = null;
        }
        Map identityHashMap = (Map) obj;
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap();
            ContextAttributes.Impl impl2 = (ContextAttributes.Impl) hVar.f3047d;
            ContextAttributes.Impl impl3 = ContextAttributes.Impl.f3814c;
            Map<?, ?> map2 = impl2.f3816a;
            HashMap map3 = impl2.f3817b;
            if (map3 == null) {
                HashMap map4 = new HashMap();
                map4.put(obj2, identityHashMap);
                impl2 = new ContextAttributes.Impl(map2, map4);
            } else {
                map3.put(obj2, identityHashMap);
            }
            hVar.f3047d = impl2;
        } else if (identityHashMap.get(beanProperty) != null) {
            return fVar;
        }
        identityHashMap.put(beanProperty, Boolean.TRUE);
        try {
            AnnotationIntrospector annotationIntrospectorD = hVar.f3044a.d();
            if (!((annotationIntrospectorD == null || beanProperty == null) ? false : true) || (annotatedMemberD = beanProperty.d()) == null || (objP = annotationIntrospectorD.P(annotatedMemberD)) == null) {
                stdDelegatingSerializer = fVar;
            } else {
                beanProperty.d();
                g gVarC = hVar.c(objP);
                hVar.e();
                JavaType javaTypeB = gVarC.b();
                if (fVar != null || javaTypeB.A()) {
                    fVarA = fVar;
                } else {
                    fVarA = hVar.f3050k.a(javaTypeB);
                    if (fVarA == null && (fVarA = hVar.f3046c.q(javaTypeB)) == null && (fVarA = hVar.k(javaTypeB)) == null) {
                        fVarA = hVar.z(javaTypeB.f3690a);
                    }
                }
                stdDelegatingSerializer = new StdDelegatingSerializer(gVarC, javaTypeB, fVarA);
            }
            return stdDelegatingSerializer != null ? hVar.B(stdDelegatingSerializer, beanProperty) : fVar;
        } finally {
            identityHashMap.remove(beanProperty);
        }
    }

    public static JsonFormat.Value k(h hVar, BeanProperty beanProperty, Class cls) {
        return beanProperty != null ? beanProperty.a(hVar.f3044a, cls) : hVar.f3044a.f(cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m(b3.h r1, java.lang.Exception r2, java.lang.Object r3, int r4) throws java.io.IOException {
        /*
        L0:
            boolean r0 = r2 instanceof java.lang.reflect.InvocationTargetException
            if (r0 == 0) goto Lf
            java.lang.Throwable r0 = r2.getCause()
            if (r0 == 0) goto Lf
            java.lang.Throwable r2 = r2.getCause()
            goto L0
        Lf:
            com.fasterxml.jackson.databind.util.a.B(r2)
            if (r1 == 0) goto L21
            com.fasterxml.jackson.databind.SerializationFeature r0 = com.fasterxml.jackson.databind.SerializationFeature.WRAP_EXCEPTIONS
            com.fasterxml.jackson.databind.SerializationConfig r1 = r1.f3044a
            boolean r1 = r1.q(r0)
            if (r1 == 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            boolean r0 = r2 instanceof java.io.IOException
            if (r0 == 0) goto L2f
            if (r1 == 0) goto L2c
            boolean r1 = r2 instanceof com.fasterxml.jackson.databind.JsonMappingException
            if (r1 != 0) goto L34
        L2c:
            java.io.IOException r2 = (java.io.IOException) r2
            throw r2
        L2f:
            if (r1 != 0) goto L34
            com.fasterxml.jackson.databind.util.a.D(r2)
        L34:
            com.fasterxml.jackson.databind.JsonMappingException r1 = com.fasterxml.jackson.databind.JsonMappingException.h(r2, r3, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StdSerializer.m(b3.h, java.lang.Exception, java.lang.Object, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(b3.h r1, java.lang.Exception r2, java.lang.Object r3, java.lang.String r4) throws java.io.IOException {
        /*
        L0:
            boolean r0 = r2 instanceof java.lang.reflect.InvocationTargetException
            if (r0 == 0) goto Lf
            java.lang.Throwable r0 = r2.getCause()
            if (r0 == 0) goto Lf
            java.lang.Throwable r2 = r2.getCause()
            goto L0
        Lf:
            com.fasterxml.jackson.databind.util.a.B(r2)
            if (r1 == 0) goto L21
            com.fasterxml.jackson.databind.SerializationFeature r0 = com.fasterxml.jackson.databind.SerializationFeature.WRAP_EXCEPTIONS
            com.fasterxml.jackson.databind.SerializationConfig r1 = r1.f3044a
            boolean r1 = r1.q(r0)
            if (r1 == 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            boolean r0 = r2 instanceof java.io.IOException
            if (r0 == 0) goto L2f
            if (r1 == 0) goto L2c
            boolean r1 = r2 instanceof com.fasterxml.jackson.databind.JsonMappingException
            if (r1 != 0) goto L34
        L2c:
            java.io.IOException r2 = (java.io.IOException) r2
            throw r2
        L2f:
            if (r1 != 0) goto L34
            com.fasterxml.jackson.databind.util.a.D(r2)
        L34:
            int r1 = com.fasterxml.jackson.databind.JsonMappingException.f3695d
            com.fasterxml.jackson.databind.JsonMappingException$Reference r1 = new com.fasterxml.jackson.databind.JsonMappingException$Reference
            r1.<init>(r3, r4)
            com.fasterxml.jackson.databind.JsonMappingException r1 = com.fasterxml.jackson.databind.JsonMappingException.g(r2, r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StdSerializer.n(b3.h, java.lang.Exception, java.lang.Object, java.lang.String):void");
    }

    @Override // b3.f
    public final Class<T> c() {
        return this.f4417a;
    }

    public final void l(h hVar, Object obj) {
        hVar.f3044a.getClass();
        hVar.i(this.f4417a, "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
        throw null;
    }

    public StdSerializer(JavaType javaType) {
        this.f4417a = (Class<T>) javaType.f3690a;
    }

    public StdSerializer(Class cls, int i10) {
        this.f4417a = cls;
    }

    public StdSerializer(StdSerializer<?> stdSerializer) {
        this.f4417a = (Class<T>) stdSerializer.f4417a;
    }
}
