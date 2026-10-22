package q3;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p extends JsonGenerator {

    /* renamed from: s, reason: collision with root package name */
    public static final int f11579s;

    /* renamed from: b, reason: collision with root package name */
    public final v2.c f11580b;

    /* renamed from: c, reason: collision with root package name */
    public final v2.b f11581c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11582d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11583e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11584j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f11585k;

    /* renamed from: l, reason: collision with root package name */
    public final b f11586l;

    /* renamed from: m, reason: collision with root package name */
    public b f11587m;

    /* renamed from: n, reason: collision with root package name */
    public int f11588n;

    /* renamed from: o, reason: collision with root package name */
    public Object f11589o;

    /* renamed from: p, reason: collision with root package name */
    public Object f11590p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11591q;
    public y2.d r;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends w2.c {

        /* renamed from: p, reason: collision with root package name */
        public final v2.c f11592p;

        /* renamed from: q, reason: collision with root package name */
        public final boolean f11593q;
        public final boolean r;

        /* renamed from: s, reason: collision with root package name */
        public b f11594s;

        /* renamed from: t, reason: collision with root package name */
        public int f11595t;

        /* renamed from: u, reason: collision with root package name */
        public q f11596u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f11597v;

        /* renamed from: w, reason: collision with root package name */
        public transient a3.c f11598w;

        /* renamed from: x, reason: collision with root package name */
        public JsonLocation f11599x;

        public a(b bVar, v2.c cVar, boolean z, boolean z3, v2.b bVar2) {
            super(0);
            this.f11599x = null;
            this.f11594s = bVar;
            this.f11595t = -1;
            this.f11592p = cVar;
            this.f11596u = bVar2 == null ? new q() : new q(bVar2, (JsonLocation) null);
            this.f11593q = z;
            this.r = z3;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final String C() {
            JsonToken jsonToken = this.f13576c;
            return (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) ? this.f11596u.f11605c.a() : this.f11596u.f11607e;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final BigDecimal I0() throws JsonParseException {
            Number numberP0 = P0();
            if (numberP0 instanceof BigDecimal) {
                return (BigDecimal) numberP0;
            }
            int iOrdinal = O0().ordinal();
            return (iOrdinal == 0 || iOrdinal == 1) ? BigDecimal.valueOf(numberP0.longValue()) : iOrdinal != 2 ? BigDecimal.valueOf(numberP0.doubleValue()) : new BigDecimal((BigInteger) numberP0);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final double J0() {
            return P0().doubleValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final Object K0() {
            if (this.f13576c == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return K1();
            }
            return null;
        }

        public final Object K1() {
            b bVar = this.f11594s;
            return bVar.f11603c[this.f11595t];
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final float L0() {
            return P0().floatValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final int M0() {
            Number numberP0 = this.f13576c == JsonToken.VALUE_NUMBER_INT ? (Number) K1() : P0();
            if ((numberP0 instanceof Integer) || (numberP0 instanceof Short) || (numberP0 instanceof Byte)) {
                return numberP0.intValue();
            }
            if (numberP0 instanceof Long) {
                long jLongValue = numberP0.longValue();
                int i10 = (int) jLongValue;
                if (i10 == jLongValue) {
                    return i10;
                }
                G1();
                throw null;
            }
            if (numberP0 instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) numberP0;
                if (w2.c.f13569e.compareTo(bigInteger) > 0 || w2.c.h.compareTo(bigInteger) < 0) {
                    G1();
                    throw null;
                }
            } else {
                if ((numberP0 instanceof Double) || (numberP0 instanceof Float)) {
                    double dDoubleValue = numberP0.doubleValue();
                    if (dDoubleValue >= -2.147483648E9d && dDoubleValue <= 2.147483647E9d) {
                        return (int) dDoubleValue;
                    }
                    G1();
                    throw null;
                }
                if (!(numberP0 instanceof BigDecimal)) {
                    a3.k.a();
                    throw null;
                }
                BigDecimal bigDecimal = (BigDecimal) numberP0;
                if (w2.c.f13574n.compareTo(bigDecimal) > 0 || w2.c.f13575o.compareTo(bigDecimal) < 0) {
                    G1();
                    throw null;
                }
            }
            return numberP0.intValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final long N0() {
            Number numberP0 = this.f13576c == JsonToken.VALUE_NUMBER_INT ? (Number) K1() : P0();
            if ((numberP0 instanceof Long) || (numberP0 instanceof Integer) || (numberP0 instanceof Short) || (numberP0 instanceof Byte)) {
                return numberP0.longValue();
            }
            if (numberP0 instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) numberP0;
                if (w2.c.f13570j.compareTo(bigInteger) > 0 || w2.c.f13571k.compareTo(bigInteger) < 0) {
                    H1();
                    throw null;
                }
            } else {
                if ((numberP0 instanceof Double) || (numberP0 instanceof Float)) {
                    double dDoubleValue = numberP0.doubleValue();
                    if (dDoubleValue >= -9.223372036854776E18d && dDoubleValue <= 9.223372036854776E18d) {
                        return (long) dDoubleValue;
                    }
                    H1();
                    throw null;
                }
                if (!(numberP0 instanceof BigDecimal)) {
                    a3.k.a();
                    throw null;
                }
                BigDecimal bigDecimal = (BigDecimal) numberP0;
                if (w2.c.f13572l.compareTo(bigDecimal) > 0 || w2.c.f13573m.compareTo(bigDecimal) < 0) {
                    H1();
                    throw null;
                }
            }
            return numberP0.longValue();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final JsonParser.NumberType O0() throws JsonParseException {
            Number numberP0 = P0();
            boolean z = numberP0 instanceof Integer;
            JsonParser.NumberType numberType = JsonParser.NumberType.f3574a;
            if (z) {
                return numberType;
            }
            if (numberP0 instanceof Long) {
                return JsonParser.NumberType.f3575b;
            }
            if (numberP0 instanceof Double) {
                return JsonParser.NumberType.f3578e;
            }
            if (numberP0 instanceof BigDecimal) {
                return JsonParser.NumberType.h;
            }
            if (numberP0 instanceof BigInteger) {
                return JsonParser.NumberType.f3576c;
            }
            if (numberP0 instanceof Float) {
                return JsonParser.NumberType.f3577d;
            }
            if (numberP0 instanceof Short) {
                return numberType;
            }
            return null;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final Number P0() throws JsonParseException {
            JsonToken jsonToken = this.f13576c;
            if (jsonToken == null || !jsonToken.f3599j) {
                throw new JsonParseException(this, "Current token (" + this.f13576c + ") not numeric, cannot use numeric value accessors");
            }
            Object objK1 = K1();
            if (objK1 instanceof Number) {
                return (Number) objK1;
            }
            if (objK1 instanceof String) {
                String str = (String) objK1;
                return str.indexOf(46) >= 0 ? Double.valueOf(Double.parseDouble(str)) : Long.valueOf(Long.parseLong(str));
            }
            if (objK1 == null) {
                return null;
            }
            throw new IllegalStateException("Internal error: entry should be a Number, but is of type ".concat(objK1.getClass().getName()));
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final BigInteger Q() throws JsonParseException {
            Number numberP0 = P0();
            return numberP0 instanceof BigInteger ? (BigInteger) numberP0 : O0() == JsonParser.NumberType.h ? ((BigDecimal) numberP0).toBigInteger() : BigInteger.valueOf(numberP0.longValue());
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final Object R0() {
            return this.f11594s.c(this.f11595t);
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final byte[] S(Base64Variant base64Variant) throws JsonParseException {
            if (this.f13576c == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object objK1 = K1();
                if (objK1 instanceof byte[]) {
                    return (byte[]) objK1;
                }
            }
            if (this.f13576c != JsonToken.VALUE_STRING) {
                throw new JsonParseException(this, "Current token (" + this.f13576c + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
            }
            String strV0 = V0();
            if (strV0 == null) {
                return null;
            }
            a3.c cVar = this.f11598w;
            if (cVar == null) {
                cVar = new a3.c((a3.a) null, 100);
                this.f11598w = cVar;
            } else {
                cVar.K();
            }
            try {
                base64Variant.b(strV0, cVar);
                return cVar.P();
            } catch (IllegalArgumentException e10) {
                A1(e10.getMessage());
                throw null;
            }
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final v2.b S0() {
            return this.f11596u;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final a3.f<StreamReadCapability> T0() {
            return JsonParser.f3557b;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final String V0() {
            JsonToken jsonToken = this.f13576c;
            if (jsonToken == JsonToken.VALUE_STRING || jsonToken == JsonToken.FIELD_NAME) {
                Object objK1 = K1();
                if (objK1 instanceof String) {
                    return (String) objK1;
                }
                Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
                if (objK1 == null) {
                    return null;
                }
                return objK1.toString();
            }
            if (jsonToken == null) {
                return null;
            }
            int iOrdinal = jsonToken.ordinal();
            if (iOrdinal != 8 && iOrdinal != 9) {
                return this.f13576c.f3594a;
            }
            Object objK12 = K1();
            Annotation[] annotationArr2 = com.fasterxml.jackson.databind.util.a.f4529a;
            if (objK12 == null) {
                return null;
            }
            return objK12.toString();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final char[] W0() {
            String strV0 = V0();
            if (strV0 == null) {
                return null;
            }
            return strV0.toCharArray();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final int X0() {
            String strV0 = V0();
            if (strV0 == null) {
                return 0;
            }
            return strV0.length();
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final int Y0() {
            return 0;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final boolean a() {
            return this.r;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final Object a1() {
            b bVar = this.f11594s;
            int i10 = this.f11595t;
            TreeMap<Integer, Object> treeMap = bVar.f11604d;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(i10 + i10));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f11597v) {
                return;
            }
            this.f11597v = true;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final v2.c g0() {
            return this.f11592p;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final boolean h1() {
            return false;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final boolean n1() {
            if (this.f13576c == JsonToken.VALUE_NUMBER_FLOAT) {
                Object objK1 = K1();
                if (objK1 instanceof Double) {
                    Double d8 = (Double) objK1;
                    return d8.isNaN() || d8.isInfinite();
                }
                if (objK1 instanceof Float) {
                    Float f8 = (Float) objK1;
                    return f8.isNaN() || f8.isInfinite();
                }
            }
            return false;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final boolean o() {
            return this.f11593q;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final String o1() {
            b bVar;
            if (this.f11597v || (bVar = this.f11594s) == null) {
                return null;
            }
            int i10 = this.f11595t + 1;
            if (i10 < 16) {
                JsonToken jsonTokenD = bVar.d(i10);
                JsonToken jsonToken = JsonToken.FIELD_NAME;
                if (jsonTokenD == jsonToken) {
                    this.f11595t = i10;
                    this.f13576c = jsonToken;
                    String str = this.f11594s.f11603c[i10];
                    String string = str instanceof String ? str : str.toString();
                    this.f11596u.f11607e = string;
                    return string;
                }
            }
            if (q1() == JsonToken.FIELD_NAME) {
                return C();
            }
            return null;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final JsonToken q1() {
            b bVar;
            if (this.f11597v || (bVar = this.f11594s) == null) {
                return null;
            }
            int i10 = this.f11595t + 1;
            this.f11595t = i10;
            if (i10 >= 16) {
                this.f11595t = 0;
                b bVar2 = bVar.f11601a;
                this.f11594s = bVar2;
                if (bVar2 == null) {
                    return null;
                }
            }
            JsonToken jsonTokenD = this.f11594s.d(this.f11595t);
            this.f13576c = jsonTokenD;
            if (jsonTokenD == JsonToken.FIELD_NAME) {
                Object objK1 = K1();
                this.f11596u.f11607e = objK1 instanceof String ? (String) objK1 : objK1.toString();
            } else if (jsonTokenD == JsonToken.START_OBJECT) {
                q qVar = this.f11596u;
                qVar.f13376b++;
                this.f11596u = new q(qVar, 2);
            } else if (jsonTokenD == JsonToken.START_ARRAY) {
                q qVar2 = this.f11596u;
                qVar2.f13376b++;
                this.f11596u = new q(qVar2, 1);
            } else if (jsonTokenD == JsonToken.END_OBJECT || jsonTokenD == JsonToken.END_ARRAY) {
                q qVar3 = this.f11596u;
                v2.b bVar3 = qVar3.f11605c;
                this.f11596u = bVar3 instanceof q ? (q) bVar3 : bVar3 == null ? new q() : new q(bVar3, qVar3.f11606d);
            } else {
                this.f11596u.f13376b++;
            }
            return this.f13576c;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final int s1(Base64Variant base64Variant, f fVar) throws JsonParseException {
            byte[] bArrS = S(base64Variant);
            if (bArrS == null) {
                return 0;
            }
            fVar.write(bArrS, 0, bArrS.length);
            return bArrS.length;
        }

        @Override // com.fasterxml.jackson.core.JsonParser
        public final JsonLocation x0() {
            JsonLocation jsonLocation = this.f11599x;
            return jsonLocation == null ? JsonLocation.h : jsonLocation;
        }

        @Override // w2.c
        public final void x1() {
            a3.k.a();
            throw null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: e, reason: collision with root package name */
        public static final JsonToken[] f11600e;

        /* renamed from: a, reason: collision with root package name */
        public b f11601a;

        /* renamed from: b, reason: collision with root package name */
        public long f11602b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f11603c = new Object[16];

        /* renamed from: d, reason: collision with root package name */
        public TreeMap<Integer, Object> f11604d;

        static {
            JsonToken[] jsonTokenArr = new JsonToken[16];
            f11600e = jsonTokenArr;
            JsonToken[] jsonTokenArrValues = JsonToken.values();
            System.arraycopy(jsonTokenArrValues, 1, jsonTokenArr, 1, Math.min(15, jsonTokenArrValues.length - 1));
        }

        public final b a(int i10, JsonToken jsonToken) {
            if (i10 >= 16) {
                b bVar = new b();
                this.f11601a = bVar;
                bVar.f11602b = jsonToken.ordinal() | bVar.f11602b;
                return this.f11601a;
            }
            long jOrdinal = jsonToken.ordinal();
            if (i10 > 0) {
                jOrdinal <<= i10 << 2;
            }
            this.f11602b |= jOrdinal;
            return null;
        }

        public final void b(int i10, Object obj, Object obj2) {
            if (this.f11604d == null) {
                this.f11604d = new TreeMap<>();
            }
            if (obj != null) {
                this.f11604d.put(Integer.valueOf(i10 + i10 + 1), obj);
            }
            if (obj2 != null) {
                this.f11604d.put(Integer.valueOf(i10 + i10), obj2);
            }
        }

        public final Object c(int i10) {
            TreeMap<Integer, Object> treeMap = this.f11604d;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(i10 + i10 + 1));
        }

        public final JsonToken d(int i10) {
            long j10 = this.f11602b;
            if (i10 > 0) {
                j10 >>= i10 << 2;
            }
            return f11600e[((int) j10) & 15];
        }
    }

    static {
        int i10 = 0;
        for (JsonGenerator.Feature feature : JsonGenerator.Feature.values()) {
            if (feature.f3550a) {
                i10 |= feature.f3551b;
            }
        }
        f11579s = i10;
    }

    public p() {
        this.f11591q = false;
        this.f11580b = null;
        this.f11582d = f11579s;
        this.r = new y2.d(0, null, null);
        b bVar = new b();
        this.f11587m = bVar;
        this.f11586l = bVar;
        this.f11588n = 0;
        this.f11583e = false;
        this.h = false;
        this.f11584j = false;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final boolean C() {
        return this.f11583e;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void C0() {
        b bVarA = this.f11587m.a(this.f11588n, JsonToken.END_ARRAY);
        if (bVarA == null) {
            this.f11588n++;
        } else {
            this.f11587m = bVarA;
            this.f11588n = 1;
        }
        y2.d dVar = this.r.f13985c;
        if (dVar != null) {
            this.r = dVar;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void G0() {
        b bVarA = this.f11587m.a(this.f11588n, JsonToken.END_OBJECT);
        if (bVarA == null) {
            this.f11588n++;
        } else {
            this.f11587m = bVarA;
            this.f11588n = 1;
        }
        y2.d dVar = this.r.f13985c;
        if (dVar != null) {
            this.r = dVar;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void H0(String str) throws JsonGenerationException {
        this.r.m(str);
        j1(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void I0(v2.e eVar) throws JsonGenerationException {
        this.r.m(eVar.getValue());
        j1(eVar);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void J0() {
        m1(JsonToken.VALUE_NULL);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final y2.d K() {
        return this.r;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void K0(double d8) {
        n1(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d8));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void L0(float f8) {
        n1(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f8));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void M0(int i10) {
        n1(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i10));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void N0(long j10) {
        n1(JsonToken.VALUE_NUMBER_INT, Long.valueOf(j10));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void O0(String str) {
        n1(JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final boolean P(JsonGenerator.Feature feature) {
        return (this.f11582d & feature.f3551b) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void P0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            J0();
        } else {
            n1(JsonToken.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void Q0(BigInteger bigInteger) {
        if (bigInteger == null) {
            J0();
        } else {
            n1(JsonToken.VALUE_NUMBER_INT, bigInteger);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void R0(short s8) {
        n1(JsonToken.VALUE_NUMBER_INT, Short.valueOf(s8));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final int S(Base64Variant base64Variant, e eVar, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void S0(Object obj) {
        this.f11590p = obj;
        this.f11591q = true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void T0(char c9) {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void U0(String str) {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void V0(v2.e eVar) {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void W0(char[] cArr, int i10) {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void X0(String str) {
        JsonToken jsonToken = JsonToken.VALUE_EMBEDDED_OBJECT;
        n nVar = new n();
        nVar.f11573a = str;
        n1(jsonToken, nVar);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void Z0() {
        this.r.n();
        l1(JsonToken.START_ARRAY);
        this.r = this.r.i();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void a1(Object obj) {
        this.r.n();
        l1(JsonToken.START_ARRAY);
        this.r = this.r.j(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void b1(Object obj) {
        this.r.n();
        l1(JsonToken.START_ARRAY);
        this.r = this.r.j(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void c0(Base64Variant base64Variant, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        writeObject(bArr2);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void c1() {
        this.r.n();
        l1(JsonToken.START_OBJECT);
        this.r = this.r.k();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void d1(Object obj) {
        this.r.n();
        l1(JsonToken.START_OBJECT);
        this.r = this.r.l(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void e1(Object obj) {
        this.r.n();
        l1(JsonToken.START_OBJECT);
        this.r = this.r.l(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void f1(String str) {
        if (str == null) {
            J0();
        } else {
            n1(JsonToken.VALUE_STRING, str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void g0(boolean z) {
        m1(z ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void g1(v2.e eVar) {
        if (eVar == null) {
            J0();
        } else {
            n1(JsonToken.VALUE_STRING, eVar);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void h1(char[] cArr, int i10, int i11) {
        f1(new String(cArr, i10, i11));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void i1(Object obj) {
        this.f11589o = obj;
        this.f11591q = true;
    }

    public final void j1(Object obj) {
        b bVar = null;
        if (this.f11591q) {
            b bVar2 = this.f11587m;
            int i10 = this.f11588n;
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            Object obj2 = this.f11590p;
            Object obj3 = this.f11589o;
            if (i10 < 16) {
                bVar2.f11603c[i10] = obj;
                long jOrdinal = jsonToken.ordinal();
                if (i10 > 0) {
                    jOrdinal <<= i10 << 2;
                }
                bVar2.f11602b = jOrdinal | bVar2.f11602b;
                bVar2.b(i10, obj2, obj3);
            } else {
                bVar2.getClass();
                b bVar3 = new b();
                bVar2.f11601a = bVar3;
                bVar3.f11603c[0] = obj;
                bVar3.f11602b = jsonToken.ordinal() | bVar3.f11602b;
                bVar3.b(0, obj2, obj3);
                bVar = bVar2.f11601a;
            }
        } else {
            b bVar4 = this.f11587m;
            int i11 = this.f11588n;
            JsonToken jsonToken2 = JsonToken.FIELD_NAME;
            if (i11 < 16) {
                bVar4.f11603c[i11] = obj;
                long jOrdinal2 = jsonToken2.ordinal();
                if (i11 > 0) {
                    jOrdinal2 <<= i11 << 2;
                }
                bVar4.f11602b |= jOrdinal2;
            } else {
                bVar4.getClass();
                b bVar5 = new b();
                bVar4.f11601a = bVar5;
                bVar5.f11603c[0] = obj;
                bVar5.f11602b = jsonToken2.ordinal() | bVar5.f11602b;
                bVar = bVar4.f11601a;
            }
        }
        if (bVar == null) {
            this.f11588n++;
        } else {
            this.f11587m = bVar;
            this.f11588n = 1;
        }
    }

    public final void k1(StringBuilder sb2) {
        Object objC = this.f11587m.c(this.f11588n - 1);
        if (objC != null) {
            sb2.append("[objectId=");
            sb2.append(String.valueOf(objC));
            sb2.append(']');
        }
        b bVar = this.f11587m;
        int i10 = this.f11588n - 1;
        TreeMap<Integer, Object> treeMap = bVar.f11604d;
        Object obj = treeMap == null ? null : treeMap.get(Integer.valueOf(i10 + i10));
        if (obj != null) {
            sb2.append("[typeId=");
            sb2.append(String.valueOf(obj));
            sb2.append(']');
        }
    }

    public final void l1(JsonToken jsonToken) {
        b bVarA;
        if (this.f11591q) {
            b bVar = this.f11587m;
            int i10 = this.f11588n;
            Object obj = this.f11590p;
            Object obj2 = this.f11589o;
            bVar.getClass();
            if (i10 < 16) {
                long jOrdinal = jsonToken.ordinal();
                if (i10 > 0) {
                    jOrdinal <<= i10 << 2;
                }
                bVar.f11602b = jOrdinal | bVar.f11602b;
                bVar.b(i10, obj, obj2);
                bVarA = null;
            } else {
                b bVar2 = new b();
                bVar.f11601a = bVar2;
                bVar2.f11602b = jsonToken.ordinal() | bVar2.f11602b;
                bVar2.b(0, obj, obj2);
                bVarA = bVar.f11601a;
            }
        } else {
            bVarA = this.f11587m.a(this.f11588n, jsonToken);
        }
        if (bVarA == null) {
            this.f11588n++;
        } else {
            this.f11587m = bVarA;
            this.f11588n = 1;
        }
    }

    public final void m1(JsonToken jsonToken) {
        b bVarA;
        this.r.n();
        if (this.f11591q) {
            b bVar = this.f11587m;
            int i10 = this.f11588n;
            Object obj = this.f11590p;
            Object obj2 = this.f11589o;
            bVar.getClass();
            if (i10 < 16) {
                long jOrdinal = jsonToken.ordinal();
                if (i10 > 0) {
                    jOrdinal <<= i10 << 2;
                }
                bVar.f11602b = jOrdinal | bVar.f11602b;
                bVar.b(i10, obj, obj2);
                bVarA = null;
            } else {
                b bVar2 = new b();
                bVar.f11601a = bVar2;
                bVar2.f11602b = jsonToken.ordinal() | bVar2.f11602b;
                bVar2.b(0, obj, obj2);
                bVarA = bVar.f11601a;
            }
        } else {
            bVarA = this.f11587m.a(this.f11588n, jsonToken);
        }
        if (bVarA == null) {
            this.f11588n++;
        } else {
            this.f11587m = bVarA;
            this.f11588n = 1;
        }
    }

    public final void n1(JsonToken jsonToken, Object obj) {
        this.r.n();
        b bVar = null;
        if (this.f11591q) {
            b bVar2 = this.f11587m;
            int i10 = this.f11588n;
            Object obj2 = this.f11590p;
            Object obj3 = this.f11589o;
            if (i10 < 16) {
                bVar2.f11603c[i10] = obj;
                long jOrdinal = jsonToken.ordinal();
                if (i10 > 0) {
                    jOrdinal <<= i10 << 2;
                }
                bVar2.f11602b = jOrdinal | bVar2.f11602b;
                bVar2.b(i10, obj2, obj3);
            } else {
                bVar2.getClass();
                b bVar3 = new b();
                bVar2.f11601a = bVar3;
                bVar3.f11603c[0] = obj;
                bVar3.f11602b = jsonToken.ordinal() | bVar3.f11602b;
                bVar3.b(0, obj2, obj3);
                bVar = bVar2.f11601a;
            }
        } else {
            b bVar4 = this.f11587m;
            int i11 = this.f11588n;
            if (i11 < 16) {
                bVar4.f11603c[i11] = obj;
                long jOrdinal2 = jsonToken.ordinal();
                if (i11 > 0) {
                    jOrdinal2 <<= i11 << 2;
                }
                bVar4.f11602b = jOrdinal2 | bVar4.f11602b;
            } else {
                bVar4.getClass();
                b bVar5 = new b();
                bVar4.f11601a = bVar5;
                bVar5.f11603c[0] = obj;
                bVar5.f11602b = jsonToken.ordinal() | bVar5.f11602b;
                bVar = bVar4.f11601a;
            }
        }
        if (bVar == null) {
            this.f11588n++;
        } else {
            this.f11587m = bVar;
            this.f11588n = 1;
        }
    }

    public final void o1(JsonParser jsonParser) {
        Object objA1 = jsonParser.a1();
        this.f11589o = objA1;
        if (objA1 != null) {
            this.f11591q = true;
        }
        Object objR0 = jsonParser.R0();
        this.f11590p = objR0;
        if (objR0 != null) {
            this.f11591q = true;
        }
    }

    public final void p1(JsonParser jsonParser) throws JsonGenerationException {
        int i10 = 1;
        while (true) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            if (jsonTokenQ1 == null) {
                return;
            }
            int iOrdinal = jsonTokenQ1.ordinal();
            if (iOrdinal == 1) {
                if (this.f11584j) {
                    o1(jsonParser);
                }
                c1();
            } else if (iOrdinal == 2) {
                G0();
                i10--;
                if (i10 == 0) {
                    return;
                }
            } else if (iOrdinal == 3) {
                if (this.f11584j) {
                    o1(jsonParser);
                }
                Z0();
            } else if (iOrdinal == 4) {
                C0();
                i10--;
                if (i10 == 0) {
                    return;
                }
            } else if (iOrdinal != 5) {
                q1(jsonParser, jsonTokenQ1);
            } else {
                if (this.f11584j) {
                    o1(jsonParser);
                }
                H0(jsonParser.C());
            }
            i10++;
        }
    }

    public final void q1(JsonParser jsonParser, JsonToken jsonToken) {
        if (this.f11584j) {
            o1(jsonParser);
        }
        switch (jsonToken.ordinal()) {
            case 6:
                writeObject(jsonParser.K0());
                return;
            case 7:
                if (jsonParser.h1()) {
                    h1(jsonParser.W0(), jsonParser.Y0(), jsonParser.X0());
                    return;
                } else {
                    f1(jsonParser.V0());
                    return;
                }
            case 8:
                int iOrdinal = jsonParser.O0().ordinal();
                if (iOrdinal == 0) {
                    M0(jsonParser.M0());
                    return;
                } else if (iOrdinal != 2) {
                    N0(jsonParser.N0());
                    return;
                } else {
                    Q0(jsonParser.Q());
                    return;
                }
            case 9:
                if (this.f11585k) {
                    P0(jsonParser.I0());
                    return;
                } else {
                    n1(JsonToken.VALUE_NUMBER_FLOAT, jsonParser.Q0());
                    return;
                }
            case 10:
                g0(true);
                return;
            case 11:
                g0(false);
                return;
            case 12:
                J0();
                return;
            default:
                throw new RuntimeException("Internal error: unexpected token: " + jsonToken);
        }
    }

    public final void r1(p pVar) throws JsonGenerationException {
        if (!this.f11583e) {
            this.f11583e = pVar.f11583e;
        }
        if (!this.h) {
            this.h = pVar.h;
        }
        this.f11584j = this.f11583e || this.h;
        a aVarT1 = pVar.t1(pVar.f11580b);
        while (aVarT1.q1() != null) {
            u1(aVarT1);
        }
    }

    public final a s1(JsonParser jsonParser) {
        a aVar = new a(this.f11586l, jsonParser.g0(), this.f11583e, this.h, this.f11581c);
        aVar.f11599x = jsonParser.Z0();
        return aVar;
    }

    public final a t1(v2.c cVar) {
        return new a(this.f11586l, cVar, this.f11583e, this.h, this.f11581c);
    }

    public final String toString() {
        StringBuilder sbB = v1.d.b("[TokenBuffer: ");
        a aVarT1 = t1(this.f11580b);
        int i10 = 0;
        boolean z = this.f11583e || this.h;
        while (true) {
            try {
                JsonToken jsonTokenQ1 = aVarT1.q1();
                if (jsonTokenQ1 == null) {
                    break;
                }
                if (z) {
                    k1(sbB);
                }
                if (i10 < 100) {
                    if (i10 > 0) {
                        sbB.append(", ");
                    }
                    sbB.append(jsonTokenQ1.toString());
                    if (jsonTokenQ1 == JsonToken.FIELD_NAME) {
                        sbB.append('(');
                        sbB.append(aVarT1.C());
                        sbB.append(')');
                    }
                }
                i10++;
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
        if (i10 >= 100) {
            sbB.append(" ... (truncated ");
            sbB.append(i10 - 100);
            sbB.append(" entries)");
        }
        sbB.append(']');
        return sbB.toString();
    }

    public final void u1(JsonParser jsonParser) throws JsonGenerationException {
        JsonToken jsonTokenK = jsonParser.K();
        if (jsonTokenK == JsonToken.FIELD_NAME) {
            if (this.f11584j) {
                o1(jsonParser);
            }
            H0(jsonParser.C());
            jsonTokenK = jsonParser.q1();
        } else if (jsonTokenK == null) {
            throw new IllegalStateException("No token available from argument `JsonParser`");
        }
        int iOrdinal = jsonTokenK.ordinal();
        if (iOrdinal == 1) {
            if (this.f11584j) {
                o1(jsonParser);
            }
            c1();
            p1(jsonParser);
            return;
        }
        if (iOrdinal == 2) {
            G0();
            return;
        }
        if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                q1(jsonParser, jsonTokenK);
                return;
            } else {
                C0();
                return;
            }
        }
        if (this.f11584j) {
            o1(jsonParser);
        }
        Z0();
        p1(jsonParser);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final boolean w() {
        return this.h;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeObject(Object obj) {
        if (obj == null) {
            J0();
            return;
        }
        if (obj.getClass() == byte[].class || (obj instanceof n)) {
            n1(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
            return;
        }
        v2.c cVar = this.f11580b;
        if (cVar == null) {
            n1(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
        } else {
            cVar.a(this, obj);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void x0(Object obj) {
        n1(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
    }

    public p(JsonParser jsonParser, DeserializationContext deserializationContext) {
        this.f11591q = false;
        this.f11580b = jsonParser.g0();
        this.f11581c = jsonParser.S0();
        this.f11582d = f11579s;
        this.r = new y2.d(0, null, null);
        b bVar = new b();
        this.f11587m = bVar;
        this.f11586l = bVar;
        this.f11588n = 0;
        this.f11583e = jsonParser.o();
        boolean zA = jsonParser.a();
        this.h = zA;
        this.f11584j = this.f11583e || zA;
        this.f11585k = deserializationContext != null ? deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) : false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public final void flush() {
    }
}
