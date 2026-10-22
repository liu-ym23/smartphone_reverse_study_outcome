package com.fasterxml.jackson.databind.deser.std;

import androidx.appcompat.widget.l;
import b3.c;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.a;
import e3.e;
import e3.i;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import q3.g;
import w2.b;
import x2.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class StdDeserializer<T> extends c<T> implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final int f4053c = DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.f3689b | DeserializationFeature.USE_LONG_FOR_INTS.f3689b;

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f4054a;

    /* renamed from: b, reason: collision with root package name */
    public final JavaType f4055b;

    static {
        int i10 = DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS.f3689b;
        int i11 = DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.f3689b;
    }

    public StdDeserializer(Class<?> cls) {
        this.f4054a = cls;
        this.f4055b = null;
    }

    public static i E(DeserializationContext deserializationContext, BeanProperty beanProperty, Nulls nulls, c cVar) throws InvalidDefinitionException {
        if (nulls == Nulls.f3492b) {
            if (beanProperty == null) {
                return new NullsFailProvider(null, deserializationContext.k(cVar.m()));
            }
            return new NullsFailProvider(beanProperty.b(), beanProperty.getType());
        }
        if (nulls == Nulls.f3493c) {
            if (cVar != null) {
                if ((cVar instanceof BeanDeserializerBase) && !((BeanDeserializerBase) cVar).h.j()) {
                    deserializationContext.j(String.format("Cannot create empty instance of %s, no default Creator", beanProperty.getType()));
                    throw null;
                }
                AccessPattern accessPatternI = cVar.i();
                if (accessPatternI != AccessPattern.f4491a) {
                    if (accessPatternI != AccessPattern.f4492b) {
                        return new NullsAsEmptyProvider(cVar);
                    }
                    Object objJ = cVar.j(deserializationContext);
                    if (objJ != null) {
                        return new NullsConstantProvider(objJ);
                    }
                }
                return NullsConstantProvider.f3925c;
            }
        } else if (nulls == Nulls.f3491a) {
            return NullsConstantProvider.f3924b;
        }
        return null;
    }

    public static final boolean F(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) > ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean G(String str) {
        char cCharAt = str.charAt(0);
        return cCharAt == 'f' ? "false".equals(str) : cCharAt == 'F' && ("FALSE".equals(str) || "False".equals(str));
    }

    public static boolean H(String str) {
        return "-Infinity".equals(str) || "-INF".equals(str);
    }

    public static boolean I(String str) {
        return "Infinity".equals(str) || "INF".equals(str);
    }

    public static boolean J(String str) {
        char cCharAt = str.charAt(0);
        return cCharAt == 't' ? "true".equals(str) : cCharAt == 'T' && ("TRUE".equals(str) || "True".equals(str));
    }

    public static int R(DeserializationContext deserializationContext, String str) throws InvalidFormatException, NumberFormatException {
        Class cls = Integer.TYPE;
        try {
            if (str.length() <= 9) {
                return d.c(str);
            }
            long j10 = Long.parseLong(str);
            if (j10 >= -2147483648L && j10 <= 2147483647L) {
                return (int) j10;
            }
            deserializationContext.G(cls, str, "Overflow: numeric value (%s) out of range of int (%d -%d)", str, Integer.MIN_VALUE, Integer.MAX_VALUE);
            throw null;
        } catch (IllegalArgumentException unused) {
            deserializationContext.G(cls, str, "not a valid `int` value", new Object[0]);
            throw null;
        }
    }

    public static i b0(DeserializationContext deserializationContext, BeanProperty beanProperty, c cVar) throws InvalidDefinitionException {
        Nulls nulls = beanProperty != null ? beanProperty.c().f3750j : null;
        if (nulls == Nulls.f3491a) {
            return NullsConstantProvider.f3924b;
        }
        if (nulls != Nulls.f3492b) {
            i iVarE = E(deserializationContext, beanProperty, nulls, cVar);
            return iVarE != null ? iVarE : cVar;
        }
        if (beanProperty != null) {
            return new NullsFailProvider(beanProperty.b(), beanProperty.getType().k());
        }
        JavaType javaTypeK = deserializationContext.k(cVar.m());
        if (javaTypeK.y()) {
            javaTypeK = javaTypeK.k();
        }
        return new NullsFailProvider(null, javaTypeK);
    }

    public static c c0(DeserializationContext deserializationContext, BeanProperty beanProperty, c cVar) {
        AnnotatedMember annotatedMemberD;
        Object objH;
        AnnotationIntrospector annotationIntrospectorD = deserializationContext.f3663c.d();
        if (annotationIntrospectorD == null || beanProperty == null || (annotatedMemberD = beanProperty.d()) == null || (objH = annotationIntrospectorD.h(annotatedMemberD)) == null) {
            return cVar;
        }
        beanProperty.d();
        g gVarC = deserializationContext.c(objH);
        deserializationContext.e();
        JavaType inputType = gVarC.getInputType();
        if (cVar == null) {
            cVar = deserializationContext.o(inputType, beanProperty);
        }
        return new StdDelegatingDeserializer(gVarC, inputType, cVar);
    }

    public static JsonFormat.Value d0(DeserializationContext deserializationContext, BeanProperty beanProperty, Class cls) {
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        return beanProperty != null ? beanProperty.a(deserializationConfig, cls) : deserializationConfig.f(cls);
    }

    public static Double s(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == '-') {
            if (H(str)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'I') {
            if (I(str)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'N' && "NaN".equals(str)) {
            return Double.valueOf(Double.NaN);
        }
        return null;
    }

    public static Float t(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == '-') {
            if (H(str)) {
                return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'I') {
            if (I(str)) {
                return Float.valueOf(Float.POSITIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'N' && "NaN".equals(str)) {
            return Float.valueOf(Float.NaN);
        }
        return null;
    }

    public static Number z(JsonParser jsonParser, DeserializationContext deserializationContext) {
        int i10 = deserializationContext.f3664d;
        return (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.f3689b & i10) != 0 ? jsonParser.Q() : (i10 & DeserializationFeature.USE_LONG_FOR_INTS.f3689b) != 0 ? Long.valueOf(jsonParser.N0()) : jsonParser.P0();
    }

    public final String A() {
        String strM;
        JavaType javaTypeF0 = f0();
        boolean z = true;
        if (javaTypeF0 == null || javaTypeF0.f3690a.isPrimitive()) {
            Class<?> clsM = m();
            if (!clsM.isArray() && !Collection.class.isAssignableFrom(clsM) && !Map.class.isAssignableFrom(clsM)) {
                z = false;
            }
            strM = a.m(clsM);
        } else {
            if (!javaTypeF0.y() && !javaTypeF0.d()) {
                z = false;
            }
            strM = a.r(javaTypeF0);
        }
        return z ? ai.onnxruntime.a.k("element of ", strM) : a0.a.j(strM, " value");
    }

    public T B(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        CoercionAction coercionActionM = deserializationContext.m(o(), m(), CoercionInputShape.f3808d);
        boolean zJ = deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zJ || coercionActionM != CoercionAction.f3796a) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (jsonTokenQ1 == jsonToken) {
                int iOrdinal = coercionActionM.ordinal();
                if (iOrdinal == 1 || iOrdinal == 2) {
                    return a(deserializationContext);
                }
                if (iOrdinal == 3) {
                    return (T) j(deserializationContext);
                }
            } else if (zJ) {
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                if (!jsonParser.i1(jsonToken2)) {
                    T tD = d(jsonParser, deserializationContext);
                    if (jsonParser.q1() == jsonToken) {
                        return tD;
                    }
                    h0(deserializationContext);
                    throw null;
                }
                deserializationContext.B(g0(deserializationContext), jsonParser.K(), jsonParser, "Cannot deserialize instance of " + a.y(this.f4054a) + " out of " + jsonToken2 + " token: nested Arrays not allowed with DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS", new Object[0]);
                throw null;
            }
        }
        deserializationContext.B(g0(deserializationContext), JsonToken.START_ARRAY, jsonParser, null, new Object[0]);
        throw null;
    }

    public final Object C(DeserializationContext deserializationContext, CoercionAction coercionAction) throws InvalidFormatException {
        int iOrdinal = coercionAction.ordinal();
        if (iOrdinal == 0) {
            r(deserializationContext, coercionAction, "", "empty String (\"\")");
            return null;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return j(deserializationContext);
    }

    public final T D(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        ValueInstantiator valueInstantiatorE0 = e0();
        Class<?> clsM = m();
        String strF1 = jsonParser.f1();
        if (valueInstantiatorE0 != null && valueInstantiatorE0.h()) {
            return (T) valueInstantiatorE0.t(deserializationContext, strF1);
        }
        if (strF1.isEmpty()) {
            return (T) C(deserializationContext, deserializationContext.m(o(), clsM, CoercionInputShape.f3809e));
        }
        if (F(strF1)) {
            return (T) C(deserializationContext, deserializationContext.n(o(), clsM));
        }
        if (valueInstantiatorE0 != null) {
            strF1 = strF1.trim();
            boolean zE = valueInstantiatorE0.e();
            LogicalType logicalType = LogicalType.h;
            CoercionAction coercionAction = CoercionAction.f3797b;
            CoercionInputShape coercionInputShape = CoercionInputShape.f3807c;
            if (zE && deserializationContext.m(logicalType, Integer.class, coercionInputShape) == coercionAction) {
                return (T) valueInstantiatorE0.q(deserializationContext, R(deserializationContext, strF1));
            }
            if (valueInstantiatorE0.f() && deserializationContext.m(logicalType, Long.class, coercionInputShape) == coercionAction) {
                try {
                    String str = d.f13725a;
                    return (T) valueInstantiatorE0.r(deserializationContext, strF1.length() <= 9 ? d.c(strF1) : Long.parseLong(strF1));
                } catch (IllegalArgumentException unused) {
                    deserializationContext.G(Long.TYPE, strF1, "not a valid `long` value", new Object[0]);
                    throw null;
                }
            }
            if (valueInstantiatorE0.c() && deserializationContext.m(LogicalType.f4434k, Boolean.class, coercionInputShape) == coercionAction) {
                String strTrim = strF1.trim();
                if ("true".equals(strTrim)) {
                    return (T) valueInstantiatorE0.o(deserializationContext, true);
                }
                if ("false".equals(strTrim)) {
                    return (T) valueInstantiatorE0.o(deserializationContext, false);
                }
            }
        }
        b bVar = deserializationContext.h;
        deserializationContext.x(clsM, valueInstantiatorE0, "no String-argument constructor/factory method to deserialize from String value ('%s')", strF1);
        throw null;
    }

    public final Boolean K(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws MismatchedInputException {
        int iP = jsonParser.P();
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP == 3) {
            return (Boolean) B(jsonParser, deserializationContext);
        }
        if (iP == 6) {
            String strV0 = jsonParser.V0();
            CoercionAction coercionActionW = w(deserializationContext, strV0, LogicalType.f4434k, cls);
            if (coercionActionW != CoercionAction.f3798c) {
                if (coercionActionW == CoercionAction.f3799d) {
                    return Boolean.FALSE;
                }
                String strTrim = strV0.trim();
                int length = strTrim.length();
                if (length == 4) {
                    if (J(strTrim)) {
                        return Boolean.TRUE;
                    }
                } else if (length == 5 && G(strTrim)) {
                    return Boolean.FALSE;
                }
                if (!x(deserializationContext, strTrim)) {
                    deserializationContext.G(cls, strTrim, "only \"true\" or \"false\" recognized", new Object[0]);
                    throw null;
                }
            }
        } else {
            if (iP == 7) {
                return y(jsonParser, deserializationContext, cls);
            }
            switch (iP) {
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    break;
                default:
                    deserializationContext.C(cls, jsonParser);
                    throw null;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        if (J(r7) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        if (G(r7) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean L(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws com.fasterxml.jackson.databind.exc.MismatchedInputException {
        /*
            r6 = this;
            int r0 = r7.P()
            r1 = 0
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r3 = 1
            if (r0 == r3) goto L85
            r4 = 3
            if (r0 == r4) goto L6e
            r4 = 6
            r5 = 0
            if (r0 == r4) goto L27
            r4 = 7
            if (r0 == r4) goto L1c
            switch(r0) {
                case 9: goto L4f;
                case 10: goto L59;
                case 11: goto L18;
                default: goto L17;
            }
        L17:
            goto L81
        L18:
            r6.Z(r8)
            return r5
        L1c:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r6 = r6.y(r7, r8, r2)
            boolean r6 = r0.equals(r6)
            return r6
        L27:
            java.lang.String r7 = r7.V0()
            com.fasterxml.jackson.databind.type.LogicalType r0 = com.fasterxml.jackson.databind.type.LogicalType.f4434k
            com.fasterxml.jackson.databind.cfg.CoercionAction r0 = r6.w(r8, r7, r0, r2)
            com.fasterxml.jackson.databind.cfg.CoercionAction r4 = com.fasterxml.jackson.databind.cfg.CoercionAction.f3798c
            if (r0 != r4) goto L39
            r6.Z(r8)
            return r5
        L39:
            com.fasterxml.jackson.databind.cfg.CoercionAction r4 = com.fasterxml.jackson.databind.cfg.CoercionAction.f3799d
            if (r0 != r4) goto L3e
            goto L59
        L3e:
            java.lang.String r7 = r7.trim()
            int r0 = r7.length()
            r4 = 4
            if (r0 != r4) goto L50
            boolean r0 = J(r7)
            if (r0 == 0) goto L5a
        L4f:
            return r3
        L50:
            r3 = 5
            if (r0 != r3) goto L5a
            boolean r0 = G(r7)
            if (r0 == 0) goto L5a
        L59:
            return r5
        L5a:
            java.lang.String r0 = "null"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L66
            r6.a0(r8, r7)
            return r5
        L66:
            java.lang.String r6 = "only \"true\"/\"True\"/\"TRUE\" or \"false\"/\"False\"/\"FALSE\" recognized"
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r8.G(r2, r7, r6, r0)
            throw r1
        L6e:
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS
            boolean r0 = r8.J(r0)
            if (r0 == 0) goto L81
            r7.q1()
            boolean r0 = r6.L(r7, r8)
            r6.Y(r7, r8)
            return r0
        L81:
            r8.C(r2, r7)
            throw r1
        L85:
            r8.C(r2, r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer.L(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):boolean");
    }

    public final byte M(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        Class<?> cls = this.f4054a;
        int iP = jsonParser.P();
        Class cls2 = Byte.TYPE;
        if (iP == 1) {
            deserializationContext.C(cls2, jsonParser);
            throw null;
        }
        if (iP != 3) {
            if (iP == 11) {
                Z(deserializationContext);
                return (byte) 0;
            }
            CoercionAction coercionAction = CoercionAction.f3799d;
            CoercionAction coercionAction2 = CoercionAction.f3798c;
            if (iP == 6) {
                String strV0 = jsonParser.V0();
                CoercionAction coercionActionW = w(deserializationContext, strV0, LogicalType.h, cls2);
                if (coercionActionW != coercionAction2 && coercionActionW != coercionAction) {
                    String strTrim = strV0.trim();
                    if ("null".equals(strTrim)) {
                        a0(deserializationContext, strTrim);
                        return (byte) 0;
                    }
                    try {
                        int iC = d.c(strTrim);
                        if (iC >= -128 && iC <= 255) {
                            return (byte) iC;
                        }
                        deserializationContext.G(cls, strTrim, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                        throw null;
                    } catch (IllegalArgumentException unused) {
                        deserializationContext.G(cls, strTrim, "not a valid `byte` value", new Object[0]);
                        throw null;
                    }
                }
            } else {
                if (iP == 7) {
                    return jsonParser.c0();
                }
                if (iP == 8) {
                    CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls2);
                    if (coercionActionU != coercionAction2 && coercionActionU != coercionAction) {
                        return jsonParser.c0();
                    }
                }
            }
            return (byte) 0;
        }
        if (deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.q1();
            byte bM = M(jsonParser, deserializationContext);
            Y(jsonParser, deserializationContext);
            return bM;
        }
        deserializationContext.A(jsonParser, deserializationContext.k(cls2));
        throw null;
    }

    public Date N(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        int iP = jsonParser.P();
        Class<?> cls = this.f4054a;
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP == 3) {
            CoercionAction coercionActionM = deserializationContext.m(o(), m(), CoercionInputShape.f3808d);
            boolean zJ = deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
            if (zJ || coercionActionM != CoercionAction.f3796a) {
                if (jsonParser.q1() == JsonToken.END_ARRAY) {
                    int iOrdinal = coercionActionM.ordinal();
                    if (iOrdinal == 1 || iOrdinal == 2) {
                        return (Date) a(deserializationContext);
                    }
                    if (iOrdinal == 3) {
                        return (Date) j(deserializationContext);
                    }
                } else if (zJ) {
                    Date dateN = N(jsonParser, deserializationContext);
                    Y(jsonParser, deserializationContext);
                    return dateN;
                }
            }
            deserializationContext.B(deserializationContext.k(cls), JsonToken.START_ARRAY, jsonParser, null, new Object[0]);
            throw null;
        }
        if (iP == 11) {
            return (Date) a(deserializationContext);
        }
        if (iP != 6) {
            if (iP != 7) {
                deserializationContext.C(cls, jsonParser);
                throw null;
            }
            try {
                return new Date(jsonParser.N0());
            } catch (JsonParseException | InputCoercionException unused) {
                deserializationContext.F(cls, jsonParser.P0(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0]);
                throw null;
            }
        }
        String strTrim = jsonParser.V0().trim();
        try {
            if (strTrim.isEmpty()) {
                if (v(deserializationContext, strTrim).ordinal() == 3) {
                    return new Date(0L);
                }
            } else if (!"null".equals(strTrim)) {
                return deserializationContext.M(strTrim);
            }
            return null;
        } catch (IllegalArgumentException e10) {
            deserializationContext.G(cls, strTrim, "not a valid representation (error: %s)", a.i(e10));
            throw null;
        }
    }

    public final double O(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        int iP = jsonParser.P();
        Class cls = Double.TYPE;
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP != 3) {
            if (iP == 11) {
                Z(deserializationContext);
                return 0.0d;
            }
            if (iP == 6) {
                String strV0 = jsonParser.V0();
                Double dS = s(strV0);
                if (dS != null) {
                    return dS.doubleValue();
                }
                CoercionAction coercionActionW = w(deserializationContext, strV0, LogicalType.h, cls);
                if (coercionActionW == CoercionAction.f3798c || coercionActionW == CoercionAction.f3799d) {
                    return 0.0d;
                }
                String strTrim = strV0.trim();
                if ("null".equals(strTrim)) {
                    a0(deserializationContext, strTrim);
                    return 0.0d;
                }
                try {
                    if ("2.2250738585072012e-308".equals(strTrim)) {
                        return Double.MIN_NORMAL;
                    }
                    return Double.parseDouble(strTrim);
                } catch (IllegalArgumentException unused) {
                    deserializationContext.G(cls, strTrim, "not a valid `double` value (as String to convert)", new Object[0]);
                    throw null;
                }
            }
            if (iP == 7 || iP == 8) {
                return jsonParser.J0();
            }
        } else if (deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.q1();
            double dO = O(jsonParser, deserializationContext);
            Y(jsonParser, deserializationContext);
            return dO;
        }
        deserializationContext.C(cls, jsonParser);
        throw null;
    }

    public final float P(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        int iP = jsonParser.P();
        Class cls = Float.TYPE;
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP != 3) {
            if (iP == 11) {
                Z(deserializationContext);
                return 0.0f;
            }
            if (iP == 6) {
                String strV0 = jsonParser.V0();
                Float fT = t(strV0);
                if (fT != null) {
                    return fT.floatValue();
                }
                CoercionAction coercionActionW = w(deserializationContext, strV0, LogicalType.h, cls);
                if (coercionActionW == CoercionAction.f3798c || coercionActionW == CoercionAction.f3799d) {
                    return 0.0f;
                }
                String strTrim = strV0.trim();
                if ("null".equals(strTrim)) {
                    a0(deserializationContext, strTrim);
                    return 0.0f;
                }
                try {
                    return Float.parseFloat(strTrim);
                } catch (IllegalArgumentException unused) {
                    deserializationContext.G(cls, strTrim, "not a valid `float` value", new Object[0]);
                    throw null;
                }
            }
            if (iP == 7 || iP == 8) {
                return jsonParser.L0();
            }
        } else if (deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.q1();
            float fP = P(jsonParser, deserializationContext);
            Y(jsonParser, deserializationContext);
            return fP;
        }
        deserializationContext.C(cls, jsonParser);
        throw null;
    }

    public final int Q(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        int iP = jsonParser.P();
        Class cls = Integer.TYPE;
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP != 3) {
            if (iP == 11) {
                Z(deserializationContext);
                return 0;
            }
            CoercionAction coercionAction = CoercionAction.f3799d;
            CoercionAction coercionAction2 = CoercionAction.f3798c;
            if (iP == 6) {
                String strV0 = jsonParser.V0();
                CoercionAction coercionActionW = w(deserializationContext, strV0, LogicalType.h, cls);
                if (coercionActionW != coercionAction2 && coercionActionW != coercionAction) {
                    String strTrim = strV0.trim();
                    if (!"null".equals(strTrim)) {
                        return R(deserializationContext, strTrim);
                    }
                    a0(deserializationContext, strTrim);
                    return 0;
                }
            } else {
                if (iP == 7) {
                    return jsonParser.M0();
                }
                if (iP == 8) {
                    CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls);
                    if (coercionActionU != coercionAction2 && coercionActionU != coercionAction) {
                        return jsonParser.b1();
                    }
                }
            }
            return 0;
        }
        if (deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.q1();
            int iQ = Q(jsonParser, deserializationContext);
            Y(jsonParser, deserializationContext);
            return iQ;
        }
        deserializationContext.C(cls, jsonParser);
        throw null;
    }

    public final Integer S(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws MismatchedInputException {
        int iP = jsonParser.P();
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP == 3) {
            return (Integer) B(jsonParser, deserializationContext);
        }
        if (iP == 11) {
            return (Integer) a(deserializationContext);
        }
        CoercionAction coercionAction = CoercionAction.f3799d;
        CoercionAction coercionAction2 = CoercionAction.f3798c;
        if (iP != 6) {
            if (iP == 7) {
                return Integer.valueOf(jsonParser.M0());
            }
            if (iP == 8) {
                CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls);
                return coercionActionU == coercionAction2 ? (Integer) a(deserializationContext) : coercionActionU == coercionAction ? (Integer) j(deserializationContext) : Integer.valueOf(jsonParser.b1());
            }
            deserializationContext.A(jsonParser, g0(deserializationContext));
            throw null;
        }
        String strV0 = jsonParser.V0();
        CoercionAction coercionActionV = v(deserializationContext, strV0);
        if (coercionActionV == coercionAction2) {
            return (Integer) a(deserializationContext);
        }
        if (coercionActionV == coercionAction) {
            return (Integer) j(deserializationContext);
        }
        String strTrim = strV0.trim();
        return x(deserializationContext, strTrim) ? (Integer) a(deserializationContext) : Integer.valueOf(R(deserializationContext, strTrim));
    }

    public final Long T(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws MismatchedInputException {
        int iP = jsonParser.P();
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP == 3) {
            return (Long) B(jsonParser, deserializationContext);
        }
        if (iP == 11) {
            return (Long) a(deserializationContext);
        }
        CoercionAction coercionAction = CoercionAction.f3799d;
        CoercionAction coercionAction2 = CoercionAction.f3798c;
        if (iP != 6) {
            if (iP == 7) {
                return Long.valueOf(jsonParser.N0());
            }
            if (iP == 8) {
                CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls);
                return coercionActionU == coercionAction2 ? (Long) a(deserializationContext) : coercionActionU == coercionAction ? (Long) j(deserializationContext) : Long.valueOf(jsonParser.d1());
            }
            deserializationContext.A(jsonParser, g0(deserializationContext));
            throw null;
        }
        String strV0 = jsonParser.V0();
        CoercionAction coercionActionV = v(deserializationContext, strV0);
        if (coercionActionV == coercionAction2) {
            return (Long) a(deserializationContext);
        }
        if (coercionActionV == coercionAction) {
            return (Long) j(deserializationContext);
        }
        String strTrim = strV0.trim();
        if (x(deserializationContext, strTrim)) {
            return (Long) a(deserializationContext);
        }
        try {
            String str = d.f13725a;
            return Long.valueOf(strTrim.length() <= 9 ? d.c(strTrim) : Long.parseLong(strTrim));
        } catch (IllegalArgumentException unused) {
            deserializationContext.G(Long.TYPE, strTrim, "not a valid `long` value", new Object[0]);
            throw null;
        }
    }

    public final long U(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        int iP = jsonParser.P();
        Class cls = Long.TYPE;
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP != 3) {
            if (iP == 11) {
                Z(deserializationContext);
                return 0L;
            }
            CoercionAction coercionAction = CoercionAction.f3799d;
            CoercionAction coercionAction2 = CoercionAction.f3798c;
            if (iP == 6) {
                String strV0 = jsonParser.V0();
                CoercionAction coercionActionW = w(deserializationContext, strV0, LogicalType.h, cls);
                if (coercionActionW != coercionAction2 && coercionActionW != coercionAction) {
                    String strTrim = strV0.trim();
                    if ("null".equals(strTrim)) {
                        a0(deserializationContext, strTrim);
                        return 0L;
                    }
                    try {
                        String str = d.f13725a;
                        return strTrim.length() <= 9 ? d.c(strTrim) : Long.parseLong(strTrim);
                    } catch (IllegalArgumentException unused) {
                        deserializationContext.G(cls, strTrim, "not a valid `long` value", new Object[0]);
                        throw null;
                    }
                }
            } else {
                if (iP == 7) {
                    return jsonParser.N0();
                }
                if (iP == 8) {
                    CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls);
                    if (coercionActionU != coercionAction2 && coercionActionU != coercionAction) {
                        return jsonParser.d1();
                    }
                }
            }
            return 0L;
        }
        if (deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.q1();
            long jU = U(jsonParser, deserializationContext);
            Y(jsonParser, deserializationContext);
            return jU;
        }
        deserializationContext.C(cls, jsonParser);
        throw null;
    }

    public final short V(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        int iP = jsonParser.P();
        Class cls = Short.TYPE;
        if (iP == 1) {
            deserializationContext.C(cls, jsonParser);
            throw null;
        }
        if (iP != 3) {
            if (iP == 11) {
                Z(deserializationContext);
                return (short) 0;
            }
            CoercionAction coercionAction = CoercionAction.f3799d;
            CoercionAction coercionAction2 = CoercionAction.f3798c;
            if (iP == 6) {
                String strV0 = jsonParser.V0();
                CoercionAction coercionActionW = w(deserializationContext, strV0, LogicalType.h, cls);
                if (coercionActionW != coercionAction2 && coercionActionW != coercionAction) {
                    String strTrim = strV0.trim();
                    if ("null".equals(strTrim)) {
                        a0(deserializationContext, strTrim);
                        return (short) 0;
                    }
                    try {
                        int iC = d.c(strTrim);
                        if (iC >= -32768 && iC <= 32767) {
                            return (short) iC;
                        }
                        deserializationContext.G(cls, strTrim, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                        throw null;
                    } catch (IllegalArgumentException unused) {
                        deserializationContext.G(cls, strTrim, "not a valid `short` value", new Object[0]);
                        throw null;
                    }
                }
            } else {
                if (iP == 7) {
                    return jsonParser.U0();
                }
                if (iP == 8) {
                    CoercionAction coercionActionU = u(jsonParser, deserializationContext, cls);
                    if (coercionActionU != coercionAction2 && coercionActionU != coercionAction) {
                        return jsonParser.U0();
                    }
                }
            }
            return (short) 0;
        }
        if (deserializationContext.J(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.q1();
            short sV = V(jsonParser, deserializationContext);
            Y(jsonParser, deserializationContext);
            return sV;
        }
        deserializationContext.A(jsonParser, deserializationContext.k(cls));
        throw null;
    }

    public final String W(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        if (jsonParser.i1(JsonToken.VALUE_STRING)) {
            return jsonParser.V0();
        }
        if (jsonParser.i1(JsonToken.VALUE_EMBEDDED_OBJECT)) {
            Object objK0 = jsonParser.K0();
            if (objK0 instanceof byte[]) {
                return deserializationContext.f3663c.f3828b.f3795k.e((byte[]) objK0);
            }
            if (objK0 == null) {
                return null;
            }
            return objK0.toString();
        }
        if (jsonParser.i1(JsonToken.START_OBJECT)) {
            deserializationContext.C(this.f4054a, jsonParser);
            throw null;
        }
        String strF1 = jsonParser.f1();
        if (strF1 != null) {
            return strF1;
        }
        deserializationContext.C(String.class, jsonParser);
        throw null;
    }

    public final void X(DeserializationContext deserializationContext, boolean z, Enum<?> r52, String str) throws MismatchedInputException {
        deserializationContext.P(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", str, A(), z ? "enable" : "disable", r52.getDeclaringClass().getSimpleName(), r52.name());
        throw null;
    }

    public final void Y(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        if (jsonParser.q1() == JsonToken.END_ARRAY) {
            return;
        }
        h0(deserializationContext);
        throw null;
    }

    public final void Z(DeserializationContext deserializationContext) throws MismatchedInputException {
        if (deserializationContext.J(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            deserializationContext.P(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", A());
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a0(DeserializationContext deserializationContext, String str) throws MismatchedInputException {
        boolean z;
        DeserializationFeature deserializationFeature;
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (deserializationContext.f3663c.k(mapperFeature)) {
            DeserializationFeature deserializationFeature2 = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
            if (!deserializationContext.J(deserializationFeature2)) {
                return;
            }
            z = false;
            deserializationFeature = deserializationFeature2;
        } else {
            z = true;
            deserializationFeature = mapperFeature;
        }
        X(deserializationContext, z, deserializationFeature, str.isEmpty() ? "empty String (\"\")" : a0.a.k("String \"", str, "\""));
        throw null;
    }

    public ValueInstantiator e0() {
        return null;
    }

    @Override // b3.c
    public Object f(JsonParser jsonParser, DeserializationContext deserializationContext, k3.b bVar) {
        return bVar.b(jsonParser, deserializationContext);
    }

    public JavaType f0() {
        return this.f4055b;
    }

    public final JavaType g0(DeserializationContext deserializationContext) {
        JavaType javaType = this.f4055b;
        return javaType != null ? javaType : deserializationContext.k(this.f4054a);
    }

    public final void h0(DeserializationContext deserializationContext) throws MismatchedInputException {
        deserializationContext.T(this, JsonToken.END_ARRAY, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", m().getName());
        throw null;
    }

    public void i0(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws UnrecognizedPropertyException {
        if (obj == null) {
            obj = m();
        }
        deserializationContext.f3663c.getClass();
        for (l lVar = null; lVar != null; lVar = (l) lVar.h) {
            ((e) lVar.f887g).getClass();
        }
        if (!deserializationContext.J(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            jsonParser.v1();
            return;
        }
        Collection<Object> collectionK = k();
        b bVar = deserializationContext.h;
        int i10 = UnrecognizedPropertyException.f4107j;
        UnrecognizedPropertyException unrecognizedPropertyException = new UnrecognizedPropertyException(bVar, h0.e.c("Unrecognized field \"", str, "\" (class ", (obj instanceof Class ? obj : obj.getClass()).getName(), "), not marked as ignorable"), bVar.x0(), collectionK);
        unrecognizedPropertyException.f(new JsonMappingException.Reference(obj, str));
        throw unrecognizedPropertyException;
    }

    @Override // b3.c
    public Class<?> m() {
        return this.f4054a;
    }

    public final void r(DeserializationContext deserializationContext, CoercionAction coercionAction, Serializable serializable, String str) throws InvalidFormatException {
        if (coercionAction != CoercionAction.f3796a) {
            return;
        }
        Object[] objArr = {str, A()};
        deserializationContext.getClass();
        throw new InvalidFormatException(deserializationContext.h, String.format("Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", objArr), serializable);
    }

    public final CoercionAction u(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws InvalidFormatException {
        CoercionAction coercionActionM = deserializationContext.m(LogicalType.h, cls, CoercionInputShape.f3806b);
        if (coercionActionM == CoercionAction.f3796a) {
            r(deserializationContext, coercionActionM, jsonParser.P0(), "Floating-point value (" + jsonParser.V0() + ")");
        }
        return coercionActionM;
    }

    public final CoercionAction v(DeserializationContext deserializationContext, String str) {
        return w(deserializationContext, str, o(), m());
    }

    public final CoercionAction w(DeserializationContext deserializationContext, String str, LogicalType logicalType, Class<?> cls) throws MismatchedInputException {
        if (str.isEmpty()) {
            CoercionAction coercionActionM = deserializationContext.m(logicalType, cls, CoercionInputShape.f3809e);
            r(deserializationContext, coercionActionM, str, "empty String (\"\")");
            return coercionActionM;
        }
        if (F(str)) {
            CoercionAction coercionActionN = deserializationContext.n(logicalType, cls);
            r(deserializationContext, coercionActionN, str, "blank String (all whitespace)");
            return coercionActionN;
        }
        if (deserializationContext.I(StreamReadCapability.UNTYPED_SCALARS)) {
            return CoercionAction.f3797b;
        }
        CoercionAction coercionActionM2 = deserializationContext.m(logicalType, cls, CoercionInputShape.f3807c);
        if (coercionActionM2 != CoercionAction.f3796a) {
            return coercionActionM2;
        }
        deserializationContext.P(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", str, A());
        throw null;
    }

    public final boolean x(DeserializationContext deserializationContext, String str) throws MismatchedInputException {
        if (!"null".equals(str)) {
            return false;
        }
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (deserializationContext.f3663c.k(mapperFeature)) {
            return true;
        }
        X(deserializationContext, true, mapperFeature, "String \"null\"");
        throw null;
    }

    public final Boolean y(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws InvalidFormatException {
        CoercionAction coercionActionM = deserializationContext.m(LogicalType.f4434k, cls, CoercionInputShape.f3805a);
        int iOrdinal = coercionActionM.ordinal();
        if (iOrdinal == 0) {
            r(deserializationContext, coercionActionM, jsonParser.P0(), "Integer value (" + jsonParser.V0() + ")");
            return Boolean.FALSE;
        }
        if (iOrdinal == 2) {
            return null;
        }
        if (iOrdinal == 3) {
            return Boolean.FALSE;
        }
        if (jsonParser.O0() == JsonParser.NumberType.f3574a) {
            return Boolean.valueOf(jsonParser.M0() != 0);
        }
        return Boolean.valueOf(!"0".equals(jsonParser.V0()));
    }

    public StdDeserializer(JavaType javaType) {
        Class<?> cls;
        if (javaType == null) {
            cls = Object.class;
        } else {
            cls = javaType.f3690a;
        }
        this.f4054a = cls;
        this.f4055b = javaType;
    }

    public StdDeserializer(StdDeserializer<?> stdDeserializer) {
        this.f4054a = stdDeserializer.f4054a;
        this.f4055b = stdDeserializer.f4055b;
    }
}
