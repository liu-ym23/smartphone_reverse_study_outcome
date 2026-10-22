package u7;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import r2.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public final Reader f14148c;

    /* renamed from: l, reason: collision with root package name */
    public long f14154l;

    /* renamed from: m, reason: collision with root package name */
    public int f14155m;

    /* renamed from: n, reason: collision with root package name */
    public String f14156n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f14157o;

    /* renamed from: q, reason: collision with root package name */
    public String[] f14159q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f14160r;

    /* renamed from: s, reason: collision with root package name */
    public int f14161s = 2;

    /* renamed from: f, reason: collision with root package name */
    public final char[] f14149f = new char[1024];

    /* renamed from: g, reason: collision with root package name */
    public int f14150g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f14151h = 0;
    public int i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f14152j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f14153k = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f14158p = 1;

    static {
        i.f10409g = new i(20);
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f14157o = iArr;
        iArr[0] = 6;
        this.f14159q = new String[32];
        this.f14160r = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f14148c = reader;
    }

    public String A() {
        return C(false);
    }

    public final String C(boolean z10) {
        StringBuilder sb2 = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i3 = this.f14158p;
            if (i >= i3) {
                return sb2.toString();
            }
            int i10 = this.f14157o[i];
            switch (i10) {
                case 1:
                case 2:
                    int i11 = this.f14160r[i];
                    if (z10 && i11 > 0 && i == i3 - 1) {
                        i11--;
                    }
                    sb2.append('[');
                    sb2.append(i11);
                    sb2.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb2.append('.');
                    String str = this.f14159q[i];
                    if (str == null) {
                        break;
                    } else {
                        sb2.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(k0.a.j(i10, "Unknown scope value: "));
            }
            i++;
        }
    }

    public String F() {
        return C(true);
    }

    public boolean H() throws IOException {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        return (i == 2 || i == 4 || i == 17) ? false : true;
    }

    public final boolean M(char c9) throws d {
        if (c9 == '\t' || c9 == '\n' || c9 == '\f' || c9 == '\r' || c9 == ' ') {
            return false;
        }
        if (c9 != '#') {
            if (c9 == ',') {
                return false;
            }
            if (c9 != '/' && c9 != '=') {
                if (c9 == '{' || c9 == '}' || c9 == ':') {
                    return false;
                }
                if (c9 != ';') {
                    switch (c9) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        g();
        return false;
    }

    final String N() {
        StringBuilder sbU = k0.a.u(" at line ", this.i + 1, " column ", " path ", (this.f14150g - this.f14152j) + 1);
        sbU.append(A());
        return sbU.toString();
    }

    public boolean O() throws IOException {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i == 5) {
            this.f14153k = 0;
            int[] iArr = this.f14160r;
            int i3 = this.f14158p - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i != 6) {
            throw g0("a boolean");
        }
        this.f14153k = 0;
        int[] iArr2 = this.f14160r;
        int i10 = this.f14158p - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return false;
    }

    public double P() throws IOException, NumberFormatException {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            this.f14153k = 0;
            int[] iArr = this.f14160r;
            int i3 = this.f14158p - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f14154l;
        }
        if (i == 16) {
            this.f14156n = new String(this.f14149f, this.f14150g, this.f14155m);
            this.f14150g += this.f14155m;
        } else if (i == 8 || i == 9) {
            this.f14156n = V(i == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
        } else if (i == 10) {
            this.f14156n = X();
        } else if (i != 11) {
            throw g0("a double");
        }
        this.f14153k = 11;
        double d7 = Double.parseDouble(this.f14156n);
        if (this.f14161s != 1 && (Double.isNaN(d7) || Double.isInfinite(d7))) {
            f0("JSON forbids NaN and infinities: " + d7);
            throw null;
        }
        this.f14156n = null;
        this.f14153k = 0;
        int[] iArr2 = this.f14160r;
        int i10 = this.f14158p - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return d7;
    }

    public int Q() throws IOException, NumberFormatException {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            long j10 = this.f14154l;
            int i3 = (int) j10;
            if (j10 == i3) {
                this.f14153k = 0;
                int[] iArr = this.f14160r;
                int i10 = this.f14158p - 1;
                iArr[i10] = iArr[i10] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f14154l + N());
        }
        if (i == 16) {
            this.f14156n = new String(this.f14149f, this.f14150g, this.f14155m);
            this.f14150g += this.f14155m;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw g0("an int");
            }
            if (i == 10) {
                this.f14156n = X();
            } else {
                this.f14156n = V(i == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
            }
            try {
                int i11 = Integer.parseInt(this.f14156n);
                this.f14153k = 0;
                int[] iArr2 = this.f14160r;
                int i12 = this.f14158p - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return i11;
            } catch (NumberFormatException unused) {
            }
        }
        this.f14153k = 11;
        double d7 = Double.parseDouble(this.f14156n);
        int i13 = (int) d7;
        if (i13 == d7) {
            this.f14156n = null;
            this.f14153k = 0;
            int[] iArr3 = this.f14160r;
            int i14 = this.f14158p - 1;
            iArr3[i14] = iArr3[i14] + 1;
            return i13;
        }
        throw new NumberFormatException("Expected an int but was " + this.f14156n + N());
    }

    public long R() throws IOException, NumberFormatException {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            this.f14153k = 0;
            int[] iArr = this.f14160r;
            int i3 = this.f14158p - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f14154l;
        }
        if (i == 16) {
            this.f14156n = new String(this.f14149f, this.f14150g, this.f14155m);
            this.f14150g += this.f14155m;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw g0("a long");
            }
            if (i == 10) {
                this.f14156n = X();
            } else {
                this.f14156n = V(i == 8 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR);
            }
            try {
                long j10 = Long.parseLong(this.f14156n);
                this.f14153k = 0;
                int[] iArr2 = this.f14160r;
                int i10 = this.f14158p - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f14153k = 11;
        double d7 = Double.parseDouble(this.f14156n);
        long j11 = (long) d7;
        if (j11 == d7) {
            this.f14156n = null;
            this.f14153k = 0;
            int[] iArr3 = this.f14160r;
            int i11 = this.f14158p - 1;
            iArr3[i11] = iArr3[i11] + 1;
            return j11;
        }
        throw new NumberFormatException("Expected a long but was " + this.f14156n + N());
    }

    public String S() throws IOException {
        String strV;
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i == 14) {
            strV = X();
        } else if (i == 12) {
            strV = V('\'');
        } else {
            if (i != 13) {
                throw g0("a name");
            }
            strV = V(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        this.f14153k = 0;
        this.f14159q[this.f14158p - 1] = strV;
        return strV;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int T(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.a.T(boolean):int");
    }

    public void U() {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i != 7) {
            throw g0("null");
        }
        this.f14153k = 0;
        int[] iArr = this.f14160r;
        int i3 = this.f14158p - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r11.f14150g = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r11.f14150g = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String V(char r12) throws u7.d {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.f14150g
            int r3 = r11.f14151h
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r11.f14149f
            if (r2 >= r4) goto L6b
            int r8 = r2 + 1
            char r2 = r7[r2]
            int r9 = r11.f14161s
            r10 = 3
            if (r9 != r10) goto L23
            r9 = 32
            if (r2 < r9) goto L1d
            goto L23
        L1d:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.f0(r12)
            throw r0
        L23:
            if (r2 != r12) goto L39
            r11.f14150g = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L31
            java.lang.String r11 = new java.lang.String
            r11.<init>(r7, r3, r8)
            return r11
        L31:
            r1.append(r7, r3, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L39:
            r9 = 92
            if (r2 != r9) goto L5e
            r11.f14150g = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L4f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L4f:
            r1.append(r7, r3, r2)
            char r2 = r11.a0()
            r1.append(r2)
            int r2 = r11.f14150g
            int r3 = r11.f14151h
            goto L6
        L5e:
            r5 = 10
            if (r2 != r5) goto L69
            int r2 = r11.i
            int r2 = r2 + r6
            r11.i = r2
            r11.f14152j = r8
        L69:
            r2 = r8
            goto L8
        L6b:
            if (r1 != 0) goto L7b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r11.f14150g = r2
            boolean r2 = r11.r(r6)
            if (r2 == 0) goto L8a
            goto L2
        L8a:
            java.lang.String r12 = "Unterminated string"
            r11.f0(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.a.V(char):java.lang.String");
    }

    public String W() {
        String str;
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i == 10) {
            str = X();
        } else if (i == 8) {
            str = V('\'');
        } else if (i == 9) {
            str = V(JsonFactory.DEFAULT_QUOTE_CHAR);
        } else if (i == 11) {
            str = this.f14156n;
            this.f14156n = null;
        } else if (i == 15) {
            str = Long.toString(this.f14154l);
        } else {
            if (i != 16) {
                throw g0("a string");
            }
            str = new String(this.f14149f, this.f14150g, this.f14155m);
            this.f14150g += this.f14155m;
        }
        this.f14153k = 0;
        int[] iArr = this.f14160r;
        int i3 = this.f14158p - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        g();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String X() throws u7.d {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f14150g
            int r3 = r3 + r2
            int r4 = r6.f14151h
            char[] r5 = r6.f14149f
            if (r3 >= r4) goto L4c
            char r3 = r5[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r6.g()
            goto L58
        L4c:
            int r3 = r5.length
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r6.r(r3)
            if (r3 == 0) goto L58
            goto L3
        L58:
            r1 = r2
            goto L78
        L5a:
            if (r0 != 0) goto L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L67:
            int r3 = r6.f14150g
            r0.append(r5, r3, r2)
            int r3 = r6.f14150g
            int r3 = r3 + r2
            r6.f14150g = r3
            r2 = 1
            boolean r2 = r6.r(r2)
            if (r2 != 0) goto L2
        L78:
            int r2 = r6.f14150g
            if (r0 != 0) goto L82
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r2, r1)
            goto L89
        L82:
            r0.append(r5, r2, r1)
            java.lang.String r0 = r0.toString()
        L89:
            int r2 = r6.f14150g
            int r2 = r2 + r1
            r6.f14150g = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.a.X():java.lang.String");
    }

    public b Y() {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        switch (i) {
            case 1:
                return b.f14164g;
            case 2:
                return b.f14165h;
            case 3:
                return b.f14162c;
            case 4:
                return b.f14163f;
            case 5:
            case 6:
                return b.f14168l;
            case 7:
                return b.f14169m;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.f14166j;
            case 12:
            case 13:
            case 14:
                return b.i;
            case 15:
            case 16:
                return b.f14167k;
            case 17:
                return b.f14170n;
            default:
                throw new AssertionError();
        }
    }

    public final void Z(int i) throws d {
        int i3 = this.f14158p;
        if (i3 - 1 >= 255) {
            throw new d("Nesting limit 255 reached".concat(N()));
        }
        int[] iArr = this.f14157o;
        if (i3 == iArr.length) {
            int i10 = i3 * 2;
            this.f14157o = Arrays.copyOf(iArr, i10);
            this.f14160r = Arrays.copyOf(this.f14160r, i10);
            this.f14159q = (String[]) Arrays.copyOf(this.f14159q, i10);
        }
        int[] iArr2 = this.f14157o;
        int i11 = this.f14158p;
        this.f14158p = i11 + 1;
        iArr2[i11] = i;
    }

    public final char a0() throws d {
        int i;
        if (this.f14150g == this.f14151h && !r(1)) {
            f0("Unterminated escape sequence");
            throw null;
        }
        int i3 = this.f14150g;
        int i10 = i3 + 1;
        this.f14150g = i10;
        char[] cArr = this.f14149f;
        char c9 = cArr[i3];
        if (c9 != '\n') {
            if (c9 != '\"') {
                if (c9 != '\'') {
                    if (c9 != '/' && c9 != '\\') {
                        if (c9 == 'b') {
                            return '\b';
                        }
                        if (c9 == 'f') {
                            return '\f';
                        }
                        if (c9 == 'n') {
                            return '\n';
                        }
                        if (c9 == 'r') {
                            return '\r';
                        }
                        if (c9 == 't') {
                            return '\t';
                        }
                        if (c9 != 'u') {
                            f0("Invalid escape sequence");
                            throw null;
                        }
                        if (i3 + 5 > this.f14151h && !r(4)) {
                            f0("Unterminated escape sequence");
                            throw null;
                        }
                        int i11 = this.f14150g;
                        int i12 = i11 + 4;
                        int i13 = 0;
                        while (i11 < i12) {
                            char c10 = cArr[i11];
                            int i14 = i13 << 4;
                            if (c10 >= '0' && c10 <= '9') {
                                i = c10 - '0';
                            } else if (c10 >= 'a' && c10 <= 'f') {
                                i = c10 - 'W';
                            } else {
                                if (c10 < 'A' || c10 > 'F') {
                                    f0("Malformed Unicode escape \\u".concat(new String(cArr, this.f14150g, 4)));
                                    throw null;
                                }
                                i = c10 - '7';
                            }
                            i13 = i + i14;
                            i11++;
                        }
                        this.f14150g += 4;
                        return (char) i13;
                    }
                }
            }
            return c9;
        }
        if (this.f14161s == 3) {
            f0("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.i++;
        this.f14152j = i10;
        if (this.f14161s == 3) {
            f0("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c9;
    }

    public final void b0(char c9) throws d {
        do {
            int i = this.f14150g;
            int i3 = this.f14151h;
            while (i < i3) {
                int i10 = i + 1;
                char c10 = this.f14149f[i];
                if (c10 == c9) {
                    this.f14150g = i10;
                    return;
                }
                if (c10 == '\\') {
                    this.f14150g = i10;
                    a0();
                    i = this.f14150g;
                    i3 = this.f14151h;
                } else {
                    if (c10 == '\n') {
                        this.i++;
                        this.f14152j = i10;
                    }
                    i = i10;
                }
            }
            this.f14150g = i;
        } while (r(1));
        f0("Unterminated string");
        throw null;
    }

    public final void c0() {
        char c9;
        do {
            if (this.f14150g >= this.f14151h && !r(1)) {
                return;
            }
            int i = this.f14150g;
            int i3 = i + 1;
            this.f14150g = i3;
            c9 = this.f14149f[i];
            if (c9 == '\n') {
                this.i++;
                this.f14152j = i3;
                return;
            }
        } while (c9 != '\r');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14153k = 0;
        this.f14157o[0] = 8;
        this.f14158p = 1;
        this.f14148c.close();
    }

    public void d() {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i != 3) {
            throw g0("BEGIN_ARRAY");
        }
        Z(1);
        this.f14160r[this.f14158p - 1] = 0;
        this.f14153k = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
    
        g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0() throws u7.d {
        /*
            r3 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r3.f14150g
            int r1 = r1 + r0
            int r2 = r3.f14151h
            if (r1 >= r2) goto L4f
            char[] r2 = r3.f14149f
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L49
            r2 = 10
            if (r1 == r2) goto L49
            r2 = 12
            if (r1 == r2) goto L49
            r2 = 13
            if (r1 == r2) goto L49
            r2 = 32
            if (r1 == r2) goto L49
            r2 = 35
            if (r1 == r2) goto L46
            r2 = 44
            if (r1 == r2) goto L49
            r2 = 47
            if (r1 == r2) goto L46
            r2 = 61
            if (r1 == r2) goto L46
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L49
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L49
            r2 = 58
            if (r1 == r2) goto L49
            r2 = 59
            if (r1 == r2) goto L46
            switch(r1) {
                case 91: goto L49;
                case 92: goto L46;
                case 93: goto L49;
                default: goto L43;
            }
        L43:
            int r0 = r0 + 1
            goto L1
        L46:
            r3.g()
        L49:
            int r1 = r3.f14150g
            int r1 = r1 + r0
            r3.f14150g = r1
            return
        L4f:
            r3.f14150g = r1
            r0 = 1
            boolean r0 = r3.r(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.a.d0():void");
    }

    public void e() {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i != 1) {
            throw g0("BEGIN_OBJECT");
        }
        Z(3);
        this.f14153k = 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void e0() throws IOException {
        int i = 0;
        do {
            int i3 = this.f14153k;
            if (i3 == 0) {
                i3 = i();
            }
            switch (i3) {
                case 1:
                    Z(3);
                    i++;
                    this.f14153k = 0;
                    break;
                case 2:
                    if (i == 0) {
                        this.f14159q[this.f14158p - 1] = null;
                    }
                    this.f14158p--;
                    i--;
                    this.f14153k = 0;
                    break;
                case 3:
                    Z(1);
                    i++;
                    this.f14153k = 0;
                    break;
                case 4:
                    this.f14158p--;
                    i--;
                    this.f14153k = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f14153k = 0;
                    break;
                case 8:
                    b0('\'');
                    this.f14153k = 0;
                    break;
                case 9:
                    b0(JsonFactory.DEFAULT_QUOTE_CHAR);
                    this.f14153k = 0;
                    break;
                case 10:
                    d0();
                    this.f14153k = 0;
                    break;
                case 12:
                    b0('\'');
                    if (i == 0) {
                        this.f14159q[this.f14158p - 1] = "<skipped>";
                    }
                    this.f14153k = 0;
                    break;
                case 13:
                    b0(JsonFactory.DEFAULT_QUOTE_CHAR);
                    if (i == 0) {
                        this.f14159q[this.f14158p - 1] = "<skipped>";
                    }
                    this.f14153k = 0;
                    break;
                case 14:
                    d0();
                    if (i == 0) {
                        this.f14159q[this.f14158p - 1] = "<skipped>";
                    }
                    this.f14153k = 0;
                    break;
                case 16:
                    this.f14150g += this.f14155m;
                    this.f14153k = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i > 0);
        int[] iArr = this.f14160r;
        int i10 = this.f14158p - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    public final void f0(String str) throws d {
        StringBuilder sbC = w2.c.c(str);
        sbC.append(N());
        sbC.append("\nSee ");
        sbC.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
        throw new d(sbC.toString());
    }

    public final void g() throws d {
        if (this.f14161s == 1) {
            return;
        }
        f0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    public final IllegalStateException g0(String str) {
        String str2 = Y() == b.f14169m ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbO = androidx.activity.b.o("Expected ", str, " but was ");
        sbO.append(Y());
        sbO.append(N());
        sbO.append("\nSee ");
        sbO.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(sbO.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x01a5, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0214, code lost:
    
        if (M(r12) != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0217, code lost:
    
        if (r5 != 2) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0219, code lost:
    
        if (r10 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x021f, code lost:
    
        if (r1 != Long.MIN_VALUE) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0221, code lost:
    
        if (r17 == 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0224, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0228, code lost:
    
        if (r1 != 0) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x022a, code lost:
    
        if (r17 != 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x022c, code lost:
    
        if (r17 == 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x022f, code lost:
    
        r1 = -r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0230, code lost:
    
        r24.f14154l = r1;
        r24.f14150g += r7;
        r9 = 15;
        r24.f14153k = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x023c, code lost:
    
        if (r5 == r13) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x023f, code lost:
    
        if (r5 == 4) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0242, code lost:
    
        if (r5 != 7) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0244, code lost:
    
        r24.f14155m = r7;
        r9 = 16;
        r24.f14153k = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x026c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 787
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.a.i():int");
    }

    public void n() {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i != 4) {
            throw g0("END_ARRAY");
        }
        int i3 = this.f14158p;
        this.f14158p = i3 - 1;
        int[] iArr = this.f14160r;
        int i10 = i3 - 2;
        iArr[i10] = iArr[i10] + 1;
        this.f14153k = 0;
    }

    public void o() {
        int i = this.f14153k;
        if (i == 0) {
            i = i();
        }
        if (i != 2) {
            throw g0("END_OBJECT");
        }
        int i3 = this.f14158p;
        int i10 = i3 - 1;
        this.f14158p = i10;
        this.f14159q[i10] = null;
        int[] iArr = this.f14160r;
        int i11 = i3 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f14153k = 0;
    }

    public final boolean r(int i) throws IOException {
        int i3;
        int i10;
        int i11 = this.f14152j;
        int i12 = this.f14150g;
        this.f14152j = i11 - i12;
        int i13 = this.f14151h;
        char[] cArr = this.f14149f;
        if (i13 != i12) {
            int i14 = i13 - i12;
            this.f14151h = i14;
            System.arraycopy(cArr, i12, cArr, 0, i14);
        } else {
            this.f14151h = 0;
        }
        this.f14150g = 0;
        do {
            int i15 = this.f14151h;
            int i16 = this.f14148c.read(cArr, i15, cArr.length - i15);
            if (i16 == -1) {
                return false;
            }
            i3 = this.f14151h + i16;
            this.f14151h = i3;
            if (this.i == 0 && (i10 = this.f14152j) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f14150g++;
                this.f14152j = i10 + 1;
                i++;
            }
        } while (i3 < i);
        return true;
    }

    public String toString() {
        return getClass().getSimpleName().concat(N());
    }
}
