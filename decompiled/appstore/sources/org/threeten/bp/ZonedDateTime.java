package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.chrono.d;
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
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: loaded from: classes4.dex */
public final class ZonedDateTime extends d implements Temporal, Serializable {
    public static final TemporalQuery<ZonedDateTime> FROM = null;
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    public static class a implements TemporalQuery {
        public a() {
        }

        public ZonedDateTime a(TemporalAccessor r10) {
            return ZonedDateTime.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23085a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23085a = r10;
            r10[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f23085a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        FROM = new a();
    }

    private ZonedDateTime(LocalDateTime r10, ZoneOffset r11, ZoneId r12) {
        this.dateTime = r10;
        this.offset = r11;
        this.zone = r12;
    }

    private static ZonedDateTime create(long r10, int r11, ZoneId r12) {
        ZoneOffset r13 = r12.getRules().getOffset(Instant.ofEpochSecond(r10, r11));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(r10, r11, r13), r13, r12);
    }

    public static ZonedDateTime from(TemporalAccessor r10) {
        if ((r10 instanceof ZonedDateTime) == true) goto L5;
        ZoneId r11 = ZoneId.from(r10);     // Catch: DateTimeException -> L12
        ChronoField r12 = ChronoField.INSTANT_SECONDS;     // Catch: DateTimeException -> L12
        if (r10.isSupported(r12) == true) goto L15;
    L10:
        return of(LocalDateTime.from(r10), r11);
    L15:
        return create(r10.getLong(r12), r10.get(ChronoField.NANO_OF_SECOND), r11);
    L13:
        throw new DateTimeException("Unable to obtain ZonedDateTime from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    L5:
        return (ZonedDateTime) r10;
    }

    public static ZonedDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static ZonedDateTime of(LocalDate r10, LocalTime r11, ZoneId r12) {
        return of(LocalDateTime.of(r10, r11), r12);
    }

    public static ZonedDateTime ofInstant(Instant r10, ZoneId r11) {
        ig.d.h(r10, "instant");
        ig.d.h(r11, "zone");
        return create(r10.getEpochSecond(), r10.getNano(), r11);
    }

    private static ZonedDateTime ofLenient(LocalDateTime r10, ZoneOffset r11, ZoneId r12) {
        ig.d.h(r10, "localDateTime");
        ig.d.h(r11, "offset");
        ig.d.h(r12, "zone");
        if ((r12 instanceof ZoneOffset) == false) goto L10;
        if (r11.equals(r12) == true) goto L10;
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    L10:
        return new ZonedDateTime(r10, r11, r12);
    }

    public static ZonedDateTime ofLocal(LocalDateTime r10, ZoneId r11, ZoneOffset r12) {
        ig.d.h(r10, "localDateTime");
        ig.d.h(r11, "zone");
        if ((r11 instanceof ZoneOffset) == true) goto L5;
        ZoneRules r13 = r11.getRules();
        List r14 = r13.getValidOffsets(r10);
        if (r14.size() != 1) goto L10;
        r12 = (ZoneOffset) r14.get(0);
    L18:
        return new ZonedDateTime(r10, r12, r11);
    L10:
        if (r14.size() != 0) goto L12;
        ZoneOffsetTransition r15 = r13.getTransition(r10);
        r10 = r10.plusSeconds(r15.getDuration().getSeconds());
        r12 = r15.getOffsetAfter();
        goto L18
    L12:
        if (r12 != null) goto L14;
    L16:
        r12 = (ZoneOffset) ig.d.h(r14.get(0), "offset");
        goto L18
    L14:
        if (r14.contains(r12) == false) goto L16;
    L5:
        return new ZonedDateTime(r10, (ZoneOffset) r11, r11);
    }

    public static ZonedDateTime ofStrict(LocalDateTime r10, ZoneOffset r11, ZoneId r12) {
        ig.d.h(r10, "localDateTime");
        ig.d.h(r11, "offset");
        ig.d.h(r12, "zone");
        ZoneRules r13 = r12.getRules();
        if (r13.isValidOffset(r10, r11) == true) goto L13;
        ZoneOffsetTransition r14 = r13.getTransition(r10);
        if (r14 == null) goto L11;
        if (r14.isGap() == false) goto L11;
        throw new DateTimeException("LocalDateTime '" + r10 + "' does not exist in zone '" + r12 + "' due to a gap in the local time-line, typically caused by daylight savings");
    L11:
        throw new DateTimeException("ZoneOffset '" + r11 + "' is not valid for LocalDateTime '" + r10 + "' in zone '" + r12 + "'");
    L13:
        return new ZonedDateTime(r10, r11, r12);
    }

    public static ZonedDateTime parse(CharSequence r10) {
        return parse(r10, DateTimeFormatter.f23106p);
    }

    public static ZonedDateTime readExternal(DataInput r10) throws IOException {
        return ofLenient(LocalDateTime.readExternal(r10), ZoneOffset.readExternal(r10), (ZoneId) Ser.read(r10));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private ZonedDateTime resolveInstant(LocalDateTime r10) {
        return ofInstant(r10, this.offset, this.zone);
    }

    private ZonedDateTime resolveLocal(LocalDateTime r10) {
        return ofLocal(r10, this.zone, this.offset);
    }

    private ZonedDateTime resolveOffset(ZoneOffset r10) {
        if (r10.equals(this.offset) == false) goto L5;
    L8:
        return this;
    L5:
        if (this.zone.getRules().isValidOffset(this.dateTime, r10) == false) goto L8;
        return new ZonedDateTime(this.dateTime, r10, this.zone);
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ZonedDateTime) == false) goto L16;
        ZonedDateTime r11 = (ZonedDateTime) r10;
        if (this.dateTime.equals(r11.dateTime) == false) goto L15;
        if (this.offset.equals(r11.offset) == false) goto L15;
        if (this.zone.equals(r11.zone) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // org.threeten.bp.chrono.d
    public String format(DateTimeFormatter r10) {
        return super.format(r10);
    }

    @Override // org.threeten.bp.chrono.d, ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        int r11 = b.f23085a[((ChronoField) r10).ordinal()];
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

    @Override // org.threeten.bp.chrono.d, org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        int r11 = b.f23085a[((ChronoField) r10).ordinal()];
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

    @Override // org.threeten.bp.chrono.d
    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    @Override // org.threeten.bp.chrono.d
    public ZoneId getZone() {
        return this.zone;
    }

    public int hashCode() {
        int r10 = this.dateTime.hashCode() ^ this.offset.hashCode();
        return Integer.rotateLeft(this.zone.hashCode(), 3) ^ r10;
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

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ d minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public ZonedDateTime minusDays(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusDays(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusDays(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ZonedDateTime minusHours(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusHours(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusHours(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ZonedDateTime minusMinutes(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusMinutes(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMinutes(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ZonedDateTime minusMonths(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusMonths(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMonths(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ZonedDateTime minusNanos(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusNanos(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusNanos(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ZonedDateTime minusSeconds(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusSeconds(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusSeconds(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ZonedDateTime minusWeeks(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusWeeks(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusWeeks(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ZonedDateTime minusYears(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plusYears(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusYears(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ d plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public ZonedDateTime plusDays(long r10) {
        return resolveLocal(this.dateTime.plusDays(r10));
    }

    public ZonedDateTime plusHours(long r10) {
        return resolveInstant(this.dateTime.plusHours(r10));
    }

    public ZonedDateTime plusMinutes(long r10) {
        return resolveInstant(this.dateTime.plusMinutes(r10));
    }

    public ZonedDateTime plusMonths(long r10) {
        return resolveLocal(this.dateTime.plusMonths(r10));
    }

    public ZonedDateTime plusNanos(long r10) {
        return resolveInstant(this.dateTime.plusNanos(r10));
    }

    public ZonedDateTime plusSeconds(long r10) {
        return resolveInstant(this.dateTime.plusSeconds(r10));
    }

    public ZonedDateTime plusWeeks(long r10) {
        return resolveLocal(this.dateTime.plusWeeks(r10));
    }

    public ZonedDateTime plusYears(long r10) {
        return resolveLocal(this.dateTime.plusYears(r10));
    }

    @Override // org.threeten.bp.chrono.d, ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.b()) goto L7;
        return (R) toLocalDate();
    L7:
        return (R) super.query(r10);
    }

    @Override // org.threeten.bp.chrono.d, ig.c, org.threeten.bp.temporal.TemporalAccessor
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

    @Override // org.threeten.bp.chrono.d
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a toLocalDate() {
        return toLocalDate();
    }

    @Override // org.threeten.bp.chrono.d
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.b toLocalDateTime() {
        return toLocalDateTime();
    }

    @Override // org.threeten.bp.chrono.d
    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetDateTime toOffsetDateTime() {
        return OffsetDateTime.of(this.dateTime, this.offset);
    }

    public String toString() {
        String r10 = this.dateTime.toString() + this.offset.toString();
        if (this.offset != this.zone) goto L5;
        return r10;
    L5:
        return r10 + '[' + this.zone.toString() + ']';
    }

    public ZonedDateTime truncatedTo(TemporalUnit r10) {
        return resolveLocal(this.dateTime.truncatedTo(r10));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        ZonedDateTime r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L11;
        ZonedDateTime r13 = r12.withZoneSameInstant(this.zone);
        if (r11.isDateBased() == false) goto L9;
        return this.dateTime.until(r13.dateTime, r11);
    L9:
        return toOffsetDateTime().until(r13.toOffsetDateTime(), r11);
    L11:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ d with(TemporalAdjuster r10) {
        return with(r10);
    }

    public ZonedDateTime withDayOfMonth(int r10) {
        return resolveLocal(this.dateTime.withDayOfMonth(r10));
    }

    public ZonedDateTime withDayOfYear(int r10) {
        return resolveLocal(this.dateTime.withDayOfYear(r10));
    }

    /* JADX INFO: renamed from: withEarlierOffsetAtOverlap, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d m66withEarlierOffsetAtOverlap() {
        return withEarlierOffsetAtOverlap();
    }

    public ZonedDateTime withFixedOffsetZone() {
        if (this.zone.equals(this.offset) == true) goto L7;
        LocalDateTime r10 = this.dateTime;
        ZoneOffset r11 = this.offset;
        return new ZonedDateTime(r10, r11, r11);
    L7:
        return this;
    }

    public ZonedDateTime withHour(int r10) {
        return resolveLocal(this.dateTime.withHour(r10));
    }

    /* JADX INFO: renamed from: withLaterOffsetAtOverlap, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d m67withLaterOffsetAtOverlap() {
        return withLaterOffsetAtOverlap();
    }

    public ZonedDateTime withMinute(int r10) {
        return resolveLocal(this.dateTime.withMinute(r10));
    }

    public ZonedDateTime withMonth(int r10) {
        return resolveLocal(this.dateTime.withMonth(r10));
    }

    public ZonedDateTime withNano(int r10) {
        return resolveLocal(this.dateTime.withNano(r10));
    }

    public ZonedDateTime withSecond(int r10) {
        return resolveLocal(this.dateTime.withSecond(r10));
    }

    public ZonedDateTime withYear(int r10) {
        return resolveLocal(this.dateTime.withYear(r10));
    }

    @Override // org.threeten.bp.chrono.d
    public /* bridge */ /* synthetic */ d withZoneSameInstant(ZoneId r10) {
        return withZoneSameInstant(r10);
    }

    @Override // org.threeten.bp.chrono.d
    public /* bridge */ /* synthetic */ d withZoneSameLocal(ZoneId r10) {
        return withZoneSameLocal(r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        this.dateTime.writeExternal(r10);
        this.offset.writeExternal(r10);
        this.zone.write(r10);
    }

    public static ZonedDateTime now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static ZonedDateTime of(LocalDateTime r10, ZoneId r11) {
        return ofLocal(r10, r11, null);
    }

    public static ZonedDateTime parse(CharSequence r10, DateTimeFormatter r11) {
        ig.d.h(r11, "formatter");
        return (ZonedDateTime) r11.n(r10, FROM);
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

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ d minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ d plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.d
    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    @Override // org.threeten.bp.chrono.d
    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ d with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public ZonedDateTime withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition r10 = getZone().getRules().getTransition(this.dateTime);
        if (r10 != null) goto L5;
    L10:
        return this;
    L5:
        if (r10.isOverlap() == false) goto L10;
        ZoneOffset r11 = r10.getOffsetBefore();
        if (r11.equals(this.offset) == true) goto L10;
        return new ZonedDateTime(this.dateTime, r11, this.zone);
    }

    public ZonedDateTime withLaterOffsetAtOverlap() {
        ZoneOffsetTransition r10 = getZone().getRules().getTransition(toLocalDateTime());
        if (r10 == null) goto L8;
        ZoneOffset r11 = r10.getOffsetAfter();
        if (r11.equals(this.offset) == true) goto L8;
        return new ZonedDateTime(this.dateTime, r11, this.zone);
    L8:
        return this;
    }

    @Override // org.threeten.bp.chrono.d
    public ZonedDateTime withZoneSameInstant(ZoneId r10) {
        ig.d.h(r10, "zone");
        if (this.zone.equals(r10) == false) goto L6;
        return this;
    L6:
        return create(this.dateTime.toEpochSecond(this.offset), this.dateTime.getNano(), r10);
    }

    @Override // org.threeten.bp.chrono.d
    public ZonedDateTime withZoneSameLocal(ZoneId r10) {
        ig.d.h(r10, "zone");
        if (this.zone.equals(r10) == false) goto L6;
        return this;
    L6:
        return ofLocal(this.dateTime, r10, this.offset);
    }

    public static ZonedDateTime now(Clock r10) {
        ig.d.h(r10, "clock");
        return ofInstant(r10.instant(), r10.getZone());
    }

    public static ZonedDateTime of(int r10, int r11, int r12, int r13, int r14, int r15, int r16, ZoneId r17) {
        return ofLocal(LocalDateTime.of(r10, r11, r12, r13, r14, r15, r16), r17, null);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public static ZonedDateTime ofInstant(LocalDateTime r10, ZoneOffset r11, ZoneId r12) {
        ig.d.h(r10, "localDateTime");
        ig.d.h(r11, "offset");
        ig.d.h(r12, "zone");
        return create(r10.toEpochSecond(r11), r10.getNano(), r12);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public ZonedDateTime minus(TemporalAmount r10) {
        return (ZonedDateTime) r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public ZonedDateTime plus(TemporalAmount r10) {
        return (ZonedDateTime) r10.addTo(this);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public ZonedDateTime with(TemporalAdjuster r10) {
        if ((r10 instanceof LocalDate) == false) goto L7;
        return resolveLocal(LocalDateTime.of((LocalDate) r10, this.dateTime.toLocalTime()));
    L7:
        if ((r10 instanceof LocalTime) == false) goto L11;
        return resolveLocal(LocalDateTime.of(this.dateTime.toLocalDate(), (LocalTime) r10));
    L11:
        if ((r10 instanceof LocalDateTime) == false) goto L15;
        return resolveLocal((LocalDateTime) r10);
    L15:
        if ((r10 instanceof Instant) == false) goto L19;
        Instant r11 = (Instant) r10;
        return create(r11.getEpochSecond(), r11.getNano(), this.zone);
    L19:
        if ((r10 instanceof ZoneOffset) == false) goto L23;
        return resolveOffset((ZoneOffset) r10);
    L23:
        return (ZonedDateTime) r10.adjustInto(this);
    }

    @Override // org.threeten.bp.chrono.d, ig.b, org.threeten.bp.temporal.Temporal
    public ZonedDateTime minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ZonedDateTime this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public ZonedDateTime plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L11;
        if (r11.isDateBased() == false) goto L9;
        return resolveLocal(this.dateTime.plus(r10, r11));
    L9:
        return resolveInstant(this.dateTime.plus(r10, r11));
    L11:
        return (ZonedDateTime) r11.addTo(this, r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public ZonedDateTime with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        ChronoField r12 = (ChronoField) r10;
        int r13 = b.f23085a[r12.ordinal()];
        if (r13 == 1) goto L13;
        if (r13 == 2) goto L11;
        return resolveLocal(this.dateTime.with(r10, r11));
    L11:
        return resolveOffset(ZoneOffset.ofTotalSeconds(r12.checkValidIntValue(r11)));
    L13:
        return create(r11, getNano(), this.zone);
    L15:
        return (ZonedDateTime) r10.adjustInto(this, r11);
    }
}
