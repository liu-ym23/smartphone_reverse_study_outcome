package com.fasterxml.jackson.core;

import a3.f;
import java.io.Closeable;
import java.io.Flushable;
import java.math.BigDecimal;
import java.math.BigInteger;
import v2.a;
import v2.d;
import v2.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class JsonGenerator implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    public d f3540a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        ESCAPE_NON_ASCII(false),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        STRICT_DUPLICATE_DETECTION(false),
        /* JADX INFO: Fake field, exist only in values array */
        IGNORE_UNKNOWN(false);


        /* renamed from: a, reason: collision with root package name */
        public final boolean f3550a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3551b = 1 << ordinal();

        Feature(boolean z) {
            this.f3550a = z;
        }

        public final boolean a(int i10) {
            return (this.f3551b & i10) != 0;
        }
    }

    static {
        f.a(StreamWriteCapability.values());
        StreamWriteCapability.CAN_WRITE_FORMATTED_NUMBERS.b();
        StreamWriteCapability.CAN_WRITE_BINARY_NATIVELY.b();
    }

    public static void o(int i10, int i11) {
        if (i11 > i10) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", 0, Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public boolean C() {
        return false;
    }

    public abstract void C0();

    public abstract void G0();

    public abstract void H0(String str);

    public abstract void I0(e eVar);

    public abstract void J0();

    public abstract y2.d K();

    public abstract void K0(double d8);

    public abstract void L0(float f8);

    public abstract void M0(int i10);

    public abstract void N0(long j10);

    public abstract void O0(String str);

    public abstract boolean P(Feature feature);

    public abstract void P0(BigDecimal bigDecimal);

    public void Q(Object obj) {
        y2.d dVarK = K();
        if (dVarK != null) {
            dVarK.f13989g = obj;
        }
    }

    public abstract void Q0(BigInteger bigInteger);

    public abstract void R0(short s8);

    public abstract int S(Base64Variant base64Variant, q3.e eVar, int i10);

    public void S0(Object obj) throws JsonGenerationException {
        throw new JsonGenerationException("No native support for writing Object Ids", this);
    }

    public abstract void T0(char c9);

    public abstract void U0(String str);

    public abstract void V0(e eVar);

    public abstract void W0(char[] cArr, int i10);

    public abstract void X0(String str);

    public void Y0(e eVar) {
        X0(eVar.getValue());
    }

    public abstract void Z0();

    public final void a(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str, this);
    }

    public abstract void a1(Object obj);

    public abstract void b1(Object obj);

    public abstract void c0(Base64Variant base64Variant, byte[] bArr, int i10, int i11);

    public abstract void c1();

    public abstract void d1(Object obj);

    public void e1(Object obj) {
        c1();
        Q(obj);
    }

    public abstract void f1(String str);

    @Override // java.io.Flushable
    public abstract void flush();

    public abstract void g0(boolean z);

    public abstract void g1(e eVar);

    public abstract void h1(char[] cArr, int i10, int i11);

    public void i1(Object obj) throws JsonGenerationException {
        throw new JsonGenerationException("No native support for writing Type Ids", this);
    }

    public boolean w() {
        return false;
    }

    public abstract void writeObject(Object obj);

    public void x0(Object obj) throws JsonGenerationException {
        if (obj == null) {
            J0();
        } else {
            if (!(obj instanceof byte[])) {
                throw new JsonGenerationException("No native support for writing embedded objects of type ".concat(obj.getClass().getName()), this);
            }
            byte[] bArr = (byte[]) obj;
            c0(a.f13372b, bArr, 0, bArr.length);
        }
    }
}
