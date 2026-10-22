package com.fasterxml.jackson.databind.jsontype.impl;

import a0.a;
import a3.h;
import androidx.appcompat.widget.l;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import e3.e;
import k3.b;
import k3.c;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AsPropertyTypeDeserializer extends AsArrayTypeDeserializer {

    /* renamed from: l, reason: collision with root package name */
    public final JsonTypeInfo.As f4245l;

    /* renamed from: m, reason: collision with root package name */
    public final String f4246m;

    public AsPropertyTypeDeserializer(JavaType javaType, c cVar, String str, boolean z, JavaType javaType2, JsonTypeInfo.As as) {
        super(javaType, cVar, str, z, javaType2);
        this.f4246m = a.k("missing type id property '", this.f4252e, "'");
        this.f4245l = as;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, k3.b
    public final Object b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return jsonParser.i1(JsonToken.START_ARRAY) ? o(jsonParser, deserializationContext) : d(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, k3.b
    public Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonGenerationException {
        Object objA1;
        if (jsonParser.o() && (objA1 = jsonParser.a1()) != null) {
            return l(jsonParser, deserializationContext, objA1);
        }
        JsonToken jsonTokenK = jsonParser.K();
        JsonToken jsonToken = JsonToken.START_OBJECT;
        String str = this.f4246m;
        p pVar = null;
        if (jsonTokenK == jsonToken) {
            jsonTokenK = jsonParser.q1();
        } else if (jsonTokenK != JsonToken.FIELD_NAME) {
            return q(jsonParser, deserializationContext, null, str);
        }
        boolean zK = deserializationContext.f3663c.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (jsonTokenK == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.q1();
            String str2 = this.f4252e;
            if (strC.equals(str2) || (zK && strC.equalsIgnoreCase(str2))) {
                return p(jsonParser, deserializationContext, pVar, jsonParser.V0());
            }
            if (pVar == null) {
                pVar = new p(jsonParser, deserializationContext);
            }
            pVar.H0(strC);
            pVar.u1(jsonParser);
            jsonTokenK = jsonParser.q1();
        }
        return q(jsonParser, deserializationContext, pVar, str);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, k3.b
    public b f(BeanProperty beanProperty) {
        return beanProperty == this.f4250c ? this : new AsPropertyTypeDeserializer(this, beanProperty);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, k3.b
    public final JsonTypeInfo.As j() {
        return this.f4245l;
    }

    public final Object p(JsonParser jsonParser, DeserializationContext deserializationContext, p pVar, String str) throws JsonGenerationException, InvalidTypeIdException {
        b3.c<Object> cVarN = n(deserializationContext, str);
        if (this.h) {
            if (pVar == null) {
                pVar = new p(jsonParser, deserializationContext);
            }
            pVar.H0(jsonParser.C());
            pVar.f1(str);
        }
        if (pVar != null) {
            jsonParser.w();
            jsonParser = h.x1(pVar.s1(jsonParser), jsonParser);
        }
        if (jsonParser.K() != JsonToken.END_OBJECT) {
            jsonParser.q1();
        }
        return cVarN.d(jsonParser, deserializationContext);
    }

    public final Object q(JsonParser jsonParser, DeserializationContext deserializationContext, p pVar, String str) throws InvalidTypeIdException {
        boolean zK = k();
        JavaType javaType = this.f4249b;
        if (!zK) {
            Object objA = b.a(jsonParser, javaType);
            if (objA != null) {
                return objA;
            }
            if (jsonParser.l1()) {
                return o(jsonParser, deserializationContext);
            }
            if (jsonParser.i1(JsonToken.VALUE_STRING) && deserializationContext.J(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.V0().trim().isEmpty()) {
                return null;
            }
        }
        b3.c<Object> cVarM = m(deserializationContext);
        if (cVarM != null) {
            if (pVar != null) {
                pVar.G0();
                jsonParser = pVar.s1(jsonParser);
                jsonParser.q1();
            }
            return cVarM.d(jsonParser, deserializationContext);
        }
        deserializationContext.f3663c.getClass();
        for (l lVar = null; lVar != null; lVar = (l) lVar.h) {
            ((e) lVar.f887g).getClass();
        }
        throw new InvalidTypeIdException(deserializationContext.h, b3.b.a(String.format("Could not resolve subtype of %s", javaType), str), 0);
    }

    public AsPropertyTypeDeserializer(AsPropertyTypeDeserializer asPropertyTypeDeserializer, BeanProperty beanProperty) {
        String strC;
        super(asPropertyTypeDeserializer, beanProperty);
        BeanProperty beanProperty2 = this.f4250c;
        if (beanProperty2 == null) {
            strC = a.k("missing type id property '", this.f4252e, "'");
        } else {
            strC = h0.e.c("missing type id property '", this.f4252e, "' (for POJO property '", beanProperty2.getName(), "')");
        }
        this.f4246m = strC;
        this.f4245l = asPropertyTypeDeserializer.f4245l;
    }
}
