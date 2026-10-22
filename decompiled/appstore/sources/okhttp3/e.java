package okhttp3;

import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f22923j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f22924k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f22925l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f22926m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f22932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f22933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f22934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f22935i;

    static {
        f22923j = Pattern.compile("(\\d{2,4})[^\\d]*");
        f22924k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f22925l = Pattern.compile("(\\d{1,2})[^\\d]*");
        f22926m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    public e(String r10, String r11, long r12, String r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        this.f22927a = r10;
        this.f22928b = r11;
        this.f22929c = r12;
        this.f22930d = r13;
        this.f22931e = r14;
        this.f22932f = r15;
        this.f22933g = r16;
        this.f22935i = r17;
        this.f22934h = r18;
    }

    public static int a(String r10, int r11, int r12, boolean r13) {
    L2:
        if (r11 >= r12) goto L30;
        char r14 = r10.charAt(r11);
        if (r14 >= ' ') goto L8;
        if (r14 == '\t') goto L8;
    L25:
        boolean r15 = true;
    L27:
        if (r15 == (!r13)) goto L28;
        r11 = r11 + 1;
        goto L2
    L28:
        return r11;
    L8:
        if (r14 >= 127) goto L25;
        if (r14 < '0') goto L14;
        if (r14 <= '9') goto L25;
    L14:
        if (r14 < 'a') goto L18;
        if (r14 <= 'z') goto L25;
    L18:
        if (r14 < 'A') goto L22;
        if (r14 <= 'Z') goto L25;
    L22:
        if (r14 == ':') goto L25;
        r15 = false;
        goto L27
    L30:
        return r12;
    }

    public static boolean b(String r10, String r11) {
        if (r10.equals(r11) == false) goto L6;
        return true;
    L6:
        if (r10.endsWith(r11) == true) goto L8;
        return false;
    L8:
        if (r10.charAt((r10.length() - r11.length()) - 1) == '.') goto L10;
        return false;
    L10:
        if (Util.verifyAsIpAddress(r10) == true) goto L15;
        return true;
    L15:
        return false;
    }

    public static e d(long r23, HttpUrl r25, String r26) {
        int r10 = r26.length();
        char r11 = ';';
        int r12 = Util.delimiterOffset(r26, 0, r10, ';');
        char r13 = '=';
        int r14 = Util.delimiterOffset(r26, 0, r12, '=');
        if (r14 != r12) goto L5;
        return null;
    L5:
        String r15 = Util.trimSubstring(r26, 0, r14);
        if (r15.isEmpty() == true) goto L90;
        if (Util.indexOfControlOrNonAscii(r15) != (-1)) goto L90;
        String r16 = Util.trimSubstring(r26, r14 + 1, r12);
        if (Util.indexOfControlOrNonAscii(r16) == (-1)) goto L13;
        return null;
    L13:
        int r17 = r12 + 1;
        boolean r18 = false;
        boolean r19 = false;
        boolean r110 = false;
        String r111 = null;
        boolean r112 = true;
        long r113 = -1;
        long r21 = 253402300799999L;
        String r20 = null;
    L14:
        if (r17 >= r10) goto L40;
        int r22 = Util.delimiterOffset(r26, r17, r10, r11);
        int r24 = Util.delimiterOffset(r26, r17, r22, r13);
        String r27 = Util.trimSubstring(r26, r17, r24);
        if (r24 >= r22) goto L18;
        String r28 = Util.trimSubstring(r26, r24 + 1, r22);
    L20:
        if (r27.equalsIgnoreCase("expires") == false) goto L24;
        r21 = h(r28, 0, r28.length());     // Catch: Throwable -> L80
    L22:
        r110 = true;
    L39:
        r17 = r22 + 1;
        r11 = ';';
        r13 = '=';
        goto L14
    L24:
        if (r27.equalsIgnoreCase("max-age") == false) goto L27;
        r113 = i(r28);
        goto L22
    L27:
        if (r27.equalsIgnoreCase("domain") == false) goto L31;
        r111 = g(r28);     // Catch: Throwable -> L80
        r112 = false;
        goto L39
    L31:
        if (r27.equalsIgnoreCase("path") == false) goto L34;
        r20 = r28;
        goto L39
    L34:
        if (r27.equalsIgnoreCase("secure") == false) goto L37;
        r18 = true;
        goto L39
    L37:
        if (r27.equalsIgnoreCase("httponly") == false) goto L39;
        r19 = true;
        goto L39
    L18:
        r28 = "";
        goto L20
    L40:
        long r29 = Long.MIN_VALUE;
        if (r113 != Long.MIN_VALUE) goto L44;
    L42:
        long r114 = r29;
    L55:
        String r30 = r25.m();
        if (r111 != null) goto L59;
        String r115 = r30;
        e r31 = null;
    L64:
        if (r30.length() != r115.length()) goto L66;
    L68:
        String r32 = LibrarianImpl.Constants.SEPARATOR;
        if (r20 != null) goto L71;
    L74:
        String r33 = r25.h();
        int r34 = r33.lastIndexOf(47);
        if (r34 == 0) goto L77;
        r32 = r33.substring(0, r34);
    L77:
        String r116 = r32;
    L79:
        return new e(r15, r16, r114, r115, r116, r18, r19, r112, r110);
    L71:
        if (r20.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L74;
        r116 = r20;
        goto L79
    L66:
        if (PublicSuffixDatabase.get().getEffectiveTldPlusOne(r115) != null) goto L68;
        return r31;
    L59:
        if (b(r30, r111) == true) goto L62;
        return null;
    L62:
        r31 = null;
        r115 = r111;
        goto L64
    L44:
        if (r113 != (-1)) goto L46;
        r114 = r21;
        goto L55
    L46:
        if (r113 > 9223372036854775L) goto L48;
        long r117 = r113 * 1000;
    L49:
        r29 = r23 + r117;
        if (r29 >= r23) goto L52;
    L53:
        r114 = 253402300799999L;
        goto L55
    L52:
        if (r29 <= HttpDate.MAX_DATE) goto L42;
    L48:
        r117 = Long.MAX_VALUE;
    L90:
        return null;
    }

    public static e e(HttpUrl r10, String r11) {
        return d(System.currentTimeMillis(), r10, r11);
    }

    public static List f(HttpUrl r10, Headers r11) {
        List r12 = r11.k("Set-Cookie");
        int r13 = r12.size();
        ArrayList r14 = null;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L11;
        e r16 = e(r10, (String) r12.get(r15));
        if (r16 == null) goto L10;
        if (r14 != null) goto L9;
        r14 = new ArrayList();
    L9:
        r14.add(r16);
    L10:
        r15 = r15 + 1;
        goto L3
    L11:
        if (r14 == null) goto L14;
        return Collections.unmodifiableList(r14);
    L14:
        return Collections.emptyList();
    }

    public static String g(String r10) {
        if (r10.endsWith(LibrarianImpl.Constants.DOT) == true) goto L13;
        if (r10.startsWith(LibrarianImpl.Constants.DOT) == false) goto L7;
        r10 = r10.substring(1);
    L7:
        String r11 = Util.canonicalizeHost(r10);
        if (r11 == null) goto L11;
        return r11;
    L11:
        throw new IllegalArgumentException();
    L13:
        throw new IllegalArgumentException();
    }

    public static long h(String r12, int r13, int r14) {
        int r15 = a(r12, r13, r14, false);
        Matcher r10 = f22926m.matcher(r12);
        int r11 = -1;
        int r16 = -1;
        int r17 = -1;
        int r18 = -1;
        int r19 = -1;
        int r20 = -1;
    L4:
        if (r15 >= r14) goto L24;
        int r110 = a(r12, r15 + 1, r14, true);
        r10.region(r15, r110);
        if (r16 == (-1)) goto L8;
    L10:
        if (r17 == (-1)) goto L12;
    L14:
        if (r18 != (-1)) goto L18;
        Pattern r111 = f22924k;
        if (r10.usePattern(r111).matches() == false) goto L18;
        r18 = r111.pattern().indexOf(r10.group(1).toLowerCase(Locale.US)) / 4;
    L22:
        r15 = a(r12, r110 + 1, r14, false);
    L18:
        if (r11 != (-1)) goto L22;
        if (r10.usePattern(f22923j).matches() == false) goto L22;
        r11 = Integer.parseInt(r10.group(1));
        goto L22
    L12:
        if (r10.usePattern(f22925l).matches() == false) goto L14;
        r17 = Integer.parseInt(r10.group(1));
        goto L22
    L8:
        if (r10.usePattern(f22926m).matches() == false) goto L10;
        r16 = Integer.parseInt(r10.group(1));
        r19 = Integer.parseInt(r10.group(2));
        r20 = Integer.parseInt(r10.group(3));
        goto L22
    L24:
        if (r11 >= 70) goto L26;
    L28:
        if (r11 < 0) goto L33;
        if (r11 > 69) goto L33;
        r11 = r11 + 2000;
    L33:
        if (r11 < 1601) goto L59;
        if (r18 == (-1)) goto L57;
        if (r17 < 1) goto L55;
        if (r17 > 31) goto L55;
        if (r16 < 0) goto L53;
        if (r16 > 23) goto L53;
        if (r19 < 0) goto L51;
        if (r19 > 59) goto L51;
        if (r20 < 0) goto L49;
        if (r20 > 59) goto L49;
        GregorianCalendar r112 = new GregorianCalendar(Util.UTC);
        r112.setLenient(false);
        r112.set(1, r11);
        r112.set(2, r18 - 1);
        r112.set(5, r17);
        r112.set(11, r16);
        r112.set(12, r19);
        r112.set(13, r20);
        r112.set(14, 0);
        return r112.getTimeInMillis();
    L49:
        throw new IllegalArgumentException();
    L51:
        throw new IllegalArgumentException();
    L53:
        throw new IllegalArgumentException();
    L55:
        throw new IllegalArgumentException();
    L57:
        throw new IllegalArgumentException();
    L59:
        throw new IllegalArgumentException();
    L26:
        if (r11 > 99) goto L28;
        r11 = r11 + 1900;
        goto L28
    }

    public static long i(String r10) {
        long r11 = Long.parseLong(r10);     // Catch: NumberFormatException -> L9
        if (r11 > 0) goto L8;
        return Long.MIN_VALUE;
    L8:
        return r11;
    L9:
        e = move-exception;
        if (r10.matches("-?\\d+") == true) goto L13;
        throw e;
    L13:
        if (r10.startsWith("-") == true) goto L21;
        return Long.MAX_VALUE;
    L21:
        return Long.MIN_VALUE;
    }

    public String c() {
        return this.f22927a;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof e) == true) goto L5;
        return false;
    L5:
        e r11 = (e) r10;
        if (r11.f22927a.equals(this.f22927a) == true) goto L8;
        return false;
    L8:
        if (r11.f22928b.equals(this.f22928b) == true) goto L10;
        return false;
    L10:
        if (r11.f22930d.equals(this.f22930d) == true) goto L12;
        return false;
    L12:
        if (r11.f22931e.equals(this.f22931e) == true) goto L14;
        return false;
    L14:
        if (r11.f22929c == this.f22929c) goto L16;
        return false;
    L16:
        if (r11.f22932f == this.f22932f) goto L18;
        return false;
    L18:
        if (r11.f22933g == this.f22933g) goto L20;
        return false;
    L20:
        if (r11.f22934h == this.f22934h) goto L22;
        return false;
    L22:
        if (r11.f22935i != this.f22935i) goto L33;
        return true;
    L33:
        return false;
    }

    public int hashCode() {
        int r10 = (((((((527 + this.f22927a.hashCode()) * 31) + this.f22928b.hashCode()) * 31) + this.f22930d.hashCode()) * 31) + this.f22931e.hashCode()) * 31;
        long r11 = this.f22929c;
        return ((((((((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + (!this.f22932f ? 1 : 0)) * 31) + (!this.f22933g ? 1 : 0)) * 31) + (!this.f22934h ? 1 : 0)) * 31) + (!this.f22935i ? 1 : 0);
    }

    public String j(boolean r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(this.f22927a);
        r11.append('=');
        r11.append(this.f22928b);
        if (this.f22934h == false) goto L9;
        if (this.f22929c != Long.MIN_VALUE) goto L7;
        r11.append("; max-age=0");
        goto L9
    L7:
        r11.append("; expires=");
        r11.append(HttpDate.format(new Date(this.f22929c)));
    L9:
        if (this.f22935i == true) goto L14;
        r11.append("; domain=");
        if (r10 == false) goto L13;
        r11.append(LibrarianImpl.Constants.DOT);
    L13:
        r11.append(this.f22930d);
    L14:
        r11.append("; path=");
        r11.append(this.f22931e);
        if (this.f22932f == false) goto L18;
        r11.append("; secure");
    L18:
        if (this.f22933g == false) goto L21;
        r11.append("; httponly");
    L21:
        return r11.toString();
    }

    public String k() {
        return this.f22928b;
    }

    public String toString() {
        return j(false);
    }
}
