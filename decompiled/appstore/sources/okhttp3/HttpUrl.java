package okhttp3;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.internal.Util;
import okio.Buffer;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpUrl {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f22699j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f22704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f22705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f22706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f22707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22708i;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f22712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f22714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f22715g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f22716h;

        public static final enum ParseResult extends Enum<ParseResult> {
            private static final /* synthetic */ ParseResult[] $VALUES = null;
            public static final ParseResult INVALID_HOST = null;
            public static final ParseResult INVALID_PORT = null;
            public static final ParseResult MISSING_SCHEME = null;
            public static final ParseResult SUCCESS = null;
            public static final ParseResult UNSUPPORTED_SCHEME = null;

            static {
                ParseResult r10 = new ParseResult("SUCCESS", 0);
                SUCCESS = r10;
                ParseResult r11 = new ParseResult("MISSING_SCHEME", 1);
                MISSING_SCHEME = r11;
                ParseResult r12 = new ParseResult("UNSUPPORTED_SCHEME", 2);
                UNSUPPORTED_SCHEME = r12;
                ParseResult r13 = new ParseResult("INVALID_PORT", 3);
                INVALID_PORT = r13;
                ParseResult r14 = new ParseResult("INVALID_HOST", 4);
                INVALID_HOST = r14;
                $VALUES = new ParseResult[]{r10, r11, r12, r13, r14};
            }

            private ParseResult(String r10, int r11) {
                super(r10, r11);
            }

            public static ParseResult valueOf(String r10) {
                return (ParseResult) Enum.valueOf(ParseResult.class, r10);
            }

            public static ParseResult[] values() {
                return (ParseResult[]) $VALUES.clone();
            }
        }

        public Builder() {
            this.f22710b = "";
            this.f22711c = "";
            this.f22713e = -1;
            ArrayList r10 = new ArrayList();
            this.f22714f = r10;
            r10.add("");
        }

        public static String d(String r10, int r11, int r12) {
            return Util.canonicalizeHost(HttpUrl.u(r10, r11, r12, false));
        }

        public static int k(String r10, int r11, int r12) {
            int r13 = Integer.parseInt(HttpUrl.a(r10, r11, r12, "", false, false, false, true, null));     // Catch: NumberFormatException -> L9
            if (r13 <= 0) goto L8;
            if (r13 > 65535) goto L8;
            return r13;
        L8:
            return -1;
        }

        public static int o(String r10, int r11, int r12) {
        L2:
            if (r11 >= r12) goto L14;
            char r13 = r10.charAt(r11);
            if (r13 == ':') goto L13;
            if (r13 != '[') goto L12;
        L8:
            r11 = r11 + 1;
            if (r11 >= r12) goto L12;
            if (r10.charAt(r11) != ']') goto L8;
        L12:
            r11 = r11 + 1;
            goto L2
        L13:
            return r11;
        L14:
            return r12;
        }

        public static int v(String r10, int r11, int r12) {
            if ((r12 - r11) >= 2) goto L5;
            return -1;
        L5:
            char r13 = r10.charAt(r11);
            if (r13 < 'a') goto L8;
            if (r13 > 'z') goto L8;
        L11:
            r11 = r11 + 1;
            if (r11 >= r12) goto L32;
            char r14 = r10.charAt(r11);
            if (r14 < 'a') goto L16;
            if (r14 <= 'z') goto L11;
        L16:
            if (r14 < 'A') goto L19;
            if (r14 <= 'Z') goto L11;
        L19:
            if (r14 < '0') goto L23;
            if (r14 <= '9') goto L11;
        L23:
            if (r14 == '+') goto L11;
            if (r14 == '-') goto L11;
            if (r14 == '.') goto L11;
            if (r14 != ':') goto L32;
            return r11;
        L32:
            return -1;
        L8:
            if (r13 < 'A') goto L32;
            if (r13 <= 'Z') goto L11;
            goto L32
        }

        public static int w(String r10, int r11, int r12) {
            int r13 = 0;
        L3:
            if (r11 >= r12) goto L9;
            char r14 = r10.charAt(r11);
            if (r14 == '\\') goto L8;
            if (r14 != '/') goto L9;
        L8:
            r13 = r13 + 1;
            r11 = r11 + 1;
        L9:
            return r13;
        }

        public Builder a(String r10, String r11) {
            if (r10 == null) goto L13;
            if (this.f22715g != null) goto L6;
            this.f22715g = new ArrayList();
        L6:
            this.f22715g.add(HttpUrl.b(r10, " \"'<>#&=", true, false, true, true));
            List r12 = this.f22715g;
            if (r11 == null) goto L9;
            String r13 = HttpUrl.b(r11, " \"'<>#&=", true, false, true, true);
        L10:
            r12.add(r13);
            return this;
        L9:
            r13 = null;
            goto L10
        L13:
            throw new NullPointerException("encodedName == null");
        }

        public Builder b(String r10, String r11) {
            if (r10 == null) goto L13;
            if (this.f22715g != null) goto L6;
            this.f22715g = new ArrayList();
        L6:
            this.f22715g.add(HttpUrl.b(r10, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            List r12 = this.f22715g;
            if (r11 == null) goto L9;
            String r13 = HttpUrl.b(r11, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);
        L10:
            r12.add(r13);
            return this;
        L9:
            r13 = null;
            goto L10
        L13:
            throw new NullPointerException("name == null");
        }

        public HttpUrl c() {
            if (this.f22709a == null) goto L11;
            if (this.f22712d == null) goto L9;
            return new HttpUrl(this);
        L9:
            throw new IllegalStateException("host == null");
        L11:
            throw new IllegalStateException("scheme == null");
        }

        public int e() {
            int r10 = this.f22713e;
            if (r10 == (-1)) goto L6;
            return r10;
        L6:
            return HttpUrl.e(this.f22709a);
        }

        public Builder f(String r10) {
            if (r10 == null) goto L4;
            List r11 = HttpUrl.D(HttpUrl.b(r10, " \"'<>#", true, false, true, true));
        L5:
            this.f22715g = r11;
            return this;
        L4:
            r11 = null;
            goto L5
        }

        public Builder g(String r10) {
            if (r10 == null) goto L10;
            String r11 = d(r10, 0, r10.length());
            if (r11 == null) goto L8;
            this.f22712d = r11;
            return this;
        L8:
            throw new IllegalArgumentException("unexpected host: " + r10);
        L10:
            throw new NullPointerException("host == null");
        }

        public final boolean h(String r10) {
            if (r10.equals(LibrarianImpl.Constants.DOT) == false) goto L5;
        L8:
            return true;
        L5:
            if (r10.equalsIgnoreCase("%2e") == true) goto L8;
            return false;
        }

        public final boolean i(String r10) {
            if (r10.equals("..") == false) goto L5;
        L12:
            return true;
        L5:
            if (r10.equalsIgnoreCase("%2e.") == true) goto L12;
            if (r10.equalsIgnoreCase(".%2e") == true) goto L12;
            if (r10.equalsIgnoreCase("%2e%2e") == true) goto L12;
            return false;
        }

        public ParseResult j(HttpUrl r22, String r23) {
            int r10 = Util.skipLeadingAsciiWhitespace(r23, 0, r23.length());
            int r11 = Util.skipTrailingAsciiWhitespace(r23, r10, r23.length());
            if (v(r23, r10, r11) != (-1)) goto L5;
            if (r22 == null) goto L76;
            this.f22709a = r22.f22700a;
        L14:
            int r12 = w(r23, r10, r11);
            char r13 = '?';
            char r14 = '#';
            if (r12 >= 2) goto L25;
            if (r22 == null) goto L25;
            if (r22.f22700a.equals(this.f22709a) == false) goto L25;
            this.f22710b = r22.k();
            this.f22711c = r22.g();
            this.f22712d = r22.f22703d;
            this.f22713e = r22.f22704e;
            this.f22714f.clear();
            this.f22714f.addAll(r22.i());
            if (r10 != r11) goto L23;
        L24:
            f(r22.j());
        L64:
            int r15 = Util.delimiterOffset(r23, r10, r11, "?#");
            t(r23, r10, r15);
            if (r15 < r11) goto L67;
        L69:
            if (r15 >= r11) goto L74;
            if (r23.charAt(r15) != '#') goto L74;
            this.f22716h = HttpUrl.a(r23, 1 + r15, r11, "", true, false, false, false, null);
        L74:
            return ParseResult.SUCCESS;
        L67:
            if (r23.charAt(r15) != '?') goto L69;
            int r16 = Util.delimiterOffset(r23, r15, r11, '#');
            this.f22715g = HttpUrl.D(HttpUrl.a(r23, r15 + 1, r16, " \"'<>#", true, false, true, true, null));
            r15 = r16;
            goto L69
        L23:
            if (r23.charAt(r10) != '#') goto L64;
        L25:
            boolean r17 = false;
            boolean r18 = false;
            int r19 = r10 + r12;
        L26:
            int r20 = Util.delimiterOffset(r23, r19, r11, "@/\\?#");
            if (r20 == r11) goto L29;
            byte r21 = r23.charAt(r20);
        L30:
            if (r21 == (-1)) goto L52;
            if (r21 == r14) goto L52;
            if (r21 == 47) goto L52;
            if (r21 == 92) goto L52;
            if (r21 == r13) goto L52;
            if (r21 != 64) goto L51;
            if (r17 == true) goto L49;
            int r24 = Util.delimiterOffset(r23, r19, r20, ':');
            int r110 = r20;
            String r25 = HttpUrl.a(r23, r19, r24, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            if (r18 == false) goto L45;
            r25 = this.f22710b + "%40" + r25;
        L45:
            this.f22710b = r25;
            if (r24 == r110) goto L48;
            this.f22711c = HttpUrl.a(r23, r24 + 1, r110, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            r17 = true;
        L48:
            r18 = true;
        L50:
            r19 = r110 + 1;
            goto L51
        L49:
            r110 = r20;
            this.f22711c += "%40" + HttpUrl.a(r23, r19, r110, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        L51:
            r13 = '?';
            r14 = '#';
        L52:
            int r26 = o(r23, r19, r20);
            int r27 = r26 + 1;
            if (r27 >= r20) goto L58;
            this.f22712d = d(r23, r19, r26);
            int r28 = k(r23, r27, r20);
            this.f22713e = r28;
            if (r28 != (-1)) goto L60;
            return ParseResult.INVALID_PORT;
        L60:
            if (this.f22712d == null) goto L62;
            r10 = r20;
            goto L64
        L62:
            return ParseResult.INVALID_HOST;
        L58:
            this.f22712d = d(r23, r19, r26);
            this.f22713e = HttpUrl.e(this.f22709a);
            goto L60
        L29:
            r21 = -1;
            goto L30
        L76:
            return ParseResult.MISSING_SCHEME;
        L5:
            if (r23.regionMatches(true, r10, "https:", 0, 6) == false) goto L8;
            this.f22709a = "https";
            r10 = r10 + 6;
            goto L14
        L8:
            if (r23.regionMatches(true, r10, "http:", 0, 5) == false) goto L11;
            this.f22709a = HttpHost.DEFAULT_SCHEME_NAME;
            r10 = r10 + 5;
            goto L14
        L11:
            return ParseResult.UNSUPPORTED_SCHEME;
        }

        public Builder l(String r10) {
            if (r10 == null) goto L6;
            this.f22711c = HttpUrl.b(r10, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        L6:
            throw new NullPointerException("password == null");
        }

        public final void m() {
            List r10 = this.f22714f;
            if (((String) r10.remove(r10.size() - 1)).isEmpty() == true) goto L5;
        L7:
            this.f22714f.add("");
            return;
        L5:
            if (this.f22714f.isEmpty() == true) goto L7;
            List r11 = this.f22714f;
            r11.set(r11.size() - 1, "");
        }

        public Builder n(int r10) {
            if (r10 <= 0) goto L8;
            if (r10 > 65535) goto L8;
            this.f22713e = r10;
            return this;
        L8:
            throw new IllegalArgumentException("unexpected port: " + r10);
        }

        public final void p(String r10, int r11, int r12, boolean r13, boolean r14) {
            String r15 = HttpUrl.a(r10, r11, r12, " \"<>^`{}|/\\?#", r14, false, false, true, null);
            if (h(r15) == false) goto L6;
            return;
        L6:
            if (i(r15) == false) goto L9;
            m();
            return;
        L9:
            List r16 = this.f22714f;
            if (((String) r16.get(r16.size() - 1)).isEmpty() == false) goto L12;
            List r17 = this.f22714f;
            r17.set(r17.size() - 1, r15);
        L13:
            if (r13 == false) goto L16;
            this.f22714f.add("");
            return;
        L16:
            return;
        L12:
            this.f22714f.add(r15);
            goto L13
        }

        public Builder q() {
            int r10 = this.f22714f.size();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            this.f22714f.set(r12, HttpUrl.b((String) this.f22714f.get(r12), "[]", true, true, false, true));
            r12 = r12 + 1;
            goto L3
        L5:
            List r13 = this.f22715g;
            if (r13 == null) goto L13;
            int r14 = r13.size();
        L8:
            if (r11 >= r14) goto L13;
            String r15 = (String) this.f22715g.get(r11);
            if (r15 == null) goto L12;
            this.f22715g.set(r11, HttpUrl.b(r15, "\\^`{|}", true, true, true, true));
        L12:
            r11 = r11 + 1;
        L13:
            String r16 = this.f22716h;
            if (r16 == null) goto L16;
            this.f22716h = HttpUrl.b(r16, " \"#<>\\^`{|}", true, true, false, false);
        L16:
            return this;
        }

        public final void r(String r10) {
            int r11 = this.f22715g.size() - 2;
        L3:
            if (r11 < 0) goto L11;
            if (r10.equals(this.f22715g.get(r11)) == false) goto L10;
            this.f22715g.remove(r11 + 1);
            this.f22715g.remove(r11);
            if (this.f22715g.isEmpty() == false) goto L10;
            this.f22715g = null;
            return;
        L10:
            r11 = r11 - 2;
            goto L3
        }

        public Builder s(String r10) {
            if (r10 == null) goto L9;
            if (this.f22715g != null) goto L6;
            return this;
        L6:
            r(HttpUrl.b(r10, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            return this;
        L9:
            throw new NullPointerException("name == null");
        }

        public final void t(String r11, int r12, int r13) {
            if (r12 != r13) goto L4;
            return;
        L4:
            char r10 = r11.charAt(r12);
            if (r10 != '/') goto L7;
        L10:
            this.f22714f.clear();
            this.f22714f.add("");
            r12 = r12 + 1;
        L11:
            int r14 = r12;
            if (r14 >= r13) goto L20;
            r12 = Util.delimiterOffset(r11, r14, r13, "/\\");
            if (r12 >= r13) goto L16;
            boolean r15 = true;
        L17:
            p(r11, r14, r12, r15, true);
            if (r15 == false) goto L11;
            r12 = r12 + 1;
            goto L11
        L16:
            r15 = false;
            goto L17
        L20:
            return;
        L7:
            if (r10 == '\\') goto L10;
            List r16 = this.f22714f;
            r16.set(r16.size() - 1, "");
            goto L11
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append(this.f22709a);
            r10.append("://");
            if (this.f22710b.isEmpty() == true) goto L5;
        L6:
            r10.append(this.f22710b);
            if (this.f22711c.isEmpty() == true) goto L9;
            r10.append(':');
            r10.append(this.f22711c);
        L9:
            r10.append('@');
        L11:
            if (this.f22712d.indexOf(58) == (-1)) goto L13;
            r10.append('[');
            r10.append(this.f22712d);
            r10.append(']');
        L14:
            int r11 = e();
            if (r11 == HttpUrl.e(this.f22709a)) goto L17;
            r10.append(':');
            r10.append(r11);
        L17:
            HttpUrl.t(r10, this.f22714f);
            if (this.f22715g == null) goto L21;
            r10.append('?');
            HttpUrl.o(r10, this.f22715g);
        L21:
            if (this.f22716h == null) goto L24;
            r10.append('#');
            r10.append(this.f22716h);
        L24:
            return r10.toString();
        L13:
            r10.append(this.f22712d);
            goto L14
        L5:
            if (this.f22711c.isEmpty() == true) goto L11;
            goto L6
        }

        public Builder u(String r10) {
            if (r10 == null) goto L13;
            if (r10.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L7;
            this.f22709a = HttpHost.DEFAULT_SCHEME_NAME;
        L9:
            return this;
        L7:
            if (r10.equalsIgnoreCase("https") == false) goto L11;
            this.f22709a = "https";
            goto L9
        L11:
            throw new IllegalArgumentException("unexpected scheme: " + r10);
        L13:
            throw new NullPointerException("scheme == null");
        }

        public Builder x(String r10) {
            if (r10 == null) goto L6;
            this.f22710b = HttpUrl.b(r10, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        L6:
            throw new NullPointerException("username == null");
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22717a = null;

        static {
            int[] r10 = new int[Builder.ParseResult.values().length];
            f22717a = r10;
            r10[Builder.ParseResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f22717a[Builder.ParseResult.INVALID_HOST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f22717a[Builder.ParseResult.UNSUPPORTED_SCHEME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f22717a[Builder.ParseResult.MISSING_SCHEME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f22717a[Builder.ParseResult.INVALID_PORT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        f22699j = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public HttpUrl(Builder r10) {
        this.f22700a = r10.f22709a;
        this.f22701b = v(r10.f22710b, false);
        this.f22702c = v(r10.f22711c, false);
        this.f22703d = r10.f22712d;
        this.f22704e = r10.e();
        this.f22705f = w(r10.f22714f, false);
        List r11 = r10.f22715g;
        String r12 = null;
        if (r11 == null) goto L5;
        List r13 = w(r11, true);
    L6:
        this.f22706g = r13;
        String r14 = r10.f22716h;
        if (r14 == null) goto L9;
        r12 = v(r14, false);
    L9:
        this.f22707h = r12;
        this.f22708i = r10.toString();
        return;
    L5:
        r13 = null;
        goto L6
    }

    public static List D(String r10) {
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L4:
        if (r12 > r10.length()) goto L15;
        int r13 = r10.indexOf(38, r12);
        if (r13 != (-1)) goto L8;
        r13 = r10.length();
    L8:
        int r14 = r10.indexOf(61, r12);
        if (r14 == (-1)) goto L13;
        if (r14 > r13) goto L13;
        r11.add(r10.substring(r12, r14));
        r11.add(r10.substring(r14 + 1, r13));
    L14:
        r12 = r13 + 1;
    L13:
        r11.add(r10.substring(r12, r13));
        r11.add(null);
        goto L14
    L15:
        return r11;
    }

    public static String a(String r11, int r12, int r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18, Charset r19) {
        int r10 = r12;
    L3:
        if (r10 >= r13) goto L29;
        int r20 = r11.codePointAt(r10);
        if (r20 < 32) goto L26;
        if (r20 == 127) goto L26;
        if (r20 < 128) goto L14;
        if (r18 == true) goto L26;
    L14:
        if (r14.indexOf(r20) != (-1)) goto L26;
        if (r20 != 37) goto L22;
        if (r15 == false) goto L26;
        if (r16 == false) goto L22;
        if (y(r11, r10, r13) == false) goto L26;
    L22:
        if (r20 != 43) goto L25;
        if (r17 == true) goto L26;
    L25:
        r10 = r10 + Character.charCount(r20);
    L26:
        Buffer r110 = new Buffer();
        r110.F(r11, r12, r10);
        d(r110, r11, r10, r13, r14, r15, r16, r17, r18, r19);
        return r110.readUtf8();
    L29:
        return r11.substring(r12, r13);
    }

    public static String b(String r10, String r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        return a(r10, 0, r10.length(), r11, r12, r13, r14, r15, null);
    }

    public static String c(String r10, String r11, boolean r12, boolean r13, boolean r14, boolean r15, Charset r16) {
        return a(r10, 0, r10.length(), r11, r12, r13, r14, r15, r16);
    }

    public static void d(Buffer r10, String r11, int r12, int r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18, Charset r19) {
        Buffer r20 = null;
    L3:
        if (r12 >= r13) goto L50;
        int r21 = r11.codePointAt(r12);
        if (r15 == false) goto L16;
        if (r21 == 9) goto L49;
        if (r21 == 10) goto L49;
        if (r21 == 12) goto L49;
        if (r21 != 13) goto L16;
    L49:
        r12 = r12 + Character.charCount(r21);
    L16:
        if (r21 != 43) goto L23;
        if (r17 == false) goto L23;
        if (r15 == false) goto L20;
        String r22 = "+";
    L21:
        r10.E(r22);
        goto L49
    L20:
        r22 = "%2B";
    L23:
        if (r21 >= 32) goto L25;
    L38:
        if (r20 != null) goto L40;
        r20 = new Buffer();
    L40:
        if (r19 != null) goto L42;
    L45:
        r20.G(r21);
    L47:
        if (r20.exhausted() == true) goto L49;
        byte r23 = r20.readByte();
        int r24 = r23 & UnsignedBytes.MAX_VALUE;
        r10.t(37);
        char[] r25 = f22699j;
        r10.t(r25[(r24 >> 4) & 15]);
        r10.t(r25[r23 & Ascii.SI]);
        goto L47
    L42:
        if (r19.equals(Util.UTF_8) == true) goto L45;
        r20.C(r11, r12, Character.charCount(r21) + r12, r19);
        goto L47
    L25:
        if (r21 == 127) goto L38;
        if (r21 < 128) goto L30;
        if (r18 == true) goto L38;
    L30:
        if (r14.indexOf(r21) != (-1)) goto L38;
        if (r21 != 37) goto L37;
        if (r15 == false) goto L38;
        if (r16 == false) goto L37;
        if (y(r11, r12, r13) == false) goto L38;
    L37:
        r10.G(r21);
        goto L49
    }

    public static int e(String r10) {
        if (r10.equals(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L7;
        return 80;
    L7:
        if (r10.equals("https") == false) goto L10;
        return 443;
    L10:
        return -1;
    }

    public static HttpUrl l(String r10) {
        Builder r11 = new Builder();
        Builder.ParseResult r12 = r11.j(null, r10);
        int r13 = a.f22717a[r12.ordinal()];
        if (r13 == 1) goto L11;
        if (r13 == 2) goto L9;
        throw new MalformedURLException("Invalid URL: " + r12 + " for " + r10);
    L9:
        throw new UnknownHostException("Invalid host: " + r10);
    L11:
        return r11.c();
    }

    public static void o(StringBuilder r10, List r11) {
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        String r14 = (String) r11.get(r13);
        String r15 = (String) r11.get(r13 + 1);
        if (r13 <= 0) goto L7;
        r10.append('&');
    L7:
        r10.append(r14);
        if (r15 == null) goto L10;
        r10.append('=');
        r10.append(r15);
    L10:
        r13 = r13 + 2;
        goto L3
    }

    public static HttpUrl r(String r10) {
        Builder r11 = new Builder();
        if (r11.j(null, r10) == Builder.ParseResult.SUCCESS) goto L5;
        return null;
    L5:
        return r11.c();
    }

    public static void t(StringBuilder r10, List r11) {
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.append('/');
        r10.append((String) r11.get(r13));
        r13 = r13 + 1;
        goto L3
    }

    public static String u(String r10, int r11, int r12, boolean r13) {
        int r14 = r11;
    L3:
        if (r14 >= r12) goto L14;
        char r15 = r10.charAt(r14);
        if (r15 == '%') goto L11;
        if (r15 != '+') goto L10;
        if (r13 == true) goto L11;
    L10:
        r14 = r14 + 1;
    L11:
        Buffer r16 = new Buffer();
        r16.F(r10, r11, r14);
        x(r16, r10, r14, r12, r13);
        return r16.readUtf8();
    L14:
        return r10.substring(r11, r12);
    }

    public static String v(String r10, boolean r11) {
        return u(r10, 0, r10.length(), r11);
    }

    public static void x(Buffer r10, String r11, int r12, int r13, boolean r14) {
    L2:
        if (r12 >= r13) goto L17;
        int r15 = r11.codePointAt(r12);
        if (r15 != 37) goto L12;
        int r16 = r12 + 2;
        if (r16 >= r13) goto L12;
        int r17 = Util.decodeHexDigit(r11.charAt(r12 + 1));
        int r18 = Util.decodeHexDigit(r11.charAt(r16));
        if (r17 == (-1)) goto L15;
        if (r18 == (-1)) goto L15;
        r10.t((r17 << 4) + r18);
        r12 = r16;
    L16:
        r12 = r12 + Character.charCount(r15);
    L15:
        r10.G(r15);
    L12:
        if (r15 != 43) goto L15;
        if (r14 == false) goto L15;
        r10.t(32);
        goto L16
    }

    public static boolean y(String r10, int r11, int r12) {
        int r13 = r11 + 2;
        if (r13 < r12) goto L5;
    L11:
        return false;
    L5:
        if (r10.charAt(r11) != '%') goto L11;
        if (Util.decodeHexDigit(r10.charAt(r11 + 1)) == (-1)) goto L11;
        if (Util.decodeHexDigit(r10.charAt(r13)) == (-1)) goto L11;
        return true;
    }

    public String A() {
        if (this.f22706g != null) goto L6;
        return null;
    L6:
        StringBuilder r10 = new StringBuilder();
        o(r10, this.f22706g);
        return r10.toString();
    }

    public String B(String r10) {
        List r11 = this.f22706g;
        if (r11 != null) goto L5;
        return null;
    L5:
        int r12 = r11.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        if (r10.equals(this.f22706g.get(r13)) == true) goto L10;
        r13 = r13 + 2;
        goto L6
    L10:
        return (String) this.f22706g.get(r13 + 1);
    L12:
        return null;
    }

    public Set C() {
        if (this.f22706g == null) goto L5;
        LinkedHashSet r10 = new LinkedHashSet();
        int r11 = this.f22706g.size();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L10;
        r10.add(this.f22706g.get(r12));
        r12 = r12 + 2;
        goto L7
    L10:
        return Collections.unmodifiableSet(r10);
    L5:
        return Collections.emptySet();
    }

    public String E() {
        return q("/...").x("").l("").c().toString();
    }

    public HttpUrl F(String r10) {
        Builder r11 = q(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.c();
    }

    public String G() {
        return this.f22700a;
    }

    public URI H() {
        String r10 = p().q().toString();
        return new URI(r10);
    L5:
        e = move-exception;
        return URI.create(r10.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L9:
        throw new RuntimeException(e);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof HttpUrl) == true) goto L5;
    L7:
        return false;
    L5:
        if (((HttpUrl) r10).f22708i.equals(this.f22708i) == false) goto L7;
        return true;
    }

    public String f() {
        if (this.f22707h != null) goto L6;
        return null;
    L6:
        int r10 = this.f22708i.indexOf(35) + 1;
        return this.f22708i.substring(r10);
    }

    public String g() {
        if (this.f22702c.isEmpty() == false) goto L6;
        return "";
    L6:
        int r10 = this.f22708i.indexOf(58, this.f22700a.length() + 3) + 1;
        int r11 = this.f22708i.indexOf(64);
        return this.f22708i.substring(r10, r11);
    }

    public String h() {
        int r10 = this.f22708i.indexOf(47, this.f22700a.length() + 3);
        String r11 = this.f22708i;
        int r12 = Util.delimiterOffset(r11, r10, r11.length(), "?#");
        return this.f22708i.substring(r10, r12);
    }

    public int hashCode() {
        return this.f22708i.hashCode();
    }

    public List i() {
        int r10 = this.f22708i.indexOf(47, this.f22700a.length() + 3);
        String r11 = this.f22708i;
        int r12 = Util.delimiterOffset(r11, r10, r11.length(), "?#");
        ArrayList r13 = new ArrayList();
    L3:
        if (r10 >= r12) goto L5;
        int r14 = r10 + 1;
        int r15 = Util.delimiterOffset(this.f22708i, r14, r12, '/');
        r13.add(this.f22708i.substring(r14, r15));
        r10 = r15;
        goto L3
    L5:
        return r13;
    }

    public String j() {
        if (this.f22706g != null) goto L6;
        return null;
    L6:
        int r10 = this.f22708i.indexOf(63) + 1;
        String r11 = this.f22708i;
        int r12 = Util.delimiterOffset(r11, r10, r11.length(), '#');
        return this.f22708i.substring(r10, r12);
    }

    public String k() {
        if (this.f22701b.isEmpty() == false) goto L6;
        return "";
    L6:
        int r10 = this.f22700a.length() + 3;
        String r11 = this.f22708i;
        int r12 = Util.delimiterOffset(r11, r10, r11.length(), ":@");
        return this.f22708i.substring(r10, r12);
    }

    public String m() {
        return this.f22703d;
    }

    public boolean n() {
        return this.f22700a.equals("https");
    }

    public Builder p() {
        Builder r10 = new Builder();
        r10.f22709a = this.f22700a;
        r10.f22710b = k();
        r10.f22711c = g();
        r10.f22712d = this.f22703d;
        if (this.f22704e == e(this.f22700a)) goto L5;
        int r11 = this.f22704e;
    L6:
        r10.f22713e = r11;
        r10.f22714f.clear();
        r10.f22714f.addAll(i());
        r10.f(j());
        r10.f22716h = f();
        return r10;
    L5:
        r11 = -1;
        goto L6
    }

    public Builder q(String r10) {
        Builder r11 = new Builder();
        if (r11.j(this, r10) == Builder.ParseResult.SUCCESS) goto L7;
        return null;
    L7:
        return r11;
    }

    public List s() {
        return this.f22705f;
    }

    public String toString() {
        return this.f22708i;
    }

    public final List w(List r10, boolean r11) {
        int r12 = r10.size();
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L10;
        String r15 = (String) r10.get(r14);
        if (r15 == null) goto L7;
        String r16 = v(r15, r11);
    L8:
        r13.add(r16);
        r14 = r14 + 1;
        goto L3
    L7:
        r16 = null;
        goto L8
    L10:
        return Collections.unmodifiableList(r13);
    }

    public int z() {
        return this.f22704e;
    }
}
