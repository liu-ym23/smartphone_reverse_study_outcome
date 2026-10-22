package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> implements Serializable {
    static final LocalDate MIN_DATE = null;
    private static final long serialVersionUID = -305327627230580483L;
    private transient JapaneseEra era;
    private final LocalDate isoDate;
    private transient int yearOfEra;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23091a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23091a = r10;
            r10[ChronoField.DAY_OF_YEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f23091a[ChronoField.YEAR_OF_ERA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f23091a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f23091a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f23091a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f23091a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f23091a[ChronoField.ERA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        MIN_DATE = LocalDate.of(1873, 1, 1);
    }

    public JapaneseDate(LocalDate r10) {
        if (r10.isBefore(MIN_DATE) == true) goto L7;
        JapaneseEra r11 = JapaneseEra.from(r10);
        this.era = r11;
        this.yearOfEra = r10.getYear() - (r11.startDate().getYear() - 1);
        this.isoDate = r10;
        return;
    L7:
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    private ValueRange actualRange(int r10) {
        Calendar r11 = Calendar.getInstance(JapaneseChronology.LOCALE);
        r11.set(0, this.era.getValue() + 2);
        r11.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return ValueRange.of(r11.getActualMinimum(r10), r11.getActualMaximum(r10));
    }

    public static JapaneseDate from(TemporalAccessor r10) {
        return JapaneseChronology.INSTANCE.date(r10);
    }

    private long getDayOfYear() {
        if (this.yearOfEra != 1) goto L7;
        return (this.isoDate.getDayOfYear() - this.era.startDate().getDayOfYear()) + 1;
    L7:
        return this.isoDate.getDayOfYear();
    }

    public static JapaneseDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static JapaneseDate of(JapaneseEra r10, int r11, int r12, int r13) {
        ig.d.h(r10, "era");
        if (r11 < 1) goto L13;
        LocalDate r14 = r10.startDate();
        LocalDate r15 = r10.endDate();
        LocalDate r16 = LocalDate.of((r14.getYear() - 1) + r11, r12, r13);
        if (r16.isBefore(r14) == true) goto L11;
        if (r16.isAfter(r15) == true) goto L11;
        return new JapaneseDate(r10, r11, r16);
    L11:
        throw new DateTimeException("Requested date is outside bounds of era " + r10);
    L13:
        throw new DateTimeException("Invalid YearOfEra: " + r11);
    }

    public static JapaneseDate ofYearDay(JapaneseEra r10, int r11, int r12) {
        ig.d.h(r10, "era");
        if (r11 < 1) goto L20;
        LocalDate r13 = r10.startDate();
        LocalDate r14 = r10.endDate();
        if (r11 != 1) goto L11;
        r12 = r12 + (r13.getDayOfYear() - 1);
        if (r12 <= r13.lengthOfYear()) goto L11;
        throw new DateTimeException("DayOfYear exceeds maximum allowed in the first year of era " + r10);
    L11:
        LocalDate r15 = LocalDate.ofYearDay((r13.getYear() - 1) + r11, r12);
        if (r15.isBefore(r13) == true) goto L18;
        if (r15.isAfter(r14) == true) goto L18;
        return new JapaneseDate(r10, r11, r15);
    L18:
        throw new DateTimeException("Requested date is outside bounds of era " + r10);
    L20:
        throw new DateTimeException("Invalid YearOfEra: " + r11);
    }

    public static org.threeten.bp.chrono.a readExternal(DataInput r10) throws IOException {
        int r11 = r10.readInt();
        byte r12 = r10.readByte();
        byte r13 = r10.readByte();
        return JapaneseChronology.INSTANCE.date(r11, r12, r13);
    }

    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        JapaneseEra r11 = JapaneseEra.from(this.isoDate);
        this.era = r11;
        this.yearOfEra = this.isoDate.getYear() - (r11.startDate().getYear() - 1);
    }

    private JapaneseDate withYear(JapaneseEra r10, int r11) {
        int r12 = JapaneseChronology.INSTANCE.prolepticYear(r10, r11);
        return with(this.isoDate.withYear(r12));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public final b atTime(LocalTime r10) {
        return super.atTime(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof JapaneseDate) == true) goto L8;
        return false;
    L8:
        return this.isoDate.equals(((JapaneseDate) r10).isoDate);
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ e getChronology() {
        return getChronology();
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ Era getEra() {
        return getEra();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L17;
        switch(a.f23091a[((ChronoField) r10).ordinal()]) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        return this.isoDate.getLong(r10);
    L9:
        return this.era.getValue();
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L13:
        return this.yearOfEra;
    L15:
        return getDayOfYear();
    L17:
        return r10.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.a
    public int hashCode() {
        int r10 = getChronology().getId().hashCode();
        return this.isoDate.hashCode() ^ r10;
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if (r10 != ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) goto L5;
        return false;
    L5:
        if (r10 != ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) goto L7;
        return false;
    L7:
        if (r10 != ChronoField.ALIGNED_WEEK_OF_MONTH) goto L9;
        return false;
    L9:
        if (r10 != ChronoField.ALIGNED_WEEK_OF_YEAR) goto L12;
        return false;
    L12:
        return super.isSupported(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfYear() {
        Calendar r10 = Calendar.getInstance(JapaneseChronology.LOCALE);
        r10.set(0, this.era.getValue() + 2);
        r10.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return r10.getActualMaximum(6);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoDateImpl plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusDays(long r10) {
        return plusDays(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusMonths(long r10) {
        return plusMonths(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusYears(long r10) {
        return plusYears(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L19;
        if (isSupported(r10) == false) goto L17;
        ChronoField r11 = (ChronoField) r10;
        int r12 = a.f23091a[r11.ordinal()];
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L13;
        return getChronology().range(r11);
    L13:
        return actualRange(1);
    L15:
        return actualRange(6);
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L19:
        return r10.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.a
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal r10, TemporalUnit r11) {
        return super.until(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(TemporalAdjuster r10) {
        return with(r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeInt(get(ChronoField.YEAR));
        r10.writeByte(get(ChronoField.MONTH_OF_YEAR));
        r10.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public static JapaneseDate now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    @Override // org.threeten.bp.chrono.a
    public JapaneseChronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.a
    public JapaneseEra getEra() {
        return this.era;
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public JapaneseDate plusDays(long r10) {
        return with(this.isoDate.plusDays(r10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public JapaneseDate plusMonths(long r10) {
        return with(this.isoDate.plusMonths(r10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public JapaneseDate plusYears(long r10) {
        return with(this.isoDate.plusYears(r10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public c until(org.threeten.bp.chrono.a r10) {
        Period r11 = this.isoDate.until(r10);
        return getChronology().period(r11.getYears(), r11.getMonths(), r11.getDays());
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static JapaneseDate now(Clock r10) {
        return new JapaneseDate(LocalDate.now(r10));
    }

    private JapaneseDate withYear(int r10) {
        return withYear(getEra(), r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public JapaneseDate minus(TemporalAmount r10) {
        return (JapaneseDate) super.minus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public JapaneseDate with(TemporalAdjuster r10) {
        return (JapaneseDate) super.with(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public JapaneseDate minus(long r10, TemporalUnit r11) {
        return (JapaneseDate) super.minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public JapaneseDate plus(TemporalAmount r10) {
        return (JapaneseDate) super.plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public JapaneseDate with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L25;
        ChronoField r12 = (ChronoField) r10;
        if (getLong(r12) != r11) goto L7;
        return this;
    L7:
        int[] r13 = a.f23091a;
        int r14 = r13[r12.ordinal()];
        if (r14 == 1) goto L12;
        if (r14 == 2) goto L12;
        if (r14 == 7) goto L12;
    L17:
        return with(this.isoDate.with(r10, r11));
    L12:
        int r15 = getChronology().range(r12).checkValidIntValue(r11, r12);
        int r16 = r13[r12.ordinal()];
        if (r16 == 1) goto L23;
        if (r16 == 2) goto L21;
        if (r16 != 7) goto L17;
        return withYear(JapaneseEra.of(r15), this.yearOfEra);
    L21:
        return withYear(r15);
    L23:
        return with(this.isoDate.plusDays(((long) r15) - getDayOfYear()));
    L25:
        return (JapaneseDate) r10.adjustInto(this, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public JapaneseDate plus(long r10, TemporalUnit r11) {
        return (JapaneseDate) super.plus(r10, r11);
    }

    public JapaneseDate(JapaneseEra r10, int r11, LocalDate r12) {
        if (r12.isBefore(MIN_DATE) == true) goto L7;
        this.era = r10;
        this.yearOfEra = r11;
        this.isoDate = r12;
        return;
    L7:
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    public static JapaneseDate of(int r10, int r11, int r12) {
        return new JapaneseDate(LocalDate.of(r10, r11, r12));
    }

    private JapaneseDate with(LocalDate r10) {
        if (r10.equals(this.isoDate) == false) goto L6;
        return this;
    L6:
        return new JapaneseDate(r10);
    }
}
