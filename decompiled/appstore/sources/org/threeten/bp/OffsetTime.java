package org.threeten.bp;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import ig.c;
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
public final class OffsetTime extends c implements Temporal, TemporalAdjuster, Comparable<OffsetTime>, Serializable {
    public static final TemporalQuery<OffsetTime> FROM = null;
    public static final OffsetTime MAX = null;
    public static final OffsetTime MIN = null;
    private static final long serialVersionUID = 7264499704384272492L;
    private final ZoneOffset offset;
    private final LocalTime time;

    public static class a implements TemporalQuery {
        public a() {
        }

        public OffsetTime a(TemporalAccessor r10) {
            return OffsetTime.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23077a = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23077a = r10;
            r10[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f23077a[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f23077a[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f23077a[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f23077a[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f23077a[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f23077a[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        MIN = LocalTime.MIN.atOffset(ZoneOffset.MAX);
        MAX = LocalTime.MAX.atOffset(ZoneOffset.MIN);
        FROM = new a();
    }

    private OffsetTime(LocalTime r10, ZoneOffset r11) {
        this.time = (LocalTime) d.h(r10, "time");
        this.offset = (ZoneOffset) d.h(r11, "offset");
    }

    public static OffsetTime from(TemporalAccessor r10) {
        if ((r10 instanceof OffsetTime) == true) goto L5;
        return new OffsetTime(LocalTime.from(r10), ZoneOffset.from(r10));
    L9:
        throw new DateTimeException("Unable to obtain OffsetTime from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    L5:
        return (OffsetTime) r10;
    }

    public static OffsetTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetTime of(LocalTime r10, ZoneOffset r11) {
        return new OffsetTime(r10, r11);
    }

    public static OffsetTime ofInstant(Instant r10, ZoneId r11) {
        d.h(r10, "instant");
        d.h(r11, "zone");
        ZoneOffset r12 = r11.getRules().getOffset(r10);
        long r13 = ((r10.getEpochSecond() % 86400) + ((long) r12.getTotalSeconds())) % 86400;
        if (r13 >= 0) goto L6;
        r13 = r13 + 86400;
    L6:
        return new OffsetTime(LocalTime.ofSecondOfDay(r13, r10.getNano()), r12);
    }

    public static OffsetTime parse(CharSequence r10) {
        return parse(r10, DateTimeFormatter.f23102l);
    }

    public static OffsetTime readExternal(DataInput r10) throws IOException {
        return of(LocalTime.readExternal(r10), ZoneOffset.readExternal(r10));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long toEpochNano() {
        return this.time.toNanoOfDay() - (((long) this.offset.getTotalSeconds()) * 1000000000);
    }

    private Object writeReplace() {
        return new Ser((byte) 66, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.NANO_OF_DAY, this.time.toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    public OffsetDateTime atDate(LocalDate r10) {
        return OffsetDateTime.of(r10, this.time, this.offset);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OffsetTime r10) {
        return compareTo2(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OffsetTime) == false) goto L14;
        OffsetTime r11 = (OffsetTime) r10;
        if (this.time.equals(r11.time) == false) goto L13;
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
        return super.get(r10);
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L11;
        if (r10 != ChronoField.OFFSET_SECONDS) goto L9;
        return getOffset().getTotalSeconds();
    L9:
        return this.time.getLong(r10);
    L11:
        return r10.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int hashCode() {
        int r10 = this.time.hashCode();
        return this.offset.hashCode() ^ r10;
    }

    public boolean isAfter(OffsetTime r10) {
        if (toEpochNano() <= r10.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(OffsetTime r10) {
        if (toEpochNano() >= r10.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqual(OffsetTime r10) {
        if (toEpochNano() != r10.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
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
        if (r10.isTimeBased() == false) goto L7;
        return true;
    L7:
        if (r10 != ChronoField.OFFSET_SECONDS) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public OffsetTime minusHours(long r10) {
        return with(this.time.minusHours(r10), this.offset);
    }

    public OffsetTime minusMinutes(long r10) {
        return with(this.time.minusMinutes(r10), this.offset);
    }

    public OffsetTime minusNanos(long r10) {
        return with(this.time.minusNanos(r10), this.offset);
    }

    public OffsetTime minusSeconds(long r10) {
        return with(this.time.minusSeconds(r10), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public OffsetTime plusHours(long r10) {
        return with(this.time.plusHours(r10), this.offset);
    }

    public OffsetTime plusMinutes(long r10) {
        return with(this.time.plusMinutes(r10), this.offset);
    }

    public OffsetTime plusNanos(long r10) {
        return with(this.time.plusNanos(r10), this.offset);
    }

    public OffsetTime plusSeconds(long r10) {
        return with(this.time.plusSeconds(r10), this.offset);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.e()) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r10 == org.threeten.bp.temporal.b.d()) goto L27;
        if (r10 == org.threeten.bp.temporal.b.f()) goto L27;
        if (r10 != org.threeten.bp.temporal.b.c()) goto L16;
        return (R) this.time;
    L16:
        if (r10 != org.threeten.bp.temporal.b.a()) goto L18;
        return null;
    L18:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L20;
        return null;
    L20:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L23;
        return null;
    L23:
        return (R) super.query(r10);
    L27:
        return (R) getOffset();
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L11;
        if (r10 != ChronoField.OFFSET_SECONDS) goto L9;
        return r10.range();
    L9:
        return this.time.range(r10);
    L11:
        return r10.rangeRefinedBy(this);
    }

    public LocalTime toLocalTime() {
        return this.time;
    }

    public String toString() {
        return this.time.toString() + this.offset.toString();
    }

    public OffsetTime truncatedTo(TemporalUnit r10) {
        return with(this.time.truncatedTo(r10), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        OffsetTime r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L21;
        long r13 = r12.toEpochNano() - toEpochNano();
        switch(b.f23077a[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L22;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L22:
        return r13;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L9:
        return r13 / 43200000000000L;
    L11:
        return r13 / 3600000000000L;
    L13:
        return r13 / 60000000000L;
    L15:
        return r13 / 1000000000;
    L17:
        return r13 / BatteryFactorConfig.WIFI_BPS;
    L19:
        return r13 / 1000;
    L21:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public OffsetTime withHour(int r10) {
        return with(this.time.withHour(r10), this.offset);
    }

    public OffsetTime withMinute(int r10) {
        return with(this.time.withMinute(r10), this.offset);
    }

    public OffsetTime withNano(int r10) {
        return with(this.time.withNano(r10), this.offset);
    }

    public OffsetTime withOffsetSameInstant(ZoneOffset r10) {
        if (r10.equals(this.offset) == false) goto L6;
        return this;
    L6:
        return new OffsetTime(this.time.plusSeconds(r10.getTotalSeconds() - this.offset.getTotalSeconds()), r10);
    }

    public OffsetTime withOffsetSameLocal(ZoneOffset r10) {
        if (r10 == null) goto L7;
        if (r10.equals(this.offset) == false) goto L7;
        return this;
    L7:
        return new OffsetTime(this.time, r10);
    }

    public OffsetTime withSecond(int r10) {
        return with(this.time.withSecond(r10), this.offset);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        this.time.writeExternal(r10);
        this.offset.writeExternal(r10);
    }

    public static OffsetTime now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static OffsetTime of(int r10, int r11, int r12, int r13, ZoneOffset r14) {
        return new OffsetTime(LocalTime.of(r10, r11, r12, r13), r14);
    }

    public static OffsetTime parse(CharSequence r10, DateTimeFormatter r11) {
        d.h(r11, "formatter");
        return (OffsetTime) r11.n(r10, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OffsetTime r10) {
        if (this.offset.equals(r10.offset) == true) goto L5;
        int r11 = d.b(toEpochNano(), r10.toEpochNano());
        if (r11 == 0) goto L9;
        return r11;
    L9:
        return this.time.compareTo2(r10.time);
    L5:
        return this.time.compareTo2(r10.time);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static OffsetTime now(Clock r10) {
        d.h(r10, "clock");
        Instant r11 = r10.instant();
        return ofInstant(r11, r10.getZone().getRules().getOffset(r11));
    }

    private OffsetTime with(LocalTime r10, ZoneOffset r11) {
        if (this.time != r10) goto L8;
        if (this.offset.equals(r11) == false) goto L8;
        return this;
    L8:
        return new OffsetTime(r10, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime minus(TemporalAmount r10) {
        return (OffsetTime) r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime plus(TemporalAmount r10) {
        return (OffsetTime) r10.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r10) {
        if ((r10 instanceof ChronoUnit) == true) goto L5;
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r10.isTimeBased();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        OffsetTime this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L7;
        return with(this.time.plus(r10, r11), this.offset);
    L7:
        return (OffsetTime) r11.addTo(this, r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime with(TemporalAdjuster r10) {
        if ((r10 instanceof LocalTime) == false) goto L7;
        return with((LocalTime) r10, this.offset);
    L7:
        if ((r10 instanceof ZoneOffset) == false) goto L11;
        return with(this.time, (ZoneOffset) r10);
    L11:
        if ((r10 instanceof OffsetTime) == false) goto L15;
        return (OffsetTime) r10;
    L15:
        return (OffsetTime) r10.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L11;
        if (r10 != ChronoField.OFFSET_SECONDS) goto L9;
        return with(this.time, ZoneOffset.ofTotalSeconds(((ChronoField) r10).checkValidIntValue(r11)));
    L9:
        return with(this.time.with(r10, r11), this.offset);
    L11:
        return (OffsetTime) r10.adjustInto(this, r11);
    }
}
