package q0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import l0.AbstractC0822a;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class e0 extends Writer {

    /* renamed from: s, reason: collision with root package name */
    private static final ThreadLocal<char[]> f19790s = new ThreadLocal<>();

    /* renamed from: t, reason: collision with root package name */
    private static final ThreadLocal<byte[]> f19791t = new ThreadLocal<>();

    /* renamed from: u, reason: collision with root package name */
    private static final char[] f19792u = ":true".toCharArray();

    /* renamed from: v, reason: collision with root package name */
    private static final char[] f19793v = ":false".toCharArray();

    /* renamed from: w, reason: collision with root package name */
    private static int f19794w;

    /* renamed from: x, reason: collision with root package name */
    static final int f19795x;

    /* renamed from: a, reason: collision with root package name */
    protected char[] f19796a;

    /* renamed from: b, reason: collision with root package name */
    protected int f19797b;

    /* renamed from: c, reason: collision with root package name */
    protected int f19798c;

    /* renamed from: d, reason: collision with root package name */
    private final Writer f19799d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f19800e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f19801f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f19802g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f19803h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f19804i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f19805j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f19806k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f19807l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f19808m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f19809n;

    /* renamed from: o, reason: collision with root package name */
    protected char f19810o;

    /* renamed from: p, reason: collision with root package name */
    protected int f19811p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f19812q;

    /* renamed from: r, reason: collision with root package name */
    protected long f19813r;

    static {
        int i5;
        f19794w = 131072;
        try {
            String strH = u0.g.h("fastjson.serializer_buffer_threshold");
            if (strH != null && strH.length() > 0 && (i5 = Integer.parseInt(strH)) >= 64 && i5 <= 65536) {
                f19794w = i5 * 1024;
            }
        } catch (Throwable unused) {
        }
        f19795x = f0.UseSingleQuotes.f19849a | f0.BrowserCompatible.f19849a | f0.PrettyFormat.f19849a | f0.WriteEnumUsingToString.f19849a | f0.WriteNonStringValueAsString.f19849a | f0.WriteSlashAsSpecial.f19849a | f0.IgnoreErrorGetter.f19849a | f0.WriteClassName.f19849a | f0.NotWriteDefaultValue.f19849a;
    }

    public e0() {
        this(null);
    }

    private void W(String str) {
        int i5;
        byte[] bArr = u0.g.f22759g;
        int length = str.length();
        int i6 = 1;
        int i7 = this.f19797b + length + 1;
        if (i7 > this.f19796a.length) {
            if (this.f19799d != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        i6 = 0;
                        break;
                    }
                    char cCharAt = str.charAt(i8);
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (i6 != 0) {
                    write(39);
                }
                for (int i9 = 0; i9 < length; i9++) {
                    char cCharAt2 = str.charAt(i9);
                    if (cCharAt2 >= bArr.length || bArr[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(u0.g.f22762j[cCharAt2]);
                    }
                }
                if (i6 != 0) {
                    write(39);
                }
                write(58);
                return;
            }
            r(i7);
        }
        if (length == 0) {
            int i10 = this.f19797b;
            if (i10 + 3 > this.f19796a.length) {
                r(i10 + 3);
            }
            char[] cArr = this.f19796a;
            int i11 = this.f19797b;
            int i12 = i11 + 1;
            this.f19797b = i12;
            cArr[i11] = '\'';
            int i13 = i11 + 2;
            this.f19797b = i13;
            cArr[i12] = '\'';
            this.f19797b = i11 + 3;
            cArr[i13] = ':';
            return;
        }
        int i14 = this.f19797b;
        int i15 = i14 + length;
        str.getChars(0, length, this.f19796a, i14);
        this.f19797b = i7;
        int i16 = i14;
        int i17 = 0;
        while (i16 < i15) {
            char[] cArr2 = this.f19796a;
            char c6 = cArr2[i16];
            if (c6 >= bArr.length || bArr[c6] == 0) {
                i5 = i6;
            } else if (i17 == 0) {
                i7 += 3;
                if (i7 > cArr2.length) {
                    r(i7);
                }
                this.f19797b = i7;
                char[] cArr3 = this.f19796a;
                int i18 = i16 + 1;
                System.arraycopy(cArr3, i18, cArr3, i16 + 3, (i15 - i16) - i6);
                char[] cArr4 = this.f19796a;
                System.arraycopy(cArr4, 0, cArr4, i6, i16);
                char[] cArr5 = this.f19796a;
                cArr5[i14] = '\'';
                cArr5[i18] = '\\';
                i16 += 2;
                cArr5[i16] = u0.g.f22762j[c6];
                i15 += 2;
                cArr5[this.f19797b - 2] = '\'';
                i17 = i6;
                i5 = i17;
            } else {
                i7++;
                if (i7 > cArr2.length) {
                    r(i7);
                }
                this.f19797b = i7;
                char[] cArr6 = this.f19796a;
                int i19 = i16 + 1;
                i5 = i6;
                System.arraycopy(cArr6, i19, cArr6, i16 + 2, i15 - i16);
                char[] cArr7 = this.f19796a;
                cArr7[i16] = '\\';
                cArr7[i19] = u0.g.f22762j[c6];
                i15++;
                i16 = i19;
            }
            i16++;
            i6 = i5;
        }
        this.f19796a[i7 - 1] = ':';
    }

    public void A(double d6, boolean z5) throws IOException {
        if (Double.isNaN(d6) || Double.isInfinite(d6)) {
            Y();
            return;
        }
        int i5 = this.f19797b + 24;
        if (i5 > this.f19796a.length) {
            if (this.f19799d != null) {
                String strB = u0.l.b(d6);
                write(strB, 0, strB.length());
                if (z5 && v(f0.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
            r(i5);
        }
        this.f19797b += u0.l.a(d6, this.f19796a, this.f19797b);
        if (z5 && v(f0.WriteClassName)) {
            write(68);
        }
    }

    public void C(Enum<?> r22) {
        if (r22 == null) {
            Y();
            return;
        }
        String string = (!this.f19807l || this.f19808m) ? this.f19808m ? r22.toString() : null : r22.name();
        if (string == null) {
            V(r22.ordinal());
            return;
        }
        int i5 = v(f0.UseSingleQuotes) ? 39 : 34;
        write(i5);
        write(string);
        write(i5);
    }

    public void D(String str) {
        E(str, false);
    }

    public void E(String str, boolean z5) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.f19800e) {
            if (!this.f19801f) {
                W(str);
                return;
            } else {
                l0(str);
                write(58);
                return;
            }
        }
        if (this.f19801f) {
            k0(str, ':');
            return;
        }
        int i5 = 0;
        boolean z6 = true;
        boolean z7 = str.length() == 0;
        while (true) {
            if (i5 >= str.length()) {
                z6 = z7;
                break;
            }
            char cCharAt = str.charAt(i5);
            if ((cCharAt < '@' && (this.f19813r & (1 << cCharAt)) != 0) || cCharAt == '\\') {
                break;
            } else {
                i5++;
            }
        }
        if (z6) {
            k0(str, ':');
        } else {
            write(str);
            write(58);
        }
    }

    public void G(char c6, String str, double d6) throws IOException {
        write(c6);
        D(str);
        A(d6, false);
    }

    public void I(char c6, String str, int i5) {
        if (i5 == Integer.MIN_VALUE || !this.f19801f) {
            write(c6);
            D(str);
            V(i5);
            return;
        }
        int iK = i5 < 0 ? u0.g.k(-i5) + 1 : u0.g.k(i5);
        int length = str.length();
        int i6 = this.f19797b + length + 4 + iK;
        if (i6 > this.f19796a.length) {
            if (this.f19799d != null) {
                write(c6);
                D(str);
                V(i5);
                return;
            }
            r(i6);
        }
        int i7 = this.f19797b;
        this.f19797b = i6;
        char[] cArr = this.f19796a;
        cArr[i7] = c6;
        int i8 = i7 + length;
        cArr[i7 + 1] = this.f19810o;
        str.getChars(0, length, cArr, i7 + 2);
        char[] cArr2 = this.f19796a;
        cArr2[i8 + 2] = this.f19810o;
        cArr2[i8 + 3] = ':';
        u0.g.f(i5, this.f19797b, cArr2);
    }

    public void L(char c6, String str, long j5) {
        if (j5 == Long.MIN_VALUE || !this.f19801f || u(f0.BrowserCompatible.f19849a)) {
            write(c6);
            D(str);
            X(j5);
            return;
        }
        int iL = j5 < 0 ? u0.g.l(-j5) + 1 : u0.g.l(j5);
        int length = str.length();
        int i5 = this.f19797b + length + 4 + iL;
        if (i5 > this.f19796a.length) {
            if (this.f19799d != null) {
                write(c6);
                D(str);
                X(j5);
                return;
            }
            r(i5);
        }
        int i6 = this.f19797b;
        this.f19797b = i5;
        char[] cArr = this.f19796a;
        cArr[i6] = c6;
        int i7 = i6 + length;
        cArr[i6 + 1] = this.f19810o;
        str.getChars(0, length, cArr, i6 + 2);
        char[] cArr2 = this.f19796a;
        cArr2[i7 + 2] = this.f19810o;
        cArr2[i7 + 3] = ':';
        u0.g.g(j5, this.f19797b, cArr2);
    }

    public void N(char c6, String str, String str2) {
        if (!this.f19801f) {
            write(c6);
            D(str);
            if (str2 == null) {
                Y();
                return;
            } else {
                h0(str2);
                return;
            }
        }
        if (this.f19800e) {
            write(c6);
            D(str);
            if (str2 == null) {
                Y();
                return;
            } else {
                h0(str2);
                return;
            }
        }
        if (!v(f0.BrowserCompatible)) {
            S(c6, str, str2);
            return;
        }
        write(c6);
        k0(str, ':');
        k0(str2, (char) 0);
    }

    public void O(char c6, String str, BigDecimal bigDecimal) {
        write(c6);
        D(str);
        if (bigDecimal == null) {
            Y();
        } else {
            int iScale = bigDecimal.scale();
            write((!v(f0.WriteBigDecimalAsPlain) || iScale < -100 || iScale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4 A[PHI: r4 r9 r10 r13
      0x00a4: PHI (r4v26 int) = (r4v23 int), (r4v27 int) binds: [B:55:0x00dd, B:32:0x009f] A[DONT_GENERATE, DONT_INLINE]
      0x00a4: PHI (r9v8 int) = (r9v5 int), (r9v9 int) binds: [B:55:0x00dd, B:32:0x009f] A[DONT_GENERATE, DONT_INLINE]
      0x00a4: PHI (r10v14 int) = (r10v3 int), (r10v15 int) binds: [B:55:0x00dd, B:32:0x009f] A[DONT_GENERATE, DONT_INLINE]
      0x00a4: PHI (r13v14 int) = (r13v10 int), (r13v16 int) binds: [B:55:0x00dd, B:32:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S(char r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.e0.S(char, java.lang.String, java.lang.String):void");
    }

    public void T(float f5, boolean z5) throws IOException {
        if (f5 != f5 || f5 == Float.POSITIVE_INFINITY || f5 == Float.NEGATIVE_INFINITY) {
            Y();
            return;
        }
        int i5 = this.f19797b + 15;
        if (i5 > this.f19796a.length) {
            if (this.f19799d != null) {
                String strB = u0.m.b(f5);
                write(strB, 0, strB.length());
                if (z5 && v(f0.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
            r(i5);
        }
        this.f19797b += u0.m.a(f5, this.f19796a, this.f19797b);
        if (z5 && v(f0.WriteClassName)) {
            write(70);
        }
    }

    public void U(byte[] bArr) {
        int length = this.f19797b + (bArr.length * 2) + 3;
        if (length > this.f19796a.length) {
            r(length);
        }
        char[] cArr = this.f19796a;
        int i5 = this.f19797b;
        int i6 = i5 + 1;
        this.f19797b = i6;
        cArr[i5] = 'x';
        this.f19797b = i5 + 2;
        cArr[i6] = '\'';
        for (byte b6 : bArr) {
            int i7 = (b6 & 255) >> 4;
            int i8 = b6 & 15;
            char[] cArr2 = this.f19796a;
            int i9 = this.f19797b;
            int i10 = i9 + 1;
            this.f19797b = i10;
            int i11 = 55;
            cArr2[i9] = (char) (i7 + (i7 < 10 ? 48 : 55));
            this.f19797b = i9 + 2;
            if (i8 < 10) {
                i11 = 48;
            }
            cArr2[i10] = (char) (i8 + i11);
        }
        char[] cArr3 = this.f19796a;
        int i12 = this.f19797b;
        this.f19797b = i12 + 1;
        cArr3[i12] = '\'';
    }

    public void V(int i5) {
        if (i5 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iK = i5 < 0 ? u0.g.k(-i5) + 1 : u0.g.k(i5);
        int i6 = this.f19797b + iK;
        if (i6 > this.f19796a.length) {
            if (this.f19799d != null) {
                char[] cArr = new char[iK];
                u0.g.f(i5, iK, cArr);
                write(cArr, 0, iK);
                return;
            }
            r(i6);
        }
        u0.g.f(i5, i6, this.f19796a);
        this.f19797b = i6;
    }

    public void X(long j5) {
        boolean z5 = v(f0.BrowserCompatible) && !v(f0.WriteClassName) && (j5 > 9007199254740991L || j5 < -9007199254740991L);
        if (j5 == Long.MIN_VALUE) {
            if (z5) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int iL = j5 < 0 ? u0.g.l(-j5) + 1 : u0.g.l(j5);
        int i5 = this.f19797b + iL;
        if (z5) {
            i5 += 2;
        }
        if (i5 > this.f19796a.length) {
            if (this.f19799d != null) {
                char[] cArr = new char[iL];
                u0.g.g(j5, iL, cArr);
                if (!z5) {
                    write(cArr, 0, iL);
                    return;
                }
                write(34);
                write(cArr, 0, iL);
                write(34);
                return;
            }
            r(i5);
        }
        if (z5) {
            char[] cArr2 = this.f19796a;
            cArr2[this.f19797b] = '\"';
            int i6 = i5 - 1;
            u0.g.g(j5, i6, cArr2);
            this.f19796a[i6] = '\"';
        } else {
            u0.g.g(j5, i5, this.f19796a);
        }
        this.f19797b = i5;
    }

    public void Y() {
        write("null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e0 append(char c6) {
        write(c6);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e0 append(CharSequence charSequence) throws IOException {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    public void c0(int i5, int i6) {
        if ((i5 & i6) == 0 && (this.f19798c & i6) == 0) {
            Y();
            return;
        }
        int i7 = f0.WriteMapNullValue.f19849a;
        if ((i5 & i7) != 0 && (i5 & (~i7) & f0.f19822G) == 0) {
            Y();
            return;
        }
        if (i6 == f0.WriteNullListAsEmpty.f19849a) {
            write("[]");
            return;
        }
        if (i6 == f0.WriteNullStringAsEmpty.f19849a) {
            h0(BuildConfig.FLAVOR);
            return;
        }
        if (i6 == f0.WriteNullBooleanAsFalse.f19849a) {
            write("false");
        } else if (i6 == f0.WriteNullNumberAsZero.f19849a) {
            write(48);
        } else {
            Y();
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f19799d != null && this.f19797b > 0) {
            flush();
        }
        char[] cArr = this.f19796a;
        if (cArr.length <= f19794w) {
            f19790s.set(cArr);
        }
        this.f19796a = null;
    }

    public void d0(f0 f0Var) {
        c0(0, f0Var.f19849a);
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e0 append(CharSequence charSequence, int i5, int i6) throws IOException {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i5, i6).toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        Writer writer = this.f19799d;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.f19796a, 0, this.f19797b);
            this.f19799d.flush();
            this.f19797b = 0;
        } catch (IOException e6) {
            throw new l0.d(e6.getMessage(), e6);
        }
    }

    public void h0(String str) {
        if (this.f19800e) {
            l0(str);
        } else {
            k0(str, (char) 0);
        }
    }

    public void j0(char[] cArr) {
        if (this.f19800e) {
            m0(cArr);
        } else {
            k0(new String(cArr), (char) 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x02c7 A[PHI: r5 r7 r11 r15
      0x02c7: PHI (r5v19 int) = (r5v17 int), (r5v21 int) binds: [B:169:0x02fd, B:147:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c7: PHI (r7v29 int) = (r7v22 int), (r7v3 int) binds: [B:169:0x02fd, B:147:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c7: PHI (r11v12 int) = (r11v10 int), (r11v14 int) binds: [B:169:0x02fd, B:147:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c7: PHI (r15v12 int) = (r15v2 int), (r15v14 int) binds: [B:169:0x02fd, B:147:0x02c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k0(java.lang.String r25, char r26) {
        /*
            Method dump skipped, instructions count: 1351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.e0.k0(java.lang.String, char):void");
    }

    protected void l0(String str) {
        int i5 = 0;
        if (str == null) {
            int i6 = this.f19797b + 4;
            if (i6 > this.f19796a.length) {
                r(i6);
            }
            "null".getChars(0, 4, this.f19796a, this.f19797b);
            this.f19797b = i6;
            return;
        }
        int length = str.length();
        int i7 = this.f19797b + length + 2;
        if (i7 > this.f19796a.length) {
            if (this.f19799d != null) {
                write(39);
                while (i5 < str.length()) {
                    char cCharAt = str.charAt(i5);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && v(f0.WriteSlashAsSpecial))) {
                        write(92);
                        write(u0.g.f22762j[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i5++;
                }
                write(39);
                return;
            }
            r(i7);
        }
        int i8 = this.f19797b;
        int i9 = i8 + 1;
        int i10 = i9 + length;
        char[] cArr = this.f19796a;
        cArr[i8] = '\'';
        str.getChars(0, length, cArr, i9);
        this.f19797b = i7;
        int i11 = -1;
        char c6 = 0;
        for (int i12 = i9; i12 < i10; i12++) {
            char c7 = this.f19796a[i12];
            if (c7 <= '\r' || c7 == '\\' || c7 == '\'' || (c7 == '/' && v(f0.WriteSlashAsSpecial))) {
                i5++;
                i11 = i12;
                c6 = c7;
            }
        }
        int i13 = i7 + i5;
        if (i13 > this.f19796a.length) {
            r(i13);
        }
        this.f19797b = i13;
        if (i5 == 1) {
            char[] cArr2 = this.f19796a;
            int i14 = i11 + 1;
            System.arraycopy(cArr2, i14, cArr2, i11 + 2, (i10 - i11) - 1);
            char[] cArr3 = this.f19796a;
            cArr3[i11] = '\\';
            cArr3[i14] = u0.g.f22762j[c6];
        } else if (i5 > 1) {
            char[] cArr4 = this.f19796a;
            int i15 = i11 + 1;
            System.arraycopy(cArr4, i15, cArr4, i11 + 2, (i10 - i11) - 1);
            char[] cArr5 = this.f19796a;
            cArr5[i11] = '\\';
            cArr5[i15] = u0.g.f22762j[c6];
            int i16 = i10 + 1;
            for (int i17 = i11 - 1; i17 >= i9; i17--) {
                char c8 = this.f19796a[i17];
                if (c8 <= '\r' || c8 == '\\' || c8 == '\'' || (c8 == '/' && v(f0.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f19796a;
                    int i18 = i17 + 1;
                    System.arraycopy(cArr6, i18, cArr6, i17 + 2, (i16 - i17) - 1);
                    char[] cArr7 = this.f19796a;
                    cArr7[i17] = '\\';
                    cArr7[i18] = u0.g.f22762j[c8];
                    i16++;
                }
            }
        }
        this.f19796a[this.f19797b - 1] = '\'';
    }

    protected void m() {
        int i5 = this.f19798c;
        boolean z5 = (f0.QuoteFieldNames.f19849a & i5) != 0;
        this.f19801f = z5;
        boolean z6 = (f0.UseSingleQuotes.f19849a & i5) != 0;
        this.f19800e = z6;
        this.f19802g = (f0.SortField.f19849a & i5) != 0;
        this.f19803h = (f0.DisableCircularReferenceDetect.f19849a & i5) != 0;
        boolean z7 = (f0.BeanToArray.f19849a & i5) != 0;
        this.f19804i = z7;
        this.f19805j = (f0.WriteNonStringValueAsString.f19849a & i5) != 0;
        this.f19806k = (f0.NotWriteDefaultValue.f19849a & i5) != 0;
        boolean z8 = (f0.WriteEnumUsingName.f19849a & i5) != 0;
        this.f19807l = z8;
        this.f19808m = (f0.WriteEnumUsingToString.f19849a & i5) != 0;
        this.f19809n = z5 && (f19795x & i5) == 0 && (z7 || z8);
        this.f19810o = z6 ? '\'' : '\"';
        boolean z9 = (f0.BrowserSecure.f19849a & i5) != 0;
        this.f19812q = z9;
        this.f19813r = z9 ? 5764610843043954687L : (i5 & f0.WriteSlashAsSpecial.f19849a) != 0 ? 140758963191807L : 21474836479L;
    }

    protected void m0(char[] cArr) {
        int i5 = 0;
        if (cArr == null) {
            int i6 = this.f19797b + 4;
            if (i6 > this.f19796a.length) {
                r(i6);
            }
            "null".getChars(0, 4, this.f19796a, this.f19797b);
            this.f19797b = i6;
            return;
        }
        int length = cArr.length;
        int i7 = this.f19797b + length + 2;
        if (i7 > this.f19796a.length) {
            if (this.f19799d != null) {
                write(39);
                while (i5 < cArr.length) {
                    char c6 = cArr[i5];
                    if (c6 <= '\r' || c6 == '\\' || c6 == '\'' || (c6 == '/' && v(f0.WriteSlashAsSpecial))) {
                        write(92);
                        write(u0.g.f22762j[c6]);
                    } else {
                        write(c6);
                    }
                    i5++;
                }
                write(39);
                return;
            }
            r(i7);
        }
        int i8 = this.f19797b;
        int i9 = i8 + 1;
        int i10 = length + i9;
        char[] cArr2 = this.f19796a;
        cArr2[i8] = '\'';
        System.arraycopy(cArr, 0, cArr2, i9, cArr.length);
        this.f19797b = i7;
        int i11 = -1;
        char c7 = 0;
        for (int i12 = i9; i12 < i10; i12++) {
            char c8 = this.f19796a[i12];
            if (c8 <= '\r' || c8 == '\\' || c8 == '\'' || (c8 == '/' && v(f0.WriteSlashAsSpecial))) {
                i5++;
                i11 = i12;
                c7 = c8;
            }
        }
        int i13 = i7 + i5;
        if (i13 > this.f19796a.length) {
            r(i13);
        }
        this.f19797b = i13;
        if (i5 == 1) {
            char[] cArr3 = this.f19796a;
            int i14 = i11 + 1;
            System.arraycopy(cArr3, i14, cArr3, i11 + 2, (i10 - i11) - 1);
            char[] cArr4 = this.f19796a;
            cArr4[i11] = '\\';
            cArr4[i14] = u0.g.f22762j[c7];
        } else if (i5 > 1) {
            char[] cArr5 = this.f19796a;
            int i15 = i11 + 1;
            System.arraycopy(cArr5, i15, cArr5, i11 + 2, (i10 - i11) - 1);
            char[] cArr6 = this.f19796a;
            cArr6[i11] = '\\';
            cArr6[i15] = u0.g.f22762j[c7];
            int i16 = i10 + 1;
            for (int i17 = i11 - 1; i17 >= i9; i17--) {
                char c9 = this.f19796a[i17];
                if (c9 <= '\r' || c9 == '\\' || c9 == '\'' || (c9 == '/' && v(f0.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.f19796a;
                    int i18 = i17 + 1;
                    System.arraycopy(cArr7, i18, cArr7, i17 + 2, (i16 - i17) - 1);
                    char[] cArr8 = this.f19796a;
                    cArr8[i17] = '\\';
                    cArr8[i18] = u0.g.f22762j[c9];
                    i16++;
                }
            }
        }
        this.f19796a[this.f19797b - 1] = '\'';
    }

    public void o(f0 f0Var, boolean z5) {
        if (z5) {
            int iB = this.f19798c | f0Var.b();
            this.f19798c = iB;
            f0 f0Var2 = f0.WriteEnumUsingToString;
            if (f0Var == f0Var2) {
                this.f19798c = (~f0.WriteEnumUsingName.b()) & iB;
            } else if (f0Var == f0.WriteEnumUsingName) {
                this.f19798c = (~f0Var2.b()) & iB;
            }
        } else {
            this.f19798c = (~f0Var.b()) & this.f19798c;
        }
        m();
    }

    public void r(int i5) {
        ThreadLocal<char[]> threadLocal;
        char[] cArr;
        int i6 = this.f19811p;
        if (i6 != -1 && i5 >= i6) {
            throw new l0.d("serialize exceeded MAX_OUTPUT_LENGTH=" + this.f19811p + ", minimumCapacity=" + i5);
        }
        char[] cArr2 = this.f19796a;
        int length = cArr2.length + (cArr2.length >> 1) + 1;
        if (length >= i5) {
            i5 = length;
        }
        char[] cArr3 = new char[i5];
        System.arraycopy(cArr2, 0, cArr3, 0, this.f19797b);
        if (this.f19796a.length < f19794w && ((cArr = (threadLocal = f19790s).get()) == null || cArr.length < this.f19796a.length)) {
            threadLocal.set(this.f19796a);
        }
        this.f19796a = cArr3;
    }

    public String toString() {
        return new String(this.f19796a, 0, this.f19797b);
    }

    public boolean u(int i5) {
        return (this.f19798c & i5) != 0;
    }

    public boolean v(f0 f0Var) {
        return (this.f19798c & f0Var.f19849a) != 0;
    }

    public void w(boolean z5) {
        if (z5) {
            write("true");
        } else {
            write("false");
        }
    }

    @Override // java.io.Writer
    public void write(int i5) {
        int i6 = 1;
        int i7 = this.f19797b + 1;
        if (i7 <= this.f19796a.length) {
            i6 = i7;
        } else if (this.f19799d == null) {
            r(i7);
            i6 = i7;
        } else {
            flush();
        }
        this.f19796a[this.f19797b] = (char) i5;
        this.f19797b = i6;
    }

    public void x(byte[] bArr) {
        if (u(f0.WriteClassName.f19849a)) {
            U(bArr);
            return;
        }
        int length = bArr.length;
        boolean z5 = this.f19800e;
        char c6 = z5 ? '\'' : '\"';
        if (length == 0) {
            write(z5 ? "''" : "\"\"");
            return;
        }
        char[] cArr = u0.g.f22768p;
        int i5 = (length / 3) * 3;
        int i6 = length - 1;
        int i7 = this.f19797b;
        int i8 = (((i6 / 3) + 1) << 2) + i7;
        int i9 = i8 + 2;
        if (i9 > this.f19796a.length) {
            if (this.f19799d != null) {
                write(c6);
                int i10 = 0;
                while (i10 < i5) {
                    int i11 = i10 + 2;
                    int i12 = ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10] & 255) << 16);
                    i10 += 3;
                    int i13 = i12 | (bArr[i11] & 255);
                    write(cArr[(i13 >>> 18) & 63]);
                    write(cArr[(i13 >>> 12) & 63]);
                    write(cArr[(i13 >>> 6) & 63]);
                    write(cArr[i13 & 63]);
                }
                int i14 = length - i5;
                if (i14 > 0) {
                    int i15 = ((bArr[i5] & 255) << 10) | (i14 == 2 ? (bArr[i6] & 255) << 2 : 0);
                    write(cArr[i15 >> 12]);
                    write(cArr[(i15 >>> 6) & 63]);
                    write(i14 == 2 ? cArr[i15 & 63] : '=');
                    write(61);
                }
                write(c6);
                return;
            }
            r(i9);
        }
        this.f19797b = i9;
        int i16 = i7 + 1;
        this.f19796a[i7] = c6;
        int i17 = 0;
        while (i17 < i5) {
            int i18 = i17 + 2;
            int i19 = ((bArr[i17 + 1] & 255) << 8) | ((bArr[i17] & 255) << 16);
            i17 += 3;
            int i20 = i19 | (bArr[i18] & 255);
            char[] cArr2 = this.f19796a;
            cArr2[i16] = cArr[(i20 >>> 18) & 63];
            cArr2[i16 + 1] = cArr[(i20 >>> 12) & 63];
            int i21 = i16 + 3;
            cArr2[i16 + 2] = cArr[(i20 >>> 6) & 63];
            i16 += 4;
            cArr2[i21] = cArr[i20 & 63];
        }
        int i22 = length - i5;
        if (i22 > 0) {
            int i23 = ((bArr[i5] & 255) << 10) | (i22 == 2 ? (bArr[i6] & 255) << 2 : 0);
            char[] cArr3 = this.f19796a;
            cArr3[i8 - 3] = cArr[i23 >> 12];
            cArr3[i8 - 2] = cArr[(i23 >>> 6) & 63];
            cArr3[i8 - 1] = i22 == 2 ? cArr[i23 & 63] : '=';
            cArr3[i8] = '=';
        }
        this.f19796a[i8 + 1] = c6;
    }

    public e0(Writer writer) {
        this(writer, AbstractC0822a.f18022g, f0.f19821F);
    }

    public e0(Writer writer, int i5, f0... f0VarArr) {
        this.f19811p = -1;
        this.f19799d = writer;
        ThreadLocal<char[]> threadLocal = f19790s;
        char[] cArr = threadLocal.get();
        this.f19796a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.f19796a = new char[RecyclerView.ItemAnimator.FLAG_MOVED];
        }
        for (f0 f0Var : f0VarArr) {
            i5 |= f0Var.b();
        }
        this.f19798c = i5;
        m();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) throws IOException {
        int i7;
        if (i5 < 0 || i5 > cArr.length || i6 < 0 || (i7 = i5 + i6) > cArr.length || i7 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i6 == 0) {
            return;
        }
        int i8 = this.f19797b + i6;
        if (i8 > this.f19796a.length) {
            if (this.f19799d == null) {
                r(i8);
            } else {
                do {
                    char[] cArr2 = this.f19796a;
                    int length = cArr2.length;
                    int i9 = this.f19797b;
                    int i10 = length - i9;
                    System.arraycopy(cArr, i5, cArr2, i9, i10);
                    this.f19797b = this.f19796a.length;
                    flush();
                    i6 -= i10;
                    i5 += i10;
                } while (i6 > this.f19796a.length);
                i8 = i6;
            }
        }
        System.arraycopy(cArr, i5, this.f19796a, this.f19797b, i6);
        this.f19797b = i8;
    }

    @Override // java.io.Writer
    public void write(String str, int i5, int i6) throws IOException {
        int i7;
        int i8 = this.f19797b + i6;
        if (i8 > this.f19796a.length) {
            if (this.f19799d == null) {
                r(i8);
            } else {
                while (true) {
                    char[] cArr = this.f19796a;
                    int length = cArr.length;
                    int i9 = this.f19797b;
                    int i10 = length - i9;
                    i7 = i5 + i10;
                    str.getChars(i5, i7, cArr, i9);
                    this.f19797b = this.f19796a.length;
                    flush();
                    i6 -= i10;
                    if (i6 <= this.f19796a.length) {
                        break;
                    } else {
                        i5 = i7;
                    }
                }
                i8 = i6;
                i5 = i7;
            }
        }
        str.getChars(i5, i6 + i5, this.f19796a, this.f19797b);
        this.f19797b = i8;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            Y();
        } else {
            write(str, 0, str.length());
        }
    }
}
