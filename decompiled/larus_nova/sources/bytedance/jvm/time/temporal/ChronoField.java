package bytedance.jvm.time.temporal;

import bytedance.jvm.time.format.ResolverStyle;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.ss.ttm.player.C;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
public final enum ChronoField extends Enum<ChronoField> implements j {
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChronoField[] f21679a = null;
    private final m baseUnit;
    private final String displayNameKey;
    private final String name;
    private final ValueRange range;
    private final m rangeUnit;

    @Override // bytedance.jvm.time.temporal.j
    public /* bridge */ /* synthetic */ d resolve(Map r100, d r101, ResolverStyle r102) {
        return null;
    }

    static {
        ChronoUnit r110 = ChronoUnit.NANOS;
        ChronoUnit r210 = ChronoUnit.SECONDS;
        ChronoField r100 = new ChronoField("NANO_OF_SECOND", 0, "NanoOfSecond", r110, r210, ValueRange.of(0, 999999999));
        NANO_OF_SECOND = r100;
        ChronoUnit r101 = ChronoUnit.DAYS;
        ChronoField r102 = new ChronoField("NANO_OF_DAY", 1, "NanoOfDay", r110, r101, ValueRange.of(0, 86399999999999L));
        NANO_OF_DAY = r102;
        ChronoUnit r211 = ChronoUnit.MICROS;
        ChronoField r103 = new ChronoField("MICRO_OF_SECOND", 2, "MicroOfSecond", r211, r210, ValueRange.of(0, 999999));
        MICRO_OF_SECOND = r103;
        ChronoField r104 = new ChronoField("MICRO_OF_DAY", 3, "MicroOfDay", r211, r101, ValueRange.of(0, 86399999999L));
        MICRO_OF_DAY = r104;
        ChronoUnit r212 = ChronoUnit.MILLIS;
        ChronoField r105 = new ChronoField("MILLI_OF_SECOND", 4, "MilliOfSecond", r212, r210, ValueRange.of(0, 999));
        MILLI_OF_SECOND = r105;
        ChronoField r111 = new ChronoField("MILLI_OF_DAY", 5, "MilliOfDay", r212, r101, ValueRange.of(0, 86399999));
        MILLI_OF_DAY = r111;
        ChronoUnit r112 = ChronoUnit.MINUTES;
        ChronoField r113 = new ChronoField("SECOND_OF_MINUTE", 6, "SecondOfMinute", r210, r112, ValueRange.of(0, 59), "second");
        SECOND_OF_MINUTE = r113;
        ChronoField r213 = new ChronoField("SECOND_OF_DAY", 7, "SecondOfDay", r210, r101, ValueRange.of(0, 86399));
        SECOND_OF_DAY = r213;
        ChronoUnit r310 = ChronoUnit.HOURS;
        ChronoField r106 = new ChronoField("MINUTE_OF_HOUR", 8, "MinuteOfHour", r112, r310, ValueRange.of(0, 59), "minute");
        MINUTE_OF_HOUR = r106;
        ChronoField r107 = new ChronoField("MINUTE_OF_DAY", 9, "MinuteOfDay", r112, r101, ValueRange.of(0, 1439));
        MINUTE_OF_DAY = r107;
        ChronoUnit r311 = ChronoUnit.HALF_DAYS;
        ChronoField r114 = new ChronoField("HOUR_OF_AMPM", 10, "HourOfAmPm", r310, r311, ValueRange.of(0, 11));
        HOUR_OF_AMPM = r114;
        ChronoField r108 = new ChronoField("CLOCK_HOUR_OF_AMPM", 11, "ClockHourOfAmPm", r310, r311, ValueRange.of(1, 12));
        CLOCK_HOUR_OF_AMPM = r108;
        ChronoField r312 = new ChronoField("HOUR_OF_DAY", 12, "HourOfDay", r310, r101, ValueRange.of(0, 23), "hour");
        HOUR_OF_DAY = r312;
        ChronoField r115 = new ChronoField("CLOCK_HOUR_OF_DAY", 13, "ClockHourOfDay", r310, r101, ValueRange.of(1, 24));
        CLOCK_HOUR_OF_DAY = r115;
        ChronoField r116 = new ChronoField("AMPM_OF_DAY", 14, "AmPmOfDay", r311, r101, ValueRange.of(0, 1), "dayperiod");
        AMPM_OF_DAY = r116;
        ChronoUnit r117 = ChronoUnit.WEEKS;
        ChronoField r313 = new ChronoField("DAY_OF_WEEK", 15, "DayOfWeek", r101, r117, ValueRange.of(1, 7), "weekday");
        DAY_OF_WEEK = r313;
        ChronoField r314 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_MONTH", 16, "AlignedDayOfWeekInMonth", r101, r117, ValueRange.of(1, 7));
        ALIGNED_DAY_OF_WEEK_IN_MONTH = r314;
        ChronoField r410 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_YEAR", 17, "AlignedDayOfWeekInYear", r101, r117, ValueRange.of(1, 7));
        ALIGNED_DAY_OF_WEEK_IN_YEAR = r410;
        ChronoUnit r118 = ChronoUnit.MONTHS;
        ChronoField r411 = new ChronoField("DAY_OF_MONTH", 18, "DayOfMonth", r101, r118, ValueRange.of(1, 28, 31), BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
        DAY_OF_MONTH = r411;
        ChronoUnit r119 = ChronoUnit.YEARS;
        ChronoField r214 = new ChronoField("DAY_OF_YEAR", 19, "DayOfYear", r101, r119, ValueRange.of(1, 365, 366));
        DAY_OF_YEAR = r214;
        ChronoUnit r510 = ChronoUnit.FOREVER;
        ChronoField r511 = new ChronoField("EPOCH_DAY", 20, "EpochDay", r101, r510, ValueRange.of(-365243219162L, 365241780471L));
        EPOCH_DAY = r511;
        ChronoField r109 = new ChronoField("ALIGNED_WEEK_OF_MONTH", 21, "AlignedWeekOfMonth", r117, r118, ValueRange.of(1, 4, 5));
        ALIGNED_WEEK_OF_MONTH = r109;
        ChronoField r120 = new ChronoField("ALIGNED_WEEK_OF_YEAR", 22, "AlignedWeekOfYear", r117, r119, ValueRange.of(1, 53));
        ALIGNED_WEEK_OF_YEAR = r120;
        ChronoField r121 = new ChronoField("MONTH_OF_YEAR", 23, "MonthOfYear", r118, r119, ValueRange.of(1, 12), BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        MONTH_OF_YEAR = r121;
        ChronoField r122 = new ChronoField("PROLEPTIC_MONTH", 24, "ProlepticMonth", r118, r510, ValueRange.of(-11999999988L, 11999999999L));
        PROLEPTIC_MONTH = r122;
        ChronoField r123 = new ChronoField("YEAR_OF_ERA", 25, "YearOfEra", r119, r510, ValueRange.of(1, 999999999, C.NANOS_PER_SECOND));
        YEAR_OF_ERA = r123;
        ChronoField r124 = new ChronoField("YEAR", 26, "Year", r119, r510, ValueRange.of(-999999999, 999999999), BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR);
        YEAR = r124;
        ChronoField r125 = new ChronoField("ERA", 27, "Era", ChronoUnit.ERAS, r510, ValueRange.of(0, 1), "era");
        ERA = r125;
        ChronoField r126 = new ChronoField("INSTANT_SECONDS", 28, "InstantSeconds", r210, r510, ValueRange.of(Long.MIN_VALUE, Long.MAX_VALUE));
        INSTANT_SECONDS = r126;
        ChronoField r127 = new ChronoField("OFFSET_SECONDS", 29, "OffsetSeconds", r210, r510, ValueRange.of(-64800, 64800));
        OFFSET_SECONDS = r127;
        f21679a = new ChronoField[]{r100, r102, r103, r104, r105, r111, r113, r213, r106, r107, r114, r108, r312, r115, r116, r313, r314, r410, r411, r214, r511, r109, r120, r121, r122, r123, r124, r125, r126, r127};
    }

    public static ChronoField[] values() {
        return (ChronoField[]) f21679a.clone();
    }

    @Override // bytedance.jvm.time.temporal.j
    public boolean isDateBased() {
        if (ordinal() >= DAY_OF_WEEK.ordinal()) goto L5;
    L7:
        return false;
    L5:
        if (ordinal() > ERA.ordinal()) goto L7;
        return true;
    }

    @Override // bytedance.jvm.time.temporal.j
    public boolean isTimeBased() {
        if (ordinal() >= DAY_OF_WEEK.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public m getBaseUnit() {
        return this.baseUnit;
    }

    public m getRangeUnit() {
        return this.rangeUnit;
    }

    @Override // bytedance.jvm.time.temporal.j
    public ValueRange range() {
        return this.range;
    }

    @Override // java.lang.Enum, bytedance.jvm.time.temporal.j
    public String toString() {
        return this.name;
    }

    public static ChronoField valueOf(String r100) {
        return (ChronoField) r27.a.a(ChronoField.class, r100);
    }

    public int checkValidIntValue(long r100) {
        return range().checkValidIntValue(r100, this);
    }

    public long checkValidValue(long r100) {
        return range().checkValidValue(r100, this);
    }

    public String getDisplayName(Locale r100) {
        Objects.requireNonNull(r100, "locale");
        return this.name;
    }

    @Override // bytedance.jvm.time.temporal.j
    public long getFrom(d r100) {
        return r100.getLong(this);
    }

    @Override // bytedance.jvm.time.temporal.j
    public boolean isSupportedBy(d r100) {
        return r100.isSupported(this);
    }

    @Override // bytedance.jvm.time.temporal.j
    public ValueRange rangeRefinedBy(d r100) {
        return r100.range(this);
    }

    @Override // bytedance.jvm.time.temporal.j
    public <R extends b> R adjustInto(R r100, long r101) {
        return (R) r100.with(this, r101);
    }

    public ChronoField(String r100, int r101, String r102, ChronoUnit r103, ChronoUnit r104, ValueRange r105) {
        super(r100, r101);
        this.name = r102;
        this.baseUnit = r103;
        this.rangeUnit = r104;
        this.range = r105;
        this.displayNameKey = null;
    }

    public ChronoField(String r100, int r101, String r102, ChronoUnit r103, ChronoUnit r104, ValueRange r105, String r106) {
        super(r100, r101);
        this.name = r102;
        this.baseUnit = r103;
        this.rangeUnit = r104;
        this.range = r105;
        this.displayNameKey = r106;
    }
}
