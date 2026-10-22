package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.reflect.Method;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class UnwrappingBeanPropertyWriter extends BeanPropertyWriter implements Serializable {

    /* renamed from: v, reason: collision with root package name */
    public final NameTransformer f4328v;

    public UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter unwrappingBeanPropertyWriter, NameTransformer.Chained chained, SerializedString serializedString) {
        super(unwrappingBeanPropertyWriter, serializedString);
        this.f4328v = chained;
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public final f<Object> f(a aVar, Class<?> cls, h hVar) {
        JavaType javaType = this.f4293j;
        f<Object> fVarX = javaType != null ? hVar.x(hVar.o(javaType, cls), this) : hVar.y(cls, this);
        boolean zE = fVarX.e();
        NameTransformer chained = this.f4328v;
        if (zE && (fVarX instanceof UnwrappingBeanSerializer)) {
            NameTransformer nameTransformer = ((UnwrappingBeanSerializer) fVarX).f4329o;
            NameTransformer.NopTransformer nopTransformer = NameTransformer.f4511a;
            chained = new NameTransformer.Chained(chained, nameTransformer);
        }
        f<Object> fVarH = fVarX.h(chained);
        this.f4300q = this.f4300q.b(cls, fVarH);
        return fVarH;
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public final void i(f<Object> fVar) {
        if (fVar != null) {
            boolean zE = fVar.e();
            NameTransformer chained = this.f4328v;
            if (zE && (fVar instanceof UnwrappingBeanSerializer)) {
                NameTransformer nameTransformer = ((UnwrappingBeanSerializer) fVar).f4329o;
                NameTransformer.NopTransformer nopTransformer = NameTransformer.f4511a;
                chained = new NameTransformer.Chained(chained, nameTransformer);
            }
            fVar = fVar.h(chained);
        }
        super.i(fVar);
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public final BeanPropertyWriter j(NameTransformer nameTransformer) {
        return new UnwrappingBeanPropertyWriter(this, new NameTransformer.Chained(nameTransformer, this.f4328v), new SerializedString(nameTransformer.a(this.f4290c.f3610a)));
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public final void l(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Method method = this.f4295l;
        Object objInvoke = method == null ? this.f4296m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            return;
        }
        f<Object> fVarF = this.f4297n;
        if (fVarF == null) {
            Class<?> cls = objInvoke.getClass();
            a aVar = this.f4300q;
            f<Object> fVarC = aVar.c(cls);
            fVarF = fVarC == null ? f(aVar, cls, hVar) : fVarC;
        }
        Object obj2 = this.f4301s;
        if (obj2 != null) {
            if (JsonInclude.Include.f3466c == obj2) {
                if (fVarF.d(hVar, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && g(jsonGenerator, hVar, fVarF)) {
            return;
        }
        if (!fVarF.e()) {
            jsonGenerator.I0(this.f4290c);
        }
        e eVar = this.f4299p;
        if (eVar == null) {
            fVarF.f(objInvoke, jsonGenerator, hVar);
        } else {
            fVarF.g(objInvoke, jsonGenerator, hVar, eVar);
        }
    }

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, NameTransformer nameTransformer) {
        super(beanPropertyWriter, beanPropertyWriter.f4290c);
        this.f4328v = nameTransformer;
    }
}
