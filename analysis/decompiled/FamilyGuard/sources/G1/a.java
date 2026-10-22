package G1;

import C1.f;
import D1.e;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: p, reason: collision with root package name */
    private static final char[] f1844p = ")]}'\n".toCharArray();

    /* renamed from: a, reason: collision with root package name */
    private final Reader f1845a;

    /* renamed from: i, reason: collision with root package name */
    private long f1853i;

    /* renamed from: j, reason: collision with root package name */
    private int f1854j;

    /* renamed from: k, reason: collision with root package name */
    private String f1855k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f1856l;

    /* renamed from: n, reason: collision with root package name */
    private String[] f1858n;

    /* renamed from: o, reason: collision with root package name */
    private int[] f1859o;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1846b = false;

    /* renamed from: c, reason: collision with root package name */
    private final char[] f1847c = new char[1024];

    /* renamed from: d, reason: collision with root package name */
    private int f1848d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f1849e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f1850f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f1851g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f1852h = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f1857m = 1;

    /* renamed from: G1.a$a, reason: collision with other inner class name */
    static class C0028a extends f {
        C0028a() {
        }

        @Override // C1.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof e) {
                ((e) aVar).u0();
                return;
            }
            int iO = aVar.f1852h;
            if (iO == 0) {
                iO = aVar.o();
            }
            if (iO == 13) {
                aVar.f1852h = 9;
                return;
            }
            if (iO == 12) {
                aVar.f1852h = 8;
                return;
            }
            if (iO == 14) {
                aVar.f1852h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.V() + aVar.C());
        }
    }

    static {
        f.f565a = new C0028a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f1856l = iArr;
        iArr[0] = 6;
        this.f1858n = new String[32];
        this.f1859o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f1845a = reader;
    }

    private boolean A(char c6) throws IOException {
        if (c6 == '\t' || c6 == '\n' || c6 == '\f' || c6 == '\r' || c6 == ' ') {
            return false;
        }
        if (c6 != '#') {
            if (c6 == ',') {
                return false;
            }
            if (c6 != '/' && c6 != '=') {
                if (c6 == '{' || c6 == '}' || c6 == ':') {
                    return false;
                }
                if (c6 != ';') {
                    switch (c6) {
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
        f();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int N(boolean r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.f1847c
            int r1 = r8.f1848d
            int r2 = r8.f1849e
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r8.f1848d = r1
            boolean r1 = r8.v(r3)
            if (r1 != 0) goto L30
            if (r9 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r9 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r8 = r8.C()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8)
            throw r9
        L30:
            int r1 = r8.f1848d
            int r2 = r8.f1849e
        L34:
            int r4 = r1 + 1
            char r5 = r0[r1]
            r6 = 10
            if (r5 != r6) goto L45
            int r1 = r8.f1850f
            int r1 = r1 + r3
            r8.f1850f = r1
            r8.f1851g = r4
            goto Lb2
        L45:
            r6 = 32
            if (r5 == r6) goto Lb2
            r6 = 13
            if (r5 == r6) goto Lb2
            r6 = 9
            if (r5 != r6) goto L52
            goto Lb2
        L52:
            r6 = 47
            if (r5 != r6) goto L9d
            r8.f1848d = r4
            r7 = 2
            if (r4 != r2) goto L69
            r8.f1848d = r1
            boolean r1 = r8.v(r7)
            int r2 = r8.f1848d
            int r2 = r2 + r3
            r8.f1848d = r2
            if (r1 != 0) goto L69
            goto L76
        L69:
            r8.f()
            int r1 = r8.f1848d
            char r2 = r0[r1]
            r3 = 42
            if (r2 == r3) goto L83
            if (r2 == r6) goto L77
        L76:
            return r5
        L77:
            int r1 = r1 + 1
            r8.f1848d = r1
            r8.k0()
            int r1 = r8.f1848d
            int r2 = r8.f1849e
            goto L6
        L83:
            int r1 = r1 + 1
            r8.f1848d = r1
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r8.j0(r1)
            if (r1 == 0) goto L96
            int r1 = r8.f1848d
            int r1 = r1 + r7
            int r2 = r8.f1849e
            goto L6
        L96:
            java.lang.String r9 = "Unterminated comment"
            java.io.IOException r8 = r8.n0(r9)
            throw r8
        L9d:
            r1 = 35
            if (r5 != r1) goto Laf
            r8.f1848d = r4
            r8.f()
            r8.k0()
            int r1 = r8.f1848d
            int r2 = r8.f1849e
            goto L6
        Laf:
            r8.f1848d = r4
            return r5
        Lb2:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: G1.a.N(boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f1848d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String S(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f1847c
            r1 = 0
        L3:
            int r2 = r9.f1848d
            int r3 = r9.f1849e
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f1848d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r9 = new java.lang.String
            r9.<init>(r0, r3, r7)
            return r9
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r9 = r1.toString()
            return r9
        L28:
            r8 = 92
            if (r2 != r8) goto L4d
            r9.f1848d = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L3e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L3e:
            r1.append(r0, r3, r2)
            char r2 = r9.c0()
            r1.append(r2)
            int r2 = r9.f1848d
            int r3 = r9.f1849e
            goto L7
        L4d:
            r5 = 10
            if (r2 != r5) goto L58
            int r2 = r9.f1850f
            int r2 = r2 + r6
            r9.f1850f = r2
            r9.f1851g = r7
        L58:
            r2 = r7
            goto L9
        L5a:
            if (r1 != 0) goto L6a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f1848d = r2
            boolean r2 = r9.v(r6)
            if (r2 == 0) goto L78
            goto L3
        L78:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r9 = r9.n0(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: G1.a.S(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        f();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String U() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f1848d
            int r4 = r3 + r2
            int r5 = r6.f1849e
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f1847c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.f()
            goto L5c
        L4e:
            char[] r3 = r6.f1847c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.v(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f1847c
            int r4 = r6.f1848d
            r0.append(r3, r4, r2)
            int r3 = r6.f1848d
            int r3 = r3 + r2
            r6.f1848d = r3
            r2 = 1
            boolean r2 = r6.v(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f1847c
            int r3 = r6.f1848d
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f1847c
            int r3 = r6.f1848d
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f1848d
            int r2 = r2 + r1
            r6.f1848d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: G1.a.U():java.lang.String");
    }

    private int W() {
        String str;
        String str2;
        int i5;
        char c6 = this.f1847c[this.f1848d];
        if (c6 == 't' || c6 == 'T') {
            str = "true";
            str2 = "TRUE";
            i5 = 5;
        } else if (c6 == 'f' || c6 == 'F') {
            str = "false";
            str2 = "FALSE";
            i5 = 6;
        } else {
            if (c6 != 'n' && c6 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i5 = 7;
        }
        int length = str.length();
        for (int i6 = 1; i6 < length; i6++) {
            if (this.f1848d + i6 >= this.f1849e && !v(i6 + 1)) {
                return 0;
            }
            char c7 = this.f1847c[this.f1848d + i6];
            if (c7 != str.charAt(i6) && c7 != str2.charAt(i6)) {
                return 0;
            }
        }
        if ((this.f1848d + length < this.f1849e || v(length + 1)) && A(this.f1847c[this.f1848d + length])) {
            return 0;
        }
        this.f1848d += length;
        this.f1852h = i5;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if (A(r14) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        if (r9 != 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
    
        if (r10 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009d, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009f, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
    
        if (r11 != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
    
        if (r13 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
    
        if (r13 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
    
        r19.f1853i = r11;
        r19.f1848d += r8;
        r19.f1852h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b7, code lost:
    
        if (r9 == 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
    
        if (r9 == 4) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bd, code lost:
    
        if (r9 != 7) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
    
        r19.f1854j = r8;
        r19.f1852h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c7, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c8, code lost:
    
        return r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int X() {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: G1.a.X():int");
    }

    private void Y(int i5) {
        int i6 = this.f1857m;
        int[] iArr = this.f1856l;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[i6 * 2];
            int[] iArr3 = new int[i6 * 2];
            String[] strArr = new String[i6 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            System.arraycopy(this.f1859o, 0, iArr3, 0, this.f1857m);
            System.arraycopy(this.f1858n, 0, strArr, 0, this.f1857m);
            this.f1856l = iArr2;
            this.f1859o = iArr3;
            this.f1858n = strArr;
        }
        int[] iArr4 = this.f1856l;
        int i7 = this.f1857m;
        this.f1857m = i7 + 1;
        iArr4[i7] = i5;
    }

    private char c0() throws IOException {
        int i5;
        if (this.f1848d == this.f1849e && !v(1)) {
            throw n0("Unterminated escape sequence");
        }
        char[] cArr = this.f1847c;
        int i6 = this.f1848d;
        int i7 = i6 + 1;
        this.f1848d = i7;
        char c6 = cArr[i6];
        if (c6 == '\n') {
            this.f1850f++;
            this.f1851g = i7;
            return c6;
        }
        if (c6 == '\"' || c6 == '\'' || c6 == '/' || c6 == '\\') {
            return c6;
        }
        if (c6 == 'b') {
            return '\b';
        }
        if (c6 == 'f') {
            return '\f';
        }
        if (c6 == 'n') {
            return '\n';
        }
        if (c6 == 'r') {
            return '\r';
        }
        if (c6 == 't') {
            return '\t';
        }
        if (c6 != 'u') {
            throw n0("Invalid escape sequence");
        }
        if (i6 + 5 > this.f1849e && !v(4)) {
            throw n0("Unterminated escape sequence");
        }
        int i8 = this.f1848d;
        int i9 = i8 + 4;
        char c7 = 0;
        while (i8 < i9) {
            char c8 = this.f1847c[i8];
            char c9 = (char) (c7 << 4);
            if (c8 >= '0' && c8 <= '9') {
                i5 = c8 - '0';
            } else if (c8 >= 'a' && c8 <= 'f') {
                i5 = c8 - 'W';
            } else {
                if (c8 < 'A' || c8 > 'F') {
                    throw new NumberFormatException("\\u" + new String(this.f1847c, this.f1848d, 4));
                }
                i5 = c8 - '7';
            }
            c7 = (char) (c9 + i5);
            i8++;
        }
        this.f1848d += 4;
        return c7;
    }

    private void f() throws IOException {
        if (!this.f1846b) {
            throw n0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void h0(char c6) throws IOException {
        char[] cArr = this.f1847c;
        do {
            int i5 = this.f1848d;
            int i6 = this.f1849e;
            while (i5 < i6) {
                int i7 = i5 + 1;
                char c7 = cArr[i5];
                if (c7 == c6) {
                    this.f1848d = i7;
                    return;
                }
                if (c7 == '\\') {
                    this.f1848d = i7;
                    c0();
                    i5 = this.f1848d;
                    i6 = this.f1849e;
                } else {
                    if (c7 == '\n') {
                        this.f1850f++;
                        this.f1851g = i7;
                    }
                    i5 = i7;
                }
            }
            this.f1848d = i5;
        } while (v(1));
        throw n0("Unterminated string");
    }

    private boolean j0(String str) {
        int length = str.length();
        while (true) {
            if (this.f1848d + length > this.f1849e && !v(length)) {
                return false;
            }
            char[] cArr = this.f1847c;
            int i5 = this.f1848d;
            if (cArr[i5] != '\n') {
                for (int i6 = 0; i6 < length; i6++) {
                    if (this.f1847c[this.f1848d + i6] != str.charAt(i6)) {
                        break;
                    }
                }
                return true;
            }
            this.f1850f++;
            this.f1851g = i5 + 1;
            this.f1848d++;
        }
    }

    private void k0() {
        char c6;
        do {
            if (this.f1848d >= this.f1849e && !v(1)) {
                return;
            }
            char[] cArr = this.f1847c;
            int i5 = this.f1848d;
            int i6 = i5 + 1;
            this.f1848d = i6;
            c6 = cArr[i5];
            if (c6 == '\n') {
                this.f1850f++;
                this.f1851g = i6;
                return;
            }
        } while (c6 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l0() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f1848d
            int r2 = r1 + r0
            int r3 = r4.f1849e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f1847c
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
            r4.f()
        L4b:
            int r1 = r4.f1848d
            int r1 = r1 + r0
            r4.f1848d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f1848d = r1
            r0 = 1
            boolean r0 = r4.v(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: G1.a.l0():void");
    }

    private void m() throws IOException {
        N(true);
        int i5 = this.f1848d - 1;
        this.f1848d = i5;
        char[] cArr = f1844p;
        if (i5 + cArr.length > this.f1849e && !v(cArr.length)) {
            return;
        }
        int i6 = 0;
        while (true) {
            char[] cArr2 = f1844p;
            if (i6 >= cArr2.length) {
                this.f1848d += cArr2.length;
                return;
            } else if (this.f1847c[this.f1848d + i6] != cArr2[i6]) {
                return;
            } else {
                i6++;
            }
        }
    }

    private IOException n0(String str) throws d {
        throw new d(str + C());
    }

    private boolean v(int i5) throws IOException {
        int i6;
        int i7;
        char[] cArr = this.f1847c;
        int i8 = this.f1851g;
        int i9 = this.f1848d;
        this.f1851g = i8 - i9;
        int i10 = this.f1849e;
        if (i10 != i9) {
            int i11 = i10 - i9;
            this.f1849e = i11;
            System.arraycopy(cArr, i9, cArr, 0, i11);
        } else {
            this.f1849e = 0;
        }
        this.f1848d = 0;
        do {
            Reader reader = this.f1845a;
            int i12 = this.f1849e;
            int i13 = reader.read(cArr, i12, cArr.length - i12);
            if (i13 == -1) {
                return false;
            }
            i6 = this.f1849e + i13;
            this.f1849e = i6;
            if (this.f1850f == 0 && (i7 = this.f1851g) == 0 && i6 > 0 && cArr[0] == 65279) {
                this.f1848d++;
                this.f1851g = i7 + 1;
                i5++;
            }
        } while (i6 < i5);
        return true;
    }

    String C() {
        return " at line " + (this.f1850f + 1) + " column " + ((this.f1848d - this.f1851g) + 1) + " path " + f0();
    }

    public boolean D() throws IOException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 5) {
            this.f1852h = 0;
            int[] iArr = this.f1859o;
            int i5 = this.f1857m - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        }
        if (iO == 6) {
            this.f1852h = 0;
            int[] iArr2 = this.f1859o;
            int i6 = this.f1857m - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + V() + C());
    }

    public double E() throws IOException, NumberFormatException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 15) {
            this.f1852h = 0;
            int[] iArr = this.f1859o;
            int i5 = this.f1857m - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f1853i;
        }
        if (iO == 16) {
            this.f1855k = new String(this.f1847c, this.f1848d, this.f1854j);
            this.f1848d += this.f1854j;
        } else if (iO == 8 || iO == 9) {
            this.f1855k = S(iO == 8 ? '\'' : '\"');
        } else if (iO == 10) {
            this.f1855k = U();
        } else if (iO != 11) {
            throw new IllegalStateException("Expected a double but was " + V() + C());
        }
        this.f1852h = 11;
        double d6 = Double.parseDouble(this.f1855k);
        if (!this.f1846b && (Double.isNaN(d6) || Double.isInfinite(d6))) {
            throw new d("JSON forbids NaN and infinities: " + d6 + C());
        }
        this.f1855k = null;
        this.f1852h = 0;
        int[] iArr2 = this.f1859o;
        int i6 = this.f1857m - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return d6;
    }

    public int G() throws IOException, NumberFormatException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 15) {
            long j5 = this.f1853i;
            int i5 = (int) j5;
            if (j5 == i5) {
                this.f1852h = 0;
                int[] iArr = this.f1859o;
                int i6 = this.f1857m - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new NumberFormatException("Expected an int but was " + this.f1853i + C());
        }
        if (iO == 16) {
            this.f1855k = new String(this.f1847c, this.f1848d, this.f1854j);
            this.f1848d += this.f1854j;
        } else {
            if (iO != 8 && iO != 9 && iO != 10) {
                throw new IllegalStateException("Expected an int but was " + V() + C());
            }
            if (iO == 10) {
                this.f1855k = U();
            } else {
                this.f1855k = S(iO == 8 ? '\'' : '\"');
            }
            try {
                int i7 = Integer.parseInt(this.f1855k);
                this.f1852h = 0;
                int[] iArr2 = this.f1859o;
                int i8 = this.f1857m - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return i7;
            } catch (NumberFormatException unused) {
            }
        }
        this.f1852h = 11;
        double d6 = Double.parseDouble(this.f1855k);
        int i9 = (int) d6;
        if (i9 != d6) {
            throw new NumberFormatException("Expected an int but was " + this.f1855k + C());
        }
        this.f1855k = null;
        this.f1852h = 0;
        int[] iArr3 = this.f1859o;
        int i10 = this.f1857m - 1;
        iArr3[i10] = iArr3[i10] + 1;
        return i9;
    }

    public long I() throws IOException, NumberFormatException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 15) {
            this.f1852h = 0;
            int[] iArr = this.f1859o;
            int i5 = this.f1857m - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f1853i;
        }
        if (iO == 16) {
            this.f1855k = new String(this.f1847c, this.f1848d, this.f1854j);
            this.f1848d += this.f1854j;
        } else {
            if (iO != 8 && iO != 9 && iO != 10) {
                throw new IllegalStateException("Expected a long but was " + V() + C());
            }
            if (iO == 10) {
                this.f1855k = U();
            } else {
                this.f1855k = S(iO == 8 ? '\'' : '\"');
            }
            try {
                long j5 = Long.parseLong(this.f1855k);
                this.f1852h = 0;
                int[] iArr2 = this.f1859o;
                int i6 = this.f1857m - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return j5;
            } catch (NumberFormatException unused) {
            }
        }
        this.f1852h = 11;
        double d6 = Double.parseDouble(this.f1855k);
        long j6 = (long) d6;
        if (j6 != d6) {
            throw new NumberFormatException("Expected a long but was " + this.f1855k + C());
        }
        this.f1855k = null;
        this.f1852h = 0;
        int[] iArr3 = this.f1859o;
        int i7 = this.f1857m - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return j6;
    }

    public String L() throws IOException {
        String strS;
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 14) {
            strS = U();
        } else if (iO == 12) {
            strS = S('\'');
        } else {
            if (iO != 13) {
                throw new IllegalStateException("Expected a name but was " + V() + C());
            }
            strS = S('\"');
        }
        this.f1852h = 0;
        this.f1858n[this.f1857m - 1] = strS;
        return strS;
    }

    public void O() throws IOException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 7) {
            this.f1852h = 0;
            int[] iArr = this.f1859o;
            int i5 = this.f1857m - 1;
            iArr[i5] = iArr[i5] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + V() + C());
    }

    public String T() throws IOException {
        String str;
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 10) {
            str = U();
        } else if (iO == 8) {
            str = S('\'');
        } else if (iO == 9) {
            str = S('\"');
        } else if (iO == 11) {
            str = this.f1855k;
            this.f1855k = null;
        } else if (iO == 15) {
            str = Long.toString(this.f1853i);
        } else {
            if (iO != 16) {
                throw new IllegalStateException("Expected a string but was " + V() + C());
            }
            str = new String(this.f1847c, this.f1848d, this.f1854j);
            this.f1848d += this.f1854j;
        }
        this.f1852h = 0;
        int[] iArr = this.f1859o;
        int i5 = this.f1857m - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    public b V() throws IOException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        switch (iO) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return b.STRING;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void a() throws IOException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 3) {
            Y(1);
            this.f1859o[this.f1857m - 1] = 0;
            this.f1852h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + V() + C());
        }
    }

    public void c() throws IOException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 1) {
            Y(3);
            this.f1852h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + V() + C());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1852h = 0;
        this.f1856l[0] = 8;
        this.f1857m = 1;
        this.f1845a.close();
    }

    public final void d0(boolean z5) {
        this.f1846b = z5;
    }

    public String f0() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i5 = this.f1857m;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = this.f1856l[i6];
            if (i7 == 1 || i7 == 2) {
                sb.append('[');
                sb.append(this.f1859o[i6]);
                sb.append(']');
            } else if (i7 == 3 || i7 == 4 || i7 == 5) {
                sb.append('.');
                String str = this.f1858n[i6];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public void m0() throws IOException {
        int i5 = 0;
        do {
            int iO = this.f1852h;
            if (iO == 0) {
                iO = o();
            }
            if (iO == 3) {
                Y(1);
            } else if (iO == 1) {
                Y(3);
            } else if (iO == 4 || iO == 2) {
                this.f1857m--;
                i5--;
                this.f1852h = 0;
            } else {
                if (iO == 14 || iO == 10) {
                    l0();
                } else if (iO == 8 || iO == 12) {
                    h0('\'');
                } else if (iO == 9 || iO == 13) {
                    h0('\"');
                } else if (iO == 16) {
                    this.f1848d += this.f1854j;
                }
                this.f1852h = 0;
            }
            i5++;
            this.f1852h = 0;
        } while (i5 != 0);
        int[] iArr = this.f1859o;
        int i6 = this.f1857m;
        int i7 = i6 - 1;
        iArr[i7] = iArr[i7] + 1;
        this.f1858n[i6 - 1] = "null";
    }

    int o() throws IOException {
        int iN;
        int[] iArr = this.f1856l;
        int i5 = this.f1857m;
        int i6 = iArr[i5 - 1];
        if (i6 == 1) {
            iArr[i5 - 1] = 2;
        } else if (i6 == 2) {
            int iN2 = N(true);
            if (iN2 != 44) {
                if (iN2 != 59) {
                    if (iN2 != 93) {
                        throw n0("Unterminated array");
                    }
                    this.f1852h = 4;
                    return 4;
                }
                f();
            }
        } else {
            if (i6 == 3 || i6 == 5) {
                iArr[i5 - 1] = 4;
                if (i6 == 5 && (iN = N(true)) != 44) {
                    if (iN != 59) {
                        if (iN != 125) {
                            throw n0("Unterminated object");
                        }
                        this.f1852h = 2;
                        return 2;
                    }
                    f();
                }
                int iN3 = N(true);
                if (iN3 == 34) {
                    this.f1852h = 13;
                    return 13;
                }
                if (iN3 == 39) {
                    f();
                    this.f1852h = 12;
                    return 12;
                }
                if (iN3 == 125) {
                    if (i6 == 5) {
                        throw n0("Expected name");
                    }
                    this.f1852h = 2;
                    return 2;
                }
                f();
                this.f1848d--;
                if (!A((char) iN3)) {
                    throw n0("Expected name");
                }
                this.f1852h = 14;
                return 14;
            }
            if (i6 == 4) {
                iArr[i5 - 1] = 5;
                int iN4 = N(true);
                if (iN4 != 58) {
                    if (iN4 != 61) {
                        throw n0("Expected ':'");
                    }
                    f();
                    if (this.f1848d < this.f1849e || v(1)) {
                        char[] cArr = this.f1847c;
                        int i7 = this.f1848d;
                        if (cArr[i7] == '>') {
                            this.f1848d = i7 + 1;
                        }
                    }
                }
            } else if (i6 == 6) {
                if (this.f1846b) {
                    m();
                }
                this.f1856l[this.f1857m - 1] = 7;
            } else if (i6 == 7) {
                if (N(false) == -1) {
                    this.f1852h = 17;
                    return 17;
                }
                f();
                this.f1848d--;
            } else if (i6 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iN5 = N(true);
        if (iN5 == 34) {
            this.f1852h = 9;
            return 9;
        }
        if (iN5 == 39) {
            f();
            this.f1852h = 8;
            return 8;
        }
        if (iN5 != 44 && iN5 != 59) {
            if (iN5 == 91) {
                this.f1852h = 3;
                return 3;
            }
            if (iN5 != 93) {
                if (iN5 == 123) {
                    this.f1852h = 1;
                    return 1;
                }
                this.f1848d--;
                int iW = W();
                if (iW != 0) {
                    return iW;
                }
                int iX = X();
                if (iX != 0) {
                    return iX;
                }
                if (!A(this.f1847c[this.f1848d])) {
                    throw n0("Expected value");
                }
                f();
                this.f1852h = 10;
                return 10;
            }
            if (i6 == 1) {
                this.f1852h = 4;
                return 4;
            }
        }
        if (i6 != 1 && i6 != 2) {
            throw n0("Unexpected value");
        }
        f();
        this.f1848d--;
        this.f1852h = 7;
        return 7;
    }

    public void r() throws IOException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + V() + C());
        }
        int i5 = this.f1857m;
        this.f1857m = i5 - 1;
        int[] iArr = this.f1859o;
        int i6 = i5 - 2;
        iArr[i6] = iArr[i6] + 1;
        this.f1852h = 0;
    }

    public String toString() {
        return getClass().getSimpleName() + C();
    }

    public void u() throws IOException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        if (iO != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + V() + C());
        }
        int i5 = this.f1857m;
        int i6 = i5 - 1;
        this.f1857m = i6;
        this.f1858n[i6] = null;
        int[] iArr = this.f1859o;
        int i7 = i5 - 2;
        iArr[i7] = iArr[i7] + 1;
        this.f1852h = 0;
    }

    public boolean w() throws IOException {
        int iO = this.f1852h;
        if (iO == 0) {
            iO = o();
        }
        return (iO == 2 || iO == 4) ? false : true;
    }

    public final boolean x() {
        return this.f1846b;
    }
}
