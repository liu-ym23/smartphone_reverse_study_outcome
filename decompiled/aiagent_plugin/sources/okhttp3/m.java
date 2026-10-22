package okhttp3;

import com.obric.oui.calendar.ODatePickerView;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40173a = null;
    private static final Pattern k = null;
    private static final Pattern l = null;
    private static final Pattern m = null;
    private static final Pattern n = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f40175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f40176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f40177e;
    private final String f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    /* JADX INFO: compiled from: Cookie.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        private final boolean a(String r4, String r5) {
            if (d.h.b.o.a(r4, r5) == false) goto L6;
            return true;
        L6:
            if (d.o.o.c(r4, r5, false, 2, null) == false) goto L13;
            if (r4.charAt((r4.length() - r5.length()) - 1) != '.') goto L13;
            if (okhttp3.internal.c.b(r4) == true) goto L13;
            return true;
        L13:
            return false;
        }

        public final m a(v r3, String r4) {
            d.h.b.o.e(r3, "url");
            d.h.b.o.e(r4, "setCookie");
            return a(System.currentTimeMillis(), r3, r4);
        }

        public final m a(long r26, v r28, String r29) {
            d.h.b.o.e(r28, "url");
            d.h.b.o.e(r29, "setCookie");
            int r9 = okhttp3.internal.c.a(r29, ';', 0, 0, 6, null);
            int r1 = okhttp3.internal.c.a(r29, '=', 0, r9, 2, null);
            if (r1 != r9) goto L5;
            return null;
        L5:
            String r11 = okhttp3.internal.c.c(r29, 0, r1, 1, null);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == true) goto L85;
            if (okhttp3.internal.c.a(r11) != (-1)) goto L85;
            String r12 = okhttp3.internal.c.c(r29, r1 + 1, r9);
            if (okhttp3.internal.c.a(r12) == (-1)) goto L16;
            return null;
        L16:
            int r10 = r9 + 1;
            int r2 = r29.length();
            String r6 = null;
            String r13 = null;
            boolean r17 = false;
            boolean r18 = false;
            boolean r19 = false;
            boolean r20 = true;
            long r21 = -1;
            long r23 = 253402300799999L;
        L17:
            if (r10 >= r2) goto L44;
            int r3 = okhttp3.internal.c.a(r29, ';', r10, r2);
            int r15 = okhttp3.internal.c.a(r29, '=', r10, r3);
            String r14 = okhttp3.internal.c.c(r29, r10, r15);
            if (r15 >= r3) goto L21;
            String r16 = okhttp3.internal.c.c(r29, r15 + 1, r3);
        L23:
            if (d.o.o.a(r14, "expires", true) == false) goto L27;
            r23 = a(r16, 0, r16.length());     // Catch: Throwable -> L86
        L29:
            r19 = true;
        L43:
            r10 = r3 + 1;
            goto L17
        L27:
            if (d.o.o.a(r14, "max-age", true) == false) goto L31;
            r21 = a(r16);
            goto L29
        L31:
            if (d.o.o.a(r14, "domain", true) == false) goto L35;
            r6 = b(r16);     // Catch: Throwable -> L86
            r20 = false;
            goto L43
        L35:
            if (d.o.o.a(r14, DownloadConstants.PATH_KEY, true) == false) goto L38;
            r13 = r16;
            goto L43
        L38:
            if (d.o.o.a(r14, "secure", true) == false) goto L41;
            r17 = true;
            goto L43
        L41:
            if (d.o.o.a(r14, "httponly", true) == false) goto L43;
            r18 = true;
            goto L43
        L21:
            r16 = "";
            goto L23
        L44:
            long r4 = Long.MIN_VALUE;
            if (r21 != Long.MIN_VALUE) goto L48;
        L46:
            long r110 = r4;
        L59:
            String r7 = r28.b();
            if (r6 != null) goto L63;
            String r111 = r7;
            m r0 = null;
        L68:
            if (r7.length() != r111.length()) goto L70;
        L72:
            String r8 = "/";
            if (r13 != null) goto L75;
        L78:
            String r22 = r28.i();
            int r24 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin"), '/', 0, false, 6, null);
            if (r24 == 0) goto L81;
            r8 = r22.substring(0, r24);
            d.h.b.o.c(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        L81:
            String r112 = r8;
        L83:
            return new m(r11, r12, r110, r111, r112, r17, r18, r19, r20, null);
        L75:
            if (d.o.o.b(r13, "/", false, 2, r0) == false) goto L78;
            r112 = r13;
            goto L83
        L70:
            if (PublicSuffixDatabase.f40158a.a().a(r111) != null) goto L72;
            return r0;
        L63:
            if (a(r7, r6) == true) goto L66;
            return null;
        L66:
            r0 = null;
            r111 = r6;
            goto L68
        L48:
            if (r21 != (-1)) goto L50;
            r110 = r23;
            goto L59
        L50:
            if (r21 > 9223372036854775L) goto L52;
            long r25 = r21 * ((long) 1000);
        L53:
            r4 = r26 + r25;
            r110 = 253402300799999L;
            if (r4 < r26) goto L59;
            if (r4 <= 253402300799999L) goto L46;
        L52:
            r25 = Long.MAX_VALUE;
        L85:
            return null;
        L8:
            r5 = false;
            goto L9
        }

        private final long a(String r24, int r25, int r26) {
            int r4 = a(r24, r25, r26, false);
            Matcher r5 = m.c().matcher((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"));
            int r6 = -1;
            int r8 = -1;
            int r9 = -1;
            int r10 = -1;
            int r11 = -1;
            int r12 = -1;
            int r13 = -1;
        L4:
            if (r4 >= r26) goto L26;
            int r3 = a(r24, r4 + 1, r26, true);
            r5.region(r4, r3);
            if (r9 == r6) goto L8;
        L11:
            if (r10 == r6) goto L13;
        L15:
            if (r11 == r6) goto L17;
        L20:
            if (r8 != r6) goto L24;
            if (r5.usePattern(m.f()).matches() == false) goto L24;
            String r7 = r5.group(1);
            d.h.b.o.c(r7, "matcher.group(1)");
            r8 = Integer.parseInt(r7);
        L24:
            r6 = -1;
            r4 = a(r24, r3 + 1, r26, false);
            goto L4
        L17:
            if (r5.usePattern(m.e()).matches() == false) goto L19;
            String r14 = r5.group(1);
            d.h.b.o.c(r14, "matcher.group(1)");
            Locale r15 = Locale.US;
            d.h.b.o.c(r15, "US");
            String r16 = r14.toLowerCase(r15);
            d.h.b.o.c(r16, "this as java.lang.String).toLowerCase(locale)");
            String r17 = m.e().pattern();
            d.h.b.o.c(r17, "MONTH_PATTERN.pattern()");
            r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"), r16, 0, false, 6, null) / 4;
            goto L24
        L19:
            r6 = -1;
            goto L20
        L13:
            if (r5.usePattern(m.d()).matches() == false) goto L15;
            String r18 = r5.group(1);
            d.h.b.o.c(r18, "matcher.group(1)");
            r10 = Integer.parseInt(r18);
            goto L24
        L8:
            if (r5.usePattern(m.c()).matches() == false) goto L10;
            String r19 = r5.group(1);
            d.h.b.o.c(r19, "matcher.group(1)");
            r9 = Integer.parseInt(r19);
            String r20 = r5.group(2);
            d.h.b.o.c(r20, "matcher.group(2)");
            r12 = Integer.parseInt(r20);
            String r21 = r5.group(3);
            d.h.b.o.c(r21, "matcher.group(3)");
            r13 = Integer.parseInt(r21);
            goto L24
        L10:
            r6 = -1;
            goto L11
        L26:
            if (70 <= r8) goto L28;
        L30:
            boolean r1 = false;
        L31:
            if (r1 == false) goto L33;
            r8 = r8 + ODatePickerView.YEAR_FROM;
        L33:
            if (r8 < 0) goto L36;
            if (r8 >= 70) goto L36;
            boolean r0 = true;
        L37:
            if (r0 == false) goto L40;
            r8 = r8 + DownloadErrorCode.ERROR_CRONET_ERROR_BASE;
        L40:
            if (r8 < 1601) goto L42;
            boolean r2 = true;
        L44:
            if (r2 == false) goto L86;
            if (r11 == (-1)) goto L48;
            boolean r22 = true;
        L49:
            if (r22 == false) goto L84;
            if (1 <= r10) goto L52;
        L54:
            boolean r23 = false;
        L55:
            if (r23 == false) goto L82;
            if (r9 >= 0) goto L58;
        L60:
            boolean r27 = false;
        L61:
            if (r27 == false) goto L80;
            if (r12 < 0) goto L66;
            if (r12 >= 60) goto L66;
            boolean r28 = true;
        L67:
            if (r28 == false) goto L78;
            if (r13 < 0) goto L71;
            if (r13 >= 60) goto L71;
            boolean r29 = true;
        L72:
            if (r29 == false) goto L76;
            GregorianCalendar r30 = new GregorianCalendar(okhttp3.internal.c.f39837e);
            r30.setLenient(false);
            r30.set(1, r8);
            r30.set(2, r11 - 1);
            r30.set(5, r10);
            r30.set(11, r9);
            r30.set(12, r12);
            r30.set(13, r13);
            r30.set(14, 0);
            return r30.getTimeInMillis();
        L76:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L71:
            r29 = false;
            goto L72
        L78:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L66:
            r28 = false;
            goto L67
        L80:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L58:
            if (r9 >= 24) goto L60;
            r27 = true;
            goto L61
        L82:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L52:
            if (r10 >= 32) goto L54;
            r23 = true;
            goto L55
        L84:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L48:
            r22 = false;
            goto L49
        L86:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L42:
            r2 = false;
        L36:
            r0 = false;
            goto L37
        L28:
            if (r8 >= 100) goto L30;
            r1 = true;
            goto L31
        }

        private final int a(String r5, int r6, int r7, boolean r8) {
        L2:
            if (r6 >= r7) goto L35;
            char r4 = r5.charAt(r6);
            boolean r2 = false;
            if (r4 >= ' ') goto L8;
            if (r4 == '\t') goto L8;
        L30:
            r2 = true;
        L32:
            if (r2 == (!r8)) goto L33;
            r6 = r6 + 1;
            goto L2
        L33:
            return r6;
        L8:
            if (r4 >= 127) goto L30;
            if ('0' > r4) goto L13;
            if (r4 >= ':') goto L13;
            boolean r0 = true;
        L14:
            if (r0 == true) goto L30;
            if ('a' <= r4) goto L18;
        L20:
            boolean r1 = false;
        L21:
            if (r1 == true) goto L30;
            if ('A' <= r4) goto L25;
        L27:
            boolean r3 = false;
        L28:
            if (r3 == true) goto L30;
            if (r4 != ':') goto L32;
        L25:
            if (r4 >= '[') goto L27;
            r3 = true;
            goto L28
        L18:
            if (r4 >= '{') goto L20;
            r1 = true;
        L13:
            r0 = false;
            goto L14
        L35:
            return r7;
        }

        private final long a(String r6) {
            long r5 = Long.parseLong(r6);     // Catch: NumberFormatException -> L9
            if (r5 > 0) goto L8;
            return Long.MIN_VALUE;
        L8:
            return r5;
        L9:
            e = move-exception;
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
            if (new d.o.k("-?\\d+").a(r2) == true) goto L13;
            throw e;
        L13:
            if (d.o.o.b(r6, "-", false, 2, null) == true) goto L21;
            return Long.MAX_VALUE;
        L21:
            return Long.MIN_VALUE;
        }

        private final String b(String r4) {
            if ((!d.o.o.c(r4, ".", false, 2, null)) == false) goto L10;
            String r3 = okhttp3.internal.a.a(d.o.o.a(r4, (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.aiagent.plugin")));
            if (r3 == null) goto L8;
            return r3;
        L8:
            throw new IllegalArgumentException();
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final List<m> a(v r7, u r8) {
            d.h.b.o.e(r7, "url");
            d.h.b.o.e(r8, "headers");
            List<String> r9 = r8.b("Set-Cookie");
            int r0 = r9.size();
            List r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            m r3 = a(r7, (String) ZeusTransformUtils.preCheckCast(r9.get(r2), String.class, "com.obric.aiagent.plugin"));
            if (r3 == null) goto L10;
            if (r1 != null) goto L9;
            r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L9:
            r1.add(r3);
        L10:
            r2 = r2 + 1;
            goto L3
        L11:
            if (r1 == null) goto L14;
            List<m> r6 = Collections.unmodifiableList(r1);
            d.h.b.o.c(r6, "{\n        Collections.un…ableList(cookies)\n      }");
            return r6;
        L14:
            return d.a.p.b();
        }
    }

    public /* synthetic */ m(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10, d.h.b.h r11) {
        this(r1, r2, r3, r5, r6, r7, r8, r9, r10);
    }

    private m(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        this.f40174b = r1;
        this.f40175c = r2;
        this.f40176d = r3;
        this.f40177e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public static final /* synthetic */ Pattern c() {
        return n;
    }

    public static final /* synthetic */ Pattern d() {
        return m;
    }

    public static final /* synthetic */ Pattern e() {
        return l;
    }

    public static final /* synthetic */ Pattern f() {
        return k;
    }

    public final String a() {
        return this.f40174b;
    }

    public final String b() {
        return this.f40175c;
    }

    public boolean equals(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, m.class) == true) goto L5;
    L23:
        return false;
    L5:
        if (d.h.b.o.a(((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).f40174b, this.f40174b) == false) goto L23;
        if (d.h.b.o.a(((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).f40175c, this.f40175c) == false) goto L23;
        if (((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).f40176d != this.f40176d) goto L23;
        if (d.h.b.o.a(((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).f40177e, this.f40177e) == false) goto L23;
        if (d.h.b.o.a(((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).f, this.f) == false) goto L23;
        if (((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).g != this.g) goto L23;
        if (((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).h != this.h) goto L23;
        if (((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).i != this.i) goto L23;
        if (((m) ZeusTransformUtils.preCheckCast(r7, m.class, "com.obric.aiagent.plugin")).j != this.j) goto L23;
        return true;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f40174b.hashCode()) * 31) + this.f40175c.hashCode()) * 31) + Long.hashCode(this.f40176d)) * 31) + this.f40177e.hashCode()) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Boolean.hashCode(this.j);
    }

    public String toString() {
        return a(false);
    }

    public final String a(boolean r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f40174b);
        r0.append('=');
        r0.append(this.f40175c);
        if (this.i == false) goto L9;
        if (this.f40176d != Long.MIN_VALUE) goto L7;
        r0.append("; max-age=0");
        goto L9
    L7:
        r0.append("; expires=").append(okhttp3.internal.e.c.a(new Date(this.f40176d)));
    L9:
        if (this.j == true) goto L14;
        r0.append("; domain=");
        if (r6 == false) goto L13;
        r0.append(".");
    L13:
        r0.append(this.f40177e);
    L14:
        r0.append("; path=").append(this.f);
        if (this.g == false) goto L18;
        r0.append("; secure");
    L18:
        if (this.h == false) goto L20;
        r0.append("; httponly");
    L20:
        String r5 = r0.toString();
        d.h.b.o.c(r5, "toString()");
        return r5;
    }

    static {
        f40173a = new a(null);
        k = Pattern.compile("(\\d{2,4})[^\\d]*");
        l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        m = Pattern.compile("(\\d{1,2})[^\\d]*");
        n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }
}
