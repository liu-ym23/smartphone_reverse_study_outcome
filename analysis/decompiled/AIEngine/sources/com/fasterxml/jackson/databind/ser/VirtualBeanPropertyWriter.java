package com.fasterxml.jackson.databind.ser;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.ser.impl.a;
import java.io.Serializable;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class VirtualBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public final void k(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Object objN = n(hVar);
        if (objN == null) {
            f<Object> fVar = this.f4298o;
            if (fVar != null) {
                fVar.f(null, jsonGenerator, hVar);
                return;
            } else {
                jsonGenerator.J0();
                return;
            }
        }
        f<Object> fVarF = this.f4297n;
        if (fVarF == null) {
            Class<?> cls = objN.getClass();
            a aVar = this.f4300q;
            f<Object> fVarC = aVar.c(cls);
            fVarF = fVarC == null ? f(aVar, cls, hVar) : fVarC;
        }
        Object obj2 = this.f4301s;
        if (obj2 != null) {
            if (JsonInclude.Include.f3466c == obj2) {
                if (fVarF.d(hVar, objN)) {
                    m(jsonGenerator, hVar);
                    return;
                }
            } else if (obj2.equals(objN)) {
                m(jsonGenerator, hVar);
                return;
            }
        }
        if (objN == obj && g(jsonGenerator, hVar, fVarF)) {
            return;
        }
        e eVar = this.f4299p;
        if (eVar == null) {
            fVarF.f(objN, jsonGenerator, hVar);
        } else {
            fVarF.g(objN, jsonGenerator, hVar, eVar);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public final void l(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Object objN = n(hVar);
        SerializedString serializedString = this.f4290c;
        if (objN == null) {
            if (this.f4298o != null) {
                jsonGenerator.I0(serializedString);
                this.f4298o.f(null, jsonGenerator, hVar);
                return;
            }
            return;
        }
        f<Object> fVarF = this.f4297n;
        if (fVarF == null) {
            Class<?> cls = objN.getClass();
            a aVar = this.f4300q;
            f<Object> fVarC = aVar.c(cls);
            fVarF = fVarC == null ? f(aVar, cls, hVar) : fVarC;
        }
        Object obj2 = this.f4301s;
        if (obj2 != null) {
            if (JsonInclude.Include.f3466c == obj2) {
                if (fVarF.d(hVar, objN)) {
                    return;
                }
            } else if (obj2.equals(objN)) {
                return;
            }
        }
        if (objN == obj && g(jsonGenerator, hVar, fVarF)) {
            return;
        }
        jsonGenerator.I0(serializedString);
        e eVar = this.f4299p;
        if (eVar == null) {
            fVarF.f(objN, jsonGenerator, hVar);
        } else {
            fVarF.g(objN, jsonGenerator, hVar, eVar);
        }
    }

    public abstract Object n(h hVar);

    public abstract VirtualBeanPropertyWriter o();
}
