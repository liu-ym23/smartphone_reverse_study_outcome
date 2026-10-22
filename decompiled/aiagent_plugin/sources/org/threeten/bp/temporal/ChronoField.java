package org.threeten.bp.temporal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.aiagent.plugin");
        return null;
    }

    public static ChronoField valueOf(String r2) {
        return (ChronoField) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChronoField.class, r2), ChronoField.class, "com.obric.aiagent.plugin");
    }

    public static ChronoField[] values() {
        return (ChronoField[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChronoField[].class, "com.obric.aiagent.plugin");
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
        ChronoField r13 = new ChronoField("CLOCK_HOUR_OF_AMPM", 11, "ClockHourOfAmPm", ChronoUnit.HOURS, ChronoUnit.HALF_DAYS, ValueRange.of(1, 12));
        CLOCK_HOUR_OF_AMPM = r13;
        ChronoField r18 = new ChronoField("HOUR_OF_DAY", 12, "HourOfDay", ChronoUnit.HOURS, ChronoUnit.DAYS, ValueRange.of(0, 23));
        HOUR_OF_DAY = r18;
        ChronoField r10 = new ChronoField("CLOCK_HOUR_OF_DAY", 13, "ClockHourOfDay", ChronoUnit.HOURS, ChronoUnit.DAYS, ValueRange.of(1, 24));
        CLOCK_HOUR_OF_DAY = r10;
        ChronoField r8 = new ChronoField("AMPM_OF_DAY", 14, "AmPmOfDay", ChronoUnit.HALF_DAYS, ChronoUnit.DAYS, ValueRange.of(0, 1));
        AMPM_OF_DAY = r8;
        ChronoField r9 = new ChronoField("DAY_OF_WEEK", 15, "DayOfWeek", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.of(1, 7));
        DAY_OF_WEEK = r9;
        ChronoField r33 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_MONTH", 16, "AlignedDayOfWeekInMonth", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.of(1, 7));
        ALIGNED_DAY_OF_WEEK_IN_MONTH = r33;
        ChronoField r26 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_YEAR", 17, "AlignedDayOfWeekInYear", ChronoUnit.DAYS, ChronoUnit.WEEKS, ValueRange.of(1, 7));
        ALIGNED_DAY_OF_WEEK_IN_YEAR = r26;
        ChronoField r11 = new ChronoField("DAY_OF_MONTH", 18, "DayOfMonth", ChronoUnit.DAYS, ChronoUnit.MONTHS, ValueRange.of(1, 28, 31));
        DAY_OF_MONTH = r11;
        ChronoField r14 = new ChronoField("DAY_OF_YEAR", 19, "DayOfYear", ChronoUnit.DAYS, ChronoUnit.YEARS, ValueRange.of(1, 365, 366));
        DAY_OF_YEAR = r14;
        ChronoField r27 = new ChronoField("EPOCH_DAY", 20, "EpochDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, ValueRange.of(-365243219162L, 365241780471L));
        EPOCH_DAY = r27;
        ChronoField r15 = new ChronoField("ALIGNED_WEEK_OF_MONTH", 21, "AlignedWeekOfMonth", ChronoUnit.WEEKS, ChronoUnit.MONTHS, ValueRange.of(1, 4, 5));
        ALIGNED_WEEK_OF_MONTH = r15;
        ChronoField r16 = new ChronoField("ALIGNED_WEEK_OF_YEAR", 22, "AlignedWeekOfYear", ChronoUnit.WEEKS, ChronoUnit.YEARS, ValueRange.of(1, 53));
        ALIGNED_WEEK_OF_YEAR = r16;
        ChronoField r17 = new ChronoField("MONTH_OF_YEAR", 23, "MonthOfYear", ChronoUnit.MONTHS, ChronoUnit.YEARS, ValueRange.of(1, 12));
        MONTH_OF_YEAR = r17;
        ChronoField r19 = new ChronoField("PROLEPTIC_MONTH", 24, "ProlepticMonth", ChronoUnit.MONTHS, ChronoUnit.FOREVER, ValueRange.of(-11999999988L, 11999999999L));
        PROLEPTIC_MONTH = r19;
        ChronoField r22 = new ChronoField("YEAR_OF_ERA", 25, "YearOfEra", ChronoUnit.YEARS, ChronoUnit.FOREVER, ValueRange.of(1, 999999999, 1000000000));
        YEAR_OF_ERA = r22;
        ChronoField r23 = new ChronoField("YEAR", 26, "Year", ChronoUnit.YEARS, ChronoUnit.FOREVER, ValueRange.of(-999999999, 999999999));
        YEAR = r23;
        ChronoField r110 = new ChronoField("ERA", 27, "Era", ChronoUnit.ERAS, ChronoUnit.FOREVER, ValueRange.of(0, 1));
        ERA = r110;
        ChronoField r24 = new ChronoField("INSTANT_SECONDS", 28, "InstantSeconds", ChronoUnit.SECONDS, ChronoUnit.FOREVER, ValueRange.of(Long.MIN_VALUE, Long.MAX_VALUE));
        INSTANT_SECONDS = r24;
        ChronoField r25 = new ChronoField("OFFSET_SECONDS", 29, "OffsetSeconds", ChronoUnit.SECONDS, ChronoUnit.FOREVER, ValueRange.of(-64800, 64800));
        OFFSET_SECONDS = r25;
        $VALUES = new ChronoField[]{r7, r0, r1, r2, r3, r4, r5, r6, r21, r12, r20, r13, r18, r10, r8, r9, r33, r26, r11, r14, r27, r15, r16, r17, r19, r22, r23, r110, r24, r25};
    }

    private ChronoField(String r3, int r4, String r5, TemporalUnit r6, TemporalUnit r7, ValueRange r8) {
        TemporalUnit r9 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r6, TemporalUnit.class, "com.obric.aiagent.plugin");
        TemporalUnit r10 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r7, TemporalUnit.class, "com.obric.aiagent.plugin");
        super(r3, r4);
        this.name = r5;
        this.baseUnit = r9;
        this.rangeUnit = r10;
        this.range = r8;
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
    public boolean isSupportedBy(TemporalAccessor r3) {
        return ((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin")).isSupported(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public ValueRange rangeRefinedBy(TemporalAccessor r3) {
        return ((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin")).range(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public long getFrom(TemporalAccessor r3) {
        return ((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin")).getLong(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public <R extends Temporal> R adjustInto(R r3, long r4) {
        return (R) ((Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.aiagent.plugin")).with(this, r4);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public String getDisplayName(Locale r2) {
        Jdk8Methods.requireNonNull(r2, "locale");
        return toString();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
