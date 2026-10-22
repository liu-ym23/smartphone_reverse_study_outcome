package C4;

import java.io.EOFException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f957j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    final String f958a;

    /* renamed from: b, reason: collision with root package name */
    private final String f959b;

    /* renamed from: c, reason: collision with root package name */
    private final String f960c;

    /* renamed from: d, reason: collision with root package name */
    final String f961d;

    /* renamed from: e, reason: collision with root package name */
    final int f962e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f963f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private final List<String> f964g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f965h;

    /* renamed from: i, reason: collision with root package name */
    private final String f966i;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        String f967a;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        String f970d;

        /* renamed from: f, reason: collision with root package name */
        final List<String> f972f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        List<String> f973g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        String f974h;

        /* renamed from: b, reason: collision with root package name */
        String f968b = BuildConfig.FLAVOR;

        /* renamed from: c, reason: collision with root package name */
        String f969c = BuildConfig.FLAVOR;

        /* renamed from: e, reason: collision with root package name */
        int f971e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f972f = arrayList;
            arrayList.add(BuildConfig.FLAVOR);
        }

        @Nullable
        private static String d(String str, int i5, int i6) {
            return D4.e.d(w.t(str, i5, i6, false));
        }

        private boolean h(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean i(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int k(String str, int i5, int i6) throws NumberFormatException {
            int i7;
            try {
                i7 = Integer.parseInt(w.a(str, i5, i6, BuildConfig.FLAVOR, false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i7 <= 0 || i7 > 65535) {
                return -1;
            }
            return i7;
        }

        private void m() {
            if (!this.f972f.remove(r0.size() - 1).isEmpty() || this.f972f.isEmpty()) {
                this.f972f.add(BuildConfig.FLAVOR);
            } else {
                this.f972f.set(r2.size() - 1, BuildConfig.FLAVOR);
            }
        }

        private static int o(String str, int i5, int i6) {
            while (i5 < i6) {
                char cCharAt = str.charAt(i5);
                if (cCharAt == ':') {
                    return i5;
                }
                if (cCharAt == '[') {
                    do {
                        i5++;
                        if (i5 < i6) {
                        }
                    } while (str.charAt(i5) != ']');
                }
                i5++;
            }
            return i6;
        }

        private void p(String str, int i5, int i6, boolean z5, boolean z6) throws EOFException {
            String strA = w.a(str, i5, i6, " \"<>^`{}|/\\?#", z6, false, false, true, null);
            if (h(strA)) {
                return;
            }
            if (i(strA)) {
                m();
                return;
            }
            if (this.f972f.get(r11.size() - 1).isEmpty()) {
                this.f972f.set(r11.size() - 1, strA);
            } else {
                this.f972f.add(strA);
            }
            if (z5) {
                this.f972f.add(BuildConfig.FLAVOR);
            }
        }

        private void r(String str, int i5, int i6) throws EOFException {
            if (i5 == i6) {
                return;
            }
            char cCharAt = str.charAt(i5);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f972f.clear();
                this.f972f.add(BuildConfig.FLAVOR);
                i5++;
            } else {
                List<String> list = this.f972f;
                list.set(list.size() - 1, BuildConfig.FLAVOR);
            }
            int i7 = i5;
            while (i7 < i6) {
                int iO = D4.e.o(str, i7, i6, "/\\");
                boolean z5 = iO < i6;
                a aVar = this;
                String str2 = str;
                aVar.p(str2, i7, iO, z5, true);
                if (z5) {
                    iO++;
                }
                i7 = iO;
                this = aVar;
                str = str2;
            }
        }

        private static int t(String str, int i5, int i6) {
            if (i6 - i5 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i5);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i5++;
                    if (i5 >= i6) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i5;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int u(String str, int i5, int i6) {
            int i7 = 0;
            while (i5 < i6) {
                char cCharAt = str.charAt(i5);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i7++;
                i5++;
            }
            return i7;
        }

        public a a(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f973g == null) {
                this.f973g = new ArrayList();
            }
            this.f973g.add(w.b(str, " \"'<>#&=", true, false, true, true));
            this.f973g.add(str2 != null ? w.b(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public a b(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f973g == null) {
                this.f973g = new ArrayList();
            }
            this.f973g.add(w.b(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.f973g.add(str2 != null ? w.b(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        public w c() {
            if (this.f967a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f970d != null) {
                return new w(this);
            }
            throw new IllegalStateException("host == null");
        }

        int e() {
            int i5 = this.f971e;
            return i5 != -1 ? i5 : w.e(this.f967a);
        }

        public a f(@Nullable String str) {
            this.f973g = str != null ? w.A(w.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a g(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strD = d(str, 0, str.length());
            if (strD != null) {
                this.f970d = strD;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        a j(@Nullable w wVar, String str) throws NumberFormatException, EOFException {
            int iO;
            String str2;
            int i5;
            String str3;
            String str4 = str;
            int iF = D4.e.F(str4, 0, str4.length());
            int iG = D4.e.G(str4, iF, str4.length());
            int iT = t(str4, iF, iG);
            if (iT != -1) {
                if (str4.regionMatches(true, iF, "https:", 0, 6)) {
                    this.f967a = "https";
                    iF += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (!str4.regionMatches(true, iF, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, iT) + "'");
                    }
                    this.f967a = "http";
                    iF += 5;
                }
            } else {
                if (wVar == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f967a = wVar.f958a;
            }
            int iU = u(str4, iF, iG);
            char c6 = '#';
            if (iU >= 2 || wVar == null || !wVar.f958a.equals(this.f967a)) {
                int i6 = iF + iU;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    iO = D4.e.o(str4, i6, iG, "@/\\?#");
                    char cCharAt = iO != iG ? str4.charAt(iO) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c6 || cCharAt == '/' || cCharAt == '\\' || cCharAt == '?') {
                        break;
                    }
                    if (cCharAt != '@') {
                        str3 = str4;
                    } else {
                        if (z5) {
                            i5 = iO;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.f969c);
                            sb.append("%40");
                            str3 = str;
                            sb.append(w.a(str3, i6, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                            this.f969c = sb.toString();
                        } else {
                            int iN = D4.e.n(str4, i6, iO, ':');
                            String strA = w.a(str, i6, iN, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z6) {
                                strA = this.f968b + "%40" + strA;
                            }
                            this.f968b = strA;
                            if (iN != iO) {
                                i5 = iO;
                                this.f969c = w.a(str, iN + 1, i5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z5 = true;
                            } else {
                                i5 = iO;
                            }
                            str3 = str;
                            z6 = true;
                        }
                        i6 = i5 + 1;
                    }
                    str4 = str3;
                    c6 = '#';
                }
                str2 = str4;
                int i7 = i6;
                int iO2 = o(str2, i7, iO);
                int i8 = iO2 + 1;
                if (i8 < iO) {
                    this.f970d = d(str2, i7, iO2);
                    int iK = k(str2, i8, iO);
                    this.f971e = iK;
                    if (iK == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i8, iO) + '\"');
                    }
                } else {
                    this.f970d = d(str2, i7, iO2);
                    this.f971e = w.e(this.f967a);
                }
                if (this.f970d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i7, iO2) + '\"');
                }
                iF = iO;
            } else {
                this.f968b = wVar.k();
                this.f969c = wVar.g();
                this.f970d = wVar.f961d;
                this.f971e = wVar.f962e;
                this.f972f.clear();
                this.f972f.addAll(wVar.i());
                if (iF == iG || str4.charAt(iF) == '#') {
                    f(wVar.j());
                }
                str2 = str4;
            }
            int iO3 = D4.e.o(str2, iF, iG, "?#");
            r(str2, iF, iO3);
            if (iO3 < iG && str2.charAt(iO3) == '?') {
                int iN2 = D4.e.n(str2, iO3, iG, '#');
                this.f973g = w.A(w.a(str2, iO3 + 1, iN2, " \"'<>#", true, false, true, true, null));
                iO3 = iN2;
            }
            if (iO3 < iG && str2.charAt(iO3) == '#') {
                this.f974h = w.a(str2, iO3 + 1, iG, BuildConfig.FLAVOR, true, false, false, false, null);
            }
            return this;
        }

        public a l(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f969c = w.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a n(int i5) {
            if (i5 > 0 && i5 <= 65535) {
                this.f971e = i5;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i5);
        }

        a q() {
            int size = this.f972f.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f972f.set(i5, w.b(this.f972f.get(i5), "[]", true, true, false, true));
            }
            List<String> list = this.f973g;
            if (list != null) {
                int size2 = list.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    String str = this.f973g.get(i6);
                    if (str != null) {
                        this.f973g.set(i6, w.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f974h;
            if (str2 != null) {
                this.f974h = w.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a s(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f967a = "http";
                return this;
            }
            if (str.equalsIgnoreCase("https")) {
                this.f967a = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f967a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f968b.isEmpty() || !this.f969c.isEmpty()) {
                sb.append(this.f968b);
                if (!this.f969c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f969c);
                }
                sb.append('@');
            }
            String str2 = this.f970d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f970d);
                    sb.append(']');
                } else {
                    sb.append(this.f970d);
                }
            }
            if (this.f971e != -1 || this.f967a != null) {
                int iE = e();
                String str3 = this.f967a;
                if (str3 == null || iE != w.e(str3)) {
                    sb.append(':');
                    sb.append(iE);
                }
            }
            w.s(sb, this.f972f);
            if (this.f973g != null) {
                sb.append('?');
                w.o(sb, this.f973g);
            }
            if (this.f974h != null) {
                sb.append('#');
                sb.append(this.f974h);
            }
            return sb.toString();
        }

        public a v(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f968b = w.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    w(a aVar) {
        this.f958a = aVar.f967a;
        this.f959b = u(aVar.f968b, false);
        this.f960c = u(aVar.f969c, false);
        this.f961d = aVar.f970d;
        this.f962e = aVar.e();
        this.f963f = v(aVar.f972f, false);
        List<String> list = aVar.f973g;
        this.f964g = list != null ? v(list, true) : null;
        String str = aVar.f974h;
        this.f965h = str != null ? u(str, false) : null;
        this.f966i = aVar.toString();
    }

    static List<String> A(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 <= str.length()) {
            int iIndexOf = str.indexOf(38, i5);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i5);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i5, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i5, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i5 = iIndexOf + 1;
        }
        return arrayList;
    }

    static String a(String str, int i5, int i6, String str2, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable Charset charset) throws EOFException {
        int iCharCount = i5;
        while (iCharCount < i6) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z8) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z5 || (z6 && !x(str, iCharCount, i6)))) || (iCodePointAt == 43 && z7)))) {
                L4.e eVar = new L4.e();
                eVar.w0(str, i5, iCharCount);
                d(eVar, str, iCharCount, i6, str2, z5, z6, z7, z8, charset);
                return eVar.O();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i5, i6);
    }

    static String b(String str, String str2, boolean z5, boolean z6, boolean z7, boolean z8) {
        return a(str, 0, str.length(), str2, z5, z6, z7, z8, null);
    }

    static String c(String str, String str2, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable Charset charset) {
        return a(str, 0, str.length(), str2, z5, z6, z7, z8, charset);
    }

    static void d(L4.e eVar, String str, int i5, int i6, String str2, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable Charset charset) throws EOFException {
        L4.e eVar2 = null;
        while (i5 < i6) {
            int iCodePointAt = str.codePointAt(i5);
            if (!z5 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z7) {
                    eVar.H(z5 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z8) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z5 || (z6 && !x(str, i5, i6)))))) {
                    if (eVar2 == null) {
                        eVar2 = new L4.e();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        eVar2.z0(iCodePointAt);
                    } else {
                        eVar2.s0(str, i5, Character.charCount(iCodePointAt) + i5, charset);
                    }
                    while (!eVar2.t()) {
                        byte b6 = eVar2.readByte();
                        eVar.writeByte(37);
                        char[] cArr = f957j;
                        eVar.writeByte(cArr[((b6 & 255) >> 4) & 15]);
                        eVar.writeByte(cArr[b6 & 15]);
                    }
                } else {
                    eVar.z0(iCodePointAt);
                }
            }
            i5 += Character.charCount(iCodePointAt);
        }
    }

    public static int e(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static w l(String str) {
        return new a().j(null, str).c();
    }

    static void o(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            String str = list.get(i5);
            String str2 = list.get(i5 + 1);
            if (i5 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static void s(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            sb.append('/');
            sb.append(list.get(i5));
        }
    }

    static String t(String str, int i5, int i6, boolean z5) {
        for (int i7 = i5; i7 < i6; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == '%' || (cCharAt == '+' && z5)) {
                L4.e eVar = new L4.e();
                eVar.w0(str, i5, i7);
                w(eVar, str, i7, i6, z5);
                return eVar.O();
            }
        }
        return str.substring(i5, i6);
    }

    static String u(String str, boolean z5) {
        return t(str, 0, str.length(), z5);
    }

    private List<String> v(List<String> list, boolean z5) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            String str = list.get(i5);
            arrayList.add(str != null ? u(str, z5) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void w(L4.e r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = D4.e.k(r2)
            char r3 = r6.charAt(r1)
            int r3 = D4.e.k(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.z0(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C4.w.w(L4.e, java.lang.String, int, int, boolean):void");
    }

    static boolean x(String str, int i5, int i6) {
        int i7 = i5 + 2;
        return i7 < i6 && str.charAt(i5) == '%' && D4.e.k(str.charAt(i5 + 1)) != -1 && D4.e.k(str.charAt(i7)) != -1;
    }

    public String B() {
        return q("/...").v(BuildConfig.FLAVOR).l(BuildConfig.FLAVOR).c().toString();
    }

    @Nullable
    public w C(String str) {
        a aVarQ = q(str);
        if (aVarQ != null) {
            return aVarQ.c();
        }
        return null;
    }

    public String D() {
        return this.f958a;
    }

    public URI E() {
        String string = p().q().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e6) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", BuildConfig.FLAVOR));
            } catch (Exception unused) {
                throw new RuntimeException(e6);
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof w) && ((w) obj).f966i.equals(this.f966i);
    }

    @Nullable
    public String f() {
        if (this.f965h == null) {
            return null;
        }
        return this.f966i.substring(this.f966i.indexOf(35) + 1);
    }

    public String g() {
        if (this.f960c.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        return this.f966i.substring(this.f966i.indexOf(58, this.f958a.length() + 3) + 1, this.f966i.indexOf(64));
    }

    public String h() {
        int iIndexOf = this.f966i.indexOf(47, this.f958a.length() + 3);
        String str = this.f966i;
        return this.f966i.substring(iIndexOf, D4.e.o(str, iIndexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.f966i.hashCode();
    }

    public List<String> i() {
        int iIndexOf = this.f966i.indexOf(47, this.f958a.length() + 3);
        String str = this.f966i;
        int iO = D4.e.o(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iO) {
            int i5 = iIndexOf + 1;
            int iN = D4.e.n(this.f966i, i5, iO, '/');
            arrayList.add(this.f966i.substring(i5, iN));
            iIndexOf = iN;
        }
        return arrayList;
    }

    @Nullable
    public String j() {
        if (this.f964g == null) {
            return null;
        }
        int iIndexOf = this.f966i.indexOf(63) + 1;
        String str = this.f966i;
        return this.f966i.substring(iIndexOf, D4.e.n(str, iIndexOf, str.length(), '#'));
    }

    public String k() {
        if (this.f959b.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int length = this.f958a.length() + 3;
        String str = this.f966i;
        return this.f966i.substring(length, D4.e.o(str, length, str.length(), ":@"));
    }

    public String m() {
        return this.f961d;
    }

    public boolean n() {
        return this.f958a.equals("https");
    }

    public a p() {
        a aVar = new a();
        aVar.f967a = this.f958a;
        aVar.f968b = k();
        aVar.f969c = g();
        aVar.f970d = this.f961d;
        aVar.f971e = this.f962e != e(this.f958a) ? this.f962e : -1;
        aVar.f972f.clear();
        aVar.f972f.addAll(i());
        aVar.f(j());
        aVar.f974h = f();
        return aVar;
    }

    @Nullable
    public a q(String str) {
        try {
            return new a().j(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public List<String> r() {
        return this.f963f;
    }

    public String toString() {
        return this.f966i;
    }

    public int y() {
        return this.f962e;
    }

    @Nullable
    public String z() {
        if (this.f964g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        o(sb, this.f964g);
        return sb.toString();
    }
}
