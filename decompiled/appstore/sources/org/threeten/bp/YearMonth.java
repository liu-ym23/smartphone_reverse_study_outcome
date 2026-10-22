package org.threeten.bp;

import com.bytedance.keva.KevaImpl;
import ig.c;
import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
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

/* JADX INFO: loaded from: classes4.dex */
public final class YearMonth extends c implements Temporal, TemporalAdjuster, Comparable<YearMonth>, Serializable {
    public static final TemporalQuery<YearMonth> FROM = null;
    private static final DateTimeFormatter PARSER = null;
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    public static class a implements TemporalQuery {
        public a() {
        }

        public YearMonth a(TemporalAccessor r10) {
            return YearMonth.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23080a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f23081b = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23081b = r10;
            r10[ChronoUnit.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            f23081b[ChronoUnit.YEARS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L39:
            f23081b[ChronoUnit.DECADES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L51:
            f23081b[ChronoUnit.CENTURIES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L35:
            f23081b[ChronoUnit.MILLENNIA.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L41:
            f23081b[ChronoUnit.ERAS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L13:
            int[] r11 = new int[ChronoField.values().length];
            f23080a = r11;
            r11[ChronoField.MONTH_OF_YEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L45:
            f23080a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L33:
            f23080a[ChronoField.YEAR_OF_ERA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L37:
            f23080a[ChronoField.YEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L47:
            f23080a[ChronoField.ERA.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
            return;
        }
    }

    static {
        FROM = new a();
        PARSER = new DateTimeFormatterBuilder().q(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).f('-').p(ChronoField.MONTH_OF_YEAR, 2).E();
    }

    private YearMonth(int r10, int r11) {
        this.year = r10;
        this.month = r11;
    }

    public static YearMonth from(TemporalAccessor r10) {
        if ((r10 instanceof YearMonth) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(e.from(r10)) == true) goto L9;
        r10 = LocalDate.from(r10);     // Catch: DateTimeException -> L11
    L9:
        return of(r10.get(ChronoField.YEAR), r10.get(ChronoField.MONTH_OF_YEAR));
    L12:
        throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    L5:
        return (YearMonth) r10;
    }

    private long getProlepticMonth() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    public static YearMonth now() {
        return now(Clock.systemDefaultZone());
    }

    public static YearMonth of(int r10, Month r11) {
        d.h(r11, "month");
        return of(r10, r11.getValue());
    }

    public static YearMonth parse(CharSequence r10) {
        return parse(r10, PARSER);
    }

    public static YearMonth readExternal(DataInput r10) throws IOException {
        return of(r10.readInt(), r10.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        if (e.from(r10).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r10.with(ChronoField.PROLEPTIC_MONTH, getProlepticMonth());
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int r10) {
        return LocalDate.of(this.year, this.month, r10);
    }

    public LocalDate atEndOfMonth() {
        return LocalDate.of(this.year, this.month, lengthOfMonth());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(YearMonth r10) {
        return compareTo2(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof YearMonth) == false) goto L14;
        YearMonth r11 = (YearMonth) r10;
        if (this.year != r11.year) goto L13;
        if (this.month != r11.month) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String format(DateTimeFormatter r10) {
        d.h(r10, "formatter");
        return r10.d(this);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        return range(r10).checkValidIntValue(getLong(r10), r10);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L33;
        int r11 = b.f23080a[((ChronoField) r10).ordinal()];
        int r12 = 1;
        if (r11 != 1) goto L7;
        int r13 = this.month;
    L23:
        return r13;
    L7:
        if (r11 == 2) goto L30;
        if (r11 != 3) goto L11;
        int r14 = this.year;
        if (r14 >= 1) goto L28;
        r14 = 1 - r14;
    L28:
        return r14;
    L11:
        if (r11 != 4) goto L13;
        r13 = this.year;
        goto L23
    L13:
        if (r11 != 5) goto L20;
        if (this.year >= 1) goto L18;
        r12 = 0;
    L18:
        return r12;
    L20:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L30:
        return getProlepticMonth();
    L33:
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

    public int hashCode() {
        int r10 = this.year;
        return (this.month << 27) ^ r10;
    }

    public boolean isAfter(YearMonth r10) {
        if (compareTo2(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(YearMonth r10) {
        if (compareTo2(r10) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 == null) goto L22;
        if (r10.isSupportedBy(this) == false) goto L22;
        return true;
    L22:
        return false;
    L5:
        if (r10 != ChronoField.YEAR) goto L7;
        return true;
    L7:
        if (r10 != ChronoField.MONTH_OF_YEAR) goto L9;
        return true;
    L9:
        if (r10 != ChronoField.PROLEPTIC_MONTH) goto L11;
        return true;
    L11:
        if (r10 != ChronoField.YEAR_OF_ERA) goto L13;
        return true;
    L13:
        if (r10 != ChronoField.ERA) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean isValidDay(int r10) {
        if (r10 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r10 > lengthOfMonth()) goto L7;
        return true;
    }

    public int lengthOfMonth() {
        return getMonth().length(isLeapYear());
    }

    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public YearMonth minusMonths(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        YearMonth this = plusMonths(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMonths(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public YearMonth minusYears(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        YearMonth this = plusYears(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusYears(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public YearMonth plusMonths(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        long r11 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + r10;
        return with(ChronoField.YEAR.checkValidIntValue(d.d(r11, 12)), d.f(r11, 12) + 1);
    }

    public YearMonth plusYears(long r10) {
        if (r10 != 0) goto L6;
        return this;
    L6:
        return with(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r10), this.month);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r10 != org.threeten.bp.temporal.b.e()) goto L11;
        return (R) ChronoUnit.MONTHS;
    L11:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L13;
        return null;
    L13:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L15;
        return null;
    L15:
        if (r10 != org.threeten.bp.temporal.b.f()) goto L17;
        return null;
    L17:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L19;
        return null;
    L19:
        if (r10 != org.threeten.bp.temporal.b.d()) goto L22;
        return null;
    L22:
        return (R) super.query(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if (r10 != ChronoField.YEAR_OF_ERA) goto L11;
        if (getYear() > 0) goto L8;
        long r11 = 1000000000;
    L9:
        return ValueRange.of(1, r11);
    L8:
        r11 = 999999999;
        goto L9
    L11:
        return super.range(r10);
    }

    public String toString() {
        int r10 = Math.abs(this.year);
        StringBuilder r11 = new StringBuilder(9);
        if (r10 >= 1000) goto L8;
        int r12 = this.year;
        if (r12 >= 0) goto L7;
        r11.append(r12 - 10000);
        r11.deleteCharAt(1);
    L10:
        if (this.month >= 10) goto L12;
        String r13 = "-0";
    L13:
        r11.append(r13);
        r11.append(this.month);
        return r11.toString();
    L12:
        r13 = "-";
        goto L13
    L7:
        r11.append(r12 + KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r11.deleteCharAt(0);
        goto L10
    L8:
        r11.append(this.year);
        goto L10
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        YearMonth r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L19;
        long r13 = r12.getProlepticMonth() - getProlepticMonth();
        switch(b.f23081b[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L20;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r14 = ChronoField.ERA;
        return r12.getLong(r14) - getLong(r14);
    L20:
        return r13;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L11:
        return r13 / 12000;
    L13:
        return r13 / 1200;
    L15:
        return r13 / 120;
    L17:
        return r13 / 12;
    L19:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public YearMonth withMonth(int r10) {
        ChronoField.MONTH_OF_YEAR.checkValidValue(r10);
        return with(this.year, r10);
    }

    public YearMonth withYear(int r10) {
        ChronoField.YEAR.checkValidValue(r10);
        return with(r10, this.month);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeInt(this.year);
        r10.writeByte(this.month);
    }

    public static YearMonth now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static YearMonth parse(CharSequence r10, DateTimeFormatter r11) {
        d.h(r11, "formatter");
        return (YearMonth) r11.n(r10, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(YearMonth r10) {
        int r11 = this.year - r10.year;
        if (r11 == 0) goto L5;
        return r11;
    L5:
        return this.month - r10.month;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static YearMonth now(Clock r10) {
        LocalDate r11 = LocalDate.now(r10);
        return of(r11.getYear(), r11.getMonth());
    }

    public static YearMonth of(int r10, int r11) {
        ChronoField.YEAR.checkValidValue(r10);
        ChronoField.MONTH_OF_YEAR.checkValidValue(r11);
        return new YearMonth(r10, r11);
    }

    private YearMonth with(int r10, int r11) {
        if (this.year != r10) goto L8;
        if (this.month != r11) goto L8;
        return this;
    L8:
        return new YearMonth(r10, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth minus(TemporalAmount r10) {
        return (YearMonth) r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth plus(TemporalAmount r10) {
        return (YearMonth) r10.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r10) {
        if ((r10 instanceof ChronoUnit) == true) goto L5;
        if (r10 == null) goto L24;
        if (r10.isSupportedBy(this) == false) goto L24;
        return true;
    L24:
        return false;
    L5:
        if (r10 != ChronoUnit.MONTHS) goto L7;
        return true;
    L7:
        if (r10 != ChronoUnit.YEARS) goto L9;
        return true;
    L9:
        if (r10 != ChronoUnit.DECADES) goto L11;
        return true;
    L11:
        if (r10 != ChronoUnit.CENTURIES) goto L13;
        return true;
    L13:
        if (r10 != ChronoUnit.MILLENNIA) goto L15;
        return true;
    L15:
        if (r10 != ChronoUnit.ERAS) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        YearMonth this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L21;
        switch(b.f23081b[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L8;
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
        return (YearMonth) r11.addTo(this, r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth with(TemporalAdjuster r10) {
        return (YearMonth) r10.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L33;
        ChronoField r12 = (ChronoField) r10;
        r12.checkValidValue(r11);
        int r13 = b.f23080a[r12.ordinal()];
        if (r13 == 1) goto L31;
        if (r13 == 2) goto L29;
        if (r13 == 3) goto L24;
        if (r13 == 4) goto L22;
        if (r13 != 5) goto L20;
        if (getLong(ChronoField.ERA) != r11) goto L18;
        return this;
    L18:
        return withYear(1 - this.year);
    L20:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L22:
        return withYear((int) r11);
    L24:
        if (this.year >= 1) goto L27;
        r11 = 1 - r11;
    L27:
        return withYear((int) r11);
    L29:
        return plusMonths(r11 - getLong(ChronoField.PROLEPTIC_MONTH));
    L31:
        return withMonth((int) r11);
    L33:
        return (YearMonth) r10.adjustInto(this, r11);
    }
}
