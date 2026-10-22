package com.fasterxml.jackson.databind.ser.std;

import androidx.appcompat.widget.l;
import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.a;
import n3.c;
import n3.e;
import q3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StdDelegatingSerializer extends StdSerializer<Object> implements c, e {

    /* renamed from: c, reason: collision with root package name */
    public final g<Object, ?> f4409c;

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f4410d;

    /* renamed from: e, reason: collision with root package name */
    public final f<Object> f4411e;

    public StdDelegatingSerializer(g<Object, ?> gVar, JavaType javaType, f<?> fVar) {
        super(javaType);
        this.f4409c = gVar;
        this.f4410d = javaType;
        this.f4411e = fVar;
    }

    public static f o(h hVar, Object obj) {
        Class cls = obj.getClass();
        l lVar = hVar.f3046c;
        f fVarB = hVar.f3050k.b(cls);
        if (fVarB != null || (fVarB = lVar.r(cls)) != null) {
            return fVarB;
        }
        f fVarQ = lVar.q(hVar.f3044a.c(cls));
        return (fVarQ == null && (fVarQ = hVar.l(cls)) == null) ? hVar.z(cls) : fVarQ;
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        f fVarB;
        JavaType javaTypeB;
        g<Object, ?> gVar = this.f4409c;
        f fVar = this.f4411e;
        JavaType javaType = this.f4410d;
        if (fVar == null) {
            if (javaType == null) {
                hVar.e();
                javaTypeB = gVar.b();
            } else {
                javaTypeB = javaType;
            }
            if (javaTypeB.A()) {
                fVarB = fVar;
            } else {
                fVarB = hVar.f3050k.a(javaTypeB);
                if (fVarB == null && (fVarB = hVar.f3046c.q(javaTypeB)) == null && (fVarB = hVar.k(javaTypeB)) == null) {
                    fVarB = hVar.z(javaTypeB.f3690a);
                }
            }
        } else {
            fVarB = fVar;
            javaTypeB = javaType;
        }
        if (fVarB instanceof c) {
            fVarB = hVar.B(fVarB, beanProperty);
        }
        if (fVarB == fVar && javaTypeB == javaType) {
            return this;
        }
        a.E(StdDelegatingSerializer.class, this, "withDelegate");
        return new StdDelegatingSerializer(gVar, javaTypeB, fVarB);
    }

    @Override // n3.e
    public final void b(h hVar) {
        Object obj = this.f4411e;
        if (obj == null || !(obj instanceof e)) {
            return;
        }
        ((e) obj).b(hVar);
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        Object objA = this.f4409c.a(obj);
        if (objA == null) {
            return true;
        }
        f<Object> fVar = this.f4411e;
        if (fVar == null) {
            return false;
        }
        return fVar.d(hVar, objA);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Object objA = this.f4409c.a(obj);
        if (objA == null) {
            hVar.p(jsonGenerator);
            return;
        }
        f<Object> fVarO = this.f4411e;
        if (fVarO == null) {
            fVarO = o(hVar, objA);
        }
        fVarO.f(objA, jsonGenerator, hVar);
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, k3.e eVar) {
        Object objA = this.f4409c.a(obj);
        f<Object> fVarO = this.f4411e;
        if (fVarO == null) {
            fVarO = o(hVar, obj);
        }
        fVarO.g(objA, jsonGenerator, hVar, eVar);
    }
}
