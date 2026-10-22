package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
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
public abstract class ChronoZonedDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Comparable<ChronoZonedDateTime<?>>, Temporal {
    private static Comparator<ChronoZonedDateTime<?>> INSTANT_COMPARATOR;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ChronoZonedDateTime$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public abstract ZoneOffset getOffset();

    public abstract ZoneId getZone();

    public abstract ChronoZonedDateTime<D> plus(long r1, TemporalUnit r3);

    public abstract ChronoLocalDateTime<D> toLocalDateTime();

    public abstract ChronoZonedDateTime<D> with(TemporalField r1, long r2);

    public abstract ChronoZonedDateTime<D> withEarlierOffsetAtOverlap();

    public abstract ChronoZonedDateTime<D> withLaterOffsetAtOverlap();

    public abstract ChronoZonedDateTime<D> withZoneSameInstant(ZoneId r1);

    public abstract ChronoZonedDateTime<D> withZoneSameLocal(ZoneId r1);

    public ChronoZonedDateTime() {
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ChronoZonedDateTime<?> r3) {
        return compareTo2((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r3, ChronoZonedDateTime.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin"));
    }

    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
    }

    public static Comparator<ChronoZonedDateTime<?>> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    static {
        INSTANT_COMPARATOR = new AnonymousClass1();
    }

    public static ChronoZonedDateTime<?> from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r4, "temporal");
        if (ZeusTransformUtils.instanceOf(r4, ChronoZonedDateTime.class) == true) goto L5;
        Chronology r0 = (Chronology) ZeusTransformUtils.preCheckCast(r4.query(TemporalQueries.chronology()), Chronology.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        return r0.zonedDateTime(r4);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoZonedDateTime: " + r4.getClass());
    L5:
        return (ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r4, ChronoZonedDateTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L14;
        if (r4 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r4 == ChronoField.OFFSET_SECONDS) goto L12;
        return toLocalDateTime().range(r4);
    L12:
        return r4.range();
    L14:
        return r4.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L15;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.aiagent.plugin")).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return toLocalDateTime().get(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new UnsupportedTemporalTypeException("Field too large for an int: " + r5);
    L15:
        return super.get(r5);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L15;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.aiagent.plugin")).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return toLocalDateTime().getLong(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        return toEpochSecond();
    L15:
        return r5.getFrom(this);
    }

    public D toLocalDate() {
        return (D) toLocalDateTime().toLocalDate();
    }

    public LocalTime toLocalTime() {
        return toLocalDateTime().toLocalTime();
    }

    public Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> with(TemporalAdjuster r3) {
        TemporalAdjuster r4 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin");
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.with(r4));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> plus(TemporalAmount r3) {
        TemporalAmount r4 = (TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin");
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.plus(r4));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> minus(TemporalAmount r3) {
        TemporalAmount r4 = (TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin");
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(r4));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(r3, r6));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<R> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.aiagent.plugin");
        if (r4 == TemporalQueries.zoneId()) goto L30;
        if (r4 == TemporalQueries.zone()) goto L30;
        if (r4 != TemporalQueries.chronology()) goto L12;
        return (R) toLocalDate().getChronology();
    L12:
        if (r4 != TemporalQueries.precision()) goto L16;
        return (R) ChronoUnit.NANOS;
    L16:
        if (r4 != TemporalQueries.offset()) goto L20;
        return (R) getOffset();
    L20:
        if (r4 != TemporalQueries.localDate()) goto L24;
        return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
    L24:
        if (r4 != TemporalQueries.localTime()) goto L28;
        return (R) toLocalTime();
    L28:
        return (R) super.query(r4);
    L30:
        return (R) getZone();
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    public Instant toInstant() {
        return Instant.ofEpochSecond(toEpochSecond(), toLocalTime().getNano());
    }

    public long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) getOffset().getTotalSeconds());
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ChronoZonedDateTime<?> r5) {
        int r0 = Jdk8Methods.compareLongs(toEpochSecond(), r5.toEpochSecond());
        if (r0 != 0) goto L12;
        int r1 = toLocalTime().getNano() - r5.toLocalTime().getNano();
        if (r1 != 0) goto L13;
        int r2 = toLocalDateTime().compareTo(r5.toLocalDateTime());
        if (r2 != 0) goto L14;
        int r3 = getZone().getId().compareTo(r5.getZone().getId());
        if (r3 == 0) goto L11;
        return r3;
    L11:
        return toLocalDate().getChronology().compareTo2(r5.toLocalDate().getChronology());
    L14:
        return r2;
    L13:
        return r1;
    L12:
        return r0;
    }

    public boolean isAfter(ChronoZonedDateTime<?> r5) {
        long r0 = toEpochSecond();
        long r2 = r5.toEpochSecond();
        if (r0 > r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() <= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(ChronoZonedDateTime<?> r5) {
        long r0 = toEpochSecond();
        long r2 = r5.toEpochSecond();
        if (r0 < r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() >= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(ChronoZonedDateTime<?> r5) {
        if (toEpochSecond() == r5.toEpochSecond()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalTime().getNano() != r5.toLocalTime().getNano()) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ChronoZonedDateTime.class) == true) goto L8;
        return false;
    L8:
        if (compareTo2((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r5, ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        int r0 = toLocalDateTime().hashCode() ^ getOffset().hashCode();
        return Integer.rotateLeft(getZone().hashCode(), 3) ^ r0;
    }

    public String toString() {
        String r0 = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() != getZone()) goto L5;
        return r0;
    L5:
        return r0 + '[' + getZone().toString() + ']';
    }
}
