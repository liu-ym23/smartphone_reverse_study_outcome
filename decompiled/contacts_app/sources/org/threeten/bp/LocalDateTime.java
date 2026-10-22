package org.threeten.bp;

import com.android.contacts.common.compat.DirectorySdkCompat;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
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
public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Temporal, TemporalAdjuster, Serializable {
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
    public /* bridge */ /* synthetic */ int compareTo(Object r1) {
        return compareTo((ChronoLocalDateTime) r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDateTime minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDateTime minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDateTime plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDateTime plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public /* bridge */ /* synthetic */ ChronoLocalDate toLocalDate() {
        return toLocalDate();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDateTime with(TemporalAdjuster r1) {
        return with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDateTime with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r1) {
        return with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
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
        Jdk8Methods.requireNonNull(r2, DBHelper.COL_TIME);
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
        return new LocalDateTime(LocalDate.ofEpochDay(Jdk8Methods.floorDiv(r3, TimeUtils.SECONDS_PER_DAY)), LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(r3, 86400), r4));
    }

    public static LocalDateTime from(TemporalAccessor r3) {
        if ((r3 instanceof LocalDateTime) == false) goto L7;
        return (LocalDateTime) r3;
    L7:
        if ((r3 instanceof ZonedDateTime) == true) goto L9;
        return new LocalDateTime(LocalDate.from(r3), LocalTime.from(r3));
    L13:
        throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + r3 + ", type " + r3.getClass().getName());
    L9:
        return ((ZonedDateTime) r3).toLocalDateTime();
    }

    public static LocalDateTime parse(CharSequence r1) {
        return parse(r1, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static LocalDateTime parse(CharSequence r1, DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return (LocalDateTime) r2.parse(r1, FROM);
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
        if ((r4 instanceof ChronoField) == true) goto L5;
        if (r4 == null) goto L16;
        if (r4.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r4.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r4.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r4) {
        if ((r4 instanceof ChronoUnit) == true) goto L5;
        if (r4 == null) goto L16;
        if (r4.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r4.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r4.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r2) {
        if ((r2 instanceof ChronoField) == false) goto L10;
        if (r2.isTimeBased() == false) goto L8;
        return this.time.range(r2);
    L8:
        return this.date.range(r2);
    L10:
        return r2.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r2) {
        if ((r2 instanceof ChronoField) == false) goto L10;
        if (r2.isTimeBased() == false) goto L8;
        return this.time.get(r2);
    L8:
        return this.date.get(r2);
    L10:
        return super.get(r2);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r2) {
        if ((r2 instanceof ChronoField) == false) goto L10;
        if (r2.isTimeBased() == false) goto L8;
        return this.time.getLong(r2);
    L8:
        return this.date.getLong(r2);
    L10:
        return r2.getFrom(this);
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
    public LocalDateTime with(TemporalAdjuster r2) {
        if ((r2 instanceof LocalDate) == false) goto L7;
        return with((LocalDate) r2, this.time);
    L7:
        if ((r2 instanceof LocalTime) == false) goto L11;
        return with(this.date, (LocalTime) r2);
    L11:
        if ((r2 instanceof LocalDateTime) == false) goto L15;
        return (LocalDateTime) r2;
    L15:
        return (LocalDateTime) r2.adjustInto(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalField r3, long r4) {
        if ((r3 instanceof ChronoField) == false) goto L11;
        if (r3.isTimeBased() == false) goto L9;
        return with(this.date, this.time.with(r3, r4));
    L9:
        return with(this.date.with(r3, r4), this.time);
    L11:
        return (LocalDateTime) r3.adjustInto(this, r4);
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
        return with(this.date, this.time.truncatedTo(r3));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(TemporalAmount r1) {
        return (LocalDateTime) r1.addTo(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(long r5, TemporalUnit r7) {
        if ((r7 instanceof ChronoUnit) == false) goto L23;
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) r7).ordinal()]) {
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
        return with(this.date.plus(r5, r7), this.time);
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
        return (LocalDateTime) r7.addTo(this, r5);
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
    public LocalDateTime minus(TemporalAmount r1) {
        return (LocalDateTime) r1.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public LocalDateTime minus(long r3, TemporalUnit r5) {
        if (r3 != Long.MIN_VALUE) goto L5;
        LocalDateTime this = plus(Long.MAX_VALUE, r5);
        long r4 = 1;
    L7:
        return this.plus(r4, r5);
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
        long r4 = (((r26 / 86400000000000L) + (r24 / TimeUtils.SECONDS_PER_DAY)) + (r22 / 1440)) + (r20 / 24);
        long r12 = r28;
        long r14 = (((r26 % 86400000000000L) + ((r24 % TimeUtils.SECONDS_PER_DAY) * DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT)) + ((r22 % 1440) * 60000000000L)) + ((r20 % 24) * 3600000000000L);
        long r6 = this.time.toNanoOfDay();
        long r15 = (r14 * r12) + r6;
        long r5 = (r4 * r12) + Jdk8Methods.floorDiv(r15, 86400000000000L);
        long r2 = Jdk8Methods.floorMod(r15, 86400000000000L);
        if (r2 != r6) goto L9;
        LocalTime r3 = this.time;
    L11:
        return with(r19.plusDays(r5), r3);
    L9:
        r3 = LocalTime.ofNanoOfDay(r2);
        goto L11
    L5:
        return with(r19, this.time);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.localDate()) goto L7;
        return (R) toLocalDate();
    L7:
        return (R) super.query(r2);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r1) {
        return super.adjustInto(r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r12, TemporalUnit r13) {
        LocalDateTime r14 = from(r12);
        if ((r13 instanceof ChronoUnit) == false) goto L46;
        ChronoUnit r0 = (ChronoUnit) r13;
        if (r0.isTimeBased() == false) goto L33;
        long r4 = this.date.daysUntil(r14.date);
        long r6 = r14.time.toNanoOfDay() - this.time.toNanoOfDay();
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
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r13);
    L20:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 2), r6 / 43200000000000L);
    L22:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 24), r6 / 3600000000000L);
    L24:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 1440), r6 / 60000000000L);
    L26:
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r4, 86400), r6 / DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT);
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
        LocalDate r1 = r14.date;
        if (r1.isAfter(this.date) == false) goto L39;
        if (r14.time.isBefore(this.time) == false) goto L39;
        r1 = r1.minusDays(1);
    L44:
        return this.date.until(r1, r13);
    L39:
        if (r1.isBefore(this.date) == false) goto L44;
        if (r14.time.isAfter(this.time) == false) goto L44;
        r1 = r1.plusDays(1);
        goto L44
    L46:
        return r13.between(this, r14);
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
    public int compareTo(ChronoLocalDateTime<?> r2) {
        if ((r2 instanceof LocalDateTime) == false) goto L7;
        return compareTo0((LocalDateTime) r2);
    L7:
        return super.compareTo(r2);
    }

    private int compareTo0(LocalDateTime r3) {
        int r0 = this.date.compareTo0(r3.toLocalDate());
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.time.compareTo2(r3.toLocalTime());
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isAfter(ChronoLocalDateTime<?> r2) {
        if ((r2 instanceof LocalDateTime) == false) goto L10;
        if (compareTo0((LocalDateTime) r2) <= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isAfter(r2);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isBefore(ChronoLocalDateTime<?> r2) {
        if ((r2 instanceof LocalDateTime) == false) goto L10;
        if (compareTo0((LocalDateTime) r2) >= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isBefore(r2);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean isEqual(ChronoLocalDateTime<?> r2) {
        if ((r2 instanceof LocalDateTime) == false) goto L10;
        if (compareTo0((LocalDateTime) r2) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isEqual(r2);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocalDateTime) == false) goto L14;
        LocalDateTime r6 = (LocalDateTime) r5;
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

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r2) throws IOException {
        this.date.writeExternal(r2);
        this.time.writeExternal(r2);
    }

    static LocalDateTime readExternal(DataInput r1) throws IOException {
        return of(LocalDate.readExternal(r1), LocalTime.readExternal(r1));
    }
}
