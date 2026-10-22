package org.threeten.bp;

import com.bytedance.keva.KevaImpl;
import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.c;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalDate extends org.threeten.bp.chrono.a implements Temporal, TemporalAdjuster, Serializable {
    static final long DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    public static final TemporalQuery<LocalDate> FROM = null;
    public static final LocalDate MAX = null;
    public static final LocalDate MIN = null;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;

    public static class a implements TemporalQuery {
        public a() {
        }

        public LocalDate a(TemporalAccessor r10) {
            return LocalDate.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23069a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f23070b = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23070b = r10;
            r10[ChronoUnit.DAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L76:
            f23070b[ChronoUnit.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L60:
            f23070b[ChronoUnit.MONTHS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L74:
            f23070b[ChronoUnit.YEARS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L78:
            f23070b[ChronoUnit.DECADES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L62:
            f23070b[ChronoUnit.CENTURIES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L64:
            f23070b[ChronoUnit.MILLENNIA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L90:
            f23070b[ChronoUnit.ERAS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L40
        L18:
            int[] r11 = new int[ChronoField.values().length];
            f23069a = r11;
            r11[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L84:
            f23069a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L86:
            f23069a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L58:
            f23069a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L80:
            f23069a[ChronoField.DAY_OF_WEEK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L94:
            f23069a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L46
        L54:
            f23069a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L47
        L66:
            f23069a[ChronoField.EPOCH_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L48
        L92:
            f23069a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L49
        L56:
            f23069a[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L50
        L82:
            f23069a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;     // Catch: NoSuchFieldError -> L51
        L88:
            f23069a[ChronoField.YEAR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L52
        L72:
            f23069a[ChronoField.ERA.ordinal()] = 13;     // Catch: NoSuchFieldError -> L53
            return;
        }
    }

    static {
        MIN = of(Year.MIN_VALUE, 1, 1);
        MAX = of(Year.MAX_VALUE, 12, 31);
        FROM = new a();
    }

    private LocalDate(int r10, int r11, int r12) {
        this.year = r10;
        this.month = (short) r11;
        this.day = (short) r12;
    }

    private static LocalDate create(int r10, Month r11, int r12) {
        if (r12 <= 28) goto L13;
        if (r12 <= r11.length(IsoChronology.INSTANCE.isLeapYear(r10))) goto L13;
        if (r12 != 29) goto L11;
        throw new DateTimeException("Invalid date 'February 29' as '" + r10 + "' is not a leap year");
    L11:
        throw new DateTimeException("Invalid date '" + r11.name() + " " + r12 + "'");
    L13:
        return new LocalDate(r10, r11.getValue(), r12);
    }

    public static LocalDate from(TemporalAccessor r10) {
        LocalDate r11 = (LocalDate) r10.query(org.threeten.bp.temporal.b.b());
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    }

    private int get0(TemporalField r10) {
        switch(b.f23069a[((ChronoField) r10).ordinal()]) {
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L24;
            case 7: goto L22;
            case 8: goto L20;
            case 9: goto L18;
            case 10: goto L16;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L7;
            default: goto L5;
        };
    L27:
        int r11 = this.year;
        if (r11 < 1) goto L31;
        return r11;
    L31:
        return 1 - r11;
    L5:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L7:
        if (this.year >= 1) goto L38;
        return 0;
    L38:
        return 1;
    L12:
        return this.year;
    L14:
        throw new DateTimeException("Field too large for an int: " + r10);
    L16:
        return this.month;
    L18:
        return ((getDayOfYear() - 1) / 7) + 1;
    L20:
        throw new DateTimeException("Field too large for an int: " + r10);
    L22:
        return ((getDayOfYear() - 1) % 7) + 1;
    L24:
        return ((this.day - 1) % 7) + 1;
    L26:
        return getDayOfWeek().getValue();
    L33:
        return ((this.day - 1) / 7) + 1;
    L35:
        return getDayOfYear();
    L37:
        return this.day;
    }

    private long getProlepticMonth() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    private long monthsUntil(LocalDate r10) {
        long r11 = (getProlepticMonth() * 32) + ((long) getDayOfMonth());
        return (((r10.getProlepticMonth() * 32) + ((long) r10.getDayOfMonth())) - r11) / 32;
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate of(int r10, Month r11, int r12) {
        ChronoField.YEAR.checkValidValue(r10);
        d.h(r11, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(r12);
        return create(r10, r11, r12);
    }

    public static LocalDate ofEpochDay(long r23) {
        ChronoField.EPOCH_DAY.checkValidValue(r23);
        long r10 = 719468 + r23;
        if (r10 >= 0) goto L5;
        long r11 = ((r23 + 719469) / 146097) - 1;
        long r13 = r11 * 400;
        r10 = r10 + ((-r11) * 146097);
    L6:
        long r12 = ((r10 * 400) + 591) / 146097;
        long r15 = r10 - ((((r12 * 365) + (r12 / 4)) - (r12 / 100)) + (r12 / 400));
        if (r15 >= 0) goto L9;
        r12 = r12 - 1;
        r15 = r10 - ((((365 * r12) + (r12 / 4)) - (r12 / 100)) + (r12 / 400));
    L9:
        int r14 = (int) r15;
        int r16 = ((r14 * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue((r12 + r13) + ((long) (r16 / 10))), ((r16 + 2) % 12) + 1, (r14 - (((r16 * 306) + 5) / 10)) + 1);
    L5:
        r13 = 0;
        goto L6
    }

    public static LocalDate ofYearDay(int r10, int r11) {
        long r12 = r10;
        ChronoField.YEAR.checkValidValue(r12);
        ChronoField.DAY_OF_YEAR.checkValidValue(r11);
        boolean r13 = IsoChronology.INSTANCE.isLeapYear(r12);
        if (r11 != 366) goto L8;
        if (r13 == true) goto L8;
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + r10 + "' is not a leap year");
    L8:
        Month r14 = Month.of(((r11 - 1) / 31) + 1);
        if (r11 <= ((r14.firstDayOfYear(r13) + r14.length(r13)) - 1)) goto L12;
        r14 = r14.plus(1);
    L12:
        return create(r10, r14, (r11 - r14.firstDayOfYear(r13)) + 1);
    }

    public static LocalDate parse(CharSequence r10) {
        return parse(r10, DateTimeFormatter.f23098h);
    }

    public static LocalDate readExternal(DataInput r10) throws IOException {
        return of(r10.readInt(), r10.readByte(), r10.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate resolvePreviousValid(int r10, int r11, int r12) {
        if (r11 == 2) goto L15;
        if (r11 != 4) goto L7;
    L13:
        r12 = Math.min(r12, 30);
    L20:
        return of(r10, r11, r12);
    L7:
        if (r11 == 6) goto L13;
        if (r11 == 9) goto L13;
        if (r11 == 11) goto L13;
    L15:
        if (IsoChronology.INSTANCE.isLeapYear(r10) == false) goto L17;
        int r13 = 29;
    L18:
        r12 = Math.min(r12, r13);
        goto L20
    L17:
        r13 = 28;
        goto L18
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return super.adjustInto(r10);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b atTime(LocalTime r10) {
        return atTime(r10);
    }

    @Override // org.threeten.bp.chrono.a, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return compareTo((org.threeten.bp.chrono.a) r10);
    }

    public int compareTo0(LocalDate r10) {
        int r11 = this.year - r10.year;
        if (r11 != 0) goto L8;
        int r12 = this.month - r10.month;
        if (r12 == 0) goto L7;
        return r12;
    L7:
        return this.day - r10.day;
    L8:
        return r11;
    }

    public long daysUntil(LocalDate r10) {
        return r10.toEpochDay() - toEpochDay();
    }

    @Override // org.threeten.bp.chrono.a
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LocalDate) == true) goto L8;
        return false;
    L8:
        if (compareTo0((LocalDate) r10) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // org.threeten.bp.chrono.a
    public String format(DateTimeFormatter r10) {
        return super.format(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L7;
        return get0(r10);
    L7:
        return super.get(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ e getChronology() {
        return getChronology();
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(d.f(toEpochDay() + 3, 7) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // org.threeten.bp.chrono.a
    public Era getEra() {
        return super.getEra();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        if (r10 != ChronoField.EPOCH_DAY) goto L9;
        return toEpochDay();
    L9:
        if (r10 != ChronoField.PROLEPTIC_MONTH) goto L13;
        return getProlepticMonth();
    L13:
        return get0(r10);
    L15:
        return r10.getFrom(this);
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    @Override // org.threeten.bp.chrono.a
    public int hashCode() {
        int r10 = this.year;
        short r11 = this.month;
        int r12 = r10 & (-2048);
        int r13 = (r10 << 11) + (r11 << 6);
        return r12 ^ (r13 + this.day);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isAfter(org.threeten.bp.chrono.a r10) {
        if ((r10 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r10) <= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isAfter(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isBefore(org.threeten.bp.chrono.a r10) {
        if ((r10 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r10) >= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isBefore(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isEqual(org.threeten.bp.chrono.a r10) {
        if ((r10 instanceof LocalDate) == false) goto L10;
        if (compareTo0((LocalDate) r10) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isEqual(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        return super.isSupported(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        short r10 = this.month;
        if (r10 == 2) goto L17;
        if (r10 != 4) goto L7;
        return 30;
    L7:
        if (r10 != 6) goto L9;
        return 30;
    L9:
        if (r10 != 9) goto L11;
        return 30;
    L11:
        if (r10 == 11) goto L24;
        return 31;
    L24:
        return 30;
    L17:
        if (isLeapYear() == false) goto L19;
        return 29;
    L19:
        return 28;
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public LocalDate minusDays(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDate this = plusDays(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusDays(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public LocalDate minusMonths(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDate this = plusMonths(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMonths(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public LocalDate minusWeeks(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDate this = plusWeeks(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusWeeks(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public LocalDate minusYears(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDate this = plusYears(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusYears(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public LocalDate plusDays(long r10) {
        if (r10 != 0) goto L6;
        return this;
    L6:
        return ofEpochDay(d.j(toEpochDay(), r10));
    }

    public LocalDate plusMonths(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        long r11 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + r10;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(d.d(r11, 12)), d.f(r11, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long r10) {
        return plusDays(d.l(r10, 7));
    }

    public LocalDate plusYears(long r10) {
        if (r10 != 0) goto L6;
        return this;
    L6:
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r10), this.month, this.day);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.chrono.a, ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.b()) goto L6;
        return this;
    L6:
        return (R) super.query(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L37;
        ChronoField r11 = (ChronoField) r10;
        if (r11.isDateBased() == false) goto L35;
        int r12 = b.f23069a[r11.ordinal()];
        if (r12 == 1) goto L33;
        if (r12 == 2) goto L31;
        if (r12 == 3) goto L23;
        if (r12 == 4) goto L17;
        return r10.range();
    L17:
        if (getYear() > 0) goto L20;
        long r13 = 1000000000;
    L21:
        return ValueRange.of(1, r13);
    L20:
        r13 = 999999999;
        goto L21
    L23:
        if (getMonth() == Month.FEBRUARY) goto L25;
    L27:
        long r14 = 5;
    L29:
        return ValueRange.of(1, r14);
    L25:
        if (isLeapYear() == true) goto L27;
        r14 = 4;
        goto L29
    L31:
        return ValueRange.of(1, lengthOfYear());
    L33:
        return ValueRange.of(1, lengthOfMonth());
    L35:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L37:
        return r10.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.a
    public long toEpochDay() {
        long r10 = this.year;
        long r11 = this.month;
        long r12 = 365 * r10;
        if (r10 < 0) goto L5;
        long r13 = r12 + ((((3 + r10) / 4) - ((99 + r10) / 100)) + ((r10 + 399) / 400));
    L6:
        long r14 = (r13 + (((367 * r11) - 362) / 12)) + ((long) (this.day - 1));
        if (r11 <= 2) goto L13;
        long r15 = r14 - 1;
        if (isLeapYear() == true) goto L11;
        r14 = r14 - 2;
        goto L13
    L11:
        r14 = r15;
    L13:
        return r14 - DAYS_0000_TO_1970;
    L5:
        r13 = r12 - (((r10 / (-4)) - (r10 / (-100))) + (r10 / (-400)));
        goto L6
    }

    @Override // org.threeten.bp.chrono.a
    public String toString() {
        int r10 = this.year;
        short r11 = this.month;
        short r12 = this.day;
        int r13 = Math.abs(r10);
        StringBuilder r14 = new StringBuilder(10);
        if (r13 >= 1000) goto L8;
        if (r10 >= 0) goto L6;
        r14.append(r10 - 10000);
        r14.deleteCharAt(1);
    L11:
        String r15 = "-";
        if (r11 >= 10) goto L14;
        String r16 = "-0";
    L15:
        r14.append(r16);
        r14.append(r11);
        if (r12 >= 10) goto L18;
        r15 = "-0";
    L18:
        r14.append(r15);
        r14.append(r12);
        return r14.toString();
    L14:
        r16 = "-";
        goto L15
    L6:
        r14.append(r10 + KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r14.deleteCharAt(0);
        goto L11
    L8:
        if (r10 <= 9999) goto L10;
        r14.append('+');
    L10:
        r14.append(r10);
        goto L11
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ c until(org.threeten.bp.chrono.a r10) {
        return until(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(TemporalAdjuster r10) {
        return with(r10);
    }

    public LocalDate withDayOfMonth(int r10) {
        if (this.day != r10) goto L6;
        return this;
    L6:
        return of(this.year, this.month, r10);
    }

    public LocalDate withDayOfYear(int r10) {
        if (getDayOfYear() != r10) goto L6;
        return this;
    L6:
        return ofYearDay(this.year, r10);
    }

    public LocalDate withMonth(int r10) {
        if (this.month != r10) goto L5;
        return this;
    L5:
        ChronoField.MONTH_OF_YEAR.checkValidValue(r10);
        return resolvePreviousValid(this.year, r10, this.day);
    }

    public LocalDate withYear(int r10) {
        if (this.year != r10) goto L5;
        return this;
    L5:
        ChronoField.YEAR.checkValidValue(r10);
        return resolvePreviousValid(r10, this.month, this.day);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeInt(this.year);
        r10.writeByte(this.month);
        r10.writeByte(this.day);
    }

    public static LocalDate now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static LocalDate parse(CharSequence r10, DateTimeFormatter r11) {
        d.h(r11, "formatter");
        return (LocalDate) r11.n(r10, FROM);
    }

    public ZonedDateTime atStartOfDay(ZoneId r10) {
        d.h(r10, "zone");
        LocalDateTime r11 = atTime(LocalTime.MIDNIGHT);
        if ((r10 instanceof ZoneOffset) == true) goto L10;
        ZoneOffsetTransition r12 = r10.getRules().getTransition(r11);
        if (r12 == null) goto L10;
        if (r12.isGap() == false) goto L10;
        r11 = r12.getDateTimeAfter();
    L10:
        return ZonedDateTime.of(r11, r10);
    }

    @Override // org.threeten.bp.chrono.a
    public LocalDateTime atTime(LocalTime r10) {
        return LocalDateTime.of(this, r10);
    }

    @Override // org.threeten.bp.chrono.a
    public int compareTo(org.threeten.bp.chrono.a r10) {
        if ((r10 instanceof LocalDate) == false) goto L7;
        return compareTo0((LocalDate) r10);
    L7:
        return super.compareTo(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        LocalDate r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L25;
        switch(b.f23070b[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r13 = ChronoField.ERA;
        return r12.getLong(r13) - getLong(r13);
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L11:
        return monthsUntil(r12) / 12000;
    L13:
        return monthsUntil(r12) / 1200;
    L15:
        return monthsUntil(r12) / 120;
    L17:
        return monthsUntil(r12) / 12;
    L19:
        return monthsUntil(r12);
    L21:
        return daysUntil(r12) / 7;
    L23:
        return daysUntil(r12);
    L25:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static LocalDate now(Clock r10) {
        d.h(r10, "clock");
        Instant r11 = r10.instant();
        ZoneOffset r12 = r10.getZone().getRules().getOffset(r11);
        return ofEpochDay(d.d(r11.getEpochSecond() + ((long) r12.getTotalSeconds()), 86400));
    }

    public LocalDateTime atTime(int r10, int r11) {
        return atTime(LocalTime.of(r10, r11));
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public LocalDateTime atTime(int r10, int r11, int r12) {
        return atTime(LocalTime.of(r10, r11, r12));
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static LocalDate of(int r10, int r11, int r12) {
        ChronoField.YEAR.checkValidValue(r10);
        ChronoField.MONTH_OF_YEAR.checkValidValue(r11);
        ChronoField.DAY_OF_MONTH.checkValidValue(r12);
        return create(r10, Month.of(r11), r12);
    }

    public LocalDateTime atTime(int r10, int r11, int r12, int r13) {
        return atTime(LocalTime.of(r10, r11, r12, r13));
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public LocalDate minus(TemporalAmount r10) {
        return (LocalDate) r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public LocalDate plus(TemporalAmount r10) {
        return (LocalDate) r10.addTo(this);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public LocalDate with(TemporalAdjuster r10) {
        if ((r10 instanceof LocalDate) == false) goto L7;
        return (LocalDate) r10;
    L7:
        return (LocalDate) r10.adjustInto(this);
    }

    public OffsetDateTime atTime(OffsetTime r10) {
        return OffsetDateTime.of(LocalDateTime.of(this, r10.toLocalTime()), r10.getOffset());
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public LocalDate minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDate this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public LocalDate plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L25;
        switch(b.f23070b[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r12 = ChronoField.ERA;
        return with(r12, d.j(getLong(r12), r10));
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L11:
        return plusYears(d.l(r10, 1000));
    L13:
        return plusYears(d.l(r10, 100));
    L15:
        return plusYears(d.l(r10, 10));
    L17:
        return plusYears(r10);
    L19:
        return plusMonths(r10);
    L21:
        return plusWeeks(r10);
    L23:
        return plusDays(r10);
    L25:
        return (LocalDate) r11.addTo(this, r10);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public LocalDate with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L42;
        ChronoField r12 = (ChronoField) r10;
        r12.checkValidValue(r11);
        switch(b.f23069a[r12.ordinal()]) {
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L9:
        if (getLong(ChronoField.ERA) != r11) goto L12;
        return this;
    L12:
        return withYear(1 - this.year);
    L14:
        return withYear((int) r11);
    L16:
        return plusMonths(r11 - getLong(ChronoField.PROLEPTIC_MONTH));
    L18:
        return withMonth((int) r11);
    L20:
        return plusWeeks(r11 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
    L22:
        return ofEpochDay(r11);
    L24:
        return plusDays(r11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
    L26:
        return plusDays(r11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
    L28:
        return plusDays(r11 - ((long) getDayOfWeek().getValue()));
    L30:
        if (this.year >= 1) goto L34;
        r11 = 1 - r11;
    L34:
        return withYear((int) r11);
    L36:
        return plusWeeks(r11 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
    L38:
        return withDayOfYear((int) r11);
    L40:
        return withDayOfMonth((int) r11);
    L42:
        return (LocalDate) r10.adjustInto(this, r11);
    }

    @Override // org.threeten.bp.chrono.a
    public Period until(org.threeten.bp.chrono.a r10) {
        LocalDate r11 = from(r10);
        long r12 = r11.getProlepticMonth() - getProlepticMonth();
        int r13 = r11.day - this.day;
        if (r12 <= 0) goto L6;
        if (r13 >= 0) goto L6;
        r12 = r12 - 1;
        LocalDate r14 = plusMonths(r12);
        r13 = (int) (r11.toEpochDay() - r14.toEpochDay());
    L9:
        long r15 = r12 / 12;
        int r16 = d.p(r15);
        return Period.of(r16, (int) (r12 % 12), r13);
    L6:
        if (r12 >= 0) goto L9;
        if (r13 <= 0) goto L9;
        r12 = r12 + 1;
        r13 = r13 - r11.lengthOfMonth();
        goto L9
    }
}
