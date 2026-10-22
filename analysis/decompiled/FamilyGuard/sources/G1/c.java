package G1;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f1871j = new String[128];

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f1872k;

    /* renamed from: a, reason: collision with root package name */
    private final Writer f1873a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f1874b = new int[32];

    /* renamed from: c, reason: collision with root package name */
    private int f1875c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f1876d;

    /* renamed from: e, reason: collision with root package name */
    private String f1877e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1878f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1879g;

    /* renamed from: h, reason: collision with root package name */
    private String f1880h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1881i;

    static {
        for (int i5 = 0; i5 <= 31; i5++) {
            f1871j[i5] = String.format("\\u%04x", Integer.valueOf(i5));
        }
        String[] strArr = f1871j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f1872k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        I(6);
        this.f1877e = ":";
        this.f1881i = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f1873a = writer;
    }

    private void C() throws IOException {
        if (this.f1876d == null) {
            return;
        }
        this.f1873a.write("\n");
        int i5 = this.f1875c;
        for (int i6 = 1; i6 < i5; i6++) {
            this.f1873a.write(this.f1876d);
        }
    }

    private c E(int i5, String str) throws IOException {
        c();
        I(i5);
        this.f1873a.write(str);
        return this;
    }

    private int G() {
        int i5 = this.f1875c;
        if (i5 != 0) {
            return this.f1874b[i5 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void I(int i5) {
        int i6 = this.f1875c;
        int[] iArr = this.f1874b;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[i6 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.f1874b = iArr2;
        }
        int[] iArr3 = this.f1874b;
        int i7 = this.f1875c;
        this.f1875c = i7 + 1;
        iArr3[i7] = i5;
    }

    private void L(int i5) {
        this.f1874b[this.f1875c - 1] = i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void U(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f1879g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = G1.c.f1872k
            goto L9
        L7:
            java.lang.String[] r0 = G1.c.f1871j
        L9:
            java.io.Writer r1 = r8.f1873a
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f1873a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f1873a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f1873a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r8 = r8.f1873a
            r8.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: G1.c.U(java.lang.String):void");
    }

    private void a() throws IOException {
        int iG = G();
        if (iG == 5) {
            this.f1873a.write(44);
        } else if (iG != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        C();
        L(4);
    }

    private void c() throws IOException {
        int iG = G();
        if (iG == 1) {
            L(2);
            C();
            return;
        }
        if (iG == 2) {
            this.f1873a.append(',');
            C();
        } else {
            if (iG == 4) {
                this.f1873a.append((CharSequence) this.f1877e);
                L(5);
                return;
            }
            if (iG != 6) {
                if (iG != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f1878f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            L(7);
        }
    }

    private void d0() throws IOException {
        if (this.f1880h != null) {
            a();
            U(this.f1880h);
            this.f1880h = null;
        }
    }

    private c o(int i5, int i6, String str) throws IOException {
        int iG = G();
        if (iG != i6 && iG != i5) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f1880h != null) {
            throw new IllegalStateException("Dangling name: " + this.f1880h);
        }
        this.f1875c--;
        if (iG == i6) {
            C();
        }
        this.f1873a.write(str);
        return this;
    }

    public c A(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f1880h != null) {
            throw new IllegalStateException();
        }
        if (this.f1875c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f1880h = str;
        return this;
    }

    public c D() throws IOException {
        if (this.f1880h != null) {
            if (!this.f1881i) {
                this.f1880h = null;
                return this;
            }
            d0();
        }
        c();
        this.f1873a.write("null");
        return this;
    }

    public final void N(boolean z5) {
        this.f1879g = z5;
    }

    public final void O(String str) {
        if (str.length() == 0) {
            this.f1876d = null;
            this.f1877e = ":";
        } else {
            this.f1876d = str;
            this.f1877e = ": ";
        }
    }

    public final void S(boolean z5) {
        this.f1878f = z5;
    }

    public final void T(boolean z5) {
        this.f1881i = z5;
    }

    public c V(long j5) throws IOException {
        d0();
        c();
        this.f1873a.write(Long.toString(j5));
        return this;
    }

    public c W(Boolean bool) throws IOException {
        if (bool == null) {
            return D();
        }
        d0();
        c();
        this.f1873a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c X(Number number) throws IOException {
        if (number == null) {
            return D();
        }
        d0();
        String string = number.toString();
        if (this.f1878f || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            c();
            this.f1873a.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public c Y(String str) throws IOException {
        if (str == null) {
            return D();
        }
        d0();
        c();
        U(str);
        return this;
    }

    public c c0(boolean z5) throws IOException {
        d0();
        c();
        this.f1873a.write(z5 ? "true" : "false");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1873a.close();
        int i5 = this.f1875c;
        if (i5 > 1 || (i5 == 1 && this.f1874b[i5 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f1875c = 0;
    }

    public c f() throws IOException {
        d0();
        return E(1, "[");
    }

    public void flush() throws IOException {
        if (this.f1875c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f1873a.flush();
    }

    public c m() throws IOException {
        d0();
        return E(3, "{");
    }

    public c r() {
        return o(1, 2, "]");
    }

    public c u() {
        return o(3, 5, "}");
    }

    public final boolean v() {
        return this.f1881i;
    }

    public final boolean w() {
        return this.f1879g;
    }

    public boolean x() {
        return this.f1878f;
    }
}
