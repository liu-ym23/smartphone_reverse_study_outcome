package com.fasterxml.jackson.databind.util;

import h0.e;
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

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StdDateFormat extends DateFormat {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f4515j = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f4516k;

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f4517l;

    /* renamed from: m, reason: collision with root package name */
    public static final TimeZone f4518m;

    /* renamed from: n, reason: collision with root package name */
    public static final Locale f4519n;

    /* renamed from: o, reason: collision with root package name */
    public static final SimpleDateFormat f4520o;

    /* renamed from: p, reason: collision with root package name */
    public static final StdDateFormat f4521p;

    /* renamed from: q, reason: collision with root package name */
    public static final GregorianCalendar f4522q;

    /* renamed from: a, reason: collision with root package name */
    public transient TimeZone f4523a;

    /* renamed from: b, reason: collision with root package name */
    public final Locale f4524b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f4525c;

    /* renamed from: d, reason: collision with root package name */
    public transient Calendar f4526d;

    /* renamed from: e, reason: collision with root package name */
    public transient DateFormat f4527e;
    public final boolean h;

    static {
        try {
            f4516k = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
            f4517l = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            f4518m = timeZone;
            Locale locale = Locale.US;
            f4519n = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            f4520o = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            f4521p = new StdDateFormat();
            f4522q = new GregorianCalendar(timeZone, locale);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public StdDateFormat() {
        this.h = true;
        this.f4524b = f4519n;
    }

    public static int c(int i10, String str) {
        return (str.charAt(i10 + 1) - '0') + ((str.charAt(i10) - '0') * 10);
    }

    public static int d(String str) {
        return (str.charAt(3) - '0') + ((str.charAt(2) - '0') * 10) + ((str.charAt(1) - '0') * 100) + ((str.charAt(0) - '0') * 1000);
    }

    public static void g(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 10;
        if (i11 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i11 + 48));
            i10 -= i11 * 10;
        }
        stringBuffer.append((char) (i10 + 48));
    }

    public static void h(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 100;
        if (i11 == 0) {
            stringBuffer.append('0');
            stringBuffer.append('0');
        } else {
            if (i11 > 99) {
                stringBuffer.append(i11);
            } else {
                g(stringBuffer, i11);
            }
            i10 -= i11 * 100;
        }
        g(stringBuffer, i10);
    }

    public final Calendar b(TimeZone timeZone) {
        Calendar calendar = this.f4526d;
        if (calendar == null) {
            calendar = (Calendar) f4522q.clone();
            this.f4526d = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    @Override // java.text.DateFormat, java.text.Format
    public final Object clone() {
        return new StdDateFormat(this.f4523a, this.f4524b, this.f4525c, this.h);
    }

    public final Date e(String str) throws ParseException {
        String str2;
        int i10;
        int i11;
        int iC;
        int length = str.length();
        Calendar calendarB = b((this.f4523a == null || 'Z' == str.charAt(length + (-1))) ? f4518m : this.f4523a);
        calendarB.clear();
        int iCharAt = 0;
        if (length > 10) {
            Matcher matcher = f4516k.matcher(str);
            if (matcher.matches()) {
                int iStart = matcher.start(2);
                int iEnd = matcher.end(2);
                int i12 = iEnd - iStart;
                if (i12 > 1) {
                    int iC2 = c(iStart + 1, str) * 3600;
                    if (i12 >= 5) {
                        iC2 += c(iEnd - 2, str) * 60;
                    }
                    calendarB.set(15, str.charAt(iStart) == '-' ? iC2 * (-1000) : iC2 * 1000);
                    calendarB.set(16, 0);
                }
                int iD = d(str);
                int iC3 = c(5, str) - 1;
                int iC4 = c(8, str);
                int iC5 = c(11, str);
                int iC6 = c(14, str);
                if (length <= 16 || str.charAt(16) != ':') {
                    i10 = iC4;
                    i11 = iD;
                    iC = 0;
                } else {
                    i10 = iC4;
                    i11 = iD;
                    iC = c(17, str);
                }
                calendarB.set(i11, iC3, i10, iC5, iC6, iC);
                int iStart2 = matcher.start(1);
                int i13 = iStart2 + 1;
                int iEnd2 = matcher.end(1);
                if (i13 >= iEnd2) {
                    calendarB.set(14, 0);
                } else {
                    int i14 = iEnd2 - i13;
                    if (i14 != 0) {
                        if (i14 != 1) {
                            if (i14 != 2) {
                                if (i14 != 3 && i14 > 9) {
                                    throw new ParseException(e.c("Cannot parse date \"", str, "\": invalid fractional seconds '", matcher.group(1).substring(1), "'; can use at most 9 digits"), i13);
                                }
                                iCharAt = str.charAt(iStart2 + 3) - '0';
                            }
                            iCharAt += (str.charAt(iStart2 + 2) - '0') * 10;
                        }
                        iCharAt += (str.charAt(i13) - '0') * 100;
                    }
                    calendarB.set(14, iCharAt);
                }
                return calendarB.getTime();
            }
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        } else {
            if (f4515j.matcher(str).matches()) {
                calendarB.set(d(str), c(5, str) - 1, c(8, str), 0, 0, 0);
                calendarB.set(14, 0);
                return calendarB.getTime();
            }
            str2 = "yyyy-MM-dd";
        }
        Boolean bool = this.f4525c;
        StringBuilder sbS = ai.onnxruntime.a.s("Cannot parse date \"", str, "\": while it seems to fit format '", str2, "', parsing fails (leniency? ");
        sbS.append(bool);
        sbS.append(")");
        throw new ParseException(sbS.toString(), 0);
    }

    @Override // java.text.DateFormat
    public final boolean equals(Object obj) {
        return obj == this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
    
        if (r2 < 0) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Date f(java.lang.String r6, java.text.ParsePosition r7) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.StdDateFormat.f(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    @Override // java.text.DateFormat
    public final StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.f4523a;
        if (timeZone == null) {
            timeZone = f4518m;
        }
        Calendar calendarB = b(timeZone);
        calendarB.setTime(date);
        int i10 = calendarB.get(1);
        if (calendarB.get(0) != 0) {
            if (i10 > 9999) {
                stringBuffer.append('+');
            }
            h(stringBuffer, i10);
        } else if (i10 == 1) {
            stringBuffer.append("+0000");
        } else {
            stringBuffer.append('-');
            h(stringBuffer, i10 - 1);
        }
        stringBuffer.append('-');
        g(stringBuffer, calendarB.get(2) + 1);
        stringBuffer.append('-');
        g(stringBuffer, calendarB.get(5));
        stringBuffer.append('T');
        g(stringBuffer, calendarB.get(11));
        stringBuffer.append(':');
        g(stringBuffer, calendarB.get(12));
        stringBuffer.append(':');
        g(stringBuffer, calendarB.get(13));
        stringBuffer.append('.');
        int i11 = calendarB.get(14);
        int i12 = i11 / 100;
        if (i12 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i12 + 48));
            i11 -= i12 * 100;
        }
        g(stringBuffer, i11);
        int offset = timeZone.getOffset(calendarB.getTimeInMillis());
        boolean z = this.h;
        if (offset == 0) {
            if (z) {
                stringBuffer.append("+00:00");
                return stringBuffer;
            }
            stringBuffer.append("+0000");
            return stringBuffer;
        }
        int i13 = offset / 60000;
        int iAbs = Math.abs(i13 / 60);
        int iAbs2 = Math.abs(i13 % 60);
        stringBuffer.append(offset < 0 ? '-' : '+');
        g(stringBuffer, iAbs);
        if (z) {
            stringBuffer.append(':');
        }
        g(stringBuffer, iAbs2);
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public final TimeZone getTimeZone() {
        return this.f4523a;
    }

    @Override // java.text.DateFormat
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.text.DateFormat
    public final boolean isLenient() {
        Boolean bool = this.f4525c;
        return bool == null || bool.booleanValue();
    }

    @Override // java.text.DateFormat
    public final Date parse(String str) throws ParseException {
        String strTrim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date dateF = f(strTrim, parsePosition);
        if (dateF != null) {
            return dateF;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : f4517l) {
            if (sb2.length() > 0) {
                sb2.append("\", \"");
            } else {
                sb2.append('\"');
            }
            sb2.append(str2);
        }
        sb2.append('\"');
        throw new ParseException(e.c("Cannot parse date \"", strTrim, "\": not compatible with any of standard forms (", sb2.toString(), ")"), parsePosition.getErrorIndex());
    }

    @Override // java.text.DateFormat
    public final void setLenient(boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Boolean bool = this.f4525c;
        if (boolValueOf == bool || boolValueOf.equals(bool)) {
            return;
        }
        this.f4525c = boolValueOf;
        this.f4527e = null;
    }

    @Override // java.text.DateFormat
    public final void setTimeZone(TimeZone timeZone) {
        if (timeZone.equals(this.f4523a)) {
            return;
        }
        this.f4527e = null;
        this.f4523a = timeZone;
    }

    public final String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", getClass().getName(), this.f4523a, this.f4524b, this.f4525c);
    }

    public StdDateFormat(TimeZone timeZone, Locale locale, Boolean bool, boolean z) {
        this.f4523a = timeZone;
        this.f4524b = locale;
        this.f4525c = bool;
        this.h = z;
    }

    @Override // java.text.DateFormat
    public final Date parse(String str, ParsePosition parsePosition) {
        try {
            return f(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }
}
