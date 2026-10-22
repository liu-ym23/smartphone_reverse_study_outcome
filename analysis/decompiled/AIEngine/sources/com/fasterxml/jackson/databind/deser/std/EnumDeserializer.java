package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.CompactStringObjectMap;
import com.fasterxml.jackson.databind.util.EnumResolver;
import e3.c;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class EnumDeserializer extends StdScalarDeserializer<Object> implements c {

    /* renamed from: d, reason: collision with root package name */
    public final Object[] f3970d;

    /* renamed from: e, reason: collision with root package name */
    public final Enum<?> f3971e;
    public final CompactStringObjectMap h;

    /* renamed from: j, reason: collision with root package name */
    public CompactStringObjectMap f3972j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f3973k;

    public EnumDeserializer(EnumDeserializer enumDeserializer, Boolean bool) {
        super(enumDeserializer);
        this.h = enumDeserializer.h;
        this.f3970d = enumDeserializer.f3970d;
        this.f3971e = enumDeserializer.f3971e;
        this.f3973k = bool;
    }

    public static b3.c j0(DeserializationConfig deserializationConfig, Class cls, AnnotatedMethod annotatedMethod, StdValueInstantiator stdValueInstantiator, SettableBeanProperty[] settableBeanPropertyArr) {
        deserializationConfig.getClass();
        if (deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            com.fasterxml.jackson.databind.util.a.e(annotatedMethod.f4124d, deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new FactoryBasedEnumDeserializer(cls, annotatedMethod, annotatedMethod.t(0), stdValueInstantiator, settableBeanPropertyArr);
    }

    public static b3.c<?> k0(DeserializationConfig deserializationConfig, Class<?> cls, AnnotatedMethod annotatedMethod) {
        deserializationConfig.getClass();
        if (deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            com.fasterxml.jackson.databind.util.a.e(annotatedMethod.f4124d, deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new FactoryBasedEnumDeserializer(cls, annotatedMethod);
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, this.f4054a);
        Boolean boolB = valueD0 != null ? valueD0.b(JsonFormat.Feature.f3435b) : null;
        Boolean bool = this.f3973k;
        if (boolB == null) {
            boolB = bool;
        }
        return Objects.equals(bool, boolB) ? this : new EnumDeserializer(this, boolB);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException, NumberFormatException {
        CompactStringObjectMap compactStringObjectMapB;
        char cCharAt;
        Object obj;
        CoercionAction coercionActionN;
        Object objA;
        Class<?> cls = this.f4054a;
        if (!jsonParser.i1(JsonToken.VALUE_STRING)) {
            if (!jsonParser.i1(JsonToken.VALUE_NUMBER_INT)) {
                if (jsonParser.m1()) {
                    deserializationContext.C(cls, jsonParser);
                    throw null;
                }
                if (jsonParser.i1(JsonToken.START_ARRAY)) {
                    return B(jsonParser, deserializationContext);
                }
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            int iM0 = jsonParser.M0();
            Object[] objArr = this.f3970d;
            Enum<?> r62 = this.f3971e;
            CoercionAction coercionActionM = deserializationContext.m(LogicalType.f4435l, cls, CoercionInputShape.f3805a);
            if (coercionActionM == CoercionAction.f3796a) {
                if (deserializationContext.J(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                    deserializationContext.F(cls, Integer.valueOf(iM0), "not allowed to deserialize Enum value out of number: disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow", new Object[0]);
                    throw null;
                }
                r(deserializationContext, coercionActionM, Integer.valueOf(iM0), ai.onnxruntime.a.g(iM0, "Integer value (", ")"));
            }
            int iOrdinal = coercionActionM.ordinal();
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return r62;
                }
                if (iM0 >= 0 && iM0 < objArr.length) {
                    return objArr[iM0];
                }
                if (r62 != null && deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
                    return r62;
                }
                if (!deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    deserializationContext.F(cls, Integer.valueOf(iM0), "index value outside legal index range [0..%s]", Integer.valueOf(objArr.length - 1));
                    throw null;
                }
            }
            return null;
        }
        String strV0 = jsonParser.V0();
        if (deserializationContext.J(DeserializationFeature.READ_ENUMS_USING_TO_STRING)) {
            compactStringObjectMapB = this.f3972j;
            if (compactStringObjectMapB == null) {
                synchronized (this) {
                    compactStringObjectMapB = EnumResolver.c(deserializationContext.f3663c, this.f4054a).b();
                }
                this.f3972j = compactStringObjectMapB;
            }
        } else {
            compactStringObjectMapB = this.h;
        }
        Object objA2 = compactStringObjectMapB.a(strV0);
        if (objA2 != null) {
            return objA2;
        }
        String strTrim = strV0.trim();
        if (strTrim != strV0 && (objA = compactStringObjectMapB.a(strTrim)) != null) {
            return objA;
        }
        Class<?> cls2 = this.f4054a;
        LogicalType logicalType = LogicalType.f4435l;
        Enum<?> r72 = this.f3971e;
        String strTrim2 = strTrim.trim();
        if (strTrim2.isEmpty()) {
            if (r72 != null && deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
                return r72;
            }
            if (!deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                if (strTrim.isEmpty()) {
                    coercionActionN = deserializationContext.m(logicalType, this.f4054a, CoercionInputShape.f3809e);
                    r(deserializationContext, coercionActionN, strTrim, "empty String (\"\")");
                } else {
                    coercionActionN = deserializationContext.n(logicalType, this.f4054a);
                    r(deserializationContext, coercionActionN, strTrim, "blank String (all whitespace)");
                }
                int iOrdinal2 = coercionActionN.ordinal();
                if (iOrdinal2 == 1 || iOrdinal2 == 3) {
                    return r72;
                }
            }
            return null;
        }
        if (Boolean.TRUE.equals(this.f3973k)) {
            Object[] objArr2 = compactStringObjectMapB.f4498c;
            int length = objArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    obj = null;
                    break;
                }
                Object obj2 = objArr2[i10];
                if (obj2 != null && ((String) obj2).equalsIgnoreCase(strTrim2)) {
                    obj = objArr2[i10 + 1];
                    break;
                }
                i10 += 2;
            }
            if (obj != null) {
                return obj;
            }
        } else if (!deserializationContext.J(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS) && (cCharAt = strTrim2.charAt(0)) >= '0' && cCharAt <= '9') {
            try {
                int i11 = Integer.parseInt(strTrim2);
                if (!deserializationContext.f3663c.k(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
                    deserializationContext.G(cls2, strTrim2, "value looks like quoted Enum index, but `MapperFeature.ALLOW_COERCION_OF_SCALARS` prevents use", new Object[0]);
                    throw null;
                }
                if (i11 >= 0) {
                    Object[] objArr3 = this.f3970d;
                    if (i11 < objArr3.length) {
                        return objArr3[i11];
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (r72 != null && deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
            return r72;
        }
        if (deserializationContext.J(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
            return null;
        }
        Object[] objArr4 = compactStringObjectMapB.f4498c;
        int length2 = objArr4.length;
        ArrayList arrayList = new ArrayList(length2 >> 2);
        for (int i12 = 0; i12 < length2; i12 += 2) {
            Object obj3 = objArr4[i12];
            if (obj3 != null) {
                arrayList.add((String) obj3);
            }
        }
        deserializationContext.G(cls2, strTrim2, "not one of the values accepted for Enum class: %s", arrayList);
        throw null;
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return this.f3971e;
    }

    @Override // b3.c
    public final boolean n() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
    public final LogicalType o() {
        return LogicalType.f4435l;
    }

    public EnumDeserializer(EnumResolver enumResolver, Boolean bool) {
        super(enumResolver.f4499a);
        this.h = enumResolver.b();
        this.f3970d = enumResolver.f4500b;
        this.f3971e = enumResolver.f4502d;
        this.f3973k = bool;
    }
}
