package org.threeten.bp.chrono;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: loaded from: classes5.dex */
final class ChronoZonedDateTimeImpl<D extends ChronoLocalDate> extends ChronoZonedDateTime<D> implements Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final ChronoLocalDateTimeImpl<D> dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ChronoZonedDateTimeImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    static <R extends ChronoLocalDate> ChronoZonedDateTime<R> ofBest(ChronoLocalDateTimeImpl<R> r6, ZoneId r7, ZoneOffset r8) {
        Jdk8Methods.requireNonNull(r6, "localDateTime");
        Jdk8Methods.requireNonNull(r7, "zone");
        if ((r7 instanceof ZoneOffset) == true) goto L5;
        ZoneRules r0 = r7.getRules();
        LocalDateTime r1 = LocalDateTime.from(r6);
        List<ZoneOffset> r2 = r0.getValidOffsets(r1);
        if (r2.size() != 1) goto L10;
        r8 = r2.get(0);
    L17:
        Jdk8Methods.requireNonNull(r8, "offset");
        return new ChronoZonedDateTimeImpl(r6, r8, r7);
    L10:
        if (r2.size() != 0) goto L12;
        ZoneOffsetTransition r9 = r0.getTransition(r1);
        r6 = r6.plusSeconds(r9.getDuration().getSeconds());
        r8 = r9.getOffsetAfter();
        goto L17
    L12:
        if (r8 != null) goto L14;
    L16:
        r8 = r2.get(0);
        goto L17
    L14:
        if (r2.contains(r8) == false) goto L16;
    L5:
        return new ChronoZonedDateTimeImpl(r6, (ZoneOffset) r7, r7);
    }

    static <R extends ChronoLocalDate> ChronoZonedDateTimeImpl<R> ofInstant(Chronology r3, Instant r4, ZoneId r5) {
        ZoneOffset r0 = r5.getRules().getOffset(r4);
        Jdk8Methods.requireNonNull(r0, "offset");
        return new ChronoZonedDateTimeImpl((ChronoLocalDateTimeImpl) r3.localDateTime(LocalDateTime.ofEpochSecond(r4.getEpochSecond(), r4.getNano(), r0)), r0, r5);
    }

    private ChronoZonedDateTimeImpl<D> create(Instant r1, ZoneId r2) {
        return ofInstant(toLocalDate().getChronology(), r1, r2);
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> r2, ZoneOffset r3, ZoneId r4) {
        this.dateTime = (ChronoLocalDateTimeImpl) Jdk8Methods.requireNonNull(r2, "dateTime");
        this.offset = (ZoneOffset) Jdk8Methods.requireNonNull(r3, "offset");
        this.zone = (ZoneId) Jdk8Methods.requireNonNull(r4, "zone");
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

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<D> withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition r0 = getZone().getRules().getTransition(LocalDateTime.from(this));
        if (r0 != null) goto L5;
    L10:
        return this;
    L5:
        if (r0.isOverlap() == false) goto L10;
        ZoneOffset r1 = r0.getOffsetBefore();
        if (r1.equals(this.offset) == true) goto L10;
        return new ChronoZonedDateTimeImpl(this.dateTime, r1, this.zone);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<D> withLaterOffsetAtOverlap() {
        ZoneOffsetTransition r0 = getZone().getRules().getTransition(LocalDateTime.from(this));
        if (r0 == null) goto L8;
        ZoneOffset r1 = r0.getOffsetAfter();
        if (r1.equals(getOffset()) == true) goto L8;
        return new ChronoZonedDateTimeImpl(this.dateTime, r1, this.zone);
    L8:
        return this;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoLocalDateTime<D> toLocalDateTime() {
        return this.dateTime;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<D> withZoneSameLocal(ZoneId r2) {
        return ofBest(this.dateTime, r2, this.offset);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime<D> withZoneSameInstant(ZoneId r3) {
        Jdk8Methods.requireNonNull(r3, "zone");
        if (this.zone.equals(r3) == false) goto L6;
        return this;
    L6:
        return create(this.dateTime.toInstant(this.offset), r3);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r2) {
        if ((r2 instanceof ChronoField) == true) goto L9;
        if (r2 != null) goto L6;
    L8:
        return false;
    L6:
        if (r2.isSupportedBy(this) == false) goto L8;
    L9:
        return true;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> with(TemporalField r4, long r5) {
        if ((r4 instanceof ChronoField) == false) goto L15;
        ChronoField r0 = (ChronoField) r4;
        int r1 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L9;
        ZoneOffset r6 = ZoneOffset.ofTotalSeconds(r0.checkValidIntValue(r5));
        return create(this.dateTime.toInstant(r6), this.zone);
    L9:
        return ofBest(this.dateTime.with(r4, r5), this.zone, this.offset);
    L13:
        return plus(r5 - toEpochSecond(), ChronoUnit.SECONDS);
    L15:
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r4.adjustInto(this, r5));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> plus(long r2, TemporalUnit r4) {
        if ((r4 instanceof ChronoUnit) == false) goto L7;
        return with(this.dateTime.plus(r2, r4));
    L7:
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r4.addTo(this, r2));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r2, TemporalUnit r3) {
        ChronoZonedDateTime<?> r4 = toLocalDate().getChronology().zonedDateTime(r2);
        if ((r3 instanceof ChronoUnit) == false) goto L7;
        ChronoZonedDateTime<D> r5 = r4.withZoneSameInstant(this.offset);
        return this.dateTime.until(r5.toLocalDateTime(), r3);
    L7:
        return r3.between(this, r4);
    }

    private Object writeReplace() {
        return new Ser(Ascii.CR, this);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(ObjectOutput r2) throws IOException {
        r2.writeObject(this.dateTime);
        r2.writeObject(this.offset);
        r2.writeObject(this.zone);
    }

    static ChronoZonedDateTime<?> readExternal(ObjectInput r2) throws IOException, ClassNotFoundException {
        ChronoLocalDateTime r0 = (ChronoLocalDateTime) r2.readObject();
        ZoneOffset r1 = (ZoneOffset) r2.readObject();
        ZoneId r3 = (ZoneId) r2.readObject();
        return r0.atZone(r1).withZoneSameLocal(r3);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
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

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public int hashCode() {
        int r0 = toLocalDateTime().hashCode() ^ getOffset().hashCode();
        return Integer.rotateLeft(getZone().hashCode(), 3) ^ r0;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String toString() {
        String r0 = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() != getZone()) goto L5;
        return r0;
    L5:
        return r0 + DefaultContactListAdapter.SNIPPET_START_MATCH + getZone().toString() + DefaultContactListAdapter.SNIPPET_END_MATCH;
    }
}
