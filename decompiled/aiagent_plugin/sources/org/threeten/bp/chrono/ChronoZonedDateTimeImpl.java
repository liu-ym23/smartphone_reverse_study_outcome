package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
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
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
    }

    static <R extends ChronoLocalDate> ChronoZonedDateTime<R> ofBest(ChronoLocalDateTimeImpl<R> r7, ZoneId r8, ZoneOffset r9) {
        Jdk8Methods.requireNonNull(r7, "localDateTime");
        Jdk8Methods.requireNonNull(r8, "zone");
        if (ZeusTransformUtils.instanceOf(r8, ZoneOffset.class) == true) goto L5;
        ZoneRules r0 = r8.getRules();
        LocalDateTime r2 = LocalDateTime.from(r7);
        List<ZoneOffset> r3 = r0.getValidOffsets(r2);
        if (r3.size() != 1) goto L10;
        r9 = (ZoneOffset) ZeusTransformUtils.preCheckCast(r3.get(0), ZoneOffset.class, "com.obric.aiagent.plugin");
    L17:
        Jdk8Methods.requireNonNull(r9, "offset");
        return new ChronoZonedDateTimeImpl(r7, r9, r8);
    L10:
        if (r3.size() != 0) goto L12;
        ZoneOffsetTransition r10 = r0.getTransition(r2);
        r7 = r7.plusSeconds(r10.getDuration().getSeconds());
        r9 = r10.getOffsetAfter();
        goto L17
    L12:
        if (r9 != null) goto L14;
    L16:
        r9 = (ZoneOffset) ZeusTransformUtils.preCheckCast(r3.get(0), ZoneOffset.class, "com.obric.aiagent.plugin");
        goto L17
    L14:
        if (r3.contains(r9) == false) goto L16;
    L5:
        return new ChronoZonedDateTimeImpl(r7, (ZoneOffset) ZeusTransformUtils.preCheckCast(r8, ZoneOffset.class, "com.obric.aiagent.plugin"), r8);
    }

    static <R extends ChronoLocalDate> ChronoZonedDateTimeImpl<R> ofInstant(Chronology r3, Instant r4, ZoneId r5) {
        ZoneOffset r0 = r5.getRules().getOffset(r4);
        Jdk8Methods.requireNonNull(r0, "offset");
        return new ChronoZonedDateTimeImpl((ChronoLocalDateTimeImpl) ZeusTransformUtils.preCheckCast(r3.localDateTime(LocalDateTime.ofEpochSecond(r4.getEpochSecond(), r4.getNano(), r0)), ChronoLocalDateTimeImpl.class, "com.obric.aiagent.plugin"), r0, r5);
    }

    private ChronoZonedDateTimeImpl<D> create(Instant r1, ZoneId r2) {
        return ofInstant(toLocalDate().getChronology(), r1, r2);
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> r3, ZoneOffset r4, ZoneId r5) {
        this.dateTime = (ChronoLocalDateTimeImpl) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r3, "dateTime"), ChronoLocalDateTimeImpl.class, "com.obric.aiagent.plugin");
        this.offset = (ZoneOffset) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r4, "offset"), ZoneOffset.class, "com.obric.aiagent.plugin");
        this.zone = (ZoneId) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r5, "zone"), ZoneId.class, "com.obric.aiagent.plugin");
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
    public boolean isSupported(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L9;
        if (r4 != null) goto L6;
    L8:
        return false;
    L6:
        if (r4.isSupportedBy(this) == false) goto L8;
    L9:
        return true;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> with(TemporalField r4, long r5) {
        TemporalField r6 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoField.class) == false) goto L15;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r6, ChronoField.class, "com.obric.aiagent.plugin");
        int r1 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L9;
        ZoneOffset r7 = ZoneOffset.ofTotalSeconds(r0.checkValidIntValue(r5));
        return create(this.dateTime.toInstant(r7), this.zone);
    L9:
        return ofBest(this.dateTime.with(r6, r5), this.zone, this.offset);
    L13:
        return plus(r5 - toEpochSecond(), ChronoUnit.SECONDS);
    L15:
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r6.adjustInto(this, r5));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime<D> plus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L7;
        return with(this.dateTime.plus(r3, r6));
    L7:
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r6.addTo(this, r3));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r3, TemporalUnit r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.aiagent.plugin");
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.aiagent.plugin");
        ChronoZonedDateTime<?> r7 = toLocalDate().getChronology().zonedDateTime(r5);
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L7;
        ChronoZonedDateTime<D> r8 = r7.withZoneSameInstant(this.offset);
        return this.dateTime.until(r8.toLocalDateTime(), r6);
    L7:
        return r6.between(this, r7);
    }

    private Object writeReplace() {
        return new Ser((byte) 13, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(ObjectOutput r3) {
        ObjectOutput r4 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectOutput.class, "com.obric.aiagent.plugin");
        r4.writeObject(this.dateTime);
        r4.writeObject(this.offset);
        r4.writeObject(this.zone);
    }

    static ChronoZonedDateTime<?> readExternal(ObjectInput r4) {
        ObjectInput r5 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r4, ObjectInput.class, "com.obric.aiagent.plugin");
        ChronoLocalDateTime r0 = (ChronoLocalDateTime) ZeusTransformUtils.preCheckCast(r5.readObject(), ChronoLocalDateTime.class, "com.obric.aiagent.plugin");
        ZoneOffset r2 = (ZoneOffset) ZeusTransformUtils.preCheckCast(r5.readObject(), ZoneOffset.class, "com.obric.aiagent.plugin");
        ZoneId r6 = (ZoneId) ZeusTransformUtils.preCheckCast(r5.readObject(), ZoneId.class, "com.obric.aiagent.plugin");
        return r0.atZone(r2).withZoneSameLocal(r6);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
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
        return r0 + '[' + getZone().toString() + ']';
    }
}
