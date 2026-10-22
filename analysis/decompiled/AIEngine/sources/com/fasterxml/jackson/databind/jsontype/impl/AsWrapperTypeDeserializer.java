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
public class AsWrapperTypeDeserializer extends TypeDeserializerBase implements Serializable {
    @Override // k3.b
    public final Object b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return o(jsonParser, deserializationContext);
    }

    @Override // k3.b
    public final Object c(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return o(jsonParser, deserializationContext);
    }

    @Override // k3.b
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return o(jsonParser, deserializationContext);
    }

    @Override // k3.b
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return o(jsonParser, deserializationContext);
    }

    @Override // k3.b
    public final b f(BeanProperty beanProperty) {
        return beanProperty == this.f4250c ? this : new AsWrapperTypeDeserializer(this, beanProperty);
    }

    @Override // k3.b
    public final JsonTypeInfo.As j() {
        return JsonTypeInfo.As.f3482b;
    }

    public final Object o(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException, JsonGenerationException {
        Object objA1;
        if (jsonParser.o() && (objA1 = jsonParser.a1()) != null) {
            return l(jsonParser, deserializationContext, objA1);
        }
        JsonToken jsonTokenK = jsonParser.K();
        JsonToken jsonToken = JsonToken.START_OBJECT;
        JavaType javaType = this.f4249b;
        if (jsonTokenK == jsonToken) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            JsonToken jsonToken2 = JsonToken.FIELD_NAME;
            if (jsonTokenQ1 != jsonToken2) {
                deserializationContext.U(jsonToken2, "need JSON String that contains type id (for subtype of " + javaType.f3690a.getName() + ")", new Object[0]);
                throw null;
            }
        } else if (jsonTokenK != JsonToken.FIELD_NAME) {
            deserializationContext.U(jsonToken, "need JSON Object to contain As.WRAPPER_OBJECT type information for class ".concat(javaType.f3690a.getName()), new Object[0]);
            throw null;
        }
        String strV0 = jsonParser.V0();
        c<Object> cVarN = n(deserializationContext, strV0);
        jsonParser.q1();
        if (this.h && jsonParser.i1(jsonToken)) {
            p pVar = new p();
            pVar.c1();
            pVar.H0(this.f4252e);
            pVar.f1(strV0);
            jsonParser.w();
            jsonParser = h.x1(pVar.s1(jsonParser), jsonParser);
            jsonParser.q1();
        }
        Object objD = cVarN.d(jsonParser, deserializationContext);
        JsonToken jsonTokenQ12 = jsonParser.q1();
        JsonToken jsonToken3 = JsonToken.END_OBJECT;
        if (jsonTokenQ12 == jsonToken3) {
            return objD;
        }
        deserializationContext.U(jsonToken3, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
        throw null;
    }
}
