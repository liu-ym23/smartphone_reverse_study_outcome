package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.databind.ser.impl.a;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.util.concurrent.atomic.AtomicReference;
import k3.e;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ReferenceTypeSerializer<T> extends StdSerializer<T> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final JavaType f4399c;

    /* renamed from: d, reason: collision with root package name */
    public final BeanProperty f4400d;

    /* renamed from: e, reason: collision with root package name */
    public final e f4401e;
    public final f<Object> h;

    /* renamed from: j, reason: collision with root package name */
    public final NameTransformer f4402j;

    /* renamed from: k, reason: collision with root package name */
    public transient a f4403k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f4404l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f4405m;

    public ReferenceTypeSerializer(ReferenceType referenceType, e eVar, f fVar) {
        super(referenceType);
        this.f4399c = referenceType.f4445m;
        this.f4400d = null;
        this.f4401e = eVar;
        this.h = fVar;
        this.f4402j = null;
        this.f4404l = null;
        this.f4405m = false;
        this.f4403k = a.b.f4334a;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f3  */
    @Override // n3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f<?> a(b3.h r15, com.fasterxml.jackson.databind.BeanProperty r16) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer.a(b3.h, com.fasterxml.jackson.databind.BeanProperty):b3.f");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b3.f
    public final boolean d(h hVar, T t8) {
        AtomicReference atomicReference = (AtomicReference) t8;
        if (atomicReference.get() == null) {
            return true;
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            return this.f4405m;
        }
        Object obj2 = this.f4404l;
        if (obj2 == null) {
            return false;
        }
        f<Object> fVarO = this.h;
        if (fVarO == null) {
            try {
                fVarO = o(hVar, obj.getClass());
            } catch (JsonMappingException e10) {
                throw new RuntimeJsonMappingException(e10);
            }
        }
        return obj2 == JsonInclude.Include.f3466c ? fVarO.d(hVar, obj) : obj2.equals(obj);
    }

    @Override // b3.f
    public final boolean e() {
        return this.f4402j != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b3.f
    public final void f(T t8, JsonGenerator jsonGenerator, h hVar) {
        Object obj = ((AtomicReference) t8).get();
        if (obj == null) {
            if (this.f4402j == null) {
                hVar.p(jsonGenerator);
                return;
            }
            return;
        }
        f<Object> fVarO = this.h;
        if (fVarO == null) {
            fVarO = o(hVar, obj.getClass());
        }
        e eVar = this.f4401e;
        if (eVar != null) {
            fVarO.g(obj, jsonGenerator, hVar, eVar);
        } else {
            fVarO.f(obj, jsonGenerator, hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b3.f
    public final void g(T t8, JsonGenerator jsonGenerator, h hVar, e eVar) {
        Object obj = ((AtomicReference) t8).get();
        if (obj == null) {
            if (this.f4402j == null) {
                hVar.p(jsonGenerator);
            }
        } else {
            f<Object> fVarO = this.h;
            if (fVarO == null) {
                fVarO = o(hVar, obj.getClass());
            }
            fVarO.g(obj, jsonGenerator, hVar, eVar);
        }
    }

    @Override // b3.f
    public final f<T> h(NameTransformer nameTransformer) {
        f<Object> fVar;
        NameTransformer chained;
        f<Object> fVar2 = this.h;
        if (fVar2 != null) {
            f<Object> fVarH = fVar2.h(nameTransformer);
            if (fVarH != fVar2) {
                fVar = fVarH;
            }
            return this;
        }
        fVar = fVar2;
        NameTransformer nameTransformer2 = this.f4402j;
        if (nameTransformer2 == null) {
            chained = nameTransformer;
        } else {
            NameTransformer.NopTransformer nopTransformer = NameTransformer.f4511a;
            chained = new NameTransformer.Chained(nameTransformer, nameTransformer2);
        }
        if (fVar2 != fVar || nameTransformer2 != chained) {
            AtomicReferenceSerializer atomicReferenceSerializer = (AtomicReferenceSerializer) this;
            return new AtomicReferenceSerializer(atomicReferenceSerializer, this.f4400d, this.f4401e, fVar, chained, atomicReferenceSerializer.f4404l, atomicReferenceSerializer.f4405m);
        }
        return this;
    }

    public final f<Object> o(h hVar, Class<?> cls) {
        f<Object> fVarC = this.f4403k.c(cls);
        if (fVarC != null) {
            return fVarC;
        }
        JavaType javaType = this.f4399c;
        boolean zS = javaType.s();
        BeanProperty beanProperty = this.f4400d;
        f<Object> fVarU = zS ? hVar.u(hVar.o(javaType, cls), beanProperty) : hVar.v(cls, beanProperty);
        NameTransformer nameTransformer = this.f4402j;
        if (nameTransformer != null) {
            fVarU = fVarU.h(nameTransformer);
        }
        this.f4403k = this.f4403k.b(cls, fVarU);
        return fVarU;
    }

    public ReferenceTypeSerializer(AtomicReferenceSerializer atomicReferenceSerializer, BeanProperty beanProperty, e eVar, f fVar, NameTransformer nameTransformer, Object obj, boolean z) {
        super(atomicReferenceSerializer);
        this.f4399c = atomicReferenceSerializer.f4399c;
        this.f4403k = a.b.f4334a;
        this.f4400d = beanProperty;
        this.f4401e = eVar;
        this.h = fVar;
        this.f4402j = nameTransformer;
        this.f4404l = obj;
        this.f4405m = z;
    }
}
