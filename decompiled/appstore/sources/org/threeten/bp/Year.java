package org.threeten.bp;

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
public final class Year extends c implements Temporal, TemporalAdjuster, Comparable<Year>, Serializable {
    public static final TemporalQuery<Year> FROM = null;
    public static final int MAX_VALUE = 999999999;
    public static final int MIN_VALUE = -999999999;
    private static final DateTimeFormatter PARSER = null;
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;

    public static class a implements TemporalQuery {
        public a() {
        }

        public Year a(TemporalAccessor r10) {
            return Year.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23078a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f23079b = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23079b = r10;
            r10[ChronoUnit.YEARS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L23:
            f23079b[ChronoUnit.DECADES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            f23079b[ChronoUnit.CENTURIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L37:
            f23079b[ChronoUnit.MILLENNIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L25:
            f23079b[ChronoUnit.ERAS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L10:
            int[] r11 = new int[ChronoField.values().length];
            f23078a = r11;
            r11[ChronoField.YEAR_OF_ERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            f23078a[ChronoField.YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L35:
            f23078a[ChronoField.ERA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    static {
        FROM = new a();
        PARSER = new DateTimeFormatterBuilder().q(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).E();
    }

    private Year(int r10) {
        this.year = r10;
    }

    public static Year from(TemporalAccessor r10) {
        if ((r10 instanceof Year) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(e.from(r10)) == true) goto L9;
        r10 = LocalDate.from(r10);     // Catch: DateTimeException -> L11
    L9:
        return of(r10.get(ChronoField.YEAR));
    L12:
        throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    L5:
        return (Year) r10;
    }

    public static boolean isLeap(long r10) {
        if ((3 & r10) == 0) goto L5;
    L9:
        return false;
    L5:
        if ((r10 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r10 % 400) != 0) goto L9;
        goto L8
    }

    public static Year now() {
        return now(Clock.systemDefaultZone());
    }

    public static Year of(int r10) {
        ChronoField.YEAR.checkValidValue(r10);
        return new Year(r10);
    }

    public static Year parse(CharSequence r10) {
        return parse(r10, PARSER);
    }

    public static Year readExternal(DataInput r10) throws IOException {
        return of(r10.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        if (e.from(r10).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r10.with(ChronoField.YEAR, this.year);
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int r10) {
        return LocalDate.ofYearDay(this.year, r10);
    }

    public YearMonth atMonth(Month r10) {
        return YearMonth.of(this.year, r10);
    }

    public LocalDate atMonthDay(MonthDay r10) {
        return r10.atYear(this.year);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Year r10) {
        return compareTo2(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Year) == true) goto L8;
        return false;
    L8:
        if (this.year != ((Year) r10).year) goto L11;
        return true;
    L11:
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
        if ((r10 instanceof ChronoField) == false) goto L25;
        int r11 = b.f23078a[((ChronoField) r10).ordinal()];
        int r12 = 1;
        if (r11 != 1) goto L7;
        int r13 = this.year;
        if (r13 >= 1) goto L23;
        r13 = 1 - r13;
    L23:
        return r13;
    L7:
        if (r11 == 2) goto L18;
        if (r11 != 3) goto L16;
        if (this.year >= 1) goto L14;
        r12 = 0;
    L14:
        return r12;
    L16:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L18:
        return this.year;
    L25:
        return r10.getFrom(this);
    }

    public int getValue() {
        return this.year;
    }

    public int hashCode() {
        return this.year;
    }

    public boolean isAfter(Year r10) {
        if (this.year <= r10.year) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Year r10) {
        if (this.year >= r10.year) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 == null) goto L18;
        if (r10.isSupportedBy(this) == false) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (r10 != ChronoField.YEAR) goto L7;
        return true;
    L7:
        if (r10 != ChronoField.YEAR_OF_ERA) goto L9;
        return true;
    L9:
        if (r10 != ChronoField.ERA) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isValidMonthDay(MonthDay r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.isValidYear(this.year) == false) goto L6;
        return true;
    }

    public int length() {
        if (isLeap() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public Year minusYears(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Year this = plusYears(Long.MAX_VALUE);
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

    public Year plusYears(long r10) {
        if (r10 != 0) goto L6;
        return this;
    L6:
        return of(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r10));
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r10 != org.threeten.bp.temporal.b.e()) goto L11;
        return (R) ChronoUnit.YEARS;
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
        if (this.year > 0) goto L8;
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
        return Integer.toString(this.year);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        Year r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L25;
        long r13 = ((long) r12.year) - ((long) this.year);
        int r14 = b.f23079b[((ChronoUnit) r11).ordinal()];
        if (r14 != 1) goto L7;
        return r13;
    L7:
        if (r14 == 2) goto L23;
        if (r14 == 3) goto L21;
        if (r14 == 4) goto L19;
        if (r14 != 5) goto L17;
        ChronoField r15 = ChronoField.ERA;
        return r12.getLong(r15) - getLong(r15);
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L19:
        return r13 / 1000;
    L21:
        return r13 / 100;
    L23:
        return r13 / 10;
    L25:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeInt(this.year);
    }

    public static Year now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static Year parse(CharSequence r10, DateTimeFormatter r11) {
        d.h(r11, "formatter");
        return (Year) r11.n(r10, FROM);
    }

    public YearMonth atMonth(int r10) {
        return YearMonth.of(this.year, r10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Year r10) {
        return this.year - r10.year;
    }

    public boolean isLeap() {
        return isLeap(this.year);
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

    public static Year now(Clock r10) {
        return of(LocalDate.now(r10).getYear());
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year minus(TemporalAmount r10) {
        return (Year) r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(TemporalAmount r10) {
        return (Year) r10.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalAdjuster r10) {
        return (Year) r10.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r10) {
        if ((r10 instanceof ChronoUnit) == true) goto L5;
        if (r10 == null) goto L22;
        if (r10.isSupportedBy(this) == false) goto L22;
        return true;
    L22:
        return false;
    L5:
        if (r10 != ChronoUnit.YEARS) goto L7;
        return true;
    L7:
        if (r10 != ChronoUnit.DECADES) goto L9;
        return true;
    L9:
        if (r10 != ChronoUnit.CENTURIES) goto L11;
        return true;
    L11:
        if (r10 != ChronoUnit.MILLENNIA) goto L13;
        return true;
    L13:
        if (r10 != ChronoUnit.ERAS) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Year this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L27;
        int r12 = b.f23079b[((ChronoUnit) r11).ordinal()];
        if (r12 == 1) goto L25;
        if (r12 == 2) goto L23;
        if (r12 == 3) goto L21;
        if (r12 == 4) goto L19;
        if (r12 != 5) goto L17;
        ChronoField r13 = ChronoField.ERA;
        return with(r13, d.j(getLong(r13), r10));
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L19:
        return plusYears(d.l(r10, 1000));
    L21:
        return plusYears(d.l(r10, 100));
    L23:
        return plusYears(d.l(r10, 10));
    L25:
        return plusYears(r10);
    L27:
        return (Year) r11.addTo(this, r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L25;
        ChronoField r12 = (ChronoField) r10;
        r12.checkValidValue(r11);
        int r13 = b.f23078a[r12.ordinal()];
        if (r13 == 1) goto L20;
        if (r13 == 2) goto L18;
        if (r13 != 3) goto L16;
        if (getLong(ChronoField.ERA) != r11) goto L14;
        return this;
    L14:
        return of(1 - this.year);
    L16:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L18:
        return of((int) r11);
    L20:
        if (this.year >= 1) goto L23;
        r11 = 1 - r11;
    L23:
        return of((int) r11);
    L25:
        return (Year) r10.adjustInto(this, r11);
    }
}
