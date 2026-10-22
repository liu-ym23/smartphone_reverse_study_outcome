package org.threeten.bp;

import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Comparator;
import org.threeten.bp.chrono.IsoChronology;
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
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class OffsetDateTime extends ig.b implements Temporal, TemporalAdjuster, Comparable<OffsetDateTime>, Serializable {
    public static final TemporalQuery<OffsetDateTime> FROM = null;
    private static final Comparator<OffsetDateTime> INSTANT_COMPARATOR = null;
    public static final OffsetDateTime MAX = null;
    public static final OffsetDateTime MIN = null;
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;

    public static class a implements TemporalQuery {
        public a() {
        }

        public OffsetDateTime a(TemporalAccessor r10) {
            return OffsetDateTime.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static class b implements Comparator {
        public b() {
        }

        public int a(OffsetDateTime r10, OffsetDateTime r11) {
            int r12 = d.b(r10.toEpochSecond(), r11.toEpochSecond());
            if (r12 == 0) goto L5;
            return r12;
        L5:
            return d.b(r10.getNano(), r11.getNano());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((OffsetDateTime) r10, (OffsetDateTime) r11);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23076a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23076a = r10;
            r10[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f23076a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        MIN = LocalDateTime.MIN.atOffset(ZoneOffset.MAX);
        MAX = LocalDateTime.MAX.atOffset(ZoneOffset.MIN);
        FROM = new a();
        INSTANT_COMPARATOR = new b();
    }

    private OffsetDateTime(LocalDateTime r10, ZoneOffset r11) {
        this.dateTime = (LocalDateTime) d.h(r10, "dateTime");
        this.offset = (ZoneOffset) d.h(r11, "offset");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [org.threeten.bp.OffsetDateTime] */
    public static OffsetDateTime from(Object r10) {
        if ((r10 instanceof OffsetDateTime) == true) goto L5;
        ZoneOffset r11 = ZoneOffset.from(r10);     // Catch: DateTimeException -> L11
        r10 = of(LocalDateTime.from(r10), r11);     // Catch: DateTimeException -> L9
        return r10;
    L9:
        return ofInstant(Instant.from(r10), r11);
    L12:
        throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    L5:
        return (OffsetDateTime) r10;
    }

    public static OffsetDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetDateTime of(LocalDate r10, LocalTime r11, ZoneOffset r12) {
        return new OffsetDateTime(LocalDateTime.of(r10, r11), r12);
    }

    public static OffsetDateTime ofInstant(Instant r10, ZoneId r11) {
        d.h(r10, "instant");
        d.h(r11, "zone");
        ZoneOffset r12 = r11.getRules().getOffset(r10);
        return new OffsetDateTime(LocalDateTime.ofEpochSecond(r10.getEpochSecond(), r10.getNano(), r12), r12);
    }

    public static OffsetDateTime parse(CharSequence r10) {
        return parse(r10, DateTimeFormatter.f23105o);
    }

    public static OffsetDateTime readExternal(DataInput r10) throws IOException {
        return of(LocalDateTime.readExternal(r10), ZoneOffset.readExternal(r10));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Comparator<OffsetDateTime> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    public ZonedDateTime atZoneSameInstant(ZoneId r10) {
        return ZonedDateTime.ofInstant(this.dateTime, this.offset, r10);
    }

    public ZonedDateTime atZoneSimilarLocal(ZoneId r10) {
        return ZonedDateTime.ofLocal(this.dateTime, r10, this.offset);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OffsetDateTime r10) {
        return compareTo2(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OffsetDateTime) == false) goto L14;
        OffsetDateTime r11 = (OffsetDateTime) r10;
        if (this.dateTime.equals(r11.dateTime) == false) goto L13;
        if (this.offset.equals(r11.offset) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String format(DateTimeFormatter r10) {
        d.h(r10, "formatter");
        return r10.d(this);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        int r11 = c.f23076a[((ChronoField) r10).ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L11;
        return this.dateTime.get(r10);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new DateTimeException("Field too large for an int: " + r10);
    L15:
        return super.get(r10);
    }

    public int getDayOfMonth() {
        return this.dateTime.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.dateTime.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.dateTime.getDayOfYear();
    }

    public int getHour() {
        return this.dateTime.getHour();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        int r11 = c.f23076a[((ChronoField) r10).ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L11;
        return this.dateTime.getLong(r10);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        return toEpochSecond();
    L15:
        return r10.getFrom(this);
    }

    public int getMinute() {
        return this.dateTime.getMinute();
    }

    public Month getMonth() {
        return this.dateTime.getMonth();
    }

    public int getMonthValue() {
        return this.dateTime.getMonthValue();
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    public int hashCode() {
        int r10 = this.dateTime.hashCode();
        return this.offset.hashCode() ^ r10;
    }

    public boolean isAfter(OffsetDateTime r10) {
        long r11 = toEpochSecond();
        long r12 = r10.toEpochSecond();
        if (r11 > r12) goto L9;
        if (r11 == r12) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() <= r10.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(OffsetDateTime r10) {
        long r11 = toEpochSecond();
        long r12 = r10.toEpochSecond();
        if (r11 < r12) goto L9;
        if (r11 == r12) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() >= r10.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(OffsetDateTime r10) {
        if (toEpochSecond() == r10.toEpochSecond()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalTime().getNano() != r10.toLocalTime().getNano()) goto L7;
        return true;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L9;
        if (r10 != null) goto L6;
    L8:
        return false;
    L6:
        if (r10.isSupportedBy(this) == false) goto L8;
    L9:
        return true;
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public OffsetDateTime minusDays(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusDays(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusDays(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public OffsetDateTime minusHours(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusHours(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusHours(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public OffsetDateTime minusMinutes(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusMinutes(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMinutes(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public OffsetDateTime minusMonths(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusMonths(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMonths(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public OffsetDateTime minusNanos(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusNanos(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusNanos(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public OffsetDateTime minusSeconds(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusSeconds(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusSeconds(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public OffsetDateTime minusWeeks(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusWeeks(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusWeeks(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public OffsetDateTime minusYears(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plusYears(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusYears(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public OffsetDateTime plusDays(long r10) {
        return with(this.dateTime.plusDays(r10), this.offset);
    }

    public OffsetDateTime plusHours(long r10) {
        return with(this.dateTime.plusHours(r10), this.offset);
    }

    public OffsetDateTime plusMinutes(long r10) {
        return with(this.dateTime.plusMinutes(r10), this.offset);
    }

    public OffsetDateTime plusMonths(long r10) {
        return with(this.dateTime.plusMonths(r10), this.offset);
    }

    public OffsetDateTime plusNanos(long r10) {
        return with(this.dateTime.plusNanos(r10), this.offset);
    }

    public OffsetDateTime plusSeconds(long r10) {
        return with(this.dateTime.plusSeconds(r10), this.offset);
    }

    public OffsetDateTime plusWeeks(long r10) {
        return with(this.dateTime.plusWeeks(r10), this.offset);
    }

    public OffsetDateTime plusYears(long r10) {
        return with(this.dateTime.plusYears(r10), this.offset);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r10 != org.threeten.bp.temporal.b.e()) goto L11;
        return (R) ChronoUnit.NANOS;
    L11:
        if (r10 == org.threeten.bp.temporal.b.d()) goto L30;
        if (r10 == org.threeten.bp.temporal.b.f()) goto L30;
        if (r10 != org.threeten.bp.temporal.b.b()) goto L20;
        return (R) toLocalDate();
    L20:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L24;
        return (R) toLocalTime();
    L24:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L28;
        return null;
    L28:
        return (R) super.query(r10);
    L30:
        return (R) getOffset();
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L14;
        if (r10 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r10 == ChronoField.OFFSET_SECONDS) goto L12;
        return this.dateTime.range(r10);
    L12:
        return r10.range();
    L14:
        return r10.rangeRefinedBy(this);
    }

    public long toEpochSecond() {
        return this.dateTime.toEpochSecond(this.offset);
    }

    public Instant toInstant() {
        return this.dateTime.toInstant(this.offset);
    }

    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetTime toOffsetTime() {
        return OffsetTime.of(this.dateTime.toLocalTime(), this.offset);
    }

    public String toString() {
        return this.dateTime.toString() + this.offset.toString();
    }

    public ZonedDateTime toZonedDateTime() {
        return ZonedDateTime.of(this.dateTime, this.offset);
    }

    public OffsetDateTime truncatedTo(TemporalUnit r10) {
        return with(this.dateTime.truncatedTo(r10), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        OffsetDateTime r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L7;
        OffsetDateTime r13 = r12.withOffsetSameInstant(this.offset);
        return this.dateTime.until(r13.dateTime, r11);
    L7:
        return r11.between(this, r12);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public OffsetDateTime withDayOfMonth(int r10) {
        return with(this.dateTime.withDayOfMonth(r10), this.offset);
    }

    public OffsetDateTime withDayOfYear(int r10) {
        return with(this.dateTime.withDayOfYear(r10), this.offset);
    }

    public OffsetDateTime withHour(int r10) {
        return with(this.dateTime.withHour(r10), this.offset);
    }

    public OffsetDateTime withMinute(int r10) {
        return with(this.dateTime.withMinute(r10), this.offset);
    }

    public OffsetDateTime withMonth(int r10) {
        return with(this.dateTime.withMonth(r10), this.offset);
    }

    public OffsetDateTime withNano(int r10) {
        return with(this.dateTime.withNano(r10), this.offset);
    }

    public OffsetDateTime withOffsetSameInstant(ZoneOffset r10) {
        if (r10.equals(this.offset) == false) goto L6;
        return this;
    L6:
        return new OffsetDateTime(this.dateTime.plusSeconds(r10.getTotalSeconds() - this.offset.getTotalSeconds()), r10);
    }

    public OffsetDateTime withOffsetSameLocal(ZoneOffset r10) {
        return with(this.dateTime, r10);
    }

    public OffsetDateTime withSecond(int r10) {
        return with(this.dateTime.withSecond(r10), this.offset);
    }

    public OffsetDateTime withYear(int r10) {
        return with(this.dateTime.withYear(r10), this.offset);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        this.dateTime.writeExternal(r10);
        this.offset.writeExternal(r10);
    }

    public static OffsetDateTime now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static OffsetDateTime parse(CharSequence r10, DateTimeFormatter r11) {
        d.h(r11, "formatter");
        return (OffsetDateTime) r11.n(r10, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OffsetDateTime r10) {
        if (getOffset().equals(r10.getOffset()) == true) goto L5;
        int r11 = d.b(toEpochSecond(), r10.toEpochSecond());
        if (r11 != 0) goto L12;
        int r12 = toLocalTime().getNano() - r10.toLocalTime().getNano();
        if (r12 == 0) goto L11;
        return r12;
    L11:
        return toLocalDateTime().compareTo(r10.toLocalDateTime());
    L12:
        return r11;
    L5:
        return toLocalDateTime().compareTo(r10.toLocalDateTime());
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

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static OffsetDateTime now(Clock r10) {
        d.h(r10, "clock");
        Instant r11 = r10.instant();
        return ofInstant(r11, r10.getZone().getRules().getOffset(r11));
    }

    public static OffsetDateTime of(LocalDateTime r10, ZoneOffset r11) {
        return new OffsetDateTime(r10, r11);
    }

    private OffsetDateTime with(LocalDateTime r10, ZoneOffset r11) {
        if (this.dateTime != r10) goto L8;
        if (this.offset.equals(r11) == false) goto L8;
        return this;
    L8:
        return new OffsetDateTime(r10, r11);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public OffsetDateTime minus(TemporalAmount r10) {
        return (OffsetDateTime) r10.subtractFrom(this);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public OffsetDateTime plus(TemporalAmount r10) {
        return (OffsetDateTime) r10.addTo(this);
    }

    public static OffsetDateTime of(int r10, int r11, int r12, int r13, int r14, int r15, int r16, ZoneOffset r17) {
        return new OffsetDateTime(LocalDateTime.of(r10, r11, r12, r13, r14, r15, r16), r17);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public OffsetDateTime minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetDateTime this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L7;
        return with(this.dateTime.plus(r10, r11), this.offset);
    L7:
        return (OffsetDateTime) r11.addTo(this, r10);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public OffsetDateTime with(TemporalAdjuster r10) {
        if ((r10 instanceof LocalDate) == true) goto L24;
        if ((r10 instanceof LocalTime) == true) goto L24;
        if ((r10 instanceof LocalDateTime) == true) goto L24;
        if ((r10 instanceof Instant) == false) goto L14;
        return ofInstant((Instant) r10, this.offset);
    L14:
        if ((r10 instanceof ZoneOffset) == false) goto L18;
        return with(this.dateTime, (ZoneOffset) r10);
    L18:
        if ((r10 instanceof OffsetDateTime) == false) goto L22;
        return (OffsetDateTime) r10;
    L22:
        return (OffsetDateTime) r10.adjustInto(this);
    L24:
        return with(this.dateTime.with(r10), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetDateTime with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        ChronoField r12 = (ChronoField) r10;
        int r13 = c.f23076a[r12.ordinal()];
        if (r13 == 1) goto L13;
        if (r13 == 2) goto L11;
        return with(this.dateTime.with(r10, r11), this.offset);
    L11:
        return with(this.dateTime, ZoneOffset.ofTotalSeconds(r12.checkValidIntValue(r11)));
    L13:
        return ofInstant(Instant.ofEpochSecond(r11, getNano()), this.offset);
    L15:
        return (OffsetDateTime) r10.adjustInto(this, r11);
    }
}
