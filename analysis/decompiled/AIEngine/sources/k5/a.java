package k5;

import androidx.datastore.preferences.protobuf.f;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import h0.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final Reader f9920a;

    /* renamed from: l, reason: collision with root package name */
    public long f9927l;

    /* renamed from: m, reason: collision with root package name */
    public int f9928m;

    /* renamed from: n, reason: collision with root package name */
    public String f9929n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f9930o;

    /* renamed from: q, reason: collision with root package name */
    public String[] f9932q;
    public int[] r;

    /* renamed from: b, reason: collision with root package name */
    public Strictness f9921b = Strictness.f5435b;

    /* renamed from: c, reason: collision with root package name */
    public final char[] f9922c = new char[1024];

    /* renamed from: d, reason: collision with root package name */
    public int f9923d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f9924e = 0;
    public int h = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f9925j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f9926k = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f9931p = 1;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: k5.a$a, reason: collision with other inner class name */
    public class C0099a extends f {
    }

    static {
        f.f1806a = new C0099a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f9930o = iArr;
        iArr[0] = 6;
        this.f9932q = new String[32];
        this.r = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f9920a = reader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:169:0x021c, code lost:
    
        if (C0(r12) != false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0274 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int C() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.a.C():int");
    }

    public final boolean C0(char c9) throws MalformedJsonException {
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
        w();
        return false;
    }

    final String G0() {
        StringBuilder sbD = e.d(this.h + 1, " at line ", (this.f9923d - this.f9925j) + 1, " column ", " path ");
        sbD.append(S());
        return sbD.toString();
    }

    public boolean H0() throws IOException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 5) {
            this.f9926k = 0;
            int[] iArr = this.r;
            int i10 = this.f9931p - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iC != 6) {
            throw a1("a boolean");
        }
        this.f9926k = 0;
        int[] iArr2 = this.r;
        int i11 = this.f9931p - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return false;
    }

    public double I0() throws IOException, NumberFormatException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            this.f9926k = 0;
            int[] iArr = this.r;
            int i10 = this.f9931p - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f9927l;
        }
        if (iC == 16) {
            this.f9929n = new String(this.f9922c, this.f9923d, this.f9928m);
            this.f9923d += this.f9928m;
        } else if (iC == 8 || iC == 9) {
            this.f9929n = O0(iC == 8 ? '\'' : '\"');
        } else if (iC == 10) {
            this.f9929n = Q0();
        } else if (iC != 11) {
            throw a1("a double");
        }
        this.f9926k = 11;
        double d8 = Double.parseDouble(this.f9929n);
        if (this.f9921b != Strictness.f5434a && (Double.isNaN(d8) || Double.isInfinite(d8))) {
            Z0("JSON forbids NaN and infinities: " + d8);
            throw null;
        }
        this.f9929n = null;
        this.f9926k = 0;
        int[] iArr2 = this.r;
        int i11 = this.f9931p - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return d8;
    }

    public int J0() throws IOException, NumberFormatException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            long j10 = this.f9927l;
            int i10 = (int) j10;
            if (j10 != i10) {
                throw new NumberFormatException("Expected an int but was " + this.f9927l + G0());
            }
            this.f9926k = 0;
            int[] iArr = this.r;
            int i11 = this.f9931p - 1;
            iArr[i11] = iArr[i11] + 1;
            return i10;
        }
        if (iC == 16) {
            this.f9929n = new String(this.f9922c, this.f9923d, this.f9928m);
            this.f9923d += this.f9928m;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw a1("an int");
            }
            if (iC == 10) {
                this.f9929n = Q0();
            } else {
                this.f9929n = O0(iC == 8 ? '\'' : '\"');
            }
            try {
                int i12 = Integer.parseInt(this.f9929n);
                this.f9926k = 0;
                int[] iArr2 = this.r;
                int i13 = this.f9931p - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        }
        this.f9926k = 11;
        double d8 = Double.parseDouble(this.f9929n);
        int i14 = (int) d8;
        if (i14 != d8) {
            throw new NumberFormatException("Expected an int but was " + this.f9929n + G0());
        }
        this.f9929n = null;
        this.f9926k = 0;
        int[] iArr3 = this.r;
        int i15 = this.f9931p - 1;
        iArr3[i15] = iArr3[i15] + 1;
        return i14;
    }

    public void K() throws IOException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 4) {
            throw a1("END_ARRAY");
        }
        int i10 = this.f9931p;
        this.f9931p = i10 - 1;
        int[] iArr = this.r;
        int i11 = i10 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f9926k = 0;
    }

    public long K0() throws IOException, NumberFormatException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 15) {
            this.f9926k = 0;
            int[] iArr = this.r;
            int i10 = this.f9931p - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f9927l;
        }
        if (iC == 16) {
            this.f9929n = new String(this.f9922c, this.f9923d, this.f9928m);
            this.f9923d += this.f9928m;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw a1("a long");
            }
            if (iC == 10) {
                this.f9929n = Q0();
            } else {
                this.f9929n = O0(iC == 8 ? '\'' : '\"');
            }
            try {
                long j10 = Long.parseLong(this.f9929n);
                this.f9926k = 0;
                int[] iArr2 = this.r;
                int i11 = this.f9931p - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f9926k = 11;
        double d8 = Double.parseDouble(this.f9929n);
        long j11 = (long) d8;
        if (j11 != d8) {
            throw new NumberFormatException("Expected a long but was " + this.f9929n + G0());
        }
        this.f9929n = null;
        this.f9926k = 0;
        int[] iArr3 = this.r;
        int i12 = this.f9931p - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return j11;
    }

    public String L0() throws IOException {
        String strO0;
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 14) {
            strO0 = Q0();
        } else if (iC == 12) {
            strO0 = O0('\'');
        } else {
            if (iC != 13) {
                throw a1("a name");
            }
            strO0 = O0('\"');
        }
        this.f9926k = 0;
        this.f9932q[this.f9931p - 1] = strO0;
        return strO0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int M0(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.a.M0(boolean):int");
    }

    public void N0() throws IOException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 7) {
            throw a1("null");
        }
        this.f9926k = 0;
        int[] iArr = this.r;
        int i10 = this.f9931p - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        r11.f9923d = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r11.f9923d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String O0(char r12) throws com.google.gson.stream.MalformedJsonException {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.f9923d
            int r3 = r11.f9924e
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r11.f9922c
            if (r2 >= r4) goto L6c
            int r8 = r2 + 1
            char r2 = r7[r2]
            com.google.gson.Strictness r9 = r11.f9921b
            com.google.gson.Strictness r10 = com.google.gson.Strictness.f5436c
            if (r9 != r10) goto L24
            r9 = 32
            if (r2 < r9) goto L1e
            goto L24
        L1e:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.Z0(r12)
            throw r0
        L24:
            if (r2 != r12) goto L3a
            r11.f9923d = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L32
            java.lang.String r11 = new java.lang.String
            r11.<init>(r7, r3, r8)
            return r11
        L32:
            r1.append(r7, r3, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L3a:
            r9 = 92
            if (r2 != r9) goto L5f
            r11.f9923d = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L50
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L50:
            r1.append(r7, r3, r2)
            char r2 = r11.T0()
            r1.append(r2)
            int r2 = r11.f9923d
            int r3 = r11.f9924e
            goto L6
        L5f:
            r5 = 10
            if (r2 != r5) goto L6a
            int r2 = r11.h
            int r2 = r2 + r6
            r11.h = r2
            r11.f9925j = r8
        L6a:
            r2 = r8
            goto L8
        L6c:
            if (r1 != 0) goto L7c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7c:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r11.f9923d = r2
            boolean r2 = r11.Q(r6)
            if (r2 == 0) goto L8b
            goto L2
        L8b:
            java.lang.String r12 = "Unterminated string"
            r11.Z0(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.a.O0(char):java.lang.String");
    }

    public void P() throws IOException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 2) {
            throw a1("END_OBJECT");
        }
        int i10 = this.f9931p;
        int i11 = i10 - 1;
        this.f9931p = i11;
        this.f9932q[i11] = null;
        int[] iArr = this.r;
        int i12 = i10 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f9926k = 0;
    }

    public String P0() throws IOException {
        String str;
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC == 10) {
            str = Q0();
        } else if (iC == 8) {
            str = O0('\'');
        } else if (iC == 9) {
            str = O0('\"');
        } else if (iC == 11) {
            str = this.f9929n;
            this.f9929n = null;
        } else if (iC == 15) {
            str = Long.toString(this.f9927l);
        } else {
            if (iC != 16) {
                throw a1("a string");
            }
            str = new String(this.f9922c, this.f9923d, this.f9928m);
            this.f9923d += this.f9928m;
        }
        this.f9926k = 0;
        int[] iArr = this.r;
        int i10 = this.f9931p - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    public final boolean Q(int i10) throws IOException {
        int i11;
        int i12;
        int i13 = this.f9925j;
        int i14 = this.f9923d;
        this.f9925j = i13 - i14;
        int i15 = this.f9924e;
        char[] cArr = this.f9922c;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f9924e = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f9924e = 0;
        }
        this.f9923d = 0;
        do {
            int i17 = this.f9924e;
            int i18 = this.f9920a.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.f9924e + i18;
            this.f9924e = i11;
            if (this.h == 0 && (i12 = this.f9925j) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f9923d++;
                this.f9925j = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        w();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Q0() throws com.google.gson.stream.MalformedJsonException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.f9923d
            int r4 = r3 + r2
            int r5 = r7.f9924e
            char[] r6 = r7.f9922c
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.w()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.Q(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.f9923d
            r0.append(r6, r3, r2)
            int r3 = r7.f9923d
            int r3 = r3 + r2
            r7.f9923d = r3
            r2 = 1
            boolean r2 = r7.Q(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f9923d
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.f9923d
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.f9923d
            int r2 = r2 + r1
            r7.f9923d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.a.Q0():java.lang.String");
    }

    public JsonToken R0() {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        switch (iC) {
            case 1:
                return JsonToken.f5473c;
            case 2:
                return JsonToken.f5474d;
            case 3:
                return JsonToken.f5471a;
            case 4:
                return JsonToken.f5472b;
            case 5:
            case 6:
                return JsonToken.f5477k;
            case 7:
                return JsonToken.f5478l;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.h;
            case 12:
            case 13:
            case 14:
                return JsonToken.f5475e;
            case 15:
            case 16:
                return JsonToken.f5476j;
            case 17:
                return JsonToken.f5479m;
            default:
                throw new AssertionError();
        }
    }

    public String S() {
        return c0(false);
    }

    public final void S0(int i10) {
        int i11 = this.f9931p;
        int[] iArr = this.f9930o;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f9930o = Arrays.copyOf(iArr, i12);
            this.r = Arrays.copyOf(this.r, i12);
            this.f9932q = (String[]) Arrays.copyOf(this.f9932q, i12);
        }
        int[] iArr2 = this.f9930o;
        int i13 = this.f9931p;
        this.f9931p = i13 + 1;
        iArr2[i13] = i10;
    }

    public final char T0() throws MalformedJsonException {
        int i10;
        if (this.f9923d == this.f9924e && !Q(1)) {
            Z0("Unterminated escape sequence");
            throw null;
        }
        int i11 = this.f9923d;
        int i12 = i11 + 1;
        this.f9923d = i12;
        char[] cArr = this.f9922c;
        char c9 = cArr[i11];
        Strictness strictness = Strictness.f5436c;
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
                            Z0("Invalid escape sequence");
                            throw null;
                        }
                        if (i11 + 5 > this.f9924e && !Q(4)) {
                            Z0("Unterminated escape sequence");
                            throw null;
                        }
                        int i13 = this.f9923d;
                        int i14 = i13 + 4;
                        int i15 = 0;
                        while (i13 < i14) {
                            char c10 = cArr[i13];
                            int i16 = i15 << 4;
                            if (c10 >= '0' && c10 <= '9') {
                                i10 = c10 - '0';
                            } else if (c10 >= 'a' && c10 <= 'f') {
                                i10 = c10 - 'W';
                            } else {
                                if (c10 < 'A' || c10 > 'F') {
                                    Z0("Malformed Unicode escape \\u".concat(new String(cArr, this.f9923d, 4)));
                                    throw null;
                                }
                                i10 = c10 - '7';
                            }
                            i15 = i10 + i16;
                            i13++;
                        }
                        this.f9923d += 4;
                        return (char) i15;
                    }
                }
            }
            return c9;
        }
        if (this.f9921b == strictness) {
            Z0("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.h++;
        this.f9925j = i12;
        if (this.f9921b == strictness) {
            Z0("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c9;
    }

    public final void U0(Strictness strictness) {
        Objects.requireNonNull(strictness);
        this.f9921b = strictness;
    }

    public final void V0(char c9) throws MalformedJsonException {
        do {
            int i10 = this.f9923d;
            int i11 = this.f9924e;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c10 = this.f9922c[i10];
                if (c10 == c9) {
                    this.f9923d = i12;
                    return;
                }
                if (c10 == '\\') {
                    this.f9923d = i12;
                    T0();
                    i10 = this.f9923d;
                    i11 = this.f9924e;
                } else {
                    if (c10 == '\n') {
                        this.h++;
                        this.f9925j = i12;
                    }
                    i10 = i12;
                }
            }
            this.f9923d = i10;
        } while (Q(1));
        Z0("Unterminated string");
        throw null;
    }

    public final void W0() {
        char c9;
        do {
            if (this.f9923d >= this.f9924e && !Q(1)) {
                return;
            }
            int i10 = this.f9923d;
            int i11 = i10 + 1;
            this.f9923d = i11;
            c9 = this.f9922c[i10];
            if (c9 == '\n') {
                this.h++;
                this.f9925j = i11;
                return;
            }
        } while (c9 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        w();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X0() throws com.google.gson.stream.MalformedJsonException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f9923d
            int r2 = r1 + r0
            int r3 = r4.f9924e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f9922c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.w()
        L4b:
            int r1 = r4.f9923d
            int r1 = r1 + r0
            r4.f9923d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f9923d = r1
            r0 = 1
            boolean r0 = r4.Q(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.a.X0():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void Y0() throws IOException {
        int i10 = 0;
        do {
            int iC = this.f9926k;
            if (iC == 0) {
                iC = C();
            }
            switch (iC) {
                case 1:
                    S0(3);
                    i10++;
                    this.f9926k = 0;
                    break;
                case 2:
                    if (i10 == 0) {
                        this.f9932q[this.f9931p - 1] = null;
                    }
                    this.f9931p--;
                    i10--;
                    this.f9926k = 0;
                    break;
                case 3:
                    S0(1);
                    i10++;
                    this.f9926k = 0;
                    break;
                case 4:
                    this.f9931p--;
                    i10--;
                    this.f9926k = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f9926k = 0;
                    break;
                case 8:
                    V0('\'');
                    this.f9926k = 0;
                    break;
                case 9:
                    V0('\"');
                    this.f9926k = 0;
                    break;
                case 10:
                    X0();
                    this.f9926k = 0;
                    break;
                case 12:
                    V0('\'');
                    if (i10 == 0) {
                        this.f9932q[this.f9931p - 1] = "<skipped>";
                    }
                    this.f9926k = 0;
                    break;
                case 13:
                    V0('\"');
                    if (i10 == 0) {
                        this.f9932q[this.f9931p - 1] = "<skipped>";
                    }
                    this.f9926k = 0;
                    break;
                case 14:
                    X0();
                    if (i10 == 0) {
                        this.f9932q[this.f9931p - 1] = "<skipped>";
                    }
                    this.f9926k = 0;
                    break;
                case 16:
                    this.f9923d += this.f9928m;
                    this.f9926k = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i10 > 0);
        int[] iArr = this.r;
        int i11 = this.f9931p - 1;
        iArr[i11] = iArr[i11] + 1;
    }

    public final void Z0(String str) throws MalformedJsonException {
        StringBuilder sbB = d.b(str);
        sbB.append(G0());
        sbB.append("\nSee ");
        sbB.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
        throw new MalformedJsonException(sbB.toString());
    }

    public void a() throws IOException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 3) {
            throw a1("BEGIN_ARRAY");
        }
        S0(1);
        this.r[this.f9931p - 1] = 0;
        this.f9926k = 0;
    }

    public final IllegalStateException a1(String str) {
        String str2 = R0() == JsonToken.f5478l ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbQ = a0.a.q("Expected ", str, " but was ");
        sbQ.append(R0());
        sbQ.append(G0());
        sbQ.append("\nSee ");
        sbQ.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(sbQ.toString());
    }

    public final String c0(boolean z) {
        StringBuilder sb2 = new StringBuilder("$");
        int i10 = 0;
        while (true) {
            int i11 = this.f9931p;
            if (i10 >= i11) {
                return sb2.toString();
            }
            int i12 = this.f9930o[i10];
            switch (i12) {
                case 1:
                case 2:
                    int i13 = this.r[i10];
                    if (z && i13 > 0 && i10 == i11 - 1) {
                        i13--;
                    }
                    sb2.append('[');
                    sb2.append(i13);
                    sb2.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb2.append('.');
                    String str = this.f9932q[i10];
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
                    throw new AssertionError(ai.onnxruntime.providers.a.a(i12, "Unknown scope value: "));
            }
            i10++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9926k = 0;
        this.f9930o[0] = 8;
        this.f9931p = 1;
        this.f9920a.close();
    }

    public String g0() {
        return c0(true);
    }

    public void o() throws IOException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        if (iC != 1) {
            throw a1("BEGIN_OBJECT");
        }
        S0(3);
        this.f9926k = 0;
    }

    public String toString() {
        return getClass().getSimpleName() + G0();
    }

    public final void w() throws MalformedJsonException {
        if (this.f9921b == Strictness.f5434a) {
            return;
        }
        Z0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    public boolean x0() throws IOException {
        int iC = this.f9926k;
        if (iC == 0) {
            iC = C();
        }
        return (iC == 2 || iC == 4 || iC == 17) ? false : true;
    }
}
