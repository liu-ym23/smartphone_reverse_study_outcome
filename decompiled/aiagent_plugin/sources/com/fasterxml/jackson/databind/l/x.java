package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: StdDateFormat.java */
/* JADX INFO: loaded from: classes2.dex */
public class x extends DateFormat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Pattern f13072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Pattern f13073b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final String[] f13074c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final TimeZone f13075d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Locale f13076e = null;
    protected static final DateFormat f = null;
    public static final x g = null;
    protected static final Calendar h = null;
    protected transient TimeZone i;
    protected final Locale j;
    protected Boolean k;
    private transient Calendar l;
    private transient DateFormat m;
    private boolean n;

    @Override // java.text.DateFormat
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // java.text.DateFormat, java.text.Format
    public /* synthetic */ Object clone() {
        return a();
    }

    static {
        f13072a = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");
        f13073b = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
        f13074c = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
        TimeZone r0 = TimeZone.getTimeZone("UTC");
        f13075d = r0;
        Locale r1 = Locale.US;
        f13076e = r1;
        SimpleDateFormat r3 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", r1);
        f = r3;
        r3.setTimeZone(r0);
        g = new x();
        h = new GregorianCalendar(r0, r1);
        return;
    L6:
        th = move-exception;
        throw new RuntimeException(th);
    }

    public x() {
        this.n = true;
        this.j = f13076e;
    }

    public x(TimeZone r2, Locale r3, Boolean r4, boolean r5) {
        this.n = true;
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.n = r5;
    }

    public x a(TimeZone r4) {
        if (r4 != null) goto L4;
        r4 = f13075d;
    L4:
        TimeZone r0 = this.i;
        if (r4 != r0) goto L7;
    L11:
        return this;
    L7:
        if (r4.equals(r0) == true) goto L11;
        return new x(r4, this.j, this.k, this.n);
    }

    public x a(Locale r4) {
        if (r4.equals(this.j) == false) goto L6;
        return this;
    L6:
        return new x(this.i, r4, this.k, this.n);
    }

    public x a(Boolean r4) {
        if (a(r4, this.k) == false) goto L6;
        return this;
    L6:
        return new x(this.i, this.j, r4, this.n);
    }

    public x a() {
        return new x(this.i, this.j, this.k, this.n);
    }

    @Override // java.text.DateFormat
    public TimeZone getTimeZone() {
        return this.i;
    }

    @Override // java.text.DateFormat
    public void setTimeZone(TimeZone r2) {
        if (r2.equals(this.i) == true) goto L6;
        c();
        this.i = r2;
        return;
    }

    @Override // java.text.DateFormat
    public void setLenient(boolean r2) {
        Boolean r3 = Boolean.valueOf(r2);
        if (a(r3, this.k) == true) goto L6;
        this.k = r3;
        c();
        return;
    }

    @Override // java.text.DateFormat
    public boolean isLenient() {
        Boolean r0 = this.k;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.booleanValue() == true) goto L8;
        return false;
    }

    @Override // java.text.DateFormat
    public Date parse(String r9) {
        String r10 = r9.trim();
        ParsePosition r0 = new ParsePosition(0);
        Date r8 = a(r10, r0);
        if (r8 == null) goto L5;
        return r8;
    L5:
        StringBuilder r11 = new StringBuilder();
        String[] r2 = f13074c;
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L13;
        String r6 = r2[r4];
        if (r11.length() <= 0) goto L11;
        r11.append("\", \"");
    L12:
        r11.append(r6);
        r4 = r4 + 1;
        goto L7
    L11:
        r11.append('\"');
        goto L12
    L13:
        r11.append('\"');
        throw new ParseException(String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{r10, r11.toString()}), r0.getErrorIndex());
    }

    @Override // java.text.DateFormat
    public Date parse(String r1, ParsePosition r2) {
        return a(r1, r2);
    L4:
        return null;
    }

    public Date a(String r5, ParsePosition r6) {
        if (a(r5) == true) goto L5;
        int r0 = r5.length();
    L7:
        r0 = r0 - 1;
        if (r0 < 0) goto L15;
        char r2 = r5.charAt(r0);
        if (r2 < '0') goto L13;
        if (r2 <= '9') goto L7;
    L13:
        if (r0 > 0) goto L15;
        if (r2 == '-') goto L7;
    L15:
        if (r0 >= 0) goto L23;
        if (r5.charAt(0) == '-') goto L21;
        if (com.fasterxml.jackson.a.d.i.a(r5, false) == false) goto L23;
    L21:
        return e(r5, r6);
    L23:
        return d(r5, r6);
    L5:
        return b(r5, r6);
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date r2, StringBuffer r3, FieldPosition r4) {
        TimeZone r5 = this.i;
        if (r5 != null) goto L5;
        r5 = f13075d;
    L5:
        a(r5, this.j, r2, r3);
        return r3;
    }

    public void a(TimeZone r6, Locale r7, Date r8, StringBuffer r9) {
        Calendar r10 = b(r6);
        r10.setTime(r8);
        int r0 = r10.get(1);
        char r2 = '+';
        if (r10.get(0) != 0) goto L6;
        a(r9, r0);
    L9:
        r9.append('-');
        b(r9, r10.get(2) + 1);
        r9.append('-');
        b(r9, r10.get(5));
        r9.append('T');
        b(r9, r10.get(11));
        r9.append(':');
        b(r9, r10.get(12));
        r9.append(':');
        b(r9, r10.get(13));
        r9.append('.');
        c(r9, r10.get(14));
        int r11 = r6.getOffset(r10.getTimeInMillis());
        if (r11 == 0) goto L19;
        int r12 = r11 / 60000;
        int r1 = Math.abs(r12 / 60);
        int r13 = Math.abs(r12 % 60);
        if (r11 >= 0) goto L14;
        r2 = '-';
    L14:
        r9.append(r2);
        b(r9, r1);
        if (this.n == false) goto L17;
        r9.append(':');
    L17:
        b(r9, r13);
        return;
    L19:
        if (this.n == false) goto L21;
        r9.append("+00:00");
        return;
    L21:
        r9.append("+0000");
        return;
    L6:
        if (r0 <= 9999) goto L8;
        r9.append('+');
    L8:
        d(r9, r0);
        goto L9
    }

    public void a(StringBuffer r1, int r2) {
        if (r2 != 1) goto L6;
        r1.append("+0000");
        return;
    L6:
        r1.append('-');
        d(r1, r2 - 1);
    }

    private static void b(StringBuffer r3, int r4) {
        int r0 = r4 / 10;
        if (r0 != 0) goto L5;
        r3.append('0');
    L6:
        r3.append((char) (r4 + 48));
        return;
    L5:
        r3.append((char) (r0 + 48));
        r4 = r4 - (r0 * 10);
        goto L6
    }

    private static void c(StringBuffer r2, int r3) {
        int r0 = r3 / 100;
        if (r0 != 0) goto L5;
        r2.append('0');
    L6:
        b(r2, r3);
        return;
    L5:
        r2.append((char) (r0 + 48));
        r3 = r3 - (r0 * 100);
        goto L6
    }

    private static void d(StringBuffer r2, int r3) {
        int r0 = r3 / 100;
        if (r0 != 0) goto L6;
        r2.append('0').append('0');
    L10:
        b(r2, r3);
        return;
    L6:
        if (r0 <= 99) goto L8;
        r2.append(r0);
    L9:
        r3 = r3 - (r0 * 100);
        goto L10
    L8:
        b(r2, r0);
        goto L9
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", new Object[]{getClass().getName(), this.i, this.j, this.k});
    }

    public String b() {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("[one of: '").append("yyyy-MM-dd'T'HH:mm:ss.SSSX").append("', '").append("EEE, dd MMM yyyy HH:mm:ss zzz").append("' (");
        if (Boolean.FALSE.equals(this.k) == false) goto L5;
        String r3 = "strict";
    L6:
        r0.append(r3).append(")]");
        return r0.toString();
    L5:
        r3 = "lenient";
        goto L6
    }

    @Override // java.text.DateFormat
    public int hashCode() {
        return System.identityHashCode(this);
    }

    public boolean a(String r3) {
        if (r3.length() >= 7) goto L5;
    L14:
        return false;
    L5:
        if (Character.isDigit(r3.charAt(0)) == false) goto L14;
        if (Character.isDigit(r3.charAt(3)) == false) goto L14;
        if (r3.charAt(4) != '-') goto L14;
        if (Character.isDigit(r3.charAt(5)) == false) goto L14;
        return true;
    }

    private Date e(String r3, ParsePosition r4) {
        return new Date(com.fasterxml.jackson.a.d.i.b(r3));
    L6:
        throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", new Object[]{r3}), r4.getErrorIndex());
    }

    public Date b(String r4, ParsePosition r5) {
        return c(r4, r5);
    L4:
        e = move-exception;
        throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", new Object[]{r4, e.getMessage()}), r5.getErrorIndex());
    }

    public Date c(String r18, ParsePosition r19) {
        int r2 = r18.length();
        TimeZone r3 = f13075d;
        if (this.i != null) goto L5;
    L7:
        Calendar r4 = b(r3);
        r4.clear();
        int r15 = 0;
        if (r2 <= 10) goto L10;
        Matcher r9 = f13073b.matcher(r18);
        if (r9.matches() == false) goto L51;
        int r0 = r9.start(2);
        int r6 = r9.end(2);
        int r7 = r6 - r0;
        if (r7 <= 1) goto L26;
        int r12 = b(r18, r0 + 1) * 3600;
        if (r7 < 5) goto L22;
        r12 = r12 + (b(r18, r6 - 2) * 60);
    L22:
        if (r18.charAt(r0) != '-') goto L24;
        int r13 = r12 * (-1000);
    L25:
        r4.set(15, r13);
        r4.set(16, 0);
        goto L26
    L24:
        r13 = r12 * 1000;
    L26:
        int r1 = a(r18, 0);
        int r8 = b(r18, 5) - 1;
        int r10 = b(r18, 8);
        int r14 = b(r18, 11);
        int r16 = b(r18, 14);
        if (r2 > 16) goto L29;
    L31:
        int r5 = 0;
    L32:
        r4.set(r1, r8, r10, r14, r16, r5);
        int r11 = r9.start(1) + 1;
        int r17 = r9.end(1);
        if (r11 < r17) goto L35;
        r4.set(14, 0);
    L50:
        return r4.getTime();
    L35:
        int r20 = r17 - r11;
        if (r20 == 0) goto L48;
        if (r20 == 1) goto L47;
        if (r20 == 2) goto L46;
        if (r20 != 3) goto L41;
    L45:
        r15 = 0 + (r18.charAt(r11 + 2) - '0');
        goto L46
    L41:
        if (r20 <= 9) goto L45;
        throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", new Object[]{r18, r9.group(1).substring(1)}), r11);
    L46:
        r15 = r15 + ((r18.charAt(r11 + 1) - '0') * 10);
    L47:
        r15 = r15 + ((r18.charAt(r11) - '0') * 100);
    L48:
        r4.set(14, r15);
        goto L50
    L29:
        if (r18.charAt(16) != ':') goto L31;
        r5 = b(r18, 17);
        goto L32
    L51:
        String r21 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
    L53:
        throw new ParseException(String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", new Object[]{r18, r21, this.k}), 0);
    L10:
        if (f13072a.matcher(r18).matches() == false) goto L13;
        r4.set(a(r18, 0), b(r18, 5) - 1, b(r18, 8), 0, 0, 0);
        r4.set(14, 0);
        return r4.getTime();
    L13:
        r21 = "yyyy-MM-dd";
        goto L53
    L5:
        if ('Z' == r18.charAt(r2 - 1)) goto L7;
        r3 = this.i;
        goto L7
    }

    private static int a(String r2, int r3) {
        return ((((r2.charAt(r3) - '0') * 1000) + ((r2.charAt(r3 + 1) - '0') * 100)) + ((r2.charAt(r3 + 2) - '0') * 10)) + (r2.charAt(r3 + 3) - '0');
    }

    private static int b(String r1, int r2) {
        return ((r1.charAt(r2) - '0') * 10) + (r1.charAt(r2 + 1) - '0');
    }

    public Date d(String r6, ParsePosition r7) {
        if (this.m != null) goto L6;
        this.m = a(f, "EEE, dd MMM yyyy HH:mm:ss zzz", this.i, this.j, this.k);
    L6:
        return this.m.parse(r6, r7);
    }

    private static final DateFormat a(DateFormat r1, String r2, TimeZone r3, Locale r4, Boolean r5) {
        if (r4.equals(f13076e) == true) goto L8;
        DateFormat r6 = new SimpleDateFormat(r2, r4);
        if (r3 != null) goto L7;
        r3 = f13075d;
    L7:
        r6.setTimeZone(r3);
    L11:
        if (r5 == null) goto L13;
        r6.setLenient(r5.booleanValue());
    L13:
        return r6;
    L8:
        r6 = (DateFormat) ZeusTransformUtils.preCheckCast(r1.clone(), DateFormat.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r6.setTimeZone(r3);
        goto L11
    }

    public void c() {
        this.m = null;
    }

    public Calendar b(TimeZone r4) {
        Calendar r0 = this.l;
        if (r0 != null) goto L6;
        r0 = (Calendar) ZeusTransformUtils.preCheckCast(h.clone(), Calendar.class, "com.obric.aiagent.plugin");
        this.l = r0;
    L6:
        if (r0.getTimeZone().equals(r4) == true) goto L8;
        r0.setTimeZone(r4);
    L8:
        r0.setLenient(isLenient());
        return r0;
    }

    public static <T> boolean a(T r1, T r2) {
        if (r1 != r2) goto L5;
        return true;
    L5:
        if (r1 != null) goto L7;
    L9:
        return false;
    L7:
        if (r1.equals(r2) == false) goto L9;
        return true;
    }
}
