package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import k3.b;
import x2.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NumberDeserializers {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f4016a = new HashSet<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class BigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {

        /* renamed from: d, reason: collision with root package name */
        public static final BigDecimalDeserializer f4017d = new BigDecimalDeserializer();

        public BigDecimalDeserializer() {
            super(BigDecimal.class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            int iP = jsonParser.P();
            Class<?> cls = this.f4054a;
            if (iP == 1) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (iP == 3) {
                return B(jsonParser, deserializationContext);
            }
            if (iP != 6) {
                if (iP == 7 || iP == 8) {
                    return jsonParser.I0();
                }
                deserializationContext.A(jsonParser, g0(deserializationContext));
                throw null;
            }
            String strV0 = jsonParser.V0();
            CoercionAction coercionActionV = v(deserializationContext, strV0);
            if (coercionActionV != CoercionAction.f3798c) {
                if (coercionActionV == CoercionAction.f3799d) {
                    return BigDecimal.ZERO;
                }
                String strTrim = strV0.trim();
                if (!"null".equals(strTrim)) {
                    try {
                        return new BigDecimal(strTrim);
                    } catch (IllegalArgumentException unused) {
                        deserializationContext.G(cls, strTrim, "not a valid representation", new Object[0]);
                        throw null;
                    }
                }
            }
            return null;
        }

        @Override // b3.c
        public final Object j(DeserializationContext deserializationContext) {
            return BigDecimal.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
        public final LogicalType o() {
            return LogicalType.f4433j;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class BigIntegerDeserializer extends StdScalarDeserializer<BigInteger> {

        /* renamed from: d, reason: collision with root package name */
        public static final BigIntegerDeserializer f4018d = new BigIntegerDeserializer();

        public BigIntegerDeserializer() {
            super(BigInteger.class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            if (jsonParser.k1()) {
                return jsonParser.Q();
            }
            int iP = jsonParser.P();
            Class<?> cls = this.f4054a;
            if (iP == 1) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (iP == 3) {
                return B(jsonParser, deserializationContext);
            }
            CoercionAction coercionAction = CoercionAction.f3799d;
            CoercionAction coercionAction2 = CoercionAction.f3798c;
            if (iP == 6) {
                String strV0 = jsonParser.V0();
                CoercionAction coercionActionV = v(deserializationContext, strV0);
                if (coercionActionV != coercionAction2) {
                    if (coercionActionV == coercionAction) {
                        return BigInteger.ZERO;
                    }
                    String strTrim = strV0.trim();
                    if (!"null".equals(strTrim)) {
                        try {
                            return new BigInteger(strTrim);
                        } catch (IllegalArgumentException unused) {
                            deserializationContext.G(cls, strTrim, "not a valid representation", new Object[0]);
                            throw null;
                        }
                    }
                }
            } else {
                if (iP != 8) {
                    deserializationContext.A(jsonParser, g0(deserializationContext));
                    throw null;
                }
                CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls);
                if (coercionActionU != coercionAction2) {
                    return coercionActionU == coercionAction ? BigInteger.ZERO : jsonParser.I0().toBigInteger();
                }
            }
            return null;
        }

        @Override // b3.c
        public final Object j(DeserializationContext deserializationContext) {
            return BigInteger.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
        public final LogicalType o() {
            return LogicalType.h;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class BooleanDeserializer extends PrimitiveOrWrapperDeserializer<Boolean> {

        /* renamed from: k, reason: collision with root package name */
        public static final BooleanDeserializer f4019k = new BooleanDeserializer(Boolean.TYPE, Boolean.FALSE);

        /* renamed from: l, reason: collision with root package name */
        public static final BooleanDeserializer f4020l = new BooleanDeserializer(Boolean.class, null);

        public BooleanDeserializer(Class<Boolean> cls, Boolean bool) {
            super(cls, LogicalType.f4434k, bool, Boolean.FALSE);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken jsonTokenK = jsonParser.K();
            return jsonTokenK == JsonToken.VALUE_TRUE ? Boolean.TRUE : jsonTokenK == JsonToken.VALUE_FALSE ? Boolean.FALSE : this.f4036j ? Boolean.valueOf(L(jsonParser, deserializationContext)) : K(jsonParser, deserializationContext, this.f4054a);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
        public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
            JsonToken jsonTokenK = jsonParser.K();
            return jsonTokenK == JsonToken.VALUE_TRUE ? Boolean.TRUE : jsonTokenK == JsonToken.VALUE_FALSE ? Boolean.FALSE : this.f4036j ? Boolean.valueOf(L(jsonParser, deserializationContext)) : K(jsonParser, deserializationContext, this.f4054a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class ByteDeserializer extends PrimitiveOrWrapperDeserializer<Byte> {

        /* renamed from: k, reason: collision with root package name */
        public static final ByteDeserializer f4021k = new ByteDeserializer(Byte.TYPE, (byte) 0);

        /* renamed from: l, reason: collision with root package name */
        public static final ByteDeserializer f4022l = new ByteDeserializer(Byte.class, null);

        public ByteDeserializer(Class<Byte> cls, Byte b10) {
            super(cls, LogicalType.h, b10, (byte) 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            if (jsonParser.k1()) {
                return Byte.valueOf(jsonParser.c0());
            }
            if (this.f4036j) {
                return Byte.valueOf(M(jsonParser, deserializationContext));
            }
            int iP = jsonParser.P();
            Class<?> cls = this.f4054a;
            if (iP == 1) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (iP == 3) {
                return B(jsonParser, deserializationContext);
            }
            if (iP == 11) {
                return a(deserializationContext);
            }
            T t8 = this.h;
            CoercionAction coercionAction = CoercionAction.f3799d;
            CoercionAction coercionAction2 = CoercionAction.f3798c;
            if (iP != 6) {
                if (iP == 7) {
                    return Byte.valueOf(jsonParser.c0());
                }
                if (iP == 8) {
                    CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls);
                    return coercionActionU == coercionAction2 ? a(deserializationContext) : coercionActionU == coercionAction ? (Byte) t8 : Byte.valueOf(jsonParser.c0());
                }
                deserializationContext.A(jsonParser, g0(deserializationContext));
                throw null;
            }
            String strV0 = jsonParser.V0();
            CoercionAction coercionActionV = v(deserializationContext, strV0);
            if (coercionActionV == coercionAction2) {
                return a(deserializationContext);
            }
            if (coercionActionV == coercionAction) {
                return (Byte) t8;
            }
            String strTrim = strV0.trim();
            if (x(deserializationContext, strTrim)) {
                return a(deserializationContext);
            }
            try {
                int iC = d.c(strTrim);
                if (iC >= -128 && iC <= 255) {
                    return Byte.valueOf((byte) iC);
                }
                deserializationContext.G(cls, strTrim, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                throw null;
            } catch (IllegalArgumentException unused) {
                deserializationContext.G(cls, strTrim, "not a valid Byte value", new Object[0]);
                throw null;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class CharacterDeserializer extends PrimitiveOrWrapperDeserializer<Character> {

        /* renamed from: k, reason: collision with root package name */
        public static final CharacterDeserializer f4023k = new CharacterDeserializer(Character.TYPE, 0);

        /* renamed from: l, reason: collision with root package name */
        public static final CharacterDeserializer f4024l = new CharacterDeserializer(Character.class, null);

        public CharacterDeserializer(Class<Character> cls, Character ch) {
            super(cls, LogicalType.h, ch, (char) 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            int iP = jsonParser.P();
            Class<?> cls = this.f4054a;
            if (iP == 1) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (iP == 3) {
                return B(jsonParser, deserializationContext);
            }
            if (iP == 11) {
                if (this.f4036j) {
                    Z(deserializationContext);
                }
                return a(deserializationContext);
            }
            T t8 = this.h;
            if (iP == 6) {
                String strV0 = jsonParser.V0();
                if (strV0.length() == 1) {
                    return Character.valueOf(strV0.charAt(0));
                }
                CoercionAction coercionActionV = v(deserializationContext, strV0);
                if (coercionActionV == CoercionAction.f3798c) {
                    return a(deserializationContext);
                }
                if (coercionActionV == CoercionAction.f3799d) {
                    return (Character) t8;
                }
                String strTrim = strV0.trim();
                if (x(deserializationContext, strTrim)) {
                    return a(deserializationContext);
                }
                deserializationContext.G(cls, strTrim, "Expected either Integer value code or 1-character String", new Object[0]);
                throw null;
            }
            if (iP != 7) {
                deserializationContext.A(jsonParser, g0(deserializationContext));
                throw null;
            }
            CoercionAction coercionActionM = deserializationContext.m(this.f4034d, cls, CoercionInputShape.f3805a);
            int iOrdinal = coercionActionM.ordinal();
            if (iOrdinal == 0) {
                r(deserializationContext, coercionActionM, jsonParser.P0(), "Integer value (" + jsonParser.V0() + ")");
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return (Character) t8;
                }
                int iM0 = jsonParser.M0();
                if (iM0 >= 0 && iM0 <= 65535) {
                    return Character.valueOf((char) iM0);
                }
                deserializationContext.F(cls, Integer.valueOf(iM0), "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]);
                throw null;
            }
            return a(deserializationContext);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class DoubleDeserializer extends PrimitiveOrWrapperDeserializer<Double> {

        /* renamed from: k, reason: collision with root package name */
        public static final DoubleDeserializer f4025k = new DoubleDeserializer(Double.TYPE, Double.valueOf(0.0d));

        /* renamed from: l, reason: collision with root package name */
        public static final DoubleDeserializer f4026l = new DoubleDeserializer(Double.class, null);

        public DoubleDeserializer(Class<Double> cls, Double d8) {
            super(cls, LogicalType.f4433j, d8, Double.valueOf(0.0d));
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.i1(JsonToken.VALUE_NUMBER_FLOAT) ? Double.valueOf(jsonParser.J0()) : this.f4036j ? Double.valueOf(O(jsonParser, deserializationContext)) : j0(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
        public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
            return jsonParser.i1(JsonToken.VALUE_NUMBER_FLOAT) ? Double.valueOf(jsonParser.J0()) : this.f4036j ? Double.valueOf(O(jsonParser, deserializationContext)) : j0(jsonParser, deserializationContext);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Double j0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            int iP = jsonParser.P();
            Class<?> cls = this.f4054a;
            if (iP == 1) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (iP == 3) {
                return B(jsonParser, deserializationContext);
            }
            if (iP == 11) {
                return a(deserializationContext);
            }
            if (iP != 6) {
                if (iP == 7 || iP == 8) {
                    return Double.valueOf(jsonParser.J0());
                }
                deserializationContext.A(jsonParser, g0(deserializationContext));
                throw null;
            }
            String strV0 = jsonParser.V0();
            Double dS = StdDeserializer.s(strV0);
            if (dS != null) {
                return dS;
            }
            CoercionAction coercionActionV = v(deserializationContext, strV0);
            if (coercionActionV == CoercionAction.f3798c) {
                return a(deserializationContext);
            }
            if (coercionActionV == CoercionAction.f3799d) {
                return (Double) this.h;
            }
            String strTrim = strV0.trim();
            if (x(deserializationContext, strTrim)) {
                return a(deserializationContext);
            }
            try {
                return Double.valueOf("2.2250738585072012e-308".equals(strTrim) ? Double.MIN_NORMAL : Double.parseDouble(strTrim));
            } catch (IllegalArgumentException unused) {
                deserializationContext.G(cls, strTrim, "not a valid `Double` value", new Object[0]);
                throw null;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class FloatDeserializer extends PrimitiveOrWrapperDeserializer<Float> {

        /* renamed from: k, reason: collision with root package name */
        public static final FloatDeserializer f4027k = new FloatDeserializer(Float.TYPE, Float.valueOf(0.0f));

        /* renamed from: l, reason: collision with root package name */
        public static final FloatDeserializer f4028l = new FloatDeserializer(Float.class, null);

        public FloatDeserializer(Class<Float> cls, Float f8) {
            super(cls, LogicalType.f4433j, f8, Float.valueOf(0.0f));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            if (jsonParser.i1(JsonToken.VALUE_NUMBER_FLOAT)) {
                return Float.valueOf(jsonParser.L0());
            }
            if (this.f4036j) {
                return Float.valueOf(P(jsonParser, deserializationContext));
            }
            int iP = jsonParser.P();
            Class<?> cls = this.f4054a;
            if (iP == 1) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (iP == 3) {
                return B(jsonParser, deserializationContext);
            }
            if (iP == 11) {
                return a(deserializationContext);
            }
            if (iP != 6) {
                if (iP == 7 || iP == 8) {
                    return Float.valueOf(jsonParser.L0());
                }
                deserializationContext.A(jsonParser, g0(deserializationContext));
                throw null;
            }
            String strV0 = jsonParser.V0();
            Float fT = StdDeserializer.t(strV0);
            if (fT != null) {
                return fT;
            }
            CoercionAction coercionActionV = v(deserializationContext, strV0);
            if (coercionActionV == CoercionAction.f3798c) {
                return a(deserializationContext);
            }
            if (coercionActionV == CoercionAction.f3799d) {
                return (Float) this.h;
            }
            String strTrim = strV0.trim();
            if (x(deserializationContext, strTrim)) {
                return a(deserializationContext);
            }
            try {
                return Float.valueOf(Float.parseFloat(strTrim));
            } catch (IllegalArgumentException unused) {
                deserializationContext.G(cls, strTrim, "not a valid `Float` value", new Object[0]);
                throw null;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class IntegerDeserializer extends PrimitiveOrWrapperDeserializer<Integer> {

        /* renamed from: k, reason: collision with root package name */
        public static final IntegerDeserializer f4029k = new IntegerDeserializer(Integer.TYPE, 0);

        /* renamed from: l, reason: collision with root package name */
        public static final IntegerDeserializer f4030l = new IntegerDeserializer(Integer.class, null);

        public IntegerDeserializer(Class<Integer> cls, Integer num) {
            super(cls, LogicalType.h, num, 0);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.k1() ? Integer.valueOf(jsonParser.M0()) : this.f4036j ? Integer.valueOf(Q(jsonParser, deserializationContext)) : S(jsonParser, deserializationContext, Integer.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
        public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
            return jsonParser.k1() ? Integer.valueOf(jsonParser.M0()) : this.f4036j ? Integer.valueOf(Q(jsonParser, deserializationContext)) : S(jsonParser, deserializationContext, Integer.class);
        }

        @Override // b3.c
        public final boolean n() {
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class LongDeserializer extends PrimitiveOrWrapperDeserializer<Long> {

        /* renamed from: k, reason: collision with root package name */
        public static final LongDeserializer f4031k = new LongDeserializer(Long.TYPE, 0L);

        /* renamed from: l, reason: collision with root package name */
        public static final LongDeserializer f4032l = new LongDeserializer(Long.class, null);

        public LongDeserializer(Class<Long> cls, Long l10) {
            super(cls, LogicalType.h, l10, 0L);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.k1() ? Long.valueOf(jsonParser.N0()) : this.f4036j ? Long.valueOf(U(jsonParser, deserializationContext)) : T(jsonParser, deserializationContext, Long.class);
        }

        @Override // b3.c
        public final boolean n() {
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class NumberDeserializer extends StdScalarDeserializer<Object> {

        /* renamed from: d, reason: collision with root package name */
        public static final NumberDeserializer f4033d = new NumberDeserializer();

        public NumberDeserializer() {
            super(Number.class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException, NumberFormatException {
            int iP = jsonParser.P();
            Class<?> cls = this.f4054a;
            int i10 = 1;
            if (iP == 1) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (iP == 3) {
                return B(jsonParser, deserializationContext);
            }
            if (iP != 6) {
                if (iP == 7) {
                    return (StdDeserializer.f4053c & deserializationContext.f3664d) != 0 ? StdDeserializer.z(jsonParser, deserializationContext) : jsonParser.P0();
                }
                if (iP == 8) {
                    return (!deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) || jsonParser.n1()) ? jsonParser.P0() : jsonParser.I0();
                }
                deserializationContext.A(jsonParser, g0(deserializationContext));
                throw null;
            }
            String strV0 = jsonParser.V0();
            CoercionAction coercionActionV = v(deserializationContext, strV0);
            if (coercionActionV != CoercionAction.f3798c && coercionActionV != CoercionAction.f3799d) {
                String strTrim = strV0.trim();
                if (!"null".equals(strTrim)) {
                    if (StdDeserializer.I(strTrim)) {
                        return Double.valueOf(Double.POSITIVE_INFINITY);
                    }
                    if (StdDeserializer.H(strTrim)) {
                        return Double.valueOf(Double.NEGATIVE_INFINITY);
                    }
                    if ("NaN".equals(strTrim)) {
                        return Double.valueOf(Double.NaN);
                    }
                    try {
                        int length = strTrim.length();
                        if (length > 0) {
                            char cCharAt = strTrim.charAt(0);
                            if (cCharAt != '-' && cCharAt != '+') {
                                i10 = 0;
                            } else if (length == 1) {
                            }
                            while (i10 < length) {
                                char cCharAt2 = strTrim.charAt(i10);
                                if (cCharAt2 <= '9' && cCharAt2 >= '0') {
                                    i10++;
                                }
                            }
                            if (deserializationContext.J(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                                return new BigInteger(strTrim);
                            }
                            long j10 = Long.parseLong(strTrim);
                            return (deserializationContext.J(DeserializationFeature.USE_LONG_FOR_INTS) || j10 > 2147483647L || j10 < -2147483648L) ? Long.valueOf(j10) : Integer.valueOf((int) j10);
                        }
                        return deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? new BigDecimal(strTrim) : Double.valueOf(strTrim);
                    } catch (IllegalArgumentException unused) {
                        deserializationContext.G(cls, strTrim, "not a valid number", new Object[0]);
                        throw null;
                    }
                }
            }
            return null;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
        public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
            int iP = jsonParser.P();
            return (iP == 6 || iP == 7 || iP == 8) ? d(jsonParser, deserializationContext) : bVar.e(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
        public final LogicalType o() {
            return LogicalType.h;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {

        /* renamed from: d, reason: collision with root package name */
        public final LogicalType f4034d;

        /* renamed from: e, reason: collision with root package name */
        public final T f4035e;
        public final T h;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f4036j;

        public PrimitiveOrWrapperDeserializer(Class<T> cls, LogicalType logicalType, T t8, T t10) {
            super(cls);
            this.f4034d = logicalType;
            this.f4035e = t8;
            this.h = t10;
            this.f4036j = cls.isPrimitive();
        }

        @Override // b3.c, e3.i
        public final T a(DeserializationContext deserializationContext) throws MismatchedInputException {
            if (!this.f4036j || !deserializationContext.J(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
                return this.f4035e;
            }
            deserializationContext.P(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", com.fasterxml.jackson.databind.util.a.f(this.f4054a));
            throw null;
        }

        @Override // b3.c
        public final Object j(DeserializationContext deserializationContext) {
            return this.h;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
        public final LogicalType o() {
            return this.f4034d;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class ShortDeserializer extends PrimitiveOrWrapperDeserializer<Short> {

        /* renamed from: k, reason: collision with root package name */
        public static final ShortDeserializer f4037k = new ShortDeserializer(Short.TYPE, 0);

        /* renamed from: l, reason: collision with root package name */
        public static final ShortDeserializer f4038l = new ShortDeserializer(Short.class, null);

        public ShortDeserializer(Class<Short> cls, Short sh) {
            super(cls, LogicalType.h, sh, (short) 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            if (jsonParser.k1()) {
                return Short.valueOf(jsonParser.U0());
            }
            if (this.f4036j) {
                return Short.valueOf(V(jsonParser, deserializationContext));
            }
            int iP = jsonParser.P();
            Class<?> cls = this.f4054a;
            if (iP == 1) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            if (iP == 3) {
                return B(jsonParser, deserializationContext);
            }
            if (iP == 11) {
                return a(deserializationContext);
            }
            T t8 = this.h;
            CoercionAction coercionAction = CoercionAction.f3799d;
            CoercionAction coercionAction2 = CoercionAction.f3798c;
            if (iP != 6) {
                if (iP == 7) {
                    return Short.valueOf(jsonParser.U0());
                }
                if (iP == 8) {
                    CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls);
                    return coercionActionU == coercionAction2 ? a(deserializationContext) : coercionActionU == coercionAction ? (Short) t8 : Short.valueOf(jsonParser.U0());
                }
                deserializationContext.A(jsonParser, g0(deserializationContext));
                throw null;
            }
            String strV0 = jsonParser.V0();
            CoercionAction coercionActionV = v(deserializationContext, strV0);
            if (coercionActionV == coercionAction2) {
                return a(deserializationContext);
            }
            if (coercionActionV == coercionAction) {
                return (Short) t8;
            }
            String strTrim = strV0.trim();
            if (x(deserializationContext, strTrim)) {
                return a(deserializationContext);
            }
            try {
                int iC = d.c(strTrim);
                if (iC >= -32768 && iC <= 32767) {
                    return Short.valueOf((short) iC);
                }
                deserializationContext.G(cls, strTrim, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                throw null;
            } catch (IllegalArgumentException unused) {
                deserializationContext.G(cls, strTrim, "not a valid Short value", new Object[0]);
                throw null;
            }
        }
    }

    static {
        Class[] clsArr = {Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
        for (int i10 = 0; i10 < 11; i10++) {
            f4016a.add(clsArr[i10].getName());
        }
    }
}
