package org.threeten.bp.temporal;

import com.android.common.speech.LoggingEvents;
import com.android.contacts.common.compat.DirectorySdkCompat;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes5.dex */
public final enum ChronoField extends Enum<ChronoField> implements TemporalField {
    private static final /* synthetic */ ChronoField[] $VALUES = null;
    public static final ChronoField ALIGNED_DAY_OF_WEEK_IN_MONTH = null;
    public static final ChronoField ALIGNED_DAY_OF_WEEK_IN_YEAR = null;
    public static final ChronoField ALIGNED_WEEK_OF_MONTH = null;
    public static final ChronoField ALIGNED_WEEK_OF_YEAR = null;
    public static final ChronoField AMPM_OF_DAY = null;
    public static final ChronoField CLOCK_HOUR_OF_AMPM = null;
    public static final ChronoField CLOCK_HOUR_OF_DAY = null;
    public static final ChronoField DAY_OF_MONTH = null;
    public static final ChronoField DAY_OF_WEEK = null;
    public static final ChronoField DAY_OF_YEAR = null;
    public static final ChronoField EPOCH_DAY = null;
    public static final ChronoField ERA = null;
    public static final ChronoField HOUR_OF_AMPM = null;
    public static final ChronoField HOUR_OF_DAY = null;
    public static final ChronoField INSTANT_SECONDS = null;
    public static final ChronoField MICRO_OF_DAY = null;
    public static final ChronoField MICRO_OF_SECOND = null;
    public static final ChronoField MILLI_OF_DAY = null;
    public static final ChronoField MILLI_OF_SECOND = null;
    public static final ChronoField MINUTE_OF_DAY = null;
    public static final ChronoField MINUTE_OF_HOUR = null;
    public static final ChronoField MONTH_OF_YEAR = null;
    public static final ChronoField NANO_OF_DAY = null;
    public static final ChronoField NANO_OF_SECOND = null;
    public static final ChronoField OFFSET_SECONDS = null;
    public static final ChronoField PROLEPTIC_MONTH = null;
    public static final ChronoField SECOND_OF_DAY = null;
    public static final ChronoField SECOND_OF_MINUTE = null;
    public static final ChronoField YEAR = null;
    public static final ChronoField YEAR_OF_ERA = null;
    private final TemporalUnit baseUnit;
    private final String name;
    private final ValueRange range;
    private final TemporalUnit rangeUnit;

    @Override // org.threeten.bp.temporal.TemporalField
    public TemporalAccessor resolve(Map<TemporalField, Long> r1, TemporalAccessor r2, ResolverStyle r3) {
        return null;
    }

    public static ChronoField valueOf(String r1) {
        return (ChronoField) Enum.valueOf(ChronoField.class, r1);
    }

    public static ChronoField[] values() {
        return (ChronoField[]) $VALUES.clone();
    }

    static {
        ChronoField r7 = new ChronoField("NANO_OF_SECOND", 0, "NanoOfSecond", ChronoUnit.NANOS, ChronoUnit.SECONDS, ValueRange.of(0, 999999999));
        NANO_OF_SECOND = r7;
        ChronoField r0 = new ChronoField("NANO_OF_DAY", 1, "NanoOfDay", ChronoUnit.NANOS, ChronoUnit.DAYS, ValueRange.of(0, 86399999999999L));
        NANO_OF_DAY = r0;
        ChronoField r1 = new ChronoField("MICRO_OF_SECOND", 2, "MicroOfSecond", ChronoUnit.MICROS, ChronoUnit.SECONDS, ValueRange.of(0, 999999));
        MICRO_OF_SECOND = r1;
        ChronoField r2 = new ChronoField("MICRO_OF_DAY", 3, "MicroOfDay", ChronoUnit.MICROS, ChronoUnit.DAYS, ValueRange.of(0, 86399999999L));
        MICRO_OF_DAY = r2;
        ChronoField r3 = new ChronoField("MILLI_OF_SECOND", 4, "MilliOfSecond", ChronoUnit.MILLIS, ChronoUnit.SECONDS, ValueRange.of(0, 999));
        MILLI_OF_SECOND = r3;
        ChronoField r4 = new ChronoField("MILLI_OF_DAY", 5, "MilliOfDay", ChronoUnit.MILLIS, ChronoUnit.DAYS, ValueRange.of(0, 86399999));
        MILLI_OF_DAY = r4;
        ChronoField r5 = new ChronoField("SECOND_OF_MINUTE", 6, "SecondOfMinute", ChronoUnit.SECONDS, ChronoUnit.MINUTES, ValueRange.of(0, 59));
        SECOND_OF_MINUTE = r5;
        ChronoField r6 = new ChronoField("SECOND_OF_DAY", 7, "SecondOfDay", ChronoUnit.SECONDS, ChronoUnit.DAYS, ValueRange.of(0, 86399));
        SECOND_OF_DAY = r6;
        ChronoField r21 = new ChronoField("MINUTE_OF_HOUR", 8, "MinuteOfHour", ChronoUnit.MINUTES, ChronoUnit.HOURS, ValueRange.of(0, 59));
        MINUTE_OF_HOUR = r21;
        ChronoField r12 = new ChronoField("MINUTE_OF_DAY", 9, "MinuteOfDay", ChronoUnit.MINUTES, ChronoUnit.DAYS, ValueRange.of(0, 1439));
        MINUTE_OF_DAY = r12;
        ChronoField r20 = new ChronoField("HOUR_OF_AMPM", 10, "HourOfAmPm", ChronoUnit.HOURS, ChronoUnit.HALF_DAYS, ValueRange.of(0, 11));
        HOUR_OF_AMPM = r20;
        ChronoField r10 = new ChronoField("CLOCK_HOUR_OF_AMPM", 11, "ClockHourOfAmPm", ChronoUnit.HOURS, ChronoUnit.HALF_DAYS, ValueRange.of(1, 12));
        CLOCK_HOUR_OF_AMPM = r10;
        ChronoField r11 = new ChronoField("HOUR_OF_DAY", 12, "HourOfDay", ChronoUnit.HOURS, ChronoUnit.DAYS, ValueRange.of(0, 23));
        HOUR_OF_DAY = r11;
        ChronoField r8 = new ChronoField("CLOCK_HOUR_OF_DAY", 13, "ClockHourOfDay", ChronoUnit.HOURS, ChronoUnit.DAYS, ValueRange.of(1, 24));
        CLOCK_HOUR_OF_DAY = r8;
        ChronoField r9 = new ChronoField("AMPM_OF_DAY", 14, "AmPmOfDay", ChronoUnit.HALF_DAYS, ChronoUnit.DAYS, ValueRange.of(0, 1));
        AMPM_OF_DAY = r9;
        ChronoField r13 = new ChronoField("DAY_OF_WEEK", 15, "DayOfWeek", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.of(1, 7));
        DAY_OF_WEEK = r13;
        ChronoField r14 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_MONTH", 16, "AlignedDayOfWeekInMonth", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.of(1, 7));
        ALIGNED_DAY_OF_WEEK_IN_MONTH = r14;
        ChronoField r15 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_YEAR", 17, "AlignedDayOfWeekInYear", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.of(1, 7));
        ALIGNED_DAY_OF_WEEK_IN_YEAR = r15;
        ChronoField r16 = new ChronoField("DAY_OF_MONTH", 18, "DayOfMonth", ChronoUnit.DAYS, ChronoUnit.MONTHS, ValueRange.of(1, 28, 31));
        DAY_OF_MONTH = r16;
        ChronoField r17 = new ChronoField("DAY_OF_YEAR", 19, "DayOfYear", ChronoUnit.DAYS, ChronoUnit.YEARS, ValueRange.of(1, 365, 366));
        DAY_OF_YEAR = r17;
        ChronoField r18 = new ChronoField("EPOCH_DAY", 20, "EpochDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, ValueRange.of(-365243219162L, 365241780471L));
        EPOCH_DAY = r18;
        ChronoField r19 = new ChronoField("ALIGNED_WEEK_OF_MONTH", 21, "AlignedWeekOfMonth", ChronoUnit.WEEKS, ChronoUnit.MONTHS, ValueRange.of(1, 4, 5));
        ALIGNED_WEEK_OF_MONTH = r19;
        ChronoField r110 = new ChronoField("ALIGNED_WEEK_OF_YEAR", 22, "AlignedWeekOfYear", ChronoUnit.WEEKS, ChronoUnit.YEARS, ValueRange.of(1, 53));
        ALIGNED_WEEK_OF_YEAR = r110;
        ChronoField r22 = new ChronoField("MONTH_OF_YEAR", 23, "MonthOfYear", ChronoUnit.MONTHS, ChronoUnit.YEARS, ValueRange.of(1, 12));
        MONTH_OF_YEAR = r22;
        ChronoField r111 = new ChronoField("PROLEPTIC_MONTH", 24, "ProlepticMonth", ChronoUnit.MONTHS, ChronoUnit.FOREVER, ValueRange.of(-11999999988L, 11999999999L));
        PROLEPTIC_MONTH = r111;
        ChronoField r23 = new ChronoField("YEAR_OF_ERA", 25, "YearOfEra", ChronoUnit.YEARS, ChronoUnit.FOREVER, ValueRange.of(1, 999999999, DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT));
        YEAR_OF_ERA = r23;
        ChronoField r24 = new ChronoField("YEAR", 26, "Year", ChronoUnit.YEARS, ChronoUnit.FOREVER, ValueRange.of(-999999999, 999999999));
        YEAR = r24;
        ChronoField r112 = new ChronoField("ERA", 27, "Era", ChronoUnit.ERAS, ChronoUnit.FOREVER, ValueRange.of(0, 1));
        ERA = r112;
        ChronoField r25 = new ChronoField("INSTANT_SECONDS", 28, "InstantSeconds", ChronoUnit.SECONDS, ChronoUnit.FOREVER, ValueRange.of(Long.MIN_VALUE, Long.MAX_VALUE));
        INSTANT_SECONDS = r25;
        ChronoField r26 = new ChronoField("OFFSET_SECONDS", 29, "OffsetSeconds", ChronoUnit.SECONDS, ChronoUnit.FOREVER, ValueRange.of(-64800, 64800));
        OFFSET_SECONDS = r26;
        $VALUES = new ChronoField[]{r7, r0, r1, r2, r3, r4, r5, r6, r21, r12, r20, r10, r11, r8, r9, r13, r14, r15, r16, r17, r18, r19, r110, r22, r111, r23, r24, r112, r25, r26};
    }

    private ChronoField(String r1, int r2, String r3, TemporalUnit r4, TemporalUnit r5, ValueRange r6) {
        super(r1, r2);
        this.name = r3;
        this.baseUnit = r4;
        this.rangeUnit = r5;
        this.range = r6;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public TemporalUnit getBaseUnit() {
        return this.baseUnit;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public TemporalUnit getRangeUnit() {
        return this.rangeUnit;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public ValueRange range() {
        return this.range;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean isDateBased() {
        if (ordinal() >= DAY_OF_WEEK.ordinal()) goto L5;
    L7:
        return false;
    L5:
        if (ordinal() > ERA.ordinal()) goto L7;
        return true;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean isTimeBased() {
        if (ordinal() >= DAY_OF_WEEK.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public long checkValidValue(long r2) {
        return range().checkValidValue(r2, this);
    }

    public int checkValidIntValue(long r2) {
        return range().checkValidIntValue(r2, this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean isSupportedBy(TemporalAccessor r1) {
        return r1.isSupported(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public ValueRange rangeRefinedBy(TemporalAccessor r1) {
        return r1.range(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public long getFrom(TemporalAccessor r1) {
        return r1.getLong(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public <R extends Temporal> R adjustInto(R r1, long r2) {
        return (R) r1.with(this, r2);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public String getDisplayName(Locale r2) {
        Jdk8Methods.requireNonNull(r2, LoggingEvents.VoiceIme.EXTRA_START_LOCALE);
        return toString();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
