package g3;

import ab.x;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.s0;
import com.stepos.account.oauth.OAuthConstants;
import f8.q0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import l8.c0;
import org.json.JSONObject;
import s8.f0;

/* loaded from: classes.dex */
public class e implements r8.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3801a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f3802b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3803c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3804d;

    /* renamed from: e, reason: collision with root package name */
    public Serializable f3805e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3806f;

    public /* synthetic */ e() {
    }

    public static /* synthetic */ void m(e eVar, String str, int i2, int i10) {
        if ((i10 & 2) != 0) {
            i2 = eVar.f3802b;
        }
        eVar.l(i2, str, (i10 & 4) != 0 ? "" : "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'");
        throw null;
    }

    public static e o(r6.a aVar, boolean z4) {
        x xVar = aVar.f8999m;
        int i2 = xVar != null ? xVar.f668b : 0;
        e bVar = z4 ? new r6.b() : new e();
        bVar.f3803c = aVar.f8989c;
        bVar.f3804d = aVar.f8990d;
        bVar.f3805e = aVar.f8987a;
        bVar.f3802b = i2;
        String string = aVar.f8994h;
        HashMap map = aVar.f8997k;
        if (TextUtils.isEmpty(string)) {
            if (map != null) {
                string = (String) map.get("sk");
                if (TextUtils.isEmpty(string)) {
                    string = new JSONObject(map).toString();
                }
            } else {
                string = null;
            }
        }
        j6.a.b("PushMessage", "self json " + string);
        bVar.f3806f = string;
        return bVar;
    }

    @Override // r8.f
    public q0 a(c0 c0Var) {
        q7.k.e(c0Var, "javaTypeParameter");
        f0 f0Var = (f0) ((b0.e) this.f3806f).invoke(c0Var);
        return f0Var != null ? f0Var : ((r8.f) ((a3.b) this.f3803c).f163g).a(c0Var);
    }

    public int b(CharSequence charSequence, int i2) {
        int i10 = i2 + 4;
        if (i10 < charSequence.length()) {
            ((StringBuilder) this.f3805e).append((char) (n(charSequence, i2 + 3) + (n(charSequence, i2) << 12) + (n(charSequence, i2 + 1) << 8) + (n(charSequence, i2 + 2) << 4)));
            return i10;
        }
        this.f3802b = i2;
        if (i10 < charSequence.length()) {
            return b(charSequence, this.f3802b);
        }
        m(this, "Unexpected EOF during unicode escape", 0, 6);
        throw null;
    }

    public boolean c() {
        int i2 = this.f3802b;
        if (i2 == -1) {
            return false;
        }
        String str = (String) this.f3806f;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f3802b = i2;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i2++;
        }
        this.f3802b = i2;
        return false;
    }

    public String d() {
        StringBuilder sb2 = (StringBuilder) this.f3805e;
        String str = (String) this.f3806f;
        f('\"');
        int i2 = this.f3802b;
        int iQ0 = ga.k.q0(str, '\"', i2, 4);
        if (iQ0 == -1) {
            i();
            int i10 = this.f3802b;
            m(this, a1.a.j("Expected quotation mark '\"', but had '", (i10 == str.length() || i10 < 0) ? "EOF" : String.valueOf(str.charAt(i10)), "' instead"), i10, 4);
            throw null;
        }
        int i11 = i2;
        while (i11 < iQ0) {
            if (str.charAt(i11) == '\\') {
                int iQ = this.f3802b;
                char cCharAt = str.charAt(i11);
                boolean z4 = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        sb2.append((CharSequence) str, iQ, i11);
                        int iQ2 = q(i11 + 1);
                        if (iQ2 == -1) {
                            m(this, "Expected escape sequence to continue, got EOF", 0, 6);
                            throw null;
                        }
                        int iB = iQ2 + 1;
                        char cCharAt2 = str.charAt(iQ2);
                        if (cCharAt2 == 'u') {
                            iB = b(str, iB);
                        } else {
                            char c10 = cCharAt2 < 'u' ? ya.c.f11732a[cCharAt2] : (char) 0;
                            if (c10 == 0) {
                                m(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, 6);
                                throw null;
                            }
                            sb2.append(c10);
                        }
                        iQ = q(iB);
                        if (iQ == -1) {
                            m(this, "Unexpected EOF", iQ, 4);
                            throw null;
                        }
                    } else {
                        i11++;
                        if (i11 >= str.length()) {
                            sb2.append((CharSequence) str, iQ, i11);
                            iQ = q(i11);
                            if (iQ == -1) {
                                m(this, "Unexpected EOF", iQ, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            cCharAt = str.charAt(i11);
                        }
                    }
                    i11 = iQ;
                    z4 = true;
                    cCharAt = str.charAt(i11);
                }
                String string = !z4 ? str.subSequence(iQ, i11).toString() : k(iQ, i11);
                this.f3802b = i11 + 1;
                return string;
            }
            i11++;
        }
        this.f3802b = iQ0 + 1;
        String strSubstring = str.substring(i2, iQ0);
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public byte e() {
        String str = (String) this.f3806f;
        int i2 = this.f3802b;
        while (i2 != -1 && i2 < str.length()) {
            int i10 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f3802b = i10;
                return ya.f.c(cCharAt);
            }
            i2 = i10;
        }
        this.f3802b = str.length();
        return (byte) 10;
    }

    public void f(char c10) {
        int i2 = this.f3802b;
        if (i2 == -1) {
            t(c10);
            throw null;
        }
        String str = (String) this.f3806f;
        while (i2 < str.length()) {
            int i10 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f3802b = i10;
                if (cCharAt == c10) {
                    return;
                }
                t(c10);
                throw null;
            }
            i2 = i10;
        }
        this.f3802b = -1;
        t(c10);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0185, code lost:
    
        throw new a4.u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0186, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0187, code lost:
    
        if (r14 == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0189, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x018e, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0191, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0192, code lost:
    
        m(r22, "Numeric value overflow", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0197, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0198, code lost:
    
        m(r22, "Expected numeric literal", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x019d, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e9, code lost:
    
        m(r22, "Unexpected symbol '" + r5 + "' in numeric literal", r7, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0100, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0101, code lost:
    
        if (r12 == r1) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0103, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0105, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0106, code lost:
    
        if (r1 == r12) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0108, code lost:
    
        if (r14 == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010c, code lost:
    
        if (r1 == (r12 - 1)) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0113, code lost:
    
        if (r3 == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0115, code lost:
    
        if (r5 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x011d, code lost:
    
        if (r2.charAt(r12) != '\"') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x011f, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0122, code lost:
    
        m(r22, "Expected closing quotation mark", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0129, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012a, code lost:
    
        m(r22, "EOF", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012f, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0130, code lost:
    
        r22.f3802b = r12;
        r1 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0134, code lost:
    
        if (r13 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0136, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0139, code lost:
    
        if (r11 != 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013b, code lost:
    
        r3 = java.lang.Math.pow(10.0d, -r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0143, code lost:
    
        if (r11 != 1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0145, code lost:
    
        r3 = java.lang.Math.pow(10.0d, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014a, code lost:
    
        r1 = r1 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x014f, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0155, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x015d, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x015f, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0161, code lost:
    
        m(r22, "Can't convert " + r1 + " to Long", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0179, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x017a, code lost:
    
        m(r22, "Numeric value overflow", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x017f, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long g() {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.e.g():long");
    }

    public String h() {
        String str = (String) this.f3804d;
        if (str == null) {
            return d();
        }
        q7.k.b(str);
        this.f3804d = null;
        return str;
    }

    public String i() {
        String str = (String) this.f3806f;
        String str2 = (String) this.f3804d;
        if (str2 != null) {
            q7.k.b(str2);
            this.f3804d = null;
            return str2;
        }
        int iR = r();
        if (iR >= str.length() || iR == -1) {
            m(this, "EOF", iR, 4);
            throw null;
        }
        byte bC = ya.f.c(str.charAt(iR));
        if (bC == 1) {
            return h();
        }
        if (bC != 0) {
            m(this, "Expected beginning of the string, but got " + str.charAt(iR), 0, 6);
            throw null;
        }
        boolean z4 = false;
        while (ya.f.c(str.charAt(iR)) == 0) {
            iR++;
            if (iR >= str.length()) {
                ((StringBuilder) this.f3805e).append((CharSequence) str, this.f3802b, iR);
                int iQ = q(iR);
                if (iQ == -1) {
                    this.f3802b = iR;
                    return k(0, 0);
                }
                iR = iQ;
                z4 = true;
            }
        }
        String string = !z4 ? str.subSequence(this.f3802b, iR).toString() : k(this.f3802b, iR);
        this.f3802b = iR;
        return string;
    }

    public String j() {
        String strI = i();
        if (!q7.k.a(strI, "null") || ((String) this.f3806f).charAt(this.f3802b - 1) == '\"') {
            return strI;
        }
        m(this, "Unexpected 'null' value instead of string literal", 0, 6);
        throw null;
    }

    public String k(int i2, int i10) {
        StringBuilder sb2 = (StringBuilder) this.f3805e;
        sb2.append((CharSequence) this.f3806f, i2, i10);
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        sb2.setLength(0);
        return string;
    }

    public void l(int i2, String str, String str2) {
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        q7.k.e(str2, "hint");
        throw ya.f.a(i2, (String) this.f3806f, str + " at path: " + ((x) this.f3803c).d() + (str2.length() == 0 ? "" : "\n".concat(str2)));
    }

    public int n(CharSequence charSequence, int i2) {
        char cCharAt = charSequence.charAt(i2);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        m(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, 6);
        throw null;
    }

    public byte p() {
        String str = (String) this.f3806f;
        int i2 = this.f3802b;
        while (true) {
            int iQ = q(i2);
            if (iQ == -1) {
                this.f3802b = iQ;
                return (byte) 10;
            }
            char cCharAt = str.charAt(iQ);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.f3802b = iQ;
                return ya.f.c(cCharAt);
            }
            i2 = iQ + 1;
        }
    }

    public int q(int i2) {
        if (i2 < ((String) this.f3806f).length()) {
            return i2;
        }
        return -1;
    }

    public int r() {
        char cCharAt;
        int i2 = this.f3802b;
        if (i2 == -1) {
            return i2;
        }
        String str = (String) this.f3806f;
        while (i2 < str.length() && ((cCharAt = str.charAt(i2)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i2++;
        }
        this.f3802b = i2;
        return i2;
    }

    public boolean s() {
        int iR = r();
        String str = (String) this.f3806f;
        if (iR >= str.length() || iR == -1 || str.charAt(iR) != ',') {
            return false;
        }
        this.f3802b++;
        return true;
    }

    public void t(char c10) {
        String str = (String) this.f3806f;
        int i2 = this.f3802b;
        if (i2 > 0 && c10 == '\"') {
            try {
                this.f3802b = i2 - 1;
                String strI = i();
                this.f3802b = i2;
                if (q7.k.a(strI, "null")) {
                    l(this.f3802b - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.f3802b = i2;
                throw th;
            }
        }
        byte bC = ya.f.c(c10);
        String str2 = bC == 1 ? "quotation mark '\"'" : bC == 2 ? "string escape sequence '\\'" : bC == 4 ? "comma ','" : bC == 5 ? "colon ':'" : bC == 6 ? "start of the object '{'" : bC == 7 ? "end of the object '}'" : bC == 8 ? "start of the array '['" : bC == 9 ? "end of the array ']'" : bC == 10 ? "end of the input" : bC == 127 ? "invalid token" : "valid token";
        int i10 = this.f3802b;
        int i11 = i10 - 1;
        m(this, m.x.x("Expected ", str2, ", but had '", (i10 == str.length() || i11 < 0) ? "EOF" : String.valueOf(str.charAt(i11)), "' instead"), i11, 4);
        throw null;
    }

    public String toString() {
        switch (this.f3801a) {
            case 1:
                StringBuilder sb2 = new StringBuilder("PushMessage{title='");
                sb2.append((String) this.f3803c);
                sb2.append("', content='");
                sb2.append((String) this.f3804d);
                sb2.append("', pushType=0, taskId='");
                sb2.append((String) this.f3805e);
                sb2.append("', selfDefineContentString='");
                sb2.append((String) this.f3806f);
                sb2.append("', notifyId=");
                return m.x.m(sb2, this.f3802b, '}');
            case 2:
            default:
                return super.toString();
            case 3:
                StringBuilder sb3 = new StringBuilder("JsonReader(source='");
                sb3.append(this.f3806f);
                sb3.append("', currentPosition=");
                return m.x.m(sb3, this.f3802b, ')');
        }
    }

    public e(Context context, h4.n nVar, s0 s0Var, ArrayList arrayList, int i2, LinkedHashSet linkedHashSet, ArrayList arrayList2, ArrayList arrayList3) {
        q7.k.e(context, "context");
        q7.k.e(s0Var, "migrationContainer");
        m.x.t(i2, "journalMode");
        this.f3803c = context;
        this.f3804d = s0Var;
        this.f3805e = arrayList;
        this.f3802b = i2;
        this.f3806f = linkedHashSet;
    }

    public e(a3.b bVar, f8.k kVar, v8.e eVar, int i2) {
        q7.k.e(bVar, "c");
        q7.k.e(eVar, "typeParameterOwner");
        this.f3803c = bVar;
        this.f3804d = kVar;
        this.f3802b = i2;
        ArrayList typeParameters = eVar.getTypeParameters();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = typeParameters.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i10));
            i10++;
        }
        this.f3805e = linkedHashMap;
        this.f3806f = ((u9.k) ((r8.a) ((a3.b) this.f3803c).f162f).f9002a).c(new r8.c(1, this));
    }

    public e(String str) {
        q7.k.e(str, "source");
        x xVar = new x(7, (byte) 0);
        xVar.f669c = new Object[8];
        int[] iArr = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = -1;
        }
        xVar.f670d = iArr;
        xVar.f668b = -1;
        this.f3803c = xVar;
        this.f3805e = new StringBuilder();
        this.f3806f = str;
    }
}
