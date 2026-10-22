package com.fasterxml.jackson.databind.deser.std;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ThrowableDeserializer extends BeanDeserializer {
    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializer
    public final Object I0(JsonParser jsonParser, DeserializationContext deserializationContext) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        if (this.f3858l != null) {
            return k0(jsonParser, deserializationContext);
        }
        c<Object> cVar = this.f3856j;
        ValueInstantiator valueInstantiator = this.h;
        if (cVar != null) {
            return valueInstantiator.w(deserializationContext, cVar.d(jsonParser, deserializationContext));
        }
        JavaType javaType = this.f3854d;
        boolean zV = javaType.v();
        Class<?> cls = javaType.f3690a;
        if (zV) {
            deserializationContext.x(cls, valueInstantiator, "abstract type (need to add/enable type information?)", new Object[0]);
            throw null;
        }
        boolean zH = valueInstantiator.h();
        boolean zJ = valueInstantiator.j();
        if (!zH && !zJ) {
            deserializationContext.x(cls, valueInstantiator, "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
            throw null;
        }
        Object objT = null;
        Object[] objArr = null;
        int i10 = 0;
        while (!jsonParser.i1(JsonToken.END_OBJECT)) {
            String strC = jsonParser.C();
            BeanPropertyMap beanPropertyMap = this.f3861o;
            SettableBeanProperty settableBeanPropertyC = beanPropertyMap.c(strC);
            jsonParser.q1();
            if (settableBeanPropertyC != null) {
                if (objT != null) {
                    settableBeanPropertyC.i(jsonParser, deserializationContext, objT);
                } else {
                    if (objArr == null) {
                        int i11 = beanPropertyMap.f3904c;
                        objArr = new Object[i11 + i11];
                    }
                    int i12 = i10 + 1;
                    objArr[i10] = settableBeanPropertyC;
                    i10 += 2;
                    objArr[i12] = settableBeanPropertyC.h(jsonParser, deserializationContext);
                }
            } else if ("message".equals(strC) && zH) {
                objT = valueInstantiator.t(deserializationContext, jsonParser.f1());
                if (objArr != null) {
                    for (int i13 = 0; i13 < i10; i13 += 2) {
                        ((SettableBeanProperty) objArr[i13]).z(objT, objArr[i13 + 1]);
                    }
                    objArr = null;
                }
            } else {
                Set<String> set = this.r;
                if (set == null || !set.contains(strC)) {
                    SettableAnyProperty settableAnyProperty = this.f3863q;
                    if (settableAnyProperty != null) {
                        settableAnyProperty.b(jsonParser, deserializationContext, objT, strC);
                    } else {
                        i0(jsonParser, deserializationContext, objT, strC);
                    }
                } else {
                    jsonParser.v1();
                }
            }
            jsonParser.q1();
        }
        if (objT != null) {
            return objT;
        }
        Object objT2 = zH ? valueInstantiator.t(deserializationContext, null) : valueInstantiator.v(deserializationContext);
        if (objArr != null) {
            for (int i14 = 0; i14 < i10; i14 += 2) {
                ((SettableBeanProperty) objArr[i14]).z(objT2, objArr[i14 + 1]);
            }
        }
        return objT2;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializer, com.fasterxml.jackson.databind.deser.BeanDeserializerBase, b3.c
    public final c<Object> q(NameTransformer nameTransformer) {
        return getClass() != ThrowableDeserializer.class ? this : new ThrowableDeserializer(this, nameTransformer);
    }
}
