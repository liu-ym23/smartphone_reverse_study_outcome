package com.fasterxml.jackson.core;

import a0.a;
import a3.f;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import v2.b;
import v2.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class JsonParser implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public static final f<StreamReadCapability> f3557b = f.a(StreamReadCapability.values());

    /* renamed from: a, reason: collision with root package name */
    public int f3558a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        ALLOW_MISSING_VALUES(false),
        ALLOW_TRAILING_COMMA(false),
        STRICT_DUPLICATE_DETECTION(false),
        /* JADX INFO: Fake field, exist only in values array */
        IGNORE_UNDEFINED(false),
        INCLUDE_SOURCE_IN_LOCATION(true);


        /* renamed from: a, reason: collision with root package name */
        public final boolean f3572a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3573b = 1 << ordinal();

        Feature(boolean z) {
            this.f3572a = z;
        }

        public final boolean a(int i10) {
            return (this.f3573b & i10) != 0;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NumberType {

        /* renamed from: a, reason: collision with root package name */
        public static final NumberType f3574a;

        /* renamed from: b, reason: collision with root package name */
        public static final NumberType f3575b;

        /* renamed from: c, reason: collision with root package name */
        public static final NumberType f3576c;

        /* renamed from: d, reason: collision with root package name */
        public static final NumberType f3577d;

        /* renamed from: e, reason: collision with root package name */
        public static final NumberType f3578e;
        public static final NumberType h;

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ NumberType[] f3579j;

        static {
            NumberType numberType = new NumberType("INT", 0);
            f3574a = numberType;
            NumberType numberType2 = new NumberType("LONG", 1);
            f3575b = numberType2;
            NumberType numberType3 = new NumberType("BIG_INTEGER", 2);
            f3576c = numberType3;
            NumberType numberType4 = new NumberType("FLOAT", 3);
            f3577d = numberType4;
            NumberType numberType5 = new NumberType("DOUBLE", 4);
            f3578e = numberType5;
            NumberType numberType6 = new NumberType("BIG_DECIMAL", 5);
            h = numberType6;
            f3579j = new NumberType[]{numberType, numberType2, numberType3, numberType4, numberType5, numberType6};
        }

        public NumberType() {
            throw null;
        }

        public static NumberType valueOf(String str) {
            return (NumberType) Enum.valueOf(NumberType.class, str);
        }

        public static NumberType[] values() {
            return (NumberType[]) f3579j.clone();
        }
    }

    public String C() {
        return C0();
    }

    public abstract String C0();

    public abstract JsonToken G0();

    @Deprecated
    public abstract int H0();

    public abstract BigDecimal I0();

    public abstract double J0();

    public JsonToken K() {
        return G0();
    }

    public Object K0() {
        return null;
    }

    public abstract float L0();

    public abstract int M0();

    public abstract long N0();

    public abstract NumberType O0();

    public int P() {
        return H0();
    }

    public abstract Number P0();

    public abstract BigInteger Q();

    public Number Q0() {
        return P0();
    }

    public Object R0() {
        return null;
    }

    public abstract byte[] S(Base64Variant base64Variant);

    public abstract b S0();

    public f<StreamReadCapability> T0() {
        return f3557b;
    }

    public short U0() throws InputCoercionException {
        int iM0 = M0();
        if (iM0 >= -32768 && iM0 <= 32767) {
            return (short) iM0;
        }
        String strK = a.k("Numeric value (", V0(), ") out of range of Java short");
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        throw new InputCoercionException(this, strK);
    }

    public abstract String V0();

    public abstract char[] W0();

    public abstract int X0();

    public abstract int Y0();

    public abstract JsonLocation Z0();

    public boolean a() {
        return false;
    }

    public Object a1() {
        return null;
    }

    public int b1() {
        return c1();
    }

    public byte c0() throws InputCoercionException {
        int iM0 = M0();
        if (iM0 >= -128 && iM0 <= 255) {
            return (byte) iM0;
        }
        String strK = a.k("Numeric value (", V0(), ") out of range of Java byte");
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        throw new InputCoercionException(this, strK);
    }

    public int c1() {
        return 0;
    }

    public long d1() {
        return e1();
    }

    public long e1() {
        return 0L;
    }

    public String f1() {
        return g1();
    }

    public abstract c g0();

    public abstract String g1();

    public abstract boolean h1();

    public abstract boolean i1(JsonToken jsonToken);

    public abstract boolean j1();

    public boolean k1() {
        return K() == JsonToken.VALUE_NUMBER_INT;
    }

    public boolean l1() {
        return K() == JsonToken.START_ARRAY;
    }

    public boolean m1() {
        return K() == JsonToken.START_OBJECT;
    }

    public boolean n1() {
        return false;
    }

    public boolean o() {
        return false;
    }

    public String o1() {
        if (q1() == JsonToken.FIELD_NAME) {
            return C0();
        }
        return null;
    }

    public String p1() {
        if (q1() == JsonToken.VALUE_STRING) {
            return V0();
        }
        return null;
    }

    public abstract JsonToken q1();

    public abstract JsonToken r1();

    public int s1(Base64Variant base64Variant, q3.f fVar) {
        throw new UnsupportedOperationException("Operation not supported by parser of type ".concat(getClass().getName()));
    }

    public boolean t1() {
        return false;
    }

    public void u1(Object obj) {
        b bVarS0 = S0();
        if (bVarS0 != null) {
            bVarS0.g(obj);
        }
    }

    public abstract JsonParser v1();

    public abstract void w();

    public abstract JsonLocation x0();
}
