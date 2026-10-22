package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.stepos.deepbinder.annotation.BaseConstantsKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
    public StackTraceElementDeserializer() {
        super(StackTraceElement.class);
    }

    @Override // b3.c
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public final StackTraceElement d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        JsonToken jsonTokenK = jsonParser.K();
        JsonToken jsonToken = JsonToken.START_OBJECT;
        Class<?> cls = this.f4054a;
        if (jsonTokenK != jsonToken) {
            if (jsonTokenK != JsonToken.START_ARRAY || !deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            jsonParser.q1();
            StackTraceElement stackTraceElementD = d(jsonParser, deserializationContext);
            if (jsonParser.q1() == JsonToken.END_ARRAY) {
                return stackTraceElementD;
            }
            h0(deserializationContext);
            throw null;
        }
        String strV0 = "";
        String strV02 = "";
        int iM0 = -1;
        String strV03 = strV02;
        while (true) {
            JsonToken jsonTokenR1 = jsonParser.r1();
            if (jsonTokenR1 == JsonToken.END_OBJECT) {
                return new StackTraceElement(strV0, strV03, strV02, iM0);
            }
            String strC = jsonParser.C();
            if ("className".equals(strC)) {
                strV0 = jsonParser.V0();
            } else if ("classLoaderName".equals(strC)) {
                jsonParser.V0();
            } else if ("fileName".equals(strC)) {
                strV02 = jsonParser.V0();
            } else if ("lineNumber".equals(strC)) {
                iM0 = jsonTokenR1.f3599j ? jsonParser.M0() : Q(jsonParser, deserializationContext);
            } else if (BaseConstantsKt.KEY_METHOD_NAME.equals(strC)) {
                strV03 = jsonParser.V0();
            } else if (!"nativeMethod".equals(strC)) {
                if ("moduleName".equals(strC)) {
                    jsonParser.V0();
                } else if ("moduleVersion".equals(strC)) {
                    jsonParser.V0();
                } else if (!"declaringClass".equals(strC) && !"format".equals(strC)) {
                    i0(jsonParser, deserializationContext, cls, strC);
                }
            }
            jsonParser.v1();
        }
    }
}
