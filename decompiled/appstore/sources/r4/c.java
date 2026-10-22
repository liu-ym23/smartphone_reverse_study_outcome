package r4;

import com.bytedance.frameworks.baselib.network.http.impl.SerializableHttpCookie;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.toolbox.ServerElements;
import com.tmall.wireless.tangram.expression.TangramExprSupport;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.protocol.HttpDateGenerator;

/* JADX INFO: loaded from: classes.dex */
public class c implements Cloneable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set f23734m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Pattern f23735n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Pattern f23736o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ThreadLocal f23737p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f23738q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f23742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f23743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f23744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f23745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f23747i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f23748j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f23749k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f23750l;

    public static class a extends ThreadLocal {
        public a() {
        }

        public DateFormat a() {
            SimpleDateFormat r10 = new SimpleDateFormat(HttpDateGenerator.PATTERN_RFC1123, Locale.US);
            r10.setTimeZone(TimeZone.getTimeZone("UTC"));
            return r10;
        }

        @Override // java.lang.ThreadLocal
        public /* bridge */ /* synthetic */ Object initialValue() {
            return a();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f23752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f23753c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f23754d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f23755e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f23756f;

        public b(String r10) {
            this.f23753c = 0;
            this.f23754d = false;
            this.f23755e = false;
            this.f23756f = false;
            this.f23751a = r10;
            this.f23752b = r10.toLowerCase(Locale.US);
        }

        public final int a(String r10) {
            int r11 = this.f23753c;
        L4:
            if (r11 >= this.f23751a.length()) goto L10;
            if (r10.indexOf(this.f23751a.charAt(r11)) != (-1)) goto L7;
            r11 = r11 + 1;
            goto L4
        L7:
            return r11;
        L10:
            return this.f23751a.length();
        }

        public List b() {
            ArrayList r10 = new ArrayList(2);
            if (this.f23752b.startsWith("set-cookie2:") == false) goto L6;
            this.f23753c += 12;
            this.f23756f = true;
            int r11 = 0;
        L9:
            String r12 = c(false);
            if (r12 == null) goto L12;
            if (e() == false) goto L55;
            if (r11 == 0) goto L21;
            String r13 = ";";
        L22:
            c r14 = new c(r12, d(r13));
            c.a(r14, r11 ^ 1);
            r10.add(r14);
        L23:
            g();
            if (this.f23753c == this.f23751a.length()) goto L30;
            if (this.f23751a.charAt(this.f23753c) == ',') goto L28;
            if (this.f23751a.charAt(this.f23753c) != ';') goto L38;
            this.f23753c++;
        L38:
            String r15 = c(true);
            if (r15 == null) goto L23;
            if (r11 == 0) goto L43;
        L48:
            String r16 = ";";
        L50:
            if (e() == false) goto L52;
            String r17 = d(r16);
        L53:
            f(r14, r15, r17);
            goto L23
        L52:
            r17 = null;
            goto L53
        L43:
            if ("expires".equals(r15) == true) goto L48;
            if ("port".equals(r15) == true) goto L48;
            r16 = ";,";
            goto L50
        L28:
            this.f23753c++;
        L30:
            if (this.f23754d == true) goto L31;
            if (this.f23755e == false) goto L9;
            c.a(r14, 1);
            goto L9
        L31:
            c.a(r14, 0);
            goto L9
        L21:
            r13 = ",;";
            goto L22
        L55:
            throw new IllegalArgumentException("Expected '=' after " + r12 + " in " + this.f23751a);
        L12:
            if (r10.isEmpty() == true) goto L15;
            return r10;
        L15:
            throw new IllegalArgumentException("No cookies in " + this.f23751a);
        L6:
            if (this.f23752b.startsWith("set-cookie:") == false) goto L8;
            this.f23753c += 11;
        L8:
            r11 = 1;
            goto L9
        }

        public final String c(boolean r10) {
            g();
            int r11 = a(",;= \t");
            if (r10 == false) goto L5;
            String r12 = this.f23752b;
        L6:
            int r13 = this.f23753c;
            if (r13 >= r11) goto L9;
            String r14 = r12.substring(r13, r11);
        L10:
            this.f23753c = r11;
            return r14;
        L9:
            r14 = null;
            goto L10
        L5:
            r12 = this.f23751a;
            goto L6
        }

        public final String d(String r10) {
            g();
            int r11 = a(r10);
            String r12 = this.f23751a.substring(this.f23753c, r11);
            this.f23753c = r11;
            return r12;
        }

        public final boolean e() {
            g();
            if (this.f23753c < this.f23751a.length()) goto L5;
            return false;
        L5:
            if (this.f23751a.charAt(this.f23753c) != '=') goto L10;
            this.f23753c++;
            return true;
        L10:
            return false;
        }

        public final void f(c r10, String r11, String r12) {
            if (r11.equals(ServerElements.COMMENT) == false) goto L8;
            if (c.b(r10) != null) goto L8;
            c.d(r10, r12);
            return;
        L8:
            if (r11.equals("commenturl") == false) goto L13;
            if (c.e(r10) != null) goto L13;
            c.f(r10, r12);
            return;
        L13:
            if (r11.equals("discard") == false) goto L16;
            c.g(r10, true);
            return;
        L16:
            if (r11.equals("domain") == false) goto L21;
            if (c.h(r10) != null) goto L21;
            c.i(r10, r12);
            return;
        L21:
            if (r11.equals("expires") == false) goto L29;
            this.f23754d = true;
            if (c.j(r10) != (-1)) goto L67;
            Date r13 = c.M(r12);
            if (r13 == null) goto L27;
            c.l(r10, r13);
            return;
        L27:
            c.k(r10, 0);
            return;
        L67:
            return;
        L29:
            if (r11.equals("max-age") == false) goto L37;
            if (c.j(r10) != (-1)) goto L37;
            long r14 = Long.parseLong(r12);     // Catch: NumberFormatException -> L34
            this.f23755e = true;     // Catch: NumberFormatException -> L34
            c.k(r10, r14);     // Catch: NumberFormatException -> L34
            return;
        L35:
            throw new IllegalArgumentException("Invalid max-age: " + r12);
        L37:
            if (r11.equals("path") == false) goto L42;
            if (c.m(r10) != null) goto L42;
            c.n(r10, r12);
            return;
        L42:
            if (r11.equals("port") == false) goto L50;
            if (c.o(r10) != null) goto L50;
            if (r12 != null) goto L48;
            r12 = "";
        L48:
            c.p(r10, r12);
            return;
        L50:
            if (r11.equals("secure") == false) goto L53;
            c.q(r10, true);
            return;
        L53:
            if (r11.equals("httponly") == false) goto L56;
            c.c(r10, true);
            return;
        L56:
            if (r11.equals("version") == true) goto L58;
            return;
        L58:
            if (this.f23756f == true) goto L75;
            c.a(r10, Integer.parseInt(r12));
            return;
        }

        public final void g() {
        L3:
            if (this.f23753c >= this.f23751a.length()) goto L8;
            if (" \t".indexOf(this.f23751a.charAt(this.f23753c)) == (-1)) goto L11;
            this.f23753c++;
            goto L3
        L11:
            return;
        }
    }

    static {
        HashSet r10 = new HashSet();
        f23734m = r10;
        r10.add(ServerElements.COMMENT);
        r10.add("commenturl");
        r10.add("discard");
        r10.add("domain");
        r10.add("expires");
        r10.add("httponly");
        r10.add("max-age");
        r10.add("path");
        r10.add("port");
        r10.add("secure");
        r10.add("version");
        f23735n = null;
        f23736o = null;
        f23735n = Pattern.compile("(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])", 2);     // Catch: PatternSyntaxException -> L6
        f23736o = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}", 2);     // Catch: PatternSyntaxException -> L6
    L4:
        f23737p = new a();
        f23738q = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    public c(String r10, String r11) {
        this.f23743e = -1;
        this.f23750l = 1;
        String r12 = r10.trim();
        if (J(r12) == false) goto L7;
        this.f23744f = r12;
        this.f23749k = r11;
        return;
    L7:
        throw new IllegalArgumentException("Invalid name: " + r10);
    }

    public static boolean H(String r10, int r11) {
        int r12 = r10.indexOf(46, r11 + 1);
        if (r12 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (r12 >= (r10.length() - 1)) goto L7;
        return true;
    }

    public static boolean I(String r10) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L3:
        if (f23735n.matcher(r10).matches() == false) goto L5;
        return true;
    L5:
        if (f23736o.matcher(r10).matches() == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static String K(String r10) {
        if (r10 != null) goto L6;
        return LibrarianImpl.Constants.SEPARATOR;
    L6:
        if (r10.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L9;
        return r10;
    L9:
        return r10 + LibrarianImpl.Constants.SEPARATOR;
    }

    public static List L(String r10) {
        return new b(r10).b();
    }

    public static Date M(String r10) {
        return ((DateFormat) f23737p.get()).parse(r10);
    L4:
        String[] r11 = f23738q;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        String r14 = r11[r13];
        return new SimpleDateFormat(r14, Locale.US).parse(r10);
    L9:
        r13 = r13 + 1;
        goto L5
    L10:
        return null;
    }

    public static boolean N(c r10, URI r11) {
        return K(r11.getPath()).startsWith(K(r10.B()));
    }

    public static boolean O(c r10, URI r11) {
        if (r10.C() != null) goto L7;
        return true;
    L7:
        return Arrays.asList(r10.C().split(",")).contains(Integer.toString(SerializableHttpCookie.getEffectivePort(r11.getScheme(), r11.getPort())));
    }

    public static boolean P(c r10, URI r11) {
        if (r10.D() == true) goto L5;
    L8:
        return true;
    L5:
        if ("https".equalsIgnoreCase(r11.getScheme()) == true) goto L8;
        return false;
    }

    public static /* synthetic */ int a(c r10, int r11) {
        r10.f23750l = r11;
        return r11;
    }

    public static /* synthetic */ String b(c r10) {
        return r10.f23739a;
    }

    public static /* synthetic */ boolean c(c r10, boolean r11) {
        r10.f23748j = r11;
        return r11;
    }

    public static /* synthetic */ String d(c r10, String r11) {
        r10.f23739a = r11;
        return r11;
    }

    public static /* synthetic */ String e(c r10) {
        return r10.f23740b;
    }

    public static /* synthetic */ String f(c r10, String r11) {
        r10.f23740b = r11;
        return r11;
    }

    public static /* synthetic */ boolean g(c r10, boolean r11) {
        r10.f23741c = r11;
        return r11;
    }

    public static /* synthetic */ String h(c r10) {
        return r10.f23742d;
    }

    public static /* synthetic */ String i(c r10, String r11) {
        r10.f23742d = r11;
        return r11;
    }

    public static /* synthetic */ long j(c r10) {
        return r10.f23743e;
    }

    public static /* synthetic */ long k(c r10, long r11) {
        r10.f23743e = r11;
        return r11;
    }

    public static /* synthetic */ void l(c r10, Date r11) {
        r10.U(r11);
    }

    public static /* synthetic */ String m(c r10) {
        return r10.f23745g;
    }

    public static /* synthetic */ String n(c r10, String r11) {
        r10.f23745g = r11;
        return r11;
    }

    public static /* synthetic */ String o(c r10) {
        return r10.f23746h;
    }

    public static /* synthetic */ String p(c r10, String r11) {
        r10.f23746h = r11;
        return r11;
    }

    public static /* synthetic */ boolean q(c r10, boolean r11) {
        r10.f23747i = r11;
        return r11;
    }

    public static boolean s(String r10, String r11) {
        if (r10 == null) goto L38;
        if (r11 == null) goto L42;
        Locale r12 = Locale.US;
        String r13 = r11.toLowerCase(r12);
        String r14 = r10.toLowerCase(r12);
        if (r13.equals(r14) == false) goto L14;
        if (H(r13, 0) == false) goto L11;
    L12:
        return true;
    L11:
        if (I(r13) == true) goto L12;
    L14:
        if (H(r13, 0) == true) goto L18;
        return r14.equals(".local");
    L18:
        if (r14.length() != (r13.length() + 1)) goto L27;
        if (r14.startsWith(LibrarianImpl.Constants.DOT) == false) goto L27;
        if (r14.endsWith(r13) == false) goto L27;
        if (H(r14, 1) == false) goto L27;
        return true;
    L27:
        if (r13.length() > r14.length()) goto L29;
        return false;
    L29:
        if (r13.endsWith(r14) == true) goto L31;
        return false;
    L31:
        if (r14.startsWith(LibrarianImpl.Constants.DOT) == false) goto L35;
        if (H(r14, 1) == false) goto L35;
    L37:
        return true;
    L35:
        if (r14.equals(".local") == true) goto L37;
        return false;
    L42:
        return false;
    L38:
        return false;
    }

    public static boolean t(Object r10, Object r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r10.equals(r11);
    }

    public String A() {
        return this.f23744f;
    }

    public String B() {
        return this.f23745g;
    }

    public String C() {
        return this.f23746h;
    }

    public boolean D() {
        return this.f23747i;
    }

    public String E() {
        return this.f23749k;
    }

    public int F() {
        return this.f23750l;
    }

    public boolean G() {
        long r10 = this.f23743e;
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        if (r10 > 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean J(String r10) {
        if (r10.length() != 0) goto L5;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L29;
        int r12 = 0;
    L13:
        if (r12 >= r10.length()) goto L29;
        char r13 = r10.charAt(r12);
        if (r13 < 0) goto L38;
        if (r13 >= 127) goto L39;
        if (r13 == ';') goto L40;
        if (r13 == ',') goto L41;
        if (Character.isWhitespace(r13) == false) goto L27;
        if (r13 == ' ') goto L27;
        return false;
    L27:
        r12 = r12 + 1;
        goto L13
    L41:
        return false;
    L40:
        return false;
    L39:
        return false;
    L38:
        return false;
    L29:
        return r11;
    L5:
        if (r10.startsWith(TangramExprSupport.VAR_START) == true) goto L9;
        if (f23734m.contains(r10.toLowerCase(Locale.US)) == true) goto L9;
        r11 = true;
        goto L10
    }

    public void Q(String r10) {
        this.f23739a = r10;
    }

    public void R(String r10) {
        this.f23740b = r10;
    }

    public void S(boolean r10) {
        this.f23741c = r10;
    }

    public void T(String r10) {
        if (r10 != null) goto L4;
        String r11 = null;
    L5:
        this.f23742d = r11;
        return;
    L4:
        r11 = r10.toLowerCase(Locale.US);
        goto L5
    }

    public final void U(Date r10) {
        this.f23743e = (r10.getTime() - System.currentTimeMillis()) / 1000;
    }

    public void V(boolean r10) {
        this.f23748j = r10;
    }

    public void W(long r10) {
        this.f23743e = r10;
    }

    public void X(String r10) {
        this.f23745g = r10;
    }

    public void Y(String r10) {
        this.f23746h = r10;
    }

    public void Z(boolean r10) {
        this.f23747i = r10;
    }

    public void a0(int r10) {
        if (r10 != 0) goto L4;
    L8:
        this.f23750l = r10;
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("Bad version: " + r10);
    }

    public Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == false) goto L21;
        c r11 = (c) r10;
        if (this.f23744f.equalsIgnoreCase(r11.A()) == false) goto L20;
        String r12 = this.f23742d;
        if (r12 == null) goto L15;
        if (r12.equalsIgnoreCase(r11.f23742d) == false) goto L20;
    L17:
        if (t(this.f23745g, r11.f23745g) == false) goto L20;
        return true;
    L15:
        if (r11.f23742d == null) goto L17;
    L20:
        return false;
    L21:
        return false;
    }

    public int hashCode() {
        String r10 = this.f23744f;
        Locale r11 = Locale.US;
        int r12 = r10.toLowerCase(r11).hashCode();
        String r13 = this.f23742d;
        int r14 = 0;
        if (r13 != null) goto L5;
        int r15 = 0;
    L6:
        int r16 = r12 + r15;
        String r17 = this.f23745g;
        if (r17 == null) goto L11;
        r14 = r17.hashCode();
    L11:
        return r16 + r14;
    L5:
        r15 = r13.toLowerCase(r11).hashCode();
        goto L6
    }

    public final void r(StringBuilder r10, String r11, String r12) {
        if (r12 == null) goto L6;
        if (r10 == null) goto L7;
        r10.append(";$");
        r10.append(r11);
        r10.append("=\"");
        r10.append(r12);
        r10.append("\"");
        return;
    L7:
        return;
    }

    public String toString() {
        if (this.f23750l == 0) goto L5;
        StringBuilder r10 = new StringBuilder();
        r10.append(this.f23744f);
        r10.append("=");
        r10.append("\"");
        r10.append(this.f23749k);
        r10.append("\"");
        r(r10, "Path", this.f23745g);
        r(r10, "Domain", this.f23742d);
        r(r10, "Port", this.f23746h);
        return r10.toString();
    L5:
        return this.f23744f + "=" + this.f23749k;
    }

    public String u() {
        return this.f23739a;
    }

    public String v() {
        return this.f23740b;
    }

    public boolean w() {
        return this.f23741c;
    }

    public String x() {
        return this.f23742d;
    }

    public boolean y() {
        return this.f23748j;
    }

    public long z() {
        return this.f23743e;
    }
}
