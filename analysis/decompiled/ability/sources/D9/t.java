package D9;

import com.fasterxml.jackson.core.JsonFactory;
import h8.InterfaceC1507O;
import h8.InterfaceC1528k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import n8.v;
import t8.C2024a;
import t8.InterfaceC2028e;
import u8.E;
import x8.InterfaceC2122e;

/* loaded from: classes4.dex */
public class t implements InterfaceC2028e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f447a = 1;
    public Object b;
    public int c;
    public Object d;
    public Object e;
    public Object f;

    public /* synthetic */ t() {
    }

    public static /* synthetic */ void o(t tVar, String str, int i, String str2, int i6) {
        if ((i6 & 2) != 0) {
            i = tVar.c;
        }
        if ((i6 & 4) != 0) {
            str2 = "";
        }
        tVar.n(i, str, str2);
        throw null;
    }

    @Override // t8.InterfaceC2028e
    public InterfaceC1507O a(v javaTypeParameter) {
        kotlin.jvm.internal.k.f(javaTypeParameter, "javaTypeParameter");
        E e = (E) ((kotlin.reflect.jvm.internal.impl.storage.b) this.f).invoke(javaTypeParameter);
        return e != null ? e : ((InterfaceC2028e) ((K1.a) this.d).b).a(javaTypeParameter);
    }

    public int b(CharSequence charSequence, int i) {
        int i6 = i + 4;
        if (i6 < charSequence.length()) {
            ((StringBuilder) this.f).append((char) (p(charSequence, i + 3) + (p(charSequence, i) << 12) + (p(charSequence, i + 1) << 8) + (p(charSequence, i + 2) << 4)));
            return i6;
        }
        this.c = i;
        if (i6 < charSequence.length()) {
            return b(charSequence, this.c);
        }
        o(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    public boolean c() {
        int i = this.c;
        if (i == -1) {
            return false;
        }
        String str = (String) this.e;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.c = i;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i++;
        }
        this.c = i;
        return false;
    }

    public void d(int i, String str) {
        String str2 = (String) this.e;
        if (str2.length() - i < str.length()) {
            o(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (str.charAt(i6) != (str2.charAt(i + i6) | ' ')) {
                o(this, "Expected valid boolean literal prefix, but had '" + k() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.c = str.length() + i;
    }

    public String e() {
        String str = (String) this.e;
        h(JsonFactory.DEFAULT_QUOTE_CHAR);
        int i = this.c;
        int iP0 = j9.m.p0(str, JsonFactory.DEFAULT_QUOTE_CHAR, i, 4);
        if (iP0 == -1) {
            k();
            int i6 = this.c;
            o(this, B7.a.m("Expected quotation mark '\"', but had '", (i6 == str.length() || i6 < 0) ? "EOF" : String.valueOf(str.charAt(i6)), "' instead"), i6, null, 4);
            throw null;
        }
        int i10 = i;
        while (i10 < iP0) {
            if (str.charAt(i10) == '\\') {
                int iT = this.c;
                char cCharAt = str.charAt(i10);
                boolean z10 = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        ((StringBuilder) this.f).append((CharSequence) str, iT, i10);
                        int iT2 = t(i10 + 1);
                        if (iT2 == -1) {
                            o(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int iB = iT2 + 1;
                        char cCharAt2 = str.charAt(iT2);
                        if (cCharAt2 == 'u') {
                            iB = b(str, iB);
                        } else {
                            char c = cCharAt2 < 'u' ? e.f438a[cCharAt2] : (char) 0;
                            if (c == 0) {
                                o(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            ((StringBuilder) this.f).append(c);
                        }
                        iT = t(iB);
                        if (iT == -1) {
                            o(this, "Unexpected EOF", iT, null, 4);
                            throw null;
                        }
                    } else {
                        i10++;
                        if (i10 >= str.length()) {
                            ((StringBuilder) this.f).append((CharSequence) str, iT, i10);
                            iT = t(i10);
                            if (iT == -1) {
                                o(this, "Unexpected EOF", iT, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            cCharAt = str.charAt(i10);
                        }
                    }
                    i10 = iT;
                    z10 = true;
                    cCharAt = str.charAt(i10);
                }
                String string = !z10 ? str.subSequence(iT, i10).toString() : m(iT, i10);
                this.c = i10 + 1;
                return string;
            }
            i10++;
        }
        this.c = iP0 + 1;
        String strSubstring = str.substring(i, iP0);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public byte f() {
        String str = (String) this.e;
        int i = this.c;
        while (i != -1 && i < str.length()) {
            int i6 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.c = i6;
                return j.f(cCharAt);
            }
            i = i6;
        }
        this.c = str.length();
        return (byte) 10;
    }

    public byte g(byte b) {
        String str = (String) this.e;
        byte bF = f();
        if (bF == b) {
            return bF;
        }
        String strR = j.r(b);
        int i = this.c;
        int i6 = i - 1;
        o(this, androidx.appfunctions.metadata.a.m("Expected ", strR, ", but had '", (i == str.length() || i6 < 0) ? "EOF" : String.valueOf(str.charAt(i6)), "' instead"), i6, null, 4);
        throw null;
    }

    public void h(char c) {
        int i = this.c;
        if (i == -1) {
            x(c);
            throw null;
        }
        String str = (String) this.e;
        while (i < str.length()) {
            int i6 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.c = i6;
                if (cCharAt == c) {
                    return;
                }
                x(c);
                throw null;
            }
            i = i6;
        }
        this.c = -1;
        x(c);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0182, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0188, code lost:
    
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0189, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x018a, code lost:
    
        if (r14 == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x018c, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0191, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0194, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0195, code lost:
    
        o(r21, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x019a, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x019b, code lost:
    
        o(r21, "Expected numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a0, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e9, code lost:
    
        o(r21, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0101, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0104, code lost:
    
        if (r12 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0106, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0108, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0109, code lost:
    
        if (r1 == r12) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x010b, code lost:
    
        if (r14 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x010f, code lost:
    
        if (r1 == (r12 - 1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0116, code lost:
    
        if (r20 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0118, code lost:
    
        if (r3 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0120, code lost:
    
        if (r2.charAt(r12) != '\"') goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0122, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0125, code lost:
    
        o(r21, "Expected closing quotation mark", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012d, code lost:
    
        o(r21, "EOF", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0132, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0133, code lost:
    
        r21.c = r12;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0137, code lost:
    
        if (r13 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0139, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013c, code lost:
    
        if (r11 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x013e, code lost:
    
        r3 = java.lang.Math.pow(10.0d, -r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0146, code lost:
    
        if (r11 != true) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0148, code lost:
    
        r3 = java.lang.Math.pow(10.0d, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x014d, code lost:
    
        r1 = r1 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0152, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0158, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0160, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0162, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0164, code lost:
    
        o(r21, "Can't convert " + r1 + " to Long", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x017c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x017d, code lost:
    
        o(r21, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long i() {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D9.t.i():long");
    }

    public String j() {
        String str = (String) this.b;
        if (str == null) {
            return e();
        }
        kotlin.jvm.internal.k.c(str);
        this.b = null;
        return str;
    }

    public String k() {
        String str = (String) this.e;
        String str2 = (String) this.b;
        if (str2 != null) {
            kotlin.jvm.internal.k.c(str2);
            this.b = null;
            return str2;
        }
        int iU = u();
        if (iU >= str.length() || iU == -1) {
            o(this, "EOF", iU, null, 4);
            throw null;
        }
        byte bF = j.f(str.charAt(iU));
        if (bF == 1) {
            return j();
        }
        if (bF != 0) {
            o(this, "Expected beginning of the string, but got " + str.charAt(iU), 0, null, 6);
            throw null;
        }
        boolean z10 = false;
        while (j.f(str.charAt(iU)) == 0) {
            iU++;
            if (iU >= str.length()) {
                ((StringBuilder) this.f).append((CharSequence) str, this.c, iU);
                int iT = t(iU);
                if (iT == -1) {
                    this.c = iU;
                    return m(0, 0);
                }
                iU = iT;
                z10 = true;
            }
        }
        String string = !z10 ? str.subSequence(this.c, iU).toString() : m(this.c, iU);
        this.c = iU;
        return string;
    }

    public String l() {
        String strK = k();
        if (!kotlin.jvm.internal.k.b(strK, "null") || ((String) this.e).charAt(this.c - 1) == '\"') {
            return strK;
        }
        o(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
        throw null;
    }

    public String m(int i, int i6) {
        ((StringBuilder) this.f).append((CharSequence) this.e, i, i6);
        StringBuilder sb = (StringBuilder) this.f;
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        sb.setLength(0);
        return string;
    }

    public void n(int i, String message, String hint) {
        kotlin.jvm.internal.k.f(message, "message");
        kotlin.jvm.internal.k.f(hint, "hint");
        String strConcat = hint.length() == 0 ? "" : "\n".concat(hint);
        StringBuilder sbX = androidx.appfunctions.metadata.a.x(message, " at path: ");
        sbX.append(((l) this.d).b());
        sbX.append(strConcat);
        throw j.d(sbX.toString(), (String) this.e, i);
    }

    public int p(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        o(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public String q(String keyToMatch, boolean z10) {
        kotlin.jvm.internal.k.f(keyToMatch, "keyToMatch");
        int i = this.c;
        try {
            if (f() == 6 && kotlin.jvm.internal.k.b(s(z10), keyToMatch)) {
                this.b = null;
                if (f() == 5) {
                    return s(z10);
                }
            }
            return null;
        } finally {
            this.c = i;
            this.b = null;
        }
    }

    public byte r() {
        String str = (String) this.e;
        int i = this.c;
        while (true) {
            int iT = t(i);
            if (iT == -1) {
                this.c = iT;
                return (byte) 10;
            }
            char cCharAt = str.charAt(iT);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.c = iT;
                return j.f(cCharAt);
            }
            i = iT + 1;
        }
    }

    public String s(boolean z10) {
        String strJ;
        byte bR = r();
        if (z10) {
            if (bR != 1 && bR != 0) {
                return null;
            }
            strJ = k();
        } else {
            if (bR != 1) {
                return null;
            }
            strJ = j();
        }
        this.b = strJ;
        return strJ;
    }

    public int t(int i) {
        if (i < ((String) this.e).length()) {
            return i;
        }
        return -1;
    }

    public String toString() {
        switch (this.f447a) {
            case 0:
                StringBuilder sb = new StringBuilder("JsonReader(source='");
                sb.append(this.e);
                sb.append("', currentPosition=");
                return B7.a.o(sb, this.c, ')');
            default:
                return super.toString();
        }
    }

    public int u() {
        char cCharAt;
        int i = this.c;
        if (i == -1) {
            return i;
        }
        String str = (String) this.e;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i++;
        }
        this.c = i;
        return i;
    }

    public boolean v() {
        int iU = u();
        String str = (String) this.e;
        if (iU >= str.length() || iU == -1 || str.charAt(iU) != ',') {
            return false;
        }
        this.c++;
        return true;
    }

    public boolean w(boolean z10) {
        int iT = t(u());
        String str = (String) this.e;
        int length = str.length() - iT;
        if (length >= 4 && iT != -1) {
            int i = 0;
            while (true) {
                if (i < 4) {
                    if ("null".charAt(i) != str.charAt(iT + i)) {
                        break;
                    }
                    i++;
                } else if (length <= 4 || j.f(str.charAt(iT + 4)) != 0) {
                    if (z10) {
                        this.c = iT + 4;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void x(char c) {
        String str = (String) this.e;
        int i = this.c;
        if (i > 0 && c == '\"') {
            try {
                this.c = i - 1;
                String strK = k();
                this.c = i;
                if (kotlin.jvm.internal.k.b(strK, "null")) {
                    n(this.c - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.c = i;
                throw th;
            }
        }
        String strR = j.r(j.f(c));
        int i6 = this.c;
        int i10 = i6 - 1;
        o(this, androidx.appfunctions.metadata.a.m("Expected ", strR, ", but had '", (i6 == str.length() || i10 < 0) ? "EOF" : String.valueOf(str.charAt(i10)), "' instead"), i10, null, 4);
        throw null;
    }

    public t(K1.a c, InterfaceC1528k interfaceC1528k, InterfaceC2122e typeParameterOwner, int i) {
        kotlin.jvm.internal.k.f(c, "c");
        kotlin.jvm.internal.k.f(typeParameterOwner, "typeParameterOwner");
        this.d = c;
        this.b = interfaceC1528k;
        this.c = i;
        ArrayList typeParameters = typeParameterOwner.getTypeParameters();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = typeParameters.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i6));
            i6++;
        }
        this.e = linkedHashMap;
        this.f = ((W8.i) ((C2024a) ((K1.a) this.d).f903a).f6670a).d(new J4.b(this, 22));
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Serializable, java.lang.Object[]] */
    public t(String source) {
        kotlin.jvm.internal.k.f(source, "source");
        l lVar = new l(0, (byte) 0);
        lVar.c = new Object[8];
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        lVar.d = iArr;
        lVar.b = -1;
        this.d = lVar;
        this.f = new StringBuilder();
        this.e = source;
    }
}
