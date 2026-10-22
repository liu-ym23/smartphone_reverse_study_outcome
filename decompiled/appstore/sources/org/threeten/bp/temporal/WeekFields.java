package org.threeten.bp.temporal;

import ig.d;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes4.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> CACHE = null;
    public static final WeekFields ISO = null;
    public static final WeekFields SUNDAY_START = null;
    private static final long serialVersionUID = -1177360819670808121L;
    private final transient TemporalField dayOfWeek;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField weekBasedYear;
    private final transient TemporalField weekOfMonth;
    private final transient TemporalField weekOfWeekBasedYear;
    private final transient TemporalField weekOfYear;

    public static class a implements TemporalField {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ValueRange f23224f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final ValueRange f23225g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final ValueRange f23226h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final ValueRange f23227i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ValueRange f23228j = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeekFields f23230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TemporalUnit f23231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TemporalUnit f23232d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ValueRange f23233e;

        static {
            f23224f = ValueRange.of(1, 7);
            f23225g = ValueRange.of(0, 1, 4, 6);
            f23226h = ValueRange.of(0, 1, 52, 54);
            f23227i = ValueRange.of(1, 52, 53);
            f23228j = ChronoField.YEAR.range();
        }

        public a(String r10, WeekFields r11, TemporalUnit r12, TemporalUnit r13, ValueRange r14) {
            this.f23229a = r10;
            this.f23230b = r11;
            this.f23231c = r12;
            this.f23232d = r13;
            this.f23233e = r14;
        }

        public static a g(WeekFields r10) {
            return new a("DayOfWeek", r10, ChronoUnit.DAYS, ChronoUnit.WEEKS, f23224f);
        }

        public static a h(WeekFields r10) {
            return new a("WeekBasedYear", r10, IsoFields.f23221e, ChronoUnit.FOREVER, f23228j);
        }

        public static a i(WeekFields r10) {
            return new a("WeekOfMonth", r10, ChronoUnit.WEEKS, ChronoUnit.MONTHS, f23225g);
        }

        public static a j(WeekFields r10) {
            return new a("WeekOfWeekBasedYear", r10, ChronoUnit.WEEKS, IsoFields.f23221e, f23227i);
        }

        public static a k(WeekFields r10) {
            return new a("WeekOfYear", r10, ChronoUnit.WEEKS, ChronoUnit.YEARS, f23226h);
        }

        public final int a(int r10, int r11) {
            return ((r10 + 7) + (r11 - 1)) / 7;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public Temporal adjustInto(Temporal r10, long r11) {
            int r12 = this.f23233e.checkValidIntValue(r11, this);
            int r13 = r10.get(this);
            if (r12 != r13) goto L6;
            return r10;
        L6:
            if (this.f23232d != ChronoUnit.FOREVER) goto L19;
            int r14 = r10.get(WeekFields.access$000(this.f23230b));
            long r15 = (long) ((r11 - ((long) r13)) * 52.1775d);
            ChronoUnit r16 = ChronoUnit.WEEKS;
            Temporal r17 = r10.plus(r15, r16);
            if (r17.get(this) <= r12) goto L11;
            return r17.minus(r17.get(WeekFields.access$000(this.f23230b)), r16);
        L11:
            if (r17.get(this) >= r12) goto L13;
            r17 = r17.plus(2, r16);
        L13:
            Temporal r18 = r17.plus(r14 - r17.get(WeekFields.access$000(this.f23230b)), r16);
            if (r18.get(this) <= r12) goto L17;
            return r18.minus(1, r16);
        L17:
            return r18;
        L19:
            return r10.plus(r12 - r13, this.f23231c);
        }

        public final int b(TemporalAccessor r10, int r11) {
            return d.e(r10.get(ChronoField.DAY_OF_WEEK) - r11, 7) + 1;
        }

        public final int c(TemporalAccessor r10) {
            int r11 = d.e(r10.get(ChronoField.DAY_OF_WEEK) - this.f23230b.getFirstDayOfWeek().getValue(), 7) + 1;
            int r12 = r10.get(ChronoField.YEAR);
            long r13 = f(r10, r11);
            if (r13 != 0) goto L7;
            return r12 - 1;
        L7:
            if (r13 >= 53) goto L9;
            return r12;
        L9:
            int r14 = m(r10.get(ChronoField.DAY_OF_YEAR), r11);
            if (Year.isLeap(r12) == false) goto L12;
            int r15 = 366;
        L14:
            if (r13 >= a(r14, r15 + this.f23230b.getMinimalDaysInFirstWeek())) goto L16;
            return r12;
        L16:
            return r12 + 1;
        L12:
            r15 = 365;
            goto L14
        }

        public final int d(TemporalAccessor r10) {
            int r11 = d.e(r10.get(ChronoField.DAY_OF_WEEK) - this.f23230b.getFirstDayOfWeek().getValue(), 7) + 1;
            long r12 = f(r10, r11);
            if (r12 != 0) goto L7;
            return ((int) f(e.from(r10).date(r10).minus(1, ChronoUnit.WEEKS), r11)) + 1;
        L7:
            if (r12 < 53) goto L17;
            int r13 = m(r10.get(ChronoField.DAY_OF_YEAR), r11);
            if (Year.isLeap(r10.get(ChronoField.YEAR)) == false) goto L11;
            int r14 = 366;
        L12:
            int r15 = a(r13, r14 + this.f23230b.getMinimalDaysInFirstWeek());
            if (r12 < r15) goto L17;
            return (int) (r12 - ((long) (r15 - 1)));
        L11:
            r14 = 365;
        L17:
            return (int) r12;
        }

        public final long e(TemporalAccessor r10, int r11) {
            int r12 = r10.get(ChronoField.DAY_OF_MONTH);
            return a(m(r12, r11), r12);
        }

        public final long f(TemporalAccessor r10, int r11) {
            int r12 = r10.get(ChronoField.DAY_OF_YEAR);
            return a(m(r12, r11), r12);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getBaseUnit() {
            return this.f23231c;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public String getDisplayName(Locale r10) {
            d.h(r10, "locale");
            if (this.f23232d != ChronoUnit.YEARS) goto L7;
            return "Week";
        L7:
            return toString();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public long getFrom(TemporalAccessor r10) {
            int r11 = d.e(r10.get(ChronoField.DAY_OF_WEEK) - this.f23230b.getFirstDayOfWeek().getValue(), 7) + 1;
            TemporalUnit r12 = this.f23232d;
            if (r12 != ChronoUnit.WEEKS) goto L7;
            return r11;
        L7:
            if (r12 != ChronoUnit.MONTHS) goto L12;
            int r13 = r10.get(ChronoField.DAY_OF_MONTH);
            int r14 = a(m(r13, r11), r13);
        L10:
            return r14;
        L12:
            if (r12 != ChronoUnit.YEARS) goto L15;
            int r15 = r10.get(ChronoField.DAY_OF_YEAR);
            r14 = a(m(r15, r11), r15);
            goto L10
        L15:
            if (r12 != IsoFields.f23221e) goto L18;
            r14 = d(r10);
            goto L10
        L18:
            if (r12 != ChronoUnit.FOREVER) goto L21;
            r14 = c(r10);
            goto L10
        L21:
            throw new IllegalStateException("unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getRangeUnit() {
            return this.f23232d;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor r10) {
            if (r10.isSupported(ChronoField.DAY_OF_WEEK) == false) goto L24;
            TemporalUnit r11 = this.f23232d;
            if (r11 != ChronoUnit.WEEKS) goto L9;
            return true;
        L9:
            if (r11 != ChronoUnit.MONTHS) goto L13;
            return r10.isSupported(ChronoField.DAY_OF_MONTH);
        L13:
            if (r11 != ChronoUnit.YEARS) goto L17;
            return r10.isSupported(ChronoField.DAY_OF_YEAR);
        L17:
            if (r11 != IsoFields.f23221e) goto L21;
            return r10.isSupported(ChronoField.EPOCH_DAY);
        L21:
            if (r11 == ChronoUnit.FOREVER) goto L23;
            return false;
        L23:
            return r10.isSupported(ChronoField.EPOCH_DAY);
        L24:
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        public final ValueRange l(TemporalAccessor r10) {
            int r11 = d.e(r10.get(ChronoField.DAY_OF_WEEK) - this.f23230b.getFirstDayOfWeek().getValue(), 7) + 1;
            long r12 = f(r10, r11);
            if (r12 == 0) goto L5;
            int r13 = m(r10.get(ChronoField.DAY_OF_YEAR), r11);
            if (Year.isLeap(r10.get(ChronoField.YEAR)) == false) goto L9;
            int r14 = 366;
        L10:
            int r15 = a(r13, r14 + this.f23230b.getMinimalDaysInFirstWeek());
            if (r12 < r15) goto L15;
            return l(e.from(r10).date(r10).plus(2, ChronoUnit.WEEKS));
        L15:
            return ValueRange.of(1, r15 - 1);
        L9:
            r14 = 365;
            goto L10
        L5:
            return l(e.from(r10).date(r10).minus(2, ChronoUnit.WEEKS));
        }

        public final int m(int r10, int r11) {
            int r12 = d.e(r10 - r11, 7);
            int r13 = -r12;
            if ((r12 + 1) > this.f23230b.getMinimalDaysInFirstWeek()) goto L5;
            return r13;
        L5:
            return 7 - r12;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange range() {
            return this.f23233e;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor r10) {
            TemporalUnit r11 = this.f23232d;
            if (r11 != ChronoUnit.WEEKS) goto L7;
            return this.f23233e;
        L7:
            if (r11 != ChronoUnit.MONTHS) goto L10;
            ChronoField r12 = ChronoField.DAY_OF_MONTH;
        L12:
            int r13 = m(r10.get(r12), d.e(r10.get(ChronoField.DAY_OF_WEEK) - this.f23230b.getFirstDayOfWeek().getValue(), 7) + 1);
            ValueRange r14 = r10.range(r12);
            return ValueRange.of(a(r13, (int) r14.getMinimum()), a(r13, (int) r14.getMaximum()));
        L10:
            if (r11 != ChronoUnit.YEARS) goto L15;
            r12 = ChronoField.DAY_OF_YEAR;
            goto L12
        L15:
            if (r11 != IsoFields.f23221e) goto L19;
            return l(r10);
        L19:
            if (r11 != ChronoUnit.FOREVER) goto L23;
            return r10.range(ChronoField.YEAR);
        L23:
            throw new IllegalStateException("unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map r19, TemporalAccessor r20, ResolverStyle r21) {
            int r10 = this.f23230b.getFirstDayOfWeek().getValue();
            if (this.f23232d != ChronoUnit.WEEKS) goto L6;
            r19.put(ChronoField.DAY_OF_WEEK, Long.valueOf(d.e((r10 - 1) + (this.f23233e.checkValidIntValue(((Long) r19.remove(this)).longValue(), this) - 1), 7) + 1));
            return null;
        L6:
            ChronoField r11 = ChronoField.DAY_OF_WEEK;
            if (r19.containsKey(r11) == true) goto L10;
            return null;
        L10:
            if (this.f23232d == ChronoUnit.FOREVER) goto L12;
            ChronoField r12 = ChronoField.YEAR;
            if (r19.containsKey(r12) == true) goto L31;
            return null;
        L31:
            int r13 = d.e(r11.checkValidIntValue(((Long) r19.get(r11)).longValue()) - r10, 7) + 1;
            int r14 = r12.checkValidIntValue(((Long) r19.get(r12)).longValue());
            e r15 = e.from(r20);
            TemporalUnit r16 = this.f23232d;
            ChronoUnit r17 = ChronoUnit.MONTHS;
            if (r16 != r17) goto L50;
            ChronoField r18 = ChronoField.MONTH_OF_YEAR;
            if (r19.containsKey(r18) == true) goto L36;
            return null;
        L36:
            long r110 = ((Long) r19.remove(this)).longValue();
            if (r21 != ResolverStyle.LENIENT) goto L39;
            org.threeten.bp.chrono.a r22 = r15.date(r14, 1, 1).plus(((Long) r19.get(r18)).longValue() - 1, r17);
            int r23 = b(r22, r10);
            long r111 = ((r110 - e(r22, r23)) * 7) + ((long) (r13 - r23));
        L40:
            org.threeten.bp.chrono.a r24 = r22.plus(r111, ChronoUnit.DAYS);
            if (r21 == ResolverStyle.STRICT) goto L43;
        L47:
            r19.remove(this);
            r19.remove(r12);
            r19.remove(r18);
            r19.remove(r11);
            return r24;
        L43:
            if (r24.getLong(r18) == ((Long) r19.get(r18)).longValue()) goto L47;
            throw new DateTimeException("Strict mode rejected date parsed to a different month");
        L39:
            r22 = r15.date(r14, r18.checkValidIntValue(((Long) r19.get(r18)).longValue()), 8);
            int r25 = b(r22, r10);
            r111 = ((long) (r13 - r25)) + ((((long) this.f23233e.checkValidIntValue(r110, this)) - e(r22, r25)) * 7);
            goto L40
        L50:
            if (r16 != ChronoUnit.YEARS) goto L66;
            long r112 = ((Long) r19.remove(this)).longValue();
            org.threeten.bp.chrono.a r26 = r15.date(r14, 1, 1);
            if (r21 != ResolverStyle.LENIENT) goto L55;
            int r27 = b(r26, r10);
            long r113 = r112 - f(r26, r27);
            long r28 = 7;
        L56:
            org.threeten.bp.chrono.a r29 = r26.plus((r113 * r28) + ((long) (r13 - r27)), ChronoUnit.DAYS);
            if (r21 == ResolverStyle.STRICT) goto L59;
        L63:
            r19.remove(this);
            r19.remove(r12);
            r19.remove(r11);
            return r29;
        L59:
            if (r29.getLong(r12) == ((Long) r19.get(r12)).longValue()) goto L63;
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        L55:
            r28 = 7;
            r27 = b(r26, r10);
            r113 = ((long) this.f23233e.checkValidIntValue(r112, this)) - f(r26, r27);
            goto L56
        L66:
            throw new IllegalStateException("unreachable");
        L12:
            if (r19.containsKey(WeekFields.access$000(this.f23230b)) == true) goto L14;
            return null;
        L14:
            e r30 = e.from(r20);
            int r31 = d.e(r11.checkValidIntValue(((Long) r19.get(r11)).longValue()) - r10, 7) + 1;
            int r32 = range().checkValidIntValue(((Long) r19.get(this)).longValue(), this);
            if (r21 != ResolverStyle.LENIENT) goto L18;
            org.threeten.bp.chrono.a r33 = r30.date(r32, 1, this.f23230b.getMinimalDaysInFirstWeek());
            long r34 = ((Long) r19.get(WeekFields.access$000(this.f23230b))).longValue();
            int r35 = b(r33, r10);
            long r114 = f(r33, r35);
        L19:
            org.threeten.bp.chrono.a r36 = r33.plus(((r34 - r114) * 7) + ((long) (r31 - r35)), ChronoUnit.DAYS);
            if (r21 == ResolverStyle.STRICT) goto L22;
        L26:
            r19.remove(this);
            r19.remove(WeekFields.access$000(this.f23230b));
            r19.remove(r11);
            return r36;
        L22:
            if (r36.getLong(this) == ((Long) r19.get(this)).longValue()) goto L26;
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        L18:
            r33 = r30.date(r32, 1, this.f23230b.getMinimalDaysInFirstWeek());
            r34 = WeekFields.access$000(this.f23230b).range().checkValidIntValue(((Long) r19.get(WeekFields.access$000(this.f23230b))).longValue(), WeekFields.access$000(this.f23230b));
            r35 = b(r33, r10);
            r114 = f(r33, r35);
            goto L19
        }

        public String toString() {
            return this.f23229a + "[" + this.f23230b.toString() + "]";
        }
    }

    static {
        CACHE = new ConcurrentHashMap(4, 0.75f, 2);
        ISO = new WeekFields(DayOfWeek.MONDAY, 4);
        SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    }

    private WeekFields(DayOfWeek r10, int r11) {
        this.dayOfWeek = a.g(this);
        this.weekOfMonth = a.i(this);
        this.weekOfYear = a.k(this);
        this.weekOfWeekBasedYear = a.j(this);
        this.weekBasedYear = a.h(this);
        d.h(r10, "firstDayOfWeek");
        if (r11 < 1) goto L9;
        if (r11 > 7) goto L9;
        this.firstDayOfWeek = r10;
        this.minimalDays = r11;
        return;
    L9:
        throw new IllegalArgumentException("Minimal number of days is invalid");
    }

    public static /* synthetic */ TemporalField access$000(WeekFields r10) {
        return r10.weekOfWeekBasedYear;
    }

    public static WeekFields of(Locale r10) {
        d.h(r10, "locale");
        GregorianCalendar r11 = new GregorianCalendar(new Locale(r10.getLanguage(), r10.getCountry()));
        return of(DayOfWeek.SUNDAY.plus(r11.getFirstDayOfWeek() - 1), r11.getMinimalDaysInFirstWeek());
    }

    private Object readResolve() throws InvalidObjectException {
        return of(this.firstDayOfWeek, this.minimalDays);
    L4:
        e = move-exception;
        throw new InvalidObjectException("Invalid WeekFields" + e.getMessage());
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WeekFields) == true) goto L8;
        return false;
    L8:
        if (hashCode() != r10.hashCode()) goto L11;
        return true;
    L11:
        return false;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + this.firstDayOfWeek + ',' + this.minimalDays + ']';
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public TemporalField weekOfYear() {
        return this.weekOfYear;
    }

    public static WeekFields of(DayOfWeek r10, int r11) {
        String r12 = r10.toString() + r11;
        ConcurrentMap<String, WeekFields> r13 = CACHE;
        WeekFields r14 = r13.get(r12);
        if (r14 != null) goto L6;
        r13.putIfAbsent(r12, new WeekFields(r10, r11));
        return r13.get(r12);
    L6:
        return r14;
    }
}
