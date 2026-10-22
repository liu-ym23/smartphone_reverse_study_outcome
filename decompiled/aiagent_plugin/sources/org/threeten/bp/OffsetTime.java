package org.threeten.bp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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
public final class OffsetTime extends DefaultInterfaceTemporalAccessor implements Serializable, Comparable<OffsetTime>, Temporal, TemporalAdjuster {
    public static final TemporalQuery<OffsetTime> FROM = null;
    public static final OffsetTime MAX = null;
    public static final OffsetTime MIN = null;
    private static final long serialVersionUID = 7264499704384272492L;
    private final ZoneOffset offset;
    private final LocalTime time;

    /* JADX INFO: renamed from: org.threeten.bp.OffsetTime$2, reason: invalid class name */
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

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(OffsetTime r3) {
        return compareTo2((OffsetTime) ZeusTransformUtils.preCheckCast(r3, OffsetTime.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
    }

    static {
        MIN = LocalTime.MIN.atOffset(ZoneOffset.MAX);
        MAX = LocalTime.MAX.atOffset(ZoneOffset.MIN);
        FROM = new AnonymousClass1();
    }

    public static OffsetTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetTime now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static OffsetTime now(Clock r1) {
        Jdk8Methods.requireNonNull(r1, "clock");
        Instant r0 = r1.instant();
        return ofInstant(r0, r1.getZone().getRules().getOffset(r0));
    }

    public static OffsetTime of(LocalTime r1, ZoneOffset r2) {
        return new OffsetTime(r1, r2);
    }

    public static OffsetTime of(int r1, int r2, int r3, int r4, ZoneOffset r5) {
        return new OffsetTime(LocalTime.of(r1, r2, r3, r4), r5);
    }

    public static OffsetTime ofInstant(Instant r6, ZoneId r7) {
        Jdk8Methods.requireNonNull(r6, "instant");
        Jdk8Methods.requireNonNull(r7, "zone");
        ZoneOffset r8 = r7.getRules().getOffset(r6);
        long r0 = ((r6.getEpochSecond() % 86400) + ((long) r8.getTotalSeconds())) % 86400;
        if (r0 >= 0) goto L6;
        r0 = r0 + 86400;
    L6:
        return new OffsetTime(LocalTime.ofSecondOfDay(r0, r6.getNano()), r8);
    }

    public static OffsetTime from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, OffsetTime.class) == true) goto L5;
        return new OffsetTime(LocalTime.from(r4), ZoneOffset.from(r4));
    L9:
        throw new DateTimeException("Unable to obtain OffsetTime from TemporalAccessor: " + r4 + ", type " + r4.getClass().getName());
    L5:
        return (OffsetTime) ZeusTransformUtils.preCheckCast(r4, OffsetTime.class, "com.obric.aiagent.plugin");
    }

    public static OffsetTime parse(CharSequence r2) {
        return parse((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ISO_OFFSET_TIME);
    }

    public static OffsetTime parse(CharSequence r2, DateTimeFormatter r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r3, "formatter");
        return (OffsetTime) ZeusTransformUtils.preCheckCast(r3.parse(r4, FROM), OffsetTime.class, "com.obric.aiagent.plugin");
    }

    private OffsetTime(LocalTime r3, ZoneOffset r4) {
        this.time = (LocalTime) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r3, "time"), LocalTime.class, "com.obric.aiagent.plugin");
        this.offset = (ZoneOffset) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r4, "offset"), ZoneOffset.class, "com.obric.aiagent.plugin");
    }

    private OffsetTime with(LocalTime r2, ZoneOffset r3) {
        if (this.time != r2) goto L8;
        if (this.offset.equals(r3) == false) goto L8;
        return this;
    L8:
        return new OffsetTime(r2, r3);
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
        if (r5.isTimeBased() == false) goto L7;
        return true;
    L7:
        if (r5 != ChronoField.OFFSET_SECONDS) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r3) {
        TemporalUnit r4 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r3, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoUnit.class) == true) goto L5;
        if (r4 != null) goto L8;
    L10:
        return false;
    L8:
        if (r4.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r4.isTimeBased();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L11;
        if (r4 != ChronoField.OFFSET_SECONDS) goto L9;
        return r4.range();
    L9:
        return this.time.range(r4);
    L11:
        return r4.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r3) {
        return super.get((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L11;
        if (r4 != ChronoField.OFFSET_SECONDS) goto L9;
        return getOffset().getTotalSeconds();
    L9:
        return this.time.getLong(r4);
    L11:
        return r4.getFrom(this);
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public OffsetTime withOffsetSameLocal(ZoneOffset r2) {
        if (r2 == null) goto L7;
        if (r2.equals(this.offset) == false) goto L7;
        return this;
    L7:
        return new OffsetTime(this.time, r2);
    }

    public OffsetTime withOffsetSameInstant(ZoneOffset r3) {
        if (r3.equals(this.offset) == false) goto L6;
        return this;
    L6:
        return new OffsetTime(this.time.plusSeconds(r3.getTotalSeconds() - this.offset.getTotalSeconds()), r3);
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

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime with(TemporalAdjuster r4) {
        TemporalAdjuster r5 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAdjuster.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, LocalTime.class) == false) goto L7;
        return with((LocalTime) ZeusTransformUtils.preCheckCast(r5, LocalTime.class, "com.obric.aiagent.plugin"), this.offset);
    L7:
        if (ZeusTransformUtils.instanceOf(r5, ZoneOffset.class) == false) goto L11;
        return with(this.time, (ZoneOffset) ZeusTransformUtils.preCheckCast(r5, ZoneOffset.class, "com.obric.aiagent.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r5, OffsetTime.class) == false) goto L15;
        return (OffsetTime) ZeusTransformUtils.preCheckCast(r5, OffsetTime.class, "com.obric.aiagent.plugin");
    L15:
        return (OffsetTime) ZeusTransformUtils.preCheckCast(r5.adjustInto(this), OffsetTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime with(TemporalField r3, long r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L11;
        if (r5 != ChronoField.OFFSET_SECONDS) goto L9;
        ChronoField r6 = (ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.aiagent.plugin");
        return with(this.time, ZoneOffset.ofTotalSeconds(r6.checkValidIntValue(r4)));
    L9:
        return with(this.time.with(r5, r4), this.offset);
    L11:
        return (OffsetTime) ZeusTransformUtils.preCheckCast(r5.adjustInto(this, r4), OffsetTime.class, "com.obric.aiagent.plugin");
    }

    public OffsetTime withHour(int r2) {
        return with(this.time.withHour(r2), this.offset);
    }

    public OffsetTime withMinute(int r2) {
        return with(this.time.withMinute(r2), this.offset);
    }

    public OffsetTime withSecond(int r2) {
        return with(this.time.withSecond(r2), this.offset);
    }

    public OffsetTime withNano(int r2) {
        return with(this.time.withNano(r2), this.offset);
    }

    public OffsetTime truncatedTo(TemporalUnit r3) {
        TemporalUnit r4 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r3, TemporalUnit.class, "com.obric.aiagent.plugin");
        return with(this.time.truncatedTo(r4), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime plus(TemporalAmount r3) {
        return (OffsetTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin")).addTo(this), OffsetTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime plus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L7;
        return with(this.time.plus(r3, r6), this.offset);
    L7:
        return (OffsetTime) ZeusTransformUtils.preCheckCast(r6.addTo(this, r3), OffsetTime.class, "com.obric.aiagent.plugin");
    }

    public OffsetTime plusHours(long r2) {
        return with(this.time.plusHours(r2), this.offset);
    }

    public OffsetTime plusMinutes(long r2) {
        return with(this.time.plusMinutes(r2), this.offset);
    }

    public OffsetTime plusSeconds(long r2) {
        return with(this.time.plusSeconds(r2), this.offset);
    }

    public OffsetTime plusNanos(long r2) {
        return with(this.time.plusNanos(r2), this.offset);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime minus(TemporalAmount r3) {
        return (OffsetTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin")).subtractFrom(this), OffsetTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        OffsetTime this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    public OffsetTime minusHours(long r2) {
        return with(this.time.minusHours(r2), this.offset);
    }

    public OffsetTime minusMinutes(long r2) {
        return with(this.time.minusMinutes(r2), this.offset);
    }

    public OffsetTime minusSeconds(long r2) {
        return with(this.time.minusSeconds(r2), this.offset);
    }

    public OffsetTime minusNanos(long r2) {
        return with(this.time.minusNanos(r2), this.offset);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<R> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.aiagent.plugin");
        if (r4 != TemporalQueries.precision()) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r4 == TemporalQueries.offset()) goto L27;
        if (r4 == TemporalQueries.zone()) goto L27;
        if (r4 != TemporalQueries.localTime()) goto L16;
        return (R) this.time;
    L16:
        if (r4 != TemporalQueries.chronology()) goto L18;
        return null;
    L18:
        if (r4 != TemporalQueries.localDate()) goto L20;
        return null;
    L20:
        if (r4 != TemporalQueries.zoneId()) goto L23;
        return null;
    L23:
        return (R) super.query(r4);
    L27:
        return (R) getOffset();
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return ((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.aiagent.plugin")).with(ChronoField.NANO_OF_DAY, this.time.toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r5, TemporalUnit r6) {
        Temporal r7 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r5, Temporal.class, "com.obric.aiagent.plugin");
        TemporalUnit r8 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r6, TemporalUnit.class, "com.obric.aiagent.plugin");
        OffsetTime r9 = from(r7);
        if (ZeusTransformUtils.instanceOf(r8, ChronoUnit.class) == false) goto L21;
        long r2 = r9.toEpochNano() - toEpochNano();
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r8, ChronoUnit.class, "com.obric.aiagent.plugin")).ordinal()]) {
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
        return r2;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r8);
    L9:
        return r2 / 43200000000000L;
    L11:
        return r2 / 3600000000000L;
    L13:
        return r2 / 60000000000L;
    L15:
        return r2 / 1000000000;
    L17:
        return r2 / 1000000;
    L19:
        return r2 / 1000;
    L21:
        return r8.between(this, r9);
    }

    public OffsetDateTime atDate(LocalDate r2) {
        return OffsetDateTime.of(r2, this.time, this.offset);
    }

    public LocalTime toLocalTime() {
        return this.time;
    }

    private long toEpochNano() {
        return this.time.toNanoOfDay() - (((long) this.offset.getTotalSeconds()) * 1000000000);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OffsetTime r5) {
        if (this.offset.equals(r5.offset) == true) goto L5;
        int r0 = Jdk8Methods.compareLongs(toEpochNano(), r5.toEpochNano());
        if (r0 == 0) goto L9;
        return r0;
    L9:
        return this.time.compareTo2(r5.time);
    L5:
        return this.time.compareTo2(r5.time);
    }

    public boolean isAfter(OffsetTime r3) {
        if (toEpochNano() <= r3.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(OffsetTime r3) {
        if (toEpochNano() >= r3.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqual(OffsetTime r3) {
        if (toEpochNano() != r3.toEpochNano()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OffsetTime.class) == false) goto L14;
        OffsetTime r6 = (OffsetTime) ZeusTransformUtils.preCheckCast(r5, OffsetTime.class, "com.obric.aiagent.plugin");
        if (this.time.equals(r6.time) == false) goto L13;
        if (this.offset.equals(r6.offset) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.time.hashCode();
        return this.offset.hashCode() ^ r0;
    }

    public String toString() {
        return this.time.toString() + this.offset.toString();
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    private Object writeReplace() {
        return new Ser((byte) 66, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.aiagent.plugin");
        this.time.writeExternal(r4);
        this.offset.writeExternal(r4);
    }

    static OffsetTime readExternal(DataInput r2) {
        DataInput r3 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.aiagent.plugin");
        return of(LocalTime.readExternal(r3), ZoneOffset.readExternal(r3));
    }
}
