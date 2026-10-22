package u7;

import ad.o;
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
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f14172p = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f14173q = new String[128];

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f14174r;

    /* renamed from: c, reason: collision with root package name */
    public final Writer f14175c;

    /* renamed from: f, reason: collision with root package name */
    public int[] f14176f;

    /* renamed from: g, reason: collision with root package name */
    public int f14177g;

    /* renamed from: h, reason: collision with root package name */
    public m7.a f14178h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public String f14179j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14180k;

    /* renamed from: l, reason: collision with root package name */
    public int f14181l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14182m;

    /* renamed from: n, reason: collision with root package name */
    public String f14183n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14184o;

    static {
        for (int i = 0; i <= 31; i++) {
            f14173q[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f14173q;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f14174r = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        int[] iArr = new int[32];
        this.f14176f = iArr;
        this.f14177g = 0;
        if (iArr.length == 0) {
            this.f14176f = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f14176f;
        int i = this.f14177g;
        this.f14177g = i + 1;
        iArr2[i] = 6;
        this.f14181l = 2;
        this.f14184o = true;
        Objects.requireNonNull(writer, "out == null");
        this.f14175c = writer;
        H(m7.a.f8242d);
    }

    public final void A() throws IOException {
        if (this.f14180k) {
            return;
        }
        String str = this.f14178h.f8243a;
        Writer writer = this.f14175c;
        writer.write(str);
        int i = this.f14177g;
        for (int i3 = 1; i3 < i; i3++) {
            writer.write(this.f14178h.f8244b);
        }
    }

    public c C() {
        if (this.f14183n != null) {
            if (!this.f14184o) {
                this.f14183n = null;
                return this;
            }
            U();
        }
        d();
        this.f14175c.write("null");
        return this;
    }

    public final int F() {
        int i = this.f14177g;
        if (i != 0) {
            return this.f14176f[i - 1];
        }
        f.e("JsonWriter is closed.");
        return 0;
    }

    public final void H(m7.a aVar) {
        Objects.requireNonNull(aVar);
        this.f14178h = aVar;
        this.f14179j = ",";
        if (aVar.f8245c) {
            this.i = ": ";
            if (aVar.f8243a.isEmpty()) {
                this.f14179j = ", ";
            }
        } else {
            this.i = ":";
        }
        this.f14180k = this.f14178h.f8243a.isEmpty() && this.f14178h.f8244b.isEmpty();
    }

    public final void M(int i) {
        if (i == 0) {
            throw null;
        }
        this.f14181l = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.f14182m
            if (r0 == 0) goto L7
            java.lang.String[] r0 = u7.c.f14174r
            goto L9
        L7:
            java.lang.String[] r0 = u7.c.f14173q
        L9:
            java.io.Writer r7 = r7.f14175c
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
        throw new UnsupportedOperationException("Method not decompiled: u7.c.N(java.lang.String):void");
    }

    public void O(double d7) throws IOException {
        U();
        if (this.f14181l == 1 || !(Double.isNaN(d7) || Double.isInfinite(d7))) {
            d();
            this.f14175c.append((CharSequence) Double.toString(d7));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d7);
        }
    }

    public void P(long j10) throws IOException {
        U();
        d();
        this.f14175c.write(Long.toString(j10));
    }

    public void Q(Boolean bool) throws IOException {
        if (bool == null) {
            C();
            return;
        }
        U();
        d();
        this.f14175c.write(bool.booleanValue() ? "true" : "false");
    }

    public void R(Number number) {
        if (number == null) {
            C();
            return;
        }
        U();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.f14181l != 1) {
                    g5.f.s("Numeric values must be finite, but was ".concat(string));
                    return;
                }
            } else if (cls != Float.class && cls != Double.class && !f14172p.matcher(string).matches()) {
                g5.f.h("String created by ", cls, " is not a valid JSON number: ", string);
                return;
            }
        }
        d();
        this.f14175c.append((CharSequence) string);
    }

    public void S(String str) {
        if (str == null) {
            C();
            return;
        }
        U();
        d();
        N(str);
    }

    public void T(boolean z10) {
        U();
        d();
        this.f14175c.write(z10 ? "true" : "false");
    }

    public final void U() throws IOException {
        if (this.f14183n != null) {
            int iF = F();
            if (iF == 5) {
                this.f14175c.write(this.f14179j);
            } else if (iF != 3) {
                f.e("Nesting problem.");
                return;
            }
            A();
            this.f14176f[this.f14177g - 1] = 4;
            N(this.f14183n);
            this.f14183n = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14175c.close();
        int i = this.f14177g;
        if (i > 1 || (i == 1 && this.f14176f[i - 1] != 7)) {
            f.l("Incomplete document");
        } else {
            this.f14177g = 0;
        }
    }

    public final void d() throws IOException {
        int iF = F();
        if (iF == 1) {
            this.f14176f[this.f14177g - 1] = 2;
            A();
            return;
        }
        Writer writer = this.f14175c;
        if (iF == 2) {
            writer.append((CharSequence) this.f14179j);
            A();
            return;
        }
        if (iF == 4) {
            writer.append((CharSequence) this.i);
            this.f14176f[this.f14177g - 1] = 5;
            return;
        }
        if (iF != 6) {
            if (iF != 7) {
                f.e("Nesting problem.");
                return;
            } else if (this.f14181l != 1) {
                f.e("JSON must have only one top-level value.");
                return;
            }
        }
        this.f14176f[this.f14177g - 1] = 7;
    }

    public void e() {
        U();
        d();
        int i = this.f14177g;
        int[] iArr = this.f14176f;
        if (i == iArr.length) {
            this.f14176f = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.f14176f;
        int i3 = this.f14177g;
        this.f14177g = i3 + 1;
        iArr2[i3] = 1;
        this.f14175c.write(91);
    }

    public void flush() throws IOException {
        if (this.f14177g != 0) {
            this.f14175c.flush();
        } else {
            f.e("JsonWriter is closed.");
        }
    }

    public void g() {
        U();
        d();
        int i = this.f14177g;
        int[] iArr = this.f14176f;
        if (i == iArr.length) {
            this.f14176f = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.f14176f;
        int i3 = this.f14177g;
        this.f14177g = i3 + 1;
        iArr2[i3] = 3;
        this.f14175c.write(123);
    }

    public final void i(int i, int i3, char c9) throws IOException {
        int iF = F();
        if (iF != i3 && iF != i) {
            f.e("Nesting problem.");
            return;
        }
        if (this.f14183n != null) {
            o.n(this.f14183n, "Dangling name: ");
            return;
        }
        this.f14177g--;
        if (iF == i3) {
            A();
        }
        this.f14175c.write(c9);
    }

    public void n() {
        i(1, 2, ']');
    }

    public void o() {
        i(3, 5, '}');
    }

    public void r(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f14183n != null) {
            f.e("Already wrote a name, expecting a value.");
            return;
        }
        int iF = F();
        if (iF == 3 || iF == 5) {
            this.f14183n = str;
        } else {
            f.e("Please begin an object before writing a name.");
        }
    }
}
