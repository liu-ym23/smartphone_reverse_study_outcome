package org.threeten.bp.chrono;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.ttnet.org.chromium.base.TimeUtils;
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
public abstract class ChronoZonedDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, Comparable<ChronoZonedDateTime<?>> {
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
    public /* bridge */ /* synthetic */ int compareTo(ChronoZonedDateTime<?> r1) {
        return compareTo2(r1);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r1) {
        return minus(r1);
    }

    public /* bridge */ /* synthetic */ Temporal plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r1) {
        return with(r1);
    }

    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    public static Comparator<ChronoZonedDateTime<?>> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    static {
        INSTANT_COMPARATOR = new AnonymousClass1();
    }

    public static ChronoZonedDateTime<?> from(TemporalAccessor r3) {
        Jdk8Methods.requireNonNull(r3, "temporal");
        if ((r3 instanceof ChronoZonedDateTime) == true) goto L5;
        Chronology r0 = (Chronology) r3.query(TemporalQueries.chronology());
        if (r0 == null) goto L11;
        return r0.zonedDateTime(r3);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoZonedDateTime: " + r3.getClass());
    L5:
        return (ChronoZonedDateTime) r3;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r2) {
        if ((r2 instanceof ChronoField) == false) goto L14;
        if (r2 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r2 == ChronoField.OFFSET_SECONDS) goto L12;
        return toLocalDateTime().range(r2);
    L12:
        return r2.range();
    L14:
        return r2.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r3) {
        if ((r3 instanceof ChronoField) == false) goto L15;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r3).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return toLocalDateTime().get(r3);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new UnsupportedTemporalTypeException("Field too large for an int: " + r3);
    L15:
        return super.get(r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        if ((r3 instanceof ChronoField) == false) goto L15;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r3).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return toLocalDateTime().getLong(r3);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        return toEpochSecond();
    L15:
        return r3.getFrom(this);
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
    public ChronoZonedDateTime<D> with(TemporalAdjuster r2) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.with(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> plus(TemporalAmount r2) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.plus(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> minus(TemporalAmount r2) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(r2));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> minus(long r2, TemporalUnit r4) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(r2, r4));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 == TemporalQueries.zoneId()) goto L30;
        if (r2 == TemporalQueries.zone()) goto L30;
        if (r2 != TemporalQueries.chronology()) goto L12;
        return (R) toLocalDate().getChronology();
    L12:
        if (r2 != TemporalQueries.precision()) goto L16;
        return (R) ChronoUnit.NANOS;
    L16:
        if (r2 != TemporalQueries.offset()) goto L20;
        return (R) getOffset();
    L20:
        if (r2 != TemporalQueries.localDate()) goto L24;
        return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
    L24:
        if (r2 != TemporalQueries.localTime()) goto L28;
        return (R) toLocalTime();
    L28:
        return (R) super.query(r2);
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
        return ((toLocalDate().toEpochDay() * TimeUtils.SECONDS_PER_DAY) + ((long) toLocalTime().toSecondOfDay())) - ((long) getOffset().getTotalSeconds());
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

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ChronoZonedDateTime) == true) goto L8;
        return false;
    L8:
        if (compareTo2((ChronoZonedDateTime) r4) != 0) goto L11;
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
        return r0 + DefaultContactListAdapter.SNIPPET_START_MATCH + getZone().toString() + DefaultContactListAdapter.SNIPPET_END_MATCH;
    }
}
