package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import e3.c;
import e3.i;
import java.util.Objects;
import k3.b;
import q3.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements c {

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f4084k = new String[0];

    /* renamed from: l, reason: collision with root package name */
    public static final StringArrayDeserializer f4085l = new StringArrayDeserializer();

    /* renamed from: d, reason: collision with root package name */
    public final b3.c<String> f4086d;

    /* renamed from: e, reason: collision with root package name */
    public final i f4087e;
    public final Boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4088j;

    public StringArrayDeserializer() {
        this(null, null, null);
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) throws InvalidDefinitionException {
        b3.c<String> cVar = this.f4086d;
        b3.c<?> cVarC0 = StdDeserializer.c0(deserializationContext, beanProperty, cVar);
        JavaType javaTypeK = deserializationContext.k(String.class);
        b3.c<?> cVarO = cVarC0 == null ? deserializationContext.o(javaTypeK, beanProperty) : deserializationContext.z(cVarC0, beanProperty, javaTypeK);
        JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, String[].class);
        Boolean boolB = valueD0 != null ? valueD0.b(JsonFormat.Feature.f3434a) : null;
        i iVarB0 = StdDeserializer.b0(deserializationContext, beanProperty, cVarO);
        if (cVarO != null && com.fasterxml.jackson.databind.util.a.v(cVarO)) {
            cVarO = null;
        }
        return (cVar == cVarO && Objects.equals(this.h, boolB) && this.f4087e == iVarB0) ? this : new StringArrayDeserializer(cVarO, iVarB0, boolB);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        int i10;
        if (!jsonParser.l1()) {
            return k0(jsonParser, deserializationContext);
        }
        if (this.f4086d != null) {
            return j0(jsonParser, deserializationContext, null);
        }
        l lVarL = deserializationContext.L();
        Object[] objArrG = lVarL.g();
        int i11 = 0;
        while (true) {
            try {
                String strP1 = jsonParser.p1();
                try {
                    if (strP1 == null) {
                        JsonToken jsonTokenK = jsonParser.K();
                        if (jsonTokenK == JsonToken.END_ARRAY) {
                            String[] strArr = (String[]) lVarL.f(objArrG, i11, String.class);
                            deserializationContext.V(lVarL);
                            return strArr;
                        }
                        if (jsonTokenK != JsonToken.VALUE_NULL) {
                            strP1 = W(jsonParser, deserializationContext);
                        } else if (!this.f4088j) {
                            strP1 = (String) this.f4087e.a(deserializationContext);
                        }
                    }
                    objArrG[i11] = strP1;
                    i11 = i10;
                } catch (Exception e10) {
                    e = e10;
                    i11 = i10;
                    throw JsonMappingException.h(e, objArrG, lVarL.f11564c + i11);
                }
                if (i11 >= objArrG.length) {
                    objArrG = lVarL.c(objArrG);
                    i11 = 0;
                }
                i10 = i11 + 1;
            } catch (Exception e11) {
                e = e11;
            }
        }
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        String strP1;
        int i10;
        String[] strArr = (String[]) obj;
        if (!jsonParser.l1()) {
            String[] strArrK0 = k0(jsonParser, deserializationContext);
            if (strArrK0 == null) {
                return strArr;
            }
            int length = strArr.length;
            String[] strArr2 = new String[strArrK0.length + length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            System.arraycopy(strArrK0, 0, strArr2, length, strArrK0.length);
            return strArr2;
        }
        if (this.f4086d != null) {
            return j0(jsonParser, deserializationContext, strArr);
        }
        l lVarL = deserializationContext.L();
        int length2 = strArr.length;
        Object[] objArrH = lVarL.h(strArr, length2);
        while (true) {
            try {
                strP1 = jsonParser.p1();
                if (strP1 == null) {
                    JsonToken jsonTokenK = jsonParser.K();
                    if (jsonTokenK == JsonToken.END_ARRAY) {
                        String[] strArr3 = (String[]) lVarL.f(objArrH, length2, String.class);
                        deserializationContext.V(lVarL);
                        return strArr3;
                    }
                    if (jsonTokenK != JsonToken.VALUE_NULL) {
                        strP1 = W(jsonParser, deserializationContext);
                    } else {
                        if (this.f4088j) {
                            return f4084k;
                        }
                        strP1 = (String) this.f4087e.a(deserializationContext);
                    }
                }
                if (length2 >= objArrH.length) {
                    objArrH = lVarL.c(objArrH);
                    length2 = 0;
                }
                i10 = length2 + 1;
            } catch (Exception e10) {
                e = e10;
            }
            try {
                objArrH[length2] = strP1;
                length2 = i10;
            } catch (Exception e11) {
                e = e11;
                length2 = i10;
                throw JsonMappingException.h(e, objArrH, lVarL.f11564c + length2);
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.c(jsonParser, deserializationContext);
    }

    @Override // b3.c
    public final AccessPattern i() {
        return AccessPattern.f4492b;
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return f4084k;
    }

    public final String[] j0(JsonParser jsonParser, DeserializationContext deserializationContext, String[] strArr) throws JsonMappingException {
        int length;
        Object[] objArrH;
        String strP1;
        b3.c<String> cVar;
        String strD;
        int i10;
        l lVarL = deserializationContext.L();
        if (strArr == null) {
            objArrH = lVarL.g();
            length = 0;
        } else {
            length = strArr.length;
            objArrH = lVarL.h(strArr, length);
        }
        while (true) {
            try {
                strP1 = jsonParser.p1();
                cVar = this.f4086d;
            } catch (Exception e10) {
                e = e10;
            }
            try {
                if (strP1 == null) {
                    JsonToken jsonTokenK = jsonParser.K();
                    if (jsonTokenK == JsonToken.END_ARRAY) {
                        String[] strArr2 = (String[]) lVarL.f(objArrH, length, String.class);
                        deserializationContext.V(lVarL);
                        return strArr2;
                    }
                    if (jsonTokenK != JsonToken.VALUE_NULL) {
                        strD = cVar.d(jsonParser, deserializationContext);
                    } else if (!this.f4088j) {
                        strD = (String) this.f4087e.a(deserializationContext);
                    }
                } else {
                    strD = cVar.d(jsonParser, deserializationContext);
                }
                objArrH[length] = strD;
                length = i10;
            } catch (Exception e11) {
                e = e11;
                length = i10;
                throw JsonMappingException.h(e, String.class, length);
            }
            if (length >= objArrH.length) {
                objArrH = lVarL.c(objArrH);
                length = 0;
            }
            i10 = length + 1;
        }
    }

    public final String[] k0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = this.h;
        if (bool2 == bool || (bool2 == null && deserializationContext.J(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return new String[]{jsonParser.i1(JsonToken.VALUE_NULL) ? (String) this.f4087e.a(deserializationContext) : W(jsonParser, deserializationContext)};
        }
        if (jsonParser.i1(JsonToken.VALUE_STRING)) {
            return D(jsonParser, deserializationContext);
        }
        deserializationContext.C(this.f4054a, jsonParser);
        throw null;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4428a;
    }

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StringArrayDeserializer(b3.c<?> cVar, i iVar, Boolean bool) {
        super((Class<?>) String[].class);
        this.f4086d = cVar;
        this.f4087e = iVar;
        this.h = bool;
        this.f4088j = NullsConstantProvider.b(iVar);
    }
}
