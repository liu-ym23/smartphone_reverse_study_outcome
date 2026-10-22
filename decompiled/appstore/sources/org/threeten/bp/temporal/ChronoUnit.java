package org.threeten.bp.temporal;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.chrono.d;

/* JADX INFO: loaded from: classes4.dex */
public final enum ChronoUnit extends Enum<ChronoUnit> implements TemporalUnit {
    private static final /* synthetic */ ChronoUnit[] $VALUES = null;
    public static final ChronoUnit CENTURIES = null;
    public static final ChronoUnit DAYS = null;
    public static final ChronoUnit DECADES = null;
    public static final ChronoUnit ERAS = null;
    public static final ChronoUnit FOREVER = null;
    public static final ChronoUnit HALF_DAYS = null;
    public static final ChronoUnit HOURS = null;
    public static final ChronoUnit MICROS = null;
    public static final ChronoUnit MILLENNIA = null;
    public static final ChronoUnit MILLIS = null;
    public static final ChronoUnit MINUTES = null;
    public static final ChronoUnit MONTHS = null;
    public static final ChronoUnit NANOS = null;
    public static final ChronoUnit SECONDS = null;
    public static final ChronoUnit WEEKS = null;
    public static final ChronoUnit YEARS = null;
    private final Duration duration;
    private final String name;

    static {
        ChronoUnit r10 = new ChronoUnit("NANOS", 0, "Nanos", Duration.ofNanos(1));
        NANOS = r10;
        ChronoUnit r11 = new ChronoUnit("MICROS", 1, "Micros", Duration.ofNanos(1000));
        MICROS = r11;
        ChronoUnit r12 = new ChronoUnit("MILLIS", 2, "Millis", Duration.ofNanos(BatteryFactorConfig.WIFI_BPS));
        MILLIS = r12;
        ChronoUnit r13 = new ChronoUnit("SECONDS", 3, "Seconds", Duration.ofSeconds(1));
        SECONDS = r13;
        ChronoUnit r14 = new ChronoUnit("MINUTES", 4, "Minutes", Duration.ofSeconds(60));
        MINUTES = r14;
        ChronoUnit r15 = new ChronoUnit("HOURS", 5, "Hours", Duration.ofSeconds(3600));
        HOURS = r15;
        ChronoUnit r16 = new ChronoUnit("HALF_DAYS", 6, "HalfDays", Duration.ofSeconds(43200));
        HALF_DAYS = r16;
        ChronoUnit r17 = new ChronoUnit("DAYS", 7, "Days", Duration.ofSeconds(86400));
        DAYS = r17;
        ChronoUnit r18 = new ChronoUnit("WEEKS", 8, "Weeks", Duration.ofSeconds(604800));
        WEEKS = r18;
        ChronoUnit r19 = new ChronoUnit("MONTHS", 9, "Months", Duration.ofSeconds(2629746));
        MONTHS = r19;
        ChronoUnit r110 = new ChronoUnit("YEARS", 10, "Years", Duration.ofSeconds(31556952));
        YEARS = r110;
        ChronoUnit r111 = new ChronoUnit("DECADES", 11, "Decades", Duration.ofSeconds(315569520));
        DECADES = r111;
        ChronoUnit r112 = new ChronoUnit("CENTURIES", 12, "Centuries", Duration.ofSeconds(3155695200L));
        CENTURIES = r112;
        ChronoUnit r113 = new ChronoUnit("MILLENNIA", 13, "Millennia", Duration.ofSeconds(31556952000L));
        MILLENNIA = r113;
        ChronoUnit r114 = new ChronoUnit("ERAS", 14, "Eras", Duration.ofSeconds(31556952000000000L));
        ERAS = r114;
        ChronoUnit r115 = new ChronoUnit("FOREVER", 15, "Forever", Duration.ofSeconds(Long.MAX_VALUE, 999999999));
        FOREVER = r115;
        $VALUES = new ChronoUnit[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115};
    }

    private ChronoUnit(String r10, int r11, String r12, Duration r13) {
        super(r10, r11);
        this.name = r12;
        this.duration = r13;
    }

    public static ChronoUnit valueOf(String r10) {
        return (ChronoUnit) Enum.valueOf(ChronoUnit.class, r10);
    }

    public static ChronoUnit[] values() {
        return (ChronoUnit[]) $VALUES.clone();
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public <R extends Temporal> R addTo(R r10, long r11) {
        return (R) r10.plus(r11, this);
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public long between(Temporal r10, Temporal r11) {
        return r10.until(r11, this);
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public Duration getDuration() {
        return this.duration;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public boolean isDateBased() {
        if (compareTo(DAYS) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this == FOREVER) goto L7;
        return true;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public boolean isDurationEstimated() {
        if (isDateBased() == false) goto L5;
    L8:
        return true;
    L5:
        if (this == FOREVER) goto L8;
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public boolean isSupportedBy(Temporal r10) {
        if (this != FOREVER) goto L6;
        return false;
    L6:
        if ((r10 instanceof org.threeten.bp.chrono.a) == false) goto L10;
        return isDateBased();
    L10:
        if ((r10 instanceof org.threeten.bp.chrono.b) == false) goto L12;
    L21:
        return true;
    L12:
        if ((r10 instanceof d) == true) goto L21;
        r10.plus(1, this);     // Catch: RuntimeException -> L17
        return true;
    L22:
        r10.plus(-1, this);     // Catch: RuntimeException -> L20
        return true;
    L20:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public boolean isTimeBased() {
        if (compareTo(DAYS) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Enum, org.threeten.bp.temporal.TemporalUnit
    public String toString() {
        return this.name;
    }
}
