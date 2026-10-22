package k5;

import com.google.gson.Strictness;
import com.stepos.core.common.util.TraceIdKeys;
import d5.c;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b implements Closeable, Flushable {

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f9933o = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f9934p = new String[TraceIdKeys.MAX_LENGTH];

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f9935q;

    /* renamed from: a, reason: collision with root package name */
    public final Writer f9936a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f9937b;

    /* renamed from: c, reason: collision with root package name */
    public int f9938c;

    /* renamed from: d, reason: collision with root package name */
    public c f9939d;

    /* renamed from: e, reason: collision with root package name */
    public String f9940e;
    public String h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9941j;

    /* renamed from: k, reason: collision with root package name */
    public Strictness f9942k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9943l;

    /* renamed from: m, reason: collision with root package name */
    public String f9944m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9945n;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f9934p[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f9934p;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f9935q = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        int[] iArr = new int[32];
        this.f9937b = iArr;
        this.f9938c = 0;
        if (iArr.length == 0) {
            this.f9937b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f9937b;
        int i10 = this.f9938c;
        this.f9938c = i10 + 1;
        iArr2[i10] = 6;
        this.f9942k = Strictness.f5435b;
        this.f9945n = true;
        Objects.requireNonNull(writer, "out == null");
        this.f9936a = writer;
        x0(c.f8347d);
    }

    public final void C(int i10, int i11, char c9) throws IOException {
        int iG0 = g0();
        if (iG0 != i11 && iG0 != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f9944m != null) {
            throw new IllegalStateException("Dangling name: " + this.f9944m);
        }
        this.f9938c--;
        if (iG0 == i11) {
            S();
        }
        this.f9936a.write(c9);
    }

    public final void C0(Strictness strictness) {
        Objects.requireNonNull(strictness);
        this.f9942k = strictness;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G0(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.f9943l
            if (r0 == 0) goto L7
            java.lang.String[] r0 = k5.b.f9935q
            goto L9
        L7:
            java.lang.String[] r0 = k5.b.f9934p
        L9:
            java.io.Writer r7 = r7.f9936a
            r1 = 34
            r7.write(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r2) goto L41
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L3e
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L3e
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L39
            int r6 = r3 - r4
            r7.write(r8, r4, r6)
        L39:
            r7.write(r5)
            int r4 = r3 + 1
        L3e:
            int r3 = r3 + 1
            goto L16
        L41:
            if (r4 >= r2) goto L47
            int r2 = r2 - r4
            r7.write(r8, r4, r2)
        L47:
            r7.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.b.G0(java.lang.String):void");
    }

    public void H0(double d8) throws IOException {
        M0();
        if (this.f9942k == Strictness.f5434a || !(Double.isNaN(d8) || Double.isInfinite(d8))) {
            a();
            this.f9936a.append((CharSequence) Double.toString(d8));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d8);
        }
    }

    public void I0(long j10) throws IOException {
        M0();
        a();
        this.f9936a.write(Long.toString(j10));
    }

    public void J0(Number number) throws IOException {
        if (number == null) {
            c0();
            return;
        }
        M0();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (cls != Integer.class && cls != Long.class && cls != Double.class && cls != Float.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class && !f9933o.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (this.f9942k != Strictness.f5434a) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
        }
        a();
        this.f9936a.append((CharSequence) string);
    }

    public void K() throws IOException {
        C(1, 2, ']');
    }

    public void K0(String str) throws IOException {
        if (str == null) {
            c0();
            return;
        }
        M0();
        a();
        G0(str);
    }

    public void L0(boolean z) throws IOException {
        M0();
        a();
        this.f9936a.write(z ? "true" : "false");
    }

    public final void M0() throws IOException {
        if (this.f9944m != null) {
            int iG0 = g0();
            if (iG0 == 5) {
                this.f9936a.write(this.h);
            } else if (iG0 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            S();
            this.f9937b[this.f9938c - 1] = 4;
            G0(this.f9944m);
            this.f9944m = null;
        }
    }

    public void P() throws IOException {
        C(3, 5, '}');
    }

    public void Q(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f9944m != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iG0 = g0();
        if (iG0 != 3 && iG0 != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f9944m = str;
    }

    public final void S() throws IOException {
        if (this.f9941j) {
            return;
        }
        String str = this.f9939d.f8348a;
        Writer writer = this.f9936a;
        writer.write(str);
        int i10 = this.f9938c;
        for (int i11 = 1; i11 < i10; i11++) {
            writer.write(this.f9939d.f8349b);
        }
    }

    public final void a() throws IOException {
        int iG0 = g0();
        if (iG0 == 1) {
            this.f9937b[this.f9938c - 1] = 2;
            S();
            return;
        }
        Writer writer = this.f9936a;
        if (iG0 == 2) {
            writer.append((CharSequence) this.h);
            S();
        } else {
            if (iG0 == 4) {
                writer.append((CharSequence) this.f9940e);
                this.f9937b[this.f9938c - 1] = 5;
                return;
            }
            if (iG0 != 6) {
                if (iG0 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f9942k != Strictness.f5434a) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f9937b[this.f9938c - 1] = 7;
        }
    }

    public b c0() throws IOException {
        if (this.f9944m != null) {
            if (!this.f9945n) {
                this.f9944m = null;
                return this;
            }
            M0();
        }
        a();
        this.f9936a.write("null");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9936a.close();
        int i10 = this.f9938c;
        if (i10 > 1 || (i10 == 1 && this.f9937b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f9938c = 0;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f9938c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f9936a.flush();
    }

    public final int g0() {
        int i10 = this.f9938c;
        if (i10 != 0) {
            return this.f9937b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void o() throws IOException {
        M0();
        a();
        int i10 = this.f9938c;
        int[] iArr = this.f9937b;
        if (i10 == iArr.length) {
            this.f9937b = Arrays.copyOf(iArr, i10 * 2);
        }
        int[] iArr2 = this.f9937b;
        int i11 = this.f9938c;
        this.f9938c = i11 + 1;
        iArr2[i11] = 1;
        this.f9936a.write(91);
    }

    public void w() throws IOException {
        M0();
        a();
        int i10 = this.f9938c;
        int[] iArr = this.f9937b;
        if (i10 == iArr.length) {
            this.f9937b = Arrays.copyOf(iArr, i10 * 2);
        }
        int[] iArr2 = this.f9937b;
        int i11 = this.f9938c;
        this.f9938c = i11 + 1;
        iArr2[i11] = 3;
        this.f9936a.write(123);
    }

    public final void x0(c cVar) {
        Objects.requireNonNull(cVar);
        this.f9939d = cVar;
        this.h = ",";
        if (cVar.f8350c) {
            this.f9940e = ": ";
            if (cVar.f8348a.isEmpty()) {
                this.h = ", ";
            }
        } else {
            this.f9940e = ":";
        }
        this.f9941j = this.f9939d.f8348a.isEmpty() && this.f9939d.f8349b.isEmpty();
    }
}
