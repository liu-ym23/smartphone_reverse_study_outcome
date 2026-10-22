package org.threeten.bp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
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
public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Serializable, Temporal, TemporalAdjuster {
    public static final TemporalQuery<LocalDateTime> FROM = null;
    public static final LocalDateTime MAX = null;
    public static final LocalDateTime MIN = null;
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;

    /* JADX INFO: renamed from: org.threeten.bp.LocalDateTime$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public /* bridge */ /* synthetic */ ChronoZonedDateTime atZone(ZoneId r1) {
        return atZone(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, java.lang.Comparable
    public /* synthetic */ int compareTo(Object r3) {
        return compareTo((ChronoLocalDateTime) ZeusTransformUtils.preCheckCast(r3, ChronoLocalDateTime.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public /* bridge */ /* synthetic */ ChronoLocalDate toLocalDate() {
        return toLocalDate();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDateTime with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
    }

    static {
        MIN = of(LocalDate.MIN, LocalTime.MIN);
        MAX = of(LocalDate.MAX, LocalTime.MAX);
        FROM = new AnonymousClass1();
    }

    public static LocalDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDateTime now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static LocalDateTime now(Clock r3) {
        Jdk8Methods.requireNonNull(r3, "clock");
        Instant r0 = r3.instant();
        ZoneOffset r4 = r3.getZone().getRules().getOffset(r0);
        return ofEpochSecond(r0.getEpochSecond(), r0.getNano(), r4);
    }

    public static LocalDateTime of(int r0, Month r1, int r2, int r3, int r4) {
        return new LocalDateTime(LocalDate.of(r0, r1, r2), LocalTime.of(r3, r4));
    }

    public static LocalDateTime of(int r0, Month r1, int r2, int r3, int r4, int r5) {
        return new LocalDateTime(LocalDate.of(r0, r1, r2), LocalTime.of(r3, r4, r5));
    }

    public static LocalDateTime of(int r0, Month r1, int r2, int r3, int r4, int r5, int r6) {
        return new LocalDateTime(LocalDate.of(r0, r1, r2), LocalTime.of(r3, r4, r5, r6));
    }

    public static LocalDateTime of(int r0, int r1, int r2, int r3, int r4) {
        return new LocalDateTime(LocalDate.of(r0, r1, r2), LocalTime.of(r3, r4));
    }

    public static LocalDateTime of(int r0, int r1, int r2, int r3, int r4, int r5) {
        return new LocalDateTime(LocalDate.of(r0, r1, r2), LocalTime.of(r3, r4, r5));
    }

    public static LocalDateTime of(int r0, int r1, int r2, int r3, int r4, int r5, int r6) {
        return new LocalDateTime(LocalDate.of(r0, r1, r2), LocalTime.of(r3, r4, r5, r6));
    }

    public static LocalDateTime of(LocalDate r1, LocalTime r2) {
        Jdk8Methods.requireNonNull(r1, "date");
        Jdk8Methods.requireNonNull(r2, "time");
        return new LocalDateTime(r1, r2);
    }

    public static LocalDateTime ofInstant(Instant r2, ZoneId r3) {
        Jdk8Methods.requireNonNull(r2, "instant");
        Jdk8Methods.requireNonNull(r3, "zone");
        ZoneOffset r4 = r3.getRules().getOffset(r2);
        return ofEpochSecond(r2.getEpochSecond(), r2.getNano(), r4);
    }

    public static LocalDateTime ofEpochSecond(long r2, int r4, ZoneOffset r5) {
        Jdk8Methods.requireNonNull(r5, "offset");
        long r3 = r2 + ((long) r5.getTotalSeconds());
        return new LocalDateTime(LocalDate.ofEpochDay(Jdk8Methods.floorDiv(r3, 86400)), LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(r3, 86400), r4));
    }

    public static LocalDateTime from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, LocalDateTime.class) == false) goto L7;
        return (LocalDateTime) ZeusTransformUtils.preCheckCast(r4, LocalDateTime.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ZonedDateTime.class) == true) goto L9;
        return new LocalDateTime(LocalDate.from(r4), LocalTime.from(r4));
    L13:
        throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + r4 + ", type " + r4.getClass().getName());
    L9:
        return ((ZonedDateTime) ZeusTransformUtils.preCheckCast(r4, ZonedDateTime.class, "com.obric.aiagent.plugin")).toLocalDateTime();
    }

    public static LocalDateTime parse(CharSequence r2) {
        return parse((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static LocalDateTime parse(CharSequence r2, DateTimeFormatter r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r3, "formatter");
        return (LocalDateTime) ZeusTransformUtils.preCheckCast(r3.parse(r4, FROM), LocalDateTime.class, "com.obric.aiagent.plugin");
    }

    private LocalDateTime(LocalDate r1, LocalTime r2) {
        this.date = r1;
        this.time = r2;
    }

    private LocalDateTime with(LocalDate r2, LocalTime r3) {
        if (this.date != r2) goto L8;
        if (this.time != r3) goto L8;
        return this;
    L8:
        return new LocalDateTime(r2, r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r5.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r4) {
        TemporalUnit r5 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoUnit.class) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r5.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L10;
        if (r4.isTimeBased() == false) goto L8;
        return this.time.range(r4);
    L8:
        return this.date.range(r4);
    L10:
        return r4.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L10;
        if (r4.isTimeBased() == false) goto L8;
        return this.time.get(r4);
    L8:
        return this.date.get(r4);
    L10:
        return super.get(r4);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L10;
        if (r4.isTimeBased() == false) goto L8;
        return this.time.getLong(r4);
    L8:
        return this.date.getLong(r4);
    L10:
        return r4.getFrom(this);
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public Month getMonth() {
        return this.date.getMonth();
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public int getDayOfYear() {
        return this.date.getDayOfYear();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getHour() {
        return this.time.getHour();
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getNano() {
        return this.time.getNano();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalAdjuster r4) {
        TemporalAdjuster r5 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAdjuster.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, LocalDate.class) == false) goto L7;
        return with((LocalDate) ZeusTransformUtils.preCheckCast(r5, LocalDate.class, "com.obric.aiagent.plugin"), this.time);
    L7:
        if (ZeusTransformUtils.instanceOf(r5, LocalTime.class) == false) goto L11;
        return with(this.date, (LocalTime) ZeusTransformUtils.preCheckCast(r5, LocalTime.class, "com.obric.aiagent.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r5, LocalDateTime.class) == false) goto L15;
        return (LocalDateTime) ZeusTransformUtils.preCheckCast(r5, LocalDateTime.class, "com.obric.aiagent.plugin");
    L15:
        return (LocalDateTime) ZeusTransformUtils.preCheckCast(r5.adjustInto(this), LocalDateTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalField r3, long r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L11;
        if (r5.isTimeBased() == false) goto L9;
        return with(this.date, this.time.with(r5, r4));
    L9:
        return with(this.date.with(r5, r4), this.time);
    L11:
        return (LocalDateTime) ZeusTransformUtils.preCheckCast(r5.adjustInto(this, r4), LocalDateTime.class, "com.obric.aiagent.plugin");
    }

    public LocalDateTime withYear(int r2) {
        return with(this.date.withYear(r2), this.time);
    }

    public LocalDateTime withMonth(int r2) {
        return with(this.date.withMonth(r2), this.time);
    }

    public LocalDateTime withDayOfMonth(int r2) {
        return with(this.date.withDayOfMonth(r2), this.time);
    }

    public LocalDateTime withDayOfYear(int r2) {
        return with(this.date.withDayOfYear(r2), this.time);
    }

    public LocalDateTime withHour(int r2) {
        LocalTime r3 = this.time.withHour(r2);
        return with(this.date, r3);
    }

    public LocalDateTime withMinute(int r2) {
        LocalTime r3 = this.time.withMinute(r2);
        return with(this.date, r3);
    }

    public LocalDateTime withSecond(int r2) {
        LocalTime r3 = this.time.withSecond(r2);
        return with(this.date, r3);
    }

    public LocalDateTime withNano(int r2) {
        LocalTime r3 = this.time.withNano(r2);
        return with(this.date, r3);
    }

    public LocalDateTime truncatedTo(TemporalUnit r3) {
        TemporalUnit r4 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r3, TemporalUnit.class, "com.obric.aiagent.plugin");
        return with(this.date, this.time.truncatedTo(r4));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(TemporalAmount r3) {
        return (LocalDateTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin")).addTo(this), LocalDateTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(long r5, TemporalUnit r7) {
        TemporalUnit r8 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r7, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ChronoUnit.class) == false) goto L23;
        ChronoUnit r0 = (ChronoUnit) ZeusTransformUtils.preCheckCast(r8, ChronoUnit.class, "com.obric.aiagent.plugin");
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[r0.ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        return with(this.date.plus(r5, r8), this.time);
    L9:
        return plusDays(r5 / 256).plusHours((r5 % 256) * 12);
    L11:
        return plusHours(r5);
    L13:
        return plusMinutes(r5);
    L15:
        return plusSeconds(r5);
    L17:
        return plusDays(r5 / 86400000).plusNanos((r5 % 86400000) * 1000000);
    L19:
        return plusDays(r5 / 86400000000L).plusNanos((r5 % 86400000000L) * 1000);
    L21:
        return plusNanos(r5);
    L23:
        return (LocalDateTime) ZeusTransformUtils.preCheckCast(r8.addTo(this, r5), LocalDateTime.class, "com.obric.aiagent.plugin");
    }

    public LocalDateTime plusYears(long r2) {
        return with(this.date.plusYears(r2), this.time);
    }

    public LocalDateTime plusMonths(long r2) {
        return with(this.date.plusMonths(r2), this.time);
    }

    public LocalDateTime plusWeeks(long r2) {
        return with(this.date.plusWeeks(r2), this.time);
    }

    public LocalDateTime plusDays(long r2) {
        return with(this.date.plusDays(r2), this.time);
    }

    public LocalDateTime plusHours(long r12) {
        return plusWithOverflow(this.date, r12, 0, 0, 0, 1);
    }

    public LocalDateTime plusMinutes(long r12) {
        return plusWithOverflow(this.date, 0, r12, 0, 0, 1);
    }

    public LocalDateTime plusSeconds(long r12) {
        return plusWithOverflow(this.date, 0, 0, r12, 0, 1);
    }

    public LocalDateTime plusNanos(long r12) {
        return plusWithOverflow(this.date, 0, 0, 0, r12, 1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime minus(TemporalAmount r3) {
        return (LocalDateTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin")).subtractFrom(this), LocalDateTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDateTime this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalDateTime minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDateTime this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalDateTime minusMonths(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDateTime this = plusMonths(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMonths(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalDateTime minusWeeks(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDateTime this = plusWeeks(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusWeeks(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalDateTime minusDays(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDateTime this = plusDays(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusDays(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public LocalDateTime minusHours(long r12) {
        return plusWithOverflow(this.date, r12, 0, 0, 0, -1);
    }

    public LocalDateTime minusMinutes(long r12) {
        return plusWithOverflow(this.date, 0, r12, 0, 0, -1);
    }

    public LocalDateTime minusSeconds(long r12) {
        return plusWithOverflow(this.date, 0, 0, r12, 0, -1);
    }

    public LocalDateTime minusNanos(long r12) {
        return plusWithOverflow(this.date, 0, 0, 0, r12, -1);
    }

    private LocalDateTime plusWithOverflow(LocalDate r19, long r20, long r22, long r24, long r26, int r28) {
        if ((((r20 | r22) | r24) | r26) == 0) goto L5;
        long r12 = r28;
        long r6 = this.time.toNanoOfDay();
        long r14 = (((((r26 % 86400000000000L) + ((r24 % 86400) * 1000000000)) + ((r22 % 1440) * 60000000000L)) + ((r20 % 24) * 3600000000000L)) * r12) + r6;
        long r4 = (((((r26 / 86400000000000L) + (r24 / 86400)) + (r22 / 1440)) + (r20 / 24)) * r12) + Jdk8Methods.floorDiv(r14, 86400000000000L);
        long r2 = Jdk8Methods.floorMod(r14, 86400000000000L);
        if (r2 != r6) goto L9;
        LocalTime r3 = this.time;
    L11:
        return with(r19.plusDays(r4), r3);
    L9:
        r3 = LocalTime.ofNanoOfDay(r2);
        goto L11
    L5:
        return with(r19, this.time);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<R> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.aiagent.plugin");
        if (r4 != TemporalQueries.localDate()) goto L7;
        return (R) toLocalDate();
    L7:
        return (R) super.query(r4);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r3) {
        return super.adjustInto((Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r12, TemporalUnit r13) {
        Temporal r14 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r12, Temporal.class, "com.obric.aiagent.plugin");
        TemporalUnit r15 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r13, TemporalUnit.class, "com.obric.aiagent.plugin");
        LocalDateTime r16 = from(r14);
        if (ZeusTransformUtils.instanceOf(r15, ChronoUnit.class) == false) goto L46;
        ChronoUnit r0 = (ChronoUnit) ZeusTransformUtils.preCheckCast(r15, ChronoUnit.class, "com.obric.aiagent.plugin");
        if (r0.isTimeBased() == false) goto L33;
        long r4 = this.date.daysUntil(r16.date);
        long r6 = r16.time.toNanoOfDay() - this.time.toNanoOfDay();
        if (r4 > 0) goto L9;
    L11:
        if (r4 < 0) goto L13;
    L16:
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[r0.ordinal()]) {
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L20;
            default: goto L18;
        };
    L18:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r15);
    L20:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 2), r6 / 43200000000000L);
    L22:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 24), r6 / 3600000000000L);
    L24:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 1440), r6 / 60000000000L);
    L26:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 86400), r6 / 1000000000);
    L28:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 86400000), r6 / 1000000);
    L30:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 86400000000L), r6 / 1000);
    L32:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 86400000000000L), r6);
    L13:
        if (r6 <= 0) goto L16;
        r4 = r4 + 1;
        r6 = r6 - 86400000000000L;
        goto L16
    L9:
        if (r6 >= 0) goto L11;
        r4 = r4 - 1;
        r6 = r6 + 86400000000000L;
        goto L16
    L33:
        LocalDate r1 = r16.date;
        if (r1.isAfter(this.date) == false) goto L39;
        if (r16.time.isBefore(this.time) == false) goto L39;
        r1 = r1.minusDays(1);
    L44:
        return this.date.until(r1, r15);
    L39:
        if (r1.isBefore(this.date) == false) goto L44;
        if (r16.time.isAfter(this.time) == false) goto L44;
        r1 = r1.plusDays(1);
        goto L44
    L46:
        return r15.between(this, r16);
    }

    public OffsetDateTime atOffset(ZoneOffset r1) {
        return OffsetDateTime.of(this, r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public ZonedDateTime atZone(ZoneId r1) {
        return ZonedDateTime.of(this, r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalDate toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public int compareTo(ChronoLocalDateTime<?> r3) {
        if (ZeusTransformUtils.instanceOf(r3, LocalDateTime.class) == false) goto L7;
        return compareTo0((LocalDateTime) ZeusTransformUtils.preCheckCast(r3, LocalDateTime.class, "com.obric.aiagent.plugin"));
    L7:
        return super.compareTo(r3);
    }

    private int compareTo0(LocalDateTime r3) {
        int r0 = this.date.compareTo0(r3.toLocalDate());
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.time.compareTo2(r3.toLocalTime());
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isAfter(ChronoLocalDateTime<?> r3) {
        if (ZeusTransformUtils.instanceOf(r3, LocalDateTime.class) == false) goto L10;
        if (compareTo0((LocalDateTime) ZeusTransformUtils.preCheckCast(r3, LocalDateTime.class, "com.obric.aiagent.plugin")) <= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isAfter(r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isBefore(ChronoLocalDateTime<?> r3) {
        if (ZeusTransformUtils.instanceOf(r3, LocalDateTime.class) == false) goto L10;
        if (compareTo0((LocalDateTime) ZeusTransformUtils.preCheckCast(r3, LocalDateTime.class, "com.obric.aiagent.plugin")) >= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isBefore(r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isEqual(ChronoLocalDateTime<?> r3) {
        if (ZeusTransformUtils.instanceOf(r3, LocalDateTime.class) == false) goto L10;
        if (compareTo0((LocalDateTime) ZeusTransformUtils.preCheckCast(r3, LocalDateTime.class, "com.obric.aiagent.plugin")) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isEqual(r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocalDateTime.class) == false) goto L14;
        LocalDateTime r6 = (LocalDateTime) ZeusTransformUtils.preCheckCast(r5, LocalDateTime.class, "com.obric.aiagent.plugin");
        if (this.date.equals(r6.date) == false) goto L13;
        if (this.time.equals(r6.time) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public int hashCode() {
        int r0 = this.date.hashCode();
        return this.time.hashCode() ^ r0;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public String format(DateTimeFormatter r1) {
        return super.format(r1);
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.aiagent.plugin");
        this.date.writeExternal(r4);
        this.time.writeExternal(r4);
    }

    static LocalDateTime readExternal(DataInput r2) {
        DataInput r3 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.aiagent.plugin");
        return of(LocalDate.readExternal(r3), LocalTime.readExternal(r3));
    }
}
