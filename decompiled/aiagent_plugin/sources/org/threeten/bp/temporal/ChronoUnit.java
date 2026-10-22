package org.threeten.bp.temporal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.Duration;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;

/* JADX INFO: loaded from: classes5.dex */
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

    public static ChronoUnit valueOf(String r2) {
        return (ChronoUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChronoUnit.class, r2), ChronoUnit.class, "com.obric.aiagent.plugin");
    }

    public static ChronoUnit[] values() {
        return (ChronoUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChronoUnit[].class, "com.obric.aiagent.plugin");
    }

    static {
        ChronoUnit r0 = new ChronoUnit("NANOS", 0, "Nanos", Duration.ofNanos(1));
        NANOS = r0;
        ChronoUnit r3 = new ChronoUnit("MICROS", 1, "Micros", Duration.ofNanos(1000));
        MICROS = r3;
        ChronoUnit r4 = new ChronoUnit("MILLIS", 2, "Millis", Duration.ofNanos(1000000));
        MILLIS = r4;
        ChronoUnit r6 = new ChronoUnit("SECONDS", 3, "Seconds", Duration.ofSeconds(1));
        SECONDS = r6;
        ChronoUnit r1 = new ChronoUnit("MINUTES", 4, "Minutes", Duration.ofSeconds(60));
        MINUTES = r1;
        ChronoUnit r2 = new ChronoUnit("HOURS", 5, "Hours", Duration.ofSeconds(3600));
        HOURS = r2;
        ChronoUnit r10 = new ChronoUnit("HALF_DAYS", 6, "HalfDays", Duration.ofSeconds(43200));
        HALF_DAYS = r10;
        ChronoUnit r12 = new ChronoUnit("DAYS", 7, "Days", Duration.ofSeconds(86400));
        DAYS = r12;
        ChronoUnit r11 = new ChronoUnit("WEEKS", 8, "Weeks", Duration.ofSeconds(604800));
        WEEKS = r11;
        ChronoUnit r8 = new ChronoUnit("MONTHS", 9, "Months", Duration.ofSeconds(2629746));
        MONTHS = r8;
        ChronoUnit r9 = new ChronoUnit("YEARS", 10, "Years", Duration.ofSeconds(31556952));
        YEARS = r9;
        ChronoUnit r7 = new ChronoUnit("DECADES", 11, "Decades", Duration.ofSeconds(315569520));
        DECADES = r7;
        ChronoUnit r5 = new ChronoUnit("CENTURIES", 12, "Centuries", Duration.ofSeconds(3155695200L));
        CENTURIES = r5;
        ChronoUnit r13 = new ChronoUnit("MILLENNIA", 13, "Millennia", Duration.ofSeconds(31556952000L));
        MILLENNIA = r13;
        ChronoUnit r14 = new ChronoUnit("ERAS", 14, "Eras", Duration.ofSeconds(31556952000000000L));
        ERAS = r14;
        ChronoUnit r15 = new ChronoUnit("FOREVER", 15, "Forever", Duration.ofSeconds(Long.MAX_VALUE, 999999999));
        FOREVER = r15;
        $VALUES = new ChronoUnit[]{r0, r3, r4, r6, r1, r2, r10, r12, r11, r8, r9, r7, r5, r13, r14, r15};
    }

    private ChronoUnit(String r1, int r2, String r3, Duration r4) {
        super(r1, r2);
        this.name = r3;
        this.duration = r4;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public Duration getDuration() {
        return this.duration;
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
    public boolean isDateBased() {
        if (compareTo(DAYS) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this == FOREVER) goto L7;
        return true;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public boolean isTimeBased() {
        if (compareTo(DAYS) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public boolean isSupportedBy(Temporal r6) {
        Temporal r7 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r6, Temporal.class, "com.obric.aiagent.plugin");
        if (this != FOREVER) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ChronoLocalDate.class) == false) goto L10;
        return isDateBased();
    L10:
        if (ZeusTransformUtils.instanceOf(r7, ChronoLocalDateTime.class) == false) goto L12;
    L21:
        return true;
    L12:
        if (ZeusTransformUtils.instanceOf(r7, ChronoZonedDateTime.class) == true) goto L21;
        r7.plus(1, this);     // Catch: RuntimeException -> L17
        return true;
    L24:
        r7.plus(-1, this);     // Catch: RuntimeException -> L20
        return true;
    L20:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public <R extends Temporal> R addTo(R r3, long r4) {
        return (R) ((Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.aiagent.plugin")).plus(r4, this);
    }

    @Override // org.threeten.bp.temporal.TemporalUnit
    public long between(Temporal r3, Temporal r4) {
        return ((Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.aiagent.plugin")).until((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.aiagent.plugin"), this);
    }

    @Override // java.lang.Enum, org.threeten.bp.temporal.TemporalUnit
    public String toString() {
        return this.name;
    }
}
