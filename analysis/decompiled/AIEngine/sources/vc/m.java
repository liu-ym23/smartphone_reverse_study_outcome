package vc;

import gc.q;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public int f13515a;

    /* renamed from: b, reason: collision with root package name */
    public final i f13516b;

    /* renamed from: c, reason: collision with root package name */
    public String f13517c;

    /* renamed from: d, reason: collision with root package name */
    public final StringBuilder f13518d;

    /* renamed from: e, reason: collision with root package name */
    public final String f13519e;

    public m(String source) {
        kotlin.jvm.internal.g.f(source, "source");
        i iVar = new i();
        iVar.f13501a = new Object[8];
        int[] iArr = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            iArr[i10] = -1;
        }
        iVar.f13502b = iArr;
        iVar.f13503c = -1;
        this.f13516b = iVar;
        this.f13518d = new StringBuilder();
        this.f13519e = source;
    }

    public static /* synthetic */ void n(m mVar, String str, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = mVar.f13515a;
        }
        mVar.m(i10, str, (i11 & 4) != 0 ? "" : "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'");
        throw null;
    }

    public final int a(CharSequence charSequence, int i10) {
        int i11 = i10 + 4;
        if (i11 < charSequence.length()) {
            this.f13518d.append((char) (p(charSequence, i10 + 3) + (p(charSequence, i10) << 12) + (p(charSequence, i10 + 1) << 8) + (p(charSequence, i10 + 2) << 4)));
            return i11;
        }
        this.f13515a = i10;
        if (i11 < charSequence.length()) {
            return a(charSequence, this.f13515a);
        }
        n(this, "Unexpected EOF during unicode escape", 0, 6);
        throw null;
    }

    public boolean b() {
        int i10 = this.f13515a;
        if (i10 == -1) {
            return false;
        }
        while (true) {
            String str = this.f13519e;
            if (i10 >= str.length()) {
                this.f13515a = i10;
                return false;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f13515a = i10;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i10++;
        }
    }

    public final void c(int i10, String str) {
        if (q().length() - i10 < str.length()) {
            n(this, "Unexpected end of boolean literal", 0, 6);
            throw null;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) != (q().charAt(i10 + i11) | ' ')) {
                n(this, "Expected valid boolean literal prefix, but had '" + j() + '\'', 0, 6);
                throw null;
            }
        }
        this.f13515a = str.length() + i10;
    }

    public final String d() {
        g('\"');
        int i10 = this.f13515a;
        String str = this.f13519e;
        int iQ0 = q.q0(str, '\"', i10, 4);
        if (iQ0 == -1) {
            j();
            o((byte) 1, false);
            throw null;
        }
        int i11 = i10;
        while (i11 < iQ0) {
            if (str.charAt(i11) == '\\') {
                int iS = this.f13515a;
                char cCharAt = str.charAt(i11);
                boolean z = false;
                while (cCharAt != '\"') {
                    StringBuilder sb2 = this.f13518d;
                    if (cCharAt == '\\') {
                        sb2.append((CharSequence) q(), iS, i11);
                        int iS2 = s(i11 + 1);
                        if (iS2 == -1) {
                            n(this, "Expected escape sequence to continue, got EOF", 0, 6);
                            throw null;
                        }
                        int iA = iS2 + 1;
                        char cCharAt2 = str.charAt(iS2);
                        if (cCharAt2 == 'u') {
                            iA = a(str, iA);
                        } else {
                            char c9 = cCharAt2 < 'u' ? c.f13494a[cCharAt2] : (char) 0;
                            if (c9 == 0) {
                                n(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, 6);
                                throw null;
                            }
                            sb2.append(c9);
                        }
                        iS = s(iA);
                        if (iS == -1) {
                            n(this, "Unexpected EOF", iS, 4);
                            throw null;
                        }
                    } else {
                        i11++;
                        if (i11 >= str.length()) {
                            sb2.append((CharSequence) q(), iS, i11);
                            iS = s(i11);
                            if (iS == -1) {
                                n(this, "Unexpected EOF", iS, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            cCharAt = str.charAt(i11);
                        }
                    }
                    i11 = iS;
                    z = true;
                    cCharAt = str.charAt(i11);
                }
                String string = !z ? q().subSequence(iS, i11).toString() : l(iS, i11);
                this.f13515a = i11 + 1;
                return string;
            }
            i11++;
        }
        this.f13515a = iQ0 + 1;
        String strSubstring = str.substring(i10, iQ0);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r4.f13515a = r3.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        return 10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte e() {
        /*
            r4 = this;
            int r0 = r4.f13515a
        L2:
            r1 = -1
            r2 = 10
            java.lang.String r3 = r4.f13519e
            if (r0 == r1) goto L2d
            int r1 = r3.length()
            if (r0 >= r1) goto L2d
            int r1 = r0 + 1
            char r0 = r3.charAt(r0)
            r3 = 32
            if (r0 == r3) goto L2b
            if (r0 == r2) goto L2b
            r2 = 13
            if (r0 == r2) goto L2b
            r2 = 9
            if (r0 != r2) goto L24
            goto L2b
        L24:
            r4.f13515a = r1
            byte r4 = mb.y.k(r0)
            return r4
        L2b:
            r0 = r1
            goto L2
        L2d:
            int r0 = r3.length()
            r4.f13515a = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.m.e():byte");
    }

    public final byte f(byte b10) {
        byte bE = e();
        if (bE == b10) {
            return bE;
        }
        o(b10, true);
        throw null;
    }

    public void g(char c9) {
        int i10 = this.f13515a;
        if (i10 == -1) {
            w(c9);
            throw null;
        }
        while (true) {
            String str = this.f13519e;
            if (i10 >= str.length()) {
                this.f13515a = -1;
                w(c9);
                throw null;
            }
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f13515a = i11;
                if (cCharAt == c9) {
                    return;
                }
                w(c9);
                throw null;
            }
            i10 = i11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x018e, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0194, code lost:
    
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0195, code lost:
    
        if (r13 == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0197, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x019c, code lost:
    
        if (r14 == Long.MIN_VALUE) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x019f, code lost:
    
        return -r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01a0, code lost:
    
        n(r21, "Numeric value overflow", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01a5, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a6, code lost:
    
        n(r21, "Expected numeric literal", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01ab, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f3, code lost:
    
        n(r21, "Unexpected symbol '" + r8 + "' in numeric literal", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010b, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010e, code lost:
    
        if (r11 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0110, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0112, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0113, code lost:
    
        if (r1 == r11) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0115, code lost:
    
        if (r13 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0119, code lost:
    
        if (r1 == (r11 - 1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0120, code lost:
    
        if (r20 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0122, code lost:
    
        if (r2 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012e, code lost:
    
        if (q().charAt(r11) != '\"') goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0130, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0133, code lost:
    
        n(r21, "Expected closing quotation mark", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x013a, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x013b, code lost:
    
        n(r21, "EOF", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0140, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0141, code lost:
    
        r21.f13515a = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0143, code lost:
    
        if (r12 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0145, code lost:
    
        r1 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0148, code lost:
    
        if (r4 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x014a, code lost:
    
        r3 = java.lang.Math.pow(10.0d, -r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0152, code lost:
    
        if (r4 != true) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0154, code lost:
    
        r3 = java.lang.Math.pow(10.0d, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0159, code lost:
    
        r1 = r1 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x015e, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0164, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x016c, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x016e, code lost:
    
        r14 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0170, code lost:
    
        n(r21, "Can't convert " + r1 + " to Long", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0188, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0189, code lost:
    
        n(r21, "Numeric value overflow", 0, 6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long h() {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.m.h():long");
    }

    public final String i() {
        String str = this.f13517c;
        if (str == null) {
            return d();
        }
        kotlin.jvm.internal.g.c(str);
        this.f13517c = null;
        return str;
    }

    public final String j() {
        String strL;
        String str = this.f13517c;
        if (str != null) {
            kotlin.jvm.internal.g.c(str);
            this.f13517c = null;
            return str;
        }
        int iT = t();
        if (iT >= q().length() || iT == -1) {
            n(this, "EOF", iT, 4);
            throw null;
        }
        byte bK = y.k(q().charAt(iT));
        if (bK == 1) {
            return i();
        }
        if (bK != 0) {
            n(this, "Expected beginning of the string, but got " + q().charAt(iT), 0, 6);
            throw null;
        }
        boolean z = false;
        while (y.k(q().charAt(iT)) == 0) {
            iT++;
            if (iT >= q().length()) {
                this.f13518d.append((CharSequence) q(), this.f13515a, iT);
                int iS = s(iT);
                if (iS == -1) {
                    this.f13515a = iT;
                    return l(0, 0);
                }
                iT = iS;
                z = true;
            }
        }
        if (z) {
            strL = l(this.f13515a, iT);
        } else {
            strL = q().subSequence(this.f13515a, iT).toString();
        }
        this.f13515a = iT;
        return strL;
    }

    public final String k() {
        String strJ = j();
        if (!kotlin.jvm.internal.g.b(strJ, "null") || q().charAt(this.f13515a - 1) == '\"') {
            return strJ;
        }
        n(this, "Unexpected 'null' value instead of string literal", 0, 6);
        throw null;
    }

    public final String l(int i10, int i11) {
        String strQ = q();
        StringBuilder sb2 = this.f13518d;
        sb2.append((CharSequence) strQ, i10, i11);
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        sb2.setLength(0);
        return string;
    }

    public final void m(int i10, String message, String hint) {
        kotlin.jvm.internal.g.f(message, "message");
        kotlin.jvm.internal.g.f(hint, "hint");
        String strConcat = hint.length() == 0 ? "" : "\n".concat(hint);
        StringBuilder sbP = a0.a.p(message, " at path: ");
        sbP.append(this.f13516b.a());
        sbP.append(strConcat);
        throw y.b(i10, q(), sbP.toString());
    }

    public final void o(byte b10, boolean z) {
        String strQ = y.Q(b10);
        int i10 = z ? this.f13515a - 1 : this.f13515a;
        n(this, h0.e.c("Expected ", strQ, ", but had '", (this.f13515a == q().length() || i10 < 0) ? "EOF" : String.valueOf(q().charAt(i10)), "' instead"), i10, 4);
        throw null;
    }

    public final int p(CharSequence charSequence, int i10) {
        char cCharAt = charSequence.charAt(i10);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        n(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, 6);
        throw null;
    }

    public final String q() {
        return this.f13519e;
    }

    public byte r() {
        String strQ = q();
        int i10 = this.f13515a;
        while (true) {
            int iS = s(i10);
            if (iS == -1) {
                this.f13515a = iS;
                return (byte) 10;
            }
            char cCharAt = strQ.charAt(iS);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.f13515a = iS;
                return y.k(cCharAt);
            }
            i10 = iS + 1;
        }
    }

    public final int s(int i10) {
        if (i10 < this.f13519e.length()) {
            return i10;
        }
        return -1;
    }

    public int t() {
        char cCharAt;
        int i10 = this.f13515a;
        if (i10 == -1) {
            return i10;
        }
        while (true) {
            String str = this.f13519e;
            if (i10 >= str.length() || !((cCharAt = str.charAt(i10)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i10++;
        }
        this.f13515a = i10;
        return i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("JsonReader(source='");
        sb2.append((Object) q());
        sb2.append("', currentPosition=");
        return a0.a.l(sb2, this.f13515a, ')');
    }

    public final boolean u() {
        int iT = t();
        String strQ = q();
        if (iT >= strQ.length() || iT == -1 || strQ.charAt(iT) != ',') {
            return false;
        }
        this.f13515a++;
        return true;
    }

    public final boolean v(boolean z) {
        int iS = s(t());
        int length = q().length() - iS;
        if (length >= 4 && iS != -1) {
            int i10 = 0;
            while (true) {
                if (i10 < 4) {
                    if ("null".charAt(i10) != q().charAt(iS + i10)) {
                        break;
                    }
                    i10++;
                } else if (length <= 4 || y.k(q().charAt(iS + 4)) != 0) {
                    if (z) {
                        this.f13515a = iS + 4;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final void w(char c9) {
        int i10 = this.f13515a;
        if (i10 > 0 && c9 == '\"') {
            try {
                this.f13515a = i10 - 1;
                String strJ = j();
                this.f13515a = i10;
                if (kotlin.jvm.internal.g.b(strJ, "null")) {
                    m(this.f13515a - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.f13515a = i10;
                throw th;
            }
        }
        o(y.k(c9), true);
        throw null;
    }
}
