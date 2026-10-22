package rc;

import com.autonavi.aps.amapapi.config.Const;
import java.util.HashSet;
import java.util.Set;
import org.scilab.forge.jlatexmath.FormulaNotFoundException;
import org.scilab.forge.jlatexmath.ParseException;
import org.scilab.forge.jlatexmath.SymbolNotFoundException;

/* loaded from: classes5.dex */
public class d1 {

    /* renamed from: n, reason: collision with root package name */
    public static boolean f39253n = false;

    /* renamed from: o, reason: collision with root package name */
    public static final Set<String> f39254o;

    /* renamed from: a, reason: collision with root package name */
    public a1 f39255a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuffer f39256b;

    /* renamed from: c, reason: collision with root package name */
    public int f39257c;

    /* renamed from: d, reason: collision with root package name */
    public int f39258d;

    /* renamed from: e, reason: collision with root package name */
    public int f39259e;

    /* renamed from: f, reason: collision with root package name */
    public int f39260f;

    /* renamed from: g, reason: collision with root package name */
    public int f39261g;

    /* renamed from: h, reason: collision with root package name */
    public int f39262h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39263i;

    /* renamed from: j, reason: collision with root package name */
    public int f39264j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39265k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39266l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f39267m;

    static {
        HashSet hashSet = new HashSet(6);
        f39254o = hashSet;
        hashSet.add("jlmDynamic");
        hashSet.add("jlmText");
        hashSet.add("jlmTextit");
        hashSet.add("jlmTextbf");
        hashSet.add("jlmTextitbf");
        hashSet.add("jlmExternalFont");
    }

    public d1(String str, a1 a1Var) {
        this(str, a1Var, true);
    }

    public static char d(char c10) {
        int i10;
        if (c10 == 1643) {
            return '.';
        }
        if (1632 <= c10 && c10 <= 1641) {
            i10 = c10 - 1584;
        } else if (1776 <= c10 && c10 <= 1785) {
            i10 = c10 - 1728;
        } else if (2406 <= c10 && c10 <= 2415) {
            i10 = c10 - 2358;
        } else if (2534 <= c10 && c10 <= 2543) {
            i10 = c10 - 2486;
        } else if (2662 <= c10 && c10 <= 2671) {
            i10 = c10 - 2614;
        } else if (2790 <= c10 && c10 <= 2799) {
            i10 = c10 - 2742;
        } else if (2918 <= c10 && c10 <= 2927) {
            i10 = c10 - 2870;
        } else if (3174 <= c10 && c10 <= 3183) {
            i10 = c10 - 3126;
        } else if (3430 <= c10 && c10 <= 3439) {
            i10 = c10 - 3382;
        } else if (3664 <= c10 && c10 <= 3673) {
            i10 = c10 - 3616;
        } else if (3792 <= c10 && c10 <= 3801) {
            i10 = c10 - 3744;
        } else if (3872 <= c10 && c10 <= 3881) {
            i10 = c10 - 3728;
        } else if (4160 <= c10 && c10 <= 4169) {
            i10 = c10 - 4112;
        } else if (6112 <= c10 && c10 <= 6121) {
            i10 = c10 - 6064;
        } else if (6160 <= c10 && c10 <= 6169) {
            i10 = c10 - 6112;
        } else if (6992 <= c10 && c10 <= 7001) {
            i10 = c10 - 6944;
        } else if (7088 <= c10 && c10 <= 7097) {
            i10 = c10 - 7040;
        } else if (7232 <= c10 && c10 <= 7241) {
            i10 = c10 - 7184;
        } else if (7248 <= c10 && c10 <= 7257) {
            i10 = c10 - 7200;
        } else {
            if (43216 > c10 || c10 > 43225) {
                return c10;
            }
            i10 = c10 - 43168;
        }
        return (char) i10;
    }

    public boolean A() {
        return this.f39266l;
    }

    public final boolean B(char c10) {
        if (Character.isLetter(c10)) {
            return true;
        }
        return this.f39264j != 0 && c10 == '@';
    }

    public final boolean C(String str) {
        char cCharAt = 0;
        if (str == null || "".equals(str) || str.charAt(0) != '\\') {
            return false;
        }
        int length = str.length();
        for (int i10 = 1; i10 < length; i10++) {
            cCharAt = str.charAt(i10);
            if (!Character.isLetter(cCharAt) && (this.f39264j == 0 || cCharAt != '@')) {
                break;
            }
        }
        return Character.isLetter(cCharAt);
    }

    public void D() {
        this.f39264j++;
    }

    public void E() {
        this.f39264j--;
    }

    public void F() throws ParseException {
        int i10;
        boolean z10;
        char cCharAt;
        if (this.f39261g != 0) {
            while (true) {
                int i11 = this.f39257c;
                if (i11 >= this.f39261g) {
                    break;
                }
                char cCharAt2 = this.f39256b.charAt(i11);
                if (cCharAt2 != '\t') {
                    if (cCharAt2 == '\n') {
                        this.f39259e++;
                        this.f39260f = this.f39257c;
                    } else if (cCharAt2 != '\r') {
                        if (cCharAt2 == ' ') {
                            this.f39257c++;
                            if (!this.f39266l) {
                                this.f39255a.d(new R0());
                                this.f39255a.d(new C5288j());
                                while (true) {
                                    int i12 = this.f39257c;
                                    if (i12 >= this.f39261g || (cCharAt = this.f39256b.charAt(i12)) != ' ' || cCharAt != '\t' || cCharAt != '\r') {
                                        break;
                                    } else {
                                        this.f39257c++;
                                    }
                                }
                            }
                        } else if (cCharAt2 == '\"') {
                            if (this.f39266l) {
                                this.f39255a.d(new r(p(), null, W0.p("prime")));
                                this.f39255a.d(new r(p(), null, W0.p("prime")));
                            } else {
                                this.f39255a.d(c('\'', true));
                                this.f39255a.d(c('\'', true));
                            }
                            this.f39257c++;
                        } else if (cCharAt2 == '$') {
                            int i13 = this.f39257c + 1;
                            this.f39257c = i13;
                            if (!this.f39266l) {
                                if (this.f39256b.charAt(i13) == '$') {
                                    this.f39257c++;
                                    z10 = true;
                                    i10 = 0;
                                } else {
                                    i10 = 2;
                                    z10 = false;
                                }
                                this.f39255a.d(new C5277d0(new a1(this, k('$'), false).f39212d, i10));
                                if (z10 && this.f39256b.charAt(this.f39257c) == '$') {
                                    this.f39257c++;
                                }
                            }
                        } else if (cCharAt2 == '\\') {
                            AbstractC5276d abstractC5276dH = H();
                            this.f39255a.d(abstractC5276dH);
                            if (this.f39265k && (abstractC5276dH instanceof P)) {
                                ((C5274c) this.f39255a).p();
                            }
                            if (this.f39263i) {
                                this.f39263i = false;
                            }
                        } else if (cCharAt2 == '{') {
                            AbstractC5276d abstractC5276dG = g();
                            if (abstractC5276dG != null) {
                                abstractC5276dG.f39248a = 0;
                            }
                            this.f39255a.d(abstractC5276dG);
                        } else if (cCharAt2 == 8245) {
                            if (this.f39266l) {
                                this.f39255a.d(new r(p(), null, W0.p("backprime")));
                            } else {
                                this.f39255a.d(c((char) 8245, true));
                            }
                            this.f39257c++;
                        } else if (cCharAt2 != '&') {
                            if (cCharAt2 == '\'') {
                                if (this.f39266l) {
                                    this.f39255a.d(new r(p(), null, W0.p("prime")));
                                } else {
                                    this.f39255a.d(c('\'', true));
                                }
                                this.f39257c++;
                            } else if (cCharAt2 == '^') {
                                this.f39255a.d(v(cCharAt2));
                            } else if (cCharAt2 != '_') {
                                if (cCharAt2 == '}') {
                                    int i14 = this.f39262h - 1;
                                    this.f39262h = i14;
                                    this.f39257c++;
                                    if (i14 == -1) {
                                        throw new ParseException("Found a closing '}' without an opening '{'!");
                                    }
                                    return;
                                }
                                if (cCharAt2 != '~') {
                                    this.f39255a.d(c(cCharAt2, false));
                                    this.f39257c++;
                                } else {
                                    this.f39255a.d(new R0());
                                    this.f39257c++;
                                }
                            } else if (this.f39266l) {
                                this.f39255a.d(v(cCharAt2));
                            } else {
                                this.f39255a.d(new m1());
                                this.f39257c++;
                            }
                        } else {
                            if (!this.f39265k) {
                                throw new ParseException("Character '&' is only available in array mode !");
                            }
                            ((C5274c) this.f39255a).n();
                            this.f39257c++;
                        }
                    }
                }
                this.f39257c++;
            }
        }
        a1 a1Var = this.f39255a;
        if (a1Var.f39212d != null || this.f39265k) {
            return;
        }
        a1Var.d(new C5317y());
    }

    public final AbstractC5276d G(String str) throws ParseException {
        C5275c0 c5275c0 = C5275c0.f39233f.get(str);
        String[] strArrS = s(c5275c0.f39237c, c5275c0.f39238d ? c5275c0.f39239e : 0);
        strArrS[0] = str;
        if (!C5291k0.d(str)) {
            return (AbstractC5276d) c5275c0.a(this, strArrS);
        }
        x(this.f39258d, this.f39257c, (String) c5275c0.a(this, strArrS));
        return null;
    }

    public final AbstractC5276d H() throws ParseException {
        this.f39258d = this.f39257c;
        String strI = i();
        if (strI.length() == 0) {
            return new C5317y();
        }
        if (C5275c0.f39233f.get(strI) != null) {
            return G(strI);
        }
        try {
            try {
                return a1.k(strI).f39212d;
            } catch (SymbolNotFoundException unused) {
                if (this.f39267m) {
                    return new C5302q(new E0(new a1("\\backslash " + strI).f39212d), null, Cc.c.f1976k);
                }
                throw new ParseException("Unknown symbol or command or predefined TeXFormula: '" + strI + "'");
            }
        } catch (FormulaNotFoundException unused2) {
            return W0.p(strI);
        }
    }

    public final void I() {
        while (true) {
            int i10 = this.f39257c;
            if (i10 >= this.f39261g) {
                return;
            }
            char cCharAt = this.f39256b.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r') {
                return;
            }
            if (cCharAt == '\n') {
                this.f39259e++;
                this.f39260f = this.f39257c;
            }
            this.f39257c++;
        }
    }

    public void a(AbstractC5276d abstractC5276d) {
        this.f39255a.d(abstractC5276d);
    }

    public void b() throws ParseException {
        if (!this.f39265k) {
            throw new ParseException("You can add a row only in array mode !");
        }
        ((C5274c) this.f39255a).p();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0088, code lost:
    
        r11 = r9.f39257c - 1;
        r9.f39257c = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public rc.AbstractC5276d c(char r10, boolean r11) throws org.scilab.forge.jlatexmath.ParseException {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.d1.c(char, boolean):rc.d");
    }

    public void e() {
        this.f39257c = this.f39256b.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0547  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() throws org.scilab.forge.jlatexmath.ParseException {
        /*
            Method dump skipped, instructions count: 1446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.d1.f():void");
    }

    public AbstractC5276d g() throws ParseException {
        I();
        int i10 = this.f39257c;
        if (i10 >= this.f39261g) {
            return new C5317y();
        }
        char cCharAt = this.f39256b.charAt(i10);
        if (cCharAt != '{') {
            if (cCharAt != '\\') {
                AbstractC5276d abstractC5276dC = c(cCharAt, true);
                this.f39257c++;
                return abstractC5276dC;
            }
            AbstractC5276d abstractC5276dH = H();
            if (!this.f39263i) {
                return abstractC5276dH;
            }
            this.f39263i = false;
            return g();
        }
        a1 a1Var = new a1();
        a1 a1Var2 = this.f39255a;
        this.f39255a = a1Var;
        this.f39257c++;
        this.f39262h++;
        F();
        this.f39255a = a1Var2;
        if (a1Var2.f39212d != null) {
            return a1Var.f39212d;
        }
        I0 i02 = new I0();
        i02.i(a1Var.f39212d);
        return i02;
    }

    public int h() {
        return (this.f39257c - this.f39260f) - 1;
    }

    public final String i() {
        int i10;
        int i11 = this.f39257c + 1;
        this.f39257c = i11;
        char cCharAt = 0;
        while (true) {
            int i12 = this.f39257c;
            if (i12 >= this.f39261g || (((cCharAt = this.f39256b.charAt(i12)) < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && (this.f39264j == 0 || cCharAt != '@')))) {
                break;
            }
            this.f39257c++;
        }
        if (cCharAt == 0) {
            return "";
        }
        int i13 = this.f39257c;
        if (i13 == i11) {
            this.f39257c = i13 + 1;
        }
        String strSubstring = this.f39256b.substring(i11, this.f39257c);
        if ("cr".equals(strSubstring) && (i10 = this.f39257c) < this.f39261g && this.f39256b.charAt(i10) == ' ') {
            this.f39257c++;
        }
        return strSubstring;
    }

    public final String j(String str) {
        if (str.equals("left")) {
            return n("\\left", "\\right");
        }
        C5275c0 c5275c0 = C5275c0.f39233f.get(str);
        if (c5275c0 == null) {
            return "\\" + str;
        }
        int i10 = 0;
        String[] strArrS = s(c5275c0.f39237c, c5275c0.f39238d ? c5275c0.f39239e : 0);
        StringBuffer stringBuffer = new StringBuffer("\\");
        stringBuffer.append(str);
        for (int i11 = 0; i11 < c5275c0.f39239e; i11++) {
            String str2 = strArrS[c5275c0.f39237c + i11 + 1];
            if (str2 != null) {
                stringBuffer.append("[");
                stringBuffer.append(str2);
                stringBuffer.append("]");
            }
        }
        while (i10 < c5275c0.f39237c) {
            i10++;
            String str3 = strArrS[i10];
            if (str3 != null) {
                stringBuffer.append(Const.STR_MART_JSON_BEGIN);
                stringBuffer.append(str3);
                stringBuffer.append("}");
            }
        }
        return stringBuffer.toString();
    }

    public String k(char c10) throws ParseException {
        char cCharAt;
        int i10;
        int i11 = this.f39257c;
        do {
            StringBuffer stringBuffer = this.f39256b;
            int i12 = this.f39257c;
            this.f39257c = i12 + 1;
            cCharAt = stringBuffer.charAt(i12);
            if (cCharAt == '\\') {
                this.f39257c++;
            }
            i10 = this.f39257c;
            if (i10 >= this.f39261g) {
                break;
            }
        } while (cCharAt != c10);
        return cCharAt == c10 ? this.f39256b.substring(i11, i10 - 1) : this.f39256b.substring(i11, i10);
    }

    public AbstractC5276d l() {
        a1 a1Var = this.f39255a;
        AbstractC5276d abstractC5276d = a1Var.f39212d;
        a1Var.f39212d = null;
        return abstractC5276d;
    }

    public String m(char c10, char c11) throws ParseException {
        int i10;
        int i11;
        int i12 = this.f39257c;
        if (i12 == this.f39261g) {
            return null;
        }
        char cCharAt = this.f39256b.charAt(i12);
        int i13 = this.f39257c;
        if (i13 >= this.f39261g || cCharAt != c10) {
            throw new ParseException("missing '" + c10 + "'!");
        }
        int i14 = 1;
        while (true) {
            i10 = this.f39257c;
            if (i10 >= this.f39261g - 1 || i14 == 0) {
                break;
            }
            int i15 = i10 + 1;
            this.f39257c = i15;
            char cCharAt2 = this.f39256b.charAt(i15);
            if (cCharAt2 == c10) {
                i14++;
            } else if (cCharAt2 == c11) {
                i14--;
            } else if (cCharAt2 == '\\' && (i11 = this.f39257c) != this.f39261g - 1) {
                this.f39257c = i11 + 1;
            }
        }
        int i16 = i10 + 1;
        this.f39257c = i16;
        return i14 != 0 ? this.f39256b.substring(i13 + 1, i16) : this.f39256b.substring(i13 + 1, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079 A[PHI: r8
      0x0079: PHI (r8v3 char) = (r8v2 char), (r8v2 char), (r8v14 char), (r8v14 char) binds: [B:7:0x003e, B:9:0x0042, B:16:0x006d, B:18:0x0073] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String n(java.lang.String r18, java.lang.String r19) throws org.scilab.forge.jlatexmath.ParseException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.d1.n(java.lang.String, java.lang.String):java.lang.String");
    }

    public boolean o() {
        return this.f39267m;
    }

    public AbstractC5276d p() {
        a1 a1Var = this.f39255a;
        AbstractC5276d abstractC5276d = a1Var.f39212d;
        if (abstractC5276d instanceof I0) {
            return ((I0) abstractC5276d).k();
        }
        a1Var.f39212d = null;
        return abstractC5276d;
    }

    public float[] q() throws ParseException {
        if (this.f39257c == this.f39261g) {
            return null;
        }
        I();
        int i10 = this.f39257c;
        char cCharAt = 0;
        while (true) {
            int i11 = this.f39257c;
            if (i11 >= this.f39261g || cCharAt == ' ') {
                break;
            }
            StringBuffer stringBuffer = this.f39256b;
            this.f39257c = i11 + 1;
            cCharAt = stringBuffer.charAt(i11);
        }
        I();
        return R0.k(this.f39256b.substring(i10, this.f39257c - 1));
    }

    public int r() {
        return this.f39259e;
    }

    public String[] s(int i10, int i11) {
        String[] strArr = new String[i10 + 11];
        if (i10 != 0) {
            if (i11 == 1) {
                for (int i12 = i10 + 1; i12 < i10 + 11; i12++) {
                    try {
                        I();
                        strArr[i12] = m('[', ']');
                    } catch (ParseException unused) {
                        strArr[i12] = null;
                    }
                }
            }
            I();
            try {
                strArr[1] = m('{', '}');
            } catch (ParseException unused2) {
                if (this.f39256b.charAt(this.f39257c) != '\\') {
                    strArr[1] = "" + this.f39256b.charAt(this.f39257c);
                    this.f39257c = this.f39257c + 1;
                } else {
                    strArr[1] = j(i());
                }
            }
            if (i11 == 2) {
                for (int i13 = i10 + 1; i13 < i10 + 11; i13++) {
                    try {
                        I();
                        strArr[i13] = m('[', ']');
                    } catch (ParseException unused3) {
                        strArr[i13] = null;
                    }
                }
            }
            for (int i14 = 2; i14 <= i10; i14++) {
                I();
                try {
                    strArr[i14] = m('{', '}');
                } catch (ParseException unused4) {
                    if (this.f39256b.charAt(this.f39257c) != '\\') {
                        strArr[i14] = "" + this.f39256b.charAt(this.f39257c);
                        this.f39257c = this.f39257c + 1;
                    } else {
                        strArr[i14] = j(i());
                    }
                }
            }
            if (this.f39266l) {
                I();
            }
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String t() throws org.scilab.forge.jlatexmath.ParseException {
        /*
            r10 = this;
            int r0 = r10.f39257c
            int r1 = r10.f39261g
            if (r0 != r1) goto L8
            r10 = 0
            return r10
        L8:
            r1 = 0
            r2 = 1
            r4 = r1
            r3 = r2
        Lc:
            int r5 = r10.f39257c
            int r6 = r10.f39261g
            r7 = 125(0x7d, float:1.75E-43)
            r8 = 38
            r9 = 92
            if (r5 >= r6) goto L7d
            if (r3 == 0) goto L7d
            java.lang.StringBuffer r4 = r10.f39256b
            char r4 = r4.charAt(r5)
            if (r4 == r8) goto L74
            if (r4 == r9) goto L31
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L2e
            if (r4 == r7) goto L2b
            goto L77
        L2b:
            int r3 = r3 + (-1)
            goto L77
        L2e:
            int r3 = r3 + 1
            goto L77
        L31:
            int r5 = r10.f39257c
            int r5 = r5 + r2
            r10.f39257c = r5
            int r6 = r10.f39261g
            if (r5 >= r6) goto L4c
            java.lang.StringBuffer r6 = r10.f39256b
            char r5 = r6.charAt(r5)
            if (r5 != r9) goto L4c
            if (r3 != r2) goto L4c
            int r3 = r3 + (-1)
            int r5 = r10.f39257c
            int r5 = r5 - r2
            r10.f39257c = r5
            goto L77
        L4c:
            int r5 = r10.f39257c
            int r6 = r10.f39261g
            int r6 = r6 - r2
            if (r5 >= r6) goto L77
            java.lang.StringBuffer r6 = r10.f39256b
            char r5 = r6.charAt(r5)
            r6 = 99
            if (r5 != r6) goto L77
            java.lang.StringBuffer r5 = r10.f39256b
            int r6 = r10.f39257c
            int r6 = r6 + r2
            char r5 = r5.charAt(r6)
            r6 = 114(0x72, float:1.6E-43)
            if (r5 != r6) goto L77
            if (r3 != r2) goto L77
            int r3 = r3 + (-1)
            int r5 = r10.f39257c
            int r5 = r5 - r2
            r10.f39257c = r5
            goto L77
        L74:
            if (r3 != r2) goto L77
            goto L2b
        L77:
            int r5 = r10.f39257c
            int r5 = r5 + r2
            r10.f39257c = r5
            goto Lc
        L7d:
            r6 = 2
            if (r3 >= r6) goto L9f
            if (r3 != 0) goto L8b
            java.lang.StringBuffer r1 = r10.f39256b
            int r5 = r5 - r2
            java.lang.String r0 = r1.substring(r0, r5)
            r1 = r4
            goto L91
        L8b:
            java.lang.StringBuffer r3 = r10.f39256b
            java.lang.String r0 = r3.substring(r0, r5)
        L91:
            if (r1 == r8) goto L99
            if (r1 == r9) goto L99
            if (r1 != r7) goto L98
            goto L99
        L98:
            return r0
        L99:
            int r1 = r10.f39257c
            int r1 = r1 - r2
            r10.f39257c = r1
            return r0
        L9f:
            org.scilab.forge.jlatexmath.ParseException r10 = new org.scilab.forge.jlatexmath.ParseException
            java.lang.String r0 = "Illegal end,  missing '}' !"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.d1.t():java.lang.String");
    }

    public int u() {
        return this.f39257c;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final rc.AbstractC5276d v(char r9) throws org.scilab.forge.jlatexmath.ParseException {
        /*
            r8 = this;
            int r0 = r8.f39257c
            r1 = 1
            int r0 = r0 + r1
            r8.f39257c = r0
            rc.d r0 = r8.g()
            int r2 = r8.f39257c
            int r3 = r8.f39261g
            r4 = 0
            if (r2 >= r3) goto L18
            java.lang.StringBuffer r3 = r8.f39256b
            char r2 = r3.charAt(r2)
            goto L19
        L18:
            r2 = r4
        L19:
            r3 = 94
            r5 = 0
            if (r9 != r3) goto L23
            if (r2 != r3) goto L23
        L20:
            r9 = r0
            r0 = r5
            goto L4a
        L23:
            r6 = 95
            if (r9 != r6) goto L33
            if (r2 != r3) goto L33
            int r9 = r8.f39257c
            int r9 = r9 + r1
            r8.f39257c = r9
            rc.d r9 = r8.g()
            goto L4a
        L33:
            if (r9 != r3) goto L44
            if (r2 != r6) goto L44
            int r9 = r8.f39257c
            int r9 = r9 + r1
            r8.f39257c = r9
            rc.d r9 = r8.g()
            r7 = r0
            r0 = r9
            r9 = r7
            goto L4a
        L44:
            if (r9 != r3) goto L49
            if (r2 == r6) goto L49
            goto L20
        L49:
            r9 = r5
        L4a:
            rc.a1 r8 = r8.f39255a
            rc.d r2 = r8.f39212d
            boolean r3 = r2 instanceof rc.I0
            if (r3 == 0) goto L59
            rc.I0 r2 = (rc.I0) r2
            rc.d r2 = r2.k()
            goto L6c
        L59:
            if (r2 != 0) goto L6a
            rc.v0 r2 = new rc.v0
            rc.m r8 = new rc.m
            r3 = 77
            java.lang.String r6 = "mathnormal"
            r8.<init>(r3, r6)
            r2.<init>(r8, r4, r1, r1)
            goto L6c
        L6a:
            r8.f39212d = r5
        L6c:
            int r8 = r2.h()
            if (r8 != r1) goto L78
            rc.f r8 = new rc.f
            r8.<init>(r2, r0, r9)
            return r8
        L78:
            boolean r8 = r2 instanceof rc.C5306s0
            if (r8 == 0) goto L9b
            r8 = r2
            rc.s0 r8 = (rc.C5306s0) r8
            boolean r1 = r8.k()
            if (r1 == 0) goto L90
            if (r9 == 0) goto L9b
            r8.i(r9)
            rc.M0 r8 = new rc.M0
            r8.<init>(r2, r0, r5)
            return r8
        L90:
            if (r0 == 0) goto L9b
            r8.i(r0)
            rc.M0 r8 = new rc.M0
            r8.<init>(r2, r5, r9)
            return r8
        L9b:
            rc.M0 r8 = new rc.M0
            r8.<init>(r2, r0, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.d1.v(char):rc.d");
    }

    public String w() {
        return this.f39256b.substring(this.f39257c);
    }

    public final void x(int i10, int i11, String str) {
        this.f39256b.replace(i10, i11, str);
        this.f39261g = this.f39256b.length();
        this.f39257c = i10;
        this.f39263i = true;
    }

    public boolean y() {
        return this.f39265k;
    }

    public boolean z() {
        return this.f39266l;
    }

    public d1(boolean z10, String str, a1 a1Var) throws ParseException {
        this(str, a1Var, false);
        this.f39267m = z10;
        f();
    }

    public d1(boolean z10, String str, a1 a1Var, boolean z11) throws ParseException {
        this.f39266l = true;
        this.f39255a = a1Var;
        this.f39267m = z10;
        if (str != null) {
            this.f39256b = new StringBuffer(str);
            this.f39261g = str.length();
            this.f39257c = 0;
            if (z11) {
                f();
                return;
            }
            return;
        }
        this.f39256b = null;
        this.f39257c = 0;
        this.f39261g = 0;
    }

    public d1(String str, a1 a1Var, boolean z10) {
        this(false, str, a1Var, z10);
    }

    public d1(boolean z10, String str, C5274c c5274c, boolean z11) {
        this(z10, str, (a1) c5274c, z11);
        this.f39265k = true;
    }

    public d1(boolean z10, String str, C5274c c5274c, boolean z11, boolean z12) {
        this(z10, str, (a1) c5274c, z11, z12);
        this.f39265k = true;
    }

    public d1(boolean z10, String str, a1 a1Var, boolean z11, boolean z12) {
        this(z10, str, a1Var, z11);
        this.f39266l = z12;
    }
}
