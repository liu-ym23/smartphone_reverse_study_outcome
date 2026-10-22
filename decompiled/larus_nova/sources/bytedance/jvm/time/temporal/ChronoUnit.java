package bytedance.jvm.time.temporal;

import bytedance.jvm.time.Duration;
import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes28.dex */
public final enum ChronoUnit extends Enum<ChronoUnit> implements m {
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChronoUnit[] f21680a = null;
    private final Duration duration;
    private final String name;

    static {
        ChronoUnit r100 = new ChronoUnit("NANOS", 0, "Nanos", Duration.ofNanos(1));
        NANOS = r100;
        ChronoUnit r101 = new ChronoUnit("MICROS", 1, "Micros", Duration.ofNanos(1000));
        MICROS = r101;
        ChronoUnit r102 = new ChronoUnit("MILLIS", 2, "Millis", Duration.ofNanos(1000000));
        MILLIS = r102;
        ChronoUnit r103 = new ChronoUnit("SECONDS", 3, "Seconds", Duration.ofSeconds(1));
        SECONDS = r103;
        ChronoUnit r104 = new ChronoUnit("MINUTES", 4, "Minutes", Duration.ofSeconds(60));
        MINUTES = r104;
        ChronoUnit r105 = new ChronoUnit("HOURS", 5, "Hours", Duration.ofSeconds(TimeUtils.SECONDS_PER_HOUR));
        HOURS = r105;
        ChronoUnit r106 = new ChronoUnit("HALF_DAYS", 6, "HalfDays", Duration.ofSeconds(43200));
        HALF_DAYS = r106;
        ChronoUnit r110 = new ChronoUnit("DAYS", 7, "Days", Duration.ofSeconds(86400));
        DAYS = r110;
        ChronoUnit r111 = new ChronoUnit("WEEKS", 8, "Weeks", Duration.ofSeconds(604800));
        WEEKS = r111;
        ChronoUnit r112 = new ChronoUnit("MONTHS", 9, "Months", Duration.ofSeconds(2629746));
        MONTHS = r112;
        ChronoUnit r107 = new ChronoUnit("YEARS", 10, "Years", Duration.ofSeconds(31556952));
        YEARS = r107;
        ChronoUnit r108 = new ChronoUnit("DECADES", 11, "Decades", Duration.ofSeconds(315569520));
        DECADES = r108;
        ChronoUnit r109 = new ChronoUnit("CENTURIES", 12, "Centuries", Duration.ofSeconds(3155695200L));
        CENTURIES = r109;
        ChronoUnit r113 = new ChronoUnit("MILLENNIA", 13, "Millennia", Duration.ofSeconds(31556952000L));
        MILLENNIA = r113;
        ChronoUnit r114 = new ChronoUnit("ERAS", 14, "Eras", Duration.ofSeconds(31556952000000000L));
        ERAS = r114;
        ChronoUnit r115 = new ChronoUnit("FOREVER", 15, "Forever", Duration.ofSeconds(Long.MAX_VALUE, 999999999));
        FOREVER = r115;
        f21680a = new ChronoUnit[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r107, r108, r109, r113, r114, r115};
    }

    public static ChronoUnit[] values() {
        return (ChronoUnit[]) f21680a.clone();
    }

    @Override // bytedance.jvm.time.temporal.m
    public boolean isDateBased() {
        if (compareTo(DAYS) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this == FOREVER) goto L7;
        return true;
    }

    @Override // bytedance.jvm.time.temporal.m
    public boolean isDurationEstimated() {
        if (compareTo(DAYS) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bytedance.jvm.time.temporal.m
    public boolean isTimeBased() {
        if (compareTo(DAYS) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bytedance.jvm.time.temporal.m
    public Duration getDuration() {
        return this.duration;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }

    public static ChronoUnit valueOf(String r100) {
        return (ChronoUnit) r27.a.a(ChronoUnit.class, r100);
    }

    @Override // bytedance.jvm.time.temporal.m
    public boolean isSupportedBy(b r100) {
        return r100.isSupported(this);
    }

    @Override // bytedance.jvm.time.temporal.m
    public <R extends b> R addTo(R r100, long r101) {
        return (R) r100.plus(r101, this);
    }

    @Override // bytedance.jvm.time.temporal.m
    public long between(b r100, b r101) {
        return r100.until(r101, this);
    }

    public ChronoUnit(String r100, int r101, String r102, Duration r103) {
        super(r100, r101);
        this.name = r102;
        this.duration = r103;
    }
}
