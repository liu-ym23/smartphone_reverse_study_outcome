package g5;

import com.google.gson.Strictness;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Reader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends k5.a {

    /* renamed from: w, reason: collision with root package name */
    public static final a f8981w = new a();

    /* renamed from: x, reason: collision with root package name */
    public static final Object f8982x = new Object();

    /* renamed from: s, reason: collision with root package name */
    public Object[] f8983s;

    /* renamed from: t, reason: collision with root package name */
    public int f8984t;

    /* renamed from: u, reason: collision with root package name */
    public String[] f8985u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f8986v;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public final int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    @Override // k5.a
    public final boolean H0() {
        b1(JsonToken.f5477k);
        boolean zA = ((d5.r) g1()).a();
        int i10 = this.f8984t;
        if (i10 > 0) {
            int[] iArr = this.f8986v;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return zA;
    }

    @Override // k5.a
    public final double I0() throws MalformedJsonException {
        JsonToken jsonTokenR0 = R0();
        JsonToken jsonToken = JsonToken.f5476j;
        if (jsonTokenR0 != jsonToken && jsonTokenR0 != JsonToken.h) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenR0 + d1());
        }
        double dH = ((d5.r) f1()).h();
        if (this.f9921b != Strictness.f5434a && (Double.isNaN(dH) || Double.isInfinite(dH))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + dH);
        }
        g1();
        int i10 = this.f8984t;
        if (i10 > 0) {
            int[] iArr = this.f8986v;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return dH;
    }

    @Override // k5.a
    public final int J0() {
        JsonToken jsonTokenR0 = R0();
        JsonToken jsonToken = JsonToken.f5476j;
        if (jsonTokenR0 != jsonToken && jsonTokenR0 != JsonToken.h) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenR0 + d1());
        }
        int iB = ((d5.r) f1()).b();
        g1();
        int i10 = this.f8984t;
        if (i10 > 0) {
            int[] iArr = this.f8986v;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return iB;
    }

    @Override // k5.a
    public final void K() {
        b1(JsonToken.f5472b);
        g1();
        g1();
        int i10 = this.f8984t;
        if (i10 > 0) {
            int[] iArr = this.f8986v;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // k5.a
    public final long K0() {
        JsonToken jsonTokenR0 = R0();
        JsonToken jsonToken = JsonToken.f5476j;
        if (jsonTokenR0 != jsonToken && jsonTokenR0 != JsonToken.h) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenR0 + d1());
        }
        long jE = ((d5.r) f1()).e();
        g1();
        int i10 = this.f8984t;
        if (i10 > 0) {
            int[] iArr = this.f8986v;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return jE;
    }

    @Override // k5.a
    public final String L0() {
        return e1(false);
    }

    @Override // k5.a
    public final void N0() {
        b1(JsonToken.f5478l);
        g1();
        int i10 = this.f8984t;
        if (i10 > 0) {
            int[] iArr = this.f8986v;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // k5.a
    public final void P() {
        b1(JsonToken.f5474d);
        this.f8985u[this.f8984t - 1] = null;
        g1();
        g1();
        int i10 = this.f8984t;
        if (i10 > 0) {
            int[] iArr = this.f8986v;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // k5.a
    public final String P0() {
        JsonToken jsonTokenR0 = R0();
        JsonToken jsonToken = JsonToken.h;
        if (jsonTokenR0 != jsonToken && jsonTokenR0 != JsonToken.f5476j) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenR0 + d1());
        }
        String strF = ((d5.r) g1()).f();
        int i10 = this.f8984t;
        if (i10 > 0) {
            int[] iArr = this.f8986v;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return strF;
    }

    @Override // k5.a
    public final JsonToken R0() {
        if (this.f8984t == 0) {
            return JsonToken.f5479m;
        }
        Object objF1 = f1();
        if (objF1 instanceof Iterator) {
            boolean z = this.f8983s[this.f8984t - 2] instanceof d5.q;
            Iterator it = (Iterator) objF1;
            if (!it.hasNext()) {
                return z ? JsonToken.f5474d : JsonToken.f5472b;
            }
            if (z) {
                return JsonToken.f5475e;
            }
            h1(it.next());
            return R0();
        }
        if (objF1 instanceof d5.q) {
            return JsonToken.f5473c;
        }
        if (objF1 instanceof d5.l) {
            return JsonToken.f5471a;
        }
        if (objF1 instanceof d5.r) {
            Serializable serializable = ((d5.r) objF1).f8384a;
            if (serializable instanceof String) {
                return JsonToken.h;
            }
            if (serializable instanceof Boolean) {
                return JsonToken.f5477k;
            }
            if (serializable instanceof Number) {
                return JsonToken.f5476j;
            }
            throw new AssertionError();
        }
        if (objF1 instanceof d5.p) {
            return JsonToken.f5478l;
        }
        if (objF1 == f8982x) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + objF1.getClass().getName() + " is not supported");
    }

    @Override // k5.a
    public final String S() {
        return c1(false);
    }

    @Override // k5.a
    public final void Y0() {
        int iOrdinal = R0().ordinal();
        if (iOrdinal == 1) {
            K();
            return;
        }
        if (iOrdinal != 9) {
            if (iOrdinal == 3) {
                P();
                return;
            }
            if (iOrdinal == 4) {
                e1(true);
                return;
            }
            g1();
            int i10 = this.f8984t;
            if (i10 > 0) {
                int[] iArr = this.f8986v;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
        }
    }

    @Override // k5.a
    public final void a() {
        b1(JsonToken.f5471a);
        h1(((d5.l) f1()).f8381a.iterator());
        this.f8986v[this.f8984t - 1] = 0;
    }

    public final void b1(JsonToken jsonToken) {
        if (R0() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + R0() + d1());
    }

    public final String c1(boolean z) {
        StringBuilder sb2 = new StringBuilder("$");
        int i10 = 0;
        while (true) {
            int i11 = this.f8984t;
            if (i10 >= i11) {
                return sb2.toString();
            }
            Object[] objArr = this.f8983s;
            Object obj = objArr[i10];
            if (obj instanceof d5.l) {
                i10++;
                if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                    int i12 = this.f8986v[i10];
                    if (z && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                        i12--;
                    }
                    sb2.append('[');
                    sb2.append(i12);
                    sb2.append(']');
                }
            } else if ((obj instanceof d5.q) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                sb2.append('.');
                String str = this.f8985u[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    @Override // k5.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8983s = new Object[]{f8982x};
        this.f8984t = 1;
    }

    public final String d1() {
        return " at path " + c1(false);
    }

    public final String e1(boolean z) {
        b1(JsonToken.f5475e);
        Map.Entry entry = (Map.Entry) ((Iterator) f1()).next();
        String str = (String) entry.getKey();
        this.f8985u[this.f8984t - 1] = z ? "<skipped>" : str;
        h1(entry.getValue());
        return str;
    }

    public final Object f1() {
        return this.f8983s[this.f8984t - 1];
    }

    @Override // k5.a
    public final String g0() {
        return c1(true);
    }

    public final Object g1() {
        Object[] objArr = this.f8983s;
        int i10 = this.f8984t - 1;
        this.f8984t = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    public final void h1(Object obj) {
        int i10 = this.f8984t;
        Object[] objArr = this.f8983s;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f8983s = Arrays.copyOf(objArr, i11);
            this.f8986v = Arrays.copyOf(this.f8986v, i11);
            this.f8985u = (String[]) Arrays.copyOf(this.f8985u, i11);
        }
        Object[] objArr2 = this.f8983s;
        int i12 = this.f8984t;
        this.f8984t = i12 + 1;
        objArr2[i12] = obj;
    }

    @Override // k5.a
    public final void o() {
        b1(JsonToken.f5473c);
        h1(((LinkedTreeMap.b) ((d5.q) f1()).f8383a.entrySet()).iterator());
    }

    @Override // k5.a
    public final String toString() {
        return e.class.getSimpleName() + d1();
    }

    @Override // k5.a
    public final boolean x0() {
        JsonToken jsonTokenR0 = R0();
        return (jsonTokenR0 == JsonToken.f5474d || jsonTokenR0 == JsonToken.f5472b || jsonTokenR0 == JsonToken.f5479m) ? false : true;
    }
}
