package org.threeten.bp;

import com.blankj.utilcode.constant.CacheConstants;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalDateTime extends org.threeten.bp.chrono.b implements Temporal, TemporalAdjuster, Serializable {
    public static final TemporalQuery<LocalDateTime> FROM = null;
    public static final LocalDateTime MAX = null;
    public static final LocalDateTime MIN = null;
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;

    public static class a implements TemporalQuery {
        public a() {
        }

        public LocalDateTime a(TemporalAccessor r10) {
            return LocalDateTime.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23071a = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23071a = r10;
            r10[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f23071a[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f23071a[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f23071a[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f23071a[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f23071a[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f23071a[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        MIN = of(LocalDate.MIN, LocalTime.MIN);
        MAX = of(LocalDate.MAX, LocalTime.MAX);
        FROM = new a();
    }

    private LocalDateTime(LocalDate r10, LocalTime r11) {
        this.date = r10;
        this.time = r11;
    }

    private int compareTo0(LocalDateTime r10) {
        int r11 = this.date.compareTo0(r10.toLocalDate());
        if (r11 == 0) goto L5;
        return r11;
    L5:
        return this.time.compareTo2(r10.toLocalTime());
    }

    public static LocalDateTime from(TemporalAccessor r10) {
        if ((r10 instanceof LocalDateTime) == false) goto L7;
        return (LocalDateTime) r10;
    L7:
        if ((r10 instanceof ZonedDateTime) == true) goto L9;
        return new LocalDateTime(LocalDate.from(r10), LocalTime.from(r10));
    L13:
        throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    L9:
        return ((ZonedDateTime) r10).toLocalDateTime();
    }

    public static LocalDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDateTime of(int r10, Month r11, int r12, int r13, int r14) {
        return new LocalDateTime(LocalDate.of(r10, r11, r12), LocalTime.of(r13, r14));
    }

    public static LocalDateTime ofEpochSecond(long r10, int r11, ZoneOffset r12) {
        d.h(r12, "offset");
        long r13 = r10 + ((long) r12.getTotalSeconds());
        return new LocalDateTime(LocalDate.ofEpochDay(d.d(r13, 86400)), LocalTime.ofSecondOfDay(d.f(r13, CacheConstants.DAY), r11));
    }

    public static LocalDateTime ofInstant(Instant r10, ZoneId r11) {
        d.h(r10, "instant");
        d.h(r11, "zone");
        ZoneOffset r12 = r11.getRules().getOffset(r10);
        return ofEpochSecond(r10.getEpochSecond(), r10.getNano(), r12);
    }

    public static LocalDateTime parse(CharSequence r10) {
        return parse(r10, DateTimeFormatter.f23104n);
    }

    private LocalDateTime plusWithOverflow(LocalDate r19, long r20, long r22, long r24, long r26, int r28) {
        if ((((r20 | r22) | r24) | r26) == 0) goto L5;
        long r12 = r28;
        long r10 = this.time.toNanoOfDay();
        long r14 = (((((r26 % 86400000000000L) + ((r24 % 86400) * 1000000000)) + ((r22 % 1440) * 60000000000L)) + ((r20 % 24) * 3600000000000L)) * r12) + r10;
        long r11 = (((((r26 / 86400000000000L) + (r24 / 86400)) + (r22 / 1440)) + (r20 / 24)) * r12) + d.d(r14, 86400000000000L);
        long r13 = d.g(r14, 86400000000000L);
        if (r13 != r10) goto L9;
        LocalTime r15 = this.time;
    L11:
        return with(r19.plusDays(r11), r15);
    L9:
        r15 = LocalTime.ofNanoOfDay(r13);
        goto L11
    L5:
        return with(r19, this.time);
    }

    public static LocalDateTime readExternal(DataInput r10) throws IOException {
        return of(LocalDate.readExternal(r10), LocalTime.readExternal(r10));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return super.adjustInto(r10);
    }

    public OffsetDateTime atOffset(ZoneOffset r10) {
        return OffsetDateTime.of(this, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.d atZone(ZoneId r10) {
        return atZone(r10);
    }

    @Override // org.threeten.bp.chrono.b, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return compareTo((org.threeten.bp.chrono.b) r10);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LocalDateTime) == false) goto L14;
        LocalDateTime r11 = (LocalDateTime) r10;
        if (this.date.equals(r11.date) == false) goto L13;
        if (this.time.equals(r11.time) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // org.threeten.bp.chrono.b
    public String format(DateTimeFormatter r10) {
        return super.format(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L10;
        if (r10.isTimeBased() == false) goto L8;
        return this.time.get(r10);
    L8:
        return this.date.get(r10);
    L10:
        return super.get(r10);
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.date.getDayOfYear();
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L10;
        if (r10.isTimeBased() == false) goto L8;
        return this.time.getLong(r10);
    L8:
        return this.date.getLong(r10);
    L10:
        return r10.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public Month getMonth() {
        return this.date.getMonth();
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    @Override // org.threeten.bp.chrono.b
    public int hashCode() {
        int r10 = this.date.hashCode();
        return this.time.hashCode() ^ r10;
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isAfter(org.threeten.bp.chrono.b r10) {
        if ((r10 instanceof LocalDateTime) == false) goto L10;
        if (compareTo0((LocalDateTime) r10) <= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isAfter(r10);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isBefore(org.threeten.bp.chrono.b r10) {
        if ((r10 instanceof LocalDateTime) == false) goto L10;
        if (compareTo0((LocalDateTime) r10) >= 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isBefore(r10);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isEqual(org.threeten.bp.chrono.b r10) {
        if ((r10 instanceof LocalDateTime) == false) goto L10;
        if (compareTo0((LocalDateTime) r10) != 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.isEqual(r10);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 == null) goto L16;
        if (r10.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r10.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r10.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public LocalDateTime minusDays(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plusDays(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusDays(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public LocalDateTime minusHours(long r12) {
        return plusWithOverflow(this.date, r12, 0, 0, 0, -1);
    }

    public LocalDateTime minusMinutes(long r12) {
        return plusWithOverflow(this.date, 0, r12, 0, 0, -1);
    }

    public LocalDateTime minusMonths(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plusMonths(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMonths(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public LocalDateTime minusNanos(long r12) {
        return plusWithOverflow(this.date, 0, 0, 0, r12, -1);
    }

    public LocalDateTime minusSeconds(long r12) {
        return plusWithOverflow(this.date, 0, 0, r12, 0, -1);
    }

    public LocalDateTime minusWeeks(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plusWeeks(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusWeeks(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public LocalDateTime minusYears(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plusYears(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusYears(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public LocalDateTime plusDays(long r10) {
        return with(this.date.plusDays(r10), this.time);
    }

    public LocalDateTime plusHours(long r12) {
        return plusWithOverflow(this.date, r12, 0, 0, 0, 1);
    }

    public LocalDateTime plusMinutes(long r12) {
        return plusWithOverflow(this.date, 0, r12, 0, 0, 1);
    }

    public LocalDateTime plusMonths(long r10) {
        return with(this.date.plusMonths(r10), this.time);
    }

    public LocalDateTime plusNanos(long r12) {
        return plusWithOverflow(this.date, 0, 0, 0, r12, 1);
    }

    public LocalDateTime plusSeconds(long r12) {
        return plusWithOverflow(this.date, 0, 0, r12, 0, 1);
    }

    public LocalDateTime plusWeeks(long r10) {
        return with(this.date.plusWeeks(r10), this.time);
    }

    public LocalDateTime plusYears(long r10) {
        return with(this.date.plusYears(r10), this.time);
    }

    @Override // org.threeten.bp.chrono.b, ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.b()) goto L7;
        return (R) toLocalDate();
    L7:
        return (R) super.query(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L10;
        if (r10.isTimeBased() == false) goto L8;
        return this.time.range(r10);
    L8:
        return this.date.range(r10);
    L10:
        return r10.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a toLocalDate() {
        return toLocalDate();
    }

    @Override // org.threeten.bp.chrono.b
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.chrono.b
    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    public LocalDateTime truncatedTo(TemporalUnit r10) {
        return with(this.date, this.time.truncatedTo(r10));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r12, TemporalUnit r13) {
        LocalDateTime r14 = from(r12);
        if ((r13 instanceof ChronoUnit) == false) goto L46;
        ChronoUnit r10 = (ChronoUnit) r13;
        if (r10.isTimeBased() == false) goto L33;
        long r11 = this.date.daysUntil(r14.date);
        long r15 = r14.time.toNanoOfDay() - this.time.toNanoOfDay();
        if (r11 > 0) goto L9;
    L11:
        if (r11 < 0) goto L13;
    L16:
        switch(b.f23071a[r10.ordinal()]) {
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
        return d.j(d.l(r11, 2), r15 / 43200000000000L);
    L22:
        return d.j(d.l(r11, 24), r15 / 3600000000000L);
    L24:
        return d.j(d.l(r11, 1440), r15 / 60000000000L);
    L26:
        return d.j(d.l(r11, CacheConstants.DAY), r15 / 1000000000);
    L28:
        return d.j(d.m(r11, 86400000), r15 / BatteryFactorConfig.WIFI_BPS);
    L30:
        return d.j(d.m(r11, 86400000000L), r15 / 1000);
    L32:
        return d.j(d.m(r11, 86400000000000L), r15);
    L13:
        if (r15 <= 0) goto L16;
        r11 = r11 + 1;
        r15 = r15 - 86400000000000L;
        goto L16
    L9:
        if (r15 >= 0) goto L11;
        r11 = r11 - 1;
        r15 = r15 + 86400000000000L;
        goto L16
    L33:
        LocalDate r16 = r14.date;
        if (r16.isAfter(this.date) == false) goto L39;
        if (r14.time.isBefore(this.time) == false) goto L39;
        r16 = r16.minusDays(1);
    L44:
        return this.date.until(r16, r13);
    L39:
        if (r16.isBefore(this.date) == false) goto L44;
        if (r14.time.isAfter(this.time) == false) goto L44;
        r16 = r16.plusDays(1);
        goto L44
    L46:
        return r13.between(this, r14);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b with(TemporalAdjuster r10) {
        return with(r10);
    }

    public LocalDateTime withDayOfMonth(int r10) {
        return with(this.date.withDayOfMonth(r10), this.time);
    }

    public LocalDateTime withDayOfYear(int r10) {
        return with(this.date.withDayOfYear(r10), this.time);
    }

    public LocalDateTime withHour(int r10) {
        LocalTime r11 = this.time.withHour(r10);
        return with(this.date, r11);
    }

    public LocalDateTime withMinute(int r10) {
        LocalTime r11 = this.time.withMinute(r10);
        return with(this.date, r11);
    }

    public LocalDateTime withMonth(int r10) {
        return with(this.date.withMonth(r10), this.time);
    }

    public LocalDateTime withNano(int r10) {
        LocalTime r11 = this.time.withNano(r10);
        return with(this.date, r11);
    }

    public LocalDateTime withSecond(int r10) {
        LocalTime r11 = this.time.withSecond(r10);
        return with(this.date, r11);
    }

    public LocalDateTime withYear(int r10) {
        return with(this.date.withYear(r10), this.time);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        this.date.writeExternal(r10);
        this.time.writeExternal(r10);
    }

    public static LocalDateTime now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static LocalDateTime parse(CharSequence r10, DateTimeFormatter r11) {
        d.h(r11, "formatter");
        return (LocalDateTime) r11.n(r10, FROM);
    }

    @Override // org.threeten.bp.chrono.b
    public ZonedDateTime atZone(ZoneId r10) {
        return ZonedDateTime.of(this, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public int compareTo(org.threeten.bp.chrono.b r10) {
        if ((r10 instanceof LocalDateTime) == false) goto L7;
        return compareTo0((LocalDateTime) r10);
    L7:
        return super.compareTo(r10);
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.b
    public LocalDate toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static LocalDateTime now(Clock r10) {
        d.h(r10, "clock");
        Instant r11 = r10.instant();
        ZoneOffset r12 = r10.getZone().getRules().getOffset(r11);
        return ofEpochSecond(r11.getEpochSecond(), r11.getNano(), r12);
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public static LocalDateTime of(int r10, Month r11, int r12, int r13, int r14, int r15) {
        return new LocalDateTime(LocalDate.of(r10, r11, r12), LocalTime.of(r13, r14, r15));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r10) {
        if ((r10 instanceof ChronoUnit) == true) goto L5;
        if (r10 == null) goto L16;
        if (r10.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r10.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r10.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    private LocalDateTime with(LocalDate r10, LocalTime r11) {
        if (this.date != r10) goto L8;
        if (this.time != r11) goto L8;
        return this;
    L8:
        return new LocalDateTime(r10, r11);
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public LocalDateTime minus(TemporalAmount r10) {
        return (LocalDateTime) r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(TemporalAmount r10) {
        return (LocalDateTime) r10.addTo(this);
    }

    @Override // org.threeten.bp.chrono.b, ig.b, org.threeten.bp.temporal.Temporal
    public LocalDateTime minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalDateTime this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDateTime plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L23;
        switch(b.f23071a[((ChronoUnit) r11).ordinal()]) {
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
        return with(this.date.plus(r10, r11), this.time);
    L9:
        return plusDays(r10 / 256).plusHours((r10 % 256) * 12);
    L11:
        return plusHours(r10);
    L13:
        return plusMinutes(r10);
    L15:
        return plusSeconds(r10);
    L17:
        return plusDays(r10 / 86400000).plusNanos((r10 % 86400000) * BatteryFactorConfig.WIFI_BPS);
    L19:
        return plusDays(r10 / 86400000000L).plusNanos((r10 % 86400000000L) * 1000);
    L21:
        return plusNanos(r10);
    L23:
        return (LocalDateTime) r11.addTo(this, r10);
    }

    public static LocalDateTime of(int r10, Month r11, int r12, int r13, int r14, int r15, int r16) {
        return new LocalDateTime(LocalDate.of(r10, r11, r12), LocalTime.of(r13, r14, r15, r16));
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalAdjuster r10) {
        if ((r10 instanceof LocalDate) == false) goto L7;
        return with((LocalDate) r10, this.time);
    L7:
        if ((r10 instanceof LocalTime) == false) goto L11;
        return with(this.date, (LocalTime) r10);
    L11:
        if ((r10 instanceof LocalDateTime) == false) goto L15;
        return (LocalDateTime) r10;
    L15:
        return (LocalDateTime) r10.adjustInto(this);
    }

    public static LocalDateTime of(int r10, int r11, int r12, int r13, int r14) {
        return new LocalDateTime(LocalDate.of(r10, r11, r12), LocalTime.of(r13, r14));
    }

    public static LocalDateTime of(int r10, int r11, int r12, int r13, int r14, int r15) {
        return new LocalDateTime(LocalDate.of(r10, r11, r12), LocalTime.of(r13, r14, r15));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalDateTime with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L11;
        if (r10.isTimeBased() == false) goto L9;
        return with(this.date, this.time.with(r10, r11));
    L9:
        return with(this.date.with(r10, r11), this.time);
    L11:
        return (LocalDateTime) r10.adjustInto(this, r11);
    }

    public static LocalDateTime of(int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        return new LocalDateTime(LocalDate.of(r10, r11, r12), LocalTime.of(r13, r14, r15, r16));
    }

    public static LocalDateTime of(LocalDate r10, LocalTime r11) {
        d.h(r10, "date");
        d.h(r11, "time");
        return new LocalDateTime(r10, r11);
    }
}
