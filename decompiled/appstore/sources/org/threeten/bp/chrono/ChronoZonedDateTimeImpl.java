package org.threeten.bp.chrono;

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
import org.threeten.bp.chrono.a;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: loaded from: classes4.dex */
final class ChronoZonedDateTimeImpl<D extends org.threeten.bp.chrono.a> extends d implements Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final ChronoLocalDateTimeImpl<D> dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23088a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23088a = r10;
            r10[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f23088a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> r10, ZoneOffset r11, ZoneId r12) {
        this.dateTime = (ChronoLocalDateTimeImpl) ig.d.h(r10, "dateTime");
        this.offset = (ZoneOffset) ig.d.h(r11, "offset");
        this.zone = (ZoneId) ig.d.h(r12, "zone");
    }

    private ChronoZonedDateTimeImpl<D> create(Instant r10, ZoneId r11) {
        return ofInstant(toLocalDate().getChronology(), r10, r11);
    }

    public static <R extends org.threeten.bp.chrono.a> d ofBest(ChronoLocalDateTimeImpl<R> r10, ZoneId r11, ZoneOffset r12) {
        ig.d.h(r10, "localDateTime");
        ig.d.h(r11, "zone");
        if ((r11 instanceof ZoneOffset) == true) goto L5;
        ZoneRules r13 = r11.getRules();
        LocalDateTime r14 = LocalDateTime.from(r10);
        List r15 = r13.getValidOffsets(r14);
        if (r15.size() != 1) goto L10;
        r12 = (ZoneOffset) r15.get(0);
    L17:
        ig.d.h(r12, "offset");
        return new ChronoZonedDateTimeImpl(r10, r12, r11);
    L10:
        if (r15.size() != 0) goto L12;
        ZoneOffsetTransition r16 = r13.getTransition(r14);
        r10 = r10.plusSeconds(r16.getDuration().getSeconds());
        r12 = r16.getOffsetAfter();
        goto L17
    L12:
        if (r12 != null) goto L14;
    L16:
        r12 = (ZoneOffset) r15.get(0);
        goto L17
    L14:
        if (r15.contains(r12) == false) goto L16;
    L5:
        return new ChronoZonedDateTimeImpl(r10, (ZoneOffset) r11, r11);
    }

    public static <R extends org.threeten.bp.chrono.a> ChronoZonedDateTimeImpl<R> ofInstant(e r10, Instant r11, ZoneId r12) {
        ZoneOffset r13 = r12.getRules().getOffset(r11);
        ig.d.h(r13, "offset");
        return new ChronoZonedDateTimeImpl((ChronoLocalDateTimeImpl) r10.localDateTime(LocalDateTime.ofEpochSecond(r11.getEpochSecond(), r11.getNano(), r13)), r13, r12);
    }

    public static d readExternal(ObjectInput r10) throws IOException, ClassNotFoundException {
        b r11 = (b) r10.readObject();
        ZoneOffset r12 = (ZoneOffset) r10.readObject();
        ZoneId r13 = (ZoneId) r10.readObject();
        return r11.atZone(r12).withZoneSameLocal(r13);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser(Ascii.CR, this);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        if (compareTo((d) r10) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // org.threeten.bp.chrono.d
    public ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // org.threeten.bp.chrono.d
    public ZoneId getZone() {
        return this.zone;
    }

    public int hashCode() {
        int r10 = toLocalDateTime().hashCode() ^ getOffset().hashCode();
        return Integer.rotateLeft(getZone().hashCode(), 3) ^ r10;
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

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.d
    public b toLocalDateTime() {
        return this.dateTime;
    }

    public String toString() {
        String r10 = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() != getZone()) goto L5;
        return r10;
    L5:
        return r10 + '[' + getZone().toString() + ']';
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        d r12 = toLocalDate().getChronology().zonedDateTime(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L7;
        d r13 = r12.withZoneSameInstant(this.offset);
        return this.dateTime.until(r13.toLocalDateTime(), r11);
    L7:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public d withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition r10 = getZone().getRules().getTransition(LocalDateTime.from(this));
        if (r10 != null) goto L5;
    L10:
        return this;
    L5:
        if (r10.isOverlap() == false) goto L10;
        ZoneOffset r11 = r10.getOffsetBefore();
        if (r11.equals(this.offset) == true) goto L10;
        return new ChronoZonedDateTimeImpl(this.dateTime, r11, this.zone);
    }

    public d withLaterOffsetAtOverlap() {
        ZoneOffsetTransition r10 = getZone().getRules().getTransition(LocalDateTime.from(this));
        if (r10 == null) goto L8;
        ZoneOffset r11 = r10.getOffsetAfter();
        if (r11.equals(getOffset()) == true) goto L8;
        return new ChronoZonedDateTimeImpl(this.dateTime, r11, this.zone);
    L8:
        return this;
    }

    @Override // org.threeten.bp.chrono.d
    public d withZoneSameInstant(ZoneId r10) {
        ig.d.h(r10, "zone");
        if (this.zone.equals(r10) == false) goto L6;
        return this;
    L6:
        return create(this.dateTime.toInstant(this.offset), r10);
    }

    @Override // org.threeten.bp.chrono.d
    public d withZoneSameLocal(ZoneId r10) {
        return ofBest(this.dateTime, r10, this.offset);
    }

    public void writeExternal(ObjectOutput r10) throws IOException {
        r10.writeObject(this.dateTime);
        r10.writeObject(this.offset);
        r10.writeObject(this.zone);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public d plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L7;
        return with(this.dateTime.plus(r10, r11));
    L7:
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r11.addTo(this, r10));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public d with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        ChronoField r12 = (ChronoField) r10;
        int r13 = a.f23088a[r12.ordinal()];
        if (r13 == 1) goto L13;
        if (r13 != 2) goto L9;
        ZoneOffset r14 = ZoneOffset.ofTotalSeconds(r12.checkValidIntValue(r11));
        return create(this.dateTime.toInstant(r14), this.zone);
    L9:
        return ofBest(this.dateTime.with(r10, r11), this.zone, this.offset);
    L13:
        return plus(r11 - toEpochSecond(), ChronoUnit.SECONDS);
    L15:
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r10.adjustInto(this, r11));
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
}
