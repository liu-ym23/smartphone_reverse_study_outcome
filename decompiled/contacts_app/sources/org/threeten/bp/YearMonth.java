package org.threeten.bp;

import com.android.contacts.common.compat.DirectorySdkCompat;
import com.bytedance.keva.KevaImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class YearMonth extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<YearMonth>, Serializable {
    public static final TemporalQuery<YearMonth> FROM = null;
    private static final DateTimeFormatter PARSER = null;
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    /* JADX INFO: renamed from: org.threeten.bp.YearMonth$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L39:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L51:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L35:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L41:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L13:
            int[] r5 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r5;
            r5[ChronoField.MONTH_OF_YEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L45:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L33:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L37:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L47:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
            return;
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(YearMonth r1) {
        return compareTo2(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r1) {
        return with(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    static {
        FROM = new AnonymousClass1();
        PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(ChronoField.MONTH_OF_YEAR, 2).toFormatter();
    }

    public static YearMonth now() {
        return now(Clock.systemDefaultZone());
    }

    public static YearMonth now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static YearMonth now(Clock r1) {
        LocalDate r2 = LocalDate.now(r1);
        return of(r2.getYear(), r2.getMonth());
    }

    public static YearMonth of(int r1, Month r2) {
        Jdk8Methods.requireNonNull(r2, "month");
        return of(r1, r2.getValue());
    }

    public static YearMonth of(int r3, int r4) {
        ChronoField.YEAR.checkValidValue(r3);
        ChronoField.MONTH_OF_YEAR.checkValidValue(r4);
        return new YearMonth(r3, r4);
    }

    public static YearMonth from(TemporalAccessor r3) {
        if ((r3 instanceof YearMonth) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(Chronology.from(r3)) == true) goto L9;
        r3 = LocalDate.from(r3);     // Catch: DateTimeException -> L11
    L9:
        return of(r3.get(ChronoField.YEAR), r3.get(ChronoField.MONTH_OF_YEAR));
    L12:
        throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + r3 + ", type " + r3.getClass().getName());
    L5:
        return (YearMonth) r3;
    }

    public static YearMonth parse(CharSequence r1) {
        return parse(r1, PARSER);
    }

    public static YearMonth parse(CharSequence r1, DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return (YearMonth) r2.parse(r1, FROM);
    }

    private YearMonth(int r1, int r2) {
        this.year = r1;
        this.month = r2;
    }

    private YearMonth with(int r2, int r3) {
        if (this.year != r2) goto L8;
        if (this.month != r3) goto L8;
        return this;
    L8:
        return new YearMonth(r2, r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        if ((r4 instanceof ChronoField) == true) goto L5;
        if (r4 == null) goto L22;
        if (r4.isSupportedBy(this) == false) goto L22;
        return true;
    L22:
        return false;
    L5:
        if (r4 != ChronoField.YEAR) goto L7;
        return true;
    L7:
        if (r4 != ChronoField.MONTH_OF_YEAR) goto L9;
        return true;
    L9:
        if (r4 != ChronoField.PROLEPTIC_MONTH) goto L11;
        return true;
    L11:
        if (r4 != ChronoField.YEAR_OF_ERA) goto L13;
        return true;
    L13:
        if (r4 != ChronoField.ERA) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r4) {
        if ((r4 instanceof ChronoUnit) == true) goto L5;
        if (r4 == null) goto L24;
        if (r4.isSupportedBy(this) == false) goto L24;
        return true;
    L24:
        return false;
    L5:
        if (r4 != ChronoUnit.MONTHS) goto L7;
        return true;
    L7:
        if (r4 != ChronoUnit.YEARS) goto L9;
        return true;
    L9:
        if (r4 != ChronoUnit.DECADES) goto L11;
        return true;
    L11:
        if (r4 != ChronoUnit.CENTURIES) goto L13;
        return true;
    L13:
        if (r4 != ChronoUnit.MILLENNIA) goto L15;
        return true;
    L15:
        if (r4 != ChronoUnit.ERAS) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        if (r3 != ChronoField.YEAR_OF_ERA) goto L11;
        if (getYear() > 0) goto L7;
        long r2 = DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT;
    L9:
        return ValueRange.of(1, r2);
    L7:
        r2 = 999999999;
        goto L9
    L11:
        return super.range(r3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        return range(r4).checkValidIntValue(getLong(r4), r4);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        if ((r4 instanceof ChronoField) == false) goto L33;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r4).ordinal()];
        int r1 = 1;
        if (r0 != 1) goto L7;
        int r3 = this.month;
    L23:
        return r3;
    L7:
        if (r0 == 2) goto L30;
        if (r0 != 3) goto L11;
        int r5 = this.year;
        if (r5 >= 1) goto L28;
        r5 = 1 - r5;
    L28:
        return r5;
    L11:
        if (r0 != 4) goto L13;
        r3 = this.year;
        goto L23
    L13:
        if (r0 != 5) goto L20;
        if (this.year >= 1) goto L18;
        r1 = 0;
    L18:
        return r1;
    L20:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    L30:
        return getProlepticMonth();
    L33:
        return r4.getFrom(this);
    }

    private long getProlepticMonth() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    public int getYear() {
        return this.year;
    }

    public int getMonthValue() {
        return this.month;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    public boolean isValidDay(int r2) {
        if (r2 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r2 > lengthOfMonth()) goto L7;
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
    public YearMonth with(TemporalAdjuster r1) {
        return (YearMonth) r1.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth with(TemporalField r5, long r6) {
        if ((r5 instanceof ChronoField) == false) goto L33;
        ChronoField r0 = (ChronoField) r5;
        r0.checkValidValue(r6);
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L31;
        if (r1 == 2) goto L29;
        if (r1 == 3) goto L24;
        if (r1 == 4) goto L22;
        if (r1 != 5) goto L20;
        if (getLong(ChronoField.ERA) != r6) goto L18;
        return this;
    L18:
        return withYear(1 - this.year);
    L20:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
    L22:
        return withYear((int) r6);
    L24:
        if (this.year >= 1) goto L27;
        r6 = 1 - r6;
    L27:
        return withYear((int) r6);
    L29:
        return plusMonths(r6 - getLong(ChronoField.PROLEPTIC_MONTH));
    L31:
        return withMonth((int) r6);
    L33:
        return (YearMonth) r5.adjustInto(this, r6);
    }

    public YearMonth withYear(int r4) {
        ChronoField.YEAR.checkValidValue(r4);
        return with(r4, this.month);
    }

    public YearMonth withMonth(int r4) {
        ChronoField.MONTH_OF_YEAR.checkValidValue(r4);
        return with(this.year, r4);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth plus(TemporalAmount r1) {
        return (YearMonth) r1.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth plus(long r3, TemporalUnit r5) {
        if ((r5 instanceof ChronoUnit) == false) goto L21;
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) r5).ordinal()]) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r5);
    L9:
        return with(ChronoField.ERA, Jdk8Methods.safeAdd(getLong(ChronoField.ERA), r3));
    L11:
        return plusYears(Jdk8Methods.safeMultiply(r3, 1000));
    L13:
        return plusYears(Jdk8Methods.safeMultiply(r3, 100));
    L15:
        return plusYears(Jdk8Methods.safeMultiply(r3, 10));
    L17:
        return plusYears(r3);
    L19:
        return plusMonths(r3);
    L21:
        return (YearMonth) r5.addTo(this, r3);
    }

    public YearMonth plusYears(long r4) {
        if (r4 != 0) goto L6;
        return this;
    L6:
        return with(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r4), this.month);
    }

    public YearMonth plusMonths(long r7) {
        if (r7 != 0) goto L5;
        return this;
    L5:
        long r0 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + r7;
        return with(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(r0, 12)), Jdk8Methods.floorMod(r0, 12) + 1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth minus(TemporalAmount r1) {
        return (YearMonth) r1.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth minus(long r3, TemporalUnit r5) {
        if (r3 != Long.MIN_VALUE) goto L5;
        YearMonth this = plus(Long.MAX_VALUE, r5);
        long r4 = 1;
    L7:
        return this.plus(r4, r5);
    L5:
        r4 = -r3;
        goto L7
    }

    public YearMonth minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        YearMonth this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public YearMonth minusMonths(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        YearMonth this = plusMonths(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMonths(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.chronology()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r2 != TemporalQueries.precision()) goto L11;
        return (R) ChronoUnit.MONTHS;
    L11:
        if (r2 != TemporalQueries.localDate()) goto L13;
        return null;
    L13:
        if (r2 != TemporalQueries.localTime()) goto L15;
        return null;
    L15:
        if (r2 != TemporalQueries.zone()) goto L17;
        return null;
    L17:
        if (r2 != TemporalQueries.zoneId()) goto L19;
        return null;
    L19:
        if (r2 != TemporalQueries.offset()) goto L22;
        return null;
    L22:
        return (R) super.query(r2);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        if (Chronology.from(r4).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r4.with(ChronoField.PROLEPTIC_MONTH, getProlepticMonth());
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r5, TemporalUnit r6) {
        YearMonth r7 = from(r5);
        if ((r6 instanceof ChronoUnit) == false) goto L19;
        long r0 = r7.getProlepticMonth() - getProlepticMonth();
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) r6).ordinal()]) {
            case 1: goto L20;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            default: goto L7;
        };
    L20:
        return r0;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r6);
    L9:
        return r7.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
    L11:
        return r0 / 12000;
    L13:
        return r0 / 1200;
    L15:
        return r0 / 120;
    L17:
        return r0 / 12;
    L19:
        return r6.between(this, r7);
    }

    public LocalDate atDay(int r2) {
        return LocalDate.of(this.year, this.month, r2);
    }

    public LocalDate atEndOfMonth() {
        return LocalDate.of(this.year, this.month, lengthOfMonth());
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(YearMonth r3) {
        int r0 = this.year - r3.year;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.month - r3.month;
    }

    public boolean isAfter(YearMonth r1) {
        if (compareTo2(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(YearMonth r1) {
        if (compareTo2(r1) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof YearMonth) == false) goto L14;
        YearMonth r6 = (YearMonth) r5;
        if (this.year != r6.year) goto L13;
        if (this.month != r6.month) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.year;
        return (this.month << 27) ^ r0;
    }

    public String toString() {
        int r0 = Math.abs(this.year);
        StringBuilder r1 = new StringBuilder(9);
        if (r0 >= 1000) goto L8;
        int r2 = this.year;
        if (r2 >= 0) goto L7;
        r1.append(r2 - 10000).deleteCharAt(1);
    L10:
        if (this.month >= 10) goto L12;
        String r3 = "-0";
    L14:
        return r1.append(r3).append(this.month).toString();
    L12:
        r3 = "-";
        goto L14
    L7:
        r1.append(r2 + KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD).deleteCharAt(0);
        goto L10
    L8:
        r1.append(this.year);
        goto L10
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r2) throws IOException {
        r2.writeInt(this.year);
        r2.writeByte(this.month);
    }

    static YearMonth readExternal(DataInput r1) throws IOException {
        return of(r1.readInt(), r1.readByte());
    }
}
