package com.fasterxml.jackson.databind.jsontype.impl;

import a3.h;
import b3.c;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.Serializable;
import k3.b;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AsArrayTypeDeserializer extends TypeDeserializerBase implements Serializable {
    @Override // k3.b
    public Object b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return o(jsonParser, deserializationContext);
    }

    @Override // k3.b
    public final Object c(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return o(jsonParser, deserializationContext);
    }

    @Override // k3.b
    public Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return o(jsonParser, deserializationContext);
    }

    @Override // k3.b
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return o(jsonParser, deserializationContext);
    }

    @Override // k3.b
    public b f(BeanProperty beanProperty) {
        return beanProperty == this.f4250c ? this : new AsArrayTypeDeserializer(this, beanProperty);
    }

    @Override // k3.b
    public JsonTypeInfo.As j() {
        return JsonTypeInfo.As.f3483c;
    }

    public final Object o(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException, JsonGenerationException {
        String strV0;
        Object objA1;
        if (jsonParser.o() && (objA1 = jsonParser.a1()) != null) {
            return l(jsonParser, deserializationContext, objA1);
        }
        boolean zL1 = jsonParser.l1();
        boolean zL12 = jsonParser.l1();
        JavaType javaType = this.f4249b;
        if (zL12) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            if (jsonTokenQ1 != jsonToken) {
                deserializationContext.U(jsonToken, "need JSON String that contains type id (for subtype of %s)", javaType.f3690a.getName());
                throw null;
            }
            strV0 = jsonParser.V0();
            jsonParser.q1();
        } else {
            if (this.f4251d == null) {
                deserializationContext.U(JsonToken.START_ARRAY, "need JSON Array to contain As.WRAPPER_ARRAY type information for class ".concat(javaType.f3690a.getName()), new Object[0]);
                throw null;
            }
            strV0 = this.f4248a.d();
        }
        c<Object> cVarN = n(deserializationContext, strV0);
        if (this.h && !(this instanceof AsExternalTypeDeserializer) && jsonParser.i1(JsonToken.START_OBJECT)) {
            p pVar = new p();
            pVar.c1();
            pVar.H0(this.f4252e);
            pVar.f1(strV0);
            jsonParser.w();
            jsonParser = h.x1(pVar.s1(jsonParser), jsonParser);
            jsonParser.q1();
        }
        if (zL1 && jsonParser.K() == JsonToken.END_ARRAY) {
            return cVarN.a(deserializationContext);
        }
        Object objD = cVarN.d(jsonParser, deserializationContext);
        if (zL1) {
            JsonToken jsonTokenQ12 = jsonParser.q1();
            JsonToken jsonToken2 = JsonToken.END_ARRAY;
            if (jsonTokenQ12 != jsonToken2) {
                deserializationContext.U(jsonToken2, "expected closing END_ARRAY after type information and deserialized value", new Object[0]);
                throw null;
            }
        }
        return objD;
    }
}
