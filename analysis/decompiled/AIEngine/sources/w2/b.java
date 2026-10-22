package w2;

import a3.f;
import a3.i;
import a3.k;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.stepos.core.ota.d;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b extends c {
    public static final f<StreamReadCapability> O = JsonParser.f3557b;
    public JsonToken A;
    public final i B;
    public char[] C;
    public boolean D;
    public a3.c E;
    public byte[] F;
    public int G;
    public int H;
    public long I;
    public double J;
    public BigInteger K;
    public BigDecimal L;
    public boolean M;
    public int N;

    /* renamed from: p, reason: collision with root package name */
    public final x2.b f13559p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13560q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f13561s;

    /* renamed from: t, reason: collision with root package name */
    public long f13562t;

    /* renamed from: u, reason: collision with root package name */
    public int f13563u;

    /* renamed from: v, reason: collision with root package name */
    public int f13564v;

    /* renamed from: w, reason: collision with root package name */
    public long f13565w;

    /* renamed from: x, reason: collision with root package name */
    public int f13566x;

    /* renamed from: y, reason: collision with root package name */
    public int f13567y;
    public y2.c z;

    public b(x2.b bVar, int i10) {
        super(i10);
        this.f13563u = 1;
        this.f13566x = 1;
        this.G = 0;
        this.f13559p = bVar;
        this.B = new i(bVar.f13716d);
        this.z = new y2.c(null, JsonParser.Feature.STRICT_DUPLICATE_DETECTION.a(i10) ? new androidx.coordinatorlayout.widget.a(this) : null, 0, 1, 0);
    }

    public static int[] Y1(int[] iArr, int i10) {
        return iArr == null ? new int[i10] : Arrays.copyOf(iArr, iArr.length + i10);
    }

    public static IllegalArgumentException Z1(Base64Variant base64Variant, int i10, int i11, String str) {
        String strI;
        if (i10 <= 32) {
            strI = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", Integer.toHexString(i10), Integer.valueOf(i11 + 1));
        } else if (i10 == base64Variant.f3509e) {
            strI = "Unexpected padding character ('" + base64Variant.f3509e + "') as character #" + (i11 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i10) || Character.isISOControl(i10)) {
            strI = "Illegal character (code 0x" + Integer.toHexString(i10) + ") in base64 content";
        } else {
            strI = "Illegal character '" + ((char) i10) + "' (code 0x" + Integer.toHexString(i10) + ") in base64 content";
        }
        if (str != null) {
            strI = d.i(strI, ": ", str);
        }
        return new IllegalArgumentException(strI);
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final String C0() {
        y2.c cVar;
        JsonToken jsonToken = this.f13576c;
        return ((jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) && (cVar = this.z.f13979c) != null) ? cVar.f13982f : this.z.f13982f;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final BigDecimal I0() throws JsonParseException, InputCoercionException {
        int i10 = this.G;
        if ((i10 & 16) == 0) {
            if (i10 == 0) {
                S1(16);
            }
            int i11 = this.G;
            if ((i11 & 16) == 0) {
                if ((i11 & 8) != 0) {
                    String strV0 = V0();
                    String str = x2.d.f13725a;
                    try {
                        this.L = new BigDecimal(strV0);
                    } catch (NumberFormatException unused) {
                        throw new NumberFormatException(a0.a.k("Value \"", strV0, "\" can not be represented as BigDecimal"));
                    }
                } else if ((i11 & 4) != 0) {
                    this.L = new BigDecimal(this.K);
                } else if ((i11 & 2) != 0) {
                    this.L = BigDecimal.valueOf(this.I);
                } else {
                    if ((i11 & 1) == 0) {
                        k.a();
                        throw null;
                    }
                    this.L = BigDecimal.valueOf(this.H);
                }
                this.G |= 16;
            }
        }
        return this.L;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final double J0() throws JsonParseException, InputCoercionException {
        int i10 = this.G;
        if ((i10 & 8) == 0) {
            if (i10 == 0) {
                S1(8);
            }
            int i11 = this.G;
            if ((i11 & 8) == 0) {
                if ((i11 & 16) != 0) {
                    this.J = this.L.doubleValue();
                } else if ((i11 & 4) != 0) {
                    this.J = this.K.doubleValue();
                } else if ((i11 & 2) != 0) {
                    this.J = this.I;
                } else {
                    if ((i11 & 1) == 0) {
                        k.a();
                        throw null;
                    }
                    this.J = this.H;
                }
                this.G |= 8;
            }
        }
        return this.J;
    }

    public abstract void K1();

    @Override // com.fasterxml.jackson.core.JsonParser
    public final float L0() {
        return (float) J0();
    }

    public final int L1(Base64Variant base64Variant, char c9, int i10) {
        if (c9 != '\\') {
            throw Z1(base64Variant, c9, i10, null);
        }
        char cN1 = N1();
        if (cN1 <= ' ' && i10 == 0) {
            return -1;
        }
        int iC = base64Variant.c(cN1);
        if (iC >= 0 || (iC == -2 && i10 >= 2)) {
            return iC;
        }
        throw Z1(base64Variant, cN1, i10, null);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int M0() throws InputCoercionException {
        int i10 = this.G;
        if ((i10 & 1) == 0) {
            if (i10 == 0) {
                return R1();
            }
            if ((i10 & 1) == 0) {
                X1();
            }
        }
        return this.H;
    }

    public final int M1(Base64Variant base64Variant, int i10, int i11) {
        if (i10 != 92) {
            throw Z1(base64Variant, i10, i11, null);
        }
        char cN1 = N1();
        if (cN1 <= ' ' && i11 == 0) {
            return -1;
        }
        int iD = base64Variant.d(cN1);
        if (iD >= 0 || iD == -2) {
            return iD;
        }
        throw Z1(base64Variant, cN1, i11, null);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final long N0() throws JsonParseException, InputCoercionException {
        int i10 = this.G;
        if ((i10 & 2) == 0) {
            if (i10 == 0) {
                S1(2);
            }
            int i11 = this.G;
            if ((i11 & 2) == 0) {
                if ((i11 & 1) != 0) {
                    this.I = this.H;
                } else if ((i11 & 4) != 0) {
                    if (c.f13570j.compareTo(this.K) > 0 || c.f13571k.compareTo(this.K) < 0) {
                        H1();
                        throw null;
                    }
                    this.I = this.K.longValue();
                } else if ((i11 & 8) != 0) {
                    double d8 = this.J;
                    if (d8 < -9.223372036854776E18d || d8 > 9.223372036854776E18d) {
                        H1();
                        throw null;
                    }
                    this.I = (long) d8;
                } else {
                    if ((i11 & 16) == 0) {
                        k.a();
                        throw null;
                    }
                    if (c.f13572l.compareTo(this.L) > 0 || c.f13573m.compareTo(this.L) < 0) {
                        H1();
                        throw null;
                    }
                    this.I = this.L.longValue();
                }
                this.G |= 2;
            }
        }
        return this.I;
    }

    public abstract char N1();

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonParser.NumberType O0() throws JsonParseException, InputCoercionException {
        if (this.G == 0) {
            S1(0);
        }
        if (this.f13576c != JsonToken.VALUE_NUMBER_INT) {
            return (this.G & 16) != 0 ? JsonParser.NumberType.h : JsonParser.NumberType.f3578e;
        }
        int i10 = this.G;
        return (i10 & 1) != 0 ? JsonParser.NumberType.f3574a : (i10 & 2) != 0 ? JsonParser.NumberType.f3575b : JsonParser.NumberType.f3576c;
    }

    public final a3.c O1() {
        a3.c cVar = this.E;
        if (cVar == null) {
            this.E = new a3.c(null);
        } else {
            cVar.K();
        }
        return this.E;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final Number P0() throws JsonParseException, InputCoercionException {
        if (this.G == 0) {
            S1(0);
        }
        if (this.f13576c != JsonToken.VALUE_NUMBER_INT) {
            int i10 = this.G;
            if ((i10 & 16) != 0) {
                return this.L;
            }
            if ((i10 & 8) != 0) {
                return Double.valueOf(this.J);
            }
            k.a();
            throw null;
        }
        int i11 = this.G;
        if ((i11 & 1) != 0) {
            return Integer.valueOf(this.H);
        }
        if ((i11 & 2) != 0) {
            return Long.valueOf(this.I);
        }
        if ((i11 & 4) != 0) {
            return this.K;
        }
        k.a();
        throw null;
    }

    public final Object P1() {
        if (JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION.a(this.f3558a)) {
            return this.f13559p.f13713a;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final BigInteger Q() throws JsonParseException, InputCoercionException {
        int i10 = this.G;
        if ((i10 & 4) == 0) {
            if (i10 == 0) {
                S1(4);
            }
            int i11 = this.G;
            if ((i11 & 4) == 0) {
                if ((i11 & 16) != 0) {
                    this.K = this.L.toBigInteger();
                } else if ((i11 & 2) != 0) {
                    this.K = BigInteger.valueOf(this.I);
                } else if ((i11 & 1) != 0) {
                    this.K = BigInteger.valueOf(this.H);
                } else {
                    if ((i11 & 8) == 0) {
                        k.a();
                        throw null;
                    }
                    this.K = BigDecimal.valueOf(this.J).toBigInteger();
                }
                this.G |= 4;
            }
        }
        return this.K;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final Number Q0() throws JsonParseException, InputCoercionException {
        if (this.f13576c != JsonToken.VALUE_NUMBER_INT) {
            if (this.G == 0) {
                S1(16);
            }
            int i10 = this.G;
            if ((i10 & 16) != 0) {
                return this.L;
            }
            if ((i10 & 8) != 0) {
                return Double.valueOf(this.J);
            }
            k.a();
            throw null;
        }
        if (this.G == 0) {
            S1(0);
        }
        int i11 = this.G;
        if ((i11 & 1) != 0) {
            return Integer.valueOf(this.H);
        }
        if ((i11 & 2) != 0) {
            return Long.valueOf(this.I);
        }
        if ((i11 & 4) != 0) {
            return this.K;
        }
        k.a();
        throw null;
    }

    public final void Q1(char c9) {
        if (JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.a(this.f3558a)) {
            return;
        }
        if (c9 == '\'' && JsonParser.Feature.ALLOW_SINGLE_QUOTES.a(this.f3558a)) {
            return;
        }
        A1("Unrecognized character escape " + c.w1(c9));
        throw null;
    }

    public final int R1() throws JsonParseException, InputCoercionException {
        if (this.f13560q) {
            A1("Internal error: _parseNumericValue called when parser instance closed");
            throw null;
        }
        if (this.f13576c != JsonToken.VALUE_NUMBER_INT || this.N > 9) {
            S1(1);
            if ((this.G & 1) == 0) {
                X1();
            }
            return this.H;
        }
        int iG = this.B.g(this.M);
        this.H = iG;
        this.G = 1;
        return iG;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final v2.b S0() {
        return this.z;
    }

    public final void S1(int i10) throws JsonParseException, InputCoercionException {
        long jE;
        long jE2;
        char[] cArr;
        if (this.f13560q) {
            A1("Internal error: _parseNumericValue called when parser instance closed");
            throw null;
        }
        JsonToken jsonToken = this.f13576c;
        JsonToken jsonToken2 = JsonToken.VALUE_NUMBER_INT;
        i iVar = this.B;
        if (jsonToken != jsonToken2) {
            if (jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
                throw new JsonParseException(this, "Current token (" + jsonToken + ") not numeric, can not use numeric value accessors");
            }
            try {
                if (i10 == 16) {
                    this.L = iVar.f();
                    this.G = 16;
                    return;
                } else {
                    this.J = x2.d.b(iVar.h());
                    this.G = 8;
                    return;
                }
            } catch (NumberFormatException e10) {
                JsonParseException jsonParseException = new JsonParseException("Malformed numeric value (" + c.z1(iVar.h()) + ")", x0(), e10);
                jsonParseException.f3609b = this;
                throw jsonParseException;
            }
        }
        int i11 = this.N;
        if (i11 <= 9) {
            this.H = iVar.g(this.M);
            this.G = 1;
            return;
        }
        int i12 = 0;
        if (i11 <= 18) {
            boolean z = this.M;
            int i13 = iVar.f26c;
            if (i13 < 0 || (cArr = iVar.f25b) == null) {
                if (z) {
                    jE2 = x2.d.e(iVar.h, 1, iVar.f31i - 1);
                    jE = -jE2;
                } else {
                    jE = x2.d.e(iVar.h, 0, iVar.f31i);
                }
            } else if (z) {
                jE2 = x2.d.e(cArr, i13 + 1, iVar.f27d - 1);
                jE = -jE2;
            } else {
                jE = x2.d.e(cArr, i13, iVar.f27d);
            }
            if (i11 == 10) {
                if (this.M) {
                    if (jE >= -2147483648L) {
                        this.H = (int) jE;
                        this.G = 1;
                        return;
                    }
                } else if (jE <= 2147483647L) {
                    this.H = (int) jE;
                    this.G = 1;
                    return;
                }
            }
            this.I = jE;
            this.G = 2;
            return;
        }
        String strH = iVar.h();
        try {
            int i14 = this.N;
            char[] cArrM = iVar.m();
            int i15 = iVar.f26c;
            if (i15 < 0) {
                i15 = 0;
            }
            boolean z3 = this.M;
            if (z3) {
                i15++;
            }
            String str = z3 ? x2.d.f13725a : x2.d.f13726b;
            int length = str.length();
            if (i14 >= length) {
                if (i14 <= length) {
                    while (true) {
                        if (i12 >= length) {
                            break;
                        }
                        int iCharAt = cArrM[i15 + i12] - str.charAt(i12);
                        if (iCharAt == 0) {
                            i12++;
                        } else if (iCharAt < 0) {
                        }
                    }
                }
                if (i10 != 1 && i10 != 2) {
                    if (i10 != 8 && i10 != 32) {
                        this.K = new BigInteger(strH);
                        this.G = 4;
                        return;
                    }
                    this.J = x2.d.b(strH);
                    this.G = 8;
                    return;
                }
                if (i10 == 1) {
                    throw new InputCoercionException(this, String.format("Numeric value (%s) out of range of int (%d - %s)", c.y1(strH), Integer.MIN_VALUE, Integer.MAX_VALUE));
                }
                I1(strH);
                throw null;
            }
            this.I = Long.parseLong(strH);
            this.G = 2;
        } catch (NumberFormatException e11) {
            JsonParseException jsonParseException2 = new JsonParseException("Malformed numeric value (" + c.z1(strH) + ")", x0(), e11);
            jsonParseException2.f3609b = this;
            throw jsonParseException2;
        }
    }

    public abstract void T1();

    public final void U1(char c9, int i10) {
        y2.c cVar = this.z;
        A1(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", Character.valueOf((char) i10), Character.valueOf(c9), cVar.h(), new JsonLocation(cVar.h, -1L, -1L, cVar.f13984i, P1())));
        throw null;
    }

    public final void V1(int i10, String str) {
        if (!JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS.a(this.f3558a) || i10 > 32) {
            A1("Illegal unquoted character (" + c.w1((char) i10) + "): has to be escaped using backslash to be included in " + str);
            throw null;
        }
    }

    public final String W1() {
        return JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.a(this.f3558a) ? "(JSON String, Number (or 'NaN'/'INF'/'+INF'), Array, Object or token 'null', 'true' or 'false')" : "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    public final void X1() throws InputCoercionException {
        int i10 = this.G;
        if ((i10 & 2) != 0) {
            long j10 = this.I;
            int i11 = (int) j10;
            if (i11 != j10) {
                throw new InputCoercionException(this, String.format("Numeric value (%s) out of range of int (%d - %s)", c.y1(V0()), Integer.MIN_VALUE, Integer.MAX_VALUE));
            }
            this.H = i11;
        } else if ((i10 & 4) != 0) {
            if (c.f13569e.compareTo(this.K) > 0 || c.h.compareTo(this.K) < 0) {
                G1();
                throw null;
            }
            this.H = this.K.intValue();
        } else if ((i10 & 8) != 0) {
            double d8 = this.J;
            if (d8 < -2.147483648E9d || d8 > 2.147483647E9d) {
                G1();
                throw null;
            }
            this.H = (int) d8;
        } else {
            if ((i10 & 16) == 0) {
                k.a();
                throw null;
            }
            if (c.f13574n.compareTo(this.L) > 0 || c.f13575o.compareTo(this.L) < 0) {
                G1();
                throw null;
            }
            this.H = this.L.intValue();
        }
        this.G |= 1;
    }

    public final JsonToken a2(String str, double d8) {
        i iVar = this.B;
        iVar.f25b = null;
        iVar.f26c = -1;
        iVar.f27d = 0;
        iVar.f32j = str;
        iVar.f33k = null;
        if (iVar.f29f) {
            iVar.d();
        }
        iVar.f31i = 0;
        this.J = d8;
        this.G = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final JsonToken b2(int i10, boolean z) {
        this.M = z;
        this.N = i10;
        this.G = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f13560q) {
            return;
        }
        this.r = Math.max(this.r, this.f13561s);
        this.f13560q = true;
        try {
            K1();
        } finally {
            T1();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final boolean h1() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return true;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this.D;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final boolean n1() {
        if (this.f13576c != JsonToken.VALUE_NUMBER_FLOAT || (this.G & 8) == 0) {
            return false;
        }
        double d8 = this.J;
        return Double.isNaN(d8) || Double.isInfinite(d8);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final void u1(Object obj) {
        this.z.f13983g = obj;
    }

    @Override // w2.c
    public final void x1() {
        if (this.z.f()) {
            return;
        }
        String str = this.z.d() ? "Array" : "Object";
        y2.c cVar = this.z;
        C1(String.format(": expected close marker for %s (start marker at %s)", str, new JsonLocation(cVar.h, -1L, -1L, cVar.f13984i, P1())));
        throw null;
    }
}
