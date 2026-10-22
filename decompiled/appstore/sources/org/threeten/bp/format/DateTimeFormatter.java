package org.threeten.bp.format;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import org.apache.http.message.TokenParser;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes4.dex */
public final class DateTimeFormatter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateTimeFormatter f23098h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DateTimeFormatter f23099i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final DateTimeFormatter f23100j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DateTimeFormatter f23101k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final DateTimeFormatter f23102l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final DateTimeFormatter f23103m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DateTimeFormatter f23104n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final DateTimeFormatter f23105o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final DateTimeFormatter f23106p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final DateTimeFormatter f23107q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final DateTimeFormatter f23108r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final DateTimeFormatter f23109s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final DateTimeFormatter f23110t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final DateTimeFormatter f23111u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final DateTimeFormatter f23112v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final TemporalQuery f23113w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final TemporalQuery f23114x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateTimeFormatterBuilder.g f23115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Locale f23116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f23117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ResolverStyle f23118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f23119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final org.threeten.bp.chrono.e f23120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ZoneId f23121g;

    public static class ClassicFormat extends Format {
        private final DateTimeFormatter formatter;
        private final TemporalQuery<?> query;

        public ClassicFormat(DateTimeFormatter r10, TemporalQuery<?> r11) {
            this.formatter = r10;
            this.query = r11;
        }

        @Override // java.text.Format
        public StringBuffer format(Object r10, StringBuffer r11, FieldPosition r12) {
            ig.d.h(r10, "obj");
            ig.d.h(r11, "toAppendTo");
            ig.d.h(r12, "pos");
            if ((r10 instanceof TemporalAccessor) == false) goto L11;
            r12.setBeginIndex(0);
            r12.setEndIndex(0);
            this.formatter.e((TemporalAccessor) r10, r11);     // Catch: RuntimeException -> L7
            return r11;
        L7:
            e = move-exception;
            throw new IllegalArgumentException(e.getMessage(), e);
        L11:
            throw new IllegalArgumentException("Format target must implement TemporalAccessor");
        }

        @Override // java.text.Format
        public Object parseObject(String r10) throws ParseException {
            ig.d.h(r10, "text");
            TemporalQuery<?> r11 = this.query;     // Catch: RuntimeException -> L7 DateTimeParseException -> L9
            if (r11 != null) goto L12;
            return DateTimeFormatter.a(this.formatter, r10, null).n(this.formatter.j(), this.formatter.i());
        L12:
            return this.formatter.n(r10, r11);
        L9:
            e = move-exception;
            throw new ParseException(e.getMessage(), e.getErrorIndex());
        L7:
            e = move-exception;
            throw ((ParseException) new ParseException(e.getMessage(), 0).initCause(e));
        }

        @Override // java.text.Format
        public Object parseObject(String r10, ParsePosition r11) {
            ig.d.h(r10, "text");
            org.threeten.bp.format.b.C0333b r12 = DateTimeFormatter.b(this.formatter, r10, r11);     // Catch: IndexOutOfBoundsException -> L16
            if (r12 == null) goto L6;
            org.threeten.bp.format.a r13 = r12.b().n(this.formatter.j(), this.formatter.i());     // Catch: RuntimeException -> L14
            TemporalQuery<?> r14 = this.query;     // Catch: RuntimeException -> L14
            if (r14 != null) goto L12;
            return r13;
        L12:
            return r13.d(r14);
        L14:
            r11.setErrorIndex(0);
            return null;
        L6:
            if (r11.getErrorIndex() >= 0) goto L8;
            r11.setErrorIndex(0);
        L8:
            return null;
        L17:
            if (r11.getErrorIndex() >= 0) goto L19;
            r11.setErrorIndex(0);
        L19:
            return null;
        }
    }

    public static class a implements TemporalQuery {
        public a() {
        }

        public Period a(TemporalAccessor r10) {
            if ((r10 instanceof org.threeten.bp.format.a) == false) goto L7;
            return ((org.threeten.bp.format.a) r10).f23182g;
        L7:
            return Period.ZERO;
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static class b implements TemporalQuery {
        public b() {
        }

        public Boolean a(TemporalAccessor r10) {
            if ((r10 instanceof org.threeten.bp.format.a) == false) goto L7;
            return Boolean.valueOf(((org.threeten.bp.format.a) r10).f23181f);
        L7:
            return Boolean.FALSE;
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    static {
        DateTimeFormatterBuilder r10 = new DateTimeFormatterBuilder();
        ChronoField r11 = ChronoField.YEAR;
        SignStyle r12 = SignStyle.EXCEEDS_PAD;
        DateTimeFormatterBuilder r13 = r10.q(r11, 4, 10, r12).f('-');
        ChronoField r14 = ChronoField.MONTH_OF_YEAR;
        DateTimeFormatterBuilder r15 = r13.p(r14, 2).f('-');
        ChronoField r16 = ChronoField.DAY_OF_MONTH;
        DateTimeFormatterBuilder r17 = r15.p(r16, 2);
        ResolverStyle r18 = ResolverStyle.STRICT;
        DateTimeFormatter r19 = r17.G(r18);
        IsoChronology r110 = IsoChronology.INSTANCE;
        DateTimeFormatter r20 = r19.r(r110);
        f23098h = r20;
        f23099i = new DateTimeFormatterBuilder().z().a(r20).j().G(r18).r(r110);
        f23100j = new DateTimeFormatterBuilder().z().a(r20).w().j().G(r18).r(r110);
        DateTimeFormatterBuilder r111 = new DateTimeFormatterBuilder();
        ChronoField r112 = ChronoField.HOUR_OF_DAY;
        DateTimeFormatterBuilder r113 = r111.p(r112, 2).f(':');
        ChronoField r114 = ChronoField.MINUTE_OF_HOUR;
        DateTimeFormatterBuilder r115 = r113.p(r114, 2).w().f(':');
        ChronoField r116 = ChronoField.SECOND_OF_MINUTE;
        DateTimeFormatter r21 = r115.p(r116, 2).w().c(ChronoField.NANO_OF_SECOND, 0, 9, true).G(r18);
        f23101k = r21;
        f23102l = new DateTimeFormatterBuilder().z().a(r21).j().G(r18);
        f23103m = new DateTimeFormatterBuilder().z().a(r21).w().j().G(r18);
        DateTimeFormatter r22 = new DateTimeFormatterBuilder().z().a(r20).f('T').a(r21).G(r18).r(r110);
        f23104n = r22;
        DateTimeFormatter r23 = new DateTimeFormatterBuilder().z().a(r22).j().G(r18).r(r110);
        f23105o = r23;
        f23106p = new DateTimeFormatterBuilder().a(r23).w().f('[').A().t().f(']').G(r18).r(r110);
        f23107q = new DateTimeFormatterBuilder().a(r22).w().j().w().f('[').A().t().f(']').G(r18).r(r110);
        f23108r = new DateTimeFormatterBuilder().z().q(r11, 4, 10, r12).f('-').p(ChronoField.DAY_OF_YEAR, 3).w().j().G(r18).r(r110);
        DateTimeFormatterBuilder r24 = new DateTimeFormatterBuilder().z().q(IsoFields.f23220d, 4, 10, r12).g("-W").p(IsoFields.f23219c, 2).f('-');
        ChronoField r25 = ChronoField.DAY_OF_WEEK;
        f23109s = r24.p(r25, 1).w().j().G(r18).r(r110);
        f23110t = new DateTimeFormatterBuilder().z().d().G(r18);
        f23111u = new DateTimeFormatterBuilder().z().p(r11, 4).p(r14, 2).p(r16, 2).w().i("+HHMMss", "Z").G(r18).r(r110);
        HashMap r26 = new HashMap();
        r26.put(1L, "Mon");
        r26.put(2L, "Tue");
        r26.put(3L, "Wed");
        r26.put(4L, "Thu");
        r26.put(5L, "Fri");
        r26.put(6L, "Sat");
        r26.put(7L, "Sun");
        HashMap r117 = new HashMap();
        r117.put(1L, "Jan");
        r117.put(2L, "Feb");
        r117.put(3L, "Mar");
        r117.put(4L, "Apr");
        r117.put(5L, "May");
        r117.put(6L, "Jun");
        r117.put(7L, "Jul");
        r117.put(8L, "Aug");
        r117.put(9L, "Sep");
        r117.put(10L, "Oct");
        r117.put(11L, "Nov");
        r117.put(12L, "Dec");
        f23112v = new DateTimeFormatterBuilder().z().C().w().l(r25, r26).g(", ").v().q(r16, 1, 2, SignStyle.NOT_NEGATIVE).f(TokenParser.SP).l(r14, r117).f(TokenParser.SP).p(r11, 4).f(TokenParser.SP).p(r112, 2).f(':').p(r114, 2).w().f(':').p(r116, 2).v().f(TokenParser.SP).i("+HHMM", "GMT").G(ResolverStyle.SMART).r(r110);
        f23113w = new a();
        f23114x = new b();
    }

    public DateTimeFormatter(DateTimeFormatterBuilder.g r10, Locale r11, e r12, ResolverStyle r13, Set r14, org.threeten.bp.chrono.e r15, ZoneId r16) {
        this.f23115a = (DateTimeFormatterBuilder.g) ig.d.h(r10, "printerParser");
        this.f23116b = (Locale) ig.d.h(r11, "locale");
        this.f23117c = (e) ig.d.h(r12, "decimalStyle");
        this.f23118d = (ResolverStyle) ig.d.h(r13, "resolverStyle");
        this.f23119e = r14;
        this.f23120f = r15;
        this.f23121g = r16;
    }

    public static /* synthetic */ org.threeten.bp.format.a a(DateTimeFormatter r10, CharSequence r11, ParsePosition r12) {
        return r10.o(r11, r12);
    }

    public static /* synthetic */ org.threeten.bp.format.b.C0333b b(DateTimeFormatter r10, CharSequence r11, ParsePosition r12) {
        return r10.p(r11, r12);
    }

    public static DateTimeFormatter l(String r10) {
        return new DateTimeFormatterBuilder().k(r10).E();
    }

    public static DateTimeFormatter m(String r10, Locale r11) {
        return new DateTimeFormatterBuilder().k(r10).F(r11);
    }

    public final DateTimeParseException c(CharSequence r10, RuntimeException r11) {
        if (r10.length() <= 64) goto L5;
        String r12 = r10.subSequence(0, 64).toString() + "...";
    L7:
        return new DateTimeParseException("Text '" + r12 + "' could not be parsed: " + r11.getMessage(), r10, 0, r11);
    L5:
        r12 = r10.toString();
        goto L7
    }

    public String d(TemporalAccessor r10) {
        StringBuilder r11 = new StringBuilder(32);
        e(r10, r11);
        return r11.toString();
    }

    public void e(TemporalAccessor r10, Appendable r11) {
        ig.d.h(r10, "temporal");
        ig.d.h(r11, "appendable");
        c r12 = new c(r10, this);     // Catch: IOException -> L6
        if ((r11 instanceof StringBuilder) == false) goto L8;
        this.f23115a.print(r12, (StringBuilder) r11);     // Catch: IOException -> L6
        return;
    L8:
        StringBuilder r13 = new StringBuilder(32);     // Catch: IOException -> L6
        this.f23115a.print(r12, r13);     // Catch: IOException -> L6
        r11.append(r13);     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new DateTimeException(e.getMessage(), e);
    }

    public org.threeten.bp.chrono.e f() {
        return this.f23120f;
    }

    public e g() {
        return this.f23117c;
    }

    public Locale h() {
        return this.f23116b;
    }

    public Set i() {
        return this.f23119e;
    }

    public ResolverStyle j() {
        return this.f23118d;
    }

    public ZoneId k() {
        return this.f23121g;
    }

    public Object n(CharSequence r10, TemporalQuery r11) {
        ig.d.h(r10, "text");
        ig.d.h(r11, "type");
        return o(r10, null).n(this.f23118d, this.f23119e).d(r11);
    L7:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        throw c(r10, e);
    }

    public final org.threeten.bp.format.a o(CharSequence r10, ParsePosition r11) {
        if (r11 == null) goto L5;
        ParsePosition r12 = r11;
    L6:
        org.threeten.bp.format.b.C0333b r13 = p(r10, r12);
        if (r13 == null) goto L17;
        if (r12.getErrorIndex() >= 0) goto L17;
        if (r11 != null) goto L15;
        if (r12.getIndex() < r10.length()) goto L17;
    L15:
        return r13.b();
    L17:
        if (r10.length() <= 64) goto L19;
        String r14 = r10.subSequence(0, 64).toString() + "...";
    L21:
        if (r12.getErrorIndex() < 0) goto L25;
        throw new DateTimeParseException("Text '" + r14 + "' could not be parsed at index " + r12.getErrorIndex(), r10, r12.getErrorIndex());
    L25:
        throw new DateTimeParseException("Text '" + r14 + "' could not be parsed, unparsed text found at index " + r12.getIndex(), r10, r12.getIndex());
    L19:
        r14 = r10.toString();
        goto L21
    L5:
        r12 = new ParsePosition(0);
        goto L6
    }

    public final org.threeten.bp.format.b.C0333b p(CharSequence r10, ParsePosition r11) {
        ig.d.h(r10, "text");
        ig.d.h(r11, "position");
        org.threeten.bp.format.b r12 = new org.threeten.bp.format.b(this);
        int r13 = r11.getIndex();
        int r14 = this.f23115a.parse(r12, r10, r13);
        if (r14 >= 0) goto L6;
        r11.setErrorIndex(~r14);
        return null;
    L6:
        r11.setIndex(r14);
        return r12.v();
    }

    public DateTimeFormatterBuilder.g q(boolean r10) {
        return this.f23115a.a(r10);
    }

    public DateTimeFormatter r(org.threeten.bp.chrono.e r10) {
        if (ig.d.c(this.f23120f, r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.f23115a, this.f23116b, this.f23117c, this.f23118d, this.f23119e, r10, this.f23121g);
    }

    public DateTimeFormatter s(ResolverStyle r10) {
        ig.d.h(r10, "resolverStyle");
        if (ig.d.c(this.f23118d, r10) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.f23115a, this.f23116b, this.f23117c, r10, this.f23119e, this.f23120f, this.f23121g);
    }

    public String toString() {
        String r10 = this.f23115a.toString();
        if (r10.startsWith("[") == false) goto L6;
        return r10;
    L6:
        return r10.substring(1, r10.length() - 1);
    }
}
