package w2;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.stepos.core.ota.d;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c extends JsonParser {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f13568d = new byte[0];

    /* renamed from: e, reason: collision with root package name */
    public static final BigInteger f13569e;
    public static final BigInteger h;

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f13570j;

    /* renamed from: k, reason: collision with root package name */
    public static final BigInteger f13571k;

    /* renamed from: l, reason: collision with root package name */
    public static final BigDecimal f13572l;

    /* renamed from: m, reason: collision with root package name */
    public static final BigDecimal f13573m;

    /* renamed from: n, reason: collision with root package name */
    public static final BigDecimal f13574n;

    /* renamed from: o, reason: collision with root package name */
    public static final BigDecimal f13575o;

    /* renamed from: c, reason: collision with root package name */
    public JsonToken f13576c;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(-2147483648L);
        f13569e = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2147483647L);
        h = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        f13570j = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        f13571k = bigIntegerValueOf4;
        f13572l = new BigDecimal(bigIntegerValueOf3);
        f13573m = new BigDecimal(bigIntegerValueOf4);
        f13574n = new BigDecimal(bigIntegerValueOf);
        f13575o = new BigDecimal(bigIntegerValueOf2);
    }

    public c(int i10) {
        this.f3558a = i10;
    }

    public static final String w1(int i10) {
        char c9 = (char) i10;
        if (Character.isISOControl(c9)) {
            return ai.onnxruntime.a.g(i10, "(CTRL-CHAR, code ", ")");
        }
        if (i10 <= 255) {
            return "'" + c9 + "' (code " + i10 + ")";
        }
        return "'" + c9 + "' (code " + i10 + " / 0x" + Integer.toHexString(i10) + ")";
    }

    public static String y1(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith("-")) {
            length--;
        }
        return String.format("[Integer with %d digits]", Integer.valueOf(length));
    }

    public static String z1(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith("-")) {
            length--;
        }
        return String.format("[number with %d characters]", Integer.valueOf(length));
    }

    public final void A1(String str) {
        throw new JsonParseException(this, str);
    }

    public final void B1() {
        C1(" in " + this.f13576c);
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String C0() {
        return C();
    }

    public final void C1(String str) {
        throw new JsonEOFException(this, ai.onnxruntime.a.k("Unexpected end-of-input", str));
    }

    public final void D1(JsonToken jsonToken) {
        C1(jsonToken != JsonToken.VALUE_STRING ? (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? " in a Number value" : " in a value" : " in a String value");
        throw null;
    }

    public final void E1(int i10, String str) {
        if (i10 < 0) {
            B1();
            throw null;
        }
        String strK = a0.a.k("Unexpected character (", w1(i10), ")");
        if (str != null) {
            strK = d.i(strK, ": ", str);
        }
        A1(strK);
        throw null;
    }

    public final void F1(int i10) {
        A1("Illegal character (" + w1((char) i10) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonToken G0() {
        return this.f13576c;
    }

    public final void G1() {
        throw new InputCoercionException(this, String.format("Numeric value (%s) out of range of int (%d - %s)", y1(V0()), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public final int H0() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.f3597d;
    }

    public final void H1() {
        I1(V0());
        throw null;
    }

    public final void I1(String str) {
        throw new InputCoercionException(this, String.format("Numeric value (%s) out of range of long (%d - %s)", y1(str), Long.MIN_VALUE, Long.MAX_VALUE));
    }

    public final void J1(int i10, String str) {
        A1(a0.a.k("Unexpected character (", w1(i10), ") in numeric value") + ": " + str);
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonToken K() {
        return this.f13576c;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int P() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.f3597d;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation Z0() {
        return x0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int b1() {
        JsonToken jsonToken = this.f13576c;
        return (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? M0() : c1();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    @Override // com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c1() {
        /*
            r5 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r5.f13576c
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            if (r0 == r1) goto L7f
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT
            if (r0 != r1) goto Lc
            goto L7f
        Lc:
            r1 = 0
            if (r0 == 0) goto L7e
            int r0 = r0.f3597d
            r2 = 6
            r3 = 1
            if (r0 == r2) goto L2e
            r2 = 9
            if (r0 == r2) goto L2d
            r2 = 12
            if (r0 == r2) goto L1e
            goto L7e
        L1e:
            java.lang.Object r5 = r5.K0()
            boolean r0 = r5 instanceof java.lang.Number
            if (r0 == 0) goto L7e
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            return r5
        L2d:
            return r3
        L2e:
            java.lang.String r5 = r5.V0()
            java.lang.String r0 = "null"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L3b
            return r1
        L3b:
            java.lang.String r0 = x2.d.f13725a
            if (r5 != 0) goto L40
            goto L7e
        L40:
            java.lang.String r5 = r5.trim()
            int r0 = r5.length()
            if (r0 != 0) goto L4b
            goto L7e
        L4b:
            char r2 = r5.charAt(r1)
            r4 = 43
            if (r2 != r4) goto L5d
            java.lang.String r5 = r5.substring(r3)
            int r0 = r5.length()
        L5b:
            r3 = r1
            goto L61
        L5d:
            r4 = 45
            if (r2 != r4) goto L5b
        L61:
            if (r3 >= r0) goto L79
            char r2 = r5.charAt(r3)
            r4 = 57
            if (r2 > r4) goto L73
            r4 = 48
            if (r2 >= r4) goto L70
            goto L73
        L70:
            int r3 = r3 + 1
            goto L61
        L73:
            double r0 = x2.d.b(r5)     // Catch: java.lang.NumberFormatException -> L7e
            int r5 = (int) r0     // Catch: java.lang.NumberFormatException -> L7e
            return r5
        L79:
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L7e
            return r5
        L7e:
            return r1
        L7f:
            int r5 = r5.M0()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.c.c1():int");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final long d1() {
        JsonToken jsonToken = this.f13576c;
        return (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? N0() : e1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final long e1() {
        String strTrim;
        int length;
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return N0();
        }
        if (jsonToken != null) {
            int i10 = jsonToken.f3597d;
            if (i10 == 6) {
                String strV0 = V0();
                if ("null".equals(strV0)) {
                    return 0L;
                }
                String str = x2.d.f13725a;
                if (strV0 != null && (length = (strTrim = strV0.trim()).length()) != 0) {
                    int i11 = 0;
                    char cCharAt = strTrim.charAt(0);
                    if (cCharAt == '+') {
                        strTrim = strTrim.substring(1);
                        length = strTrim.length();
                    } else if (cCharAt == '-') {
                        i11 = 1;
                    }
                    while (i11 < length) {
                        try {
                            char cCharAt2 = strTrim.charAt(i11);
                            if (cCharAt2 > '9' || cCharAt2 < '0') {
                                return (long) x2.d.b(strTrim);
                            }
                            i11++;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return Long.parseLong(strTrim);
                }
            } else {
                if (i10 == 9) {
                    return 1L;
                }
                if (i10 == 12) {
                    Object objK0 = K0();
                    if (objK0 instanceof Number) {
                        return ((Number) objK0).longValue();
                    }
                }
            }
        }
        return 0L;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String f1() {
        return g1();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String g1() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return V0();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return C0();
        }
        if (jsonToken == null || jsonToken == JsonToken.VALUE_NULL || !jsonToken.f3600k) {
            return null;
        }
        return V0();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final boolean i1(JsonToken jsonToken) {
        return this.f13576c == jsonToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final boolean j1() {
        JsonToken jsonToken = this.f13576c;
        return jsonToken != null && jsonToken.f3597d == 5;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final boolean k1() {
        return this.f13576c == JsonToken.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final boolean l1() {
        return this.f13576c == JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final boolean m1() {
        return this.f13576c == JsonToken.START_OBJECT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonToken r1() {
        JsonToken jsonTokenQ1 = q1();
        return jsonTokenQ1 == JsonToken.FIELD_NAME ? q1() : jsonTokenQ1;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonParser v1() throws JsonParseException {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            int i10 = 1;
            while (true) {
                JsonToken jsonTokenQ1 = q1();
                if (jsonTokenQ1 == null) {
                    x1();
                    return this;
                }
                if (jsonTokenQ1.f3598e) {
                    i10++;
                } else if (jsonTokenQ1.h) {
                    i10--;
                    if (i10 == 0) {
                        break;
                    }
                } else if (jsonTokenQ1 == JsonToken.NOT_AVAILABLE) {
                    throw new JsonParseException(this, a0.a.k("Not enough content available for `skipChildren()`: non-blocking parser? (", getClass().getName(), ")"));
                }
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final void w() {
        if (this.f13576c != null) {
            this.f13576c = null;
        }
    }

    public abstract void x1();
}
